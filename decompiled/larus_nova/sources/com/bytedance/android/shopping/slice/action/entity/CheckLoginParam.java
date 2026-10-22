package com.bytedance.android.shopping.slice.action.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/entity/CheckLoginParam;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "enterFrom", "enterMethod", "source", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getEnterFrom", "()Ljava/lang/String;", "getEnterMethod", "getSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckLoginParam implements Serializable {
    public static final a Companion = null;
    public static final String KET_TIMESTAMP = "pdp_check_login_time";
    public static final String KEY_FAILED = "failed";
    public static final String KEY_SUCCESS = "success";

    @SerializedName("enter_from")
    private final String enterFrom;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName("source")
    private final String source;

    public static final class a {
        public a() {
        }

        public static CheckLoginParam a(Map r100) {
            Object r101 = null;
            if (r100 == null) goto L16;
            Object r102 = r100.get("enter_from");
            if ((r102 instanceof String) == true) goto L7;
            r102 = null;
        L7:
            String r103 = (String) r102;
            Object r104 = r100.get("enter_method");
            if ((r104 instanceof String) == true) goto L10;
            r104 = null;
        L10:
            String r105 = (String) r104;
            Object r106 = r100.get("source");
            if ((r106 instanceof String) == false) goto L15;
            r101 = r106;
        L15:
            return new CheckLoginParam(r103, r105, (String) r101);
        L16:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public CheckLoginParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CheckLoginParam copy$default(CheckLoginParam r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.enterFrom;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.enterMethod;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.source;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.enterFrom;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final String component3() {
        return this.source;
    }

    public final CheckLoginParam copy(String r100, String r101, String r102) {
        return new CheckLoginParam(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CheckLoginParam) == false) goto L12;
        CheckLoginParam r101 = (CheckLoginParam) r100;
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.enterFrom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterMethod;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.source;
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
        return "CheckLoginParam(enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ", source=" + this.source + ")";
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getSource() {
        return this.source;
    }

    public CheckLoginParam(String r100, String r101, String r102) {
        this.enterFrom = r100;
        this.enterMethod = r101;
        this.source = r102;
    }

    public /* synthetic */ CheckLoginParam(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
