package com.android.server.location.injector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.pm.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class SystemPackageResetHelper extends PackageResetHelper {
    private final Context mContext;
    private BroadcastReceiver mReceiver;

    private class Receiver extends BroadcastReceiver {
        final /* synthetic */ SystemPackageResetHelper this$0;

        public static /* synthetic */ void $r8$lambda$Zx70x59PQZk3MrOf_2AnvOmaJzM(Receiver r0, String r1) {
            r0.lambda$onReceive$0(r1);
        }

        public static /* synthetic */ void $r8$lambda$nQjWM_LpqGA0LL_igYwAYJnsylE(Receiver r0, String r1) {
            r0.lambda$onReceive$1(r1);
        }

        /* synthetic */ Receiver(SystemPackageResetHelper r1, SystemPackageResetHelperIA r2) {
            this(r1);
        }

        private Receiver(SystemPackageResetHelper r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) goto L5;
            return;
        L5:
            Uri data = intent.getData();
            if (data != null) goto L8;
            return;
        L8:
            final String packageName = data.getSchemeSpecificPart();
            if (packageName != null) goto L11;
            return;
        L11:
            int r5 = 0;
            switch(action.hashCode()) {
                case -1072806502: goto L24;
                case -757780528: goto L21;
                case 172491798: goto L18;
                case 525384130: goto L15;
                default: goto L26;
            };
        L26:
            byte r3 = -1;
        L27:
            switch(r3) {
                case 0: goto L49;
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L29;
                default: goto L72;
            };
        L29:
            FgThread.getExecutor().execute(new SystemPackageResetHelper$Receiver$$ExternalSyntheticLambda1(this, packageName));
            return;
        L30:
            boolean isPackageChange = false;
            String[] components = intent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
            if (components == null) goto L39;
            int r6 = components.length;
        L34:
            if (r5 >= r6) goto L39;
            String component = components[r5];
            if (packageName.equals(component) == true) goto L37;
            r5 = r5 + 1;
            goto L34
        L37:
            isPackageChange = true;
        L39:
            if (isPackageChange == false) goto L70;
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(0));     // Catch: PackageManager.NameNotFoundException -> L44
            if (appInfo.enabled == true) goto L73;
            FgThread.getExecutor().execute(new SystemPackageResetHelper$Receiver$$ExternalSyntheticLambda0(this, packageName));     // Catch: PackageManager.NameNotFoundException -> L44
            return;
        L73:
            return;
        L48:
            return;
        L70:
            return;
        L49:
            String[] packages = intent.getStringArrayExtra("android.intent.extra.PACKAGES");
            if (packages == null) goto L71;
            int r7 = packages.length;
        L53:
            if (r5 >= r7) goto L76;
            String pkg = packages[r5];
            if (this.this$0.queryResetableForPackage(pkg) == true) goto L56;
            r5 = r5 + 1;
            goto L53
        L56:
            setResultCode(-1);
            return;
        L76:
            return;
        L71:
            return;
        L72:
            return;
        L15:
            if (action.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L66;
            r3 = 2;
            goto L27
        L66:
            r3 = -1;
            goto L27
        L18:
            if (action.equals("android.intent.action.PACKAGE_CHANGED") == false) goto L67;
            r3 = 1;
            goto L27
        L67:
            r3 = -1;
            goto L27
        L21:
            if (action.equals("android.intent.action.PACKAGE_RESTARTED") == false) goto L68;
            r3 = 3;
            goto L27
        L68:
            r3 = -1;
            goto L27
        L24:
            if (action.equals("android.intent.action.QUERY_PACKAGE_RESTART") == false) goto L69;
            r3 = 0;
            goto L27
        L69:
            r3 = -1;
            goto L27
        }

        private /* synthetic */ void lambda$onReceive$0(String packageName) {
            this.this$0.notifyPackageReset(packageName);
        }

        private /* synthetic */ void lambda$onReceive$1(String packageName) {
            this.this$0.notifyPackageReset(packageName);
        }
    }

    public SystemPackageResetHelper(Context context) {
        this.mContext = context;
    }

    @Override // com.android.server.location.injector.PackageResetHelper
    protected void onRegister() {
        if (this.mReceiver != null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        this.mReceiver = new Receiver(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_RESTARTED");
        filter.addAction("android.intent.action.QUERY_PACKAGE_RESTART");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiver(this.mReceiver, filter);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.location.injector.PackageResetHelper
    protected void onUnregister() {
        if (this.mReceiver == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mReceiver = null;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
