package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.s1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\u0004\u0018\u0001`\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h0;", "", "", "content", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/s1;", "trackInfo", "Lcom/bytedance/android/ec/model/response/s1;", "c", "()Lcom/bytedance/android/ec/model/response/s1;", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "colorList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName(EventConstant.Key.COLOR)
    private final List<String> colorList;

    @SerializedName("content")
    private final String content;

    @SerializedName("track_info")
    private final s1 trackInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == false) goto L12;
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.trackInfo, r101.trackInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.colorList, r101.colorList) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        s1 r104 = this.trackInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.colorList;
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
        return "IntroProductTitle(content=" + this.content + ", trackInfo=" + this.trackInfo + ", colorList=" + this.colorList + ")";
    }

    public h0() {
        this.content = null;
        this.trackInfo = null;
        this.colorList = null;
    }

    public final List<String> a() {
        return this.colorList;
    }

    public final String b() {
        return this.content;
    }

    public final s1 c() {
        return this.trackInfo;
    }
}
