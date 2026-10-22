package com.bytedance.android.livehostapi.business.depend.hashtag;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHashTagParams {
    private final long anchorId;
    private final LiveCircleHashTag currentCircleHashTag;
    private final LiveHashTag currentHashTag;
    private final String entranceType;
    private final String functionType;
    private final boolean isLiving;
    private final String liveType;
    private boolean needLoadCircleData;
    private final String recommendId;
    private final String roomId;

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.hashtag.LiveHashTagParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private long anchorId;
        private LiveHashTag currentHashTag;
        private LiveCircleHashTag currentLiveHashTag;
        private String entranceType;
        private String functionType;
        private boolean isLiving;
        private String liveType;
        private boolean needLoadCircleData;
        private String recommendId;
        private String roomId;

        public LiveHashTagParams build() {
            return new LiveHashTagParams(this.roomId, this.currentHashTag, this.currentLiveHashTag, this.isLiving, this.needLoadCircleData, this.entranceType, this.recommendId, this.anchorId, this.liveType, this.functionType, null);
        }

        public Builder() {
            this.recommendId = "";
            this.needLoadCircleData = false;
            this.anchorId = 0;
            this.liveType = "";
            this.functionType = "";
        }

        public Builder setAnchorId(long r100) {
            this.anchorId = r100;
            return this;
        }

        public Builder setCurrentCircleHashTag(LiveCircleHashTag r100) {
            this.currentLiveHashTag = r100;
            return this;
        }

        public Builder setCurrentHashTag(LiveHashTag r100) {
            this.currentHashTag = r100;
            return this;
        }

        public Builder setEntranceType(String r100) {
            this.entranceType = r100;
            return this;
        }

        public Builder setFunctionType(String r100) {
            this.functionType = r100;
            return this;
        }

        public Builder setIsLiving(boolean r100) {
            this.isLiving = r100;
            return this;
        }

        public Builder setLiveType(String r100) {
            this.liveType = r100;
            return this;
        }

        public Builder setNeedLoadCircleData(boolean r100) {
            this.needLoadCircleData = r100;
            return this;
        }

        public Builder setRecommendId(String r100) {
            this.recommendId = r100;
            return this;
        }

        public Builder setRoomId(String r100) {
            this.roomId = r100;
            return this;
        }
    }

    public Boolean getNeedLoadCircleData() {
        return Boolean.valueOf(this.needLoadCircleData);
    }

    public long getAnchorId() {
        return this.anchorId;
    }

    public LiveCircleHashTag getCurrentCircleHashTag() {
        return this.currentCircleHashTag;
    }

    public LiveHashTag getCurrentHashTag() {
        return this.currentHashTag;
    }

    public String getEntranceType() {
        return this.entranceType;
    }

    public String getFunctionType() {
        return this.functionType;
    }

    public String getLiveType() {
        return this.liveType;
    }

    public String getRecommendId() {
        return this.recommendId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public boolean isLiving() {
        return this.isLiving;
    }

    private LiveHashTagParams(String r100, LiveHashTag r101, LiveCircleHashTag r102, boolean r103, boolean r104, String r105, String r106, long r107, String r110, String r111) {
        this.roomId = r100;
        this.currentHashTag = r101;
        this.currentCircleHashTag = r102;
        this.isLiving = r103;
        this.entranceType = r105;
        this.recommendId = r106;
        this.needLoadCircleData = r104;
        this.anchorId = r107;
        this.liveType = r110;
        this.functionType = r111;
    }

    public /* synthetic */ LiveHashTagParams(String r100, LiveHashTag r101, LiveCircleHashTag r102, boolean r103, boolean r104, String r105, String r106, long r107, String r110, String r111, AnonymousClass1 r112) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111);
    }
}
