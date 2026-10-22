package com.stepos.ability.manager.watcher;

import H4.o;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.stepos.ability.net.biz.model.AppItem;
import com.stepos.ability.net.biz.model.DeviceAppRequest;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;

/* loaded from: classes3.dex */
public final class a extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3168a;

    public a(b bVar) {
        this.f3168a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String schemeSpecificPart;
        k.f(context, "context");
        k.f(intent, "intent");
        Log.i("AbilityInstallerWatcher", "onReceive action: " + intent.getAction());
        Log.i("AbilityInstallerWatcher", "onReceive action: " + intent);
        Uri data = intent.getData();
        if (data == null || (schemeSpecificPart = data.getSchemeSpecificPart()) == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            b bVar = this.f3168a;
            if (iHashCode == -810471698) {
                if (action.equals("android.intent.action.PACKAGE_REPLACED")) {
                    Log.i("AbilityInstallerWatcher", "handleAppUpdated. packageName:".concat(schemeSpecificPart));
                    bVar.b(context, schemeSpecificPart, false);
                    return;
                }
                return;
            }
            if (iHashCode != 525384130) {
                if (iHashCode == 1544582882 && action.equals("android.intent.action.PACKAGE_ADDED") && !booleanExtra) {
                    Log.i("AbilityInstallerWatcher", "handleAppInstalled. packageName:".concat(schemeSpecificPart));
                    bVar.b(context, schemeSpecificPart, true);
                    return;
                }
                return;
            }
            if (action.equals("android.intent.action.PACKAGE_REMOVED") && !booleanExtra) {
                Log.i("AbilityInstallerWatcher", "handleAppRemoved. packageName:".concat(schemeSpecificPart));
                String str = bVar.b;
                String str2 = Build.MODEL;
                String str3 = EnvironmentCompat.MEDIA_UNKNOWN;
                String str4 = str2 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str2;
                String str5 = Build.VERSION.RELEASE;
                if (str5 != null) {
                    str3 = str5;
                }
                AbstractC1683A.n(bVar.g, null, new AbilityInstallerWatcher$handleAppRemoved$1(context, schemeSpecificPart, bVar, new DeviceAppRequest(str, "UNINSTALL", str4, "Android ".concat(str3), o.M(new AppItem("", null, null, null, schemeSpecificPart, null, null, null, null, null, null, null, null, 8174, null))), null), 3);
            }
        }
    }
}
