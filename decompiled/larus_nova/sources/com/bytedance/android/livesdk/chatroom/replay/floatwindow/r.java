package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class r extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f108707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f108708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f108709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f108710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f108711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f108712f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f108713a;

        public a(r r100) {
            this.f108713a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            r r101 = this.f108713a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public r(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_live_dialog);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_replay_video_float_window_notified_dialog, null);
        this.f108707a = r101;
        this.f108708b = (LinearLayout) r101.findViewById(R.id.dialog_with_top_image);
        HSImageView r102 = (HSImageView) r101.findViewById(R.id.dialog_top_image);
        this.f108709c = r102;
        this.f108710d = (TextView) r101.findViewById(R.id.dialog_title);
        this.f108711e = (TextView) r101.findViewById(R.id.dialog_content);
        TextView r103 = (TextView) r101.findViewById(R.id.notified_action);
        this.f108712f = r103;
        setContentView(r101);
        r103.setOnClickListener(new a(this));
        setCancelable(true);
        fq1.h.a().f(r102, "/replay/ttlive_dialog_top_image.webp");
    }

    public final void a(DataCenter r100) {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L86;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (r100 != null) goto L10;
    L47:
        LinearLayout r101 = this.f108708b;
        if (r101 == null) goto L52;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L52;
        r102.width = s1.f(281.0f);
    L52:
        HSImageView r103 = this.f108709c;
        if (r103 == null) goto L57;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L57;
        r104.height = s1.f(140.0f);
    L57:
        TextView r105 = this.f108710d;
        if (r105 == null) goto L60;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
    L62:
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L64;
        r106 = null;
    L64:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 == null) goto L67;
        r107.topMargin = s1.f(24.0f);
    L67:
        TextView r108 = this.f108711e;
        if (r108 == null) goto L70;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L72:
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == true) goto L74;
        r109 = null;
    L74:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r109;
        if (r110 == null) goto L77;
        r110.topMargin = s1.f(8.0f);
        r110.bottomMargin = s1.f(24.0f);
    L77:
        TextView r111 = this.f108712f;
        if (r111 == null) goto L82;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L82;
        r112.height = s1.f(48.0f);
    L82:
        if (r100 == null) goto L88;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r100).d("mini_window_open_success_popup_show", null, new Object[0]);
        return;
    L88:
        return;
    L70:
        r109 = null;
        goto L72
    L60:
        r106 = null;
        goto L62
    L10:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.h.d(r100, true) == true) goto L47;
        LinearLayout r113 = this.f108708b;
        if (r113 == null) goto L17;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L17;
        r114.width = s1.f(240.0f);
    L17:
        HSImageView r115 = this.f108709c;
        if (r115 == null) goto L22;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L22;
        r116.height = s1.f(118.0f);
    L22:
        TextView r117 = this.f108710d;
        if (r117 == null) goto L25;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
    L27:
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == true) goto L29;
        r118 = null;
    L29:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        if (r119 == null) goto L32;
        r119.topMargin = s1.f(20.5f);
    L32:
        TextView r120 = this.f108711e;
        if (r120 == null) goto L35;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
    L37:
        if ((r121 instanceof ViewGroup.MarginLayoutParams) == true) goto L39;
        r121 = null;
    L39:
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        if (r122 == null) goto L42;
        r122.topMargin = s1.f(6.5f);
        r122.bottomMargin = s1.f(20.5f);
    L42:
        TextView r123 = this.f108712f;
        if (r123 == null) goto L82;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L82;
        r124.height = s1.f(41.0f);
        goto L82
    L35:
        r121 = null;
        goto L37
    L25:
        r118 = null;
        goto L27
    L86:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L85
    L6:
        DialogLancet.beforeDialogShow(this);
        show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }
}
