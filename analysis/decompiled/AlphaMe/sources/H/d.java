package H;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Base64;
import android.widget.TextView;
import java.util.List;
import m1.AbstractC0769a;
import y1.C0987a;
import y1.n;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f659a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final int f660b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f661c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f662d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f663e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f664f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f665g;

    public d(String str, String str2, String str3, List list) {
        str.getClass();
        this.f661c = str;
        str2.getClass();
        this.f662d = str2;
        this.f663e = str3;
        list.getClass();
        this.f665g = list;
        this.f660b = 0;
        this.f664f = str + "-" + str2 + "-" + str3;
    }

    public static d a(int i4, Context context) throws Resources.NotFoundException {
        com.airbnb.lottie.h.f("Cannot create a CalendarItemStyle with a styleResId of 0", i4 != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i4, AbstractC0769a.f13552r);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListY = B0.f.y(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListY2 = B0.f.y(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListY3 = B0.f.y(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        n nVarA = n.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new C0987a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new d(colorStateListY, colorStateListY2, colorStateListY3, dimensionPixelSize, nVarA, rect);
    }

    public final void b(TextView textView) {
        y1.j jVar = new y1.j();
        y1.j jVar2 = new y1.j();
        n nVar = (n) this.f665g;
        jVar.setShapeAppearanceModel(nVar);
        jVar2.setShapeAppearanceModel(nVar);
        jVar.o((ColorStateList) this.f663e);
        float f4 = this.f660b;
        ColorStateList colorStateList = (ColorStateList) this.f664f;
        jVar.f16234b.f16214l = f4;
        jVar.invalidateSelf();
        y1.h hVar = jVar.f16234b;
        if (hVar.f16207e != colorStateList) {
            hVar.f16207e = colorStateList;
            jVar.onStateChange(jVar.getState());
        }
        Object obj = this.f662d;
        textView.setTextColor((ColorStateList) obj);
        RippleDrawable rippleDrawable = new RippleDrawable(((ColorStateList) obj).withAlpha(30), jVar, jVar2);
        Rect rect = (Rect) this.f661c;
        textView.setBackground(new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }

    public final String toString() {
        switch (this.f659a) {
            case 0:
                StringBuilder sb = new StringBuilder();
                sb.append("FontRequest {mProviderAuthority: " + ((String) this.f661c) + ", mProviderPackage: " + ((String) this.f662d) + ", mQuery: " + ((String) this.f663e) + ", mCertificates:");
                int i4 = 0;
                while (true) {
                    List list = (List) this.f665g;
                    if (i4 >= list.size()) {
                        sb.append("}");
                        sb.append("mCertificatesArray: " + this.f660b);
                        return sb.toString();
                    }
                    sb.append(" [");
                    List list2 = (List) list.get(i4);
                    for (int i5 = 0; i5 < list2.size(); i5++) {
                        sb.append(" \"");
                        sb.append(Base64.encodeToString((byte[]) list2.get(i5), 0));
                        sb.append("\"");
                    }
                    sb.append(" ]");
                    i4++;
                }
            default:
                return super.toString();
        }
    }

    public d(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i4, n nVar, Rect rect) {
        com.airbnb.lottie.h.g(rect.left);
        com.airbnb.lottie.h.g(rect.top);
        com.airbnb.lottie.h.g(rect.right);
        com.airbnb.lottie.h.g(rect.bottom);
        this.f661c = rect;
        this.f662d = colorStateList2;
        this.f663e = colorStateList;
        this.f664f = colorStateList3;
        this.f660b = i4;
        this.f665g = nVar;
    }
}
