package com.obric.oui.dialog.v2.misc;

import com.obric.common.oui.R$id;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OSimpleFormDialogModal$positiveButton$2 extends Lambda implements Function0<OButton> {
    final /* synthetic */ OSimpleFormDialogModal this$0;

    public OSimpleFormDialogModal$positiveButton$2(OSimpleFormDialogModal r10) {
        this.this$0 = r10;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final OButton invoke() {
        return (OButton) this.this$0.findViewById(R$id.actionPositive);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ OButton invoke() {
        return invoke();
    }
}
