package com.bytedance.android.livesdk.player;

import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.videoarch.liveplayer.model.LiveStreamInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class z implements gl0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveStreamInfo f156272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f156273b;

    public z(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "streamInfoObject");
        this.f156273b = r100;
        this.f156272a = new LiveStreamInfo(r100);
    }

    @Override // gl0.e
    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(PullConfiguration.PROCESS_NAME_MAIN, "playLevel");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L12:
        return "";
    L5:
        if (TextUtils.isEmpty("flv") == true) goto L12;
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(this.f156273b, "data").optJSONObject(r100);     // Catch: Exception -> L10
        if (r101 == null) goto L12;
        return r101.optJSONObject(PullConfiguration.PROCESS_NAME_MAIN).optString("flv");
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    @Override // gl0.e
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resolutionKey");
        Intrinsics.checkNotNullParameter(PullConfiguration.PROCESS_NAME_MAIN, "playLevel");
        LiveStreamInfo r101 = this.f156272a;
        if (r101 == null) goto L6;
        String r102 = r101.getVCodec(r100, PullConfiguration.PROCESS_NAME_MAIN);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // gl0.e
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(PullConfiguration.PROCESS_NAME_MAIN, "playLevel");
        LiveStreamInfo r101 = this.f156272a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getStreamUrlForResolution(r100, "flv", PullConfiguration.PROCESS_NAME_MAIN);
    }
}
