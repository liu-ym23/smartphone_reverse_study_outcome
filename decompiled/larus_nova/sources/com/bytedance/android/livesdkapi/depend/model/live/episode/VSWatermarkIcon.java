package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\u0005R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSWatermarkIcon;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermarkIcon;", "", "getIconWidth", "()Ljava/lang/Integer;", "getLandscapeMargin", "getPortraitMargin", "Lpy/k;", "icon", "Lpy/k;", "", "iconWidth", "Ljava/lang/Long;", "iconType", "landscapeMargin", "portraitMargin", "getIconFlex", "()Lpy/k;", "iconFlex", "getIconWidthFlex", "()Ljava/lang/Long;", "iconWidthFlex", "getIconTypeFlex", "iconTypeFlex", "getLandscapeMarginFlex", "landscapeMarginFlex", "getPortraitMarginFlex", "portraitMarginFlex", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSWatermarkIcon extends FlexModelBase<IVSWatermarkIcon> implements IVSWatermarkIcon, h {

    @SerializedName("icon")
    public k icon;

    @SerializedName("icon_type")
    public Long iconType;

    @SerializedName("icon_width")
    public Long iconWidth;

    @SerializedName("landscape_dis")
    public Long landscapeMargin;

    @SerializedName("vertical_dis")
    public Long portraitMargin;

    public VSWatermarkIcon() {
        super(IVSWatermarkIcon.class);
    }

    public final Integer getIconWidth() {
        Long r100 = this.iconWidth;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf((int) r100.longValue());
    }

    public final Integer getLandscapeMargin() {
        Long r100 = this.landscapeMargin;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf((int) r100.longValue());
    }

    public final Integer getPortraitMargin() {
        Long r100 = this.portraitMargin;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf((int) r100.longValue());
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermarkIcon
    public k getIconFlex() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermarkIcon
    public Long getIconTypeFlex() {
        return this.iconType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermarkIcon
    public Long getIconWidthFlex() {
        return this.iconWidth;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermarkIcon
    public Long getLandscapeMarginFlex() {
        return this.landscapeMargin;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSWatermarkIcon
    public Long getPortraitMarginFlex() {
        return this.portraitMargin;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, py.k] */
    public VSWatermarkIcon(g r100) {
        super(IVSWatermarkIcon.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.icon = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.iconWidth = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.iconType = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.landscapeMargin = Long.valueOf(r100.j());
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.portraitMargin = Long.valueOf(r100.j());
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }
}
