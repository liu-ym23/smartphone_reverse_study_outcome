package com.bytedance.android.shopping.vo;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/vo/ShopRowVO;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "number", "", "getNumber", "()J", "setNumber", "(J)V", "withData", "", "getWithData", "()Z", "setWithData", "(Z)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopRowVO implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Integer f187191id;
    private String name;
    private long number;
    private boolean withData;

    public ShopRowVO() {
        this.name = "";
    }

    public final Integer getId() {
        return this.f187191id;
    }

    public final String getName() {
        return this.name;
    }

    public final long getNumber() {
        return this.number;
    }

    public final boolean getWithData() {
        return this.withData;
    }

    public final void setId(Integer r100) {
        this.f187191id = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setNumber(long r100) {
        this.number = r100;
    }

    public final void setWithData(boolean r100) {
        this.withData = r100;
    }
}
