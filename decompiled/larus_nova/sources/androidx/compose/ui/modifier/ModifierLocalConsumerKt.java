package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007¨\u0006\u0007"}, d2 = {"modifierLocalConsumer", "Landroidx/compose/ui/Modifier;", "consumer", "Lkotlin/Function1;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModifierLocalConsumerKt {
    public static final Modifier modifierLocalConsumer(Modifier r100, final Function1<? super ModifierLocalReadScope, Unit> r101) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r102 = new ModifierLocalConsumerKt$modifierLocalConsumer$$inlined$debugInspectorInfo$1(r101);
    L7:
        return r100.then(new ModifierLocalConsumerImpl(r101, r102));
    L5:
        r102 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }
}
