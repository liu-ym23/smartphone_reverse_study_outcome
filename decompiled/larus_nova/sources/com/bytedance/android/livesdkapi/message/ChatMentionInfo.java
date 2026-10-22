package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/ChatMentionInfo;", "", "()V", "mentionUserIds", "", "", "getMentionUserIds", "()Ljava/util/List;", "setMentionUserIds", "(Ljava/util/List;)V", "mentionWebcastUserIds", "getMentionWebcastUserIds", "setMentionWebcastUserIds", "showTime", "", "getShowTime", "()J", "setShowTime", "(J)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatMentionInfo implements h {

    @SerializedName("mention_user_ids")
    protected List<String> mentionUserIds;

    @SerializedName("mention_webcast_user_ids")
    protected List<String> mentionWebcastUserIds;

    @SerializedName("show_time")
    protected long showTime;

    public ChatMentionInfo() {
    }

    public final List<String> getMentionUserIds() {
        return this.mentionUserIds;
    }

    public final List<String> getMentionWebcastUserIds() {
        return this.mentionWebcastUserIds;
    }

    public final long getShowTime() {
        return this.showTime;
    }

    public ChatMentionInfo(g r100) {
        this.mentionUserIds = new ArrayList();
        this.mentionWebcastUserIds = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L10;
        List<String> r103 = this.mentionWebcastUserIds;
    L15:
        r103.add(am3.h.c(r100));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.showTime = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L14:
        r103 = this.mentionUserIds;
        goto L15
    L16:
        r100.d(r101);
    }

    public final void setMentionUserIds(List<String> r100) {
        this.mentionUserIds = r100;
    }

    public final void setMentionWebcastUserIds(List<String> r100) {
        this.mentionWebcastUserIds = r100;
    }

    public final void setShowTime(long r100) {
        this.showTime = r100;
    }
}
