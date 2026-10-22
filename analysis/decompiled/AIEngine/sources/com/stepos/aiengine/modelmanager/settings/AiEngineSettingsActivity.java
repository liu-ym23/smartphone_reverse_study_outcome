package com.stepos.aiengine.modelmanager.settings;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a;
import bd.j;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.datepicker.k;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.settings.AiEngineSettingsActivity;
import com.stepos.core.cta.CtaGateGuard;
import com.stepos.core.ota.d;
import d.b;
import e.c;
import java.util.ArrayList;
import java.util.WeakHashMap;
import kotlin.jvm.internal.g;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AiEngineSettingsActivity extends i {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f5904d = 0;

    /* renamed from: b, reason: collision with root package name */
    public MaterialToolbar f5905b;

    /* renamed from: c, reason: collision with root package name */
    public final b<Intent> f5906c = registerForActivityResult(new c(), new j(this));

    @Override // androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setTheme(R.style.Theme_ModelManager);
        setContentView(R.layout.activity_model_manager_settings);
        View viewFindViewById = findViewById(R.id.main);
        g.c(viewFindViewById);
        d dVar = new d(15);
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        e0.d.k(viewFindViewById, dVar);
        View viewFindViewById2 = findViewById(R.id.toolbar);
        g.c(viewFindViewById2);
        MaterialToolbar materialToolbar = (MaterialToolbar) viewFindViewById2;
        this.f5905b = materialToolbar;
        materialToolbar.setNavigationOnClickListener(new k(this, 6));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentManager.l lVar = new FragmentManager.l() { // from class: j6.a
            @Override // androidx.fragment.app.FragmentManager.l
            public final void onBackStackChanged() throws Resources.NotFoundException {
                int i10 = AiEngineSettingsActivity.f5904d;
                this.f9708a.r();
            }
        };
        if (supportFragmentManager.f2023l == null) {
            supportFragmentManager.f2023l = new ArrayList<>();
        }
        supportFragmentManager.f2023l.add(lVar);
        if (bundle == null) {
            CtaGateGuard ctaGateGuard = CtaGateGuard.INSTANCE;
            if (ctaGateGuard.isAuthorized()) {
                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                supportFragmentManager2.getClass();
                a aVar = new a(supportFragmentManager2);
                aVar.e(new AiEngineSettingsFragment(), R.id.settings_container);
                aVar.g(false);
            } else {
                this.f5906c.a(ctaGateGuard.createPolicyIntent(this));
            }
        }
        r();
    }

    public final void r() throws Resources.NotFoundException {
        Fragment fragmentA = getSupportFragmentManager().A(R.id.settings_container);
        MaterialToolbar materialToolbar = this.f5905b;
        if (materialToolbar != null) {
            materialToolbar.setTitle(fragmentA instanceof PrivacySettingsFragment ? getString(R.string.mm_privacy_title) : getString(R.string.mm_ai_engine_settings_title));
        } else {
            g.l("toolbar");
            throw null;
        }
    }
}
