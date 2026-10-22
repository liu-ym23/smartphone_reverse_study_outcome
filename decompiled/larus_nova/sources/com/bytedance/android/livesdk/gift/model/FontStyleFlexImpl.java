package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.gift.PageNameStyle.FontStyle")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/FontStyleFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/x;", "", "<set-?>", "color$delegate", "Ljava/lang/Object;", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "color", "", "transparency$delegate", "getTransparency", "()D", "setTransparency", "(D)V", "transparency", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class FontStyleFlexImpl extends FlexModelBase<x> implements x, vh7.h {

    @SerializedName("color")
    protected String _$$color;

    @SerializedName("transparency")
    protected double _$$transparency;

    public FontStyleFlexImpl() {
        super(x.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.x
    public final String getColor() {
        return this._$$color;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x
    public final double getTransparency() {
        return this._$$transparency;
    }

    public FontStyleFlexImpl(am3.g r100) {
        super(x.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$color = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$transparency = Double.longBitsToDouble(r100.h());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.x
    public final void setColor(String r100) {
        this._$$color = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.x
    public final void setTransparency(double r100) {
        this._$$transparency = r100;
    }
}
