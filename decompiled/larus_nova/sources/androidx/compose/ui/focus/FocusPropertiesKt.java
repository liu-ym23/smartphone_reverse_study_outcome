package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001a#\u0010\u0007\u001a\u00020\b*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¨\u0006\u000b"}, d2 = {"toUsingEnterExitScope", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/focus/FocusDirection;", "Landroidx/compose/ui/focus/FocusRequester;", "focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FocusPropertiesKt {
    public static final /* synthetic */ Function1 access$toUsingEnterExitScope(Function1 r100) {
        return toUsingEnterExitScope(r100);
    }

    private static final Function1<FocusEnterExitScope, Unit> toUsingEnterExitScope(final Function1<? super FocusDirection, FocusRequester> r100) {
        return new AnonymousClass1(r100);
    }

    public static final Modifier focusProperties(Modifier r100, Function1<? super FocusProperties, Unit> r101) {
        return r100.then(new FocusPropertiesElement(new FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(r101)));
    }
}
