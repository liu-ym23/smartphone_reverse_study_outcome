package com.bytedance.android.livesdk.room.external;

import android.util.Base64;
import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import com.bytedance.android.livesdkapi.room.controller.DefaultStartLiveController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes11.dex */
public final class TopRightRoomInfoControllerProvider implements ISaasLiveRoomControllerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TopRightRoomInfoControllerProvider$roomControllerCache$1 f157626a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TopRightRoomInfoControllerProvider f157627b = null;

    public TopRightRoomInfoControllerProvider() {
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final String businessType() {
        return "TopRightRoomInfoWidgetController";
    }

    static {
        f157627b = new TopRightRoomInfoControllerProvider();
        f157626a = new TopRightRoomInfoControllerProvider$roomControllerCache$1();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider, com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final IStartLivePreviewController getStartLivePreviewController() {
        return new DefaultStartLiveController();
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public final String getInjectionLicense() {
        long r100 = System.currentTimeMillis();
        long r101 = System.currentTimeMillis();
        String r102 = r100 + "::" + r101 + "::" + (r100 % ((long) 256));
        MessageDigest r103 = MessageDigest.getInstance("MD5");
        Charset r104 = Charsets.UTF_8;
        if (r102 == null) goto L7;
        return r100 + "::" + r101 + "::" + Base64.encodeToString(r103.digest(r102.getBytes(r104)), 0);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public final void onMessageInjectionAllow(IExternalMessageInject r100) {
        Intrinsics.checkNotNullParameter(r100, "injectionStub");
        ISaasLiveRoomControllerProvider.DefaultImpls.onMessageInjectionAllow(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final ILiveRoomController getController(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        TopRightRoomInfoControllerProvider$roomControllerCache$1 r102 = f157626a;
        ILiveRoomController r103 = r102.get(r100);
        if (r103 != null) goto L6;
        r103 = new e(r100);
        r102.put(r100, r103);
    L6:
        return r103;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public final void onInjectFinished(boolean r100, String r101) {
        ISaasLiveRoomControllerProvider.DefaultImpls.onInjectFinished(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public final void substituteClearLiveRoomController(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        f157626a.remove(r100);
    }
}
