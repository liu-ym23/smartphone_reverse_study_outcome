package com.ss.bduploader;

import java.util.Hashtable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public class BDUploadResolver implements com.ss.bduploader.net.d {
    private static final String TAG = "BDUploadResolver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f37459a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f37460b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f37461c = 60000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Hashtable<String, Object> f37462d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f37463e;
    private volatile String f;
    private volatile boolean g;
    private Thread h;
    private Future i;
    private volatile String[] j;
    private int k;

    private native void _notifyParserResult(String r1, String r2, long r3, String r5);

    static {
        f37462d = new Hashtable();
        f37463e = 1;
    }

    public BDUploadResolver() {
        this.g = false;
        this.h = null;
        this.i = null;
        this.k = f37460b;
    }

    @Override // com.ss.bduploader.net.d
    public void a(int r1, String r2, String r3, long r4, String r6) {
        s.c(TAG, String.format("notify result host:%s iplist:%s ", new Object[]{r2, r3}));
        if (this.g == true) goto L15;
        if (r3 == null) goto L13;
        if (r2 == null) goto L13;
        if (r2.equals(this.f) == false) goto L13;
        String[] r5 = r3.split(",");
        if (r5 == null) goto L13;
        if (r5.length <= 0) goto L13;
        this.j = new String[1];
        this.j[0] = r5[0];
    L13:
        this.g = true;
        return;
    }
}
