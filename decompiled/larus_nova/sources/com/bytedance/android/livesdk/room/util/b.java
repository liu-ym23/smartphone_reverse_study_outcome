package com.bytedance.android.livesdk.room.util;

import androidx.collection.LruCache;
import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import com.bytedance.android.livesdkapi.room.controller.DefaultStartLiveController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements ISaasLiveRoomControllerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, ISaasLiveRoomController> f157827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f157828b = null;

    public b() {
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final String businessType() {
        return "Saas";
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
        f157828b = new b();
        f157827a = new LruCache(4);
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
        Intrinsics.checkNotNullParameter(r100, "roomTag");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        LruCache<String, ISaasLiveRoomController> r102 = f157827a;
        ISaasLiveRoomController r103 = r102.get(r100);
        if (r103 != null) goto L6;
        a r104 = new a(r100);
        r102.put(r100, r104);
        return r104;
    L6:
        return r103;
    }
}
