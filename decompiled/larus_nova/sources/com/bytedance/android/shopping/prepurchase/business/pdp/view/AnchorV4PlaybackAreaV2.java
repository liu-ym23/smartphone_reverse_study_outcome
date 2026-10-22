package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Lifecycle;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.api.PlaybackEntryApi;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.api.PlaybackVideoRequestParams;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/AnchorV4PlaybackAreaV2;", "Landroidx/cardview/widget/CardView;", "Lfa3/d;", "", "getCurVideoProgress", "Lij/a;", "event", "", "onPlaybackPageReturned", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4PlaybackAreaV2 extends CardView implements fa3.d {
    public final /* synthetic */ fa3.b A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f182194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f182195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f182196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LottieAnimationView f182197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f182198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PlayerBlock f182199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f182200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SimpleDraweeView f182201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f182202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f182203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ECLottieAnimationView f182204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f182205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SimpleDraweeView f182206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f182207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f182208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f182209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public n73.a f182210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f182211r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f182212s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f182213t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public fj.d f182214u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ECPDPBaseVideo f182215v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f182216w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f182217x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f182218y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function0<Unit> f182219z;

    public static final class a {
    }

    static {
    }

    public AnchorV4PlaybackAreaV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4PlaybackAreaV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.A.add(r100);
        return r100;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    private final int getCurVideoProgress() {
        PlayerBlock r100 = this.f182199f;
        if (r100 == null) goto L5;
        float r101 = r100.getPlayProgress();
    L6:
        float r102 = r101 / 100;
        PlayerBlock r103 = this.f182199f;
        if (r103 == null) goto L11;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r104 = r103.getVideoModel();
        if (r104 == null) goto L11;
        long r105 = r104.a();
    L13:
        return (int) ((r102 * r105) / 1000.0f);
    L11:
        r105 = 0;
        goto L13
    L5:
        r101 = 0.0f;
        goto L6
    }

    public final void c() {
        if (this.f182199f == null) goto L5;
        return;
    L5:
        ViewGroup r100 = (ViewGroup) findViewById(R.id.video_wrapper);
        PlayerBlock r101 = new PlayerBlock(getContext(), null, 0, null, false, false, 510);
        int r102 = com.bytedance.android.shopping.extensions.b.a(30);
        int r103 = com.bytedance.android.shopping.extensions.b.a(36);
        ImageView r104 = r101.f164936a;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.width = r102;
        r105.height = r103;
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutParams(r105);
        if (r100 == null) goto L8;
        r100.addView(r101, 0, new FrameLayout.LayoutParams(-1, -1));
    L8:
        this.f182199f = r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s0.e(this);
    }

    @Subscribe
    public final void onPlaybackPageReturned(ij.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        long r101 = this.f182216w;
        if (r101 <= 0) goto L9;
        float r102 = r100.f490051a;
        if ((r102 - (r101 * ((long) 1000))) <= 0) goto L13;
        PlayerBlock r103 = this.f182199f;
        if (r103 == null) goto L14;
        r103.J(r102);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        PlayerBlock r104 = this.f182199f;
        if (r104 == null) goto L16;
        r104.J(r100.f490051a);
        return;
    }

    public AnchorV4PlaybackAreaV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.A = new fa3.b();
        this.f182207n = -1;
        this.f182208o = -1;
        if (PdpPerfOpt.b().j() == false) goto L5;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.shopping_anchor_v4_replay_entry_layout, this, true);
    L6:
        setRadius(com.bytedance.android.shopping.extensions.b.b(12));
        setElevation(com.bytedance.android.shopping.extensions.b.b(10));
        setMaxCardElevation(com.bytedance.android.shopping.extensions.b.b(10));
        setCardBackgroundColor(0);
        setAlpha(0.99f);
        this.f182194a = findViewById(R.id.replay_entry_top_area);
        this.f182195b = findViewById(R.id.replay_entry_bottom_area);
        this.f182196c = (SimpleDraweeView) findViewById(R.id.top_replay_icon);
        this.f182197d = (LottieAnimationView) findViewById(R.id.top_replay_icon_lottie);
        this.f182198e = findViewById(R.id.video_wrapper);
        if (PdpPerfOpt.e() == true) goto L9;
        c();
    L9:
        this.f182200g = findViewById(R.id.bottom_entry_area);
        this.f182201h = (SimpleDraweeView) findViewById(R.id.bottom_replay_icon);
        this.f182203j = (TextView) findViewById(R.id.bottom_entry_text_new_style);
        this.f182202i = (TextView) findViewById(R.id.bottom_entry_text);
        this.f182205l = findViewById(R.id.view_disappear_lottie_wrapper);
        this.f182204k = (ECLottieAnimationView) findViewById(R.id.view_disappear_lottie);
        this.f182206m = (SimpleDraweeView) findViewById(R.id.video_cover_image);
        setVisibility(4);
        return;
    L5:
        th.a.c(r100, R.layout.shopping_anchor_v4_replay_entry_layout, this, true);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.LifecycleObserver, com.bytedance.android.shopping.prepurchase.business.pdp.view.AnchorV4PlaybackAreaV2$bindData$4] */
    public final void b(final PlayBackEntryVO r110, n73.a r111, final com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.d r112) {
        Intrinsics.checkNotNullParameter(r112, "dependency");
        setVisibility(8);
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.isFloatEntryVisible() == true) goto L8;
        return;
    L8:
        if (r110.isShowLiveIcon() == true) goto L10;
    L12:
        setVisibility(0);
        boolean r100 = r112.e();
        this.f182218y = r100;
        if (r100 == true) goto L15;
    L19:
        this.f182210q = r111;
        setOnClickListener(new com.bytedance.android.shopping.prepurchase.business.pdp.view.a(this, r111, r110, r112));
        ImageModel r101 = r110.getPlayBackIcon();
        LocalImage r102 = null;
        if (r101 == null) goto L22;
        ECUrlModel r103 = r101.getRemote();
    L24:
        if (r103 == null) goto L26;
        y.a(this.f182196c, r110.getPlayBackIcon().getRemote());
    L34:
        this.f182202i.setText(r110.getEntryText());
        this.f182203j.setText(r110.getEntryText());
        y.a(this.f182201h, r110.getBottomPrefixIcon());
        y.a(this.f182206m, r110.getVideoCoverImage());
        ECLottieAnimationView r104 = this.f182204k;
        ImageModel r105 = r110.getLottie();
        if (r105 == null) goto L46;
        LocalImage r106 = r105.getLocal();
        if (r106 == null) goto L46;
        String r107 = r106.getName();
        if (r107 == null) goto L46;
        if (com.bytedance.android.shopping.extensions.k.c(r107) == true) goto L44;
        r107 = null;
    L44:
        if (r107 == null) goto L46;
        r104.setAnimation(r107.concat(InvRouter.FLOW_SUFFIX));
    L46:
        this.f182209p = r110.shouldGoneWithHead();
        Integer r108 = r110.getShowStyle();
        if (r108 != null) goto L50;
    L52:
        boolean r109 = false;
    L53:
        this.f182217x = r109;
        if (r110.showNewStylePlayBackEntry(Boolean.valueOf(r112.isFullScreen())) == false) goto L69;
        Link r113 = r110.getReplayLink();
        if (r113 == null) goto L58;
        String r114 = r113.getLinkUrl();
    L59:
        com.bytedance.android.shopping.anchorv4.video.f r115 = r112.d();
        if (r114 != null) goto L62;
    L65:
        boolean r116 = true;
    L66:
        if (r116 == true) goto L71;
        PlaybackEntryApi.a r117 = PlaybackEntryApi.f166844a;
        PlaybackVideoRequestParams.Companion.getClass();
        PlaybackVideoRequestParams r118 = PlaybackVideoRequestParams.a.a(r114);
        r117.getClass();
        fa3.c.a(bg4.b.b(PlaybackEntryApi.a.a(r118)).subscribe(new d(this, r115), e.f182273a), this);
    L71:
        boolean r119 = r110.showNewStylePlayBackEntry(Boolean.valueOf(r112.isFullScreen()));
        if (r119 == true) goto L85;
        this.f182196c.setVisibility(8);
        this.f182197d.setVisibility(8);
        ImageModel r120 = r110.getPlayBackIcon();
        if (r120 == null) goto L76;
        ECUrlModel r121 = r120.getRemote();
    L77:
        if (r121 == null) goto L79;
        this.f182196c.setVisibility(0);
    L84:
        this.f182202i.setVisibility(0);
        this.f182198e.setVisibility(8);
        this.f182200g.setVisibility(8);
    L87:
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r122 = r112.b();
        int r123 = r112.c();
        int r124 = r122.f180784a;
        Boolean r125 = r110.isHeadAreaLengthened();
        Boolean r126 = Boolean.TRUE;
        if (Intrinsics.areEqual(r125, r126) == false) goto L90;
        int r127 = (r124 * 4) / 3;
    L90:
        int r128 = com.bytedance.android.shopping.extensions.j.a(R.dimen.commerce_anchor_v3_top_area_height);
        if (Intrinsics.areEqual(r110.isHeadHasScrollMore(), r126) == false) goto L93;
        com.bytedance.android.shopping.extensions.b.b(146);
    L93:
        setVisibility(4);
        post(new f(this, r128, r122, r123, r112, r110));
        Function0<Unit> r129 = this.f182219z;
        if (r129 == null) goto L96;
        Unit r130 = r129.invoke();
    L96:
        Lifecycle r131 = r112.getLifecycleOwner().getLifecycleCompat();
        if (r131 == 0) goto L101;
        final ?? r132 = new AnchorV4PlaybackAreaV2$bindData$4(this, r110, r112);
        this.f182219z = new AnchorV4PlaybackAreaV2$bindData$$inlined$apply$lambda$1(r132, this, r112);
        Unit r133 = Unit.INSTANCE;
        r131.addObserver(r132);
        return;
    L101:
        return;
    L79:
        ImageModel r134 = r110.getPlayBackIcon();
        if (r134 == null) goto L82;
        r102 = r134.getLocal();
    L82:
        if (r102 == null) goto L84;
        this.f182197d.setVisibility(0);
        goto L84
    L76:
        r121 = null;
        goto L77
    L85:
        if (r119 != true) goto L87;
        this.f182200g.setVisibility(0);
        this.f182202i.setVisibility(8);
        this.f182198e.setVisibility(0);
        goto L87
    L62:
        if (r114.length() == 0) goto L65;
        r116 = false;
        goto L66
    L58:
        r114 = null;
        goto L59
    L69:
        if (r111 == null) goto L71;
        r111.a(null);
        goto L71
    L50:
        if (r108.intValue() != 0) goto L52;
        r109 = true;
        goto L53
    L26:
        ImageModel r135 = r110.getPlayBackIcon();
        if (r135 == null) goto L29;
        LocalImage r136 = r135.getLocal();
    L30:
        if (r136 == null) goto L34;
        ImageExtensionsKt.e(this.f182197d, r110.getPlayBackIcon());
        Object r137 = this.f182197d.getTag();
        Boolean r138 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r137, r138)) == false) goto L34;
        this.f182197d.setTag(r138);
        this.f182197d.addOnAttachStateChangeListener(new b(this));
        goto L34
    L29:
        r136 = null;
        goto L30
    L22:
        r103 = null;
        goto L24
    L15:
        if (r112.isFullScreen() == true) goto L19;
        if (r112.f() == true) goto L19;
        setAlpha(0.0f);
        goto L19
    L10:
        if (r112.a() == false) goto L12;
    }

    public /* synthetic */ AnchorV4PlaybackAreaV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final int a(AnchorV4PlaybackAreaV2 r100, int r101, int r102, float r103) {
        r100.getClass();
        return (int) (r101 + ((r102 - r101) * r103));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = this.f182207n;
        if (r105 < 0) goto L9;
        int r106 = this.f182208o;
        if (r106 < 0) goto L9;
        if (r105 != r101) goto L8;
        if (r106 == r102) goto L9;
    L8:
        layout(r105, r106, (r103 - r101) + r105, (r104 - r102) + r106);
        return;
    L9:
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
