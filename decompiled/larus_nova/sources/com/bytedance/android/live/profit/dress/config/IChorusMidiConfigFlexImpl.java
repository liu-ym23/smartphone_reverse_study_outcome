package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.ChorusMidiConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001d\u0010!\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IChorusMidiConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/f;", "Lpy/k;", "advanScatterDecoA", "Lpy/k;", "getAdvanScatterDecoA", "()Lpy/k;", "setAdvanScatterDecoA", "(Lpy/k;)V", "advanScatterDecoB", "getAdvanScatterDecoB", "setAdvanScatterDecoB", "buoyAreaBg", "getBuoyAreaBg", "setBuoyAreaBg", "buoyBall", "getBuoyBall", "setBuoyBall", "buoyTailing", "getBuoyTailing", "setBuoyTailing", "univScatterDecoA", "getUnivScatterDecoA", "setUnivScatterDecoA", "univScatterDecoB", "getUnivScatterDecoB", "setUnivScatterDecoB", "", "scoreColor$delegate", "Ljava/lang/Object;", "getScoreColor", "()Ljava/lang/String;", "scoreColor", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IChorusMidiConfigFlexImpl extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("score_color")
    protected String _$$scoreColor;

    @SerializedName("advan_scatter_deco_a")
    protected py.k advanScatterDecoA;

    @SerializedName("advan_scatter_deco_b")
    protected py.k advanScatterDecoB;

    @SerializedName("buoy_area_bg")
    protected py.k buoyAreaBg;

    @SerializedName("buoy_ball")
    protected py.k buoyBall;

    @SerializedName("buoy_tailing")
    protected py.k buoyTailing;

    @SerializedName("univ_scatter_deco_a")
    protected py.k univScatterDecoA;

    @SerializedName("univ_scatter_deco_b")
    protected py.k univScatterDecoB;

    public IChorusMidiConfigFlexImpl() {
        super(f.class);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public IChorusMidiConfigFlexImpl(am3.g r100) {
        super(f.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$scoreColor = am3.h.c(r100);
        goto L3
    L9:
        this.univScatterDecoB = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        this.univScatterDecoA = vh7.f.a(r100, py.k.class);
        goto L3
    L11:
        this.buoyTailing = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        this.buoyBall = vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        this.buoyAreaBg = vh7.f.a(r100, py.k.class);
        goto L3
    L14:
        this.advanScatterDecoB = vh7.f.a(r100, py.k.class);
        goto L3
    L15:
        this.advanScatterDecoA = vh7.f.a(r100, py.k.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L16:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public py.k getAdvanScatterDecoA() {
        return this.advanScatterDecoA;
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public py.k getAdvanScatterDecoB() {
        return this.advanScatterDecoB;
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public py.k getBuoyAreaBg() {
        return this.buoyAreaBg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public py.k getBuoyBall() {
        return this.buoyBall;
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public py.k getBuoyTailing() {
        return this.buoyTailing;
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public final String getScoreColor() {
        return this._$$scoreColor;
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public py.k getUnivScatterDecoA() {
        return this.univScatterDecoA;
    }

    @Override // com.bytedance.android.live.profit.dress.config.f
    public py.k getUnivScatterDecoB() {
        return this.univScatterDecoB;
    }

    public void setAdvanScatterDecoA(py.k r100) {
        this.advanScatterDecoA = r100;
    }

    public void setAdvanScatterDecoB(py.k r100) {
        this.advanScatterDecoB = r100;
    }

    public void setBuoyAreaBg(py.k r100) {
        this.buoyAreaBg = r100;
    }

    public void setBuoyBall(py.k r100) {
        this.buoyBall = r100;
    }

    public void setBuoyTailing(py.k r100) {
        this.buoyTailing = r100;
    }

    public void setUnivScatterDecoA(py.k r100) {
        this.univScatterDecoA = r100;
    }

    public void setUnivScatterDecoB(py.k r100) {
        this.univScatterDecoB = r100;
    }
}
