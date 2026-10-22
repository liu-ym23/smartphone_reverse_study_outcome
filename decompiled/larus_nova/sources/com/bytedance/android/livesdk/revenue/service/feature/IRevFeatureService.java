package com.bytedance.android.livesdk.revenue.service.feature;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
public interface IRevFeatureService extends dy0.a {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/feature/IRevFeatureService$RevFeatureType;", "", "", "value", "I", "getValue", "()I", "STATIC", BannerBizName.DYNAMIC, "MONITOR", "DYNAMIC_MONITOR", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RevFeatureType extends Enum<RevFeatureType> {
        public static final RevFeatureType DYNAMIC = null;
        public static final RevFeatureType DYNAMIC_MONITOR = null;
        public static final RevFeatureType MONITOR = null;
        public static final RevFeatureType STATIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RevFeatureType[] f157314a = null;
        private final int value;

        static {
            RevFeatureType r100 = new RevFeatureType("STATIC", 0, 0);
            STATIC = r100;
            RevFeatureType r101 = new RevFeatureType(BannerBizName.DYNAMIC, 1, 1);
            DYNAMIC = r101;
            RevFeatureType r102 = new RevFeatureType("MONITOR", 2, -1);
            MONITOR = r102;
            RevFeatureType r103 = new RevFeatureType("DYNAMIC_MONITOR", 3, 2);
            DYNAMIC_MONITOR = r103;
            f157314a = new RevFeatureType[]{r100, r101, r102, r103};
        }

        public static RevFeatureType valueOf(String r100) {
            return (RevFeatureType) r27.a.a(RevFeatureType.class, r100);
        }

        public static RevFeatureType[] values() {
            return (RevFeatureType[]) f157314a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public RevFeatureType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    String getPortrait(String r100);

    boolean nb(String r100, Object r101, RevFeatureType r102);
}
