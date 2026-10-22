package com.bytedance.android.livesdk.share;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/share/AutoRecordNoticeDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "init", "Landroid/view/View;", "view", "setOnClick", "show", BaseSwitches.V, SendEventContainerMethodParamModel.EventKinds.onClick, "mContext", "Landroid/content/Context;", "mRootView", "Landroid/view/View;", "mDivider", "Landroid/widget/ToggleButton;", "mToggle", "Landroid/widget/ToggleButton;", "Landroid/widget/TextView;", "mContentText", "Landroid/widget/TextView;", "<init>", "(Landroid/content/Context;)V", "", "themeResId", "(Landroid/content/Context;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoRecordNoticeDialog extends AppCompatDialog implements View.OnClickListener {
    public static final a Companion = null;
    public static final float DIALOG_WIDTH_DP = 280.0f;
    private TextView mContentText;
    private Context mContext;
    private View mDivider;
    private View mRootView;
    private ToggleButton mToggle;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f158005a = null;

        static {
            f158005a = new b();
        }

        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.W;
            boolean r103 = true;
            if (r101 != true) goto L6;
            r103 = false;
        L6:
            Boolean r104 = Boolean.valueOf(r103);
            r102.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r102, r104);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void access$000(AppCompatDialog r100) {
        super.show();
    }

    @Override // android.app.Dialog
    public void show() {
        INVOKESPECIAL_com_bytedance_android_livesdk_share_AutoRecordNoticeDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        Window r100 = getWindow();
        if (r100 == null) goto L8;
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        r101.copyFrom(r100.getAttributes());
        r101.width = s1.f(280.0f);
        r101.height = -2;
        r100.setAttributes(r101);
        View r102 = this.mDivider;
        if (r102 == null) goto L9;
        a1.p(r102, s1.f(280.0f));
        return;
    L9:
        return;
    }

    public AutoRecordNoticeDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, R.style.ttlive_live_dialog);
        init(r100);
    }

    public static void INVOKESPECIAL_com_bytedance_android_livesdk_share_AutoRecordNoticeDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AppCompatDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        access$000(r100);
        DialogLancet.afterDialogShow(r100);
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_share_AutoRecordNoticeDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AutoRecordNoticeDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    private final void init(Context r100) {
        this.mContext = r100;
        ToggleButton r101 = null;
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_auto_record_notice, null);
        this.mRootView = r102;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        setOnClick(r102);
        View r103 = this.mRootView;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        setContentView(r103);
        View r104 = this.mRootView;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        this.mDivider = r104.findViewById(R.id.v_divider);
        View r105 = this.mRootView;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L14:
        ToggleButton r106 = (ToggleButton) r105.findViewById(R.id.btn_toggle);
        if (r106 == null) goto L17;
        r106.setOnCheckedChangeListener(b.f158005a);
        Unit r107 = Unit.INSTANCE;
        r101 = r106;
    L17:
        this.mToggle = r101;
        View r108 = this.mRootView;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L20:
        TextView r109 = (TextView) r108.findViewById(R.id.tv_content);
        this.mContentText = r109;
        if (r109 == null) goto L24;
        r109.setText(s1.C(R.string.ttlive_record_notice_content, new Object[]{r3.b()}));
        return;
    }

    private final void setOnClick(View r100) {
        View r101 = r100.findViewById(R.id.ll_toggle);
        if (r101 == null) goto L5;
        r101.setOnClickListener(this);
    L5:
        TextView r102 = (TextView) r100.findViewById(R.id.btn_left);
        if (r102 == null) goto L8;
        r102.setOnClickListener(this);
    L8:
        TextView r103 = (TextView) r100.findViewById(R.id.btn_right);
        if (r103 == null) goto L12;
        r103.setOnClickListener(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getId());
    L5:
        if (r101 != null) goto L8;
    L24:
        if (r101 != null) goto L27;
    L29:
        if (r101 != null) goto L32;
        return;
    L32:
        if (r101.intValue() != R.id.btn_right) goto L37;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.X;
        Boolean r103 = Boolean.TRUE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        INVOKEVIRTUAL_com_bytedance_android_livesdk_share_AutoRecordNoticeDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    L37:
        return;
    L27:
        if (r101.intValue() != R.id.btn_left) goto L29;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = com.bytedance.android.livesdk.sharedpref.b.X;
        Boolean r105 = Boolean.FALSE;
        r104.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
        INVOKEVIRTUAL_com_bytedance_android_livesdk_share_AutoRecordNoticeDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    L8:
        if (r101.intValue() != R.id.ll_toggle) goto L24;
        ToggleButton r106 = this.mToggle;
        boolean r107 = false;
        if (r106 == null) goto L18;
        if (r106 != null) goto L13;
    L16:
        boolean r108 = true;
    L17:
        r106.setChecked(r108);
        goto L18
    L13:
        if (r106.isChecked() != true) goto L16;
        r108 = false;
    L18:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r109 = com.bytedance.android.livesdk.sharedpref.b.W;
        ToggleButton r110 = this.mToggle;
        if (r110 != null) goto L21;
    L22:
        r107 = true;
    L23:
        Boolean r111 = Boolean.valueOf(r107);
        r109.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r109, r111);
        return;
    L21:
        if (r110.isChecked() == true) goto L23;
    L4:
        r101 = null;
        goto L5
    }

    public AutoRecordNoticeDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        init(r100);
    }
}
