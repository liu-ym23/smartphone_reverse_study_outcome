package com.bytedance.android.shopping.orderlist.list.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/model/PageContext;", "Ljava/io/Serializable;", "()V", "environment", "", "getEnvironment$annotations", "getEnvironment", "()Ljava/lang/String;", "setEnvironment", "(Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageContext implements Serializable {

    @SerializedName("environment")
    private String environment;

    public PageContext() {
    }

    public static /* synthetic */ void getEnvironment$annotations() {
    }

    public final String getEnvironment() {
        return this.environment;
    }

    public final void setEnvironment(String r100) {
        this.environment = r100;
    }
}
