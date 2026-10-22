package com.obric.memorydata.sdk.awareness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import d.n;

/* JADX INFO: compiled from: BaseAwarenessCallbackProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAwarenessCallbackProvider extends PluginContentProvider {
    private static final a Companion = null;
    private static final String TAG = "AwarenessCallbackProvider";

    /* JADX INFO: compiled from: BaseAwarenessCallbackProvider.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public abstract void onContextEvent(String r1, String r2, Bundle r3);

    public abstract void onFeatureEvent(String r1, String r2, Object r3, Object r4, Bundle r5);

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public BaseAwarenessCallbackProvider() {
    }

    public boolean onCreate() {
        com.obric.memorydata.sdk.a.d.f33797a.b(TAG, "callback provider onCreate");
        return true;
    }

    public Bundle call(String r6, String r7, Bundle r8) {
        o.e(r6, "method");
        com.obric.memorydata.sdk.a.d.f33797a.b(TAG, "callback provider call method=" + r6);
        if (o.a(r6, "persistent_awareness_callback") == true) goto L7;
        com.obric.memorydata.sdk.a.d.f33797a.c(TAG, "callback provider unknown method=" + r6);
        return f.f33829a.a(405, "unknown method=" + r6);
    L7:
        if (validateAwarenessProviderCaller() == true) goto L10;
        com.obric.memorydata.sdk.a.d.f33797a.c(TAG, "callback provider caller is not allowed");
        return f.f33829a.a(402, "caller is not allowed");
    L10:
        f r9 = f.f33829a;
        if (r8 == null) goto L13;
        PersistentAwarenessCallback r10 = (PersistentAwarenessCallback) ZeusTransformUtils.preCheckCast(r9.a(r8, "callback", PersistentAwarenessCallback.class), PersistentAwarenessCallback.class, "com.obric.aiagent.plugin");
    L14:
        if (r10 != null) goto L27;
        BaseAwarenessCallbackProvider r5 = (BaseAwarenessCallbackProvider) ZeusTransformUtils.preCheckCast(this, BaseAwarenessCallbackProvider.class, "com.obric.aiagent.plugin");
        com.obric.memorydata.sdk.a.d.f33797a.c(TAG, "callback provider callback is missing");
        return f.f33829a.a(405, "callback is missing");
    L27:
        n.a r11 = n.f38560a;     // Catch: Throwable -> L19
        BaseAwarenessCallbackProvider r12 = (BaseAwarenessCallbackProvider) ZeusTransformUtils.preCheckCast(this, BaseAwarenessCallbackProvider.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        com.obric.memorydata.sdk.a.d.f33797a.b(TAG, "dispatch callback subscriptionId=" + r10.getSubscriptionId() + " target=" + r10.getTarget().getTargetType() + '/' + r10.getTarget().getTargetName());     // Catch: Throwable -> L19
        Object r13 = n.f(r12.dispatchCallback(r10));     // Catch: Throwable -> L19
    L21:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L26;
        com.obric.memorydata.sdk.a.d.f33797a.a(TAG, "callback provider dispatch failed", r14);
        r13 = f.f33829a.a(400, r14.getMessage());
    L26:
        return (Bundle) ZeusTransformUtils.preCheckCast(r13, Bundle.class, "com.obric.aiagent.plugin");
    L19:
        th = move-exception;
        n.a r15 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L21
    L13:
        r10 = null;
        goto L14
    }

    public boolean validateAwarenessProviderCaller() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = Binder.getCallingUid();
        String[] r3 = r0.getPackageManager().getPackagesForUid(r2);
        if (r3 != null) goto L8;
        r3 = new String[0];
    L8:
        String[] r4 = r3;
        int r5 = r4.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L25;
        String r7 = r4[r6];
        if (o.a(r7, r0.getPackageName()) == false) goto L14;
    L21:
        boolean r8 = true;
    L22:
        if (r8 == true) goto L23;
        r6 = r6 + 1;
        goto L10
    L23:
        r1 = true;
        goto L25
    L14:
        if (o.a(r7, "com.larus.nova") == true) goto L21;
        o.a(r7);
        if (hasSameSignature(r7, "com.larus.nova") == true) goto L21;
        String r9 = r0.getPackageName();
        o.c(r9, "getPackageName(...)");
        if (hasSameSignature(r7, r9) == true) goto L21;
        r8 = false;
    L25:
        com.obric.memorydata.sdk.a.d.f33797a.b(TAG, "validate callback caller uid=" + r2 + " allowed=" + r1 + " packages=" + i.a(r4, null, null, null, 0, null, null, 63, null));
        return r1;
    }

    private final Bundle dispatchCallback(PersistentAwarenessCallback r9) {
        r9.getPayload().setClassLoader(getClass().getClassLoader());
        String r0 = r9.getTarget().getTargetType();
        Bundle r2 = null;
        if (o.a(r0, "feature") == false) goto L10;
        Bundle r1 = r9.getPayload().getBundle("extras");
        if (r1 == null) goto L7;
        r1.setClassLoader(r1.getClass().getClassLoader());
        r1.keySet();
        Bundle r7 = r1;
    L8:
        onFeatureEvent(r9.getSubscriptionId(), r9.getTarget().getTargetName(), r9.getPayload().get("old_value"), r9.getPayload().get("new_value"), r7);
        return f.f33829a.a();
    L7:
        r7 = null;
        goto L8
    L10:
        if (o.a(r0, "event") == false) goto L15;
        Bundle r3 = r9.getPayload().getBundle("extras");
        if (r3 == null) goto L14;
        r3.setClassLoader(r3.getClass().getClassLoader());
        r3.keySet();
        r2 = r3;
    L14:
        onContextEvent(r9.getSubscriptionId(), r9.getTarget().getTargetName(), r2);
        return f.f33829a.a();
    L15:
        com.obric.memorydata.sdk.a.d.f33797a.c(TAG, "unknown callback targetType=" + r9.getTarget().getTargetType());
        return f.f33829a.a(405, "unknown targetType=" + r9.getTarget().getTargetType());
    }

    private final boolean hasSameSignature(String r5, String r6) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L18;
        return false;
    L18:
        n.a r3 = n.f38560a;     // Catch: Throwable -> L11
        BaseAwarenessCallbackProvider r4 = (BaseAwarenessCallbackProvider) ZeusTransformUtils.preCheckCast(this, BaseAwarenessCallbackProvider.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r0.getPackageManager().checkSignatures(r5, r6) != 0) goto L8;
        boolean r7 = true;
    L9:
        Object r8 = n.f(Boolean.valueOf(r7));     // Catch: Throwable -> L11
    L14:
        if (n.b(r8) == false) goto L17;
        r8 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L8:
        r7 = false;
    L11:
        th = move-exception;
        n.a r9 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L14
    }
}
