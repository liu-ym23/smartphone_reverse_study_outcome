package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public interface LottieLogger {
    void debug(String r1);

    void debug(String r1, Throwable r2);

    void error(String r1, Throwable r2);

    void warning(String r1);

    void warning(String r1, Throwable r2);
}
