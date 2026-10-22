package com.stepos.statsapp.v3.lib.plugin.events;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.session.b;
import com.stepos.statsapp.v3.lib.plugin.tracker.b;
import com.stepos.statsapp.v3.lib.plugin.utils.thread.GlobalExecutor;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final String f30791b = "EventController";

    /* renamed from: c, reason: collision with root package name */
    private static final int f30792c = 300;

    /* renamed from: a, reason: collision with root package name */
    private final List<b.C0370b> f30793a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context, String str, String str2, Map map, int i10, Map map2) {
        a(new a(context, str, str2, map), i10, map2);
    }

    public void b(final Context context, final String str, final String str2, Map<String, String> map, final int i10, Map<String, Object> map2) {
        Logger.d(f30791b, "onActionXEvent, eventName: " + str + ", pageName: " + str2 + ", properties: " + map + ", sendType: " + i10 + ", replaceMap: " + map2);
        if (TextUtils.isEmpty(str)) {
            Logger.e(f30791b, "onActionXEvent fail, eventName is empty");
            return;
        }
        final Map<String, String> mapB = b(map);
        final Map<String, Object> mapA = a(map2);
        GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.events.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f30799a.a(context, str, str2, mapB, i10, mapA);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context, String str, Map map, int i10) {
        HashMap map2 = new HashMap();
        map2.put(Parameters.PKG_NAME, d.f30794i);
        a(new d(context, str, map), i10, map2);
    }

    public void a(com.stepos.statsapp.v3.lib.plugin.session.b bVar, String str) {
        Logger.d(f30791b, "onPageStartEvent pageName: " + str);
        if (bVar == null) {
            Logger.e(f30791b, "onPageStartEvent fail, pageController is null");
        } else {
            bVar.b(str);
        }
    }

    public void b(final Context context, final String str, Map<String, String> map, final int i10) {
        Logger.d(f30791b, "onLogEvent logName: " + str + ", properties: " + map + ", sendType: " + i10);
        if (TextUtils.isEmpty(str)) {
            Logger.e(f30791b, "onLogEvent fail, logName is empty");
        } else {
            final Map<String, String> mapB = b(map);
            GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.events.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30813a.a(context, str, mapB, i10);
                }
            });
        }
    }

    public void a(final Context context, com.stepos.statsapp.v3.lib.plugin.session.b bVar, final String str, Map<String, String> map, final int i10) {
        Logger.d(f30791b, "onPageStopEvent pageName: " + str + ", properties: " + map + ", sendType: " + i10);
        if (TextUtils.isEmpty(str)) {
            Logger.e(f30791b, "onPageStopEvent fail, pageName is empty");
            return;
        }
        if (bVar == null) {
            Logger.e(f30791b, "onPageStopEvent fail, pageController is null");
            return;
        }
        b.a aVarC = bVar.c(str);
        if (aVarC == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        final HashMap map2 = map != null ? new HashMap(map) : new HashMap();
        map2.put(e.f30796j, String.valueOf(jElapsedRealtime - aVarC.f30956c));
        final String strValueOf = String.valueOf(aVarC.f30955b);
        final String strValueOf2 = String.valueOf(jCurrentTimeMillis);
        GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.events.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f30806a.a(context, str, strValueOf, strValueOf2, map2, i10);
            }
        });
    }

    private static Map<String, String> b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context, String str, String str2, String str3, Map map, int i10) {
        a(new e(context, str, str2, str3, map), i10, null);
    }

    private void a(b bVar, int i10, Map<String, Object> map) {
        b.C0370b c0370b = new b.C0370b(bVar, i10, map);
        com.stepos.statsapp.v3.lib.plugin.tracker.b bVarH = com.stepos.statsapp.v3.lib.plugin.sdk.a.c().h();
        if (bVarH == null) {
            Logger.w(f30791b, "send fail, tracker is null");
            a(c0370b);
            com.stepos.statsapp.v3.lib.plugin.sdk.a.c().b(false);
        } else {
            Logger.d(f30791b, "send success");
            bVarH.b(c0370b);
        }
    }

    private synchronized void a(b.C0370b c0370b) {
        if (this.f30793a.size() < 300) {
            this.f30793a.add(c0370b);
        } else {
            Logger.w(f30791b, "fail event data list is already full");
        }
    }

    public synchronized void a() {
        if (this.f30793a.isEmpty()) {
            Logger.d(f30791b, "fail event data list is empty");
            return;
        }
        com.stepos.statsapp.v3.lib.plugin.tracker.b bVarH = com.stepos.statsapp.v3.lib.plugin.sdk.a.c().h();
        for (int i10 = 0; i10 < this.f30793a.size(); i10++) {
            bVarH.b(this.f30793a.get(i10));
        }
        Logger.i(f30791b, "resend fail event data success, number: " + this.f30793a.size());
        this.f30793a.clear();
    }

    private static Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }
}
