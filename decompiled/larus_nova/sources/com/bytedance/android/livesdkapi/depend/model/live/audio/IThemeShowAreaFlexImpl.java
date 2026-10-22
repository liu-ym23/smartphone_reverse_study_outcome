package com.bytedance.android.livesdkapi.depend.model.live.audio;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ShowArea")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowAreaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "", "x$delegate", "Ljava/lang/Object;", "getX", "()J", "x", "y$delegate", "getY", "y", "h$delegate", "getH", "h", "w$delegate", "getW", "w", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IThemeShowAreaFlexImpl extends FlexModelBase<IThemeShowArea> implements IThemeShowArea, h {

    @SerializedName("h")
    protected long _$$h;

    @SerializedName("w")
    protected long _$$w;

    @SerializedName("x")
    protected long _$$x;

    @SerializedName("y")
    protected long _$$y;

    public IThemeShowAreaFlexImpl() {
        super(IThemeShowArea.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public final long getH() {
        return this._$$h;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public final long getW() {
        return this._$$w;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public final long getX() {
        return this._$$x;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea, com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    public final long getY() {
        return this._$$y;
    }

    public IThemeShowAreaFlexImpl(g r100) {
        super(IThemeShowArea.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$x = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$y = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$h = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$w = r100.j();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }
}
