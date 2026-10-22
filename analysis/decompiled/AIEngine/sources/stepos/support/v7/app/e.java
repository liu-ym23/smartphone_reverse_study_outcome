package stepos.support.v7.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.method.MovementMethod;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import stepos.support.v7.app.StepOSAlertController;
import stepos.support.v7.app.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class e extends p implements DialogInterface {
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_NORMAL = 0;
    public static final int COLOR_POLESTAR = 3;
    public static final int COLOR_RED = 2;
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    public static final int STEP_OS_DIALOG_CONTROLLER = 1;
    public static final int SUPPORT_DIALOG_CONTROLLER = 0;
    final c mAlert;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final c.a f12101a;

        /* renamed from: b, reason: collision with root package name */
        public final int f12102b;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: stepos.support.v7.app.e$a$a, reason: collision with other inner class name */
        public interface InterfaceC0143a<T extends e> {
            T newDialog(Context context, int i10);
        }

        public a(Context context, int i10) {
            this.f12101a = new c.a(new ContextThemeWrapper(context, e.resolveDialogTheme(context, i10)));
            this.f12102b = i10;
        }

        public final <T extends e> T a(InterfaceC0143a<T> interfaceC0143a) {
            c.a aVar = this.f12101a;
            T t8 = (T) interfaceC0143a.newDialog(aVar.f12081a, this.f12102b);
            c cVar = t8.mAlert;
            LayoutInflater layoutInflater = aVar.f12082b;
            ContextThemeWrapper contextThemeWrapper = aVar.f12081a;
            if (cVar instanceof StepOSAlertController) {
                StepOSAlertController.b bVar = new StepOSAlertController.b();
                bVar.f12058a = aVar;
                StepOSAlertController stepOSAlertController = (StepOSAlertController) cVar;
                View view = aVar.f12085e;
                if (view != null) {
                    stepOSAlertController.J = view;
                } else {
                    CharSequence charSequence = aVar.f12084d;
                    if (charSequence != null) {
                        stepOSAlertController.h = charSequence;
                        TextView textView = stepOSAlertController.G;
                        if (textView != null) {
                            textView.setText(charSequence);
                        }
                    }
                    Drawable drawable = aVar.f12083c;
                    if (drawable != null) {
                        stepOSAlertController.c(drawable);
                    }
                }
                CharSequence charSequence2 = aVar.f12086f;
                if (charSequence2 != null) {
                    stepOSAlertController.a(-1, charSequence2, aVar.f12087g, null, null);
                }
                CharSequence charSequence3 = aVar.h;
                if (charSequence3 != null) {
                    stepOSAlertController.a(-2, charSequence3, aVar.f12088i, null, null);
                }
                if (aVar.f12092m != null) {
                    StepOSAlertController.RecycleListView recycleListView = (StepOSAlertController.RecycleListView) layoutInflater.inflate(stepOSAlertController.O, (ViewGroup) null);
                    int i10 = stepOSAlertController.P;
                    ListAdapter dVar = aVar.f12092m;
                    if (dVar != null) {
                        i10 = 0;
                    } else {
                        dVar = new StepOSAlertController.d(contextThemeWrapper, i10, R.id.text1, null);
                    }
                    stepOSAlertController.K = dVar;
                    stepOSAlertController.L = -1;
                    if (aVar.f12093n != null) {
                        recycleListView.setOnItemClickListener(new m0(bVar, stepOSAlertController));
                    }
                    int dimensionPixelOffset = contextThemeWrapper.getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.stepos_alert_dialog_listview_choice_padding);
                    if (i10 > 0 && (i10 == com.stepos.aiengine.R.layout.stepos_select_dialog_singlechoice || i10 == com.stepos.aiengine.R.layout.stepos_select_dialog_multichoice)) {
                        recycleListView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                        recycleListView.setSelector(R.color.transparent);
                    }
                    stepOSAlertController.f12041j = recycleListView;
                    if (aVar.h == null && aVar.f12086f == null) {
                        stepOSAlertController.a(-2, contextThemeWrapper.getText(com.stepos.aiengine.R.string.mc_cancel), new StepOSAlertController.b.a(), null, null);
                    }
                }
                View view2 = aVar.f12094o;
                if (view2 != null) {
                    stepOSAlertController.f12043k = view2;
                    stepOSAlertController.f12048p = false;
                }
                stepOSAlertController.f12029a0 = (int) (0 * stepOSAlertController.f12040i0);
                int i11 = aVar.f12095p;
                int i12 = aVar.f12096q;
                stepOSAlertController.c0 = i11;
                stepOSAlertController.f12031d0 = i12;
            } else {
                View view3 = aVar.f12085e;
                if (view3 != null) {
                    ((StepOSAlertController) cVar).J = view3;
                } else {
                    CharSequence charSequence4 = aVar.f12084d;
                    if (charSequence4 != null) {
                        StepOSAlertController stepOSAlertController2 = (StepOSAlertController) cVar;
                        stepOSAlertController2.h = charSequence4;
                        TextView textView2 = stepOSAlertController2.G;
                        if (textView2 != null) {
                            textView2.setText(charSequence4);
                        }
                    }
                    Drawable drawable2 = aVar.f12083c;
                    if (drawable2 != null) {
                        cVar.c(drawable2);
                    }
                }
                CharSequence charSequence5 = aVar.f12086f;
                if (charSequence5 != null) {
                    cVar.a(-1, charSequence5, aVar.f12087g, null, null);
                }
                CharSequence charSequence6 = aVar.h;
                if (charSequence6 != null) {
                    cVar.a(-2, charSequence6, aVar.f12088i, null, null);
                }
                if (aVar.f12092m != null) {
                    c.d dVar2 = (c.d) layoutInflater.inflate(cVar.f12079b, (ViewGroup) null);
                    int i13 = cVar.f12080c;
                    if (aVar.f12092m == null) {
                        new c.C0142c(contextThemeWrapper, i13, R.id.text1, null);
                    }
                    if (aVar.f12093n != null) {
                        dVar2.setOnItemClickListener(new b(aVar, cVar));
                    }
                }
                View view4 = aVar.f12094o;
                if (view4 != null) {
                    StepOSAlertController stepOSAlertController3 = (StepOSAlertController) cVar;
                    stepOSAlertController3.f12043k = view4;
                    stepOSAlertController3.f12048p = false;
                }
            }
            t8.setCancelable(aVar.f12089j);
            if (aVar.f12089j) {
                t8.setCanceledOnTouchOutside(true);
            }
            t8.setOnCancelListener(aVar.f12090k);
            t8.setOnDismissListener(null);
            stepos.support.v7.view.menu.d dVar3 = aVar.f12091l;
            if (dVar3 != null) {
                t8.setOnKeyListener(dVar3);
            }
            return t8;
        }
    }

    public e(Context context) {
        this(context, 0);
    }

    public static final c create(Context context, p pVar, Window window) {
        return new StepOSAlertController(context, pVar, window);
    }

    public static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(com.stepos.aiengine.R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public c getAlertController() {
        return this.mAlert;
    }

    public Button getButton(int i10) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        if (i10 == -3) {
            return stepOSAlertController.f12056y;
        }
        if (i10 == -2) {
            return stepOSAlertController.f12052u;
        }
        if (i10 == -1) {
            return stepOSAlertController.f12049q;
        }
        stepOSAlertController.getClass();
        return null;
    }

    public ListView getListView() {
        return ((StepOSAlertController) this.mAlert).f12041j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05c0  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05c6  */
    @Override // stepos.support.v7.app.p, android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r24) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1971
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.e.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((StepOSAlertController) this.mAlert).C;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = ((StepOSAlertController) this.mAlert).C;
        if (nestedScrollView == null || !nestedScrollView.d(keyEvent)) {
            return super.onKeyUp(i10, keyEvent);
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.app.e.onStart():void");
    }

    public void setAutoShowSoftInput(boolean z) {
        ((StepOSAlertController) this.mAlert).b0 = z;
    }

    public void setButton(int i10, CharSequence charSequence, Message message) {
        this.mAlert.a(i10, charSequence, null, message, null);
    }

    public void setButtonPanelLayoutHint(int i10) {
        ((StepOSAlertController) this.mAlert).R = i10;
    }

    public void setButtonTextColor(int i10, int i11) {
        Button button;
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        p pVar = stepOSAlertController.f12032e;
        if (!(pVar instanceof e) || (button = ((e) pVar).getButton(i10)) == null) {
            return;
        }
        button.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[0]}, new int[]{stepOSAlertController.f12030d.getResources().getColor(i11), Color.argb(77, 0, 0, 0)}));
    }

    public void setCustomPaddingRule(int i10, int i11, int i12, int i13) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.V = true;
        stepOSAlertController.W = i10;
        stepOSAlertController.X = i11;
        stepOSAlertController.Y = i12;
        stepOSAlertController.Z = i13;
    }

    public void setCustomTitle(View view) {
        ((StepOSAlertController) this.mAlert).J = view;
    }

    public void setHighLightButton(int i10, int i11) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.c0 = i10;
        stepOSAlertController.f12031d0 = i11;
    }

    public void setIcon(int i10) {
        this.mAlert.b(i10);
    }

    public void setIconAttribute(int i10) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i10, typedValue, true);
        this.mAlert.b(typedValue.resourceId);
    }

    public void setMaxHeight(int i10) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.f12029a0 = (int) (i10 * stepOSAlertController.f12040i0);
    }

    public void setMessage(CharSequence charSequence) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.f12039i = charSequence;
        TextView textView = stepOSAlertController.H;
        if (textView != null) {
            textView.setText(charSequence);
            stepOSAlertController.H.setVisibility(0);
        }
    }

    public void setMessageMovementMethod(MovementMethod movementMethod) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.I = movementMethod;
        TextView textView = stepOSAlertController.H;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    @Override // stepos.support.v7.app.p, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.h = charSequence;
        TextView textView = stepOSAlertController.G;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(View view) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.f12043k = view;
        stepOSAlertController.f12048p = false;
    }

    public e(Context context, int i10) {
        super(context, resolveDialogTheme(context, i10));
        this.mAlert = create(getContext(), this, getWindow());
    }

    public void setButton(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.a(i10, charSequence, onClickListener, null, null);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.c(drawable);
    }

    public void setButton(int i10, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.a(i10, charSequence, onClickListener, null, drawable);
    }

    public e(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    public void setView(View view, int i10, int i11, int i12, int i13) {
        StepOSAlertController stepOSAlertController = (StepOSAlertController) this.mAlert;
        stepOSAlertController.f12043k = view;
        stepOSAlertController.f12048p = true;
        stepOSAlertController.f12044l = i10;
        stepOSAlertController.f12045m = i11;
        stepOSAlertController.f12046n = i12;
        stepOSAlertController.f12047o = i13;
    }
}
