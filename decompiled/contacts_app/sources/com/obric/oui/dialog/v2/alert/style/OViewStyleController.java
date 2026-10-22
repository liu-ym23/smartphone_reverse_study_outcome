package com.obric.oui.dialog.v2.alert.style;

import android.content.Context;
import com.obric.oui.dialog.base.AbstractDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StyleController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B(\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/dialog/v2/alert/style/OViewStyleController;", "Lcom/obric/oui/dialog/v2/alert/style/StyleController;", "body", "Lkotlin/Function1;", "Lcom/obric/oui/dialog/v2/alert/style/DialogContainer;", "Lkotlin/ParameterName;", "name", "dialogContainer", "", "(Lkotlin/jvm/functions/Function1;)V", "attachToDialog", "dialog", "Lcom/obric/oui/dialog/base/AbstractDialog;", "attachToParent", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OViewStyleController implements StyleController {
    private final Function1<DialogContainer, Unit> body;

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToDialog(AbstractDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OViewStyleController(Function1<? super DialogContainer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "body");
        this.body = r2;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToParent(Context r2, DialogContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dialogContainer");
        this.body.invoke(r3);
    }
}
