package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public int f16126a;

    /* renamed from: b, reason: collision with root package name */
    public int f16127b;

    /* renamed from: c, reason: collision with root package name */
    public float f16128c;

    /* renamed from: d, reason: collision with root package name */
    public float f16129d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f16157g);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            if (index == 1) {
                this.f16128c = typedArrayObtainStyledAttributes.getFloat(index, this.f16128c);
            } else if (index == 0) {
                int i5 = typedArrayObtainStyledAttributes.getInt(index, this.f16126a);
                this.f16126a = i5;
                this.f16126a = n.f16144d[i5];
            } else if (index == 4) {
                this.f16127b = typedArrayObtainStyledAttributes.getInt(index, this.f16127b);
            } else if (index == 3) {
                this.f16129d = typedArrayObtainStyledAttributes.getFloat(index, this.f16129d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
