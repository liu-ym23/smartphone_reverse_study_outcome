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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/BackgroundMaterial;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/IBackgroundMaterial;", "Lpy/k;", "buoyAreaBg", "Lpy/k;", "getBuoyAreaBg", "()Lpy/k;", "setBuoyAreaBg", "(Lpy/k;)V", "songTitleBgImage", "getSongTitleBgImage", "setSongTitleBgImage", "globalBg", "getGlobalBg", "setGlobalBg", "scoreboardBg", "getScoreboardBg", "setScoreboardBg", "", "toneLineStart", "Ljava/lang/String;", "getToneLineStart", "()Ljava/lang/String;", "setToneLineStart", "(Ljava/lang/String;)V", "toneLineEnd", "getToneLineEnd", "setToneLineEnd", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BackgroundMaterial extends FlexModelBase<IBackgroundMaterial> implements IBackgroundMaterial, h {

    @SerializedName("buoy_area_bg")
    protected k buoyAreaBg;

    @SerializedName("global_bg")
    protected k globalBg;

    @SerializedName("scoreboard_bg")
    protected k scoreboardBg;
    private k songTitleBgImage;

    @SerializedName("tone_line_end")
    protected String toneLineEnd;

    @SerializedName("tone_line_start")
    protected String toneLineStart;

    public BackgroundMaterial() {
        super(IBackgroundMaterial.class);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public BackgroundMaterial(g r100) {
        super(IBackgroundMaterial.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.buoyAreaBg = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.globalBg = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.scoreboardBg = f.a(r100, k.class);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.toneLineStart = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.toneLineEnd = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBackgroundMaterial
    public k getBuoyAreaBg() {
        return this.buoyAreaBg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBackgroundMaterial
    public k getGlobalBg() {
        return this.globalBg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBackgroundMaterial
    public k getScoreboardBg() {
        return this.scoreboardBg;
    }

    public final k getSongTitleBgImage() {
        return this.songTitleBgImage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBackgroundMaterial
    public String getToneLineEnd() {
        return this.toneLineEnd;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IBackgroundMaterial
    public String getToneLineStart() {
        return this.toneLineStart;
    }

    public void setBuoyAreaBg(k r100) {
        this.buoyAreaBg = r100;
    }

    public void setGlobalBg(k r100) {
        this.globalBg = r100;
    }

    public void setScoreboardBg(k r100) {
        this.scoreboardBg = r100;
    }

    public final void setSongTitleBgImage(k r100) {
        this.songTitleBgImage = r100;
    }

    public void setToneLineEnd(String r100) {
        this.toneLineEnd = r100;
    }

    public void setToneLineStart(String r100) {
        this.toneLineStart = r100;
    }
}
