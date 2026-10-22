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
import androidx.core.widget.NestedScrollView;
import com.stepos.alphame.R;
import e.EnumC0546d;

/* renamed from: stepos.support.v7.app.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class DialogInterfaceC0865j extends A implements DialogInterface {
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_NORMAL = 0;
    public static final int COLOR_POLESTAR = 3;
    public static final int COLOR_RED = 2;
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    public static final int STEP_OS_DIALOG_CONTROLLER = 1;
    public static final int SUPPORT_DIALOG_CONTROLLER = 0;
    final AbstractC0862g mAlert;

    public DialogInterfaceC0865j(Context context, int i4) {
        int iResolveDialogTheme = resolveDialogTheme(context, i4);
        if (iResolveDialogTheme == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            iResolveDialogTheme = typedValue.resourceId;
        }
        super(context, iResolveDialogTheme);
        getDelegate().e(null);
        getDelegate().a();
        this.mAlert = create(getContext(), this, getWindow());
    }

    public static final AbstractC0862g create(Context context, A a4, Window window) {
        return new Z(context, a4, window);
    }

    public static int resolveDialogTheme(@NonNull Context context, @StyleRes int i4) {
        if (((i4 >>> 24) & 255) >= 1) {
            return i4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public AbstractC0862g getAlertController() {
        return this.mAlert;
    }

    public Button getButton(int i4) {
        return this.mAlert.a(i4);
    }

    public ListView getListView() {
        return ((Z) this.mAlert).f14413j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:295:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0228  */
    @Override // stepos.support.v7.app.A, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r23) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 2007
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.DialogInterfaceC0865j.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((Z) this.mAlert).f14376D;
        if (nestedScrollView == null || !nestedScrollView.e(keyEvent)) {
            return super.onKeyDown(i4, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((Z) this.mAlert).f14376D;
        if (nestedScrollView == null || !nestedScrollView.e(keyEvent)) {
            return super.onKeyUp(i4, keyEvent);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStart() {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.DialogInterfaceC0865j.onStart():void");
    }

    public void setAutoShowSoftInput(boolean z4) {
        ((Z) this.mAlert).f14404e0 = z4;
    }

    public void setButton(int i4, CharSequence charSequence, Message message) {
        this.mAlert.b(i4, charSequence, null, message, null);
    }

    @RestrictTo({EnumC0546d.f12493b})
    public void setButtonPanelLayoutHint(int i4) {
        ((Z) this.mAlert).T = i4;
    }

    public void setButtonTextColor(int i4, int i5) {
        Button button;
        Z z4 = (Z) this.mAlert;
        A a4 = z4.f14403e;
        if (!(a4 instanceof DialogInterfaceC0865j) || (button = ((DialogInterfaceC0865j) a4).getButton(i4)) == null) {
            return;
        }
        button.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}, new int[0]}, new int[]{z4.f14401d.getResources().getColor(i5), Color.argb(77, 0, 0, 0)}));
    }

    public void setCustomPaddingRule(int i4, int i5, int i6, int i7) {
        Z z4 = (Z) this.mAlert;
        z4.f14395X = true;
        z4.f14396Y = i4;
        z4.f14397Z = i5;
        z4.f14398a0 = i6;
        z4.f14399b0 = i7;
    }

    public void setCustomTitle(View view) {
        ((Z) this.mAlert).f14383K = view;
    }

    public void setHighLightButton(int i4, int i5) {
        Z z4 = (Z) this.mAlert;
        z4.f14406f0 = i4;
        z4.f14408g0 = i5;
    }

    public void setIcon(int i4) {
        this.mAlert.c(i4);
    }

    public void setIconAttribute(int i4) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i4, typedValue, true);
        this.mAlert.c(typedValue.resourceId);
    }

    public void setMaxHeight(int i4) {
        Z z4 = (Z) this.mAlert;
        z4.f14400c0 = (int) (i4 * z4.f14418l0);
    }

    public void setMessage(CharSequence charSequence) {
        Z z4 = (Z) this.mAlert;
        z4.f14411i = charSequence;
        TextView textView = z4.f14381I;
        if (textView != null) {
            textView.setText(charSequence);
            z4.f14381I.setVisibility(0);
        }
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        Z z4 = (Z) this.mAlert;
        z4.f14382J = movementMethod;
        TextView textView = z4.f14381I;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    @Override // stepos.support.v7.app.A, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        Z z4 = (Z) this.mAlert;
        z4.f14409h = charSequence;
        TextView textView = z4.f14380H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(View view) {
        Z z4 = (Z) this.mAlert;
        z4.f14415k = view;
        z4.f14417l = 0;
        z4.f14424q = false;
    }

    public void setButton(int i4, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.b(i4, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.d(drawable);
    }

    public void setButton(int i4, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.b(i4, charSequence, onClickListener, null, drawable);
    }

    public void setView(View view, int i4, int i5, int i6, int i7) {
        Z z4 = (Z) this.mAlert;
        z4.f14415k = view;
        z4.f14417l = 0;
        z4.f14424q = true;
        z4.f14419m = i4;
        z4.f14421n = i5;
        z4.f14422o = i6;
        z4.f14423p = i7;
    }
}
