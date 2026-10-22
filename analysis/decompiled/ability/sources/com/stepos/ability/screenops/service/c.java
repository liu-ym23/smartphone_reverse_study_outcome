package com.stepos.ability.screenops.service;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.mdisdk.TaskManager;
import com.mdisdk.capability.model.IntentEntity;
import com.uxsense.ApexSDK;
import j9.m;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.r0;
import s9.C1923c;
import z2.l;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final C1923c f3241a;
    public static final ConcurrentHashMap b;
    public static final ConcurrentHashMap c;
    public static final ConcurrentHashMap.KeySetView d;
    public static final ConcurrentHashMap.KeySetView e;
    public static final ConcurrentHashMap f;
    public static final AtomicBoolean g;
    public static boolean h;
    public static Context i;

    static {
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        f3241a = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = ConcurrentHashMap.newKeySet();
        e = ConcurrentHashMap.newKeySet();
        f = new ConcurrentHashMap();
        g = new AtomicBoolean(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0160 -> B:20:0x0163). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r57) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.screenops.service.c.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static void b(Context context) {
        if (h) {
            return;
        }
        h = true;
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        i = applicationContext;
        ApexSDK.initialize$default(applicationContext, null, 2, null);
        AbstractC1683A.n(f3241a, null, new RuleTriggerManager$init$1(2, null), 3);
        Intent intent = new Intent("com.screenops.action.SERVER_READY");
        Context context2 = i;
        if (context2 == null) {
            k.n("appContext");
            throw null;
        }
        context2.sendBroadcastAsUser(intent, Process.myUserHandle());
        Log.i("RuleTriggerManager", "Broadcast SERVER_READY sent");
        Log.i("RuleTriggerManager", "RuleTriggerManager initialized");
    }

    public static boolean c() {
        String intentDataUri;
        String intentDataUri2 = null;
        try {
            IntentEntity activityIntentByPackage = TaskManager.getActivityIntentByPackage("com.dianping.v1", 0);
            if (activityIntentByPackage == null || (intentDataUri = activityIntentByPackage.getIntentDataUri()) == null) {
                IntentEntity topActivityIntent = TaskManager.getTopActivityIntent(0);
                if (topActivityIntent != null) {
                    if (!k.b(topActivityIntent.getPackageName(), "com.dianping.v1")) {
                        topActivityIntent = null;
                    }
                    if (topActivityIntent != null) {
                        intentDataUri2 = topActivityIntent.getIntentDataUri();
                    }
                }
            } else {
                intentDataUri2 = intentDataUri;
            }
        } catch (Exception unused) {
        }
        if (intentDataUri2 == null || intentDataUri2.length() == 0) {
            return false;
        }
        return m.h0(intentDataUri2, "ugc-addcontent-post", false);
    }
}
