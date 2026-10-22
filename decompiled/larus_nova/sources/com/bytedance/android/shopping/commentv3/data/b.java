package com.bytedance.android.shopping.commentv3.data;

import android.view.View;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import com.bytedance.android.shopping.commentv3.audio.f;
import com.bytedance.android.shopping.commentv3.event_chain.costom_event.l;
import fc3.c;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mc3.d;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommentParams f172736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fc3.a f172737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f172738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gc3.a f172739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f172740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f172741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, String> f172742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommentDataCenter f172743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f172744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f172745j;

    public final int a() {
        CommentParams r100 = this.f172736a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDataType();
    }

    public final boolean b() {
        CommentDataCenter r100 = this.f172743h;
        int r101 = r100.f172718w.a();
        if (r101 != DataType.PRODUCT.getType()) goto L6;
        return r100.f172699d;
    L6:
        if (r101 != DataType.SIMILAR.getType()) goto L9;
        return r100.f172700e;
    L9:
        if (r101 != DataType.MIX.getType()) goto L18;
        if (r100.f172699d == false) goto L13;
    L16:
        return true;
    L13:
        if (r100.d() == true) goto L15;
    L20:
        return false;
    L15:
        if (r100.f172700e == false) goto L20;
    L18:
        if (r101 != DataType.FUSION.getType()) goto L20;
        return r100.f172701f;
    }

    public final boolean c() {
        if (nc3.a.b(this.f172740e.f512877d.f512873a, com.bytedance.android.ec.core.event.a.KEY_MULTI_PIC_MODE, MultiPicMode.LIST.getMode()) != MultiPicMode.PIC.getMode()) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.f172740e.f512875b.b() == false) goto L10;
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final void d() {
        CommentDataCenter r100 = this.f172743h;
        r100.getClass();
        FetchFrom r101 = FetchFrom.LOAD_MORE;
        FetchFrom.monitorInteractionStart$default(r101, false, 1, null);
        r100.a(false, r100.f172718w.f172740e.f512875b.f(), r100.f172718w.f172740e.f512875b.c(), r101, null);
    }

    public b() {
        this.f172740e = new d();
        this.f172741f = new LinkedHashMap();
        this.f172743h = new CommentDataCenter(this);
        boolean r100 = true;
        this.f172744i = true;
        String r101 = y53.a.f566237a;
        long r102 = q.f48131a.getLong(y53.a.f566237a, 0);
        if (System.currentTimeMillis() > r102) goto L6;
        r100 = false;
    L6:
        this.f172745j = r100;
        new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(FetchFrom r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "from");
        int r100 = 14;
        View r101 = null;
        Object[] r102 = 0;
        Object[] r103 = 0;
        Object[] r104 = 0;
        Object[] r105 = 0;
        Object[] r106 = 0;
        if (r110 != FetchFrom.INIT) goto L38;
        mc3.a.C6799a r107 = mc3.a.f512870b;
        CommentParams r112 = this.f172736a;
        r107.getClass();
        if (r112 == null) goto L15;
        Map<String, Object> r108 = r112.getExtraParams();
        if (r108 == null) goto L15;
        if (r108.containsKey("first_filter") == false) goto L12;
    L14:
        String r109 = mc3.a.C6799a.c(r112, "first_filter");
        String r113 = mc3.a.C6799a.c(r112, "second_filter");
        LinkedHashMap r114 = new LinkedHashMap();
        r114.put("first_filter", r109);
        r114.put("second_filter", r113);
    L16:
        if (r114 == null) goto L20;
        int r115 = l.f172794e;
        SlcCommonAction r116 = l.a.a(r114);
        fc3.a r117 = this.f172737b;
        if (r117 == null) goto L42;
        r117.a(new c(r116, r101, r106 == true ? 1 : 0, r100));
    L42:
        CommentDataCenter r118 = this.f172743h;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r110, "from");
        r118.f172698c = 0;
        r118.f172696a = 0;
        r118.f172697b = 0;
        r118.f172699d = true;
        r118.f172700e = true;
        r118.f172701f = true;
        r118.f172708m.postValue(null);
        r118.a(true, r118.f172718w.f172740e.f512875b.f(), r118.f172718w.f172740e.f512875b.c(), r110, r111);
        return;
    L20:
        mc3.a.C6799a.b();
        CommentParams r119 = this.f172736a;
        if (r119 == null) goto L33;
        StatTagItem r120 = r119.getEnterClickTagItem();
        if (r120 == null) goto L33;
        CommentParams r121 = this.f172736a;
        if (r121 == null) goto L27;
        long r122 = r121.getPassedTagVersion();
    L28:
        long r123 = r120.getId();
        String r124 = r120.getTagName();
        long r125 = r120.getSentiment();
        if (r120.isStat() == false) goto L31;
        TabTypeEnum r126 = TabTypeEnum.TAB;
    L32:
        int r127 = r126.getType();
        Intrinsics.checkNotNullParameter(r124, "name");
        LinkedHashMap r128 = new LinkedHashMap();
        r128.put("id", String.valueOf(r123));
        r128.put("name", r124);
        r128.put("sentiment", Long.valueOf(r125));
        r128.put(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, Integer.valueOf(r127));
        r128.put("tag_version", Long.valueOf(r122));
        Unit r129 = Unit.INSTANCE;
        Map r130 = MapsKt.mapOf(TuplesKt.to("selected_tab", r128));
    L34:
        int r131 = l.f172794e;
        SlcCommonAction r132 = l.a.a(r130);
        fc3.a r133 = this.f172737b;
        if (r133 == null) goto L42;
        r133.a(new c(r132, r105 == true ? 1 : 0, r104 == true ? 1 : 0, r100));
        goto L42
    L31:
        r126 = TabTypeEnum.TAG;
        goto L32
    L27:
        r122 = 0;
    L33:
        r130 = mc3.a.C6799a.b();
        goto L34
    L12:
        if (r108.containsKey("second_filter") == true) goto L14;
    L15:
        r114 = null;
        goto L16
    L38:
        if (r110 != FetchFrom.SKU_SWITCH) goto L42;
        mc3.a.f512870b.getClass();
        LinkedHashMap r134 = new LinkedHashMap();
        r134.putAll(mc3.a.C6799a.b());
        r134.put("selected_first", "");
        r134.put("selected_second", "");
        r134.put("first_filter", "");
        r134.put("second_filter", "");
        r134.put(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, Integer.valueOf(SortType.DEFAULT.getType()));
        int r135 = l.f172794e;
        SlcCommonAction r136 = l.a.a(r134);
        fc3.a r137 = this.f172737b;
        if (r137 == null) goto L42;
        r137.a(new c(r136, r103 == true ? 1 : 0, r102 == true ? 1 : 0, r100));
        goto L42
    }
}
