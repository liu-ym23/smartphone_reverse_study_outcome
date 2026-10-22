package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001c\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010'\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R$\u0010+\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\b\u001a\u0004\b(\u0010\u0004\"\u0004\b)\u0010\u0006R\"\u0010/\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\b\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\"\u00103\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\b\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R$\u0010:\u001a\u0004\u0018\u0001048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\b\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010>\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\b\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R$\u0010B\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\b\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!¨\u0006C"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;", "getGameClip", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;", "setGameClip", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IClip;)V", "getGameClip$annotations", "()V", "gameClip", "getCameraClip", "setCameraClip", "getCameraClip$annotations", "cameraClip", "", "getCameraHidden", "()I", "setCameraHidden", "(I)V", "getCameraHidden$annotations", "cameraHidden", "getDisplayMode", "setDisplayMode", "getDisplayMode$annotations", "displayMode", "getGameHidden", "setGameHidden", "getGameHidden$annotations", "gameHidden", "", "getGameRoomIdStr", "()Ljava/lang/String;", "setGameRoomIdStr", "(Ljava/lang/String;)V", "getGameRoomIdStr$annotations", "gameRoomIdStr", "getLayout", "setLayout", "getLayout$annotations", "layout", "getCameraClipCustom", "setCameraClipCustom", "getCameraClipCustom$annotations", "cameraClipCustom", "getCameraVerticalType", "setCameraVerticalType", "getCameraVerticalType$annotations", "cameraVerticalType", "getCameraHorizontalType", "setCameraHorizontalType", "getCameraHorizontalType$annotations", "cameraHorizontalType", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;", "getCameraHorizontalPosition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;", "setCameraHorizontalPosition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData$ICameraHorizontalPosition;)V", "getCameraHorizontalPosition$annotations", "cameraHorizontalPosition", "getCameraHorizontalHidden", "setCameraHorizontalHidden", "getCameraHorizontalHidden$annotations", "cameraHorizontalHidden", "getMultiViewData", "setMultiViewData", "getMultiViewData$annotations", "multiViewData", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IExtension extends c<IExtension> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "camera_clip")
        public static /* synthetic */ void getCameraClip$annotations() {
        }

        @FieldName(name = "camera_clip_custom")
        public static /* synthetic */ void getCameraClipCustom$annotations() {
        }

        @FieldName(name = "camera_hidden")
        public static /* synthetic */ void getCameraHidden$annotations() {
        }

        @FieldName(name = "camera_horizontal_hidden")
        public static /* synthetic */ void getCameraHorizontalHidden$annotations() {
        }

        @FieldName(name = "camera_horizontal_position")
        public static /* synthetic */ void getCameraHorizontalPosition$annotations() {
        }

        @FieldName(name = "camera_horizontal_type")
        public static /* synthetic */ void getCameraHorizontalType$annotations() {
        }

        @FieldName(name = "camera_vertical_type")
        public static /* synthetic */ void getCameraVerticalType$annotations() {
        }

        @FieldName(name = "display_mode")
        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        @FieldName(name = "game_clip")
        public static /* synthetic */ void getGameClip$annotations() {
        }

        @FieldName(name = "game_hidden")
        public static /* synthetic */ void getGameHidden$annotations() {
        }

        @FieldName(name = "game_room_id")
        public static /* synthetic */ void getGameRoomIdStr$annotations() {
        }

        @FieldName(name = "layout")
        public static /* synthetic */ void getLayout$annotations() {
        }

        @FieldName(name = "multi_view_data")
        public static /* synthetic */ void getMultiViewData$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "camera_clip")
    IClip getCameraClip();

    @FieldName(name = "camera_clip_custom")
    IClip getCameraClipCustom();

    @FieldName(name = "camera_hidden")
    int getCameraHidden();

    @FieldName(name = "camera_horizontal_hidden")
    int getCameraHorizontalHidden();

    @FieldName(name = "camera_horizontal_position")
    ILiveCoreSDKData.ICameraHorizontalPosition getCameraHorizontalPosition();

    @FieldName(name = "camera_horizontal_type")
    int getCameraHorizontalType();

    @FieldName(name = "camera_vertical_type")
    int getCameraVerticalType();

    @FieldName(name = "display_mode")
    int getDisplayMode();

    @FieldName(name = "game_clip")
    IClip getGameClip();

    @FieldName(name = "game_hidden")
    int getGameHidden();

    @FieldName(name = "game_room_id")
    String getGameRoomIdStr();

    @FieldName(name = "layout")
    int getLayout();

    @FieldName(name = "multi_view_data")
    String getMultiViewData();

    @FieldName(name = "camera_clip#setter")
    void setCameraClip(IClip r100);

    @FieldName(name = "camera_clip_custom#setter")
    void setCameraClipCustom(IClip r100);

    @FieldName(name = "camera_hidden#setter")
    void setCameraHidden(int r100);

    @FieldName(name = "camera_horizontal_hidden#setter")
    void setCameraHorizontalHidden(int r100);

    @FieldName(name = "camera_horizontal_position#setter")
    void setCameraHorizontalPosition(ILiveCoreSDKData.ICameraHorizontalPosition r100);

    @FieldName(name = "camera_horizontal_type#setter")
    void setCameraHorizontalType(int r100);

    @FieldName(name = "camera_vertical_type#setter")
    void setCameraVerticalType(int r100);

    @FieldName(name = "display_mode#setter")
    void setDisplayMode(int r100);

    @FieldName(name = "game_clip#setter")
    void setGameClip(IClip r100);

    @FieldName(name = "game_hidden#setter")
    void setGameHidden(int r100);

    @FieldName(name = "game_room_id#setter")
    void setGameRoomIdStr(String r100);

    @FieldName(name = "layout#setter")
    void setLayout(int r100);

    @FieldName(name = "multi_view_data#setter")
    void setMultiViewData(String r100);
}
