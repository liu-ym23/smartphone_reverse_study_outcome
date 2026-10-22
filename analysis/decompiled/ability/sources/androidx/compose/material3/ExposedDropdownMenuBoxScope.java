package androidx.compose.material3;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u0093\u0001\u0010%\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u001f¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0013\u0010\u000b\u001a\u00020\u0004*\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010&J\u009d\u0001\u0010%\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u001f¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)JR\u0010%\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u001f¢\u0006\u0002\b!H\u0007¢\u0006\u0004\b%\u0010*R\u001a\u0010-\u001a\u00020\u00058 X \u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0001\u0001.\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/MenuAnchorType;", "type", "", "enabled", "menuAnchor-fsE2BvY", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "menuAnchor", "matchTextFieldWidth", "exposedDropdownSize", "(Landroidx/compose/ui/Modifier;Z)Landroidx/compose/ui/Modifier;", "expanded", "Lkotlin/Function0;", "LC7/r;", "onDismissRequest", "modifier", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Landroidx/compose/ui/graphics/Shape;", "shape", "Landroidx/compose/ui/graphics/Color;", "containerColor", "Landroidx/compose/ui/unit/Dp;", "tonalElevation", "shadowElevation", "Landroidx/compose/foundation/BorderStroke;", "border", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "content", "ExposedDropdownMenu-vNxi1II", "(ZLS7/a;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;LS7/o;Landroidx/compose/runtime/Composer;III)V", "ExposedDropdownMenu", "(Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "focusable", "ExposedDropdownMenu-kbRbctU", "(ZLS7/a;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;LS7/o;Landroidx/compose/runtime/Composer;III)V", "(ZLS7/a;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;LS7/o;Landroidx/compose/runtime/Composer;II)V", "getAnchorType-Mg6Rgbw$material3_release", "()Ljava/lang/String;", "anchorType", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable = 0;

    public /* synthetic */ ExposedDropdownMenuBoxScope(e eVar) {
        this();
    }

    public static /* synthetic */ Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        }
        if ((i & 1) != 0) {
            z10 = true;
        }
        return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier, z10);
    }

    /* renamed from: menuAnchor-fsE2BvY$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1833menuAnchorfsE2BvY$default(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier, String str, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-fsE2BvY");
        }
        if ((i & 2) != 0) {
            z10 = true;
        }
        return exposedDropdownMenuBoxScope.mo1837menuAnchorfsE2BvY(modifier, str, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0149  */
    @C7.c
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ void ExposedDropdownMenu(final boolean r26, final S7.a r27, androidx.compose.ui.Modifier r28, androidx.compose.foundation.ScrollState r29, final S7.o r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu(boolean, S7.a, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    @C7.c
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: ExposedDropdownMenu-kbRbctU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1834ExposedDropdownMenukbRbctU(final boolean r35, final S7.a r36, androidx.compose.ui.Modifier r37, androidx.compose.foundation.ScrollState r38, boolean r39, boolean r40, androidx.compose.ui.graphics.Shape r41, long r42, float r44, float r45, androidx.compose.foundation.BorderStroke r46, final S7.o r47, androidx.compose.runtime.Composer r48, final int r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m1834ExposedDropdownMenukbRbctU(boolean, S7.a, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, S7.o, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f6  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: ExposedDropdownMenu-vNxi1II, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1835ExposedDropdownMenuvNxi1II(final boolean r37, final S7.a r38, androidx.compose.ui.Modifier r39, androidx.compose.foundation.ScrollState r40, boolean r41, androidx.compose.ui.graphics.Shape r42, long r43, float r45, float r46, androidx.compose.foundation.BorderStroke r47, final S7.o r48, androidx.compose.runtime.Composer r49, final int r50, final int r51, final int r52) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuBoxScope.m1835ExposedDropdownMenuvNxi1II(boolean, S7.a, androidx.compose.ui.Modifier, androidx.compose.foundation.ScrollState, boolean, androidx.compose.ui.graphics.Shape, long, float, float, androidx.compose.foundation.BorderStroke, S7.o, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z10);

    /* renamed from: getAnchorType-Mg6Rgbw$material3_release, reason: not valid java name */
    public abstract String mo1836getAnchorTypeMg6Rgbw$material3_release();

    @C7.c
    public final Modifier menuAnchor(Modifier modifier) {
        return m1833menuAnchorfsE2BvY$default(this, modifier, MenuAnchorType.INSTANCE.m1984getPrimaryNotEditableMg6Rgbw(), false, 2, null);
    }

    /* renamed from: menuAnchor-fsE2BvY, reason: not valid java name */
    public abstract Modifier mo1837menuAnchorfsE2BvY(Modifier modifier, String str, boolean z10);

    private ExposedDropdownMenuBoxScope() {
    }
}
