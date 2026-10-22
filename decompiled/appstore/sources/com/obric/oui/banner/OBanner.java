package com.obric.oui.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$styleable;
import com.obric.oui.banner.interfaces.BannerOperator;
import com.obric.oui.banner.interfaces.OnBannerItemClickListener;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0002\u008c\u0001B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0012J\u0019\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u0012J\u001b\u0010!\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010\u0012J\u001f\u0010&\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000eH\u0014¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u000eH\u0014¢\u0006\u0004\b)\u0010\u0012J\u0015\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u001d\u0010/\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u001b¢\u0006\u0004\b/\u00100J\u0015\u00103\u001a\u00020\u000e2\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\u0007¢\u0006\u0004\b5\u00106R\"\u0010=\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010?\u001a\u0004\b@\u0010AR$\u0010F\u001a\u0002072\u0006\u0010C\u001a\u0002078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bD\u00108\u001a\u0004\bE\u0010:R\u0018\u0010H\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010GR\u001b\u0010L\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010?\u001a\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010NR\u0016\u0010R\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010V\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010QR$\u0010[\u001a\u0010\u0012\f\u0012\n X*\u0004\u0018\u00010\u00070\u00070W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010?\u001a\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR$\u0010g\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u00106R\u0016\u0010j\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010QR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010eR\u0016\u0010t\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010QR*\u0010{\u001a\u00020m2\u0006\u0010u\u001a\u00020m8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010o\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010\u007f\u001a\u00020\u001b2\u0006\u0010u\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010|\"\u0004\b}\u0010~R\u0013\u0010\u0081\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u00106R\u0013\u0010\u0083\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u00106R\u0013\u0010\u0085\u0001\u001a\u00020\u00078F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u00106R\u001e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0086\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0016\u0010\u008b\u0001\u001a\u0002078VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010:¨\u0006\u008d\u0001"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lcom/obric/oui/banner/interfaces/BannerOperator;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/banner/BannerData;", "data", "position", "", "p", "(Lcom/obric/oui/banner/BannerData;I)V", "k", "()V", "m", "Lcom/obric/oui/banner/interfaces/OnBannerItemClickListener;", "listener", "setBannerItemClickListener", "(Lcom/obric/oui/banner/interfaces/OnBannerItemClickListener;)V", "n", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "r", "", "dataSet", "setData", "(Ljava/util/List;)V", "currentItemPlayDone", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/obric/oui/banner/BannerStyle;", "style", "setBannerStyle", "(Lcom/obric/oui/banner/BannerStyle;)V", "smoothScroll", "q", "(IZ)Lcom/obric/oui/banner/OBanner;", "Landroidx/viewpager2/widget/ViewPager2$h;", "onPageChangeListener", "setOnPageChangeListener", "(Landroidx/viewpager2/widget/ViewPager2$h;)V", "getCurrentRealPos", "()I", "", "J", "getDelayAfterUserTouch", "()J", "setDelayAfterUserTouch", "(J)V", "delayAfterUserTouch", "Landroidx/viewpager2/widget/ViewPager2;", "Lkotlin/Lazy;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "<set-?>", "o", "getLastUserTouchTime", "lastUserTouchTime", "Lcom/obric/oui/banner/interfaces/OnBannerItemClickListener;", "mBannerItemClickListener", "Lcom/obric/oui/banner/b;", "getAdapter", "()Lcom/obric/oui/banner/b;", "adapter", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "checkAutoPlayRunnable", "s", "Z", "isUserDragging", "t", "pageInvalid", "u", "isAutoSwitchEnabled", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "v", "Landroidx/lifecycle/MutableLiveData;", "_selectedPosition", "Landroidx/viewpager2/widget/c;", "w", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/c;", "compositePageTransformer", FixCard.FixStyle.KEY_X, "Landroidx/viewpager2/widget/ViewPager2$h;", "mOnPageChangeListener", FixCard.FixStyle.KEY_Y, "I", "getStartPosition", "startPosition", "z", "Lcom/obric/oui/banner/BannerStyle;", "mBannerStyle", "A", "isPadGridAdaptEnable", "", "B", "F", "triptychBannerRatio", "C", "mLastWindowWidth", "D", "haveVibratedAfterUserDragging", CommonKey.KEY_VALUE, "E", "getProportion", "()F", "setProportion", "(F)V", "proportion", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isInfiniteSwitchEnabled", "getRealCount", "realCount", "getCurrentItem", "currentItem", "getItemCount", "itemCount", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "selectedPosition", "getAutoSwitchIntervalMs", "autoSwitchIntervalMs", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBanner extends RadiusLayout implements BannerOperator {
    public static final a F = null;
    public boolean A;
    public float B;
    public int C;
    public boolean D;
    public float E;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f12423m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f12424n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f12425o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OnBannerItemClickListener f12426p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f12427q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Runnable f12428r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f12429s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12430t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12431u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MutableLiveData f12432v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f12433w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ViewPager2.h f12434x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12435y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public BannerStyle f12436z;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final BannerStyle a(int r10) {
            if (r10 == 0) goto L11;
            if (r10 == 1) goto L14;
            if (r10 == 2) goto L13;
            return BannerStyle.FILL;
        L13:
            return BannerStyle.TRIPTYCH;
        L14:
            return BannerStyle.INDENT;
        L11:
            return BannerStyle.FILL;
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12439a = null;

        static {
            int[] r10 = new int[BannerStyle.values().length];
            r10[BannerStyle.TRIPTYCH.ordinal()] = 1;
            r10[BannerStyle.FILL.ordinal()] = 2;
            r10[BannerStyle.INDENT.ordinal()] = 3;
            f12439a = r10;
        }
    }

    static {
        F = new a(null);
    }

    @JvmOverloads
    public OBanner(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void g(OBanner r10) {
        l(r10);
    }

    private final com.obric.oui.banner.b getAdapter() {
        return (com.obric.oui.banner.b) this.f12427q.getValue();
    }

    private final androidx.viewpager2.widget.c getCompositePageTransformer() {
        return (androidx.viewpager2.widget.c) this.f12433w.getValue();
    }

    public static final /* synthetic */ OnBannerItemClickListener h(OBanner r10) {
        return r10.f12426p;
    }

    public static final /* synthetic */ BannerStyle i(OBanner r10) {
        return r10.f12436z;
    }

    public static final /* synthetic */ void j(OBanner r10, BannerData r11, int r12) {
        r10.p(r11, r12);
    }

    public static final void l(OBanner r10) {
        q.g(r10, "this$0");
        r10.k();
    }

    @Override // com.obric.oui.banner.interfaces.BannerOperator
    public void currentItemPlayDone() {
        this.f12430t = true;
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L4;
        Integer r11 = null;
    L6:
        if (r11 != null) goto L9;
    L11:
        if (r11 != null) goto L14;
    L16:
        if (r11 != null) goto L19;
    L22:
        return super.dispatchTouchEvent(r10);
    L19:
        if (r11.intValue() != 3) goto L22;
    L20:
        this.f12429s = false;
        this.f12425o = SystemClock.uptimeMillis();
        k();
        goto L22
    L14:
        if (r11.intValue() != 1) goto L16;
    L9:
        if (r11.intValue() != 0) goto L11;
        this.f12429s = true;
        this.D = false;
        goto L22
    L4:
        r11 = Integer.valueOf(r10.getAction());
        goto L6
    }

    @Override // com.obric.oui.banner.interfaces.BannerOperator
    public long getAutoSwitchIntervalMs() {
        return this.f12423m;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getCurrentRealPos() {
        return oc.a.f22548a.a(o(), getCurrentItem(), getRealCount());
    }

    public final long getDelayAfterUserTouch() {
        return this.f12423m;
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final long getLastUserTouchTime() {
        return this.f12425o;
    }

    public final float getProportion() {
        return this.E;
    }

    public final int getRealCount() {
        return getAdapter().b();
    }

    @Override // com.obric.oui.banner.interfaces.BannerOperator
    @NotNull
    public LiveData getSelectedPosition() {
        return this.f12432v;
    }

    public final int getStartPosition() {
        return this.f12435y;
    }

    @NotNull
    public final ViewPager2 getViewPager2() {
        return (ViewPager2) this.f12424n.getValue();
    }

    public final void k() {
        if (this.f12431u == true) goto L5;
    L27:
        tc.e.a("检查换页：开关 false，不换页");
        return;
    L5:
        if (this.f12423m <= 0) goto L27;
        if (this.f12429s == false) goto L12;
        tc.e.a("检查换页：正在拖动，不换页");
        return;
    L12:
        if (isAttachedToWindow() == true) goto L15;
        tc.e.a("剥离window，不换页");
        return;
    L15:
        long r10 = SystemClock.uptimeMillis() - this.f12425o;
        if (r10 >= this.f12423m) goto L23;
        tc.e.a("检查换页: 刚松手" + r10 + " ms，delay换页");
        Handler r11 = getHandler();
        if (r11 == null) goto L29;
        r11.postDelayed(this.f12428r, this.f12423m - r10);
        return;
    L29:
        return;
    L23:
        if (this.f12430t == false) goto L25;
        r();
        return;
    L25:
        tc.e.a("检查换页：不是业务触发的，不换页");
    }

    public final void m() {
        Handler r10 = getHandler();
        if (r10 == null) goto L7;
        r10.removeCallbacks(this.f12428r);
        return;
    }

    public final void n() {
        m();
        this.f12431u = false;
    }

    public final boolean o() {
        return getAdapter().c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.E > 0.0f) goto L6;
        super.onMeasure(r10, r11);
        return;
    L6:
        int r12 = View.MeasureSpec.getSize(r10);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r12 / this.E), Ints.MAX_POWER_OF_TWO));
    }

    public final void p(BannerData r10, int r11) {
        int r12 = oc.a.f22548a.a(o(), getCurrentItem(), getRealCount());
        if (getCurrentItem() != 2) goto L8;
        if (r11 != (getRealCount() - 1)) goto L8;
        q(1, true);
        return;
    L8:
        if (getCurrentItem() != (getItemCount() - 3)) goto L12;
        if (r11 != 0) goto L12;
        q(getItemCount() - 2, true);
        return;
    L12:
        if (r12 != (getRealCount() - 1)) goto L15;
        if (r11 != 0) goto L15;
        q(getCurrentItem() + 1, true);
        return;
    L15:
        if (r12 == 0) goto L17;
    L19:
        if (r12 <= r11) goto L21;
        q(getCurrentItem() - 1, true);
        return;
    L21:
        if (r12 >= r11) goto L23;
        q(getCurrentItem() + 1, true);
        return;
    L23:
        OnBannerItemClickListener r13 = this.f12426p;
        if (r13 == null) goto L34;
        r13.onItemClick(r10, r11);
        return;
    L34:
        return;
    L17:
        if (r11 != (getRealCount() - 1)) goto L19;
        q(getCurrentItem() - 1, true);
    }

    public final OBanner q(int r10, boolean r11) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        Log.w("OBanner", "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
    L9:
        return this;
    L10:
        getViewPager2().j(r10, r11);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e("OBanner", q.p("setCurrentItem error, msg: ", e.getMessage()));
        goto L9
    }

    public final void r() {
        getViewPager2().j(getViewPager2().getCurrentItem() + 1, true);
    }

    public final void setBannerItemClickListener(@NotNull OnBannerItemClickListener r10) {
        q.g(r10, "listener");
        this.f12426p = r10;
    }

    public final void setBannerStyle(@NotNull BannerStyle r10) {
        q.g(r10, "style");
        this.f12436z = r10;
    }

    public final void setData(@NotNull List<? extends BannerData> r10) {
        q.g(r10, "dataSet");
        getAdapter().k(r10);
        int r11 = 1;
        if (r10.size() != 1) goto L6;
        n();
        setInfiniteSwitchEnabled(false);
    L6:
        if (o() == false) goto L9;
        r11 = getRealCount() * 100;
    L12:
        this.f12435y = r11;
        q(r11, false);
        getViewPager2().h();
        return;
    L9:
        if (b.f12439a[this.f12436z.ordinal()] == 1) goto L12;
        r11 = 0;
        goto L12
    }

    public final void setDelayAfterUserTouch(long r10) {
        this.f12423m = r10;
    }

    public final void setInfiniteSwitchEnabled(boolean r10) {
        getAdapter().l(r10);
        getAdapter().notifyDataSetChanged();
    }

    public final void setOnPageChangeListener(@NotNull ViewPager2.h r10) {
        q.g(r10, "onPageChangeListener");
        this.f12434x = r10;
    }

    public final void setProportion(float r10) {
        if (r10 >= 0.0f) goto L5;
        this.E = 0.0f;
        return;
    L5:
        this.E = r10;
        invalidate();
    }

    @JvmOverloads
    public OBanner(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OBanner(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OBanner(@NotNull final Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f12423m = PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS;
        this.f12424n = kotlin.b.b(new OBanner$viewPager2$2(r10));
        this.f12425o = -1;
        this.f12427q = kotlin.b.b(new OBanner$adapter$2(this));
        this.f12428r = new e(this);
        this.f12432v = new MutableLiveData(0);
        this.f12433w = kotlin.b.b(OBanner$compositePageTransformer$2.INSTANCE);
        this.f12436z = BannerStyle.FILL;
        this.B = 0.5625f;
        this.C = -1;
        this.D = true;
        if (r11 == null) goto L6;
        TypedArray r13 = r10.obtainStyledAttributes(r11, R$styleable.OBanner);
        q.f(r13, "context.obtainStyledAttr…trs, R.styleable.OBanner)");
        this.f12436z = F.a(r13.getInt(R$styleable.OBanner_oui_banner_style, 0));
        this.A = r13.getBoolean(R$styleable.OBanner_oui_banner_is_pad_grid_adapt_enable, false);
        setProportion(r13.getFloat(R$styleable.OBanner_oui_banner_proportion, 0.0f));
        this.f12431u = r13.getBoolean(R$styleable.OBanner_oui_banner_enableAutoSwitch, false);
        this.f12423m = r13.getInt(R$styleable.OBanner_oui_banner_autoSwitchInterval, 5000);
        setInfiniteSwitchEnabled(r13.getBoolean(R$styleable.OBanner_oui_banner_enableInfiniteSwitch, true));
        r13.recycle();
        return;
    }
}
