package com.obric.appstore.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.obric.appstore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.apache.http.protocol.HttpRequestExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010.R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010=\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010B\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010.\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u0011R\u0016\u0010D\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010*R\u0014\u0010F\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\bE\u0010.R\u0016\u0010H\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010%R\u0016\u0010J\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010%¨\u0006K"}, d2 = {"Lcom/obric/appstore/view/CommonRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "M", "()V", "slopConstant", "setScrollingTouchSlop", "(I)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "e", "onInterceptTouchEvent", "velocityX", "velocityY", "fling", "(II)Z", "isRequestDisallow", "setRequestDisallow", "(Z)V", "velocity", "N", "(I)I", "", "a", "F", "lastX", "b", "lastY", "c", "Z", "requestDisallow", "d", "scrolling", "I", "mScrollPointerId", "f", "touchSlop", "", "g", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", "pageSource", "h", "getWidgetType", "setWidgetType", "widgetType", "i", "getPosition", "()I", "setPosition", "position", "j", "isFirstScrolling", "k", "FLING_MAX_VELOCITY", "l", "initialX", "m", "initialY", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CommonRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f11113k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f11114l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f11115m;

    public static final class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonRecyclerView f11116a;

        public a(CommonRecyclerView r10) {
            this.f11116a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView r10, int r11) {
            q.g(r10, "recyclerView");
            super.onScrollStateChanged(r10, r11);
            CommonRecyclerView r12 = this.f11116a;
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
        this.f11105c = true;
        this.f11107e = -1;
        this.f11109g = "";
        this.f11110h = "";
        this.f11112j = true;
        this.f11113k = HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        M();
        this.f11108f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        addOnScrollListener(new a(this));
    }

    public static final /* synthetic */ void L(CommonRecyclerView r10, boolean r11) {
        r10.f11106d = r11;
    }

    private final void M() {
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

    public final int N(int r10) {
        if (r10 <= 0) goto L6;
        return Math.min(r10, this.f11113k);
    L6:
        return Math.max(r10, -this.f11113k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (this.f11105c == false) goto L28;
        if (r10 == null) goto L28;
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L8;
        this.f11114l = r10.getRawX();
        this.f11115m = r10.getRawY();
        ViewParent r12 = getParent();
        if (r12 == null) goto L28;
        r12.requestDisallowInterceptTouchEvent(true);
        goto L28
    L8:
        if (r11 != 2) goto L28;
        float r13 = Math.abs(r10.getRawX() - this.f11114l);
        float r14 = Math.abs(r10.getRawY() - this.f11115m);
        if (r14 <= r13) goto L18;
        if (r14 <= this.f11108f) goto L18;
        ViewParent r15 = getParent();
        if (r15 == null) goto L28;
        r15.requestDisallowInterceptTouchEvent(false);
    L18:
        if (r13 <= (r14 * 1.5f)) goto L28;
        if (r13 <= this.f11108f) goto L28;
        ViewParent r16 = getParent();
        if (r16 == null) goto L28;
        r16.requestDisallowInterceptTouchEvent(true);
    L28:
        return super.dispatchTouchEvent(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int r10, int r11) {
        return super.fling(N(r10), r11);
    }

    @Nullable
    public final String getPageSource() {
        return this.f11109g;
    }

    public final int getPosition() {
        return this.f11111i;
    }

    @Nullable
    public final String getWidgetType() {
        return this.f11110h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        q.g(r10, "e");
        RecyclerView.LayoutManager r11 = getLayoutManager();
        if (r11 == null) goto L5;
        int r12 = r10.getActionMasked();
        boolean r13 = true;
        if (r12 != 0) goto L9;
        this.f11103a = r10.getX();
        this.f11104b = r10.getY();
    L35:
        if (r13 == true) goto L38;
        return false;
    L38:
        return super.onInterceptTouchEvent(r10);
    L9:
        if (r12 != 2) goto L35;
        float r14 = r10.getX();
        float r15 = r10.getY();
        float r16 = Math.abs(r14 - this.f11103a);
        float r17 = Math.abs(r15 - this.f11104b);
        if (this.f11112j == false) goto L26;
        if (r17 <= r16) goto L21;
        if (r11.canScrollVertically() == false) goto L26;
        if (TextUtils.isEmpty(this.f11109g) == true) goto L26;
        this.f11112j = false;
        goto L26
    L21:
        if (r11.canScrollHorizontally() == false) goto L26;
        if (TextUtils.isEmpty(this.f11109g) == true) goto L26;
        this.f11112j = false;
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
        this.f11109g = r10;
    }

    public final void setPosition(int r10) {
        this.f11111i = r10;
    }

    public final void setRequestDisallow(boolean r10) {
        this.f11105c = r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int r10) {
        super.setScrollingTouchSlop(r10);
        ViewConfiguration r11 = ViewConfiguration.get(getContext());
        if (r10 != 0) goto L5;
        this.f11108f = r11.getScaledTouchSlop();
        return;
    L5:
        if (r10 != 1) goto L11;
        this.f11108f = r11.getScaledPagingTouchSlop();
        return;
    }

    public final void setWidgetType(@Nullable String r10) {
        this.f11110h = r10;
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
