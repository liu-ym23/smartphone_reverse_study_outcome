package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.im.EffectTextInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IEffectTextInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/e1;", "", "placeholderKey$delegate", "Ljava/lang/Object;", "getPlaceholderKey", "()Ljava/lang/String;", "placeholderKey", "content$delegate", "getContent", "content", "", "fontSize$delegate", "getFontSize", "()J", "fontSize", "fontColor$delegate", "getFontColor", "fontColor", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IEffectTextInfoFlexImpl extends FlexModelBase<e1> implements e1, vh7.h {

    @SerializedName("content")
    protected String _$$content;

    @SerializedName("font_color")
    protected String _$$fontColor;

    @SerializedName("font_size")
    protected long _$$fontSize;

    @SerializedName("placeholder_key")
    protected String _$$placeholderKey;

    public IEffectTextInfoFlexImpl() {
        super(e1.class);
        this._$$placeholderKey = "";
        this._$$content = "";
        this._$$fontColor = "";
    }

    @Override // com.bytedance.android.livesdk.gift.model.e1
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e1
    public final String getFontColor() {
        return this._$$fontColor;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e1
    public final long getFontSize() {
        return this._$$fontSize;
    }

    @Override // com.bytedance.android.livesdk.gift.model.e1
    public final String getPlaceholderKey() {
        return this._$$placeholderKey;
    }

    public IEffectTextInfoFlexImpl(am3.g r100) {
        super(e1.class);
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
        this._$$fontSize = r100.j();
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
        if (this._$$placeholderKey != null) goto L22;
        this._$$placeholderKey = "";
    L22:
        if (this._$$content != null) goto L25;
        this._$$content = "";
    L25:
        if (this._$$fontColor != null) goto L43;
        this._$$fontColor = "";
        return;
    }
}
