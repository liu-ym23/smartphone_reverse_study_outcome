package b1;

import android.graphics.drawable.Drawable;
import android.util.Property;

/* renamed from: b1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0557e extends Property<Drawable, Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final Property<Drawable, Integer> f11790a = new C0557e();

    private C0557e() {
        super(Integer.class, "drawableAlphaCompat");
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
