package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class LooperPrinterUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f33647a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PrinterWrapper f33648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f33649c;

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
            if (LooperPrinterUtils.a() == null) goto L8;
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
            if (this.mPrinters.size() <= LooperPrinterUtils.b()) goto L23;
            INVOKESTATIC_com_obric_matrix_platform_sdk_ones_commonmonitor_fps_LooperPrinterUtils$PrinterWrapper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
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
            if (LooperPrinterUtils.a() != null) goto L41;
            return;
        L41:
            if (r3 <= 0) goto L56;
            LooperPrinterUtils.a().a(System.currentTimeMillis() - r3);
            return;
        L56:
            return;
        L8:
            r3 = 0;
            goto L10
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_matrix_platform_sdk_ones_commonmonitor_fps_LooperPrinterUtils$PrinterWrapper_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    public interface a {
        void a(long r1);
    }

    static {
    }

    static /* synthetic */ a a() {
        return f33649c;
    }

    static /* synthetic */ int b() {
        return f33647a;
    }

    private LooperPrinterUtils() {
    }
}
