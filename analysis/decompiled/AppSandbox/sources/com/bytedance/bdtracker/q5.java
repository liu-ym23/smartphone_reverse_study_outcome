package com.bytedance.bdtracker;

import android.os.SystemProperties;
import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class q5 {
    public static volatile Object b;
    public final List<String> a = Collections.singletonList("SystemPropertiesProxy");

    public final Object a() {
        if (b == null) {
            synchronized (q5.class) {
                if (b == null) {
                    try {
                        b = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return b;
    }

    public String a(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            LoggerImpl.global().error(this.a, "Get key:{} value failed", th, str);
            try {
                Object objA = this.a();
                return (String) objA.getClass().getMethod("get", String.class).invoke(objA, str);
            } catch (Throwable th2) {
                LoggerImpl.global().error(this.a, "Get key:{} value by reflection failed", th2, str);
                return "";
            }
        }
    }
}
