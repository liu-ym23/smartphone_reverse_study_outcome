package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ComboTrayInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/IComboTrayInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/a7;", "", "extra$delegate", "Ljava/lang/Object;", "getExtra", "()Ljava/lang/String;", "extra", "comboId$delegate", "getComboId", "comboId", "", "action$delegate", "getAction", "()I", "action", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IComboTrayInfoFlexImpl extends FlexModelBase<a7> implements a7, vh7.h {

    @SerializedName("action")
    protected int _$$action;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COMBO_ID)
    protected String _$$comboId;

    @SerializedName("extra")
    protected String _$$extra;

    public IComboTrayInfoFlexImpl() {
        super(a7.class);
        this._$$extra = "";
        this._$$comboId = "";
    }

    @Override // com.bytedance.android.livesdk.message.model.a7
    public final int getAction() {
        return this._$$action;
    }

    @Override // com.bytedance.android.livesdk.message.model.a7
    public final String getComboId() {
        return this._$$comboId;
    }

    @Override // com.bytedance.android.livesdk.message.model.a7
    public final String getExtra() {
        return this._$$extra;
    }

    public IComboTrayInfoFlexImpl(am3.g r100) {
        super(a7.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$comboId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 5) goto L10;
        this._$$action = r100.i();
        goto L3
    L10:
        if (r102 != 6) goto L11;
        this._$$extra = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$extra != null) goto L19;
        this._$$extra = "";
    L19:
        if (this._$$comboId != null) goto L34;
        this._$$comboId = "";
        return;
    }
}
