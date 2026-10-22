package g0;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f4190a = yb.k.a(Build.DEVICE, "layoutlib");

    public static final m a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof m) {
                return (m) childAt;
            }
        }
        Context context = viewGroup.getContext();
        m mVar = new m(context);
        mVar.f4167c = 5;
        ArrayList arrayList = new ArrayList();
        mVar.f4168f = arrayList;
        ArrayList arrayList2 = new ArrayList();
        mVar.f4169g = arrayList2;
        p5.l lVar = new p5.l();
        lVar.f9738c = new LinkedHashMap();
        lVar.f9739f = new LinkedHashMap();
        VarHandle.storeStoreFence();
        mVar.f4170h = lVar;
        mVar.setClipChildren(false);
        o oVar = new o(context);
        mVar.addView(oVar);
        arrayList.add(oVar);
        arrayList2.add(oVar);
        mVar.i = 1;
        mVar.setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
        VarHandle.storeStoreFence();
        viewGroup.addView(mVar);
        return mVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.ViewParent] */
    public static final ViewGroup b(View view) {
        while (!(view instanceof ViewGroup)) {
            ?? parent = view.getParent();
            if (!(parent instanceof View)) {
                ad.o.l("Couldn't find a valid parent for ", view, ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?");
                return null;
            }
            view = parent;
        }
        return (ViewGroup) view;
    }
}
