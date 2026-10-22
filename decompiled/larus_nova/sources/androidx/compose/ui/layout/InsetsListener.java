package androidx.compose.ui.layout;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0002J\u001e\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020)02H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00104\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0018\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\u0006\u00100\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00100\u001a\u00020\u0010H\u0002J\b\u00109\u001a\u00020'H\u0016J\u0010\u0010:\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006<"}, d2 = {"Landroidx/compose/ui/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeView", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getComposeView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "prepared", "", "runningAnimationMask", "", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "insetsValues", "Landroidx/collection/ScatterMap;", "", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "generation", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "displayCutouts", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "getDisplayCutouts", "()Landroidx/collection/MutableObjectList;", "displayCutoutRulers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/ui/layout/RectRulers;", "getDisplayCutoutRulers", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "onPrepare", "", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/core/view/WindowInsetsAnimationCompat;", WidgetCostModule.TYPE_ON_START, "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "updateInsetAnimationInfo", "insetsValue", "onProgress", "insets", "runningAnimations", "", "onEnd", "stopAnimationForRuler", "onApplyWindowInsets", "view", "Landroid/view/View;", "updateInsets", "run", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {
    public static final int $stable = 8;
    private final AndroidComposeView composeView;
    private final SnapshotStateList<RectRulers> displayCutoutRulers;
    private final MutableObjectList<MutableState<Rect>> displayCutouts;
    private final MutableIntState generation;
    private final ScatterMap<Object, WindowWindowInsetsAnimationValues> insetsValues;
    private boolean prepared;
    private int runningAnimationMask;
    private WindowInsetsCompat savedInsets;

    @Override // java.lang.Runnable
    public void run() {
        androidx_compose_ui_layout_InsetsListener_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_compose_ui_layout_InsetsListener__run$___twin___() {
        if (this.prepared == false) goto L8;
        this.runningAnimationMask = 0;
        this.prepared = false;
        WindowInsetsCompat r100 = this.savedInsets;
        if (r100 == null) goto L9;
        updateInsets(r100);
        this.savedInsets = null;
        return;
    L9:
        return;
    }

    public final AndroidComposeView getComposeView() {
        return this.composeView;
    }

    public final SnapshotStateList<RectRulers> getDisplayCutoutRulers() {
        return this.displayCutoutRulers;
    }

    public final MutableObjectList<MutableState<Rect>> getDisplayCutouts() {
        return this.displayCutouts;
    }

    public final MutableIntState getGeneration() {
        return this.generation;
    }

    public final ScatterMap<Object, WindowWindowInsetsAnimationValues> getInsetsValues() {
        return this.insetsValues;
    }

    public InsetsListener(AndroidComposeView r100) {
        super(1);
        this.composeView = r100;
        MutableScatterMap r101 = new MutableScatterMap(9);
        WindowInsetsRulers.Companion r102 = WindowInsetsRulers.Companion;
        r101.set(r102.getCaptionBar(), new WindowWindowInsetsAnimationValues("caption bar"));
        r101.set(r102.getDisplayCutout(), new WindowWindowInsetsAnimationValues("display cutout"));
        r101.set(r102.getIme(), new WindowWindowInsetsAnimationValues("ime"));
        r101.set(r102.getMandatorySystemGestures(), new WindowWindowInsetsAnimationValues("mandatory system gestures"));
        r101.set(r102.getNavigationBars(), new WindowWindowInsetsAnimationValues("navigation bars"));
        r101.set(r102.getStatusBars(), new WindowWindowInsetsAnimationValues("status bars"));
        r101.set(r102.getSystemGestures(), new WindowWindowInsetsAnimationValues("system gestures"));
        r101.set(r102.getTappableElement(), new WindowWindowInsetsAnimationValues("tappable element"));
        r101.set(r102.getWaterfall(), new WindowWindowInsetsAnimationValues("waterfall"));
        this.insetsValues = r101;
        this.generation = SnapshotIntStateKt.mutableIntStateOf(0);
        this.displayCutouts = new MutableObjectList(4);
        this.displayCutoutRulers = SnapshotStateKt.mutableStateListOf();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_compose_ui_layout_InsetsListener_com_larus_apm_impl_protector_RunnableLancet_run(InsetsListener r100) {
        r100.androidx_compose_ui_layout_InsetsListener__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private final void stopAnimationForRuler(WindowWindowInsetsAnimationValues r100) {
        r100.setAnimating(false);
        r100.m6390setSourceValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
        r100.m6391setTargetValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
    }

    private final void updateInsets(WindowInsetsCompat r310) {
        IntObjectMap r100 = WindowInsetsRulers_androidKt.access$getWindowInsetsTypeMap$p();
        int[] r101 = r100.keys;
        Object[] r102 = r100.values;
        long[] r103 = r100.metadata;
        int r104 = r103.length - 2;
        long r105 = 255;
        char r110 = 7;
        long r111 = -9187201950435737472L;
        int r106 = 8;
        if (r104 < 0) goto L28;
        int r112 = 0;
        boolean r210 = false;
        boolean r211 = false;
    L5:
        long r113 = r103[r112];
        if (((((~r113) << r110) & r113) & r111) == r111) goto L25;
        int r107 = 8 - ((~(r112 - r104)) >>> 31);
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L22;
        if ((r113 & r105) >= 128) goto L12;
        boolean r212 = true;
    L13:
        if (r212 == false) goto L21;
        int r213 = (r112 << 3) + r108;
        int r109 = r101[r213];
        WindowInsetsRulers r114 = (WindowInsetsRulers) r102[r213];
        Insets r115 = r310.getInsets(r109);
        long r116 = ValueInsets.m6372constructorimpl((((((long) r115.top) << 32) | (((long) r115.left) << 48)) | (((long) r115.right) << 16)) | ((long) r115.bottom));
        WindowWindowInsetsAnimationValues r117 = this.insetsValues.get(r114);
        Intrinsics.checkNotNull(r117);
        WindowWindowInsetsAnimationValues r118 = r117;
        if (ValueInsets.m6374equalsimpl0(r116, r118.m6384getCurrenthdzbrEE()) == true) goto L19;
        r118.m6388setCurrentYnlvx88(r116);
        r210 = true;
        if (ValueInsets.m6374equalsimpl0(r116, ValueInsets_androidKt.getZeroValueInsets()) == true) goto L19;
        r211 = true;
    L19:
        r106 = 8;
    L21:
        r113 = r113 >> r106;
        r108 = r108 + 1;
        r112 = r112;
        r107 = r107;
        r105 = 255;
        goto L8
    L12:
        r212 = false;
        goto L13
    L22:
        int r214 = r112;
        if (r107 != r106) goto L29;
        int r119 = r214;
    L26:
        if (r119 == r104) goto L29;
        r112 = r119 + 1;
        r106 = 8;
        r105 = 255;
        r110 = 7;
        r111 = -9187201950435737472L;
    L29:
        MutableIntObjectMap r120 = WindowInsetsRulers_androidKt.access$getAnimatableRulers$p();
        int[] r121 = r120.keys;
        Object[] r122 = r120.values;
        long[] r123 = r120.metadata;
        int r124 = r123.length - 2;
        if (r124 < 0) goto L58;
        int r125 = 0;
    L32:
        long r126 = r123[r125];
        if (((((~r126) << 7) & r126) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L55;
        int r127 = 8 - ((~(r125 - r124)) >>> 31);
        int r128 = 0;
    L35:
        if (r128 >= r127) goto L52;
        if ((r126 & 255) >= 128) goto L39;
        boolean r129 = true;
    L40:
        if (r129 == false) goto L50;
        int r130 = (r125 << 3) + r128;
        int r131 = r121[r130];
        WindowWindowInsetsAnimationValues r132 = this.insetsValues.get((WindowInsetsRulers) r122[r130]);
        Intrinsics.checkNotNull(r132);
        WindowWindowInsetsAnimationValues r133 = r132;
        if (r131 == WindowInsetsCompat.Type.ime()) goto L48;
        Insets r134 = r310.getInsetsIgnoringVisibility(r131);
        long[] r135 = r123;
        int[] r215 = r121;
        long r136 = ValueInsets.m6372constructorimpl((((((long) r134.top) << 32) | (((long) r134.left) << 48)) | (((long) r134.right) << 16)) | ((long) r134.bottom));
        if (ValueInsets.m6374equalsimpl0(r133.m6385getMaximumhdzbrEE(), r136) == true) goto L49;
        r133.m6389setMaximumYnlvx88(r136);
        r210 = true;
        if (ValueInsets.m6374equalsimpl0(r136, ValueInsets_androidKt.getZeroValueInsets()) == true) goto L49;
        r211 = true;
    L49:
        r133.setVisible(r310.isVisible(r131));
    L51:
        r126 = r126 >> 8;
        r128 = r128 + 1;
        r123 = r135;
        r121 = r215;
        goto L35
    L48:
        r135 = r123;
        r215 = r121;
        goto L49
    L50:
        r135 = r123;
        r215 = r121;
        goto L51
    L39:
        r129 = false;
        goto L40
    L52:
        long[] r137 = r123;
        int[] r216 = r121;
        if (r127 != 8) goto L58;
    L56:
        if (r125 == r124) goto L58;
        r125 = r125 + 1;
        r123 = r137;
        r121 = r216;
        goto L32
    L55:
        r137 = r123;
        r216 = r121;
    L58:
        DisplayCutoutCompat r138 = r310.getDisplayCutout();
        if (r138 != null) goto L61;
        long r139 = ValueInsets_androidKt.getZeroValueInsets();
    L62:
        ScatterMap<Object, WindowWindowInsetsAnimationValues> r140 = this.insetsValues;
        WindowInsetsRulers.Companion r141 = WindowInsetsRulers.Companion;
        WindowWindowInsetsAnimationValues r142 = r140.get(r141.getWaterfall());
        Intrinsics.checkNotNull(r142);
        WindowWindowInsetsAnimationValues r143 = r142;
        if (ValueInsets.m6374equalsimpl0(r143.m6384getCurrenthdzbrEE(), r139) == true) goto L67;
        r143.m6388setCurrentYnlvx88(r139);
        r143.m6389setMaximumYnlvx88(r139);
        r210 = true;
        if (ValueInsets.m6374equalsimpl0(r139, ValueInsets_androidKt.getZeroValueInsets()) == true) goto L67;
        r211 = true;
    L67:
        if (r138 != null) goto L69;
        long r144 = ValueInsets_androidKt.getZeroValueInsets();
    L70:
        WindowWindowInsetsAnimationValues r145 = this.insetsValues.get(r141.getDisplayCutout());
        Intrinsics.checkNotNull(r145);
        WindowWindowInsetsAnimationValues r146 = r145;
        if (ValueInsets.m6374equalsimpl0(r144, r146.m6384getCurrenthdzbrEE()) == true) goto L75;
        r146.m6388setCurrentYnlvx88(r144);
        r146.m6389setMaximumYnlvx88(r144);
        r210 = true;
        if (ValueInsets.m6374equalsimpl0(r144, ValueInsets_androidKt.getZeroValueInsets()) == true) goto L75;
        r211 = true;
    L75:
        if (r138 == null) goto L77;
        List<Rect> r147 = r138.getBoundingRects();
        if (r147.size() >= this.displayCutouts.getSize()) goto L82;
        this.displayCutouts.removeRange(r147.size(), this.displayCutouts.getSize());
        this.displayCutoutRulers.removeRange(r147.size(), this.displayCutoutRulers.size());
        r210 = true;
    L85:
        List<Rect> r148 = r147;
        int r149 = r148.size();
        int r150 = 0;
    L86:
        if (r150 >= r149) goto L92;
        Rect r151 = (Rect) ListProtector.get(r147, r150);
        MutableState<Rect> r152 = this.displayCutouts.get(r150);
        if (Intrinsics.areEqual(r152.getValue(), r151) == true) goto L90;
        r152.setValue(r151);
        r210 = true;
    L90:
        r150 = r150 + 1;
        goto L86
    L92:
        if ((!r148.isEmpty()) == false) goto L94;
        r211 = true;
    L94:
        if (r211 == false) goto L96;
    L97:
        if (r210 == false) goto L115;
        MutableIntState r153 = this.generation;
        r153.setIntValue(r153.getIntValue() + 1);
        Snapshot.Companion.sendApplyNotifications();
        return;
    L115:
        return;
    L96:
        if (this.generation.getIntValue() != 0) goto L97;
        return;
    L82:
        int r154 = r147.size() - this.displayCutouts.getSize();
        int r155 = 0;
    L83:
        if (r155 >= r154) goto L85;
        MutableObjectList<MutableState<Rect>> r156 = this.displayCutouts;
        r156.add(SnapshotStateKt.mutableStateOf$default(ListProtector.get(r147, r156.getSize()), null, 2, null));
        this.displayCutoutRulers.add(RectRulersKt.RectRulers("display cutout rect " + this.displayCutouts.getSize()));
        r155 = r155 + 1;
        r210 = true;
        goto L83
    L77:
        if (this.displayCutouts.getSize() <= 0) goto L94;
        this.displayCutouts.clear();
        this.displayCutoutRulers.clear();
        r210 = true;
        goto L94
    L69:
        int r157 = r138.getSafeInsetLeft();
        long r158 = ((long) r157) << 48;
        r144 = ValueInsets.m6372constructorimpl((((((long) r138.getSafeInsetTop()) << 32) | r158) | (((long) r138.getSafeInsetRight()) << 16)) | ((long) r138.getSafeInsetBottom()));
        goto L70
    L61:
        Insets r159 = r138.getWaterfallInsets();
        r139 = ValueInsets.m6372constructorimpl((((((long) r159.left) << 48) | (((long) r159.top) << 32)) | (((long) r159.right) << 16)) | ((long) r159.bottom));
        goto L62
    L25:
        r119 = r112;
        goto L26
    L28:
        r210 = false;
        r211 = false;
        goto L29
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat r100) {
        this.prepared = false;
        int r101 = r100.getTypeMask();
        this.runningAnimationMask &= ~r101;
        this.savedInsets = null;
        WindowInsetsRulers r102 = (WindowInsetsRulers) WindowInsetsRulers_androidKt.access$getAnimatableRulers$p().get(r101);
        if (r102 == null) goto L5;
        WindowWindowInsetsAnimationValues r103 = this.insetsValues.get(r102);
        Intrinsics.checkNotNull(r103);
        WindowWindowInsetsAnimationValues r104 = r103;
        r104.setFraction(0.0f);
        r104.setAlpha(1.0f);
        r104.setDurationMillis(0);
        r104.setFraction(0.0f);
        stopAnimationForRuler(r104);
        MutableIntState r105 = this.generation;
        r105.setIntValue(r105.getIntValue() + 1);
        Snapshot.Companion.sendApplyNotifications();
    L5:
        super.onEnd(r100);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat r100) {
        this.prepared = true;
        super.onPrepare(r100);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == false) goto L5;
        View r102 = (View) r101;
    L6:
        if (r102 == null) goto L9;
        r100 = r102;
    L9:
        ViewCompat.setOnApplyWindowInsetsListener(r100, this);
        ViewCompat.setWindowInsetsAnimationCallback(r100, this);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == false) goto L5;
        View r102 = (View) r101;
    L6:
        if (r102 == null) goto L9;
        r100 = r102;
    L9:
        ViewCompat.setOnApplyWindowInsetsListener(r100, null);
        ViewCompat.setWindowInsetsAnimationCallback(r100, null);
        return;
    L5:
        r102 = null;
        goto L6
    }

    private final void updateInsetAnimationInfo(WindowWindowInsetsAnimationValues r100, WindowInsetsAnimationCompat r101) {
        r100.setFraction(r101.getInterpolatedFraction());
        r100.setAlpha(r101.getAlpha());
        r100.setDurationMillis(r101.getDurationMillis());
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        if (this.prepared == false) goto L8;
        this.savedInsets = r101;
        if (Build.VERSION.SDK_INT != 30) goto L10;
        r100.post(this);
    L10:
        return r101;
    L8:
        if (this.runningAnimationMask != 0) goto L10;
        updateInsets(r101);
        goto L10
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat r100, List<WindowInsetsAnimationCompat> r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        WindowInsetsAnimationCompat r104 = (WindowInsetsAnimationCompat) ListProtector.get(r101, r103);
        int r105 = r104.getTypeMask();
        WindowInsetsRulers r106 = (WindowInsetsRulers) WindowInsetsRulers_androidKt.access$getAnimatableRulers$p().get(r105);
        if (r106 == null) goto L9;
        WindowWindowInsetsAnimationValues r107 = this.insetsValues.get(r106);
        Intrinsics.checkNotNull(r107);
        WindowWindowInsetsAnimationValues r108 = r107;
        if (r108.isAnimating() == false) goto L9;
        updateInsetAnimationInfo(r108, r104);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        updateInsets(r100);
        return r100;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r100, WindowInsetsAnimationCompat.BoundsCompat r101) {
        WindowInsetsCompat r102 = this.savedInsets;
        this.prepared = false;
        this.savedInsets = null;
        if (r100.getDurationMillis() <= 0) goto L11;
        if (r102 == null) goto L11;
        int r103 = r100.getTypeMask();
        this.runningAnimationMask |= r103;
        WindowInsetsRulers r104 = (WindowInsetsRulers) WindowInsetsRulers_androidKt.access$getAnimatableRulers$p().get(r103);
        if (r104 == null) goto L11;
        WindowWindowInsetsAnimationValues r105 = this.insetsValues.get(r104);
        Intrinsics.checkNotNull(r105);
        WindowWindowInsetsAnimationValues r106 = r105;
        Insets r107 = r102.getInsets(r103);
        long r108 = ValueInsets.m6372constructorimpl(((long) r107.bottom) | (((((long) r107.left) << 48) | (((long) r107.top) << 32)) | (((long) r107.right) << 16)));
        long r109 = r106.m6384getCurrenthdzbrEE();
        if (ValueInsets.m6374equalsimpl0(r108, r109) == true) goto L11;
        r106.m6390setSourceValueInsetsYnlvx88(r109);
        r106.m6391setTargetValueInsetsYnlvx88(r108);
        r106.setAnimating(true);
        updateInsetAnimationInfo(r106, r100);
        MutableIntState r110 = this.generation;
        r110.setIntValue(r110.getIntValue() + 1);
        Snapshot.Companion.sendApplyNotifications();
    L11:
        return super.onStart(r100, r101);
    }
}
