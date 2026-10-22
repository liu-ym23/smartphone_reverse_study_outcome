package com.bytedance.android.shopping.store.slicecard.dto;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/store/slicecard/dto/SliceTemplate;", "Ljava/io/Serializable;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "version", "getVersion", "setVersion", "content", "getContent", "setContent", "", "type", "I", "getType", "()I", "setType", "(I)V", "spanSize", "Ljava/lang/Integer;", "getSpanSize", "()Ljava/lang/Integer;", "setSpanSize", "(Ljava/lang/Integer;)V", "", "predictHeight", "D", "getPredictHeight", "()D", "setPredictHeight", "(D)V", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "getSlcElement", "()Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "setSlcElement", "(Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;)V", "slcElement", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceTemplate implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient SlcElement f186333a;

    @SerializedName("content")
    private String content;

    @SerializedName("name")
    private String name;

    @SerializedName("predict_height")
    private double predictHeight;

    @SerializedName("span_size")
    private Integer spanSize;

    @SerializedName("type")
    private int type;

    @SerializedName("url")
    private String url;

    @SerializedName("version")
    private String version;

    public SliceTemplate() {
        this.type = SliceTemplateType.GECKO.getType();
    }

    public final String getContent() {
        return this.content;
    }

    public final String getName() {
        return this.name;
    }

    public final double getPredictHeight() {
        return this.predictHeight;
    }

    public final SlcElement getSlcElement() {
        return this.f186333a;
    }

    public final Integer getSpanSize() {
        return this.spanSize;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setPredictHeight(double r100) {
        this.predictHeight = r100;
    }

    public final void setSlcElement(SlcElement r100) {
        this.f186333a = r100;
    }

    public final void setSpanSize(Integer r100) {
        this.spanSize = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setVersion(String r100) {
        this.version = r100;
    }
}
