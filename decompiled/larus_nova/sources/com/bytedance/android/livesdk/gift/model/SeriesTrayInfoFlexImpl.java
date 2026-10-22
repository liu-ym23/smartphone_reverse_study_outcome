package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.data.SeriesTrayInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/SeriesTrayInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/o3;", "Lpy/k;", "staticImage", "Lpy/k;", "getStaticImage", "()Lpy/k;", "setStaticImage", "(Lpy/k;)V", "dynamicImage", "getDynamicImage", "setDynamicImage", "", "duration$delegate", "Ljava/lang/Object;", "getDuration", "()J", "duration", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeriesTrayInfoFlexImpl extends FlexModelBase<o3> implements o3, vh7.h {

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("dynamic_img")
    protected py.k dynamicImage;

    @SerializedName("static_img")
    protected py.k staticImage;

    public SeriesTrayInfoFlexImpl() {
        super(o3.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.o3
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o3
    public py.k getDynamicImage() {
        return this.dynamicImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o3
    public py.k getStaticImage() {
        return this.staticImage;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public SeriesTrayInfoFlexImpl(am3.g r100) {
        super(o3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$duration = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.staticImage = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.dynamicImage = vh7.f.a(r100, py.k.class);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setDynamicImage(py.k r100) {
        this.dynamicImage = r100;
    }

    public void setStaticImage(py.k r100) {
        this.staticImage = r100;
    }
}
