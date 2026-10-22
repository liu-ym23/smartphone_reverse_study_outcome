package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.SpannableStringUtils;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Date;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m8 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f113711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f113712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f113713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f113714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f113715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakHandler f113716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s5 f113717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f113718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f113719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f113720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f113721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f113722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f113723m;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m8 f113724a;

        public final void a() {
            m8 r100 = this.f113724a;
            if (r100.f113720j < 1000) goto L7;
            r100.b();
            WeakHandler r101 = this.f113724a.f113716f;
            if (r101 == null) goto L31;
            r101.postDelayed(this, 1000);
            return;
        L31:
            return;
        L7:
            WeakHandler r102 = r100.f113716f;
            if (r102 == null) goto L10;
            r102.removeCallbacks(this);
        L10:
            m8 r103 = this.f113724a;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r105 == null) goto L24;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L13:
            if (Looper.myLooper() == r104.getLooper()) goto L15;
            r104.post(DialogLancet.createDismissRunnable(r103));
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

        public b(m8 r100) {
            this.f113724a = r100;
        }
    }

    static {
    }

    public final void b() {
        String r100 = this.f113721k;
        int r101 = r100.length();
        int r102 = 0;
    L3:
        int r103 = -1;
        if (r102 >= r101) goto L12;
        if (r100.charAt(r102) != '{') goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L14;
        r102 = r102 + 1;
    L14:
        if (r100 == null) goto L34;
        String r105 = r100.substring(0, r102);
        String r106 = this.f113721k;
        int r107 = r106.length();
        int r108 = 0;
    L16:
        if (r108 >= r107) goto L24;
        if (r106.charAt(r108) != '}') goto L20;
        boolean r109 = true;
    L21:
        if (r109 == true) goto L22;
        r108 = r108 + 1;
        goto L16
    L22:
        r103 = r108;
        goto L24
    L20:
        r109 = false;
    L24:
        int r110 = r103 + 1;
        int r111 = this.f113721k.length();
        if (r106 == null) goto L32;
        String r112 = r106.substring(r110, r111);
        String r113 = TimeUtils.formatVideoDuration(this.f113720j);
        SpannableString r114 = SpannableStringUtils.getDiffColorSpannable(r105 + r113 + r112, r105.length(), r105.length() + r113.length(), -65536);
        TextView r115 = this.f113712b;
        if (r115 == null) goto L29;
        r115.setText(r114);
    L29:
        this.f113720j -= 1000;
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L34:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L8:
        r104 = false;
        goto L9
    L12:
        r102 = -1;
        goto L14
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        WeakHandler r101 = this.f113716f;
        if (r101 == null) goto L21;
        r101.removeCallbacks(this.f113719i);
    L21:
        if (this.f113722l == false) goto L23;
        return;
    L23:
        if (this.f113723m == true) goto L32;
        a("close");
        return;
    L32:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        WeakHandler r100 = this.f113716f;
        if (r100 == null) goto L14;
        r100.postDelayed(this.f113719i, 1000);
        return;
    L14:
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final void a(String r100) {
        Pair[] r101 = new Pair[3];
        r101[0] = TuplesKt.to("remaining", String.valueOf(this.f113720j / 1000));
        s5 r102 = this.f113717g;
        if (r102 == null) goto L8;
        i6 r103 = r102.b();
        if (r103 == null) goto L8;
        String r104 = r103.b();
        if (r104 == null) goto L8;
    L9:
        r101[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCORE, r104);
        r101[2] = TuplesKt.to("click_type", r100);
        Map<String, String> r105 = MapsKt.mutableMapOf(r101);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_keep_popup_click", r105, new Object[]{Room.class, am2.x.class});
        return;
    L8:
        r104 = "";
        goto L9
    }

    public m8(Context r100, WeakHandler r101, Runnable r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "weakHandler");
        Intrinsics.checkNotNullParameter(r102, "afterQuitRunnable");
        super(r100, R.style.ttlive_live_dialog);
        this.f113719i = new b(this);
        this.f113720j = LinkConstant.TIME_AFTER_ENTER_BACKGROUND;
        this.f113721k = "再逛{count_down}可获得500金币，确定要退出吗？";
        String r103 = null;
        View r104 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_room_quit_with_task_layout, null);
        this.f113711a = r104;
        setContentView(r104);
        this.f113716f = r101;
        s5 r105 = l8.b();
        this.f113717g = r105;
        if (r105 == null) goto L9;
        i6 r106 = r105.b();
        if (r106 == null) goto L9;
        Long r107 = r106.a();
        if (r107 == null) goto L9;
        int r108 = (int) (r107.longValue() - new Date().getTime());
    L10:
        this.f113720j = r108;
        this.f113718h = r102;
        if (r105 == null) goto L15;
        String r109 = r105.a();
        if (r109 == null) goto L15;
        this.f113721k = r109;
    L15:
        this.f113712b = (TextView) r104.findViewById(R.id.quit_dialog_content);
        this.f113713c = (TextView) r104.findViewById(R.id.quit_dialog_title);
        this.f113714d = (Button) r104.findViewById(R.id.quit_button);
        this.f113715e = (Button) r104.findViewById(R.id.continue_button);
        Button r110 = this.f113714d;
        if (r110 == null) goto L18;
        r110.setOnClickListener(new n8(this));
    L18:
        Button r111 = this.f113715e;
        if (r111 == null) goto L21;
        r111.setOnClickListener(new o8(this));
    L21:
        setOnShowListener(new p8(this));
        b();
        if (r105 == null) goto L25;
        r103 = r105.f114057a;
    L25:
        if ("ad_reward_retain_data".equals(r103) == false) goto L27;
        int r112 = R.string.ttlive_live_guide_task_retain_quit;
        int r113 = R.string.ttlive_live_guide_task_retain_title;
    L28:
        Button r114 = this.f113714d;
        if (r114 == null) goto L31;
        r114.setText(r112);
    L31:
        TextView r115 = this.f113713c;
        if (r115 == null) goto L35;
        r115.setText(r113);
        return;
    L35:
        return;
    L27:
        r112 = R.string.ttlive_live_guide_feed_quit;
        r113 = R.string.ttlive_quit_room_confirm_title;
    L9:
        r108 = 0;
        goto L10
    }
}
