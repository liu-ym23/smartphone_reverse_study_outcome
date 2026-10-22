package androidx.appcompat.widget;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import o0.AbstractC0787C;
import o0.C0798d;

/* loaded from: classes.dex */
public final class T0 extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2966a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T0(Class cls, String str, int i4) {
        super(cls, str);
        this.f2966a = i4;
    }

    public final Float a(View view) {
        switch (this.f2966a) {
            case 6:
                T0 t02 = AbstractC0787C.f13676a;
                return Float.valueOf(view.getTransitionAlpha());
            case 7:
            default:
                return Float.valueOf(view.getPaddingEnd());
            case 8:
                return Float.valueOf(view.getLayoutParams().width);
            case 9:
                return Float.valueOf(view.getLayoutParams().height);
            case 10:
                return Float.valueOf(view.getPaddingStart());
        }
    }

    public final void b(View view, PointF pointF) {
        switch (this.f2966a) {
            case 3:
                int left = view.getLeft();
                int top = view.getTop();
                int iRound = Math.round(pointF.x);
                int iRound2 = Math.round(pointF.y);
                T0 t02 = AbstractC0787C.f13676a;
                view.setLeftTopRightBottom(left, top, iRound, iRound2);
                break;
            case 4:
                int iRound3 = Math.round(pointF.x);
                int iRound4 = Math.round(pointF.y);
                int right = view.getRight();
                int bottom = view.getBottom();
                T0 t03 = AbstractC0787C.f13676a;
                view.setLeftTopRightBottom(iRound3, iRound4, right, bottom);
                break;
            default:
                int iRound5 = Math.round(pointF.x);
                int iRound6 = Math.round(pointF.y);
                int width = view.getWidth() + iRound5;
                int height = view.getHeight() + iRound6;
                T0 t04 = AbstractC0787C.f13676a;
                view.setLeftTopRightBottom(iRound5, iRound6, width, height);
                break;
        }
    }

    public final void c(View view, Float f4) {
        switch (this.f2966a) {
            case 6:
                float fFloatValue = f4.floatValue();
                T0 t02 = AbstractC0787C.f13676a;
                view.setTransitionAlpha(fFloatValue);
                break;
            case 7:
            default:
                view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), f4.intValue(), view.getPaddingBottom());
                break;
            case 8:
                view.getLayoutParams().width = f4.intValue();
                view.requestLayout();
                break;
            case 9:
                view.getLayoutParams().height = f4.intValue();
                view.requestLayout();
                break;
            case 10:
                view.setPaddingRelative(f4.intValue(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
                break;
        }
    }

    public final void d(C0798d c0798d, PointF pointF) {
        switch (this.f2966a) {
            case 1:
                c0798d.getClass();
                c0798d.f13696a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                c0798d.f13697b = iRound;
                int i4 = c0798d.f13701f + 1;
                c0798d.f13701f = i4;
                if (i4 == c0798d.f13702g) {
                    int i5 = c0798d.f13696a;
                    int i6 = c0798d.f13698c;
                    int i7 = c0798d.f13699d;
                    T0 t02 = AbstractC0787C.f13676a;
                    c0798d.f13700e.setLeftTopRightBottom(i5, iRound, i6, i7);
                    c0798d.f13701f = 0;
                    c0798d.f13702g = 0;
                    break;
                }
                break;
            default:
                c0798d.getClass();
                c0798d.f13698c = Math.round(pointF.x);
                int iRound2 = Math.round(pointF.y);
                c0798d.f13699d = iRound2;
                int i8 = c0798d.f13702g + 1;
                c0798d.f13702g = i8;
                if (c0798d.f13701f == i8) {
                    int i9 = c0798d.f13696a;
                    int i10 = c0798d.f13697b;
                    int i11 = c0798d.f13698c;
                    T0 t03 = AbstractC0787C.f13676a;
                    c0798d.f13700e.setLeftTopRightBottom(i9, i10, i11, iRound2);
                    c0798d.f13701f = 0;
                    c0798d.f13702g = 0;
                    break;
                }
                break;
        }
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f2966a) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        return a((View) obj);
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f2966a) {
            case 0:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 1:
                d((C0798d) obj, (PointF) obj2);
                break;
            case 2:
                d((C0798d) obj, (PointF) obj2);
                break;
            case 3:
                b((View) obj, (PointF) obj2);
                break;
            case 4:
                b((View) obj, (PointF) obj2);
                break;
            case 5:
                b((View) obj, (PointF) obj2);
                break;
            case 6:
                c((View) obj, (Float) obj2);
                break;
            case 7:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
            case 8:
                c((View) obj, (Float) obj2);
                break;
            case 9:
                c((View) obj, (Float) obj2);
                break;
            case 10:
                c((View) obj, (Float) obj2);
                break;
            default:
                c((View) obj, (Float) obj2);
                break;
        }
    }
}
