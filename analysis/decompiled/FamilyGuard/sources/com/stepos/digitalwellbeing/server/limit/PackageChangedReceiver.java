package com.stepos.digitalwellbeing.server.limit;

import D3.c;
import U1.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.limit.PackageChangedReceiver;
import com.stepos.digitalwellbeing.utils.PackageUtils;
import f2.C0702g;
import java.util.Objects;
import p2.g;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class PackageChangedReceiver extends BroadcastReceiver {
    public static /* synthetic */ void a(BroadcastReceiver.PendingResult pendingResult, Throwable th) {
        C0702g.p("PackageChangedReceiver", "onReceive async failed: " + th.getMessage());
        pendingResult.finish();
    }

    public static /* synthetic */ void b(Context context, String str, String str2, boolean z5, String str3, Intent intent) {
        PackageUtils.h(context).A();
        a.c(context);
        boolean zD = a.d();
        if (TextUtils.equals(str, "android.intent.action.PACKAGE_ADDED")) {
            DigitalWellbeingService.a0(context, str2);
            return;
        }
        if (!TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
            if (("android.intent.action.PACKAGE_REPLACED".equals(str) && TextUtils.equals(str2, str3)) || TextUtils.equals(str, "android.intent.action.MY_PACKAGE_REPLACED")) {
                C0702g.b("PackageChangedReceiver", "PackageChangedReceiver onReceive: intent = " + intent);
                DigitalWellbeingService.e0(context, zD);
                return;
            }
            return;
        }
        if (z5) {
            C0702g.b("PackageChangedReceiver", "skip PACKAGE_REMOVED while replacing, pkg=" + str2);
            return;
        }
        if (!TextUtils.equals(str2, str3)) {
            DigitalWellbeingService.b0(context, str2);
            return;
        }
        C0702g.b("PackageChangedReceiver", "PackageChangedReceiver onReceive: intent = " + intent);
        C0702g.b("PackageChangedReceiver", "PackageChangedReceiver onReceive: extras = " + C0702g.i(intent.getExtras()));
        DigitalWellbeingService.e0(context, zD);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (intent == null || intent.getData() == null) {
            return;
        }
        final String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
        final String action = intent.getAction();
        final boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED") && !booleanExtra) {
            PackageUtils.h(context).z(schemeSpecificPart);
        }
        if (g.x(context)) {
            final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            C0702g.b("PackageChangedReceiver", "onReceive action=" + action + " pkg=" + schemeSpecificPart + " replacing=" + booleanExtra);
            final String packageName = context.getPackageName();
            AbstractC1286b abstractC1286bJ = AbstractC1286b.c(new D3.a() { // from class: Y1.o
                @Override // D3.a
                public final void run() {
                    PackageChangedReceiver.b(context, action, schemeSpecificPart, booleanExtra, packageName, intent);
                }
            }).j(T3.a.c());
            Objects.requireNonNull(pendingResultGoAsync);
            abstractC1286bJ.h(new D3.a() { // from class: Y1.p
                @Override // D3.a
                public final void run() {
                    pendingResultGoAsync.finish();
                }
            }, new c() { // from class: Y1.q
                @Override // D3.c
                public final void accept(Object obj) {
                    PackageChangedReceiver.a(pendingResultGoAsync, (Throwable) obj);
                }
            });
        }
    }
}
