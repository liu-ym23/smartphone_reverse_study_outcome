package com.bytedance.android.livesdkapi.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.LinkPhase")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LinkPhase;", "", "()V", "phaseId", "", "phaseSecondsBegin", "phaseSecondsEnd", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPhase implements h {

    @SerializedName("phase_id")
    public int phaseId;

    @SerializedName("phase_seconds_begin")
    public int phaseSecondsBegin;

    @SerializedName("phase_seconds_end")
    public int phaseSecondsEnd;

    public LinkPhase() {
    }

    public LinkPhase(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.phaseId = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.phaseSecondsBegin = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.phaseSecondsEnd = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
