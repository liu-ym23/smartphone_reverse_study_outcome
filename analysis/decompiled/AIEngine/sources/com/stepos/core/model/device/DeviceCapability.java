package com.stepos.core.model.device;

import a9.a;
import android.os.Build;
import gc.o;
import gc.q;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeviceCapability {
    public static final DeviceCapability INSTANCE = new DeviceCapability();
    private static final d hardware$delegate;
    private static final d socModel$delegate;

    static {
        int i10 = 0;
        socModel$delegate = b.b(new a(i10));
        hardware$delegate = b.b(new a9.b(i10));
    }

    private DeviceCapability() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isModelSupported$default(DeviceCapability deviceCapability, List list, List list2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list2 = null;
        }
        return deviceCapability.isModelSupported(list, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String socModel_delegate$lambda$1() {
        Object objA;
        if (Build.VERSION.SDK_INT >= 31) {
            String SOC_MODEL = Build.SOC_MODEL;
            g.e(SOC_MODEL, "SOC_MODEL");
            if (!q.t0(SOC_MODEL) && !SOC_MODEL.equals("unknown")) {
                return SOC_MODEL;
            }
        }
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "ro.soc.model", "");
            g.d(objInvoke, "null cannot be cast to non-null type kotlin.String");
            objA = (String) objInvoke;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        String str = (String) (objA instanceof Result.Failure ? "" : objA);
        if (!q.t0(str)) {
            return str;
        }
        String str2 = Build.HARDWARE;
        return str2 == null ? "unknown" : str2;
    }

    public final String getHardware() {
        Object value = hardware$delegate.getValue();
        g.e(value, "getValue(...)");
        return (String) value;
    }

    public final String getSocModel() {
        return (String) socModel$delegate.getValue();
    }

    public final boolean hasQNN() {
        String upperCase = getSocModel().toUpperCase(Locale.ROOT);
        g.e(upperCase, "toUpperCase(...)");
        return q.l0(upperCase, "SM8845", false) || q.l0(upperCase, "SM8735", false) || q.l0(upperCase, "SM8650", false) || q.l0(upperCase, "SM8550", false) || q.l0(upperCase, "SM8475", false) || q.l0(upperCase, "SM8450", false);
    }

    public final boolean isModelSupported(List<String> list, List<String> list2) {
        if (list != null && !list.isEmpty()) {
            String upperCase = getSocModel().toUpperCase(Locale.ROOT);
            g.e(upperCase, "toUpperCase(...)");
            if (!list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    String upperCase2 = ((String) it.next()).toUpperCase(Locale.ROOT);
                    g.e(upperCase2, "toUpperCase(...)");
                    if (q.l0(upperCase, upperCase2, false)) {
                        if (list2 != null) {
                        }
                        return true;
                    }
                }
            }
        } else if (list2 != null || !list2.contains(Build.MODEL)) {
            return true;
        }
        return false;
    }

    public final boolean isQualcomm() {
        String hardware = getHardware();
        Locale locale = Locale.ROOT;
        String lowerCase = hardware.toLowerCase(locale);
        g.e(lowerCase, "toLowerCase(...)");
        if (q.l0(lowerCase, "qcom", false)) {
            return true;
        }
        String upperCase = getSocModel().toUpperCase(locale);
        g.e(upperCase, "toUpperCase(...)");
        return o.k0(upperCase, "SM", false);
    }
}
