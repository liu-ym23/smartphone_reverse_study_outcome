package com.bytedance.android.livesdk.live.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated(message = "弃用")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B%\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/live/model/LiveInnerUrl;", "", "", "component1", "component2", "component3", "key", "reqFrom", "innerUrl", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "getReqFrom", "getInnerUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerUrl {
    public static final a Companion = null;

    @SerializedName("inner_url")
    private final String innerUrl;

    @SerializedName("key")
    private final String key;

    @SerializedName("req_from")
    private final String reqFrom;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ LiveInnerUrl copy$default(LiveInnerUrl r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.reqFrom;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.innerUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.reqFrom;
    }

    public final String component3() {
        return this.innerUrl;
    }

    public final LiveInnerUrl copy(String r100, String r101, String r102) {
        return new LiveInnerUrl(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveInnerUrl) == false) goto L12;
        LiveInnerUrl r101 = (LiveInnerUrl) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.reqFrom, r101.reqFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.innerUrl, r101.innerUrl) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.reqFrom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.innerUrl;
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

    public String toString() {
        return "LiveInnerUrl(key=" + this.key + ", reqFrom=" + this.reqFrom + ", innerUrl=" + this.innerUrl + ")";
    }

    public final String getInnerUrl() {
        return this.innerUrl;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getReqFrom() {
        return this.reqFrom;
    }

    public LiveInnerUrl(String r100, String r101, String r102) {
        this.key = r100;
        this.reqFrom = r101;
        this.innerUrl = r102;
    }
}
