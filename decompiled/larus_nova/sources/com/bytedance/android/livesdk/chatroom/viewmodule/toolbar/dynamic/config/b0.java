package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ogc.OgcVSWebActivityBehavior;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSToolbarConfigData;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f115980f;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r100 = ToolbarButton.VS_ACTIVITY_ONE;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r100, r100, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarVSOperation.INSTANCE;
    }

    public b0(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        super(null, null, 7);
        this.f115980f = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r110, boolean r111, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "button");
        ILiveToolbarData r100 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(this.f115980f).getToolbarData();
        py.k r101 = null;
        if (r100 == null) goto L63;
        List<IToolbarComponentData> r102 = r100.getToolbarDataList();
        if (r102 == null) goto L63;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L61;
        Object r104 = r103.next();
        IToolbarComponentData r105 = (IToolbarComponentData) r104;
        if (r105.getId() != 32) goto L58;
        Intrinsics.checkNotNullParameter(r105, "config");
        Intrinsics.checkNotNullParameter(r105, "config");
        String r106 = r105.getScheme();
        boolean r107 = true;
        if (r106 != null) goto L14;
    L17:
        boolean r108 = true;
    L19:
        if (r108 == true) goto L38;
        String r109 = r105.getScheme();
        if (r109 == null) goto L25;
        List r112 = StringsKt.split$default(r109, new String[]{"?"}, false, 0, 6, null);
        if (r112 == null) goto L25;
    L27:
        if (r112.size() <= 1) goto L38;
        Iterator r113 = StringsKt.split$default((String) ListProtector.get(r112, 1), new String[]{"&"}, false, 0, 6, null).iterator();
    L30:
        if (r113.hasNext() == false) goto L38;
        List r114 = StringsKt.split$default((String) r113.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null);
        if (r114.size() != 2) goto L30;
        if (Intrinsics.areEqual((String) ListProtector.get(r114, 0), "is_vote_page") == false) goto L30;
        if (Intrinsics.areEqual((String) ListProtector.get(r114, 1), "1") == false) goto L30;
        boolean r115 = true;
    L39:
        vr1.u r116 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f115980f, null, 2);
        if (r116 == null) goto L44;
        Boolean r117 = r116.isVSVerticalStream();
        if (r117 == null) goto L44;
        boolean r118 = r117.booleanValue();
    L45:
        if (r115 == false) goto L52;
        if (r118 == false) goto L52;
        vr1.u r119 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(this.f115980f, null, 2);
        if (r119 == null) goto L52;
        com.bytedance.live.datacontext.m<Boolean> r120 = r119.y();
        if (r120 == null) goto L52;
        r120.setValue(Boolean.TRUE);
    L52:
        if (r115 == false) goto L55;
        if (r118 == true) goto L55;
        boolean r121 = true;
    L56:
        if (r121 == true) goto L58;
    L59:
        if (r107 == false) goto L8;
    L62:
        IToolbarComponentData r122 = (IToolbarComponentData) r104;
    L64:
        if (r122 == null) goto L110;
        String r123 = r122.getExtraData();
        if (r123 != null) goto L95;
    L75:
        VSToolbarConfigData r124 = null;
    L76:
        if (r111 == true) goto L78;
    L86:
        String r125 = r122.getScheme();
        py.k r126 = r122.getIcon();
        if (r124 == null) goto L89;
        Integer r127 = Integer.valueOf(r124.getToolbarType());
    L90:
        if (r124 == null) goto L92;
        r101 = r124.getDynamicIcon();
    L92:
        OgcVSWebActivityBehavior r128 = new OgcVSWebActivityBehavior(r125, r126, r127, r101, false);
    L94:
        return r128;
    L89:
        r127 = null;
        goto L90
    L78:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.y().i(r210) == false) goto L86;
        String r129 = r122.getScheme();
        py.k r130 = r122.getIcon();
        if (r124 == null) goto L82;
        Integer r131 = Integer.valueOf(r124.getToolbarType());
    L83:
        if (r124 == null) goto L85;
        r101 = r124.getDynamicIcon();
    L85:
        r128 = new OgcVSWebActivityBehavior(r129, r130, r131, r101, true);
        goto L94
    L82:
        r131 = null;
        goto L83
    L95:
        JsonElement r132 = GsonHelper.parser().parse(r123);     // Catch: Throwable -> L73
        if (r132 == null) goto L70;
        JsonObject r133 = r132.getAsJsonObject();     // Catch: Throwable -> L73
    L71:
        r124 = (VSToolbarConfigData) GsonHelper.get().fromJson(r133, VSToolbarConfigData.class);     // Catch: Throwable -> L73
        goto L76
    L70:
        r133 = null;
    L73:
        th = move-exception;
        x8.a.c("Error parsing json", th, false);
        goto L75
    L110:
        return null;
    L55:
        r121 = false;
    L44:
        r118 = true;
    L25:
        r112 = CollectionsKt.emptyList();
    L38:
        r115 = false;
        goto L39
    L14:
        if (r106.length() == 0) goto L17;
        r108 = false;
    L58:
        r107 = false;
        goto L59
    L61:
        r104 = null;
    L63:
        r122 = null;
        goto L64
    }
}
