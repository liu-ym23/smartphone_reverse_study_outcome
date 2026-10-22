package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.data.ProfileCardPreviewDock")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IDressProfilePreviewConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/h;", "", "enablePreview$delegate", "Ljava/lang/Object;", "getEnablePreview", "()Z", "enablePreview", "Lcom/bytedance/android/live/profit/dress/config/IButtonConfigFlexImpl;", "buttonConfig$delegate", "getButtonConfig", "()Lcom/bytedance/android/live/profit/dress/config/IButtonConfigFlexImpl;", "buttonConfig", "", "logExtra$delegate", "getLogExtra", "()Ljava/lang/String;", "logExtra", "", "profilePreviewAssetId$delegate", "getProfilePreviewAssetId", "()J", "profilePreviewAssetId", "", "profileTextAlignTypeInt$delegate", "getProfileTextAlignTypeInt", "()I", "profileTextAlignTypeInt", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IDressProfilePreviewConfigFlexImpl extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("right_button")
    protected IButtonConfigFlexImpl _$$buttonConfig;

    @SerializedName("enable_preview")
    protected boolean _$$enablePreview;

    @SerializedName("extra")
    protected String _$$logExtra;

    @SerializedName("asset_id")
    protected long _$$profilePreviewAssetId;

    @SerializedName("text_alignment")
    protected int _$$profileTextAlignTypeInt;

    public IDressProfilePreviewConfigFlexImpl() {
        super(h.class);
        this._$$enablePreview = false;
    }

    @Override // com.bytedance.android.live.profit.dress.config.h
    public /* bridge */ /* synthetic */ d getButtonConfig() {
        return getButtonConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.h
    public final boolean getEnablePreview() {
        return this._$$enablePreview;
    }

    @Override // com.bytedance.android.live.profit.dress.config.h
    public final String getLogExtra() {
        return this._$$logExtra;
    }

    @Override // com.bytedance.android.live.profit.dress.config.h
    public final long getProfilePreviewAssetId() {
        return this._$$profilePreviewAssetId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.h
    public final int getProfileTextAlignTypeInt() {
        return this._$$profileTextAlignTypeInt;
    }

    @Override // com.bytedance.android.live.profit.dress.config.h
    public final IButtonConfigFlexImpl getButtonConfig() {
        return this._$$buttonConfig;
    }

    public IDressProfilePreviewConfigFlexImpl(am3.g r100) {
        super(h.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$enablePreview = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$profilePreviewAssetId = r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this._$$buttonConfig = new IButtonConfigFlexImpl(r100);
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this._$$profileTextAlignTypeInt = r100.i();
        r102 = r102 | 4;
        goto L3
    L14:
        if (r103 != 5) goto L15;
        this._$$logExtra = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r104, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L43;
        this._$$enablePreview = false;
        return;
    }
}
