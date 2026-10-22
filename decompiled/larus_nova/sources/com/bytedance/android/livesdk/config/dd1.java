package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/dd1;", "", "", "firstTitle", "Ljava/lang/String;", "getFirstTitle", "()Ljava/lang/String;", "setFirstTitle", "(Ljava/lang/String;)V", "secondTitleHasTest", "getSecondTitleHasTest", "setSecondTitleHasTest", "secondTitleNoTest", "getSecondTitleNoTest", "setSecondTitleNoTest", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class dd1 {

    @SerializedName("first_title")
    private String firstTitle;

    @SerializedName("second_title_has_test")
    private String secondTitleHasTest;

    @SerializedName("second_title_no_test")
    private String secondTitleNoTest;

    public dd1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof dd1) == false) goto L12;
        dd1 r101 = (dd1) r100;
        if (Intrinsics.areEqual(this.firstTitle, r101.firstTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secondTitleHasTest, r101.secondTitleHasTest) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secondTitleNoTest, r101.secondTitleNoTest) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.firstTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.secondTitleHasTest;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.secondTitleNoTest;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSingStageConfig(firstTitle=" + this.firstTitle + ", secondTitleHasTest=" + this.secondTitleHasTest + ", secondTitleNoTest=" + this.secondTitleNoTest + ")";
    }

    public dd1(int r100) {
        this.firstTitle = "你点我唱";
        this.secondTitleHasTest = "欢迎选择嘉宾送礼试音/点唱";
        this.secondTitleNoTest = "欢迎选择嘉宾送礼点唱";
    }
}
