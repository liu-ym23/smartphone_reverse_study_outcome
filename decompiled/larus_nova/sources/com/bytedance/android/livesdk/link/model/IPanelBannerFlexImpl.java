package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.PanelBanner")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPanelBannerFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/n7;", "Lpy/k;", "bgImage", "Lpy/k;", "getBgImage", "()Lpy/k;", "setBgImage", "(Lpy/k;)V", "", "schemeUrl$delegate", "Ljava/lang/Object;", "getSchemeUrl", "()Ljava/lang/String;", "schemeUrl", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPanelBannerFlexImpl extends FlexModelBase<n7> implements n7, vh7.h {

    @SerializedName("scheme_url")
    protected String _$$schemeUrl;

    @SerializedName("bg_image")
    protected py.k bgImage;

    public IPanelBannerFlexImpl() {
        super(n7.class);
        this._$$schemeUrl = "";
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IPanelBannerFlexImpl(am3.g r100) {
        super(n7.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.bgImage = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$schemeUrl = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$schemeUrl != null) goto L25;
        this._$$schemeUrl = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.n7
    public py.k getBgImage() {
        return this.bgImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.n7
    public final String getSchemeUrl() {
        return this._$$schemeUrl;
    }

    public void setBgImage(py.k r100) {
        this.bgImage = r100;
    }
}
