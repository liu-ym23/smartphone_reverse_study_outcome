package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0007\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cj;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "msgType", "Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/message/model/cj$f;", "metaContent", "Lcom/bytedance/android/livesdk/message/model/cj$f;", "Lcom/bytedance/android/livesdk/message/model/cj$g;", "wallContent", "Lcom/bytedance/android/livesdk/message/model/cj$g;", "Lcom/bytedance/android/livesdk/message/model/cj$b;", "auditContent", "Lcom/bytedance/android/livesdk/message/model/cj$b;", "Lcom/bytedance/android/livesdk/message/model/cj$c;", "commentListContent", "Lcom/bytedance/android/livesdk/message/model/cj$c;", "Lcom/bytedance/android/livesdk/message/model/cj$e;", "guideTextShowContent", "Lcom/bytedance/android/livesdk/message/model/cj$e;", "Lcom/bytedance/android/livesdk/message/model/cj$d;", "guideTextAuditContent", "Lcom/bytedance/android/livesdk/message/model/cj$d;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", com.amap.api.col.s.ce.f26391f, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class cj extends o0 implements vh7.h {

    @SerializedName("audit_content")
    public b auditContent;

    @SerializedName("comment_list_content")
    public c commentListContent;

    @SerializedName("guide_text_audit_content")
    public d guideTextAuditContent;

    @SerializedName("guide_text_show_content")
    public e guideTextShowContent;

    @SerializedName("meta_content")
    public f metaContent;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    public Integer msgType;

    @SerializedName("wall_content")
    public g wallContent;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cj$b;", "", "", "changeType", "Ljava/lang/Integer;", "", "toast", "Ljava/lang/String;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b implements vh7.h {

        @SerializedName("change_type")
        public Integer changeType;

        @SerializedName("toast")
        public String toast;

        public b() {
            this.changeType = 0;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.changeType = Integer.valueOf(r100.i());
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.toast = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.changeType != null) goto L25;
            this.changeType = 0;
            return;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cj$c;", "", "", "changeType", "Ljava/lang/Integer;", "", "total", "Ljava/lang/Long;", "", "watchingListUserToast", "Ljava/lang/String;", "operatorUserId", "operatorUserOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c implements vh7.h {

        @SerializedName("change_type")
        public Integer changeType;

        @SerializedName("operator_user_id")
        public Long operatorUserId;

        @SerializedName("operator_user_open_id")
        public String operatorUserOpenId;

        @SerializedName("total")
        public Long total;

        @SerializedName("watching_list_user_toast")
        public String watchingListUserToast;

        public c() {
            this.changeType = 0;
            this.total = 0L;
            this.operatorUserId = 0L;
        }

        public c(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.changeType = Integer.valueOf(r100.i());
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.total = Long.valueOf(r100.j());
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.watchingListUserToast = am3.h.c(r100);
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.operatorUserId = Long.valueOf(r100.j());
            goto L3
        L14:
            if (r102 != 5000) goto L15;
            this.operatorUserOpenId = am3.h.c(r100);
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
            if (this.changeType != null) goto L25;
            this.changeType = 0;
        L25:
            if (this.total != null) goto L28;
            this.total = 0L;
        L28:
            if (this.operatorUserId != null) goto L49;
            this.operatorUserId = 0L;
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cj$d;", "", "", "changeType", "Ljava/lang/Integer;", "", "guideText", "Ljava/lang/String;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d implements vh7.h {

        @SerializedName("change_type")
        public Integer changeType;

        @SerializedName("guide_text")
        public String guideText;

        public d() {
        }

        public d(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.changeType = Integer.valueOf(r100.i());
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.guideText = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cj$e;", "", "", "guideText", "Ljava/lang/String;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e implements vh7.h {

        @SerializedName("guide_text")
        public String guideText;

        public e() {
        }

        public e(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.guideText = am3.h.c(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cj$f;", "", "", "isActivate", "Ljava/lang/Boolean;", "", "giftId", "J", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f implements vh7.h {

        @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
        public long giftId;

        @SerializedName("is_activate")
        public Boolean isActivate;

        public f() {
            this.isActivate = Boolean.FALSE;
        }

        public f(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.isActivate = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.giftId = r100.j();
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.isActivate != null) goto L25;
            this.isActivate = Boolean.FALSE;
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/cj$g;", "", "", "exitCommentOnWall", "Ljava/lang/Boolean;", "Lcom/bytedance/android/livesdk/message/model/bj;", "comment", "Lcom/bytedance/android/livesdk/message/model/bj;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class g implements vh7.h {

        @SerializedName("comment")
        public bj comment;

        @SerializedName("exist_comment_on_wall")
        public Boolean exitCommentOnWall;

        public g() {
            this.exitCommentOnWall = Boolean.FALSE;
        }

        public g(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.exitCommentOnWall = Boolean.valueOf(am3.h.a(r100));
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.comment = new bj(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.exitCommentOnWall != null) goto L25;
            this.exitCommentOnWall = Boolean.FALSE;
            return;
        }
    }

    static {
    }

    public cj() {
        this.msgType = 0;
        this.type = MessageType.GIFT_COMMENT_MESSAGE;
    }

    public cj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.msgType = Integer.valueOf(r100.i());
        goto L3
    L9:
        switch(r102) {
            case 50: goto L16;
            case 51: goto L15;
            case 52: goto L14;
            case 53: goto L13;
            case 54: goto L12;
            case 55: goto L11;
            default: goto L10;
        };
    L11:
        this.guideTextAuditContent = new d(r100);
        goto L3
    L12:
        this.guideTextShowContent = new e(r100);
        goto L3
    L13:
        this.commentListContent = new c(r100);
        goto L3
    L14:
        this.auditContent = new b(r100);
        goto L3
    L15:
        this.wallContent = new g(r100);
        goto L3
    L16:
        this.metaContent = new f(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
        if (this.msgType != null) goto L22;
        this.msgType = 0;
    L22:
        this.type = MessageType.GIFT_COMMENT_MESSAGE;
    }
}
