package androidx.camera.core.internal;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/camera/core/internal/ScreenFlashWrapper;", "Landroidx/camera/core/ImageCapture$ScreenFlash;", "screenFlash", "(Landroidx/camera/core/ImageCapture$ScreenFlash;)V", "isClearScreenFlashPending", "", "lock", "Ljava/lang/Object;", "pendingListener", "Landroidx/camera/core/ImageCapture$ScreenFlashListener;", e1.REPLY_ACTION_APPLY, "", "expirationTimeMillis", "", "screenFlashListener", "clear", "completePendingScreenFlashClear", "completePendingScreenFlashListener", "completePendingTasks", "getBaseScreenFlash", "Companion", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScreenFlashWrapper implements ImageCapture.ScreenFlash {
    public static final Companion Companion = null;
    private static final String TAG = "ScreenFlashWrapper";
    private boolean isClearScreenFlashPending;
    private final Object lock;
    private ImageCapture.ScreenFlashListener pendingListener;
    private final ImageCapture.ScreenFlash screenFlash;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/camera/core/internal/ScreenFlashWrapper$Companion;", "", "()V", "TAG", "", "from", "Landroidx/camera/core/internal/ScreenFlashWrapper;", "screenFlash", "Landroidx/camera/core/ImageCapture$ScreenFlash;", "camera-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final ScreenFlashWrapper from(ImageCapture.ScreenFlash r100) {
            return new ScreenFlashWrapper(r100, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ ScreenFlashWrapper(ImageCapture.ScreenFlash r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public static /* synthetic */ void a(ScreenFlashWrapper r100) {
        apply$lambda$2(r100);
    }

    @JvmStatic
    public static final ScreenFlashWrapper from(ImageCapture.ScreenFlash r100) {
        return Companion.from(r100);
    }

    private final void completePendingScreenFlashClear() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.isClearScreenFlashPending == false) goto L12;
        ImageCapture.ScreenFlash r101 = this.screenFlash;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        r101.clear();     // Catch: Throwable -> L16
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L10:
        if (r102 != null) goto L13;
        Logger.e(TAG, "completePendingScreenFlashClear: screenFlash is null!");     // Catch: Throwable -> L16
    L13:
        this.isClearScreenFlashPending = false;     // Catch: Throwable -> L16
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L9:
        r102 = null;
        goto L10
    L12:
        Logger.w(TAG, "completePendingScreenFlashClear: none pending!");     // Catch: Throwable -> L16
        goto L13
    }

    private final void completePendingScreenFlashListener() {
        Object r100 = this.lock;
        monitor-enter(r100);
        ImageCapture.ScreenFlashListener r101 = this.pendingListener;     // Catch: Throwable -> L10
        if (r101 == null) goto L7;
        r101.onCompleted();     // Catch: Throwable -> L10
    L7:
        this.pendingListener = null;     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void completePendingTasks() {
        completePendingScreenFlashListener();
        completePendingScreenFlashClear();
    }

    @Override // androidx.camera.core.ImageCapture.ScreenFlash
    public void clear() {
        completePendingScreenFlashClear();
    }

    public final ImageCapture.ScreenFlash getBaseScreenFlash() {
        return this.screenFlash;
    }

    private ScreenFlashWrapper(ImageCapture.ScreenFlash r100) {
        this.screenFlash = r100;
        this.lock = new Object();
    }

    private static final void apply$lambda$2(ScreenFlashWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Object r101 = r100.lock;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r100.pendingListener != null) goto L7;
        Logger.w(TAG, "apply: pendingListener is null!");     // Catch: Throwable -> L10
    L7:
        r100.completePendingScreenFlashListener();     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
    }

    @Override // androidx.camera.core.ImageCapture.ScreenFlash
    public void apply(long r100, ImageCapture.ScreenFlashListener r101) {
        Intrinsics.checkNotNullParameter(r101, "screenFlashListener");
        Object r102 = this.lock;
        monitor-enter(r102);
        this.isClearScreenFlashPending = true;     // Catch: Throwable -> L14
        this.pendingListener = r101;     // Catch: Throwable -> L14
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r102);
        ImageCapture.ScreenFlash r104 = this.screenFlash;
        if (r104 == null) goto L10;
        r104.apply(r100, new c(this));
        Unit r105 = Unit.INSTANCE;
    L11:
        if (r105 != null) goto L19;
        Logger.e(TAG, "apply: screenFlash is null!");
        completePendingScreenFlashListener();
        return;
    L19:
        return;
    L10:
        r105 = null;
    L14:
        th = move-exception;
        throw th;
    }
}
