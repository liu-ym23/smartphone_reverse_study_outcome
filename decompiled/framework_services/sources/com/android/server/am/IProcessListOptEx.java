package com.android.server.am;

import android.os.IBinder;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface IProcessListOptEx {
    public static final int INCLUDE_ALL = 3;
    public static final int INCLUDE_FROZEN = 1;
    public static final int INCLUDE_PREFETCH = 2;
    public static final int NOT_INCLUDE = 0;

    ProcessRecord findAppProcessSmtLocked(IBinder r1, int r2);

    ProcessRecord findFrozenAppProcessByPid(int r1);

    boolean handleUnsolicitedMessage(DataInputStream r1, int r2);

    boolean handleUnsolicitedMessage(ByteBuffer r1, int r2);

    void handlerKilledPid(int r1, String r2, int r3);

    boolean isLmkdKilled(int r1);

    void onLmkdConnect(OutputStream r1);
}
