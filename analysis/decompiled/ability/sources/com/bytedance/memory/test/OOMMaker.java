package com.bytedance.memory.test;

import Z6.k;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class OOMMaker {

    /* renamed from: a, reason: collision with root package name */
    public static ArrayList<byte[]> f2248a = new ArrayList<>();

    public static void createOOM() {
        while (true) {
            f2248a.add(new byte[2097152]);
        }
    }

    public static void createReachTop(int i) throws InterruptedException {
        while (k.c() < i) {
            encreaseMem();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void encreaseMem() {
        f2248a.add(new byte[15728640]);
    }
}
