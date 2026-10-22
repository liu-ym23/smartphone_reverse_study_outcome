package com.bytedance.android.livesdk.log.filter;

import android.os.Bundle;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends a<am2.f> {
    public i() {
    }

    public final void J(Bundle r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        this.f153291b.remove("game_ranklist_id");     // Catch: Throwable -> L14
        if (r100 == null) goto L6;
        String r102 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_JUMP_EXTRA);     // Catch: Throwable -> L14
    L8:
        if (r2.a(r102) == false) goto L12;
        JSONObject r103 = new JSONObject(r102).optJSONObject("gamecp_context");     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        this.f153291b.put("game_ranklist_id", JSONObjectProtectorUtils.getString(r103, "game_ranklist_id"));     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L6:
        r102 = null;
    L14:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, String>> r101 = this.f153291b.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        Map.Entry<String, String> r102 = r101.next();
        if (r102.getValue().length() <= 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        Map.Entry<String, String> r104 = r102;
    L14:
        if (r104 == null) goto L6;
        r100.put(r102.getKey(), r102.getValue());
        goto L6
    L13:
        r104 = null;
        goto L14
    L10:
        r103 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        am2.f r101 = (am2.f) r100;
        Map<String, String> r102 = this.f153291b;
        String r103 = "";
        if (r101 == null) goto L6;
        String r104 = r101.f4274a;
        if (r104 == null) goto L6;
    L7:
        r102.put("enter_from", r104);
        Map<String, String> r105 = this.f153291b;
        if (r101 == null) goto L11;
        String r106 = r101.f4275b;
        if (r106 == null) goto L11;
    L12:
        r105.put("promote_game_id", r106);
        Map<String, String> r107 = this.f153291b;
        if (r101 == null) goto L16;
        String r108 = r101.f4276c;
        if (r108 == null) goto L16;
    L17:
        r107.put("promote_game_name", r108);
        Map<String, String> r109 = this.f153291b;
        if (r101 == null) goto L21;
        String r110 = r101.f4277d;
        if (r110 == null) goto L21;
    L22:
        r109.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, r110);
        Map<String, String> r111 = this.f153291b;
        if (r101 == null) goto L26;
        String r112 = r101.f4278e;
        if (r112 == null) goto L26;
    L27:
        r111.put("order", r112);
        Map<String, String> r113 = this.f153291b;
        if (r101 == null) goto L33;
        String r114 = r101.f4279f;
        if (r114 == null) goto L33;
        r103 = r114;
    L33:
        r113.put("label", r103);
        return;
    L26:
        r112 = "";
    L21:
        r110 = "";
    L16:
        r108 = "";
    L11:
        r106 = "";
    L6:
        r104 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.f r102 = (am2.f) r101;
        if (r100 == null) goto L17;
        Iterator<Map.Entry<String, String>> r103 = this.f153291b.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L23;
        Map.Entry<String, String> r104 = r103.next();
        if (r104.getValue().length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        Map.Entry<String, String> r106 = r104;
    L15:
        if (r106 == null) goto L7;
        r100.put(r104.getKey(), r104.getValue());
        goto L7
    L14:
        r106 = null;
        goto L15
    L11:
        r105 = false;
        goto L12
    L23:
        return;
    }
}
