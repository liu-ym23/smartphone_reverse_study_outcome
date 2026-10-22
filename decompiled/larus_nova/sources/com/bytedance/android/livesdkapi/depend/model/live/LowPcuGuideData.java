package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LowPcuGuideData;", "", "()V", "delayTime", "", "enableBackup", "", "guideText", "", "status", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LowPcuGuideData implements h {

    @SerializedName("delay_time")
    public int delayTime;

    @SerializedName("enable_backup")
    public boolean enableBackup;

    @SerializedName("guide_text")
    public String guideText;

    @SerializedName("status")
    public int status;

    public LowPcuGuideData() {
    }

    public LowPcuGuideData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.guideText = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.status = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.enableBackup = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.delayTime = (int) r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
