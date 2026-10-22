package com.stepos.ailauncher.chat.provider;

import C5.d;
import Y8.h;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.C2708m;
import com.stepos.ailauncher.chat.manager.InputViewManager;
import com.stepos.ailauncher.chat.provider.LauncherStateProvider;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.a;
import com.stepos.ailauncher.chat.view.BaseInputView;
import com.stepos.ailauncher.chat.view.MainInputView;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilitySnapshot;
import com.stepos.ailauncher.homegesture.C3352t;
import com.stepos.launcher.assistant.utils.AiLauncherStateContract;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o6.C5009a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001f\u0010 J=\u0010!\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0010H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u001eH\u0002¢\u0006\u0004\b,\u0010-R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/stepos/ailauncher/chat/provider/LauncherStateProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "", "onCreate", "()Z", "", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "Landroid/net/Uri;", "uri", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", ChatTracker.CLICK_DELETE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", a.BUTTON_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "sessionId", "e", "(Ljava/lang/String;)I", "Landroid/content/Context;", "ctx", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/content/Context;)Z", "column", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(Ljava/lang/String;I)Landroid/database/Cursor;", "Landroid/os/Handler;", "mainHandler$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroid/os/Handler;", "mainHandler", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherStateProvider extends ContentProvider {
    private static final int CODE_AGENT_ENABLED = 3;
    private static final int CODE_CHAT_ACTIVE = 1;
    private static final int CODE_HOME_GESTURE_ELIGIBLE = 2;
    private static final UriMatcher matcher;

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final h mainHandler = C4848b.b(new InterfaceC5063a() { // from class: t5.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return LauncherStateProvider.i();
        }
    });

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("com.stepos.ailauncher.state.provider", "chat_active", 1);
        uriMatcher.addURI("com.stepos.ailauncher.state.provider", AiLauncherStateContract.PATH_AGENT_ENABLED, 3);
        uriMatcher.addURI("com.stepos.ailauncher.state.provider", "home_gesture_eligible", 2);
        matcher = uriMatcher;
    }

    public static final int f(String str) {
        InputViewManager inputViewManager = InputViewManager.INSTANCE;
        BaseInputView baseInputViewR0 = inputViewManager.r0();
        if (baseInputViewR0 == null) {
            return 0;
        }
        if (str == null || str.length() == 0 || inputViewManager.L0(str)) {
            return baseInputViewR0 instanceof MainInputView ? 2 : 1;
        }
        return 0;
    }

    public static final void g(AtomicInteger atomicInteger, InterfaceC5063a interfaceC5063a, CountDownLatch countDownLatch) {
        atomicInteger.set(((Number) interfaceC5063a.invoke()).intValue());
        countDownLatch.countDown();
    }

    public static final Handler i() {
        return new Handler(Looper.getMainLooper());
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String arg, Bundle extras) {
        p.i(method, "method");
        Context context = getContext();
        if (context == null) {
            return null;
        }
        d.INSTANCE.g(context, "LauncherStateProvider.call:" + method);
        return p.d(method, "home_gesture_eligible") ? C3352t.a().toBundle() : super.call(method, arg, extras);
    }

    public final Cursor d(String column, int value) {
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{column});
        matrixCursor.addRow(new Integer[]{Integer.valueOf(value)});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }

    public final int e(final String sessionId) {
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: t5.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(LauncherStateProvider.f(sessionId));
            }
        };
        if (p.d(Looper.myLooper(), Looper.getMainLooper())) {
            return ((Number) interfaceC5063a.invoke()).intValue();
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        h().post(new Runnable() { // from class: t5.c
            @Override // java.lang.Runnable
            public final void run() {
                LauncherStateProvider.g(atomicInteger, interfaceC5063a, countDownLatch);
            }
        });
        try {
            if (countDownLatch.await(200L, TimeUnit.MILLISECONDS)) {
                return atomicInteger.get();
            }
            return 0;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        p.i(uri, "uri");
        return null;
    }

    public final Handler h() {
        return (Handler) this.mainHandler.getValue();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        p.i(uri, "uri");
        return null;
    }

    public final boolean j(Context ctx) {
        C5009a.INSTANCE.d(ctx);
        return C2708m.INSTANCE.a();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        p.i(uri, "uri");
        Context context = getContext();
        if (context == null) {
            return null;
        }
        d.INSTANCE.g(context, "LauncherStateProvider.query");
        int iMatch = matcher.match(uri);
        if (iMatch == 1) {
            return d("active", e(uri.getQueryParameter("session_id")));
        }
        if (iMatch != 2) {
            if (iMatch != 3) {
                return null;
            }
            return d(AiLauncherStateContract.PATH_AGENT_ENABLED, j(context) ? 1 : 0);
        }
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshotA = C3352t.a();
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{HomeGestureEligibilityContract.EXTRA_GENERATION, HomeGestureEligibilityContract.EXTRA_CONSUMABLE, HomeGestureEligibilityContract.EXTRA_SCENE, "action", "task_id", "reason"});
        matrixCursor.addRow(new Object[]{Long.valueOf(homeGestureEligibilitySnapshotA.getGeneration()), Integer.valueOf(homeGestureEligibilitySnapshotA.getConsumable() ? 1 : 0), Integer.valueOf(homeGestureEligibilitySnapshotA.getScene()), Integer.valueOf(homeGestureEligibilitySnapshotA.getAction()), Integer.valueOf(homeGestureEligibilitySnapshotA.getTaskId()), homeGestureEligibilitySnapshotA.getReason()});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        p.i(uri, "uri");
        return 0;
    }
}
