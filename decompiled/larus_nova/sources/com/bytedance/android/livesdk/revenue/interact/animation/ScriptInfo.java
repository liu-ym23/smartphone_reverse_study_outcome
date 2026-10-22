package com.bytedance.android.livesdk.revenue.interact.animation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/interact/animation/ScriptInfo;", "", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "script", "getScript", "setScript", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScriptInfo {

    @SerializedName("duration")
    private long duration;

    @SerializedName("name")
    private String name;

    @SerializedName("script")
    private String script;

    public ScriptInfo() {
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
}
