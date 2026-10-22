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
@ProtoMessage("webcast.im.DrumMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/DrumMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "drumResult", "I", "dumpMsgType", "", "drumCount", "J", "reportTimeGap", "pushId", "", "Lcom/bytedance/android/livesdkapi/depend/message/DrumMessage$User;", "users", "Ljava/util/List;", "<init>", "()V", "User", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrumMessage extends o0 implements h {

    @SerializedName("drum_count")
    public long drumCount;

    @SerializedName("drum_result")
    public int drumResult;

    @SerializedName("dump_msg_type")
    public int dumpMsgType;

    @SerializedName("push_id")
    public long pushId;

    @SerializedName("report_time_gap")
    public long reportTimeGap;

    @SerializedName("users")
    public List<User> users;

    @ProtoMessage("webcast.im.DrumMessage.User")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/DrumMessage$User;", "", "()V", "avatar", "", "nickName", "userId", "", "userIdStr", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public DrumMessage() {
        this.users = CollectionsKt.emptyList();
        this.type = MessageType.DRUM_MESSAGE;
    }

    public DrumMessage(g r100) {
        this.users = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L6;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.users.add(new User(r100));
        goto L3
    L8:
        this.pushId = r100.j();
        goto L3
    L9:
        this.reportTimeGap = r100.j();
        goto L3
    L10:
        this.drumCount = r100.j();
        goto L3
    L11:
        this.dumpMsgType = r100.i();
        goto L3
    L12:
        this.drumResult = r100.i();
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.users.isEmpty() == false) goto L17;
        this.users = CollectionsKt.emptyList();
    L17:
        this.type = MessageType.DRUM_MESSAGE;
    }
}
