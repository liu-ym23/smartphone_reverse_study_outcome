package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.engine.AccessibilityConfigEngine;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewAccessibilityDelegateProcessor.a f38307a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final void a(ViewAccessibilityDelegateProcessor.a r100) {
        View r101 = r100.a();
        IBaseConfig r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.getTag(2130706435);
    L6:
        if (r103 == null) goto L8;
        return;
    L8:
        StringBuilder r104 = new StringBuilder("{");
        r104.append("layoutId=" + r100.f38294b);
        String r105 = r104.toString() + ",";
        StringBuilder r106 = new StringBuilder();
        r106.append(r105);
        View r107 = r100.a();
        int r108 = r100.f38294b;
        if (r107 != null) goto L11;
        ViewAccessibilityDelegateProcessor.a r109 = null;
    L20:
        if (r109 == null) goto L33;
        Iterator<IBaseConfig> r110 = AccessibilityConfigEngine.f38242d.iterator();
    L23:
        if (r110.hasNext() == false) goto L27;
        IBaseConfig r111 = r110.next();
        if (AccessibilityConfigEngine.b(r111, r109) == false) goto L23;
        r102 = r111;
    L27:
        if (r102 == null) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L32;
        String r113 = "已标注";
    L34:
        r106.append(r113);
        String r114 = r106.toString() + i.f25855d;
        View r115 = r100.a();
        if (r115 == null) goto L38;
        r115.setTag(2130706435, r114);
    L38:
        if (("ViewTagBuildProcessor>>>> for view = " + r100.a() + ", tag = " + r114) == null) goto L44;
        Context r116 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
        return;
    L44:
        return;
    L32:
        r113 = "未标注";
        goto L34
    L29:
        r112 = false;
        goto L30
    L33:
        r113 = "";
        goto L34
    L11:
        if (this.f38307a != null) goto L13;
        this.f38307a = new ViewAccessibilityDelegateProcessor.a(new WeakReference(r107), r108);
    L13:
        ViewAccessibilityDelegateProcessor.a r117 = this.f38307a;
        if (r117 == null) goto L16;
        r117.f38293a = new WeakReference(r107);
    L16:
        r109 = this.f38307a;
        if (r109 == null) goto L20;
        r109.f38294b = r108;
        goto L20
    L5:
        r103 = null;
        goto L6
    }
}
