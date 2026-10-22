package com.obric.agent.complextask;

import android.content.Context;
import android.os.RemoteException;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.api.IOAutoStateManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: OmniTaskStateProviderClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14359a = null;

    /* JADX INFO: compiled from: OmniTaskStateProviderClient.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniTaskStateProviderClient.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f14360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14361b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f14360a == r6.f14360a) goto L12;
            return false;
        L12:
            if (o.a(this.f14361b, r6.f14361b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f14360a) * 31;
            String r1 = this.f14361b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "StopTaskResult(success=" + this.f14360a + ", errorMessage=" + this.f14361b + ')';
        }

        public b(boolean r1, String r2) {
            this.f14360a = r1;
            this.f14361b = r2;
        }

        public final String a() {
            return this.f14361b;
        }
    }

    static {
        f14359a = new a(null);
    }

    public e(Context r3) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
    }

    private final IOAutoStateManager a() {
        return (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
    }

    public final d a(String r6) {
        o.e(r6, ObricMemoryConstants.KEY_SESSION_ID);
        IOAutoStateManager r5 = a();     // Catch: Exception -> L15 SecurityException -> L17 RemoteException -> L18
        if (r5 == null) goto L6;
        IOAutoStateManager.a r7 = r5.getCurrentState(r6);     // Catch: Exception -> L15 SecurityException -> L17 RemoteException -> L18
    L7:
        if (r7 == null) goto L25;
        int r8 = r7.a();     // Catch: Exception -> L15 SecurityException -> L17 RemoteException -> L18
        Integer r9 = r7.b();     // Catch: Exception -> L15 SecurityException -> L17 RemoteException -> L18
        if (r9 == null) goto L11;
        String r10 = r9.toString();     // Catch: Exception -> L15 SecurityException -> L17 RemoteException -> L18
    L22:
        return new d(r8, r10, true, null);
    L11:
        r10 = null;
        goto L22
    L25:
        return new d(-1, null, false, "IOAutoStateManager unavailable");
    L6:
        r7 = null;
    L18:
        e = move-exception;
        return new d(-1, null, false, "RemoteException: " + e.getMessage());
    L15:
        e = move-exception;
        return new d(-1, null, false, "Exception: " + e.getMessage());
    L24:
        return new d(-1, null, false, "SecurityException: No permission to access ContentProvider");
    }

    public final b a(String r4, String r5, int r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r5, "message");
        o.e(r8, "ext");
        IOAutoStateManager r2 = a();     // Catch: Exception -> L8 SecurityException -> L10 RemoteException -> L11
        if (r2 == null) goto L6;
        b r9 = new b(r2.stopTask(r4, r5, r6, r8), "");     // Catch: Exception -> L8 SecurityException -> L10 RemoteException -> L11
    L14:
        return r9;
        goto L19
    L6:
        e r3 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L8 SecurityException -> L10 RemoteException -> L11
        r9 = new b(false, "IOAutoStateManager unavailable");     // Catch: Exception -> L8 SecurityException -> L10 RemoteException -> L11
    L11:
        e = move-exception;
        return new b(false, "RemoteException: " + e.getMessage());
    L8:
        e = move-exception;
        return new b(false, "Exception: " + e.getMessage());
    L19:
        return new b(false, "SecurityException: No permission to access ContentProvider");
    }
}
