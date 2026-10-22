package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ECQuickUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECQuickUtilKt$DEFAULT_LIFECYCLE$1 f45525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECQuickUtilKt$DEFAULT_LIFECYCLE_OWNER$1 f45526b = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.ec.core.utils.ECQuickUtilKt$DEFAULT_LIFECYCLE$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.ec.core.utils.ECQuickUtilKt$DEFAULT_LIFECYCLE_OWNER$1] */
    static {
        f45525a = new ECQuickUtilKt$DEFAULT_LIFECYCLE$1();
        f45526b = new ECQuickUtilKt$DEFAULT_LIFECYCLE_OWNER$1();
    }

    public static final LifecycleOwner a(QContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$lifecycleOwnerSafe");
        LifecycleOwner r101 = r100.f450890a;
        if (r101 != null) goto L9;
        Activity r102 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r100.c());
        if ((r102 instanceof LifecycleOwner) == true) goto L8;
        r102 = null;
    L8:
        r101 = (LifecycleOwner) r102;
    L9:
        if (r101 == null) goto L11;
        return r101;
    L11:
        return f45526b;
    }

    public static final <F extends Fragment> F b(QContext r100, Class<F> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$uniqueFragment");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        FragmentActivity r102 = l0.c(r100.c());
        if (r102 == null) goto L16;
        FragmentManager r103 = r102.getSupportFragmentManager();
        if (r103 == null) goto L16;
        List<Fragment> r104 = r103.getFragments();
        if (r104 == null) goto L16;
        Iterator<T> r105 = r104.iterator();
    L10:
        if (r105.hasNext() == false) goto L14;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((Fragment) r106).getClass(), r101) == false) goto L10;
    L15:
        F r107 = (F) r106;
    L17:
        if (r107 == null) goto L19;
        return r107;
    L19:
        if (r102 == null) goto L47;
        FragmentManager r108 = r102.getSupportFragmentManager();
        if (r108 == null) goto L47;
        List<Fragment> r109 = r108.getFragments();
        if (r109 == null) goto L47;
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r109.iterator();
    L26:
        if (r111.hasNext() == false) goto L33;
        Object r112 = r111.next();
        if (((Fragment) r112).getHost() == null) goto L30;
        boolean r113 = true;
    L31:
        if (r113 == false) goto L26;
        r110.add(r112);
        goto L26
    L30:
        r113 = false;
        goto L31
    L33:
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r115 = r110.iterator();
    L35:
        if (r115.hasNext() == false) goto L37;
        r114.add(((Fragment) r115.next()).getChildFragmentManager().getFragments());
        goto L35
    L37:
        List r116 = CollectionsKt.flatten(r114);
        if (r116 == null) goto L47;
        Iterator r117 = r116.iterator();
    L41:
        if (r117.hasNext() == false) goto L45;
        Object r118 = r117.next();
        if (Intrinsics.areEqual(((Fragment) r118).getClass(), r101) == false) goto L41;
    L46:
        Fragment r119 = (Fragment) r118;
    L49:
        if ((r119 instanceof Fragment) == true) goto L52;
        return null;
    L52:
        return (F) r119;
    L45:
        r118 = null;
    L47:
        r119 = null;
        goto L49
    L14:
        r106 = null;
    L16:
        r107 = null;
        goto L17
    }

    public static final <T extends QViewModel> T c(QContext r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$vmOfActivitySafe");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        ComponentCallbacks2 r102 = l0.b(r100.c());
        if ((r102 instanceof ViewModelStoreOwner) == true) goto L5;
        ComponentCallbacks2 r103 = null;
    L6:
        ViewModelStoreOwner r104 = (ViewModelStoreOwner) r103;
        if ((r102 instanceof QViewModelOwner) == true) goto L9;
        r102 = null;
    L9:
        QViewModelOwner r105 = (QViewModelOwner) r102;
        if (r104 == null) goto L16;
        if (r105 == null) goto L16;
        return (T) new ViewModelProvider(r104, r105.o6()).get(r101);
    L16:
        return (T) r100.f(r101);
    L5:
        r103 = r102;
        goto L6
    }

    public static final <T extends QViewModel, F extends Fragment & QViewModelOwner> T d(QContext r100, Class<T> r101, Class<F> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$vmOfFragmentOrActivitySafe");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "fragmentType");
        FragmentActivity r103 = l0.c(r100.c());
        Fragment r104 = null;
        Object r105 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        if (r103 == null) goto L16;
        FragmentManager r106 = r103.getSupportFragmentManager();
        if (r106 == null) goto L16;
        List<Fragment> r107 = r106.getFragments();
        if (r107 == null) goto L16;
        Iterator<T> r108 = r107.iterator();
    L10:
        if (r108.hasNext() == false) goto L14;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((Fragment) r109).getClass(), r102) == false) goto L10;
    L15:
        Fragment r110 = (Fragment) r109;
    L17:
        if (r110 != null) goto L19;
        if (r103 == null) goto L47;
        FragmentManager r111 = r103.getSupportFragmentManager();
        if (r111 == null) goto L47;
        List<Fragment> r112 = r111.getFragments();
        if (r112 == null) goto L47;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L27:
        if (r114.hasNext() == false) goto L34;
        Object r115 = r114.next();
        if (((Fragment) r115).getHost() == null) goto L31;
        boolean r116 = true;
    L32:
        if (r116 == false) goto L27;
        r113.add(r115);
        goto L27
    L31:
        r116 = false;
        goto L32
    L34:
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r118 = r113.iterator();
    L36:
        if (r118.hasNext() == false) goto L38;
        r117.add(((Fragment) r118.next()).getChildFragmentManager().getFragments());
        goto L36
    L38:
        List r119 = CollectionsKt.flatten(r117);
        if (r119 == null) goto L47;
        Iterator r120 = r119.iterator();
    L42:
        if (r120.hasNext() == false) goto L46;
        Object r121 = r120.next();
        if (Intrinsics.areEqual(((Fragment) r121).getClass(), r102) == false) goto L42;
        r105 = r121;
    L46:
        r104 = (Fragment) r105;
    L47:
        if (r104 == null) goto L51;
        return (T) QContext.h(r101, r104);
    L51:
        return (T) c(r100, r101);
    L19:
        return (T) QContext.h(r101, r110);
    L14:
        r109 = null;
    L16:
        r110 = null;
        goto L17
    }
}
