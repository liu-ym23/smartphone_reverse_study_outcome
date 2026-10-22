package i7;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f5816a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f5817b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f5818c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.f5818c = cVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        c cVar = this.f5818c;
        ColorStateList colorStateList2 = cVar.f5824o;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f5817b = colorStateList;
        if (cVar.f5823n != 0 && cVar.f5824o != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{f3.a.b(cVar.f5824o.getColorForState(iArr3, 0), cVar.f5823n), f3.a.b(cVar.f5824o.getColorForState(iArr2, 0), cVar.f5823n), cVar.f5823n});
        }
        this.f5816a = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            c cVar = this.f5818c;
            Drawable rippleDrawable = null;
            if (cVar.getText().toString().contentEquals(textView.getText()) && cVar.f5823n != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(cVar.f5823n);
                if (this.f5817b != null) {
                    colorDrawable.setTintList(this.f5816a);
                    rippleDrawable = new RippleDrawable(this.f5817b, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            textView.setBackground(rippleDrawable);
        }
        return view2;
    }
}
