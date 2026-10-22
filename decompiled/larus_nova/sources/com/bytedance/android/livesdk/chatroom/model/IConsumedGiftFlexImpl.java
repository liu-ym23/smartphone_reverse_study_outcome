package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.LuckyBoxBonus.ConsumedGift")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/IConsumedGiftFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/w0;", "", "<set-?>", "id$delegate", "Ljava/lang/Object;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "id", "diamondCount$delegate", "getDiamondCount", "setDiamondCount", "diamondCount", "", "icon$delegate", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "icon", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IConsumedGiftFlexImpl extends FlexModelBase<w0> implements w0, vh7.h {

    @SerializedName("diamond_count")
    protected Long _$$diamondCount;

    @SerializedName("icon")
    protected String _$$icon;

    @SerializedName("id")
    protected Long _$$id;

    public IConsumedGiftFlexImpl() {
        super(w0.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.w0
    public final Long getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.w0
    public final String getIcon() {
        return this._$$icon;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.w0
    public final Long getId() {
        return this._$$id;
    }

    public IConsumedGiftFlexImpl(am3.g r100) {
        super(w0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$id = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$diamondCount = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$icon = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.w0
    public final void setDiamondCount(Long r100) {
        this._$$diamondCount = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.w0
    public final void setIcon(String r100) {
        this._$$icon = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.w0
    public final void setId(Long r100) {
        this._$$id = r100;
    }
}
