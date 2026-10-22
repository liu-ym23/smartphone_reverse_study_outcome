package com.obric.oui.constraintlayout.core;

/* JADX INFO: loaded from: classes4.dex */
interface Pools$Pool<T> {
    T acquire();

    boolean release(T r10);

    void releaseAll(T[] r10, int r11);
}
