package com.stepos.ailauncher.chat.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JS\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/view/E7;", "", "<init>", "()V", "Landroid/view/ViewGroup;", Parameters.ROOT, "Landroid/view/View;", "btn", "", "sizeDp", "gapDp", "Lkotlin/Function0;", "anchorProvider", "secondaryAnchorProvider", "Lcom/stepos/ailauncher/chat/view/E7$a;", Const.INTENT_KEY_UMID, "(Landroid/view/ViewGroup;Landroid/view/View;FFLp9/a;Lp9/a;)Lcom/stepos/ailauncher/chat/view/E7$a;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;Landroid/view/View;FLp9/a;Lp9/a;)V", "v", UxipConstants.f30680s, "", "c", "(Landroid/view/View;F)I", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E7 {
    public static final E7 INSTANCE = new E7();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/view/E7$a;", "", "Landroid/view/ViewGroup;", Parameters.ROOT, "Landroid/view/View;", "btn", "originalParent", "", "originalIndex", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "listener", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/ViewGroup;ILandroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "Landroid/view/ViewGroup;", "Landroid/view/View;", "I", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final View btn;
        private final ViewTreeObserver.OnGlobalLayoutListener listener;
        private final int originalIndex;
        private final ViewGroup originalParent;
        private final ViewGroup root;

        public a(ViewGroup root, View btn, ViewGroup viewGroup, int i10, ViewTreeObserver.OnGlobalLayoutListener listener) {
            kotlin.jvm.internal.p.i(root, "root");
            kotlin.jvm.internal.p.i(btn, "btn");
            kotlin.jvm.internal.p.i(listener, "listener");
            this.root = root;
            this.btn = btn;
            this.originalParent = viewGroup;
            this.originalIndex = i10;
            this.listener = listener;
        }

        public final void a() {
            this.root.getViewTreeObserver().removeOnGlobalLayoutListener(this.listener);
            ViewParent parent = this.btn.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.btn);
            }
            ViewGroup viewGroup2 = this.originalParent;
            if (viewGroup2 != null) {
                viewGroup2.addView(this.btn, C5685n.n(this.originalIndex, 0, viewGroup2.getChildCount()));
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5063a {
        public static final b INSTANCE = new b();

        @Override // p9.InterfaceC5063a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke() {
            return null;
        }
    }

    public static /* synthetic */ a e(E7 e72, ViewGroup viewGroup, View view, float f10, float f11, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f10 = 30.0f;
        }
        float f12 = f10;
        if ((i10 & 8) != 0) {
            f11 = 9.0f;
        }
        float f13 = f11;
        if ((i10 & 32) != 0) {
            interfaceC5063a2 = b.INSTANCE;
        }
        return e72.d(viewGroup, view, f12, f13, interfaceC5063a, interfaceC5063a2);
    }

    public static final void f(ViewGroup viewGroup, View view, float f10, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        INSTANCE.h(viewGroup, view, f10, interfaceC5063a, interfaceC5063a2);
    }

    public static final void g(ViewGroup viewGroup, View view, float f10, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        INSTANCE.h(viewGroup, view, f10, interfaceC5063a, interfaceC5063a2);
    }

    public final int c(View v10, float value) {
        return (int) (value * v10.getResources().getDisplayMetrics().density);
    }

    public final a d(final ViewGroup root, final View btn, float sizeDp, final float gapDp, final InterfaceC5063a<? extends View> anchorProvider, final InterfaceC5063a<? extends View> secondaryAnchorProvider) {
        kotlin.jvm.internal.p.i(root, "root");
        kotlin.jvm.internal.p.i(btn, "btn");
        kotlin.jvm.internal.p.i(anchorProvider, "anchorProvider");
        kotlin.jvm.internal.p.i(secondaryAnchorProvider, "secondaryAnchorProvider");
        ViewParent parent = btn.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        int iIndexOfChild = viewGroup != null ? viewGroup.indexOfChild(btn) : -1;
        if (viewGroup != null) {
            viewGroup.removeView(btn);
        }
        int iC = c(root, sizeDp);
        root.addView(btn, new ViewGroup.MarginLayoutParams(iC, iC));
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.chat.view.C7
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                E7.f(root, btn, gapDp, anchorProvider, secondaryAnchorProvider);
            }
        };
        root.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        root.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.D7
            @Override // java.lang.Runnable
            public final void run() {
                E7.g(root, btn, gapDp, anchorProvider, secondaryAnchorProvider);
            }
        });
        return new a(root, btn, viewGroup, iIndexOfChild, onGlobalLayoutListener);
    }

    public final void h(View root, View btn, float gapDp, InterfaceC5063a<? extends View> anchorProvider, InterfaceC5063a<? extends View> secondaryAnchorProvider) {
        float fC;
        View viewInvoke = anchorProvider.invoke();
        if (viewInvoke == null || viewInvoke.getWidth() == 0 || btn.getWidth() == 0) {
            return;
        }
        int[] iArr = new int[2];
        root.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        viewInvoke.getLocationInWindow(iArr2);
        btn.setTranslationX(((iArr2[0] - iArr[0]) + viewInvoke.getWidth()) - btn.getWidth());
        View viewInvoke2 = secondaryAnchorProvider.invoke();
        if (viewInvoke2 == null || !viewInvoke2.isShown() || viewInvoke2.getHeight() <= 0) {
            fC = ((iArr2[1] - iArr[1]) - c(root, gapDp)) - btn.getHeight();
        } else {
            int[] iArr3 = new int[2];
            viewInvoke2.getLocationInWindow(iArr3);
            fC = ((iArr3[1] - iArr[1]) + viewInvoke2.getHeight()) - btn.getHeight();
        }
        btn.setTranslationY(fC);
    }
}
