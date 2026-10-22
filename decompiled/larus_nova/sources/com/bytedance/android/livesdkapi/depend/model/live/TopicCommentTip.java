package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TopicCommentTip;", "", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "frequency", "getFrequency", "setFrequency", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TopicCommentTip implements h {

    @SerializedName("content")
    protected String content;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("frequency")
    protected long frequency;

    public TopicCommentTip() {
    }

    public final String getContent() {
        return this.content;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getFrequency() {
        return this.frequency;
    }

    public TopicCommentTip(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.content = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.frequency = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.duration = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setFrequency(long r100) {
        this.frequency = r100;
    }
}
