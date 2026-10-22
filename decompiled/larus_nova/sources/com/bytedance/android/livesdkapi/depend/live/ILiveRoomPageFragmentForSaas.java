package com.bytedance.android.livesdkapi.depend.live;

import android.os.Bundle;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveRoomPageFragmentForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static IPreviewController $default$previewController(ILiveRoomPageFragmentForSaas r100) {
            return null;
        }

        public static void $default$saveBackRoomInfo(ILiveRoomPageFragmentForSaas r100, String r101) {
        }

        public static void $default$saveBackRoomInfo(ILiveRoomPageFragmentForSaas r100, String r101, Bundle r102) {
        }

        public static void $default$stopRoom(ILiveRoomPageFragmentForSaas r100) {
        }
    }

    IPreviewController previewController();

    void saveBackRoomInfo(String r100);

    void saveBackRoomInfo(String r100, Bundle r101);

    void stopRoom();
}
