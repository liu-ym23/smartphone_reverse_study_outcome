package com.stepos.aiengine.cta;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.stepos.aiengine.R;
import com.stepos.aiengine.cta.PolicyActivity;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTADialogGate;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.cta.CtaGatedInitManager;
import com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl;
import gc.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.l;
import stepos.support.v7.app.c;
import stepos.support.v7.app.d;
import stepos.support.v7.app.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyActivity extends Activity {

    /* renamed from: d, reason: collision with root package name */
    public static final Set<String> f5763d = l.s0(new String[]{"com.stepos.policy.sdk.activity.PolicyHtmlViewerActivity", "com.stepos.policy.sdk.activity.PolicyPermissionDesActivity", "com.stepos.aiengine.cta.PolicyLocalDocActivity"});

    /* renamed from: a, reason: collision with root package name */
    public final String f5764a = "PolicyActivity";

    /* renamed from: b, reason: collision with root package name */
    public boolean f5765b;

    /* renamed from: c, reason: collision with root package name */
    public e f5766c;

    public final void a() {
        e eVar = this.f5766c;
        if (eVar != null) {
            if (!eVar.isShowing()) {
                eVar = null;
            }
            if (eVar != null) {
                eVar.dismiss();
            }
        }
        this.f5766c = null;
    }

    public final void b() {
        finish();
        overridePendingTransition(0, 0);
    }

    public final boolean c() {
        Object objA;
        ActivityManager activityManager;
        boolean z;
        Object objA2;
        ComponentName componentName;
        try {
            Object systemService = getSystemService("activity");
            activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            z = false;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (activityManager == null) {
            return false;
        }
        List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
        g.e(appTasks, "getAppTasks(...)");
        if (!appTasks.isEmpty()) {
            Iterator<T> it = appTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                try {
                    ActivityManager.RecentTaskInfo taskInfo = ((ActivityManager.AppTask) it.next()).getTaskInfo();
                    objA2 = (taskInfo == null || (componentName = taskInfo.topActivity) == null) ? null : componentName.getClassName();
                } catch (Throwable th2) {
                    objA2 = c.a(th2);
                }
                if (objA2 instanceof Result.Failure) {
                    objA2 = null;
                }
                String str = (String) objA2;
                if (str != null && f5763d.contains(str)) {
                    z = true;
                    break;
                }
            }
        }
        objA = Boolean.valueOf(z);
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void d(boolean z) {
        CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
        Intent intent = getIntent();
        g.e(intent, "getIntent(...)");
        if (cTADialogGate.isFromGate(intent)) {
            Intent intent2 = getIntent();
            g.e(intent2, "getIntent(...)");
            cTADialogGate.dispatchResult(cTADialogGate.readCallingUid(intent2), z, this);
        }
        if (z) {
            LogModule logModule = LogModule.SERVICE;
            Intent intent3 = getIntent();
            g.e(intent3, "getIntent(...)");
            AIEngineLogger.i(logModule, this.f5764a, "flush pending interactive download fromGate=" + cTADialogGate.isFromGate(intent3));
            OtaDeepBinderServiceImpl.Companion companion = OtaDeepBinderServiceImpl.Companion;
            Context applicationContext = getApplicationContext();
            g.e(applicationContext, "getApplicationContext(...)");
            companion.flushPendingAfterCta(applicationContext);
            ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra(CTADialogGate.EXTRA_CONTINUE_ALGORITHM_IDS);
            if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                return;
            }
            Context applicationContext2 = getApplicationContext();
            g.e(applicationContext2, "getApplicationContext(...)");
            companion.continueAfterCtaIfNeeded(applicationContext2, stringArrayListExtra);
        }
    }

    public final void e(String str) {
        if (this.f5765b) {
            return;
        }
        boolean zC = c();
        String str2 = this.f5764a;
        if (zC) {
            AIEngineLogger.i(LogModule.SERVICE, str2, str.concat(": policy viewer in foreground → keep CTA"));
            return;
        }
        this.f5765b = true;
        AIEngineLogger.i(LogModule.SERVICE, str2, str.concat(": user left before decision → close host"));
        a();
        CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
        Intent intent = getIntent();
        g.e(intent, "getIntent(...)");
        if (cTADialogGate.isFromGate(intent)) {
            d(false);
        }
        b();
    }

    public final void f() {
        int i10 = (getResources().getConfiguration().uiMode & 48) == 32 ? R.style.Theme_StepOS_AppCompat_Light_Dialog_Alert_Dark : R.style.Theme_StepOS_AppCompat_Light_Dialog_Alert;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this, i10);
        View viewInflate = LayoutInflater.from(contextThemeWrapper).inflate(R.layout.dialog_cta_policy, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(R.id.cta_dialog_read_policy);
        g.c(viewFindViewById);
        TextView textView = (TextView) viewFindViewById;
        String string = getString(R.string.cta_policy_link_privacy);
        g.e(string, "getString(...)");
        String string2 = getString(R.string.cta_policy_read_policy, string);
        g.e(string2, "getString(...)");
        String string3 = q.L0(string2).toString();
        SpannableString spannableString = new SpannableString(string3);
        int iR0 = q.r0(string3, string, 0, false, 6);
        if (iR0 >= 0) {
            spannableString.setSpan(new c6.e(q.M0(string, 12298, 12299)), iR0, string.length() + iR0, 33);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        View viewFindViewById2 = viewInflate.findViewById(R.id.cta_dialog_wifi_auto_update);
        g.c(viewFindViewById2);
        final CheckBox checkBox = (CheckBox) viewFindViewById2;
        checkBox.setChecked(true);
        e.a aVar = new e.a(contextThemeWrapper, i10);
        c.a aVar2 = aVar.f12101a;
        aVar2.f12094o = viewInflate;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: c6.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                ModelManagerActivity modelManagerActivity;
                PolicyActivity policyActivity = this.f3289a;
                if (policyActivity.f5765b) {
                    return;
                }
                policyActivity.f5765b = true;
                CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
                cTAPermissionManager.setCTAPermission(false);
                cTAPermissionManager.setModelServiceEnabled(false);
                LogModule logModule = LogModule.SERVICE;
                String str = policyActivity.f5764a;
                CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
                Intent intent = policyActivity.getIntent();
                kotlin.jvm.internal.g.e(intent, "getIntent(...)");
                AIEngineLogger.i(logModule, str, "onPolicyDeny fromGate=" + cTADialogGate.isFromGate(intent));
                policyActivity.a();
                policyActivity.d(false);
                Intent intent2 = policyActivity.getIntent();
                kotlin.jvm.internal.g.e(intent2, "getIntent(...)");
                if (!cTADialogGate.isFromGate(intent2)) {
                    WeakReference<ModelManagerActivity> weakReference = ModelManagerActivity.f5847u;
                    ModelManagerActivity modelManagerActivity2 = null;
                    if (weakReference != null && (modelManagerActivity = weakReference.get()) != null && !modelManagerActivity.isFinishing() && !modelManagerActivity.isDestroyed()) {
                        modelManagerActivity2 = modelManagerActivity;
                    }
                    if (modelManagerActivity2 != null) {
                        modelManagerActivity2.finish();
                    }
                }
                policyActivity.setResult(0);
                policyActivity.b();
            }
        };
        aVar2.h = aVar2.f12081a.getText(R.string.cta_policy_btn_refuse);
        aVar2.f12088i = onClickListener;
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: c6.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                Set<String> set = PolicyActivity.f5763d;
                boolean zIsChecked = checkBox.isChecked();
                PolicyActivity policyActivity = this.f3290a;
                if (policyActivity.f5765b) {
                    return;
                }
                policyActivity.f5765b = true;
                CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
                cTAPermissionManager.setCTAPermission(true);
                cTAPermissionManager.setModelServiceEnabled(true);
                cTAPermissionManager.setWlanAutoUpgrade(zIsChecked);
                try {
                    CtaGatedInitManager ctaGatedInitManager = CtaGatedInitManager.INSTANCE;
                    Application application = policyActivity.getApplication();
                    kotlin.jvm.internal.g.e(application, "getApplication(...)");
                    ctaGatedInitManager.refresh(application);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                LogModule logModule = LogModule.SERVICE;
                String str = policyActivity.f5764a;
                CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
                Intent intent = policyActivity.getIntent();
                kotlin.jvm.internal.g.e(intent, "getIntent(...)");
                AIEngineLogger.i(logModule, str, "onPolicyAgree fromGate=" + cTADialogGate.isFromGate(intent));
                policyActivity.a();
                policyActivity.d(true);
                policyActivity.setResult(-1);
                policyActivity.b();
            }
        };
        aVar2.f12086f = aVar2.f12081a.getText(R.string.cta_policy_btn_agree);
        aVar2.f12087g = onClickListener2;
        aVar2.f12089j = false;
        e eVarA = aVar.a(new d(aVar));
        eVarA.show();
        int color = getColor(R.color.cta_dialog_btn_text);
        Button button = eVarA.getButton(-2);
        if (button != null) {
            button.setTextColor(color);
            button.setBackgroundResource(R.drawable.cta_bg_btn_negative);
        }
        Button button2 = eVarA.getButton(-1);
        if (button2 != null) {
            button2.setTextColor(color);
            button2.setBackgroundResource(R.drawable.cta_bg_btn_agree);
        }
        this.f5766c = eVarA;
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        if (!CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            f();
            return;
        }
        this.f5765b = true;
        CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
        Intent intent = getIntent();
        g.e(intent, "getIntent(...)");
        if (cTADialogGate.isFromGate(intent)) {
            Intent intent2 = getIntent();
            g.e(intent2, "getIntent(...)");
            cTADialogGate.dispatchResult(cTADialogGate.readCallingUid(intent2), true, this);
        }
        setResult(-1);
        b();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        a();
        CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
        cTADialogGate.markDialogHostGone();
        super.onDestroy();
        if (this.f5765b) {
            return;
        }
        Intent intent = getIntent();
        g.e(intent, "getIntent(...)");
        if (cTADialogGate.isFromGate(intent)) {
            Intent intent2 = getIntent();
            g.e(intent2, "getIntent(...)");
            CTADialogGate.dispatchResult$default(cTADialogGate, cTADialogGate.readCallingUid(intent2), false, null, 4, null);
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        g.f(intent, "intent");
        super.onNewIntent(intent);
        boolean zIsFinishing = isFinishing();
        String str = this.f5764a;
        if (zIsFinishing || isDestroyed()) {
            AIEngineLogger.i(LogModule.SERVICE, str, "onNewIntent: instance finishing → cancel this gate");
            CTADialogGate cTADialogGate = CTADialogGate.INSTANCE;
            if (cTADialogGate.isFromGate(intent)) {
                CTADialogGate.dispatchResult$default(cTADialogGate, cTADialogGate.readCallingUid(intent), false, null, 4, null);
                return;
            }
            return;
        }
        setIntent(intent);
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            this.f5765b = true;
            CTADialogGate cTADialogGate2 = CTADialogGate.INSTANCE;
            if (cTADialogGate2.isFromGate(intent)) {
                cTADialogGate2.dispatchResult(cTADialogGate2.readCallingUid(intent), true, this);
            }
            setResult(-1);
            b();
            return;
        }
        boolean z = false;
        this.f5765b = false;
        LogModule logModule = LogModule.SERVICE;
        e eVar = this.f5766c;
        if (eVar != null && eVar.isShowing()) {
            z = true;
        }
        AIEngineLogger.i(logModule, str, "onNewIntent: re-arm CTA dialog (dialogShowing=" + z + ")");
        e eVar2 = this.f5766c;
        if (eVar2 == null || !eVar2.isShowing()) {
            f();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f5765b || !CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            return;
        }
        this.f5765b = true;
        AIEngineLogger.i(LogModule.SERVICE, this.f5764a, "onResume: CTA granted elsewhere → dismiss stale dialog");
        a();
        d(true);
        setResult(-1);
        b();
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (this.f5765b) {
            return;
        }
        boolean zC = c();
        String str = this.f5764a;
        if (zC) {
            AIEngineLogger.i(LogModule.SERVICE, str, "onStop: policy viewer in foreground → keep CTA (not cancel)");
            return;
        }
        Object systemService = getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if ((powerManager == null || powerManager.isInteractive()) && !isChangingConfigurations()) {
            e("onStop");
        } else {
            AIEngineLogger.i(LogModule.SERVICE, str, "onStop: screen-off/config-change → keep CTA (not cancel)");
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        e("onUserLeaveHint");
    }
}
