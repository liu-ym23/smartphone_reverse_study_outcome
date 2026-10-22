package com.stepos.agentframework.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.view.N;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/app/Activity;", "Lkotlin/Pair;", "", Const.INTENT_KEY_APIKEY, "(Landroid/app/Activity;)Lkotlin/Pair;", "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Lkotlin/Pair;", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class G {
    public static final Pair<Integer, Integer> a(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "<this>");
        a0 a0VarB = N.B(activity.getWindow().getDecorView());
        if (a0VarB == null) {
            return null;
        }
        return Y8.j.a(Integer.valueOf(a0VarB.f(a0.o.f()).f41978b), Integer.valueOf(a0VarB.f(a0.o.e()).f41980d));
    }

    public static final Pair<Integer, Integer> b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }
}
