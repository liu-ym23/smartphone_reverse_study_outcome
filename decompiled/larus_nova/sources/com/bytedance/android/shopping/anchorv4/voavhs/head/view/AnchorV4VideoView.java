package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.SlidesAndIndicatorV4Component;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoCoverLayout;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4VideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/o;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/k;", "Lfa3/d;", "", "getVideoType", "Ld83/b;", "getHeadAbility", "", "isSmall", "", "setIsSmallComponent", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayerBlock;", "getPlayerBlock", "", "getVideoProgress", "()Ljava/lang/Float;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4VideoView extends FrameLayout implements com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o, com.bytedance.android.shopping.anchorv4.voavhs.head.base.k, fa3.d {
    public static final /* synthetic */ int F = 0;
    public boolean A;
    public boolean B;
    public VideoCoverLayout C;
    public com.bytedance.android.shopping.anchorv4.voavhs.head.base.d D;
    public final /* synthetic */ fa3.b E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f168898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f168899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProgressBar f168900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PlayerBlock f168901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b f168902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f168903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f168904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h83.g f168905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<Function1<Float, Unit>> f168906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c63.d f168907j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GaussianBlurConfig f168908k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f168909l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ECDraweeView f168910m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f168911n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f168912o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f168913p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f168914q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f168915r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f168916s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f168917t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AnchorV4CommentVideoEntryLayout f168918u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f168919v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bitmap f168920w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bitmap f168921x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f168922y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f168923z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4VideoView f168924a;

        public a(AnchorV4VideoView r100) {
            this.f168924a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f168924a.getHeight();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c implements com.bytedance.android.ec.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4VideoView f168925a;

        @Override // com.bytedance.android.ec.model.j
        public final void onClick() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onClose(boolean r100) {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onReturnClick() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onShow() {
        }

        public c(AnchorV4VideoView r100) {
            this.f168925a = r100;
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onMuteButtonClick(boolean r100) {
            if (r100 == true) goto L17;
            PlayerBlock r101 = this.f168925a.f168901d;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.isPlaying() != true) goto L19;
            PlayerBlock r102 = this.f168925a.f168901d;
            if (r102 != null) goto L10;
        L12:
            if (r102 != null) goto L14;
            return;
        L14:
            if (r102.t() == true) goto L21;
            PlayerBlock.o(r102, false, 2);
            return;
        L21:
            return;
        L10:
            if (r102.f164950o != true) goto L12;
            return;
        L19:
            return;
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4VideoView f168926a;

        public d(AnchorV4VideoView r100, int r101) {
            this.f168926a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Long) r100, "it");
            final AnchorV4VideoView r101 = this.f168926a;
            int r102 = AnchorV4VideoView.F;
            r101.getClass();
            return Observable.create(new AnchorV4VideoView$getVideoFrame$1(r101));
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4VideoView f168927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f168928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GaussianBlurConfig f168929c;

        public e(AnchorV4VideoView r100, boolean r101, GaussianBlurConfig r102) {
            this.f168927a = r100;
            this.f168928b = r101;
            this.f168929c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (this.f168928b == false) goto L8;
            AnchorV4VideoView r102 = this.f168927a;
            if (r102.f168919v == true) goto L7;
            this.f168929c.getMaskColor();
            AnchorV4VideoView.g(r102, r101);
        L7:
            this.f168927a.f168919v = true;
            return;
        L8:
            AnchorV4VideoView r103 = this.f168927a;
            this.f168929c.getMaskColor();
            AnchorV4VideoView.g(r103, r101);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f168930a = null;

        static {
            f168930a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ECExceptionMonitor.e((Throwable) r100);
        }
    }

    static {
    }

    public AnchorV4VideoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4VideoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void W(boolean r100) {
    }

    @Override // fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.E.add(r100);
        return r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void b(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onResume() {
    }

    private final d83.b getHeadAbility() {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r100 = this.D;
        if (r100 == null) goto L5;
        SlidesAndIndicatorV4Component r101 = r100.r();
    L7:
        if ((r101 instanceof d83.b) == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    private final String getVideoType() {
        h83.g r100 = this.f168905h;
        if (r100 != null) goto L5;
    L7:
        return com.bytedance.android.ec.core.event.a.VALUE_VIDEO_TYPE_MAIN_VIDEO;
    L5:
        if (r100.f484099i != true) goto L7;
        return com.bytedance.android.ec.core.event.a.VALUE_VIDEO_TYPE_TEST_TAB;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
    public final void c() {
        PlayerBlock r100 = this.f168901d;
        if (r100 == null) goto L5;
        int r101 = PlayerBlock.T;
        r100.D(false, false, false);
    L5:
        this.E.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void d() {
        h83.g r100 = this.f168905h;
        if (r100 != null) goto L5;
    L9:
        d83.b r101 = getHeadAbility();
        if (r101 != null) goto L12;
    L13:
        PlayerBlock r102 = this.f168901d;
        if (r102 == null) goto L20;
        int r103 = PlayerBlock.T;
        r102.F(true);
        return;
    L20:
        return;
    L12:
        if (r101.a() != true) goto L13;
        return;
    L5:
        if (r100.f484099i != true) goto L9;
        PlayerBlock r104 = this.f168901d;
        if (r104 == null) goto L17;
        r104.F(false);
        return;
    }

    public final Float getVideoProgress() {
        PlayerBlock r100 = this.f168901d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r100.getPlayProgress());
    }

    public final void l() {
        h83.g r100 = this.f168905h;
        if (r100 == null) goto L14;
        ECUrlModel r101 = r100.f484093c;
        if (r101 == null) goto L15;
        String r102 = r101.getFirstUrl();
        if (r102 != null) goto L10;
        return;
    L10:
        if (this.B == true) goto L17;
        this.B = true;
        fa3.c.a(Observable.create(new r(r102)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this)), this);
        return;
    L17:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onDestroy() {
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100 = this.f168902e;
        if (r100 == null) goto L5;
        Integer r101 = r100.h();
    L6:
        n("quit", r101, false);
        this.f168917t = true;
        PlayerBlock r102 = this.f168901d;
        if (r102 == null) goto L9;
        r102.B();
    L9:
        this.E.a();
        if (this.A == false) goto L20;
        Object r103 = this.f168923z;
        if (r103 == null) goto L18;
        int r104 = ECSdk.f48106a;
        IAdapterService r105 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r105 == null) goto L18;
        com.bytedance.android.ec.adapter.api.j r106 = r105.getLiveWindowService();
        if (r106 == null) goto L18;
        r106.d(r103);
    L18:
        this.A = false;
        return;
    L20:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final PlayerBlock getPlayerBlock() {
        return this.f168901d;
    }

    public static final /* synthetic */ String h(AnchorV4VideoView r100) {
        return r100.getVideoType();
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void Q(float r100) {
        float r101 = (float) Math.floor(r100);
        ProgressBar r102 = this.f168900c;
        if (r102 == null) goto L5;
        r102.setProgress((int) r101);
    L5:
        Iterator r103 = ((ArrayList) this.f168906i).iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Function1 r104 = (Function1) r103.next();
        if (r104 == null) goto L7;
        Unit r105 = (Unit) r104.invoke(Float.valueOf(r100));
        goto L7
    L11:
        VideoCoverLayout r106 = this.C;
        if (r106 == null) goto L20;
        r106.setProgress(r100 / 100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void R(boolean r100) {
        View r101 = this.f168899b;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        goto L8
    L6:
        r102 = 8;
    L8:
        c63.d r103 = this.f168907j;
        if (r103 == null) goto L12;
        r103.d();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void V(boolean r100) {
        ImageView r101 = this.f168898a;
        if (r101 == null) goto L5;
        r101.setSelected(!r100);
    L5:
        VideoCoverLayout r102 = this.C;
        if (r102 == null) goto L9;
        r102.setAudioState(r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
    public final void e(boolean r100) {
        PlayerBlock r101 = this.f168901d;
        if (r101 == null) goto L5;
        int r102 = PlayerBlock.T;
        r101.D(true, r100, false);
    L5:
        PlayerBlock r103 = this.f168901d;
        if (r103 != null) goto L8;
    L10:
        o(true);
        c63.d r104 = this.f168907j;
        String r105 = null;
        if (r104 == null) goto L17;
        String r106 = this.f168904g;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r107 = this.f168902e;
        if (r107 == null) goto L15;
        String r108 = r107.j();
    L16:
        r104.F(r106, r108);
        goto L17
    L15:
        r108 = null;
    L17:
        this.f168916s = "click_tab";
        c63.d r109 = this.f168907j;
        if (r109 == null) goto L24;
        String r110 = getVideoType();
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r111 = this.f168902e;
        if (r111 == null) goto L22;
        r105 = r111.j();
    L22:
        r109.s(r110, r105);
        return;
    L24:
        return;
    L8:
        if (r103.getCompleteMode() == true) goto L10;
        o(false);
        goto L10
    }

    public final void m(GaussianBlurConfig r100) {
        this.f168908k = r100;
        if (r100 == null) goto L8;
        l();
        PlayerBlock r101 = this.f168901d;
        if (r101 == null) goto L9;
        r101.g(new AnchorV4VideoView$configBlurSetting$1(this));
        return;
    L9:
        return;
    }

    public final void o(boolean r110) {
        GaussianBlurConfig r100 = this.f168908k;
        if (r100 != null) goto L5;
        return;
    L5:
        Integer r101 = r100.getFps();
        if (r101 == null) goto L8;
        int r102 = r101.intValue();
    L9:
        Integer r103 = r100.getRadius();
        if (r103 == null) goto L12;
        int r104 = r103.intValue();
    L13:
        if (r110 == false) goto L15;
        this.f168919v = false;
        long r105 = 1000 / ((long) r102);
        Observable<Long> r106 = com.bytedance.android.ec.core.rxjava.a.b(r105, r105, TimeUnit.MILLISECONDS, Schedulers.computation()).filter(new t(this));
    L16:
        fa3.c.a(r106.observeOn(Schedulers.computation()).flatMap(new d(this, r104)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r110, r100), f.f168930a), this);
        return;
    L15:
        r106 = Observable.rangeLong(0, 5).subscribeOn(Schedulers.computation()).filter(new u(this));
        goto L16
    L12:
        r104 = com.bytedance.android.shopping.extensions.b.b(20);
        goto L13
    L8:
        r102 = 24;
        goto L9
    }

    public final void setIsSmallComponent(boolean r110) {
        boolean r100 = false;
        if (r110 == false) goto L5;
    L20:
        VideoCoverLayout r111 = this.C;
        if (r111 != null) goto L58;
        ImageView r112 = this.f168898a;
        if (r112 == null) goto L30;
        PlayerBlock r101 = this.f168901d;
        if (r101 != null) goto L27;
    L28:
        r100 = true;
    L29:
        r112.setSelected(r100);
        goto L30
    L27:
        if (r101.f164950o == true) goto L29;
    L30:
        ImageView r113 = this.f168898a;
        if (r113 == null) goto L33;
        r113.setOnClickListener(new v(this));
    L33:
        View r114 = this.f168899b;
        if (r114 == null) goto L36;
        r114.setVisibility(8);
    L36:
        boolean r115 = com.bytedance.android.shopping.anchorv4.experiment.d.a();
        if (r115 == false) goto L41;
        View r102 = this.f168899b;
        if (r102 == null) goto L41;
        r102.setPadding(com.bytedance.android.shopping.extensions.b.b(15), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(15), com.bytedance.android.shopping.extensions.b.b(8));
    L41:
        ImageView r103 = this.f168898a;
        if (r103 == null) goto L52;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r115 == false) goto L46;
        int r105 = 40;
    L47:
        r104.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r105));
        if (r115 == false) goto L50;
        int r106 = 20;
    L51:
        r104.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r106));
        Unit r107 = Unit.INSTANCE;
        r103.setLayoutParams(r104);
        goto L52
    L50:
        r106 = 24;
        goto L51
    L46:
        r105 = 36;
    L52:
        ImageView r108 = this.f168898a;
        if (r108 == null) goto L67;
        if (r115 == false) goto L56;
        int r116 = R.drawable.commerce_anchor_v4_audio_status_new;
    L57:
        r108.setImageResource(r116);
        return;
    L56:
        r116 = R.drawable.commerce_anchor_v4_audio_status;
        goto L57
    L67:
        return;
    L58:
        PlayerBlock r109 = this.f168901d;
        if (r109 != null) goto L61;
    L63:
        r111.setAudioState(r100);
        return;
    L61:
        if (r109.f164950o != true) goto L63;
        r100 = true;
        goto L63
    L5:
        if (com.bytedance.android.shopping.anchorv4.video.p007float.e.b() == false) goto L20;
        View r117 = this.f168899b;
        if (r117 == null) goto L9;
        r117.setVisibility(8);
    L9:
        ProgressBar r118 = this.f168900c;
        if (r118 == null) goto L12;
        r118.setVisibility(8);
    L12:
        this.f168898a = null;
        this.f168899b = null;
        this.f168900c = null;
        VideoCoverLayout r119 = new VideoCoverLayout(getContext(), new n(this));
        this.C = r119;
        Unit r120 = Unit.INSTANCE;
        ViewGroup.LayoutParams r121 = new FrameLayout.LayoutParams(-1, -1);
        PlayerBlock r122 = this.f168901d;
        int r123 = getChildCount();
        int r124 = 0;
        int r125 = -1;
    L13:
        if (r124 >= r123) goto L18;
        if (Intrinsics.areEqual(getChildAt(r124), r122) == true) goto L19;
        r125 = r124;
        r124 = r124 + 1;
    L19:
        addView(r119, r124 + 1, r121);
        goto L20
    L18:
        r124 = r125;
        goto L19
    }

    public static final void g(AnchorV4VideoView r100, Bitmap r101) {
        View r102 = r100.f168909l;
        if (r102 == null) goto L24;
        ImageView r103 = (ImageView) r102.findViewById(R.id.player_block_blur_image);
        r103.setVisibility(0);
        r102.findViewById(R.id.player_block_blur_mask);
        if (r100.f168912o == true) goto L9;
        r102.setVisibility(0);
        r100.f168912o = true;
    L9:
        if (r100.f168913p == true) goto L11;
    L13:
        float r104 = 2.0f;
    L14:
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        r105.width = (int) (r101.getWidth() * r104);
        r105.height = (int) (r104 * r101.getHeight());
        Unit r106 = Unit.INSTANCE;
        r103.setLayoutParams(r105);
        Drawable r107 = r103.getDrawable();
        if ((r107 instanceof BitmapDrawable) == true) goto L17;
        r107 = null;
    L17:
        BitmapDrawable r108 = (BitmapDrawable) r107;
        if (r108 == null) goto L22;
        Bitmap r109 = r108.getBitmap();
        if (r109 == null) goto L22;
        r109.recycle();
    L22:
        r103.setImageBitmap(r101);
        return;
    L11:
        if (r100.f168914q == false) goto L13;
        r104 = 2.5f;
        goto L14
    }

    public AnchorV4VideoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.E = new fa3.b();
        this.f168906i = new ArrayList();
        this.f168915r = -1;
        this.f168916s = "auto";
        this.f168922y = new c(this);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v4_head_video_layout, this, true);
        this.f168898a = (ImageView) findViewById(R.id.iv_audio_status);
        this.f168899b = findViewById(R.id.iv_audio_status_holder);
        this.f168900c = (ProgressBar) findViewById(R.id.pb_media_progress);
        PlayerBlock r103 = (PlayerBlock) findViewById(R.id.player_block);
        this.f168901d = r103;
        ViewGroup.LayoutParams r104 = null;
        if (r103 == null) goto L5;
        int r105 = PlayerBlock.T;
        r103.q(true, null, null);
    L5:
        if (r103 == null) goto L7;
        r103.setPlayBlockClickListener(new AnonymousClass1(this));
    L7:
        if (r103 == null) goto L9;
        r103.g(new AnonymousClass2(this));
    L9:
        if (r103 == null) goto L11;
        r103.i(this);
    L11:
        if (r103 == null) goto L13;
        r103.f164944i = new AnonymousClass3(this);
    L13:
        if (r103 == null) goto L15;
        r103.post(new a(this));
    L15:
        View r106 = findViewById(R.id.player_block_blur_layout);
        this.f168909l = r106;
        if (r106 == null) goto L20;
        wg.a.a(r106);
        if (r103 == null) goto L20;
        r103.addView(r106, 0);
    L20:
        if (r103 == null) goto L22;
        ECDraweeView r107 = (ECDraweeView) r103.findViewById(R.id.blur_background_shadow_image);
    L23:
        this.f168910m = r107;
        AnchorV4CommentVideoEntryLayout r108 = (AnchorV4CommentVideoEntryLayout) findViewById(R.id.comment_video_entry_layout);
        this.f168918u = r108;
        d83.b r109 = getHeadAbility();
        if (r109 == null) goto L26;
        Boolean r110 = Boolean.valueOf(r109.g());
    L28:
        if (com.bytedance.android.shopping.extensions.k.i(r110) == false) goto L38;
        if (r108 == null) goto L39;
        ViewGroup.LayoutParams r111 = r108.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        r104 = r111;
    L34:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r104;
        if (r112 == null) goto L40;
        r112.bottomMargin = com.bytedance.android.shopping.extensions.b.b(48);
        r108.setLayoutParams(r112);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L26:
        r110 = null;
        goto L28
    L22:
        r107 = null;
        goto L23
    }

    public final void n(String r110, Integer r111, boolean r112) {
        if (this.f168915r >= 0) goto L5;
        return;
    L5:
        long r100 = SystemClock.elapsedRealtime();
        c63.d r101 = this.f168907j;
        if (r101 == null) goto L16;
        String r102 = this.f168916s;
        if (this.f168914q == false) goto L10;
        String r103 = com.bytedance.android.ec.core.event.a.VALUE_INFLOW;
    L11:
        long r104 = r100 - this.f168915r;
        String r113 = getVideoType();
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r105 = this.f168902e;
        if (r105 == null) goto L14;
        String r106 = r105.j();
    L15:
        r101.w(r102, r103, r104, r110, r111, r113, r106, r112, null);
        goto L16
    L14:
        r106 = null;
        goto L15
    L10:
        r103 = "product";
    L16:
        this.f168915r = -1;
    }

    public /* synthetic */ AnchorV4VideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void k(final h83.g r210, final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r211, final com.bytedance.android.shopping.anchorv4.voavhs.head.holder.s r212, Function0 r213) {
        if (r210 != null) goto L5;
        return;
    L5:
        this.f168905h = r210;
        if (r211 == null) goto L8;
        r211.l();
    L8:
        int r100 = 0;
        boolean r101 = true;
        if (r211 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        this.f168913p = r102;
        this.f168914q = r210.f484099i;
        String r103 = null;
        if (r211 == null) goto L17;
        c63.d r104 = r211.t();
    L18:
        this.f168907j = r104;
        if (r211 == null) goto L21;
        r211.u1();
    L21:
        PlayerBlock r105 = this.f168901d;
        if (r105 == null) goto L24;
        r105.setLogAction(this.f168907j);
    L24:
        PlayerBlock r106 = this.f168901d;
        if (r106 == null) goto L27;
        r106.setForbidPlay(r210.f484095e);
    L27:
        PlayerBlock r107 = this.f168901d;
        if (r107 == null) goto L30;
        r107.setVideoType(getVideoType());
    L30:
        this.D = r211;
        PlayerBlock r108 = this.f168901d;
        if (r108 == null) goto L33;
        r108.setAudioInterceptor(new p(r211));
    L33:
        if (r211 == null) goto L39;
        AnchorV4PlayerStateManager r109 = r211.e();
        if (r109 == null) goto L39;
        PlayerBlock r110 = this.f168901d;
        if (r110 == null) goto L39;
        r110.u(r109, new o(r211));
    L39:
        PlayerBlock r111 = this.f168901d;
        if (r111 == null) goto L42;
        r111.setCollisionNegotiator(r210.f484094d);
    L42:
        PlayerBlock r112 = this.f168901d;
        if (r112 == null) goto L50;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r113 = r210.f484091a;
        if (r113 == null) goto L47;
        PlayerViewScene r114 = r113.f164973e;
    L48:
        if (r114 == null) goto L50;
        r112.f164961z = r114;
        goto L50
    L47:
        r114 = null;
    L50:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r115 = r210.f484091a;
        ECUrlModel r116 = r210.f484093c;
        if (r210.f484098h == null) goto L53;
        boolean r117 = true;
    L54:
        Function0<Unit> r118 = new AnchorV4VideoView$bindVideoView$3(r211);
        this.f168902e = r115;
        PlayerBlock r119 = this.f168901d;
        if (r119 == null) goto L57;
        PlayerBlock.m(r119, r115, r116, r117, AVScene.CONTENT_PRODUCT_DETAIL_HEADER, null, r213, 16);
    L57:
        this.f168903f = r118;
        PlayerBlock r120 = this.f168901d;
        if (r120 == null) goto L61;
        r120.setPlayBlockClickListener(new AnchorV4VideoView$bindVideoModel$1(this));
    L61:
        if (this.A == true) goto L69;
        int r121 = ECSdk.f48106a;
        IAdapterService r122 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r122 == null) goto L67;
        com.bytedance.android.ec.adapter.api.j r123 = r122.getLiveWindowService();
        if (r123 == null) goto L67;
        Object r124 = r123.f(this.f168922y);
    L68:
        this.f168923z = r124;
        this.A = true;
    L67:
        r124 = null;
    L69:
        PlayerBlock r125 = this.f168901d;
        if (r125 == null) goto L72;
        r125.setPlayBlockClickListener(new AnchorV4VideoView$bindVideoView$4(this, r210, r212));
    L72:
        View r126 = this.f168909l;
        if (r126 == null) goto L75;
        r126.setVisibility(0);
    L75:
        ECDraweeView r127 = this.f168910m;
        if (r127 == null) goto L95;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r128 = r210.f484091a;
        if (r128 == null) goto L82;
        Integer r129 = r128.l();
        if (r129 == null) goto L82;
        int r130 = r129.intValue();
    L83:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r131 = r210.f484091a;
        if (r131 == null) goto L88;
        Integer r132 = r131.c();
        if (r132 == null) goto L88;
        int r133 = r132.intValue();
    L89:
        r127.setVisibility(0);
        if (r130 <= r133) goto L94;
        ViewGroup.LayoutParams r134 = r127.getLayoutParams();
        r134.width = -1;
        r134.height = -2;
        Unit r135 = Unit.INSTANCE;
        r127.setLayoutParams(r134);
        ECDraweeView r136 = this.f168910m;
        if (r136 == null) goto L94;
        r136.setAdjustMode(2);
    L94:
        y.a(r127, r210.f484093c);
    L88:
        r133 = 1;
    L82:
        r130 = 1;
    L95:
        String r137 = r210.f484096f;
        PlayerBlock r138 = this.f168901d;
        if (r138 == null) goto L98;
        r138.setIndicatorInfo(r137);
    L98:
        PlayerBlock r139 = this.f168901d;
        if (r139 == null) goto L101;
        r139.setContentDescription(r210.f484097g);
    L101:
        this.f168904g = r210.f484092b;
        PlayerBlock r140 = this.f168901d;
        if (r140 == null) goto L104;
        r140.h(new q(this));
    L104:
        Integer r141 = r73.b.f536425b;
        if (r141 == null) goto L107;
        int r142 = r141.intValue();
    L108:
        if (r142 <= 0) goto L110;
        boolean r143 = true;
    L111:
        if (r143 == false) goto L120;
        View r144 = this.f168899b;
        if (r144 == null) goto L120;
        ViewGroup.LayoutParams r145 = r144.getLayoutParams();
        if ((r145 instanceof ViewGroup.MarginLayoutParams) == true) goto L117;
        r145 = null;
    L117:
        ViewGroup.MarginLayoutParams r146 = (ViewGroup.MarginLayoutParams) r145;
        if (r146 == null) goto L120;
        r146.bottomMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r144.setLayoutParams(r146);
    L120:
        h83.a r147 = r210.f484100j;
        if (r147 == null) goto L142;
        AnchorV4CommentVideoEntryLayout r148 = this.f168918u;
        if (r148 == null) goto L137;
        TextWithOneIconElementView r149 = r148.f168866a;
        CommentVideoInfo r150 = r147.f484068a;
        if (r150 == null) goto L127;
        TextWithOneIconElement r151 = r150.getAuthorHead();
    L128:
        TextWithOneIconElementView.b(r149, r151, null, false, null, 14);
        TextWithOneIconElementView r152 = r148.f168867b;
        CommentVideoInfo r153 = r147.f484068a;
        if (r153 == null) goto L131;
        TextWithOneIconElement r154 = r153.getAuthorName();
    L132:
        TextWithOneIconElementView.b(r152, r154, null, false, null, 14);
        TextWithOneIconElementView r155 = r148.f168868c;
        CommentVideoInfo r156 = r147.f484068a;
        if (r156 == null) goto L135;
        TextWithOneIconElement r157 = r156.getMoreText();
    L136:
        TextWithOneIconElementView.b(r155, r157, null, false, null, 14);
        r148.setOnClickListener(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.a(r212));
        goto L137
    L135:
        r157 = null;
        goto L136
    L131:
        r154 = null;
        goto L132
    L127:
        r151 = null;
    L137:
        AnchorV4CommentVideoEntryLayout r158 = this.f168918u;
        if (r158 == null) goto L140;
        r158.setVisibility(0);
        Unit r159 = Unit.INSTANCE;
    L141:
        if (r159 == null) goto L142;
    L145:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r160 = r210.f484091a;
        if (r160 != null) goto L148;
    L177:
        PlayerBlock r161 = this.f168901d;
        if (r161 == null) goto L180;
        r161.g(new AnchorV4VideoView$bindVideoView$10(this));
    L180:
        VideoCoverLayout r162 = this.C;
        if (r162 == null) goto L187;
        PlayerBlock r163 = this.f168901d;
        if (r163 == null) goto L185;
        r100 = (int) r163.s();
    L185:
        r162.setTotalDuration(r100);
        return;
    L187:
        return;
    L148:
        if (r160.m() != true) goto L177;
        PlayerBlock r164 = this.f168901d;
        if (r164 == null) goto L160;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r165 = r210.f484091a;
        r165.p();
        fj.d r166 = r165.f164970b;
        if (r166 == null) goto L154;
        long r167 = r166.f477448o;
    L156:
        if (r167 > 0) goto L159;
        r101 = false;
    L159:
        PlayerBlock.l(r164, Boolean.valueOf(r101), 2);
        goto L160
    L154:
        r167 = 0;
    L160:
        c63.d r168 = this.f168907j;
        if (r168 == null) goto L177;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r169 = this.f168902e;
        if (r169 == null) goto L165;
        String r170 = r169.k(null);
    L166:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r171 = this.f168902e;
        if (r171 == null) goto L169;
        Integer r172 = r171.h();
    L170:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r173 = this.f168902e;
        if (r173 == null) goto L173;
        String r174 = r173.f164969a;
    L174:
        if (r173 == null) goto L176;
        r103 = r173.j();
    L176:
        r168.x(com.bytedance.android.ec.core.event.a.VALUE_MAIN_PICTURE, "dynamic_auto_slient_play", r170, r172, r174, r103);
        goto L177
    L173:
        r174 = null;
        goto L174
    L169:
        r172 = null;
        goto L170
    L165:
        r170 = null;
        goto L166
    L140:
        r159 = null;
    L142:
        AnchorV4CommentVideoEntryLayout r175 = this.f168918u;
        if (r175 == null) goto L145;
        r175.setVisibility(8);
        Unit r176 = Unit.INSTANCE;
        goto L145
    L110:
        r143 = false;
        goto L111
    L107:
        r142 = r73.b.f536424a;
        goto L108
    L53:
        r117 = false;
        goto L54
    L17:
        r104 = null;
        goto L18
    L11:
        if (r211.i() != true) goto L13;
        r102 = true;
        goto L14
    }
}
