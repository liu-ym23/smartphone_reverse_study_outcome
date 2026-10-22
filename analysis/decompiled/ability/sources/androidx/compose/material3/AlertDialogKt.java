package androidx.compose.material3;

import C7.r;
import D7.v;
import H4.o;
import S7.k;
import S7.n;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aD\u0010\t\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001aD\u0010\u000b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\n\u001aÇ\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00072\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00072\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00072\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a¦\u0001\u0010!\u001a\u00020\u00012\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00072\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00072\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a5\u0010&\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00182\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0007H\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\"\u001a\u0010'\u001a\u00020\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u001a\u0010+\u001a\u00020\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*\"\u0014\u0010-\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010(\"\u0014\u0010.\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010(\"\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101\"\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00101\"\u0014\u00103\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00101\"\u0014\u00104\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00101\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "onDismissRequest", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/window/DialogProperties;", "properties", "Landroidx/compose/runtime/Composable;", "content", "BasicAlertDialog", "(LS7/a;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;LS7/n;Landroidx/compose/runtime/Composer;II)V", "AlertDialog", "confirmButton", "dismissButton", "icon", "title", "text", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "containerColor", "iconContentColor", "titleContentColor", "textContentColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "AlertDialogImpl-wrnwzgE", "(LS7/a;LS7/n;Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/n;LS7/n;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "AlertDialogImpl", "buttons", "buttonContentColor", "AlertDialogContent-4hvqGtA", "(LS7/n;Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/n;Landroidx/compose/ui/graphics/Shape;JFJJJJLandroidx/compose/runtime/Composer;III)V", "AlertDialogContent", "mainAxisSpacing", "crossAxisSpacing", "AlertDialogFlowRow-ixp7dh8", "(FFLS7/n;Landroidx/compose/runtime/Composer;I)V", "AlertDialogFlowRow", "DialogMinWidth", "F", "getDialogMinWidth", "()F", "DialogMaxWidth", "getDialogMaxWidth", "ButtonsMainAxisSpacing", "ButtonsCrossAxisSpacing", "Landroidx/compose/foundation/layout/PaddingValues;", "DialogPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "IconPadding", "TitlePadding", "TextPadding", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlertDialogKt {
    private static final PaddingValues DialogPadding;
    private static final PaddingValues IconPadding;
    private static final PaddingValues TextPadding;
    private static final PaddingValues TitlePadding;
    private static final float DialogMinWidth = Dp.m6844constructorimpl(280);
    private static final float DialogMaxWidth = Dp.m6844constructorimpl(560);
    private static final float ButtonsMainAxisSpacing = Dp.m6844constructorimpl(8);
    private static final float ButtonsCrossAxisSpacing = Dp.m6844constructorimpl(12);

    static {
        float f = 24;
        DialogPadding = PaddingKt.m693PaddingValues0680j_4(Dp.m6844constructorimpl(f));
        float f7 = 16;
        IconPadding = PaddingKt.m697PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6844constructorimpl(f7), 7, null);
        TitlePadding = PaddingKt.m697PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6844constructorimpl(f7), 7, null);
        TextPadding = PaddingKt.m697PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6844constructorimpl(f), 7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @C7.c
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AlertDialog(final S7.a r17, androidx.compose.ui.Modifier r18, androidx.compose.ui.window.DialogProperties r19, final S7.n r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.AlertDialog(S7.a, androidx.compose.ui.Modifier, androidx.compose.ui.window.DialogProperties, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1498AlertDialogContent4hvqGtA(final S7.n r29, androidx.compose.ui.Modifier r30, final S7.n r31, final S7.n r32, final S7.n r33, final androidx.compose.ui.graphics.Shape r34, final long r35, final float r37, final long r38, final long r40, final long r42, final long r44, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.m1498AlertDialogContent4hvqGtA(S7.n, androidx.compose.ui.Modifier, S7.n, S7.n, S7.n, androidx.compose.ui.graphics.Shape, long, float, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m1499AlertDialogFlowRowixp7dh8(final float f, final float f7, final n nVar, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(586821353);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(f7) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(586821353, i6, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:364)");
            }
            boolean z10 = ((i6 & 14) == 4) | ((i6 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1
                    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> list, Ref$IntRef ref$IntRef, MeasureScope measureScope, float f9, long j5, Placeable placeable) {
                        if (list.isEmpty()) {
                            return true;
                        }
                        return placeable.getWidth() + (measureScope.mo375roundToPx0680j_4(f9) + ref$IntRef.f4918a) <= Constraints.m6797getMaxWidthimpl(j5);
                    }

                    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> list, Ref$IntRef ref$IntRef, MeasureScope measureScope, float f9, List<Placeable> list2, List<Integer> list3, Ref$IntRef ref$IntRef2, List<Integer> list4, Ref$IntRef ref$IntRef3, Ref$IntRef ref$IntRef4) {
                        if (!list.isEmpty()) {
                            ref$IntRef.f4918a = measureScope.mo375roundToPx0680j_4(f9) + ref$IntRef.f4918a;
                        }
                        list.add(0, v.f1(list2));
                        list3.add(Integer.valueOf(ref$IntRef2.f4918a));
                        list4.add(Integer.valueOf(ref$IntRef.f4918a));
                        ref$IntRef.f4918a += ref$IntRef2.f4918a;
                        ref$IntRef3.f4918a = Math.max(ref$IntRef3.f4918a, ref$IntRef4.f4918a);
                        list2.clear();
                        ref$IntRef4.f4918a = 0;
                        ref$IntRef2.f4918a = 0;
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        final ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        final ArrayList arrayList3 = new ArrayList();
                        Ref$IntRef ref$IntRef = new Ref$IntRef();
                        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
                        ArrayList arrayList4 = new ArrayList();
                        Ref$IntRef ref$IntRef3 = new Ref$IntRef();
                        Ref$IntRef ref$IntRef4 = new Ref$IntRef();
                        float f9 = f;
                        float f10 = f7;
                        int size = list.size();
                        int i10 = 0;
                        while (i10 < size) {
                            ArrayList arrayList5 = arrayList;
                            Ref$IntRef ref$IntRef5 = ref$IntRef2;
                            Placeable placeableMo5549measureBRTryo0 = list.get(i10).mo5549measureBRTryo0(j5);
                            int i11 = i10;
                            Ref$IntRef ref$IntRef6 = ref$IntRef3;
                            ref$IntRef3 = ref$IntRef6;
                            int i12 = size;
                            if (measure_3p2s80s$canAddToCurrentSequence(arrayList4, ref$IntRef6, measureScope, f9, j5, placeableMo5549measureBRTryo0)) {
                                arrayList = arrayList5;
                                ref$IntRef2 = ref$IntRef5;
                            } else {
                                arrayList = arrayList5;
                                ref$IntRef2 = ref$IntRef5;
                                measure_3p2s80s$startNewSequence(arrayList, ref$IntRef2, measureScope, f10, arrayList4, arrayList2, ref$IntRef4, arrayList3, ref$IntRef, ref$IntRef3);
                            }
                            if (!arrayList4.isEmpty()) {
                                ref$IntRef3.f4918a = measureScope.mo375roundToPx0680j_4(f9) + ref$IntRef3.f4918a;
                            }
                            arrayList4.add(placeableMo5549measureBRTryo0);
                            ref$IntRef3.f4918a = placeableMo5549measureBRTryo0.getWidth() + ref$IntRef3.f4918a;
                            ref$IntRef4.f4918a = Math.max(ref$IntRef4.f4918a, placeableMo5549measureBRTryo0.getHeight());
                            i10 = i11 + 1;
                            size = i12;
                        }
                        if (!arrayList4.isEmpty()) {
                            measure_3p2s80s$startNewSequence(arrayList, ref$IntRef2, measureScope, f7, arrayList4, arrayList2, ref$IntRef4, arrayList3, ref$IntRef, ref$IntRef3);
                        }
                        final int iMax = Math.max(ref$IntRef.f4918a, Constraints.m6799getMinWidthimpl(j5));
                        int iMax2 = Math.max(ref$IntRef2.f4918a, Constraints.m6798getMinHeightimpl(j5));
                        final float f11 = f;
                        return MeasureScope.layout$default(measureScope, iMax, iMax2, null, new k() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                List<List<Placeable>> list2 = arrayList;
                                MeasureScope measureScope2 = measureScope;
                                float f12 = f11;
                                int i13 = iMax;
                                List<Integer> list3 = arrayList3;
                                int size2 = list2.size();
                                for (int i14 = 0; i14 < size2; i14++) {
                                    List<Placeable> list4 = list2.get(i14);
                                    int size3 = list4.size();
                                    int[] iArr = new int[size3];
                                    int i15 = 0;
                                    while (i15 < size3) {
                                        iArr[i15] = list4.get(i15).getWidth() + (i15 < o.H(list4) ? measureScope2.mo375roundToPx0680j_4(f12) : 0);
                                        i15++;
                                    }
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    int[] iArr2 = new int[size3];
                                    for (int i16 = 0; i16 < size3; i16++) {
                                        iArr2[i16] = 0;
                                    }
                                    end.arrange(measureScope2, i13, iArr, measureScope2.getLayoutDirection(), iArr2);
                                    int size4 = list4.size();
                                    for (int i17 = 0; i17 < size4; i17++) {
                                        Placeable.PlacementScope.place$default(placementScope, list4.get(i17), iArr2[i17], list3.get(i14).intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int i10 = (i6 >> 6) & 14;
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion2.getConstructor();
            int i11 = ((i10 << 6) & 896) | 6;
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            if (androidx.appfunctions.metadata.a.C(nVar, composerStartRestartGroup, (i11 >> 6) & 14)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$2
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
                    AlertDialogKt.m1499AlertDialogFlowRowixp7dh8(f, f7, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: AlertDialogImpl-wrnwzgE, reason: not valid java name */
    public static final void m1500AlertDialogImplwrnwzgE(final S7.a aVar, final n nVar, final Modifier modifier, final n nVar2, final n nVar3, final n nVar4, final n nVar5, final Shape shape, final long j5, final long j6, final long j10, final long j11, final float f, final DialogProperties dialogProperties, Composer composer, final int i, final int i6) {
        int i10;
        n nVar6;
        n nVar7;
        n nVar8;
        int i11;
        float f7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-919826268);
        if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changedInstance(aVar) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            nVar6 = nVar;
            i10 |= composerStartRestartGroup.changedInstance(nVar6) ? 32 : 16;
        } else {
            nVar6 = nVar;
        }
        if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            nVar7 = nVar2;
            i10 |= composerStartRestartGroup.changedInstance(nVar7) ? 2048 : 1024;
        } else {
            nVar7 = nVar2;
        }
        if ((i & 24576) == 0) {
            nVar8 = nVar3;
            i10 |= composerStartRestartGroup.changedInstance(nVar8) ? 16384 : 8192;
        } else {
            nVar8 = nVar3;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar4) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar5) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i10 |= composerStartRestartGroup.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i10 |= composerStartRestartGroup.changed(j5) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((i & 805306368) == 0) {
            i10 |= composerStartRestartGroup.changed(j6) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i11 = i6 | (composerStartRestartGroup.changed(j10) ? 4 : 2);
        } else {
            i11 = i6;
        }
        if ((i6 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(j11) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            f7 = f;
            i11 |= composerStartRestartGroup.changed(f7) ? 256 : 128;
        } else {
            f7 = f;
        }
        if ((i6 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
        }
        int i12 = i11;
        if ((i10 & 306783379) == 306783378 && (i12 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-919826268, i10, i12, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:247)");
            }
            final n nVar9 = nVar6;
            final n nVar10 = nVar7;
            final float f9 = f7;
            final n nVar11 = nVar8;
            BasicAlertDialog(aVar, modifier, dialogProperties, ComposableLambdaKt.rememberComposableLambda(-1852840226, true, new n() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i13) {
                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1852840226, i13, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous> (AlertDialog.kt:252)");
                    }
                    final n nVar12 = nVar10;
                    final n nVar13 = nVar9;
                    AlertDialogKt.m1498AlertDialogContent4hvqGtA(ComposableLambdaKt.rememberComposableLambda(1163543932, true, new n() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return r.f317a;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(Composer composer3, int i14) {
                            if ((i14 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1163543932, i14, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous> (AlertDialog.kt:254)");
                            }
                            float f10 = AlertDialogKt.ButtonsMainAxisSpacing;
                            float f11 = AlertDialogKt.ButtonsCrossAxisSpacing;
                            final n nVar14 = nVar12;
                            final n nVar15 = nVar13;
                            AlertDialogKt.m1499AlertDialogFlowRowixp7dh8(f10, f11, ComposableLambdaKt.rememberComposableLambda(1887135077, true, new n() { // from class: androidx.compose.material3.AlertDialogKt.AlertDialogImpl.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // S7.n
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return r.f317a;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(Composer composer4, int i15) {
                                    if ((i15 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1887135077, i15, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:258)");
                                    }
                                    n nVar16 = nVar14;
                                    composer4.startReplaceGroup(1497073862);
                                    if (nVar16 != null) {
                                        nVar16.invoke(composer4, 0);
                                    }
                                    composer4.endReplaceGroup();
                                    nVar15.invoke(composer4, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 438);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), null, nVar11, nVar4, nVar5, shape, j5, f9, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j6, j10, j11, composer2, 6, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i10 & 14) | 3072 | ((i10 >> 3) & 112) | ((i12 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i13) {
                    AlertDialogKt.m1500AlertDialogImplwrnwzgE(aVar, nVar, modifier, nVar2, nVar3, nVar4, nVar5, shape, j5, j6, j10, j11, f, dialogProperties, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BasicAlertDialog(final S7.a r16, androidx.compose.ui.Modifier r17, androidx.compose.ui.window.DialogProperties r18, final S7.n r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.BasicAlertDialog(S7.a, androidx.compose.ui.Modifier, androidx.compose.ui.window.DialogProperties, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getDialogMaxWidth() {
        return DialogMaxWidth;
    }

    public static final float getDialogMinWidth() {
        return DialogMinWidth;
    }
}
