package com.bytedance.android.livesdk.interactivity.pin.business.microapp.api;

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
@ProtoMessage("webcast.api.room.MicroAppHighlightRequest")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/microapp/api/MicroAppHighlightRequest;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "toRequestFieldMap", "", ReportConstant.COMMON_ACTION_TYPE, "I", "", "roomId", "J", RemoteMessageConst.MSGID, "_commenterId", "_commenterOpenId", "Ljava/lang/String;", "pinId", "value", "getCommenterId", "()Ljava/lang/String;", "setCommenterId", "(Ljava/lang/String;)V", "commenterId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MicroAppHighlightRequest implements h {
    public static final int ACTION_TYPE_EDIT = 3;
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_SET = 1;
    public static final int ACTION_TYPE_UNSET = 2;
    public static final a Companion = null;

    @SerializedName("commenter_id")
    public long _commenterId;

    @SerializedName("commenter_open_id")
    public String _commenterOpenId;

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("msg_id")
    public long msgId;

    @SerializedName("pin_id")
    public long pinId;

    @SerializedName("room_id")
    public long roomId;

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
        r100.put("scene", "applets_highlight");
        r100.put("action_type", String.valueOf(this.actionType));
        r100.put("room_id", String.valueOf(this.roomId));
        r100.put("commenter_id", getCommenterId());
        r100.put("msg_id", String.valueOf(this.msgId));
        r100.put("pin_id", String.valueOf(this.pinId));
        return r100;
    }

    public MicroAppHighlightRequest() {
        this._commenterOpenId = "0";
    }

    public MicroAppHighlightRequest(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 2) goto L8;
        this.actionType = r100.i();
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.roomId = r100.j();
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.msgId = r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this._commenterId = r100.j();
        goto L3
    L14:
        if (r102 != 6) goto L16;
        this.pinId = r100.j();
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this._commenterOpenId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this._commenterOpenId != null) goto L49;
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
