package com.bytedance.android.live.messagewindow.framework.manager;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements IFloatingBannerManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f83112d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<View, d> f83113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f83114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f83115c;

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.manager.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC1264a {
        public AbstractC1264a() {
        }

        public abstract void a();
    }

    public static final class b {
    }

    public final class c extends e {
        public c(a r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            super(r100, r101);
        }

        @Override // com.bytedance.android.live.messagewindow.framework.manager.a.e
        public final boolean b(ConstraintLayout.LayoutParams r100, ViewGroup r101, ViewGroup r102, Rect r103) {
            Intrinsics.checkNotNullParameter(r100, "lp");
            Intrinsics.checkNotNullParameter(r101, "fullscreen");
            Intrinsics.checkNotNullParameter(r102, "layerLayout");
            Intrinsics.checkNotNullParameter(r103, "publicScreenRectInLayer");
            int r104 = r102.getHeight() - r103.top;
            int r105 = (int) fm3.e.a(this.f83119b.getContext(), 22.0f);
            if (((ViewGroup.MarginLayoutParams) r100).bottomMargin == r104) goto L5;
        L8:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            ((ViewGroup.MarginLayoutParams) r100).bottomMargin = r104;
            ((ViewGroup.MarginLayoutParams) r100).height = r105;
        L11:
            return r106;
        L5:
            if (((ViewGroup.MarginLayoutParams) r100).height != r105) goto L8;
            r106 = false;
            goto L9
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<AbstractC1264a> f83116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f83117b;

        public d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "layerView");
            this.f83117b = r100;
            this.f83116a = new ArrayList();
        }
    }

    public class e extends AbstractC1264a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Disposable f83118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f83119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f83120c;

        /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.manager.a$e$a, reason: collision with other inner class name */
        public static final class C1265a<T1, T2, R> implements BiFunction {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1265a f83121a = null;

            static {
                f83121a = new C1265a();
            }

            public C1265a() {
            }

            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object r100, Object r101) {
                i32.a r102 = (i32.a) r101;
                Intrinsics.checkNotNullParameter((Unit) r100, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(r102, "data");
                return r102;
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f83122a;

            public b(e r100) {
                this.f83122a = r100;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                i32.a r101 = (i32.a) r100;
                e r102 = this.f83122a;
                r102.getClass();
                Intrinsics.checkNotNullParameter(r101, "data");
                ViewParent r103 = r102.f83120c.f83114b.getParent();
                ViewParent r104 = null;
                if (r103 == null) goto L5;
                ViewParent r105 = r103.getParent();
            L7:
                if ((r105 instanceof ViewGroup) == false) goto L10;
                r104 = r105;
            L10:
                ViewGroup r106 = (ViewGroup) r104;
                if (r106 != null) goto L13;
                r102.f83120c.getClass();
                a.a("fullscreenParent is null");
                return;
            L13:
                ViewParent r107 = r102.f83119b.getParent();
                if (r107 == null) goto L25;
                ViewGroup r108 = (ViewGroup) r107;
                ViewGroup.LayoutParams r109 = r102.f83119b.getLayoutParams();
                if (r109 == null) goto L23;
                ConstraintLayout.LayoutParams r110 = (ConstraintLayout.LayoutParams) r109;
                int r111 = r106.getHeight() - r101.f488090b;
                Rect r112 = new Rect(0, r111 - r101.f488089a, r106.getRight(), r111);
                String r113 = r112.toString();
                r106.offsetRectIntoDescendantCoords(r108, r112);
                boolean r114 = r102.b(r110, r106, r108, r112);
                if (r114 == false) goto L20;
                r102.f83119b.setLayoutParams(r110);
            L20:
                a r115 = r102.f83120c;
                String r116 = "onPublicScreenSpecUpdated fullScreenSize=(" + r106.getWidth() + ", " + r106.getHeight() + ") pubRectInFullscreen=" + r113 + " pubRectInLayer=" + r112 + " layoutChanged=" + r114;
                r115.getClass();
                a.a(r116);
                return;
            L23:
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            L25:
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            L5:
                r105 = null;
                goto L7
            }
        }

        @Override // com.bytedance.android.live.messagewindow.framework.manager.a.AbstractC1264a
        public final void a() {
            this.f83118a.dispose();
        }

        public e(a r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.f83120c = r100;
            this.f83119b = r101;
            ConstraintSet r102 = new ConstraintSet();
            r102.connect(r101.getId(), 1, 0, 1);
            r102.connect(r101.getId(), 2, 0, 2);
            r102.connect(r101.getId(), 4, 0, 4);
            ViewParent r103 = r101.getParent();
            if (r103 == null) goto L11;
            r102.applyTo((ConstraintLayout) r103);
            Observable<Unit> r104 = RxUtilKt.g(r101, false);
            if (ViewCompat.isLaidOut(r101) == false) goto L7;
            r104 = r104.startWith(Unit.INSTANCE);
        L8:
            this.f83118a = Observable.combineLatest(r104.doOnNext(new com.bytedance.android.live.messagewindow.framework.manager.d(this)), RxUtilKt.b(r100.f83115c, "cmd_data_interact_public_screen_height_change", true).distinctUntilChanged(com.bytedance.android.live.messagewindow.framework.manager.b.f83123a).doOnNext(new com.bytedance.android.live.messagewindow.framework.manager.c(this)), C1265a.f83121a).subscribe(new b(this));
            return;
        L7:
            r101.getLeft();
            goto L8
        L11:
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        }

        public boolean b(ConstraintLayout.LayoutParams r100, ViewGroup r101, ViewGroup r102, Rect r103) {
            Intrinsics.checkNotNullParameter(r100, "lp");
            Intrinsics.checkNotNullParameter(r101, "fullscreen");
            Intrinsics.checkNotNullParameter(r102, "layerLayout");
            Intrinsics.checkNotNullParameter(r103, "publicScreenRectInLayer");
            int r104 = r102.getHeight() - r103.bottom;
            int r105 = r103.height();
            if (((ViewGroup.MarginLayoutParams) r100).bottomMargin == r104) goto L5;
        L8:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            ((ViewGroup.MarginLayoutParams) r100).bottomMargin = r104;
            ((ViewGroup.MarginLayoutParams) r100).height = r105;
        L11:
            return r106;
        L5:
            if (((ViewGroup.MarginLayoutParams) r100).height != r105) goto L8;
            r106 = false;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager
    public final ViewGroup getRootContainer() {
        return this.f83114b;
    }

    public static void a(String r100) {
        ALogger.i("FloatingBannerManager", r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager
    public final void H1(View r100) {
        Intrinsics.checkNotNullParameter(r100, "layerView");
        d r101 = this.f83113a.get(r100);
        if (r101 == null) goto L11;
        a("unloadLayer " + r100);
        Iterator r102 = ((ArrayList) r101.f83116a).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((AbstractC1264a) r102.next()).a();
        goto L6
    L8:
        ((ArrayList) r101.f83116a).clear();
        this.f83114b.removeView(r100);
        return;
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager
    public final void n0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "layerView");
        if (this.f83113a.containsKey(r100) == true) goto L6;
        a("loadLayer " + r100);
        this.f83114b.addView(r100, -1, -1);
        this.f83113a.put(r100, new d(r100));
        return;
    }

    public a(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f83115c = r101;
        this.f83113a = new HashMap();
        this.f83114b = new FrameLayout(r100);
    }

    @Override // com.bytedance.android.live.room.api.messagewindow.manager.IFloatingBannerManager
    public final void I1(View r100, View r101, IFloatingBannerManager.Element r102) {
        Intrinsics.checkNotNullParameter(r100, "layerView");
        Intrinsics.checkNotNullParameter(r101, "placeholderView");
        Intrinsics.checkNotNullParameter(r102, "reference");
        d r103 = this.f83113a.get(r100);
        if (r103 == null) goto L15;
        int r104 = com.bytedance.android.live.messagewindow.framework.manager.e.f83126a[r102.ordinal()];
        if (r104 != 1) goto L7;
        Object r105 = new e(this, r101);
    L12:
        a("setPlaceholder " + r100 + ' ' + r105);
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.GAIAX_PLACEHOLDER);
        ((ArrayList) r103.f83116a).add(r105);
        return;
    L7:
        if (r104 != 2) goto L10;
        r105 = new c(this, r101);
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalStateException("layer is not loaded");
    }
}
