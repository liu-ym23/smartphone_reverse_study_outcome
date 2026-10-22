package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import android.animation.Animator;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.drawable.ScalingUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e*\u0001,\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001iJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u001c\u0010\u0011\u001a\u00020\u00062\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010-\u001a\u0004\b\u0019\u0010.RE\u0010:\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000600¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R:\u0010C\u001a\n\u0012\u0004\u0012\u00020;\u0018\u0001002\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u0001008\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010K\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010S\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010Z\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010U\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR$\u0010e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0017\u0010h\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bf\u0010U\u001a\u0004\bg\u0010W¨\u0006j"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayerBlock;", "Landroid/widget/FrameLayout;", "Lfj/e;", "Ll53/a;", "", ITTVideoEngineEventSource.KEY_MUTE, "", "setIsMute", "Landroid/view/ViewGroup;", "getPlayerContainer", "", "getFromEntrance", "getExpandMode", "info", "setIndicatorInfo", "Lkotlin/Function1;", "listener", "setPlayBlockClickListener", "Lvg3/c;", "collisionNegotiator", "setCollisionNegotiator", "forbidPlay", "setForbidPlay", "getCompleteMode", "Lx73/c;", "getSharePlayer", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/b;", "getVideoModel", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/d;", "B", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/d;", "getDetachHandler", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/d;", "setDetachHandler", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/d;)V", "detachHandler", "", "C", FaceService.girlLabel, "getPlayProgress", "()F", "setPlayProgress", "(F)V", "playProgress", "com/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayerBlock$sharePlayer$2$1", "Lkotlin/Lazy;", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayerBlock$sharePlayer$2$1;", "sharePlayer", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "videoPlay", "I", "Lkotlin/jvm/functions/Function1;", "getClick2PlayInterceptor", "()Lkotlin/jvm/functions/Function1;", "setClick2PlayInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "click2PlayInterceptor", "", "value", "J", "Lkotlin/jvm/functions/Function0;", "getVideoExtraHeightProvider", "()Lkotlin/jvm/functions/Function0;", "setVideoExtraHeightProvider", "(Lkotlin/jvm/functions/Function0;)V", "videoExtraHeightProvider", "Lc63/c;", "N", "Lc63/c;", "getLogAction", "()Lc63/c;", "setLogAction", "(Lc63/c;)V", "logAction", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/a;", "O", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/a;", "getAudioInterceptor", "()Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/a;", "setAudioInterceptor", "(Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/a;)V", "audioInterceptor", "P", "Z", "getV4Head", "()Z", "setV4Head", "(Z)V", "v4Head", "Q", "getOptPlayer", "setOptPlayer", "optPlayer", "R", "Ljava/lang/String;", "getVideoType", "()Ljava/lang/String;", "setVideoType", "(Ljava/lang/String;)V", "videoType", ExifInterface.LATITUDE_SOUTH, "getDisableCoverHideAnim", "disableCoverHideAnim", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerBlock extends FrameLayout implements fj.e, l53.a {
    public static final /* synthetic */ int T = 0;
    public boolean A;
    public d B;
    public float C;
    public k D;
    public Boolean E;
    public final Lazy F;
    public boolean G;
    public boolean H;
    public Function1<? super Function0<Unit>, Unit> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Function0<Integer> f164935J;
    public boolean K;
    public Function0<Unit> L;
    public Boolean M;
    public c63.c N;
    public com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.a O;
    public boolean P;
    public boolean Q;
    public String R;
    public final boolean S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f164936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECStatusView f164937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECDraweeView f164938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECDraweeView f164939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f164940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gj.b f164941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AVScene f164942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ECUrlModel f164943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f164944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f164945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f164946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f164947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f164948m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f164949n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f164950o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set<o> f164951p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b f164952q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f164953r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f164954s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public vg3.c f164955t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f164956u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f164957v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f164958w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<Function1<Boolean, Unit>> f164959x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<e> f164960y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PlayerViewScene f164961z;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PlayerBlock f164962a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        public b(PlayerBlock r100) {
            this.f164962a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f164962a.f164938c.setVisibility(4);
        }
    }

    static {
    }

    public PlayerBlock(Context r100) {
        this(r100, null, 0, null, false, false, 510);
    }

    public PlayerBlock(Context r100, AttributeSet r110) {
        this(r100, r110, 0, null, false, false, 508);
    }

    public PlayerBlock(Context r100, AttributeSet r110, int r111) {
        this(r100, r110, r111, null, false, false, 504);
    }

    private final PlayerBlock$sharePlayer$2.AnonymousClass1 getSharePlayer() {
        return (PlayerBlock$sharePlayer$2.AnonymousClass1) this.F.getValue();
    }

    public final void E() {
        K(false);
        gj.b r100 = this.f164941f;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    @Override // l53.a
    public final void a() {
        F(true);
    }

    @Override // l53.a
    public final void b() {
        setIsMute(true);
    }

    @Override // fj.e
    public final void B0() {
        c63.c r100 = this.N;
        if (r100 == null) goto L5;
        r100.c(this.f164952q, null);
    L5:
        com.bytedance.android.ec.sdk.helper.i.f48124a.e(getContext(), com.bytedance.android.shopping.extensions.j.c(R.string.shopping_player_block_fail_hint), false, false);
    }

    @Override // fj.e
    public final void H() {
        k r100 = this.D;
        if (r100 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r101 = r100.f167580d;
        if (r101 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r101, r100, false, 6);
    L7:
        this.f164936a.setVisibility(8);
        this.f164953r = SystemClock.elapsedRealtime();
        G(false);
        I(true);
        Iterator r102 = ((ArrayList) this.f164960y).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((e) r102.next()).S();
        goto L9
    }

    @Override // fj.e
    public final void Z2() {
        k r100 = this.D;
        if (r100 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f r101 = r100.f167580d;
        if (r101 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.video.f.a.b(r101, r100, false, 6);
    L7:
        this.f164936a.setVisibility(8);
        G(false);
        this.f164953r = SystemClock.elapsedRealtime();
        I(true);
        Iterator r102 = ((ArrayList) this.f164960y).iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((e) r102.next()).U();
        goto L9
    }

    public final String getFromEntrance() {
        if (this.f164945j == false) goto L5;
        return com.bytedance.android.ec.core.event.a.VALUE_BIG_PICTURE;
    L5:
        return com.bytedance.android.ec.core.event.a.VALUE_MAIN_PICTURE;
    }

    @Override // l53.a
    public final boolean isPlaying() {
        gj.b r100 = this.f164941f;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isPlaying() != true) goto L7;
        return true;
    }

    public final long s() {
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100 = this.f164952q;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.a();
    }

    public final boolean t() {
        vg3.c r100 = this.f164955t;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.d() != true) goto L7;
        return true;
    }

    public final boolean v() {
        Lazy r100 = ECSettingKeys.f43616a;
        int r101 = com.bytedance.android.ec.base.settings.b.f42814a;
        int r102 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r103 = com.bytedance.android.ec.core.abtest.e.a(2, 0);
        View r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L164
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L164
        SDKSettingsCacheManager r106 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L164
        r106.getClass();     // Catch: Throwable -> L55
        Object r107 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_video_preload_opt");     // Catch: Throwable -> L55
        if (r107 != null) goto L10;
    L52:
        Object r108 = null;
    L53:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L55
    L57:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L164
        if (r110 == null) goto L61;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L164
    L61:
        if (Result.m9455isFailureimpl(r109) == false) goto L64;
        r109 = null;
    L64:
        if ((r109 instanceof Integer) == true) goto L66;
        r109 = null;
    L66:
        Object r111 = (Integer) r109;     // Catch: Throwable -> L164
        if (r111 != null) goto L73;
        r106.getClass();     // Catch: Throwable -> L164
        Object r112 = SDKSettingsCacheManager.f42808a.get("iesec_pdp_video_preload_opt");     // Catch: Throwable -> L164
        if ((r112 instanceof Integer) == true) goto L72;
        r112 = null;
    L72:
        r111 = (Integer) r112;     // Catch: Throwable -> L164
    L73:
        if (r111 != null) goto L174;
        int r113 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L164
    L151:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L164
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L164
    L154:
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L192;
    L161:
        r111 = r115;
    L162:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L164
        SDKSettingsCacheManager.e("iesec_pdp_video_preload_opt", r111);     // Catch: Throwable -> L164
        goto L174
    L192:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_pdp_video_preload_opt", Integer.class, r103);     // Catch: Throwable -> L158
    L159:
        if (r115 != null) goto L161;
        r111 = r103;
    L158:
        r115 = r103;
        goto L159
    L186:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L126
        Object r116 = SDKSettingsCacheManager.f42809b.get("iesec_pdp_video_preload_opt");     // Catch: Throwable -> L126
        if (r116 != null) goto L81;
    L123:
        Object r117 = null;
    L124:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L126
    L128:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L151
        if (r119 == null) goto L132;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L151
    L132:
        if (Result.m9455isFailureimpl(r118) == false) goto L135;
        r118 = null;
    L135:
        if ((r118 instanceof Integer) == true) goto L137;
        r118 = null;
    L137:
        r115 = (Integer) r118;     // Catch: Throwable -> L151
        if (r115 != null) goto L161;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L151
        Object r121 = jj4.a.a("iesec_pdp_video_preload_opt", Integer.class, r103, false);     // Catch: Throwable -> L151
        if (r121 != null) goto L144;
        Intrinsics.throwNpe();     // Catch: Throwable -> L151
    L144:
        if ((r121 instanceof Integer) == true) goto L146;
        r121 = null;
    L146:
        Object r122 = (Integer) r121;     // Catch: Throwable -> L151
        if (r122 != null) goto L149;
        r122 = r103;
    L149:
        r115 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L151
    L81:
        if ((r116 instanceof Integer) == true) goto L83;
        Object r123 = null;
    L84:
        r117 = (Integer) r123;     // Catch: Throwable -> L126
        if (r117 != null) goto L124;
        if ((r116 instanceof Number) == false) goto L111;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L126
        if ((r124 instanceof Integer) == true) goto L94;
        r124 = null;
    L94:
        r117 = (Integer) r124;     // Catch: Throwable -> L126
        goto L124
    L96:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L126
        if ((r125 instanceof Integer) == true) goto L100;
        r125 = null;
    L100:
        r117 = (Integer) r125;     // Catch: Throwable -> L126
        goto L124
    L102:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L105;
        r117 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L126
        goto L124
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L111;
        Long r126 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L126
        if ((r126 instanceof Integer) == true) goto L109;
        r126 = null;
    L109:
        r117 = (Integer) r126;     // Catch: Throwable -> L126
    L111:
        if ((r116 instanceof JSONObject) == false) goto L113;
    L182:
        Object r127 = SDKSettingsCacheManager.a().fromJson(r116.toString(), Integer.class);     // Catch: Throwable -> L119
        if ((r127 instanceof Integer) == true) goto L117;
        r127 = null;
    L117:
        Object r128 = Result.m9449constructorimpl((Integer) r127);     // Catch: Throwable -> L119
    L121:
        r117 = r128;
        if (Result.m9455isFailureimpl(r117) == false) goto L124;
    L119:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L126
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L126
        goto L121
    L113:
        if ((r116 instanceof JSONArray) == false) goto L123;
    L83:
        r123 = r116;
    L126:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L151
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L151
    L174:
        if (((Number) r111).intValue() != 2) goto L196;
        gj.b r131 = this.f164941f;
        if (r131 == null) goto L179;
        r104 = r131.getView();
    L179:
        if ((r104 instanceof ECVideoPlayerView) == false) goto L197;
        return true;
    L197:
        return false;
    L196:
        return false;
    L10:
        if ((r107 instanceof Integer) == true) goto L12;
        Object r132 = null;
    L13:
        r108 = (Integer) r132;     // Catch: Throwable -> L55
        if (r108 != null) goto L53;
        if ((r107 instanceof Number) == false) goto L40;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r133 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L55
        if ((r133 instanceof Integer) == true) goto L23;
        r133 = null;
    L23:
        r108 = (Integer) r133;     // Catch: Throwable -> L55
        goto L53
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r134 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L55
        if ((r134 instanceof Integer) == true) goto L29;
        r134 = null;
    L29:
        r108 = (Integer) r134;     // Catch: Throwable -> L55
        goto L53
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L34;
        r108 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L55
        goto L53
    L34:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L40;
        Long r135 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L55
        if ((r135 instanceof Integer) == true) goto L38;
        r135 = null;
    L38:
        r108 = (Integer) r135;     // Catch: Throwable -> L55
    L40:
        if ((r107 instanceof JSONObject) == false) goto L42;
    L190:
        Object r136 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Integer.class);     // Catch: Throwable -> L48
        if ((r136 instanceof Integer) == true) goto L46;
        r136 = null;
    L46:
        Object r137 = Result.m9449constructorimpl((Integer) r136);     // Catch: Throwable -> L48
    L50:
        r108 = r137;
        if (Result.m9455isFailureimpl(r108) == false) goto L53;
    L48:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L55
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L55
        goto L50
    L42:
        if ((r107 instanceof JSONArray) == false) goto L52;
    L12:
        r132 = r107;
    L55:
        th = move-exception;
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L164
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L164
    L164:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        Object r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r142 = Result.m9452exceptionOrNullimpl(r141);
        if (r142 == null) goto L169;
        EnsureManager.ensureNotReachHere(r142);
    L169:
        if (Result.m9455isFailureimpl(r141) == true) goto L172;
        r103 = r141;
    L172:
        r111 = r103;
        goto L174
    }

    public final boolean w() {
        gj.b r100 = this.f164941f;
        if ((r100 instanceof i) == true) goto L5;
        r100 = null;
    L5:
        i r101 = (i) r100;
        if (r101 == null) goto L12;
        com.bytedance.android.shopping.api.video.d r102 = r101.f164982b;
        if (r102 == null) goto L12;
        if (r102.f170642b != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final void B() {
        long r100 = SystemClock.elapsedRealtime();
        c63.c r101 = this.N;
        if (r101 == null) goto L5;
        r101.E(r100 - this.f164953r, getFromEntrance());
    L5:
        this.f164953r = r100;
        gj.b r102 = this.f164941f;
        if (r102 == null) goto L8;
        r102.release();
    L8:
        z73.a<String, gj.b> r103 = PlayAbilityUtil.f164933a;
        PlayAbilityUtil.f164933a.f570646a.clear();
    }

    @Override // fj.e
    public final void R2() {
        if (w() == false) goto L5;
        return;
    L5:
        postDelayed(new m(this), 100);
        G(true);
        K(false);
        I(false);
    }

    @Override // fj.e
    public final void e() {
        if (w() == false) goto L5;
        return;
    L5:
        postDelayed(new l(this), 100);
        G(true);
        K(false);
        I(false);
        k r100 = this.D;
        if (r100 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f r101 = r100.f167580d;
        if (r101 == null) goto L10;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r101, r100, false, false, 6);
    L10:
        Iterator r102 = ((ArrayList) this.f164960y).iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((e) r102.next()).g();
        goto L12
    L14:
        this.E = null;
    }

    /* JADX INFO: renamed from: getSharePlayer, reason: collision with other method in class */
    public final x73.c m8282getSharePlayer() {
        return getSharePlayer();
    }

    public final void j() {
        if (v() == false) goto L7;
        gj.b r100 = this.f164941f;
        if (r100 == null) goto L10;
        r100.play();
    L10:
        this.f164948m = false;
        A(true, true);
        K(true);
        vg3.c r101 = this.f164955t;
        if (r101 == null) goto L14;
        r101.a(this);
        return;
    L14:
        return;
    L7:
        gj.b r102 = this.f164941f;
        if (r102 == null) goto L10;
        r102.C();
        goto L10
    }

    public final void x() {
        if (isPlaying() == false) goto L8;
        c63.c r100 = this.N;
        if (r100 == null) goto L9;
        r100.u(getFromEntrance());
        return;
    L9:
        return;
    }

    @Override // l53.a
    public final boolean c() {
        return this.f164950o;
    }

    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.a getAudioInterceptor() {
        return this.O;
    }

    public final Function1<Function0<Unit>, Unit> getClick2PlayInterceptor() {
        return this.I;
    }

    public final boolean getCompleteMode() {
        return this.f164946k;
    }

    public final d getDetachHandler() {
        return this.B;
    }

    public final boolean getDisableCoverHideAnim() {
        return this.S;
    }

    public final boolean getExpandMode() {
        return this.f164945j;
    }

    public final c63.c getLogAction() {
        return this.N;
    }

    public final boolean getOptPlayer() {
        return this.Q;
    }

    public final float getPlayProgress() {
        return this.C;
    }

    public final ViewGroup getPlayerContainer() {
        return this.f164940e;
    }

    public final boolean getV4Head() {
        return this.P;
    }

    public final Function0<Integer> getVideoExtraHeightProvider() {
        return this.f164935J;
    }

    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b getVideoModel() {
        return this.f164952q;
    }

    public final String getVideoType() {
        return this.R;
    }

    public static final void f(PlayerBlock r100) {
        gj.b r101 = r100.f164941f;
        if (r101 != null) goto L5;
    L6:
        r100.n(true, Boolean.TRUE);
    L7:
        gj.b r102 = r100.f164941f;
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        Iterator<T> r104 = r100.f164951p.iterator();
    L15:
        if (r104.hasNext() == false) goto L17;
        ((o) r104.next()).W(r103);
        goto L15
    L17:
        gj.b r105 = r100.f164941f;
        if (r105 != null) goto L20;
        return;
    L20:
        if (r105.isPlaying() != true) goto L25;
        r100.Z2();
        return;
    L25:
        return;
    L10:
        if (r102.isPlaying() != true) goto L12;
        r103 = true;
        goto L13
    L5:
        if (r101.isMute() == r100.f164950o) goto L7;
        goto L6
    }

    private final void setIsMute(boolean r100) {
        this.f164950o = r100;
        gj.b r101 = this.f164941f;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        boolean r102 = this.f164950o;
        Iterator<T> r103 = this.f164951p.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((o) r103.next()).V(r102);
        goto L7
    }

    public final void C(boolean r100) {
        gj.b r101 = this.f164941f;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isPlaying() != true) goto L7;
    L8:
        x();
        gj.b r103 = this.f164941f;
        if (r103 == null) goto L11;
        r103.pause();
    L11:
        if (r100 == false) goto L19;
        if (r102 == false) goto L20;
        k r104 = this.D;
        if (r104 == null) goto L21;
        com.bytedance.android.shopping.anchorv4.video.f r105 = r104.f167580d;
        if (r105 == null) goto L22;
        r105.a(r104);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void F(boolean r100) {
        gj.b r101 = this.f164941f;
        if (r101 == null) goto L5;
        r101.pause();
    L5:
        this.G = r100;
    }

    public final void G(boolean r100) {
        if (this.f164946k != r100) goto L6;
        return;
    L6:
        if (r100 == false) goto L15;
        this.f164940e.setAlpha(0.0f);
        if (this.f164958w == true) goto L10;
    L14:
        this.f164938c.setVisibility(0);
        this.f164938c.setAlpha(1.0f);
    L20:
        this.f164946k = r100;
        return;
    L10:
        if (this.f164945j == true) goto L14;
        if (this.Q == true) goto L14;
        this.f164939d.setVisibility(0);
        goto L20
    L15:
        this.f164940e.setAlpha(1.0f);
        if (this.S == false) goto L18;
        this.f164938c.setVisibility(4);
    L19:
        this.f164939d.setVisibility(8);
        goto L20
    L18:
        ViewPropertyAnimator r101 = this.f164938c.animate().alpha(0.0f);
        r101.setDuration(300);
        r101.setListener(new b(this));
        r101.start();
        goto L19
    }

    public final void I(boolean r100) {
        Iterator<T> r101 = this.f164951p.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((o) r101.next()).R(r100);
        goto L4
    }

    public final void J(float r100) {
        gj.b r101 = this.f164941f;
        if (r101 == null) goto L5;
        r101.seek(r100 / 100.0f);
    L5:
        c63.c r102 = this.N;
        if (r102 == null) goto L16;
        String r103 = getFromEntrance();
        String r104 = this.R;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r105 = this.f164952q;
        if (r105 == null) goto L13;
        String r106 = r105.j();
    L14:
        r102.e(r103, r104, r106);
        return;
    L13:
        r106 = null;
        goto L14
    }

    public final void K(boolean r100) {
        if (t() == false) goto L6;
        return;
    L6:
        if (y0.a() == true) goto L9;
        return;
    L9:
        if (this.f164945j == false) goto L11;
        return;
    L11:
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L17;
        com.bytedance.android.ec.adapter.api.j r103 = r102.getLiveWindowService();
        if (r103 == null) goto L18;
        r103.toggleLiveAudio(r100);
        return;
    L18:
        return;
    }

    @Override // fj.e
    public final void Q(float r100) {
        this.C = r100;
        Iterator<T> r101 = this.f164951p.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((o) r101.next()).Q(r100);
        goto L4
    }

    public final void g(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f164959x).contains(r100) == true) goto L6;
        ((ArrayList) this.f164959x).add(r100);
        return;
    }

    public final void h(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f164960y).contains(r100) == true) goto L5;
        ((ArrayList) this.f164960y).add(r100);
    L5:
        r(r100);
    }

    public final void i(o r100) {
        Intrinsics.checkNotNullParameter(r100, "reporter");
        if (this.f164951p.contains(r100) == true) goto L6;
        this.f164951p.add(r100);
        return;
    }

    @Override // fj.e
    public final void m3(boolean r100) {
        long r101 = SystemClock.elapsedRealtime();
        c63.c r102 = this.N;
        if (r102 == null) goto L5;
        r102.E(r101 - this.f164953r, getFromEntrance());
    L5:
        this.f164953r = r101;
        this.f164936a.setVisibility(0);
        Iterator r103 = ((ArrayList) this.f164960y).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((e) r103.next()).onPausePlay();
        goto L7
    L9:
        k r104 = this.D;
        if (r104 == null) goto L14;
        com.bytedance.android.shopping.anchorv4.video.f r105 = r104.f167580d;
        if (r105 == null) goto L14;
        com.bytedance.android.shopping.anchorv4.video.f.a.a(r105, r104, this.G, false, 4);
    L14:
        this.G = true;
    }

    public final void p(boolean r100) {
        this.f164945j = r100;
        Iterator<T> r101 = this.f164959x.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Function1) r101.next()).invoke(Boolean.valueOf(r100));
        goto L4
    }

    public final void r(e r100) {
        if (this.H == false) goto L12;
        if (r100 != null) goto L9;
        Iterator<T> r101 = this.f164960y.iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        ((e) r101.next()).T();
        goto L7
    L13:
        return;
    L9:
        r100.T();
        return;
    }

    public final void setAudioInterceptor(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.a r100) {
        this.O = r100;
    }

    public final void setClick2PlayInterceptor(Function1<? super Function0<Unit>, Unit> r100) {
        this.I = r100;
    }

    public final void setCollisionNegotiator(vg3.c r100) {
        this.f164955t = r100;
        if (r100 == null) goto L6;
        r100.b(this);
        return;
    }

    public final void setDetachHandler(d r100) {
        this.B = r100;
    }

    public final void setForbidPlay(boolean r100) {
        this.f164956u = r100;
    }

    public final void setIndicatorInfo(String r100) {
        this.f164957v = r100;
    }

    public final void setLogAction(c63.c r100) {
        this.N = r100;
    }

    public final void setOptPlayer(boolean r100) {
        this.Q = r100;
    }

    public final void setPlayBlockClickListener(Function1<? super Boolean, Unit> r100) {
        this.f164954s = r100;
    }

    public final void setPlayProgress(float r100) {
        this.C = r100;
    }

    public final void setV4Head(boolean r100) {
        this.P = r100;
    }

    public final void setVideoExtraHeightProvider(Function0<Integer> r100) {
        this.f164935J = r100;
        requestLayout();
    }

    public final void setVideoType(String r100) {
        this.R = r100;
    }

    @Override // fj.e
    public final void y(boolean r100) {
        if (r100 == false) goto L4;
        this.f164937b.c();
        return;
    L4:
        this.f164937b.a();
    }

    public static final void d(PlayerBlock r100, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r101) {
        if (r100.A == false) goto L39;
        Function1<? super Boolean, Unit> r102 = r100.f164954s;
        if (r102 == null) goto L9;
        Unit r103 = r102.invoke(Boolean.valueOf(r100.isPlaying()));
    L9:
        if (r100.f164956u == true) goto L40;
        c63.c r104 = r100.N;
        if (r104 == null) goto L15;
        String r105 = r100.f164957v;
        int r106 = com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.f164968f;
        r104.B(r105, r101.k(null), r101.h());
    L15:
        if (r100.isPlaying() == false) goto L23;
        if (r100.f164945j == false) goto L19;
        r100.x();
        r100.E();
        return;
    L19:
        Function0<Unit> r107 = r100.f164944i;
        if (r107 == null) goto L37;
        Unit r108 = r107.invoke();
        return;
    L37:
        return;
    L23:
        if (r100.t() == false) goto L25;
    L34:
        r100.j();
        z(r100, true, false, null, 6);
        return;
    L25:
        if (r100.f164948m == false) goto L34;
        k r109 = r100.D;
        if (r109 == null) goto L31;
        com.bytedance.android.shopping.anchorv4.video.f r110 = r109.f167580d;
        if (r110 == null) goto L31;
        boolean r111 = r110.h(r109);
    L32:
        if (r111 == false) goto L34;
        o(r100, false, 2);
    L31:
        r111 = false;
        goto L32
    L40:
        return;
    }

    public final void A(boolean r100, boolean r101) {
        if (this.f164950o == false) goto L5;
        return;
    L5:
        if (r100 == true) goto L11;
        gj.b r102 = this.f164941f;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isPlaying() == true) goto L11;
        return;
    L11:
        if (r101 == false) goto L15;
        vg3.c r103 = this.f164955t;
        if (r103 == null) goto L20;
        r103.c(this);
        return;
    L20:
        return;
    L15:
        vg3.c r104 = this.f164955t;
        if (r104 == null) goto L22;
        r104.e(this);
        return;
    }

    public final void k(Boolean r100, Boolean r101) {
        ImageView r102 = this.f164936a;
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r103) == false) goto L5;
        int r104 = 8;
    L6:
        r102.setVisibility(r104);
        this.E = r101;
        setIsMute(Intrinsics.areEqual(r101, r103));
        j();
        z(this, false, false, null, 7);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public final void n(boolean r100, Boolean r101) {
        boolean r102 = !this.f164950o;
        this.f164950o = r102;
        gj.b r103 = this.f164941f;
        if (r103 == null) goto L5;
        r103.a(r102);
    L5:
        A(false, false);
        boolean r104 = this.f164950o;
        Iterator<T> r105 = this.f164951p.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        ((o) r105.next()).V(r104);
        goto L7
    L9:
        if (r100 == false) goto L13;
        c63.c r106 = this.N;
        if (r106 == null) goto L13;
        r106.K(this.f164950o);
    L13:
        k r107 = this.D;
        if (r107 == null) goto L20;
        boolean r108 = this.f164950o;
        if (r101 == null) goto L18;
        r100 = r101.booleanValue();
    L18:
        r107.n(r108, r100);
    L20:
        if (this.f164950o == true) goto L24;
        K(true);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        Function0<Integer> r102 = this.f164935J;
        if (r102 == null) goto L15;
        if (r102 == null) goto L8;
        Integer r103 = r102.invoke();
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        int r105 = View.MeasureSpec.getSize(r101);
        int r106 = View.MeasureSpec.getSize(r100);
        FrameLayout r107 = this.f164940e;
        r107.getLayoutParams().width = r106;
        int r108 = r105 + r104;
        r107.getLayoutParams().height = r108;
        ViewGroup.LayoutParams r109 = r107.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r109 = null;
    L12:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        if (r110 == null) goto L18;
        r110.topMargin = -r104;
    L18:
        super.onMeasure(r100, r101);
        return;
    L8:
        r104 = 0;
        goto L9
    L15:
        ViewGroup.LayoutParams r111 = this.f164940e.getLayoutParams();
        if (r111 == null) goto L18;
        r111.width = -1;
        r111.height = -1;
        goto L18
    }

    public final void u(com.bytedance.android.shopping.anchorv4.video.f r100, f r101) {
        Intrinsics.checkNotNullParameter("head_video", "scene");
        Intrinsics.checkNotNullParameter(r100, "playerStateManager");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (this.D != null) goto L6;
        k r102 = new k(this, r101, r100, r100);
        r100.c(r102);
        Unit r103 = Unit.INSTANCE;
        this.D = r102;
        return;
    }

    public static /* synthetic */ void l(PlayerBlock r100, Boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r101 = Boolean.FALSE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        Boolean r103 = Boolean.TRUE;
    L9:
        r100.k(r101, r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public static /* synthetic */ void o(PlayerBlock r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        r101 = true;
    L5:
        r100.n(r101, null);
    }

    public final void D(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L4;
        String r103 = "video";
    L6:
        if (Intrinsics.areEqual(this.f164949n, r103) == false) goto L8;
        return;
    L8:
        this.f164949n = r103;
        boolean r104 = false;
        if (r100 == false) goto L19;
        if (this.f164948m == false) goto L14;
        return;
    L14:
        if (this.f164947l == false) goto L17;
        if (r102 == true) goto L17;
        j();
        z(this, false, !r101, null, 5);
    L17:
        this.M = null;
        return;
    L19:
        if (this.f164948m == true) goto L29;
        Boolean r105 = this.M;
        if (r105 == null) goto L23;
        r104 = r105.booleanValue();
    L28:
        this.f164947l = r104;
        goto L29
    L23:
        gj.b r106 = this.f164941f;
        if (r106 == null) goto L28;
        if (r106.isPlaying() != true) goto L28;
        r104 = true;
    L29:
        E();
        x();
        return;
    L4:
        r103 = "picture";
        goto L6
    }

    public final void q(boolean r100, Integer r101, Integer r102) {
        this.P = r100;
        if (r100 == false) goto L12;
        if (r101 == null) goto L6;
        int r103 = r101.intValue();
    L7:
        if (r102 == null) goto L9;
        int r104 = r102.intValue();
    L10:
        this.f164936a.setBackgroundResource(r104);
        ImageView r105 = this.f164936a;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.width = r103;
        r106.height = r103;
        Unit r107 = Unit.INSTANCE;
        r105.setLayoutParams(r106);
        return;
    L9:
        r104 = R.drawable.ec_shopping_anchor_v4_play_icon;
        goto L10
    L6:
        r103 = com.bytedance.android.shopping.extensions.b.b(79);
        goto L7
    }

    public static void z(PlayerBlock r100, boolean r101, boolean r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r110 = false;
    L8:
        String r102 = null;
        if ((r112 & 4) == 0) goto L11;
        r111 = null;
    L11:
        r100.getClass();
        if (r101 == false) goto L15;
        String r103 = DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON;
    L14:
        String r104 = r103;
        c63.c r105 = r100.N;
        if (r105 == null) goto L38;
        if (r111 != null) goto L22;
        r111 = r100.getFromEntrance();
    L22:
        String r106 = r111;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r107 = r100.f164952q;
        if (r107 == null) goto L25;
        int r113 = com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.f164968f;
        String r108 = r107.k(null);
    L26:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r109 = r100.f164952q;
        if (r109 == null) goto L29;
        Integer r114 = r109.h();
    L30:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r115 = r100.f164952q;
        if (r115 == null) goto L33;
        String r116 = r115.f164969a;
    L34:
        if (r115 == null) goto L36;
        r102 = r115.j();
    L36:
        r105.x(r106, r104, r108, r114, r116, r102);
        return;
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r108 = null;
        goto L26
    L38:
        return;
    L15:
        if (r110 == false) goto L17;
        r103 = "click_tab";
        goto L14
    L17:
        r103 = "auto";
        goto L14
    }

    public PlayerBlock(Context r100, AttributeSet r101, int r102, c63.c r103, boolean r104, boolean r105, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 64) == 0) goto L15;
        r104 = false;
    L15:
        if ((r110 & 256) == 0) goto L17;
        r105 = false;
    L17:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.N = r103;
        this.O = null;
        this.P = false;
        this.Q = r104;
        this.R = null;
        this.S = r105;
        this.f164942g = AVScene.CONTENT_DEFAULT;
        this.f164946k = true;
        this.f164947l = true;
        this.f164948m = true;
        this.f164949n = "unknown";
        this.f164951p = new LinkedHashSet();
        this.f164953r = -1;
        this.f164959x = new ArrayList();
        this.f164960y = new ArrayList();
        this.f164961z = PlayerViewScene.SCENE_OTHERS;
        this.A = true;
        this.F = LazyKt.lazy(new PlayerBlock$sharePlayer$2(this));
        this.G = true;
        this.K = true;
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_anchor_v3_video_player_block, this);
        ImageView r106 = (ImageView) findViewById(R.id.video_play_button);
        this.f164936a = r106;
        ECDraweeView r107 = (ECDraweeView) findViewById(R.id.background_shadow_image);
        this.f164938c = r107;
        this.f164939d = (ECDraweeView) findViewById(R.id.blur_background_shadow_image);
        this.f164940e = (FrameLayout) findViewById(R.id.video_area_placeholder);
        ECStatusView r108 = (ECStatusView) findViewById(R.id.load_status_icon);
        this.f164937b = r108;
        r108.b(r100, null, null);
        r106.setVisibility(0);
        if (this.Q == false) goto L21;
        r107.setAdjustMode(0);
        ViewGroup.LayoutParams r109 = r107.getLayoutParams();
        r109.width = -1;
        r109.height = -1;
        Unit r111 = Unit.INSTANCE;
        r107.setLayoutParams(r109);
        r107.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        return;
    }

    public static void m(final PlayerBlock r210, final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r211, ECUrlModel r212, boolean r213, AVScene r214, com.bytedance.android.shopping.api.video.d r310, Function0 r311, int r312) {
        if ((r312 & 4) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r312 & 8) == 0) goto L9;
        AVScene r101 = AVScene.CONTENT_DEFAULT;
    L11:
        if ((r312 & 16) == 0) goto L13;
        com.bytedance.android.shopping.api.video.d r102 = new com.bytedance.android.shopping.api.video.d(false, false, 0, 0, false, 511);
    L14:
        List<String> r103 = null;
        if ((r312 & 32) == 0) goto L17;
        final Function0 r110 = null;
    L18:
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "playerOptions");
        r210.f164952q = r211;
        r210.f164943h = r212;
        r210.f164942g = r101;
        r210.f164958w = r100;
        if (r100 == false) goto L21;
        r210.f164938c.setVisibility(8);
    L21:
        if (r211 == null) goto L33;
        r210.f164952q = r211;
        if (ECSettingKeys.E0() <= 0) goto L27;
        gj.b r104 = r210.f164941f;
        if (r104 == null) goto L27;
        r104.f0(r211, r102);
    L27:
        z73.a<String, gj.b> r105 = PlayAbilityUtil.f164933a;
        final gj.b r106 = PlayAbilityUtil.d(r211, r210.f164940e, r210.f164961z, r210.f164942g, r102, PlayAbilityCacheScene.SCENE_PLAYER_BLOCK);
        r210.f164941f = r106;
        if (r106 == null) goto L33;
        r106.A(r210);
        if (r210.v() == false) goto L32;
        r210.post(new n(r210));
    L32:
        r210.setOnClickListener(new PlayerBlock$prepare$$inlined$apply$lambda$2(r106, r210, r211));
    L33:
        if (r212 == null) goto L35;
        List<String> r111 = r212.getUrlList();
    L36:
        if (r111 != null) goto L38;
    L40:
        ECDraweeView r107 = r210.f164938c;
        ECUrlModel r108 = r210.f164943h;
        if (r108 == null) goto L43;
        r103 = r108.getUrlList();
    L43:
        y.c(r107, r108, -1, -1, new z53.a(r103, ImagePosition.GOODS_HEADER.getValue(), new PlayerBlock$bindVideoAndImageModel$5(r210, r110), false, 24));
        return;
    L38:
        if ((!r111.isEmpty()) != true) goto L40;
        ImageExtensionsKt.x(r210.f164938c, r111, null, null, null, null, null, null, new j(r111, r110, r111, ImagePosition.GOODS_HEADER.getValue(), new PlayerBlock$bindVideoAndImageModel$3(r210, r110)), false, null, PlayerBlock$bindVideoAndImageModel$4.INSTANCE, null, 7038);
        return;
    L35:
        r111 = null;
        goto L36
    L17:
        r110 = r311;
        goto L18
    L13:
        r102 = r310;
        goto L14
    L9:
        r101 = r214;
        goto L11
    L5:
        r100 = r213;
        goto L7
    }
}
