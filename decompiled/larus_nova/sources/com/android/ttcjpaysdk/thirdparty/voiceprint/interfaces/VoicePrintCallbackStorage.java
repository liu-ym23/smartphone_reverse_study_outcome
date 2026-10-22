package com.android.ttcjpaysdk.thirdparty.voiceprint.interfaces;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/interfaces/VoicePrintCallbackStorage;", "", "()V", "callbackMap", "", "", "Lcom/android/ttcjpaysdk/thirdparty/voiceprint/interfaces/VoicePrintCallback;", "bindToLifecycle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "token", "bindToLifecycle$bdpay_voiceprint_release", MonitorConstants.CONNECT_TYPE_GET, MiPushClient.COMMAND_REGISTER, "callback", "release", "LifecycleObserverWrapper", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoicePrintCallbackStorage {
    public static final VoicePrintCallbackStorage INSTANCE = null;
    private static final Map<String, VoicePrintCallback> callbackMap = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/interfaces/VoicePrintCallbackStorage$LifecycleObserverWrapper;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "token", "", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "onStateChanged", "", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LifecycleObserverWrapper implements LifecycleEventObserver {
        private final LifecycleOwner lifecycleOwner;
        private final String token;

        public LifecycleObserverWrapper(LifecycleOwner r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(r101, "token");
            this.lifecycleOwner = r100;
            this.token = r101;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "event");
            if (this.lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
            VoicePrintCallbackStorage.INSTANCE.release(this.token);
            this.lifecycleOwner.getLifecycle().removeObserver(this);
            return;
        }
    }

    private VoicePrintCallbackStorage() {
    }

    static {
        INSTANCE = new VoicePrintCallbackStorage();
        callbackMap = new ConcurrentHashMap();
    }

    public final VoicePrintCallback get(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return callbackMap.get(r100);
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public final void release(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        callbackMap.remove(r100);
        return;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public final void bindToLifecycle$bdpay_voiceprint_release(LifecycleOwner r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, "token");
        r100.getLifecycle().addObserver(new LifecycleObserverWrapper(r100, r101));
    }

    public final String register(LifecycleOwner r100, VoicePrintCallback r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        String r102 = UUID.randomUUID().toString();
        callbackMap.put(r102, r101);
        if (r100 == null) goto L5;
        INSTANCE.bindToLifecycle$bdpay_voiceprint_release(r100, r102);
    L5:
        return r102;
    }

    public static /* synthetic */ String register$default(VoicePrintCallbackStorage r100, LifecycleOwner r101, VoicePrintCallback r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.register(r101, r102);
    }
}
