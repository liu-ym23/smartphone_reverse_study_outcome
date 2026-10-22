package com.obric.oui.segmentedtab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 \u00122\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0010J\u001f\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\"¨\u0006%"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "e", "()Z", "", "d", "()V", "c", "", "animFraction", "", "scene", "f", "(FLjava/lang/String;)V", "g", "i", "a", "F", "animValue", "Landroid/animation/ValueAnimator;", "b", "Landroid/animation/ValueAnimator;", "pressAnimator", "releaseAnimator", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OTouchAnimView extends RelativeLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f16713d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f16715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f16716c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final float a(float r10) {
            return 1 - (r10 * 0.5f);
        }

        public a() {
        }
    }

    static {
        f16713d = new a(null);
    }

    @JvmOverloads
    public OTouchAnimView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ void a(OTouchAnimView r10, ValueAnimator r11) {
        j(r10, r11);
    }

    public static /* synthetic */ void b(OTouchAnimView r10, ValueAnimator r11) {
        h(r10, r11);
    }

    public static final void h(OTouchAnimView r10, ValueAnimator r11) {
        q.g(r10, "this$0");
        q.g(r11, "animator");
        Object r12 = r11.getAnimatedValue();
        if (r12 == null) goto L7;
        float r13 = ((Float) r12).floatValue();
        r10.f16714a = r13;
        r10.f(r13, "press_anim");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public static final void j(OTouchAnimView r10, ValueAnimator r11) {
        q.g(r10, "this$0");
        q.g(r11, "animator");
        Object r12 = r11.getAnimatedValue();
        if (r12 == null) goto L7;
        float r13 = ((Float) r12).floatValue();
        r10.f16714a = r13;
        r10.f(r13, "release_anim");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public abstract boolean c();

    public final void d() {
        ValueAnimator r10 = this.f16715b;
        if (r10 == null) goto L6;
        r10.cancel();
    L6:
        ValueAnimator r11 = this.f16716c;
        if (r11 == null) goto L11;
        r11.cancel();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "event");
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        g();
    L12:
        return super.dispatchTouchEvent(r10);
    L5:
        if (r11 != 1) goto L7;
    L9:
        i();
        goto L12
    L7:
        if (r11 == 3) goto L9;
        goto L9
    }

    public final boolean e() {
        ValueAnimator r10 = this.f16715b;
        if (r10 != null) goto L6;
    L8:
        ValueAnimator r11 = this.f16716c;
        if (r11 != null) goto L12;
    L14:
        return false;
    L12:
        if (r11.isRunning() != true) goto L14;
        return true;
    L6:
        if (r10.isRunning() != true) goto L8;
        return true;
    }

    public abstract void f(float r10, String r11);

    public final void g() {
        if (c() == true) goto L5;
        return;
    L5:
        ValueAnimator r10 = this.f16716c;
        if (r10 == null) goto L9;
        r10.removeAllUpdateListeners();
    L9:
        ValueAnimator r11 = this.f16716c;
        if (r11 == null) goto L13;
        r11.cancel();
    L13:
        ValueAnimator r12 = this.f16715b;
        if (r12 == null) goto L17;
        r12.cancel();
    L17:
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{this.f16714a, 1.0f});
        r13.setDuration(50);
        r13.setInterpolator(new DecelerateInterpolator());
        r13.addUpdateListener(new e(this));
        r13.start();
        this.f16715b = r13;
    }

    public final void i() {
        if (c() == true) goto L5;
        return;
    L5:
        ValueAnimator r10 = this.f16715b;
        if (r10 == null) goto L9;
        r10.removeAllUpdateListeners();
    L9:
        ValueAnimator r11 = this.f16715b;
        if (r11 == null) goto L13;
        r11.cancel();
    L13:
        ValueAnimator r12 = this.f16716c;
        if (r12 == null) goto L17;
        r12.cancel();
    L17:
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{this.f16714a, 0.0f});
        r13.setDuration(200);
        r13.setInterpolator(new DecelerateInterpolator());
        r13.addUpdateListener(new d(this));
        r13.start();
        this.f16716c = r13;
    }

    @JvmOverloads
    public OTouchAnimView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OTouchAnimView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OTouchAnimView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
