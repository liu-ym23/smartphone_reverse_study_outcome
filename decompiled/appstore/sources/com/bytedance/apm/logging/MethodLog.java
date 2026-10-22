package com.bytedance.apm.logging;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class MethodLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LogImp f6518a;

    public interface LogImp {
        void d(String r10, String r11, Object... r12);

        void e(String r10, String r11, Object... r12);

        void i(String r10, String r11, Object... r12);

        void printErrStackTrace(String r10, Throwable r11, String r12, Object... r13);

        void v(String r10, String r11, Object... r12);

        void w(String r10, String r11, Object... r12);
    }

    public static class a implements LogImp {
        public a() {
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void d(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.d(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void e(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.e(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void i(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.i(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void printErrStackTrace(String r10, Throwable r11, String r12, Object... r13) {
            if (r13 != null) goto L4;
        L7:
            if (r12 != null) goto L9;
            r12 = "";
        L9:
            Log.e(r10, r12 + "  " + Log.getStackTraceString(r11));
            return;
        L4:
            if (r13.length == 0) goto L7;
            r12 = String.format(r12, r13);
            goto L7
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void v(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.v(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }

        @Override // com.bytedance.apm.logging.MethodLog.LogImp
        public void w(String r10, String r11, Object... r12) {
            if (r12 != null) goto L4;
        L7:
            Log.w(r10, r11);
            return;
        L4:
            if (r12.length == 0) goto L7;
            r11 = String.format(r11, r12);
            goto L7
        }
    }

    static {
        f6518a = new a();
    }
}
