package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002,\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001eR\u0014\u0010$\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010%\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u001eR\u0014\u0010'\u001a\u00020&8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\u001e¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;", "target", "", "activityTaskId", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;Ljava/lang/Integer;)V", "", "callbackUri", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$a;", "e", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$a;", "", "f", "(Landroid/content/Context;)Z", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", Const.INTENT_KEY_APIKEY, UxipConstants.f30680s, "c", "(Ljava/lang/String;)Z", "PREFS", "Ljava/lang/String;", "KEY_TIMESTAMP", "KEY_CARD_ID", "KEY_PENDING_ID", "KEY_VENDOR_ID", "KEY_INTEGRATION_ID", "KEY_RETURN_TARGET", "KEY_ACTIVITY_TASK_ID", "", "VALID_MS", "J", "INVALID_TASK_ID", "I", "ACTION_SHOW_WAKE", "ReturnTarget", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppAutherReturnContext {
    private static final String ACTION_SHOW_WAKE = "com.stepos.ailauncher.action.SHOW_WAKE";
    public static final AppAutherReturnContext INSTANCE = new AppAutherReturnContext();
    private static final int INVALID_TASK_ID = -1;
    private static final String KEY_ACTIVITY_TASK_ID = "activity_task_id";
    private static final String KEY_CARD_ID = "card_id";
    private static final String KEY_INTEGRATION_ID = "integration_id";
    private static final String KEY_PENDING_ID = "pending_id";
    private static final String KEY_RETURN_TARGET = "return_target";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_VENDOR_ID = "vendor_id";
    private static final String PREFS = "app_auther_return_context";
    private static final long VALID_MS = 600000;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVITY", "LAUNCHER_OVERLAY", "WAKE_DIALOG", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ReturnTarget {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ ReturnTarget[] $VALUES;
        public static final ReturnTarget ACTIVITY = new ReturnTarget("ACTIVITY", 0);
        public static final ReturnTarget LAUNCHER_OVERLAY = new ReturnTarget("LAUNCHER_OVERLAY", 1);
        public static final ReturnTarget WAKE_DIALOG = new ReturnTarget("WAKE_DIALOG", 2);

        private static final /* synthetic */ ReturnTarget[] $values() {
            return new ReturnTarget[]{ACTIVITY, LAUNCHER_OVERLAY, WAKE_DIALOG};
        }

        static {
            ReturnTarget[] returnTargetArr$values = $values();
            $VALUES = returnTargetArr$values;
            $ENTRIES = kotlin.enums.a.a(returnTargetArr$values);
        }

        private ReturnTarget(String str, int i10) {
        }

        public static InterfaceC4149a<ReturnTarget> getEntries() {
            return $ENTRIES;
        }

        public static ReturnTarget valueOf(String str) {
            return (ReturnTarget) Enum.valueOf(ReturnTarget.class, str);
        }

        public static ReturnTarget[] values() {
            return (ReturnTarget[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$a;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;", "target", "", "activityTaskId", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;Ljava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;", "Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherReturnContext$a, reason: from toString */
    public static final /* data */ class RestoredContext {
        private final Integer activityTaskId;
        private final ReturnTarget target;

        public RestoredContext(ReturnTarget target, Integer num) {
            kotlin.jvm.internal.p.i(target, "target");
            this.target = target;
            this.activityTaskId = num;
        }

        /* renamed from: a, reason: from getter */
        public final Integer getActivityTaskId() {
            return this.activityTaskId;
        }

        /* renamed from: b, reason: from getter */
        public final ReturnTarget getTarget() {
            return this.target;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RestoredContext)) {
                return false;
            }
            RestoredContext restoredContext = (RestoredContext) other;
            return this.target == restoredContext.target && kotlin.jvm.internal.p.d(this.activityTaskId, restoredContext.activityTaskId);
        }

        public int hashCode() {
            int iHashCode = this.target.hashCode() * 31;
            Integer num = this.activityTaskId;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "RestoredContext(target=" + this.target + ", activityTaskId=" + this.activityTaskId + ")";
        }
    }

    public final void a(Context context) {
        context.getApplicationContext().getSharedPreferences(PREFS, 0).edit().clear().apply();
    }

    public final void b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        a(context);
    }

    public final boolean c(String value) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Uri.parse(value));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Uri uri = (Uri) objB;
        return uri != null && La.D.L(uri.getScheme(), DidiCardProvider.MARKET_SOURCE, true) && La.D.L(uri.getHost(), "app-auther", true) && kotlin.jvm.internal.p.d(uri.getPath(), "/callback");
    }

    public final void d(Context context, AppAutherCardModel model, ReturnTarget target, Integer activityTaskId) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(target, "target");
        context.getApplicationContext().getSharedPreferences(PREFS, 0).edit().putLong(KEY_TIMESTAMP, System.currentTimeMillis()).putString(KEY_CARD_ID, model.getCardId()).putString(KEY_PENDING_ID, model.getPendingId()).putString(KEY_VENDOR_ID, model.getVendorId()).putString(KEY_INTEGRATION_ID, model.getIntegrationId()).putString(KEY_RETURN_TARGET, target.name()).putInt(KEY_ACTIVITY_TASK_ID, activityTaskId != null ? activityTaskId.intValue() : -1).apply();
        R5.b.INSTANCE.c("auther.return.record", Y8.j.a("taskId", model.getCardId()), Y8.j.a("pendingId", model.getPendingId()), Y8.j.a("vendorId", model.getVendorId()), Y8.j.a("integrationId", model.getIntegrationId()), Y8.j.a("target", target.name()), Y8.j.a("activityTaskId", activityTaskId));
    }

    public final synchronized RestoredContext e(Context context, String callbackUri) {
        Object objB;
        ReturnTarget returnTarget;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callbackUri, "callbackUri");
        Context applicationContext = context.getApplicationContext();
        if (!c(callbackUri)) {
            R5.b.INSTANCE.h("auther.return.invalid_uri", Y8.j.a("hasUri", Boolean.valueOf(callbackUri.length() > 0)));
            a(context);
            return null;
        }
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(PREFS, 0);
        long j10 = sharedPreferences.getLong(KEY_TIMESTAMP, 0L);
        long jCurrentTimeMillis = j10 > 0 ? System.currentTimeMillis() - j10 : -1L;
        if (j10 <= 0 || 0 > jCurrentTimeMillis || jCurrentTimeMillis >= 600001) {
            R5.b.INSTANCE.h("auther.return.invalid", Y8.j.a("ageMs", Long.valueOf(jCurrentTimeMillis)));
            a(context);
            return null;
        }
        String string = sharedPreferences.getString(KEY_RETURN_TARGET, null);
        if (string != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(ReturnTarget.valueOf(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            returnTarget = (ReturnTarget) objB;
        } else {
            returnTarget = null;
        }
        if (returnTarget == null) {
            R5.b.INSTANCE.h("auther.return.invalid", Y8.j.a("reason", M5.b.FAIL_MISSING_TARGET));
            a(context);
            return null;
        }
        Integer numValueOf = Integer.valueOf(sharedPreferences.getInt(KEY_ACTIVITY_TASK_ID, -1));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        R5.b.INSTANCE.c("auther.return.restore", Y8.j.a("taskId", sharedPreferences.getString(KEY_CARD_ID, null)), Y8.j.a("pendingId", sharedPreferences.getString(KEY_PENDING_ID, null)), Y8.j.a("vendorId", sharedPreferences.getString(KEY_VENDOR_ID, null)), Y8.j.a("integrationId", sharedPreferences.getString(KEY_INTEGRATION_ID, null)), Y8.j.a("target", returnTarget.name()), Y8.j.a("activityTaskId", numValueOf));
        a(context);
        return new RestoredContext(returnTarget, numValueOf);
    }

    public final boolean f(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        Context applicationContext = context.getApplicationContext();
        try {
            Result.Companion companion = Result.INSTANCE;
            applicationContext.sendBroadcast(new Intent("com.stepos.ailauncher.action.SHOW_WAKE").setPackage(applicationContext.getPackageName()));
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("auther.return.restore.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
