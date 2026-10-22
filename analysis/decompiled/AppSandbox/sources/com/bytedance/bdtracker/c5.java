package com.bytedance.bdtracker;

import com.bytedance.applog.log.LoggerImpl;

/* loaded from: classes.dex */
public class c5 implements Runnable {
    public final /* synthetic */ d5 a;

    public c5(d5 d5Var) {
        this.a = d5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.a.a.size(); i++) {
            try {
                String[] strArr = {"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", "device_id"};
                for (int i2 = 0; i2 < 6; i2++) {
                    String str = strArr[i2];
                    try {
                        d5 d5Var = this.a;
                        d5Var.a(d5Var.a.get(i), str);
                    } catch (Exception e) {
                        LoggerImpl.global().error("DeprecatedFileCleaner execute failed", e, new Object[0]);
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }
}
