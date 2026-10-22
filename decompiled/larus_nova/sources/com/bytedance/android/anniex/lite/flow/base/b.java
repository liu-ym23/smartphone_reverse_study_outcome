package com.bytedance.android.anniex.lite.flow.base;

import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModel;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b extends com.bytedance.android.anniex.lite.flow.base.model.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f40923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.anniex.lite.flow.base.model.a f40924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IAnnieXPreloadStrategyProvider f40925f;

    public static final class a {
    }

    static {
    }

    public void e() {
        com.bytedance.android.anniex.lite.flow.base.model.b r100 = this.f40931a;
        Iterator<AnnieXModel> r101 = r100.f40930a.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a();
        goto L4
    L6:
        r100.f40930a.clear();
        CoroutineScopeKt.cancel$default(this.f40923d, null, 1, null);
        com.bytedance.android.anniex.lite.flow.base.a r102 = com.bytedance.android.anniex.lite.flow.base.a.f40919a;
        String r103 = this.f40922c;
        monitor-enter(r102);
        Intrinsics.checkNotNullParameter(r103, "sessionId");     // Catch: Throwable -> L11
        com.bytedance.android.anniex.lite.flow.base.a.f40920b.remove(r103);     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        this.f40921b = r100;
        this.f40922c = r101;
        CoroutineScope r102 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.f40923d = r102;
        com.bytedance.android.anniex.lite.flow.base.a r103 = com.bytedance.android.anniex.lite.flow.base.a.f40919a;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r101, "sessionId");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(this, "dispatchManager");     // Catch: Throwable -> L11
        com.bytedance.android.anniex.lite.flow.base.a.f40920b.put(r101, this);     // Catch: Throwable -> L11
        monitor-exit(r103);
        com.bytedance.android.anniex.lite.flow.base.model.b r104 = this.f40931a;
        if (com.bytedance.android.anniex.lite.flow.base.model.d.f40932a != null) goto L9;
        com.bytedance.android.anniex.lite.flow.base.model.d.f40932a = new com.bytedance.android.anniex.lite.flow.base.model.d();
    L9:
        com.bytedance.android.anniex.lite.flow.base.model.d r105 = com.bytedance.android.anniex.lite.flow.base.model.d.f40932a;
        Intrinsics.checkNotNull(r105);
        this.f40924e = new com.bytedance.android.anniex.lite.flow.base.model.a(r104, r105);
        AnnieXServiceCenter.f40313a.getClass();
        this.f40925f = (IAnnieXPreloadStrategyProvider) AnnieXServiceCenter.d(r100, IAnnieXPreloadStrategyProvider.class);
        BuildersKt.launch$default(r102, Dispatchers.getDefault(), null, new BaseAnnieXDispatchManager$releaseTask$1(this, null), 2, null);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
