package com.stepos.ailauncher.chat.media;

import La.H;
import Ua.C1060i;
import Ua.CoroutineName;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\\\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010\u0003J\u0015\u0010'\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R*\u00106\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010<\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u00107\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010-R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010-R\u0016\u0010A\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010-R\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010-R\u001b\u0010H\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010LR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u00104R\u0016\u0010Z\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u001b\u0010c\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010E\u001a\u0004\ba\u0010b¨\u0006e"}, d2 = {"Lcom/stepos/ailauncher/chat/media/ScreenshotOverlayTracker;", "", "<init>", "()V", "", "from", "", "newerShot", "", "addedSec", "LY8/t;", "y", "(Ljava/lang/String;ZLjava/lang/Long;)V", "Lcom/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$a;", "shot", "m", "(Lcom/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$a;Ljava/lang/String;)V", "initialFrom", "", "initialEpoch", "r", "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "G", "(Ljava/lang/String;)Z", "x", "()Z", "o", "()J", "B", "()Lcom/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$a;", "Landroid/content/Context;", "context", "s", "(Landroid/content/Context;)V", "w", "(Landroid/content/Context;)Z", "C", "(Ljava/lang/String;)V", "q", "n", "TAG", "Ljava/lang/String;", "ACTION_HOME_WITHOUT_FOCUS", "REASON_KEY", "COVER_HOLD_MS", "J", "RECENT_SCREENSHOT_SEC", "IGNORE_MARK_AFTER_CLEAR_MS", "OBSERVER_DEBOUNCE_MS", "appContext", "Landroid/content/Context;", "registered", "Z", "Lkotlin/Function0;", "onCovered", "Lp9/a;", "getOnCovered", "()Lp9/a;", "D", "(Lp9/a;)V", "onDismissed", "getOnDismissed", ExifInterface.LONGITUDE_EAST, "coverUntilElapsed", "coverStartedElapsed", "ignoreMarkUntilElapsed", "lastConsumedAddedSec", "Landroid/os/HandlerThread;", "observerThread$delegate", "LY8/h;", "u", "()Landroid/os/HandlerThread;", "observerThread", "Landroid/os/Handler;", "observerHandler$delegate", "t", "()Landroid/os/Handler;", "observerHandler", "Ljava/lang/Runnable;", "debouncedStoreRefresh", "Ljava/lang/Runnable;", "LUa/M;", "queryScope", "LUa/M;", "refreshLock", "Ljava/lang/Object;", "Lkotlinx/coroutines/g;", "refreshJob", "Lkotlinx/coroutines/g;", "refreshAgain", "refreshEpoch", "I", "com/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$b", "closeReceiver", "Lcom/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$b;", "Landroid/database/ContentObserver;", "storeObserver$delegate", "v", "()Landroid/database/ContentObserver;", "storeObserver", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenshotOverlayTracker {
    private static final String ACTION_HOME_WITHOUT_FOCUS = "com.stepos.launcher.action.HOME_WITHOUT_FOCUS";
    private static final long COVER_HOLD_MS = 45000;
    private static final long IGNORE_MARK_AFTER_CLEAR_MS = 8000;
    private static final long OBSERVER_DEBOUNCE_MS = 300;
    private static final String REASON_KEY = "reason";
    private static final long RECENT_SCREENSHOT_SEC = 8;
    private static volatile Context appContext;
    private static volatile long coverStartedElapsed;
    private static volatile long coverUntilElapsed;
    private static volatile long ignoreMarkUntilElapsed;
    private static volatile long lastConsumedAddedSec;
    private static volatile InterfaceC5063a<t> onCovered;
    private static volatile InterfaceC5063a<t> onDismissed;
    private static boolean refreshAgain;
    private static int refreshEpoch;
    private static kotlinx.coroutines.g refreshJob;
    private static volatile boolean registered;
    public static final ScreenshotOverlayTracker INSTANCE = new ScreenshotOverlayTracker();

    /* renamed from: observerThread$delegate, reason: from kotlin metadata */
    private static final Y8.h observerThread = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.media.g
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ScreenshotOverlayTracker.A();
        }
    });

    /* renamed from: observerHandler$delegate, reason: from kotlin metadata */
    private static final Y8.h observerHandler = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.media.h
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ScreenshotOverlayTracker.z();
        }
    });
    private static final Runnable debouncedStoreRefresh = new Runnable() { // from class: com.stepos.ailauncher.chat.media.i
        @Override // java.lang.Runnable
        public final void run() {
            ScreenshotOverlayTracker.p();
        }
    };
    private static final String TAG = "ScreenshotOverlay";
    private static final M queryScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()).plus(new CoroutineName(TAG)));
    private static final Object refreshLock = new Object();
    private static final b closeReceiver = new b();

    /* renamed from: storeObserver$delegate, reason: from kotlin metadata */
    private static final Y8.h storeObserver = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.media.j
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ScreenshotOverlayTracker.F();
        }
    });

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$a;", "", "", "addedSec", "", "screenshot", "recent", "<init>", "(JZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", Const.INTENT_KEY_APIKEY, "()J", "Z", "c", "()Z", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$a, reason: from toString */
    public static final /* data */ class LatestImage {
        private final long addedSec;
        private final boolean recent;
        private final boolean screenshot;

        public LatestImage(long j10, boolean z10, boolean z11) {
            this.addedSec = j10;
            this.screenshot = z10;
            this.recent = z11;
        }

        /* renamed from: a, reason: from getter */
        public final long getAddedSec() {
            return this.addedSec;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getRecent() {
            return this.recent;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getScreenshot() {
            return this.screenshot;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LatestImage)) {
                return false;
            }
            LatestImage latestImage = (LatestImage) other;
            return this.addedSec == latestImage.addedSec && this.screenshot == latestImage.screenshot && this.recent == latestImage.recent;
        }

        public int hashCode() {
            return (((Long.hashCode(this.addedSec) * 31) + Boolean.hashCode(this.screenshot)) * 31) + Boolean.hashCode(this.recent);
        }

        public String toString() {
            return "LatestImage(addedSec=" + this.addedSec + ", screenshot=" + this.screenshot + ", recent=" + this.recent + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$b", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action == null) {
                action = "";
            }
            String stringExtra = intent != null ? intent.getStringExtra("reason") : null;
            ScreenshotOverlayTracker screenshotOverlayTracker = ScreenshotOverlayTracker.INSTANCE;
            if (!screenshotOverlayTracker.G("broadcast:" + action + "/" + stringExtra) && f.INSTANCE.b(stringExtra)) {
                screenshotOverlayTracker.y("broadcast:" + stringExtra, true, null);
                screenshotOverlayTracker.C("broadcast:" + stringExtra);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/media/ScreenshotOverlayTracker$c", "Landroid/database/ContentObserver;", "", "selfChange", "LY8/t;", "onChange", "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            ScreenshotOverlayTracker screenshotOverlayTracker = ScreenshotOverlayTracker.INSTANCE;
            screenshotOverlayTracker.t().removeCallbacks(ScreenshotOverlayTracker.debouncedStoreRefresh);
            screenshotOverlayTracker.t().postDelayed(ScreenshotOverlayTracker.debouncedStoreRefresh, 300L);
        }
    }

    public static final HandlerThread A() {
        HandlerThread handlerThread = new HandlerThread("ScreenshotOverlayObserver");
        handlerThread.start();
        return handlerThread;
    }

    public static final c F() {
        return new c(INSTANCE.t());
    }

    public static final void p() {
        INSTANCE.C("mediastore");
    }

    public static final Handler z() {
        return new Handler(INSTANCE.u().getLooper());
    }

    public final LatestImage B() {
        Context context;
        Object objB;
        LatestImage latestImage;
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b() || (context = appContext) == null) {
            return null;
        }
        String[] strArr = {"_data", "_display_name", "date_added"};
        try {
            Result.Companion companion = Result.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});
            boolean z10 = true;
            bundle.putInt("android:query-arg-sort-direction", 1);
            bundle.putInt("android:query-arg-limit", 1);
            Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, bundle, null);
            if (cursorQuery != null) {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst()) {
                        String string = cursor2.getString(0);
                        String str = "";
                        if (string == null) {
                            string = "";
                        }
                        String string2 = cursor2.getString(1);
                        if (string2 != null) {
                            str = string2;
                        }
                        long j10 = cursor2.getLong(2);
                        boolean z11 = Math.abs((System.currentTimeMillis() / 1000) - j10) <= RECENT_SCREENSHOT_SEC;
                        if (!H.e0(string, "screenshot", true) && !H.e0(str, "screenshot", true)) {
                            z10 = false;
                        }
                        latestImage = new LatestImage(j10, z10, z11);
                    } else {
                        latestImage = null;
                    }
                    l9.b.a(cursor, null);
                } finally {
                }
            } else {
                latestImage = null;
            }
            objB = Result.b(latestImage);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (LatestImage) (Result.g(objB) ? null : objB);
    }

    public final void C(String from) {
        kotlin.jvm.internal.p.i(from, "from");
        if (com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            synchronized (refreshLock) {
                kotlinx.coroutines.g gVar = refreshJob;
                if (gVar != null && gVar.b()) {
                    refreshAgain = true;
                    return;
                }
                refreshAgain = false;
                refreshJob = C1060i.d(queryScope, null, null, new ScreenshotOverlayTracker$requestRefresh$1$1(from, refreshEpoch, null), 3, null);
                t tVar = t.f7040a;
            }
        }
    }

    public final void D(InterfaceC5063a<t> interfaceC5063a) {
        onCovered = interfaceC5063a;
    }

    public final void E(InterfaceC5063a<t> interfaceC5063a) {
        onDismissed = interfaceC5063a;
    }

    public final boolean G(String from) {
        if (!x() || !f.INSTANCE.a(o())) {
            return false;
        }
        C4148a.k(TAG, "dismiss from=" + from + " ageMs=" + o(), false, 4, null);
        n(from);
        InterfaceC5063a<t> interfaceC5063a = onDismissed;
        if (interfaceC5063a == null) {
            return true;
        }
        interfaceC5063a.invoke();
        return true;
    }

    public final void m(LatestImage shot, String from) {
        if (shot != null && shot.getScreenshot() && shot.getRecent()) {
            boolean z10 = shot.getAddedSec() > lastConsumedAddedSec;
            if (!z10) {
                if (G(from + "-resave")) {
                    return;
                }
            }
            y(from, z10, z10 ? Long.valueOf(shot.getAddedSec()) : null);
        }
    }

    public final void n(String from) {
        kotlin.jvm.internal.p.i(from, "from");
        coverUntilElapsed = 0L;
        coverStartedElapsed = 0L;
        ignoreMarkUntilElapsed = SystemClock.elapsedRealtime() + 8000;
        C4148a.k(TAG, "clear cover from=" + from, false, 4, null);
    }

    public final long o() {
        long j10 = coverStartedElapsed;
        if (j10 == 0) {
            return Long.MAX_VALUE;
        }
        return SystemClock.elapsedRealtime() - j10;
    }

    public final void q() {
        synchronized (refreshLock) {
            refreshEpoch++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0084 -> B:18:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.String r11, int r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$1 r0 = (com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$1 r0 = new com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$3
            com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$a r12 = (com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker.LatestImage) r12
            java.lang.Object r12 = r0.L$2
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref$IntRef) r12
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r13)
            r13 = r11
            r11 = r5
            goto L87
        L3e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L46:
            kotlin.C4849c.b(r13)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            r13.f34820a = r11
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            r2.f34818a = r12
            r9 = r13
            r13 = r12
            r12 = r2
            r2 = r9
        L5b:
            com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$a r5 = r10.B()
            Ua.A0 r6 = Ua.Y.c()
            Ua.A0 r6 = r6.getImmediate()
            com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$2 r7 = new com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker$drainRefresh$2
            r7.<init>(r2, r5, r12, r4)
            java.lang.Object r8 = g9.h.a(r11)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r12
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$3 = r5
            r0.I$0 = r13
            r0.label = r3
            java.lang.Object r5 = Ua.C1056g.j(r6, r7, r0)
            if (r5 != r1) goto L87
            return r1
        L87:
            java.lang.Object r5 = com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker.refreshLock
            monitor-enter(r5)
            boolean r6 = com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker.refreshAgain     // Catch: java.lang.Throwable -> L92
            if (r6 != 0) goto L94
            com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker.refreshJob = r4     // Catch: java.lang.Throwable -> L92
            r6 = r4
            goto L9d
        L92:
            r10 = move-exception
            goto Lae
        L94:
            r6 = 0
            com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker.refreshAgain = r6     // Catch: java.lang.Throwable -> L92
            int r6 = com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker.refreshEpoch     // Catch: java.lang.Throwable -> L92
            java.lang.Integer r6 = g9.C4109a.f(r6)     // Catch: java.lang.Throwable -> L92
        L9d:
            monitor-exit(r5)
            if (r6 == 0) goto Lab
            int r5 = r6.intValue()
            r12.f34818a = r5
            java.lang.String r5 = "coalesced"
            r2.f34820a = r5
            goto L5b
        Lab:
            Y8.t r10 = Y8.t.f7040a
            return r10
        Lae:
            monitor-exit(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.media.ScreenshotOverlayTracker.r(java.lang.String, int, e9.c):java.lang.Object");
    }

    public final void s(Context context) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(context, "context");
        if (registered) {
            return;
        }
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            C4148a.k(TAG, "skip register: privacy not granted", false, 4, null);
            return;
        }
        synchronized (this) {
            try {
                if (registered) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                appContext = applicationContext;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.stepos.launcher.action.HOME_WITHOUT_FOCUS");
                intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(applicationContext.registerReceiver(closeReceiver, intentFilter, 2));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(TAG, "register close receiver failed", thE, false, 8, null);
                }
                try {
                    applicationContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, INSTANCE.v());
                    objB2 = Result.b(t.f7040a);
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objB2 = Result.b(C4849c.a(th2));
                }
                Throwable thE2 = Result.e(objB2);
                if (thE2 != null) {
                    C4148a.t(TAG, "register screenshot store observer failed", thE2, false, 8, null);
                }
                registered = true;
                C4148a.k(TAG, "registered", false, 4, null);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final Handler t() {
        return (Handler) observerHandler.getValue();
    }

    public final HandlerThread u() {
        return (HandlerThread) observerThread.getValue();
    }

    public final ContentObserver v() {
        return (ContentObserver) storeObserver.getValue();
    }

    public final boolean w(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        s(context);
        return SystemClock.elapsedRealtime() < coverUntilElapsed;
    }

    public final boolean x() {
        return coverStartedElapsed != 0 && SystemClock.elapsedRealtime() < coverUntilElapsed;
    }

    public final void y(String from, boolean newerShot, Long addedSec) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime < ignoreMarkUntilElapsed && !newerShot) {
            C4148a.k(TAG, "ignore mark from=" + from + " (cooldown after clear, same file)", false, 4, null);
            return;
        }
        if (newerShot) {
            ignoreMarkUntilElapsed = 0L;
            if (addedSec != null) {
                lastConsumedAddedSec = addedSec.longValue();
            }
        }
        if (coverStartedElapsed == 0) {
            coverStartedElapsed = jElapsedRealtime;
        }
        coverUntilElapsed = jElapsedRealtime + 45000;
        C4148a.k(TAG, "cover from=" + from + " hold=45000ms newerShot=" + newerShot, false, 4, null);
        InterfaceC5063a<t> interfaceC5063a = onCovered;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }
}
