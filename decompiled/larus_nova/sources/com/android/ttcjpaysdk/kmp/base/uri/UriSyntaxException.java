package com.android.ttcjpaysdk.kmp.base.uri;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/UriSyntaxException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "input", "", "internalReason", "index", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getInput", "()Ljava/lang/String;", "getIndex", "()I", "reason", "getReason", "message", "getMessage", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UriSyntaxException extends Exception {
    public static final int $stable = 8;
    private final int index;
    private final String input;
    private final String internalReason;

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.internalReason);
        if (this.index <= (-1)) goto L5;
        r100.append(" at index ");
        r100.append(this.index);
    L5:
        r100.append(": ");
        r100.append(this.input);
        return r100.toString();
    }

    public final String getReason() {
        return getMessage();
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getInput() {
        return this.input;
    }

    public UriSyntaxException(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "internalReason");
        super(r101);
        this.input = r100;
        this.internalReason = r101;
        this.index = r102;
        if (r102 < (-1)) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r103 = false;
        goto L6
    }

    public /* synthetic */ UriSyntaxException(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = -1;
    L5:
        this(r100, r101, r102);
    }
}
