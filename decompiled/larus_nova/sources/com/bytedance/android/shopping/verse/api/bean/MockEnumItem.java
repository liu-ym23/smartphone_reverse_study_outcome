package com.bytedance.android.shopping.verse.api.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/verse/api/bean/MockEnumItem;", "Ljava/io/Serializable;", "()V", "enumData", "", "getEnumData", "()Ljava/lang/Object;", "setEnumData", "(Ljava/lang/Object;)V", "enumDesc", "", "getEnumDesc", "()Ljava/lang/String;", "setEnumDesc", "(Ljava/lang/String;)V", "ec-verse-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MockEnumItem implements Serializable {

    @SerializedName("enumData")
    private Object enumData;

    @SerializedName("enumDesc")
    private String enumDesc;

    public MockEnumItem() {
    }

    public final Object getEnumData() {
        return this.enumData;
    }

    public final String getEnumDesc() {
        return this.enumDesc;
    }

    public final void setEnumData(Object r100) {
        this.enumData = r100;
    }

    public final void setEnumDesc(String r100) {
        this.enumDesc = r100;
    }
}
