package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.EffectMixTextInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/EffectMixTextInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/t;", "", "<set-?>", "placeholderKey$delegate", "Ljava/lang/Object;", "getPlaceholderKey", "()Ljava/lang/String;", "setPlaceholderKey", "(Ljava/lang/String;)V", "placeholderKey", "content$delegate", "getContent", "setContent", "content", "", "fontSize$delegate", "getFontSize", "()Ljava/lang/Long;", "setFontSize", "(Ljava/lang/Long;)V", "fontSize", "fontColor$delegate", "getFontColor", "setFontColor", "fontColor", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EffectMixTextInfoFlexImpl extends FlexModelBase<t> implements t, vh7.h {

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("font_color")
    protected String _$$fontColor;

    @SerializedName("font_size")
    protected Long _$$fontSize;

    @SerializedName("text_key")
    protected String _$$placeholderKey;

    public EffectMixTextInfoFlexImpl() {
        super(t.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final String getFontColor() {
        return this._$$fontColor;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final Long getFontSize() {
        return this._$$fontSize;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final String getPlaceholderKey() {
        return this._$$placeholderKey;
    }

    public EffectMixTextInfoFlexImpl(am3.g r100) {
        super(t.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$placeholderKey = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$content = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$fontSize = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$fontColor = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final void setContent(String r100) {
        this._$$content = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final void setFontColor(String r100) {
        this._$$fontColor = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final void setFontSize(Long r100) {
        this._$$fontSize = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t
    public final void setPlaceholderKey(String r100) {
        this._$$placeholderKey = r100;
    }
}
