package com.android.server.security.rkp;

import android.content.Context;
import android.hardware.security.keymint.DeviceInfo;
import android.hardware.security.keymint.IRemotelyProvisionedComponent;
import android.hardware.security.keymint.MacedPublicKey;
import android.hardware.security.keymint.ProtectedData;
import android.hardware.security.keymint.RpcHardwareInfo;
import android.os.CancellationSignal;
import android.os.OutcomeReceiver;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ShellCommand;
import android.security.rkp.service.RegistrationProxy;
import android.security.rkp.service.RemotelyProvisionedKey;
import android.util.IndentingPrintWriter;
import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.UnsignedInteger;
import com.android.server.slice.SliceClientPermissions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.time.Duration;
import java.util.Base64;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
class RemoteProvisioningShellCommand extends ShellCommand {
    private static final Duration BIND_TIMEOUT = null;
    static final String EEK_ED25519_BASE64 = "goRDoQEnoFgqpAEBAycgBiFYIJm57t1e5FL2hcZMYtw+YatXSH11NymtdoAy0rPLY1jZWEAeIghLpLekyNdOAw7+uK8UTKc7b6XN3Np5xitk/pk5r3bngPpmAIUNB5gqrJFcpyUUSQY0dcqKJ3rZ41pJ6wIDhEOhASegWE6lAQECWCDQrsEVyirPc65rzMvRlh1l6LHd10oaN7lDOpfVmd+YCAM4GCAEIVggvoXnRsSjQlpA2TY6phXQLFh+PdwzAjLS/F4ehyVfcmBYQJvPkOIuS6vRGLEOjl0gJ0uEWP78MpB+cgWDvNeCvvpkeC1UEEvAMb9r6B414vAtzmwvT/L1T6XUg62WovGHWAQ=";
    static final String EEK_P256_BASE64 = "goRDoQEmoFhNpQECAyYgASFYIPcUituX9MxT79JkEcTjdR9mH6RxDGzP+glGgHSHVPKtIlggXn9b9uzk9hnM/xM3/Q+hyJPbGAZ2xF3m12p3hsMtr49YQC+XjkL7vgctlUeFR5NAsB/Um0ekxESp8qEHhxDHn8sR9L+f6Dvg5zRMFfx7w34zBfTRNDztAgRgehXgedOK/ySEQ6EBJqBYcaYBAgJYIDVztz+gioCJsSZn6ct8daGvAmH8bmUDkTvTS30UlD5GAzgYIAEhWCDgQc8vDzQPHDMsQbDP1wwwVTXSHmpHE0su0UiWfiScaCJYIB/ORcX7YbqBIfnlBZubOQ52hoZHuB4vRfHOr9o/gGjbWECMs7p+ID4ysGjfYNEdffCsOI5RvP9s4Wc7Snm8Vnizmdh8igfY2rW1f3H02GvfMyc0e2XRKuuGmZirOrSAqr1Q";
    private static final int ERROR = -1;
    private static final int KEY_ID = 452436;
    private static final int SUCCESS = 0;
    private static final String USAGE = "usage: cmd remote_provisioning SUBCOMMAND [ARGS]\nhelp\n  Show this message.\ndump\n  Dump service diagnostics.\nlist\n  List the names of the IRemotelyProvisionedComponent instances.\ncsr [--challenge CHALLENGE] NAME\n  Generate and print a base64-encoded CSR from the named\n  IRemotelyProvisionedComponent. A base64-encoded challenge can be provided,\n  or else it defaults to an empty challenge.\ncertify NAME\n  Output the PEM-encoded certificate chain provisioned for the named\n  IRemotelyProvisionedComponent.\n";
    private final int mCallerUid;
    private final Context mContext;
    private final Injector mInjector;

    static class Injector {
        Injector() {
        }

        String[] getIrpcNames() {
            return ServiceManager.getDeclaredInstances(IRemotelyProvisionedComponent.DESCRIPTOR);
        }

        IRemotelyProvisionedComponent getIrpcBinder(String name) {
            String irpc = IRemotelyProvisionedComponent.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + name;
            IRemotelyProvisionedComponent binder = IRemotelyProvisionedComponent.Stub.asInterface(ServiceManager.waitForDeclaredService(irpc));
            if (binder == null) goto L6;
            return binder;
        L6:
            throw new IllegalArgumentException("failed to find " + irpc);
        }

        RegistrationProxy getRegistrationProxy(Context context, int callerUid, String name, Executor executor) {
            String irpc = IRemotelyProvisionedComponent.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + name;
            OutcomeFuture<RegistrationProxy> registration = new OutcomeFuture(null);
            RegistrationProxy.createAsync(context, callerUid, irpc, RemoteProvisioningShellCommand.m8066$$Nest$sfgetBIND_TIMEOUT(), executor, registration);
            return registration.join();
        }
    }

    private static class OutcomeFuture<T> implements OutcomeReceiver<T, Exception> {
        private CompletableFuture<T> mFuture;

        /* synthetic */ OutcomeFuture(RemoteProvisioningShellCommandIA r1) {
            this();
        }

        private OutcomeFuture() {
            this.mFuture = new CompletableFuture();
        }

        @Override // android.os.OutcomeReceiver
        public /* bridge */ /* synthetic */ void onError(Throwable r1) {
            onError((Exception) r1);
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(T result) {
            this.mFuture.complete(result);
        }

        public void onError(Exception e) {
            this.mFuture.completeExceptionally(e);
        }

        public T join() {
            return this.mFuture.join();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetBIND_TIMEOUT, reason: not valid java name */
    static /* bridge */ /* synthetic */ Duration m8066$$Nest$sfgetBIND_TIMEOUT() {
        return BIND_TIMEOUT;
    }

    static {
        BIND_TIMEOUT = Duration.ofSeconds(10);
    }

    RemoteProvisioningShellCommand(Context context, int callerUid) {
        this(context, callerUid, new Injector());
    }

    RemoteProvisioningShellCommand(Context context, int callerUid, Injector injector) {
        this.mContext = context;
        this.mCallerUid = callerUid;
        this.mInjector = injector;
    }

    public void onHelp() {
        getOutPrintWriter().print(USAGE);
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L32;
        return handleDefaultCommands(cmd);
    L32:
    L12:
        e = move-exception;
        e.printStackTrace(getErrPrintWriter());
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case 98818: goto L18;
            case 3322014: goto L15;
            case 668936792: goto L10;
            default: goto L20;
        };     // Catch: Exception -> L12
    L20:
        byte r1 = -1;
    L21:
        switch(r1) {
            case 0: goto L29;
            case 1: goto L27;
            case 2: goto L25;
            default: goto L23;
        };     // Catch: Exception -> L12
    L23:
        return handleDefaultCommands(cmd);
    L25:
        return certify();
    L27:
        return csr();
    L29:
        return list();
    L10:
        if (cmd.equals("certify") == false) goto L20;
        r1 = 2;
        goto L21
    L15:
        if (cmd.equals("list") == false) goto L20;
        r1 = 0;
        goto L21
    L18:
        if (cmd.equals("csr") == false) goto L20;
        r1 = 1;
        goto L21
    }

    void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);     // Catch: Exception -> L6
        String[] r1 = this.mInjector.getIrpcNames();     // Catch: Exception -> L6
        int r2 = r1.length;     // Catch: Exception -> L6
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L14;
        String name = r1[r3];     // Catch: Exception -> L6
        ipw.println(name + ":");     // Catch: Exception -> L6
        ipw.increaseIndent();     // Catch: Exception -> L6
        dumpRpcInstance(ipw, name);     // Catch: Exception -> L6
        ipw.decreaseIndent();     // Catch: Exception -> L6
        r3 = r3 + 1;
        goto L3
    L14:
        return;
    L6:
        e = move-exception;
        e.printStackTrace(pw);
    }

    private void dumpRpcInstance(PrintWriter pw, String name) throws RemoteException {
        RpcHardwareInfo info = this.mInjector.getIrpcBinder(name).getHardwareInfo();
        pw.println("hwVersion=" + info.versionNumber);
        pw.println("rpcAuthorName=" + info.rpcAuthorName);
        if (info.versionNumber >= 3) goto L5;
        pw.println("supportedEekCurve=" + info.supportedEekCurve);
    L5:
        pw.println("uniqueId=" + info.uniqueId);
        if (info.versionNumber < 3) goto L9;
        pw.println("supportedNumKeysInCsr=" + info.supportedNumKeysInCsr);
        return;
    }

    private int list() throws RemoteException {
        String[] r0 = this.mInjector.getIrpcNames();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        String name = r0[r3];
        getOutPrintWriter().println(name);
        r3 = r3 + 1;
        goto L3
    L5:
        return 0;
    }

    private int csr() throws RemoteException, CborException {
        byte[] challenge = new byte[0];
    L3:
        String opt = getNextOption();
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case 1891027651: goto L9;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        challenge = Base64.getDecoder().decode(getNextArgRequired());
        goto L3
    L13:
        getErrPrintWriter().println("error: unknown option " + opt);
        return -1;
    L9:
        if (opt.equals("--challenge") == false) goto L11;
        r1 = 0;
        goto L12
    L16:
        String name = getNextArgRequired();
        IRemotelyProvisionedComponent binder = this.mInjector.getIrpcBinder(name);
        RpcHardwareInfo info = binder.getHardwareInfo();
        MacedPublicKey[] emptyKeys = new MacedPublicKey[0];
        switch(info.versionNumber) {
            case 1: goto L21;
            case 2: goto L21;
            case 3: goto L20;
            default: goto L18;
        };
    L18:
        getErrPrintWriter().println("error: unsupported hwVersion: " + info.versionNumber);
        return -1;
    L20:
        byte[] csrBytes = binder.generateCertificateRequestV2(emptyKeys, challenge);
        byte[] csrBytes2 = csrBytes;
    L22:
        getOutPrintWriter().println(Base64.getEncoder().encodeToString(csrBytes2));
        return 0;
    L21:
        DeviceInfo deviceInfo = new DeviceInfo();
        ProtectedData protectedData = new ProtectedData();
        byte[] eek = getEekChain(info.supportedEekCurve);
        byte[] keysToSignMac = binder.generateCertificateRequest(false, emptyKeys, eek, challenge, deviceInfo, protectedData);
        csrBytes2 = composeCertificateRequestV1(deviceInfo, challenge, protectedData, keysToSignMac);
        goto L22
    }

    private byte[] getEekChain(int supportedEekCurve) {
        switch(supportedEekCurve) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        throw new IllegalArgumentException("unsupported EEK curve: " + supportedEekCurve);
    L6:
        return Base64.getDecoder().decode(EEK_ED25519_BASE64);
    L8:
        return Base64.getDecoder().decode(EEK_P256_BASE64);
    }

    private byte[] composeCertificateRequestV1(DeviceInfo deviceInfo, byte[] challenge, ProtectedData protectedData, byte[] keysToSignMac) throws CborException {
        Array info = new Array().add(decode(deviceInfo.deviceInfo)).add(new Map());
        Array mac = new Array().add(new ByteString(encode(new Map().put(new UnsignedInteger(1), new UnsignedInteger(5))))).add(new Map()).add(SimpleValue.NULL).add(new ByteString(keysToSignMac));
        Array csr = new Array().add(info).add(new ByteString(challenge)).add(decode(protectedData.protectedData)).add(mac);
        return encode(csr);
    }

    private byte[] encode(DataItem item) throws CborException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new CborEncoder(baos).encode(item);
        return baos.toByteArray();
    }

    private DataItem decode(byte[] data) throws CborException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        return new CborDecoder(bais).decodeNext();
    }

    private int certify() throws Exception {
        String name = getNextArgRequired();
        Executor executor = this.mContext.getMainExecutor();
        CancellationSignal cancellationSignal = new CancellationSignal();
        OutcomeFuture<RemotelyProvisionedKey> key = new OutcomeFuture(null);
        this.mInjector.getRegistrationProxy(this.mContext, this.mCallerUid, name, executor).getKeyAsync(KEY_ID, cancellationSignal, executor, key);
        byte[] encodedCertChain = key.join().getEncodedCertChain();
        ByteArrayInputStream is = new ByteArrayInputStream(encodedCertChain);
        PrintWriter pw = getOutPrintWriter();
        Iterator<? extends Certificate> r7 = CertificateFactory.getInstance("X.509").generateCertificates(is).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Certificate cert = r7.next();
        String encoded = Base64.getEncoder().encodeToString(cert.getEncoded());
        pw.println("-----BEGIN CERTIFICATE-----");
        pw.println(encoded.replaceAll("(.{64})", "$1\n").stripTrailing());
        pw.println("-----END CERTIFICATE-----");
        goto L4
    L6:
        return 0;
    }
}
