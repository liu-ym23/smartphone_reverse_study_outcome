package com.bytedance.android.live.base.model.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.LinkmicAsrSummary")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/b6;", "", "", "summary", "Ljava/lang/String;", "getSummary", "()Ljava/lang/String;", "setSummary", "(Ljava/lang/String;)V", "", "qualityLevel", "I", "getQualityLevel", "()I", "setQualityLevel", "(I)V", "showState", "getShowState", "setShowState", "summaryId", "getSummaryId", "setSummaryId", "generateTimeStamp", "getGenerateTimeStamp", "setGenerateTimeStamp", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b6 implements vh7.h {

    @SerializedName("generate_time_stamp")
    protected String generateTimeStamp;

    @SerializedName("quality_level")
    protected int qualityLevel;

    @SerializedName("show_state")
    protected int showState;

    @SerializedName("summary")
    protected String summary;

    @SerializedName("summary_id")
    protected String summaryId;

    public b6() {
        this.qualityLevel = AsrContentQualityLevel.AsrContentQualityLevelUnDefined.getValue();
        this.showState = SummaryShowState.SummaryShowStateUnDefined.getValue();
    }

    public b6(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 1) goto L7;
        this.summary = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.qualityLevel = r100.i();
        r102 = r102 | 1;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.showState = r100.i();
        r102 = r102 | 2;
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this.summaryId = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this.generateTimeStamp = am3.h.c(r100);
        goto L3
    L14:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L24;
        this.qualityLevel = AsrContentQualityLevel.AsrContentQualityLevelUnDefined.getValue();
    L24:
        if ((r102 & 2) != 0) goto L45;
        this.showState = SummaryShowState.SummaryShowStateUnDefined.getValue();
        return;
    }
}
