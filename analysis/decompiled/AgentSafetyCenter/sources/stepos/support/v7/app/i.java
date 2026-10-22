package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.method.MovementMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class i extends s implements DialogInterface {
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_NORMAL = 0;
    public static final int COLOR_POLESTAR = 3;
    public static final int COLOR_RED = 2;
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    public static final int STEP_OS_DIALOG_CONTROLLER = 1;
    public static final int SUPPORT_DIALOG_CONTROLLER = 0;
    final e mAlert;

    public i(Context context, int i) {
        int iResolveDialogTheme = resolveDialogTheme(context, i);
        if (iResolveDialogTheme == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            iResolveDialogTheme = typedValue.resourceId;
        }
        super(context, iResolveDialogTheme);
        getDelegate().f(null);
        getDelegate().a();
        this.mAlert = create(getContext(), this, getWindow());
    }

    public static final e create(Context context, s sVar, Window window) {
        int i;
        n0 n0Var = new n0();
        new h.e(1).f4782b = new WeakReference(sVar);
        new ArrayList();
        int[] iArr = oe.a.f9500b;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, 0);
        typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        n0Var.f12310a = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        typedArrayObtainStyledAttributes.getResourceId(6, 0);
        typedArrayObtainStyledAttributes.getResourceId(11, 0);
        n0Var.f12311b = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(7, 0);
        typedArrayObtainStyledAttributes.getResourceId(8, 0);
        typedArrayObtainStyledAttributes.getResourceId(9, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(14, 0);
        typedArrayObtainStyledAttributes.recycle();
        sVar.supportRequestWindowFeature(1);
        n0Var.f12375o = false;
        n0Var.C = 0;
        n0Var.K = -1;
        n0Var.Q = 0;
        n0Var.f12357a0 = true;
        n0Var.f12360c0 = 1;
        n0Var.f0 = true;
        h.b bVar = new h.b(4);
        bVar.f4749f = n0Var;
        VarHandle.storeStoreFence();
        n0Var.f12369i0 = bVar;
        n0Var.f12359c = context;
        n0Var.f12361d = sVar;
        n0Var.f12363e = window;
        h.e eVar = new h.e(2);
        eVar.f4782b = new WeakReference(sVar);
        n0Var.R = eVar;
        n0Var.f12366g0 = new r9.l();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, 0);
        n0Var.L = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        n0Var.M = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
        n0Var.N = typedArrayObtainStyledAttributes2.getResourceId(5, 0);
        typedArrayObtainStyledAttributes2.getResourceId(6, 0);
        typedArrayObtainStyledAttributes2.getResourceId(11, 0);
        n0Var.O = typedArrayObtainStyledAttributes2.getResourceId(4, 0);
        typedArrayObtainStyledAttributes2.getResourceId(7, 0);
        typedArrayObtainStyledAttributes2.getResourceId(8, 0);
        typedArrayObtainStyledAttributes2.getResourceId(9, 0);
        n0Var.P = true;
        n0Var.f12364f = typedArrayObtainStyledAttributes2.getDimensionPixelSize(14, n0.k(48.0f, context));
        typedArrayObtainStyledAttributes2.getResourceId(3, 0);
        n0Var.S = typedArrayObtainStyledAttributes2.getBoolean(12, false);
        n0Var.U = typedArrayObtainStyledAttributes2.getBoolean(15, false);
        n0Var.V = typedArrayObtainStyledAttributes2.getDimensionPixelSize(16, 0);
        n0Var.W = typedArrayObtainStyledAttributes2.getDimensionPixelSize(17, 0);
        n0Var.X = typedArrayObtainStyledAttributes2.getDimensionPixelSize(18, 0);
        n0Var.Y = typedArrayObtainStyledAttributes2.getDimensionPixelSize(19, 0);
        typedArrayObtainStyledAttributes2.recycle();
        sVar.supportRequestWindowFeature(1);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            i = context.getResources().getDisplayMetrics().widthPixels;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            i = displayMetrics.widthPixels;
        }
        n0Var.T = Math.min(i, n0Var.m()) - (context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_margin_bottom_to_screen) * 2);
        n0Var.f12368h0 = 1.0f;
        n0Var.f12362d0 = context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_divider_height);
        VarHandle.storeStoreFence();
        return n0Var;
    }

    public static int resolveDialogTheme(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public e getAlertController() {
        return this.mAlert;
    }

    public Button getButton(int i) {
        n0 n0Var = (n0) this.mAlert;
        if (i == -3) {
            return n0Var.f12384x;
        }
        if (i == -2) {
            return n0Var.f12380t;
        }
        if (i == -1) {
            return n0Var.f12376p;
        }
        n0Var.getClass();
        return null;
    }

    public ListView getListView() {
        return ((n0) this.mAlert).i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05e8  */
    @Override // stepos.support.v7.app.s, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r23) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 2073
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.i.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((n0) this.mAlert).B;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((n0) this.mAlert).B;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.i.onStart():void");
    }

    public void setAutoShowSoftInput(boolean z10) {
        ((n0) this.mAlert).f12357a0 = z10;
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.a(i, charSequence, null, message, null);
    }

    public void setButtonPanelLayoutHint(int i) {
        ((n0) this.mAlert).Q = i;
    }

    public void setButtonTextColor(int i, int i3) {
        Button button;
        n0 n0Var = (n0) this.mAlert;
        s sVar = n0Var.f12361d;
        if (!(sVar instanceof i) || (button = ((i) sVar).getButton(i)) == null) {
            return;
        }
        button.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}, new int[0]}, new int[]{n0Var.f12359c.getResources().getColor(i3), Color.argb(77, 0, 0, 0)}));
    }

    public void setCustomPaddingRule(int i, int i3, int i10, int i11) {
        n0 n0Var = (n0) this.mAlert;
        n0Var.U = true;
        n0Var.V = i;
        n0Var.W = i3;
        n0Var.X = i10;
        n0Var.Y = i11;
    }

    public void setCustomTitle(View view) {
        ((n0) this.mAlert).I = view;
    }

    public void setHighLightButton(int i, int i3) {
        n0 n0Var = (n0) this.mAlert;
        n0Var.f12358b0 = i;
        n0Var.f12360c0 = i3;
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
        n0 n0Var = (n0) this.mAlert;
        n0Var.Z = (int) (i * n0Var.f12368h0);
    }

    public void setMessage(CharSequence charSequence) {
        n0 n0Var = (n0) this.mAlert;
        n0Var.f12367h = charSequence;
        TextView textView = n0Var.G;
        if (textView != null) {
            textView.setText(charSequence);
            n0Var.G.setVisibility(0);
        }
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        n0 n0Var = (n0) this.mAlert;
        n0Var.H = movementMethod;
        TextView textView = n0Var.G;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    @Override // stepos.support.v7.app.s, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        n0 n0Var = (n0) this.mAlert;
        n0Var.f12365g = charSequence;
        TextView textView = n0Var.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(View view, int i, int i3, int i10, int i11) {
        n0 n0Var = (n0) this.mAlert;
        n0Var.f12370j = view;
        n0Var.f12375o = true;
        n0Var.f12371k = i;
        n0Var.f12372l = i3;
        n0Var.f12373m = i10;
        n0Var.f12374n = i11;
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.c(drawable);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.a(i, charSequence, onClickListener, null, null);
    }

    public void setButton(int i, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.a(i, charSequence, onClickListener, null, drawable);
    }

    public void setView(View view) {
        n0 n0Var = (n0) this.mAlert;
        n0Var.f12370j = view;
        n0Var.f12375o = false;
    }
}
