package com.bytedance.android.live.revlink.impl.pk.feedview.viewstate;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.FeedBreakThroughBarState;
import com.bytedance.android.live.revlink.impl.pk.feedview.frame.ModeType;
import com.bytedance.android.live.revlink.impl.pk.feedview.layout.FeedPkWindowManager;
import com.bytedance.android.live.revlink.impl.pk.feedview.lynx.FeedBreakThroughBarWidget;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.l;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.s;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.v;
import com.bytedance.android.live.revlink.impl.pk.feedview.r;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.IPreviewIMExtend;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.h3;
import com.bytedance.android.livesdk.link.model.m3;
import com.bytedance.android.livesdk.link.model.n3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.link.model.x2;
import com.larus.nova.R;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qc0.d;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FeedPkWindowManager f96653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a f96654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f96655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ModeType f96656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f96657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IBattleUserInfo f96658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f96659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f96660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h3 f96661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z31.d f96662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public aa f96663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public q11.a f96664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f96665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public m3 f96666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public n3 f96667o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<? extends af2.b> f96668p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public r f96669q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MutableLiveData<pc0.d> f96670r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Long f96671s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public zy0.b f96672t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f96673u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function0<Unit> f96674v;

    public final IBaseBattleSetting b() {
        l r100 = this.f96657e;
        if ((r100 instanceof l.c) == false) goto L12;
        if (r100 == null) goto L10;
        v r101 = ((l.c) r100).f96582c;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f96604e;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L12:
        if ((r100 instanceof l.b) == false) goto L20;
        if (r100 == null) goto L19;
        s r102 = ((l.b) r100).f96581c;
        if (r102 != null) goto L17;
        return null;
    L17:
        return r102.f96593c;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L20:
        return null;
    }

    public final x2 c() {
        l r100 = this.f96657e;
        if ((r100 instanceof l.c) == false) goto L12;
        if (r100 == null) goto L10;
        v r101 = ((l.c) r100).f96582c;
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f96605f;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L12:
        if ((r100 instanceof l.b) == false) goto L20;
        if (r100 == null) goto L19;
        s r102 = ((l.b) r100).f96581c;
        if (r102 != null) goto L17;
        return null;
    L17:
        return r102.f96594d;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L20:
        return null;
    }

    public final int d() {
        l r100 = this.f96657e;
        Integer r101 = null;
        if ((r100 instanceof l.c) == false) goto L13;
        if (r100 == null) goto L11;
        v r102 = ((l.c) r100).f96582c;
        if (r102 == null) goto L9;
        r101 = Integer.valueOf(r102.f96606g);
    L9:
        return r101.intValue();
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L13:
        if ((r100 instanceof l.b) == false) goto L22;
        if (r100 == null) goto L21;
        s r103 = ((l.b) r100).f96581c;
        if (r103 == null) goto L19;
        r101 = Integer.valueOf(r103.f96595e);
    L19:
        return r101.intValue();
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L22:
        return 0;
    }

    public final void e() {
        if (this.f96656d != ModeType.BreakThough) goto L12;
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r100 = this.f96654b;
        if (r100 == null) goto L7;
        FrameLayout r101 = r100.f96427b;
    L8:
        FeedPkWindowManager r102 = this.f96653a;
        if (r102 == null) goto L13;
        r102.h(r101);
        return;
    L13:
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final void g() {
        l r100 = this.f96657e;
        ModeType r101 = this.f96656d;
        aa r102 = this.f96663k;
        Integer r103 = this.f96659g;
        Integer r104 = this.f96660h;
        q11.a r105 = this.f96664l;
        z31.d r106 = this.f96662j;
        Long r107 = this.f96655c;
        IBattleUserInfo r108 = this.f96658f;
        r r109 = this.f96669q;
        if ((r100 instanceof l.c) == false) goto L10;
        if (r101 == null) goto L10;
        if (r103 == null) goto L10;
        FeedPkWindowManager r110 = this.f96653a;
        if (r110 == null) goto L10;
        r110.f((l.c) r100, r101, r103.intValue());
    L10:
        if ((r100 instanceof l.b) == false) goto L17;
        if (r101 == null) goto L17;
        if (r103 == null) goto L17;
        FeedPkWindowManager r111 = this.f96653a;
        if (r111 == null) goto L17;
        r111.e((l.b) r100, r101, r103.intValue());
    L17:
        if ((r100 instanceof l.a) == false) goto L21;
        FeedPkWindowManager r112 = this.f96653a;
        if (r112 == null) goto L21;
        r112.d((l.a) r100, r104);
    L21:
        if (r105 == null) goto L25;
        FeedPkWindowManager r113 = this.f96653a;
        if (r113 == null) goto L25;
        r113.l(r105);
    L25:
        if (r102 == null) goto L29;
        FeedPkWindowManager r114 = this.f96653a;
        if (r114 == null) goto L29;
        r114.n(r102);
    L29:
        if (r109 == null) goto L33;
        FeedPkWindowManager r115 = this.f96653a;
        if (r115 == null) goto L33;
        r115.j(r109);
    L33:
        FeedPkWindowManager r116 = this.f96653a;
        if (r116 == null) goto L36;
        r116.m(r106);
    L36:
        if (r107 == null) goto L40;
        FeedPkWindowManager r117 = this.f96653a;
        if (r117 == null) goto L40;
        r117.i(r107.longValue());
    L40:
        if (r108 == null) goto L44;
        FeedPkWindowManager r118 = this.f96653a;
        if (r118 == null) goto L44;
        r118.k(r108);
    L44:
        FeedPkWindowManager r119 = this.f96653a;
        if (r119 == null) goto L47;
        r119.b().c();
    L47:
        l r120 = this.f96657e;
        if (r120 != null) goto L50;
    L60:
        IPreviewIMExtend.IMFeedPkViewState r121 = IPreviewIMExtend.IMFeedPkViewState.Other;
    L62:
        if ((r120 instanceof l.a) == false) goto L64;
        IPreviewIMExtend.IMFeedPkPlayMode r122 = IPreviewIMExtend.IMFeedPkPlayMode.CONNECTION;
    L106:
        MutableLiveData<pc0.d> r123 = this.f96670r;
        Integer r124 = this.f96659g;
        if (r124 == null) goto L109;
        int r125 = r124.intValue();
    L110:
        Integer r126 = Integer.valueOf(r121.ordinal());
        Integer r127 = Integer.valueOf(r122.ordinal());
        if (this.f96673u == false) goto L113;
        int r128 = 1;
    L114:
        r123.setValue(new pc0.d(r125, r126, r127, R.drawable.ttlive_icon_pk_for_im, r128));
        return;
    L113:
        r128 = 2;
        goto L114
    L109:
        r125 = 0;
        goto L110
    L64:
        aa r129 = this.f96663k;
        if (r129 == null) goto L70;
        if (r129.getVoteType() == 0) goto L70;
        r122 = IPreviewIMExtend.IMFeedPkPlayMode.VOTE;
    L70:
        if (this.f96656d != ModeType.BreakThough) goto L76;
        l r130 = this.f96657e;
        if ((r130 instanceof l.c) == false) goto L74;
    L75:
        r122 = IPreviewIMExtend.IMFeedPkPlayMode.PVE;
        goto L106
    L74:
        if ((r130 instanceof l.a) == true) goto L75;
    L76:
        l r131 = this.f96657e;
        w2 r132 = null;
        if ((r131 instanceof l.c) == false) goto L91;
        if (r131 == null) goto L90;
        v r133 = ((l.c) r131).f96582c;
        if (r133 == null) goto L86;
        IBaseBattleSetting r134 = r133.f96604e;
        if (r134 == null) goto L86;
        IBattleConfigSetting r135 = r134.getBattleConfigSetting();
        if (r135 == null) goto L86;
        w2 r136 = r135.getShellConfig();
    L87:
        if (r136 == null) goto L91;
        r122 = IPreviewIMExtend.IMFeedPkPlayMode.SHELLCONFIG;
    L86:
        r136 = null;
        goto L87
    L90:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PK");
    L91:
        l r137 = this.f96657e;
        if ((r137 instanceof l.b) == false) goto L105;
        if (r137 == null) goto L104;
        s r138 = ((l.b) r137).f96581c;
        if (r138 == null) goto L101;
        IBaseBattleSetting r139 = r138.f96593c;
        if (r139 == null) goto L101;
        IBattleConfigSetting r140 = r139.getBattleConfigSetting();
        if (r140 == null) goto L101;
        r132 = r140.getShellConfig();
    L101:
        if (r132 == null) goto L105;
        r122 = IPreviewIMExtend.IMFeedPkPlayMode.SHELLCONFIG;
        goto L106
    L104:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.feedview.machine.FeedPkState.PENAL");
    L105:
        r122 = IPreviewIMExtend.IMFeedPkPlayMode.PK;
        goto L106
    L50:
        if ((r120 instanceof l.c) == false) goto L53;
        r121 = IPreviewIMExtend.IMFeedPkViewState.PK;
    L59:
        if (r121 != null) goto L62;
    L53:
        if ((r120 instanceof l.b) == false) goto L56;
        r121 = IPreviewIMExtend.IMFeedPkViewState.PENAL;
        goto L59
    L56:
        if ((r120 instanceof l.a) == false) goto L58;
        r121 = IPreviewIMExtend.IMFeedPkViewState.LINK;
        goto L59
    L58:
        r121 = IPreviewIMExtend.IMFeedPkViewState.Other;
        goto L59
    }

    public b() {
        this.f96670r = new MutableLiveData();
    }

    @Override // qc0.d
    public final Function0<Unit> a() {
        return this.f96674v;
    }

    public final void f(final int r110) {
        final Integer r100 = this.f96659g;
        final h3 r101 = this.f96661i;
        final m3 r102 = this.f96666n;
        final n3 r103 = this.f96667o;
        final List<? extends af2.b> r104 = this.f96668p;
        com.bytedance.android.live.revlink.impl.pk.feedview.breakthrough.a r105 = this.f96654b;
        if (r105 == null) goto L32;
        Function1<FeedBreakThroughBarState, Unit> r106 = new FeedPkViewState$onBreakThroughBarUpdate$1(this, r110, r102, r103, r104, r101, r100);
        Intrinsics.checkNotNullParameter(r106, "procedure");
        FeedBreakThroughBarState r111 = r105.f96429d;
        if (r111 == null) goto L36;
        l r107 = r111.f96420a;
        r106.invoke(r111);
        l r112 = r111.f96420a;
        String r108 = null;
        if (r107 == null) goto L10;
        String r109 = r107.f96578a;
    L11:
        if (r112 == null) goto L14;
        r108 = r112.f96578a;
    L14:
        if (Intrinsics.areEqual(r109, r108) == false) goto L17;
        return;
    L17:
        if (r105.f96432g == false) goto L33;
        FeedBreakThroughBarWidget r113 = r105.f96433h;
        if (r113 == null) goto L34;
        ViewGroup r114 = r113.f96514a;
        if (r114 == null) goto L23;
        r114.removeAllViews();
    L23:
        zy0.b r115 = r113.f96516c;
        if (r115 == null) goto L28;
        xy0.a<?> r116 = r115.g();
        if (r116 == null) goto L28;
        r116.load();
    L28:
        FeedBreakThroughBarWidget.a r117 = r113.f96515b;
        if (r117 == null) goto L35;
        r117.a();
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L10:
        r109 = null;
        goto L11
    L36:
        return;
    }
}
