package com.bytedance.android.livesdkapi.depend.model.live.toolbar;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/BlockComponent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IBlockComponent;", "()V", "componentType", "", "getComponentType", "()Ljava/lang/Integer;", "setComponentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "reason", "getReason", "setReason", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BlockComponent extends FlexModelBase<IBlockComponent> implements IBlockComponent, h {

    @SerializedName("component_type")
    protected Integer componentType;

    @SerializedName("reason")
    protected Integer reason;

    public BlockComponent() {
        super(IBlockComponent.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IBlockComponent
    public Integer getComponentType() {
        return this.componentType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IBlockComponent
    public Integer getReason() {
        return this.reason;
    }

    public BlockComponent(g r100) {
        super(IBlockComponent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.componentType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.reason = Integer.valueOf(r100.i());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IBlockComponent
    public void setComponentType(Integer r100) {
        this.componentType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.toolbar.IBlockComponent
    public void setReason(Integer r100) {
        this.reason = r100;
    }
}
