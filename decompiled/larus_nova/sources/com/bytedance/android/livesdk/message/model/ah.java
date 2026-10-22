package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.InteractOpenChatMessage.ChatItem")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ah;", "", "", "Lcom/bytedance/android/livesdk/message/model/uh;", "userInfo", "Ljava/util/List;", "", "secNickName", "Ljava/lang/String;", "secAvatarUrl", "content", "", "timestamp", "I", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ah implements vh7.h {

    @SerializedName("content")
    public String content;

    @SerializedName("sec_avatar_url")
    public String secAvatarUrl;

    @SerializedName("sec_nick_name")
    public String secNickName;

    @SerializedName("timestamp")
    public int timestamp;

    @SerializedName("app_user_info")
    public List<uh> userInfo;

    public ah() {
        this.userInfo = CollectionsKt.emptyList();
        this.secNickName = "";
        this.secAvatarUrl = "";
        this.content = "";
    }

    public ah(am3.g r100) {
        this.userInfo = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.userInfo.add(new uh(r100));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.secNickName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.secAvatarUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.content = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.timestamp = r100.i();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.userInfo.isEmpty() == false) goto L25;
        this.userInfo = CollectionsKt.emptyList();
    L25:
        if (this.secNickName != null) goto L28;
        this.secNickName = "";
    L28:
        if (this.secAvatarUrl != null) goto L31;
        this.secAvatarUrl = "";
    L31:
        if (this.content != null) goto L52;
        this.content = "";
        return;
    }
}
