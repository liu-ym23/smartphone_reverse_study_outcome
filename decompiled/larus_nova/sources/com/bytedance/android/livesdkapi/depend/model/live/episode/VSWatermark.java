package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0006R(\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSWatermark;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;", "()V", "position", "", "Ljava/lang/Long;", "value", "positionFlex", "getPositionFlex", "()Ljava/lang/Long;", "setPositionFlex", "(Ljava/lang/Long;)V", "vsWatermarkIcon", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSWatermarkIcon;", "vsWatermarkIconFlex", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermarkIcon;", "getVsWatermarkIconFlex", "()Ljava/util/List;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSWatermark extends FlexModelBase<IVSWatermark> implements IVSWatermark, h {

    @SerializedName("position")
    public Long position;

    @SerializedName("watermark_icon")
    public List<VSWatermarkIcon> vsWatermarkIcon;

    public VSWatermark() {
        super(IVSWatermark.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermark
    public Long getPositionFlex() {
        return this.position;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermark
    public List<IVSWatermarkIcon> getVsWatermarkIconFlex() {
        return this.vsWatermarkIcon;
    }

    public VSWatermark(g r100) {
        super(IVSWatermark.class);
        this.vsWatermarkIcon = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.position = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 4) goto L9;
        this.vsWatermarkIcon.add(new VSWatermarkIcon(r100));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermark
    public void setPositionFlex(Long r100) {
        this.position = r100;
    }
}
