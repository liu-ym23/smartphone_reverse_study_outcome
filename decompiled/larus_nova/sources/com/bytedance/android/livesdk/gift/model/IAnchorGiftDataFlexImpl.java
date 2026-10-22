package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.AnchorGiftData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IAnchorGiftDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/a1;", "Lpy/k;", "<set-?>", "anchorDiyOriginImg$delegate", "Ljava/lang/Object;", "getAnchorDiyOriginImg", "()Lpy/k;", "setAnchorDiyOriginImg", "(Lpy/k;)V", "anchorDiyOriginImg", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorGiftDataFlexImpl extends FlexModelBase<a1> implements a1, vh7.h {

    @SerializedName("anchor_diy_origin_img")
    protected py.k _$$anchorDiyOriginImg;

    public IAnchorGiftDataFlexImpl() {
        super(a1.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IAnchorGiftDataFlexImpl(am3.g r100) {
        super(a1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$anchorDiyOriginImg = vh7.f.a(r100, py.k.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.a1
    public final py.k getAnchorDiyOriginImg() {
        return this._$$anchorDiyOriginImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a1
    public final void setAnchorDiyOriginImg(py.k r100) {
        this._$$anchorDiyOriginImg = r100;
    }
}
