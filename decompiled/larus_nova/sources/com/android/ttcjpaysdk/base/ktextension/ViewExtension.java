package com.android.ttcjpaysdk.base.ktextension;

import android.os.Handler;
import android.os.Looper;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/ViewExtension;", "", "()V", "Companion", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewExtension {
    public static final Companion Companion = null;
    public static final long DEFAULT_INTERVAL = 500;
    private static final Runnable ENABLE_AGAIN = null;
    private static final Handler debouncingHandler = null;
    private static boolean enabled;
    private static long interval;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/ktextension/ViewExtension$Companion;", "", "()V", "DEFAULT_INTERVAL", "", "ENABLE_AGAIN", "Ljava/lang/Runnable;", "getENABLE_AGAIN", "()Ljava/lang/Runnable;", "debouncingHandler", "Landroid/os/Handler;", "getDebouncingHandler", "()Landroid/os/Handler;", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", VideoThumbInfo.KEY_INTERVAL, "getInterval", "()J", "setInterval", "(J)V", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Handler getDebouncingHandler() {
            return ViewExtension.access$getDebouncingHandler$cp();
        }

        public final Runnable getENABLE_AGAIN() {
            return ViewExtension.access$getENABLE_AGAIN$cp();
        }

        public final boolean getEnabled() {
            return ViewExtension.access$getEnabled$cp();
        }

        public final long getInterval() {
            return ViewExtension.access$getInterval$cp();
        }

        public final void setEnabled(boolean r100) {
            ViewExtension.access$setEnabled$cp(r100);
        }

        public final void setInterval(long r100) {
            ViewExtension.access$setInterval$cp(r100);
        }
    }

    public ViewExtension() {
    }

    static {
        Companion = new Companion(null);
        enabled = true;
        interval = 500;
        ENABLE_AGAIN = ViewExtension$Companion$ENABLE_AGAIN$1.INSTANCE;
        debouncingHandler = new Handler(Looper.getMainLooper());
    }

    public static final /* synthetic */ Handler access$getDebouncingHandler$cp() {
        return debouncingHandler;
    }

    public static final /* synthetic */ Runnable access$getENABLE_AGAIN$cp() {
        return ENABLE_AGAIN;
    }

    public static final /* synthetic */ boolean access$getEnabled$cp() {
        return enabled;
    }

    public static final /* synthetic */ long access$getInterval$cp() {
        return interval;
    }

    public static final /* synthetic */ void access$setEnabled$cp(boolean r100) {
        enabled = r100;
    }

    public static final /* synthetic */ void access$setInterval$cp(long r100) {
        interval = r100;
    }
}
