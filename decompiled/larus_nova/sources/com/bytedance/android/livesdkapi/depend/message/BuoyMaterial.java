package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/BuoyMaterial;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/IBuoyMaterial;", "Lpy/k;", "buoyBall", "Lpy/k;", "getBuoyBall", "()Lpy/k;", "setBuoyBall", "(Lpy/k;)V", "buoyTailing", "getBuoyTailing", "setBuoyTailing", "univScatterDecoA", "getUnivScatterDecoA", "setUnivScatterDecoA", "univScatterDecoB", "getUnivScatterDecoB", "setUnivScatterDecoB", "univScatterDecoC", "getUnivScatterDecoC", "setUnivScatterDecoC", "advanScatterDecoA", "getAdvanScatterDecoA", "setAdvanScatterDecoA", "advanScatterDecoB", "getAdvanScatterDecoB", "setAdvanScatterDecoB", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BuoyMaterial extends FlexModelBase<IBuoyMaterial> implements IBuoyMaterial, h {

    @SerializedName("advan_scatter_deco_a")
    protected k advanScatterDecoA;

    @SerializedName("advan_scatter_deco_b")
    protected k advanScatterDecoB;

    @SerializedName("buoy_ball")
    protected k buoyBall;

    @SerializedName("buoy_tailing")
    protected k buoyTailing;

    @SerializedName("univ_scatter_deco_a")
    protected k univScatterDecoA;

    @SerializedName("univ_scatter_deco_b")
    protected k univScatterDecoB;

    @SerializedName("univ_scatter_deco_c")
    protected k univScatterDecoC;

    public BuoyMaterial() {
        super(IBuoyMaterial.class);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public BuoyMaterial(g r100) {
        super(IBuoyMaterial.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this.advanScatterDecoB = f.a(r100, k.class);
        goto L3
    L9:
        this.advanScatterDecoA = f.a(r100, k.class);
        goto L3
    L10:
        this.univScatterDecoC = f.a(r100, k.class);
        goto L3
    L11:
        this.univScatterDecoB = f.a(r100, k.class);
        goto L3
    L12:
        this.univScatterDecoA = f.a(r100, k.class);
        goto L3
    L13:
        this.buoyTailing = f.a(r100, k.class);
        goto L3
    L14:
        this.buoyBall = f.a(r100, k.class);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBuoyMaterial
    public k getAdvanScatterDecoA() {
        return this.advanScatterDecoA;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBuoyMaterial
    public k getAdvanScatterDecoB() {
        return this.advanScatterDecoB;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBuoyMaterial
    public k getBuoyBall() {
        return this.buoyBall;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBuoyMaterial
    public k getBuoyTailing() {
        return this.buoyTailing;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBuoyMaterial
    public k getUnivScatterDecoA() {
        return this.univScatterDecoA;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBuoyMaterial
    public k getUnivScatterDecoB() {
        return this.univScatterDecoB;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBuoyMaterial
    public k getUnivScatterDecoC() {
        return this.univScatterDecoC;
    }

    public void setAdvanScatterDecoA(k r100) {
        this.advanScatterDecoA = r100;
    }

    public void setAdvanScatterDecoB(k r100) {
        this.advanScatterDecoB = r100;
    }

    public void setBuoyBall(k r100) {
        this.buoyBall = r100;
    }

    public void setBuoyTailing(k r100) {
        this.buoyTailing = r100;
    }

    public void setUnivScatterDecoA(k r100) {
        this.univScatterDecoA = r100;
    }

    public void setUnivScatterDecoB(k r100) {
        this.univScatterDecoB = r100;
    }

    public void setUnivScatterDecoC(k r100) {
        this.univScatterDecoC = r100;
    }
}
