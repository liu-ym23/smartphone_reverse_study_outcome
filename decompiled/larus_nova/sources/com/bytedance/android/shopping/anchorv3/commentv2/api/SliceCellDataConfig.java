package com.bytedance.android.shopping.anchorv3.commentv2.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/commentv2/api/SliceCellDataConfig;", "Ljava/io/Serializable;", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "equals", "", "other", "", "hashCode", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SliceCellDataConfig implements Serializable {

    @SerializedName("height")
    private int height;

    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public SliceCellDataConfig() {
        this.url = "";
        this.name = "";
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof SliceCellDataConfig) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        SliceCellDataConfig r101 = (SliceCellDataConfig) r100;
        if (this.height == r101.height) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.name, r101.name) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }
}
