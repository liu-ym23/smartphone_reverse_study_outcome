package io.ktor.utils.io;

import Z8.C1173v;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@InternalAPI
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0018"}, d2 = {"Lio/ktor/utils/io/LineEndingMode;", "", "", "mode", "constructor-impl", "(I)I", "other", "", "contains-lTjpP64", "(II)Z", "contains", "plus-1Ter-O4", "(II)I", "plus", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "Companion", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LineEndingMode {
    private static final int Any;
    private static final int CR;
    private static final int CRLF;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int LF;
    private static final List<LineEndingMode> values;
    private final int mode;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/utils/io/LineEndingMode$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/LineEndingMode;", "CR", "I", "getCR-f0jXZW8", "()I", "LF", "getLF-f0jXZW8", "CRLF", "getCRLF-f0jXZW8", "Any", "getAny-f0jXZW8", "", "values", "Ljava/util/List;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* renamed from: getAny-f0jXZW8, reason: not valid java name */
        public final int m211getAnyf0jXZW8() {
            return LineEndingMode.Any;
        }

        /* renamed from: getCR-f0jXZW8, reason: not valid java name */
        public final int m212getCRf0jXZW8() {
            return LineEndingMode.CR;
        }

        /* renamed from: getCRLF-f0jXZW8, reason: not valid java name */
        public final int m213getCRLFf0jXZW8() {
            return LineEndingMode.CRLF;
        }

        /* renamed from: getLF-f0jXZW8, reason: not valid java name */
        public final int m214getLFf0jXZW8() {
            return LineEndingMode.LF;
        }

        private Companion() {
        }
    }

    static {
        int iM203constructorimpl = m203constructorimpl(1);
        CR = iM203constructorimpl;
        int iM203constructorimpl2 = m203constructorimpl(2);
        LF = iM203constructorimpl2;
        int iM203constructorimpl3 = m203constructorimpl(4);
        CRLF = iM203constructorimpl3;
        Any = m203constructorimpl(7);
        values = C1173v.p(m202boximpl(iM203constructorimpl), m202boximpl(iM203constructorimpl2), m202boximpl(iM203constructorimpl3));
    }

    private /* synthetic */ LineEndingMode(int i10) {
        this.mode = i10;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineEndingMode m202boximpl(int i10) {
        return new LineEndingMode(i10);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m203constructorimpl(int i10) {
        return i10;
    }

    /* renamed from: contains-lTjpP64, reason: not valid java name */
    public static final boolean m204containslTjpP64(int i10, int i11) {
        return (i11 | i10) == i10;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m205equalsimpl(int i10, Object obj) {
        return (obj instanceof LineEndingMode) && i10 == ((LineEndingMode) obj).getMode();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m206equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m207hashCodeimpl(int i10) {
        return Integer.hashCode(i10);
    }

    /* renamed from: plus-1Ter-O4, reason: not valid java name */
    public static final int m208plus1TerO4(int i10, int i11) {
        return m203constructorimpl(i10 | i11);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m209toStringimpl(int i10) {
        if (m206equalsimpl0(i10, CR)) {
            return "CR";
        }
        if (m206equalsimpl0(i10, LF)) {
            return "LF";
        }
        if (m206equalsimpl0(i10, CRLF)) {
            return "CRLF";
        }
        List<LineEndingMode> list = values;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (m204containslTjpP64(i10, ((LineEndingMode) obj).getMode())) {
                arrayList.add(obj);
            }
        }
        return arrayList.toString();
    }

    public boolean equals(Object other) {
        return m205equalsimpl(this.mode, other);
    }

    public int hashCode() {
        return m207hashCodeimpl(this.mode);
    }

    public String toString() {
        return m209toStringimpl(this.mode);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getMode() {
        return this.mode;
    }
}
