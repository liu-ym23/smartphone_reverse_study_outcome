package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicSelfDisciplineLikeContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00038\u0006X\u0087D¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/LinkMicSelfDisciplineLikeContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/l2;", "", "toString", "", "fromUserId", "J", "getFromUserId", "()J", "setFromUserId", "(J)V", "toUserId", "getToUserId", "setToUserId", "", "source", "I", "getSource", "()I", "setSource", "(I)V", "fromOpenId", "Ljava/lang/String;", "getFromOpenId", "()Ljava/lang/String;", "toOpenId", "getToOpenId", "getFromUserIdStr", "fromUserIdStr", "getToUserIdStr", "toUserIdStr", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicSelfDisciplineLikeContent extends FlexModelBase<com.bytedance.android.live.base.model.message.l2> implements com.bytedance.android.live.base.model.message.l2, vh7.h {
    public static final a Companion = null;
    public static final int SOURCE_PERSON_RECORD = 2;
    public static final int SOURCE_UNKNOWN = 0;
    public static final int SOURCE_WEEKLY_RANK = 1;

    @SerializedName("from_open_id")
    protected String fromOpenId;

    @SerializedName("from_user_id")
    protected long fromUserId;

    @SerializedName("source")
    protected int source;

    @SerializedName("to_open_id")
    protected String toOpenId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    protected long toUserId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public LinkMicSelfDisciplineLikeContent() {
        super(com.bytedance.android.live.base.model.message.l2.class);
        this.fromUserId = -1;
        this.toUserId = -1;
        this.fromOpenId = "";
        this.toOpenId = "";
    }

    @Override // com.bytedance.android.live.base.model.message.l2
    public String getFromUserIdStr() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.fromUserId);
        String r102 = this.fromOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    @Override // com.bytedance.android.live.base.model.message.l2
    public String getToUserIdStr() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        Long r101 = Long.valueOf(this.toUserId);
        String r102 = this.toOpenId;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.g(r101, r102);
    }

    public String toString() {
        return "likeContent from=" + this.fromUserId + " to=" + this.toUserId + " source=" + getSource();
    }

    public final String getFromOpenId() {
        return this.fromOpenId;
    }

    public final long getFromUserId() {
        return this.fromUserId;
    }

    @Override // com.bytedance.android.live.base.model.message.l2
    public int getSource() {
        return this.source;
    }

    public final String getToOpenId() {
        return this.toOpenId;
    }

    public final long getToUserId() {
        return this.toUserId;
    }

    public LinkMicSelfDisciplineLikeContent(am3.g r100) {
        super(com.bytedance.android.live.base.model.message.l2.class);
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this.fromUserId = r100.j();
        r101 = r101 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.toUserId = r100.j();
        r101 = r101 | 2;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.source = r100.i();
        goto L3
    L11:
        if (r103 != 5000) goto L13;
        this.fromOpenId = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5001) goto L14;
        this.toOpenId = am3.h.c(r100);
        goto L3
    L14:
        am3.h.d(r104, r100);
        goto L3
    L20:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L24;
        this.fromUserId = -1;
    L24:
        if ((r101 & 2) != 0) goto L27;
        this.toUserId = -1;
    L27:
        if (this.fromOpenId != null) goto L30;
        this.fromOpenId = "";
    L30:
        if (this.toOpenId != null) goto L51;
        this.toOpenId = "";
        return;
    }

    public final void setFromUserId(long r100) {
        this.fromUserId = r100;
    }

    public void setSource(int r100) {
        this.source = r100;
    }

    public final void setToUserId(long r100) {
        this.toUserId = r100;
    }
}
