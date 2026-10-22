package com.stepos.ailauncher.sheet;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/sheet/x0;", "", "", "clearNotFocusable", "clearNotTouchable", "enableInputSink", "<init>", "(ZZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_APIKEY, "()Z", Const.INTENT_KEY_PKGNAME, "c", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.x0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WindowFocusRestoreAction {
    private final boolean clearNotFocusable;
    private final boolean clearNotTouchable;
    private final boolean enableInputSink;

    public WindowFocusRestoreAction(boolean z10, boolean z11, boolean z12) {
        this.clearNotFocusable = z10;
        this.clearNotTouchable = z11;
        this.enableInputSink = z12;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getClearNotFocusable() {
        return this.clearNotFocusable;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getClearNotTouchable() {
        return this.clearNotTouchable;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnableInputSink() {
        return this.enableInputSink;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WindowFocusRestoreAction)) {
            return false;
        }
        WindowFocusRestoreAction windowFocusRestoreAction = (WindowFocusRestoreAction) other;
        return this.clearNotFocusable == windowFocusRestoreAction.clearNotFocusable && this.clearNotTouchable == windowFocusRestoreAction.clearNotTouchable && this.enableInputSink == windowFocusRestoreAction.enableInputSink;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.clearNotFocusable) * 31) + Boolean.hashCode(this.clearNotTouchable)) * 31) + Boolean.hashCode(this.enableInputSink);
    }

    public String toString() {
        return "WindowFocusRestoreAction(clearNotFocusable=" + this.clearNotFocusable + ", clearNotTouchable=" + this.clearNotTouchable + ", enableInputSink=" + this.enableInputSink + ")";
    }
}
