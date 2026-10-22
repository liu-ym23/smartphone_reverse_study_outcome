package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class z5 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f57552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f57553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f57554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharSequence f57555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f57556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f57557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f57558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f57559h;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f57560a;

        public a(Function0 r100) {
            this.f57560a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f57560a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f57561a;

        public b(Function0 r100) {
            this.f57561a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f57561a.invoke();
        }
    }

    public z5(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.gamecp_team_play_single_title_dialog);
        this.f57555d = "";
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.gamecp_team_play_single_title_dialog);
        this.f57552a = (TextView) findViewById(R.id.tv_title);
        this.f57553b = (TextView) findViewById(R.id.tv_left_btn);
        this.f57554c = (TextView) findViewById(R.id.tv_right_btn);
        setTitle(this.f57555d);
        a(this.f57557f, this.f57559h);
        b(this.f57556e, this.f57558g);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence r100) {
        Intrinsics.checkNotNull(r100);
        this.f57555d = r100;
        TextView r101 = this.f57552a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void a(CharSequence r100, Function0<Unit> r101) {
        this.f57557f = r100;
        this.f57559h = r101;
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        TextView r102 = this.f57554c;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        TextView r103 = this.f57554c;
        if (r103 == null) goto L12;
        r103.setText(r100);
    L12:
        TextView r104 = this.f57554c;
        if (r104 == null) goto L19;
        r104.setOnClickListener(new a(r101));
        return;
    L19:
        return;
    L15:
        TextView r105 = this.f57554c;
        if (r105 == null) goto L21;
        r105.setVisibility(8);
        return;
    }

    public final void b(CharSequence r100, Function0<Unit> r101) {
        this.f57556e = r100;
        this.f57558g = r101;
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        TextView r102 = this.f57553b;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        TextView r103 = this.f57553b;
        if (r103 == null) goto L12;
        r103.setText(r100);
    L12:
        TextView r104 = this.f57553b;
        if (r104 == null) goto L19;
        r104.setOnClickListener(new b(r101));
        return;
    L19:
        return;
    L15:
        TextView r105 = this.f57553b;
        if (r105 == null) goto L21;
        r105.setVisibility(8);
        return;
    }
}
