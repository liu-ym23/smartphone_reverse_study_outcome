package com.bytedance.android.live.base.model.message;

import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.larus.dora.api.model.FlowDoraWifiScene;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface ITextPieceImage extends vh7.c<ITextPieceImage> {

    public static final enum ExtraOpt extends Enum<ExtraOpt> {
        public static final ExtraOpt NONE = null;
        public static final ExtraOpt OTHER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExtraOpt[] f58851a = null;

        static {
            ExtraOpt r100 = new ExtraOpt(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ExtraOpt r101 = new ExtraOpt(FlowDoraWifiScene.OTHER, 1);
            OTHER = r101;
            f58851a = new ExtraOpt[]{r100, r101};
        }

        public static ExtraOpt[] values() {
            return (ExtraOpt[]) f58851a.clone();
        }

        public static ExtraOpt valueOf(String r100) {
            return (ExtraOpt) r27.a.a(ExtraOpt.class, r100);
        }

        public ExtraOpt(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ResourceType extends Enum<ResourceType> {
        public static final ResourceType Local = null;
        public static final ResourceType NetWork = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResourceType[] f58852a = null;

        static {
            ResourceType r100 = new ResourceType(CloudSearch.SearchBound.LOCAL_SHAPE, 0);
            Local = r100;
            ResourceType r101 = new ResourceType("NetWork", 1);
            NetWork = r101;
            f58852a = new ResourceType[]{r100, r101};
        }

        public static ResourceType[] values() {
            return (ResourceType[]) f58852a.clone();
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) r27.a.a(ResourceType.class, r100);
        }

        public ResourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ScaleType extends Enum<ScaleType> {
        public static final ScaleType DEFAULT = null;
        public static final ScaleType FIT_TEXT_SIZE = null;
        public static final ScaleType FIT_TEXT_SIZE_CENTER_CANVAS = null;
        public static final ScaleType FIT_Y = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScaleType[] f58853a = null;

        static {
            ScaleType r100 = new ScaleType("DEFAULT", 0);
            DEFAULT = r100;
            ScaleType r101 = new ScaleType("FIT_Y", 1);
            FIT_Y = r101;
            ScaleType r102 = new ScaleType("FIT_TEXT_SIZE", 2);
            FIT_TEXT_SIZE = r102;
            ScaleType r103 = new ScaleType("FIT_TEXT_SIZE_CENTER_CANVAS", 3);
            FIT_TEXT_SIZE_CENTER_CANVAS = r103;
            f58853a = new ScaleType[]{r100, r101, r102, r103};
        }

        public static ScaleType[] values() {
            return (ScaleType[]) f58853a.clone();
        }

        public static ScaleType valueOf(String r100) {
            return (ScaleType) r27.a.a(ScaleType.class, r100);
        }

        public ScaleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    ITextPieceImage doClone();

    boolean getEnableTextWhenFailed();

    ExtraOpt getExtraOpt();

    int getHeight();

    py.k getImageModel();

    int getLocalResId();

    ResourceType getResourceType();

    ScaleType getScaleType();

    float getScaleX();

    float getScaleY();

    float getScalingRate();

    int getWidth();

    boolean isNeedExtraSpace();

    void setEnableTextWhenFailed(boolean r100);

    void setExtraOpt(ExtraOpt r100);

    void setHeight(int r100);

    void setImageModel(py.k r100);

    void setLocalResId(int r100);

    void setNeedExtraSpace(boolean r100);

    void setResourceType(ResourceType r100);

    void setScaleType(ScaleType r100);

    void setScaleX(float r100);

    void setScaleY(float r100);

    void setScalingRate(float r100);

    void setWidth(int r100);
}
