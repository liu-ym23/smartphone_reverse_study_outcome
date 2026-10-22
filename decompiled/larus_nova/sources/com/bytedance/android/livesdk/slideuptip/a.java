package com.bytedance.android.livesdk.slideuptip;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.feed.RoomEnterBackendResponse.RoomEnterBackendData")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/slideuptip/a;", "", "", "feedSlideGuide", "Z", "getFeedSlideGuide", "()Z", "setFeedSlideGuide", "(Z)V", "", "slideDelayTime", "I", "getSlideDelayTime", "()I", "setSlideDelayTime", "(I)V", "", "slideGuideText", "Ljava/lang/String;", "getSlideGuideText", "()Ljava/lang/String;", "setSlideGuideText", "(Ljava/lang/String;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("feed_slide_guide")
    protected boolean feedSlideGuide;

    @SerializedName("feed_slide_guide_display_time")
    protected int slideDelayTime;

    @SerializedName("feed_slide_guide_text")
    protected String slideGuideText;

    public a() {
    }

    public a(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.feedSlideGuide = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.slideDelayTime = r100.i();
        goto L3
    L10:
        if (r102 != 5) goto L11;
        this.slideGuideText = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }
}
