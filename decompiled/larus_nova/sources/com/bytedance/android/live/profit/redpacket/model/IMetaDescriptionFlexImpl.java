package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.luckybox.BoxListResponse.MetaDescription")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R/\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/IMetaDescriptionFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/redpacket/model/c;", "", "giftId$delegate", "Ljava/lang/Object;", "getGiftId", "()J", "giftId", "number$delegate", "getNumber", "number", "Lpy/k;", "<set-?>", "image$delegate", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "image", "", "text$delegate", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMetaDescriptionFlexImpl extends FlexModelBase<c> implements c, vh7.h {

    @SerializedName(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID)
    protected long _$$giftId;

    @SerializedName("image")
    protected py.k _$$image;

    @SerializedName("number")
    protected long _$$number;

    @SerializedName("text")
    protected String _$$text;

    public IMetaDescriptionFlexImpl() {
        super(c.class);
        this._$$text = "";
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.c
    public final long getGiftId() {
        return this._$$giftId;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.c
    public final py.k getImage() {
        return this._$$image;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.c
    public final long getNumber() {
        return this._$$number;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.c
    public final String getText() {
        return this._$$text;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IMetaDescriptionFlexImpl(am3.g r100) {
        super(c.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$giftId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$number = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$image = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$text = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$text != null) goto L37;
        this._$$text = "";
        return;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.c
    public final void setImage(py.k r100) {
        this._$$image = r100;
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.c
    public final void setText(String r100) {
        this._$$text = r100;
    }
}
