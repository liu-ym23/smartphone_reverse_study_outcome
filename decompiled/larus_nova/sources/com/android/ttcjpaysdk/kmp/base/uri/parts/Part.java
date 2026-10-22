package com.android.ttcjpaysdk.kmp.base.uri.parts;

import com.android.ttcjpaysdk.kmp.base.uri.NotCachedHolder;
import com.android.ttcjpaysdk.kmp.base.uri.UriCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0011\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u001d\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/AbstractPart;", "encoded", "", "decoded", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "isEmpty", "", "()Z", "encode", "EmptyPart", "Companion", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Part extends AbstractPart {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Part EMPTY = null;
    private static final Part NULL = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part$Companion;", "", "<init>", "()V", "NULL", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;", "getNULL", "()Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;", "EMPTY", "getEMPTY", "nonNull", "part", "fromEncoded", "encoded", "", "fromDecoded", "decoded", "from", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Part getEMPTY() {
            return Part.access$getEMPTY$cp();
        }

        public final Part getNULL() {
            return Part.access$getNULL$cp();
        }

        public final Part fromDecoded(String r100) {
            return from(NotCachedHolder.INSTANCE.getNotCached(), r100);
        }

        public final Part fromEncoded(String r100) {
            return from(r100, NotCachedHolder.INSTANCE.getNotCached());
        }

        public final Part nonNull(Part r100) {
            if (r100 == null) goto L4;
            return r100;
        L4:
            return getNULL();
        }

        public final Part from(String r100, String r101) {
            if (r100 == null) goto L20;
            boolean r102 = true;
            if (r100.length() != 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == true) goto L21;
            if (r101 != null) goto L13;
            return getNULL();
        L13:
            if (r101.length() == 0) goto L16;
            r102 = false;
        L16:
            if (r102 == false) goto L19;
            return getEMPTY();
        L19:
            return new Part(r100, r101);
        L21:
            return getEMPTY();
        L7:
            r103 = false;
            goto L8
        L20:
            return getNULL();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part$EmptyPart;", "Lcom/android/ttcjpaysdk/kmp/base/uri/parts/Part;", "value", "", "<init>", "(Ljava/lang/String;)V", "isEmpty", "", "()Z", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EmptyPart extends Part {
        private final boolean isEmpty;

        @Override // com.android.ttcjpaysdk.kmp.base.uri.parts.Part
        public boolean isEmpty() {
            return this.isEmpty;
        }

        public EmptyPart(String r100) {
            super(r100, r100);
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L13;
            this.isEmpty = true;
            return;
        L13:
            throw new IllegalArgumentException(("Expected empty value, got: " + r100).toString());
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }
    }

    public boolean isEmpty() {
        return false;
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        NULL = new EmptyPart(null);
        EMPTY = new EmptyPart("");
    }

    public static final /* synthetic */ Part access$getEMPTY$cp() {
        return EMPTY;
    }

    public static final /* synthetic */ Part access$getNULL$cp() {
        return NULL;
    }

    @Override // com.android.ttcjpaysdk.kmp.base.uri.parts.AbstractPart
    public String encode(String r100) {
        return UriCodec.INSTANCE.encodeOrNull(r100);
    }

    public Part(String r100, String r101) {
        super(r100, r101);
    }
}
