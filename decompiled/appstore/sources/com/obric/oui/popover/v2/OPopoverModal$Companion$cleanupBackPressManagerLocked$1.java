package com.obric.oui.popover.v2;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "ref", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/popover/v2/OPopoverModal;", "invoke", "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OPopoverModal$Companion$cleanupBackPressManagerLocked$1 extends Lambda implements Function1<WeakReference<OPopoverModal>, Boolean> {
    public static final OPopoverModal$Companion$cleanupBackPressManagerLocked$1 INSTANCE = null;

    static {
        INSTANCE = new OPopoverModal$Companion$cleanupBackPressManagerLocked$1();
    }

    public OPopoverModal$Companion$cleanupBackPressManagerLocked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<OPopoverModal> r10) {
        return invoke2(r10);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@NotNull WeakReference<OPopoverModal> r10) {
        q.g(r10, "ref");
        OPopoverModal r11 = r10.get();
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        return Boolean.valueOf(r12);
    L5:
        if (r11.c() == false) goto L8;
        r12 = false;
        goto L10
    }
}
