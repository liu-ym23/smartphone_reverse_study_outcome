package com.stepos.aiengine.modelmanager.settings;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.i;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.datepicker.k;
import com.stepos.aiengine.R;
import com.stepos.core.ota.d;
import java.util.WeakHashMap;
import kotlin.jvm.internal.g;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelManagerSettingsActivity extends i {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5907b = 0;

    @Override // androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.Theme_ModelManager);
        setContentView(R.layout.activity_model_manager_settings);
        View viewFindViewById = findViewById(R.id.main);
        g.c(viewFindViewById);
        d dVar = new d(16);
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        e0.d.k(viewFindViewById, dVar);
        View viewFindViewById2 = findViewById(R.id.toolbar);
        g.c(viewFindViewById2);
        ((MaterialToolbar) viewFindViewById2).setNavigationOnClickListener(new k(this, 7));
        if (bundle == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.getClass();
            a aVar = new a(supportFragmentManager);
            aVar.e(new ModelManagerSettingsFragment(), R.id.settings_container);
            aVar.g(false);
        }
    }
}
