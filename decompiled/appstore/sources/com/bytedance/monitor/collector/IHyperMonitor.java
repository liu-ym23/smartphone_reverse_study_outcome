package com.bytedance.monitor.collector;

/* JADX INFO: loaded from: classes.dex */
public interface IHyperMonitor {

    public interface ILogInstance {
        void d(String r10, String r11);

        void e(String r10, String r11);

        long getNativeReference();

        void i(String r10, String r11);

        void v(String r10, String r11);

        void w(String r10, String r11);
    }

    ILogInstance getLogInstance();
}
