package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/config/lc1;", "", "", "button", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "content", "b", "Lcom/bytedance/android/livesdk/config/ci1;", "title", "Lcom/bytedance/android/livesdk/config/ci1;", "e", "()Lcom/bytedance/android/livesdk/config/ci1;", "douYinAuthColor", "c", "testNum", "d", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class lc1 {

    @SerializedName("button")
    private final String button;

    @SerializedName("content")
    private final String content;

    @SerializedName("douyin_auth_text_color")
    private final String douYinAuthColor;

    @SerializedName("test_num")
    private final String testNum;

    @SerializedName("title")
    private final ci1 title;

    public lc1() {
        this(0);
    }

    public final String a() {
        return this.button;
    }

    public final String b() {
        return this.content;
    }

    public final String c() {
        return this.douYinAuthColor;
    }

    public final String d() {
        return this.testNum;
    }

    public final ci1 e() {
        return this.title;
    }

    public lc1(int r100) {
        ci1 r101 = new ci1(0);
        Intrinsics.checkNotNullParameter("立即关联", "button");
        Intrinsics.checkNotNullParameter("关联当前手机号*所登录的抖音，或以此号注册抖音并关联", "content");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter("#FFFE2C55", "douYinAuthColor");
        Intrinsics.checkNotNullParameter("0", "testNum");
        this.button = "立即关联";
        this.content = "关联当前手机号*所登录的抖音，或以此号注册抖音并关联";
        this.title = r101;
        this.douYinAuthColor = "#FFFE2C55";
        this.testNum = "0";
    }
}
