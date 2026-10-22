package r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public int f5029a;

    /* renamed from: b, reason: collision with root package name */
    public int f5030b;

    /* renamed from: c, reason: collision with root package name */
    public float f5031c;
    public float d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f5055g);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            if (index == 1) {
                this.f5031c = typedArrayObtainStyledAttributes.getFloat(index, this.f5031c);
            } else if (index == 0) {
                int i9 = typedArrayObtainStyledAttributes.getInt(index, this.f5029a);
                this.f5029a = i9;
                this.f5029a = n.d[i9];
            } else if (index == 4) {
                this.f5030b = typedArrayObtainStyledAttributes.getInt(index, this.f5030b);
            } else if (index == 3) {
                this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
