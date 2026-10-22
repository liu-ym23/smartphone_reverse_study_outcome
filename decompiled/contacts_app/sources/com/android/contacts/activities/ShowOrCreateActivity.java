package com.android.contacts.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsActivity;
import com.android.contacts.R;
import com.android.contacts.util.Constants;
import com.android.contacts.util.IntentUtils;
import com.android.contacts.util.NotifyingAsyncQueryHandler;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.privacy.PrivacyUtils;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class ShowOrCreateActivity extends ContactsActivity implements NotifyingAsyncQueryHandler.AsyncQueryListener {
    static final String[] CONTACTS_PROJECTION = null;
    static final int CONTACT_ID_INDEX = 0;
    static final int CREATE_CONTACT_DIALOG = 1;
    static final boolean LOGD = false;
    static final int LOOKUP_KEY_INDEX = 1;
    static final String[] PHONES_PROJECTION = null;
    static final int QUERY_TOKEN = 42;
    static final String TAG = "ShowOrCreateActivity";
    private String mCreateDescrip;
    private Bundle mCreateExtras;
    private boolean mCreateForce;
    private NotifyingAsyncQueryHandler mQueryHandler;

    private static class IntentClickListener implements DialogInterface.OnClickListener {
        private Intent mIntent;
        private Activity mParent;

        public IntentClickListener(Activity r1, Intent r2) {
            this.mParent = r1;
            this.mIntent = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            Intent r3 = this.mIntent;
            if (r3 == null) goto L5;
            this.mParent.startActivity(r3);
        L5:
            this.mParent.finish();
        }
    }

    @Override // com.android.contacts.ContactsActivity, com.android.contacts.activities.TransactionSafeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_activities_ShowOrCreateActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.ContactsActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_contacts_activities_ShowOrCreateActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public ShowOrCreateActivity() {
    }

    static {
        PHONES_PROJECTION = new String[]{"_id", "lookup"};
        CONTACTS_PROJECTION = new String[]{"contact_id", "lookup"};
    }

    public void com_android_contacts_activities_ShowOrCreateActivity__onCreate$___twin___(Bundle r10) {
        super.onCreate(r10);
        UiUtils.setWindowColorStatusBar(this);
        NotifyingAsyncQueryHandler r11 = this.mQueryHandler;
        if (r11 != null) goto L5;
        this.mQueryHandler = new NotifyingAsyncQueryHandler(this, this);
    L6:
        Intent r12 = getIntent();
        Uri r0 = r12.getData();
        if (r0 == null) goto L9;
        String r1 = r0.getScheme();
        String r2 = r0.getSchemeSpecificPart();
    L10:
        this.mCreateExtras = new Bundle();
        Bundle r3 = r12.getExtras();
        if (r3 != null) goto L27;
    L16:
        String r4 = IntentUtils.getStringExtra(r12, "com.android.contacts.action.CREATE_DESCRIPTION");
        this.mCreateDescrip = r4;
        if (r4 != null) goto L19;
        this.mCreateDescrip = r2;
    L19:
        this.mCreateForce = r12.getBooleanExtra("com.android.contacts.action.FORCE_CREATE", false);
        if ("mailto".equals(r1) == false) goto L23;
        this.mCreateExtras.putString("email", r2);
        this.mCreateExtras.putString("query", r2);
        this.mQueryHandler.startQuery(42, null, Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI, Uri.encode(r2)), CONTACTS_PROJECTION, null, null, null);
        return;
    L23:
        if (Constants.SCHEME_TEL.equals(r1) == false) goto L25;
        this.mCreateExtras.putString("phone", r2);
        this.mCreateExtras.putString("query", r2);
        this.mQueryHandler.startQuery(42, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, r2), PHONES_PROJECTION, null, null, null);
        return;
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Invalid intent:" + getIntent());
        finish();
        return;
    L27:
        this.mCreateExtras.putAll(r3);     // Catch: RuntimeException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L9:
        r1 = null;
        r2 = null;
        goto L10
    L5:
        r11.cancelOperation(42);
        goto L6
    }

    public void com_android_contacts_activities_ShowOrCreateActivity__onStop$___twin___() {
        super.onStop();
        NotifyingAsyncQueryHandler r1 = this.mQueryHandler;
        if (r1 == null) goto L6;
        r1.cancelOperation(42);
        return;
    }

    @Override // com.android.contacts.util.NotifyingAsyncQueryHandler.AsyncQueryListener
    public void onQueryComplete(int r6, Object r7, Cursor r8) {
        if (r8 != null) goto L27;
        finish();
        return;
    L27:
        int r9 = r8.getCount();     // Catch: Throwable -> L24
        if (r9 == 1) goto L8;
    L11:
        String r4 = null;
        long r2 = -1;
    L12:
        r8.close();
        if (r9 == 1) goto L15;
    L17:
        if (r9 <= 1) goto L20;
        Intent r10 = new Intent("android.intent.action.SEARCH");
        r10.setComponent(new ComponentName(this, DialtactsActivity.class));
        r10.putExtras(this.mCreateExtras);
        startActivity(r10);
        finish();
        return;
    L20:
        if (this.mCreateForce == false) goto L22;
        Intent r11 = new Intent("android.intent.action.INSERT", ContactsContract.RawContacts.CONTENT_URI);
        r11.putExtras(this.mCreateExtras);
        r11.setType("vnd.android.cursor.dir/raw_contact");
        startActivity(r11);
        finish();
        return;
    L22:
        showDialog(1);
        return;
    L15:
        if (r2 == (-1)) goto L17;
        startActivity(new Intent("android.intent.action.VIEW", ContactsContract.Contacts.getLookupUri(r2, r4)));
        finish();
        return;
    L8:
        if (r8.moveToFirst() == false) goto L11;
        r2 = r8.getLong(0);     // Catch: Throwable -> L24
        r4 = r8.getString(1);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r8.close();
        throw th;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r5) {
        if (r5 != 1) goto L5;
        Intent r6 = new Intent("android.intent.action.INSERT_OR_EDIT");
        r6.putExtras(this.mCreateExtras);
        r6.setType("vnd.android.cursor.item/raw_contact");
        return new AlertDialog.Builder(this, 3).setTitle(R.string.common_add_contact).setMessage(getResources().getString(R.string.add_contact_dlg_message_fmt, new Object[]{this.mCreateDescrip})).setPositiveButton(android.R.string.ok, new IntentClickListener(this, r6)).setNegativeButton(android.R.string.cancel, new IntentClickListener(this, null)).setOnCancelListener(new AnonymousClass1(this)).create();
    L5:
        return super.onCreateDialog(r5);
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_activities_ShowOrCreateActivity_com_obric_privacyhook_PrivacyHook_onCreate(ShowOrCreateActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ShowOrCreateActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_activities_ShowOrCreateActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_activities_ShowOrCreateActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ShowOrCreateActivity r1) {
        com_android_contacts_activities_ShowOrCreateActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_activities_ShowOrCreateActivity_com_obric_privacyhook_PrivacyHook_onStop(ShowOrCreateActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        ShowOrCreateActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_activities_ShowOrCreateActivity__onStop$___twin___();
    }
}
