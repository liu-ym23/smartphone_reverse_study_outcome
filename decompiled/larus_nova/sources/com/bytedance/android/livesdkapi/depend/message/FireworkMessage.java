package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.FireworkMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/FireworkMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "count", "J", "reportTimeGap", "pushId", "", "pushIdStr", "Ljava/lang/String;", "", "Lcom/bytedance/android/livesdkapi/depend/message/FireworkMessage$User;", "users", "Ljava/util/List;", "<init>", "()V", "User", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FireworkMessage extends o0 implements h {

    @SerializedName("count")
    public long count;

    @SerializedName("push_id")
    public long pushId;

    @SerializedName("push_id_str")
    public String pushIdStr;

    @SerializedName("report_time_gap")
    public long reportTimeGap;

    @SerializedName("users")
    public List<User> users;

    @ProtoMessage("webcast.im.FireworkMessage.User")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/FireworkMessage$User;", "", "()V", "avatar", "", "nickName", "userId", "", "userIdStr", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class User implements h {

        @SerializedName("avatar")
        public String avatar;

        @SerializedName("nick_name")
        public String nickName;

        @SerializedName("user_id")
        public long userId;

        @SerializedName("user_id_str")
        public String userIdStr;

        public User() {
            this.nickName = "";
            this.avatar = "";
            this.userIdStr = "";
        }

        public User(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.userId = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.nickName = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.avatar = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.userIdStr = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
            if (this.nickName != null) goto L22;
            this.nickName = "";
        L22:
            if (this.avatar != null) goto L25;
            this.avatar = "";
        L25:
            if (this.userIdStr != null) goto L43;
            this.userIdStr = "";
            return;
        }
    }

    public FireworkMessage() {
        this.pushIdStr = "";
        this.users = CollectionsKt.emptyList();
        this.type = MessageType.FIREWORK_MESSAGE;
    }

    public FireworkMessage(g r100) {
        this.users = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.users.add(new User(r100));
        goto L3
    L8:
        this.pushIdStr = am3.h.c(r100);
        goto L3
    L9:
        this.pushId = r100.j();
        goto L3
    L10:
        this.reportTimeGap = r100.j();
        goto L3
    L11:
        this.count = r100.j();
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.pushIdStr != null) goto L17;
        this.pushIdStr = "";
    L17:
        if (this.users.isEmpty() == false) goto L19;
        this.users = CollectionsKt.emptyList();
    L19:
        this.type = MessageType.FIREWORK_MESSAGE;
    }
}
