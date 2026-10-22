package com.android.contacts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import com.GlobalProxyLancet;
import com.android.contacts.util.Constants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsInitialize.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/android/contacts/SettingsInitialize;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SettingsInitialize extends BroadcastReceiver {
    public static final Companion Companion = null;
    private static final String TAG = "Settings";

    /* JADX INFO: compiled from: SettingsInitialize.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/SettingsInitialize$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SettingsInitialize() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r4, Intent r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, MemorySourceLinkType.INTENT);
        Object r3 = r4.getSystemService("user");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.os.UserManager");
        UserInfo r6 = ((UserManager) r3).getUserInfo(UserHandle.myUserId());
        boolean r0 = false;
        if (r6 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Received broadcast: " + r5.getAction() + ", add cross profile filters");
        PackageManager r7 = r4.getPackageManager();
        IntentFilter r8 = new IntentFilter("android.intent.action.VIEW");
        r8.addCategory("android.intent.category.DEFAULT");
        r8.addCategory("android.intent.category.BROWSABLE");
        r8.addDataScheme(Constants.SCHEME_TEL);
        r7.addCrossProfileIntentFilter(r8, r6.id, r6.profileGroupId, 2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "add cross profile filter, " + r8);
        return;
    L5:
        if (r6.isManagedProfile() != true) goto L7;
        r0 = true;
        goto L7
    }
}
