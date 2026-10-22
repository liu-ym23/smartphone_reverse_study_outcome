package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkerEnlargeGuestReplyContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0097D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0011\u0010\u0019\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0011\u0010\u001b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/LinkerEnlargeGuestReplyContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/linker/g;", "", "fromUid", "J", "getFromUid", "()J", "", "fromOpenUid", "Ljava/lang/String;", "getFromOpenUid", "()Ljava/lang/String;", "toUid", "getToUid", "toOpenUid", "getToOpenUid", "", "replyType", "I", "getReplyType", "()I", "replyPrompts", "getReplyPrompts", "getFromUidString", "fromUidString", "getToUidString", "toUidString", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerEnlargeGuestReplyContent extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("from_openid")
    protected String fromOpenUid;

    @SerializedName("from_user_id")
    protected long fromUid;

    @SerializedName("reply_prompts")
    protected String replyPrompts;

    @SerializedName("reply_type")
    protected int replyType;

    @SerializedName("to_openid")
    protected String toOpenUid;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    protected long toUid;

    public LinkerEnlargeGuestReplyContent() {
        super(g.class);
        this.fromOpenUid = "";
        this.toOpenUid = "";
    }

    public final String getFromUidString() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this.fromUid);
        String r102 = this.fromOpenUid;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public final String getToUidString() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this.toUid);
        String r102 = this.toOpenUid;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    public final String getFromOpenUid() {
        return this.fromOpenUid;
    }

    public final long getFromUid() {
        return this.fromUid;
    }

    @Override // com.bytedance.android.livesdk.message.linker.g
    public String getReplyPrompts() {
        return this.replyPrompts;
    }

    @Override // com.bytedance.android.livesdk.message.linker.g
    public int getReplyType() {
        return this.replyType;
    }

    public final String getToOpenUid() {
        return this.toOpenUid;
    }

    public final long getToUid() {
        return this.toUid;
    }

    public LinkerEnlargeGuestReplyContent(am3.g r100) {
        super(g.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.fromUid = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.toUid = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.replyType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.replyPrompts = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5000) goto L16;
        this.fromOpenUid = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5001) goto L17;
        this.toOpenUid = am3.h.c(r100);
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
        if (this.fromOpenUid != null) goto L28;
        this.fromOpenUid = "";
    L28:
        if (this.toOpenUid != null) goto L52;
        this.toOpenUid = "";
        return;
    }
}
