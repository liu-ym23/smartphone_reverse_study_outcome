package com.bytedance.android.livesdk.ktvapi.concert_stage.enums;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/concert_stage/enums/ConcertBizIdType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LINK_SERVICE", "TUNING", "CHORUS", "UNKNOWN", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ConcertBizIdType extends Enum<ConcertBizIdType> {
    public static final ConcertBizIdType CHORUS = null;
    public static final a Companion = null;
    public static final ConcertBizIdType LINK_SERVICE = null;
    public static final ConcertBizIdType TUNING = null;
    public static final ConcertBizIdType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConcertBizIdType[] f142295a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static ConcertBizIdType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            ConcertBizIdType[] r101 = ConcertBizIdType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            ConcertBizIdType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return ConcertBizIdType.UNKNOWN;
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
        ConcertBizIdType r100 = new ConcertBizIdType("LINK_SERVICE", 0, "link_service");
        LINK_SERVICE = r100;
        ConcertBizIdType r101 = new ConcertBizIdType("TUNING", 1, "tuning");
        TUNING = r101;
        ConcertBizIdType r102 = new ConcertBizIdType("CHORUS", 2, "chorus");
        CHORUS = r102;
        ConcertBizIdType r103 = new ConcertBizIdType("UNKNOWN", 3, "unknown");
        UNKNOWN = r103;
        f142295a = new ConcertBizIdType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static ConcertBizIdType valueOf(String r100) {
        return (ConcertBizIdType) r27.a.a(ConcertBizIdType.class, r100);
    }

    public static ConcertBizIdType[] values() {
        return (ConcertBizIdType[]) f142295a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ConcertBizIdType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
