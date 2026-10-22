package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.toolbar.IToolbarPermutation;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\u0006R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014R:\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010!\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\"8&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\n\u001a\u0004\b#\u0010$R\u001c\u0010+\u001a\u0004\u0018\u00010'8&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\n\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IToolbarComponentData;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getToolbarDataList", "()Ljava/util/List;", "setToolbarDataList", "(Ljava/util/List;)V", "getToolbarDataList$annotations", "()V", "toolbarDataList", "getMorePanelDataList", "getMorePanelDataList$annotations", "morePanelDataList", "getLandScapeTop", "getLandScapeTop$annotations", "landScapeTop", "", "getMaxCount", "()Ljava/lang/Integer;", "getMaxCount$annotations", "maxCount", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IToolbarComponentSkin;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getSkinResource", "()Ljava/util/Map;", "getSkinResource$annotations", "skinResource", "getMaxCountLandscape", "()I", "getMaxCountLandscape$annotations", "maxCountLandscape", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarPermutation;", "getRules", "()Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarPermutation;", "getRules$annotations", "rules", "Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarExtraInfo;", "getExtraInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/toolbar/IToolbarExtraInfo;", "getExtraInfo$annotations", "extraInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILiveToolbarData extends c<ILiveToolbarData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "extra_info")
        public static /* synthetic */ void getExtraInfo$annotations() {
        }

        @FieldName(name = "landscape_up_right")
        public static /* synthetic */ void getLandScapeTop$annotations() {
        }

        @FieldName(name = "max_entrance_cnt")
        public static /* synthetic */ void getMaxCount$annotations() {
        }

        @FieldName(name = "max_entrance_cnt_landscape")
        public static /* synthetic */ void getMaxCountLandscape$annotations() {
        }

        @FieldName(name = "more_panel")
        public static /* synthetic */ void getMorePanelDataList$annotations() {
        }

        @FieldName(name = "permutation")
        public static /* synthetic */ void getRules$annotations() {
        }

        @FieldName(name = "skin_resource")
        public static /* synthetic */ void getSkinResource$annotations() {
        }

        @FieldName(name = "entrance_list")
        public static /* synthetic */ void getToolbarDataList$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "extra_info")
    IToolbarExtraInfo getExtraInfo();

    @FieldName(name = "landscape_up_right")
    List<IToolbarComponentData> getLandScapeTop();

    @FieldName(name = "max_entrance_cnt")
    Integer getMaxCount();

    @FieldName(name = "max_entrance_cnt_landscape")
    int getMaxCountLandscape();

    @FieldName(name = "more_panel")
    List<IToolbarComponentData> getMorePanelDataList();

    @FieldName(name = "permutation")
    IToolbarPermutation getRules();

    @FieldName(name = "skin_resource")
    Map<Integer, IToolbarComponentSkin> getSkinResource();

    @FieldName(name = "entrance_list")
    List<IToolbarComponentData> getToolbarDataList();

    @FieldName(name = "entrance_list#setter")
    void setToolbarDataList(List<? extends IToolbarComponentData> r100);
}
