package com.bytedance.librarian;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: LibrarianUnsatisfiedLinkError.java */
/* JADX INFO: loaded from: classes.dex */
class d extends UnsatisfiedLinkError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList<d> f8759a = null;

    static {
        f8759a = new ArrayList();
    }

    d(String r1) {
        super(r1);
        ArrayList<d> r2 = f8759a;
        monitor-enter(r2);
        r2.add(this);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    d(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
        ArrayList<d> r3 = f8759a;
        monitor-enter(r3);
        r3.add(this);     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static UnsatisfiedLinkError[] a() {
        ArrayList<d> r0 = f8759a;
        monitor-enter(r0);
        UnsatisfiedLinkError[] r1 = (UnsatisfiedLinkError[]) ZeusTransformUtils.preCheckCast(r0.toArray(new UnsatisfiedLinkError[0]), UnsatisfiedLinkError[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L8:
        th = move-exception;
        throw th;
    }
}
