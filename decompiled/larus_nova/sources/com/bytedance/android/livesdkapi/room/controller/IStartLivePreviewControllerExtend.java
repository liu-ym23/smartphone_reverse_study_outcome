package com.bytedance.android.livesdkapi.room.controller;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewControllerExtend;", "Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewController;", "onRecycler", "", "live-room-controller-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IStartLivePreviewControllerExtend extends IStartLivePreviewController {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onCreate(IStartLivePreviewControllerExtend r100) {
            IStartLivePreviewController.DefaultImpls.onCreate(r100);
        }

        public static void onDestroy(IStartLivePreviewControllerExtend r100) {
            IStartLivePreviewController.DefaultImpls.onDestroy(r100);
        }

        public static void onDestroyView(IStartLivePreviewControllerExtend r100) {
            IStartLivePreviewController.DefaultImpls.onDestroyView(r100);
        }

        public static boolean onRecycler(IStartLivePreviewControllerExtend r100) {
            return false;
        }

        public static void onStart(IStartLivePreviewControllerExtend r100) {
            IStartLivePreviewController.DefaultImpls.onStart(r100);
        }

        public static void onStop(IStartLivePreviewControllerExtend r100) {
            IStartLivePreviewController.DefaultImpls.onStop(r100);
        }

        public static void onViewCreated(IStartLivePreviewControllerExtend r100) {
            IStartLivePreviewController.DefaultImpls.onViewCreated(r100);
        }
    }

    boolean onRecycler();
}
