package com.bytedance.android.accessibilityLib_Core.engine;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig;
import com.bytedance.android.accessibilityLib_Core.config.bean.c;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.processor.RemoteConfigProcessor;
import com.bytedance.android.accessibilityLib_Core.processor.ViewAccessibilityDelegateProcessor;
import com.bytedance.android.accessibilityLib_Core.tool.AccessibilityCommonToolExtKt;
import com.bytedance.android.accessibilityLib_Core.tool.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AccessibilityConfigEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<IBaseConfig> f38239a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<IBaseConfig> f38240b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f38241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList<IBaseConfig> f38242d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ArrayList<h> f38243e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<IBaseConfig, Boolean> f38244f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ArrayList<IBaseLargeTouchAreaConfig> f38245g = null;

    public static final class a implements IBaseLargeTouchAreaConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseConfig f38246a;

        @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig
        public final String name() {
            return this.f38246a.name();
        }

        @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig
        public final List<Integer> supportLayoutRootList() {
            return CollectionsKt.listOf(Integer.valueOf(this.f38246a.layoutRoot()));
        }

        public a(IBaseConfig r100) {
            this.f38246a = r100;
        }
    }

    static {
        f38239a = new ArrayList();
        f38240b = new ArrayList();
        f38242d = new ArrayList();
        f38243e = new ArrayList();
        f38244f = new HashMap();
        f38245g = new ArrayList();
    }

    public static void e() {
        Context r100 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        Iterator<IBaseConfig> r101 = f38239a.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        IBaseConfig r102 = r101.next();
        if (com.bytedance.android.accessibilityLib_Core.engine.a.f38248b[r102.getScope().ordinal()] != 1) goto L7;
        if (("AccessibilityConfigEngine >>> configName = " + r102.name()) == null) goto L11;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L11:
        c(r102);
        goto L4
    L7:
        AccessibilityCommonToolExtKt.a(r102, AccessibilityConfigEngine$analysis$1$1.INSTANCE);
        goto L4
    L12:
        RemoteConfigProcessor.a(true);
    }

    public static void c(IBaseConfig r100) {
        if (r100.getScope() == AccessiblityScope.Fragment) goto L9;
        if (r100.getScope() == AccessiblityScope.Activity) goto L9;
        if (r100.getScope() == AccessiblityScope.ViewGroup) goto L9;
    L13:
        f38242d.add(r100);
        return;
    L9:
        if (r100.enableLargeTouchArea() == false) goto L13;
        if (r100.layoutRoot() == (-1)) goto L13;
        f38245g.add(new a(r100));
        goto L13
    }

    public static void d(final List r100) {
        StringBuilder r101 = new StringBuilder("before remove configList = ");
        ArrayList<IBaseConfig> r102 = f38242d;
        r101.append(r102.size());
        r101.append(", _largeTouchAreaConfigList = ");
        ArrayList<IBaseLargeTouchAreaConfig> r103 = f38245g;
        r101.append(r103.size());
        if (r101.toString() == null) goto L5;
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L5:
        r102.removeAll(CollectionsKt.toSet(r100));
        CollectionsKt.removeAll(r103, new AccessibilityConfigEngine$removeConfigList$1(r100));
        if (("after remove configList = " + r102.size() + ", _largeTouchAreaConfigList = " + r103.size()) == null) goto L9;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return;
    }

    public static h a(int r100, int r101) {
        ArrayList<h> r102 = f38243e;
        h r103 = null;
        if (r102.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<h> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L30;
        h r105 = r104.next();
        h r106 = r105;
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r106) == true) goto L12;
    L26:
        boolean r107 = false;
    L27:
        if (r107 == false) goto L7;
        r103 = r105;
        goto L30
    L12:
        if (c.a(Integer.valueOf(r100)) == false) goto L26;
        int r108 = r106.f38209b;
        if (r108 == r100) goto L17;
    L21:
        if (r108 != r100) goto L26;
        if (("predicateInDynamicLabel step2 true for " + r106) == null) goto L25;
        Context r109 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L25:
        r107 = true;
        goto L27
    L17:
        if (r106.f38208a != r101) goto L21;
        if (("predicateInDynamicLabel step1 true for " + r106) == null) goto L25;
        Context r110 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L30:
        return r103;
    }

    public static boolean b(IBaseConfig r110, ViewAccessibilityDelegateProcessor.a r111) {
        Integer r100 = r110.getVirtualNode().f38152b;
        View r101 = r111.a();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getId());
    L7:
        if (Intrinsics.areEqual(r100, r102) == false) goto L25;
        int r103 = r111.f38294b;
        Integer r104 = r110.getVirtualNode().f38151a;
        if (r104 == null) goto L25;
        if (r103 != r104.intValue()) goto L25;
        View r105 = r111.a();
        if (r105 == null) goto L16;
        Integer r106 = Integer.valueOf(r105.getId());
    L18:
        if (c.a(r106) == false) goto L25;
        if (c.a(Integer.valueOf(r111.f38294b)) == false) goto L25;
        if (("predicate true for v.id = " + r110.getVirtualNode().f38152b + ",resid = " + r110.getVirtualNode().f38151a) == null) goto L24;
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L24:
        return true;
    L16:
        r106 = null;
    L25:
        Integer r107 = r110.getVirtualNode().f38152b;
        View r108 = r111.a();
        if (r108 == null) goto L28;
        Integer r109 = Integer.valueOf(r108.getId());
    L30:
        if (Intrinsics.areEqual(r107, r109) == false) goto L71;
        View r113 = r111.a();
        if (r113 == null) goto L34;
        Integer r114 = Integer.valueOf(r113.getId());
    L36:
        if (c.a(r114) == false) goto L71;
        if (r110.getVirtualNode().f38167q == false) goto L71;
        View r115 = r111.a();
        Integer r116 = r110.getVirtualNode().f38151a;
        if (r116 == null) goto L42;
        int r117 = r116.intValue();
    L43:
        if (r115 != null) goto L46;
    L65:
        boolean r118 = false;
    L66:
        if (r118 == false) goto L71;
        if (("predicate true for v.id = " + r110.getVirtualNode().f38152b + ",resid = " + r110.getVirtualNode().f38151a) == null) goto L70;
        Context r119 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L70:
        return true;
    L46:
        if (c.a(Integer.valueOf(r117)) == false) goto L65;
        ViewParent r120 = r115.getParent();
        View r121 = r115.getRootView();
        int r122 = 0;
    L49:
        if (r120 == null) goto L63;
        if ((!Intrinsics.areEqual(r120, r121)) == false) goto L63;
        if (r122 >= 100) goto L63;
        r122 = r122 + 1;
        if ((r120 instanceof View) == false) goto L61;
        View r123 = (View) r120;
        if (r123.getId() == r117) goto L64;
        if (e.a(r123) != r117) goto L61;
    L64:
        r118 = true;
    L61:
        r120 = r120.getParent();
    L63:
        if (r117 != e.a(r115)) goto L65;
    L42:
        r117 = -1;
        goto L43
    L34:
        r114 = null;
    L71:
        Integer r124 = r110.getVirtualNode().f38152b;
        View r125 = r111.a();
        if (r125 == null) goto L74;
        Integer r126 = Integer.valueOf(r125.getId());
    L76:
        if (Intrinsics.areEqual(r124, r126) == true) goto L78;
    L83:
        r110.getVirtualNode().getClass();
        View r127 = r111.a();
        if (r127 == null) goto L88;
        String r128 = r127.getClass().getCanonicalName();
        if (r128 == null) goto L88;
    L90:
        if (Intrinsics.areEqual(null, r128) == false) goto L97;
        HashMap<IBaseConfig, Boolean> r129 = f38244f;
        if (r129.containsKey(r110) == true) goto L97;
        r129.put(r110, Boolean.TRUE);
        StringBuilder r130 = new StringBuilder("find for viewIdentify = null, virtualIndex = ");
        r110.getVirtualNode().getClass();
        r130.append(r110.getVirtualNode().f38153c);
        if (r130.toString() == null) goto L96;
        Context r131 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L96:
        return true;
    L97:
        return false;
    L88:
        r128 = "null";
        goto L90
    L78:
        if (r110.getVirtualNode().f38167q == true) goto L83;
        if (("predicate true for v.id = " + r110.getVirtualNode().f38152b + ",resid = " + r110.getVirtualNode().f38151a) == null) goto L82;
        Context r132 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L82:
        return true;
    L74:
        r126 = null;
        goto L76
    L28:
        r109 = null;
        goto L30
    L5:
        r102 = null;
        goto L7
    }
}
