package com.amap.api.col.s;

import androidx.camera.video.AudioStats;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ad f26002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, ae> f26003b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f26004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f26005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f26006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private double f26007d;

        public a() {
            this.f26004a = true;
            this.f26005b = 86400;
            this.f26006c = 10;
            this.f26007d = AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        public final boolean a() {
            return this.f26004a;
        }

        public final long b() {
            return this.f26005b;
        }

        public final int c() {
            return this.f26006c;
        }

        public final double d() {
            return this.f26007d;
        }

        public final void a(double r100) {
            this.f26007d = r100;
        }

        public final void a(int r100) {
            this.f26006c = r100;
        }

        public final void a(long r100) {
            this.f26005b = r100;
        }

        public final void a(boolean r100) {
            this.f26004a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f26009b;

        public b() {
        }

        public final int hashCode() {
            String r100 = this.f26008a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            Object r104 = this.f26009b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L24:
            return false;
        L8:
            if (b.class != r100.getClass()) goto L24;
            b r101 = (b) r100;
            String r102 = this.f26008a;
            if (r102 != null) goto L20;
            if (r101.f26008a == null) goto L16;
            return false;
        L16:
            if (this.f26009b != r101.f26009b) goto L18;
            return true;
        L18:
            return false;
        L20:
            if (r102.equals(r101.f26008a) == false) goto L24;
            if (this.f26009b != r101.f26009b) goto L24;
            return true;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f26010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f26011b;

        public c(Object r100, boolean r101) {
            this.f26010a = r100;
            this.f26011b = r101;
        }
    }

    public static ad a() {
        if (f26002a != null) goto L15;
        monitor-enter(ad.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f26002a != null) goto L9;
        f26002a = new ad();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ad.class);     // Catch: Throwable -> L11
    L15:
        return f26002a;
    }

    public ad() {
        this.f26003b = new HashMap();
    }

    public final c a(b r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<ae> r101 = this.f26003b.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        ae r102 = r101.next();
        if (r102 == null) goto L7;
        c r103 = r102.a(r100);
        if (r103 == null) goto L7;
        return r103;
    L13:
        return null;
    }

    public final boolean b(b r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<ae> r101 = this.f26003b.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        ae r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.b(r100) == false) goto L7;
        return true;
    L14:
        return false;
    }

    public final void a(a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<ae> r101 = this.f26003b.values().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ae r102 = r101.next();
        if (r102 == null) goto L6;
        r102.a(r100);
        goto L6
    }

    public final synchronized ae a(String r100) {
        monitor-enter(this);
        ae r101 = this.f26003b.get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(b r100, Object r101) {
        Iterator<ae> r102 = this.f26003b.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        ae r103 = r102.next();
        if (r103 == null) goto L4;
        r103.a(r100, r101);
        goto L4
    }

    public final void a(String r100, a r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L11;
        ae r102 = this.f26003b.get(r100);
        if (r102 == null) goto L10;
        r102.a(r101);
        return;
    L10:
        return;
    L11:
        return;
    }

    public final synchronized void a(String r100, ae r101) {
        monitor-enter(this);
        this.f26003b.put(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
