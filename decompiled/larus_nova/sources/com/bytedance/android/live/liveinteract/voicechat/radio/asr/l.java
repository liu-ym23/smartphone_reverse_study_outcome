package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f80524a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f80525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80526b;

        public a(l r100, String r101) {
            this.f80525a = r100;
            this.f80526b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r100 = this.f80525a.f80524a.f80518g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b(this.f80526b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f80527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.liveinteract.voicechat.radio.asr.e f80528b;

        public b(l r100, com.bytedance.android.live.liveinteract.voicechat.radio.asr.e r101) {
            this.f80527a = r100;
            this.f80528b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r100 = this.f80527a.f80524a.f80518g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.a(this.f80528b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f80529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80530b;

        public c(l r100, String r101) {
            this.f80529a = r100;
            this.f80530b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r100 = this.f80529a.f80524a.f80518g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.c(this.f80530b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f80531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80532b;

        public d(l r100, String r101) {
            this.f80531a = r100;
            this.f80532b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r100 = this.f80531a.f80524a.f80518g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onStart(this.f80532b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f80533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f80534b;

        public e(l r100, String r101) {
            this.f80533a = r100;
            this.f80534b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r100 = this.f80533a.f80524a.f80518g;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.onStop(this.f80534b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public l(k r100) {
        this.f80524a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.g
    public final void c(com.bytedance.android.live.liveinteract.voicechat.radio.asr.e r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        AndroidSchedulers.mainThread().scheduleDirect(new b(this, r100));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.g
    public final void onStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reqId");
        h r101 = this.f80524a.f80513b;
        if (r101 == null) goto L5;
        r101.f80503f = true;
    L5:
        AndroidSchedulers.mainThread().scheduleDirect(new d(this, r100));
        Handler r102 = this.f80524a.f80515d;
        if (r102 == null) goto L9;
        r102.sendMessageDelayed(r102.obtainMessage(24, r100), ((long) this.f80524a.f80520i.intValue()) * 1000);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.g
    public final void onStop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reqId");
        h r101 = this.f80524a.f80513b;
        if (r101 == null) goto L5;
        r101.f80503f = false;
    L5:
        k r102 = this.f80524a;
        r102.f80519h = "";
        Handler r103 = r102.f80515d;
        if (r103 == null) goto L8;
        r103.removeMessages(24);
    L8:
        AndroidSchedulers.mainThread().scheduleDirect(new e(this, r100));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.f
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "reqId");
        Intrinsics.checkNotNullParameter(r101, "result");
        ALogger.d("MultiLinkAsrEngine", "onCompleteResult: " + r101);
        this.f80524a.f80519h = r101;
        AndroidSchedulers.mainThread().scheduleDirect(new a(this, r101));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.f
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "reqId");
        Intrinsics.checkNotNullParameter(r101, "result");
        if (this.f80524a.f80519h.equals(r101) == false) goto L5;
        return;
    L5:
        ALogger.d("MultiLinkAsrEngine", "onPartialResult: " + r101);
        this.f80524a.f80519h = r101;
        AndroidSchedulers.mainThread().scheduleDirect(new c(this, r101));
    }
}
