package com.bytedance.android.livesdk.interactivity.pin.business.comment.api;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.room.ChatHighlightRequest")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR$\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/comment/api/ChatHighlightRequest;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "toRequestFieldMap", "", ReportConstant.COMMON_ACTION_TYPE, "I", "", "preId", "J", "roomId", "content", "Ljava/lang/String;", RemoteMessageConst.MSGID, "_commenterId", "_commenterOpenId", "commenterNickname", "chatId", "scene", "contentType", "value", "getCommenterId", "()Ljava/lang/String;", "setCommenterId", "(Ljava/lang/String;)V", "commenterId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatHighlightRequest implements h {
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_SET = 1;
    public static final int ACTION_TYPE_UNSET = 2;
    public static final int ACTION_TYPE_UNSET_ALL = 4;
    public static final a Companion = null;

    @SerializedName("commenter_id")
    public long _commenterId;

    @SerializedName("commenter_open_id")
    public String _commenterOpenId;

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("chat_id")
    public long chatId;

    @SerializedName("commenter_nickname")
    public String commenterNickname;

    @SerializedName("content")
    public String content;

    @SerializedName("content_type")
    public String contentType;

    @SerializedName("msg_id")
    public long msgId;

    @SerializedName("pre_id")
    public long preId;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("scene")
    public String scene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getCommenterId() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this._commenterId);
        String r102 = this._commenterOpenId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public final HashMap<String, String> toRequestFieldMap() {
        HashMap<String, String> r100 = new HashMap();
        String r101 = this.scene;
        if (r101 == null) goto L5;
        String r102 = r100.put("scene", r101);
    L5:
        r100.put("action_type", String.valueOf(this.actionType));
        r100.put("pre_id", String.valueOf(this.preId));
        r100.put("room_id", String.valueOf(this.roomId));
        String r103 = this.content;
        if (r103 == null) goto L8;
        String r104 = r100.put("content", r103);
    L8:
        r100.put("msg_id", String.valueOf(this.msgId));
        r100.put("commenter_id", getCommenterId().toString());
        String r105 = this.commenterNickname;
        if (r105 == null) goto L11;
        String r106 = r100.put("commenter_nickname", r105);
    L11:
        r100.put("chat_id", String.valueOf(this.chatId));
        String r107 = this.contentType;
        if (r107 == null) goto L14;
        r100.put("content_type", r107);
    L14:
        return r100;
    }

    public ChatHighlightRequest() {
        this._commenterOpenId = "0";
    }

    public ChatHighlightRequest(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 50) goto L8;
        this.scene = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 51) goto L10;
        this.contentType = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 5000) goto L11;
        this._commenterOpenId = am3.h.c(r100);
        goto L3
    L11:
        switch(r102) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            default: goto L12;
        };
    L13:
        this.chatId = r100.j();
        goto L3
    L14:
        this.commenterNickname = am3.h.c(r100);
        goto L3
    L15:
        this._commenterId = r100.j();
        goto L3
    L16:
        this.msgId = r100.j();
        goto L3
    L17:
        this.content = am3.h.c(r100);
        goto L3
    L18:
        this.roomId = r100.j();
        goto L3
    L19:
        this.preId = r100.j();
        goto L3
    L20:
        this.actionType = r100.i();
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this._commenterOpenId != null) goto L57;
        this._commenterOpenId = "0";
        return;
    }

    public final void setCommenterId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        o0.f58946a.getClass();
        this._commenterId = 0;
        this._commenterOpenId = r100;
    }
}
