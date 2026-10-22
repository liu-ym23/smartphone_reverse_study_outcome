package androidx.compose.material3;

import C7.r;
import S7.n;
import S7.o;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.FabPosition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a±\u0001\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0013\b\u0002\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0087\u0001\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u00042\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "topBar", "bottomBar", "snackbarHost", "floatingActionButton", "Landroidx/compose/material3/FabPosition;", "floatingActionButtonPosition", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "Landroidx/compose/foundation/layout/WindowInsets;", "contentWindowInsets", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/n;LS7/n;IJJLandroidx/compose/foundation/layout/WindowInsets;LS7/o;Landroidx/compose/runtime/Composer;II)V", "Scaffold", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILS7/n;LS7/o;LS7/n;LS7/n;Landroidx/compose/foundation/layout/WindowInsets;LS7/n;Landroidx/compose/runtime/Composer;I)V", "ScaffoldLayout", "Landroidx/compose/ui/unit/Dp;", "FabSpacing", "F", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final float FabSpacing = Dp.m6844constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010e  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_][_][_]]")
    /* renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2173ScaffoldTvnljyQ(androidx.compose.ui.Modifier r28, S7.n r29, S7.n r30, S7.n r31, S7.n r32, int r33, long r34, long r36, androidx.compose.foundation.layout.WindowInsets r38, final S7.o r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScaffoldKt.m2173ScaffoldTvnljyQ(androidx.compose.ui.Modifier, S7.n, S7.n, S7.n, S7.n, int, long, long, androidx.compose.foundation.layout.WindowInsets, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][_][_][_][_]]")
    /* renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m2174ScaffoldLayoutFMILGgc(final int i, final n nVar, final o oVar, final n nVar2, final n nVar3, final WindowInsets windowInsets, final n nVar4, Composer composer, final int i6) {
        int i10;
        o oVar2;
        n nVar5;
        final WindowInsets windowInsets2;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-975511942);
        if ((i6 & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i6;
        } else {
            i10 = i6;
        }
        if ((i6 & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            oVar2 = oVar;
            i10 |= composerStartRestartGroup.changedInstance(oVar2) ? 256 : 128;
        } else {
            oVar2 = oVar;
        }
        if ((i6 & 3072) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar2) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            nVar5 = nVar3;
            i10 |= composerStartRestartGroup.changedInstance(nVar5) ? 16384 : 8192;
        } else {
            nVar5 = nVar3;
        }
        if ((196608 & i6) == 0) {
            windowInsets2 = windowInsets;
            i10 |= composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i6 & 1572864) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar4) ? 1048576 : 524288;
        }
        if ((i10 & 599187) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i10, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:138)");
            }
            boolean z10 = ((i10 & 112) == 32) | ((i10 & 7168) == 2048) | ((458752 & i10) == 131072) | ((57344 & i10) == 16384) | ((i10 & 14) == 4) | ((3670016 & i10) == 1048576) | ((i10 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final o oVar3 = oVar2;
                i11 = 1;
                final n nVar6 = nVar5;
                n nVar7 = new n() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m2176invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2176invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j5) {
                        Object obj;
                        Object obj2;
                        Object obj3;
                        FabPlacement fabPlacement;
                        Object obj4;
                        Object obj5;
                        Object obj6;
                        int iMo375roundToPx0680j_4;
                        int iMo375roundToPx0680j_42;
                        final int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
                        final int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
                        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
                        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, nVar);
                        ArrayList arrayList = new ArrayList(listSubcompose.size());
                        int size = listSubcompose.size();
                        for (int i12 = 0; i12 < size; i12++) {
                            arrayList.add(listSubcompose.get(i12).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                        }
                        if (arrayList.isEmpty()) {
                            obj = null;
                        } else {
                            obj = arrayList.get(0);
                            int height = ((Placeable) obj).getHeight();
                            int iH = H4.o.H(arrayList);
                            if (1 <= iH) {
                                int i13 = 1;
                                while (true) {
                                    Object obj7 = arrayList.get(i13);
                                    int height2 = ((Placeable) obj7).getHeight();
                                    if (height < height2) {
                                        obj = obj7;
                                        height = height2;
                                    }
                                    if (i13 == iH) {
                                        break;
                                    }
                                    i13++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj;
                        int height3 = placeable != null ? placeable.getHeight() : 0;
                        List<Measurable> listSubcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, nVar2);
                        WindowInsets windowInsets3 = windowInsets2;
                        final ArrayList arrayList2 = new ArrayList(listSubcompose2.size());
                        int size2 = listSubcompose2.size();
                        int i14 = 0;
                        while (i14 < size2) {
                            arrayList2.add(listSubcompose2.get(i14).mo5549measureBRTryo0(ConstraintsKt.m6816offsetNN6EwU(jM6787copyZbe2FdA$default, (-windowInsets3.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope))));
                            i14++;
                            listSubcompose2 = listSubcompose2;
                        }
                        if (arrayList2.isEmpty()) {
                            obj2 = null;
                        } else {
                            obj2 = arrayList2.get(0);
                            int height4 = ((Placeable) obj2).getHeight();
                            int iH2 = H4.o.H(arrayList2);
                            if (1 <= iH2) {
                                Object obj8 = obj2;
                                int i15 = height4;
                                int i16 = 1;
                                while (true) {
                                    Object obj9 = arrayList2.get(i16);
                                    int height5 = ((Placeable) obj9).getHeight();
                                    if (i15 < height5) {
                                        obj8 = obj9;
                                        i15 = height5;
                                    }
                                    if (i16 == iH2) {
                                        break;
                                    }
                                    i16++;
                                }
                                obj2 = obj8;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj2;
                        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                        if (arrayList2.isEmpty()) {
                            obj3 = null;
                        } else {
                            obj3 = arrayList2.get(0);
                            int width = ((Placeable) obj3).getWidth();
                            int iH3 = H4.o.H(arrayList2);
                            if (1 <= iH3) {
                                Object obj10 = obj3;
                                int i17 = width;
                                int i18 = 1;
                                while (true) {
                                    Object obj11 = arrayList2.get(i18);
                                    int width2 = ((Placeable) obj11).getWidth();
                                    if (i17 < width2) {
                                        obj10 = obj11;
                                        i17 = width2;
                                    }
                                    if (i18 == iH3) {
                                        break;
                                    }
                                    i18++;
                                }
                                obj3 = obj10;
                            }
                        }
                        Placeable placeable3 = (Placeable) obj3;
                        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                        List<Measurable> listSubcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, nVar6);
                        WindowInsets windowInsets4 = windowInsets2;
                        final int i19 = width3;
                        final ArrayList arrayList3 = new ArrayList(listSubcompose3.size());
                        int size3 = listSubcompose3.size();
                        int i20 = 0;
                        while (i20 < size3) {
                            int i21 = height6;
                            ArrayList arrayList4 = arrayList;
                            List<Measurable> list = listSubcompose3;
                            int i22 = height3;
                            Placeable placeableMo5549measureBRTryo0 = listSubcompose3.get(i20).mo5549measureBRTryo0(ConstraintsKt.m6816offsetNN6EwU(jM6787copyZbe2FdA$default, (-windowInsets4.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets4.getRight(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets4.getBottom(subcomposeMeasureScope)));
                            if (placeableMo5549measureBRTryo0.getHeight() == 0 || placeableMo5549measureBRTryo0.getWidth() == 0) {
                                placeableMo5549measureBRTryo0 = null;
                            }
                            if (placeableMo5549measureBRTryo0 != null) {
                                arrayList3.add(placeableMo5549measureBRTryo0);
                            }
                            i20++;
                            arrayList = arrayList4;
                            height6 = i21;
                            listSubcompose3 = list;
                            height3 = i22;
                        }
                        int i23 = height6;
                        final ArrayList arrayList5 = arrayList;
                        final int i24 = height3;
                        if (arrayList3.isEmpty()) {
                            fabPlacement = null;
                        } else {
                            if (arrayList3.isEmpty()) {
                                obj5 = null;
                            } else {
                                obj5 = arrayList3.get(0);
                                int width4 = ((Placeable) obj5).getWidth();
                                int iH4 = H4.o.H(arrayList3);
                                if (1 <= iH4) {
                                    Object obj12 = obj5;
                                    int i25 = width4;
                                    int i26 = 1;
                                    while (true) {
                                        Object obj13 = arrayList3.get(i26);
                                        int width5 = ((Placeable) obj13).getWidth();
                                        if (i25 < width5) {
                                            obj12 = obj13;
                                            i25 = width5;
                                        }
                                        if (i26 == iH4) {
                                            break;
                                        }
                                        i26++;
                                    }
                                    obj5 = obj12;
                                }
                            }
                            k.c(obj5);
                            int width6 = ((Placeable) obj5).getWidth();
                            if (arrayList3.isEmpty()) {
                                obj6 = null;
                            } else {
                                obj6 = arrayList3.get(0);
                                int height7 = ((Placeable) obj6).getHeight();
                                int iH5 = H4.o.H(arrayList3);
                                if (1 <= iH5) {
                                    int i27 = height7;
                                    Object obj14 = obj6;
                                    int i28 = 1;
                                    while (true) {
                                        Object obj15 = arrayList3.get(i28);
                                        int height8 = ((Placeable) obj15).getHeight();
                                        if (i27 < height8) {
                                            obj14 = obj15;
                                            i27 = height8;
                                        }
                                        if (i28 == iH5) {
                                            break;
                                        }
                                        i28++;
                                    }
                                    obj6 = obj14;
                                }
                            }
                            k.c(obj6);
                            int height9 = ((Placeable) obj6).getHeight();
                            int i29 = i;
                            FabPosition.Companion companion = FabPosition.INSTANCE;
                            if (!FabPosition.m1859equalsimpl0(i29, companion.m1866getStartERTFSPs())) {
                                if (!(FabPosition.m1859equalsimpl0(i29, companion.m1864getEndERTFSPs()) ? true : FabPosition.m1859equalsimpl0(i29, companion.m1865getEndOverlayERTFSPs()))) {
                                    iMo375roundToPx0680j_4 = (iM6797getMaxWidthimpl - width6) / 2;
                                } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                    iMo375roundToPx0680j_42 = subcomposeMeasureScope.mo375roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    iMo375roundToPx0680j_4 = (iM6797getMaxWidthimpl - iMo375roundToPx0680j_42) - width6;
                                } else {
                                    iMo375roundToPx0680j_4 = subcomposeMeasureScope.mo375roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                }
                                fabPlacement = new FabPlacement(iMo375roundToPx0680j_4, width6, height9);
                            } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                iMo375roundToPx0680j_4 = subcomposeMeasureScope.mo375roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                fabPlacement = new FabPlacement(iMo375roundToPx0680j_4, width6, height9);
                            } else {
                                iMo375roundToPx0680j_42 = subcomposeMeasureScope.mo375roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                iMo375roundToPx0680j_4 = (iM6797getMaxWidthimpl - iMo375roundToPx0680j_42) - width6;
                                fabPlacement = new FabPlacement(iMo375roundToPx0680j_4, width6, height9);
                            }
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final n nVar8 = nVar4;
                        List<Measurable> listSubcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-2146438447, true, new n() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
                            {
                                super(2);
                            }

                            @Override // S7.n
                            public /* bridge */ /* synthetic */ Object invoke(Object obj16, Object obj17) {
                                invoke((Composer) obj16, ((Number) obj17).intValue());
                                return r.f317a;
                            }

                            @Composable
                            public final void invoke(Composer composer2, int i30) {
                                if ((i30 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2146438447, i30, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:209)");
                                }
                                nVar8.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        final ArrayList arrayList6 = new ArrayList(listSubcompose4.size());
                        int size4 = listSubcompose4.size();
                        for (int i30 = 0; i30 < size4; i30++) {
                            arrayList6.add(listSubcompose4.get(i30).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                        }
                        if (arrayList6.isEmpty()) {
                            obj4 = null;
                        } else {
                            obj4 = arrayList6.get(0);
                            int height10 = ((Placeable) obj4).getHeight();
                            int iH6 = H4.o.H(arrayList6);
                            if (1 <= iH6) {
                                int i31 = 1;
                                while (true) {
                                    Object obj16 = arrayList6.get(i31);
                                    int height11 = ((Placeable) obj16).getHeight();
                                    if (height10 < height11) {
                                        height10 = height11;
                                        obj4 = obj16;
                                    }
                                    if (i31 == iH6) {
                                        break;
                                    }
                                    i31++;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) obj4;
                        final Integer numValueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                        Integer numValueOf2 = fabPlacement != null ? Integer.valueOf((numValueOf == null || FabPosition.m1859equalsimpl0(i, FabPosition.INSTANCE.m1865getEndOverlayERTFSPs())) ? windowInsets2.getBottom(subcomposeMeasureScope) + subcomposeMeasureScope.mo375roundToPx0680j_4(ScaffoldKt.FabSpacing) + fabPlacement.getHeight() : subcomposeMeasureScope.mo375roundToPx0680j_4(ScaffoldKt.FabSpacing) + fabPlacement.getHeight() + numValueOf.intValue()) : null;
                        int iIntValue = i23 != 0 ? i23 + (numValueOf2 != null ? numValueOf2.intValue() : numValueOf != null ? numValueOf.intValue() : windowInsets2.getBottom(subcomposeMeasureScope)) : 0;
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets5 = windowInsets2;
                        final o oVar4 = oVar3;
                        List<Measurable> listSubcompose5 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1213360416, true, new n() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // S7.n
                            public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                                invoke((Composer) obj17, ((Number) obj18).intValue());
                                return r.f317a;
                            }

                            @Composable
                            public final void invoke(Composer composer2, int i32) {
                                Integer num;
                                if ((i32 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1213360416, i32, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:238)");
                                }
                                PaddingValues paddingValuesAsPaddingValues = WindowInsetsKt.asPaddingValues(windowInsets5, subcomposeMeasureScope);
                                oVar4.invoke(PaddingKt.m696PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), arrayList5.isEmpty() ? paddingValuesAsPaddingValues.getTop() : subcomposeMeasureScope.mo378toDpu2uoSUM(i24), PaddingKt.calculateEndPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), (arrayList6.isEmpty() || (num = numValueOf) == null) ? paddingValuesAsPaddingValues.getBottom() : subcomposeMeasureScope.mo378toDpu2uoSUM(num.intValue())), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        final ArrayList arrayList7 = new ArrayList(listSubcompose5.size());
                        int size5 = listSubcompose5.size();
                        for (int i32 = 0; i32 < size5; i32++) {
                            arrayList7.add(listSubcompose5.get(i32).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                        }
                        final WindowInsets windowInsets6 = windowInsets2;
                        final Integer num = numValueOf;
                        final Integer num2 = numValueOf2;
                        final int i33 = iIntValue;
                        final FabPlacement fabPlacement2 = fabPlacement;
                        return MeasureScope.layout$default(subcomposeMeasureScope, iM6797getMaxWidthimpl, iM6796getMaxHeightimpl, null, new S7.k() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj17) {
                                invoke((Placeable.PlacementScope) obj17);
                                return r.f317a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                List<Placeable> list2 = arrayList7;
                                int size6 = list2.size();
                                for (int i34 = 0; i34 < size6; i34++) {
                                    Placeable.PlacementScope.place$default(placementScope, list2.get(i34), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list3 = arrayList5;
                                int size7 = list3.size();
                                for (int i35 = 0; i35 < size7; i35++) {
                                    Placeable.PlacementScope.place$default(placementScope, list3.get(i35), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list4 = arrayList2;
                                int i36 = iM6797getMaxWidthimpl;
                                int i37 = i19;
                                WindowInsets windowInsets7 = windowInsets6;
                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                int i38 = iM6796getMaxHeightimpl;
                                int i39 = i33;
                                int size8 = list4.size();
                                for (int i40 = 0; i40 < size8; i40++) {
                                    Placeable.PlacementScope.place$default(placementScope, list4.get(i40), windowInsets7.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection()) + ((i36 - i37) / 2), i38 - i39, 0.0f, 4, null);
                                }
                                List<Placeable> list5 = arrayList6;
                                int i41 = iM6796getMaxHeightimpl;
                                Integer num3 = num;
                                int size9 = list5.size();
                                for (int i42 = 0; i42 < size9; i42++) {
                                    Placeable.PlacementScope.place$default(placementScope, list5.get(i42), 0, i41 - (num3 != null ? num3.intValue() : 0), 0.0f, 4, null);
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                if (fabPlacement3 != null) {
                                    List<Placeable> list6 = arrayList3;
                                    int i43 = iM6796getMaxHeightimpl;
                                    Integer num4 = num2;
                                    int size10 = list6.size();
                                    for (int i44 = 0; i44 < size10; i44++) {
                                        Placeable placeable5 = list6.get(i44);
                                        int left = fabPlacement3.getLeft();
                                        k.c(num4);
                                        Placeable.PlacementScope.place$default(placementScope, placeable5, left, i43 - num4.intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(nVar7);
                objRememberedValue = nVar7;
            } else {
                i11 = 1;
            }
            SubcomposeLayoutKt.SubcomposeLayout(null, (n) objRememberedValue, composerStartRestartGroup, 0, i11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    ScaffoldKt.m2174ScaffoldLayoutFMILGgc(i, nVar, oVar, nVar2, nVar3, windowInsets, nVar4, composer2, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
                }
            });
        }
    }
}
