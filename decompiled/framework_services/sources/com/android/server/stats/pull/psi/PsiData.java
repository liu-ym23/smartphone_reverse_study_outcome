package com.android.server.stats.pull.psi;

/* JADX INFO: loaded from: classes3.dex */
public class PsiData {
    private final AppsStallInfo mFullAppsStallInfo;
    private final ResourceType mResourceType;
    private final AppsStallInfo mSomeAppsStallInfo;

    static class AppsStallInfo {
        private final float mAvg10SecPercentage;
        private final float mAvg300SecPercentage;
        private final float mAvg60SecPercentage;
        private final long mTotalUsec;

        /* JADX INFO: renamed from: -$$Nest$fgetmAvg10SecPercentage, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m8370$$Nest$fgetmAvg10SecPercentage(AppsStallInfo r0) {
            return r0.mAvg10SecPercentage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAvg300SecPercentage, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m8371$$Nest$fgetmAvg300SecPercentage(AppsStallInfo r0) {
            return r0.mAvg300SecPercentage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAvg60SecPercentage, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m8372$$Nest$fgetmAvg60SecPercentage(AppsStallInfo r0) {
            return r0.mAvg60SecPercentage;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTotalUsec, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m8373$$Nest$fgetmTotalUsec(AppsStallInfo r2) {
            return r2.mTotalUsec;
        }

        AppsStallInfo(float avg10SecPercentage, float avg60SecPercentage, float avg300SecPercentage, long totalUsec) {
            this.mAvg10SecPercentage = avg10SecPercentage;
            this.mAvg60SecPercentage = avg60SecPercentage;
            this.mAvg300SecPercentage = avg300SecPercentage;
            this.mTotalUsec = totalUsec;
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> {
        private static final /* synthetic */ ResourceType[] $VALUES = null;
        public static final ResourceType CPU = null;
        public static final ResourceType IO = null;
        public static final ResourceType MEMORY = null;

        private static /* synthetic */ ResourceType[] $values() {
            return new ResourceType[]{CPU, MEMORY, IO};
        }

        private ResourceType(String r1, int r2) {
            super(r1, r2);
        }

        public static ResourceType valueOf(String name) {
            return (ResourceType) Enum.valueOf(ResourceType.class, name);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) $VALUES.clone();
        }

        static {
            CPU = new ResourceType("CPU", 0);
            MEMORY = new ResourceType("MEMORY", 1);
            IO = new ResourceType("IO", 2);
            $VALUES = $values();
        }
    }

    PsiData(ResourceType resourceType, AppsStallInfo someAppsStallInfo, AppsStallInfo fullAppsStallInfo) {
        this.mResourceType = resourceType;
        this.mSomeAppsStallInfo = someAppsStallInfo;
        this.mFullAppsStallInfo = fullAppsStallInfo;
    }

    public ResourceType getResourceType() {
        return this.mResourceType;
    }

    public float getSomeAvg10SecPercentage() {
        return AppsStallInfo.m8370$$Nest$fgetmAvg10SecPercentage(this.mSomeAppsStallInfo);
    }

    public float getSomeAvg60SecPercentage() {
        return AppsStallInfo.m8372$$Nest$fgetmAvg60SecPercentage(this.mSomeAppsStallInfo);
    }

    public float getSomeAvg300SecPercentage() {
        return AppsStallInfo.m8371$$Nest$fgetmAvg300SecPercentage(this.mSomeAppsStallInfo);
    }

    public long getSomeTotalUsec() {
        return AppsStallInfo.m8373$$Nest$fgetmTotalUsec(this.mSomeAppsStallInfo);
    }

    public float getFullAvg10SecPercentage() {
        return AppsStallInfo.m8370$$Nest$fgetmAvg10SecPercentage(this.mFullAppsStallInfo);
    }

    public float getFullAvg60SecPercentage() {
        return AppsStallInfo.m8372$$Nest$fgetmAvg60SecPercentage(this.mFullAppsStallInfo);
    }

    public float getFullAvg300SecPercentage() {
        return AppsStallInfo.m8371$$Nest$fgetmAvg300SecPercentage(this.mFullAppsStallInfo);
    }

    public long getFullTotalUsec() {
        return AppsStallInfo.m8373$$Nest$fgetmTotalUsec(this.mFullAppsStallInfo);
    }
}
