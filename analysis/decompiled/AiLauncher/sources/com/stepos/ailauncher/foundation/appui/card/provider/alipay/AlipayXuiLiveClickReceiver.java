package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiLiveClickReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "raw", "", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;Ljava/lang/String;)Z", "target", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlipayXuiLiveClickReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.stepos.ailauncher.alipay.LIVE_CARD_CLICK";
    private static final String ACTION_DISMISS_WAKE = "com.stepos.ailauncher.action.DISMISS_WAKE";
    public static final String EXTRA_APP_LINK = "appLink";
    public static final String EXTRA_SESSION_ID = "sessionId";
    public static final String EXTRA_STATUS = "status";
    public static final String EXTRA_SWIPE = "swipe";
    public static final String EXTRA_TASK_ID = "taskId";

    public final void a(Context context, String target) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            context.sendBroadcast(new Intent("com.stepos.ailauncher.action.DISMISS_WAKE").setPackage(context.getPackageName()));
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("binder.island.dismissWake.fail", Y8.j.a("uri", target), Y8.j.a("exception", thE.getClass().getSimpleName()));
        }
    }

    public final boolean b(Context context, String raw) {
        Object objB;
        String strT = La.D.T(La.D.T(La.D.T(La.D.T(La.D.T(raw, "&amp;", Const.STR_MART_ADD, false, 4, null), "&lt;", "<", false, 4, null), "&gt;", ">", false, 4, null), "&quot;", "\"", false, 4, null), "&#39;", "'", false, 4, null);
        a(context, strT);
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strT));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            R5.b.INSTANCE.c("binder.island.openLink", Y8.j.a("uri", strT));
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("binder.island.openLink.fail", Y8.j.a("uri", strT), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        kotlin.jvm.internal.p.i(context, "context");
        if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, ACTION)) {
            Context applicationContext = context.getApplicationContext();
            String stringExtra = intent.getStringExtra("taskId");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String str = stringExtra;
            N5.j jVar = N5.j.INSTANCE;
            String strD = jVar.d(intent.getStringExtra(EXTRA_APP_LINK));
            String strD2 = jVar.d(intent.getStringExtra("sessionId"));
            if (strD2 == null) {
                strD2 = AlipayXuiIslandVisibility.INSTANCE.U(str);
            }
            String stringExtra2 = intent.getStringExtra("status");
            String str2 = EXTRA_SWIPE;
            boolean booleanExtra = intent.getBooleanExtra(EXTRA_SWIPE, false);
            R5.b bVar = R5.b.INSTANCE;
            String str3 = booleanExtra ? "binder.island.swipe" : "binder.island.click";
            Pair pairA = Y8.j.a("taskId", str.length() == 0 ? "null" : str);
            if (stringExtra2 == null) {
                stringExtra2 = "null";
            }
            bVar.c(str3, pairA, Y8.j.a("status", stringExtra2), Y8.j.a("hasLink", Boolean.valueOf(strD != null)), Y8.j.a("hasSession", Boolean.valueOf(strD2 != null)));
            AlipayXuiIslandVisibility alipayXuiIslandVisibility = AlipayXuiIslandVisibility.INSTANCE;
            if (!booleanExtra) {
                str2 = "click";
            }
            AlipayXuiIslandVisibility.m(alipayXuiIslandVisibility, str, null, str2, 2, null);
            if (booleanExtra) {
                return;
            }
            if (strD != null) {
                kotlin.jvm.internal.p.f(applicationContext);
                b(applicationContext, strD);
            } else {
                String strO = AlipayXuiIsland.INSTANCE.o(str);
                if (strO != null) {
                    str = strO;
                }
                v.INSTANCE.i(str);
            }
        }
    }
}
