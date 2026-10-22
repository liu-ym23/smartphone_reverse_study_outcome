package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/p;", "", "", "frequencyKey", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "frequencyCount", "J", "b", "()J", "Lcom/bytedance/android/ec/model/ECUrlModel;", "leftIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "background", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "num", "e", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f148477a = 0;

    @SerializedName("background")
    private final ECUrlModel background;

    @SerializedName("frequency_count")
    private final long frequencyCount;

    @SerializedName("frequency_key")
    private final String frequencyKey;

    @SerializedName("left_icon")
    private final ECUrlModel leftIcon;

    @SerializedName("num")
    private final String num;

    public static final class a {
    }

    static {
    }

    public p() {
        this(null, 0, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L16;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.frequencyKey, r101.frequencyKey) == true) goto L8;
        return false;
    L8:
        if (this.frequencyCount == r101.frequencyCount) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.num, r101.num) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.frequencyKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.frequencyCount;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        ECUrlModel r105 = this.leftIcon;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ECUrlModel r108 = this.background;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.num;
        if (r111 == null) goto L18;
        r101 = r111.hashCode();
    L18:
        return r110 + r101;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroDigitalAtmosphere(frequencyKey=" + this.frequencyKey + ", frequencyCount=" + this.frequencyCount + ", leftIcon=" + this.leftIcon + ", background=" + this.background + ", num=" + this.num + ")";
    }

    public final ECUrlModel a() {
        return this.background;
    }

    public final long b() {
        return this.frequencyCount;
    }

    public final String c() {
        return this.frequencyKey;
    }

    public final ECUrlModel d() {
        return this.leftIcon;
    }

    public final String e() {
        return this.num;
    }

    public p(String r100, long r101, ECUrlModel r102, ECUrlModel r103, String r104) {
        this.frequencyKey = r100;
        this.frequencyCount = r101;
        this.leftIcon = r102;
        this.background = r103;
        this.num = r104;
    }
}
