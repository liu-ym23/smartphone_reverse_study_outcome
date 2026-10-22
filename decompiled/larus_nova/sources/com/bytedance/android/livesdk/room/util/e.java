package com.bytedance.android.livesdk.room.util;

import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import com.bytedance.android.livesdkapi.room.controller.DefaultStartLiveController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements ISaasLiveRoomControllerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f157830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f157831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f157832c = null;

    public e() {
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final String businessType() {
        return "log";
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public final String getInjectionLicense() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public final void onInjectFinished(boolean r100, String r101) {
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final void substituteClearLiveRoomController(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
    }

    static {
        f157832c = new e();
        f157830a = "";
        f157831b = new d("");
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider, com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final IStartLivePreviewController getStartLivePreviewController() {
        return new DefaultStartLiveController();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public final void onMessageInjectionAllow(IExternalMessageInject r100) {
        Intrinsics.checkNotNullParameter(r100, "injectionStub");
        ISaasLiveRoomControllerProvider.DefaultImpls.onMessageInjectionAllow(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final ILiveRoomController getController(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "roomTag");
        if ((!Intrinsics.areEqual(f157830a, r101)) == false) goto L6;
        f157830a = r101;
        f157831b = new d(r101);
    L6:
        return f157831b;
    }
}
