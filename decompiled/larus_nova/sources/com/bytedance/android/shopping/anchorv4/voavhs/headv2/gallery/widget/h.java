package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f169507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f169508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f169509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f169510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f169511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f169512f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f169513a;

        public a(h r100) {
            this.f169513a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f169513a;     // Catch: Throwable -> L4
            r100.f169509c.animate().alpha(0.0f).setDuration(300).setListener(new i(r100)).start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f169514a;

        public b(h r100) {
            this.f169514a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f169514a.f169507a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        this.f169508b = new LinkedHashSet();
        this.f169511e = new a(this);
        LinearLayout r100 = new LinearLayout(r110);
        this.f169509c = r100;
        r100.setPadding(0, com.bytedance.android.shopping.extensions.b.a(10), 0, com.bytedance.android.shopping.extensions.b.a(10));
        BackgroundDrawable r101 = new BackgroundDrawable(r110, null, false, 4, null);
        r101.setBgColor(872415231);
        r101.setStrokeColor((int) 2298478591L);
        r101.setStrokeWidth(com.bytedance.android.shopping.extensions.b.a(Double.valueOf(0.2d)));
        r101.setCornerRadiusTL(q.a(12));
        r101.setCornerRadiusBL(q.a(12));
        r101.invalidate();
        Unit r102 = Unit.INSTANCE;
        r100.setBackground(r101);
        r100.setOrientation(1);
        r100.setGravity(1);
        ImageView r103 = new ImageView(r110);
        r103.setImageResource(R.drawable.anchor_v4_gallery_next_video);
        r100.addView(r103, com.bytedance.android.shopping.extensions.b.a(10), com.bytedance.android.shopping.extensions.b.a(10));
        TextView r104 = new TextView(r110);
        this.f169507a = r104;
        r104.setGravity(1);
        int r105 = g1.f45599a;
        r104.setTextColor(g1.a.a(r110, R.color.commerce_color_FF161823));
        r104.setTextSize(1, 12.0f);
        r104.setEms(1);
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -2);
        r111.topMargin = com.bytedance.android.shopping.extensions.b.a(8);
        r100.addView(r104, r111);
        addView(r100, new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(23), -2));
        r100.setVisibility(4);
    }

    private final void setVideoLabel(String r100) {
        TextView r101 = this.f169507a;
        if (a2.d(r100) == null) goto L6;
        String r102 = "·" + r100;
        if (r102 == null) goto L6;
    L7:
        r101.setText("下一个视频".concat(r102));
        post(new b(this));
        return;
    L6:
        r102 = "";
        goto L7
    }

    public static final /* synthetic */ void a(h r100, String r101) {
        r100.setVideoLabel(r101);
    }
}
