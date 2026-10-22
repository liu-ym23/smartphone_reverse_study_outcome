package com.bytedance.android.livesdk.chatroom.detail;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f105635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f105636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f105637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f105638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f105639e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f105640a;

        @Override // java.lang.Runnable
        public final void run() {
            c0 r100 = this.f105640a;     // Catch: Throwable -> L8
            if (r100.f105636b == true) goto L11;
            b r101 = r100.f105637c;     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            ((mj1.f) r101).f514155a.Hn();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(c0 r100) {
            this.f105640a = r100;
        }
    }

    public interface b {
    }

    public c0(Handler r100, mj1.f r101) {
        this.f105635a = true;
        this.f105639e = new a(this);
        this.f105638d = r100;
        this.f105637c = r101;
    }
}
