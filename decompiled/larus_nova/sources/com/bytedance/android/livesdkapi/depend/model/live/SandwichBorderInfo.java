package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.ISandwichBorderInfo;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/SandwichBorderInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/ISandwichBorderInfo;", "()V", "bottom", "", "getBottom", "()D", "left", "getLeft", "right", "getRight", "top", "getTop", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SandwichBorderInfo extends FlexModelBase<ISandwichBorderInfo> implements ISandwichBorderInfo, h {

    @SerializedName("bottom")
    protected double bottom;

    @SerializedName("left")
    protected double left;

    @SerializedName("right")
    protected double right;

    @SerializedName("top")
    protected double top;

    public SandwichBorderInfo() {
        super(ISandwichBorderInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.ISandwichBorderInfo
    public double getBottom() {
        return this.bottom;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.ISandwichBorderInfo
    public double getLeft() {
        return this.left;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.ISandwichBorderInfo
    public double getRight() {
        return this.right;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.ISandwichBorderInfo
    public double getTop() {
        return this.top;
    }

    public SandwichBorderInfo(g r100) {
        super(ISandwichBorderInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.top = Double.longBitsToDouble(r100.h());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.bottom = Double.longBitsToDouble(r100.h());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.left = Double.longBitsToDouble(r100.h());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.right = Double.longBitsToDouble(r100.h());
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
