package com.stepos.aiengine.cta;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.LineHeightSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.stepos.aiengine.R;
import com.stepos.aiengine.cta.WithdrawActivity;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.core.ability.deepbinder.AIEngineDeepBinderServiceImpl;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.cta.CtaGatedInitManager;
import com.stepos.core.ota.process.OtaProcessClient;
import com.stepos.core.ota.push.OtaPushRegistrar;
import com.stepos.policy.sdk.PolicySdk;
import gc.q;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;
import mb.v;
import stepos.support.v7.app.e;
import stepos.support.v7.app.g0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WithdrawActivity extends Activity {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f5770c = 0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f5771a;

    /* renamed from: b, reason: collision with root package name */
    public e f5772b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements LineHeightSpan {

        /* renamed from: a, reason: collision with root package name */
        public final int f5773a;

        public a(int i10) {
            this.f5773a = i10;
        }

        @Override // android.text.style.LineHeightSpan
        public final void chooseHeight(CharSequence charSequence, int i10, int i11, int i12, int i13, Paint.FontMetricsInt fm) {
            int i14;
            g.f(fm, "fm");
            int i15 = fm.descent;
            int i16 = fm.ascent;
            int i17 = i15 - i16;
            if (i17 <= 0 || (i14 = this.f5773a) <= i17) {
                return;
            }
            int i18 = i14 - i17;
            int i19 = i18 / 2;
            int i20 = i18 - i19;
            fm.ascent = i16 - i19;
            fm.top -= i19;
            fm.descent = i15 + i20;
            fm.bottom += i20;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements g0.a {
        public b() {
        }

        @Override // stepos.support.v7.app.g0.a
        public final void onPermissionClick(DialogInterface d8, boolean z, boolean z3) {
            Object objA;
            ModelManagerActivity modelManagerActivity;
            g.f(d8, "d");
            WithdrawActivity withdrawActivity = WithdrawActivity.this;
            if (!z3) {
                withdrawActivity.finish();
                return;
            }
            if (withdrawActivity.f5771a) {
                return;
            }
            withdrawActivity.f5771a = true;
            n6.a.f10642a.getClass();
            n6.a.a("model_withdraw_consent", v.b0(new Pair("action", "withdraw")));
            CTAPermissionManager.INSTANCE.revokeCta();
            try {
                CtaGatedInitManager ctaGatedInitManager = CtaGatedInitManager.INSTANCE;
                Context applicationContext = withdrawActivity.getApplicationContext();
                g.e(applicationContext, "getApplicationContext(...)");
                ctaGatedInitManager.refresh(applicationContext);
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
            try {
                OtaPushRegistrar otaPushRegistrar = OtaPushRegistrar.INSTANCE;
                Context applicationContext2 = withdrawActivity.getApplicationContext();
                g.e(applicationContext2, "getApplicationContext(...)");
                otaPushRegistrar.unregister(applicationContext2);
                n nVar2 = n.f10413a;
            } catch (Throwable th2) {
                c.a(th2);
            }
            try {
                AIEngineDeepBinderServiceImpl.Companion.onCTAStateChanged(-1, false);
                n nVar3 = n.f10413a;
            } catch (Throwable th3) {
                c.a(th3);
            }
            try {
                OtaProcessClient.INSTANCE.persistAndShutdownOta();
                n nVar4 = n.f10413a;
            } catch (Throwable th4) {
                c.a(th4);
            }
            Context applicationContext3 = withdrawActivity.getApplicationContext();
            try {
                k6.b bVar = k6.b.f9949a;
                g.c(applicationContext3);
                bVar.getClass();
                k6.b.a(applicationContext3);
                n nVar5 = n.f10413a;
            } catch (Throwable th5) {
                c.a(th5);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new a6.e(withdrawActivity, applicationContext3), 2000L);
            try {
                WeakReference<ModelManagerActivity> weakReference = ModelManagerActivity.f5847u;
                if (weakReference == null || (modelManagerActivity = weakReference.get()) == null || modelManagerActivity.isFinishing() || modelManagerActivity.isDestroyed()) {
                    modelManagerActivity = null;
                }
                if (modelManagerActivity != null) {
                    modelManagerActivity.finish();
                }
                n nVar6 = n.f10413a;
            } catch (Throwable th6) {
                c.a(th6);
            }
            withdrawActivity.setResult(-1);
            Set setS0 = l.s0(new String[]{ModelDownloadNotifier.MODEL_MANAGER_ACTIVITY_CLASS, "com.stepos.aiengine.modelmanager.settings.AiEngineSettingsActivity", "com.stepos.aiengine.cta.WithdrawActivity"});
            try {
                Object systemService = withdrawActivity.getSystemService("activity");
                g.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                List<ActivityManager.AppTask> appTasks = ((ActivityManager) systemService).getAppTasks();
                g.e(appTasks, "getAppTasks(...)");
                for (ActivityManager.AppTask appTask : appTasks) {
                    try {
                        objA = appTask.getTaskInfo();
                    } catch (Throwable th7) {
                        objA = c.a(th7);
                    }
                    if (objA instanceof Result.Failure) {
                        objA = null;
                    }
                    ActivityManager.RecentTaskInfo recentTaskInfo = (ActivityManager.RecentTaskInfo) objA;
                    if (recentTaskInfo != null) {
                        ComponentName component = recentTaskInfo.baseIntent.getComponent();
                        String className = component != null ? component.getClassName() : null;
                        if (className != null && setS0.contains(className)) {
                            try {
                                appTask.finishAndRemoveTask();
                                n nVar7 = n.f10413a;
                            } catch (Throwable th8) {
                                c.a(th8);
                            }
                        }
                    }
                }
                n nVar8 = n.f10413a;
            } catch (Throwable th9) {
                c.a(th9);
            }
            withdrawActivity.finishAndRemoveTask();
        }
    }

    public static TextView a(View view, String str) {
        if (view != null) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                CharSequence text = textView.getText();
                if (g.b(text != null ? text.toString() : null, str.toString())) {
                    return textView;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    TextView textViewA = a(viewGroup.getChildAt(i10), str);
                    if (textViewA != null) {
                        return textViewA;
                    }
                }
            }
        }
        return null;
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            this.f5771a = true;
            finish();
            return;
        }
        if (CTADialogGate.INSTANCE.isDialogShowing()) {
            this.f5771a = true;
            finish();
            return;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this, R.style.Theme_AIEngine_WithdrawDialogHost);
        String string = getString(R.string.mm_withdraw_title);
        String string2 = getString(R.string.mm_withdraw_message);
        g.e(string2, "getString(...)");
        String string3 = getString(R.string.mm_withdraw_policy_link);
        g.e(string3, "getString(...)");
        SpannableString spannableString = new SpannableString(string2);
        int iR0 = q.r0(string2, string3, 0, false, 6);
        if (iR0 >= 0) {
            spannableString.setSpan(new c6.g(this, string3), iR0, string3.length() + iR0, 33);
        }
        spannableString.setSpan(new a((int) (getResources().getDisplayMetrics().density * 22.0f)), 0, string2.length(), 33);
        e eVarShowWithdrawalDialogRecord = PolicySdk.showWithdrawalDialogRecord(contextThemeWrapper, string, spannableString, getString(R.string.mm_withdraw_cancel), getString(R.string.mm_withdraw_confirm), new String[]{"pp"}, "", new b());
        if (eVarShowWithdrawalDialogRecord != null) {
            eVarShowWithdrawalDialogRecord.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: c6.f
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WithdrawActivity withdrawActivity = this.f3297a;
                    if (withdrawActivity.f5771a) {
                        return;
                    }
                    withdrawActivity.finish();
                }
            });
            eVarShowWithdrawalDialogRecord.show();
            String string4 = getString(R.string.mm_withdraw_title);
            g.e(string4, "getString(...)");
            View viewFindViewById = findViewById(R.id.alertTitle);
            TextView textViewA = viewFindViewById instanceof TextView ? (TextView) viewFindViewById : null;
            if (textViewA == null) {
                View viewFindViewById2 = findViewById(android.R.id.title);
                textViewA = viewFindViewById2 instanceof TextView ? (TextView) viewFindViewById2 : null;
                if (textViewA == null) {
                    Window window = eVarShowWithdrawalDialogRecord.getWindow();
                    textViewA = a(window != null ? window.getDecorView() : null, string4);
                }
            }
            if (textViewA != null) {
                textViewA.setTypeface(Typeface.create(textViewA.getTypeface(), 1));
            }
            boolean z = (getResources().getConfiguration().uiMode & 48) == 32;
            if (textViewA != null) {
                textViewA.setTextColor(z ? -1118482 : -15066598);
            }
            Button button = eVarShowWithdrawalDialogRecord.getButton(-2);
            if (button != null) {
                button.setBackgroundResource(R.drawable.bg_withdraw_btn_negative);
                button.setTextColor(getColor(R.color.mm_withdraw_btn_text));
                button.setTypeface(Typeface.create(button.getTypeface(), 1));
            }
            Button button2 = eVarShowWithdrawalDialogRecord.getButton(-1);
            if (button2 != null) {
                button2.setBackgroundResource(R.drawable.bg_withdraw_btn_positive);
                button2.setTextColor(getColor(R.color.mm_withdraw_btn_text));
                button2.setTypeface(Typeface.create(button2.getTypeface(), 1));
            }
        } else {
            eVarShowWithdrawalDialogRecord = null;
        }
        this.f5772b = eVarShowWithdrawalDialogRecord;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        e eVar = this.f5772b;
        if (eVar != null) {
            if (!eVar.isShowing()) {
                eVar = null;
            }
            if (eVar != null) {
                eVar.dismiss();
            }
        }
        this.f5772b = null;
        super.onDestroy();
    }
}
