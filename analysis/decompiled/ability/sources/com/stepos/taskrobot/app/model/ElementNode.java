package com.stepos.taskrobot.app.model;

import B7.a;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b9\b\u0086\b\u0018\u0000 c2\u00020\u0001:\u0001cB\u0085\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0000\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001b¢\u0006\u0004\b!\u0010 J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0000¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u0000¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020'2\u0006\u0010&\u001a\u00020\u0000¢\u0006\u0004\b*\u0010)J\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000+¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00000+¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\tH\u0016¢\u0006\u0004\b3\u0010#J\u0010\u00104\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b8\u00100J\u0010\u00109\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b9\u00100J\u0010\u0010:\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b:\u0010#J\u0010\u0010;\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b=\u00100J\u0012\u0010>\u001a\u0004\u0018\u00010\u0000HÆ\u0003¢\u0006\u0004\b>\u0010%J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fHÆ\u0003¢\u0006\u0004\b?\u0010-J\u0010\u0010@\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b@\u0010#J\u0010\u0010A\u001a\u00020\tHÆ\u0003¢\u0006\u0004\bA\u0010#J\u0012\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\bB\u00100J\u0010\u0010C\u001a\u00020\tHÆ\u0003¢\u0006\u0004\bC\u0010#J\u009c\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00002\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\tHÆ\u0001¢\u0006\u0004\bD\u0010ER\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010F\u001a\u0004\bG\u00105R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010H\u001a\u0004\bI\u00107R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010J\u001a\u0004\bK\u00100R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010J\u001a\u0004\bL\u00100R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010M\u001a\u0004\bN\u0010#R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010O\u001a\u0004\bP\u0010<\"\u0004\bQ\u0010RR\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010J\u001a\u0004\bS\u00100R$\u0010\u000e\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010T\u001a\u0004\bU\u0010%\"\u0004\bV\u0010)R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010W\u001a\u0004\bX\u0010-R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010M\u001a\u0004\bY\u0010#\"\u0004\bZ\u0010[R\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010M\u001a\u0004\b\\\u0010#\"\u0004\b]\u0010[R$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010J\u001a\u0004\b^\u00100\"\u0004\b_\u0010`R\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010M\u001a\u0004\ba\u0010#\"\u0004\bb\u0010[¨\u0006d"}, d2 = {"Lcom/stepos/taskrobot/app/model/ElementNode;", "", "Landroid/view/accessibility/AccessibilityNodeInfo;", "nodeInfo", "Landroid/graphics/Rect;", "rect", "", "text", "className", "", "windowLayer", "", "creationTime", "id", "parent", "", "children", "clickableIndex", "nestingLevel", "semanticParentId", "overlayIndex", AppAgent.CONSTRUCT, "(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/graphics/Rect;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Lcom/stepos/taskrobot/app/model/ElementNode;Ljava/util/List;IILjava/lang/String;I)V", "", "calculateWeight", "()F", "other", "", "overlaps", "(Lcom/stepos/taskrobot/app/model/ElementNode;)Z", "contains", "isClickable", "()Z", "isText", "calculateNestingLevel", "()I", "getRootAncestor", "()Lcom/stepos/taskrobot/app/model/ElementNode;", "child", "LC7/r;", "addChild", "(Lcom/stepos/taskrobot/app/model/ElementNode;)V", "removeChild", "", "getAllDescendants", "()Ljava/util/List;", "getPathFromRoot", "toString", "()Ljava/lang/String;", "equals", "(Ljava/lang/Object;)Z", "hashCode", "component1", "()Landroid/view/accessibility/AccessibilityNodeInfo;", "component2", "()Landroid/graphics/Rect;", "component3", "component4", "component5", "component6", "()J", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Landroid/view/accessibility/AccessibilityNodeInfo;Landroid/graphics/Rect;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Lcom/stepos/taskrobot/app/model/ElementNode;Ljava/util/List;IILjava/lang/String;I)Lcom/stepos/taskrobot/app/model/ElementNode;", "Landroid/view/accessibility/AccessibilityNodeInfo;", "getNodeInfo", "Landroid/graphics/Rect;", "getRect", "Ljava/lang/String;", "getText", "getClassName", "I", "getWindowLayer", "J", "getCreationTime", "setCreationTime", "(J)V", "getId", "Lcom/stepos/taskrobot/app/model/ElementNode;", "getParent", "setParent", "Ljava/util/List;", "getChildren", "getClickableIndex", "setClickableIndex", "(I)V", "getNestingLevel", "setNestingLevel", "getSemanticParentId", "setSemanticParentId", "(Ljava/lang/String;)V", "getOverlayIndex", "setOverlayIndex", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ElementNode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long FADE_DURATION_MS = 60000;
    private final List<ElementNode> children;
    private final String className;
    private int clickableIndex;
    private long creationTime;
    private final String id;
    private int nestingLevel;
    private final AccessibilityNodeInfo nodeInfo;
    private int overlayIndex;
    private ElementNode parent;
    private final Rect rect;
    private String semanticParentId;
    private final String text;
    private final int windowLayer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/taskrobot/app/model/ElementNode$Companion;", "", AppAgent.CONSTRUCT, "()V", "FADE_DURATION_MS", "", "createId", "", "rect", "Landroid/graphics/Rect;", "className", "text", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final String createId(Rect rect, String className, String text) {
            k.f(rect, "rect");
            k.f(className, "className");
            k.f(text, "text");
            return rect.toShortString() + "_" + className + "_" + m.N0(20, text);
        }

        private Companion() {
        }
    }

    public ElementNode(AccessibilityNodeInfo nodeInfo, Rect rect, String text, String className, int i, long j5, String id, ElementNode elementNode, List<ElementNode> children, int i6, int i10, String str, int i11) {
        k.f(nodeInfo, "nodeInfo");
        k.f(rect, "rect");
        k.f(text, "text");
        k.f(className, "className");
        k.f(id, "id");
        k.f(children, "children");
        this.nodeInfo = nodeInfo;
        this.rect = rect;
        this.text = text;
        this.className = className;
        this.windowLayer = i;
        this.creationTime = j5;
        this.id = id;
        this.parent = elementNode;
        this.children = children;
        this.clickableIndex = i6;
        this.nestingLevel = i10;
        this.semanticParentId = str;
        this.overlayIndex = i11;
    }

    public final void addChild(ElementNode child) {
        k.f(child, "child");
        if (this.children.contains(child)) {
            return;
        }
        this.children.add(child);
        child.parent = this;
    }

    public final int calculateNestingLevel() {
        int i = this.nestingLevel;
        if (i > 0) {
            return i;
        }
        int i6 = 0;
        ElementNode elementNode = this;
        while (true) {
            elementNode = elementNode.parent;
            if (elementNode == null) {
                this.nestingLevel = i6;
                return i6;
            }
            i6++;
            k.c(elementNode);
        }
    }

    public final float calculateWeight() {
        return Math.max(0.0f, Math.min(1.0f, 1.0f - ((System.currentTimeMillis() - this.creationTime) / 60000.0f)));
    }

    /* renamed from: component1, reason: from getter */
    public final AccessibilityNodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    /* renamed from: component10, reason: from getter */
    public final int getClickableIndex() {
        return this.clickableIndex;
    }

    /* renamed from: component11, reason: from getter */
    public final int getNestingLevel() {
        return this.nestingLevel;
    }

    /* renamed from: component12, reason: from getter */
    public final String getSemanticParentId() {
        return this.semanticParentId;
    }

    /* renamed from: component13, reason: from getter */
    public final int getOverlayIndex() {
        return this.overlayIndex;
    }

    /* renamed from: component2, reason: from getter */
    public final Rect getRect() {
        return this.rect;
    }

    /* renamed from: component3, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClassName() {
        return this.className;
    }

    /* renamed from: component5, reason: from getter */
    public final int getWindowLayer() {
        return this.windowLayer;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreationTime() {
        return this.creationTime;
    }

    /* renamed from: component7, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component8, reason: from getter */
    public final ElementNode getParent() {
        return this.parent;
    }

    public final List<ElementNode> component9() {
        return this.children;
    }

    public final boolean contains(ElementNode other) {
        k.f(other, "other");
        return this.rect.contains(other.rect);
    }

    public final ElementNode copy(AccessibilityNodeInfo nodeInfo, Rect rect, String text, String className, int windowLayer, long creationTime, String id, ElementNode parent, List<ElementNode> children, int clickableIndex, int nestingLevel, String semanticParentId, int overlayIndex) {
        k.f(nodeInfo, "nodeInfo");
        k.f(rect, "rect");
        k.f(text, "text");
        k.f(className, "className");
        k.f(id, "id");
        k.f(children, "children");
        return new ElementNode(nodeInfo, rect, text, className, windowLayer, creationTime, id, parent, children, clickableIndex, nestingLevel, semanticParentId, overlayIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ElementNode) {
            return k.b(this.id, ((ElementNode) other).id);
        }
        return false;
    }

    public final List<ElementNode> getAllDescendants() {
        ArrayList arrayList = new ArrayList();
        for (ElementNode elementNode : this.children) {
            arrayList.add(elementNode);
            arrayList.addAll(elementNode.getAllDescendants());
        }
        return arrayList;
    }

    public final List<ElementNode> getChildren() {
        return this.children;
    }

    public final String getClassName() {
        return this.className;
    }

    public final int getClickableIndex() {
        return this.clickableIndex;
    }

    public final long getCreationTime() {
        return this.creationTime;
    }

    public final String getId() {
        return this.id;
    }

    public final int getNestingLevel() {
        return this.nestingLevel;
    }

    public final AccessibilityNodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    public final int getOverlayIndex() {
        return this.overlayIndex;
    }

    public final ElementNode getParent() {
        return this.parent;
    }

    public final List<ElementNode> getPathFromRoot() {
        ArrayList arrayList = new ArrayList();
        while (this != null) {
            arrayList.add(0, this);
            this = this.parent;
        }
        return arrayList;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final ElementNode getRootAncestor() {
        while (true) {
            ElementNode elementNode = this.parent;
            if (elementNode == null) {
                return this;
            }
            k.c(elementNode);
            this = elementNode;
        }
    }

    public final String getSemanticParentId() {
        return this.semanticParentId;
    }

    public final String getText() {
        return this.text;
    }

    public final int getWindowLayer() {
        return this.windowLayer;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public final boolean isClickable() {
        return this.nodeInfo.isClickable();
    }

    public final boolean isText() {
        return this.text.length() > 0 && !this.nodeInfo.isClickable();
    }

    public final boolean overlaps(ElementNode other) {
        k.f(other, "other");
        return Rect.intersects(this.rect, other.rect);
    }

    public final void removeChild(ElementNode child) {
        k.f(child, "child");
        this.children.remove(child);
        child.parent = null;
    }

    public final void setClickableIndex(int i) {
        this.clickableIndex = i;
    }

    public final void setCreationTime(long j5) {
        this.creationTime = j5;
    }

    public final void setNestingLevel(int i) {
        this.nestingLevel = i;
    }

    public final void setOverlayIndex(int i) {
        this.overlayIndex = i;
    }

    public final void setParent(ElementNode elementNode) {
        this.parent = elementNode;
    }

    public final void setSemanticParentId(String str) {
        this.semanticParentId = str;
    }

    public String toString() {
        String str = this.text;
        String str2 = this.className;
        Rect rect = this.rect;
        String str3 = this.id;
        StringBuilder sbW = a.w("ElementNode(text='", str, "', className='", str2, "', rect=");
        sbW.append(rect);
        sbW.append(", id='");
        sbW.append(str3);
        sbW.append("')");
        return sbW.toString();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ ElementNode(android.view.accessibility.AccessibilityNodeInfo r19, android.graphics.Rect r20, java.lang.String r21, java.lang.String r22, int r23, long r24, java.lang.String r26, com.stepos.taskrobot.app.model.ElementNode r27, java.util.List r28, int r29, int r30, java.lang.String r31, int r32, int r33, kotlin.jvm.internal.e r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 128(0x80, float:1.8E-43)
            r2 = 0
            if (r1 == 0) goto L9
            r12 = r2
            goto Lb
        L9:
            r12 = r27
        Lb:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L16
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r13 = r1
            goto L18
        L16:
            r13 = r28
        L18:
            r1 = r0 & 512(0x200, float:7.17E-43)
            r3 = -1
            if (r1 == 0) goto L1f
            r14 = r3
            goto L21
        L1f:
            r14 = r29
        L21:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L28
            r1 = 0
            r15 = r1
            goto L2a
        L28:
            r15 = r30
        L2a:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L31
            r16 = r2
            goto L33
        L31:
            r16 = r31
        L33:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L4a
            r17 = r3
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r11 = r26
            r3 = r18
            goto L5c
        L4a:
            r17 = r32
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r11 = r26
        L5c:
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.app.model.ElementNode.<init>(android.view.accessibility.AccessibilityNodeInfo, android.graphics.Rect, java.lang.String, java.lang.String, int, long, java.lang.String, com.stepos.taskrobot.app.model.ElementNode, java.util.List, int, int, java.lang.String, int, int, kotlin.jvm.internal.e):void");
    }
}
