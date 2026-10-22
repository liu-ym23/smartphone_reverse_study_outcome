package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherReturnContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherRedirectActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", Const.INTENT_KEY_APIKEY, "", "taskId", "", Const.INTENT_KEY_UMID, "(Ljava/lang/Integer;)Z", Const.INTENT_KEY_PKGNAME, "c", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppAutherRedirectActivity extends Activity {

    @Deprecated
    public static final String ACTION_OPEN_CHAT = "com.stepos.ailauncher.action.OPEN_CHAT";
    private static final a Companion = new a(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherRedirectActivity$a;", "", "<init>", "()V", "", "ACTION_OPEN_CHAT", "Ljava/lang/String;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppAutherReturnContext.ReturnTarget.values().length];
            try {
                iArr[AppAutherReturnContext.ReturnTarget.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppAutherReturnContext.ReturnTarget.LAUNCHER_OVERLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppAutherReturnContext.ReturnTarget.WAKE_DIALOG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final void a(Intent intent) {
        Uri data;
        String string = (intent == null || (data = intent.getData()) == null) ? null : data.toString();
        if (string == null) {
            string = "";
        }
        R5.b.INSTANCE.c("auther.redirect.received", Y8.j.a("hasUri", Boolean.valueOf(string.length() > 0)));
        AppAutherReturnContext appAutherReturnContext = AppAutherReturnContext.INSTANCE;
        AppAutherReturnContext.RestoredContext restoredContextE = appAutherReturnContext.e(this, string);
        AppAutherReturnContext.ReturnTarget target = restoredContextE != null ? restoredContextE.getTarget() : null;
        int i10 = target == null ? -1 : b.$EnumSwitchMapping$0[target.ordinal()];
        if (i10 != -1) {
            if (i10 != 1) {
                if (i10 == 2) {
                    c();
                } else {
                    if (i10 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    appAutherReturnContext.f(this);
                }
            } else if (!d(restoredContextE.getActivityTaskId())) {
                b();
            }
        }
        finish();
        overridePendingTransition(0, 0);
    }

    public final void b() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent(ACTION_OPEN_CHAT);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(getPackageName());
            intent.addFlags(603979776);
            startActivity(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("auther.redirect.launch.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
    }

    public final void c() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.addFlags(270532608);
            startActivity(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("auther.redirect.launch_home.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
    }

    public final boolean d(Integer taskId) {
        Object objB;
        ActivityManager activityManager;
        if (taskId == null || taskId.intValue() <= 0) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            activityManager = (ActivityManager) getSystemService(ActivityManager.class);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (activityManager == null) {
            throw new IllegalStateException("ActivityManager unavailable");
        }
        activityManager.moveTaskToFront(taskId.intValue(), 0);
        R5.b.INSTANCE.c("auther.redirect.task_restored", Y8.j.a("activityTaskId", taskId));
        objB = Result.b(Boolean.TRUE);
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("auther.redirect.task_restore.fail", Y8.j.a("activityTaskId", taskId), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a(getIntent());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
    }
}
