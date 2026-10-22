package androidx.compose.ui;

import S7.k;
import S7.n;
import S7.o;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a@\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\b\u001aR\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\r\u001a\\\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\u000f\u001af\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\u0011\u001a`\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\u0012\"\u0004\u0018\u00010\u000b2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0001¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\u0014\u001a\u001b\u0010\u0019\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001b\u0010\u001a\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u0018\u001a\u001b\u0010\u001b\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u001b\u0010\u001c\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "LC7/r;", "inspectorInfo", "Landroidx/compose/runtime/Composable;", "factory", "composed", "(Landroidx/compose/ui/Modifier;LS7/k;LS7/o;)Landroidx/compose/ui/Modifier;", "", "fullyQualifiedName", "", "key1", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;LS7/k;LS7/o;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;LS7/k;LS7/o;)Landroidx/compose/ui/Modifier;", "key3", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;LS7/k;LS7/o;)Landroidx/compose/ui/Modifier;", "", "keys", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;[Ljava/lang/Object;LS7/k;LS7/o;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composer;", "modifier", "materializeModifier", "(Landroidx/compose/runtime/Composer;Landroidx/compose/ui/Modifier;)Landroidx/compose/ui/Modifier;", "materialize", "materializeImpl", "materializeWithCompositionLocalInjection", "materializeWithCompositionLocalInjectionInternal", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposedModifierKt {
    public static final Modifier composed(Modifier modifier, k kVar, o oVar) {
        return modifier.then(new ComposedModifier(kVar, oVar));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, k kVar, o oVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, kVar, oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier materializeImpl(final Composer composer, Modifier modifier) {
        if (modifier.all(new k() { // from class: androidx.compose.ui.ComposedModifierKt.materializeImpl.1
            @Override // S7.k
            public final Boolean invoke(Modifier.Element element) {
                return Boolean.valueOf(!(element instanceof ComposedModifier));
            }
        })) {
            return modifier;
        }
        composer.startReplaceableGroup(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.INSTANCE, new n() { // from class: androidx.compose.ui.ComposedModifierKt$materializeImpl$result$1
            {
                super(2);
            }

            @Override // S7.n
            public final Modifier invoke(Modifier modifier3, Modifier.Element element) {
                boolean z10 = element instanceof ComposedModifier;
                Modifier modifierMaterializeImpl = element;
                if (z10) {
                    o factory = ((ComposedModifier) element).getFactory();
                    kotlin.jvm.internal.k.d(factory, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                    p.e(3, factory);
                    modifierMaterializeImpl = ComposedModifierKt.materializeImpl(composer, (Modifier) factory.invoke(Modifier.INSTANCE, composer, 0));
                }
                return modifier3.then(modifierMaterializeImpl);
            }
        });
        composer.endReplaceableGroup();
        return modifier2;
    }

    public static final Modifier materializeModifier(Composer composer, Modifier modifier) {
        composer.startReplaceGroup(439770924);
        Modifier modifierMaterializeImpl = materializeImpl(composer, modifier);
        composer.endReplaceGroup();
        return modifierMaterializeImpl;
    }

    public static final Modifier materializeWithCompositionLocalInjectionInternal(Composer composer, Modifier modifier) {
        return modifier == Modifier.INSTANCE ? modifier : materializeModifier(composer, new CompositionLocalMapInjectionElement(composer.getCurrentCompositionLocalMap()).then(modifier));
    }

    public static final Modifier composed(Modifier modifier, String str, Object obj, k kVar, o oVar) {
        return modifier.then(new KeyedComposedModifier1(str, obj, kVar, oVar));
    }

    public static final Modifier composed(Modifier modifier, String str, Object obj, Object obj2, k kVar, o oVar) {
        return modifier.then(new KeyedComposedModifier2(str, obj, obj2, kVar, oVar));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, k kVar, o oVar, int i, Object obj2) {
        if ((i & 4) != 0) {
            kVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, kVar, oVar);
    }

    public static final Modifier composed(Modifier modifier, String str, Object obj, Object obj2, Object obj3, k kVar, o oVar) {
        return modifier.then(new KeyedComposedModifier3(str, obj, obj2, obj3, kVar, oVar));
    }

    public static final Modifier composed(Modifier modifier, String str, Object[] objArr, k kVar, o oVar) {
        return modifier.then(new KeyedComposedModifierN(str, objArr, kVar, oVar));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, k kVar, o oVar, int i, Object obj3) {
        if ((i & 8) != 0) {
            kVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, kVar, oVar);
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Object obj3, k kVar, o oVar, int i, Object obj4) {
        if ((i & 16) != 0) {
            kVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, obj3, kVar, oVar);
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object[] objArr, k kVar, o oVar, int i, Object obj) {
        if ((i & 4) != 0) {
            kVar = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, objArr, kVar, oVar);
    }
}
