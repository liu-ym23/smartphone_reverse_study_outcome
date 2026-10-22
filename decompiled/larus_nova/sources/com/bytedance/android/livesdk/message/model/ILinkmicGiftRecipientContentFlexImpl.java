package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicGiftRecipientContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R)\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkmicGiftRecipientContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/k9;", "", "reason$delegate", "Ljava/lang/Object;", "getReason", "()I", "reason", "", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "", "_giftRecipientUserId$delegate", "get_giftRecipientUserId", "()J", "_giftRecipientUserId", "_giftRecipientOpenId$delegate", "get_giftRecipientOpenId", "()Ljava/lang/String;", "_giftRecipientOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicGiftRecipientContentFlexImpl extends FlexModelBase<k9> implements k9, vh7.h {

    @SerializedName("gift_recipient_open_id")
    protected String _$$_giftRecipientOpenId;

    @SerializedName("gift_recipient_user_id")
    protected long _$$_giftRecipientUserId;

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("reason")
    protected int _$$reason;

    public ILinkmicGiftRecipientContentFlexImpl() {
        super(k9.class);
        this._$$_giftRecipientOpenId = "";
    }

    @Override // com.bytedance.android.livesdk.message.model.k9
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.livesdk.message.model.k9
    public final int getReason() {
        return this._$$reason;
    }

    @Override // com.bytedance.android.livesdk.message.model.k9
    public final String get_giftRecipientOpenId() {
        return this._$$_giftRecipientOpenId;
    }

    @Override // com.bytedance.android.livesdk.message.model.k9
    public final long get_giftRecipientUserId() {
        return this._$$_giftRecipientUserId;
    }

    public ILinkmicGiftRecipientContentFlexImpl(am3.g r110) {
        super(k9.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 1) goto L8;
        this._$$_giftRecipientUserId = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this._$$reason = r110.i();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L16:
        int r106 = r110.f();
        if (r106 == (-1)) goto L23;
        if (r106 != 1) goto L19;
        r104 = am3.h.c(r110);
        goto L16
    L19:
        if (r106 != 2) goto L20;
        r105 = am3.h.c(r110);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r103);
        Map<String, String> r107 = this._$$extra;
        if (r104 == null) goto L30;
        if (r105 == null) goto L28;
        r107.put(r104, r105);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 5000) goto L13;
        this._$$_giftRecipientOpenId = am3.h.c(r110);
        goto L3
    L13:
        am3.h.d(r102, r110);
        goto L3
    L33:
        r110.d(r100);
        setThreadSafe(true);
        if (this._$$_giftRecipientOpenId != null) goto L63;
        this._$$_giftRecipientOpenId = "";
        return;
    }
}
