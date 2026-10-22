package com.obric.autogui.common.api.platform.system.viewhierarchy;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ViewHierarchyDump.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewHierarchyDump {
    private final long dataSize;
    private final VHNode rootNode;
    private final int windowIndex;

    public static /* synthetic */ ViewHierarchyDump copy$default(ViewHierarchyDump r1, VHNode r2, long r3, int r5, int r6, Object r7) {
        VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r4 = r1.rootNode;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.dataSize;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r5 = r1.windowIndex;
    L12:
        return r1.copy(r4, r3, r5);
    }

    private static final boolean findNodeAtRecursive$lambda$3(VHNode r2) {
        o.e((VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin"), "it");
        return true;
    }

    private static final boolean findNodeByPosition$lambda$0(VHNode r2) {
        o.e((VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin"), "it");
        return true;
    }

    public static /* synthetic */ boolean lambda$FbOyo8TvnxlKCtMyeUursGv2gVw(VHNode r0) {
        return findNodeAtRecursive$lambda$3(r0);
    }

    public static /* synthetic */ boolean lambda$RJ_KVg5v37caYHpPkbv7y9_fcpA(VHNode r0) {
        return findNodeByPosition$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$Re6IbmD-_1su-hQPDMQn4j0x7bY, reason: not valid java name */
    public static /* synthetic */ boolean m806lambda$Re6IbmD_1suhQPDMQn4j0x7bY(int r0, int r1, b r2, VHNode r3) {
        return findNodeByPosition$lambda$2$lambda$1(r0, r1, r2, r3);
    }

    public final VHNode component1() {
        return this.rootNode;
    }

    public final long component2() {
        return this.dataSize;
    }

    public final int component3() {
        return this.windowIndex;
    }

    public final ViewHierarchyDump copy(VHNode r2, long r3, int r5) {
        return new ViewHierarchyDump((VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin"), r3, r5);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ViewHierarchyDump.class) == true) goto L8;
        return false;
    L8:
        ViewHierarchyDump r10 = (ViewHierarchyDump) ZeusTransformUtils.preCheckCast(r9, ViewHierarchyDump.class, "com.obric.aiagent.plugin");
        if (o.a(this.rootNode, r10.rootNode) == true) goto L12;
        return false;
    L12:
        if (this.dataSize == r10.dataSize) goto L15;
        return false;
    L15:
        if (this.windowIndex == r10.windowIndex) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        VHNode r0 = this.rootNode;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + Long.hashCode(this.dataSize)) * 31) + Integer.hashCode(this.windowIndex);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ViewHierarchyDump(rootNode=" + this.rootNode + ", dataSize=" + this.dataSize + ", windowIndex=" + this.windowIndex + ')';
    }

    public ViewHierarchyDump(VHNode r3, long r4, int r6) {
        this.rootNode = (VHNode) ZeusTransformUtils.wrapperContextForParams(r3, VHNode.class, "com.obric.aiagent.plugin");
        this.dataSize = r4;
        this.windowIndex = r6;
    }

    public /* synthetic */ ViewHierarchyDump(VHNode r2, long r3, int r5, int r6, h r7) {
        VHNode r4 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 0;
    L8:
        this(r4, r3, r5);
    }

    public final VHNode getRootNode() {
        return this.rootNode;
    }

    public final long getDataSize() {
        return this.dataSize;
    }

    public final int getWindowIndex() {
        return this.windowIndex;
    }

    public static /* synthetic */ VHNode findNodeByPosition$default(ViewHierarchyDump r1, int r2, int r3, b r4, int r5, Object r6) {
        b<? super VHNode, Boolean> r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = $$Lambda$ViewHierarchyDump$RJ_KVg5v37caYHpPkbv7y9_fcpA.INSTANCE;
    L6:
        return r1.findNodeByPosition(r2, r3, r7);
    }

    public final VHNode findNodeByPosition(final int r3, final int r4, b<? super VHNode, Boolean> r5) {
        final b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r6, "predicate");
        VHNode r0 = this.rootNode;
        if (r0 != null) goto L7;
        return null;
    L7:
        return findNodeAtRecursive(r0, new $$Lambda$ViewHierarchyDump$Re6IbmD_1suhQPDMQn4j0x7bY(r3, r4, r6));
    }

    private static final boolean findNodeByPosition$lambda$2$lambda$1(int r5, int r6, b r7, VHNode r8) {
        b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        VHNode r10 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r8, VHNode.class, "com.obric.aiagent.plugin");
        o.e(r10, "node");
        VHNode.Bounds r0 = r10.getBounds();
        if (r5 >= r0.getScreenLeft()) goto L5;
    L11:
        boolean r11 = false;
    L12:
        if (r11 == false) goto L17;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9.invoke(r10), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (r5 > r0.getScreenRight()) goto L11;
        if (r6 < r0.getScreenTop()) goto L11;
        if (r6 > r0.getScreenBottom()) goto L11;
        r11 = true;
        goto L12
    }

    public static /* synthetic */ VHNode findNodeAtRecursive$default(ViewHierarchyDump r1, VHNode r2, b r3, int r4, Object r5) {
        VHNode r6 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r2, VHNode.class, "com.obric.aiagent.plugin");
        b<? super VHNode, Boolean> r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r7 = $$Lambda$ViewHierarchyDump$FbOyo8TvnxlKCtMyeUursGv2gVw.INSTANCE;
    L6:
        return r1.findNodeAtRecursive(r6, r7);
    }

    public final VHNode findNodeAtRecursive(VHNode r5, b<? super VHNode, Boolean> r6) {
        VHNode r7 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r5, VHNode.class, "com.obric.aiagent.plugin");
        b<? super VHNode, Boolean> r8 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        o.e(r7, "node");
        o.e(r8, "predicate");
        Iterator r0 = p.h(r7.getChildren()).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        VHNode r2 = findNodeAtRecursive((VHNode) ZeusTransformUtils.preCheckCast(r0.next(), VHNode.class, "com.obric.aiagent.plugin"), r8);
        if (r2 == null) goto L4;
        return r2;
    L9:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.invoke(r7), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L16;
        return null;
    L16:
        return r7;
    }

    public final String print() {
        StringBuilder r0 = new StringBuilder();
        VHNode r1 = this.rootNode;
        if (r1 == null) goto L5;
        printTree(r1, r0, "", true);
    L6:
        String r4 = r0.toString();
        o.c(r4, "toString(...)");
        return r4;
    L5:
        ViewHierarchyDump r5 = (ViewHierarchyDump) ZeusTransformUtils.preCheckCast(this, ViewHierarchyDump.class, "com.obric.aiagent.plugin");
        r0.append("Empty Tree");
        goto L6
    }

    private final void printTree(VHNode r10, StringBuilder r11, String r12, boolean r13) {
        VHNode r14 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r10, VHNode.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = r11.append(r12);
        if (r13 == false) goto L5;
        String r2 = "└── ";
    L6:
        r0.append(r2);
        r14.dump(r11);
        r11.append('\n');
        List<VHNode> r15 = r14.getChildren();
        int r1 = r15.size() - 1;
        int r4 = 0;
    L7:
        String r5 = "    ";
        if (r4 >= r1) goto L15;
        VHNode r7 = (VHNode) ZeusTransformUtils.preCheckCast(r15.get(r4), VHNode.class, "com.obric.aiagent.plugin");
        StringBuilder r8 = new StringBuilder().append(r12);
        if (r13 == true) goto L13;
        r5 = "│   ";
    L13:
        printTree(r7, r11, r8.append(r5).toString(), false);
        r4 = r4 + 1;
        goto L7
    L15:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L25;
        VHNode r16 = (VHNode) ZeusTransformUtils.preCheckCast(p.m(r15), VHNode.class, "com.obric.aiagent.plugin");
        StringBuilder r17 = new StringBuilder().append(r12);
        if (r13 == true) goto L20;
        r5 = "│   ";
    L20:
        printTree(r16, r11, r17.append(r5).toString(), true);
        return;
    L25:
        return;
    L5:
        r2 = "├── ";
        goto L6
    }
}
