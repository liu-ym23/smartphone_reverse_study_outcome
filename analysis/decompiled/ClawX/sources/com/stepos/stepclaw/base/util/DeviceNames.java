package com.stepos.stepclaw.base.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import b5.h;
import c5.l;
import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/base/util/DeviceNames;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "bestDefaultNodeName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "context", "Landroid/content/Context;", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeviceNames {
    public static final DeviceNames INSTANCE = new DeviceNames();

    private DeviceNames() {
    }

    public final String bestDefaultNodeName(Context context) {
        Object objO;
        p.e(context, "context");
        try {
            objO = Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        String str = null;
        if (objO instanceof h) {
            objO = null;
        }
        String str2 = (String) objO;
        String string = str2 != null ? n.T1(str2).toString() : null;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (string.length() > 0) {
            return string;
        }
        String str3 = Build.MANUFACTURER;
        if (str3 == null || n.t1(str3)) {
            str3 = null;
        }
        String str4 = Build.MODEL;
        if (str4 != null && !n.t1(str4)) {
            str = str4;
        }
        String string2 = n.T1(m.A0(l.d0(new String[]{str3, str}), " ", null, null, null, 62)).toString();
        return string2.length() == 0 ? SecurePrefs.DEFAULT_DISPLAY_NAME : string2;
    }
}
