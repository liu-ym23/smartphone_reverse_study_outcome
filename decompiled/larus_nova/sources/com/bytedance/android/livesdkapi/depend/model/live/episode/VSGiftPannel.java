package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSGiftPannel;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSGiftPanel;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "", "", "colors", "Ljava/util/List;", "Lpy/k;", "background", "Lpy/k;", "selectedImage", "getSelectedImage", "()Lpy/k;", "topTitle", "getTopTitle", "backgroundBottom", "getBackgroundBottom", "backgroundTop", "getBackgroundTop", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftPannel extends FlexModelBase<IVSGiftPanel> implements IVSGiftPanel, h {

    @SerializedName("background")
    public k background;

    @SerializedName("background_bottom")
    protected k backgroundBottom;

    @SerializedName("background_top")
    protected k backgroundTop;

    @SerializedName("background_colors")
    public List<String> colors;

    @SerializedName("selected")
    protected k selectedImage;

    @SerializedName("top_title")
    protected k topTitle;

    public VSGiftPannel() {
        super(IVSGiftPanel.class);
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public VSGiftPannel(g r100) {
        super(IVSGiftPanel.class);
        this.colors = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        g.a r103 = decodeExtensionFields(r102, r100);
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
        this.backgroundTop = f.a(r100, k.class);
        goto L3
    L9:
        this.backgroundBottom = f.a(r100, k.class);
        goto L3
    L10:
        this.topTitle = f.a(r100, k.class);
        goto L3
    L11:
        this.selectedImage = f.a(r100, k.class);
        goto L3
    L12:
        this.background = f.a(r100, k.class);
        goto L3
    L13:
        this.colors.add(am3.h.c(r100));
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel
    public k getBackgroundBottom() {
        return this.backgroundBottom;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel
    public k getBackgroundTop() {
        return this.backgroundTop;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel
    public k getSelectedImage() {
        return this.selectedImage;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel
    public k getTopTitle() {
        return this.topTitle;
    }
}
