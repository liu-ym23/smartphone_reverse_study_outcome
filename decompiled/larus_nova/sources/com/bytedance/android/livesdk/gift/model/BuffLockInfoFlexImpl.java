package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.BuffLockInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R/\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001b\u0010\u001d\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/BuffLockInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/i;", "", "<set-?>", "locked$delegate", "Ljava/lang/Object;", "getLocked", "()Z", "setLocked", "(Z)V", "locked", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "toast", "schema$delegate", "getSchema", "setSchema", "schema", "cellText$delegate", "getCellText", "setCellText", "cellText", "useCustomButtonColor$delegate", "getUseCustomButtonColor", "useCustomButtonColor", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BuffLockInfoFlexImpl extends FlexModelBase<i> implements i, vh7.h {

    @SerializedName("cell_text")
    protected String _$$cellText;

    @SerializedName("locked")
    protected boolean _$$locked;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("custom_button_color")
    protected boolean _$$useCustomButtonColor;

    public BuffLockInfoFlexImpl() {
        super(i.class);
        this._$$locked = false;
        this._$$useCustomButtonColor = false;
    }

    public BuffLockInfoFlexImpl(am3.g r100) {
        super(i.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        this._$$locked = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this._$$toast = am3.h.c(r100);
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this._$$schema = am3.h.c(r100);
        goto L3
    L11:
        if (r103 != 4) goto L13;
        this._$$cellText = am3.h.c(r100);
        goto L3
    L13:
        if (r103 != 5) goto L14;
        this._$$useCustomButtonColor = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L14:
        am3.h.d(r104, r100);
        goto L3
    L20:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L24;
        this._$$locked = false;
    L24:
        if ((r102 & 2) != 0) goto L45;
        this._$$useCustomButtonColor = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final String getCellText() {
        return this._$$cellText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final boolean getLocked() {
        return this._$$locked;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final String getToast() {
        return this._$$toast;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final boolean getUseCustomButtonColor() {
        return this._$$useCustomButtonColor;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final void setCellText(String r100) {
        this._$$cellText = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final void setLocked(boolean r100) {
        this._$$locked = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final void setSchema(String r100) {
        this._$$schema = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.i
    public final void setToast(String r100) {
        this._$$toast = r100;
    }
}
