package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.di1;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorBottomToolbar;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f92168a;

    public static boolean b() {
        com.bytedance.android.livesdk.revenue.service.toolbar.f r100 = (com.bytedance.android.livesdk.revenue.service.toolbar.f) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.f.class));
        if (r100 == null) goto L5;
        di1 r101 = r100.l3();
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.f120036a;
    L5:
        r101 = null;
        goto L6
    }

    public static com.bytedance.android.livesdk.link.model.t c() {
        yz0.k r100 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r100 == null) goto L16;
        IRoom r101 = r100.getRoom();
        if (r101 == null) goto L19;
        IRoomOthersData r102 = r101.getRoomOthers();
        if (r102 == null) goto L17;
        Intrinsics.checkNotNullParameter(r102, "$this$anchorBottomToolbarExt");
        IAnchorBottomToolbar r103 = r102.getAnchorBottomToolbar();
        if (r103 == null) goto L12;
        com.bytedance.android.livesdk.link.model.i r104 = (com.bytedance.android.livesdk.link.model.i) r103.castToOrNull(com.bytedance.android.livesdk.link.model.i.class);
    L13:
        if (r104 != null) goto L15;
        return null;
    L15:
        return r104.getAnchorLinkmicentrance();
    L12:
        r104 = null;
        goto L13
    L17:
        return null;
    L19:
        return null;
    L16:
        return null;
    }

    public k() {
        PkPanelType r100 = PkPanelType.PK;
        int r101 = e.f92145d;
        this.f92168a = new h(r100, new e(IconResMode.DRAWABLE, null, Integer.valueOf(R.drawable.ttlive_selector_action_btn_pk)), s1.B(R.string.ttlive_anchor_toolbar_title_pk), "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean g() {
        com.bytedance.android.livesdk.link.model.t r100 = c();
        if (r100 == null) goto L5;
        String r101 = r100.getLeadPkFreqKey();
    L7:
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        return false;
    L16:
        return !Intrinsics.areEqual((String) l51.a.I0.getValue(null, l51.a.f507436a[98]), r101);
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    public static void h() {
        com.bytedance.android.livesdk.link.model.t r100 = c();
        if (r100 == null) goto L5;
        String r101 = r100.getLeadPkFreqKey();
    L7:
        if (by0.b.a(r101) == false) goto L12;
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        KProperty[] r102 = l51.a.f507436a;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        l51.a.I0.setValue(null, l51.a.f507436a[98], r101);
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public static boolean j() {
        if (b() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.link.model.t r100 = c();
        if (r100 != null) goto L8;
        return false;
    L8:
        yz0.k r101 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r101 == null) goto L11;
        IRoom r102 = r101.getRoom();
    L13:
        if (r102 != null) goto L15;
    L17:
        boolean r103 = false;
    L18:
        if (r103 == false) goto L21;
        return false;
    L21:
        if (by0.b.a(r100.getText()) == true) goto L23;
        return false;
    L23:
        if (a(r100.getIcon()) == true) goto L25;
        return false;
    L25:
        if (a(r100.getPkIcon()) == true) goto L27;
        return false;
    L27:
        if (a(r100.getAnchorIcon()) == true) goto L29;
        return false;
    L29:
        if (a(r100.getLink2PkImage()) == true) goto L31;
        return false;
    L31:
        if (a(r100.getPk2LinkImage()) == true) goto L33;
        return false;
    L33:
        if (a(r100.getLeadPkImage()) == false) goto L42;
        return true;
    L42:
        return false;
    L15:
        if (r102.isLiveTypeAudio() != true) goto L17;
        r103 = true;
        goto L18
    L11:
        r102 = null;
        goto L13
    }

    public final h d() {
        if (j() == false) goto L20;
        com.bytedance.android.livesdk.link.model.t r100 = c();
        h r101 = null;
        if (r100 == null) goto L18;
        int r102 = r100.getPanelType();
        py.k r103 = r100.getIcon();
        if (r103 == null) goto L18;
        String r104 = r100.getText();
        if (r104 == null) goto L18;
        String r105 = r100.getWordType();
        if (r102 != 1) goto L16;
        PkPanelType r106 = PkPanelType.Anchor;
    L17:
        int r107 = e.f92145d;
        Intrinsics.checkNotNullParameter(r103, "image");
        r101 = new h(r106, new e(IconResMode.IMAGE_MODEL, r103, null), r104, r105);
        goto L18
    L16:
        r106 = PkPanelType.PK;
    L18:
        if (r101 == null) goto L20;
        return r101;
    L20:
        return this.f92168a;
    }

    public static boolean a(py.k r100) {
        if (r100 == null) goto L6;
        List<String> r101 = r100.getUrls();
        if (r101 == null) goto L6;
        String r102 = (String) CollectionsKt.firstOrNull(r101);
    L8:
        return by0.b.a(r102);
    L6:
        r102 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String e(PkPanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        boolean r101 = false;
        if (r100 != PkPanelType.PK) goto L9;
        String r102 = (String) l51.a.J0.getValue(null, l51.a.f507436a[99]);
        if (r102.length() != 0) goto L7;
        r101 = true;
    L7:
        if (r101 == false) goto L14;
        r102 = "PK";
    L14:
        com.bytedance.android.livesdk.link.model.t r103 = c();
        if (r103 != null) goto L17;
        return r102;
    L17:
        PkPanelType.a r104 = PkPanelType.Companion;
        Integer r105 = Integer.valueOf(r103.getPanelType());
        r104.getClass();
        if (PkPanelType.a.a(r105) != r100) goto L24;
        String r106 = r103.getText();
        if (r106 != null) goto L23;
        return r102;
    L23:
        return r106;
    L24:
        return r102;
    L9:
        r102 = (String) l51.a.K0.getValue(null, l51.a.f507436a[100]);
        if (r102.length() != 0) goto L12;
        r101 = true;
    L12:
        if (r101 == false) goto L14;
        r102 = "连主播";
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String f(PkPanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != PkPanelType.PK) goto L5;
        String r101 = (String) l51.a.L0.getValue(null, l51.a.f507436a[101(0x65, float:1.42E-43)]);
    L6:
        com.bytedance.android.livesdk.link.model.t r102 = c();
        if (r102 != null) goto L9;
        return r101;
    L9:
        PkPanelType.a r103 = PkPanelType.Companion;
        Integer r104 = Integer.valueOf(r102.getPanelType());
        r103.getClass();
        if (PkPanelType.a.a(r104) == r100) goto L12;
        return r101;
    L12:
        return r102.getWordType();
    L5:
        r101 = (String) l51.a.M0.getValue(null, l51.a.f507436a[102(0x66, float:1.43E-43)]);
        goto L6
    }

    public static void i(PkPanelType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "wordType");
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        Integer r104 = Integer.valueOf(r100.toConstInt());
        com.bytedance.tools.kcp.spongepreference.runtime.a r105 = l51.a.H0;
        KProperty<?>[] r106 = l51.a.f507436a;
        r105.setValue(null, r106[97], r104);
        if (r100 != PkPanelType.PK) goto L12;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        l51.a.J0.setValue(null, r106[99], r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        l51.a.L0.setValue(null, r106[101(0x65, float:1.42E-43)], r102);
    L12:
        if (r100 != PkPanelType.Anchor) goto L15;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        l51.a.K0.setValue(null, r106[100], r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        l51.a.M0.setValue(null, r106[102(0x66, float:1.43E-43)], r102);
        return;
    L15:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
