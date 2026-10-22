package com.bytedance.android.livesdkapi.depend.live;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveRoomPlayFragmentForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ILivePlayerClient $default$livePlayerClient(ILiveRoomPlayFragmentForSaas r100) {
            return null;
        }

        public static void $default$onPreviewBackPressed(ILiveRoomPlayFragmentForSaas r100) {
        }

        public static void $default$onPreviewStateChange(ILiveRoomPlayFragmentForSaas r100, Boolean r101) {
        }

        public static void $default$reallyHideInteractionFragment(ILiveRoomPlayFragmentForSaas r100) {
        }

        public static void $default$reallyShowInteractionFragment(ILiveRoomPlayFragmentForSaas r100) {
        }

        public static void $default$reloadInteraction(ILiveRoomPlayFragmentForSaas r100) {
        }

        public static void $default$resetLoggerInPreview(ILiveRoomPlayFragmentForSaas r100) {
        }
    }

    ILivePlayerClient livePlayerClient();

    void onPreviewBackPressed();

    void onPreviewStateChange(Boolean r100);

    void reallyHideInteractionFragment();

    void reallyShowInteractionFragment();

    void reloadInteraction();

    void resetLoggerInPreview();
}
