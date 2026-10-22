package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.app.Dialog;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012<\u0010\u0004\u001a8\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005j\u0002`\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J?\u0010\u0018\u001a8\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005j\u0002`\rHÆ\u0003JS\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032>\b\u0002\u0010\u0004\u001a8\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005j\u0002`\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001RP\u0010\u0004\u001a8\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005j\u0002`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/KeepDialogBtnConfig;", "", "text", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function2;", "Landroid/app/Dialog;", "Lkotlin/ParameterName;", "name", "dialog", "Lorg/json/JSONObject;", "data", "", "Lcom/android/ttcjpaysdk/base/ui/dialog/LynxDialogOnEvent;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "setOnClick", "(Lkotlin/jvm/functions/Function2;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KeepDialogBtnConfig {
    private Function2<? super Dialog, ? super JSONObject, Unit> onClick;
    private String text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KeepDialogBtnConfig copy$default(KeepDialogBtnConfig r100, String r101, Function2 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.onClick;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.text;
    }

    public final Function2<Dialog, JSONObject, Unit> component2() {
        return this.onClick;
    }

    public final KeepDialogBtnConfig copy(String r100, Function2<? super Dialog, ? super JSONObject, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        return new KeepDialogBtnConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof KeepDialogBtnConfig) == true) goto L8;
        return false;
    L8:
        KeepDialogBtnConfig r101 = (KeepDialogBtnConfig) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.onClick, r101.onClick) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.onClick.hashCode();
    }

    public String toString() {
        return "KeepDialogBtnConfig(text=" + this.text + ", onClick=" + this.onClick + ')';
    }

    public final Function2<Dialog, JSONObject, Unit> getOnClick() {
        return this.onClick;
    }

    public final String getText() {
        return this.text;
    }

    public final void setOnClick(Function2<? super Dialog, ? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.onClick = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public KeepDialogBtnConfig(String r100, Function2<? super Dialog, ? super JSONObject, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.text = r100;
        this.onClick = r101;
    }
}
