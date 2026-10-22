package com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sve_core.u;
import com.ss.bduploader.BDVideoUploaderBase;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f55107a;

    public d(b r100) {
        this.f55107a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        String r100 = (String) r110;
        b r101 = this.f55107a;
        int r102 = i.f55123j;
        Function1 r103 = (Function1) r101.c(new u("team_play_entrance_state")).component2();
        if (r100.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r103.invoke(new i(null, null, null, null, null, null, Boolean.FALSE, null, BDVideoUploaderBase.KeyIsDynamicSliceForceConfig));
        return;
    L8:
        JSONObject r105 = new JSONObject(r100);
        boolean r106 = r105.optBoolean(GXTemplateKey.GAIAX_PLACEHOLDER);
        yr.b.b(4, "TeamPlayEntranceEffect", "handleRefresh, placeholder = " + r106);
        String r107 = r105.optString("icon");
        String r111 = r105.optString("sub_icon");
        String r112 = r105.optString("title");
        String r113 = r105.optString("button_text");
        String r114 = r105.optString("button_schema");
        r103.invoke(new i(r107, r111, r112, r105.optString(BdpAppEventConstant.PARAMS_SUB_TITLE), r113, r114, Boolean.valueOf(!r106), r105.optString("extra"), Boolean.TRUE));
        return;
    L5:
        r104 = false;
        goto L6
    }
}
