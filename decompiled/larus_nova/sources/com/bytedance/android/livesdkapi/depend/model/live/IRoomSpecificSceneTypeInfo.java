package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0003\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "Lvh7/c;", "", "isLandscapeVerticalRoom", "()I", "isLandscapeVerticalRoom$annotations", "()V", "", "isUnionLiveRoom", "()Z", "isUnionLiveRoom$annotations", "isLife", "isLife$annotations", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomSpecificSceneTypeInfo extends c<IRoomSpecificSceneTypeInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "is_sub_orientation_vertical_room")
        public static /* synthetic */ void isLandscapeVerticalRoom$annotations() {
        }

        @FieldName(name = "is_life")
        public static /* synthetic */ void isLife$annotations() {
        }

        @FieldName(name = "is_union_live_room")
        public static /* synthetic */ void isUnionLiveRoom$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "is_sub_orientation_vertical_room")
    int isLandscapeVerticalRoom();

    @FieldName(name = "is_life")
    boolean isLife();

    @FieldName(name = "is_union_live_room")
    boolean isUnionLiveRoom();
}
