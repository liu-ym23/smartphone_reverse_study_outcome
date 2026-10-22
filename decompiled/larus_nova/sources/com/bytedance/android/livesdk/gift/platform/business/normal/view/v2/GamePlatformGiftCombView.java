package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.f0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.utils.GiftImageFormat;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GamePlatformGiftCombView;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/BaseNormalGiftCombView;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "msg", "", "setGiftMessageAndDuration", "", "showCombo", "setShowCombo", "", "orientation", "setRoomOrientation", "Ls02/c;", "listener", "setClickListener", "Ls02/b;", "callback", "setGiftControllerCallback", "Lio/reactivex/disposables/Disposable;", "q", "Lio/reactivex/disposables/Disposable;", "getDispose", "()Lio/reactivex/disposables/Disposable;", "setDispose", "(Lio/reactivex/disposables/Disposable;)V", "dispose", "getShowDynamicGiftIcon", "()Z", "showDynamicGiftIcon", "getAutoExit", "autoExit", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePlatformGiftCombView extends BaseNormalGiftCombView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f129801r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f129802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f129803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Animator f129804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f129805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NormalGiftMessage f129806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f129807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f129808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f129809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f129810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n12.f f129811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q02.a f129812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s02.a f129813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public s02.b f129814m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f129815n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f129816o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f129817p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f129818q;

    public static final class a {
    }

    public static final class b implements q02.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GamePlatformGiftCombView f129819a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f129820a;

            public a(b r100) {
                this.f129820a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Long r101 = (Long) r100;
                this.f129820a.f();
            }
        }

        @Override // q02.d
        public final void a() {
            if (b02.a.b(this.f129819a.f129806e) == false) goto L5;
        L6:
            GamePlatformGiftCombView r100 = this.f129819a;
            if (r100.f129805d == true) goto L9;
        L13:
            c();
            return;
        L9:
            if (r100.o(R.id.combo_body) == null) goto L13;
            ((LinearLayout) this.f129819a.o(R.id.combo_body)).setVisibility(0);
            GamePlatformGiftCombView r101 = this.f129819a;
            r101.f129804c = r101.f129812k.d(r101.o(R.id.combo_body), this);
            GamePlatformGiftCombView r102 = this.f129819a;
            r102.f129809h = true;
            Animator r103 = r102.f129804c;
            if (r103 == null) goto L15;
            r103.start();
            return;
        L15:
            return;
        L5:
            if ((this.f129819a.f129806e instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L13;
            goto L6
        }

        @Override // q02.d
        public final void b() {
            s02.a r100 = this.f129819a.f129813l;
            if (r100 == null) goto L6;
            r100.onExit();
            return;
        }

        @Override // q02.d
        public final void c() {
            Disposable r100 = this.f129819a.f129807f;
            if (r100 == null) goto L6;
            r100.dispose();
        L6:
            if (GamePlatformGiftCombView.p(this.f129819a) == false) goto L8;
            GamePlatformGiftCombView r101 = this.f129819a;
            r101.f129807f = Observable.timer(r101.f129803b, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        L8:
            GamePlatformGiftCombView r102 = this.f129819a;
            NormalGiftMessage r103 = r102.f129806e;
            if (r103 == null) goto L11;
            int r104 = r103.f129777g;
        L12:
            long r105 = r104;
            if (r103 == null) goto L15;
            long r106 = r103.f129781k;
        L16:
            long r107 = r105 * r106;
            n12.f r108 = r102.f129811j;
            if ((r108 instanceof n12.c) == false) goto L23;
            ((n12.c) r108).getClass();
            if (n12.c.m(r107) < 2) goto L23;
            GiftIconMaskView r109 = (GiftIconMaskView) this.f129819a.o(R.id.gift_icon_animation_view);
            if (r109 == null) goto L23;
            r109.b();
        L23:
            GamePlatformGiftCombView r110 = this.f129819a;
            r110.f129809h = false;
            s02.a r111 = r110.f129813l;
            if (r111 == null) goto L27;
            r111.onWaiting();
            return;
        L27:
            return;
        L15:
            r106 = 0;
            goto L16
        L11:
            r104 = 0;
            goto L12
        }

        @Override // q02.d
        public final void d() {
            s02.b r100 = this.f129819a.f129814m;
            if (r100 == null) goto L6;
            r100.onPlay();
            return;
        }

        @Override // q02.d
        public final void e() {
            s02.b r100 = this.f129819a.f129814m;
            if (r100 == null) goto L6;
            r100.onPlay();
            return;
        }

        public final void f() {
            GiftTrayMessageManager r100 = GiftTrayMessageManager.f130310r;
            if (GiftTrayMessageManager.a.a().f130322l == false) goto L6;
            this.f129819a.f129810i = true;
            ALogger.d("PauseAnim", "GamePlatformGiftCombView isExitAnimationDelay=true");
            return;
        L6:
            GamePlatformGiftCombView r101 = this.f129819a;
            int r102 = GamePlatformGiftCombView.f129801r;
            r101.getClass();
            r101.post(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.c(r101));
        }

        public b(GamePlatformGiftCombView r100) {
            this.f129819a = r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HSImageView f129821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HSImageView f129822b;

        public c(HSImageView r100, HSImageView r101) {
            this.f129821a = r100;
            this.f129822b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f129821a.setVisibility(4);
            HSImageView r101 = this.f129822b;
            r101.setImageBitmap((Bitmap) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f129823a = null;

        static {
            f129823a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e extends BaseControllerListener<ImageInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HSImageView f129824a;

        public e(HSImageView r100) {
            this.f129824a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            ImageInfo r103 = (ImageInfo) r101;
            this.f129824a.setVisibility(4);
        }
    }

    static {
    }

    public GamePlatformGiftCombView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GamePlatformGiftCombView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void d(ViewGroup r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setClickListener(s02.c r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setRoomOrientation(int r100) {
    }

    private final boolean getAutoExit() {
        if (this.f129816o == false) goto L5;
    L8:
        return true;
    L5:
        if ((this.f129806e instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L8;
        return false;
    }

    private final boolean getShowDynamicGiftIcon() {
        NormalGiftMessage r100 = this.f129806e;
        if (r100 == null) goto L11;
        o7 r101 = r100.r();
        if (r101 == null) goto L11;
        o0 r102 = r101.getTrayInfo();
        if (r102 == null) goto L11;
        py.k r103 = r102.getTrayDynamicImg();
        if (r103 == null) goto L11;
        List<String> r104 = r103.getUrls();
    L12:
        List<String> r105 = r104;
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L20:
        return !r106;
    L15:
        if (r105.isEmpty() == true) goto L18;
        r106 = false;
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void e() {
        if (this.f129809h == false) goto L12;
        Animator r100 = this.f129804c;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isRunning() != true) goto L14;
        Animator r101 = this.f129804c;
        if (r101 == null) goto L15;
        r101.cancel();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void f() {
        this.f129817p.f();
        s02.a r100 = this.f129813l;
        if (r100 == null) goto L6;
        r100.onExit();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void g() {
        Animator r100 = this.f129804c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() != true) goto L12;
        Animator r101 = this.f129804c;
        if (r101 == null) goto L9;
        r101.pause();
    L9:
        ALogger.d("PauseAnim", "GamePlatformGiftCombView pauseAnimation success");
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void i() {
        if (this.f129808g == false) goto L5;
        return;
    L5:
        Disposable r100 = this.f129807f;
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        TextView r101 = (TextView) o(R.id.combo_count);
        NormalGiftMessage r102 = this.f129806e;
        if (r102 == null) goto L11;
        Number r103 = Long.valueOf(r102.f129783m);
    L12:
        r101.setText(r103.toString());
        NormalGiftMessage r104 = this.f129806e;
        if (r104 == null) goto L20;
        o7 r105 = r104.r();
        if (r105 == null) goto L20;
        o0 r106 = r105.getTrayInfo();
        if (r106 == null) goto L20;
        if (((int) r106.getTrayLevel()) != this.f129815n) goto L20;
    L49:
        Animator r107 = this.f129812k.d(o(R.id.combo_body), this.f129817p);
        this.f129804c = r107;
        this.f129809h = true;
        if (r107 == null) goto L53;
        r107.start();
        return;
    L53:
        return;
    L20:
        NormalGiftMessage r108 = this.f129806e;
        if (r108 == null) goto L27;
        o7 r109 = r108.r();
        if (r109 == null) goto L27;
        o0 r110 = r109.getTrayInfo();
        if (r110 == null) goto L27;
        int r111 = (int) r110.getTrayLevel();
    L29:
        if (this.f129816o == false) goto L49;
        Lazy r112 = GiftImageFormat.f129798a;
        if (r108 == null) goto L35;
        o7 r113 = r108.r();
        if (r113 == null) goto L35;
        o0 r114 = r113.getTrayInfo();
    L36:
        py.k r115 = GiftImageFormat.a(r114);
        if (r115 == null) goto L49;
        if (r108 == null) goto L44;
        o7 r116 = r108.r();
        if (r116 == null) goto L44;
        o0 r117 = r116.getTrayInfo();
        if (r117 == null) goto L44;
        int r118 = (int) r117.getTrayLevel();
    L45:
        this.f129815n = r118;
        ImageLoader.bindImage((HSImageView) o(R.id.normal_gift_bg_view), r115);
        if (((RoundCornerImageView) o(R.id.normal_gift_bg_view)).getVisibility() != 0) goto L48;
        s((HSImageView) o(R.id.normal_gift_bg_view), (HSImageView) o(R.id.normal_gift_bg_view_temp), r115, r111);
        goto L49
    L48:
        s((HSImageView) o(R.id.normal_gift_bg_view_temp), (HSImageView) o(R.id.normal_gift_bg_view), r115, r111);
    L44:
        r118 = 0;
    L35:
        r114 = null;
    L27:
        r111 = 1;
        goto L29
    L11:
        r103 = 1;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void l() {
        Animator r100 = this.f129804c;
        if (r100 == null) goto L11;
        if (r100.isPaused() != true) goto L11;
        Animator r101 = this.f129804c;
        if (r101 == null) goto L9;
        r101.resume();
    L9:
        ALogger.d("PauseAnim", "GamePlatformGiftCombView resumeAnimation success");
    L11:
        if (this.f129810i == false) goto L14;
        ALogger.d("PauseAnim", "GamePlatformGiftCombView getGiftExitAnim when scroll idle");
        post(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.c(this));
        this.f129810i = false;
        return;
    }

    public final void r() {
        if (this.f129808g == false) goto L5;
        return;
    L5:
        Animator r100 = this.f129804c;
        if (r100 != null) goto L8;
    L16:
        this.f129813l = null;
        GiftIconMaskView r101 = (GiftIconMaskView) o(R.id.gift_icon_animation_view);
        if (r101 == null) goto L20;
        r101.c();
        return;
    L20:
        return;
    L8:
        if (r100.isRunning() != true) goto L16;
        Animator r102 = this.f129804c;
        if (r102 == null) goto L12;
        r102.removeAllListeners();
    L12:
        Animator r103 = this.f129804c;
        if (r103 == null) goto L15;
        r103.cancel();
    L15:
        this.f129804c = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void j() {
        r();
        this.f129813l = null;
        this.f129814m = null;
        Disposable r100 = this.f129807f;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f129807f = null;
        this.f129808g = true;
        GiftIconMaskView r101 = (GiftIconMaskView) o(R.id.gift_icon_animation_view);
        if (r101 == null) goto L9;
        r101.c();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void k() {
        r();
        ((TextView) o(R.id.combo_count)).setText(String.valueOf(1));
        ((LinearLayout) o(R.id.combo_body)).setVisibility(8);
        setAlpha(1.0f);
        GiftIconMaskView r100 = (GiftIconMaskView) o(R.id.gift_icon_animation_view);
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f129818q;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final Disposable getDispose() {
        return this.f129818q;
    }

    public static final /* synthetic */ boolean p(GamePlatformGiftCombView r100) {
        return r100.getAutoExit();
    }

    private final void setGiftMessageAndDuration(NormalGiftMessage r100) {
        int r101 = com.bytedance.android.livesdk.gift.platform.business.tray2.k.f130373c;
        boolean r102 = true;
        if (((Number) com.bytedance.android.livesdk.gift.platform.business.e.f129020f.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.f129015a[4])).intValue() == 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L9;
        long r103 = (long) (2000 / l.i(r100));
    L12:
        this.f129803b = r103;
        return;
    L9:
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L11;
        r103 = this.f129811j.k(r100.getTotalMoney(), l.i(r100));
        goto L12
    L11:
        r103 = this.f129811j.i(((com.bytedance.android.livesdk.gift.platform.business.tray.a) r100).t(false), l.i(r100));
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void m(NormalGiftMessage r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        this.f129806e = r110;
        setGiftMessageAndDuration(r110);
        int r100 = this.f129811j.b(r110.getTotalMoney());
        o7 r101 = r110.r();
        py.k r102 = null;
        if (r101 == null) goto L7;
        o0 r103 = r101.getTrayInfo();
    L8:
        py.k r104 = GiftImageFormat.a(r103);
        if (this.f129816o == false) goto L23;
        if (r104 == null) goto L23;
        List<String> r105 = r104.getUrls();
        if (r105 == null) goto L14;
        Integer r106 = Integer.valueOf(r105.size());
    L16:
        if (r106.intValue() <= 0) goto L23;
        if (r103 == null) goto L20;
        this.f129815n = (int) r103.getTrayLevel();
    L20:
        if (((RoundCornerImageView) o(R.id.normal_gift_bg_view)).getVisibility() != 0) goto L22;
        s((HSImageView) o(R.id.normal_gift_bg_view), (HSImageView) o(R.id.normal_gift_bg_view_temp), r104, this.f129815n);
    L26:
        TextView r107 = (TextView) o(R.id.user_name_tv);
        if (r107 == null) goto L29;
        r107.setText("");
    L29:
        IBaseUser r108 = r110.f129775e;
        if (r108 == null) goto L34;
        TextView r109 = (TextView) o(R.id.user_name_tv);
        if (r109 == null) goto L34;
        int r111 = f0.f90831a;
        r109.setText(f0.a(r108, r110.M));
    L34:
        boolean r112 = false;
        if (r110.getTrayDisplayText() == null) goto L42;
        TextView r113 = (TextView) o(R.id.gift_description_tv);
        if (r113 == null) goto L81;
        ur2.a r114 = (ur2.a) vh6.c.b(ur2.a.class);
        a5 r115 = r110.getTrayDisplayText();
        String r116 = r110.f129773c;
        if (r116 != null) goto L41;
        r116 = "";
    L41:
        r113.setText(r114.Lf(r115, r116));
    L81:
        View r117 = o(R.id.normal_gift_bg_view);
        Function0<String> r118 = new GamePlatformGiftCombView$loadTrayDisplayText$2(this);
        int r119 = r3.f156924a;
        Intrinsics.checkNotNullParameter(r118, "getDescription");
        if (r117 == null) goto L85;
        r3.a r120 = new r3.a(r117);
        r120.f156926b = r118;
        r120.f156927c = "";
        ViewCompat.setAccessibilityDelegate(r117, r120);
    L85:
        View r121 = o(R.id.normal_gift_bg_view_temp);
        Function0<String> r122 = new GamePlatformGiftCombView$loadTrayDisplayText$3(this);
        Intrinsics.checkNotNullParameter(r122, "getDescription");
        if (r121 == null) goto L89;
        r3.a r123 = new r3.a(r121);
        r123.f156926b = r122;
        r123.f156927c = "";
        ViewCompat.setAccessibilityDelegate(r121, r123);
    L89:
        boolean r124 = r110 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a;
        if (r124 == false) goto L98;
        LinearLayout r125 = (LinearLayout) o(R.id.combo_body);
        if (r125 == null) goto L94;
        r125.setVisibility(8);
    L94:
        TextView r126 = (TextView) o(R.id.group_count);
        if (r126 == null) goto L116;
        r126.setVisibility(8);
    L116:
        if (r124 == true) goto L118;
    L121:
        boolean r127 = true;
    L123:
        if (r127 == true) goto L125;
        GiftIconMaskView r128 = (GiftIconMaskView) o(R.id.gift_icon_animation_view);
        if (r128 == null) goto L138;
        r128.setVisibility(8);
    L138:
        HSImageView r129 = (HSImageView) o(R.id.dynamic_gift_icon);
        if (r129 == null) goto L141;
        r129.setVisibility(8);
    L141:
        if (r127 == true) goto L143;
        return;
    L143:
        if (getShowDynamicGiftIcon() == true) goto L145;
        py.k r130 = r110.f129785o;
        GiftImageLoader.f132324k.getClass();
        Intrinsics.checkNotNullParameter("live_gift_tray_gift", "callerContext");
        Single.create(new com.bytedance.android.livesdk.gift.util.e(r130, null, "live_gift_tray_gift")).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.a(this), com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.b.f129967a);
        return;
    L145:
        o7 r131 = r110.r();
        if (r131 == null) goto L150;
        o0 r132 = r131.getTrayInfo();
        if (r132 == null) goto L150;
        r102 = r132.getTrayDynamicImg();
    L150:
        if (r102 == null) goto L164;
        List<String> r133 = r102.getUrls();
        if (r133 != null) goto L154;
    L155:
        r112 = true;
    L156:
        if (r112 == true) goto L166;
        HSImageView r134 = (HSImageView) o(R.id.dynamic_gift_icon);
        if (r134 == null) goto L165;
        r134.setController(Fresco.newDraweeControllerBuilder().setUri((String) CollectionsKt.first(r102.getUrls())).setAutoPlayAnimations(true).build());
        return;
    L165:
        return;
    L166:
        return;
    L154:
        if (r133.isEmpty() == false) goto L156;
    L164:
        return;
    L125:
        if (getShowDynamicGiftIcon() == false) goto L132;
        GiftIconMaskView r135 = (GiftIconMaskView) o(R.id.gift_icon_animation_view);
        if (r135 == null) goto L129;
        r135.setVisibility(8);
    L129:
        HSImageView r136 = (HSImageView) o(R.id.dynamic_gift_icon);
        if (r136 == null) goto L141;
        r136.setVisibility(0);
        goto L141
    L132:
        GiftIconMaskView r137 = (GiftIconMaskView) o(R.id.gift_icon_animation_view);
        if (r137 == null) goto L141;
        r137.setVisibility(0);
        goto L141
    L118:
        if (((com.bytedance.android.livesdk.gift.platform.business.tray.a) r110).R == true) goto L121;
        r127 = false;
        goto L123
    L98:
        if (this.f129805d == false) goto L105;
        LinearLayout r138 = (LinearLayout) o(R.id.combo_body);
        if (r138 == null) goto L102;
        r138.setVisibility(0);
    L102:
        TextView r139 = (TextView) o(R.id.combo_count);
        if (r139 == null) goto L105;
        r139.setText(r110.q());
    L105:
        long r140 = r110.f129781k;
        if (r140 <= 1) goto L113;
        TextView r141 = (TextView) o(R.id.group_count);
        if (r141 == null) goto L110;
        r141.setVisibility(0);
    L110:
        TextView r142 = (TextView) o(R.id.group_count);
        if (r142 == null) goto L116;
        r142.setText("x" + r140);
        goto L116
    L113:
        TextView r143 = (TextView) o(R.id.group_count);
        if (r143 == null) goto L116;
        r143.setVisibility(8);
        goto L116
    L42:
        String r144 = r110.f129773c;
        if (r144 != null) goto L45;
        r144 = "";
    L45:
        TextView r145 = (TextView) o(R.id.gift_description_tv);
        if (r145 == null) goto L48;
        r145.setText(r144);
    L48:
        yz0.k r146 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r146 == null) goto L51;
        IRoom r147 = r146.getRoom();
    L52:
        if (r147 == null) goto L56;
        IBaseUser r148 = r147.getOwner();
        if (r148 == null) goto L56;
        String r149 = r148.getIdString();
    L57:
        IBaseUser r150 = r110.f129776f;
        if (r150 == null) goto L60;
        String r151 = r150.getIdString();
    L62:
        if ((!Intrinsics.areEqual(r149, r151)) == false) goto L81;
        IBaseUser r152 = r110.f129776f;
        if (r152 == null) goto L69;
        String r153 = r152.getNickName();
        if (r153 == null) goto L69;
        String r154 = r153;
    L70:
        int r155 = StringsKt.indexOf$default(r144, r154, 0, false, 6, null);
        if (r155 == (-1)) goto L81;
        String r156 = r144.substring(0, r155);
        String r157 = " <font color = '#FACE15'>" + r144.substring(r155) + "</font> ";
        StringBuilder r158 = new StringBuilder();
        r158.append(r156);
        r158.append(r157);
        h2 r159 = GiftManagerKt.l(r110.f129772b);
        if (r159 == null) goto L75;
        String r160 = r159.getName();
    L76:
        r158.append(r160);
        String r161 = r158.toString();
        if (Build.VERSION.SDK_INT < 24) goto L79;
        Spanned r162 = Html.fromHtml(r161, 0);
    L80:
        ((TextView) o(R.id.gift_description_tv)).setText(r162);
        goto L81
    L79:
        r162 = Html.fromHtml(r161);
        goto L80
    L75:
        r160 = null;
    L69:
        r154 = "";
        goto L70
    L60:
        r151 = null;
    L56:
        r149 = null;
        goto L57
    L51:
        r147 = null;
        goto L52
    L22:
        s((HSImageView) o(R.id.normal_gift_bg_view_temp), (HSImageView) o(R.id.normal_gift_bg_view), r104, this.f129815n);
        goto L26
    L14:
        r106 = null;
    L23:
        RoundCornerImageView r163 = (RoundCornerImageView) o(R.id.normal_gift_bg_view);
        if (r163 == null) goto L26;
        r163.setBackgroundResource(r100);
        goto L26
    L7:
        r103 = null;
        goto L8
    }

    public final View o(int r100) {
        if (this.f129802a != null) goto L5;
        this.f129802a = new LinkedHashMap();
    L5:
        View r101 = this.f129802a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f129802a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setDispose(Disposable r100) {
        this.f129818q = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setGiftControllerCallback(s02.b r100) {
        this.f129814m = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setShowCombo(boolean r100) {
        this.f129805d = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void h(r02.b.C7406b r100, boolean r101) {
        this.f129813l = r100;
        Animator r102 = this.f129812k.b(this, this.f129817p);
        this.f129804c = r102;
        if (r102 == null) goto L6;
        r102.start();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void n(int r100, int r101) {
        this.f129812k.a(this, r100, r101);
    }

    public GamePlatformGiftCombView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f129802a = new LinkedHashMap();
        this.f129805d = true;
        this.f129811j = n12.e.a();
        if (com.bytedance.android.livesdk.gift.platform.business.b.a() == false) goto L6;
        q02.a r103 = new com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.b();
    L9:
        this.f129812k = r103;
        this.f129816o = true;
        this.f129817p = new b(this);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_gift_game_tray, this);
        Typeface r104 = Typeface.createFromAsset(r100.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L17
        TextView r105 = (TextView) o(R.id.combo_count_x);     // Catch: Exception -> L17
        if (r105 == null) goto L13;
        r105.setTypeface(r104);     // Catch: Exception -> L17
    L13:
        TextView r106 = (TextView) o(R.id.combo_count);     // Catch: Exception -> L17
        if (r106 == null) goto L20;
        r106.setTypeface(r104);     // Catch: Exception -> L17
    L20:
        if (PadConfigUtils.c() == false) goto L27;
        ViewUtilsKt.c(o(R.id.normal_gift_bg_view), s1.f(20.0f));
        HSImageView r107 = (HSImageView) findViewById(R.id.normal_gift_bg_view_temp);
        if (r107 == null) goto L28;
        ViewUtilsKt.c(r107, s1.f(20.0f));
        return;
    L28:
        return;
    L27:
        return;
    L17:
        e = move-exception;
        jy0.b.c("GamePlatformGiftCombView", "load font asset exception: " + e.getMessage(), null, 4);
        goto L20
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.a.a() <= 0) goto L8;
        r103 = new q02.f();
        goto L9
    L8:
        r103 = new q02.e();
        goto L9
    }

    public final Bitmap q(Bitmap r100, int r110, int r111) {
        if (r100 == null) goto L9;
        int r101 = r100.getWidth();     // Catch: Throwable -> L6
        int r102 = r100.getHeight();     // Catch: Throwable -> L6
        Matrix r103 = new Matrix();     // Catch: Throwable -> L6
        r103.postScale(r110 / r101, r111 / r102);     // Catch: Throwable -> L6
        return Bitmap.createBitmap(r100, 0, 0, r101, r102, r103, true);
    L10:
        return null;
    L9:
        return null;
    }

    public /* synthetic */ GamePlatformGiftCombView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void s(HSImageView r100, HSImageView r101, py.k r102, int r103) {
        Integer r104 = null;
        r101.setController(null);
        r101.setVisibility(0);
        e r105 = new e(r100);
        if (r103 > 4) goto L5;
        this.f129818q = a1.k(r102).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r100, r101), d.f129823a);
        return;
    L5:
        List<String> r106 = r102.getUrls();
        if (r106 == null) goto L9;
        r104 = Integer.valueOf(r106.size());
    L9:
        if (r104.intValue() < 1) goto L13;
        r101.setController(Fresco.newDraweeControllerBuilder().setControllerListener(r105).setUri((String) ListProtector.get(r102.getUrls(), 0)).setAutoPlayAnimations(true).build());
        return;
    }
}
