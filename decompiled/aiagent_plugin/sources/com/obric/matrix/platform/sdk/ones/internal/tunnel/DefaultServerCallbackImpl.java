package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.util.Log;
import com.obric.matrix.a.ad;
import com.obric.matrix.platform.server.IServerCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;

/* JADX INFO: compiled from: DefaultServerCallbackImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DefaultServerCallbackImpl extends IServerCallback.Stub {
    public static final a Companion = null;
    private static final String TAG = "DefaultServerCallbackImpl";

    /* JADX INFO: compiled from: DefaultServerCallbackImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public DefaultServerCallbackImpl() {
    }

    @Override // com.obric.matrix.platform.server.IServerCallback
    public void onResult(int r8, byte[] r9) {
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "onResult(cmd: " + r8 + ", bytes: " + r9 + ").", null, 4, null);
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(d.f33701a.e(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "notification start", null, 4, null);     // Catch: Exception -> L14
        if (r9 == null) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L11;
        throw new IllegalStateException("result bytes is null".toString());     // Catch: Exception -> L14
    L11:
        ad r6 = ad.f33286a.decode(r9);     // Catch: Exception -> L14
        o.c(r6, "ADAPTER.decode(bytes)");     // Catch: Exception -> L14
        r3.a(r8, (ad) ZeusTransformUtils.preCheckCast(r6, ad.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L14
        goto L4
    L9:
        r5 = false;
    L14:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "on notification exception " + Log.getStackTraceString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), null, 4, null);
        goto L4
    }
}
