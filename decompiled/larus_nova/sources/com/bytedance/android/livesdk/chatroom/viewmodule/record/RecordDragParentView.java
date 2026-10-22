package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.DragContainer;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0019\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/RecordDragParentView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/d;", "Ld42/b;", "callback", "", "setDragCallback", "", "getAreaWidth", "getAreaHeight", "getAreaMarginLeft", "getAreaMarginRight", "getAreaMarginTop", "getAreaMarginBottom", "Lkotlin/Function0;", "", "h", "Lkotlin/jvm/functions/Function0;", "getOnOtherAreaTouchListener", "()Lkotlin/jvm/functions/Function0;", "setOnOtherAreaTouchListener", "(Lkotlin/jvm/functions/Function0;)V", "onOtherAreaTouchListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordDragParentView extends FrameLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f115395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d42.b f115396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f115397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f115398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f115399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f115400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f115401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Boolean> f115402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f115403i;

    @Override // d42.d
    public final void d(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "deleteView");
    }

    @Override // d42.d
    public final void j(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "forbiddenView");
    }

    public int getAreaHeight() {
        return getHeight();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.record.d
    public int getAreaWidth() {
        return getWidth();
    }

    public int getAreaMarginBottom() {
        return this.f115401g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.record.d
    public int getAreaMarginLeft() {
        return this.f115398d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.record.d
    public int getAreaMarginRight() {
        return this.f115400f;
    }

    public int getAreaMarginTop() {
        return this.f115399e;
    }

    public final Function0<Boolean> getOnOtherAreaTouchListener() {
        return this.f115402h;
    }

    public RecordDragParentView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // d42.d
    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "dragView");
        addView(r100, new FrameLayout.LayoutParams(-2, -2));
        this.f115395a = r100;
        r100.setX(this.f115398d);
        r100.setY(this.f115399e);
    }

    @Override // d42.c
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "draggingView");
        d42.b r101 = this.f115396b;
        if (r101 == null) goto L5;
        r101.Op(false);
    L5:
        this.f115397c = true;
    }

    @Override // d42.c
    public final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "draggingView");
        d42.b r101 = this.f115396b;
        if (r101 == null) goto L5;
        r101.Op(false);
    L5:
        this.f115397c = true;
    }

    @Override // d42.c
    public final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "draggingView");
        if (this.f115397c == false) goto L9;
        d42.b r101 = this.f115396b;
        if (r101 == null) goto L7;
        r101.onDragStart();
    L7:
        this.f115397c = false;
        return;
    }

    @Override // d42.d
    public final Pair h(DragContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "dragView");
        Float r101 = Float.valueOf(0.0f);
        return TuplesKt.to(r101, r101);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = this.f115395a;
        if (r101 == null) goto L5;
        int r102 = r100.getAction();
        if (r102 == 0) goto L13;
        if (r102 != 1) goto L10;
    L12:
        requestDisallowInterceptTouchEvent(false);
    L23:
        return super.onInterceptTouchEvent(r100);
    L10:
        if (r102 == 3) goto L12;
    L13:
        float r103 = r100.getX();
        float r104 = r100.getY();
        float r105 = r101.getX();
        float r106 = r101.getX() + r101.getWidth();
        if (r103 < r105) goto L23;
        if (r103 > r106) goto L23;
        float r107 = r101.getY();
        float r108 = r101.getY() + r101.getHeight();
        if (r104 < r107) goto L23;
        if (r104 > r108) goto L23;
        requestDisallowInterceptTouchEvent(true);
        goto L23
    L5:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = this.f115395a;
        if (r101 != null) goto L7;
        return super.onTouchEvent(r100);
    L7:
        if (r100.getAction() != 0) goto L26;
        float r102 = r100.getX();
        float r103 = r100.getY();
        float r104 = r101.getX();
        float r105 = r101.getX() + r101.getWidth();
        if (r102 >= r104) goto L12;
    L18:
        Function0<Boolean> r106 = this.f115402h;
        if (r106 == null) goto L23;
        Boolean r107 = r106.invoke();
        if (r107 == null) goto L23;
        boolean r108 = r107.booleanValue();
    L24:
        this.f115403i = r108;
    L23:
        r108 = false;
        goto L24
    L12:
        if (r102 > r105) goto L18;
        float r109 = r101.getY();
        float r110 = r101.getY() + r101.getHeight();
        if (r103 < r109) goto L18;
        if (r103 > r110) goto L18;
    L26:
        if (this.f115403i == false) goto L28;
    L29:
        return true;
    L28:
        if (super.onTouchEvent(r100) == true) goto L29;
        return false;
    }

    @Override // d42.d
    public void setDragCallback(d42.b r100) {
        this.f115396b = r100;
    }

    public final void setOnOtherAreaTouchListener(Function0<Boolean> r100) {
        this.f115402h = r100;
    }

    public RecordDragParentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // d42.d
    public final boolean e(float r100, float r101) {
        if (r100 >= this.f115398d) goto L5;
    L7:
        return false;
    L5:
        if ((r100 + r101) > (getWidth() - this.f115400f)) goto L7;
        return true;
    }

    @Override // d42.d
    public final boolean i(float r100, float r101) {
        if (r100 >= this.f115399e) goto L5;
    L7:
        return false;
    L5:
        if ((r100 + r101) > (getHeight() - this.f115401g)) goto L7;
        return true;
    }

    public RecordDragParentView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f115397c = true;
        this.f115398d = UtilityKotlinExtentionsKt.i(12);
        this.f115399e = UtilityKotlinExtentionsKt.i(128);
        this.f115400f = UtilityKotlinExtentionsKt.i(12);
        this.f115401g = UtilityKotlinExtentionsKt.i(320);
    }

    @Override // d42.d
    public final void a(int r100, int r101, int r102) {
        this.f115398d = r100;
        this.f115399e = r101;
        this.f115400f = r102;
        this.f115401g = 0;
    }
}
