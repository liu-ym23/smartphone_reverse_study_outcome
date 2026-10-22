package com.bytedance.android.live.multilink;

import bc.a;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.t1;
import com.bytedance.android.scope.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/MultiLinkInitializer;", "", "()V", "ensureInitialized", "", "multilink-integration_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiLinkInitializer {
    public static final MultiLinkInitializer INSTANCE = null;

    private MultiLinkInitializer() {
    }

    public final void ensureInitialized() {
    }

    static {
        INSTANCE = new MultiLinkInitializer();
        ALogger.w("MultiLinkScope", "MultiLinkInitializer#init, call invokeBatchCall", new Throwable());
        Function0<Unit> r100 = t1.f66404a;
        Function0<Unit> r101 = t1.f66404a;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke();
    L5:
        a.call("scope-modules");
        h23.a r103 = h23.a.f483586a;
        m r104 = m.f163449e;
        h23.a r105 = h23.a.f483586a;
        r104.getClass();
        m.e(r105);
        a.call("settings");
        ALogger.i("MultiLinkScope", "MultiLinkInitializer#init, invokeBatchCall Finish");
    }
}
