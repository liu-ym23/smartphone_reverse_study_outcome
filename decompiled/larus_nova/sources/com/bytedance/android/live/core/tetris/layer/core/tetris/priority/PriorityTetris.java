package com.bytedance.android.live.core.tetris.layer.core.tetris.priority;

import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.setting.d2;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.common.jato.views.JatoOptFrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import h70.b;
import j70.f;
import j70.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k70.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import t70.k;
import u70.c;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityTetris;", "Lh70/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OrientationMode", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PriorityTetris<T extends h70.b> extends Tetris<T> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PriorityLinearLayout f65814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HorizontalScrollView f65815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JatoOptFrameLayout f65816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f65817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<View, u70.b> f65818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<View, String> f65819t;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityTetris$OrientationMode;", "", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OrientationMode {
    }

    public static final class a {
    }

    public static final class b implements PriorityLinearLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PriorityTetris f65820a;

        public b(PriorityTetris r100) {
            this.f65820a = r100;
        }

        @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.priority.PriorityLinearLayout.b
        public final void a(List<? extends View> r100, List<? extends View> r101, List<? extends View> r102) {
            Intrinsics.checkNotNullParameter(r100, "allVisibleChildren");
            Intrinsics.checkNotNullParameter(r101, "canToCannotList");
            Intrinsics.checkNotNullParameter(r102, "cannotToCanList");
            Iterator<T> r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            View r104 = (View) r103.next();
            LocalTestManager.a(new Class[]{wy.a.class});
            goto L4
        L6:
            Iterator<T> r105 = r101.iterator();
        L8:
            if (r105.hasNext() == false) goto L12;
            u70.b r106 = (u70.b) ((LinkedHashMap) this.f65820a.f65818s).get((View) r105.next());
            if (r106 == null) goto L8;
            r106.J6(false);
            goto L8
        L12:
            Iterator<T> r107 = r102.iterator();
        L14:
            if (r107.hasNext() == false) goto L18;
            u70.b r108 = (u70.b) ((LinkedHashMap) this.f65820a.f65818s).get((View) r107.next());
            if (r108 == null) goto L14;
            r108.J6(true);
            goto L14
        }
    }

    static {
    }

    public abstract boolean Q();

    public abstract boolean R();

    public abstract boolean S();

    public abstract boolean T();

    public abstract int V();

    public abstract void W();

    public abstract int Z();

    public PriorityTetris() {
        this.f65817r = new b(this);
        this.f65818s = new LinkedHashMap();
        this.f65819t = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r100) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        PriorityLinearLayout r101 = new PriorityLinearLayout(r100.getContext(), null, 6, 0);
        this.f65814o = r101;
        r101.setChangeListener(this.f65817r);
        PriorityLinearLayout r102 = this.f65814o;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L5:
        W();
        r102.setOrientation(0);
        PriorityLinearLayout r103 = this.f65814o;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L8:
        r103.setSpaceMargin(V());
        PriorityLinearLayout r104 = this.f65814o;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L11:
        r104.setMaxVisibleCount(Z());
        PriorityLinearLayout r105 = this.f65814o;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L14:
        r105.setAutoDismissChildViewWhenWidthLimit(S());
        PriorityLinearLayout r106 = this.f65814o;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L17:
        View r107 = r106;
        if (Q() == false) goto L37;
        PriorityLinearLayout r108 = this.f65814o;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L22:
        r108.setAutoDismissChildViewWhenWidthLimit(false);
        if (R() == false) goto L28;
        HorizontalScrollView r109 = new HorizontalScrollView(r100.getContext(), null, 0);
        r109.setClipChildren(true);
        r109.setHorizontalFadingEdgeEnabled(true);
        r109.setHorizontalScrollBarEnabled(false);
        r109.setPadding(0, 0, 1, 0);
        PriorityLinearLayout r110 = this.f65814o;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L27:
        r109.addView(r110, new ViewGroup.LayoutParams(-2, -2));
        Unit r111 = Unit.INSTANCE;
        this.f65815p = r109;
    L33:
        if (d2.f65279a.getValue().booleanValue() == false) goto L35;
        JatoOptFrameLayoutVisibilityProxy r112 = new JatoOptFrameLayoutVisibilityProxy(r100.getContext(), null, 6, 0);
        r112.setClipChildren(true);
        r112.addView(this.f65815p, new ViewGroup.LayoutParams(-1, -1));
        JatoOptFrameLayout r113 = r112;
    L36:
        this.f65816q = r113;
        r107 = r113;
        goto L37
    L35:
        JatoOptFrameLayout r114 = new JatoOptFrameLayout(r100.getContext());
        r114.setClipChildren(true);
        r114.addView(this.f65815p, new ViewGroup.LayoutParams(-1, -1));
        r113 = r114;
        goto L36
    L28:
        HorizontalScrollView r115 = new HorizontalScrollView(r100.getContext());
        r115.setClipChildren(true);
        r115.setHorizontalFadingEdgeEnabled(true);
        r115.setHorizontalScrollBarEnabled(false);
        r115.setPadding(0, 0, 1, 0);
        PriorityLinearLayout r116 = this.f65814o;
        if (r116 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L31:
        r115.addView(r116, new ViewGroup.LayoutParams(-2, -2));
        Unit r117 = Unit.INSTANCE;
        this.f65815p = r115;
    L37:
        return r107;
    }

    public final Element P(o r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "elementAttribute");
        Intrinsics.checkNotNullParameter(r101, "priorityItemInfo");
        k70.c r102 = this.f65788b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("elementFactory");
    L5:
        Element<?> r103 = r102.a(f.f497555c, r100);
        ((ArrayList) this.f65787a).add(r103);
        View r104 = r103.c(K().getContext(), null);
        if (r104 == null) goto L32;
        r103.f65660b = r104;
        getLifecycle().addObserver(r103);
        d r105 = this.f65790d;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L10:
        r105.b(r103);
        PriorityLinearLayout r106 = this.f65814o;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L13:
        r106.getPriorityMap().put(r104, Integer.valueOf(r101.f549031a));
        PriorityLinearLayout r107 = this.f65814o;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L16:
        r107.getViewToIdentifyMap().put(r104, r101.f549032b);
        PriorityLinearLayout r108 = this.f65814o;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L19:
        r108.getIdentifyToViewMap().put(r101.f549032b, r104);
        PriorityLinearLayout r109 = this.f65814o;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L22:
        r109.addView(r104);
        u70.b r110 = (u70.b) r103.f(u70.b.class);
        if (r110 == null) goto L25;
        this.f65818s.put(r104, r110);
    L25:
        this.f65819t.put(r104, r101.f549032b);
        if (T() == false) goto L30;
        JatoOptFrameLayout r111 = this.f65816q;
        if (r111 == null) goto L30;
        r111.setHasFixSize(true);
    L30:
        return r103;
    L32:
        throw new IllegalStateException("buildView 不能为空");
    }
}
