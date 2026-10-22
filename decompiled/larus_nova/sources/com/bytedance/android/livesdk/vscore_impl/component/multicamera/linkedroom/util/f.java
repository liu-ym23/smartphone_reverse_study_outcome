package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.util;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
public class f {

    @SerializedName("entry_linked_room_sub_title_text")
    public String entryLinkRoomSubTitle;

    @SerializedName("entry_linked_room_title_text")
    public String entryLinkRoomTitle;

    @SerializedName("entry_multi_camera_sub_title_text")
    public String multiCameraSubTitle;

    @SerializedName("entry_multi_camera_title_text")
    public String multiCameraTitle;

    @SerializedName("vs_camera_infos")
    public List<VSCameraInfo> vsCameraInfo;

    public f() {
    }
}
