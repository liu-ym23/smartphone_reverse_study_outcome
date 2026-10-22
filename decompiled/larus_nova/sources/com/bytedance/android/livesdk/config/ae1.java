package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/ae1;", "", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "", "enterFromMerges", "Ljava/util/List;", "getEnterFromMerges", "()Ljava/util/List;", "enterMethods", "getEnterMethods", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ae1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f119783a = null;

    @SerializedName("channel")
    private final String channelId;

    @SerializedName("enter_from_merges")
    private final List<String> enterFromMerges;

    @SerializedName("enter_methods")
    private final List<String> enterMethods;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ae1) == false) goto L12;
        ae1 r101 = (ae1) r100;
        if (Intrinsics.areEqual(this.channelId, r101.channelId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterFromMerges, r101.enterFromMerges) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterMethods, r101.enterMethods) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.channelId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.enterFromMerges;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.enterMethods;
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
        return "PangleFeedArgsConfig(channelId=" + this.channelId + ", enterFromMerges=" + this.enterFromMerges + ", enterMethods=" + this.enterMethods + ")";
    }

    static {
        f119783a = new a();
    }
}
