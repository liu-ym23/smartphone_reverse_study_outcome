package androidx.compose.ui.platform;

import C7.r;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a2\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a>\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0014\b\b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0000H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\f\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\f\u0010\r\"#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "LC7/r;", "definitions", "debugInspectorInfo", "(LS7/k;)LS7/k;", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "factory", "inspectable", "(Landroidx/compose/ui/Modifier;LS7/k;LS7/k;)Landroidx/compose/ui/Modifier;", "wrapped", "inspectableWrapper", "(Landroidx/compose/ui/Modifier;LS7/k;Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "NoInspectorInfo", "LS7/k;", "getNoInspectorInfo", "()LS7/k;", "", "isDebugInspectorInfoEnabled", "Z", "()Z", "setDebugInspectorInfoEnabled", "(Z)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InspectableValueKt {
    private static final S7.k NoInspectorInfo = new S7.k() { // from class: androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1
        public final void invoke(InspectorInfo inspectorInfo) {
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return r.f317a;
        }
    };
    private static boolean isDebugInspectorInfoEnabled;

    public static final S7.k debugInspectorInfo(final S7.k kVar) {
        return isDebugInspectorInfoEnabled() ? new S7.k() { // from class: androidx.compose.ui.platform.InspectableValueKt.debugInspectorInfo.1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                kVar.invoke(inspectorInfo);
            }
        } : getNoInspectorInfo();
    }

    public static final S7.k getNoInspectorInfo() {
        return NoInspectorInfo;
    }

    @C7.c
    public static final Modifier inspectable(Modifier modifier, S7.k kVar, S7.k kVar2) {
        return inspectableWrapper(modifier, kVar, (Modifier) kVar2.invoke(Modifier.INSTANCE));
    }

    public static final Modifier inspectableWrapper(Modifier modifier, S7.k kVar, Modifier modifier2) {
        InspectableModifier inspectableModifier = new InspectableModifier(kVar);
        return modifier.then(inspectableModifier).then(modifier2).then(inspectableModifier.getEnd());
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return isDebugInspectorInfoEnabled;
    }

    public static final void setDebugInspectorInfoEnabled(boolean z10) {
        isDebugInspectorInfoEnabled = z10;
    }
}
