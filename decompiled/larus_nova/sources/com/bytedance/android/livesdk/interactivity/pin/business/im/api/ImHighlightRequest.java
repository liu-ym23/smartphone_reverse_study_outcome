package com.bytedance.android.livesdk.interactivity.pin.business.im.api;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.room.ImCommonHighlightRequest")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/im/api/ImHighlightRequest;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "toRequestFieldMap", "scene", "Ljava/lang/String;", "", ReportConstant.COMMON_ACTION_TYPE, "I", "", "roomId", "J", RemoteMessageConst.MSGID, "commenterId", "pinId", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImHighlightRequest implements h {
    public static final int ACTION_TYPE_EDIT = 3;
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_SET = 1;
    public static final int ACTION_TYPE_UNSET = 2;
    public static final a Companion = null;
    public static final String SCENE = "im_common_highlight";

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("commenter_id")
    public long commenterId;

    @SerializedName("msg_id")
    public long msgId;

    @SerializedName("pin_id")
    public long pinId;

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

    public ImHighlightRequest() {
    }

    public final HashMap<String, String> toRequestFieldMap() {
        HashMap<String, String> r100 = new HashMap();
        String r101 = this.scene;
        if (r101 == null) goto L5;
        String r102 = r100.put("scene", r101);
    L5:
        r100.put("action_type", String.valueOf(this.actionType));
        r100.put("room_id", String.valueOf(this.roomId));
        r100.put("msg_id", String.valueOf(this.msgId));
        r100.put("commenter_id", String.valueOf(this.commenterId));
        r100.put("pin_id", String.valueOf(this.pinId));
        return r100;
    }

    public ImHighlightRequest(g r100) {
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
        this.pinId = r100.j();
        goto L3
    L8:
        this.commenterId = r100.j();
        goto L3
    L9:
        this.msgId = r100.j();
        goto L3
    L10:
        this.roomId = r100.j();
        goto L3
    L11:
        this.actionType = r100.i();
        goto L3
    L12:
        this.scene = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
