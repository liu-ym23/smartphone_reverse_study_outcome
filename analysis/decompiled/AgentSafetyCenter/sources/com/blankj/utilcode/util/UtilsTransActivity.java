package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import h.i;
import h.j;
import h.k;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import od.f;
import t4.d;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class UtilsTransActivity extends k {

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f2289f = new HashMap();

    public UtilsTransActivity() {
        d savedStateRegistry = getSavedStateRegistry();
        i iVar = new i(0);
        iVar.f4842b = this;
        VarHandle.storeStoreFence();
        savedStateRegistry.c("androidx:appcompat", iVar);
        j jVar = new j();
        jVar.f4843a = this;
        VarHandle.storeStoreFence();
        addOnContextAvailableListener(jVar);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (f2289f.get(this) == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        f.j();
        return false;
    }

    @Override // androidx.fragment.app.j, androidx.activity.p, android.app.Activity
    public final void onActivityResult(int i, int i3, Intent intent) {
        super.onActivityResult(i, i3, intent);
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }

    @Override // androidx.fragment.app.j, androidx.activity.p, d3.c, android.app.Activity
    public final void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        getIntent().getSerializableExtra("extra_delegate");
        super.onCreate(bundle);
        finish();
    }

    @Override // h.k, androidx.fragment.app.j, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public final void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }

    @Override // androidx.fragment.app.j, androidx.activity.p, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }

    @Override // androidx.activity.p, d3.c, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }

    @Override // h.k, androidx.fragment.app.j, android.app.Activity
    public final void onStart() throws PackageManager.NameNotFoundException {
        super.onStart();
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }

    @Override // h.k, androidx.fragment.app.j, android.app.Activity
    public final void onStop() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onStop();
        if (f2289f.get(this) == null) {
            return;
        }
        f.j();
    }
}
