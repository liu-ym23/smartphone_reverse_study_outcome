package com.bytedance.android.livesdkapi.depend.model.live;

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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/EpisodePreviewImage;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IEpisodePreviewImage;", "Lpy/k;", "previewImageUp", "Lpy/k;", "getPreviewImageUp", "()Lpy/k;", "setPreviewImageUp", "(Lpy/k;)V", "previewImageDown", "getPreviewImageDown", "setPreviewImageDown", "", "previewType", "I", "getPreviewType", "()I", "setPreviewType", "(I)V", "", "previewWordUp", "Ljava/lang/String;", "getPreviewWordUp", "()Ljava/lang/String;", "setPreviewWordUp", "(Ljava/lang/String;)V", "previewWordDown", "getPreviewWordDown", "setPreviewWordDown", "<init>", "()V", "EpisodePreviewType", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodePreviewImage extends FlexModelBase<IEpisodePreviewImage> implements IEpisodePreviewImage, h {

    @SerializedName("preview_uri_down")
    protected k previewImageDown;

    @SerializedName("preview_uri_up")
    protected k previewImageUp;

    @SerializedName("preview_type")
    protected int previewType;

    @SerializedName("preview_word_down")
    protected String previewWordDown;

    @SerializedName("preview_word_up")
    protected String previewWordUp;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/EpisodePreviewImage$EpisodePreviewType;", "", "()V", "GENERAL", "", "NEW", "OLD", "UNKNOWN", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EpisodePreviewType {
        public static final int GENERAL = 3;
        public static final EpisodePreviewType INSTANCE = null;
        public static final int NEW = 2;
        public static final int OLD = 1;
        public static final int UNKNOWN = 0;

        private EpisodePreviewType() {
        }

        static {
            INSTANCE = new EpisodePreviewType();
        }
    }

    public EpisodePreviewImage() {
        super(IEpisodePreviewImage.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public k getPreviewImageDown() {
        return this.previewImageDown;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public k getPreviewImageUp() {
        return this.previewImageUp;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public int getPreviewType() {
        return this.previewType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public String getPreviewWordDown() {
        return this.previewWordDown;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public String getPreviewWordUp() {
        return this.previewWordUp;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public EpisodePreviewImage(g r100) {
        super(IEpisodePreviewImage.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.previewImageUp = f.a(r100, k.class);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.previewImageDown = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.previewType = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.previewWordUp = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.previewWordDown = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public void setPreviewImageDown(k r100) {
        this.previewImageDown = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public void setPreviewImageUp(k r100) {
        this.previewImageUp = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public void setPreviewType(int r100) {
        this.previewType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public void setPreviewWordDown(String r100) {
        this.previewWordDown = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage
    public void setPreviewWordUp(String r100) {
        this.previewWordUp = r100;
    }
}
