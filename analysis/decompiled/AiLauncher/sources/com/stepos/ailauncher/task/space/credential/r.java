package com.stepos.ailauncher.task.space.credential;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.Y;
import androidx.core.view.a0;
import androidx.dynamicanimation.animation.e;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.ailauncher.sheet.h0;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0018\u001a\u00020\u0004*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "vendorName", "Lkotlin/Function0;", "LY8/t;", "onConfirm", "Lkotlin/Function1;", "onChoice", "Landroid/app/Dialog;", "k", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lp9/a;Lp9/l;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "Landroidx/dynamicanimation/animation/f;", "property", "", "finalValue", "Lcom/stepos/ailauncher/sheet/g0;", "spring", "onEnd", "Landroidx/dynamicanimation/animation/i;", "v", "(Landroid/view/View;Landroidx/dynamicanimation/animation/f;FLcom/stepos/ailauncher/sheet/g0;Lp9/a;)Landroidx/dynamicanimation/animation/i;", "Landroid/view/Window;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/Window;)V", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r {

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/space/credential/r$a", "Landroidx/dynamicanimation/animation/f;", "Landroid/view/View;", "v", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)F", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends androidx.dynamicanimation.animation.f<View> {
        public a() {
            super("scrimDim");
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            return (v10.getBackground() != null ? r0.getAlpha() : 255) / 255.0f;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(View v10, float value) {
            kotlin.jvm.internal.p.i(v10, "v");
            Drawable background = v10.getBackground();
            if (background != null) {
                background.setAlpha((int) (C5685n.m(value, 0.0f, 1.0f) * 255.0f));
            }
        }
    }

    public static final void j(Window window) {
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setLayout(-1, -1);
        window.addFlags(768);
        window.clearFlags(201326592);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(false);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        Y.b(window, false);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.setFitInsetsTypes(0);
        window.setAttributes(attributes);
        window.setWindowAnimations(0);
    }

    public static final Dialog k(final Fragment fragment, String vendorName, final InterfaceC5063a<Y8.t> onConfirm, final InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        kotlin.jvm.internal.p.i(fragment, "<this>");
        kotlin.jvm.internal.p.i(vendorName, "vendorName");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        Context context = fragment.getContext();
        if (context == null) {
            return null;
        }
        final Dialog dialog = new Dialog(context, R.style.Theme.Translucent.NoTitleBar);
        Window window = dialog.getWindow();
        if (window != null) {
            j(window);
        }
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.dialog_revoke_auth_confirm, (ViewGroup) null);
        dialog.setContentView(viewInflate);
        ((TextView) viewInflate.findViewById(R$id.tv_title)).setText(fragment.getString(R$string.third_party_auth_revoke_dialog_title, vendorName));
        ((TextView) viewInflate.findViewById(R$id.tv_message)).setText(fragment.getString(R$string.third_party_auth_revoke_dialog_message, vendorName));
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_cancel);
        textView.setText(fragment.getString(R$string.third_party_auth_revoke_dialog_cancel));
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btn_confirm);
        textView2.setText(fragment.getString(R$string.third_party_auth_revoke_dialog_confirm));
        final View viewFindViewById = viewInflate.findViewById(R$id.fl_overlay);
        final View viewFindViewById2 = viewInflate.findViewById(R$id.ll_card);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.o(view);
            }
        });
        final float f10 = fragment.getResources().getDisplayMetrics().widthPixels * 0.34013605f;
        final SheetSpring sheetSpring = new SheetSpring(322.27f, 0.8f);
        SheetSpring sheetSpringB = SheetSpring.Companion.b(SheetSpring.INSTANCE, 400.0f, 40.0f, 0.0f, 4, null);
        final SheetSpring sheetSpring2 = new SheetSpring(439.0f, 0.9f);
        final a aVar = new a();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        androidx.core.view.N.u0(viewFindViewById, new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.space.credential.j
            @Override // androidx.core.view.A
            public final a0 a(View view, a0 a0Var) {
                return r.p(view, a0Var);
            }
        });
        viewFindViewById2.setTranslationY(f10);
        viewFindViewById2.setAlpha(0.0f);
        Drawable background = viewFindViewById.getBackground();
        if (background != null) {
            background.setAlpha(0);
        }
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.q(ref$BooleanRef, viewFindViewById2, f10, sheetSpring, viewFindViewById, aVar, sheetSpring2, fragment, dialog, view);
            }
        });
        dialog.setCancelable(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.stepos.ailauncher.task.space.credential.l
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                return r.r(ref$BooleanRef, viewFindViewById2, f10, sheetSpring, viewFindViewById, aVar, sheetSpring2, fragment, dialog, dialogInterface, i10, keyEvent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.s(interfaceC5074l, onConfirm, ref$BooleanRef, viewFindViewById2, f10, sheetSpring, viewFindViewById, aVar, sheetSpring2, fragment, dialog, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.credential.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.u(interfaceC5074l, ref$BooleanRef, viewFindViewById2, f10, sheetSpring, viewFindViewById, aVar, sheetSpring2, fragment, dialog, view);
            }
        });
        dialog.show();
        kotlin.jvm.internal.p.f(viewFindViewById2);
        e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
        kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
        w(viewFindViewById2, TRANSLATION_Y, 0.0f, sheetSpring, null, 16, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        w(viewFindViewById2, ALPHA, 1.0f, sheetSpringB, null, 16, null);
        kotlin.jvm.internal.p.f(viewFindViewById);
        w(viewFindViewById, aVar, 1.0f, sheetSpringB, null, 16, null);
        return dialog;
    }

    public static final void l(Ref$BooleanRef ref$BooleanRef, View view, float f10, SheetSpring sheetSpring, View view2, a aVar, SheetSpring sheetSpring2, final Fragment fragment, final Dialog dialog, InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (ref$BooleanRef.f34815a) {
            return;
        }
        ref$BooleanRef.f34815a = true;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        kotlin.jvm.internal.p.f(view);
        e.s TRANSLATION_Y = androidx.dynamicanimation.animation.e.f13691o;
        kotlin.jvm.internal.p.h(TRANSLATION_Y, "TRANSLATION_Y");
        w(view, TRANSLATION_Y, f10, sheetSpring, null, 16, null);
        kotlin.jvm.internal.p.f(view2);
        w(view2, aVar, 0.0f, sheetSpring2, null, 16, null);
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        v(view, ALPHA, 0.0f, sheetSpring2, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.credential.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.m(fragment, dialog);
            }
        });
    }

    public static final Y8.t m(Fragment fragment, Dialog dialog) {
        try {
            Result.Companion companion = Result.INSTANCE;
            dialog.dismiss();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ Dialog n(Fragment fragment, String str, InterfaceC5063a interfaceC5063a, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = null;
        }
        return k(fragment, str, interfaceC5063a, interfaceC5074l);
    }

    public static final void o(View view) {
    }

    public static final a0 p(View v10, a0 insets) {
        kotlin.jvm.internal.p.i(v10, "v");
        kotlin.jvm.internal.p.i(insets, "insets");
        v10.setPadding(v10.getPaddingLeft(), v10.getPaddingTop(), v10.getPaddingRight(), insets.f(a0.o.g()).f41980d);
        return insets;
    }

    public static final void q(Ref$BooleanRef ref$BooleanRef, View view, float f10, SheetSpring sheetSpring, View view2, a aVar, SheetSpring sheetSpring2, Fragment fragment, Dialog dialog, View view3) {
        l(ref$BooleanRef, view, f10, sheetSpring, view2, aVar, sheetSpring2, fragment, dialog, null);
    }

    public static final boolean r(Ref$BooleanRef ref$BooleanRef, View view, float f10, SheetSpring sheetSpring, View view2, a aVar, SheetSpring sheetSpring2, Fragment fragment, Dialog dialog, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return false;
        }
        if (keyEvent.getAction() == 1) {
            l(ref$BooleanRef, view, f10, sheetSpring, view2, aVar, sheetSpring2, fragment, dialog, null);
        }
        return true;
    }

    public static final void s(InterfaceC5074l interfaceC5074l, final InterfaceC5063a interfaceC5063a, Ref$BooleanRef ref$BooleanRef, View view, float f10, SheetSpring sheetSpring, View view2, a aVar, SheetSpring sheetSpring2, Fragment fragment, Dialog dialog, View view3) {
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke("confirm");
        }
        l(ref$BooleanRef, view, f10, sheetSpring, view2, aVar, sheetSpring2, fragment, dialog, new InterfaceC5063a() { // from class: com.stepos.ailauncher.task.space.credential.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return r.t(interfaceC5063a);
            }
        });
    }

    public static final Y8.t t(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final void u(InterfaceC5074l interfaceC5074l, Ref$BooleanRef ref$BooleanRef, View view, float f10, SheetSpring sheetSpring, View view2, a aVar, SheetSpring sheetSpring2, Fragment fragment, Dialog dialog, View view3) {
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke("cancel");
        }
        l(ref$BooleanRef, view, f10, sheetSpring, view2, aVar, sheetSpring2, fragment, dialog, null);
    }

    public static final androidx.dynamicanimation.animation.i v(View view, androidx.dynamicanimation.animation.f<View> fVar, float f10, SheetSpring sheetSpring, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, fVar);
        iVar.B(h0.d(sheetSpring, f10));
        if (fVar != androidx.dynamicanimation.animation.e.f13691o) {
            iVar.o(0.00390625f);
        }
        if (interfaceC5063a != null) {
            iVar.b(new e.q() { // from class: com.stepos.ailauncher.task.space.credential.o
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f11, float f12) {
                    r.x(interfaceC5063a, eVar, z10, f11, f12);
                }
            });
        }
        iVar.t();
        return iVar;
    }

    public static /* synthetic */ androidx.dynamicanimation.animation.i w(View view, androidx.dynamicanimation.animation.f fVar, float f10, SheetSpring sheetSpring, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            interfaceC5063a = null;
        }
        return v(view, fVar, f10, sheetSpring, interfaceC5063a);
    }

    public static final void x(InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        interfaceC5063a.invoke();
    }
}
