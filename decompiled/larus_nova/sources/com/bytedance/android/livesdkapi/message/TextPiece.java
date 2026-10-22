package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.f5;
import com.bytedance.android.live.base.model.message.g5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TextPiece extends FlexModelBase<c5> implements c5 {

    @SerializedName(SubInfo.KEY_FORMAT)
    protected TextFormat format;

    @SerializedName("gift_value")
    protected TextPieceGift giftValue;

    @SerializedName("heart_value")
    protected TextPieceHeart heartValue;

    @SerializedName("image_value")
    protected TextPieceImage imageValue;
    protected boolean isNormalPiece;

    @SerializedName("pattern_ref_value")
    protected TextPiecePatternRef patternRefValue;

    @SerializedName("value_ref")
    protected String refKey;

    @SerializedName("schema_key")
    String schemaKey;

    @SerializedName("string_value")
    protected String stringValue;

    @SerializedName("type")
    protected int type;

    @SerializedName("user_value")
    protected TextPieceUser userValue;

    public TextPiece() {
        super(c5.class);
        this.stringValue = "";
        this.isNormalPiece = false;
    }

    public String getFormatColor() {
        TextFormat r100 = this.format;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.color;
    }

    public String toString() {
        return "TextPiece{type=" + this.type + ", format=" + this.format + ", stringValue='" + this.stringValue + "', userValue=" + this.userValue + ", giftValue=" + this.giftValue + ", heartValue=" + this.heartValue + ", patternRefValue=" + this.patternRefValue + ", imageValue=" + this.imageValue + ", refKey=" + this.refKey + '}';
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public /* bridge */ /* synthetic */ b5 getFormat() {
        return getFormat();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public /* bridge */ /* synthetic */ e5 getGiftValue() {
        return getGiftValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public /* bridge */ /* synthetic */ f5 getHeartValue() {
        return getHeartValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public /* bridge */ /* synthetic */ ITextPieceImage getImageValue() {
        return getImageValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public /* bridge */ /* synthetic */ g5 getPatternRefValue() {
        return getPatternRefValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public /* bridge */ /* synthetic */ i5 getUserValue() {
        return getUserValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public String getRefKey() {
        return this.refKey;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public String getSchemaKey() {
        return this.schemaKey;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public String getStringValue() {
        return this.stringValue;
    }

    @Override // com.bytedance.android.live.base.model.message.c5, com.bytedance.android.live.base.model.message.d5
    public int getType() {
        return this.type;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public boolean isNormalPiece() {
        return this.isNormalPiece;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public TextFormat getFormat() {
        return this.format;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public TextPieceGift getGiftValue() {
        return this.giftValue;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public TextPieceHeart getHeartValue() {
        return this.heartValue;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public TextPieceImage getImageValue() {
        return this.imageValue;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public TextPiecePatternRef getPatternRefValue() {
        return this.patternRefValue;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public TextPieceUser getUserValue() {
        return this.userValue;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setFormat(b5 r100) {
        this.format = (TextFormat) m.b(r100, TextFormat.class);
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setGiftValue(e5 r100) {
        this.giftValue = (TextPieceGift) m.b(r100, TextPieceGift.class);
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setHeartValue(f5 r100) {
        this.heartValue = (TextPieceHeart) m.b(r100, TextPieceHeart.class);
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setImageValue(ITextPieceImage r100) {
        this.imageValue = (TextPieceImage) m.b(r100, TextPieceImage.class);
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setNormalPiece(boolean r100) {
        this.isNormalPiece = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setPatternRefValue(g5 r100) {
        this.patternRefValue = (TextPiecePatternRef) m.b(r100, TextPiecePatternRef.class);
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setRefKey(String r100) {
        this.refKey = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setSchemaKey(String r100) {
        this.schemaKey = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setStringValue(String r100) {
        this.stringValue = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setType(int r100) {
        this.type = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setUserValue(i5 r100) {
        this.userValue = (TextPieceUser) m.b(r100, TextPieceUser.class);
    }

    public void setFormat(TextFormat r100) {
        this.format = r100;
    }

    public void setUserValue(TextPieceUser r100) {
        this.userValue = r100;
    }
}
