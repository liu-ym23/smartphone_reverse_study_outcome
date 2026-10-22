package aa3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Laa3/c;", "", "", "preBindPage", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "preBindTiming", "f", "preBindCountResume", "b", "preBindInstantEnd", "d", "preBindCountLoadMore", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "preBindCountUserBehavior", "c", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("pre_bind_count_load_more")
    private final Integer preBindCountLoadMore;

    @SerializedName("pre_bind_count_resume")
    private final Integer preBindCountResume;

    @SerializedName("pre_bind_count_user_behavior")
    private final Integer preBindCountUserBehavior;

    @SerializedName("pre_bind_instant_end")
    private final Integer preBindInstantEnd;

    @SerializedName("pre_bind_page")
    private final Integer preBindPage;

    @SerializedName("pre_bind_timing")
    private final Integer preBindTiming;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.preBindPage, r101.preBindPage) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.preBindTiming, r101.preBindTiming) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preBindCountResume, r101.preBindCountResume) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preBindInstantEnd, r101.preBindInstantEnd) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.preBindCountLoadMore, r101.preBindCountLoadMore) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.preBindCountUserBehavior, r101.preBindCountUserBehavior) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.preBindPage;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.preBindTiming;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.preBindCountResume;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.preBindInstantEnd;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.preBindCountLoadMore;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.preBindCountUserBehavior;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallPreBindSetting(preBindPage=" + this.preBindPage + ", preBindTiming=" + this.preBindTiming + ", preBindCountResume=" + this.preBindCountResume + ", preBindInstantEnd=" + this.preBindInstantEnd + ", preBindCountLoadMore=" + this.preBindCountLoadMore + ", preBindCountUserBehavior=" + this.preBindCountUserBehavior + ")";
    }

    public final Integer a() {
        return this.preBindCountLoadMore;
    }

    public final Integer b() {
        return this.preBindCountResume;
    }

    public final Integer c() {
        return this.preBindCountUserBehavior;
    }

    public final Integer d() {
        return this.preBindInstantEnd;
    }

    public final Integer e() {
        return this.preBindPage;
    }

    public final Integer f() {
        return this.preBindTiming;
    }

    public c(int r100) {
        this.preBindPage = null;
        this.preBindTiming = null;
        this.preBindCountResume = null;
        this.preBindInstantEnd = null;
        this.preBindCountLoadMore = null;
        this.preBindCountUserBehavior = null;
    }
}
