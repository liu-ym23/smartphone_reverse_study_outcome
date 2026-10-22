package com.bytedance.agentrobots.identity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.agentrobots.a.a.c;
import com.bytedance.agentrobots.a.a.d;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AgentIdentityManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "AgentIdentityManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f4033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f4034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SecureRandom f4035c;

    private a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f4035c = new SecureRandom();
        this.f4034b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    public static a a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f4033a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4033a != null) goto L9;
        f4033a = new a(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f4033a;
    }

    public RobotAgentRegRes a(Context r13, RobotAgentRegReq r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L7;
        a(TAG, "Registration request is null");
        return null;
    L7:
        if (r14.getAgentName() != null) goto L9;
    L74:
        a(TAG, "Invalid registration request parameters");
        return null;
    L9:
        if (r14.getAgentName().isEmpty() == true) goto L74;
        if (r14.getAgentType() == null) goto L74;
        byte[] r3 = new byte[32];
        this.f4035c.nextBytes(r3);
        r14.setChallenge(Base64.getEncoder().encodeToString(r3));
        com.bytedance.agentrobots.a.a.a r4 = com.bytedance.agentrobots.a.a.a();     // Catch: Exception -> L71
        Bundle r5 = new Bundle();     // Catch: Exception -> L71
        r5.putString("agent_name", r14.getAgentName());     // Catch: Exception -> L71
        r5.putInt("agent_type", r14.getAgentType().ordinal());     // Catch: Exception -> L71
        r5.putString("challenge", r14.getChallenge());     // Catch: Exception -> L71
        if (r14.getRequestedPermissions() == null) goto L17;
        ArrayList<String> r6 = new ArrayList(r14.getRequestedPermissions());     // Catch: Exception -> L71
    L18:
        r5.putStringArrayList("request_permission", r6);     // Catch: Exception -> L71
        if (r4 != null) goto L22;
        a(TAG, "AgentManager instance is null");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3003, null, null, null);
    L22:
        d r16 = r4.a(r15, r5);     // Catch: Exception -> L71
        if (r16 != null) goto L27;
        a(TAG, "registerAgent returned null");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3003, null, null, null);
    L27:
        if (r16.a() == 0) goto L30;
        a(TAG, "registerAgent failed, resultCode=" + r16.a());     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3001, null, null, null);
    L30:
        c r17 = r16.b();     // Catch: Exception -> L71
        if (r17 != null) goto L34;
        a(TAG, "AgentProof is null");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3002, null, null, null);
    L34:
        String r7 = r17.a();     // Catch: Exception -> L71
        byte[] r8 = r17.b();     // Catch: Exception -> L71
        byte[] r9 = r17.c();     // Catch: Exception -> L71
        byte[] r10 = r17.d();     // Catch: Exception -> L71
        byte[] r11 = r17.e();     // Catch: Exception -> L71
        byte[] r12 = r17.f();     // Catch: Exception -> L71
        if (r7 != null) goto L37;
    L69:
        a(TAG, "AgentProof contains null fields");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3002, null, null, null);
    L37:
        if (r7.isEmpty() == true) goto L69;
        if (r8 == null) goto L69;
        if (r9 == null) goto L69;
        if (r10 == null) goto L69;
        if (r11 == null) goto L69;
        if (r12 == null) goto L69;
        byte[] r18 = MessageDigest.getInstance("SHA-256").digest(r8);     // Catch: Exception -> L71
        if (MessageDigest.isEqual(r18, r9) == true) goto L48;
        a(TAG, "AgentData hash verification failed");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3001, null, null, null);
    L48:
        List<X509Certificate> r19 = e(r11);     // Catch: Exception -> L71
        if (r19 != null) goto L51;
    L67:
        a(TAG, "Failed to parse certificate chain");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3002, null, null, null);
    L51:
        if (r19.isEmpty() == true) goto L67;
        b(TAG, "Parsed certificate chain, count=" + r19.size());     // Catch: Exception -> L71
        ByteArrayOutputStream r110 = new ByteArrayOutputStream();     // Catch: Exception -> L71
        r110.write(r7.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L71
        r110.write(r18);     // Catch: Exception -> L71
        r110.write(r10);     // Catch: Exception -> L71
        if (a(r110.toByteArray(), r12, (X509Certificate) ZeusTransformUtils.preCheckCast(r19.get(0), X509Certificate.class, "com.obric.aiagent.plugin")) == true) goto L58;
        a(TAG, "Signature verification failed");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3001, null, null, null);
    L58:
        if (a((X509Certificate) ZeusTransformUtils.preCheckCast(r19.get(r19.size() - 1), X509Certificate.class, "com.obric.aiagent.plugin")) == true) goto L61;
        a(TAG, "Root certificate hash verification failed");     // Catch: Exception -> L71
        return new RobotAgentRegRes(-3001, null, null, null);
    L61:
        RobotAgent r111 = c(r8);     // Catch: Exception -> L71
        RobotDeviceStatus r112 = d(r10);     // Catch: Exception -> L71
        ArrayList r20 = new ArrayList();     // Catch: Exception -> L71
        Iterator<X509Certificate> r21 = r19.iterator();     // Catch: Exception -> L71
    L63:
        if (r21.hasNext() == false) goto L66;
        r20.add(Base64.getEncoder().encodeToString(((X509Certificate) ZeusTransformUtils.preCheckCast(r21.next(), X509Certificate.class, "com.obric.aiagent.plugin")).getEncoded()));     // Catch: Exception -> L71
        goto L63
    L66:
        return new RobotAgentRegRes(0, r111, new RobotAgentProof(r7, Base64.getEncoder().encodeToString(r9), r112, r10, r20, r12), r112);
    L17:
        r6 = new ArrayList();     // Catch: Exception -> L71
    L71:
        e = move-exception;
        a(TAG, "Exception in registerAgent", e);
        return new RobotAgentRegRes(-3001, null, null, null);
    }

    private RobotAgent c(byte[] r5) {
        DataInputStream r4 = new DataInputStream(new ByteArrayInputStream(r5));
        RobotAgent r6 = new RobotAgent();
        r6.setAgentName(r4.readUTF());
        int r0 = r4.readInt();
        if (r0 >= 0) goto L5;
    L7:
        r6.setAgentUuid(r4.readUTF());
        r6.setChallenge(r4.readUTF());
        r6.setPackageName(r4.readUTF());
        r6.setSignatureHash(r4.readUTF());
        r6.setRegisteredAt(r4.readLong());
        int r1 = r4.readInt();
        ArrayList r2 = new ArrayList();
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L10;
        r2.add(r4.readUTF());
        r3 = r3 + 1;
        goto L8
    L10:
        r6.setRequestedPermissions(r2);
        return r6;
    L5:
        if (r0 >= b.values().length) goto L7;
        r6.setAgentType(b.values()[r0]);
        goto L7
    }

    private RobotDeviceStatus d(byte[] r3) {
        DataInputStream r2 = new DataInputStream(new ByteArrayInputStream(r3));
        RobotDeviceStatus r4 = new RobotDeviceStatus();
        r4.setVersion(r2.readInt());
        r4.setOsVersion(r2.readUTF());
        r4.setOsPatchLevel(r2.readUTF());
        r4.setOsBuildType(r2.readUTF());
        r4.setSELinuxEnforcing(r2.readBoolean());
        r4.setKernelIntegrity(r2.readBoolean());
        byte[] r1 = new byte[32];
        r2.readFully(r1);
        r4.setVerifiedBootKey(r1);
        r4.setLocked(r2.readBoolean());
        r4.setColor(RobotDeviceStatus.a.a(r2.readInt()));
        byte[] r0 = new byte[32];
        r2.readFully(r0);
        r4.setVerifiedBootHash(r0);
        r4.setSecure(r2.readBoolean());
        return r4;
    }

    private List<X509Certificate> e(byte[] r4) {
        Collection<? extends Certificate> r5 = CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(r4));     // Catch: Exception -> L9
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L9
        Iterator<? extends Certificate> r6 = r5.iterator();     // Catch: Exception -> L9
    L5:
        if (r6.hasNext() == false) goto L8;
        r0.add((X509Certificate) ZeusTransformUtils.preCheckCast((Certificate) ZeusTransformUtils.preCheckCast(r6.next(), Certificate.class, "com.obric.aiagent.plugin"), X509Certificate.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L9
        goto L5
    L8:
        return r0;
    L9:
        e = move-exception;
        a(TAG, "Failed to parse certificate chain", e);
        return null;
    }

    private boolean a(byte[] r4, byte[] r5, X509Certificate r6) {
        String r1 = r6.getPublicKey().getAlgorithm();     // Catch: Exception -> L13
        if ("EC".equals(r1) == false) goto L7;
        Signature r2 = Signature.getInstance("SHA256withECDSA");     // Catch: Exception -> L13
    L9:
        r2.initVerify(r6.getPublicKey());     // Catch: Exception -> L13
        r2.update(r4);     // Catch: Exception -> L13
        return r2.verify(r5);
    L7:
        if ("RSA".equals(r1) == false) goto L11;
        r2 = Signature.getInstance("SHA256withRSA");     // Catch: Exception -> L13
        goto L9
    L11:
        a(TAG, "Unsupported key algorithm: " + r1);     // Catch: Exception -> L13
        return false;
    L13:
        e = move-exception;
        a(TAG, "Signature verification exception", e);
        return false;
    }

    private boolean a(X509Certificate r2) {
        return "f921620752fe3192217ee9111b4bce9738b1d83f7c25c9c0b84a73a4a9c23042".equalsIgnoreCase(a(MessageDigest.getInstance("SHA-256").digest(r2.getEncoded())));
    L4:
        e = move-exception;
        a(TAG, "Root cert hash verification exception", e);
        return false;
    }

    public static String a(byte[] r2) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L4
        r0.update(r2);     // Catch: NoSuchAlgorithmException -> L4
        return b(r0.digest());
    L4:
        e = move-exception;
        a(TAG, "Get message digest failed, error:" + e.getMessage());
        return "";
    }

    public static String b(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
