package com.bytedance.android.live.core.resources;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.AnchorGuide")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR+\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00108V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/core/resources/AnchorGuideFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/core/resources/a;", "Lpy/k;", "<set-?>", "textImageModel$delegate", "Ljava/lang/Object;", "getTextImageModel", "()Lpy/k;", "setTextImageModel", "(Lpy/k;)V", "textImageModel", "pictureImageModel$delegate", "getPictureImageModel", "setPictureImageModel", "pictureImageModel", "", "textMaxShowTimes$delegate", "getTextMaxShowTimes", "()I", "setTextMaxShowTimes", "(I)V", "textMaxShowTimes", "imageMaxShowTimes$delegate", "getImageMaxShowTimes", "setImageMaxShowTimes", "imageMaxShowTimes", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AnchorGuideFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("max_picture_display_num")
    protected int _$$imageMaxShowTimes;

    @SerializedName("picture")
    protected py.k _$$pictureImageModel;

    @SerializedName("text")
    protected py.k _$$textImageModel;

    @SerializedName("max_text_display_num")
    protected int _$$textMaxShowTimes;

    public AnchorGuideFlexImpl() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final int getImageMaxShowTimes() {
        return this._$$imageMaxShowTimes;
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final py.k getPictureImageModel() {
        return this._$$pictureImageModel;
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final py.k getTextImageModel() {
        return this._$$textImageModel;
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final int getTextMaxShowTimes() {
        return this._$$textMaxShowTimes;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public AnchorGuideFlexImpl(am3.g r100) {
        super(a.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$textImageModel = vh7.f.a(r100, py.k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$pictureImageModel = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$textMaxShowTimes = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._$$imageMaxShowTimes = r100.i();
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final void setImageMaxShowTimes(int r100) {
        this._$$imageMaxShowTimes = r100;
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final void setPictureImageModel(py.k r100) {
        this._$$pictureImageModel = r100;
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final void setTextImageModel(py.k r100) {
        this._$$textImageModel = r100;
    }

    @Override // com.bytedance.android.live.core.resources.a
    public final void setTextMaxShowTimes(int r100) {
        this._$$textMaxShowTimes = r100;
    }
}
