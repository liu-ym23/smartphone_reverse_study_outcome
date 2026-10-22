package com.bytedance.bdtracker;

import android.app.Activity;
import com.bytedance.applog.exposure.ViewExposureManager;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class t0 extends Lambda implements Function2<Activity, Boolean, Unit> {
    public final /* synthetic */ ViewExposureManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(ViewExposureManager viewExposureManager) {
        super(2);
        this.a = viewExposureManager;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Activity activity, Boolean bool) {
        WeakHashMap weakHashMap;
        Activity activity2 = activity;
        boolean zBooleanValue = bool.booleanValue();
        if (activity2 != null && (weakHashMap = (WeakHashMap) this.a.a.get(activity2)) != null) {
            Intrinsics.checkExpressionValueIsNotNull(weakHashMap, "activitiesMap[activity] …erActivityStoppedCallback");
            Iterator it = weakHashMap.entrySet().iterator();
            while (it.hasNext()) {
                q0 q0Var = (q0) ((Map.Entry) it.next()).getValue();
                if (q0Var != null) {
                    u0 u0Var = q0Var.c;
                    u0 u0Var2 = u0.NOT_EXPOSURE;
                    if (u0Var != u0Var2) {
                        u0Var2 = zBooleanValue ? u0.RESUME_FORM_BACK : u0.RESUME_FORM_PAGE;
                    }
                    q0Var.c = u0Var2;
                    q0Var.b = false;
                    q0Var.d = 0L;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
