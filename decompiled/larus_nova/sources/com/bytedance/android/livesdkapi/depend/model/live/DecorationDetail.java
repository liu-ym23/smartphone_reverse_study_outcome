package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.DecotationDetail")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationDetail;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IDecorationDetail;", "()V", "imageDecoration", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "getImageDecoration", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "setImageDecoration", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;)V", "textDecoration", "getTextDecoration", "setTextDecoration", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DecorationDetail extends FlexModelBase<IDecorationDetail> implements IDecorationDetail, h {

    @SerializedName("image_decoration")
    protected RoomDecoration imageDecoration;

    @SerializedName("text_decoration")
    protected RoomDecoration textDecoration;

    public DecorationDetail() {
        super(IDecorationDetail.class);
    }

    public DecorationDetail(g r100) {
        super(IDecorationDetail.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.textDecoration = new RoomDecoration(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.imageDecoration = new RoomDecoration(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IDecorationDetail
    public /* bridge */ /* synthetic */ IRoomDecoration getImageDecoration() {
        return getImageDecoration();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IDecorationDetail
    public /* bridge */ /* synthetic */ IRoomDecoration getTextDecoration() {
        return getTextDecoration();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IDecorationDetail
    public RoomDecoration getImageDecoration() {
        return this.imageDecoration;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IDecorationDetail
    public RoomDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public void setImageDecoration(RoomDecoration r100) {
        this.imageDecoration = r100;
    }

    public void setTextDecoration(RoomDecoration r100) {
        this.textDecoration = r100;
    }
}
