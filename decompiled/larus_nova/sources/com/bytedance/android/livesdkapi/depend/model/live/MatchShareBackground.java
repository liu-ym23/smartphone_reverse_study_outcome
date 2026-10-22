package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MatchShareBackground;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchShareBackground;", "Lpy/k;", "verticalBackground", "Lpy/k;", "getVerticalBackground", "()Lpy/k;", "setVerticalBackground", "(Lpy/k;)V", "horizontalBackground", "getHorizontalBackground", "setHorizontalBackground", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchShareBackground extends FlexModelBase<IMatchShareBackground> implements IMatchShareBackground, h {

    @SerializedName("horizontal_img")
    protected k horizontalBackground;

    @SerializedName("vertical_img")
    protected k verticalBackground;

    public MatchShareBackground() {
        super(IMatchShareBackground.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public MatchShareBackground(g r100) {
        super(IMatchShareBackground.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.verticalBackground = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.horizontalBackground = f.a(r100, k.class);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground
    public k getHorizontalBackground() {
        return this.horizontalBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground
    public k getVerticalBackground() {
        return this.verticalBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground
    public void setHorizontalBackground(k r100) {
        this.horizontalBackground = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchShareBackground
    public void setVerticalBackground(k r100) {
        this.verticalBackground = r100;
    }
}
