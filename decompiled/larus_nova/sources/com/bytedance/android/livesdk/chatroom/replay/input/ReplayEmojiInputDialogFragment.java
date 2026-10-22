package com.bytedance.android.livesdk.chatroom.replay.input;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentStatisticLog;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.ReplayDanmakuSendWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.m;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.InputLinearLayout;
import com.bytedance.android.livesdk.chatroom.vs_base.util.y;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdk.utils.u3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import fq1.r;
import i40.h;
import java.lang.reflect.Field;
import vr1.d0;
import yr1.f;

/* JADX INFO: loaded from: classes7.dex */
public class ReplayEmojiInputDialogFragment extends DialogFragment implements com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c, qq1.a {
    public static final /* synthetic */ int H = 0;
    public com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.a A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public PanelStatus F;
    public final int G;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputFilter f108766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f108767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f108768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f108769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.replay.input.b f108770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f108771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f108772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public InputLinearLayout f108773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f108774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f108775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EditText f108776n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f108777o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ReplayKeyboardShadowView f108778p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f108779q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FrameLayout f108780r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f108781s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f108782t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f108783u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f108784v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f108785w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f108786x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f108787y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.b f108788z;

    public static final enum PanelStatus extends Enum<PanelStatus> {
        public static final PanelStatus Close = null;
        public static final PanelStatus Emoji = null;
        public static final PanelStatus KeyBroad = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PanelStatus[] f108789a = null;

        static {
            PanelStatus r100 = new PanelStatus("KeyBroad", 0);
            KeyBroad = r100;
            PanelStatus r101 = new PanelStatus("Emoji", 1);
            Emoji = r101;
            PanelStatus r102 = new PanelStatus("Close", 2);
            Close = r102;
            f108789a = new PanelStatus[]{r100, r101, r102};
        }

        public static PanelStatus[] values() {
            return (PanelStatus[]) f108789a.clone();
        }

        public static PanelStatus valueOf(String r100) {
            return (PanelStatus) r27.a.a(PanelStatus.class, r100);
        }

        public PanelStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayEmojiInputDialogFragment f108790a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(ReplayEmojiInputDialogFragment r100) {
            this.f108790a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r110) {
            ReplayEmojiInputDialogFragment r111 = this.f108790a;
            if (r111.D == true) goto L5;
            return;
        L5:
            Editable r112 = r111.f108776n.getText();
            ReplayEmojiInputDialogFragment r100 = this.f108790a;
            if (r112 != null) goto L8;
            String r101 = "";
        L9:
            r100.f108786x = r101;
            if (TextUtils.isEmpty(this.f108790a.f108786x) == false) goto L12;
            this.f108790a.f108777o.setVisibility(0);
            this.f108790a.f108774l.setImageResource(R.drawable.ttlive_icon_send_untouch);
        L13:
            int r102 = TextUtils.getTrimmedLength(this.f108790a.f108786x);
            u3.a r113 = u3.a(r112, this.f108790a.f108767e);
            if (r113 == null) goto L16;
            int r103 = r113.f159177a;
            r102 = r113.f159178b;
            int r114 = r103;
        L17:
            ReplayEmojiInputDialogFragment r104 = this.f108790a;
            r104.f108768f = r102;
            int r105 = 15;
            if (r104.f108781s == false) goto L20;
            int r106 = 15;
        L22:
            if (r102 <= r106) goto L24;
            EditText r107 = r104.f108776n;
            InputFilter.LengthFilter r108 = new InputFilter.LengthFilter(r104.f108786x.length());
            r104.f108766d = r108;
            r107.setFilters(new InputFilter[]{r108});
        L27:
            ReplayEmojiInputDialogFragment r109 = this.f108790a;
            boolean r115 = r109.f108781s;
            if (r115 == true) goto L31;
            r105 = r109.f108767e;
        L31:
            if (r102 <= r105) goto L48;
            if (r115 == false) goto L34;
            String r116 = r109.getString(R.string.ttlive_replay_live_danmaku_too_long);
        L35:
            y.b(r116, 1);
            int r117 = this.f108790a.f108786x.length();
            if (this.f108790a.f108781s == true) goto L39;
            if (r114 == 0) goto L39;
            int r118 = Math.min(r114, r117);
        L40:
            this.f108790a.f108776n.setText(this.f108790a.f108786x.substring(0, r118));
            EditText r119 = this.f108790a.f108776n;     // Catch: Exception -> L43
            r119.setSelection(r119.getText().length());     // Catch: Exception -> L43
            return;
        L43:
            e = move-exception;
            r.a().a(e.getStackTrace());
            return;
        L39:
            f r120 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.e();
            ReplayEmojiInputDialogFragment r121 = this.f108790a;
            r118 = r120.h(r121.f108786x, r121.f108781s, r121.f108767e);
            goto L40
        L34:
            r116 = r109.getString(R.string.ttlive_replay_input_max_counts, new Object[]{Integer.valueOf(r109.f108767e)});
            goto L35
        L48:
            return;
        L24:
            EditText r122 = r104.f108776n;
            if (r104.f108766d == null) goto L27;
            r122.setFilters(new InputFilter[0]);
            r104.f108766d = null;
            goto L27
        L20:
            r106 = r104.f108767e;
            goto L22
        L16:
            r114 = 0;
            goto L17
        L12:
            this.f108790a.f108777o.setVisibility(8);
            this.f108790a.f108774l.setImageResource(R.drawable.ttlive_icon_send_touched);
            goto L13
        L8:
            r101 = r112.toString();
            goto L9
        }
    }

    public class b implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayEmojiInputDialogFragment f108791a;

        public b(ReplayEmojiInputDialogFragment r100) {
            this.f108791a = r100;
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayEmojiInputDialogFragment f108792a;

        public c(ReplayEmojiInputDialogFragment r100) {
            this.f108792a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ReplayEmojiInputDialogFragment r101 = this.f108792a;
            r101.F = PanelStatus.Close;
            r101.hideSoftKeyBoard();
            com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c.a r102 = this.f108792a.A;
            if (r102 == null) goto L20;
            r102.a();
            this.f108792a.T90();     // Catch: Exception -> L13
            this.f108792a.dismiss();     // Catch: Exception -> L8
        L22:
            return;
        L8:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L13
            Throwable r103 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L13
            if (r103 == null) goto L21;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L13
            return;
        L21:
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
            h.b("dismiss error", e);
            return;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayEmojiInputDialogFragment f108793a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f108793a.f108776n.requestFocus();     // Catch: Throwable -> L4 Exception -> L6
        L16:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public d(ReplayEmojiInputDialogFragment r100) {
            this.f108793a = r100;
        }
    }

    public class e implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayEmojiInputDialogFragment f108794a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f108795a;

            public final void a() {
                if (this.f108795a.f108794a.isAdded() == true) goto L5;
                return;
            L5:
                if (this.f108795a.f108794a.getContext() != null) goto L8;
                return;
            L8:
                if (this.f108795a.f108794a.getActivity() == null) goto L10;
                this.f108795a.f108794a.getActivity().getWindow().setSoftInputMode(48);
            L10:
                t2.b(this.f108795a.f108794a.getContext(), this.f108795a.f108794a.f108776n);
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

            public a(e r100) {
                this.f108795a = r100;
            }
        }

        public e(ReplayEmojiInputDialogFragment r100) {
            this.f108794a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            r100.postDelayed(new a(this), 100);
            this.f108794a.f108776n.setOnFocusChangeListener(null);
        }
    }

    public final void T90() {
        if (this.B == false) goto L17;
        this.B = false;
        this.f108773k.setVisibility(4);
        dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: IllegalStateException -> L12
        Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: IllegalStateException -> L12
        if (r100 == null) goto L18;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: IllegalStateException -> L12
        return;
    L18:
        return;
    L20:
        return;
    }

    public final void hideSoftKeyBoard() {
        if (this.f108776n != null) goto L6;
        h.a("hide key board return, messageedit view null");
        return;
    L6:
        t2.a(getContext(), this.f108776n);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.livesdk.chatroom.replay.input.b] */
    public ReplayEmojiInputDialogFragment() {
        this.f108767e = ReplayConfigSettingKeys.REPLAY_COMMENT_WORDS_COUNT_LIMIT.getValue().intValue();
        this.f108768f = 0;
        this.f108770h = new com.bytedance.android.livesdk.chatroom.replay.input.b(this);
        this.f108771i = new a(this);
        this.f108772j = new b(this);
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = PanelStatus.KeyBroad;
        this.G = s1.f(18.0f);
    }

    public final void U90() {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (this.f108783u == false) goto L8;
        this.f108776n.setText("");
        this.f108777o.setText(R.string.ttlive_replay_live_user_text_banned);
        this.f108776n.setEnabled(false);
        return;
    L8:
        this.f108776n.setText(this.f108786x);
        if (TextUtils.isEmpty(this.f108786x) == true) goto L11;
        this.f108776n.setSelection(this.f108786x.length());
    L11:
        this.f108776n.setTextSize(1, 17.0f);
        if (this.f108781s == false) goto L15;
        this.f108777o.setText(s1.C(R.string.ttlive_replay_danmu_hint_v2, new Object[]{com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.a().a()}));
    L21:
        this.f108776n.setEnabled(true);
        return;
    L15:
        if (this.f108782t == false) goto L18;
        this.f108777o.setText(R.string.ttlive_replay_broadcast_send_hint);
        goto L21
    L18:
        if (TextUtils.isEmpty(this.f108787y) == true) goto L20;
        this.f108777o.setText(this.f108787y);
        goto L21
    L20:
        this.f108777o.setText(R.string.ttlive_replay_live_send_hint);
        goto L21
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c
    public final void dismissInputDialog() {
        hideSoftKeyBoard();
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L12;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c
    public final void jS() {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (this.f108783u == false) goto L8;
        return;
    L8:
        this.f108783u = true;
        U90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.D = false;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.C = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        InputLinearLayout r100 = this.f108773k;
        if (r100 == null) goto L7;
        r100.getKeyBoardObservable().b(this);
        h.a("unregisterKeyboardListener with keyBoardObservable");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        InputLinearLayout r100 = this.f108773k;
        if (r100 == null) goto L7;
        r100.getKeyBoardObservable().a(this);
        h.a("registerKeyboardListener with keyBoardObservable");
    L7:
        if (this.C == false) goto L14;
        if (this.F != PanelStatus.KeyBroad) goto L14;
        this.C = false;
        EditText r101 = this.f108776n;
        if (r101 == null) goto L17;
        r101.postDelayed(new com.bytedance.android.livesdk.chatroom.replay.input.a(this, 200, 1, 5), 200);
        return;
    L17:
        return;
    L14:
        if (this.F != PanelStatus.KeyBroad) goto L19;
        this.f108776n.post(new d(this));
        this.f108776n.setOnFocusChangeListener(new e(this));
        return;
    }

    public final void S90(DialogInterface r100) {
        com.bytedance.android.livesdk.f.d().f123394c = false;
        com.bytedance.android.livesdk.f.d().f();
        if (s.d() == null) goto L5;
        s.d().onInputStateChange(false);
    L5:
        super.onDismiss(r100);
        r.a().i(r.a().f(), "input dialog dismiss");
        if (this.f108788z == null) goto L9;
        ll1.a r101 = new ll1.a();
        r101.f509668b = this.f108782t;
        r101.f509669c = this.f108783u;
        r101.f509667a = this.f108781s;
        r101.f509672f = this.f108786x;
        r101.f509670d = this.f108784v;
        r101.f509671e = this.f108787y;
        this.f108788z.b(r101);
        this.f108788z = null;
        this.B = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c
    public final void iM(ReplayDanmakuSendWidget.c r100) {
        this.f108788z = r100;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setLayout(-1, -1);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        InputLinearLayout r101 = this.f108773k;
        if (r101 != null) goto L5;
        return;
    L5:
        if (m.a() == false) goto L9;
        r101.f117955b++;
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        setStyle(1, R.style.ttlive_emoji_input_dialog);
        super.onCreate(r100);
        this.D = true;
        setCancelable(true);
        Bundle r101 = getArguments();
        if (r101 != null) goto L5;
        r101 = new Bundle();
    L5:
        this.f108781s = r101.getBoolean("live.intent.extra.DANMU_OPEN", false);
        this.f108782t = r101.getBoolean("live.intent.extra.IS_BROADCASTER", false);
        this.f108783u = r101.getBoolean("live.intent.extra.USER_BANNED", false);
        this.f108786x = r101.getString("live.intent.extra.INPUT", "");
        this.f108784v = r101.getBoolean("live.inter.extra.CAN_DANMU", true);
        this.f108787y = r101.getString("live.intent.extra.COMMENT_HINT", "");
        r101.getString("live.intent.extra.OFF_ALLOW_GIFT", "");
        this.f108785w = r101.getBoolean("live.intent.extra.CAN_SEND_EMOJI", true);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        boolean r102 = false;
        r101.setCanceledOnTouchOutside(false);
        Window r103 = r101.getWindow();
        if (r103 == null) goto L21;
        r103.setGravity(80);
        r103.setLayout(-1, -2);
        r103.setBackgroundDrawable(new ColorDrawable(0));
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.a().c() == false) goto L7;
        int r104 = 19;
    L8:
        r103.setSoftInputMode(r104);
        r103.addFlags(32);
        if (getActivity() == null) goto L13;
        if (e5.g(getActivity()) == false) goto L13;
    L19:
        r103.addFlags(1024);
    L20:
        r103.clearFlags(2);
    L13:
        if (this.f108782t == true) goto L20;
        FragmentActivity r105 = getActivity();
        if (getActivity().getRequestedOrientation() != 1) goto L18;
        r102 = true;
    L18:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r105, r102, this.f108782t) == true) goto L20;
    L7:
        r104 = 3;
    L21:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        S90(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        this.C = this.B;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c
    public final void updateInput(String r100) {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (this.f108783u == false) goto L8;
        return;
    L8:
        this.f108786x = "";
        U90();
    }

    @Override // qq1.a
    public final void X6(boolean r100, int r101) {
        if (r100 == false) goto L11;
        PanelStatus r102 = this.F;
        PanelStatus r103 = PanelStatus.KeyBroad;
        if (r102 == r103) goto L7;
        this.F = r103;
    L7:
        this.B = true;
        this.f108775m.setImageResource(R.drawable.ttlive_ic_panel_input_emoji);
        h.a("key board visible gone emoji container");
        this.f108779q.setVisibility(8);
        if (s.d() == null) goto L23;
        s.d().onInputStateChange(true);
    L23:
        int[] r104 = new int[2];
        this.f108773k.getLocationOnScreen(r104);
        h.a("updateSoftKeyboardState, keyBoardVisible: " + r100 + "，keyBoardHeight： " + r101 + ", currPanelStatus: " + this.F + ", rootViewHeight: " + this.f108773k.getHeight() + ", rootViewPosition: " + r104[0] + ", " + r104[1]);
        return;
    L11:
        if (this.F != PanelStatus.Emoji) goto L22;
        h.a("try show emoji");
        this.f108773k.setVisibility(0);
        this.f108775m.setImageResource(R.drawable.ttlive_ic_panel_input_keyboard);
        if (this.f108779q.getVisibility() == 0) goto L18;
        h.a("emoji not visible, try init");
        this.f108779q.setVisibility(0);
        final FrameLayout r105 = this.f108779q;
        r105.post(new com.bytedance.android.livesdk.chatroom.replay.input.c(this, r105));
        DataCenter r106 = this.f108769g;
        if (r106 != null) goto L17;
        int r107 = ReplayCommentStatisticLog.f108856a;
    L20:
        if (s.d() == null) goto L23;
        s.d().onInputStateChange(true);
        goto L23
    L17:
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r106).d("input_comment_emoji_panel_show", ReplayCommentStatisticLog.a(r106), new Object[0]);
        goto L20
    L18:
        h.a("emoji already visible");
        goto L20
    L22:
        T90();
        goto L23
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f108776n.addTextChangedListener(this.f108771i);
        this.f108776n.setOnKeyListener(new com.bytedance.android.livesdk.chatroom.replay.input.d(this));
        this.f108774l.setOnClickListener(this.f108770h);
        this.f108775m.setOnClickListener(this.f108770h);
        U90();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.c
    public final void show(Activity r100, String r101) {
        FragmentManager r102 = ((FragmentActivity) r100).getSupportFragmentManager();
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, "INPUT", r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r102, this, r103) == false) goto L13;
    L7:
        DataCenter r104 = this.f108769g;
        int r105 = ReplayCommentStatisticLog.f108856a;
        if (r104 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r104).d("input_comment_word_panel_show", ReplayCommentStatisticLog.a(r104), new Object[0]);
        return;
    L15:
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L6:
        show(r102, "INPUT");
        goto L7
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void showNow(FragmentManager r100, String r101) {
        com.bytedance.android.livesdk.f.d().f123394c = true;
        com.bytedance.android.livesdk.f.d().a();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L10;
    L7:
        r.a().i(r.a().f(), "input dialog showNow");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.showNow(r100, r101);
        goto L7
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        com.bytedance.android.livesdk.f.d().f123394c = true;
        com.bytedance.android.livesdk.f.d().a();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == false) goto L10;
    L7:
        r.a().i(r.a().f(), "input dialog show");
        return;
    L10:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        super.show(r100, r101);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_replay_fragment_live_emoji_input_dialog, r101, false);
        InputLinearLayout r104 = (InputLinearLayout) r103;
        this.f108773k = r104;
        ReplayKeyboardShadowView r105 = (ReplayKeyboardShadowView) r104.findViewById(R.id.view_shadow);
        this.f108778p = r105;
        r105.setIsAnchor(this.f108782t);
        ReplayKeyboardShadowView r106 = this.f108778p;
        if (getActivity().getRequestedOrientation() != 1) goto L5;
        boolean r107 = true;
    L6:
        r106.setIsPortrait(r107);
        this.f108778p.setActivity(getActivity());
        ReplayKeyboardShadowView r108 = this.f108778p;
        if (getActivity() != null) goto L9;
    L12:
        boolean r109 = true;
    L13:
        r108.setShowStatusBar(r109);
        this.f108775m = (ImageView) r103.findViewById(R.id.open_emoji_panel);
        this.f108774l = (ImageView) r103.findViewById(R.id.send_message);
        this.f108777o = (TextView) r103.findViewById(R.id.edit_text_hint);
        if (this.f108784v == true) goto L16;
        this.f108781s = false;
    L16:
        this.f108780r = (FrameLayout) r103.findViewById(R.id.emoji_edit_text_container);
        GradientEditText r110 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.e().a(getContext(), this.G);
        FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-1, -2);
        r111.gravity = 8388627;
        r110.setLayoutParams(r111);
        r110.setImeOptions(268435460);
        r110.setInputType(1);
        r110.setLineSpacing(s1.f(5.0f), r110.getLineSpacingMultiplier());
        r110.setTextAlignment(5);
        r110.setTextColor(s1.h(R.color.ttlive_live_input_text_color));
        r110.setTextSize(s1.I(15.0f));
        r110.setBackground(null);
        Field r112 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Exception -> L19
        r112.setAccessible(true);     // Catch: Exception -> L19
        r112.set(r110, Integer.valueOf(R.drawable.ttlive_edit_text_cursor_drawable));     // Catch: Exception -> L19
    L21:
        this.f108780r.addView(r110);
        this.f108776n = r110;
        this.f108779q = (FrameLayout) r103.findViewById(R.id.emoji_panel_container);
        if (this.f108785w == false) goto L24;
        this.f108775m.setVisibility(0);
    L26:
        if (getDialog() == null) goto L28;
        this.f108778p.setOnClickListener(new c(this));
    L28:
        r3.a(this.f108774l, s1.B(R.string.ttlive_a11y_keyboard_send));
        r3.a(this.f108775m, s1.B(R.string.ttlive_a11y_keyboard_emoji));
        return r103;
    L24:
        this.f108775m.setVisibility(8);
    L19:
        e = move-exception;
        h.b("emoji key board mCursorDrawableRes", e);
        goto L21
    L9:
        if (e5.g(getActivity()) == false) goto L12;
        r109 = false;
        goto L13
    L5:
        r107 = false;
        goto L6
    }
}
