package com.stepos.ailauncher.sla;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.bean.SlaFunctionDetail;
import com.stepos.ability.bean.SlaPermissionResult;
import h8.C4148a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/sla/u;", "", "<init>", "()V", "", "verdict", "denyReason", "", Const.INTENT_KEY_APIKEY, "(II)Z", "anyRedline", "offline", Const.INTENT_KEY_PKGNAME, "(IIZZ)Z", "Landroid/content/Context;", "context", "Lcom/stepos/ability/bean/SlaPermissionResult;", "perm", "c", "(Landroid/content/Context;Lcom/stepos/ability/bean/SlaPermissionResult;)Z", Const.INTENT_KEY_UMID, "()Z", "", "TAG", "Ljava/lang/String;", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    public static final u INSTANCE = new u();
    private static final String TAG = "SLA";

    public final boolean a(int verdict, int denyReason) {
        return verdict == 2 || denyReason == 5 || denyReason == 6 || denyReason == 7;
    }

    public final boolean b(int verdict, int denyReason, boolean anyRedline, boolean offline) {
        C3474c c3474c = C3474c.INSTANCE;
        return c3474c.b() && c3474c.c() && c3474c.d() && offline && !anyRedline && a(verdict, denyReason);
    }

    public final boolean c(Context context, SlaPermissionResult perm) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(perm, "perm");
        boolean z10 = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(!com.stepos.ailauncher.common.utils.I.INSTANCE.b(context)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u("SLA", "ledgerBypass: 网络状态读取失败(" + thE.getMessage() + ")，按在线处理 -> 不放行", false, 4, null);
            objB = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) objB).booleanValue();
        List<SlaFunctionDetail> details = perm.getDetails();
        if ((details instanceof Collection) && details.isEmpty()) {
            z10 = false;
        } else {
            Iterator<T> it = details.iterator();
            while (it.hasNext()) {
                if (((SlaFunctionDetail) it.next()).getRedline()) {
                    break;
                }
            }
            z10 = false;
        }
        return b(perm.getVerdict(), perm.getDenyReason(), z10, zBooleanValue);
    }

    public final boolean d() {
        C3474c c3474c = C3474c.INSTANCE;
        return c3474c.b() && c3474c.c();
    }
}
