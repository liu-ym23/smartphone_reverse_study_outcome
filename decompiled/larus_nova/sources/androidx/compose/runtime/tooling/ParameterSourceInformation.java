package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "", "sortedIndex", "", "name", "", "inlineClass", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getSortedIndex", "()I", "getName", "()Ljava/lang/String;", "getInlineClass", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParameterSourceInformation {
    public static final int $stable = 0;
    private final String inlineClass;
    private final String name;
    private final int sortedIndex;

    public final String getInlineClass() {
        return this.inlineClass;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSortedIndex() {
        return this.sortedIndex;
    }

    public ParameterSourceInformation(int r100, String r101, String r102) {
        this.sortedIndex = r100;
        this.name = r101;
        this.inlineClass = r102;
    }

    public /* synthetic */ ParameterSourceInformation(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
