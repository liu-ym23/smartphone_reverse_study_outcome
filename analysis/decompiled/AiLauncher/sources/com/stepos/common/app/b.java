package com.stepos.common.app;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class b {
    private static final boolean DBG = true;
    private static final int LONG_DELAY = 3500;
    private static final int MESSAGE_TIMEOUT = 1;
    private static final int SHORT_DELAY = 2000;
    private static final String TAG = "SlideNoticeManager";
    private Activity mCurActivity;
    private ArrayList<c> mNoticeQueue = new ArrayList<>();
    private d mHandler = new d();

    /* renamed from: com.stepos.common.app.b$b, reason: collision with other inner class name */
    public interface InterfaceC0347b {
        void hide();

        void show();
    }

    public static final class c {
        final Activity activity = null;
        final InterfaceC0347b callback;
        int duration;
        CharSequence message;

        public c(CharSequence charSequence, int i10, InterfaceC0347b interfaceC0347b) {
            this.message = charSequence;
            this.duration = i10;
            this.callback = interfaceC0347b;
        }

        public void a(int i10) {
            this.duration = i10;
        }

        public final String toString() {
            return "NoticeRecord{" + Integer.toHexString(System.identityHashCode(this)) + " callback=" + this.callback + " duration=" + this.duration;
        }
    }

    public final class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            b.this.e((c) message.obj);
        }
    }

    public final void b(int i10) {
        Log.d(TAG, "cancelNotice index=" + i10);
        this.mNoticeQueue.get(i10).callback.hide();
        this.mNoticeQueue.remove(i10);
        if (this.mNoticeQueue.size() > 0) {
            h();
        }
    }

    public void c(InterfaceC0347b interfaceC0347b) {
        if (interfaceC0347b == null) {
            return;
        }
        synchronized (this.mNoticeQueue) {
            try {
                int iF = f(interfaceC0347b);
                if (iF >= 0) {
                    this.mHandler.removeCallbacksAndMessages(this.mNoticeQueue.get(iF));
                    b(iF);
                } else {
                    Log.w(TAG, "Notice already cancelled. callback=" + interfaceC0347b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:7:0x002c, B:9:0x0032, B:20:0x0073, B:21:0x0076, B:12:0x0040, B:14:0x0048, B:18:0x0069, B:17:0x005f), top: B:25:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.lang.CharSequence r4, com.stepos.common.app.b.InterfaceC0347b r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "SlideNoticeManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "enqueueNotice callback="
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " message="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = " duration="
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            if (r5 != 0) goto L29
            return
        L29:
            java.util.ArrayList<com.stepos.common.app.b$c> r0 = r3.mNoticeQueue
            monitor-enter(r0)
            int r1 = r3.f(r5)     // Catch: java.lang.Throwable -> L3e
            if (r1 < 0) goto L40
            java.util.ArrayList<com.stepos.common.app.b$c> r4 = r3.mNoticeQueue     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Throwable -> L3e
            com.stepos.common.app.b$c r4 = (com.stepos.common.app.b.c) r4     // Catch: java.lang.Throwable -> L3e
            r4.a(r6)     // Catch: java.lang.Throwable -> L3e
            goto L71
        L3e:
            r3 = move-exception
            goto L78
        L40:
            java.util.ArrayList<com.stepos.common.app.b$c> r1 = r3.mNoticeQueue     // Catch: java.lang.Throwable -> L3e
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L3e
            if (r1 <= 0) goto L5f
            java.util.ArrayList<com.stepos.common.app.b$c> r1 = r3.mNoticeQueue     // Catch: java.lang.Throwable -> L3e
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L3e
            int r2 = r2 + (-1)
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L3e
            com.stepos.common.app.b$c r1 = (com.stepos.common.app.b.c) r1     // Catch: java.lang.Throwable -> L3e
            java.lang.CharSequence r1 = r1.message     // Catch: java.lang.Throwable -> L3e
            boolean r1 = android.text.TextUtils.equals(r4, r1)     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L5f
            goto L69
        L5f:
            com.stepos.common.app.b$c r1 = new com.stepos.common.app.b$c     // Catch: java.lang.Throwable -> L3e
            r1.<init>(r4, r6, r5)     // Catch: java.lang.Throwable -> L3e
            java.util.ArrayList<com.stepos.common.app.b$c> r4 = r3.mNoticeQueue     // Catch: java.lang.Throwable -> L3e
            r4.add(r1)     // Catch: java.lang.Throwable -> L3e
        L69:
            java.util.ArrayList<com.stepos.common.app.b$c> r4 = r3.mNoticeQueue     // Catch: java.lang.Throwable -> L3e
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L3e
            int r1 = r4 + (-1)
        L71:
            if (r1 != 0) goto L76
            r3.h()     // Catch: java.lang.Throwable -> L3e
        L76:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L78:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.app.b.d(java.lang.CharSequence, com.stepos.common.app.b$b, int):void");
    }

    public final void e(c cVar) {
        Log.d(TAG, "Timeout callback=" + cVar.callback);
        synchronized (this.mNoticeQueue) {
            try {
                int iF = f(cVar.callback);
                if (iF >= 0) {
                    b(iF);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int f(InterfaceC0347b interfaceC0347b) {
        ArrayList<c> arrayList = this.mNoticeQueue;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (arrayList.get(i10).callback == interfaceC0347b) {
                return i10;
            }
        }
        return -1;
    }

    public final void g(c cVar) {
        this.mHandler.removeCallbacksAndMessages(cVar);
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 1, cVar), cVar.duration == 1 ? 3500L : 2000L);
    }

    public final void h() {
        c cVar = this.mNoticeQueue.get(0);
        while (cVar != null) {
            try {
                Log.d(TAG, "Show callback=" + cVar.callback);
                cVar.callback.show();
                g(cVar);
                return;
            } catch (Exception e10) {
                Log.e(TAG, "catch an exception when showing next notice, it will be romoved from queue", e10);
                int iIndexOf = this.mNoticeQueue.indexOf(cVar);
                if (iIndexOf >= 0) {
                    this.mNoticeQueue.remove(iIndexOf);
                }
                cVar = this.mNoticeQueue.size() > 0 ? this.mNoticeQueue.get(0) : null;
            }
        }
    }
}
