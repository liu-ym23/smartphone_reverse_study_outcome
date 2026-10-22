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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/FeedbackMaterial;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/IFeedbackMaterial;", "Lpy/k;", "nice", "Lpy/k;", "getNice", "()Lpy/k;", "setNice", "(Lpy/k;)V", "good", "getGood", "setGood", "perfect", "getPerfect", "setPerfect", "advanPerfectBg", "getAdvanPerfectBg", "setAdvanPerfectBg", "advanPerfectTx", "getAdvanPerfectTx", "setAdvanPerfectTx", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FeedbackMaterial extends FlexModelBase<IFeedbackMaterial> implements IFeedbackMaterial, h {

    @SerializedName("advan_perfect_bg")
    protected k advanPerfectBg;

    @SerializedName("advan_perfect_tx")
    protected k advanPerfectTx;

    @SerializedName("good")
    protected k good;

    @SerializedName("nice")
    protected k nice;

    @SerializedName("perfect")
    protected k perfect;

    public FeedbackMaterial() {
        super(IFeedbackMaterial.class);
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public FeedbackMaterial(g r100) {
        super(IFeedbackMaterial.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.nice = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.good = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.perfect = f.a(r100, k.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.advanPerfectBg = f.a(r100, k.class);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.advanPerfectTx = f.a(r100, k.class);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IFeedbackMaterial
    public k getAdvanPerfectBg() {
        return this.advanPerfectBg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IFeedbackMaterial
    public k getAdvanPerfectTx() {
        return this.advanPerfectTx;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IFeedbackMaterial
    public k getGood() {
        return this.good;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IFeedbackMaterial
    public k getNice() {
        return this.nice;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IFeedbackMaterial
    public k getPerfect() {
        return this.perfect;
    }

    public void setAdvanPerfectBg(k r100) {
        this.advanPerfectBg = r100;
    }

    public void setAdvanPerfectTx(k r100) {
        this.advanPerfectTx = r100;
    }

    public void setGood(k r100) {
        this.good = r100;
    }

    public void setNice(k r100) {
        this.nice = r100;
    }

    public void setPerfect(k r100) {
        this.perfect = r100;
    }
}
