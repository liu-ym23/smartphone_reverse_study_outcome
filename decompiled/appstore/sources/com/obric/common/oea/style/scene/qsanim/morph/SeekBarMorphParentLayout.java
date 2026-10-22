package com.obric.common.oea.style.scene.qsanim.morph;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import bg.h;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qb.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 62\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\u001b8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\"R\"\u0010*\u001a\u00020$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\"R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00105\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/SeekBarMorphParentLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "initForce", "", "d", "(F)V", "force", "a", "b", "()V", "Landroid/view/MotionEvent;", "motionEvent", "c", "(Landroid/view/MotionEvent;)F", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Landroid/widget/SeekBar;", "Landroid/widget/SeekBar;", "getSeekBarChild", "()Landroid/widget/SeekBar;", "setSeekBarChild", "(Landroid/widget/SeekBar;)V", "seekBarChild", "F", "forceFactor", "Landroid/graphics/PointF;", "Landroid/graphics/PointF;", "getLastTouchPoint", "()Landroid/graphics/PointF;", "setLastTouchPoint", "(Landroid/graphics/PointF;)V", "lastTouchPoint", "lastProgress", "e", "lastForce", "f", "I", "minProgress", "g", "maxProgress", "h", "Z", "invertDirection", "i", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SeekBarMorphParentLayout extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f11842i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SeekBar f11843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f11845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f11847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11850h;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f11842i = new a(null);
    }

    @JvmOverloads
    public SeekBarMorphParentLayout(@NotNull Context r10) {
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public abstract void a(float r10);

    public abstract void b();

    public abstract float c(MotionEvent r10);

    public abstract void d(float r10);

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r11) {
        SeekBar r10 = this.f11843a;
        if (r10 != null) goto L5;
        q.y("seekBarChild");
    L5:
        float r12 = r10.getProgress();
        if (r11 == null) goto L8;
        Integer r13 = Integer.valueOf(r11.getAction());
    L10:
        if (r13 != null) goto L13;
    L20:
        if (r13 != null) goto L23;
    L48:
        if (r13 != null) goto L51;
    L53:
        if (r13 != null) goto L56;
    L19:
        boolean r14 = false;
    L58:
        if (r14 == false) goto L60;
        return true;
    L60:
        if (super.dispatchTouchEvent(r11) == false) goto L63;
        return true;
    L63:
        return false;
    L56:
        if (r13.intValue() != 3) goto L19;
    L57:
        b();
        goto L19
    L51:
        if (r13.intValue() != 1) goto L53;
    L23:
        if (r13.intValue() != 2) goto L48;
        float r15 = c(r11);
        float r16 = (r12 - this.f11846d) / r15;
        float r17 = 0.0f;
        if (r16 != 0.0f) goto L27;
    L31:
        this.f11845c = new PointF(r11.getX(), r11.getY());
        this.f11846d = r12;
        int r18 = this.f11849g;
        if (r12 < r18) goto L34;
    L38:
        r17 = this.f11847e + (this.f11844b * r15);
        if (r17 <= r18) goto L41;
    L44:
        this.f11847e = r17;
        r14 = true;
    L45:
        if (r14 == false) goto L47;
        a(r17);
    L47:
        b.f23627c.a("MorphSeekBarParentLayout", "needMorph: " + r14 + ", force: " + r17 + ", process: " + r12 + ", deltaMove: " + r15 + ", forceFactor: " + this.f11844b + ", f: " + r16);
        goto L58
    L41:
        if (r17 < this.f11848f) goto L44;
        this.f11847e = r12;
    L37:
        r14 = false;
        goto L45
    L34:
        if (r12 <= this.f11848f) goto L38;
        this.f11847e = r12;
        goto L37
    L27:
        if (this.f11850h == false) goto L29;
        float r19 = h.j(r16, -0.3f, -0.1f);
    L30:
        this.f11844b = r19;
        goto L31
    L29:
        r19 = h.j(r16, 0.1f, 0.3f);
        goto L30
    L13:
        if (r13.intValue() != 0) goto L20;
        d(r12);
        this.f11845c = new PointF(r11.getX(), r11.getY());
        this.f11846d = r12;
        this.f11847e = r12;
        if (this.f11850h == false) goto L17;
        float r20 = -0.2f;
    L18:
        this.f11844b = r20;
        goto L19
    L17:
        r20 = 0.2f;
        goto L18
    L8:
        r13 = null;
        goto L10
    }

    @NotNull
    public final PointF getLastTouchPoint() {
        return this.f11845c;
    }

    @NotNull
    public final SeekBar getSeekBarChild() {
        SeekBar r10 = this.f11843a;
        if (r10 != null) goto L5;
        q.y("seekBarChild");
    L5:
        return r10;
    }

    public final void setLastTouchPoint(@NotNull PointF r10) {
        q.g(r10, "<set-?>");
        this.f11845c = r10;
    }

    public final void setSeekBarChild(@NotNull SeekBar r10) {
        q.g(r10, "<set-?>");
        this.f11843a = r10;
    }

    @JvmOverloads
    public SeekBarMorphParentLayout(@NotNull Context r10, @Nullable AttributeSet r11) {
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ SeekBarMorphParentLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public SeekBarMorphParentLayout(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f11845c = new PointF(0.0f, 0.0f);
        this.f11849g = 100;
    }
}
