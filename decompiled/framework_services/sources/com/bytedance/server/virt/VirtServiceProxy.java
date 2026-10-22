package com.bytedance.server.virt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.os.LxcClient;
import com.bytedance.virt.IVirtService;
import com.bytedance.virt.LxcCommandResult;
import com.bytedance.virt.LxcStreamingSession;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class VirtServiceProxy {
    private static final String DEFAULT_DNS_SERVER = "8.8.8.8";
    private static final Object LOCK = null;
    private static final String LXC_DNS_ARG_PREFIX = "__lxc_dns_servers__=";
    private static final String TAG = "VirtServiceProxy";
    private static volatile VirtServiceProxy sInstance;
    private final Context mContext;
    private final HashMap<IBinder, IBinder.DeathRecipient> mDeathRecipients;
    private final LxcStreamingManager mStreamingManager;

    public class VirtServiceImpl extends IVirtService.Stub {
        final /* synthetic */ VirtServiceProxy this$0;

        public VirtServiceImpl(VirtServiceProxy this$0) {
            this.this$0 = this$0;
        }

        private int getVerifiedCallingUid() {
            return Binder.getCallingUid();
        }

        private LxcCommandResult unsupportedPrivilegedResult() {
            return new LxcCommandResult(-1, "", "Privileged LXC execution is not supported");
        }

        private boolean isPrivilegedAppUid(int uid) {
            if (VirtServiceProxy.m10565$$Nest$fgetmContext(this.this$0) == null) goto L5;
            PackageManager packageManager = VirtServiceProxy.m10565$$Nest$fgetmContext(this.this$0).getPackageManager();
        L7:
            if (packageManager != null) goto L9;
            return false;
        L9:
            long token = Binder.clearCallingIdentity();
            String[] packageNames = packageManager.getPackagesForUid(uid);     // Catch: Throwable -> L30
            if (packageNames == null) goto L40;
            if (packageNames.length == 0) goto L40;
            int r5 = packageNames.length;     // Catch: Throwable -> L30
            int r6 = 0;
        L16:
            if (r6 >= r5) goto L38;
            String packageName = packageNames[r6];     // Catch: Throwable -> L30
            if (packageName == null) goto L37;
            if (packageName.isEmpty() == true) goto L37;
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);     // Catch: Throwable -> L30 PackageManager.NameNotFoundException -> L32
            if (applicationInfo == null) goto L37;
        L27:
            if ((applicationInfo.privateFlags & 8) == 0) goto L37;
            Binder.restoreCallingIdentity(token);
            return true;
        L32:
            e = move-exception;
            Log.w(VirtServiceProxy.TAG, "Package not found for uid=" + uid + ", package=" + packageName, e);     // Catch: Throwable -> L30
        L37:
            r6 = r6 + 1;
            goto L16
        L38:
            Binder.restoreCallingIdentity(token);
            return false;
        L40:
            Binder.restoreCallingIdentity(token);
            return false;
        L30:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            packageManager = null;
            goto L7
        }

        private void enforceTrustedCaller(String methodName) {
            int callingUid = Binder.getCallingUid();
            if (callingUid != 1000) goto L6;
            return;
        L6:
            if (VirtServiceProxy.m10565$$Nest$fgetmContext(this.this$0) == null) goto L8;
            PackageManager packageManager = VirtServiceProxy.m10565$$Nest$fgetmContext(this.this$0).getPackageManager();
        L10:
            if (packageManager == null) goto L15;
            if (packageManager.checkSignatures(1000, callingUid) != 0) goto L15;
            return;
        L15:
            if (isPrivilegedAppUid(callingUid) == false) goto L18;
            return;
        L18:
            throw new SecurityException(methodName + " requires a platform-signed or privileged caller, uid=" + callingUid);
        L8:
            packageManager = null;
            goto L10
        }

        public LxcCommandResult lxcExecute(String containerName, String[] args, int timeoutSeconds) throws RemoteException {
            enforceTrustedCaller("lxcExecute");     // Catch: Exception -> L21
            int targetUid = getVerifiedCallingUid();     // Catch: Exception -> L21
            Log.i(VirtServiceProxy.TAG, "lxcExecute called: container=" + containerName + ", timeout=" + timeoutSeconds + "s, targetUid=" + targetUid);     // Catch: Exception -> L21
            LxcClient.LxcCommandResult result = VirtServiceProxy.m10570$$Nest$msendExecuteCommandWithDns(this.this$0, "lxcExecute", containerName, args, timeoutSeconds, 0, targetUid, null);     // Catch: Exception -> L9
            if (result != null) goto L12;
            return new LxcCommandResult(-1, "", "Result is null");
        L12:
            if (result.stdout == null) goto L14;
            String stdout = result.stdout;     // Catch: Exception -> L9
        L16:
            if (result.stderr == null) goto L18;
            String stderr = result.stderr;     // Catch: Exception -> L9
        L20:
            return new LxcCommandResult(result.exitCode, stdout, stderr);
        L18:
            stderr = "";
            goto L20
        L14:
            stdout = "";
        L9:
            e = move-exception;
            Exception e = e;
        L23:
            Log.e(VirtServiceProxy.TAG, "lxcExecute failed", e);
            String errorMsg = e.getMessage();
            if (errorMsg == null) goto L26;
            String r0 = errorMsg;
        L28:
            return new LxcCommandResult(-1, "", r0);
        L26:
            r0 = e.toString();
        L21:
            e = move-exception;
            e = e;
            goto L23
        }

        public LxcCommandResult lxcExecuteWithToken(final String containerName, String[] args, int timeoutSeconds, final IBinder clientToken) throws RemoteException {
            enforceTrustedCaller("lxcExecuteWithToken");     // Catch: Throwable -> L46 Exception -> L48
            if (clientToken != null) goto L66;
        L24:
            Log.i(VirtServiceProxy.TAG, "lxcExecuteWithToken called: container=" + containerName + ", timeout=" + timeoutSeconds + "s");     // Catch: Throwable -> L46 Exception -> L48
            int targetUid = getVerifiedCallingUid();     // Catch: Throwable -> L46 Exception -> L48
        L60:
            LxcClient.LxcCommandResult result = VirtServiceProxy.m10570$$Nest$msendExecuteCommandWithDns(this.this$0, "lxcExecuteWithToken", containerName, args, timeoutSeconds, 0, targetUid, null);     // Catch: Throwable -> L31 Exception -> L33
            if (result != null) goto L36;
            LxcCommandResult r12 = new LxcCommandResult(-1, "", "Result is null");     // Catch: Throwable -> L31 Exception -> L33
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r12;
        L36:
            if (result.stdout == null) goto L38;
            String stdout = result.stdout;     // Catch: Throwable -> L31 Exception -> L33
        L40:
            if (result.stderr == null) goto L42;
            String stderr = result.stderr;     // Catch: Throwable -> L31 Exception -> L33
        L43:
            LxcCommandResult r0 = new LxcCommandResult(result.exitCode, stdout, stderr);     // Catch: Throwable -> L31 Exception -> L33
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r0;
        L42:
            stderr = "";
            goto L43
        L38:
            stdout = "";
        L33:
            e = e;
        L51:
            Log.e(VirtServiceProxy.TAG, "lxcExecuteWithToken failed", e);     // Catch: Throwable -> L31
            String errorMsg = e.getMessage();     // Catch: Throwable -> L31
            if (errorMsg == null) goto L54;
            String r2 = errorMsg;
        L55:
            LxcCommandResult r13 = new LxcCommandResult(-1, "", r2);     // Catch: Throwable -> L31
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r13;
        L54:
            r2 = e.toString();     // Catch: Throwable -> L31
            goto L55
        L66:
            IBinder.DeathRecipient recipient = new AnonymousClass1(this, containerName, clientToken);     // Catch: Throwable -> L13 Exception -> L15
            Log.i(VirtServiceProxy.TAG, "[VirtService-Death] Linking to death for container=" + containerName);     // Catch: Throwable -> L13 Exception -> L15 RemoteException -> L17
            clientToken.linkToDeath(recipient, 0);     // Catch: Throwable -> L13 Exception -> L15 RemoteException -> L17
            HashMap r3 = VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0);     // Catch: Throwable -> L13 Exception -> L15 RemoteException -> L17
            monitor-enter(r3);     // Catch: Throwable -> L13 Exception -> L15 RemoteException -> L17
            VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0).put(clientToken, recipient);     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
            Log.i(VirtServiceProxy.TAG, "[VirtService-Death] Successfully linked to death, map size=" + VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0).size());     // Catch: Throwable -> L13 Exception -> L15 RemoteException -> L17
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13 Exception -> L15 RemoteException -> L17
        L17:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "[VirtService-Death] Failed to link to death", e);     // Catch: Throwable -> L13 Exception -> L15
        L15:
            e = e;
        L13:
            e = th;
        L58:
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            throw e;
        L31:
            e = th;
        L48:
            e = e;
        L46:
            e = th;
            goto L58
        }

        public LxcCommandResult lxcKill(String containerName) throws RemoteException {
            enforceTrustedCaller("lxcKill");     // Catch: Exception -> L7
            Log.i(VirtServiceProxy.TAG, "=== lxcKill called: container=" + containerName + " ===");     // Catch: Exception -> L7
            Log.i(VirtServiceProxy.TAG, "Calling sendLxcCommand with action=kill");     // Catch: Exception -> L7
            LxcClient.LxcCommandResult result = LxcClient.sendLxcCommand("kill", containerName, null, 0);     // Catch: Exception -> L7
            if (result != null) goto L9;
            Log.e(VirtServiceProxy.TAG, "sendLxcCommand returned null");     // Catch: Exception -> L7
            return new LxcCommandResult(-1, "", "Result is null");
        L9:
            Log.i(VirtServiceProxy.TAG, "sendLxcCommand returned, exitCode=" + result.exitCode);     // Catch: Exception -> L7
            if (result.stderr == null) goto L12;
            String stderr = result.stderr;     // Catch: Exception -> L7
        L14:
            if (stderr.isEmpty() == true) goto L17;
            Log.i(VirtServiceProxy.TAG, "stderr: " + stderr);     // Catch: Exception -> L7
        L17:
            if (result.stdout == null) goto L19;
            String stdout = result.stdout;     // Catch: Exception -> L7
        L20:
            LxcCommandResult ret = new LxcCommandResult(result.exitCode, stdout, stderr);     // Catch: Exception -> L7
            Log.i(VirtServiceProxy.TAG, "=== lxcKill completed ===");     // Catch: Exception -> L7
            return ret;
        L19:
            stdout = "";
            goto L20
        L12:
            stderr = "";
        L7:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "lxcKill failed", e);
            String errorMsg = e.getMessage();
            if (errorMsg == null) goto L25;
            String r5 = errorMsg;
        L27:
            return new LxcCommandResult(-1, "", r5);
        L25:
            r5 = e.toString();
            goto L27
        }

        public LxcCommandResult lxcExecutePrivileged(String containerName, String[] args, int timeoutSeconds, int privileged) throws RemoteException {
            enforceTrustedCaller("lxcExecutePrivileged");     // Catch: Exception -> L7
            Log.i(VirtServiceProxy.TAG, "lxcExecutePrivileged called: container=" + containerName + ", timeout=" + timeoutSeconds + "s, privileged=" + privileged);     // Catch: Exception -> L7
            if (privileged != 0) goto L6;
            int targetUid = getVerifiedCallingUid();     // Catch: Exception -> L7
            LxcClient.LxcCommandResult result = VirtServiceProxy.m10570$$Nest$msendExecuteCommandWithDns(this.this$0, "lxcExecutePrivileged", containerName, args, timeoutSeconds, privileged, targetUid, null);     // Catch: Exception -> L7
            if (result != null) goto L14;
            return new LxcCommandResult(-1, "", "Result is null");
        L14:
            if (result.stdout == null) goto L16;
            String stdout = result.stdout;     // Catch: Exception -> L7
        L18:
            if (result.stderr == null) goto L20;
            String stderr = result.stderr;     // Catch: Exception -> L7
        L22:
            return new LxcCommandResult(result.exitCode, stdout, stderr);
        L20:
            stderr = "";
            goto L22
        L16:
            stdout = "";
            goto L18
        L6:
            return unsupportedPrivilegedResult();
        L7:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "lxcExecutePrivileged failed", e);
            String errorMsg = e.getMessage();
            if (errorMsg == null) goto L26;
            String r3 = errorMsg;
        L28:
            return new LxcCommandResult(-1, "", r3);
        L26:
            r3 = e.toString();
            goto L28
        }

        public LxcCommandResult lxcExecutePrivilegedWithToken(final String containerName, String[] args, int timeoutSeconds, final IBinder clientToken, int privileged) throws RemoteException {
            enforceTrustedCaller("lxcExecutePrivilegedWithToken");     // Catch: Throwable -> L50 Exception -> L52
            if (privileged == 0) goto L12;
            LxcCommandResult r0 = unsupportedPrivilegedResult();     // Catch: Throwable -> L8 Exception -> L10
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r0;
        L12:
            if (clientToken == null) goto L28;
            IBinder.DeathRecipient recipient = new AnonymousClass2(this, containerName, clientToken);     // Catch: Throwable -> L8 Exception -> L10
            Log.i(VirtServiceProxy.TAG, "[VirtService-Death] Linking to death for container=" + containerName);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L21
            clientToken.linkToDeath(recipient, 0);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L21
            HashMap r3 = VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L21
            monitor-enter(r3);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L21
            VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0).put(clientToken, recipient);     // Catch: Throwable -> L23
            monitor-exit(r3);     // Catch: Throwable -> L23
            Log.i(VirtServiceProxy.TAG, "[VirtService-Death] Successfully linked to death, map size=" + VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0).size());     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L21
        L23:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L21
        L21:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "[VirtService-Death] Failed to link to death", e);     // Catch: Throwable -> L8 Exception -> L10
        L28:
            Log.i(VirtServiceProxy.TAG, "lxcExecutePrivilegedWithToken called: container=" + containerName + ", timeout=" + timeoutSeconds + "s, privileged=" + privileged);     // Catch: Throwable -> L50 Exception -> L52
            int targetUid = getVerifiedCallingUid();     // Catch: Throwable -> L50 Exception -> L52
        L64:
            LxcClient.LxcCommandResult result = VirtServiceProxy.m10570$$Nest$msendExecuteCommandWithDns(this.this$0, "lxcExecutePrivilegedWithToken", containerName, args, timeoutSeconds, privileged, targetUid, null);     // Catch: Throwable -> L35 Exception -> L37
            if (result != null) goto L40;
            LxcCommandResult r12 = new LxcCommandResult(-1, "", "Result is null");     // Catch: Throwable -> L35 Exception -> L37
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r12;
        L40:
            if (result.stdout == null) goto L42;
            String stdout = result.stdout;     // Catch: Throwable -> L35 Exception -> L37
        L44:
            if (result.stderr == null) goto L46;
            String stderr = result.stderr;     // Catch: Throwable -> L35 Exception -> L37
        L47:
            LxcCommandResult r15 = new LxcCommandResult(result.exitCode, stdout, stderr);     // Catch: Throwable -> L35 Exception -> L37
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r15;
        L46:
            stderr = "";
            goto L47
        L42:
            stdout = "";
        L37:
            e = e;
        L55:
            Log.e(VirtServiceProxy.TAG, "lxcExecutePrivilegedWithToken failed", e);     // Catch: Throwable -> L35
            String errorMsg = e.getMessage();     // Catch: Throwable -> L35
            if (errorMsg == null) goto L58;
            String r16 = errorMsg;
        L59:
            LxcCommandResult r13 = new LxcCommandResult(-1, "", r16);     // Catch: Throwable -> L35
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r13;
        L58:
            r16 = e.toString();     // Catch: Throwable -> L35
        L10:
            e = e;
        L8:
            e = th;
        L62:
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            throw e;
        L35:
            e = th;
        L52:
            e = e;
        L50:
            e = th;
            goto L62
        }

        public LxcStreamingSession lxcStartExecutePrivilegedWithTokenStreaming(String containerName, String[] args, int timeoutSeconds, IBinder clientToken, int privileged) throws RemoteException {
            enforceTrustedCaller("lxcStartExecutePrivilegedWithTokenStreaming");     // Catch: Exception -> L7
            if (privileged == 0) goto L9;
            Log.w(VirtServiceProxy.TAG, "Privileged streaming LXC execution is not supported");     // Catch: Exception -> L7
            return null;
        L9:
            int targetUid = getVerifiedCallingUid();     // Catch: Exception -> L7
            List<String> dnsServers = VirtServiceProxy.m10568$$Nest$mgetCurrentDnsServersForLxc(this.this$0, "lxcStartExecutePrivilegedWithTokenStreaming");     // Catch: Exception -> L7
            String[] requestArgs = VirtServiceProxy.m10569$$Nest$mprepareExecuteArgsWithDns(this.this$0, args, dnsServers, "lxcStartExecutePrivilegedWithTokenStreaming");     // Catch: Exception -> L7
            return VirtServiceProxy.m10567$$Nest$fgetmStreamingManager(this.this$0).startExecute(containerName, requestArgs, timeoutSeconds, clientToken, privileged, targetUid, null);
        L7:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "lxcStartExecutePrivilegedWithTokenStreaming failed", e);
            return null;
        }

        public LxcCommandResult lxcExecuteWithEnv(String containerName, String[] args, int timeoutSeconds, String[] env) throws RemoteException {
            enforceTrustedCaller("lxcExecuteWithEnv");     // Catch: Exception -> L6
            int targetUid = getVerifiedCallingUid();     // Catch: Exception -> L6
            StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L6
            r0.append("lxcExecuteWithEnv called: container=");     // Catch: Exception -> L6
            r0.append(containerName);     // Catch: Exception -> L6
            r0.append(", timeout=");     // Catch: Exception -> L6
            r0.append(timeoutSeconds);     // Catch: Exception -> L6
            r0.append("s, targetUid=");     // Catch: Exception -> L6
            r0.append(targetUid);     // Catch: Exception -> L6
            r0.append(", envCount=");     // Catch: Exception -> L6
            if (env == null) goto L8;
            int r1 = env.length;     // Catch: Exception -> L6
        L9:
            r0.append(r1);     // Catch: Exception -> L6
            Log.i(VirtServiceProxy.TAG, r0.toString());     // Catch: Exception -> L6
            LxcClient.LxcCommandResult result = VirtServiceProxy.m10570$$Nest$msendExecuteCommandWithDns(this.this$0, "lxcExecuteWithEnv", containerName, args, timeoutSeconds, 0, targetUid, env);     // Catch: Exception -> L6
            if (result != null) goto L14;
            return new LxcCommandResult(-1, "", "Result is null");
        L14:
            if (result.stdout == null) goto L16;
            String stdout = result.stdout;     // Catch: Exception -> L6
        L18:
            if (result.stderr == null) goto L20;
            String stderr = result.stderr;     // Catch: Exception -> L6
        L22:
            return new LxcCommandResult(result.exitCode, stdout, stderr);
        L20:
            stderr = "";
            goto L22
        L16:
            stdout = "";
            goto L18
        L8:
            r1 = 0;
        L6:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "lxcExecuteWithEnv failed", e);
            String errorMsg = e.getMessage();
            if (errorMsg == null) goto L26;
            String r3 = errorMsg;
        L28:
            return new LxcCommandResult(-1, "", r3);
        L26:
            r3 = e.toString();
            goto L28
        }

        public LxcCommandResult lxcExecuteWithTokenWithEnv(String containerName, String[] args, int timeoutSeconds, IBinder clientToken, String[] env) throws RemoteException {
            return lxcExecutePrivilegedWithTokenWithEnv(containerName, args, timeoutSeconds, clientToken, 0, env);
        }

        public LxcCommandResult lxcExecutePrivilegedWithEnv(String containerName, String[] args, int timeoutSeconds, int privileged, String[] env) throws RemoteException {
            enforceTrustedCaller("lxcExecutePrivilegedWithEnv");     // Catch: Exception -> L6
            StringBuilder r0 = new StringBuilder();     // Catch: Exception -> L6
            r0.append("lxcExecutePrivilegedWithEnv called: container=");     // Catch: Exception -> L6
            r0.append(containerName);     // Catch: Exception -> L6
            r0.append(", timeout=");     // Catch: Exception -> L6
            r0.append(timeoutSeconds);     // Catch: Exception -> L6
            r0.append("s, privileged=");     // Catch: Exception -> L6
            r0.append(privileged);     // Catch: Exception -> L6
            r0.append(", envCount=");     // Catch: Exception -> L6
            if (env == null) goto L8;
            int r1 = env.length;     // Catch: Exception -> L6
        L9:
            r0.append(r1);     // Catch: Exception -> L6
            Log.i(VirtServiceProxy.TAG, r0.toString());     // Catch: Exception -> L6
            if (privileged != 0) goto L12;
            int targetUid = getVerifiedCallingUid();     // Catch: Exception -> L6
            LxcClient.LxcCommandResult result = VirtServiceProxy.m10570$$Nest$msendExecuteCommandWithDns(this.this$0, "lxcExecutePrivilegedWithEnv", containerName, args, timeoutSeconds, privileged, targetUid, env);     // Catch: Exception -> L6
            if (result != null) goto L18;
            return new LxcCommandResult(-1, "", "Result is null");
        L18:
            if (result.stdout == null) goto L20;
            String stdout = result.stdout;     // Catch: Exception -> L6
        L22:
            if (result.stderr == null) goto L24;
            String stderr = result.stderr;     // Catch: Exception -> L6
        L26:
            return new LxcCommandResult(result.exitCode, stdout, stderr);
        L24:
            stderr = "";
            goto L26
        L20:
            stdout = "";
            goto L22
        L12:
            return unsupportedPrivilegedResult();
        L8:
            r1 = 0;
        L6:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "lxcExecutePrivilegedWithEnv failed", e);
            String errorMsg = e.getMessage();
            if (errorMsg == null) goto L30;
            String r3 = errorMsg;
        L32:
            return new LxcCommandResult(-1, "", r3);
        L30:
            r3 = e.toString();
            goto L32
        }

        public LxcCommandResult lxcExecutePrivilegedWithTokenWithEnv(final String containerName, String[] args, int timeoutSeconds, final IBinder clientToken, int privileged, String[] env) throws RemoteException {
            enforceTrustedCaller("lxcExecutePrivilegedWithTokenWithEnv");     // Catch: Throwable -> L8 Exception -> L10
            if (privileged == 0) goto L12;
            LxcCommandResult r0 = unsupportedPrivilegedResult();     // Catch: Throwable -> L8 Exception -> L10
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r0;
        L12:
            int r1 = 0;
            if (clientToken == null) goto L29;
            IBinder.DeathRecipient recipient = new AnonymousClass3(this, containerName, clientToken);     // Catch: Throwable -> L8 Exception -> L10
            Log.i(VirtServiceProxy.TAG, "[VirtService-Death] Linking to death for container=" + containerName);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L22
            clientToken.linkToDeath(recipient, 0);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L22
            HashMap r3 = VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L22
            monitor-enter(r3);     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L22
            VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0).put(clientToken, recipient);     // Catch: Throwable -> L24
            monitor-exit(r3);     // Catch: Throwable -> L24
            Log.i(VirtServiceProxy.TAG, "[VirtService-Death] Successfully linked to death, map size=" + VirtServiceProxy.m10566$$Nest$fgetmDeathRecipients(this.this$0).size());     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L22
        L24:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8 Exception -> L10 RemoteException -> L22
        L22:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "[VirtService-Death] Failed to link to death", e);     // Catch: Throwable -> L8 Exception -> L10
        L29:
            StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L8 Exception -> L10
            r2.append("lxcExecutePrivilegedWithTokenWithEnv called: container=");     // Catch: Throwable -> L8 Exception -> L10
            r2.append(containerName);     // Catch: Throwable -> L8 Exception -> L10
            r2.append(", timeout=");     // Catch: Throwable -> L8 Exception -> L10
            r2.append(timeoutSeconds);     // Catch: Throwable -> L8 Exception -> L10
            r2.append("s, privileged=");     // Catch: Throwable -> L8 Exception -> L10
            r2.append(privileged);     // Catch: Throwable -> L8 Exception -> L10
            r2.append(", envCount=");     // Catch: Throwable -> L8 Exception -> L10
            if (env == null) goto L32;
            r1 = env.length;     // Catch: Throwable -> L8 Exception -> L10
        L32:
            r2.append(r1);     // Catch: Throwable -> L8 Exception -> L10
            Log.i(VirtServiceProxy.TAG, r2.toString());     // Catch: Throwable -> L8 Exception -> L10
            int targetUid = getVerifiedCallingUid();     // Catch: Throwable -> L8 Exception -> L10
            LxcClient.LxcCommandResult result = VirtServiceProxy.m10570$$Nest$msendExecuteCommandWithDns(this.this$0, "lxcExecutePrivilegedWithTokenWithEnv", containerName, args, timeoutSeconds, privileged, targetUid, env);     // Catch: Throwable -> L8 Exception -> L10
            if (result != null) goto L38;
            LxcCommandResult r4 = new LxcCommandResult(-1, "", "Result is null");     // Catch: Throwable -> L8 Exception -> L10
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r4;
        L38:
            if (result.stdout == null) goto L40;
            String stdout = result.stdout;     // Catch: Throwable -> L8 Exception -> L10
        L42:
            if (result.stderr == null) goto L44;
            String stderr = result.stderr;     // Catch: Throwable -> L8 Exception -> L10
        L45:
            LxcCommandResult r5 = new LxcCommandResult(result.exitCode, stdout, stderr);     // Catch: Throwable -> L8 Exception -> L10
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r5;
        L44:
            stderr = "";
            goto L45
        L40:
            stdout = "";
        L8:
            th = move-exception;
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            throw th;
        L10:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "lxcExecutePrivilegedWithTokenWithEnv failed", e);     // Catch: Throwable -> L8
            String errorMsg = e.getMessage();     // Catch: Throwable -> L8
            if (errorMsg == null) goto L52;
            String r6 = errorMsg;
        L53:
            LxcCommandResult r7 = new LxcCommandResult(-1, "", r6);     // Catch: Throwable -> L8
            VirtServiceProxy.m10571$$Nest$munlinkDeathRecipientIfNeeded(this.this$0, clientToken);
            return r7;
        L52:
            r6 = e.toString();     // Catch: Throwable -> L8
            goto L53
        }

        public LxcStreamingSession lxcStartExecutePrivilegedWithTokenStreamingWithEnv(String containerName, String[] args, int timeoutSeconds, IBinder clientToken, int privileged, String[] env) throws RemoteException {
            enforceTrustedCaller("lxcStartExecutePrivilegedWithTokenStreamingWithEnv");     // Catch: Exception -> L7
            if (privileged == 0) goto L9;
            Log.w(VirtServiceProxy.TAG, "Privileged streaming LXC execution is not supported");     // Catch: Exception -> L7
            return null;
        L9:
            int targetUid = getVerifiedCallingUid();     // Catch: Exception -> L7
            List<String> dnsServers = VirtServiceProxy.m10568$$Nest$mgetCurrentDnsServersForLxc(this.this$0, "lxcStartExecutePrivilegedWithTokenStreamingWithEnv");     // Catch: Exception -> L7
            String[] requestArgs = VirtServiceProxy.m10569$$Nest$mprepareExecuteArgsWithDns(this.this$0, args, dnsServers, "lxcStartExecutePrivilegedWithTokenStreamingWithEnv");     // Catch: Exception -> L7
            return VirtServiceProxy.m10567$$Nest$fgetmStreamingManager(this.this$0).startExecute(containerName, requestArgs, timeoutSeconds, clientToken, privileged, targetUid, env);
        L7:
            e = move-exception;
            Log.e(VirtServiceProxy.TAG, "lxcStartExecutePrivilegedWithTokenStreamingWithEnv failed", e);
            return null;
        }

        public LxcCommandResult lxcWaitForStreamingResult(String sessionId) throws RemoteException {
            enforceTrustedCaller("lxcWaitForStreamingResult");
            return VirtServiceProxy.m10567$$Nest$fgetmStreamingManager(this.this$0).waitForResult(sessionId);
        }

        public boolean isLxcGatewaySupported() throws RemoteException {
            enforceTrustedCaller("isLxcGatewaySupported");
            return true;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m10565$$Nest$fgetmContext(VirtServiceProxy r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipients, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m10566$$Nest$fgetmDeathRecipients(VirtServiceProxy r0) {
        return r0.mDeathRecipients;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStreamingManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ LxcStreamingManager m10567$$Nest$fgetmStreamingManager(VirtServiceProxy r0) {
        return r0.mStreamingManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentDnsServersForLxc, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m10568$$Nest$mgetCurrentDnsServersForLxc(VirtServiceProxy r0, String r1) {
        return r0.getCurrentDnsServersForLxc(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mprepareExecuteArgsWithDns, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m10569$$Nest$mprepareExecuteArgsWithDns(VirtServiceProxy r0, String[] r1, List r2, String r3) {
        return r0.prepareExecuteArgsWithDns(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msendExecuteCommandWithDns, reason: not valid java name */
    static /* bridge */ /* synthetic */ LxcClient.LxcCommandResult m10570$$Nest$msendExecuteCommandWithDns(VirtServiceProxy r0, String r1, String r2, String[] r3, int r4, int r5, int r6, String[] r7) {
        return r0.sendExecuteCommandWithDns(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$munlinkDeathRecipientIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10571$$Nest$munlinkDeathRecipientIfNeeded(VirtServiceProxy r0, IBinder r1) {
        r0.unlinkDeathRecipientIfNeeded(r1);
    }

    static {
        LOCK = new Object();
    }

    private VirtServiceProxy(Context context) {
        this.mDeathRecipients = new HashMap();
        this.mStreamingManager = new LxcStreamingManager();
        if (context == null) goto L5;
        Context r0 = context.getApplicationContext();
    L6:
        this.mContext = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static VirtServiceProxy getInstance(Context context) {
        if (sInstance != null) goto L16;
        Object r0 = LOCK;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new VirtServiceProxy(context);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void onStart() {
        ServiceManager.addService("VirtService", new VirtServiceImpl(this));
        Log.i(TAG, "VirtService registered.");
    }

    public void onBootPhase(int phase) {
        Log.i(TAG, "VirtService onBootPhase: " + phase);
    }

    private List<String> getCurrentDnsServersForLxc(String caller) {
        ArrayList<String> dnsServers = new ArrayList();
        if (this.mContext != null) goto L6;
        Log.w(TAG, caller + ": context is null, cannot query DNS servers");
        return dnsServers;
    L6:
        long token = Binder.clearCallingIdentity();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);     // Catch: Throwable -> L12
        if (connectivityManager != null) goto L14;
        Log.w(TAG, caller + ": ConnectivityManager is null");     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return dnsServers;
    L14:
        LinkedHashSet<String> dedupedDnsServers = new LinkedHashSet();     // Catch: Throwable -> L12
        Network activeNetwork = connectivityManager.getActiveNetwork();     // Catch: Throwable -> L12
        if (activeNetwork == null) goto L17;
        collectDnsServersFromLinkProperties(dedupedDnsServers, connectivityManager.getLinkProperties(activeNetwork), caller, "activeNetwork=" + activeNetwork);     // Catch: Throwable -> L12
    L19:
        if (dedupedDnsServers.isEmpty() == false) goto L29;
        Network[] allNetworks = connectivityManager.getAllNetworks();     // Catch: Throwable -> L12
        if (allNetworks == null) goto L28;
        if (allNetworks.length == 0) goto L28;
        int r8 = allNetworks.length;     // Catch: Throwable -> L12
        int r9 = 0;
    L26:
        if (r9 >= r8) goto L29;
        Network network = allNetworks[r9];     // Catch: Throwable -> L12
        collectDnsServersFromLinkProperties(dedupedDnsServers, connectivityManager.getLinkProperties(network), caller, "fallbackNetwork=" + network);     // Catch: Throwable -> L12
        r9 = r9 + 1;     // Catch: Throwable -> L12
    L28:
        Log.w(TAG, caller + ": no networks available from ConnectivityManager");     // Catch: Throwable -> L12
    L29:
        dnsServers.addAll(dedupedDnsServers);     // Catch: Throwable -> L12
        if (dnsServers.isEmpty() == false) goto L32;
        Log.w(TAG, caller + ": no DNS servers discovered from ConnectivityManager");     // Catch: Throwable -> L12
    L33:
        Binder.restoreCallingIdentity(token);
        return dnsServers;
    L32:
        Log.i(TAG, caller + ": discovered DNS servers=" + dnsServers);     // Catch: Throwable -> L12
        goto L33
    L17:
        Log.w(TAG, caller + ": active network is null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void collectDnsServersFromLinkProperties(LinkedHashSet<String> out, LinkProperties linkProperties, String caller, String source) {
        if (linkProperties != null) goto L6;
        Log.w(TAG, caller + ": LinkProperties is null for " + source);
        return;
    L6:
        List<InetAddress> dnsServers = linkProperties.getDnsServers();
        if (dnsServers.isEmpty() == false) goto L10;
        Log.w(TAG, caller + ": no DNS servers in " + source);
        return;
    L10:
        Iterator<InetAddress> r2 = dnsServers.iterator();
    L12:
        if (r2.hasNext() == false) goto L22;
        InetAddress dnsServer = r2.next();
        if (dnsServer == null) goto L12;
        String hostAddress = dnsServer.getHostAddress();
        if (hostAddress == null) goto L12;
        if (hostAddress.isEmpty() == true) goto L12;
        out.add(hostAddress);
        goto L12
    L22:
        Log.i(TAG, caller + ": " + source + " dnsServers=" + dnsServers + ", interfaceName=" + linkProperties.getInterfaceName());
    }

    private String[] prepareExecuteArgsWithDns(String[] args, List<String> dnsServers, String caller) {
        ArrayList<String> requestArgs = new ArrayList();
        if (args == null) goto L5;
        Collections.addAll(requestArgs, args);
    L5:
        StringBuilder dnsArgValue = new StringBuilder();
        Iterator<String> r2 = dnsServers.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        String dnsServer = r2.next();
        if (dnsServer == null) goto L7;
        if (dnsServer.isEmpty() == true) goto L7;
        if (dnsArgValue.length() <= 0) goto L16;
        dnsArgValue.append(',');
    L16:
        dnsArgValue.append(dnsServer);
        goto L7
    L17:
        requestArgs.add(LXC_DNS_ARG_PREFIX + dnsArgValue);
        Log.i(TAG, caller + ": appended DNS forwarding arg=" + dnsArgValue);
        return (String[]) requestArgs.toArray(new String[0]);
    }

    private List<String> ensureDnsFallback(List<String> dnsServers, String caller, String reason) {
        LinkedHashSet<String> normalizedDnsServers = new LinkedHashSet();
        if (dnsServers == null) goto L15;
        Iterator<String> r1 = dnsServers.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        String dnsServer = r1.next();
        if (dnsServer == null) goto L6;
        String trimmed = dnsServer.trim();
        if (trimmed.isEmpty() == true) goto L6;
        normalizedDnsServers.add(trimmed);
    L15:
        if (normalizedDnsServers.isEmpty() == false) goto L18;
        normalizedDnsServers.add(DEFAULT_DNS_SERVER);
        Log.w(TAG, caller + ": " + reason + ", fallback DNS=" + DEFAULT_DNS_SERVER);
    L18:
        return new ArrayList(normalizedDnsServers);
    }

    private LxcClient.LxcCommandResult sendExecuteCommandWithDns(String caller, String containerName, String[] args, int timeoutSeconds, int privileged, int targetUid, String[] env) {
        Log.i(TAG, caller + ": preparing DNS before calling LxcHelper, container=" + containerName + ", timeout=" + timeoutSeconds + "s, privileged=" + privileged + ", targetUid=" + targetUid);
        List<String> dnsServers = ensureDnsFallback(getCurrentDnsServersForLxc(caller), caller, "empty DNS result");     // Catch: Exception -> L5
        String[] requestArgs = prepareExecuteArgsWithDns(args, dnsServers, caller);     // Catch: Exception -> L5
    L7:
        StringBuilder r0 = new StringBuilder();
        r0.append(caller);
        r0.append(": calling LxcClient.sendLxcCommand with argsCount=");
        if (requestArgs == null) goto L10;
        int r2 = requestArgs.length;
    L11:
        r0.append(r2);
        Log.i(TAG, r0.toString());
        return LxcClient.sendLxcCommand("execute", containerName, requestArgs, timeoutSeconds, privileged, targetUid, env);
    L10:
        r2 = 0;
    L5:
        e = move-exception;
        Log.w(TAG, caller + ": failed to query DNS, fallback to default DNS", e);
        requestArgs = prepareExecuteArgsWithDns(args, ensureDnsFallback(null, caller, "DNS query failure"), caller);
        goto L7
    }

    private void unlinkDeathRecipientIfNeeded(IBinder clientToken) {
        if (clientToken != null) goto L4;
        return;
    L4:
        HashMap<IBinder, IBinder.DeathRecipient> r1 = this.mDeathRecipients;
        monitor-enter(r1);
        IBinder.DeathRecipient recipientToUnlink = this.mDeathRecipients.remove(clientToken);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (recipientToUnlink == null) goto L16;
        Log.i(TAG, "[VirtService-Death] Unlinking death recipient, map size=" + this.mDeathRecipients.size());
        clientToken.unlinkToDeath(recipientToUnlink, 0);
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
