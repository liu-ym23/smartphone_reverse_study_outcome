package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatTextView;
import com.amap.api.col.s.ce;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002Y\u0003B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010V\u001a\u00020\u0012¢\u0006\u0004\bW\u0010XR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\"\u00101\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\"\u00105\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\"\u00109\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\"\u0010=\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\"\u0010A\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\"\u0010C\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R*\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0019\u0010S\u001a\u0004\u0018\u00010N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedMarqueeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/widget/Scroller;", "b", "Landroid/widget/Scroller;", "getMScroller", "()Landroid/widget/Scroller;", "setMScroller", "(Landroid/widget/Scroller;)V", "mScroller", "", "c", "Z", "getCanScrollable", "()Z", "setCanScrollable", "(Z)V", "canScrollable", "", "d", "I", "getMScrollVelocity", "()I", "setMScrollVelocity", "(I)V", "mScrollVelocity", "e", "getMaxLoopCount", "setMaxLoopCount", "maxLoopCount", "f", "getScrollStartDelay", "setScrollStartDelay", "scrollStartDelay", ce.f26391f, "getScrollFirstDelay", "setScrollFirstDelay", "scrollFirstDelay", "h", "getScrollTimeInterval", "setScrollTimeInterval", "scrollTimeInterval", RXScreenCaptureService.KEY_INDEX, "getNeedAdaptWidth", "setNeedAdaptWidth", "needAdaptWidth", ce.f26395j, "getMFirst", "setMFirst", "mFirst", ce.f26396k, "getScrollOnVisible", "setScrollOnVisible", "scrollOnVisible", "l", "getScrollMode", "setScrollMode", "scrollMode", "m", "getCurrentLoop", "setCurrentLoop", "currentLoop", OfficeSDKRequestTag.KEY_NEW_USER, "getHasAdjusted", "setHasAdjusted", "hasAdjusted", "o", "isScrollEnd", "setScrollEnd", "Lkotlin/Function0;", "", "p", "Lkotlin/jvm/functions/Function0;", "getOnScrollEndAction", "()Lkotlin/jvm/functions/Function0;", "setOnScrollEndAction", "(Lkotlin/jvm/functions/Function0;)V", "onScrollEndAction", "Landroid/util/AttributeSet;", "s", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DeepFeedMarqueeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f174174t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f174175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f174176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f174177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f174178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f174179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f174180f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f174181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f174182h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f174183i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f174184j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f174185k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f174186l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f174187m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f174188n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f174189o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f174190p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f174191q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<b> f174192r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AttributeSet f174193s;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedMarqueeTextView f174194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f174195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f174196c;

        public c(DeepFeedMarqueeTextView r100, int r101, int r102) {
            this.f174194a = r100;
            this.f174195b = r101;
            this.f174196c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Scroller r100 = this.f174194a.getMScroller();     // Catch: Throwable -> L7
            if (r100 == null) goto L5;
            r100.startScroll(0, 0, this.f174195b, 0, this.f174196c);     // Catch: Throwable -> L7
        L5:
            this.f174194a.invalidate();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedMarqueeTextView f174197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f174198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f174199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f174200d;

        public d(DeepFeedMarqueeTextView r100, Integer r101, int r102, int r103) {
            this.f174197a = r100;
            this.f174198b = r101;
            this.f174199c = r102;
            this.f174200d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Scroller r100 = this.f174197a.getMScroller();     // Catch: Throwable -> L14
            if (r100 == null) goto L12;
            int r101 = this.f174198b.intValue();     // Catch: Throwable -> L14
            Integer r102 = this.f174198b;     // Catch: Throwable -> L14
            if (r102 != null) goto L8;
        L10:
            int r103 = -this.f174199c;
        L11:
            r100.startScroll(r101, 0, r103, 0, this.f174200d);     // Catch: Throwable -> L14
            goto L12
        L8:
            if (r102.intValue() != 0) goto L10;
            r103 = this.f174199c;     // Catch: Throwable -> L14
        L12:
            this.f174197a.invalidate();     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L18;
            return;
        L18:
            throw th;
        }
    }

    static {
    }

    public DeepFeedMarqueeTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedMarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void y() {
        if (this.f174187m < this.f174179e) goto L8;
        this.f174189o = true;
        Function0<Unit> r100 = this.f174190p;
        if (r100 == null) goto L34;
        Unit r101 = r100.invoke();
        return;
    L34:
        return;
    L8:
        setHorizontallyScrolling(true);
        Scroller r102 = this.f174176b;
        if (r102 == null) goto L11;
        setScroller(r102);
    L11:
        int r103 = x() - getMeasuredWidth();
        if (r103 > 0) goto L17;
        this.f174189o = true;
        Function0<Unit> r104 = this.f174190p;
        if (r104 == null) goto L35;
        Unit r105 = r104.invoke();
        return;
    L35:
        return;
    L17:
        this.f174189o = false;
        int r106 = (r103 * 100) / this.f174178d;
        if (this.f174184j == false) goto L20;
        new Handler(Looper.getMainLooper()).postDelayed(new c(this, r103, r106), this.f174180f);
        return;
    L20:
        Scroller r107 = this.f174176b;
        if (r107 == null) goto L23;
        Integer r108 = Integer.valueOf(r107.getCurrX());
    L24:
        if (r108 == null) goto L37;
        r108.intValue();
        if (r108.intValue() != r103) goto L29;
        this.f174187m++;
    L29:
        if (r108.intValue() != 0) goto L31;
        int r109 = this.f174182h;
    L32:
        postDelayed(new d(this, r108, r103, r106), r109);
        return;
    L31:
        r109 = this.f174181g;
        goto L32
    L37:
        return;
    L23:
        r108 = null;
        goto L24
    }

    @Override // android.widget.TextView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f174189o == false) goto L5;
        return;
    L5:
        Scroller r100 = this.f174176b;
        if (r100 != null) goto L9;
        return;
    L9:
        if (this.f174177c == true) goto L11;
        return;
    L11:
        int r101 = r100.getCurrX();
        if (r101 == this.f174175a) goto L25;
        Iterator r102 = ((ArrayList) this.f174192r).iterator();
    L15:
        if (r102.hasNext() == false) goto L25;
        b r103 = (b) r102.next();
        r103.b();
        Float r104 = Float.valueOf(x() - getMeasuredWidth());
        if (r104.floatValue() <= 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L23;
        r104 = null;
    L23:
        if (r104 == null) goto L15;
        r104.floatValue();
        r103.a();
        goto L15
    L19:
        r105 = false;
    L25:
        this.f174175a = r101;
        Scroller r106 = this.f174176b;
        if (r106 != null) goto L28;
    L44:
        this.f174191q = Boolean.FALSE;
        return;
    L28:
        if (r106.isFinished() != true) goto L44;
        if (this.f174186l != 101) goto L40;
        Scroller r107 = this.f174176b;
        if (r107 == null) goto L40;
        if (r107.getCurrX() != 0) goto L40;
        Scroller r108 = this.f174176b;
        if (r108 == null) goto L51;
        r108.startScroll(0, 0, 0, 0, 0);
        return;
    L51:
        return;
    L40:
        Boolean r109 = this.f174191q;
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r109, r110) == false) goto L43;
        return;
    L43:
        this.f174184j = false;
        y();
        this.f174191q = r110;
    }

    public final int x() {
        TextPaint r100 = getPaint();
        Rect r101 = new Rect();
        String r102 = getText().toString();
        r100.getTextBounds(r102, 0, r102.length(), r101);
        r100.measureText(r102);
        return (int) r100.measureText(r102);
    }

    public final AttributeSet getAttrs() {
        return this.f174193s;
    }

    public final boolean getCanScrollable() {
        return this.f174177c;
    }

    public final int getCurrentLoop() {
        return this.f174187m;
    }

    public final boolean getHasAdjusted() {
        return this.f174188n;
    }

    public final boolean getMFirst() {
        return this.f174184j;
    }

    public final int getMScrollVelocity() {
        return this.f174178d;
    }

    public final Scroller getMScroller() {
        return this.f174176b;
    }

    public final int getMaxLoopCount() {
        return this.f174179e;
    }

    public final boolean getNeedAdaptWidth() {
        return this.f174183i;
    }

    public final Function0<Unit> getOnScrollEndAction() {
        return this.f174190p;
    }

    public final int getScrollFirstDelay() {
        return this.f174181g;
    }

    public final int getScrollMode() {
        return this.f174186l;
    }

    public final boolean getScrollOnVisible() {
        return this.f174185k;
    }

    public final int getScrollStartDelay() {
        return this.f174180f;
    }

    public final int getScrollTimeInterval() {
        return this.f174182h;
    }

    public final void setCanScrollable(boolean r100) {
        this.f174177c = r100;
    }

    public final void setCurrentLoop(int r100) {
        this.f174187m = r100;
    }

    public final void setHasAdjusted(boolean r100) {
        this.f174188n = r100;
    }

    public final void setMFirst(boolean r100) {
        this.f174184j = r100;
    }

    public final void setMScrollVelocity(int r100) {
        this.f174178d = r100;
    }

    public final void setMScroller(Scroller r100) {
        this.f174176b = r100;
    }

    public final void setMaxLoopCount(int r100) {
        this.f174179e = r100;
    }

    public final void setNeedAdaptWidth(boolean r100) {
        this.f174183i = r100;
    }

    public final void setOnScrollEndAction(Function0<Unit> r100) {
        this.f174190p = r100;
    }

    public final void setScrollEnd(boolean r100) {
        this.f174189o = r100;
    }

    public final void setScrollFirstDelay(int r100) {
        this.f174181g = r100;
    }

    public final void setScrollMode(int r100) {
        this.f174186l = r100;
    }

    public final void setScrollOnVisible(boolean r100) {
        this.f174185k = r100;
    }

    public final void setScrollStartDelay(int r100) {
        this.f174180f = r100;
    }

    public final void setScrollTimeInterval(int r100) {
        this.f174182h = r100;
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
    }

    public DeepFeedMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f174193s = r101;
        boolean r103 = true;
        this.f174177c = true;
        this.f174179e = Integer.MAX_VALUE;
        this.f174184j = true;
        this.f174185k = true;
        this.f174192r = new ArrayList();
        this.f174176b = new Scroller(r100, new LinearInterpolator());
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ec_scroll_adapt_width, R.attr.ec_scroll_auto_mode, R.attr.ec_scroll_delay, R.attr.ec_scroll_max_loop, R.attr.ec_scroll_mode, R.attr.ec_scroll_start_delay, R.attr.ec_scroll_time_interval, R.attr.ec_scroll_velocity});
        this.f174178d = r104.getInt(7, 7);
        this.f174186l = r104.getInt(4, 100);
        this.f174180f = r104.getInt(5, 2000);
        this.f174181g = r104.getInt(2, 1000);
        this.f174182h = r104.getInt(6, 1000);
        if (r104.getInt(0, 0) != 1) goto L5;
        boolean r105 = true;
    L6:
        this.f174183i = r105;
        if (r104.getInt(1, 102) == 102) goto L10;
        r103 = false;
    L10:
        this.f174177c = r103;
        this.f174179e = r104.getInt(3, Integer.MAX_VALUE);
        r104.recycle();
        setSingleLine();
        setEllipsize(null);
        return;
    L5:
        r105 = false;
        goto L6
    }

    public /* synthetic */ DeepFeedMarqueeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
