package com.jeffmony.async.util;

/* JADX INFO: loaded from: classes3.dex */
interface TimeoutBase$Handlerish {
    void post(Runnable r10);

    Object postDelayed(Runnable r10, long r11);

    void removeAllCallbacks(Object r10);
}
