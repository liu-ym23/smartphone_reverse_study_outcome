package com.bytedance.common.utility;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LooperPrinterUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6835a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f6836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PrinterListener f6837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f6838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Printer f6839e;

    public interface PrinterListener {
        void onDuration(long r10);
    }

    public static class a implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f6840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f6841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f6842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6843d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6844e;

        public a() {
            this.f6840a = new ArrayList();
            this.f6841b = new ArrayList();
            this.f6842c = new ArrayList();
            this.f6843d = false;
            this.f6844e = false;
        }

        @Override // android.util.Printer
        public void println(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            if (LooperPrinterUtils.a() == null) goto L8;
            long r11 = System.currentTimeMillis();
        L10:
            if (r10.charAt(0) != '>') goto L21;
            if (this.f6844e == false) goto L21;
            Iterator r12 = this.f6842c.iterator();
        L15:
            if (r12.hasNext() == false) goto L19;
            Printer r13 = (Printer) r12.next();
            if (this.f6840a.contains(r13) == true) goto L15;
            this.f6840a.add(r13);
            goto L15
        L19:
            this.f6842c.clear();
            this.f6844e = false;
        L21:
            if (this.f6840a.size() <= LooperPrinterUtils.b()) goto L23;
            Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L23:
            Iterator r14 = this.f6840a.iterator();
        L25:
            if (r14.hasNext() == false) goto L30;
            Printer r15 = (Printer) r14.next();
            if (r15 == null) goto L25;
            r15.println(r10);
            goto L25
        L30:
            if (r10.charAt(0) != '<') goto L39;
            if (this.f6843d == false) goto L39;
            Iterator r16 = this.f6841b.iterator();
        L35:
            if (r16.hasNext() == false) goto L37;
            Printer r17 = (Printer) r16.next();
            this.f6840a.remove(r17);
            this.f6842c.remove(r17);
            goto L35
        L37:
            this.f6841b.clear();
            this.f6843d = false;
        L39:
            if (LooperPrinterUtils.a() != null) goto L41;
            return;
        L41:
            if (r11 <= 0) goto L56;
            LooperPrinterUtils.a().onDuration(System.currentTimeMillis() - r11);
            return;
        L56:
            return;
        L8:
            r11 = 0;
            goto L10
        }
    }

    static {
    }

    public static /* synthetic */ PrinterListener a() {
        return f6837c;
    }

    public static /* synthetic */ int b() {
        return f6835a;
    }

    public static void c(Printer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (f6836b.f6842c.contains(r10) == true) goto L8;
        f6836b.f6842c.add(r10);
        f6836b.f6844e = true;
        return;
    }

    public static Printer d() {
        Field r10 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r10.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static List e() {
        a r10 = f6836b;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.f6840a;
    }

    public static void f() {
        if (f6838d == false) goto L5;
        return;
    L5:
        f6838d = true;
        f6836b = new a();
        Printer r10 = d();
        f6839e = r10;
        if (r10 == null) goto L8;
        f6836b.f6840a.add(r10);
    L8:
        Looper.getMainLooper().setMessageLogging(f6836b);
    }

    public static void g(Printer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (f6836b.f6841b.contains(r10) == true) goto L8;
        f6836b.f6841b.add(r10);
        f6836b.f6843d = true;
        return;
    }
}
