package com.obric.autogui.platforms.tools.input;

import android.app.assist.AssistStructure;
import com.obric.autogui.common.api.platform.input.InjectTextViewTreeNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: InjectTextViewTreeSnapshotExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30241a = null;

    static {
        f30241a = new a();
    }

    private a() {
    }

    public final List<InjectTextViewTreeNode> a(AssistStructure r26) {
        o.e(r26, "structure");
        List<ViewHierarchyDump> r0 = com.obric.autogui.platforms.tools.internal.viewhierarchy.b.f30401a.a(r26, false);
        ArrayDeque r1 = new ArrayDeque();
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        VHNode r3 = ((ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r2.next(), ViewHierarchyDump.class, "com.obric.aiagent.plugin")).getRootNode();
        if (r3 == null) goto L4;
        ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).add(r3);
        goto L4
    L8:
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin");
        List<InjectTextViewTreeNode> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L45;
        VHNode r6 = (VHNode) ZeusTransformUtils.preCheckCast(r1.removeFirst(), VHNode.class, "com.obric.aiagent.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.getChildren(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r7.hasNext() == false) goto L15;
        r1.addLast((VHNode) ZeusTransformUtils.preCheckCast(r7.next(), VHNode.class, "com.obric.aiagent.plugin"));
        goto L13
    L15:
        o.a(r6);
        if (a(r6) == false) goto L10;
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin");
        String[] r9 = new String[3];
        String r10 = r6.getId();
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        r9[0] = r10;
        String r11 = r6.getClassName();
        if (r11 != null) goto L24;
        r11 = "";
    L24:
        r9[1] = r11;
        r9[2] = r6.getBounds().toString();
        String r12 = p.a((Iterable) ZeusTransformUtils.preCheckCast(p.b(r9), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("#", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        String r13 = r6.getId();
        if (r13 != null) goto L27;
        r13 = "";
    L27:
        String r14 = r6.getClassName();
        if (r14 != null) goto L30;
        String r15 = "";
    L31:
        CharSequence r16 = r6.getHint();
        String r17 = null;
        if (r16 == null) goto L34;
        String r18 = r16.toString();
    L35:
        if (r18 != null) goto L37;
        String r19 = "";
    L38:
        CharSequence r20 = r6.getText();
        if (r20 == null) goto L41;
        r17 = r20.toString();
    L41:
        if (r17 != null) goto L43;
        String r110 = "";
    L44:
        r8.add(new InjectTextViewTreeNode(r12, r13, r15, r19, r110, r6.isFocused(), r6.getInputType()));
        goto L10
    L43:
        r110 = r17;
        goto L44
    L37:
        r19 = r18;
        goto L38
    L34:
        r18 = null;
        goto L35
    L30:
        r15 = r14;
        goto L31
    L45:
        return r5;
    }

    private final boolean a(VHNode r6) {
        VHNode r5 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r6, VHNode.class, "com.obric.aiagent.plugin");
        if (r5.getInputType() > 0) goto L18;
        String r7 = r5.getClassName();
        String r2 = "";
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("EditText", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L19;
        String r8 = r5.getClassName();
        if (r8 == null) goto L14;
        r2 = r8;
    L14:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TextField", CharSequence.class, "com.obric.aiagent.plugin"), true) == true) goto L20;
        return false;
    L20:
        return true;
    L19:
        return true;
    L18:
        return true;
    }
}
