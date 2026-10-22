package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.GiftDetail")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ISpecifyGiftDetailFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/i9;", "Lpy/k;", "image", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "", "<set-?>", "giftName$delegate", "Ljava/lang/Object;", "getGiftName", "()Ljava/lang/String;", "setGiftName", "(Ljava/lang/String;)V", "giftName", "giftDes$delegate", "getGiftDes", "setGiftDes", "giftDes", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISpecifyGiftDetailFlexImpl extends FlexModelBase<i9> implements i9, vh7.h {

    @SerializedName("gift_des")
    protected String _$$giftDes;

    @SerializedName("gift_name")
    protected String _$$giftName;

    @SerializedName("image")
    protected py.k image;

    public ISpecifyGiftDetailFlexImpl() {
        super(i9.class);
        this._$$giftName = "";
        this._$$giftDes = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public ISpecifyGiftDetailFlexImpl(am3.g r100) {
        super(i9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 2) goto L8;
        this._$$giftName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.image = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 4) goto L11;
        this._$$giftDes = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$giftName != null) goto L19;
        this._$$giftName = "";
    L19:
        if (this._$$giftDes != null) goto L34;
        this._$$giftDes = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.i9
    public final String getGiftDes() {
        return this._$$giftDes;
    }

    @Override // com.bytedance.android.livesdk.link.model.i9
    public final String getGiftName() {
        return this._$$giftName;
    }

    @Override // com.bytedance.android.livesdk.link.model.i9
    public py.k getImage() {
        return this.image;
    }

    @Override // com.bytedance.android.livesdk.link.model.i9
    public final void setGiftDes(String r100) {
        this._$$giftDes = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.i9
    public final void setGiftName(String r100) {
        this._$$giftName = r100;
    }

    public void setImage(py.k r100) {
        this.image = r100;
    }
}
