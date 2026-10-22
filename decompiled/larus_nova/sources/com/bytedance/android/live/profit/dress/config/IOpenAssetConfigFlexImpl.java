package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.OpenAssetConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001b\u0010\u0018\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001b\u0010\u001d\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010!R\u001d\u0010(\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b'\u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IOpenAssetConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/p;", "Lcom/bytedance/android/live/base/model/message/a5;", "templateText", "Lcom/bytedance/android/live/base/model/message/a5;", "getTemplateText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setTemplateText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "assetId$delegate", "Ljava/lang/Object;", "getAssetId", "()J", "assetId", "price$delegate", "getPrice", "price", "textWidth$delegate", "getTextWidth", "textWidth", "textHeight$delegate", "getTextHeight", "textHeight", "", "alignType$delegate", "getAlignType", "()I", "alignType", "", "extra$delegate", "getExtra", "()Ljava/lang/String;", "extra", "avatarBorderDressId$delegate", "getAvatarBorderDressId", "avatarBorderDressId", "schema$delegate", "getSchema", "schema", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IOpenAssetConfigFlexImpl extends FlexModelBase<p> implements p, vh7.h {

    @SerializedName("text_align_type")
    protected int _$$alignType;

    @SerializedName("asset_id")
    protected long _$$assetId;

    @SerializedName("link_avatar_border_id")
    protected String _$$avatarBorderDressId;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("price")
    protected long _$$price;

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("text_height")
    protected long _$$textHeight;

    @SerializedName("text_width")
    protected long _$$textWidth;

    @SerializedName("template_text")
    protected a5 templateText;

    public IOpenAssetConfigFlexImpl() {
        super(p.class);
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final int getAlignType() {
        return this._$$alignType;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final long getAssetId() {
        return this._$$assetId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final String getAvatarBorderDressId() {
        return this._$$avatarBorderDressId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final long getPrice() {
        return this._$$price;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final String getSchema() {
        return this._$$schema;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public a5 getTemplateText() {
        return this.templateText;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final long getTextHeight() {
        return this._$$textHeight;
    }

    @Override // com.bytedance.android.live.profit.dress.config.p
    public final long getTextWidth() {
        return this._$$textWidth;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public IOpenAssetConfigFlexImpl(am3.g r100) {
        super(p.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this._$$schema = am3.h.c(r100);
        goto L3
    L9:
        this.templateText = vh7.f.a(r100, a5.class);
        goto L3
    L10:
        this._$$avatarBorderDressId = am3.h.c(r100);
        goto L3
    L11:
        this._$$extra = am3.h.c(r100);
        goto L3
    L12:
        this._$$alignType = r100.i();
        goto L3
    L13:
        this._$$textHeight = r100.j();
        goto L3
    L14:
        this._$$textWidth = r100.j();
        goto L3
    L15:
        this._$$price = r100.j();
        goto L3
    L16:
        this._$$assetId = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L17:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setTemplateText(a5 r100) {
        this.templateText = r100;
    }
}
