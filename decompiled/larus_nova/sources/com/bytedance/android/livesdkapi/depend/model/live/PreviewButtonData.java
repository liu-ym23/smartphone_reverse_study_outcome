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
@ProtoMessage("webcast.data.PreviewExposeData.PreviewButtonData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00058\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewButtonData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewButtonData;", "()V", "boxId", "", "getBoxId", "()Ljava/lang/Long;", "buttonPriority", "", "getButtonPriority", "()Ljava/lang/Integer;", "enterSchema", "", "getEnterSchema", "()Ljava/lang/String;", "extra", "getExtra", "lotteryId", "getLotteryId", "text", "getText", "type", "getType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewButtonData extends FlexModelBase<IPreviewButtonData> implements IPreviewButtonData, h {

    @SerializedName("box_id")
    protected long boxId;

    @SerializedName("button_priority")
    protected int buttonPriority;

    @SerializedName("enter_schema")
    protected String enterSchema;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("lottery_id")
    protected long lotteryId;

    @SerializedName("text")
    protected String text;

    @SerializedName("type")
    protected long type;

    public PreviewButtonData() {
        super(IPreviewButtonData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewButtonData
    public Long getBoxId() {
        return Long.valueOf(this.boxId);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewButtonData
    public Integer getButtonPriority() {
        return Integer.valueOf(this.buttonPriority);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewButtonData
    public Long getLotteryId() {
        return Long.valueOf(this.lotteryId);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewButtonData
    public Long getType() {
        return Long.valueOf(this.type);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewButtonData
    public String getEnterSchema() {
        return this.enterSchema;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewButtonData
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewButtonData
    public String getText() {
        return this.text;
    }

    public PreviewButtonData(g r100) {
        super(IPreviewButtonData.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this.extra = am3.h.c(r100);
        goto L3
    L9:
        this.enterSchema = am3.h.c(r100);
        goto L3
    L10:
        this.buttonPriority = r100.i();
        goto L3
    L11:
        this.boxId = r100.j();
        goto L3
    L12:
        this.lotteryId = r100.j();
        goto L3
    L13:
        this.text = am3.h.c(r100);
        goto L3
    L14:
        this.type = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }
}
