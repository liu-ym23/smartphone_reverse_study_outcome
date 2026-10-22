package bl2;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b@\u0010AR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lbl2/c;", "", "", "couponMetaId", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setCouponMetaId", "(Ljava/lang/String;)V", "couponId", "c", "setCouponId", "", "countDown", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setCountDown", "(J)V", "credit", "f", "setCredit", "threshold", "l", "setThreshold", "name", RXScreenCaptureService.KEY_INDEX, "setName", "validScene", "m", "setValidScene", "validTime", OfficeSDKRequestTag.KEY_NEW_USER, "setValidTime", "", "hasApplied", "Z", "h", "()Z", "setHasApplied", "(Z)V", "prizeActivityId", ce.f26395j, "setPrizeActivityId", "prizeId", ce.f26396k, "setPrizeId", "couponKey", "d", "setCouponKey", "Lbl2/c$a;", "discountInfo", "Lbl2/c$a;", ce.f26391f, "()Lbl2/c$a;", "setDiscountInfo", "(Lbl2/c$a;)V", "", "couponDiscountType", "I", "b", "()I", "setCouponDiscountType", "(I)V", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("count_down")
    private long countDown;

    @SerializedName("coupon_discount_type")
    private int couponDiscountType;

    @SerializedName("coupon_id")
    private String couponId;

    @SerializedName("coupon_key")
    private String couponKey;

    @SerializedName("coupon_meta_id")
    private String couponMetaId;

    @SerializedName("credit")
    private long credit;

    @SerializedName("discount_info")
    private a discountInfo;

    @SerializedName("has_applied")
    private boolean hasApplied;

    @SerializedName("name")
    private String name;

    @SerializedName("prize_activity_id")
    private String prizeActivityId;

    @SerializedName("prize_id")
    private String prizeId;

    @SerializedName("threshold")
    private long threshold;

    @SerializedName("valid_scene")
    private String validScene;

    @SerializedName("valid_time")
    private String validTime;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lbl2/c$a;", "", "", "discount", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "setDiscount", "(Ljava/lang/Long;)V", "maxCreditLimit", "b", "setMaxCreditLimit", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("discount")
        private Long discount;

        @SerializedName("max_credit_limit")
        private Long maxCreditLimit;

        public a() {
        }

        public final Long a() {
            return this.discount;
        }

        public final Long b() {
            return this.maxCreditLimit;
        }
    }

    public c() {
    }

    public final long a() {
        return this.countDown;
    }

    public final int b() {
        return this.couponDiscountType;
    }

    public final String c() {
        return this.couponId;
    }

    public final String d() {
        return this.couponKey;
    }

    public final String e() {
        return this.couponMetaId;
    }

    public final long f() {
        return this.credit;
    }

    public final a g() {
        return this.discountInfo;
    }

    public final boolean h() {
        return this.hasApplied;
    }

    public final String i() {
        return this.name;
    }

    public final String j() {
        return this.prizeActivityId;
    }

    public final String k() {
        return this.prizeId;
    }

    public final long l() {
        return this.threshold;
    }

    public final String m() {
        return this.validScene;
    }

    public final String n() {
        return this.validTime;
    }
}
