package com.stepos.ailauncher.homegesture;

import Z8.C1172u;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilitySnapshot;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeTopKind;
import h8.C4148a;
import io.ktor.http.ContentType;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ_\u0010\u0019\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001bH\u0002¢\u0006\u0004\b%\u0010\u0003R\u0014\u0010&\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00040\u00040+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0012018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/stepos/ailauncher/homegesture/t;", "", "<init>", "()V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "Lcom/stepos/ailauncher/homegesture/b;", "decision", "", "forceBump", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/homegesture/b;Z)Z", HomeGestureEligibilityContract.EXTRA_CONSUMABLE, "", HomeGestureEligibilityContract.EXTRA_SCENE, "action", "taskId", "", "reason", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "rootToken", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;", "topKind", "topId", "e", "(ZIIILjava/lang/String;Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Lcom/stepos/ailauncher/contract/api/homegesture/HomeTopKind;Ljava/lang/String;Z)Z", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "Landroid/app/Application;", ContentType.Application.TYPE, Const.INTENT_KEY_PKGNAME, "(Landroid/app/Application;)V", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;)V", "c", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicLong;", "generationSeq", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "snapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "app", "Landroid/app/Application;", "", "launcherPackages", "Ljava/util/List;", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3352t {
    private static final String TAG = "HomeGestureEligible";
    private static volatile Application app;
    public static final C3352t INSTANCE = new C3352t();
    private static final AtomicLong generationSeq = new AtomicLong(0);
    private static final AtomicReference<HomeGestureEligibilitySnapshot> snapshot = new AtomicReference<>(HomeGestureEligibilitySnapshot.Companion.none$default(HomeGestureEligibilitySnapshot.INSTANCE, 0, null, 3, null));
    private static final List<String> launcherPackages = C1172u.e("com.android.launcher3");

    public static final HomeGestureEligibilitySnapshot a() {
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshot = snapshot.get();
        kotlin.jvm.internal.p.h(homeGestureEligibilitySnapshot, "get(...)");
        return homeGestureEligibilitySnapshot;
    }

    public static final boolean d(EligibilityDecision decision, boolean forceBump) {
        kotlin.jvm.internal.p.i(decision, "decision");
        return e(decision.getConsumable(), decision.getScene(), decision.getAction(), decision.getTaskId(), decision.getReason(), decision.getRootToken(), decision.getTopKind(), decision.getTopId(), forceBump);
    }

    public static final boolean e(boolean consumable, int scene, int action, int taskId, String reason, HomeRootToken rootToken, HomeTopKind topKind, String topId, boolean forceBump) {
        kotlin.jvm.internal.p.i(reason, "reason");
        kotlin.jvm.internal.p.i(rootToken, "rootToken");
        kotlin.jvm.internal.p.i(topKind, "topKind");
        kotlin.jvm.internal.p.i(topId, "topId");
        AtomicReference<HomeGestureEligibilitySnapshot> atomicReference = snapshot;
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshot = atomicReference.get();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        kotlin.jvm.internal.p.f(homeGestureEligibilitySnapshot);
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshotCopy$default = HomeGestureEligibilitySnapshot.copy$default(homeGestureEligibilitySnapshot, 0, 0L, consumable, scene, action, taskId, reason, jElapsedRealtime, rootToken, topKind, topId, 3, null);
        if (!forceBump && homeGestureEligibilitySnapshot.getGeneration() > 0 && kotlin.jvm.internal.p.d(homeGestureEligibilitySnapshot.fingerprint(), homeGestureEligibilitySnapshotCopy$default.fingerprint())) {
            C4148a.d(TAG, "publish skip same fingerprint consumable=" + consumable + " scene=" + scene + " action=" + action + " reason=" + reason + " gen=" + homeGestureEligibilitySnapshot.getGeneration() + " force=" + forceBump, false, 4, null);
            atomicReference.set(HomeGestureEligibilitySnapshot.copy$default(homeGestureEligibilitySnapshot, 0, 0L, false, 0, 0, 0, reason, jElapsedRealtime, null, null, null, 1855, null));
            return false;
        }
        long jIncrementAndGet = generationSeq.incrementAndGet();
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshotCopy$default2 = HomeGestureEligibilitySnapshot.copy$default(homeGestureEligibilitySnapshotCopy$default, 0, jIncrementAndGet, false, 0, 0, 0, null, 0L, null, null, null, 2045, null);
        atomicReference.set(homeGestureEligibilitySnapshotCopy$default2);
        C3352t c3352t = INSTANCE;
        c3352t.h(homeGestureEligibilitySnapshotCopy$default2);
        c3352t.c();
        C4148a.k(TAG, "publish consumable=" + consumable + " scene=" + scene + " action=" + action + " taskId=" + taskId + " gen=" + jIncrementAndGet + " token=" + rootToken.getWire() + " top=" + topKind.getWire() + ServerSentEventKt.COLON + topId + " reason=" + reason + " force=" + forceBump, false, 4, null);
        return true;
    }

    public static /* synthetic */ boolean f(boolean z10, int i10, int i11, int i12, String str, HomeRootToken homeRootToken, HomeTopKind homeTopKind, String str2, boolean z11, int i13, Object obj) {
        return e(z10, i10, i11, i12, str, (i13 & 32) != 0 ? HomeRootToken.DESKTOP : homeRootToken, (i13 & 64) != 0 ? HomeTopKind.NONE : homeTopKind, (i13 & 128) != 0 ? "" : str2, (i13 & 256) != 0 ? false : z11);
    }

    public static final void g(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        f(false, 0, 0, -1, reason, HomeRootToken.DESKTOP, HomeTopKind.NONE, "", false, 256, null);
    }

    public final void b(Application application) {
        kotlin.jvm.internal.p.i(application, "application");
        Context applicationContext = application.getApplicationContext();
        Application application2 = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application2 != null) {
            application = application2;
        }
        app = application;
        C4148a.d(TAG, "init", false, 4, null);
    }

    public final void c() {
        Object objB;
        Application application = app;
        if (application == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            application.getContentResolver().notifyChange(HomeGestureEligibilityContract.INSTANCE.getURI_HOME_GESTURE_ELIGIBLE(), null);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "notifyProvider failed: " + thE.getMessage(), false, 4, null);
        }
    }

    public final void h(HomeGestureEligibilitySnapshot state) {
        Application application = app;
        if (application == null) {
            return;
        }
        for (String str : launcherPackages) {
            Intent intent = new Intent(HomeGestureEligibilityContract.ACTION_HOME_ELIGIBILITY_CHANGED);
            intent.setPackage(str);
            intent.putExtras(state.toBundle());
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                application.sendBroadcast(intent, "android.permission.INTERNAL_SYSTEM_WINDOW");
                C4148a.d(TAG, "pushToLaunchers " + str + " gen=" + state.getGeneration(), false, 4, null);
            } catch (Throwable th) {
                C4148a.u(TAG, "pushToLaunchers " + str + " failed: " + th.getMessage(), false, 4, null);
            }
        }
    }
}
