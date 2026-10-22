package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.liveinteract.plantform.model.k;
import com.bytedance.android.live.liveinteract.plantform.model.k0;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkmicMediaParamDef;", "", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getLinkmicMediaInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getLinkmicMediaInfo$annotations", "()V", "linkmicMediaInfo", "", "getLinkmicMediaType", "()I", "getLinkmicMediaType$annotations", "linkmicMediaType", "Lcom/bytedance/android/live/liveinteract/plantform/model/k;", "getLinkMediaInfoForEnterRoom", "()Lcom/bytedance/android/live/liveinteract/plantform/model/k;", "getLinkMediaInfoForEnterRoom$annotations", "linkMediaInfoForEnterRoom", "Lcom/bytedance/android/live/liveinteract/plantform/model/k0;", "getUpdateMediaInfoNotify", "()Lcom/bytedance/android/live/liveinteract/plantform/model/k0;", "getUpdateMediaInfoNotify$annotations", "updateMediaInfoNotify", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicMediaParamDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "media_info_for_enter_room")
        public static /* synthetic */ void getLinkMediaInfoForEnterRoom$annotations() {
        }

        @FieldName(name = "linkmic_media_info")
        public static /* synthetic */ void getLinkmicMediaInfo$annotations() {
        }

        @FieldName(name = "linkmic_media_type")
        public static /* synthetic */ void getLinkmicMediaType$annotations() {
        }

        @FieldName(name = "update_media_info_notify")
        public static /* synthetic */ void getUpdateMediaInfoNotify$annotations() {
        }
    }

    k getLinkMediaInfoForEnterRoom();

    j1 getLinkmicMediaInfo();

    int getLinkmicMediaType();

    k0 getUpdateMediaInfoNotify();
}
