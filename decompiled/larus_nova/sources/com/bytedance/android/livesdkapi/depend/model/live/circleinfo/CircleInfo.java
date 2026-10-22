package com.bytedance.android.livesdkapi.depend.model.live.circleinfo;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.CircleInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/CircleInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/circleinfo/ICircleInfo;", "", "circleId", "J", "getCircleId", "()J", "setCircleId", "(J)V", "", "circleName", "Ljava/lang/String;", "getCircleName", "()Ljava/lang/String;", "setCircleName", "(Ljava/lang/String;)V", "Lpy/k;", "circleCover", "Lpy/k;", "getCircleCover", "()Lpy/k;", "setCircleCover", "(Lpy/k;)V", "circleDesc", "getCircleDesc", "setCircleDesc", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CircleInfo extends FlexModelBase<ICircleInfo> implements ICircleInfo, h {

    @SerializedName("cover_img")
    protected k circleCover;

    @SerializedName("description")
    protected String circleDesc;

    @SerializedName("id")
    protected long circleId;

    @SerializedName("name")
    protected String circleName;

    public CircleInfo() {
        super(ICircleInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public k getCircleCover() {
        return this.circleCover;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public String getCircleDesc() {
        return this.circleDesc;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public long getCircleId() {
        return this.circleId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public String getCircleName() {
        return this.circleName;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public CircleInfo(g r100) {
        super(ICircleInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.circleId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.circleName = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.circleCover = f.a(r100, k.class);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.circleDesc = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public void setCircleCover(k r100) {
        this.circleCover = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public void setCircleDesc(String r100) {
        this.circleDesc = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public void setCircleId(long r100) {
        this.circleId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo
    public void setCircleName(String r100) {
        this.circleName = r100;
    }
}
