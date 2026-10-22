package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.RedEnvelopeSkin.SurpriseGift")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001b\u0010\u0015\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ISurpriseGiftFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/v;", "Lpy/k;", "effect", "Lpy/k;", "getEffect", "()Lpy/k;", "setEffect", "(Lpy/k;)V", "fortuneLabel", "getFortuneLabel", "setFortuneLabel", "exclusiveGiftIcon", "getExclusiveGiftIcon", "setExclusiveGiftIcon", "", "title$delegate", "Ljava/lang/Object;", "getTitle", "()Ljava/lang/String;", "title", "subtitle$delegate", "getSubtitle", "subtitle", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISurpriseGiftFlexImpl extends FlexModelBase<v> implements v, vh7.h {

    @SerializedName("subtitle")
    protected String _$$subtitle;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("effect")
    protected py.k effect;

    @SerializedName("exclusive_gift_icon")
    protected py.k exclusiveGiftIcon;

    @SerializedName("fortune_label")
    protected py.k fortuneLabel;

    public ISurpriseGiftFlexImpl() {
        super(v.class);
        this._$$title = "";
        this._$$subtitle = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public ISurpriseGiftFlexImpl(am3.g r100) {
        super(v.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$subtitle = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.effect = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.fortuneLabel = vh7.f.a(r100, py.k.class);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.exclusiveGiftIcon = vh7.f.a(r100, py.k.class);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$title != null) goto L25;
        this._$$title = "";
    L25:
        if (this._$$subtitle != null) goto L46;
        this._$$subtitle = "";
        return;
    }

    @Override // com.bytedance.android.live.profit.dress.config.v
    public py.k getEffect() {
        return this.effect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.v
    public py.k getExclusiveGiftIcon() {
        return this.exclusiveGiftIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.v
    public py.k getFortuneLabel() {
        return this.fortuneLabel;
    }

    @Override // com.bytedance.android.live.profit.dress.config.v
    public final String getSubtitle() {
        return this._$$subtitle;
    }

    @Override // com.bytedance.android.live.profit.dress.config.v
    public final String getTitle() {
        return this._$$title;
    }

    public void setEffect(py.k r100) {
        this.effect = r100;
    }

    public void setExclusiveGiftIcon(py.k r100) {
        this.exclusiveGiftIcon = r100;
    }

    public void setFortuneLabel(py.k r100) {
        this.fortuneLabel = r100;
    }
}
