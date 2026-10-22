package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.StarWishPerformanceInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/StarWishPerformanceInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/s1;", "", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "userOpenId", "getUserOpenId", "setUserOpenId", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StarWishPerformanceInfo extends FlexModelBase<s1> implements s1, vh7.h {

    @SerializedName("item_id")
    protected String itemId;

    @SerializedName("status")
    protected int status;

    @SerializedName("user_id")
    protected long userId;

    @SerializedName("user_open_id")
    protected String userOpenId;

    public StarWishPerformanceInfo() {
        super(s1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.s1
    public String getItemId() {
        return this.itemId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.s1
    public int getStatus() {
        return this.status;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUserOpenId() {
        return this.userOpenId;
    }

    public StarWishPerformanceInfo(am3.g r100) {
        super(s1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.itemId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.userId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.status = r100.i();
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this.userOpenId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setItemId(String r100) {
        this.itemId = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public final void setUserId(long r100) {
        this.userId = r100;
    }

    public final void setUserOpenId(String r100) {
        this.userOpenId = r100;
    }
}
