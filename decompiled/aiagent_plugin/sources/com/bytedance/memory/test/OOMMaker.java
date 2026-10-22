package com.bytedance.memory.test;

import com.bytedance.memory.b.d;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class OOMMaker {
    private static ArrayList<byte[]> sArrayList;

    public OOMMaker() {
    }

    static {
        sArrayList = new ArrayList();
    }

    public static void createOOM() {
    L2:
        encreaseMem(UiType.FLAG_REMOTE_CARD);
        goto L2
    }

    public static void encreaseMem() {
        encreaseMem(15728640);
    }

    private static void encreaseMem(int r1) {
        ArrayList<byte[]> r0 = sArrayList;
        r0.add(new byte[r1]);
    }

    public static void createReachTop(int r2) {
    L3:
        if (d.a() >= r2) goto L9;
        encreaseMem();
        Thread.sleep(500);     // Catch: InterruptedException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L3
    }
}
