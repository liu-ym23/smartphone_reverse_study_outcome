package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.dress.ChorusEvaluateEffectConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IChorusEvaluateEffectConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/e;", "Lpy/k;", "<set-?>", "perfectIcon$delegate", "Ljava/lang/Object;", "getPerfectIcon", "()Lpy/k;", "setPerfectIcon", "(Lpy/k;)V", "perfectIcon", "goodIcon$delegate", "getGoodIcon", "setGoodIcon", "goodIcon", "niceIcon$delegate", "getNiceIcon", "setNiceIcon", "niceIcon", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IChorusEvaluateEffectConfigFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("good_icon")
    protected py.k _$$goodIcon;

    @SerializedName("nice_icon")
    protected py.k _$$niceIcon;

    @SerializedName("perfect_icon")
    protected py.k _$$perfectIcon;

    public IChorusEvaluateEffectConfigFlexImpl() {
        super(e.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public IChorusEvaluateEffectConfigFlexImpl(am3.g r100) {
        super(e.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$perfectIcon = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$goodIcon = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$niceIcon = vh7.f.a(r100, py.k.class);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.e
    public final py.k getGoodIcon() {
        return this._$$goodIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.e
    public final py.k getNiceIcon() {
        return this._$$niceIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.e
    public final py.k getPerfectIcon() {
        return this._$$perfectIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.e
    public final void setGoodIcon(py.k r100) {
        this._$$goodIcon = r100;
    }

    @Override // com.bytedance.android.live.profit.dress.config.e
    public final void setNiceIcon(py.k r100) {
        this._$$niceIcon = r100;
    }

    @Override // com.bytedance.android.live.profit.dress.config.e
    public final void setPerfectIcon(py.k r100) {
        this._$$perfectIcon = r100;
    }
}
