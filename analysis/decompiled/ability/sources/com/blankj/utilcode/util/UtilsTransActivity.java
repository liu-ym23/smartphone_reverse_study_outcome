package com.blankj.utilcode.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class UtilsTransActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f2201a = new HashMap();

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (f2201a.get(this) == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        throw new ClassCastException();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i, int i6, Intent intent) {
        super.onActivityResult(i, i6, intent);
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        getIntent().getSerializableExtra("extra_delegate");
        super.onCreate(bundle);
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }

    @Override // android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (f2201a.get(this) != null) {
            throw new ClassCastException();
        }
    }
}
