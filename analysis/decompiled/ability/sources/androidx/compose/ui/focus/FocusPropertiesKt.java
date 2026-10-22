package androidx.compose.ui.focus;

import C7.r;
import S7.k;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0000*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\u0007*\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "Landroidx/compose/ui/focus/FocusRequester;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "LC7/r;", "toUsingEnterExitScope", "(LS7/k;)LS7/k;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusProperties;", "scope", "focusProperties", "(Landroidx/compose/ui/Modifier;LS7/k;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusPropertiesKt {
    public static final Modifier focusProperties(Modifier modifier, k kVar) {
        return modifier.then(new FocusPropertiesElement(new FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(kVar)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k toUsingEnterExitScope(final k kVar) {
        return new k() { // from class: androidx.compose.ui.focus.FocusPropertiesKt.toUsingEnterExitScope.1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusEnterExitScope) obj);
                return r.f317a;
            }

            public final void invoke(FocusEnterExitScope focusEnterExitScope) {
                FocusRequester focusRequester = (FocusRequester) kVar.invoke(FocusDirection.m3768boximpl(focusEnterExitScope.getRequestedFocusDirection()));
                FocusRequester.Companion companion = FocusRequester.INSTANCE;
                if (focusRequester == companion.getCancel()) {
                    focusEnterExitScope.cancelFocusChange();
                } else if (focusRequester != companion.getDefault()) {
                    FocusRequester.m3800requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                }
            }
        };
    }
}
