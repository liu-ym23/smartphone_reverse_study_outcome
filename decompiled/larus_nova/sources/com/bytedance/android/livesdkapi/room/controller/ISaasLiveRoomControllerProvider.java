package com.bytedance.android.livesdkapi.room.controller;

import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/ISaasLiveRoomControllerProvider;", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider;", "getInjectionLicense", "", "getStartLivePreviewController", "Lcom/bytedance/android/livesdkapi/room/controller/IStartLivePreviewController;", "onInjectFinished", "", "success", "", "errMsg", "onMessageInjectionAllow", "injectionStub", "Lcom/bytedance/android/livesdkapi/message/IExternalMessageInject;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISaasLiveRoomControllerProvider extends ILiveRoomControllerProvider {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String getInjectionLicense(ISaasLiveRoomControllerProvider r100) {
            return null;
        }

        public static void onInjectFinished(ISaasLiveRoomControllerProvider r100, boolean r101, String r102) {
        }

        public static void onMessageInjectionAllow(ISaasLiveRoomControllerProvider r100, IExternalMessageInject r101) {
            Intrinsics.checkNotNullParameter(r101, "injectionStub");
        }

        public static IStartLivePreviewController getStartLivePreviewController(ISaasLiveRoomControllerProvider r100) {
            return new DefaultStartLiveController();
        }
    }

    String getInjectionLicense();

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    IStartLivePreviewController getStartLivePreviewController();

    void onInjectFinished(boolean r100, String r101);

    void onMessageInjectionAllow(IExternalMessageInject r100);
}
