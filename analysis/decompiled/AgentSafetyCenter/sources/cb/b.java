package cb;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public int f2240c;

    /* renamed from: f, reason: collision with root package name */
    public float f2241f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f2242g;

    /* renamed from: h, reason: collision with root package name */
    public int f2243h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public za.a f2244j;

    public static boolean b(View view) {
        if (view == null || !view.isPressed()) {
            return false;
        }
        i iVar = view instanceof i ? (i) view : null;
        return iVar != null ? iVar.getPressFeedbackEnabled() : true;
    }

    public final void a() throws Resources.NotFoundException {
        if (this.f2240c == 1) {
            setBackground(null);
            setClipToOutline(false);
            int i = this.f2243h;
            setPadding(0, i, 0, i);
            return;
        }
        Integer num = this.f2242g;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(R.color.stepos_list_group_background);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.f2241f);
        gradientDrawable.setColor(iIntValue);
        setBackground(gradientDrawable);
        setClipToOutline(true);
        setPadding(0, 0, 0, 0);
        c();
    }

    public final void c() throws Resources.NotFoundException {
        int i;
        float[] fArr;
        if (this.f2240c == 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof i) && ((i) childAt).getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return;
        }
        Integer num = this.f2242g;
        int iIntValue = num != null ? num.intValue() : getContext().getColor(R.color.stepos_list_group_background);
        float f5 = this.f2241f;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_list_group_padding_vertical);
        int size2 = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size2) {
            Object obj = arrayList.get(i11);
            i11++;
            int i12 = i10 + 1;
            if (i10 < 0) {
                ac.a.a0();
                throw null;
            }
            i iVar = (i) obj;
            if (size == 1) {
                i = 0;
                fArr = new float[]{f5, f5, f5, f5, f5, f5, f5, f5};
            } else {
                i = 0;
                fArr = i10 == 0 ? new float[]{f5, f5, f5, f5, 0.0f, 0.0f, 0.0f, 0.0f} : i10 == size + (-1) ? new float[]{0.0f, 0.0f, 0.0f, 0.0f, f5, f5, f5, f5} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            }
            iVar.i(fArr, iIntValue, (size == 1 || i10 == 0) ? dimensionPixelSize : i, (size == 1 || i10 == size + (-1)) ? dimensionPixelSize : i);
            i10 = i12;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        View childAt;
        za.a aVar = this.f2244j;
        canvas.getClass();
        super.dispatchDraw(canvas);
        if (!this.i || aVar.f16572a <= 0) {
            return;
        }
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 < childCount) {
                if (getChildAt(childCount).getVisibility() != 8) {
                    break;
                }
            } else {
                childCount = -1;
                break;
            }
        }
        int childCount2 = getChildCount();
        for (int i = 0; i < childCount2 && i != childCount; i++) {
            View childAt2 = getChildAt(i);
            if (childAt2.getVisibility() != 8) {
                int i3 = i + 1;
                int childCount3 = getChildCount();
                while (true) {
                    if (i3 >= childCount3) {
                        childAt = null;
                        break;
                    }
                    childAt = getChildAt(i3);
                    if (childAt.getVisibility() != 8) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (!b(childAt2) && !b(childAt)) {
                    int dividerInsetStart = childAt2 instanceof i ? ((i) childAt2).getDividerInsetStart() : aVar.f16574c;
                    int i10 = aVar.f16574c;
                    aVar.f16574c = dividerInsetStart;
                    za.a.a(aVar, canvas, childAt2.getBottom() - aVar.f16572a, getWidth(), getLayoutDirection());
                    aVar.f16574c = i10;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) throws Resources.NotFoundException {
        super.onViewAdded(view);
        c();
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) throws Resources.NotFoundException {
        super.onViewRemoved(view);
        c();
    }

    public final void setBackgroundMode(int i) throws Resources.NotFoundException {
        this.f2240c = i;
        a();
    }

    public final void setDividerColor(int i) {
        this.f2244j.f16573b = i;
        invalidate();
    }

    public final void setGroupColor(Integer num) throws Resources.NotFoundException {
        this.f2242g = num;
        a();
    }

    public final void setGroupCornerRadius(float f5) throws Resources.NotFoundException {
        this.f2241f = f5;
        a();
    }

    public final void setShowDividers(boolean z10) {
        this.i = z10;
        invalidate();
    }
}
