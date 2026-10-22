package com.bytedanceos.common.core.account;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.i;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class SyncReloginDialog extends AlertDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f9586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ProgressDialog f9587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EditText f9588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Button f9589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f9590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f9591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f9592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageButton f9593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f9594i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9595j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public n8.a f9596k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AccountInfoCallback f9597l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Handler f9598m;

    public interface AccountInfoCallback {
        void addAccountInfo(n8.a r10);

        void logOutAccount(String r10);
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncReloginDialog f9599a;

        public a(SyncReloginDialog r10) {
            this.f9599a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            p8.b.g(SyncReloginDialog.a(this.f9599a), SyncReloginDialog.b(this.f9599a));
            String r11 = SyncReloginDialog.b(this.f9599a).getText().toString();
            Message r12 = SyncReloginDialog.d(this.f9599a).obtainMessage(4);
            r12.obj = r11;
            r12.sendToTarget();
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncReloginDialog f9600a;

        public b(SyncReloginDialog r10) {
            this.f9600a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            p8.b.g(SyncReloginDialog.a(this.f9600a), SyncReloginDialog.b(this.f9600a));
            SyncReloginDialog.e(this.f9600a).logOutAccount("LogOutAccount");
            i.a("SyncReloginDialog", "log out account");
        }
    }

    public class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncReloginDialog f9601a;

        public c(SyncReloginDialog r10) {
            this.f9601a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            SyncReloginDialog.f(this.f9601a);
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncReloginDialog f9602a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f9603a;

            public a(d r10) {
                this.f9603a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                p8.a.a(SyncReloginDialog.a(this.f9603a.f9602a), SyncReloginDialog.g(this.f9603a.f9602a).e());
                if (SyncReloginDialog.d(this.f9603a.f9602a) == null) goto L6;
                SyncReloginDialog.d(this.f9603a.f9602a).sendEmptyMessage(6);
                return;
            }
        }

        public d(SyncReloginDialog r10) {
            this.f9602a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            new Thread(new a(this)).start();
        }
    }

    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncReloginDialog f9604a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f9605a;

            public a(e r10) {
                this.f9605a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                p8.a.a(SyncReloginDialog.a(this.f9605a.f9604a), SyncReloginDialog.g(this.f9605a.f9604a).e());
                if (SyncReloginDialog.d(this.f9605a.f9604a) == null) goto L6;
                SyncReloginDialog.d(this.f9605a.f9604a).sendEmptyMessage(6);
                return;
            }
        }

        public e(SyncReloginDialog r10) {
            this.f9604a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            new Thread(new a(this)).start();
        }
    }

    public class f implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncReloginDialog f9606a;

        public f(SyncReloginDialog r10) {
            this.f9606a = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            SyncReloginDialog.f(this.f9606a);
        }
    }

    public class g extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SyncReloginDialog f9607a;

        public g(SyncReloginDialog r10) {
            this.f9607a = r10;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            switch(r10.what) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L6;
                default: goto L25;
            };
        L11:
            this.f9607a.t();
            return;
        L12:
            SyncReloginDialog.i(this.f9607a);
            SyncReloginDialog.j(this.f9607a);
            return;
        L13:
            SyncReloginDialog.k(this.f9607a, (String) r10.obj);
            return;
        L14:
            SyncReloginDialog.c(this.f9607a, (String) r10.obj, 0);
            return;
        L15:
            SyncReloginDialog.i(this.f9607a);
            return;
        L16:
            SyncReloginDialog r11 = this.f9607a;
            SyncReloginDialog.h(r11, SyncReloginDialog.a(r11).getString(((Integer) r10.obj).intValue()));
            return;
        L25:
            return;
        L6:
            if (r10.arg1 != 5) goto L8;
            return;
        L8:
            Object r12 = r10.obj;
            if (r12 == null) goto L18;
            SyncReloginDialog.c(this.f9607a, (String) r12, 0);
            return;
        }
    }

    public SyncReloginDialog(Context r10, String r11) {
        super(r10);
        this.f9595j = false;
        this.f9598m = new g(this);
        this.f9586a = r10;
        this.f9596k = new n8.a();
        if (u(r11) == false) goto L6;
        this.f9596k.g(r11);
    L6:
        if (p8.b.k(r11) == false) goto L8;
        this.f9596k.f(r11);
    L8:
        i.a("SyncReloginDialog", "SyncReloginDialog  accountName " + r11);
    }

    public static /* synthetic */ Context a(SyncReloginDialog r10) {
        return r10.f9586a;
    }

    public static /* synthetic */ EditText b(SyncReloginDialog r10) {
        return r10.f9588c;
    }

    public static /* synthetic */ void c(SyncReloginDialog r10, String r11, int r12) {
        r10.s(r11, r12);
    }

    public static /* synthetic */ Handler d(SyncReloginDialog r10) {
        return r10.f9598m;
    }

    public static /* synthetic */ AccountInfoCallback e(SyncReloginDialog r10) {
        return r10.f9597l;
    }

    public static /* synthetic */ void f(SyncReloginDialog r10) {
        r10.n();
    }

    public static /* synthetic */ n8.a g(SyncReloginDialog r10) {
        return r10.f9596k;
    }

    public static /* synthetic */ void h(SyncReloginDialog r10, String r11) {
        r10.q(r11);
    }

    public static /* synthetic */ void i(SyncReloginDialog r10) {
        r10.l();
    }

    public static /* synthetic */ void j(SyncReloginDialog r10) {
        r10.r();
    }

    public static /* synthetic */ void k(SyncReloginDialog r10, String r11) {
        r10.o(r11);
    }

    public final void l() {
        ProgressDialog r10 = this.f9587b;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isShowing() == false) goto L9;
        this.f9587b.dismiss();
        return;
    }

    public final void m() {
        View r10 = LayoutInflater.from(this.f9586a).inflate(R$layout.sync_relogin_input_dialog, null);
        setTitle(R$string.passwd_reset_title);
        setView(r10);
        setCancelable(false);
        Message r11 = new Message();
        setButton(-1, this.f9586a.getText(R$string.loginBtn), r11);
        setButton(-2, this.f9586a.getText(R$string.relogin_cancel), new b(this));
        getWindow().setSoftInputMode(16);
        this.f9590e = r10.findViewById(R$id.account_verification_code);
        EditText r12 = (EditText) r10.findViewById(R$id.verification_code);
        this.f9591f = r12;
        r12.addTextChangedListener(new c(this));
        this.f9592g = (ImageView) r10.findViewById(R$id.verification_code_icon);
        this.f9593h = (ImageButton) r10.findViewById(R$id.refresh);
        this.f9592g.setOnClickListener(new d(this));
        this.f9593h.setOnClickListener(new e(this));
        TextView r13 = (TextView) r10.findViewById(R$id.relogin_notice_for_dialog);
        this.f9588c.setTransformationMethod(PasswordTransformationMethod.getInstance());
        n8.a r14 = this.f9596k;
        if (r14 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r14.c()) == true) goto L8;
        r13.setText(this.f9586a.getString(R$string.passwd_reset_content, new Object[]{this.f9596k.c()}));
    L10:
        this.f9588c.addTextChangedListener(new f(this));
        return;
    L8:
        if (TextUtils.isEmpty(this.f9596k.a()) == true) goto L10;
        r13.setText(this.f9586a.getString(R$string.passwd_reset_content, new Object[]{this.f9596k.a()}));
        goto L10
    }

    public final void n() {
        String r10 = this.f9588c.getText().toString();
        String r11 = this.f9591f.getText().toString().trim();
        if (this.f9590e.getVisibility() != 0) goto L5;
        boolean r12 = true;
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L9;
    L14:
        this.f9589d.setEnabled(false);
        return;
    L9:
        if (p8.b.l(r10) == false) goto L14;
        if (r12 == true) goto L12;
    L13:
        this.f9589d.setEnabled(true);
        this.f9594i = r11;
        return;
    L12:
        if (TextUtils.isEmpty(r11) == true) goto L14;
    L5:
        r12 = false;
        goto L7
    }

    public final void o(String r10) {
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle r10) {
        i.a("SyncReloginDialog", "  onCreate ");
        m();
        super.onCreate(r10);
        Button r11 = getButton(-1);
        this.f9589d = r11;
        r11.setOnClickListener(new a(this));
        n();
    }

    public void p(AccountInfoCallback r10) {
        this.f9597l = r10;
    }

    public final void q(String r10) {
    }

    public final void r() {
    }

    public final void s(String r10, int r11) {
        Toast.makeText(this.f9586a, r10, r11).show();
    }

    public void t() {
        File r10 = p8.a.b(this.f9586a);
        if (r10 == null) goto L5;
        this.f9592g.setImageDrawable(new BitmapDrawable(this.f9586a.getResources(), r10.getAbsolutePath()));
    L7:
        if (this.f9590e.getVisibility() != 8) goto L9;
        this.f9595j = true;
        this.f9590e.setVisibility(0);
    L9:
        n();
        return;
    L5:
        this.f9592g.setImageDrawable(this.f9586a.getResources().getDrawable(R$drawable.relogin_code_fail));
        goto L7
    }

    public final boolean u(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        String r11 = r10.replace("+86", "");
        int r12 = r11.indexOf("+86");
        int r13 = r11.indexOf("86");
        if (r12 >= 0) goto L9;
        if (r13 >= 0) goto L9;
    L11:
        return Pattern.compile("^(1[1-9])\\d{9}$").matcher(r11.trim()).matches();
    L9:
        r11 = r11.substring(r13 + 2);
        goto L11
    }
}
