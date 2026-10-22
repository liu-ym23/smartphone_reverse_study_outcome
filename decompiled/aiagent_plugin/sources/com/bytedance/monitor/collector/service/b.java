package com.bytedance.monitor.collector.service;

import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: MessageHandleUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Set<Integer> f9029a;

    static {
        HashSet r0 = new HashSet();
        f9029a = r0;
        r0.add(114);
        f9029a.add(115);
        f9029a.add(116);
        f9029a.add(121);
        f9029a.add(122);
        f9029a.add(123);
    }

    public static boolean a(Message r1) {
        return f9029a.contains(Integer.valueOf(r1.what));
    }
}
