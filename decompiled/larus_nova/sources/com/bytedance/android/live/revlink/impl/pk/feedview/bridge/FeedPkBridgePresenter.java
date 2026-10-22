package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.link.model.b8;
import com.bytedance.android.livesdk.link.model.bridge.f2;
import com.bytedance.android.livesdk.link.model.bridge.q;
import com.bytedance.android.livesdk.link.model.bridge.u0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.d1;
import com.bytedance.android.livesdk.link.model.g5;
import com.bytedance.android.livesdk.link.model.k5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedPkBridgePresenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f96437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f96438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mx0.a f96439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f96440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f96441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRoom f96442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f96443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f96444h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f96445i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f96446j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, ? extends b8> f96447k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableLiveData<String> f96448l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableLiveData<String> f96449m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f96450n;

    public FeedPkBridgePresenter() {
        this.f96440d = new CompositeDisposable();
        this.f96444h = true;
        this.f96446j = true;
        this.f96448l = new MutableLiveData();
        this.f96449m = new MutableLiveData();
    }

    public final void b(mx0.a r100) {
        if (this.f96441e == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r101 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90886c);
        final FeedPkBridgePresenter$doMessageListen$1 r102 = new FeedPkBridgePresenter$doMessageListen$1(this);
        Disposable r103 = r101.subscribe(new a(r102));
        if (r103 == null) goto L8;
        RxUtilKt.c(r103, this.f96440d);
    L8:
        Observable r104 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90887d);
        final FeedPkBridgePresenter$doMessageListen$2 r105 = new FeedPkBridgePresenter$doMessageListen$2(this);
        Disposable r106 = r104.subscribe(new a(r105));
        if (r106 == null) goto L11;
        RxUtilKt.c(r106, this.f96440d);
    L11:
        Observable r107 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90893j);
        final FeedPkBridgePresenter$doMessageListen$3 r108 = new FeedPkBridgePresenter$doMessageListen$3(this);
        Disposable r109 = r107.subscribe(new a(r108));
        if (r109 == null) goto L14;
        RxUtilKt.c(r109, this.f96440d);
    L14:
        Observable r110 = r100.a(com.bytedance.android.live.revenue.common.message.b.f90892i);
        final FeedPkBridgePresenter$doMessageListen$4 r111 = new FeedPkBridgePresenter$doMessageListen$4(this);
        Disposable r112 = r110.subscribe(new a(r111));
        if (r112 == null) goto L17;
        RxUtilKt.c(r112, this.f96440d);
    L17:
        this.f96441e = true;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f96446j = true;
        Disposable r101 = this.f96445i;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        Disposable r102 = this.f96450n;
        if (r102 == null) goto L9;
        r102.dispose();
        return;
    }

    public static final void a(FeedPkBridgePresenter r100, yh6.c r101) {
        r100.getClass();
        if ((r101 instanceof z0) == false) goto L10;
        k5 r102 = (k5) ((z0) r101).castTo(k5.class);
        if (((int) r102.getType2()) != 202) goto L53;
        d r103 = r100.f96438b;
        if (r103 == null) goto L54;
        r103.c(r102);
        return;
    L54:
        return;
    L53:
        return;
    L10:
        if ((r101 instanceof u0) == false) goto L15;
        g5 r104 = (g5) ((vh7.c) r101).castTo(g5.class);
        d r105 = r100.f96438b;
        if (r105 == null) goto L56;
        r105.b(r104);
        return;
    L56:
        return;
    L15:
        if ((r101 instanceof f2) == false) goto L46;
        c8 r106 = (c8) ((vh7.c) r101).castTo(c8.class);
        int r107 = r106.getScoreUpdateType();
        r100.f96443g = r107;
        boolean r108 = true;
        if (r100.f96446j == true) goto L23;
        if (r107 != 1) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == true) goto L23;
        r100.c("scoreStatus_" + r100.f96443g);
        goto L23
    L20:
        r109 = false;
    L23:
        IRoom r110 = r100.f96442f;
        if (r110 == null) goto L28;
        if (r110.isLiveTypeAudio() != true) goto L28;
    L29:
        boolean r111 = false;
    L32:
        if (r111 != r100.f96444h) goto L35;
        r108 = false;
    L35:
        r100.f96444h = r111;
        if (r100.f96446j == false) goto L38;
        r100.f96447k = r106.getAnchorInfoMap();
    L38:
        r100.f96448l.setValue(String.valueOf(r106.getLinkStartTime()));
        if (r108 == false) goto L41;
    L42:
        d r112 = r100.f96438b;
        if (r112 == null) goto L59;
        r112.e();
        return;
    L59:
        return;
    L41:
        if (r100.f96446j == true) goto L42;
        return;
    L28:
        if (v41.b.f553047f.a() == false) goto L29;
        r111 = com.bytedance.android.live.revlink.impl.multianchor.profit.c.a(r100.f96443g);
        goto L32
    L46:
        if ((r101 instanceof q) == false) goto L61;
        d1 r113 = (d1) ((vh7.c) r101).castTo(d1.class);
        if (TextUtils.isEmpty(r113.getBattleEffectInfo()) == true) goto L62;
        d r114 = r100.f96438b;
        if (r114 == null) goto L63;
        r114.a(r113);
        return;
    L63:
        return;
    L62:
        return;
    }
}
