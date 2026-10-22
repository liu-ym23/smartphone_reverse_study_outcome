package com.android.server.power;

import android.util.proto.ProtoOutputStream;

/* JADX INFO: loaded from: classes3.dex */
interface SuspendBlocker {
    void acquire();

    void acquire(String r1);

    void dumpDebug(ProtoOutputStream r1, long r2);

    void release();

    void release(String r1);
}
