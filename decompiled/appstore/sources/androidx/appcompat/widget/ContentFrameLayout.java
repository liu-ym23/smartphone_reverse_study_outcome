package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TypedValue f816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TypedValue f817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TypedValue f818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TypedValue f819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TypedValue f821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OnAttachListener f823h;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public void a(int r10, int r11, int r12, int r13) {
        this.f822g.set(r10, r11, r12, r13);
        if (ViewCompat.T(this) == false) goto L6;
        requestLayout();
        return;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f820e != null) goto L6;
        this.f820e = new TypedValue();
    L6:
        return this.f820e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f821f != null) goto L6;
        this.f821f = new TypedValue();
    L6:
        return this.f821f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f818c != null) goto L6;
        this.f818c = new TypedValue();
    L6:
        return this.f818c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f819d != null) goto L6;
        this.f819d = new TypedValue();
    L6:
        return this.f819d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f816a != null) goto L6;
        this.f816a = new TypedValue();
    L6:
        return this.f816a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f817b != null) goto L6;
        this.f817b = new TypedValue();
    L6:
        return this.f817b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener r10 = this.f823h;
        if (r10 == null) goto L6;
        r10.onAttachedFromWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener r10 = this.f823h;
        if (r10 == null) goto L6;
        r10.onDetachedFromWindow();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r14, int r15) {
        DisplayMetrics r10 = getContext().getResources().getDisplayMetrics();
        boolean r11 = true;
        if (r10.widthPixels >= r10.heightPixels) goto L5;
        boolean r12 = true;
    L6:
        int r13 = View.MeasureSpec.getMode(r14);
        int r16 = View.MeasureSpec.getMode(r15);
        if (r13 != Integer.MIN_VALUE) goto L22;
        if (r12 == false) goto L10;
        TypedValue r17 = this.f819d;
    L11:
        if (r17 == null) goto L22;
        int r18 = r17.type;
        if (r18 == 0) goto L22;
        if (r18 != 5) goto L17;
        float r19 = r17.getDimension(r10);
    L16:
        int r110 = (int) r19;
    L20:
        if (r110 <= 0) goto L22;
        Rect r111 = this.f822g;
        r14 = View.MeasureSpec.makeMeasureSpec(Math.min(r110 - (r111.left + r111.right), View.MeasureSpec.getSize(r14)), Ints.MAX_POWER_OF_TWO);
        boolean r112 = true;
    L23:
        if (r16 != Integer.MIN_VALUE) goto L38;
        if (r12 == false) goto L26;
        TypedValue r20 = this.f820e;
    L27:
        if (r20 == null) goto L38;
        int r113 = r20.type;
        if (r113 == 0) goto L38;
        if (r113 != 5) goto L33;
        float r21 = r20.getDimension(r10);
    L32:
        int r22 = (int) r21;
    L36:
        if (r22 <= 0) goto L38;
        Rect r114 = this.f822g;
        r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r22 - (r114.top + r114.bottom), View.MeasureSpec.getSize(r15)), Ints.MAX_POWER_OF_TWO);
        goto L38
    L33:
        if (r113 != 6) goto L35;
        int r115 = r10.heightPixels;
        r21 = r20.getFraction(r115, r115);
        goto L32
    L35:
        r22 = 0;
        goto L36
    L26:
        r20 = this.f821f;
    L38:
        super.onMeasure(r14, r15);
        int r116 = getMeasuredWidth();
        int r23 = View.MeasureSpec.makeMeasureSpec(r116, Ints.MAX_POWER_OF_TWO);
        if (r112 == true) goto L57;
        if (r13 != Integer.MIN_VALUE) goto L57;
        if (r12 == false) goto L43;
        TypedValue r24 = this.f817b;
    L44:
        if (r24 == null) goto L57;
        int r25 = r24.type;
        if (r25 == 0) goto L57;
        if (r25 != 5) goto L50;
        float r26 = r24.getDimension(r10);
    L49:
        int r27 = (int) r26;
    L53:
        if (r27 <= 0) goto L55;
        Rect r28 = this.f822g;
        r27 = r27 - (r28.left + r28.right);
    L55:
        if (r116 >= r27) goto L57;
        r23 = View.MeasureSpec.makeMeasureSpec(r27, Ints.MAX_POWER_OF_TWO);
    L58:
        if (r11 == false) goto L61;
        super.onMeasure(r23, r15);
        return;
    L61:
        return;
    L50:
        if (r25 != 6) goto L52;
        int r29 = r10.widthPixels;
        r26 = r24.getFraction(r29, r29);
        goto L49
    L52:
        r27 = 0;
        goto L53
    L43:
        r24 = this.f816a;
    L57:
        r11 = false;
        goto L58
    L17:
        if (r18 != 6) goto L19;
        int r117 = r10.widthPixels;
        r19 = r17.getFraction(r117, r117);
        goto L16
    L19:
        r110 = 0;
        goto L20
    L10:
        r17 = this.f818c;
    L22:
        r112 = false;
        goto L23
    L5:
        r12 = false;
        goto L6
    }

    public void setAttachListener(OnAttachListener r10) {
        this.f823h = r10;
    }

    public ContentFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ContentFrameLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f822g = new Rect();
    }
}
