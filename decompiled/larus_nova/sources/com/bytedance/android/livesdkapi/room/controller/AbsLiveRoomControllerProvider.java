package com.bytedance.android.livesdkapi.room.controller;

import android.util.Base64;
import android.util.LruCache;
import com.bytedance.android.livesdkapi.message.IExternalMessageInject;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H&J\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/AbsLiveRoomControllerProvider;", "Lcom/bytedance/android/livesdkapi/room/controller/ISaasLiveRoomControllerProvider;", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveMergeRoomControllerProvider;", "()V", "roomControllerCache", "Landroid/util/LruCache;", "", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "getRoomControllerCache", "()Landroid/util/LruCache;", "createController", "roomId", "uniqueKey", "source", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomControllerProvider$ProviderSource;", "getController", "getInjectionLicense", "logger", "", "tag", "msg", "substituteClearLiveRoomController", "Companion", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsLiveRoomControllerProvider implements ISaasLiveRoomControllerProvider, ILiveMergeRoomControllerProvider {
    public static final int CONTROLLER_CACHE_SIZE = 6;
    public static final Companion Companion = null;
    private static final String TAG = "DefaultLiveRoomController";
    private final LruCache<String, ILiveRoomController> roomControllerCache;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/controller/AbsLiveRoomControllerProvider$Companion;", "", "()V", "CONTROLLER_CACHE_SIZE", "", "TAG", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract ILiveRoomController createController(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102);

    public abstract void logger(String r100, String r101);

    public AbsLiveRoomControllerProvider() {
        final int r100 = 6;
        this.roomControllerCache = new AbsLiveRoomControllerProvider$roomControllerCache$1(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public String getInjectionLicense() {
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

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider, com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public IStartLivePreviewController getStartLivePreviewController() {
        return ISaasLiveRoomControllerProvider.DefaultImpls.getStartLivePreviewController(this);
    }

    public final LruCache<String, ILiveRoomController> getRoomControllerCache() {
        return this.roomControllerCache;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public void onMessageInjectionAllow(IExternalMessageInject r100) {
        Intrinsics.checkNotNullParameter(r100, "injectionStub");
        ISaasLiveRoomControllerProvider.DefaultImpls.onMessageInjectionAllow(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider
    public ILiveRoomController getController(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        return getController(r100, r101, ILiveRoomControllerProvider.ProviderSource.DEFAULT);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ISaasLiveRoomControllerProvider
    public void onInjectFinished(boolean r100, String r101) {
        ISaasLiveRoomControllerProvider.DefaultImpls.onInjectFinished(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomControllerProvider
    public ILiveRoomController getController(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        ILiveRoomController r103 = this.roomControllerCache.get(r101);
        if (r103 != null) goto L6;
        ILiveRoomController r104 = createController(r100, r101, r102);
        this.roomControllerCache.put(r101, r104);
        return r104;
    L6:
        return r103;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomControllerProvider
    public final void substituteClearLiveRoomController(String r100, String r101, ILiveRoomControllerProvider.ProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.roomControllerCache.remove(r101);
    }
}
