package com.bytedance.android.livesdkapi.depend.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.diamond.OneKeyPay")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/IOneKeyPayFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/IOneKeyPay;", "", "<set-?>", "supportOneKeyPay$delegate", "Ljava/lang/Object;", "getSupportOneKeyPay", "()Z", "setSupportOneKeyPay", "(Z)V", "supportOneKeyPay", "", "oneKeyPayMsg$delegate", "getOneKeyPayMsg", "()Ljava/lang/String;", "setOneKeyPayMsg", "(Ljava/lang/String;)V", "oneKeyPayMsg", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IOneKeyPayFlexImpl extends FlexModelBase<IOneKeyPay> implements IOneKeyPay, h {

    @SerializedName("one_key_pay_msg")
    protected String _$$oneKeyPayMsg;

    @SerializedName("support_one_key_pay")
    protected boolean _$$supportOneKeyPay;

    public IOneKeyPayFlexImpl() {
        super(IOneKeyPay.class);
        this._$$supportOneKeyPay = false;
    }

    public IOneKeyPayFlexImpl(g r100) {
        super(IOneKeyPay.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$supportOneKeyPay = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L8:
        if (r103 != 2) goto L9;
        this._$$oneKeyPayMsg = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L25;
        this._$$supportOneKeyPay = false;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IOneKeyPay
    public final String getOneKeyPayMsg() {
        return this._$$oneKeyPayMsg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IOneKeyPay
    public final boolean getSupportOneKeyPay() {
        return this._$$supportOneKeyPay;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IOneKeyPay
    public final void setOneKeyPayMsg(String r100) {
        this._$$oneKeyPayMsg = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.IOneKeyPay
    public final void setSupportOneKeyPay(boolean r100) {
        this._$$supportOneKeyPay = r100;
    }
}
