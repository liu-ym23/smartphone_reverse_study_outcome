package com.bytedance.android.livesdkapi.interact;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/interact/InputDraft;", "", "input", "", "(Ljava/lang/CharSequence;)V", "getInput", "()Ljava/lang/CharSequence;", "setInput", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputDraft {
    private CharSequence input;

    public static /* synthetic */ InputDraft copy$default(InputDraft r100, CharSequence r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.input;
    L6:
        return r100.copy(r101);
    }

    public final CharSequence component1() {
        return this.input;
    }

    public final InputDraft copy(CharSequence r100) {
        return new InputDraft(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InputDraft) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.input, ((InputDraft) r100).input) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        CharSequence r100 = this.input;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "InputDraft(input=" + this.input + ")";
    }

    public final CharSequence getInput() {
        return this.input;
    }

    public InputDraft(CharSequence r100) {
        this.input = r100;
    }

    public final void setInput(CharSequence r100) {
        this.input = r100;
    }
}
