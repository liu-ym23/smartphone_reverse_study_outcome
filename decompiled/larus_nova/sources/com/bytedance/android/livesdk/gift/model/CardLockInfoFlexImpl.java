package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.CardLockInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001b\u0010\u0019\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000fR\u001b\u0010\u001c\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u000fR\u001b\u0010!\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/CardLockInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "", "<set-?>", "lockStatus$delegate", "Ljava/lang/Object;", "getLockStatus", "()I", "setLockStatus", "(I)V", "lockStatus", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "toast", "reason$delegate", "getReason", "setReason", "reason", "schema$delegate", "getSchema", "schema", "cellText$delegate", "getCellText", "cellText", "", "useCustomButtonColor$delegate", "getUseCustomButtonColor", "()Z", "useCustomButtonColor", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CardLockInfoFlexImpl extends FlexModelBase<CardLockInfo> implements CardLockInfo, vh7.h {

    @SerializedName("cell_text")
    protected String _$$cellText;

    @SerializedName("lock_status")
    protected int _$$lockStatus;

    @SerializedName("reason")
    protected String _$$reason;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("custom_button_color")
    protected boolean _$$useCustomButtonColor;

    public CardLockInfoFlexImpl() {
        super(CardLockInfo.class);
        this._$$toast = "";
        this._$$reason = "";
        this._$$schema = "";
        this._$$cellText = "";
        this._$$useCustomButtonColor = false;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final String getCellText() {
        return this._$$cellText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final int getLockStatus() {
        return this._$$lockStatus;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final String getReason() {
        return this._$$reason;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final String getToast() {
        return this._$$toast;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final boolean getUseCustomButtonColor() {
        return this._$$useCustomButtonColor;
    }

    public CardLockInfoFlexImpl(am3.g r100) {
        super(CardLockInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$useCustomButtonColor = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L9:
        this._$$cellText = am3.h.c(r100);
        goto L3
    L10:
        this._$$schema = am3.h.c(r100);
        goto L3
    L11:
        this._$$reason = am3.h.c(r100);
        goto L3
    L12:
        this._$$toast = am3.h.c(r100);
        goto L3
    L13:
        this._$$lockStatus = r100.i();
        r102 = r102 | 1;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$toast != null) goto L18;
        this._$$toast = "";
    L18:
        if (this._$$reason != null) goto L21;
        this._$$reason = "";
    L21:
        if (this._$$schema != null) goto L24;
        this._$$schema = "";
    L24:
        if (this._$$cellText != null) goto L27;
        this._$$cellText = "";
    L27:
        if ((r102 & 2) != 0) goto L46;
        this._$$useCustomButtonColor = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final void setLockStatus(int r100) {
        this._$$lockStatus = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final void setReason(String r100) {
        this._$$reason = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.CardLockInfo
    public final void setToast(String r100) {
        this._$$toast = r100;
    }
}
