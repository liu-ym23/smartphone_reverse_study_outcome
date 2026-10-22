package com.bytedance.android.gamecp.host_api.cloudgame;

import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
public interface IFeatureService {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/cloudgame/IFeatureService$FeatureType;", "", "", "value", "I", "getValue", "()I", "STATIC", BannerBizName.DYNAMIC, "MONITOR", "DYNAMIC_MONITOR", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FeatureType extends Enum<FeatureType> {
        public static final FeatureType DYNAMIC = null;
        public static final FeatureType DYNAMIC_MONITOR = null;
        public static final FeatureType MONITOR = null;
        public static final FeatureType STATIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeatureType[] f57358a = null;
        private final int value;

        static {
            FeatureType r100 = new FeatureType("STATIC", 0, 0);
            STATIC = r100;
            FeatureType r101 = new FeatureType(BannerBizName.DYNAMIC, 1, 1);
            DYNAMIC = r101;
            FeatureType r102 = new FeatureType("MONITOR", 2, -1);
            MONITOR = r102;
            FeatureType r103 = new FeatureType("DYNAMIC_MONITOR", 3, 2);
            DYNAMIC_MONITOR = r103;
            f57358a = new FeatureType[]{r100, r101, r102, r103};
        }

        public static FeatureType valueOf(String r100) {
            return (FeatureType) a.a(FeatureType.class, r100);
        }

        public static FeatureType[] values() {
            return (FeatureType[]) f57358a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public FeatureType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    void a();
}
