package com.obric.structure.omvvm.core.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import com.obric.structure.omvvm.core.flux.FluxComponentLifecycle;
import com.obric.structure.omvvm.core.flux.IComponent;
import com.obric.structure.omvvm.core.flux.IComponentContext;
import com.obric.structure.omvvm.core.model.QModel;
import com.obric.structure.omvvm.core.presenter.QIMust;
import com.obric.structure.omvvm.core.ui.QUIManager;
import com.obric.structure.omvvm.core.ui.QUIModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\"\u0010\r\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00060\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\t\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/structure/omvvm/core/util/QUtils;", "", "()V", "VIEW_STUB", "", "dispatchFluxLifecycleEvent", "", "component", "Lcom/obric/structure/omvvm/core/flux/IComponent;", "context", "Lcom/obric/structure/omvvm/core/flux/IComponentContext;", "event", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "bindFunction", "Lkotlin/Function3;", "Lcom/obric/structure/omvvm/core/model/QModel;", "Landroid/view/View;", "Lcom/obric/structure/omvvm/core/ui/QUIManager;", "unbindFunction", "Lkotlin/Function0;", "inflateViewStub", "viewStub", "Landroid/view/ViewStub;", "parent", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "realReplace", "view", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "uiModule", "Lcom/obric/structure/omvvm/core/ui/QUIModule;", "replaceSelfWithView", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class QUtils {
    public static final QUtils INSTANCE = null;
    private static final int VIEW_STUB = -2;

    /* JADX INFO: compiled from: QUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FluxComponentLifecycle.Event.values().length];
            r0[FluxComponentLifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[FluxComponentLifecycle.Event.ON_BIND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[FluxComponentLifecycle.Event.ON_DISPLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[FluxComponentLifecycle.Event.ON_HIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[FluxComponentLifecycle.Event.ON_UNBIND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[FluxComponentLifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new QUtils();
    }

    private QUtils() {
    }

    public final void inflateViewStub(ViewStub r2, ViewGroup r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "viewStub");
        Intrinsics.checkNotNullParameter(r4, "context");
        View r1 = LayoutInflater.from(r4).inflate(r2.getLayoutResource(), r3, false);
        if (r2.getInflatedId() == (-1)) goto L5;
        r1.setId(r2.getInflatedId());
    L5:
        r2.setTag(-2, r1);
    }

    public final void replaceSelfWithView(QUIModule r6) {
        Intrinsics.checkNotNullParameter(r6, "uiModule");
        View r0 = r6.getView();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewStub");
        ViewStub r1 = (ViewStub) r0;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r2, "view.getLayoutParams()");
        View r3 = r6.getView();
        Intrinsics.checkNotNull(r3);
        if (r3.getParent() == null) goto L7;
        View r4 = r6.getView();
        Intrinsics.checkNotNull(r4);
        ViewParent r5 = r4.getParent();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        realReplace((ViewGroup) r5, r1, r2, r6);
        return;
    L7:
        if (r6.getParentId$omvvm_core_release() == (-1)) goto L9;
        QUIModule r7 = r6.getParent();
        Intrinsics.checkNotNull(r7);
        View r8 = r7.getView();
        Intrinsics.checkNotNull(r8);
        View r9 = r8.findViewById(r6.getParentId$omvvm_core_release());
        Intrinsics.checkNotNullExpressionValue(r9, "{\n            uiModule.p…odule.parentId)\n        }");
        ViewGroup r10 = (ViewGroup) r9;
    L10:
        realReplace(r10, r1, r2, r6);
        return;
    L9:
        QUIModule r11 = r6.getParent();
        Intrinsics.checkNotNull(r11);
        View r12 = r11.getView();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        r10 = (ViewGroup) r12;
        goto L10
    }

    private final void realReplace(ViewGroup r4, ViewStub r5, ViewGroup.LayoutParams r6, QUIModule r7) {
        ViewStub r3 = r5;
        int r0 = r4.indexOfChild(r3);
        r4.removeViewInLayout(r3);
        if (r6 == null) goto L5;
        Object r2 = r5.getTag(-2);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
        r4.addView((View) r2, r0, r6);
    L6:
        r7.setView((View) r5.getTag(-2));
        r5.setTag(-2, null);
        return;
    L5:
        Object r8 = r5.getTag(-2);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.View");
        r4.addView((View) r8, r0);
        goto L6
    }

    public final void dispatchFluxLifecycleEvent(IComponent r1, IComponentContext r2, FluxComponentLifecycle.Event r3, Function3<? super QModel, ? super View, ? super QUIManager, Unit> r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "component");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "bindFunction");
        Intrinsics.checkNotNullParameter(r5, "unbindFunction");
        int r0 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r0 != 2) goto L5;
        if (r2 != null) goto L15;
        return;
    L15:
        View r6 = r2.getView();
        if (r6 != null) goto L19;
        return;
    L19:
        if ((r1 instanceof QIMust) == false) goto L21;
        ((QIMust) r1).mustBind(r2.getQModel(), r2.getQuiManager());
    L21:
        r4.invoke(r2.getQModel(), r6, r2.getQuiManager());
        return;
    L5:
        if (r0 != 5) goto L24;
        if (r2 != null) goto L10;
        return;
    L10:
        if ((r1 instanceof QIMust) == false) goto L12;
        ((QIMust) r1).mustUnbind();
    L12:
        r5.invoke();
        return;
    }
}
