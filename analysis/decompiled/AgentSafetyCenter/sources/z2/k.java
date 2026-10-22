package z2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f16308a;

    /* renamed from: b, reason: collision with root package name */
    public int f16309b;

    /* renamed from: c, reason: collision with root package name */
    public float f16310c;

    /* renamed from: d, reason: collision with root package name */
    public float f16311d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f16338g);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.f16310c = typedArrayObtainStyledAttributes.getFloat(index, this.f16310c);
            } else if (index == 0) {
                int i3 = typedArrayObtainStyledAttributes.getInt(index, this.f16308a);
                this.f16308a = i3;
                this.f16308a = m.f16325d[i3];
            } else if (index == 4) {
                this.f16309b = typedArrayObtainStyledAttributes.getInt(index, this.f16309b);
            } else if (index == 3) {
                this.f16311d = typedArrayObtainStyledAttributes.getFloat(index, this.f16311d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
