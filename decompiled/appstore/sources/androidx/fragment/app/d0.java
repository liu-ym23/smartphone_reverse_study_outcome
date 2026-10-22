package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import com.bytedance.apm.constant.CommonKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f3319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f3320b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f0 f3321c = null;

    static {
        d0 r10 = new d0();
        f3319a = r10;
        f3320b = new e0();
        f3321c = r10.c();
    }

    public d0() {
    }

    public static final void a(Fragment r10, Fragment r11, boolean r12, ArrayMap r13, boolean r14) {
        kotlin.jvm.internal.q.g(r10, "inFragment");
        kotlin.jvm.internal.q.g(r11, "outFragment");
        kotlin.jvm.internal.q.g(r13, "sharedElements");
        if (r12 == false) goto L5;
        SharedElementCallback r15 = r11.getEnterTransitionCallback();
    L6:
        if (r15 == null) goto L22;
        ArrayList r16 = new ArrayList(r13.size());
        Iterator r17 = r13.entrySet().iterator();
    L9:
        if (r17.hasNext() == false) goto L11;
        r16.add((View) ((Map.Entry) r17.next()).getValue());
        goto L9
    L11:
        ArrayList r18 = new ArrayList(r13.size());
        Iterator r19 = r13.entrySet().iterator();
    L13:
        if (r19.hasNext() == false) goto L16;
        r18.add((String) ((Map.Entry) r19.next()).getKey());
        goto L13
    L16:
        if (r14 == false) goto L18;
        r15.g(r18, r16, null);
        return;
    L18:
        r15.f(r18, r16, null);
        return;
    L22:
        return;
    L5:
        r15 = r10.getEnterTransitionCallback();
        goto L6
    }

    public static final String b(ArrayMap r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r10.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (kotlin.jvm.internal.q.b(r14.getValue(), r11) == false) goto L4;
        r12.put(r14.getKey(), r14.getValue());
        goto L4
    L8:
        ArrayList r15 = new ArrayList(r12.size());
        Iterator r16 = r12.entrySet().iterator();
    L10:
        if (r16.hasNext() == false) goto L13;
        r15.add((String) ((Map.Entry) r16.next()).getKey());
        goto L10
    L13:
        return (String) kotlin.collections.b0.Z(r15);
    }

    public static final void d(ArrayMap r10, ArrayMap r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "namedViews");
        int r12 = r10.size();
    L3:
        r12 = r12 - 1;
        if ((-1) >= r12) goto L9;
        if (r11.containsKey((String) r10.valueAt(r12)) == true) goto L3;
        r10.removeAt(r12);
        goto L3
    }

    public static final void e(List r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "views");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((View) r12.next()).setVisibility(r11);
        goto L4
    }

    public static final boolean f() {
        if (f3320b == null) goto L5;
    L8:
        return true;
    L5:
        if (f3321c != null) goto L8;
        return false;
    }

    public final f0 c() {
        kotlin.jvm.internal.q.e(androidx.transition.d.class, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");     // Catch: Exception -> L6
        return (f0) androidx.transition.d.class.getDeclaredConstructor(null).newInstance(null);
    L9:
        return null;
    }
}
