package com.migu.music.ipc.dialog;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.migu.music.ipc.dialog.MusicIpcCheckDialog;
import com.migu.music.ipc.sdk.R$id;
import com.migu.music.ipc.sdk.R$layout;
import com.migu.music.ipc.sdk.R$string;
import com.migu.music.ipc.sdk.R$style;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes2.dex */
public class MusicIpcCheckDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public TextView f21920a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f21921b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f21922c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f21923d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f21924e;

    /* renamed from: f, reason: collision with root package name */
    public Button f21925f;

    /* renamed from: g, reason: collision with root package name */
    public DialogType f21926g;

    public enum DialogType {
        INSTALL,
        LOGIN,
        OPEN_APP,
        UPDATE
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21927a;

        static {
            int[] iArr = new int[DialogType.values().length];
            f21927a = iArr;
            try {
                iArr[DialogType.INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21927a[DialogType.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21927a[DialogType.OPEN_APP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21927a[DialogType.LOGIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public MusicIpcCheckDialog(Context context) {
        super(context);
    }

    public static /* synthetic */ void a(MusicIpcCheckDialog musicIpcCheckDialog, View view) {
        DialogType dialogType = musicIpcCheckDialog.f21926g;
        if (dialogType == DialogType.INSTALL || dialogType == DialogType.UPDATE) {
            musicIpcCheckDialog.b();
        } else {
            musicIpcCheckDialog.c();
        }
        musicIpcCheckDialog.dismiss();
    }

    public final void b() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(P3.a.b()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            getContext().startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void c() {
        if (this.f21926g == DialogType.LOGIN) {
            g();
        } else {
            f();
        }
    }

    public final void d() {
        this.f21925f.setOnClickListener(new View.OnClickListener() { // from class: N3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MusicIpcCheckDialog.a(this.f4792a, view);
            }
        });
    }

    public final void e(View view) {
        this.f21920a = (TextView) view.findViewById(R$id.tv_title);
        this.f21921b = (TextView) view.findViewById(R$id.tv_message);
        this.f21922c = (ImageView) view.findViewById(R$id.iv_app_icon);
        this.f21923d = (TextView) view.findViewById(R$id.tv_app_name);
        this.f21924e = (TextView) view.findViewById(R$id.tv_developer);
        this.f21925f = (Button) view.findViewById(R$id.btn_control);
    }

    public final void f() {
        try {
            Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage("cmccwm.mobilemusic");
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                launchIntentForPackage.putExtra("com.migu.music.ipc.extra.AUTO_RETURN_TO_CALLER", true);
                getContext().startActivity(launchIntentForPackage);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void g() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("mgmusic://route-path-main?bPageType=B_MY_PAGE"));
            intent.addFlags(335544320);
            getContext().startActivity(intent);
        } catch (Exception e10) {
            e10.printStackTrace();
            f();
        }
    }

    public MusicIpcCheckDialog h(DialogType dialogType) {
        if (dialogType == null) {
            dialogType = DialogType.LOGIN;
        }
        this.f21926g = dialogType;
        return this;
    }

    public MusicIpcCheckDialog i(DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        return this;
    }

    public final void j() {
        Button button;
        Context context;
        int i10;
        TextView textView;
        Context context2;
        int i11;
        int i12 = a.f21927a[this.f21926g.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    textView = this.f21920a;
                    context2 = getContext();
                    i11 = R$string.dialog_login_hint;
                } else {
                    textView = this.f21920a;
                    context2 = getContext();
                    i11 = R$string.dialog_open_app_title;
                }
                textView.setText(context2.getString(i11));
                button = this.f21925f;
                context = getContext();
                i10 = R$string.dialog_open_app_button;
            } else {
                this.f21920a.setText(getContext().getString(R$string.dialog_update_app_title));
                button = this.f21925f;
                context = getContext();
                i10 = R$string.dialog_update_button;
            }
            button.setText(context.getString(i10));
            this.f21921b.setVisibility(4);
            this.f21924e.setVisibility(4);
        } else {
            this.f21920a.setText(getContext().getString(R$string.dialog_install_app_title));
            this.f21925f.setText(getContext().getString(R$string.dialog_download_button));
            this.f21921b.setVisibility(0);
            this.f21924e.setVisibility(0);
        }
        this.f21923d.setText(getContext().getString(R$string.dialog_app_name));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_music_ipc_not_install_or_open, (ViewGroup) null);
        setContentView(viewInflate);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.horizontalMargin = 0.0f;
            window.setWindowAnimations(R$style.DialogAnimation);
            window.setAttributes(attributes);
        }
        e(viewInflate);
        j();
        d();
    }
}
