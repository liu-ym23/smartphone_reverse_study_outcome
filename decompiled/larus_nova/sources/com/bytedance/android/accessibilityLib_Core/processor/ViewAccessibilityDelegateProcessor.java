package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.core.Config2AccessibilityDelegateGenerateProcessor;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.engine.AccessibilityConfigEngine;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ViewAccessibilityDelegateProcessor implements com.bytedance.android.accessibilityLib_Core.processor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f38289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f38290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f38291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k6.a f38292d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<View> f38293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f38295c;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f38293a, r101.f38293a) == true) goto L8;
            return false;
        L8:
            if (this.f38294b == r101.f38294b) goto L10;
            return false;
        L10:
            if (this.f38295c == r101.f38295c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public final int hashCode() {
            WeakReference<View> r100 = this.f38293a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = ((r101 * 31) + this.f38294b) * 31;
            boolean r103 = this.f38295c;
            ?? r104 = r103;
            if (r103 == false) goto L10;
            r104 = 1;
        L10:
            return r102 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "ViewStruct(weakRefView=" + this.f38293a + ", resourceId=" + this.f38294b + ", isLarge=" + this.f38295c + ")";
        }

        public final View a() {
            return this.f38293a.get();
        }

        public a(WeakReference r100, int r101) {
            this.f38293a = r100;
            this.f38294b = r101;
            this.f38295c = false;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBaseConfig f38296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f38297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AccessibilityDelegateCompat f38298c;

        public b(IBaseConfig r100, View r101, AccessibilityDelegateCompat r102) {
            this.f38296a = r100;
            this.f38297b = r101;
            this.f38298c = r102;
        }

        public final void a() {
            if (this.f38296a.getVirtualNode().f38163m == false) goto L17;
            ArrayList<IBaseConfig> r100 = AccessibilityConfigEngine.f38239a;
            IBaseConfig r101 = this.f38296a;
            int r102 = 1;
            if ((r101 instanceof i6.a) == false) goto L7;
        L10:
            boolean r103 = true;
        L11:
            if (r103 == true) goto L17;
            Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
            View r105 = this.f38297b;
            if (this.f38296a.getVirtualNode().f38159i == false) goto L16;
            r102 = 2;
        L16:
            r105.setImportantForAccessibility(r102);
            goto L17
        L7:
            if (Intrinsics.areEqual(r101.name(), "largeTouchArea") == true) goto L10;
            r103 = false;
        L17:
            ViewCompat.setAccessibilityDelegate(this.f38297b, this.f38298c);
            if (("set delegate for config name = " + this.f38296a.name() + ", view = " + this.f38297b) == null) goto L21;
            Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ViewAccessibilityDelegateProcessor(k6.a r100) {
        this.f38292d = r100;
        this.f38289a = LazyKt.lazy(new ViewAccessibilityDelegateProcessor$config2AccessibilityDelegateGenerateProcessor$2(this));
        this.f38290b = LazyKt.lazy(ViewAccessibilityDelegateProcessor$buildTagBuildProcessor$2.INSTANCE);
        this.f38291c = LazyKt.lazy(ViewAccessibilityDelegateProcessor$viewLabelBuildProcessor$2.INSTANCE);
    }

    public final void c(a r110) {
        View r100 = r110.a();
        if (r100 != null) goto L168;
        Context r111 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return;
    L168:
    L16:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L20;
        Context r101 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L20:
        Unit r102 = Unit.INSTANCE;
    L21:
        Iterator<IBaseConfig> r103 = AccessibilityConfigEngine.f38242d.iterator();
    L22:
        boolean r104 = r103.hasNext();
        ArrayList<IBaseConfig> r105 = AccessibilityConfigEngine.f38239a;
        AccessibilityDelegateCompat r106 = null;
        if (r104 == false) goto L27;
        IBaseConfig r107 = r103.next();
        if (AccessibilityConfigEngine.b(r107, r110) == false) goto L22;
    L28:
        IBaseConfig r108 = r107;
        boolean r109 = false;
        if (com.bytedance.android.accessibilityLib_Core.engine.a.f38247a[com.bytedance.android.accessibilityLib_Core.base.largertoucharea.b.f38147a.ordinal()] == 1) goto L67;
        Iterator<IBaseLargeTouchAreaConfig> r112 = AccessibilityConfigEngine.f38245g.iterator();
    L32:
        if (r112.hasNext() == false) goto L51;
        IBaseLargeTouchAreaConfig r113 = r112.next();
        IBaseLargeTouchAreaConfig r114 = r113;
        if (Build.VERSION.SDK_INT < 29) goto L48;
        List<Integer> r115 = r114.supportLayoutRootList();
        View r116 = r110.a();
        if (r116 == null) goto L40;
        View r117 = r116.getRootView();
        if (r117 == null) goto L40;
        int r118 = r117.getSourceLayoutResId();
    L42:
        if (r115.contains(Integer.valueOf(r118)) == false) goto L44;
    L47:
        boolean r119 = true;
    L49:
        if (r119 == false) goto L32;
    L52:
        IBaseLargeTouchAreaConfig r120 = r113;
        StringBuilder r121 = new StringBuilder("largeAreaConfig = ");
        if (r120 == null) goto L55;
        List<Integer> r122 = r120.supportLayoutRootList();
    L56:
        r121.append(r122);
        if (r121.toString() == null) goto L59;
        Context r123 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L59:
        if (r108 != null) goto L73;
        if (r120 != null) goto L63;
    L66:
        r108 = null;
        goto L73
    L63:
        if (r110.f38295c == false) goto L66;
        i6.a r124 = new i6.a();
    L65:
        r108 = r124;
    L73:
        if (r110.f38295c == false) goto L76;
        if (r108 == null) goto L76;
        r108.getVirtualNode().f38155e = true;
    L76:
        if (r108 == null) goto L184;
        String r125 = r108.getVirtualNode().f38168r;
        if (r125 != null) goto L80;
    L83:
        boolean r126 = true;
    L85:
        if (r126 == true) goto L113;
        if (("appModeConfigStr = " + r125) == null) goto L89;
        Context r127 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L89:
        int r128 = com.bytedance.android.accessibilityLib_Core.helper.a.f38278b;
        if (r128 != 1) goto L92;
        boolean r129 = true;
    L93:
        if (r129 == true) goto L95;
        if (r128 != 2) goto L99;
        boolean r130 = true;
    L100:
        if (r130 == false) goto L105;
        if ((!StringsKt.contains(r125, "dylite", true)) == false) goto L113;
        return;
    L105:
        if (r128 != 3) goto L107;
        boolean r131 = true;
    L108:
        if (r131 == false) goto L113;
        if ((!StringsKt.contains(r125, "hotsoon", true)) == false) goto L113;
        return;
    L107:
        r131 = false;
        goto L108
    L99:
        r130 = false;
        goto L100
    L95:
        if ((!StringsKt.contains(r125, "douyin", true)) == false) goto L113;
        return;
    L92:
        r129 = false;
    L113:
        if (("find config for view = " + r100 + ", config name = " + r108.name()) == null) goto L115;
        Context r132 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L115:
        AccessibilityDelegateCompat r133 = ViewCompat.getAccessibilityDelegate(r100);
        if (r133 != null) goto L118;
    L120:
        boolean r134 = false;
    L121:
        if (r134 == true) goto L170;
        View r135 = r110.a();
        if (r135 != null) goto L140;
    L149:
        if (r109 == true) goto L155;
        if (("replaceAccessibilityDelegate,overwrite = false for viewinfo = " + r110.a()) == null) goto L182;
        Context r136 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return;
    L182:
        return;
    L155:
        if (Build.VERSION.SDK_INT < 29) goto L157;
        AccessibilityDelegateCompat r137 = ((Config2AccessibilityDelegateGenerateProcessor) this.f38289a.getValue()).wrap2AccessibilityDelegateCompat(r108, r100.getAccessibilityDelegate());
    L159:
        if (r100.isAttachedToWindow() == false) goto L161;
        r100.post(new b(r108, r100, r137));
        return;
    L161:
        if (("don't attached for viewnode>>> " + r100) == null) goto L183;
        Context r138 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return;
    L183:
        return;
    L157:
        r137 = Config2AccessibilityDelegateGenerateProcessor.wrap2AccessibilityDelegateCompat$default((Config2AccessibilityDelegateGenerateProcessor) this.f38289a.getValue(), r108, null, 2, null);
        goto L159
    L140:
        if (ViewCompat.getAccessibilityDelegate(r135) != null) goto L144;
        if (ViewCompat.hasAccessibilityDelegate(r135) == true) goto L144;
    L148:
        r109 = true;
    L144:
        if (r108.getVirtualNode().f38163m == false) goto L149;
        if (("replaceAccessibilityDelegate,overwrite = true for viewinfo = " + r110) == null) goto L148;
        Context r139 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        goto L148
    L170:
    L131:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L135;
        Context r140 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L135:
        Unit r141 = Unit.INSTANCE;
        return;
    L123:
        if ((r133 instanceof Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite) == false) goto L126;
        r106 = r133;
    L126:
        Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite r142 = (Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite) r106;     // Catch: Exception -> L131
        if (r142 == null) goto L129;
        r142.setConfig(r108);     // Catch: Exception -> L131
    L129:
        Unit r143 = Unit.INSTANCE;     // Catch: Exception -> L131
        return;
    L118:
        if ((r133 instanceof Config2AccessibilityDelegateGenerateProcessor.AccessibilityDelegateComposite) == false) goto L120;
        r134 = true;
        goto L121
    L80:
        if (r125.length() == 0) goto L83;
        r126 = false;
        goto L85
    L184:
        return;
    L55:
        r122 = null;
        goto L56
    L44:
        if (r114.supportLayoutRootList().contains(Integer.valueOf(r110.f38294b)) == true) goto L47;
        r119 = false;
    L40:
        r118 = -1;
        goto L42
    L48:
        r119 = r114.supportLayoutRootList().contains(Integer.valueOf(r110.f38294b));
        goto L49
    L51:
        r113 = null;
        goto L52
    L67:
        if (r108 != null) goto L73;
        if (r110.f38295c == false) goto L66;
        r124 = new i6.a();
        goto L65
    L27:
        r107 = null;
        goto L28
    L6:
        if (com.bytedance.android.accessibilityLib_Core.engine.b.f38249a == false) goto L8;
        ((c) this.f38290b.getValue()).a(r110);     // Catch: Exception -> L16
    L8:
        ArrayList<IBaseConfig> r144 = AccessibilityConfigEngine.f38239a;     // Catch: Exception -> L16
        View r145 = r110.f38293a.get();     // Catch: Exception -> L16
        if (r145 == null) goto L11;
        int r146 = r145.getId();     // Catch: Exception -> L16
    L12:
        h r147 = AccessibilityConfigEngine.a(r146, r110.f38294b);     // Catch: Exception -> L16
        if (r147 == null) goto L21;
        a(r110.f38293a, r147);     // Catch: Exception -> L16
        Unit r148 = Unit.INSTANCE;     // Catch: Exception -> L16
        goto L21
    L11:
        r146 = -1;
        goto L12
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void a(WeakReference<View> r100, h r101) {
        com.bytedance.android.accessibilityLib_Core.processor.b r102 = (com.bytedance.android.accessibilityLib_Core.processor.b) this.f38291c.getValue();
        r102.getClass();
        if (r100 == null) goto L5;
        View r103 = r100.get();
    L6:
        if (r103 == null) goto L26;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101.f38208a);
        r104.append('-');
        r104.append(r101.f38209b);
        String r105 = r104.toString();
        String r106 = com.bytedance.android.accessibilityLib_Core.processor.b.a(r103);
        if (r106 != null) goto L10;
    L13:
        boolean r107 = true;
    L14:
        if (r107 == false) goto L17;
    L20:
        if (r100 != null) goto L22;
        return;
    L22:
        if (r102.f38305b.size() < r102.f38306c) goto L24;
        Context r108 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return;
    L24:
        r102.f38305b.put(r105, r100);
        return;
    L17:
        if (("store key = " + r105 + ", contentDesc = " + r106) == null) goto L19;
        Context r109 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L19:
        r102.f38304a.put(r105, r106);
        goto L20
    L10:
        if (r106.length() == 0) goto L13;
        r107 = false;
        goto L14
    L26:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void b(View r100, int r101, boolean r102) {
    L12:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L16;
        Context r103 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L16:
        Unit r104 = Unit.INSTANCE;
        return;
    L4:
        if (("[ViewAccessibilityDelegateProcessor]>>>consumeViewDirectly,view = " + r100) == null) goto L6;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L12
    L6:
        a r106 = this.f38292d.a(r100, r101);     // Catch: Exception -> L12
        if (r106.f38294b != (-1)) goto L10;
        if (r101 == (-1)) goto L10;
        r106.f38294b = r101;     // Catch: Exception -> L12
    L10:
        r106.f38295c = r102;     // Catch: Exception -> L12
        c(r106);     // Catch: Exception -> L12
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L12
    }
}
