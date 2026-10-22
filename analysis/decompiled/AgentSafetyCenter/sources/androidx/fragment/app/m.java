package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m implements LayoutInflater.Factory2 {

    /* renamed from: c, reason: collision with root package name */
    public v f1292c;

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        v vVar = this.f1292c;
        a0 a0Var = vVar.f1307c;
        q qVar = vVar.f1323t;
        if (k.class.getName().equals(str)) {
            context.getClass();
            attributeSet.getClass();
            k kVar = new k(context, attributeSet);
            kVar.f1287c = new ArrayList();
            kVar.f1288f = new ArrayList();
            kVar.f1290h = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d4.a.f3190b, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
            }
            String string = typedArrayObtainStyledAttributes.getString(1);
            typedArrayObtainStyledAttributes.recycle();
            int id2 = kVar.getId();
            vVar.g();
            if (classAttribute == null) {
                Iterator it = a0Var.b().iterator();
                if (it.hasNext()) {
                    throw androidx.activity.b.g(it);
                }
                VarHandle.storeStoreFence();
                return kVar;
            }
            if (id2 == -1) {
                od.f.e(k0.a.C("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                return null;
            }
            context.getClassLoader();
            qVar.a(classAttribute);
            throw null;
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d4.a.f3189a);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes2.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes2.getResourceId(1, -1);
            String string2 = typedArrayObtainStyledAttributes2.getString(2);
            typedArrayObtainStyledAttributes2.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = e.class.isAssignableFrom(q.b(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id3 = view != null ? view.getId() : 0;
                    if (id3 == -1 && resourceId == -1 && string2 == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    if (resourceId != -1) {
                        vVar.g();
                    }
                    if (string2 != null) {
                        ArrayList arrayList = a0Var.f1248a;
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            if (arrayList.get(size) != null) {
                                od.f.j();
                                return null;
                            }
                        }
                        Iterator it2 = a0Var.f1249b.values().iterator();
                        while (it2.hasNext()) {
                            if (it2.next() != null) {
                                od.f.j();
                                return null;
                            }
                        }
                    }
                    if (id3 != -1) {
                        vVar.g();
                    }
                    context.getClassLoader();
                    qVar.a(attributeValue);
                    throw null;
                }
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
