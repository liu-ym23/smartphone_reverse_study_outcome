package z2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final float f16238a;

    /* renamed from: b, reason: collision with root package name */
    public final float f16239b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16240c;

    /* renamed from: d, reason: collision with root package name */
    public final float f16241d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16242e;

    public f(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        this.f16238a = Float.NaN;
        this.f16239b = Float.NaN;
        this.f16240c = Float.NaN;
        this.f16241d = Float.NaN;
        this.f16242e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), q.f16340j);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 0) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f16242e);
                this.f16242e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new m().a(resourceId, context);
                }
            } else if (index == 1) {
                this.f16241d = typedArrayObtainStyledAttributes.getDimension(index, this.f16241d);
            } else if (index == 2) {
                this.f16239b = typedArrayObtainStyledAttributes.getDimension(index, this.f16239b);
            } else if (index == 3) {
                this.f16240c = typedArrayObtainStyledAttributes.getDimension(index, this.f16240c);
            } else if (index == 4) {
                this.f16238a = typedArrayObtainStyledAttributes.getDimension(index, this.f16238a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
