package f1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import r.n;
import r.r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f2546a;

    /* renamed from: b, reason: collision with root package name */
    public int f2547b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f2548c;

    public b(View view) {
        this.f2548c = view;
    }

    public b(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        this.f2548c = new ArrayList();
        this.f2547b = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.f5056h);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            if (index == 0) {
                this.f2546a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2546a);
            } else if (index == 1) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2547b);
                this.f2547b = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new n().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public b() {
        this.f2548c = new b[256];
        this.f2546a = 0;
        this.f2547b = 0;
    }

    public b(int i8, int i9) {
        this.f2548c = null;
        this.f2546a = i8;
        int i10 = i9 & 7;
        this.f2547b = i10 == 0 ? 8 : i10;
    }
}
