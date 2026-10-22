package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "", "()V", "dslData", "", "getDslData", "()Ljava/lang/String;", "setDslData", "(Ljava/lang/String;)V", "dslType", "", "getDslType", "()J", "setDslType", "(J)V", "extra", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel$ExtraInfo;", "getExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel$ExtraInfo;", "setExtra", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel$ExtraInfo;)V", "id", "getId", "setId", "sliceContent", "getSliceContent", "setSliceContent", "url", "getUrl", "setUrl", "version", "getVersion", "setVersion", "ExtraInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveDSLModel implements h {

    @SerializedName("dsl_data")
    protected String dslData;

    @SerializedName("dsl_type")
    protected long dslType;

    @SerializedName("extra")
    protected ExtraInfo extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("dsl_id")
    protected long f162596id;

    @SerializedName("dsl_slice_info")
    protected String sliceContent;

    @SerializedName("dsl_gecko_download_uri")
    protected String url;

    @SerializedName("version")
    protected long version;

    @ForMain
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel$ExtraInfo;", "", "()V", "height", "", "getHeight", "()J", "setHeight", "(J)V", "width", "getWidth", "setWidth", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ExtraInfo implements h {

        @SerializedName("height")
        protected long height;

        @SerializedName("width")
        protected long width;

        public ExtraInfo() {
        }

        public final long getHeight() {
            return this.height;
        }

        public final long getWidth() {
            return this.width;
        }

        public ExtraInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.height = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.width = r100.j();
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setHeight(long r100) {
            this.height = r100;
        }

        public final void setWidth(long r100) {
            this.width = r100;
        }
    }

    public LiveDSLModel() {
        this.url = "";
        this.sliceContent = "";
        this.dslData = "";
    }

    public final String getDslData() {
        return this.dslData;
    }

    public final long getDslType() {
        return this.dslType;
    }

    public final ExtraInfo getExtra() {
        return this.extra;
    }

    public final long getId() {
        return this.f162596id;
    }

    public final String getSliceContent() {
        return this.sliceContent;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getVersion() {
        return this.version;
    }

    public LiveDSLModel(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.extra = new ExtraInfo(r100);
        goto L3
    L8:
        this.dslData = am3.h.c(r100);
        goto L3
    L9:
        this.version = r100.j();
        goto L3
    L10:
        this.sliceContent = am3.h.c(r100);
        goto L3
    L11:
        this.url = am3.h.c(r100);
        goto L3
    L12:
        this.dslType = r100.j();
        goto L3
    L13:
        this.f162596id = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.url != null) goto L18;
        this.url = "";
    L18:
        if (this.sliceContent != null) goto L21;
        this.sliceContent = "";
    L21:
        if (this.dslData != null) goto L42;
        this.dslData = "";
        return;
    }

    public final void setDslData(String r100) {
        this.dslData = r100;
    }

    public final void setDslType(long r100) {
        this.dslType = r100;
    }

    public final void setExtra(ExtraInfo r100) {
        this.extra = r100;
    }

    public final void setId(long r100) {
        this.f162596id = r100;
    }

    public final void setSliceContent(String r100) {
        this.sliceContent = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setVersion(long r100) {
        this.version = r100;
    }
}
