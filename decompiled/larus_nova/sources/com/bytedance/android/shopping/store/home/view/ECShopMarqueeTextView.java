package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002Y\u0003B'\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010V\u001a\u00020\u0012¢\u0006\u0004\bW\u0010XR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\"\u00101\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\"\u00105\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\"\u00109\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\"\u0010=\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0014\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\"\u0010A\u001a\u00020\n8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u0010\f\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R\"\u0010C\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010R*\u0010M\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0019\u0010S\u001a\u0004\u0018\u00010N8\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R¨\u0006Z"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECShopMarqueeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/widget/Scroller;", "b", "Landroid/widget/Scroller;", "getMScroller", "()Landroid/widget/Scroller;", "setMScroller", "(Landroid/widget/Scroller;)V", "mScroller", "", "c", "Z", "getCanScrollable", "()Z", "setCanScrollable", "(Z)V", "canScrollable", "", "d", "I", "getMScrollVelocity", "()I", "setMScrollVelocity", "(I)V", "mScrollVelocity", "e", "getMaxLoopCount", "setMaxLoopCount", "maxLoopCount", "f", "getScrollStartDelay", "setScrollStartDelay", "scrollStartDelay", ce.f26391f, "getScrollFirstDelay", "setScrollFirstDelay", "scrollFirstDelay", "h", "getScrollTimeInterval", "setScrollTimeInterval", "scrollTimeInterval", RXScreenCaptureService.KEY_INDEX, "getNeedAdaptWidth", "setNeedAdaptWidth", "needAdaptWidth", ce.f26395j, "getMFirst", "setMFirst", "mFirst", ce.f26396k, "getScrollOnVisible", "setScrollOnVisible", "scrollOnVisible", "l", "getScrollMode", "setScrollMode", "scrollMode", "m", "getCurrentLoop", "setCurrentLoop", "currentLoop", OfficeSDKRequestTag.KEY_NEW_USER, "getHasAdjusted", "setHasAdjusted", "hasAdjusted", "o", "isScrollEnd", "setScrollEnd", "Lkotlin/Function0;", "", "p", "Lkotlin/jvm/functions/Function0;", "getOnScrollEndAction", "()Lkotlin/jvm/functions/Function0;", "setOnScrollEndAction", "(Lkotlin/jvm/functions/Function0;)V", "onScrollEndAction", "Landroid/util/AttributeSet;", "w", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECShopMarqueeTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f184519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f184520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f184521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f184522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f184523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f184524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f184525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f184526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f184527i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f184528j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f184529k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f184530l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f184531m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f184532n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f184533o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function0<Unit> f184534p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f184535q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f184536r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f184537s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Runnable f184538t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<b> f184539u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f184540v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AttributeSet f184541w;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopMarqueeTextView f184542a;

        public c(ECShopMarqueeTextView r100) {
            this.f184542a = r100;
        }

        public final void a() {
            ECShopMarqueeTextView r100 = this.f184542a;
            if (r100.f184537s == true) goto L5;
            return;
        L5:
            if (r100.f184535q == false) goto L7;
            return;
        L7:
            if (r100.getVisibility() != 0) goto L87;
            CharSequence r101 = this.f184542a.getText();
            if (r101 != null) goto L12;
        L15:
            boolean r102 = true;
        L16:
            if (r102 == false) goto L18;
        L76:
            this.f184542a.z("checkScroll, wait for valid layout");
            return;
        L18:
            if (this.f184542a.getMeasuredWidth() <= 0) goto L76;
            int r103 = this.f184542a.getMaxWidth();
            ECShopMarqueeTextView r104 = this.f184542a;
            if (r104.f184532n == true) goto L60;
            if (r104.f184527i == false) goto L40;
            CharSequence r105 = r104.getText();
            if (r105 != null) goto L29;
        L32:
            boolean r106 = true;
        L33:
            if (r106 == true) goto L40;
            if (r104.getVisibility() == 8) goto L40;
            if (r104.getMeasuredWidth() <= 0) goto L40;
            boolean r107 = false;
        L42:
            if (r107 == true) goto L60;
            TextPaint r108 = r104.getPaint();
            String r109 = r104.getText().toString();
            int r110 = r109.length();
        L45:
            if (r110 < 1) goto L60;
            int r111 = (int) r108.measureText(r109, 0, r110);
            if (r111 <= 0) goto L58;
            if (r111 > r104.getMeasuredWidth()) goto L58;
            if (r104.getMaxWidth() == r111) goto L60;
            r104.f184532n = true;
            r104.setMaxWidth(r111);     // Catch: Throwable -> L55
            r104.f184532n = false;
        L55:
            th = move-exception;
            r104.f184532n = false;
            throw th;
        L58:
            r110 = r110 - 1;
            goto L45
        L29:
            if (StringsKt.isBlank(r105) == true) goto L32;
            r106 = false;
        L40:
            r107 = true;
        L60:
            if (this.f184542a.getMaxWidth() == r103) goto L63;
            this.f184542a.C();
            return;
        L63:
            ECShopMarqueeTextView r112 = this.f184542a;
            int r113 = r112.x();
            r112.z("should Scroll, measuredWidth: " + r112.getMeasuredWidth() + ", textLength: " + r113);
            if (r112.getMeasuredWidth() > 0) goto L66;
        L68:
            boolean r114 = false;
        L69:
            if (r114 == false) goto L74;
            this.f184542a.z("checkScroll, shouldScroll");
            this.f184542a.setCanScrollable(true);
            ECShopMarqueeTextView r115 = this.f184542a;
            r115.z("startScroll");
            r115.y();
            r115.f184533o = false;
            r115.f184531m = 0;
            r115.f184536r = null;
            r115.f184519a = 0;
            r115.f184528j = true;
            Scroller r116 = r115.f184520b;
            if (r116 == null) goto L73;
            r116.startScroll(0, 0, 0, 0, 0);
        L73:
            r115.scrollTo(0, 0);
            r115.B();
            return;
        L74:
            this.f184542a.z("checkScroll, should not scroll");
            this.f184542a.D();
            this.f184542a.setScrollEnd(false);
            this.f184542a.A();
            return;
        L66:
            if (r112.getMeasuredWidth() >= r113) goto L68;
            r114 = true;
            goto L69
        L12:
            if (StringsKt.isBlank(r101) == true) goto L15;
            r102 = false;
            goto L16
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopMarqueeTextView f184543a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public d(ECShopMarqueeTextView r100) {
            this.f184543a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            this.f184543a.D();
            this.f184543a.setCurrentLoop(0);
            if (this.f184543a.getCanScrollable() == false) goto L5;
        L6:
            ECShopMarqueeTextView r101 = this.f184543a;
            r101.f184537s = true;
            r101.C();
            return;
        L5:
            if (this.f184543a.f184537s == true) goto L6;
        }
    }

    static {
    }

    public ECShopMarqueeTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECShopMarqueeTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void A() {
        if (this.f184533o == false) goto L5;
        return;
    L5:
        this.f184533o = true;
        y();
        Function0<Unit> r100 = this.f184534p;
        if (r100 == null) goto L9;
        Unit r101 = r100.invoke();
        return;
    }

    public final void B() {
        z("resumeScroll, currentLoop: " + this.f184531m + ", maxLoopCount: " + this.f184523e);
        if (this.f184531m < this.f184523e) goto L6;
        A();
        return;
    L6:
        setHorizontallyScrolling(true);
        Scroller r100 = this.f184520b;
        if (r100 == null) goto L9;
        setScroller(r100);
    L9:
        final int r101 = x() - getMeasuredWidth();
        z("resumeScroll, scrollingLen: " + r101);
        if (r101 > 0) goto L13;
        A();
        return;
    L13:
        final int r102 = (r101 * 100) / this.f184522d;
        if (this.f184528j == false) goto L16;
        long r103 = this.f184524f;
        Function0<Unit> r104 = new ECShopMarqueeTextView$resumeScroll$1(this, r101, r102);
        y();
        com.bytedance.android.shopping.store.home.view.b r105 = new com.bytedance.android.shopping.store.home.view.b(this, r104);
        this.f184538t = r105;
        postDelayed(r105, r103);
        return;
    L16:
        Scroller r106 = this.f184520b;
        if (r106 == null) goto L19;
        final Integer r107 = Integer.valueOf(r106.getCurrX());
    L20:
        if (r107 == null) goto L31;
        r107.intValue();
        if (r107.intValue() != r101) goto L24;
        this.f184531m++;
    L24:
        z("resumeScroll, currentX: " + r107 + ", currentLoop: " + this.f184531m);
        if (r107.intValue() != 0) goto L27;
        int r108 = this.f184526h;
    L28:
        long r109 = r108;
        Function0<Unit> r110 = new ECShopMarqueeTextView$resumeScroll$2(this, r107, r101, r102);
        y();
        com.bytedance.android.shopping.store.home.view.b r111 = new com.bytedance.android.shopping.store.home.view.b(this, r110);
        this.f184538t = r111;
        postDelayed(r111, r109);
        return;
    L27:
        r108 = this.f184525g;
        goto L28
    L31:
        return;
    L19:
        r107 = null;
        goto L20
    }

    public final void C() {
        removeCallbacks(this.f184540v);
        postDelayed(this.f184540v, 32);
    }

    public final void E() {
        z("tryScrollIfNeed");
        this.f184537s = true;
        D();
        C();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f184540v);
        D();
        super.onDetachedFromWindow();
    }

    public final void y() {
        Runnable r100 = this.f184538t;
        if (r100 == null) goto L5;
        removeCallbacks(r100);
    L5:
        this.f184538t = null;
    }

    public final void D() {
        y();
        this.f184533o = true;
        Scroller r100 = this.f184520b;
        if (r100 == null) goto L5;
        r100.forceFinished(true);
    L5:
        Scroller r101 = this.f184520b;
        if (r101 == null) goto L8;
        r101.startScroll(0, 0, 0, 0, 0);
    L8:
        scrollTo(0, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f184533o == false) goto L5;
        return;
    L5:
        Scroller r100 = this.f184520b;
        if (r100 != null) goto L9;
        return;
    L9:
        if (this.f184521c == true) goto L12;
        return;
    L12:
        if (this.f184535q == false) goto L14;
        return;
    L14:
        int r101 = r100.getCurrX();
        if (r101 == this.f184519a) goto L28;
        Iterator r102 = ((ArrayList) this.f184539u).iterator();
    L18:
        if (r102.hasNext() == false) goto L28;
        b r103 = (b) r102.next();
        r103.b();
        Float r104 = Float.valueOf(x() - getMeasuredWidth());
        if (r104.floatValue() <= 0) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == true) goto L26;
        r104 = null;
    L26:
        if (r104 == null) goto L18;
        r104.floatValue();
        r103.a();
        goto L18
    L22:
        r105 = false;
    L28:
        this.f184519a = r101;
        Scroller r106 = this.f184520b;
        if (r106 != null) goto L31;
    L44:
        this.f184536r = Boolean.FALSE;
        return;
    L31:
        if (r106.isFinished() != true) goto L44;
        if (this.f184530l != 101) goto L40;
        Scroller r107 = this.f184520b;
        if (r107 == null) goto L40;
        if (r107.getCurrX() != 0) goto L40;
        D();
        return;
    L40:
        Boolean r108 = this.f184536r;
        Boolean r109 = Boolean.TRUE;
        if (Intrinsics.areEqual(r108, r109) == false) goto L43;
        return;
    L43:
        this.f184528j = false;
        z("computeScroll computeScroll mScroller?.isFinished == true");
        B();
        this.f184536r = r109;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f184537s == true) goto L5;
        return;
    L5:
        if (this.f184535q == false) goto L7;
        return;
    L7:
        if (getVisibility() != 0) goto L12;
        C();
        return;
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
        return this.f184541w;
    }

    public final boolean getCanScrollable() {
        return this.f184521c;
    }

    public final int getCurrentLoop() {
        return this.f184531m;
    }

    public final boolean getHasAdjusted() {
        return this.f184532n;
    }

    public final boolean getMFirst() {
        return this.f184528j;
    }

    public final int getMScrollVelocity() {
        return this.f184522d;
    }

    public final Scroller getMScroller() {
        return this.f184520b;
    }

    public final int getMaxLoopCount() {
        return this.f184523e;
    }

    public final boolean getNeedAdaptWidth() {
        return this.f184527i;
    }

    public final Function0<Unit> getOnScrollEndAction() {
        return this.f184534p;
    }

    public final int getScrollFirstDelay() {
        return this.f184525g;
    }

    public final int getScrollMode() {
        return this.f184530l;
    }

    public final boolean getScrollOnVisible() {
        return this.f184529k;
    }

    public final int getScrollStartDelay() {
        return this.f184524f;
    }

    public final int getScrollTimeInterval() {
        return this.f184526h;
    }

    public final void setCanScrollable(boolean r100) {
        this.f184521c = r100;
    }

    public final void setCurrentLoop(int r100) {
        this.f184531m = r100;
    }

    public final void setHasAdjusted(boolean r100) {
        this.f184532n = r100;
    }

    public final void setMFirst(boolean r100) {
        this.f184528j = r100;
    }

    public final void setMScrollVelocity(int r100) {
        this.f184522d = r100;
    }

    public final void setMScroller(Scroller r100) {
        this.f184520b = r100;
    }

    public final void setMaxLoopCount(int r100) {
        this.f184523e = r100;
    }

    public final void setNeedAdaptWidth(boolean r100) {
        this.f184527i = r100;
    }

    public final void setOnScrollEndAction(Function0<Unit> r100) {
        this.f184534p = r100;
    }

    public final void setScrollEnd(boolean r100) {
        this.f184533o = r100;
    }

    public final void setScrollFirstDelay(int r100) {
        this.f184525g = r100;
    }

    public final void setScrollMode(int r100) {
        this.f184530l = r100;
    }

    public final void setScrollOnVisible(boolean r100) {
        this.f184529k = r100;
    }

    public final void setScrollStartDelay(int r100) {
        this.f184524f = r100;
    }

    public final void setScrollTimeInterval(int r100) {
        this.f184526h = r100;
    }

    public final void z(String r100) {
        dm.a.a("ECShopMarqueeTextView").a("text: " + getText() + ", " + r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 == 0) goto L5;
    L13:
        if (r101 == 0) goto L17;
        removeCallbacks(this.f184540v);
        D();
        return;
    L17:
        return;
    L5:
        if (this.f184529k == false) goto L13;
        if (this.f184521c == true) goto L11;
        if (this.f184537s == false) goto L13;
    L11:
        if (this.f184535q == true) goto L13;
        z("onVisibilityChanged tryScrollIfNeed");
        E();
    }

    public ECShopMarqueeTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f184541w = r101;
        boolean r103 = true;
        this.f184521c = true;
        this.f184523e = Integer.MAX_VALUE;
        this.f184528j = true;
        this.f184529k = true;
        this.f184539u = new ArrayList();
        this.f184540v = new c(this);
        d r104 = new d(this);
        this.f184520b = new Scroller(r100, new LinearInterpolator());
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ec_scroll_adapt_width, R.attr.ec_scroll_auto_mode, R.attr.ec_scroll_delay, R.attr.ec_scroll_max_loop, R.attr.ec_scroll_mode, R.attr.ec_scroll_start_delay, R.attr.ec_scroll_time_interval, R.attr.ec_scroll_velocity});
        this.f184522d = r105.getInt(7, 7);
        this.f184530l = r105.getInt(4, 100);
        this.f184524f = r105.getInt(5, 2000);
        this.f184525g = r105.getInt(2, 1000);
        this.f184526h = r105.getInt(6, 1000);
        if (r105.getInt(0, 0) != 1) goto L5;
        boolean r106 = true;
    L6:
        this.f184527i = r106;
        if (r105.getInt(1, 102) == 102) goto L10;
        r103 = false;
    L10:
        this.f184521c = r103;
        this.f184523e = r105.getInt(3, Integer.MAX_VALUE);
        r105.recycle();
        setSingleLine();
        setEllipsize(null);
        addTextChangedListener(r104);
        return;
    L5:
        r106 = false;
        goto L6
    }

    public /* synthetic */ ECShopMarqueeTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        return;
    L5:
        if (this.f184537s == false) goto L9;
        D();
        C();
        return;
    }
}
