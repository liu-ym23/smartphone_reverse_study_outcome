package com.obric.autogui.platforms.tools.internal.viewhierarchy;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AssistVHNode.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements ScrollableVTNode, VHNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0815a f30396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<? extends VHNode> f30398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VHNode f30399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AssistStructure.ViewNode f30400e;
    private final String f;
    private final f g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final CharSequence l;
    private final CharSequence m;
    private final int n;
    private final f o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final boolean v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.internal.viewhierarchy.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistVHNode.kt */
    public static final class C0815a {
        public /* synthetic */ C0815a(h r1) {
            this();
        }

        private C0815a() {
        }
    }

    static {
        f30396a = new C0815a(null);
    }

    public static /* synthetic */ VHNode.Bounds lambda$EQ9RKUmkEDmmAwer2kDoGsUu1Fg(a r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$hXuBu8009weEjvsKVZ-c_MYsLYM, reason: not valid java name */
    public static /* synthetic */ int m870lambda$hXuBu8009weEjvsKVZc_MYsLYM(a r0) {
        return a(r0);
    }

    public a(String r5, List<? extends VHNode> r6, VHNode r7, AssistStructure.ViewNode r8) {
        List<? extends VHNode> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        VHNode r10 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r7, VHNode.class, "com.obric.aiagent.plugin");
        o.e(r9, "children");
        o.e(r8, "vs");
        this.f30397b = r5;
        this.f30398c = r9;
        this.f30399d = r10;
        this.f30400e = r8;
        this.f = r8.getIdEntry();
        this.g = g.a(new $$Lambda$a$hXuBu8009weEjvsKVZc_MYsLYM(this));
        this.h = r8.isClickable();
        this.i = r8.isLongClickable();
        this.j = r8.isEnabled();
        this.k = r8.isFocused();
        this.l = r8.getText();
        this.m = (CharSequence) ZeusTransformUtils.preCheckCast(r8.getHint(), CharSequence.class, "com.obric.aiagent.plugin");
        this.n = r8.getInputType();
        this.o = g.a(new $$Lambda$a$EQ9RKUmkEDmmAwer2kDoGsUu1Fg(this));
        boolean r0 = true;
        if (a("scl_v") == false) goto L5;
    L8:
        boolean r11 = true;
    L9:
        this.p = r11;
        this.q = a(this, "scl_up", false, 2, null);
        this.r = a(this, "scl_down", false, 2, null);
        this.s = a(this, "scl_left", false, 2, null);
        this.t = a(this, "scl_right", false, 2, null);
        if (a(this, "scl_v", false, 2, null) == false) goto L12;
    L17:
        boolean r12 = true;
    L18:
        this.u = r12;
        if (a(this, "scl_h", false, 2, null) == false) goto L21;
    L26:
        this.v = r0;
        this.w = a(this, "scl_ran", 0, 2, null);
        this.x = a(this, "scl_off", 0, 2, null);
        this.y = a(this, "scl_ext", 0, 2, null);
        Bundle r13 = r8.getExtras();
        int r14 = -1;
        if (r13 == null) goto L29;
        r14 = r13.getInt("android.view.ViewStructure.extra.vhd.VIEW_HASH_CODE", -1);
    L29:
        this.z = r14;
        return;
    L21:
        if (getScrollableLeft() == true) goto L26;
        if (getScrollableRight() == true) goto L26;
        r0 = false;
        goto L26
    L12:
        if (getScrollableUp() == true) goto L17;
        if (getScrollableDown() == true) goto L17;
        r12 = false;
        goto L18
    L5:
        if (a("scl_h") == true) goto L8;
        r11 = false;
        goto L9
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public String getClassName() {
        return this.f30397b;
    }

    public /* synthetic */ a(String r2, List r3, VHNode r4, AssistStructure.ViewNode r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        VHNode r9 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r4, VHNode.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r8 = p.b();
    L6:
        if ((r6 & 4) == 0) goto L8;
        r9 = null;
    L8:
        this(r2, r8, r9, r5);
    }

    public void a(List<? extends VHNode> r3) {
        List<? extends VHNode> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f30398c = r4;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public List<VHNode> getChildren() {
        return this.f30398c;
    }

    public void a(VHNode r3) {
        this.f30399d = (VHNode) ZeusTransformUtils.wrapperContextForParams(r3, VHNode.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public VHNode getParent() {
        return this.f30399d;
    }

    public final AssistStructure.ViewNode a() {
        return this.f30400e;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public String getId() {
        return this.f;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public int getVisibility() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.g.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
    }

    private static final int a(a r2) {
        Bundle r0 = r2.f30400e.getExtras();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.getBoolean("android.view.ViewStructure.extra.VISIBLE_TO_USER"));
    L6:
        if (r1 != null) goto L9;
        return r2.f30400e.getVisibility();
    L9:
        if (r1.booleanValue() == false) goto L11;
        return 0;
    L11:
        return 4;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public boolean isClickable() {
        return this.h;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public boolean isLongClickable() {
        return this.i;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public boolean isEnabled() {
        return this.j;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public boolean isFocused() {
        return this.k;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public CharSequence getText() {
        return this.l;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public CharSequence getHint() {
        return this.m;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public int getInputType() {
        return this.n;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public VHNode.Bounds getBounds() {
        return (VHNode.Bounds) ZeusTransformUtils.preCheckCast(this.o.b(), VHNode.Bounds.class, "com.obric.aiagent.plugin");
    }

    private static final VHNode.Bounds b(a r11) {
        Bundle r0 = r11.f30400e.getExtras();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r5 = r0.getInt("android.view.ViewStructure.extra.RECT_SCREEN_LEFT");
    L6:
        Bundle r2 = r11.f30400e.getExtras();
        if (r2 == null) goto L9;
        int r6 = r2.getInt("android.view.ViewStructure.extra.RECT_SCREEN_TOP");
    L10:
        Bundle r3 = r11.f30400e.getExtras();
        if (r3 == null) goto L13;
        int r7 = r3.getInt("android.view.ViewStructure.extra.RECT_SCREEN_RIGHT");
    L14:
        Bundle r4 = r11.f30400e.getExtras();
        if (r4 == null) goto L18;
        r1 = r4.getInt("android.view.ViewStructure.extra.RECT_SCREEN_BOTTOM");
    L18:
        return new VHNode.Bounds(r11.f30400e.getLeft(), r11.f30400e.getTop(), r5, r6, r7, r1, r11.f30400e.getWidth(), r11.f30400e.getHeight());
    L13:
        r7 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    static /* synthetic */ boolean a(a r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.a(r1, r2);
    }

    private final boolean a(String r2, boolean r3) {
        Bundle r1 = this.f30400e.getExtras();
        if (r1 != null) goto L5;
        return r3;
    L5:
        return r1.getBoolean("android.view.ViewStructure.extra.vhd.prop." + r2);
    }

    static /* synthetic */ int a(a r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.a(r1, r2);
    }

    private final int a(String r2, int r3) {
        Bundle r1 = this.f30400e.getExtras();
        if (r1 != null) goto L5;
        return r3;
    L5:
        return r1.getInt("android.view.ViewStructure.extra.vhd.prop." + r2);
    }

    private final boolean a(String r5) {
        Bundle r4 = this.f30400e.getExtras();
        if (r4 == null) goto L8;
        if (r4.containsKey("android.view.ViewStructure.extra.vhd.prop." + r5) != true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public boolean isScrollable() {
        return this.p;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public boolean getScrollableUp() {
        return this.q;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public boolean getScrollableDown() {
        return this.r;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public boolean getScrollableLeft() {
        return this.s;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public boolean getScrollableRight() {
        return this.t;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public boolean getScrollableVertical() {
        return this.u;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public boolean getScrollableHorizontal() {
        return this.v;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public int getScrollableRange() {
        return this.w;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public int getScrollableOffset() {
        return this.x;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.ScrollableVTNode
    public int getScrollableExtent() {
        return this.y;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public void dump(StringBuilder r5) {
        o.e(r5, "sb");
        VHNode.DefaultImpls.dump(this, r5);
        r5.append("[H" + this.z + "],v=" + getVisibility() + ",b=" + getBounds() + ",i=" + getInputType());
        if (getText() == null) goto L8;
        if (AOSystemTools.INSTANCE.isDebuggable() == false) goto L8;
        r5.append(",t=[" + getText() + ']');
    L8:
        if (isClickable() == false) goto L11;
        r5.append(",c");
    L11:
        if (isScrollable() == false) goto L14;
        r5.append(",s");
        r5.append(",sv=" + getScrollableVertical());
        r5.append(",sh=" + getScrollableHorizontal());
        r5.append(",sudlr=(" + getScrollableUp() + ',' + getScrollableDown() + ',' + getScrollableLeft() + ',' + getScrollableRight() + ')');
        r5.append(",se=(" + getScrollableRange() + ',' + getScrollableOffset() + ',' + getScrollableExtent() + ')');
        return;
    }

    @Override // com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode
    public VHNode.VHNodeComparison compareTo(VHNode r5) {
        VHNode r6 = (VHNode) ZeusTransformUtils.wrapperContextForParams(r5, VHNode.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, a.class) == false) goto L15;
        if (this.z == (-1)) goto L15;
        if (((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).z == (-1)) goto L15;
        if (this.z != ((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).z) goto L11;
        boolean r4 = true;
    L13:
        return new VHNode.VHNodeComparison(r4, true, "client-hashcode");
    L11:
        r4 = false;
    L15:
        return VHNode.DefaultImpls.compareTo(this, r6);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        dump(r0);
        String r1 = r0.toString();
        o.c(r1, "toString(...)");
        return r1;
    }
}
