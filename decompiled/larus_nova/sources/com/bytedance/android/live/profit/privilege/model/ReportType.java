package com.bytedance.android.live.profit.privilege.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/ReportType;", "", "", "value", "J", "getValue", "()J", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "SINGLE_SHOT", "MULTI_SHOT", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReportType extends Enum<ReportType> {
    public static final a Companion = null;
    public static final ReportType MULTI_SHOT = null;
    public static final ReportType SINGLE_SHOT = null;
    public static final ReportType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportType[] f88416a = null;
    private final long value;

    public static final class a {
        public a() {
        }

        public static ReportType a(long r100) {
            ReportType[] r101 = ReportType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            ReportType r104 = r101[r103];
            if (r104.getValue() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return ReportType.Unknown;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    static {
        ReportType r100 = new ReportType("Unknown", 0, -1);
        Unknown = r100;
        ReportType r101 = new ReportType("SINGLE_SHOT", 1, 0);
        SINGLE_SHOT = r101;
        ReportType r102 = new ReportType("MULTI_SHOT", 2, 1);
        MULTI_SHOT = r102;
        f88416a = new ReportType[]{r100, r101, r102};
        Companion = new a();
    }

    public static ReportType valueOf(String r100) {
        return (ReportType) r27.a.a(ReportType.class, r100);
    }

    public static ReportType[] values() {
        return (ReportType[]) f88416a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public ReportType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
