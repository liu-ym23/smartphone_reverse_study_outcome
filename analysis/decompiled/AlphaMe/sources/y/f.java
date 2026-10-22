package y;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final float f16020a;

    /* renamed from: b, reason: collision with root package name */
    public final float f16021b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16022c;

    /* renamed from: d, reason: collision with root package name */
    public final float f16023d;

    /* renamed from: e, reason: collision with root package name */
    public final int f16024e;

    public f(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        this.f16020a = Float.NaN;
        this.f16021b = Float.NaN;
        this.f16022c = Float.NaN;
        this.f16023d = Float.NaN;
        this.f16024e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.f16160j);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f16024e);
                this.f16024e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new n().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f16023d = typedArrayObtainStyledAttributes.getDimension(index, this.f16023d);
            } else if (index == 2) {
                this.f16021b = typedArrayObtainStyledAttributes.getDimension(index, this.f16021b);
            } else if (index == 3) {
                this.f16022c = typedArrayObtainStyledAttributes.getDimension(index, this.f16022c);
            } else if (index == 4) {
                this.f16020a = typedArrayObtainStyledAttributes.getDimension(index, this.f16020a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
