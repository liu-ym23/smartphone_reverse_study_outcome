package com.obric.oui.constraintlayout.core.parser;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes3.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String r1, CLElement r2) {
        super(r1);
        this.mReason = r1;
        if (r2 == null) goto L5;
        this.mElementClass = r2.getStrClass();
        this.mLineNumber = r2.getLine();
        return;
    L5:
        this.mElementClass = EnvironmentCompat.MEDIA_UNKNOWN;
        this.mLineNumber = 0;
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
