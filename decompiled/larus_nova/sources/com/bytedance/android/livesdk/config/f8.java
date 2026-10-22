package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/f8;", "", "", "showNoticeDuration", "J", "getShowNoticeDuration", "()J", "hideNoticeDelay", "getHideNoticeDelay", "", "showNoticeLimit", "I", "getShowNoticeLimit", "()I", "showToolbarNoticeDuration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "toolbarNoticeContent", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f8 {

    @SerializedName("hide_notice_delay")
    private final long hideNoticeDelay;

    @SerializedName("show_notice_duration")
    private final long showNoticeDuration;

    @SerializedName("show_notice_limit")
    private final int showNoticeLimit;

    @SerializedName("show_toolbar_notice_duration")
    private final long showToolbarNoticeDuration;

    @SerializedName("toolbar_notice_content")
    private final String toolbarNoticeContent;

    public f8() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f8) == false) goto L16;
        f8 r101 = (f8) r100;
        if (this.showNoticeDuration == r101.showNoticeDuration) goto L8;
        return false;
    L8:
        if (this.hideNoticeDelay == r101.hideNoticeDelay) goto L10;
        return false;
    L10:
        if (this.showNoticeLimit == r101.showNoticeLimit) goto L12;
        return false;
    L12:
        if (this.showToolbarNoticeDuration == r101.showToolbarNoticeDuration) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.toolbarNoticeContent, r101.toolbarNoticeContent) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.showNoticeDuration;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.hideNoticeDelay;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.showNoticeLimit) * 31;
        long r104 = this.showToolbarNoticeDuration;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.toolbarNoticeContent;
        if (r106 == null) goto L5;
        int r107 = r106.hashCode();
    L7:
        return r105 + r107;
    L5:
        r107 = 0;
        goto L7
    }

    public final String toString() {
        return "InLiveGamePromoteConfig(showNoticeDuration=" + this.showNoticeDuration + ", hideNoticeDelay=" + this.hideNoticeDelay + ", showNoticeLimit=" + this.showNoticeLimit + ", showToolbarNoticeDuration=" + this.showToolbarNoticeDuration + ", toolbarNoticeContent=" + this.toolbarNoticeContent + ")";
    }

    public final long a() {
        return this.showToolbarNoticeDuration;
    }

    public final String b() {
        return this.toolbarNoticeContent;
    }

    public f8(int r100) {
        Intrinsics.checkNotNullParameter("查看实时下载数据及更多推广工具", "toolbarNoticeContent");
        this.showNoticeDuration = 5000;
        this.hideNoticeDelay = 1000;
        this.showNoticeLimit = 1;
        this.showToolbarNoticeDuration = 3000;
        this.toolbarNoticeContent = "查看实时下载数据及更多推广工具";
    }
}
