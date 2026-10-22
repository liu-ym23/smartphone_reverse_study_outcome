package androidx.fragment.app;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p1.C5044e;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJC\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001b\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010 ¨\u0006#"}, d2 = {"Landroidx/fragment/app/L;", "", "<init>", "()V", "Landroidx/collection/a;", "", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(Landroidx/collection/a;Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/View;", "namedViews", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroidx/collection/a;Landroidx/collection/a;)V", "Landroidx/fragment/app/Fragment;", "inFragment", "outFragment", "", "isPop", "sharedElements", "isStart", Const.INTENT_KEY_APIKEY, "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;ZLandroidx/collection/a;Z)V", "", "views", "", "visibility", "e", "(Ljava/util/List;I)V", "Landroidx/fragment/app/N;", "c", "()Landroidx/fragment/app/N;", "Landroidx/fragment/app/N;", "PLATFORM_IMPL", "SUPPORT_IMPL", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public static final L f14021a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final N PLATFORM_IMPL;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final N SUPPORT_IMPL;

    static {
        L l10 = new L();
        f14021a = l10;
        PLATFORM_IMPL = new M();
        SUPPORT_IMPL = l10.c();
    }

    public static final void a(Fragment inFragment, Fragment outFragment, boolean isPop, androidx.collection.a<String, View> sharedElements, boolean isStart) {
        kotlin.jvm.internal.p.i(inFragment, "inFragment");
        kotlin.jvm.internal.p.i(outFragment, "outFragment");
        kotlin.jvm.internal.p.i(sharedElements, "sharedElements");
        androidx.core.app.s enterTransitionCallback = isPop ? outFragment.getEnterTransitionCallback() : inFragment.getEnterTransitionCallback();
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it = sharedElements.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            ArrayList arrayList2 = new ArrayList(sharedElements.size());
            Iterator<Map.Entry<String, View>> it2 = sharedElements.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getKey());
            }
            if (isStart) {
                enterTransitionCallback.g(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.f(arrayList2, arrayList, null);
            }
        }
    }

    public static final String b(androidx.collection.a<String, String> aVar, String value) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        kotlin.jvm.internal.p.i(value, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : aVar.entrySet()) {
            if (kotlin.jvm.internal.p.d(entry.getValue(), value)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        return (String) Z8.F.s0(arrayList);
    }

    public static final void d(androidx.collection.a<String, String> aVar, androidx.collection.a<String, View> namedViews) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        kotlin.jvm.internal.p.i(namedViews, "namedViews");
        int size = aVar.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!namedViews.containsKey(aVar.valueAt(size))) {
                aVar.removeAt(size);
            }
        }
    }

    public static final void e(List<? extends View> views, int visibility) {
        kotlin.jvm.internal.p.i(views, "views");
        Iterator<T> it = views.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(visibility);
        }
    }

    public final N c() {
        try {
            kotlin.jvm.internal.p.g(C5044e.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (N) C5044e.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
