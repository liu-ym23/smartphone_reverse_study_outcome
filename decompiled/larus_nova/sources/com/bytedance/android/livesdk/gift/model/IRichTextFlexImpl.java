package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.RichText")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010 \u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR/\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R+\u0010(\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001f¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IRichTextFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/IRichText;", "", "<set-?>", "type$delegate", "Ljava/lang/Object;", "getType", "()I", "setType", "(I)V", "type", "", "text$delegate", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text", "Lpy/k;", "img$delegate", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "img", "", "fontSize$delegate", "getFontSize", "()J", "setFontSize", "(J)V", "fontSize", "fontColor$delegate", "getFontColor", "setFontColor", "fontColor", "weight$delegate", "getWeight", "setWeight", "weight", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRichTextFlexImpl extends FlexModelBase<IRichText> implements IRichText, vh7.h {

    @SerializedName("font_color")
    protected String _$$fontColor;

    @SerializedName("font_size")
    protected long _$$fontSize;

    @SerializedName("img")
    protected py.k _$$img;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("type")
    protected int _$$type;

    @SerializedName("weight")
    protected long _$$weight;

    public IRichTextFlexImpl() {
        super(IRichText.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final String getFontColor() {
        return this._$$fontColor;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final long getFontSize() {
        return this._$$fontSize;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final py.k getImg() {
        return this._$$img;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final int getType() {
        return this._$$type;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final long getWeight() {
        return this._$$weight;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IRichTextFlexImpl(am3.g r100) {
        super(IRichText.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$weight = r100.j();
        goto L3
    L9:
        this._$$fontColor = am3.h.c(r100);
        goto L3
    L10:
        this._$$fontSize = r100.j();
        goto L3
    L11:
        this._$$img = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        this._$$text = am3.h.c(r100);
        goto L3
    L13:
        this._$$type = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final void setFontColor(String r100) {
        this._$$fontColor = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final void setFontSize(long r100) {
        this._$$fontSize = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final void setImg(py.k r100) {
        this._$$img = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final void setText(String r100) {
        this._$$text = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final void setType(int r100) {
        this._$$type = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IRichText
    public final void setWeight(long r100) {
        this._$$weight = r100;
    }
}
