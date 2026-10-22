package io.ktor.http.cio.internals;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lio/ktor/http/cio/internals/MutableRange;", "", "", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "I", "getStart", "()I", "setStart", "(I)V", "getEnd", "setEnd", "ktor-http-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MutableRange {
    private int end;
    private int start;

    public MutableRange(int i10, int i11) {
        this.start = i10;
        this.end = i11;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getStart() {
        return this.start;
    }

    public final void setEnd(int i10) {
        this.end = i10;
    }

    public final void setStart(int i10) {
        this.start = i10;
    }

    public String toString() {
        return "MutableRange(start=" + this.start + ", end=" + this.end + ')';
    }
}
