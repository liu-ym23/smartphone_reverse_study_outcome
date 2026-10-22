package com.android.ttcjpaysdk.base.framework.manager;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenCaptureManager;", "", "listener", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "mScreenCaptureCallback", "Landroid/app/Activity$ScreenCaptureCallback;", "registerListener", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "unregisterListener", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJScreenCaptureManager {
    public static final Companion Companion = null;
    public static final String TAG = "CJScreenCaptureManager";
    private final Activity.ScreenCaptureCallback mScreenCaptureCallback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/manager/CJScreenCaptureManager$Companion;", "", "()V", "TAG", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public CJScreenCaptureManager(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.mScreenCaptureCallback = new CJScreenCaptureManager$mScreenCaptureCallback$1(r100);
    }

    public final void registerListener(AppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    L7:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJScreenCaptureManager#registerListener", th);
        CJLogger.b("CJScreenCaptureManager", th.getMessage());
        return;
    L4:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.DETECT_SCREEN_CAPTURE") != 0) goto L12;
        r100.registerScreenCaptureCallback(r100.getMainExecutor(), this.mScreenCaptureCallback);     // Catch: Throwable -> L7
        return;
    }

    public final void unregisterListener(AppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    L7:
        th = move-exception;
        CJLogger.b("CJScreenCaptureManager", th.getMessage());
        return;
    L4:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.DETECT_SCREEN_CAPTURE") != 0) goto L12;
        r100.unregisterScreenCaptureCallback(this.mScreenCaptureCallback);     // Catch: Throwable -> L7
        return;
    }
}
