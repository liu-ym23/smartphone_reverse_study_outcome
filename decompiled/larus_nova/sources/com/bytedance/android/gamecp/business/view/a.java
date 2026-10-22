package com.bytedance.android.gamecp.business.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.utils.p0;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends com.bytedance.android.gamecp.business.gamedetail.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f56490a;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.view.a$a, reason: collision with other inner class name */
    public static final class C0907a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f56491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f56492b;

        public final void a() {
            a r100 = new a(this.f56492b, this.f56491a);
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        public final Context getContext() {
            return this.f56492b;
        }

        public C0907a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f56492b = r100;
            this.f56491a = new c(new ArrayList());
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f56493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function2<Dialog, View, Unit> f56494b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(CharSequence r100, Function2<? super Dialog, ? super View, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "itemText");
            this.f56493a = r100;
            this.f56494b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f56495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f56496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f56497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f56498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f56499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f56500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f56501g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f56502h;

        public c(List r100) {
            int r101 = y0.c(R.color.gamecp_core_hs_s9);
            int r102 = y0.b(56.0f);
            int r103 = y0.c(R.color.gamecp_live_dialog_title);
            Intrinsics.checkNotNullParameter(r100, "itemList");
            this.f56495a = null;
            this.f56496b = r100;
            this.f56497c = null;
            this.f56498d = r101;
            this.f56499e = 15.0f;
            this.f56500f = r102;
            this.f56501g = r103;
            this.f56502h = true;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f56503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f56504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f56505c;

        public d(TextView r100, a r101, b r102) {
            this.f56503a = r100;
            this.f56504b = r101;
            this.f56505c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function2<Dialog, View, Unit> r101 = this.f56505c.f56494b;
            if (r101 == null) goto L6;
            Unit r102 = r101.invoke(this.f56504b, this.f56503a);
            return;
        }
    }

    public final View b() {
        View r100 = new View(getContext());
        r100.setBackgroundResource(R.color.gamecp_core_hs_s9);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, y0.b(1.0f)));
        return r100;
    }

    public final TextView a(b r100) {
        TextView r101 = new TextView(getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f56490a.f56500f));
        r101.setGravity(17);
        r101.setTextSize(1, this.f56490a.f56499e);
        r101.setTextColor(this.f56490a.f56501g);
        r101.setText(r100.f56493a);
        r101.setOnClickListener(new d(r101, this, r100));
        return r101;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        WindowManager.LayoutParams r101 = null;
        if (this.f56490a.f56502h == false) goto L5;
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_game_promote_dialog_common_bottom, null));
    L6:
        Window r102 = getWindow();
        if (r102 == null) goto L15;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L13;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L13;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L13:
        if (r103 == null) goto L15;
        r103.setPadding(0, 0, 0, 0);
    L15:
        Window r105 = getWindow();
        if (r105 == null) goto L19;
        r101 = r105.getAttributes();
    L19:
        if (p0.a() == true) goto L24;
        if (r101 == null) goto L22;
        r101.width = -1;
    L22:
        if (r101 == null) goto L28;
        r101.gravity = 80;
    L28:
        Window r106 = getWindow();
        if (r106 == null) goto L31;
        r106.setAttributes(r101);
    L31:
        Window r107 = getWindow();
        if (r107 == null) goto L34;
        r107.setDimAmount(0.0f);
    L34:
        LinearLayout r108 = (LinearLayout) findViewById(R.id.ll_game_promote_common_bottom_dialog_parent);
        b r109 = this.f56490a.f56495a;
        if (r109 == null) goto L40;
        if (r108 == null) goto L38;
        TextView r110 = new TextView(getContext());
        r110.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f56490a.f56500f));
        r110.setGravity(17);
        r110.setTextSize(1, this.f56490a.f56499e);
        r110.setTextColor(this.f56490a.f56501g);
        r110.setText(r109.f56493a);
        r108.addView(r110);
    L38:
        if (r108 == null) goto L40;
        r108.addView(b());
    L40:
        Iterator<T> r111 = this.f56490a.f56496b.iterator();
    L42:
        if (r111.hasNext() == false) goto L48;
        b r112 = (b) r111.next();
        if (r108 == null) goto L46;
        r108.addView(a(r112));
    L46:
        if (r108 == null) goto L42;
        r108.addView(b());
        goto L42
    L48:
        b r113 = this.f56490a.f56497c;
        if (r113 == null) goto L60;
        if (r108 == null) goto L52;
        View r114 = new View(getContext());
        r114.setBackgroundColor(this.f56490a.f56498d);
        r114.setLayoutParams(new ViewGroup.LayoutParams(-1, y0.b(8.0f)));
        r108.addView(r114);
    L52:
        if (r108 == null) goto L61;
        r108.addView(a(r113));
        return;
    L61:
        return;
    L60:
        return;
    L24:
        if (r101 == null) goto L26;
        r101.width = y0.b(393.0f);
    L26:
        if (r101 == null) goto L28;
        r101.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        goto L28
    L5:
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.gamecp_game_promote_dialog_common_bottom_horizontal, null));
        goto L6
    }

    public a(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        boolean r102 = r101.f56502h;
        super(r100, R.style.gamecp_common_bottom_dialog_no_full_screen);
        this.f56490a = r101;
    }
}
