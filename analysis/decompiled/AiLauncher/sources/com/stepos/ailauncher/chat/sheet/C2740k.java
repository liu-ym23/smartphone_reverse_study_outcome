package com.stepos.ailauncher.chat.sheet;

import Z8.C1173v;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/k;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()I", "Landroid/content/Context;", "context", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)I", "", "reason", "", "c", "(Landroid/content/Context;Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "ACTION_REQUEST_OVERVIEW", "EXTRA_OVERVIEW_REASON", "", "launcherOverviewPackages", "Ljava/util/List;", "Lcom/stepos/ailauncher/chat/sheet/f0;", "launcherTaskIdProvider", "Lcom/stepos/ailauncher/chat/sheet/f0;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/chat/sheet/f0;", "e", "(Lcom/stepos/ailauncher/chat/sheet/f0;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.sheet.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2740k {
    public static final String ACTION_REQUEST_OVERVIEW = "com.stepos.launcher.action.REQUEST_OVERVIEW";
    public static final String EXTRA_OVERVIEW_REASON = "reason";
    private static final String TAG = "ChatPlatformBridge";
    private static volatile f0 launcherTaskIdProvider;
    public static final C2740k INSTANCE = new C2740k();
    private static final List<String> launcherOverviewPackages = C1173v.p("com.android.launcher3", "com.stepos.launcher");

    public final int a() {
        f0 f0Var = launcherTaskIdProvider;
        if (f0Var == null) {
            return -1;
        }
        Integer numValueOf = Integer.valueOf(f0Var.a());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return -1;
    }

    public final f0 b() {
        return launcherTaskIdProvider;
    }

    public final boolean c(Context context, String reason) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(reason, "reason");
        Context applicationContext = context.getApplicationContext();
        boolean z10 = false;
        for (String str : launcherOverviewPackages) {
            Intent intent = new Intent(ACTION_REQUEST_OVERVIEW);
            intent.setPackage(str);
            intent.putExtra("reason", reason);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                applicationContext.sendBroadcast(intent);
                z10 = true;
                Log.i(TAG, "REQUEST_OVERVIEW → " + str + " reason=" + reason);
            } catch (Throwable th) {
                Log.w(TAG, "REQUEST_OVERVIEW " + str + " failed: " + th.getMessage());
            }
        }
        if (!z10) {
            Log.w(TAG, "REQUEST_OVERVIEW not delivered");
        }
        return z10;
    }

    public final int d(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Integer numValueOf = Integer.valueOf(a());
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        Integer numValueOf2 = Integer.valueOf(new i0(applicationContext, null, 2, null).a());
        Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
        int iIntValue = num != null ? num.intValue() : -1;
        if (iIntValue <= 0) {
            Log.w(TAG, "resolveLauncherTaskId failed (provider+RunningTasks)");
            return iIntValue;
        }
        Log.i(TAG, "resolveLauncherTaskId via RunningTasks → " + iIntValue);
        return iIntValue;
    }

    public final void e(f0 f0Var) {
        launcherTaskIdProvider = f0Var;
    }
}
