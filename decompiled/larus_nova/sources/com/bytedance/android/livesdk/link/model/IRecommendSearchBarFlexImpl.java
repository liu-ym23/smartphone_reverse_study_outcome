package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.SearchBar")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRecommendSearchBarFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/l8;", "Lpy/k;", "backgroundImage", "Lpy/k;", "getBackgroundImage", "()Lpy/k;", "setBackgroundImage", "(Lpy/k;)V", "", "tabName$delegate", "Ljava/lang/Object;", "getTabName", "()Ljava/lang/String;", "tabName", "content$delegate", "getContent", "content", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRecommendSearchBarFlexImpl extends FlexModelBase<l8> implements l8, vh7.h {

    @SerializedName("content")
    protected String _$$content;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    protected String _$$tabName;

    @SerializedName("bg_image")
    protected py.k backgroundImage;

    public IRecommendSearchBarFlexImpl() {
        super(l8.class);
        this._$$tabName = "";
        this._$$content = "";
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public IRecommendSearchBarFlexImpl(am3.g r100) {
        super(l8.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.backgroundImage = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$content = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$tabName = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$tabName != null) goto L19;
        this._$$tabName = "";
    L19:
        if (this._$$content != null) goto L34;
        this._$$content = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.l8
    public py.k getBackgroundImage() {
        return this.backgroundImage;
    }

    @Override // com.bytedance.android.livesdk.link.model.l8
    public final String getContent() {
        return this._$$content;
    }

    @Override // com.bytedance.android.livesdk.link.model.l8
    public final String getTabName() {
        return this._$$tabName;
    }

    public void setBackgroundImage(py.k r100) {
        this.backgroundImage = r100;
    }
}
