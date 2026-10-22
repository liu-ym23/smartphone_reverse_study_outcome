package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.blankj.utilcode.util.p;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public class UtilsTransActivity extends androidx.appcompat.app.d {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<UtilsTransActivity, TransActivityDelegate> f19232a = new HashMap();

    public static abstract class TransActivityDelegate implements Serializable {
        public boolean a(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            return false;
        }

        public void b(UtilsTransActivity utilsTransActivity, int i10, int i11, Intent intent) {
        }

        public void c(UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void d(UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void e(UtilsTransActivity utilsTransActivity) {
        }

        public void f(UtilsTransActivity utilsTransActivity) {
        }

        public void g(UtilsTransActivity utilsTransActivity, int i10, String[] strArr, int[] iArr) {
        }

        public void h(UtilsTransActivity utilsTransActivity) {
        }

        public void i(UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void j(UtilsTransActivity utilsTransActivity) {
        }

        public void k(UtilsTransActivity utilsTransActivity) {
        }
    }

    public static void r(Activity activity, p.b<Intent> bVar, TransActivityDelegate transActivityDelegate, Class<?> cls) {
        if (transActivityDelegate == null) {
            return;
        }
        Intent intent = new Intent(p.a(), cls);
        intent.putExtra("extra_delegate", transActivityDelegate);
        if (bVar != null) {
            bVar.accept(intent);
        }
        if (activity != null) {
            activity.startActivity(intent);
        } else {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            p.a().startActivity(intent);
        }
    }

    public static void s(p.b<Intent> bVar, TransActivityDelegate transActivityDelegate) {
        r(null, bVar, transActivityDelegate, UtilsTransActivity.class);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate != null && transActivityDelegate.a(this, motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.r, b.q, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.b(this, i10, i11, intent);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_delegate");
        if (!(serializableExtra instanceof TransActivityDelegate)) {
            super.onCreate(bundle);
            finish();
            return;
        }
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) serializableExtra;
        f19232a.put(this, transActivityDelegate);
        transActivityDelegate.c(this, bundle);
        super.onCreate(bundle);
        transActivityDelegate.d(this, bundle);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Map<UtilsTransActivity, TransActivityDelegate> map = f19232a;
        TransActivityDelegate transActivityDelegate = map.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.e(this);
        map.remove(this);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.f(this);
    }

    @Override // androidx.fragment.app.r, b.q, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.g(this, i10, strArr, iArr);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.h(this);
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.i(this, bundle);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStart() {
        super.onStart();
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.j(this);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        super.onStop();
        TransActivityDelegate transActivityDelegate = f19232a.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.k(this);
    }
}
