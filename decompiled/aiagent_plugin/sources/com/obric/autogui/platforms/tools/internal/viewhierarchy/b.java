package com.obric.autogui.platforms.tools.internal.viewhierarchy;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AssistViewStructureConverter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "AssistStructure-Converter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30401a = null;

    static {
        f30401a = new b();
    }

    private b() {
    }

    public final List<ViewHierarchyDump> a(AssistStructure r3, boolean r4) {
        o.e(r3, "structure");
        return b(r3, r4);
    L5:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "error while converting " + r3 + " --> VHD: " + th, th);
        return p.b();
    }

    private final List<ViewHierarchyDump> b(AssistStructure r13, boolean r14) {
        List<ViewHierarchyDump> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        int r1 = r13.getWindowNodeCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        AssistStructure.ViewNode r4 = r13.getWindowNodeAt(r3).getRootViewNode();
        o.c(r4, "getRootViewNode(...)");
        r0.add(new ViewHierarchyDump((VHNode) ZeusTransformUtils.preCheckCast(a(r4, r14), VHNode.class, "com.obric.aiagent.plugin"), 0, r3, 2, null));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    private final a a(AssistStructure.ViewNode r9, boolean r10) {
        Bundle r0 = r9.getExtras();
        if (r0 == null) goto L6;
        String r1 = r0.getString("android.view.ViewStructure.extra.CLASS_NAME");
        if (r1 == null) goto L6;
    L7:
        a r7 = new a(r1, null, null, r9, 6, null);
        if (r10 == false) goto L24;
        if (r7.getBounds().getWidth() != 0) goto L12;
        return null;
    L12:
        if (r7.getBounds().getHeight() != 0) goto L14;
        return null;
    L14:
        if (r7.getBounds().getScreenLeft() != 0) goto L24;
        if (r7.getBounds().getScreenTop() != 0) goto L24;
        if (r7.getBounds().getScreenRight() != 0) goto L24;
        if (r7.getBounds().getScreenBottom() != 0) goto L24;
        return null;
    L24:
        if (r9.getChildCount() <= 0) goto L37;
        ArrayList r2 = new ArrayList(r9.getChildCount());
        int r3 = 0;
        int r4 = r9.getChildCount();     // Catch: Throwable -> L34
    L27:
        if (r3 >= r4) goto L36;
        AssistStructure.ViewNode r5 = r9.getChildAt(r3);     // Catch: Throwable -> L34
        if (r5 == null) goto L33;
        a r6 = f30401a.a(r5, r10);     // Catch: Throwable -> L34
        if (r6 == null) goto L33;
        r6.a((VHNode) ZeusTransformUtils.preCheckCast(r7, VHNode.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L34
        r2.add(r6);     // Catch: Throwable -> L34
    L33:
        r3 = r3 + 1;
    L36:
        r7.a((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"));
    L34:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "error while extracting child of " + r9 + " --> VH: " + th, th);
    L37:
        return r7;
    L6:
        r1 = r9.getClassName();
        goto L7
    }
}
