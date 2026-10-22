package com.bytedance.common.utility;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class LooperPrinterUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f6676a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PrinterWrapper f6677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f6678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f6679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Printer f6680e;

    static class PrinterWrapper implements Printer {
        private static final char END = '<';
        private static final char START = '>';
        boolean haveAdd;
        boolean haveRemove;
        List<Printer> mAddPrinters;
        List<Printer> mPrinters;
        List<Printer> mRemovePrinters;

        public static /* synthetic */ int access$000(String r0, String r1) {
            return Log.e(r0, r1);
        }

        PrinterWrapper() {
            this.mPrinters = new ArrayList();
            this.mRemovePrinters = new ArrayList();
            this.mAddPrinters = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        @Override // android.util.Printer
        public void println(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            if (LooperPrinterUtils.c() == null) goto L8;
            long r3 = System.currentTimeMillis();
        L10:
            if (r10.charAt(0) != '>') goto L21;
            if (this.haveAdd == false) goto L21;
            Iterator<Printer> r5 = this.mAddPrinters.iterator();
        L15:
            if (r5.hasNext() == false) goto L19;
            Printer r6 = (Printer) ZeusTransformUtils.preCheckCast(r5.next(), Printer.class, "com.obric.aiagent.plugin");
            if (this.mPrinters.contains(r6) == true) goto L15;
            this.mPrinters.add(r6);
            goto L15
        L19:
            this.mAddPrinters.clear();
            this.haveAdd = false;
        L21:
            if (this.mPrinters.size() <= LooperPrinterUtils.d()) goto L23;
            INVOKESTATIC_com_bytedance_common_utility_LooperPrinterUtils$PrinterWrapper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L23:
            Iterator<Printer> r7 = this.mPrinters.iterator();
        L25:
            if (r7.hasNext() == false) goto L30;
            Printer r8 = (Printer) ZeusTransformUtils.preCheckCast(r7.next(), Printer.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L25;
            r8.println(r10);
            goto L25
        L30:
            if (r10.charAt(0) != '<') goto L39;
            if (this.haveRemove == false) goto L39;
            Iterator<Printer> r11 = this.mRemovePrinters.iterator();
        L35:
            if (r11.hasNext() == false) goto L37;
            Printer r9 = (Printer) ZeusTransformUtils.preCheckCast(r11.next(), Printer.class, "com.obric.aiagent.plugin");
            this.mPrinters.remove(r9);
            this.mAddPrinters.remove(r9);
            goto L35
        L37:
            this.mRemovePrinters.clear();
            this.haveRemove = false;
        L39:
            if (LooperPrinterUtils.c() != null) goto L41;
            return;
        L41:
            if (r3 <= 0) goto L56;
            LooperPrinterUtils.c().a(System.currentTimeMillis() - r3);
            return;
        L56:
            return;
        L8:
            r3 = 0;
            goto L10
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_bytedance_common_utility_LooperPrinterUtils$PrinterWrapper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    public interface a {
        void a(long r1);
    }

    static {
    }

    static /* synthetic */ a c() {
        return f6678c;
    }

    static /* synthetic */ int d() {
        return f6676a;
    }

    public static void a() {
        if (f6679d == false) goto L5;
        return;
    L5:
        f6679d = true;
        f6677b = new PrinterWrapper();
        Printer r0 = e();
        f6680e = r0;
        if (r0 == null) goto L8;
        f6677b.mPrinters.add(f6680e);
    L8:
        Looper.getMainLooper().setMessageLogging(f6677b);
    }

    public static void a(Printer r2) {
        Printer r3 = (Printer) ZeusTransformUtils.wrapperContextForParams(r2, Printer.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (f6677b.mAddPrinters.contains(r3) == true) goto L9;
        f6677b.mAddPrinters.add(r3);
        f6677b.haveAdd = true;
        return;
    }

    public static void b(Printer r2) {
        Printer r3 = (Printer) ZeusTransformUtils.wrapperContextForParams(r2, Printer.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (f6677b.mRemovePrinters.contains(r3) == true) goto L9;
        f6677b.mRemovePrinters.add(r3);
        f6677b.haveRemove = true;
        return;
    }

    private static Printer e() {
        Field r1 = ZeusTransformUtils.forName("android.os.Looper", "com.obric.aiagent.plugin").getDeclaredField("mLogging");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return (Printer) ZeusTransformUtils.preCheckCast(r1.get(Looper.getMainLooper()), Printer.class, "com.obric.aiagent.plugin");
    L5:
        return null;
    }

    public static List<Printer> b() {
        PrinterWrapper r0 = f6677b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.mPrinters;
    }
}
