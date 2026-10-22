package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/model/response/LynxCellDataConfig;", "Ljava/io/Serializable;", "height", "", "url", "", "(ILjava/lang/String;)V", "getHeight", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "dataValid", "", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LynxCellDataConfig implements Serializable {

    @SerializedName("height")
    private final int height;

    @SerializedName("url")
    private final String url;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxCellDataConfig() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ LynxCellDataConfig copy$default(LynxCellDataConfig r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.height;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.url;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.height;
    }

    public final String component2() {
        return this.url;
    }

    public final LynxCellDataConfig copy(int r100, String r101) {
        return new LynxCellDataConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LynxCellDataConfig) == false) goto L10;
        LynxCellDataConfig r101 = (LynxCellDataConfig) r100;
        if (this.height == r101.height) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.height * 31;
        String r101 = this.url;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "LynxCellDataConfig(height=" + this.height + ", url=" + this.url + ")";
    }

    public final boolean dataValid() {
        return com.bytedance.android.shopping.anchorv3.a.b(this.url);
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getUrl() {
        return this.url;
    }

    public LynxCellDataConfig(int r100, String r101) {
        this.height = r100;
        this.url = r101;
    }

    public /* synthetic */ LynxCellDataConfig(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
