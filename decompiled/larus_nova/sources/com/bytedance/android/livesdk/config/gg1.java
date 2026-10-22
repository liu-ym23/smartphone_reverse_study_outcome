package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/config/gg1;", "", "", "anchorPreviewAddPoiDialogWhite", "Z", "getAnchorPreviewAddPoiDialogWhite", "()Z", "setAnchorPreviewAddPoiDialogWhite", "(Z)V", "anchorPoiSuccessToastEnable", "getAnchorPoiSuccessToastEnable", "setAnchorPoiSuccessToastEnable", "anchorMoreItemPopupEnable", "getAnchorMoreItemPopupEnable", "setAnchorMoreItemPopupEnable", "anchorRoomIntroLocalLifePoiEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnchorRoomIntroLocalLifePoiEnable", "anchorMorePanelLocationEnable", "getAnchorMorePanelLocationEnable", "setAnchorMorePanelLocationEnable", "publicScreenRoomIntroLocalLifePoiEnable", "b", "setPublicScreenRoomIntroLocalLifePoiEnable", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gg1 {

    @SerializedName("anchor_more_item_popup_enable")
    private boolean anchorMoreItemPopupEnable;

    @SerializedName("anchor_more_panel_location_enable")
    private boolean anchorMorePanelLocationEnable;

    @SerializedName("anchor_poi_success_toast_enable")
    private boolean anchorPoiSuccessToastEnable;

    @SerializedName("anchor_preview_add_poi_dialog_white")
    private boolean anchorPreviewAddPoiDialogWhite;

    @SerializedName("anchor_room_intro_local_life_poi_enable")
    private boolean anchorRoomIntroLocalLifePoiEnable;

    @SerializedName("public_screen_room_intro_local_life_poi_enable")
    private boolean publicScreenRoomIntroLocalLifePoiEnable;

    public gg1() {
        this.anchorPreviewAddPoiDialogWhite = true;
        this.anchorPoiSuccessToastEnable = true;
        this.anchorMoreItemPopupEnable = true;
        this.anchorRoomIntroLocalLifePoiEnable = true;
        this.anchorMorePanelLocationEnable = true;
        this.publicScreenRoomIntroLocalLifePoiEnable = true;
    }

    public final boolean a() {
        return this.anchorRoomIntroLocalLifePoiEnable;
    }

    public final boolean b() {
        return this.publicScreenRoomIntroLocalLifePoiEnable;
    }
}
