package com.bytedanceos.appstore.buss.widget.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.appstore.R;
import f9.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010#R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00101\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\"\u00106\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010#\u001a\u0004\b3\u00104\"\u0004\b5\u0010\u000fR\u0016\u00108\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010 R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010\u001bR\u0016\u0010<\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010\u001b¨\u0006="}, d2 = {"Lcom/bytedanceos/appstore/buss/widget/recyclerview/CommonRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "slopConstant", "", "setScrollingTouchSlop", "(I)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "e", "onInterceptTouchEvent", "M", "()V", "", "a", "F", "lastX", "b", "lastY", "c", "Z", "scrolling", "d", "I", "mScrollPointerId", "touchSlop", "", "f", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "g", "getWidgetType", "setWidgetType", "widgetType", "h", "getPosition", "()I", "setPosition", "position", "i", "isFirstScrolling", "j", "initialX", "k", "initialY", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CommonRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f9326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f9327k;

    public static final class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonRecyclerView f9328a;

        public a(CommonRecyclerView r10) {
            this.f9328a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            q.g(r10, "recyclerView");
            super.onScrollStateChanged(r10, r11);
            CommonRecyclerView r12 = this.f9328a;
            if (r11 == 0) goto L5;
            boolean r13 = true;
        L6:
            CommonRecyclerView.L(r12, r13);
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    public CommonRecyclerView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f9320d = -1;
        this.f9322f = "";
        this.f9323g = "";
        this.f9325i = true;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        M();
        this.f9321e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        addOnScrollListener(new a(this));
    }

    public static final /* synthetic */ void L(CommonRecyclerView r10, boolean r11) {
        r10.f9319c = r11;
    }

    public final void M() {
        RecyclerView.ItemAnimator r10 = getItemAnimator();
        if (r10 == null) goto L6;
        r10.w(0);
    L6:
        RecyclerView.ItemAnimator r11 = getItemAnimator();
        if (r11 == null) goto L10;
        r11.x(0);
    L10:
        RecyclerView.ItemAnimator r12 = getItemAnimator();
        if (r12 == null) goto L14;
        r12.z(0);
    L14:
        RecyclerView.ItemAnimator r13 = getItemAnimator();
        if (r13 == null) goto L18;
        r13.A(0);
    L18:
        m r14 = (m) getItemAnimator();
        if (r14 == null) goto L23;
        r14.V(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L30;
        RecyclerView.LayoutManager r11 = getLayoutManager();
        if (r11 == null) goto L30;
        if (r11.canScrollHorizontally() != true) goto L30;
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L10;
        this.f9326j = r10.getRawX();
        this.f9327k = r10.getRawY();
        ViewParent r13 = getParent();
        if (r13 == null) goto L30;
        r13.requestDisallowInterceptTouchEvent(true);
        goto L30
    L10:
        if (r12 != 2) goto L30;
        float r14 = Math.abs(r10.getRawX() - this.f9326j);
        float r15 = Math.abs(r10.getRawY() - this.f9327k);
        if (r15 <= r14) goto L20;
        if (r15 <= this.f9321e) goto L20;
        ViewParent r16 = getParent();
        if (r16 == null) goto L30;
        r16.requestDisallowInterceptTouchEvent(false);
    L20:
        if (r14 <= (r15 * 1.5f)) goto L30;
        if (r14 <= this.f9321e) goto L30;
        ViewParent r17 = getParent();
        if (r17 == null) goto L30;
        r17.requestDisallowInterceptTouchEvent(true);
    L30:
        return super.dispatchTouchEvent(r10);
    }

    @Nullable
    public final String getPageSource() {
        return this.f9322f;
    }

    public final int getPosition() {
        return this.f9324h;
    }

    @Nullable
    public final String getWidgetType() {
        return this.f9323g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        q.g(r10, "e");
        RecyclerView.LayoutManager r11 = getLayoutManager();
        if (r11 == null) goto L5;
        int r12 = r10.getActionMasked();
        boolean r13 = true;
        if (r12 != 0) goto L9;
        this.f9317a = r10.getX();
        this.f9318b = r10.getY();
    L35:
        if (r13 == true) goto L38;
        return false;
    L38:
        return super.onInterceptTouchEvent(r10);
    L9:
        if (r12 != 2) goto L35;
        float r14 = r10.getX();
        float r15 = r10.getY();
        float r16 = Math.abs(r14 - this.f9317a);
        float r17 = Math.abs(r15 - this.f9318b);
        if (this.f9325i == false) goto L26;
        if (r17 <= r16) goto L21;
        if (r11.canScrollVertically() == false) goto L26;
        if (TextUtils.isEmpty(this.f9322f) == true) goto L26;
        this.f9325i = false;
        Bundle r18 = new Bundle();
        r18.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, this.f9322f);
        b.b("move_portrait_allpages", r18);
        goto L26
    L21:
        if (r11.canScrollHorizontally() == false) goto L26;
        if (TextUtils.isEmpty(this.f9322f) == true) goto L26;
        this.f9325i = false;
        Bundle r19 = new Bundle();
        r19.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, this.f9322f);
        r19.putString("widget_position", String.valueOf(this.f9324h));
        r19.putString("widget_type", this.f9323g);
        b.b("move_transverse_control", r19);
    L26:
        if (r17 <= r16) goto L29;
        r13 = r11.canScrollVertically();
        goto L35
    L29:
        if (r11.canScrollHorizontally() == true) goto L31;
    L33:
        r13 = false;
        goto L35
    L31:
        if (r16 <= (r17 * 1.5f)) goto L33;
    L5:
        return super.onInterceptTouchEvent(r10);
    }

    public final void setPageSource(@Nullable String r10) {
        this.f9322f = r10;
    }

    public final void setPosition(int r10) {
        this.f9324h = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int r10) {
        super.setScrollingTouchSlop(r10);
        ViewConfiguration r11 = ViewConfiguration.get(getContext());
        if (r10 != 0) goto L5;
        this.f9321e = r11.getScaledTouchSlop();
        return;
    L5:
        if (r10 != 1) goto L11;
        this.f9321e = r11.getScaledPagingTouchSlop();
        return;
    }

    public final void setWidgetType(@Nullable String r10) {
        this.f9323g = r10;
    }

    public CommonRecyclerView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null);
    }

    public CommonRecyclerView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        this(r10, r11, R.attr.recyclerViewStyle);
    }
}
