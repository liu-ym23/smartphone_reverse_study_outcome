package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\fH\u0007J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001a\u001a\u00020\u000fH\u0007J,\u0010\u001b\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0007R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/fragment/app/FragmentTransition;", "", "()V", "PLATFORM_IMPL", "Landroidx/fragment/app/FragmentTransitionImpl;", "SUPPORT_IMPL", "callSharedElementStartEnd", "", "inFragment", "Landroidx/fragment/app/Fragment;", "outFragment", "isPop", "", "sharedElements", "Landroidx/collection/ArrayMap;", "", "Landroid/view/View;", "isStart", "resolveSupportImpl", "setViewVisibility", "views", "", "visibility", "", "supportsTransition", "findKeyForValue", "value", "retainValues", "namedViews", "fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FragmentTransition {
    public static final FragmentTransition INSTANCE = null;
    public static final FragmentTransitionImpl PLATFORM_IMPL = null;
    public static final FragmentTransitionImpl SUPPORT_IMPL = null;

    private FragmentTransition() {
    }

    static {
        FragmentTransition r0 = new FragmentTransition();
        INSTANCE = r0;
        PLATFORM_IMPL = new FragmentTransitionCompat21();
        SUPPORT_IMPL = r0.resolveSupportImpl();
    }

    private final FragmentTransitionImpl resolveSupportImpl() {
        Class<?> r2 = Class.forName("androidx.transition.FragmentTransitionSupport");     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");     // Catch: Exception -> L4
        return (FragmentTransitionImpl) r2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        return null;
    }

    @JvmStatic
    public static final String findKeyForValue(ArrayMap<String, String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "value");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r5.next();
        if (Intrinsics.areEqual(r1.getValue(), r4) == false) goto L4;
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L8:
        ArrayList r6 = new ArrayList(r0.size());
        Iterator r7 = r0.entrySet().iterator();
    L10:
        if (r7.hasNext() == false) goto L13;
        r6.add((String) ((Map.Entry) r7.next()).getKey());
        goto L10
    L13:
        return (String) CollectionsKt.firstOrNull(r6);
    }

    @JvmStatic
    public static final void retainValues(ArrayMap<String, String> r2, ArrayMap<String, View> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "namedViews");
        int r0 = r2.size();
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L9;
        if (r3.containsKey(r2.valueAt(r0)) == true) goto L3;
        r2.removeAt(r0);
        goto L3
    }

    @JvmStatic
    public static final void callSharedElementStartEnd(Fragment r1, Fragment r2, boolean r3, ArrayMap<String, View> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "inFragment");
        Intrinsics.checkNotNullParameter(r2, "outFragment");
        Intrinsics.checkNotNullParameter(r4, "sharedElements");
        if (r3 == false) goto L5;
        SharedElementCallback r6 = r2.getEnterTransitionCallback();
    L6:
        if (r6 == null) goto L22;
        ArrayMap<String, View> r7 = r4;
        ArrayList r8 = new ArrayList(r7.size());
        Iterator<Map.Entry<String, View>> r9 = r7.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L11;
        r8.add(r9.next().getValue());
        goto L9
    L11:
        ArrayList r10 = r8;
        ArrayList r11 = new ArrayList(r7.size());
        Iterator<Map.Entry<String, View>> r12 = r7.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        r11.add(r12.next().getKey());
        goto L13
    L15:
        ArrayList r13 = r11;
        if (r5 == false) goto L18;
        r6.onSharedElementStart(r13, r10, null);
        return;
    L18:
        r6.onSharedElementEnd(r13, r10, null);
        return;
    L22:
        return;
    L5:
        r6 = r1.getEnterTransitionCallback();
        goto L6
    }

    @JvmStatic
    public static final void setViewVisibility(List<? extends View> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "views");
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((View) r3.next()).setVisibility(r2);
        goto L4
    }

    @JvmStatic
    public static final boolean supportsTransition() {
        if (PLATFORM_IMPL == null) goto L5;
    L8:
        return true;
    L5:
        if (SUPPORT_IMPL != null) goto L8;
        return false;
    }
}
