package com.bytedance.android.gamecp.common.track.filter;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.common.track.i;
import com.bytedance.android.gamecp.common.track.model.GPViewTrackData;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class GPViewFilter extends a<GPViewTrackData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f56798c;

    public GPViewFilter() {
        this.f56797b = "GPPageFilter";
        this.f56798c = 10;
    }

    public static GPViewTrackData d(View r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag(R.id.gamecp_view_tag_track_key);
    L7:
        if ((r102 instanceof GPViewTrackData) == false) goto L11;
        r101 = r102;
    L11:
        return (GPViewTrackData) r101;
    L5:
        r102 = null;
        goto L7
    }

    public final List<GPViewTrackData> e(final View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        GPViewTrackData r100 = d(r110);
        ArrayList r101 = new ArrayList();
        View r102 = r110;
        GPViewTrackData r103 = r100;
    L4:
        if (r103 != null) goto L6;
    L7:
        if (r103 == null) goto L9;
        ListProtector.add(r101, 0, r103);
    L9:
        r102 = UtilityKotlinExtentionsKt.f(r102);
        if (r102 == null) goto L11;
        r103 = d(r102);
    L11:
        String r104 = null;
        if (r103 == null) goto L19;
        if (r103.isRootView() != true) goto L19;
        ListProtector.add(r101, 0, r103);
        if (r101.size() <= 1) goto L34;
        final List r105 = r101.subList(0, r101.size() - 1);
        UtilityKotlinExtentionsKt.g(0, false, false, new GPViewFilter$cacheViewParentListData$1(r110, r105), 7);
    L34:
        if (r103 != null) goto L36;
    L38:
        int r111 = i.f56806a;
        String r112 = this.f56797b;
        StringBuilder r106 = new StringBuilder("module: ");
        if (r100 == null) goto L41;
        r104 = r100.getName();
    L41:
        r106.append(r104);
        r106.append(", don't set rootview trackdata, need use GamecpTracker.registerPage() 或者GamecpTracker.registerTopModule() set data");
        yr.c.g(r112, r106.toString());
    L42:
        return r101;
    L36:
        if (r103.isRootView() != true) goto L38;
    L19:
        if (r110.isAttachedToWindow() == true) goto L21;
    L22:
        Object r113 = r110.getTag(R.id.gamecp_view_tag_parent_cache_key);
        if ((r113 instanceof List) == true) goto L25;
        r113 = null;
    L25:
        List r114 = (List) r113;
        if (r114 == null) goto L28;
        int r107 = r114.size();
    L29:
        if (r107 <= 0) goto L34;
        r101.clear();
        Intrinsics.checkNotNull(r114);
        r101.addAll(r114);
        if (r100 == null) goto L33;
        r101.add(r100);
    L33:
        r103 = (GPViewTrackData) ListProtector.get(r101, 0);
        goto L34
    L28:
        r107 = 0;
        goto L29
    L21:
        if (r110.isShown() == true) goto L34;
    L6:
        if (r103.isRootView() == true) goto L11;
        goto L7
    }

    public final void f(final View r100, final GPViewTrackData r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        UtilityKotlinExtentionsKt.g(0, false, false, new GPViewFilter$setViewTrackData$1(this, r100, r101), 7);
    }

    public final void b(View r100, HashMap<String, String> r110, Map<String, ? extends Object> r111, boolean r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "resultMap");
        Intrinsics.checkNotNullParameter(r111, "extraAttrs");
        Intrinsics.checkNotNullParameter(r113, "resultProductType");
        c(r100, r110, null, r111, r112, r113);
    }

    public final void c(View r110, HashMap<String, String> r111, HashMap<String, Object> r112, Map<String, ? extends Object> r210, boolean r211, String r212) {
        GPViewTrackData r100 = d(r110);
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        ArrayList r103 = new ArrayList();
        new ArrayList();
        ArrayList r104 = (ArrayList) e(r110);
        if (r104.size() <= this.f56798c) goto L5;
        int r105 = i.f56806a;
        yr.c.g(this.f56797b, "GamecpTracker, exceed max view tree level 10 limit");
    L5:
        HashMap r106 = new HashMap();
        Iterator r107 = r104.iterator();
    L6:
        String r113 = "";
        if (r107.hasNext() == false) goto L31;
        GPViewTrackData r108 = (GPViewTrackData) r107.next();
        if (r108.isRootView() == true) goto L11;
        if ((true ^ Intrinsics.areEqual(r100, r108)) == false) goto L6;
        r103.add(r108.getName());
        r106.putAll(r108.getAttrs());
        goto L6
    L11:
        if ((!r108.getRouterData().isEmpty()) == false) goto L13;
        r101.putAll(r108.getRouterData());
    L15:
        if (r108.isPageData() == true) goto L17;
        if (r108.isModuleData() == false) goto L6;
        r102.putAll(r108.getLocationData());
        if ((true ^ Intrinsics.areEqual(r100, r108)) == false) goto L6;
        r103.add(r108.getName());
        r106.putAll(r108.getAttrs());
        goto L6
    L17:
        if ((true ^ Intrinsics.areEqual(r100, r108)) == false) goto L6;
        String r114 = r108.getName();
        if (r114 == null) goto L22;
        r113 = r114;
    L22:
        r102.put("current_page", r113);
        r106.putAll(r108.getAttrs());
        goto L6
    L13:
        r101.put("previous_page", "start_page");
        goto L15
    L31:
        r102.put("current_module", r103);
        if (r100 == null) goto L39;
        Map<String, Object> r109 = r100.getAttrs();
        if (r109 == null) goto L39;
        if ((!r109.isEmpty()) != true) goto L39;
        r106.putAll(r100.getAttrs());
    L39:
        if ((!r210.isEmpty()) == false) goto L41;
        r106.putAll(r210);
    L41:
        if (r100 != null) goto L43;
    L44:
        r101.remove("previous_page_attr");
        r101.remove("previous_module_attr");
    L46:
        if (r111 == null) goto L67;
        HashMap r115 = new HashMap();
        r115.put(CloudControlInf.ROUTE, e1.a(r101));
        r115.put("location", e1.a(r102));
        r115.put(SlcElement.KEY_ATTR, e1.a(r106));
        if (r100 == null) goto L52;
        boolean r116 = true;
        if (r100.isPageData() != true) goto L53;
        r115.put("page_name", r100.getName());
    L57:
        if (r211 == true) goto L59;
    L66:
        r115.putAll(r111);
        r111.putAll(r115);
        goto L67
    L59:
        if (TextUtils.isEmpty(r212) == false) goto L64;
        if (r100 == null) goto L63;
        String r117 = r100.getName();
        if (r117 == null) goto L63;
    L65:
        r115.put("product_type", r117);
        r115.remove("module_name");
        r115.remove("page_name");
    L63:
        r117 = "";
        goto L65
    L64:
        r117 = r212;
    L53:
        if (r100 == null) goto L57;
        if (r100.isModuleData() != r116) goto L57;
        r115.put("module_name", r100.getName());
        goto L57
    L52:
        r116 = true;
    L67:
        if (r112 == null) goto L107;
        HashMap r118 = new HashMap();
        r118.put(CloudControlInf.ROUTE, r101);
        r118.put("location", r102);
        r118.put(SlcElement.KEY_ATTR, r106);
        if (r100 == null) goto L73;
        boolean r119 = true;
        if (r100.isPageData() != true) goto L74;
        r118.put("page_name", r100.getName());
    L78:
        if (r211 == true) goto L80;
    L88:
        r118.putAll(r112);
        r112.putAll(r118);
        return;
    L80:
        if (TextUtils.isEmpty(r212) == false) goto L86;
        if (r100 == null) goto L87;
        String r120 = r100.getName();
        if (r120 == null) goto L87;
        r113 = r120;
    L87:
        r118.put("product_type", r113);
        r118.remove("module_name");
        r118.remove("page_name");
        goto L88
    L86:
        r113 = r212;
    L74:
        if (r100 == null) goto L78;
        if (r100.isModuleData() != r119) goto L78;
        r118.put("module_name", r100.getName());
        goto L78
    L73:
        r119 = true;
        goto L74
    L107:
        return;
    L43:
        if (r100.getNeedReportRouterAttr() == true) goto L46;
        goto L44
    }
}
