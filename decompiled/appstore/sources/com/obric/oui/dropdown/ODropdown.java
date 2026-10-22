package com.obric.oui.dropdown;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\r"}, d2 = {"Lcom/obric/oui/dropdown/ODropdown;", "", "start", "", "caller", "Lcom/obric/oui/dropdown/ODropdownTrigger;", "activity", "Landroid/app/Activity;", "onDismiss", "Lkotlin/Function0;", "onTextChanged", "Lkotlin/Function1;", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ODropdown {

    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ODropdown r10, final ODropdownTrigger r11, Activity r12, Function0 r13, Function1 r14, int r15, Object r16) {
            if (r16 != null) goto L9;
            if ((r15 & 4) == 0) goto L6;
            r13 = new AnonymousClass1(r11);
        L6:
            r10.start(r11, r12, r13, r14);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    void start(@NotNull ODropdownTrigger r10, @NotNull Activity r11, @NotNull Function0<Unit> r12, @NotNull Function1<? super CharSequence, Unit> r13);
}
