package com.bytedance.android.shopping.mall.opt;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f178569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f178570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f178571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178572d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f178573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f178574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f178575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f178576d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f178577e;

        public b(long r100, g r101, boolean r102, int r103, int r104) {
            this.f178573a = r100;
            this.f178574b = r101;
            this.f178575c = r102;
            this.f178576d = r103;
            this.f178577e = r104;
        }

        public final void a() {
            JSONObject r100 = new JSONObject();
            r100.putOpt("type", this.f178574b.f178571c);
            if (this.f178575c == false) goto L5;
            String r101 = "success";
        L6:
            r100.putOpt("timing", r101);
            r100.putOpt("filedTiming", Integer.valueOf(this.f178576d));
            r100.putOpt("failedReason", Integer.valueOf(this.f178577e));
            r100.putOpt("pageName", this.f178574b.f178572d);
            r100.putOpt("startT", Long.valueOf(this.f178574b.f178569a));
            r100.putOpt("reportT", Long.valueOf(this.f178573a));
            JSONObject r102 = this.f178574b.f178570b;
            if (r102 == null) goto L17;
            Iterator<String> r103 = r102.keys();
            if (r103 == null) goto L17;
        L11:
            if (r103.hasNext() == false) goto L17;
            String r104 = r103.next();
            JSONObject r105 = this.f178574b.f178570b;
            if (r105 == null) goto L15;
            Object r106 = r105.opt(r104);
        L16:
            r100.putOpt(r104, r106);
            goto L11
        L15:
            r106 = null;
        L17:
            Unit r107 = Unit.INSTANCE;
            AppLogNewUtils.onEventV3("mall_gyl_refresh", r100);
            return;
        L5:
            r101 = "failed";
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f178578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f178579b;

        public c(g r100, JSONObject r101) {
            this.f178578a = r100;
            this.f178579b = r101;
        }

        public final void a() {
            JSONObject r100 = new JSONObject();
            r100.putOpt("type", this.f178578a.f178571c);
            r100.putOpt("timing", this.f178578a.f178571c);
            r100.putOpt("pageName", this.f178578a.f178572d);
            r100.putOpt("startT", Long.valueOf(this.f178578a.f178569a));
            JSONObject r101 = this.f178579b;
            if (r101 == null) goto L9;
            Iterator<String> r102 = r101.keys();
            if (r102 == null) goto L9;
        L7:
            if (r102.hasNext() == false) goto L9;
            String r103 = r102.next();
            r100.putOpt(r103, this.f178579b.opt(r103));
        L9:
            Unit r104 = Unit.INSTANCE;
            AppLogNewUtils.onEventV3("mall_gyl_refresh", r100);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void b(JSONObject r100) {
        this.f178570b = r100;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(ThreadPoolHelper.c().submit(new c(this, r100)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        this.f178571c = r100;
        this.f178572d = r101;
        this.f178569a = System.currentTimeMillis();
    }

    public final void a(boolean r110, int r111, int r112) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L4
        Result.m9449constructorimpl(ThreadPoolHelper.c().submit(new b(r101, this, r110, r111, r112)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
