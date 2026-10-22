package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewEtData;", "Lvh7/c;", "", "getEnterRoom", "()Ljava/lang/String;", "getEnterRoom$annotations", "()V", "enterRoom", "getMobParams", "getMobParams$annotations", "mobParams", "getParams", "getParams$annotations", "params", "getFirstRoomParams", "getFirstRoomParams$annotations", "firstRoomParams", "getFirstRoomMobParams", "getFirstRoomMobParams$annotations", "firstRoomMobParams", "getFirstShowRoomParams", "getFirstShowRoomParams$annotations", "firstShowRoomParams", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPreviewEtData extends c<IPreviewEtData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "type_enter_room")
        public static /* synthetic */ void getEnterRoom$annotations() {
        }

        @FieldName(name = "type_first_room_mob_params")
        public static /* synthetic */ void getFirstRoomMobParams$annotations() {
        }

        @FieldName(name = "type_first_room_params")
        public static /* synthetic */ void getFirstRoomParams$annotations() {
        }

        @FieldName(name = "type_first_show_room_params")
        public static /* synthetic */ void getFirstShowRoomParams$annotations() {
        }

        @FieldName(name = "type_mob_params")
        public static /* synthetic */ void getMobParams$annotations() {
        }

        @FieldName(name = "type_params")
        public static /* synthetic */ void getParams$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "type_enter_room")
    String getEnterRoom();

    @FieldName(name = "type_first_room_mob_params")
    String getFirstRoomMobParams();

    @FieldName(name = "type_first_room_params")
    String getFirstRoomParams();

    @FieldName(name = "type_first_show_room_params")
    String getFirstShowRoomParams();

    @FieldName(name = "type_mob_params")
    String getMobParams();

    @FieldName(name = "type_params")
    String getParams();
}
