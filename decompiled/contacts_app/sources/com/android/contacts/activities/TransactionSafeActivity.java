package com.android.contacts.activities;

import android.os.Bundle;
import com.android.contacts.BaseActivity;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class TransactionSafeActivity extends BaseActivity {
    private boolean mIsSafeToCommitTransactions;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_TransactionSafeActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_activities_TransactionSafeActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_contacts_activities_TransactionSafeActivity_com_obric_privacyhook_PrivacyHook_onStart(this);
    }

    public TransactionSafeActivity() {
    }

    public void com_android_contacts_activities_TransactionSafeActivity__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mIsSafeToCommitTransactions = true;
    }

    public void com_android_contacts_activities_TransactionSafeActivity__onStart$___twin___() {
        super.onStart();
        this.mIsSafeToCommitTransactions = true;
    }

    public void com_android_contacts_activities_TransactionSafeActivity__onResume$___twin___() {
        super.onResume();
        this.mIsSafeToCommitTransactions = true;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        this.mIsSafeToCommitTransactions = false;
    }

    public boolean isSafeToCommitTransactions() {
        return this.mIsSafeToCommitTransactions;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_TransactionSafeActivity_com_obric_privacyhook_PrivacyHook_onCreate(TransactionSafeActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        TransactionSafeActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_TransactionSafeActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStart")
    public static void com_android_contacts_activities_TransactionSafeActivity_com_obric_privacyhook_PrivacyHook_onStart(TransactionSafeActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        TransactionSafeActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r2.com_android_contacts_activities_TransactionSafeActivity__onStart$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_activities_TransactionSafeActivity_com_obric_privacyhook_PrivacyHook_onResume(TransactionSafeActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        TransactionSafeActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_activities_TransactionSafeActivity__onResume$___twin___();
    }
}
