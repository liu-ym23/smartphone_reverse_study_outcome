package com.bytedance.android.livesdk.chatroom.multitask;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.bytedance.android.livesdk.chatroom.multitask.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f107027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f107028c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f107029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f107030b;

        public final Context getContext() {
            return this.f107030b;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f107030b = r100;
            this.f107029a = new c(0);
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f107031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f107032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f107033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f107034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function1<? super Dialog, Unit> f107035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Function1<? super Dialog, Unit> f107036f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Function1<? super Dialog, Unit> f107037g;

        public c(int r100) {
            Intrinsics.checkNotNullParameter("", "imageResId");
            this.f107031a = "";
            this.f107032b = -1;
            this.f107033c = -1;
            this.f107034d = -1;
            this.f107035e = null;
            this.f107036f = null;
            this.f107037g = null;
        }
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        LinearLayout r111 = new LinearLayout(this.f107027b);
        r111.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r111.setGravity(81);
        r111.setOrientation(1);
        RoundCornerImageView r100 = new RoundCornerImageView(getContext(), null, 6, 0);
        r100.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, (int) (s1.y() / 1.6741072f)));
        r100.J(s1.f(20.0f), 0, s1.f(20.0f), 0);
        String r101 = i2.f114501a;
        i2.h(r100, this.f107028c.f107031a);
        r111.addView(r100);
        TextView r102 = new TextView(this.f107027b);
        r102.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, s1.f(62.0f)));
        r102.setGravity(17);
        r102.setTextColor(s1.h(R.color.ttlive_live_dialog_title));
        r102.setTextSize(1, 17.0f);
        r102.setText(this.f107028c.f107032b);
        r102.setTypeface(Typeface.DEFAULT_BOLD);
        r102.setPadding(0, s1.f(24.0f), 0, s1.f(14.0f));
        r102.setBackgroundResource(this.f107028c.f107034d);
        r111.addView(r102);
        TextView r103 = new TextView(this.f107027b);
        r103.setLayoutParams(new ViewGroup.MarginLayoutParams(s1.f(342.0f), -1));
        r103.setTextColor(s1.h(R.color.ttlive_live_dialog_title));
        r103.setTextSize(1, 15.0f);
        r103.setText(this.f107028c.f107033c);
        r103.setTypeface(Typeface.DEFAULT_BOLD);
        r103.setGravity(17);
        r103.setBackgroundResource(R.drawable.ttlive_independent_task_guide_button_bg);
        r103.setOnClickListener(new f(this));
        LinearLayout r104 = new LinearLayout(this.f107027b);
        r104.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, s1.f(66.0f)));
        r104.setOrientation(1);
        r104.setGravity(1);
        r104.setPadding(0, 0, 0, s1.f(24.0f));
        r104.setBackgroundResource(this.f107028c.f107034d);
        r104.addView(r103);
        r111.addView(r104);
        Unit r105 = Unit.INSTANCE;
        setContentView(r111);
    }

    public e(Context r100, c r101) {
        super(r100);
        this.f107027b = r100;
        this.f107028c = r101;
    }
}
