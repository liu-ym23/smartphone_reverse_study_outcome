package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    final AlertController mAlert;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlertController.a f202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f203b;

        public a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            this(r4, AlertDialog.resolveDialogTheme(r4, 0));
        }

        public a(Context r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f202a = new AlertController.a(new ContextThemeWrapper(r6, AlertDialog.resolveDialogTheme(r6, r5)));
            this.f203b = r5;
        }

        public Context getContext() {
            return this.f202a.f197a;
        }

        public a a(CharSequence r3) {
            this.f202a.f = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(View r2) {
            this.f202a.g = r2;
            return this;
        }

        public a b(CharSequence r3) {
            this.f202a.h = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(Drawable r2) {
            this.f202a.f200d = r2;
            return this;
        }

        public a a(CharSequence r3, DialogInterface.OnClickListener r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
            this.f202a.i = r5;
            this.f202a.k = r6;
            return this;
        }

        public a b(CharSequence r3, DialogInterface.OnClickListener r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
            this.f202a.l = r5;
            this.f202a.n = r6;
            return this;
        }

        public a a(boolean r2) {
            this.f202a.r = r2;
            return this;
        }

        public a a(DialogInterface.OnKeyListener r3) {
            this.f202a.u = (DialogInterface.OnKeyListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnKeyListener.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(ListAdapter r3, DialogInterface.OnClickListener r4) {
            ListAdapter r5 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.aiagent.plugin");
            DialogInterface.OnClickListener r6 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
            this.f202a.w = r5;
            this.f202a.x = r6;
            return this;
        }

        public a a(ListAdapter r3, int r4, DialogInterface.OnClickListener r5) {
            ListAdapter r6 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r3, ListAdapter.class, "com.obric.aiagent.plugin");
            DialogInterface.OnClickListener r7 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
            this.f202a.w = r6;
            this.f202a.x = r7;
            this.f202a.I = r4;
            this.f202a.H = true;
            return this;
        }

        public a b(View r2) {
            this.f202a.z = r2;
            this.f202a.y = 0;
            this.f202a.E = false;
            return this;
        }

        public AlertDialog a() {
            AlertDialog r0 = new AlertDialog(this.f202a.f197a, this.f203b);
            this.f202a.a(r0.mAlert);
            r0.setCancelable(this.f202a.r);
            if (this.f202a.r == false) goto L5;
            r0.setCanceledOnTouchOutside(true);
        L5:
            r0.setOnCancelListener(this.f202a.s);
            r0.setOnDismissListener(this.f202a.t);
            if (this.f202a.u == null) goto L8;
            r0.setOnKeyListener(this.f202a.u);
        L8:
            return r0;
        }

        public AlertDialog b() {
            AlertDialog r0 = a();
            r0.show();
            return r0;
        }
    }

    public AlertDialog(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), 0);
    }

    public AlertDialog(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r5, resolveDialogTheme(r5, r4));
        this.mAlert = new AlertController((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, getWindow());
    }

    public AlertDialog(Context r3, boolean r4, DialogInterface.OnCancelListener r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DialogInterface.OnCancelListener r7 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnCancelListener.class, "com.obric.aiagent.plugin");
        this(r6, 0);
        setCancelable(r4);
        setOnCancelListener(r7);
    }

    static int resolveDialogTheme(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (((r5 >>> 24) & 255) < 1) goto L5;
        return r5;
    L5:
        TypedValue r7 = new TypedValue();
        r6.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.alertDialogTheme, "attr", "alertDialogTheme"), r7, true);
        return r7.resourceId;
    }

    public Button getButton(int r1) {
        return this.mAlert.e(r1);
    }

    public ListView getListView() {
        return this.mAlert.b();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        super.setTitle(r4);
        this.mAlert.a(r4);
    }

    public void setCustomTitle(View r1) {
        this.mAlert.b(r1);
    }

    public void setMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.mAlert.b(r4);
    }

    public void setView(View r1) {
        this.mAlert.c(r1);
    }

    public void setView(View r7, int r8, int r9, int r10, int r11) {
        this.mAlert.a(r7, r8, r9, r10, r11);
    }

    void setButtonPanelLayoutHint(int r1) {
        this.mAlert.b(r1);
    }

    public void setButton(int r7, CharSequence r8, Message r9) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.aiagent.plugin");
        this.mAlert.a(r7, r2, null, r9, null);
    }

    public void setButton(int r9, CharSequence r10, DialogInterface.OnClickListener r11) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r11, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        this.mAlert.a(r9, r4, r5, null, null);
    }

    public void setButton(int r9, CharSequence r10, Drawable r11, DialogInterface.OnClickListener r12) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        DialogInterface.OnClickListener r5 = (DialogInterface.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin");
        this.mAlert.a(r9, r4, r5, null, r11);
    }

    public void setIcon(int r1) {
        this.mAlert.c(r1);
    }

    public void setIcon(Drawable r1) {
        this.mAlert.a(r1);
    }

    public void setIconAttribute(int r5) {
        TypedValue r0 = new TypedValue();
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().resolveAttribute(r5, r0, true);
        this.mAlert.c(r0.resourceId);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mAlert.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (this.mAlert.a(r2, r3) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r2, r3);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r2, KeyEvent r3) {
        if (this.mAlert.b(r2, r3) == false) goto L7;
        return true;
    L7:
        return super.onKeyUp(r2, r3);
    }
}
