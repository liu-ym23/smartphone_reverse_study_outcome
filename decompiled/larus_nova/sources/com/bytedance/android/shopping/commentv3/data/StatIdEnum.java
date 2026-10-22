package com.bytedance.android.shopping.commentv3.data;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/StatIdEnum;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "INVALID", AccountType.ALL, "PIC_VIDEO", "VERY_GOOD", "JUST_SO_SO", "APPEND_COMMENT", "BAD", "NEWEST", "JUST_SO_SO_OR_BAD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StatIdEnum extends Enum<StatIdEnum> {
    public static final StatIdEnum ALL = null;
    public static final StatIdEnum APPEND_COMMENT = null;
    public static final StatIdEnum BAD = null;
    public static final StatIdEnum INVALID = null;
    public static final StatIdEnum JUST_SO_SO = null;
    public static final StatIdEnum JUST_SO_SO_OR_BAD = null;
    public static final StatIdEnum NEWEST = null;
    public static final StatIdEnum PIC_VIDEO = null;
    public static final StatIdEnum VERY_GOOD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StatIdEnum[] f172732a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f172733id;

    public static StatIdEnum valueOf(String r100) {
        return (StatIdEnum) r27.a.a(StatIdEnum.class, r100);
    }

    public static StatIdEnum[] values() {
        return (StatIdEnum[]) f172732a.clone();
    }

    static {
        StatIdEnum r100 = new StatIdEnum("INVALID", 0, -1);
        INVALID = r100;
        StatIdEnum r101 = new StatIdEnum(AccountType.ALL, 1, 1);
        ALL = r101;
        StatIdEnum r102 = new StatIdEnum("PIC_VIDEO", 2, 2);
        PIC_VIDEO = r102;
        StatIdEnum r103 = new StatIdEnum("VERY_GOOD", 3, 3);
        VERY_GOOD = r103;
        StatIdEnum r104 = new StatIdEnum("JUST_SO_SO", 4, 4);
        JUST_SO_SO = r104;
        StatIdEnum r105 = new StatIdEnum("APPEND_COMMENT", 5, 5);
        APPEND_COMMENT = r105;
        StatIdEnum r106 = new StatIdEnum("BAD", 6, 6);
        BAD = r106;
        StatIdEnum r107 = new StatIdEnum("NEWEST", 7, 7);
        NEWEST = r107;
        StatIdEnum r108 = new StatIdEnum("JUST_SO_SO_OR_BAD", 8, 8);
        JUST_SO_SO_OR_BAD = r108;
        f172732a = new StatIdEnum[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final long getId() {
        return this.f172733id;
    }

    public final void setId(long r100) {
        this.f172733id = r100;
    }

    public StatIdEnum(String r100, int r101, long r102) {
        super(r100, r101);
        this.f172733id = r102;
    }
}
