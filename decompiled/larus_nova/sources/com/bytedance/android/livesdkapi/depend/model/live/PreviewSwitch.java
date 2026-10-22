package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.PreviewSwitch")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewSwitch;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewSwitch;", "()V", "assistLabel", "", "getAssistLabel", "()I", "setAssistLabel", "(I)V", "dynamicLabel", "getDynamicLabel", "setDynamicLabel", "extendArea", "getExtendArea", "setExtendArea", "previewGuide", "getPreviewGuide", "setPreviewGuide", "title", "getTitle", d.f25925o, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewSwitch extends FlexModelBase<IPreviewSwitch> implements IPreviewSwitch, h {

    @SerializedName("assist_label")
    protected int assistLabel;

    @SerializedName("dynamic_label")
    protected int dynamicLabel;

    @SerializedName("extend_area")
    protected int extendArea;

    @SerializedName("preview_guide")
    protected int previewGuide;

    @SerializedName("title")
    protected int title;

    public PreviewSwitch() {
        super(IPreviewSwitch.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public int getAssistLabel() {
        return this.assistLabel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public int getDynamicLabel() {
        return this.dynamicLabel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public int getExtendArea() {
        return this.extendArea;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public int getPreviewGuide() {
        return this.previewGuide;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public int getTitle() {
        return this.title;
    }

    public PreviewSwitch(g r100) {
        super(IPreviewSwitch.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.title = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.previewGuide = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.dynamicLabel = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.assistLabel = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.extendArea = r100.i();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public void setAssistLabel(int r100) {
        this.assistLabel = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public void setDynamicLabel(int r100) {
        this.dynamicLabel = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public void setExtendArea(int r100) {
        this.extendArea = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public void setPreviewGuide(int r100) {
        this.previewGuide = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewSwitch
    public void setTitle(int r100) {
        this.title = r100;
    }
}
