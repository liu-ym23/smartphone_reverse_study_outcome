package com.bytedanceos.appstore.buss.utilities;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.x;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f8868e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f8869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CountDownTimer f8871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f8872d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f8873a;

        public b(p r10, long r11) {
            this.f8873a = r10;
            super(r11, 1000);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            EventBus.getDefault().post(new p7.b());
            cancel();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long r10) {
            this.f8873a.d(Integer.valueOf((int) r10));
            TextView r11 = this.f8873a.b();
            x r12 = x.f21192a;
            String r13 = BaseApplication.c().getResources().getString(R.string.ad_skip);
            kotlin.jvm.internal.q.f(r13, "getString(...)");
            String r14 = String.format(r13, Arrays.copyOf(new Object[]{Integer.valueOf((int) (r10 / ((long) 1000)))}, 1));
            kotlin.jvm.internal.q.f(r14, "format(...)");
            r11.setText(r14);
        }
    }

    static {
        f8868e = new a(null);
    }

    public p(TextView r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "textView");
        this.f8869a = r10;
        this.f8870b = r11;
        this.f8872d = 0;
        int r12 = this.f8870b * 1000;
        this.f8870b = r12;
        this.f8872d = Integer.valueOf(r12 + 100);
    }

    public final void a() {
        CountDownTimer r10 = this.f8871c;
        if (r10 == null) goto L6;
        kotlin.jvm.internal.q.d(r10);
        r10.cancel();
        this.f8871c = null;
        return;
    }

    public final TextView b() {
        return this.f8869a;
    }

    public final void c() {
        a();
        Integer r10 = this.f8872d;
        kotlin.jvm.internal.q.d(r10);
        this.f8871c = new b(this, r10.intValue()).start();
    }

    public final void d(Integer r10) {
        this.f8872d = r10;
    }
}
