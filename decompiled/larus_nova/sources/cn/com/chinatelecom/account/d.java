package cn.com.chinatelecom.account;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes28.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Executor f24367a;

    static {
        f24367a = Executors.newSingleThreadExecutor();
    }

    public static void a(Runnable r100) {
        f24367a.execute(r100);
    }
}
