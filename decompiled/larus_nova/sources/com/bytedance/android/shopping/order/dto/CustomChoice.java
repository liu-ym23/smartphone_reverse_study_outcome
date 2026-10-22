package com.bytedance.android.shopping.order.dto;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/CustomChoice;", "Ljava/io/Serializable;", "()V", "option", "", "getOption", "()Ljava/lang/String;", "setOption", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomChoice implements Serializable {

    @SerializedName("option")
    private String option;

    @SerializedName("title")
    private String title;

    public CustomChoice() {
    }

    public final String getOption() {
        return this.option;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setOption(String r100) {
        this.option = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
