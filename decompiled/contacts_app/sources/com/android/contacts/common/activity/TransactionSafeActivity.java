package com.android.contacts.common.activity;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransactionSafeActivity extends Activity {
    private boolean mIsSafeToCommitTransactions;

    public void com_android_contacts_common_activity_TransactionSafeActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_activity_TransactionSafeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public TransactionSafeActivity() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mIsSafeToCommitTransactions = true;
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mIsSafeToCommitTransactions = true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsSafeToCommitTransactions = true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        this.mIsSafeToCommitTransactions = false;
    }

    public boolean isSafeToCommitTransactions() {
        return this.mIsSafeToCommitTransactions;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_activity_TransactionSafeActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(TransactionSafeActivity r1) {
        r1.com_android_contacts_common_activity_TransactionSafeActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
