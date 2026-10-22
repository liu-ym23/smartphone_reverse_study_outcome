package com.stepos.ailauncher.chat.view;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.chat.view.R5;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a]\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a[\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013\u001ai\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a?\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0017H\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010)\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0003H\u0000¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroid/view/View;", LinkHeader.Parameters.Anchor, SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", "cornerRadiusDp", "gapDp", "", "focusable", "clippingEnabled", "followAnchor", "Lkotlin/Function0;", "LY8/t;", "onDismiss", "Landroid/widget/PopupWindow;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;Landroid/view/View;FFZZZLp9/a;)Landroid/widget/PopupWindow;", "rawX", "rawY", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/View;Landroid/view/View;FFFZZLp9/a;)Landroid/widget/PopupWindow;", "tokenAnchor", "Lcom/stepos/ailauncher/chat/view/U5;", "overshootHost", "", "popupX", "popupY", "Lcom/stepos/ailauncher/chat/view/E5;", "anchorFollow", "l", "(Landroid/view/View;Landroid/view/View;Lcom/stepos/ailauncher/chat/view/U5;FIIZZLcom/stepos/ailauncher/chat/view/E5;Lp9/a;)Landroid/widget/PopupWindow;", "basePopupX", "basePopupY", "baseAnchorRight", "baseAnchorBottom", "anchorRight", "anchorBottom", "Lcom/stepos/ailauncher/chat/view/V5;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(IIIIII)Lcom/stepos/ailauncher/chat/view/V5;", "contentHeightPx", "density", "f", "(IF)F", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class R5 {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/view/R5$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ E5 $anchorFollow;
        final /* synthetic */ Ref$ObjectRef<F5> $enterAnim;
        final /* synthetic */ Ref$ObjectRef<F5> $exitAnim;
        final /* synthetic */ Ref$ObjectRef<y7.E> $glassHandle;

        public a(E5 e52, Ref$ObjectRef<F5> ref$ObjectRef, Ref$ObjectRef<F5> ref$ObjectRef2, Ref$ObjectRef<y7.E> ref$ObjectRef3) {
            this.$anchorFollow = e52;
            this.$enterAnim = ref$ObjectRef;
            this.$exitAnim = ref$ObjectRef2;
            this.$glassHandle = ref$ObjectRef3;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            E5 e52 = this.$anchorFollow;
            if (e52 != null) {
                e52.b();
            }
            F5 f52 = this.$enterAnim.f34820a;
            if (f52 != null) {
                f52.a();
            }
            this.$enterAnim.f34820a = null;
            F5 f53 = this.$exitAnim.f34820a;
            if (f53 != null) {
                f53.a();
            }
            this.$exitAnim.f34820a = null;
            v10.setLayerType(0, null);
            C2851i7.INSTANCE.h(this.$glassHandle.f34820a);
            this.$glassHandle.f34820a = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/view/R5$b", "Landroid/widget/PopupWindow;", "LY8/t;", DidiCardProvider.ACTION_DISMISS, "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends PopupWindow {
        final /* synthetic */ View $content;
        final /* synthetic */ float $cornerRadiusDp;
        final /* synthetic */ Ref$ObjectRef<F5> $enterAnim;
        final /* synthetic */ Ref$ObjectRef<F5> $exitAnim;
        final /* synthetic */ Ref$BooleanRef $exitStarted;
        final /* synthetic */ Ref$ObjectRef<y7.E> $glassHandle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ViewGroup viewGroup, boolean z10, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<F5> ref$ObjectRef, Ref$ObjectRef<F5> ref$ObjectRef2, View view, float f10, Ref$ObjectRef<y7.E> ref$ObjectRef3) {
            super(viewGroup, -2, -2, z10);
            this.$exitStarted = ref$BooleanRef;
            this.$exitAnim = ref$ObjectRef;
            this.$enterAnim = ref$ObjectRef2;
            this.$content = view;
            this.$cornerRadiusDp = f10;
            this.$glassHandle = ref$ObjectRef3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final y7.E c(Ref$ObjectRef ref$ObjectRef) {
            return (y7.E) ref$ObjectRef.f34820a;
        }

        public static final Y8.t d(Ref$ObjectRef ref$ObjectRef, F5[] f5Arr, b bVar) {
            if (ref$ObjectRef.f34820a == f5Arr[0]) {
                ref$ObjectRef.f34820a = null;
            }
            if (bVar.isShowing()) {
                super.dismiss();
            }
            return Y8.t.f7040a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.PopupWindow
        public void dismiss() {
            if (!isShowing()) {
                super.dismiss();
                return;
            }
            Ref$BooleanRef ref$BooleanRef = this.$exitStarted;
            if (ref$BooleanRef.f34815a) {
                F5 f52 = this.$exitAnim.f34820a;
                if (f52 != null) {
                    f52.a();
                }
                this.$exitAnim.f34820a = null;
                super.dismiss();
                return;
            }
            ref$BooleanRef.f34815a = true;
            F5 f53 = this.$enterAnim.f34820a;
            if (f53 != null) {
                f53.a();
            }
            this.$enterAnim.f34820a = null;
            final F5[] f5Arr = new F5[1];
            L5 l52 = L5.INSTANCE;
            View view = this.$content;
            float f10 = this.$cornerRadiusDp;
            final Ref$ObjectRef<y7.E> ref$ObjectRef = this.$glassHandle;
            InterfaceC5063a<y7.E> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.S5
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return R5.b.c(ref$ObjectRef);
                }
            };
            final Ref$ObjectRef<F5> ref$ObjectRef2 = this.$exitAnim;
            f5Arr[0] = l52.k(view, f10, interfaceC5063a, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.T5
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return R5.b.d(ref$ObjectRef2, f5Arr, this);
                }
            });
            if (isShowing()) {
                this.$exitAnim.f34820a = f5Arr[0];
            }
        }
    }

    public static final float f(int i10, float f10) {
        if (i10 <= 0 || f10 <= 0.0f) {
            return 0.0f;
        }
        return (-i10) / f10;
    }

    public static final GlassDropdownPosition g(int i10, int i11, int i12, int i13, int i14, int i15) {
        return new GlassDropdownPosition(i10 + (i14 - i12), i11 + (i15 - i13));
    }

    public static final PopupWindow h(View anchor, View content, float f10, float f11, boolean z10, boolean z11, boolean z12, InterfaceC5063a<Y8.t> interfaceC5063a) {
        int i10;
        View view;
        boolean z13;
        InterfaceC5063a<Y8.t> interfaceC5063a2;
        E5 e52;
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(content, "content");
        content.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int i11 = (int) (anchor.getResources().getDisplayMetrics().density * f11);
        L5 l52 = L5.INSTANCE;
        l52.h(content, anchor.getHeight(), i11);
        U5 u5V = l52.v(content);
        int[] iArr = new int[2];
        anchor.getLocationInWindow(iArr);
        int width = ((iArr[0] + anchor.getWidth()) - content.getMeasuredWidth()) - u5V.getPadLeft();
        int height = ((iArr[1] + anchor.getHeight()) + i11) - u5V.getPadTop();
        if (z12) {
            int width2 = iArr[0] + anchor.getWidth();
            int height2 = iArr[1] + anchor.getHeight();
            i10 = height;
            E5 e53 = new E5(anchor, width, i10, width2, height2);
            view = content;
            z13 = z10;
            interfaceC5063a2 = interfaceC5063a;
            e52 = e53;
            width = width;
        } else {
            i10 = height;
            view = content;
            z13 = z10;
            interfaceC5063a2 = interfaceC5063a;
            e52 = null;
        }
        return l(anchor, view, u5V, f10, width, i10, z13, z11, e52, interfaceC5063a2);
    }

    public static /* synthetic */ PopupWindow i(View view, View view2, float f10, float f11, boolean z10, boolean z11, boolean z12, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z10 = true;
        }
        if ((i10 & 32) != 0) {
            z11 = true;
        }
        if ((i10 & 64) != 0) {
            z12 = false;
        }
        if ((i10 & 128) != 0) {
            interfaceC5063a = null;
        }
        return h(view, view2, f10, f11, z10, z11, z12, interfaceC5063a);
    }

    public static final PopupWindow j(View anchor, View content, float f10, float f11, float f12, boolean z10, boolean z11, InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(content, "content");
        content.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        L5 l52 = L5.INSTANCE;
        l52.i(content);
        U5 u5V = l52.v(content);
        return l(anchor, content, u5V, f10, ((int) f11) - u5V.getPadLeft(), ((int) f12) - u5V.getPadTop(), z10, z11, null, interfaceC5063a);
    }

    public static /* synthetic */ PopupWindow k(View view, View view2, float f10, float f11, float f12, boolean z10, boolean z11, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            z10 = true;
        }
        if ((i10 & 64) != 0) {
            z11 = true;
        }
        if ((i10 & 128) != 0) {
            interfaceC5063a = null;
        }
        return j(view, view2, f10, f11, f12, z10, z11, interfaceC5063a);
    }

    public static final PopupWindow l(View view, final View view2, U5 u52, final float f10, int i10, int i11, boolean z10, boolean z11, final E5 e52, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ViewGroup root = u52.getRoot();
        com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
        final String strC = iVar.c("glass_dropdown");
        final b bVar = new b(root, z10, ref$BooleanRef, ref$ObjectRef3, ref$ObjectRef2, view2, f10, ref$ObjectRef);
        bVar.setOutsideTouchable(true);
        bVar.setAnimationStyle(0);
        bVar.setBackgroundDrawable(new ColorDrawable(0));
        bVar.setClippingEnabled(z11);
        bVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.stepos.ailauncher.chat.view.M5
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                R5.m(strC, e52, ref$ObjectRef2, ref$ObjectRef3, view2, ref$ObjectRef, interfaceC5063a);
            }
        });
        view2.addOnAttachStateChangeListener(new a(e52, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef));
        view2.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.N5
            @Override // java.lang.Runnable
            public final void run() {
                R5.n(bVar, ref$BooleanRef, ref$ObjectRef, view2, f10, ref$ObjectRef2);
            }
        });
        bVar.showAtLocation(view, 0, i10, i11);
        if (bVar.isShowing()) {
            if (e52 != null) {
                e52.a(bVar);
            }
            PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
            View rootView = view.getRootView();
            kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
            iVar.e(strC, panelHomePolicy, rootView, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.O5
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(R5.p(bVar));
                }
            }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.P5
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return R5.q(bVar);
                }
            }, new com.stepos.ailauncher.chat.panelui.y(bVar));
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(String str, E5 e52, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, View view, Ref$ObjectRef ref$ObjectRef3, InterfaceC5063a interfaceC5063a) {
        com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
        if (e52 != null) {
            e52.b();
        }
        F5 f52 = (F5) ref$ObjectRef.f34820a;
        if (f52 != null) {
            f52.a();
        }
        ref$ObjectRef.f34820a = null;
        ref$ObjectRef2.f34820a = null;
        view.setLayerType(0, null);
        C2851i7.INSTANCE.h((y7.E) ref$ObjectRef3.f34820a);
        ref$ObjectRef3.f34820a = null;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, com.stepos.ailauncher.chat.view.F5] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, y7.E] */
    public static final void n(b bVar, Ref$BooleanRef ref$BooleanRef, final Ref$ObjectRef ref$ObjectRef, View view, float f10, Ref$ObjectRef ref$ObjectRef2) {
        if (!bVar.isShowing() || ref$BooleanRef.f34815a) {
            return;
        }
        if (ref$ObjectRef.f34820a == 0) {
            ref$ObjectRef.f34820a = C2851i7.INSTANCE.c(view, true, Float.valueOf(f10), y7.o.INSTANCE.h());
        }
        ref$ObjectRef2.f34820a = L5.INSTANCE.j(view, f10, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.Q5
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return R5.o(ref$ObjectRef);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final y7.E o(Ref$ObjectRef ref$ObjectRef) {
        return (y7.E) ref$ObjectRef.f34820a;
    }

    public static final boolean p(b bVar) {
        return bVar.isShowing();
    }

    public static final Y8.t q(b bVar) {
        if (bVar.isShowing()) {
            bVar.dismiss();
        }
        return Y8.t.f7040a;
    }
}
