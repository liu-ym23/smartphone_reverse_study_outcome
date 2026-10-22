package com.android.contacts.recyclebin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.android.contacts.ContactsActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleItemDetailActivity extends ContactsActivity {
    private static String DETAIL_FRAGMENT_TAG = "recycle_item_detail";

    static {
    }

    public void com_android_contacts_recyclebin_RecycleItemDetailActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_recyclebin_RecycleItemDetailActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_recyclebin_RecycleItemDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public RecycleItemDetailActivity() {
    }

    public void com_android_contacts_recyclebin_RecycleItemDetailActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.contact_detail_activity);
        UiUtils.setWindowColorStatusBar(this);
        ((OFloatingTitleBar) findViewById(R.id.otitlebar)).addStartAction(R.drawable.icon_back_22_22, -1, new AnonymousClass1(this));
        Intent r5 = getIntent();
        if (r5 != null) goto L5;
    L12:
        finish();
        return;
    L5:
        if (r5.getParcelableExtra("recycle_item") == null) goto L12;
        RecycleItem r6 = (RecycleItem) r5.getParcelableExtra("recycle_item");
        FragmentManager r3 = getFragmentManager();
        RecycleItemDetailFragment r0 = (RecycleItemDetailFragment) r3.findFragmentByTag(DETAIL_FRAGMENT_TAG);
        if (r0 != null) goto L10;
        r0 = RecycleItemDetailFragment.newInstance();
    L10:
        r0.setRecycleItem(r6);
        FragmentTransaction r7 = r3.beginTransaction();
        r7.replace(R.id.contact_detail_container, r0, DETAIL_FRAGMENT_TAG);
        r7.commitAllowingStateLoss();
        r3.executePendingTransactions();
    }

    private OButton getTransTitleBtn(int r2, boolean r3, OCTitleBar r4) {
        LinearLayout r0 = r4.mLeftContainer;
        if (r3 == true) goto L5;
        r0 = r4.mRightContainer;
    L5:
        OButton r5 = r4.createTransIconButton(this, r0);
        r5.setMIcon(getResources().getDrawable(r2));
        return r5;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_recyclebin_RecycleItemDetailActivity_com_obric_privacyhook_PrivacyHook_onCreate(RecycleItemDetailActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        RecycleItemDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_recyclebin_RecycleItemDetailActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_recyclebin_RecycleItemDetailActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(RecycleItemDetailActivity r1) {
        com_android_contacts_recyclebin_RecycleItemDetailActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_recyclebin_RecycleItemDetailActivity_com_obric_privacyhook_PrivacyHook_onStop(RecycleItemDetailActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        RecycleItemDetailActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_recyclebin_RecycleItemDetailActivity__onStop$___twin___();
    }
}
