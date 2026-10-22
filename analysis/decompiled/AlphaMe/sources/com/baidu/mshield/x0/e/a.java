package com.baidu.mshield.x0.e;

import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static a f8403a = new a();

    /* renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f8404b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8405c;

    /* renamed from: d, reason: collision with root package name */
    public b f8406d;

    public static a a() {
        return f8403a;
    }

    public synchronized void b() {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f8404b;
            if (uncaughtExceptionHandler != null) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                this.f8404b = null;
            }
        } finally {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String strA = a(th);
            if (!TextUtils.isEmpty(strA) && (strA.contains("mshield") || strA.contains("WebViewProvider") || strA.contains("createWebView"))) {
                b bVar = this.f8406d;
                if (bVar != null) {
                    bVar.a(strA);
                }
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f8404b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public synchronized void a(b bVar) {
        this.f8406d = bVar;
        if (bVar == null) {
            return;
        }
        if (bVar.a()) {
            if (this.f8405c) {
                return;
            }
            this.f8405c = true;
            this.f8404b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public final String a(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
        } catch (Throwable unused) {
            printWriter = null;
        }
        try {
            th.printStackTrace(printWriter);
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Throwable unused2) {
            if (printWriter == null) {
                return "";
            }
            printWriter.close();
            return "";
        }
    }
}
