package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.InviteResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/LinkMultiInviteResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/interact/model/v;", "", "", "invitedUserList", "Ljava/util/List;", "getInvitedUserList", "()Ljava/util/List;", "setInvitedUserList", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/chatroom/interact/model/LinkMultiInviteResponse$NoticeInfo;", "noticeInfoList", "getNoticeInfoList", "setNoticeInfoList", "", "remoteLinkerSessionId", "Ljava/lang/String;", "getRemoteLinkerSessionId", "()Ljava/lang/String;", "setRemoteLinkerSessionId", "(Ljava/lang/String;)V", "<init>", "()V", com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo.TAG, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMultiInviteResponse extends FlexModelBase<v> implements v, vh7.h {

    @SerializedName("invited_user_id_list")
    protected List<Long> invitedUserList;

    @SerializedName("notice_infos")
    protected List<NoticeInfo> noticeInfoList;

    @SerializedName("remote_linker_session_id")
    protected String remoteLinkerSessionId;

    @ProtoMessage("webcast.api.linkmic_audience.InviteResponse.NoticeInfo")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/LinkMultiInviteResponse$NoticeInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/e1;", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "", "needPush", "Z", "getNeedPush", "()Z", "setNeedPush", "(Z)V", "appId", "getAppId", "setAppId", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NoticeInfo extends FlexModelBase<e1> implements e1, vh7.h {

        @SerializedName("action")
        protected String action;

        @SerializedName("app_id")
        protected long appId;

        @SerializedName("need_push")
        protected boolean needPush;

        @SerializedName("user_id")
        protected long userId;

        public NoticeInfo() {
            super(e1.class);
            this.action = "none";
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public String getAction() {
            return this.action;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public long getAppId() {
            return this.appId;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public boolean getNeedPush() {
            return this.needPush;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public long getUserId() {
            return this.userId;
        }

        public NoticeInfo(am3.g r100) {
            super(e1.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.userId = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.needPush = am3.h.a(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.appId = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.action = am3.h.c(r100);
            goto L3
        L13:
            am3.h.d(r103, r100);
            goto L3
        L18:
            r100.d(r101);
            setThreadSafe(true);
            if (this.action != null) goto L37;
            this.action = "none";
            return;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public void setAction(String r100) {
            this.action = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public void setAppId(long r100) {
            this.appId = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public void setNeedPush(boolean r100) {
            this.needPush = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.model.interact.e1
        public void setUserId(long r100) {
            this.userId = r100;
        }
    }

    public LinkMultiInviteResponse() {
        super(v.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.v
    public List<Long> getInvitedUserList() {
        return this.invitedUserList;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.v
    public List<NoticeInfo> getNoticeInfoList() {
        return this.noticeInfoList;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.v
    public String getRemoteLinkerSessionId() {
        return this.remoteLinkerSessionId;
    }

    public LinkMultiInviteResponse(am3.g r100) {
        super(v.class);
        this.invitedUserList = new ArrayList();
        this.noticeInfoList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 == 1) goto L14;
        if (r102 != 2) goto L10;
        List r104 = this.noticeInfoList;
        Object r105 = new NoticeInfo(r100);
    L15:
        r104.add(r105);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.remoteLinkerSessionId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r104 = this.invitedUserList;
        r105 = Long.valueOf(r100.j());
        goto L15
    L16:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setInvitedUserList(List<Long> r100) {
        this.invitedUserList = r100;
    }

    public void setNoticeInfoList(List<NoticeInfo> r100) {
        this.noticeInfoList = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.v
    public void setRemoteLinkerSessionId(String r100) {
        this.remoteLinkerSessionId = r100;
    }
}
