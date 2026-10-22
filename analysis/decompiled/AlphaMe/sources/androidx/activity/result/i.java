package androidx.activity.result;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import y.n;
import y.r;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f2435a;

    /* renamed from: b, reason: collision with root package name */
    public int f2436b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2437c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public Object f2438d;

    public i(Context context, XmlResourceParser xmlResourceParser) throws Resources.NotFoundException {
        this.f2436b = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.f16158h);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                this.f2435a = typedArrayObtainStyledAttributes.getResourceId(index, this.f2435a);
            } else if (index == 1) {
                this.f2436b = typedArrayObtainStyledAttributes.getResourceId(index, this.f2436b);
                String resourceTypeName = context.getResources().getResourceTypeName(this.f2436b);
                context.getResources().getResourceName(this.f2436b);
                if ("layout".equals(resourceTypeName)) {
                    n nVar = new n();
                    this.f2438d = nVar;
                    nVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.f2436b, (ViewGroup) null));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
