package androidx.compose.material3;

import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aß\u0001\u0010\u0018\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00032\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00032\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00032\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0002\b\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "onDismissRequest", "Landroidx/compose/runtime/Composable;", "confirmButton", "Landroidx/compose/ui/Modifier;", "modifier", "dismissButton", "icon", "title", "text", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "containerColor", "iconContentColor", "titleContentColor", "textContentColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "Landroidx/compose/ui/window/DialogProperties;", "properties", "AlertDialog-Oix01E0", "(LS7/a;LS7/n;Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/n;LS7/n;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "AlertDialog", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidAlertDialog_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1503AlertDialogOix01E0(final S7.a r31, final S7.n r32, androidx.compose.ui.Modifier r33, S7.n r34, S7.n r35, S7.n r36, S7.n r37, androidx.compose.ui.graphics.Shape r38, long r39, long r41, long r43, long r45, float r47, androidx.compose.ui.window.DialogProperties r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 801
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidAlertDialog_androidKt.m1503AlertDialogOix01E0(S7.a, S7.n, androidx.compose.ui.Modifier, S7.n, S7.n, S7.n, S7.n, androidx.compose.ui.graphics.Shape, long, long, long, long, float, androidx.compose.ui.window.DialogProperties, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
