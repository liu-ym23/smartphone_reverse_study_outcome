package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/MultiLinkScriptInfo;", "", "name", "", "duration", "", "script", "(Ljava/lang/String;JLjava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getScript", "setScript", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkScriptInfo {

    @SerializedName("duration")
    private long duration;

    @SerializedName("name")
    private String name;

    @SerializedName("script")
    private String script;

    public MultiLinkScriptInfo() {
        this(null, 0, null, 7, null);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScript() {
        return this.script;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setScript(String r100) {
        this.script = r100;
    }

    public MultiLinkScriptInfo(String r100, long r101, String r102) {
        this.name = r100;
        this.duration = r101;
        this.script = r102;
    }

    public /* synthetic */ MultiLinkScriptInfo(String r100, long r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
