package com.bytedanceos.common.core.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.core.account.SyncReloginDialog;
import com.bytedanceos.common.network.core.ImageLoader;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.StatusBarActivity;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import com.bytedanceos.common.utils.AppStoreCommonError;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public class PersonalAccountSettingsActivity extends StatusBarActivity implements View.OnClickListener, Observer, ImageLoader.ImageListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AccountDataCache f9741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m8.a f9742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f9743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f9744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public File f9745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public File f9746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Uri f9747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f9748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AlertDialog f9749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SyncReloginDialog f9750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AlertDialog f9751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Handler f9752l;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonalAccountSettingsActivity f9753a;

        public a(PersonalAccountSettingsActivity r10) {
            this.f9753a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            switch(r10.what) {
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                case 10: goto L5;
                default: goto L13;
            };
        L5:
            this.f9753a.x();
            int r11 = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.user_account_icon);
            com.bytedanceos.common.toolbox.e.R0(AccountDataCache.b().d(), r11, r11);
            String r12 = (String) r10.obj;
            ImageLoader.l(0.0f).h(r12, this.f9753a, r11, r11, true);
            this.f9753a.f9741a.q(r12);
            this.f9753a.f9742b.j();
            e0.e(R$string.modify_success);
            return;
        L6:
            this.f9753a.C();
            return;
        L7:
            this.f9753a.x();
            return;
        L8:
            PersonalAccountSettingsActivity r13 = this.f9753a;
            r13.B(r13.getString(((Integer) r10.obj).intValue()));
            return;
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonalAccountSettingsActivity f9754a;

        public b(PersonalAccountSettingsActivity r10) {
            this.f9754a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.dismiss();
        }
    }

    public class c implements SyncReloginDialog.AccountInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonalAccountSettingsActivity f9755a;

        public c(PersonalAccountSettingsActivity r10) {
            this.f9755a = r10;
        }

        @Override // com.bytedanceos.common.core.account.SyncReloginDialog.AccountInfoCallback
        public void addAccountInfo(n8.a r10) {
            if (r10 != null) goto L5;
            com.bytedanceos.common.toolbox.j.e("addAccountInfo " + r10);
            return;
        L5:
            AccountDataCache.b().v(r10.b());
            AccountDataCache.b().u(r10.d());
            AccountDataCache.b().r(true);
            BaseApplication.c().b().O();
        }

        @Override // com.bytedanceos.common.core.account.SyncReloginDialog.AccountInfoCallback
        public void logOutAccount(String r10) {
            com.bytedanceos.common.toolbox.j.e("logOutAccount " + r10);
            m8.a.i().e();
        }
    }

    public class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonalAccountSettingsActivity f9756a;

        public d(PersonalAccountSettingsActivity r10) {
            this.f9756a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.dismiss();
        }
    }

    public PersonalAccountSettingsActivity() {
        this.f9751k = null;
        this.f9752l = new a(this);
    }

    private void initView() {
    }

    public static String w(Context r10, Uri r11, String r12, String[] r13) {
        String[] r14 = {"_data"};
        Cursor r15 = null;
        Cursor r16 = r10.getContentResolver().query(r11, r14, r12, r13, null);     // Catch: Throwable -> L15
        if (r16 != null) goto L21;
    L12:
        if (r16 == null) goto L14;
        r16.close();
    L14:
        return null;
    L21:
    L10:
        th = th;
        r15 = r16;
    L16:
        if (r15 == null) goto L18;
        r15.close();
    L18:
        throw th;
    L6:
        if (r16.moveToFirst() == false) goto L12;
        String r17 = r16.getString(r16.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L10
        r16.close();
        return r17;
    L15:
        th = th;
        goto L16
    }

    public static boolean z(Uri r10) {
        return "com.android.providers.media.documents".equals(r10.getAuthority());
    }

    public void A() {
        if (this.f9750j != null) goto L5;
        SyncReloginDialog r10 = new SyncReloginDialog(this, AccountDataCache.b().c());
        this.f9750j = r10;
        r10.p(new c(this));
    L5:
        this.f9750j.show();
    }

    public void B(String r10) {
        com.bytedanceos.common.toolbox.j.a("showLoadingDialog() message=" + r10);
    }

    public void C() {
        if (com.bytedanceos.common.toolbox.e.A0(getApplicationContext()) == true) goto L14;
        AlertDialog r10 = this.f9749i;
        if (r10 == null) goto L10;
        if (r10.isShowing() == false) goto L10;
        return;
    L10:
        if (this.f9749i != null) goto L12;
        this.f9749i = new AlertDialog.Builder(new ContextThemeWrapper(this, R$style.AppStoreDialogTheme)).setMessage(R$string.no_network_retry).setTitle(R$string.no_network).setPositiveButton(R$string.done, new d(this)).create();
    L12:
        this.f9749i.show();
        return;
    }

    public void D(byte[] r10, String r11) {
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity
    public View initHeaderView() {
        OFloatingTitleBar r10 = (OFloatingTitleBar) findViewById(R$id.toolbar);
        com.bytedanceos.common.utils.u.e(r10, R$string.personal_account_title);
        com.bytedanceos.common.utils.u.a(r10, this);
        return r10;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r10, int r11, Intent r12) {
        if (r10 != 200) goto L5;
        this.f9744d.setText(this.f9741a.l());     // Catch: Exception -> L22
        this.f9742b.j();     // Catch: Exception -> L22
        return;
    L5:
        if (r10 != 300) goto L7;
        if (r11 != (-1)) goto L59;
        File r13 = this.f9745e;     // Catch: Exception -> L22
        if (r13 != null) goto L56;
        return;
    L56:
        if (r13.exists() == false) goto L70;
        startActivityForResult(v(Uri.fromFile(this.f9745e)), 500);     // Catch: Exception -> L22
        return;
    L70:
        return;
    L59:
        return;
    L7:
        if (r10 == 400) goto L47;
        if (r10 != 500) goto L74;
        if (r11 != (-1)) goto L45;
        if (r12 == null) goto L45;
        u();     // Catch: Exception -> L22
        Bitmap r14 = (Bitmap) r12.getParcelableExtra("data");     // Catch: Exception -> L22
        this.f9748h = r14;     // Catch: Exception -> L22
        if (r14 != null) goto L25;
        Uri r15 = r12.getData();     // Catch: Exception -> L22
        if (r15 == null) goto L25;
        if (z(r15) == false) goto L25;
        String[] r16 = DocumentsContract.getDocumentId(r15).split(":");     // Catch: Exception -> L22
        if (SlardarSettingsConsts.SETTING_IMAGE.equals(r16[0]) == false) goto L25;
        this.f9748h = com.bytedanceos.common.utils.f.e(this, w(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{r16[1]}));     // Catch: Exception -> L22
    L25:
        if (this.f9748h == null) goto L65;
    L30:
        Bitmap r17 = this.f9748h;     // Catch: Exception -> L22
        if (r17 != null) goto L34;
        return;
    L34:
        if (r17.getWidth() <= 512) goto L36;
    L37:
        this.f9748h = com.bytedanceos.common.utils.f.h(this.f9748h, 512.0d, 512.0d);     // Catch: Exception -> L22
    L38:
        byte[] r18 = com.bytedanceos.common.utils.f.a(this.f9748h);     // Catch: Exception -> L22
        if (r18 != null) goto L41;
        return;
    L41:
        if (r18.length == 0) goto L67;
        D(r18, com.bytedanceos.common.toolbox.k.g(r18));     // Catch: Exception -> L22
        return;
    L67:
        return;
    L36:
        if (this.f9748h.getHeight() <= 512) goto L38;
    L65:
        this.f9748h = BitmapFactory.decodeStream(getContentResolver().openInputStream(this.f9747g));     // Catch: Exception -> L22 FileNotFoundException -> L28
        t();     // Catch: Exception -> L22 FileNotFoundException -> L28
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L22
    L45:
        u();     // Catch: Exception -> L22
        return;
    L74:
        return;
    L47:
        if (r11 != (-1)) goto L51;
        if (r12 == null) goto L68;
        startActivityForResult(v(r12.getData()), 500);     // Catch: Exception -> L22
        return;
    L68:
        return;
    L51:
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        overridePendingTransition(R$anim.fake_anim, R$anim.slide_down_out);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.personal_account_setting);
        initView();
        y();
    }

    @Override // com.bytedanceos.common.ui.StatusBarActivity, com.bytedanceos.common.ui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f9742b.deleteObserver(this);
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError r10) {
        if (r10 == null) goto L5;
        com.bytedanceos.common.toolbox.j.a("PersonalAccountSettingsActivity: " + r10.getMessage());
        return;
    }

    @Override // com.bytedanceos.common.network.core.ImageLoader.ImageListener
    public void onResponse(ImageLoader.ImageContainer r10, boolean r11) {
        if (this.f9743c == null) goto L9;
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.d() == null) goto L11;
        Bitmap r12 = BitmapFactory.decodeResource(getResources(), R$drawable.mask_user_icon);
        Bitmap r13 = com.bytedanceos.common.toolbox.e.Q(com.bytedanceos.common.toolbox.e.y(r10.d()), r12);
        this.f9743c.setBackground(new BitmapDrawable(null, r13));
        return;
    L11:
        return;
    }

    public final void s(int r10) {
        if (this.f9751k != null) goto L5;
        this.f9751k = new AlertDialog.Builder(new ContextThemeWrapper(this, R$style.AppStoreDialogTheme)).setTitle(R$string.logout_failed_title).setMessage(r10).setPositiveButton(R$string.done, new b(this)).create();
    L5:
        this.f9751k.show();
    }

    public final void t() {
        File r10 = this.f9746f;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.exists() == false) goto L9;
        this.f9746f.delete();
        return;
    }

    public final void u() {
        File r10 = this.f9745e;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.exists() == false) goto L9;
        this.f9745e.delete();
        return;
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
        String r12 = "";
        if (isFinishing() == false) goto L48;
        return;
    L48:
        Bundle r13 = (Bundle) r11;     // Catch: Exception -> L15
        r12 = r13.getString("key", "");     // Catch: Exception -> L15
        if ("account_info".equals(r12) == false) goto L9;
        return;
    L9:
        AppStoreCommonError r14 = (AppStoreCommonError) r13.getSerializable("error");     // Catch: Exception -> L15
        if (r14 != null) goto L19;
        finish();     // Catch: Exception -> L13
        overridePendingTransition(R$anim.fake_anim, R$anim.slide_down_out);     // Catch: Exception -> L13
        return;
    L13:
        Exception e10 = e;
    L17:
        e10.printStackTrace();
    L19:
        if (TextUtils.equals("logout", r12) == false) goto L38;
        if (r14 == null) goto L38;
        int r15 = r14.getErrorCode();
        if (r15 != (-5)) goto L24;
        s(R$string.logout_failed_description);
        return;
    L24:
        if (r15 == 1000004) goto L35;
        if (r15 == 1601) goto L35;
        if (r15 == 1106) goto L35;
        if (r15 == 1602) goto L35;
        if (com.bytedanceos.common.utils.k.a(r15) == false) goto L33;
        int r16 = com.bytedanceos.common.toolbox.l.f10067a.get(r15);
    L34:
        s(r16);
        return;
    L33:
        r16 = com.bytedanceos.common.toolbox.l.f10067a.get(0);
    L35:
        this.f9742b.e();
        return;
    L38:
        if (TextUtils.equals("account", r12) == false) goto L52;
        if (r14 == null) goto L53;
        int r17 = r14.getErrorCode();
        if (r17 == 1000004) goto L44;
        if (r17 == 1601) goto L44;
        if (r17 == 1602) goto L44;
        return;
    L44:
        A();
        return;
    L53:
        return;
    L52:
        return;
    L15:
        e = move-exception;
        e10 = e;
        r14 = null;
        goto L17
    }

    public Intent v(Uri r10) {
        Intent r11 = new Intent("com.android.camera.action.CROP");
        r11.setDataAndType(r10, "image/*");
        r11.putExtra("crop", "true");
        r11.putExtra("aspectX", 1);
        r11.putExtra("aspectY", 1);
        r11.putExtra("outputX", SearchChipsView.BROWN);
        r11.putExtra("outputY", SearchChipsView.BROWN);
        r11.putExtra("scaleUpIfNeeded", true);
        r11.putExtra("return-data", true);
        r11.putExtra("noFaceDetection", true);
        this.f9746f = new File(Environment.getExternalStorageDirectory(), "reader_cropped.jpg");
        Uri r12 = Uri.parse("file:///" + this.f9746f);
        this.f9747g = r12;
        r11.putExtra("output", r12);
        r11.setPackage("com.android.gallery3d");
        return r11;
    }

    public void x() {
        com.bytedanceos.common.toolbox.j.a("hideLoadingDialog()");
    }

    public final void y() {
        StrictMode.VmPolicy.Builder r10 = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(r10.build());
        r10.detectFileUriExposure();
    }
}
