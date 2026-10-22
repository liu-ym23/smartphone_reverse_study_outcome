package com.stepos.agentframework.floatcard.ext;

import E4.FloatCardOptions;
import E4.FloatCardRequest;
import E4.q;
import Y8.t;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.R$color;
import com.stepos.agentframework.floatcard.R$dimen;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import io.ktor.http.LinkHeader;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a1\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/view/View;", LinkHeader.Parameters.Anchor, "LE4/k;", "request", "Lkotlin/Function1;", "LE4/d;", "LY8/t;", "onEvent", "Lcom/stepos/agentframework/floatcard/ext/c;", "e", "(Landroid/view/View;LE4/k;Lp9/l;)Lcom/stepos/agentframework/floatcard/ext/c;", "", "OVERLAY_CARD_PADDING_DP", "F", "floatcard_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i {
    private static final float OVERLAY_CARD_PADDING_DP = 16.0f;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/floatcard/ext/i$a", "LE4/q;", "LE4/d;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LE4/d;)V", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements q {
        final /* synthetic */ Ref$ObjectRef<c> $handle;
        final /* synthetic */ InterfaceC5074l<E4.d, t> $onEvent;

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC5074l<? super E4.d, t> interfaceC5074l, Ref$ObjectRef<c> ref$ObjectRef) {
            this.$onEvent = interfaceC5074l;
            this.$handle = ref$ObjectRef;
        }

        @Override // E4.q
        public void a(E4.d event) {
            p.i(event, "event");
            this.$onEvent.invoke(event);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, com.stepos.agentframework.floatcard.ext.c] */
    public static final c e(final View anchor, FloatCardRequest request, InterfaceC5074l<? super E4.d, t> onEvent) {
        p.i(anchor, "anchor");
        p.i(request, "request");
        p.i(onEvent, "onEvent");
        final Context context = anchor.getContext();
        p.f(context);
        final FloatCardContainerView floatCardContainerView = new FloatCardContainerView(context, null, 0, 6, null);
        floatCardContainerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        final PopupWindow popupWindow = new PopupWindow((View) floatCardContainerView, -1, -2, false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        a aVar = new a(onEvent, ref$ObjectRef);
        float f10 = context.getResources().getDisplayMetrics().density;
        int iC = androidx.core.content.a.c(context, R$color.float_card_bg);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.float_card_corner_radius);
        int i10 = (int) ((16.0f * f10) + 0.5f);
        com.stepos.agentframework.floatcard.view.p pVar = new com.stepos.agentframework.floatcard.view.p(context, FloatCardRequest.b(request, null, null, null, null, null, FloatCardOptions.b(request.getOptions(), false, false, false, false, true, 15, null), null, 95, null), aVar);
        pVar.setBackground(H4.a.INSTANCE.a(iC, dimensionPixelSize));
        View viewFindViewById = pVar.findViewById(R$id.float_card_root);
        if (viewFindViewById == null) {
            viewFindViewById = pVar;
        }
        viewFindViewById.setPadding(i10, i10, i10, i10);
        ref$ObjectRef.f34820a = new c(popupWindow, floatCardContainerView, pVar);
        FloatCardContainerView.q(floatCardContainerView, pVar, false, 2, null);
        int i11 = (int) ((20 * f10) + 0.5f);
        ViewGroup.LayoutParams layoutParams = pVar.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.leftMargin = i11;
            layoutParams2.rightMargin = i11;
            layoutParams2.bottomMargin = i11;
            pVar.setLayoutParams(layoutParams2);
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        pVar.setOnContentHeightSettled(new InterfaceC5063a() { // from class: com.stepos.agentframework.floatcard.ext.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return i.h(popupWindow, anchor, context, floatCardContainerView, ref$IntRef);
            }
        });
        anchor.post(new Runnable() { // from class: com.stepos.agentframework.floatcard.ext.f
            @Override // java.lang.Runnable
            public final void run() {
                i.i(popupWindow, anchor, floatCardContainerView, context, ref$IntRef);
            }
        });
        T t10 = ref$ObjectRef.f34820a;
        if (t10 != 0) {
            return (c) t10;
        }
        p.A("handle");
        return null;
    }

    public static final void f(final PopupWindow popupWindow, final View view, final Context context, final FloatCardContainerView floatCardContainerView, final Ref$IntRef ref$IntRef) {
        if (popupWindow.isShowing()) {
            View rootView = view.getRootView();
            Integer numValueOf = Integer.valueOf(rootView != null ? rootView.getWidth() : 0);
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            floatCardContainerView.measure(View.MeasureSpec.makeMeasureSpec(numValueOf != null ? numValueOf.intValue() : context.getResources().getDisplayMetrics().widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = floatCardContainerView.getMeasuredHeight();
            if (measuredHeight > 0) {
                ref$IntRef.f34818a = 0;
                popupWindow.update(-1, measuredHeight);
                return;
            }
            int i10 = ref$IntRef.f34818a;
            if (i10 < 8) {
                ref$IntRef.f34818a = i10 + 1;
                floatCardContainerView.post(new Runnable() { // from class: com.stepos.agentframework.floatcard.ext.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        i.g(popupWindow, view, context, floatCardContainerView, ref$IntRef);
                    }
                });
            }
        }
    }

    public static final void g(PopupWindow popupWindow, View view, Context context, FloatCardContainerView floatCardContainerView, Ref$IntRef ref$IntRef) {
        f(popupWindow, view, context, floatCardContainerView, ref$IntRef);
    }

    public static final t h(PopupWindow popupWindow, View view, Context context, FloatCardContainerView floatCardContainerView, Ref$IntRef ref$IntRef) {
        f(popupWindow, view, context, floatCardContainerView, ref$IntRef);
        return t.f7040a;
    }

    public static final void i(final PopupWindow popupWindow, final View view, final FloatCardContainerView floatCardContainerView, final Context context, final Ref$IntRef ref$IntRef) {
        try {
            Result.Companion companion = Result.INSTANCE;
            popupWindow.showAtLocation(view, 81, 0, 0);
            Result.b(Boolean.valueOf(floatCardContainerView.post(new Runnable() { // from class: com.stepos.agentframework.floatcard.ext.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.j(popupWindow, view, context, floatCardContainerView, ref$IntRef);
                }
            })));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    public static final void j(PopupWindow popupWindow, View view, Context context, FloatCardContainerView floatCardContainerView, Ref$IntRef ref$IntRef) {
        f(popupWindow, view, context, floatCardContainerView, ref$IntRef);
    }
}
