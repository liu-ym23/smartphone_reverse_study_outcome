package com.stepos.aiengine.modelmanager;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.p;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.datepicker.k;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.ModelManagerActivity;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.aiengine.modelmanager.settings.ModelManagerSettingsActivity;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.settings.AiEngineSystemSettings;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.confirmui.ConfirmUiRequest;
import h6.d;
import h6.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.v;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelManagerActivity extends i {

    /* renamed from: t, reason: collision with root package name */
    public static volatile boolean f5846t;

    /* renamed from: u, reason: collision with root package name */
    public static WeakReference<ModelManagerActivity> f5847u;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5849c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f5850d;

    /* renamed from: e, reason: collision with root package name */
    public ImageButton f5851e;
    public ModelManagerFragment h;

    /* renamed from: j, reason: collision with root package name */
    public String f5852j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5853k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5854l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5855m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5856n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5857o;

    /* renamed from: p, reason: collision with root package name */
    public ContentObserver f5858p;

    /* renamed from: q, reason: collision with root package name */
    public d f5859q;

    /* renamed from: b, reason: collision with root package name */
    public final String f5848b = "ModelManagerActivity";
    public final e r = new CTAPermissionManager.SwitchChangeListener() { // from class: h6.e
        @Override // com.stepos.core.cta.CTAPermissionManager.SwitchChangeListener
        public final void onChanged() {
            ModelManagerActivity modelManagerActivity = this.f9304a;
            boolean z = ModelManagerActivity.f5846t;
            if (modelManagerActivity.isFinishing() || modelManagerActivity.isDestroyed()) {
                return;
            }
            modelManagerActivity.runOnUiThread(new c(modelManagerActivity, 1));
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public final b f5860s = new b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static ModelManagerActivity a() {
            ModelManagerActivity modelManagerActivity;
            WeakReference<ModelManagerActivity> weakReference = ModelManagerActivity.f5847u;
            if (weakReference == null || (modelManagerActivity = weakReference.get()) == null || modelManagerActivity.isFinishing() || modelManagerActivity.isDestroyed()) {
                return null;
            }
            return modelManagerActivity;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends p {
        public b() {
            super(false);
        }

        @Override // b.p
        public final void d() {
            ModelManagerActivity modelManagerActivity = ModelManagerActivity.this;
            boolean z = ModelManagerActivity.f5846t;
            modelManagerActivity.y(false);
        }
    }

    public final void A() {
        TextView textView = this.f5850d;
        if (textView != null) {
            if (this.f5849c) {
                textView.setText(getString(R.string.model_manager_toolbar_done));
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                textView.setText("");
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.mm_ic_edit, 0, 0, 0);
            }
            textView.setContentDescription(getString(this.f5849c ? R.string.mm_menu_done : R.string.mm_menu_edit));
        }
        ImageButton imageButton = this.f5851e;
        if (imageButton != null) {
            imageButton.setVisibility(this.f5849c ? 8 : 0);
        }
    }

    @Override // androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        CTAPermissionManager cTAPermissionManager = CTAPermissionManager.INSTANCE;
        setTheme(cTAPermissionManager.hasCTAPermission() ? R.style.Theme_ModelManager : R.style.Theme_ModelManager_CtaPlaceholder);
        super.onCreate(bundle);
        ModelManagerActivity modelManagerActivityA = a.a();
        if (bundle != null || modelManagerActivityA == null || modelManagerActivityA == this || modelManagerActivityA.getTaskId() == getTaskId()) {
            f5847u = new WeakReference<>(this);
            s(getIntent());
            w(getIntent());
            if (cTAPermissionManager.hasCTAPermission()) {
                u(bundle);
                return;
            } else {
                t();
                return;
            }
        }
        modelManagerActivityA.x(getIntent());
        try {
            ActivityManager activityManager = (ActivityManager) getSystemService(ActivityManager.class);
            if (activityManager != null) {
                activityManager.moveTaskToFront(modelManagerActivityA.getTaskId(), 0);
                n nVar = n.f10413a;
            }
        } catch (Throwable th) {
            c.a(th);
        }
        s(getIntent());
        finish();
    }

    @Override // androidx.appcompat.app.i, androidx.fragment.app.o, android.app.Activity
    public final void onDestroy() {
        r();
        z();
        if (a.a() == this) {
            f5847u = null;
        }
        f5846t = false;
        this.f5857o = false;
        super.onDestroy();
    }

    @Override // b.k, android.app.Activity
    public final void onNewIntent(Intent intent) {
        g.f(intent, "intent");
        super.onNewIntent(intent);
        x(intent);
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            u(null);
        }
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public final void onPause() {
        super.onPause();
        f5846t = false;
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public final void onResume() {
        super.onResume();
        r();
        if (!isFinishing()) {
            f5847u = new WeakReference<>(this);
        }
        f5846t = true;
        this.f5857o = false;
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            u(null);
        } else {
            if (isFinishing() || isDestroyed()) {
                return;
            }
            t();
        }
    }

    @Override // androidx.appcompat.app.i, androidx.fragment.app.o, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (CTAPermissionManager.INSTANCE.hasCTAPermission() || isChangingConfigurations()) {
            return;
        }
        r();
        d dVar = new d(this, 0);
        this.f5859q = dVar;
        getWindow().getDecorView().postDelayed(dVar, 350L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            u(null);
        }
    }

    public final void r() {
        d dVar = this.f5859q;
        if (dVar != null) {
            getWindow().getDecorView().removeCallbacks(dVar);
        }
        this.f5859q = null;
    }

    public final void s(Intent intent) {
        int intExtra = intent != null ? intent.getIntExtra(ModelDownloadNotifier.EXTRA_DISMISS_NOTIF_ID, -1) : -1;
        if (intExtra < 0) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.cancel(intExtra);
        }
        if (intent != null) {
            intent.removeExtra(ModelDownloadNotifier.EXTRA_DISMISS_NOTIF_ID);
        }
    }

    public final void t() {
        if (!this.f5855m && !this.f5854l) {
            this.f5855m = true;
            setContentView(R.layout.activity_model_manager_cta_placeholder);
            View viewFindViewById = findViewById(R.id.main);
            if (viewFindViewById != null) {
                h0.e eVar = new h0.e();
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                e0.d.k(viewFindViewById, eVar);
            }
        }
        CTAPermissionManager.INSTANCE.addSwitchListener(this.r);
        if (this.f5858p == null) {
            this.f5858p = AiEngineSystemSettings.INSTANCE.registerSwitchObserver(this, new b6.g(this, 11));
        }
        getWindow().getDecorView().post(new h6.c(this, 0));
    }

    public final void u(Bundle bundle) {
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            final int i10 = 0;
            this.f5857o = false;
            final int i11 = 1;
            if (!this.f5854l) {
                setTheme(R.style.Theme_ModelManager);
                this.f5854l = true;
                setContentView(R.layout.activity_model_manager);
                View viewFindViewById = findViewById(R.id.main);
                if (viewFindViewById != null) {
                    h0.e eVar = new h0.e();
                    WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                    e0.d.k(viewFindViewById, eVar);
                }
                View viewFindViewById2 = findViewById(R.id.toolbar);
                g.c(viewFindViewById2);
                getOnBackPressedDispatcher().a(this, this.f5860s);
                ((MaterialToolbar) viewFindViewById2).setNavigationOnClickListener(new View.OnClickListener(this) { // from class: h6.b

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ ModelManagerActivity f9299b;

                    {
                        this.f9299b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i10) {
                            case 0:
                                ModelManagerActivity modelManagerActivity = this.f9299b;
                                if (!modelManagerActivity.f5849c) {
                                    modelManagerActivity.finish();
                                    break;
                                } else {
                                    modelManagerActivity.y(false);
                                    break;
                                }
                            default:
                                this.f9299b.y(!r0.f5849c);
                                break;
                        }
                    }
                });
                ImageButton imageButton = (ImageButton) findViewById(R.id.btn_settings);
                this.f5851e = imageButton;
                if (imageButton != null) {
                    imageButton.setOnClickListener(new k(this, 5));
                }
                TextView textView = (TextView) findViewById(R.id.btn_edit);
                this.f5850d = textView;
                if (textView != null) {
                    textView.setOnClickListener(new View.OnClickListener(this) { // from class: h6.b

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ ModelManagerActivity f9299b;

                        {
                            this.f9299b = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            switch (i11) {
                                case 0:
                                    ModelManagerActivity modelManagerActivity = this.f9299b;
                                    if (!modelManagerActivity.f5849c) {
                                        modelManagerActivity.finish();
                                        break;
                                    } else {
                                        modelManagerActivity.y(false);
                                        break;
                                    }
                                default:
                                    this.f9299b.y(!r0.f5849c);
                                    break;
                            }
                        }
                    });
                }
                A();
            }
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            g.e(supportFragmentManager, "getSupportFragmentManager(...)");
            Fragment fragmentA = supportFragmentManager.A(R.id.pref_container);
            ModelManagerFragment modelManagerFragment = fragmentA instanceof ModelManagerFragment ? (ModelManagerFragment) fragmentA : null;
            if (modelManagerFragment != null) {
                this.h = modelManagerFragment;
                this.f5856n = true;
                z();
                return;
            }
            if (this.f5856n) {
                this.f5856n = false;
            }
            if (this.f5856n) {
                return;
            }
            this.f5856n = true;
            z();
            if (bundle == null) {
                try {
                    n6.a.f10642a.getClass();
                    n6.a.a("nav_model_management_in", v.b0(new Pair("in_status", "model_manager")));
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    c.a(th);
                }
            }
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            g.e(supportFragmentManager2, "getSupportFragmentManager(...)");
            Fragment fragmentA2 = supportFragmentManager2.A(R.id.pref_container);
            ModelManagerFragment modelManagerFragment2 = fragmentA2 instanceof ModelManagerFragment ? (ModelManagerFragment) fragmentA2 : null;
            if (modelManagerFragment2 != null) {
                this.h = modelManagerFragment2;
                return;
            }
            ModelManagerFragment.a aVar = ModelManagerFragment.Companion;
            String str = this.f5852j;
            String strResolveAnyToOta = str != null ? OtaEngine.INSTANCE.resolveAnyToOta(str) : null;
            aVar.getClass();
            ModelManagerFragment modelManagerFragment3 = new ModelManagerFragment();
            Bundle bundle2 = new Bundle();
            if (strResolveAnyToOta != null) {
                bundle2.putString("highlight_model", strResolveAnyToOta);
            }
            modelManagerFragment3.setArguments(bundle2);
            this.h = modelManagerFragment3;
            androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(supportFragmentManager2);
            aVar2.e(modelManagerFragment3, R.id.pref_container);
            if (supportFragmentManager2.K()) {
                aVar2.g(true);
            } else {
                if (aVar2.f2101g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                aVar2.h = false;
                aVar2.f2075q.y(aVar2, false);
            }
            if (this.f5853k) {
                this.f5853k = false;
                Intent intent = new Intent("com.stepos.aiengine.action.MODEL_MANAGER_SETTINGS");
                intent.setPackage("com.stepos.aiengine");
                intent.setClassName("com.stepos.aiengine", ModelManagerSettingsActivity.class.getName());
                intent.putExtra("com.stepos.aiengine.extra.CALLER_PACKAGE", getPackageName());
                startActivity(intent);
            }
        }
    }

    public final boolean v() {
        Object objA;
        ActivityManager activityManager;
        boolean z;
        Object objA2;
        ComponentName componentName;
        try {
            activityManager = (ActivityManager) getSystemService(ActivityManager.class);
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
                Object obj = null;
                try {
                    ActivityManager.RecentTaskInfo taskInfo = ((ActivityManager.AppTask) it.next()).getTaskInfo();
                    objA2 = (taskInfo == null || (componentName = taskInfo.topActivity) == null) ? null : componentName.getClassName();
                } catch (Throwable th2) {
                    objA2 = c.a(th2);
                }
                if (!(objA2 instanceof Result.Failure)) {
                    obj = objA2;
                }
                if (g.b((String) obj, "com.stepos.aiengine.cta.PolicyActivity")) {
                    z = true;
                    break;
                }
            }
        }
        objA = Boolean.valueOf(z);
        Object obj2 = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj2;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void w(Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action == null || action.equals(ModelDownloadNotifier.ACTION_MODEL_MANAGER) || action.equals("com.stepos.aiengine.action.MODEL_MANAGER_SETTINGS")) {
            String stringExtra = intent.getStringExtra("com.stepos.aiengine.extra.MODEL_ID");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("com.stepos.aiengine.extra.ABILITY_ID");
            }
            this.f5852j = stringExtra;
            this.f5853k = intent.getBooleanExtra("com.stepos.aiengine.extra.OPEN_SETTINGS", false) || g.b(action, "com.stepos.aiengine.action.MODEL_MANAGER_SETTINGS");
        }
    }

    public final void x(Intent intent) {
        ModelManagerFragment modelManagerFragment;
        if (intent == null) {
            return;
        }
        setIntent(intent);
        s(intent);
        w(intent);
        String str = this.f5852j;
        if (str != null && (modelManagerFragment = this.h) != null) {
            modelManagerFragment.highlightModel(str);
        }
        String stringExtra = intent.getStringExtra("com.stepos.aiengine.extra.PENDING_CONFIRM");
        if (stringExtra != null) {
            intent.removeExtra("com.stepos.aiengine.extra.PENDING_CONFIRM");
            OtaModelClient.f5871a.getClass();
            ConfirmUiRequest confirmUiRequestRemove = OtaModelClient.f5880k.remove(stringExtra);
            if (confirmUiRequestRemove != null) {
                OtaModelClient.f5879j.show(confirmUiRequestRemove);
            }
        }
        if (this.f5853k) {
            this.f5853k = false;
            Intent intent2 = new Intent("com.stepos.aiengine.action.MODEL_MANAGER_SETTINGS");
            intent2.setPackage("com.stepos.aiengine");
            intent2.setClassName("com.stepos.aiengine", ModelManagerSettingsActivity.class.getName());
            intent2.putExtra("com.stepos.aiengine.extra.CALLER_PACKAGE", getPackageName());
            startActivity(intent2);
        }
        if (CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            return;
        }
        this.f5857o = false;
        t();
    }

    public final void y(boolean z) {
        if (this.f5849c == z) {
            return;
        }
        this.f5849c = z;
        this.f5860s.e(z);
        A();
        ModelManagerFragment modelManagerFragment = this.h;
        if (modelManagerFragment != null) {
            modelManagerFragment.setEditing(this.f5849c);
        }
    }

    public final void z() {
        CTAPermissionManager.INSTANCE.removeSwitchListener(this.r);
        ContentObserver contentObserver = this.f5858p;
        if (contentObserver != null) {
            AiEngineSystemSettings.INSTANCE.unregisterSwitchObserver(this, contentObserver);
        }
        this.f5858p = null;
    }
}
