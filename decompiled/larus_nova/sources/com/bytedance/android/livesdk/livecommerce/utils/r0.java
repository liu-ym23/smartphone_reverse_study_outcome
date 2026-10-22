package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class r0 extends a1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f153113c;

    public r0(int r100, long r101) {
        super("msg");
        this.f153113c = r100;
        JSONObject r102 = this.f153061a;
        r102.put(SeiMessageConst.MSG_TYPE, r100);
        r102.put("msg_id", r101);
    }
}
