package b1;

import a1.C0413f;
import android.util.Property;
import android.view.ViewGroup;

/* renamed from: b1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0556d extends Property<ViewGroup, Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final Property<ViewGroup, Float> f11789a = new C0556d("childrenAlpha");

    private C0556d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(ViewGroup viewGroup) {
        Float f5 = (Float) viewGroup.getTag(C0413f.f6820C);
        return f5 != null ? f5 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ViewGroup viewGroup, Float f5) {
        float fFloatValue = f5.floatValue();
        viewGroup.setTag(C0413f.f6820C, f5);
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            viewGroup.getChildAt(i5).setAlpha(fFloatValue);
        }
    }
}
