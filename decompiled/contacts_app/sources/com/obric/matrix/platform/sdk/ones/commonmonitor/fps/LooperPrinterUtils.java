package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Printer;
import com.GlobalProxyLancet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class LooperPrinterUtils {
    private static final int DEFAULT_MAX_COUNT = 5;
    private static boolean isInit = false;
    private static int mMaxCount = 5;
    private static PrinterListener sListener;
    private static Printer sOriginPrinter;
    private static PrinterWrapper sPrinterWrapper;

    public interface PrinterListener {
        void onDuration(long r1);
    }

    static class PrinterWrapper implements Printer {
        private static final char END = '<';
        private static final char START = '>';
        boolean haveAdd;
        boolean haveRemove;
        List<Printer> mAddPrinters;
        List<Printer> mPrinters;
        List<Printer> mRemovePrinters;

        PrinterWrapper() {
            this.mPrinters = new ArrayList();
            this.mRemovePrinters = new ArrayList();
            this.mAddPrinters = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        @Override // android.util.Printer
        public void println(String r9) {
            if (TextUtils.isEmpty(r9) == false) goto L6;
            return;
        L6:
            if (LooperPrinterUtils.access$000() == null) goto L8;
            long r3 = System.currentTimeMillis();
        L10:
            if (r9.charAt(0) != '>') goto L21;
            if (this.haveAdd == false) goto L21;
            Iterator<Printer> r5 = this.mAddPrinters.iterator();
        L15:
            if (r5.hasNext() == false) goto L19;
            Printer r6 = r5.next();
            if (this.mPrinters.contains(r6) == true) goto L15;
            this.mPrinters.add(r6);
            goto L15
        L19:
            this.mAddPrinters.clear();
            this.haveAdd = false;
        L21:
            if (this.mPrinters.size() <= LooperPrinterUtils.access$100()) goto L23;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
        L23:
            Iterator<Printer> r7 = this.mPrinters.iterator();
        L25:
            if (r7.hasNext() == false) goto L30;
            Printer r8 = r7.next();
            if (r8 == null) goto L25;
            r8.println(r9);
            goto L25
        L30:
            if (r9.charAt(0) != '<') goto L39;
            if (this.haveRemove == false) goto L39;
            Iterator<Printer> r10 = this.mRemovePrinters.iterator();
        L35:
            if (r10.hasNext() == false) goto L37;
            Printer r11 = r10.next();
            this.mPrinters.remove(r11);
            this.mAddPrinters.remove(r11);
            goto L35
        L37:
            this.mRemovePrinters.clear();
            this.haveRemove = false;
        L39:
            if (LooperPrinterUtils.access$000() != null) goto L41;
            return;
        L41:
            if (r3 <= 0) goto L56;
            LooperPrinterUtils.access$000().onDuration(System.currentTimeMillis() - r3);
            return;
        L56:
            return;
        L8:
            r3 = 0;
            goto L10
        }
    }

    static {
    }

    static /* synthetic */ PrinterListener access$000() {
        return sListener;
    }

    static /* synthetic */ int access$100() {
        return mMaxCount;
    }

    private LooperPrinterUtils() {
    }

    public static void init() {
        if (isInit == false) goto L5;
        return;
    L5:
        isInit = true;
        sPrinterWrapper = new PrinterWrapper();
        Printer r0 = getCurrentPrinter();
        sOriginPrinter = r0;
        if (r0 == null) goto L8;
        sPrinterWrapper.mPrinters.add(sOriginPrinter);
    L8:
        Looper.getMainLooper().setMessageLogging(sPrinterWrapper);
    }

    public static void release() {
        if (isInit == true) goto L5;
        return;
    L5:
        isInit = false;
        Looper.getMainLooper().setMessageLogging(sOriginPrinter);
        sPrinterWrapper = null;
    }

    public static void addMessageLogging(Printer r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (sPrinterWrapper.mAddPrinters.contains(r1) == true) goto L8;
        sPrinterWrapper.mAddPrinters.add(r1);
        sPrinterWrapper.haveAdd = true;
        return;
    }

    public static void removeMessageLogging(Printer r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (sPrinterWrapper.mRemovePrinters.contains(r1) == true) goto L8;
        sPrinterWrapper.mRemovePrinters.add(r1);
        sPrinterWrapper.haveRemove = true;
        return;
    }

    private static Printer getCurrentPrinter() {
        Field r0 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r0.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static void setMaxCount(int r0) {
        mMaxCount = r0;
    }

    public static List<Printer> getPrinters() {
        PrinterWrapper r0 = sPrinterWrapper;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.mPrinters;
    }

    public static void setPrinterLisnter(PrinterListener r0) {
        sListener = r0;
    }
}
