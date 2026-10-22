package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.link.model.bridge.q;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.k5;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedMultiBridgePresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f94120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f94121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f94122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f94123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f94124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z21.a f94125f;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedMultiBridgePresenter f94126a;

        public a(FeedMultiBridgePresenter r100) {
            this.f94126a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Unit r101 = (Unit) r100;
            FeedMultiBridgePresenter r102 = this.f94126a;
            mx0.a r103 = r102.f94125f.f569772c;
            if (r102.f94120a == false) goto L7;
            if (r103 == null) goto L8;
            r102.b(r103);
            return;
        L8:
            return;
        }
    }

    public FeedMultiBridgePresenter(z21.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f94125f = r100;
        this.f94123d = new CompositeDisposable();
        this.f94124e = new a(this);
    }

    public final void b(mx0.a r100) {
        if (this.f94122c == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r101 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90886c);
        final FeedMultiBridgePresenter$doMessageListen$1 r102 = new FeedMultiBridgePresenter$doMessageListen$1(this);
        Disposable r103 = r101.subscribe(new b(r102));
        if (r103 == null) goto L8;
        RxUtilKt.c(r103, this.f94123d);
    L8:
        Observable r104 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90893j);
        final FeedMultiBridgePresenter$doMessageListen$2 r105 = new FeedMultiBridgePresenter$doMessageListen$2(this);
        Disposable r106 = r104.subscribe(new b(r105));
        if (r106 == null) goto L11;
        RxUtilKt.c(r106, this.f94123d);
    L11:
        Observable r107 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90887d);
        final FeedMultiBridgePresenter$doMessageListen$3 r108 = new FeedMultiBridgePresenter$doMessageListen$3(this);
        Disposable r109 = r107.subscribe(new b(r108));
        if (r109 == null) goto L14;
        RxUtilKt.c(r109, this.f94123d);
    L14:
        this.f94122c = true;
    }

    public static final void a(FeedMultiBridgePresenter r100, yh6.c r101) {
        r100.getClass();
        if ((r101 instanceof z0) == false) goto L10;
        k5 r102 = (k5) ((z0) r101).castTo(k5.class);
        if (((int) r102.getType2()) != 202) goto L22;
        e r103 = r100.f94121b;
        if (r103 == null) goto L23;
        r103.c(r102);
        return;
    L23:
        return;
    L22:
        return;
    L10:
        if ((r101 instanceof q) == false) goto L17;
        d1 r104 = (d1) ((vh7.c) r101).castTo(d1.class);
        if (TextUtils.isEmpty(r104.getBattleEffectInfo()) == true) goto L25;
        e r105 = r100.f94121b;
        if (r105 == null) goto L26;
        r105.a(r104);
        return;
    L26:
        return;
    L25:
        return;
    L17:
        if ((r101 instanceof u0) == false) goto L28;
        g5 r106 = (g5) ((vh7.c) r101).castTo(g5.class);
        e r107 = r100.f94121b;
        if (r107 == null) goto L29;
        r107.b(r106);
        return;
    L29:
        return;
    }
}
