package com.bytedance.android.livesdk.interactivity.imagerecognition;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: classes9.dex */
public final class ImageRecognitionTask {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f136950q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f136951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f136952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageRecognitionDialogFragment f136953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f136954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f136955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f136956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f136957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f136958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d8 f136959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f136960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageRecognitionEntry f136961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f136962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageRecognitionBusiness f136963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f136964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FragmentManager f136965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f136966p;

    public static final class a {
    }

    public interface b {
        void onCancel();

        void onFailed();

        void onSuccess();
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRecognitionTask f136967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f136968b;

        public c(ImageRecognitionTask r100, Function0 r101) {
            this.f136967a = r100;
            this.f136968b = r101;
        }

        public final void a() {
            ImageRecognitionTask r100 = this.f136967a;
            String r101 = "close action run. state=" + this.f136967a.f136951a;
            r100.getClass();
            ImageRecognitionTask.e(r101);
            ImageRecognitionDialogFragment r102 = this.f136967a.f136953c;
            if (r102 != null) goto L13;
        L11:
            this.f136967a.f136954d = 0;
            this.f136968b.invoke();
            return;
        L13:
            r102.dismissAllowingStateLoss();     // Catch: Exception -> L6
        L10:
            this.f136967a.f136953c = null;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L10;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
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

    public final boolean d() {
        if (this.f136951a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void b() {
        if (d() == true) goto L15;
        int r100 = this.f136951a;
        if (r100 != 2) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L15;
        if (r100 != 0) goto L26;
        this.f136951a = 5;
        b r102 = this.f136966p;
        if (r102 == null) goto L27;
        r102.onCancel();
        return;
    L27:
        return;
    L26:
        return;
    L7:
        r101 = false;
    L15:
        if (d() == true) goto L19;
        if (this.f136958h.f136985c == 0) goto L19;
    L22:
        this.f136951a = 5;
        c(true, ImageRecognitionTask$cancel$1.INSTANCE);
        this.f136956f.dispose();
        this.f136955e.removeCallbacksAndMessages(null);
        b r103 = this.f136966p;
        if (r103 == null) goto L29;
        r103.onCancel();
        return;
    L29:
        return;
    L19:
        if (d() == false) goto L21;
        d r104 = this.f136958h;
        r104.f136995m = System.currentTimeMillis() - this.f136952b;
    L21:
        d r105 = this.f136958h;
        r105.f136985c = -1;
        Intrinsics.checkNotNullParameter("user cancel", "<set-?>");
        r105.f136986d = "user cancel";
        int r106 = com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.f136999a;
        int r107 = this.f136960j;
        ImageRecognitionEntry r108 = this.f136961k;
        d r109 = this.f136958h;
        Intrinsics.checkNotNullParameter(r108, "entry");
        Intrinsics.checkNotNullParameter(r109, "ctx");
        com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a(r107, r108, r109);
        goto L22
    }

    public static void e(String r100) {
        int r101 = f.f540454a;
        f.b("[RecognitionTask] " + r100);
    }

    public static final void a(final ImageRecognitionTask r100, Throwable r101) {
        if (r100.d() == false) goto L6;
        r100.f136951a = 2;
        r100.f136958h.f136995m = System.currentTimeMillis() - r100.f136952b;
        int r102 = com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.f136999a;
        int r103 = r100.f136960j;
        ImageRecognitionEntry r104 = r100.f136961k;
        d r105 = r100.f136958h;
        Intrinsics.checkNotNullParameter(r104, "entry");
        Intrinsics.checkNotNullParameter(r105, "ctx");
        com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a(r103, r104, r105);
        f("onRecognitionFailed. cost " + r100.f136958h.f136995m + "ms. logId=" + r100.f136958h.f136997o + " msg=" + r100.f136958h.f136986d + " requestId=" + r100.f136958h.f136996n, r101);
        r100.c(false, new ImageRecognitionTask$onRecognitionFailed$1(r100));
        return;
    }

    public static void f(String r100, Throwable r101) {
        if (r101 != null) goto L5;
        int r102 = f.f540454a;
        f.a("[RecognitionTask] " + r100);
        return;
    L5:
        int r103 = f.f540454a;
        String r104 = "[RecognitionTask] " + r100;
        Intrinsics.checkNotNullParameter(r104, "info");
        Intrinsics.checkNotNullParameter(r101, "t");
        ALogger.e("ImageRecognition", r104, r101);
    }

    public final void c(boolean r100, Function0<Unit> r101) {
        c r102 = this.f136957g;
        if (r102 == null) goto L5;
        this.f136955e.removeCallbacks(r102);
        this.f136957g = null;
    L5:
        c r103 = new c(this, r101);
        if (r100 == true) goto L14;
        long r104 = this.f136954d;
        if (r104 == 0) goto L14;
        long r105 = r104 - SystemClock.elapsedRealtime();
        if (r105 <= 0) goto L13;
        this.f136957g = r103;
        this.f136955e.postDelayed(r103, r105);
        return;
    L13:
        r103.run();
        return;
    L14:
        r103.run();
    }

    public ImageRecognitionTask(d8 r100, int r101, ImageRecognitionEntry r102, String r103, ImageRecognitionBusiness r104, Context r105, FragmentManager r106, com.bytedance.android.livesdk.interactivity.imagerecognition.b r107) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r102, "entry");
        Intrinsics.checkNotNullParameter(r104, "business");
        this.f136959i = r100;
        this.f136960j = r101;
        this.f136961k = r102;
        this.f136962l = r103;
        this.f136963m = r104;
        this.f136964n = r105;
        this.f136965o = r106;
        this.f136966p = r107;
        this.f136955e = new Handler(Looper.getMainLooper());
        this.f136956f = new CompositeDisposable();
        this.f136958h = new d();
    }
}
