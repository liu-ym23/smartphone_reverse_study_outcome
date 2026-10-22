package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o0;", "", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "maxLine", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tag", "Ljava/util/List;", "c", "()Ljava/util/List;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o0 {

    @SerializedName("max_line")
    private final long maxLine;

    @SerializedName("name")
    private String name;

    @SerializedName("tag")
    private final List<ECRitTag> tag;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == false) goto L12;
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (this.maxLine == r101.maxLine) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.maxLine;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        List<ECRitTag> r105 = this.tag;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroTitle(name=" + this.name + ", maxLine=" + this.maxLine + ", tag=" + this.tag + ")";
    }

    public o0() {
        this.name = null;
        this.maxLine = 0;
        this.tag = null;
    }

    public final long a() {
        return this.maxLine;
    }

    public final String b() {
        return this.name;
    }

    public final List<ECRitTag> c() {
        return this.tag;
    }

    public final void d(String r100) {
        this.name = r100;
    }
}
