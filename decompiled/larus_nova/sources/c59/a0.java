package c59;

import com.larus.dora.impl.dynamic.dsl.DslNodeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a0 {
    static {
    }

    public static l a(z r100) {
        Intrinsics.checkNotNullParameter(r100, "rootNode");
        l r101 = new l(0);
        List<z> r102 = r100.c();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        g49.d.b("DSLPageParser", "parseDeviceListPage: rootNode.nodes is null or empty");
        return r101;
    L13:
        Iterator<z> r104 = r100.c().iterator();
    L15:
        if (r104.hasNext() == false) goto L34;
        z r105 = r104.next();
        if (r105 == null) goto L15;
        if (r105.b() == DslNodeType.NAV_BAR) goto L20;
        if (r105.b() == DslNodeType.LAYER) goto L23;
        g49.d.b("DSLPageParser", "parseDeviceManagementPage: unrecognized node type " + r105.b());
        goto L15
    L23:
        List<z> r106 = r105.c();
        if (r106 == null) goto L26;
        z r107 = (z) CollectionsKt.getOrNull(r106, 0);
    L27:
        if (r107 == null) goto L28;
        if (r107.b() != DslNodeType.CARD) goto L31;
        r101.f22516b.add(new i(r107.d(), r107.a()));
        goto L15
    L31:
        g49.d.b("DSLPageParser", "parseDeviceListPage: unrecognized node type " + r107.b());
        goto L15
    L28:
        g49.d.b("DSLPageParser", "parseDeviceListPage: cardNode is null");
        goto L15
    L26:
        r107 = null;
        goto L27
    L20:
        r101.f22515a = c(r105);
        goto L15
    L34:
        return r101;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }

    public static m b(z r110) {
        Intrinsics.checkNotNullParameter(r110, "rootNode");
        m r100 = new m();
        List<z> r101 = r110.c();
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        g49.d.b("DSLPageParser", "parseDeviceManagementPage: rootNode.nodes is null or empty");
        return r100;
    L13:
        Iterator<z> r104 = r110.c().iterator();
    L15:
        if (r104.hasNext() == false) goto L126;
        z r105 = r104.next();
        if (r105 == null) goto L125;
        if (r105.b() != DslNodeType.NAV_BAR) goto L22;
        r100.f22517a = c(r105);
        goto L125
    L22:
        if (r105.b() != DslNodeType.SUBPAGES) goto L124;
        Intrinsics.checkNotNullParameter(r105, "subpagesNode");
        List<z> r106 = r105.c();
        if (r106 != null) goto L26;
    L29:
        boolean r107 = true;
    L30:
        ArrayList r108 = null;
        if (r107 == false) goto L33;
        g49.d.b("DSLPageParser", "parseDeviceManagementSubpages: subpagesNode.nodes is null or empty");
    L122:
        if (r108 == null) goto L125;
        ((ArrayList) r100.f22518b).addAll(r108);
        goto L125
    L33:
        ArrayList r109 = new ArrayList();
        Iterator<z> r111 = r105.c().iterator();
    L35:
        if (r111.hasNext() == false) goto L121;
        z r112 = r111.next();
        if (r112 == null) goto L120;
        if (r112.b() == DslNodeType.SUBPAGE) goto L41;
        g49.d.b("DSLPageParser", "parseDeviceManagementSubpages: unrecognized node type " + r112.b());
        goto L120
    L41:
        Intrinsics.checkNotNullParameter(r112, "subPageNode");
        List<z> r113 = r112.c();
        if (r113 != null) goto L44;
    L47:
        boolean r114 = true;
    L48:
        if (r114 == false) goto L50;
        g49.d.b("DSLPageParser", "parseSubPageInfo: subPageNode.nodes is null or empty");
        n r115 = null;
    L118:
        if (r115 == null) goto L120;
        r109.add(r115);
        goto L120
    L50:
        r115 = new n(null);
        Iterator<z> r116 = r112.c().iterator();
    L52:
        if (r116.hasNext() == false) goto L118;
        z r117 = r116.next();
        if (r117 == null) goto L55;
        if (r117.b() == DslNodeType.LAYER) goto L62;
        if (r117.b() == DslNodeType.TABS) goto L62;
        g49.d.b("DSLPageParser", "parseSubPageInfo: unrecognized node type " + r117.b());
    L62:
        if (r117.b() != DslNodeType.TABS) goto L63;
        Intrinsics.checkNotNullParameter(r117, "tabsNode");
        ArrayList r118 = new ArrayList();
        List<z> r119 = r117.c();
        if (r119 != null) goto L76;
    L79:
        boolean r120 = true;
    L80:
        if (r120 == false) goto L82;
        g49.d.b("DSLPageParser", "parseTabInfo: tabsNode.nodes is null or empty");
    L117:
        r115.f22520b.addAll(r118);
        r102 = 0;
        goto L52
    L82:
        Iterator<z> r121 = r117.c().iterator();
    L84:
        if (r121.hasNext() == false) goto L117;
        z r122 = r121.next();
        if (r122 == null) goto L87;
        if (r122.b() != DslNodeType.TAB) goto L90;
        e0 r123 = new e0(r122.a());
        List<z> r124 = r122.c();
        if (r124 != null) goto L94;
    L97:
        boolean r125 = true;
    L98:
        if (r125 == true) goto L99;
        Iterator<z> r126 = r122.c().iterator();
    L102:
        if (r126.hasNext() == false) goto L116;
        z r127 = r126.next();
        if (r127 == null) goto L115;
        List<z> r128 = r127.c();
        if (r128 == null) goto L108;
        z r129 = (z) CollectionsKt.getOrNull(r128, r102);
    L109:
        if (r129 != null) goto L112;
        g49.d.b("DSLPageParser", "parseTabInfo: tabInnerNode is null");
        goto L115
    L112:
        if (r129.b() == DslNodeType.CARD) goto L114;
        g49.d.b("DSLPageParser", "parseTabInfo: tabInnerNode is not card");
        goto L115
    L114:
        ((ArrayList) r123.f22509b).add(new i(r129.d(), r129.a()));
        goto L115
    L108:
        r129 = null;
    L115:
        r102 = 0;
        goto L102
    L116:
        r118.add(r123);
        r102 = 0;
        goto L84
    L99:
        g49.d.b("DSLPageParser", "parseTabInfo: tabNode.nodes is null or empty");
        r118.add(r123);
        goto L84
    L94:
        if (r124.isEmpty() == true) goto L97;
        r125 = false;
        goto L98
    L90:
        g49.d.b("DSLPageParser", "parseTabInfo: unrecognized node type " + r122.b());
        goto L84
    L87:
        g49.d.b("DSLPageParser", "parseTabInfo: tabNode is null");
        goto L84
    L76:
        if (r119.isEmpty() == true) goto L79;
        r120 = false;
        goto L80
    L63:
        List<z> r130 = r117.c();
        if (r130 == null) goto L66;
        z r131 = (z) CollectionsKt.getOrNull(r130, r102);
    L67:
        if (r131 == null) goto L68;
        if (r131.b() != DslNodeType.CARD) goto L71;
        r115.f22519a.add(new i(r131.d(), r131.a()));
        goto L52
    L71:
        g49.d.b("DSLPageParser", "parseSubPageInfo: subpage innerNode is not card");
        goto L52
    L68:
        g49.d.b("DSLPageParser", "parseSubPageInfo: subpage innerNode is null");
        goto L52
    L66:
        r131 = null;
        goto L67
    L55:
        g49.d.b("DSLPageParser", "parseSubPageInfo: childNode is null");
        goto L52
    L44:
        if (r113.isEmpty() == true) goto L47;
        r114 = false;
    L120:
        r102 = 0;
        goto L35
    L121:
        r108 = r109;
        goto L122
    L26:
        if (r106.isEmpty() == true) goto L29;
        r107 = false;
        goto L30
    L124:
        g49.d.b("DSLPageParser", "parseDeviceManagementPage: unrecognized node type " + r105.b());
    L125:
        r102 = 0;
        goto L15
    L126:
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }

    public static v c(z r100) {
        Intrinsics.checkNotNullParameter(r100, "navBarNode");
        return new v(r100.a());
    }

    public static c0 d(z r100) {
        Intrinsics.checkNotNullParameter(r100, "rootNode");
        r100.getClass();
        c0 r101 = new c0();
        List<z> r102 = r100.c();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        g49.d.b("DSLPageParser", "parseSimplePage: rootNode.nodes is null or empty");
        return r101;
    L13:
        Iterator<z> r104 = r100.c().iterator();
        boolean r105 = false;
    L15:
        if (r104.hasNext() == false) goto L36;
        z r106 = r104.next();
        if (r106 == null) goto L15;
        if (r106.b() == DslNodeType.NAV_BAR) goto L20;
        if (r106.b() == DslNodeType.LAYER) goto L23;
        g49.d.b("DSLPageParser", "parseSimplePage: unrecognized node type " + r106.b());
        goto L15
    L23:
        if (r105 == true) goto L24;
        List<z> r107 = r106.c();
        if (r107 == null) goto L28;
        z r108 = (z) CollectionsKt.getOrNull(r107, 0);
    L29:
        if (r108 == null) goto L30;
        if (r108.b() != DslNodeType.CARD) goto L33;
        r101.f22504a = new i(r108.d(), r108.a());
        r105 = true;
        goto L15
    L33:
        g49.d.b("DSLPageParser", "parseSimplePage: unrecognized node type " + r108.b());
        goto L15
    L30:
        g49.d.b("DSLPageParser", "parseSimplePage: cardNode is null");
        goto L15
    L28:
        r108 = null;
        goto L29
    L24:
        g49.d.b("DSLPageParser", "parseSimplePage: more than one card");
        goto L15
    L20:
        c(r106);
        goto L15
    L36:
        return r101;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }
}
