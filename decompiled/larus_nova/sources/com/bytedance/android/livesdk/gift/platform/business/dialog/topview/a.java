package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f126582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f126583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h1 f126584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f126585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f126586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f126587f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC2029a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f126588a;

        public ViewOnClickListenerC2029a(a r100) {
            this.f126588a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f126588a.d();
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public void a() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public void b() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public void c() {
    }

    public abstract void d();

    public void e(long r100) {
    }

    public void f(p2 r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }

    public abstract void g(e0 r100);

    public final Context getContext() {
        return this.f126586e;
    }

    public a(Context r100, DataCenter r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        this.f126586e = r100;
        this.f126587f = r110;
        View r101 = LayoutInflater.from(r100).inflate(r111, new FrameLayout(r100), false);
        if (r101 == null) goto L7;
        ViewGroup r102 = (ViewGroup) r101;
        this.f126582a = r102;
        r102.setOnClickListener(new ViewOnClickListenerC2029a(this));
        this.f126583b = new g(r102, a1.b(r102.getLayoutParams(), null, null, null, null, null, null, null), this);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
