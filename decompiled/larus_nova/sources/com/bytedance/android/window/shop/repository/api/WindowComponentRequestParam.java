package com.bytedance.android.window.shop.repository.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lq3.b;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR(\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/WindowComponentRequestParam;", "Ljava/io/Serializable;", "", "secAuthorId", "Ljava/lang/String;", "getSecAuthorId", "()Ljava/lang/String;", "setSecAuthorId", "(Ljava/lang/String;)V", "passThroughApi", "getPassThroughApi", "setPassThroughApi", "", "sourceType", "Ljava/lang/Integer;", "getSourceType", "()Ljava/lang/Integer;", "setSourceType", "(Ljava/lang/Integer;)V", "extraSchema", "getExtraSchema", "setExtraSchema", "Llq3/b;", "sceneParams", "Llq3/b;", "getSceneParams", "()Llq3/b;", "setSceneParams", "(Llq3/b;)V", "isPrefetch", "I", "()I", "setPrefetch", "(I)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowComponentRequestParam implements Serializable {
    private String extraSchema;
    private int isPrefetch;
    private String passThroughApi;
    private b<?> sceneParams;
    private String secAuthorId;
    private Integer sourceType;

    public WindowComponentRequestParam() {
        this.secAuthorId = "";
    }

    public final String getExtraSchema() {
        return this.extraSchema;
    }

    public final String getPassThroughApi() {
        return this.passThroughApi;
    }

    public final b<?> getSceneParams() {
        return this.sceneParams;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final int isPrefetch() {
        return this.isPrefetch;
    }

    public final void setExtraSchema(String r100) {
        this.extraSchema = r100;
    }

    public final void setPassThroughApi(String r100) {
        this.passThroughApi = r100;
    }

    public final void setPrefetch(int r100) {
        this.isPrefetch = r100;
    }

    public final void setSceneParams(b<?> r100) {
        this.sceneParams = r100;
    }

    public final void setSecAuthorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secAuthorId = r100;
    }

    public final void setSourceType(Integer r100) {
        this.sourceType = r100;
    }
}
