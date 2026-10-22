package com.bytedance.android.livesdk.gift.grouplive.component.dragger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import j80.c;
import j80.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0003\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/grouplive/component/dragger/DraggableContainerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/gift/grouplive/component/dragger/DraggableContainerView$b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/gift/grouplive/component/dragger/DraggableContainerView$b;", "getDragCallback", "()Lcom/bytedance/android/livesdk/gift/grouplive/component/dragger/DraggableContainerView$b;", "setDragCallback", "(Lcom/bytedance/android/livesdk/gift/grouplive/component/dragger/DraggableContainerView$b;)V", "dragCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableContainerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f126290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f126291b;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f126292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f126293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f126294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DraggableContainerView f126295d;

        public a(DraggableContainerView r100) {
            this.f126295d = r100;
            this.f126292a = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
            this.f126293b = new d(0.0f, 0.0f);
            this.f126294c = new d(0.0f, 0.0f);
        }
    }

    public interface b {
        void a();

        void b(d r100);

        void onDragStart();
    }

    public DraggableContainerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DraggableContainerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final b getDragCallback() {
        return this.f126290a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f126290a == null) goto L23;
        a r101 = this.f126291b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 != 0) goto L7;
        r101.f126294c = j80.b.c(r100);
    L19:
        boolean r103 = false;
    L20:
        if (r103 == false) goto L23;
        return true;
    L7:
        if (r102 != 2) goto L19;
        if (c.a(j80.b.c(r100), r101.f126294c) < r101.f126292a) goto L19;
        r101.f126293b = j80.b.c(r100);
        r101.f126295d.requestDisallowInterceptTouchEvent(true);
        b r104 = r101.f126295d.getDragCallback();
        if (r104 == null) goto L14;
        r104.onDragStart();
    L14:
        b r105 = r101.f126295d.getDragCallback();
        if (r105 == null) goto L17;
        r105.b(c.b(j80.b.c(r100), r101.f126294c));
    L17:
        r103 = true;
    L23:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f126290a == null) goto L29;
        a r101 = this.f126291b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 == 0) goto L22;
        if (r102 != 1) goto L8;
        b r103 = r101.f126295d.getDragCallback();
        if (r103 == null) goto L21;
        r103.a();
    L21:
        r101.f126295d.performClick();
    L25:
        boolean r104 = true;
    L26:
        if (r104 == false) goto L29;
        return true;
    L8:
        if (r102 != 2) goto L10;
        d r105 = c.b(j80.b.c(r100), r101.f126293b);
        r101.f126293b = j80.b.c(r100);
        b r106 = r101.f126295d.getDragCallback();
        if (r106 == null) goto L25;
        r106.b(r105);
        goto L25
    L10:
        if (r102 == 3) goto L12;
        r104 = false;
        goto L26
    L12:
        b r107 = r101.f126295d.getDragCallback();
        if (r107 == null) goto L25;
        r107.a();
        goto L25
    L22:
        r101.f126293b = j80.b.c(r100);
        r101.f126295d.requestDisallowInterceptTouchEvent(true);
        b r108 = r101.f126295d.getDragCallback();
        if (r108 == null) goto L25;
        r108.onDragStart();
    L29:
        return super.onTouchEvent(r100);
    }

    public final void setDragCallback(b r100) {
        this.f126290a = r100;
    }

    public DraggableContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f126291b = new a(this);
    }

    public /* synthetic */ DraggableContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
