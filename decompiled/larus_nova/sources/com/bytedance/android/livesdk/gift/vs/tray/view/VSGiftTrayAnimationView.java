package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n12.f;
import py.k;
import zt0.e;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001NB'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0018\u001a\n \u000e*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001b\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R#\u0010 \u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR#\u0010#\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u001fR#\u0010(\u001a\n \u000e*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010'R#\u0010+\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R#\u00100\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010/R#\u00103\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010/R#\u00106\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u001fR#\u00109\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010/R#\u0010<\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b;\u0010\u001fR#\u0010?\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b>\u0010\u001fR#\u0010B\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\bA\u0010/R\u0014\u0010E\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006O"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/tray/view/VSGiftTrayAnimationView;", "Landroid/widget/FrameLayout;", "", "showCombo", "", "setShowCombo", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "msg", "setGiftMessage", "Ls02/b;", "callback", "setGiftControllerCallback", "setGiftMessageAndDuration", "Lcom/bytedance/android/live/core/widget/HSImageView;", "kotlin.jvm.PlatformType", ce.f26396k, "Lkotlin/Lazy;", "getNormalGiftBgView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "normalGiftBgView", "Landroid/widget/ImageView;", "l", "getUserAvatarIv", "()Landroid/widget/ImageView;", "userAvatarIv", "m", "getAvatarBorderIv", "avatarBorderIv", "Landroid/widget/TextView;", OfficeSDKRequestTag.KEY_NEW_USER, "getUserNameTv", "()Landroid/widget/TextView;", "userNameTv", "o", "getGiftDescriptionTv", "giftDescriptionTv", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "p", "getGiftIconAnimationView", "()Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "giftIconAnimationView", "q", "getDynamicGiftIcon", "dynamicGiftIcon", "Landroid/view/View;", "r", "getDummyView", "()Landroid/view/View;", "dummyView", "s", "getGroupBody", "groupBody", "t", "getGroupCount", "groupCount", "u", "getComboBody", "comboBody", BaseSwitches.V, "getComboCountX", "comboCountX", "w", "getComboCount", "comboCount", "x", "getLinearLayout", "linearLayout", "getShowDynamicGiftIcon", "()Z", "showDynamicGiftIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftTrayAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f132525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Animator f132526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f132527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NormalGiftMessage f132528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f132529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f132530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f132531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q02.a f132532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s02.a f132533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s02.b f132534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f132535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f132536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f132537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f132538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f132539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f132540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f132541q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f132542r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f132543s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f132544t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f132545u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f132546v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f132547w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f132548x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final d f132549y;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSGiftTrayAnimationView f132550a;

        public a(VSGiftTrayAnimationView r100) {
            this.f132550a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            NormalGiftMessage r101 = this.f132550a.f132528d;
            if (r101 == null) goto L8;
            IBaseUser r102 = r101.f129775e;
            if (r102 == null) goto L9;
            ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).xh(r102);
            return;
        L9:
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f132551a = null;

        static {
            f132551a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class c {
    }

    public static final class d implements q02.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VSGiftTrayAnimationView f132552a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f132553a;

            public a(d r100) {
                this.f132553a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Long r101 = (Long) r100;
                d r102 = this.f132553a;
                r102.f132552a.post(new com.bytedance.android.livesdk.gift.vs.tray.view.c(r102));
            }
        }

        @Override // q02.d
        public final void a() {
            VSGiftTrayAnimationView r100 = this.f132552a;
            if ((r100.f132528d instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L5;
        L11:
            c();
            return;
        L5:
            if (r100.f132527c == false) goto L11;
            if (VSGiftTrayAnimationView.a(r100) == null) goto L11;
            VSGiftTrayAnimationView.a(this.f132552a).setVisibility(0);
            VSGiftTrayAnimationView r101 = this.f132552a;
            r101.f132526b = r101.f132532h.d(VSGiftTrayAnimationView.a(r101), this);
            this.f132552a.getClass();
            Animator r102 = this.f132552a.f132526b;
            if (r102 == null) goto L13;
            r102.start();
            return;
        }

        @Override // q02.d
        public final void b() {
            s02.a r100 = this.f132552a.f132533i;
            if (r100 == null) goto L6;
            r100.onExit();
            return;
        }

        @Override // q02.d
        public final void c() {
            Disposable r100 = this.f132552a.f132529e;
            if (r100 == null) goto L5;
            r100.dispose();
        L5:
            VSGiftTrayAnimationView r101 = this.f132552a;
            if ((r101.f132528d instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L8;
            r101.f132529e = Observable.timer(r101.f132525a, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        L8:
            VSGiftTrayAnimationView r102 = this.f132552a;
            NormalGiftMessage r103 = r102.f132528d;
            if (r103 == null) goto L11;
            int r104 = r103.f129777g;
        L12:
            long r105 = r104;
            if (r103 == null) goto L15;
            long r106 = r103.f129781k;
        L16:
            long r107 = r105 * r106;
            f r108 = r102.f132531g;
            if ((r108 instanceof n12.c) == false) goto L21;
            ((n12.c) r108).getClass();
            if (n12.c.m(r107) < 2) goto L21;
            VSGiftTrayAnimationView.b(this.f132552a).b();
        L21:
            this.f132552a.getClass();
            s02.a r109 = this.f132552a.f132533i;
            if (r109 == null) goto L25;
            r109.onWaiting();
            return;
        L25:
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
            s02.b r100 = this.f132552a.f132534j;
            if (r100 == null) goto L6;
            r100.onPlay();
            return;
        }

        @Override // q02.d
        public final void e() {
            s02.b r100 = this.f132552a.f132534j;
            if (r100 == null) goto L6;
            r100.onPlay();
            return;
        }

        public d(VSGiftTrayAnimationView r100) {
            this.f132552a = r100;
        }
    }

    static {
    }

    public VSGiftTrayAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSGiftTrayAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final HSImageView getAvatarBorderIv() {
        return (HSImageView) this.f132537m.getValue();
    }

    private final View getComboBody() {
        return (View) this.f132545u.getValue();
    }

    private final TextView getComboCount() {
        return (TextView) this.f132547w.getValue();
    }

    private final TextView getComboCountX() {
        return (TextView) this.f132546v.getValue();
    }

    private final View getDummyView() {
        return (View) this.f132542r.getValue();
    }

    private final HSImageView getDynamicGiftIcon() {
        return (HSImageView) this.f132541q.getValue();
    }

    private final TextView getGiftDescriptionTv() {
        return (TextView) this.f132539o.getValue();
    }

    private final GiftIconMaskView getGiftIconAnimationView() {
        return (GiftIconMaskView) this.f132540p.getValue();
    }

    private final View getGroupBody() {
        return (View) this.f132543s.getValue();
    }

    private final TextView getGroupCount() {
        return (TextView) this.f132544t.getValue();
    }

    private final View getLinearLayout() {
        return (View) this.f132548x.getValue();
    }

    private final HSImageView getNormalGiftBgView() {
        return (HSImageView) this.f132535k.getValue();
    }

    private final ImageView getUserAvatarIv() {
        return (ImageView) this.f132536l.getValue();
    }

    private final TextView getUserNameTv() {
        return (TextView) this.f132538n.getValue();
    }

    private final boolean getShowDynamicGiftIcon() {
        NormalGiftMessage r100 = this.f132528d;
        if (r100 == null) goto L11;
        o7 r101 = r100.r();
        if (r101 == null) goto L11;
        o0 r102 = r101.getTrayInfo();
        if (r102 == null) goto L11;
        k r103 = r102.getTrayDynamicImg();
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

    public final void g() {
        if (this.f132530f == false) goto L5;
        return;
    L5:
        Animator r100 = this.f132526b;
        if (r100 != null) goto L8;
    L16:
        this.f132533i = null;
        getGiftIconAnimationView().c();
        return;
    L8:
        if (r100.isRunning() != true) goto L16;
        Animator r101 = this.f132526b;
        if (r101 == null) goto L12;
        r101.removeAllListeners();
    L12:
        Animator r102 = this.f132526b;
        if (r102 == null) goto L15;
        r102.cancel();
    L15:
        this.f132526b = null;
        goto L16
    }

    public final void e() {
        g();
        this.f132533i = null;
        this.f132534j = null;
        Disposable r100 = this.f132529e;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f132529e = null;
        this.f132530f = true;
        getGiftIconAnimationView().c();
    }

    public final void f() {
        g();
        getComboCount().setText(String.valueOf(1));
        getComboBody().setVisibility(8);
        setAlpha(1.0f);
        getGiftIconAnimationView().c();
    }

    public static final /* synthetic */ View a(VSGiftTrayAnimationView r100) {
        return r100.getComboBody();
    }

    public static final /* synthetic */ GiftIconMaskView b(VSGiftTrayAnimationView r100) {
        return r100.getGiftIconAnimationView();
    }

    private final void setGiftMessageAndDuration(NormalGiftMessage r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L5;
        long r101 = this.f132531g.k(r100.getTotalMoney(), l.i(r100));
    L6:
        this.f132525a = r101;
        return;
    L5:
        r101 = this.f132531g.i(((com.bytedance.android.livesdk.gift.platform.business.tray.a) r100).t(false), l.i(r100));
        goto L6
    }

    public final void d(long r100) {
        if (this.f132530f == false) goto L5;
        return;
    L5:
        Disposable r101 = this.f132529e;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        getComboCount().setText(String.valueOf(r100));
        Animator r102 = this.f132532h.d(getComboBody(), this.f132549y);
        this.f132526b = r102;
        if (r102 == null) goto L12;
        r102.start();
        return;
    }

    public final void setGiftControllerCallback(s02.b r100) {
        this.f132534j = r100;
    }

    public final void setGiftMessage(NormalGiftMessage r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        this.f132528d = r110;
        setGiftMessageAndDuration(r110);
        NormalGiftMessage r100 = this.f132528d;
        boolean r101 = false;
        if (r100 == null) goto L7;
        int r102 = r100.f129777g;
    L8:
        long r103 = r102;
        if (r100 == null) goto L11;
        long r104 = r100.f129781k;
    L12:
        getNormalGiftBgView().setBackgroundResource(this.f132531g.b(r103 * r104));
        ImageView r105 = getUserAvatarIv();
        NormalGiftMessage r106 = this.f132528d;
        k r107 = null;
        if (r106 == null) goto L17;
        IBaseUser r108 = r106.f129775e;
        if (r108 == null) goto L17;
        k r109 = r108.getAvatarThumbKt();
    L18:
        a1.k(r109).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.vs.tray.view.b(this, r105));
        e r111 = yt0.c.a();
        IBaseUser r112 = r110.f129775e;
        if (r112 == null) goto L23;
        py.f r113 = r112.getBorder();
        if (r113 == null) goto L23;
        String r114 = r113.getDressId();
    L24:
        com.bytedance.android.live.profit.dress.a r115 = (com.bytedance.android.live.profit.dress.a) r111.getDressData(r114, 1, "VSGiftTrayAnimationView: loadTrayHeadImage");
        if (r115 == null) goto L28;
        k r116 = r115.f87077a;
        if (r116 == null) goto L28;
    L34:
        if (r116 == null) goto L39;
        HSImageView r117 = getAvatarBorderIv();
        if (r117 == null) goto L38;
        r117.setVisibility(0);
    L38:
        ImageLoader.bindImage(getAvatarBorderIv(), r116);
    L39:
        TextView r118 = getUserNameTv();
        IBaseUser r119 = r110.f129775e;
        String r120 = "";
        if (r119 == null) goto L44;
        String r121 = r119.getNickName();
        if (r121 == null) goto L44;
    L45:
        r118.setText(r121);
        if (r110.getTrayDisplayText() == null) goto L52;
        TextView r122 = getGiftDescriptionTv();
        ur2.a r123 = (ur2.a) vh6.c.b(ur2.a.class);
        a5 r124 = r110.getTrayDisplayText();
        String r125 = r110.f129773c;
        if (r125 == null) goto L51;
        r120 = r125;
    L51:
        r122.setText(r123.Lf(r124, r120));
    L88:
        boolean r126 = r110 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a;
        if (r126 == false) goto L92;
        getComboBody().setVisibility(8);
        getGroupBody().setVisibility(8);
        getDummyView().setVisibility(0);
    L99:
        if (r126 == true) goto L101;
    L104:
        boolean r127 = true;
    L105:
        if (r127 == true) goto L107;
        getGiftIconAnimationView().setVisibility(8);
        getDynamicGiftIcon().setVisibility(8);
    L111:
        View r128 = getLinearLayout();
        ViewGroup.LayoutParams r129 = getLinearLayout().getLayoutParams();
        if (r127 == false) goto L114;
        int r130 = R.dimen.ttlive_gift_user_info_body_width;
    L115:
        r129.width = s1.j(r130);
        Unit r131 = Unit.INSTANCE;
        r128.setLayoutParams(r129);
        if (r127 == true) goto L118;
        return;
    L118:
        if (getShowDynamicGiftIcon() == true) goto L120;
        a1.k(r110.f129785o).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.vs.tray.view.a(this));
        return;
    L120:
        o7 r132 = r110.r();
        if (r132 == null) goto L125;
        o0 r133 = r132.getTrayInfo();
        if (r133 == null) goto L125;
        r107 = r133.getTrayDynamicImg();
    L125:
        if (r107 == null) goto L137;
        List<String> r134 = r107.getUrls();
        if (r134 != null) goto L129;
    L130:
        r101 = true;
    L131:
        if (r101 == true) goto L138;
        getDynamicGiftIcon().setController(Fresco.newDraweeControllerBuilder().setUri((String) CollectionsKt.first(r107.getUrls())).setAutoPlayAnimations(true).build());
        return;
    L138:
        return;
    L129:
        if (r134.isEmpty() == false) goto L131;
    L137:
        return;
    L114:
        r130 = R.dimen.ttlive_gift_user_info_body_width_no_icon;
        goto L115
    L107:
        if (getShowDynamicGiftIcon() == false) goto L109;
        getGiftIconAnimationView().setVisibility(8);
        getDynamicGiftIcon().setVisibility(0);
        goto L111
    L109:
        getGiftIconAnimationView().setVisibility(0);
        goto L111
    L101:
        if (((com.bytedance.android.livesdk.gift.platform.business.tray.a) r110).R == true) goto L104;
        r127 = false;
        goto L105
    L92:
        if (this.f132527c == false) goto L94;
        getComboBody().setVisibility(0);
        getComboCount().setText(String.valueOf(r110.f129783m));
    L95:
        long r135 = r110.f129781k;
        if (r135 <= 1) goto L98;
        getDummyView().setVisibility(8);
        getGroupBody().setVisibility(0);
        getGroupCount().setText(String.valueOf(r135));
        goto L99
    L98:
        getDummyView().setVisibility(0);
        getGroupBody().setVisibility(8);
        goto L99
    L94:
        getComboBody().setVisibility(8);
        goto L95
    L52:
        String r136 = r110.f129773c;
        if (r136 != null) goto L55;
        r136 = "";
    L55:
        getGiftDescriptionTv().setText(r136);
        yz0.k r137 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);
        if (r137 == null) goto L58;
        IRoom r138 = r137.getRoom();
    L59:
        if (r138 == null) goto L63;
        IBaseUser r139 = r138.getOwner();
        if (r139 == null) goto L63;
        String r140 = r139.getIdString();
    L64:
        IBaseUser r141 = r110.f129776f;
        if (r141 == null) goto L67;
        String r142 = r141.getIdString();
    L69:
        if (StringsKt.equals$default(r140, r142, false, 2, null) == true) goto L88;
        IBaseUser r143 = r110.f129776f;
        if (r143 == null) goto L76;
        String r144 = r143.getNickName();
        if (r144 == null) goto L76;
        String r145 = r144;
    L77:
        int r146 = StringsKt.indexOf$default(r136, r145, 0, false, 6, null);
        if (r146 == (-1)) goto L88;
        String r147 = r136.substring(0, r146);
        String r148 = " <font color = '#FACE15'>" + r136.substring(r146) + "</font> ";
        StringBuilder r149 = new StringBuilder();
        r149.append(r147);
        r149.append(r148);
        h2 r150 = GiftManagerKt.l(r110.f129772b);
        if (r150 == null) goto L82;
        String r151 = r150.getName();
    L83:
        r149.append(r151);
        String r152 = r149.toString();
        if (Build.VERSION.SDK_INT < 24) goto L86;
        Spanned r153 = Html.fromHtml(r152, 0);
    L87:
        getGiftDescriptionTv().setText(r153);
        goto L88
    L86:
        r153 = Html.fromHtml(r152);
        goto L87
    L82:
        r151 = null;
    L76:
        r145 = "";
        goto L77
    L67:
        r142 = null;
    L63:
        r140 = null;
        goto L64
    L58:
        r138 = null;
    L44:
        r121 = "";
    L28:
        IBaseUser r154 = r110.f129775e;
        if (r154 == null) goto L33;
        py.f r155 = r154.getBorder();
        if (r155 == null) goto L33;
        r116 = r155.getIcon();
    L33:
        r116 = null;
    L23:
        r114 = null;
    L17:
        r109 = null;
        goto L18
    L11:
        r104 = 0;
        goto L12
    L7:
        r102 = 0;
        goto L8
    }

    public final void setShowCombo(boolean r100) {
        this.f132527c = r100;
    }

    public VSGiftTrayAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f132527c = true;
        this.f132531g = n12.e.a();
        if (com.bytedance.android.livesdk.gift.platform.business.b.a() == false) goto L6;
        q02.a r103 = new com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.b();
    L9:
        this.f132532h = r103;
        this.f132535k = LazyKt.lazy(new VSGiftTrayAnimationView$normalGiftBgView$2(this));
        this.f132536l = LazyKt.lazy(new VSGiftTrayAnimationView$userAvatarIv$2(this));
        this.f132537m = LazyKt.lazy(new VSGiftTrayAnimationView$avatarBorderIv$2(this));
        this.f132538n = LazyKt.lazy(new VSGiftTrayAnimationView$userNameTv$2(this));
        this.f132539o = LazyKt.lazy(new VSGiftTrayAnimationView$giftDescriptionTv$2(this));
        this.f132540p = LazyKt.lazy(new VSGiftTrayAnimationView$giftIconAnimationView$2(this));
        this.f132541q = LazyKt.lazy(new VSGiftTrayAnimationView$dynamicGiftIcon$2(this));
        this.f132542r = LazyKt.lazy(new VSGiftTrayAnimationView$dummyView$2(this));
        this.f132543s = LazyKt.lazy(new VSGiftTrayAnimationView$groupBody$2(this));
        this.f132544t = LazyKt.lazy(new VSGiftTrayAnimationView$groupCount$2(this));
        this.f132545u = LazyKt.lazy(new VSGiftTrayAnimationView$comboBody$2(this));
        this.f132546v = LazyKt.lazy(new VSGiftTrayAnimationView$comboCountX$2(this));
        this.f132547w = LazyKt.lazy(new VSGiftTrayAnimationView$comboCount$2(this));
        this.f132548x = LazyKt.lazy(new VSGiftTrayAnimationView$linearLayout$2(this));
        this.f132549y = new d(this);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_vs_gift_combo_view, this);
        getUserAvatarIv().setOnClickListener(new a(this));
        setOnClickListener(b.f132551a);
        Typeface r104 = Typeface.createFromAsset(r100.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L12
        getComboCountX().setTypeface(r104);     // Catch: Exception -> L12
        getComboCount().setTypeface(r104);     // Catch: Exception -> L12
        getGroupCount().setTypeface(r104);     // Catch: Exception -> L12
    L15:
        if (PadConfigUtils.c() == false) goto L17;
    L18:
        ViewUtilsKt.c(getNormalGiftBgView(), s1.f(20.0f));
        return;
    L17:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L18;
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("NormalGiftCombViewV2", "load font asset exception: " + e.getMessage(), null, 4);
        goto L15
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.a.a() <= 0) goto L8;
        r103 = new q02.f();
        goto L9
    L8:
        r103 = new q02.e();
        goto L9
    }

    public static Bitmap c(Bitmap r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        int r102 = r100.getWidth();     // Catch: Throwable -> L5
        int r103 = r100.getHeight();     // Catch: Throwable -> L5
        Matrix r104 = new Matrix();     // Catch: Throwable -> L5
        r104.postScale(r101 / r102, r110 / r103);     // Catch: Throwable -> L5
        return Bitmap.createBitmap(r100, 0, 0, r102, r103, r104, true);
    L5:
        return null;
    }

    public /* synthetic */ VSGiftTrayAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
