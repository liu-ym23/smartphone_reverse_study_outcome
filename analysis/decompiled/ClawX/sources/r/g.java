package r;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final float f4963a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4964b;

    /* renamed from: c, reason: collision with root package name */
    public final float f4965c;
    public final float d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4966e;

    public g(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        this.f4963a = Float.NaN;
        this.f4964b = Float.NaN;
        this.f4965c = Float.NaN;
        this.d = Float.NaN;
        this.f4966e = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.f5058j);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            if (index == 0) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f4966e);
                this.f4966e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new n().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.d = typedArrayObtainStyledAttributes.getDimension(index, this.d);
            } else if (index == 2) {
                this.f4964b = typedArrayObtainStyledAttributes.getDimension(index, this.f4964b);
            } else if (index == 3) {
                this.f4965c = typedArrayObtainStyledAttributes.getDimension(index, this.f4965c);
            } else if (index == 4) {
                this.f4963a = typedArrayObtainStyledAttributes.getDimension(index, this.f4963a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
