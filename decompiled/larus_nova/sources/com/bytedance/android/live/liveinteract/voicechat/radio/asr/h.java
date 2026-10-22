package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends c<f> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f80503f;

    public static final class a {
    }

    static {
    }

    public final void e() {
        c("finishTalking come");
        if (b() == false) goto L9;
        int r100 = this.f80499b.sendDirective(1100, "");
        if (r100 != 0) goto L7;
        this.f80498a.compareAndSet(3, 4);
        return;
    L7:
        d("finish talking failed. ret=" + r100);
        return;
    }

    public h() {
    }

    public static Pair f(byte[] r100) {
        JSONObject r101 = new JSONObject(new String(r100, Charsets.UTF_8));     // Catch: Exception -> L11
        String r102 = r101.optString("reqid");     // Catch: Exception -> L11
        JSONArray r103 = r101.optJSONArray("result");     // Catch: Exception -> L11
        if (r103 == null) goto L8;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r103, 0);     // Catch: Exception -> L11
        if (r104 == null) goto L8;
        String r105 = JSONObjectProtectorUtils.getString(r104, "text");     // Catch: Exception -> L11
        if (r105 == null) goto L8;
    L9:
        return TuplesKt.to(r102, r105);
    L8:
        r105 = "";
    L11:
        e = move-exception;
        SafetyGuard.a("AnchorAsr get asr result failed", e, null);
        return null;
    }
}
