package androidx.compose.ui.layout;

import android.graphics.Rect;
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
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.layout.WindowInsetsRulers;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010\u0017J\u001f\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b)\u0010(R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R#\u00107\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\t058\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010<\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R#\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0A0@8\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020H0G8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L¨\u0006M"}, d2 = {"Landroidx/compose/ui/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/compose/ui/platform/AndroidComposeView;", "composeView", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "insetsValue", "Landroidx/core/view/WindowInsetsAnimationCompat;", "animation", "LC7/r;", "updateInsetAnimationInfo", "(Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;Landroidx/core/view/WindowInsetsAnimationCompat;)V", "stopAnimationForRuler", "(Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;)V", "Landroidx/core/view/WindowInsetsCompat;", "insets", "updateInsets", "(Landroidx/core/view/WindowInsetsCompat;)V", "onPrepare", "(Landroidx/core/view/WindowInsetsAnimationCompat;)V", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onStart", "(Landroidx/core/view/WindowInsetsAnimationCompat;Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;)Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "", "runningAnimations", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "(Landroidx/core/view/WindowInsetsCompat;Ljava/util/List;)Landroidx/core/view/WindowInsetsCompat;", "onEnd", "Landroid/view/View;", "view", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;", "run", "()V", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "Landroidx/compose/ui/platform/AndroidComposeView;", "getComposeView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "", "prepared", "Z", "", "runningAnimationMask", "I", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "Landroidx/collection/ScatterMap;", "", "insetsValues", "Landroidx/collection/ScatterMap;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MutableIntState;", "generation", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "displayCutouts", "Landroidx/collection/MutableObjectList;", "getDisplayCutouts", "()Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/ui/layout/RectRulers;", "displayCutoutRulers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getDisplayCutoutRulers", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
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

    public InsetsListener(AndroidComposeView androidComposeView) {
        super(1);
        this.composeView = androidComposeView;
        MutableScatterMap mutableScatterMap = new MutableScatterMap(9);
        WindowInsetsRulers.Companion companion = WindowInsetsRulers.INSTANCE;
        mutableScatterMap.set(companion.getCaptionBar(), new WindowWindowInsetsAnimationValues("caption bar"));
        mutableScatterMap.set(companion.getDisplayCutout(), new WindowWindowInsetsAnimationValues("display cutout"));
        mutableScatterMap.set(companion.getIme(), new WindowWindowInsetsAnimationValues("ime"));
        mutableScatterMap.set(companion.getMandatorySystemGestures(), new WindowWindowInsetsAnimationValues("mandatory system gestures"));
        mutableScatterMap.set(companion.getNavigationBars(), new WindowWindowInsetsAnimationValues("navigation bars"));
        mutableScatterMap.set(companion.getStatusBars(), new WindowWindowInsetsAnimationValues("status bars"));
        mutableScatterMap.set(companion.getSystemGestures(), new WindowWindowInsetsAnimationValues("system gestures"));
        mutableScatterMap.set(companion.getTappableElement(), new WindowWindowInsetsAnimationValues("tappable element"));
        mutableScatterMap.set(companion.getWaterfall(), new WindowWindowInsetsAnimationValues("waterfall"));
        this.insetsValues = mutableScatterMap;
        this.generation = SnapshotIntStateKt.mutableIntStateOf(0);
        this.displayCutouts = new MutableObjectList<>(4);
        this.displayCutoutRulers = SnapshotStateKt.mutableStateListOf();
    }

    private final void stopAnimationForRuler(WindowWindowInsetsAnimationValues insetsValue) {
        insetsValue.setAnimating(false);
        insetsValue.m5679setSourceValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
        insetsValue.m5680setTargetValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
    }

    private final void updateInsetAnimationInfo(WindowWindowInsetsAnimationValues insetsValue, WindowInsetsAnimationCompat animation) {
        insetsValue.setFraction(animation.getInterpolatedFraction());
        insetsValue.setAlpha(animation.getAlpha());
        insetsValue.setDurationMillis(animation.getDurationMillis());
    }

    private final void updateInsets(WindowInsetsCompat insets) {
        long j5;
        boolean z10;
        long j6;
        char c;
        char c2;
        char c5;
        char c10;
        int i;
        boolean z11;
        boolean z12;
        long jM5661constructorimpl;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        long[] jArr3;
        int[] iArr3;
        long[] jArr4;
        int[] iArr4;
        int i6;
        long j10;
        int i10;
        IntObjectMap intObjectMap = WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
        int[] iArr5 = intObjectMap.keys;
        Object[] objArr = intObjectMap.values;
        long[] jArr5 = intObjectMap.metadata;
        int i11 = 2;
        int length = jArr5.length - 2;
        long j11 = -9187201950435737472L;
        int i12 = 8;
        if (length >= 0) {
            int i13 = 0;
            z11 = false;
            z12 = false;
            z10 = true;
            j6 = 255;
            while (true) {
                long j12 = jArr5[i13];
                c = 7;
                c2 = 16;
                if ((((~j12) << 7) & j12 & j11) != j11) {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((j12 & 255) < 128) {
                            int i16 = (i13 << 3) + i15;
                            int i17 = iArr5[i16];
                            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) objArr[i16];
                            Insets insets2 = insets.getInsets(i17);
                            j10 = j11;
                            i10 = i11;
                            i6 = i12;
                            jArr4 = jArr5;
                            iArr4 = iArr5;
                            long jM5661constructorimpl2 = ValueInsets.m5661constructorimpl((insets2.top << 32) | (insets2.left << 48) | (insets2.right << 16) | insets2.bottom);
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                            k.c(windowWindowInsetsAnimationValues);
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                            if (!ValueInsets.m5663equalsimpl0(jM5661constructorimpl2, windowWindowInsetsAnimationValues2.getCurrent())) {
                                windowWindowInsetsAnimationValues2.m5677setCurrentYnlvx88(jM5661constructorimpl2);
                                z11 = true;
                                if (!ValueInsets.m5663equalsimpl0(jM5661constructorimpl2, ValueInsets_androidKt.getZeroValueInsets())) {
                                    z12 = true;
                                }
                            }
                        } else {
                            jArr4 = jArr5;
                            iArr4 = iArr5;
                            i6 = i12;
                            j10 = j11;
                            i10 = i11;
                        }
                        j12 >>= i6;
                        i15++;
                        i11 = i10;
                        i12 = i6;
                        j11 = j10;
                        iArr5 = iArr4;
                        jArr5 = jArr4;
                    }
                    jArr3 = jArr5;
                    iArr3 = iArr5;
                    j5 = j11;
                    c5 = ' ';
                    c10 = '0';
                    i = i11;
                    if (i14 != i12) {
                        break;
                    }
                } else {
                    jArr3 = jArr5;
                    iArr3 = iArr5;
                    j5 = j11;
                    c5 = ' ';
                    c10 = '0';
                    i = i11;
                }
                if (i13 == length) {
                    break;
                }
                i13++;
                i11 = i;
                j11 = j5;
                iArr5 = iArr3;
                jArr5 = jArr3;
                i12 = 8;
            }
        } else {
            j5 = -9187201950435737472L;
            z10 = true;
            j6 = 255;
            c = 7;
            c2 = 16;
            c5 = ' ';
            c10 = '0';
            i = 2;
            z11 = false;
            z12 = false;
        }
        MutableIntObjectMap mutableIntObjectMap = WindowInsetsRulers_androidKt.AnimatableRulers;
        int[] iArr6 = mutableIntObjectMap.keys;
        Object[] objArr2 = mutableIntObjectMap.values;
        long[] jArr6 = mutableIntObjectMap.metadata;
        int length2 = jArr6.length - 2;
        if (length2 >= 0) {
            int i18 = 0;
            while (true) {
                long j13 = jArr6[i18];
                if ((((~j13) << c) & j13 & j5) != j5) {
                    int i19 = 8 - ((~(i18 - length2)) >>> 31);
                    int i20 = 0;
                    while (i20 < i19) {
                        if ((j13 & j6) < 128) {
                            int i21 = (i18 << 3) + i20;
                            int i22 = iArr6[i21];
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues3 = this.insetsValues.get((WindowInsetsRulers) objArr2[i21]);
                            k.c(windowWindowInsetsAnimationValues3);
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues4 = windowWindowInsetsAnimationValues3;
                            if (i22 != WindowInsetsCompat.Type.ime()) {
                                Insets insetsIgnoringVisibility = insets.getInsetsIgnoringVisibility(i22);
                                jArr2 = jArr6;
                                iArr2 = iArr6;
                                long jM5661constructorimpl3 = ValueInsets.m5661constructorimpl((insetsIgnoringVisibility.top << c5) | (insetsIgnoringVisibility.left << c10) | (insetsIgnoringVisibility.right << c2) | insetsIgnoringVisibility.bottom);
                                if (!ValueInsets.m5663equalsimpl0(windowWindowInsetsAnimationValues4.getMaximum(), jM5661constructorimpl3)) {
                                    windowWindowInsetsAnimationValues4.m5678setMaximumYnlvx88(jM5661constructorimpl3);
                                    z11 = z10;
                                    if (!ValueInsets.m5663equalsimpl0(jM5661constructorimpl3, ValueInsets_androidKt.getZeroValueInsets())) {
                                        z12 = z11;
                                    }
                                }
                            } else {
                                jArr2 = jArr6;
                                iArr2 = iArr6;
                            }
                            windowWindowInsetsAnimationValues4.setVisible(insets.isVisible(i22));
                        } else {
                            jArr2 = jArr6;
                            iArr2 = iArr6;
                        }
                        j13 >>= 8;
                        i20++;
                        jArr6 = jArr2;
                        iArr6 = iArr2;
                    }
                    jArr = jArr6;
                    iArr = iArr6;
                    if (i19 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr6;
                    iArr = iArr6;
                }
                if (i18 == length2) {
                    break;
                }
                i18++;
                jArr6 = jArr;
                iArr6 = iArr;
            }
        }
        DisplayCutoutCompat displayCutout = insets.getDisplayCutout();
        if (displayCutout == null) {
            jM5661constructorimpl = ValueInsets_androidKt.getZeroValueInsets();
        } else {
            Insets waterfallInsets = displayCutout.getWaterfallInsets();
            jM5661constructorimpl = ValueInsets.m5661constructorimpl((waterfallInsets.left << c10) | (waterfallInsets.top << c5) | (waterfallInsets.right << c2) | waterfallInsets.bottom);
        }
        ScatterMap<Object, WindowWindowInsetsAnimationValues> scatterMap = this.insetsValues;
        WindowInsetsRulers.Companion companion = WindowInsetsRulers.INSTANCE;
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues5 = scatterMap.get(companion.getWaterfall());
        k.c(windowWindowInsetsAnimationValues5);
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues6 = windowWindowInsetsAnimationValues5;
        if (!ValueInsets.m5663equalsimpl0(windowWindowInsetsAnimationValues6.getCurrent(), jM5661constructorimpl)) {
            windowWindowInsetsAnimationValues6.m5677setCurrentYnlvx88(jM5661constructorimpl);
            windowWindowInsetsAnimationValues6.m5678setMaximumYnlvx88(jM5661constructorimpl);
            z11 = z10;
            if (!ValueInsets.m5663equalsimpl0(jM5661constructorimpl, ValueInsets_androidKt.getZeroValueInsets())) {
                z12 = z11;
            }
        }
        long zeroValueInsets = displayCutout == null ? ValueInsets_androidKt.getZeroValueInsets() : ValueInsets.m5661constructorimpl((displayCutout.getSafeInsetTop() << c5) | (displayCutout.getSafeInsetLeft() << c10) | (displayCutout.getSafeInsetRight() << c2) | displayCutout.getSafeInsetBottom());
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues7 = this.insetsValues.get(companion.getDisplayCutout());
        k.c(windowWindowInsetsAnimationValues7);
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues8 = windowWindowInsetsAnimationValues7;
        if (!ValueInsets.m5663equalsimpl0(zeroValueInsets, windowWindowInsetsAnimationValues8.getCurrent())) {
            windowWindowInsetsAnimationValues8.m5677setCurrentYnlvx88(zeroValueInsets);
            windowWindowInsetsAnimationValues8.m5678setMaximumYnlvx88(zeroValueInsets);
            z11 = z10;
            if (!ValueInsets.m5663equalsimpl0(zeroValueInsets, ValueInsets_androidKt.getZeroValueInsets())) {
                z12 = z11;
            }
        }
        if (displayCutout != null) {
            List<Rect> boundingRects = displayCutout.getBoundingRects();
            if (boundingRects.size() < this.displayCutouts.getSize()) {
                this.displayCutouts.removeRange(boundingRects.size(), this.displayCutouts.getSize());
                this.displayCutoutRulers.removeRange(boundingRects.size(), this.displayCutoutRulers.size());
                z11 = z10;
            } else {
                int size = boundingRects.size() - this.displayCutouts.getSize();
                int i23 = 0;
                while (i23 < size) {
                    MutableObjectList<MutableState<Rect>> mutableObjectList = this.displayCutouts;
                    mutableObjectList.add(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundingRects.get(mutableObjectList.getSize()), null, i, null));
                    this.displayCutoutRulers.add(RectRulersKt.RectRulers("display cutout rect " + this.displayCutouts.getSize()));
                    i23++;
                    z11 = z10;
                }
            }
            List<Rect> list = boundingRects;
            int size2 = list.size();
            for (int i24 = 0; i24 < size2; i24++) {
                Rect rect = boundingRects.get(i24);
                MutableState<Rect> mutableState = this.displayCutouts.get(i24);
                if (!k.b(mutableState.getValue(), rect)) {
                    mutableState.setValue(rect);
                    z11 = z10;
                }
            }
            if (!list.isEmpty()) {
                z12 = z10;
            }
        } else if (this.displayCutouts.getSize() > 0) {
            this.displayCutouts.clear();
            this.displayCutoutRulers.clear();
            z11 = z10;
        }
        if ((z12 || this.generation.getIntValue() != 0) && z11) {
            MutableIntState mutableIntState = this.generation;
            mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
            Snapshot.INSTANCE.sendApplyNotifications();
        }
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

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
        if (this.prepared) {
            this.savedInsets = insets;
            return insets;
        }
        if (this.runningAnimationMask == 0) {
            updateInsets(insets);
        }
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat animation) {
        this.prepared = false;
        int typeMask = animation.getTypeMask();
        this.runningAnimationMask &= ~typeMask;
        this.savedInsets = null;
        WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) WindowInsetsRulers_androidKt.AnimatableRulers.get(typeMask);
        if (windowInsetsRulers != null) {
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
            k.c(windowWindowInsetsAnimationValues);
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
            windowWindowInsetsAnimationValues2.setFraction(0.0f);
            windowWindowInsetsAnimationValues2.setAlpha(1.0f);
            windowWindowInsetsAnimationValues2.setDurationMillis(0L);
            windowWindowInsetsAnimationValues2.setFraction(0.0f);
            stopAnimationForRuler(windowWindowInsetsAnimationValues2);
            MutableIntState mutableIntState = this.generation;
            mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
            Snapshot.INSTANCE.sendApplyNotifications();
        }
        super.onEnd(animation);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat animation) {
        this.prepared = true;
        super.onPrepare(animation);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
        int size = runningAnimations.size();
        for (int i = 0; i < size; i++) {
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = runningAnimations.get(i);
            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) WindowInsetsRulers_androidKt.AnimatableRulers.get(windowInsetsAnimationCompat.getTypeMask());
            if (windowInsetsRulers != null) {
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                k.c(windowWindowInsetsAnimationValues);
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                if (windowWindowInsetsAnimationValues2.isAnimating()) {
                    updateInsetAnimationInfo(windowWindowInsetsAnimationValues2, windowInsetsAnimationCompat);
                }
            }
        }
        updateInsets(insets);
        return insets;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        WindowInsetsCompat windowInsetsCompat = this.savedInsets;
        this.prepared = false;
        this.savedInsets = null;
        if (animation.getDurationMillis() > 0 && windowInsetsCompat != null) {
            int typeMask = animation.getTypeMask();
            this.runningAnimationMask |= typeMask;
            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) WindowInsetsRulers_androidKt.AnimatableRulers.get(typeMask);
            if (windowInsetsRulers != null) {
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                k.c(windowWindowInsetsAnimationValues);
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                Insets insets = windowInsetsCompat.getInsets(typeMask);
                long jM5661constructorimpl = ValueInsets.m5661constructorimpl(insets.bottom | (insets.left << 48) | (insets.top << 32) | (insets.right << 16));
                long current = windowWindowInsetsAnimationValues2.getCurrent();
                if (!ValueInsets.m5663equalsimpl0(jM5661constructorimpl, current)) {
                    windowWindowInsetsAnimationValues2.m5679setSourceValueInsetsYnlvx88(current);
                    windowWindowInsetsAnimationValues2.m5680setTargetValueInsetsYnlvx88(jM5661constructorimpl);
                    windowWindowInsetsAnimationValues2.setAnimating(true);
                    updateInsetAnimationInfo(windowWindowInsetsAnimationValues2, animation);
                    MutableIntState mutableIntState = this.generation;
                    mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
                    Snapshot.INSTANCE.sendApplyNotifications();
                }
            }
        }
        return super.onStart(animation, bounds);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, this);
        ViewCompat.setWindowInsetsAnimationCallback(view, this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, null);
        ViewCompat.setWindowInsetsAnimationCallback(view, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prepared) {
            this.runningAnimationMask = 0;
            this.prepared = false;
            WindowInsetsCompat windowInsetsCompat = this.savedInsets;
            if (windowInsetsCompat != null) {
                updateInsets(windowInsetsCompat);
                this.savedInsets = null;
            }
        }
    }
}
