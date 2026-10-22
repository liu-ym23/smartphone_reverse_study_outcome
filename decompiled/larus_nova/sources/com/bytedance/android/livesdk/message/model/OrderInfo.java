package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/OrderInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/za;", "Lcom/bytedance/android/livesdk/message/model/InteractiveSongUserInfo;", "topUser", "Lcom/bytedance/android/livesdk/message/model/InteractiveSongUserInfo;", "getTopUser", "()Lcom/bytedance/android/livesdk/message/model/InteractiveSongUserInfo;", "setTopUser", "(Lcom/bytedance/android/livesdk/message/model/InteractiveSongUserInfo;)V", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "J", "getScore", "()J", "setScore", "(J)V", "orderCount", "getOrderCount", "setOrderCount", "", "hasAdded", "Z", "getHasAdded", "()Z", "setHasAdded", "(Z)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OrderInfo extends FlexModelBase<za> implements za, vh7.h {

    @SerializedName("has_added")
    protected boolean hasAdded;

    @SerializedName("order_count")
    protected long orderCount;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long score;

    @SerializedName("top_user")
    protected InteractiveSongUserInfo topUser;

    public OrderInfo() {
        super(za.class);
        this.topUser = new InteractiveSongUserInfo();
    }

    @Override // com.bytedance.android.livesdk.message.model.za
    public /* bridge */ /* synthetic */ b8 getTopUser() {
        return getTopUser();
    }

    @Override // com.bytedance.android.livesdk.message.model.za
    public boolean getHasAdded() {
        return this.hasAdded;
    }

    @Override // com.bytedance.android.livesdk.message.model.za
    public long getOrderCount() {
        return this.orderCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.za
    public long getScore() {
        return this.score;
    }

    @Override // com.bytedance.android.livesdk.message.model.za
    public InteractiveSongUserInfo getTopUser() {
        return this.topUser;
    }

    public OrderInfo(am3.g r100) {
        super(za.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.topUser = new InteractiveSongUserInfo(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.score = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.orderCount = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.hasAdded = am3.h.a(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this.topUser != null) goto L37;
        this.topUser = new InteractiveSongUserInfo();
        return;
    }

    public void setHasAdded(boolean r100) {
        this.hasAdded = r100;
    }

    public void setOrderCount(long r100) {
        this.orderCount = r100;
    }

    public void setScore(long r100) {
        this.score = r100;
    }

    public void setTopUser(InteractiveSongUserInfo r100) {
        this.topUser = r100;
    }
}
