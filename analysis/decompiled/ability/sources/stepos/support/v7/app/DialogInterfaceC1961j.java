package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.NestedScrollView;

/* renamed from: stepos.support.v7.app.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class DialogInterfaceC1961j extends AbstractDialogC1976z implements DialogInterface {
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_NORMAL = 0;
    public static final int COLOR_POLESTAR = 3;
    public static final int COLOR_RED = 2;
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    public static final int STEP_OS_DIALOG_CONTROLLER = 1;
    public static final int SUPPORT_DIALOG_CONTROLLER = 0;
    final AbstractC1958g mAlert;

    public DialogInterfaceC1961j(Context context, int i) {
        int iResolveDialogTheme = resolveDialogTheme(context, i);
        if (iResolveDialogTheme == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            iResolveDialogTheme = typedValue.resourceId;
        }
        super(context, iResolveDialogTheme);
        getDelegate().c(null);
        getDelegate().a();
        this.mAlert = create(getContext(), this, getWindow());
    }

    public static final AbstractC1958g create(Context context, AbstractDialogC1976z abstractDialogC1976z, Window window) {
        return new Z(context, abstractDialogC1976z, window);
    }

    public static int resolveDialogTheme(@NonNull Context context, @StyleRes int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public AbstractC1958g getAlertController() {
        return this.mAlert;
    }

    public Button getButton(int i) {
        Z z10 = (Z) this.mAlert;
        if (i == -3) {
            return z10.f6288x;
        }
        if (i == -2) {
            return z10.f6285t;
        }
        if (i == -1) {
            return z10.p;
        }
        z10.getClass();
        return null;
    }

    public ListView getListView() {
        return ((Z) this.mAlert).i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x064f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0671 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x06e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0700  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0705 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0715  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x07a6  */
    @Override // stepos.support.v7.app.AbstractDialogC1976z, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.DialogInterfaceC1961j.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((Z) this.mAlert).f6249B;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((Z) this.mAlert).f6249B;
        if (nestedScrollView == null || !nestedScrollView.executeKeyEvent(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d9  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStart() {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.DialogInterfaceC1961j.onStart():void");
    }

    public void setAutoShowSoftInput(boolean z10) {
        ((Z) this.mAlert).f6273a0 = z10;
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.a(i, charSequence, null, message, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setButtonPanelLayoutHint(int i) {
        ((Z) this.mAlert).f6263Q = i;
    }

    public void setButtonTextColor(int i, int i6) {
        Button button;
        Z z10 = (Z) this.mAlert;
        AbstractDialogC1976z abstractDialogC1976z = z10.d;
        if (!(abstractDialogC1976z instanceof DialogInterfaceC1961j) || (button = ((DialogInterfaceC1961j) abstractDialogC1976z).getButton(i)) == null) {
            return;
        }
        button.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}, new int[0]}, new int[]{z10.c.getResources().getColor(i6), Color.argb(77, 0, 0, 0)}));
    }

    public void setCustomPaddingRule(int i, int i6, int i10, int i11) {
        Z z10 = (Z) this.mAlert;
        z10.f6267U = true;
        z10.f6268V = i;
        z10.f6269W = i6;
        z10.f6270X = i10;
        z10.f6271Y = i11;
    }

    public void setCustomTitle(View view) {
        ((Z) this.mAlert).f6255I = view;
    }

    public void setHighLightButton(int i, int i6) {
        Z z10 = (Z) this.mAlert;
        z10.b0 = i;
        z10.f6274c0 = i6;
    }

    public void setIcon(int i) {
        this.mAlert.b(i);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.b(typedValue.resourceId);
    }

    public void setMaxHeight(int i) {
        Z z10 = (Z) this.mAlert;
        z10.f6272Z = (int) (i * z10.f6279h0);
    }

    public void setMessage(CharSequence charSequence) {
        Z z10 = (Z) this.mAlert;
        z10.h = charSequence;
        TextView textView = z10.f6253G;
        if (textView != null) {
            textView.setText(charSequence);
            z10.f6253G.setVisibility(0);
        }
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        Z z10 = (Z) this.mAlert;
        z10.f6254H = movementMethod;
        TextView textView = z10.f6253G;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    @Override // stepos.support.v7.app.AbstractDialogC1976z, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        Z z10 = (Z) this.mAlert;
        z10.g = charSequence;
        TextView textView = z10.f6252F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(View view) {
        Z z10 = (Z) this.mAlert;
        z10.f6281j = view;
        z10.o = false;
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.a(i, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.c(drawable);
    }

    public void setButton(int i, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.a(i, charSequence, onClickListener, null, drawable);
    }

    public void setView(View view, int i, int i6, int i10, int i11) {
        Z z10 = (Z) this.mAlert;
        z10.f6281j = view;
        z10.o = true;
        z10.k = i;
        z10.l = i6;
        z10.m = i10;
        z10.n = i11;
    }
}
