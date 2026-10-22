package com.bytedance.android.live.broadcastgame.opengame.panel;

import com.bytedance.android.live.broadcastgame.opengame.q;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f60673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f60674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f60675c;

    public b(int r100, Function1 r101, Ref.ObjectRef r102) {
        this.f60673a = r100;
        this.f60674b = r101;
        this.f60675c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        int r102 = ((Number) r101.component1()).intValue();
        FullScreenOpenPanel r103 = (FullScreenOpenPanel) r101.component2();
        if (this.f60673a != r102) goto L7;
        this.f60674b.invoke(r103);
        Disposable r104 = (Disposable) this.f60675c.element;
        if (r104 == null) goto L9;
        r104.dispose();
        return;
    L9:
        return;
    L7:
        int r105 = q.f60744a;
        q.g("attach want:" + this.f60673a + " create：" + r102, "FullScreenOpenPanel");
    }
}
