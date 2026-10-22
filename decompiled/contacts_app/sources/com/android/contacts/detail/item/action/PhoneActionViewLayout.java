package com.android.contacts.detail.item.action;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhoneActionViewLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/android/contacts/detail/item/action/PhoneActionViewLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "buttonActionCall", "Lcom/android/contacts/detail/item/action/PhoneActionView;", "getButtonActionCall", "()Lcom/android/contacts/detail/item/action/PhoneActionView;", "buttonActionCall$delegate", "Lkotlin/Lazy;", "buttonActionMessage", "getButtonActionMessage", "buttonActionMessage$delegate", "buttonActionVideo", "getButtonActionVideo", "buttonActionVideo$delegate", "setEnabled", "", "enabled", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhoneActionViewLayout extends LinearLayout {
    private final Lazy buttonActionCall$delegate;
    private final Lazy buttonActionMessage$delegate;
    private final Lazy buttonActionVideo$delegate;

    public PhoneActionViewLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.buttonActionCall$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionCall$2(this));
        this.buttonActionVideo$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionVideo$2(this));
        this.buttonActionMessage$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionMessage$2(this));
    }

    public PhoneActionViewLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.buttonActionCall$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionCall$2(this));
        this.buttonActionVideo$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionVideo$2(this));
        this.buttonActionMessage$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionMessage$2(this));
    }

    public PhoneActionViewLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.buttonActionCall$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionCall$2(this));
        this.buttonActionVideo$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionVideo$2(this));
        this.buttonActionMessage$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionMessage$2(this));
    }

    public PhoneActionViewLayout(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, r5);
        this.buttonActionCall$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionCall$2(this));
        this.buttonActionVideo$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionVideo$2(this));
        this.buttonActionMessage$delegate = LazyKt.lazy(new PhoneActionViewLayout$buttonActionMessage$2(this));
    }

    public final PhoneActionView getButtonActionCall() {
        return (PhoneActionView) this.buttonActionCall$delegate.getValue();
    }

    public final PhoneActionView getButtonActionVideo() {
        return (PhoneActionView) this.buttonActionVideo$delegate.getValue();
    }

    public final PhoneActionView getButtonActionMessage() {
        return (PhoneActionView) this.buttonActionMessage$delegate.getValue();
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        PhoneActionView r0 = getButtonActionCall();
        if (r0 == null) goto L5;
        r0.setEnableState(r2);
    L5:
        PhoneActionView r1 = getButtonActionVideo();
        if (r1 == null) goto L8;
        r1.setEnableState(r2);
    L8:
        PhoneActionView r3 = getButtonActionMessage();
        if (r3 == null) goto L12;
        r3.setEnableState(r2);
        return;
    }
}
