package com.google.crypto.tink.internal;

import g5.f;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import javax.annotation.Nullable;
import m7.g;
import m7.i;
import m7.j;
import m7.l;
import m7.n;
import u7.a;
import u7.b;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JsonParser {
    private static final JsonElementTypeAdapter JSON_ELEMENT = new JsonElementTypeAdapter(null);

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.internal.JsonParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[b.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[6] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[7] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[8] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class LazilyParsedNumber extends Number {
        private final String value;

        public LazilyParsedNumber(String str) {
            this.value = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        private Object writeReplace() throws NotSerializableException {
            throw new NotSerializableException("serialization is not supported");
        }

        @Override // java.lang.Number
        public double doubleValue() {
            return Double.parseDouble(this.value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LazilyParsedNumber) {
                return this.value.equals(((LazilyParsedNumber) obj).value);
            }
            return false;
        }

        @Override // java.lang.Number
        public float floatValue() {
            return Float.parseFloat(this.value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        @Override // java.lang.Number
        public int intValue() {
            try {
                try {
                    return Integer.parseInt(this.value);
                } catch (NumberFormatException unused) {
                    return (int) Long.parseLong(this.value);
                }
            } catch (NumberFormatException unused2) {
                return new BigDecimal(this.value).intValue();
            }
        }

        @Override // java.lang.Number
        public long longValue() {
            try {
                return Long.parseLong(this.value);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.value).longValue();
            }
        }

        public String toString() {
            return this.value;
        }
    }

    private JsonParser() {
    }

    public static long getParsedNumberAsLongOrThrow(g gVar) {
        if (gVar.h() instanceof LazilyParsedNumber) {
            return Long.parseLong(gVar.h().toString());
        }
        f.s("does not contain a parsed number.");
        return 0L;
    }

    public static boolean isValidString(String str) {
        int length = str.length();
        int i = 0;
        while (i != length) {
            char cCharAt = str.charAt(i);
            int i3 = i + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i = i3;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i3 == length || !Character.isLowSurrogate(str.charAt(i3))) {
                    return false;
                }
                i += 2;
            }
        }
        return true;
    }

    public static g parse(String str) throws IOException {
        try {
            a aVar = new a(new StringReader(str));
            aVar.f14161s = 2;
            return JSON_ELEMENT.read(aVar);
        } catch (NumberFormatException e10) {
            throw new IOException(e10);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class JsonElementTypeAdapter extends n {
        private static final int RECURSION_LIMIT = 100;

        private JsonElementTypeAdapter() {
        }

        private g readTerminal(a aVar, b bVar) throws IOException {
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 5) {
                String strW = aVar.W();
                if (JsonParser.isValidString(strW)) {
                    return new l(strW);
                }
                od.f.l("illegal characters in string");
                return null;
            }
            if (iOrdinal == 6) {
                LazilyParsedNumber lazilyParsedNumber = new LazilyParsedNumber(aVar.W());
                l lVar = new l();
                lVar.f8267c = lazilyParsedNumber;
                return lVar;
            }
            if (iOrdinal == 7) {
                Boolean boolValueOf = Boolean.valueOf(aVar.O());
                l lVar2 = new l();
                lVar2.f8267c = boolValueOf;
                return lVar2;
            }
            if (iOrdinal == 8) {
                aVar.U();
                return i.f8265c;
            }
            f.r(bVar, "Unexpected token: ");
            return null;
        }

        @Nullable
        private g tryBeginNesting(a aVar, b bVar) {
            int iOrdinal = bVar.ordinal();
            if (iOrdinal == 0) {
                aVar.d();
                return new m7.f();
            }
            if (iOrdinal != 2) {
                return null;
            }
            aVar.e();
            return new j();
        }

        @Override // m7.n
        public g read(a aVar) throws IOException {
            String strS;
            b bVarY = aVar.Y();
            g gVarTryBeginNesting = tryBeginNesting(aVar, bVarY);
            if (gVarTryBeginNesting == null) {
                return readTerminal(aVar, bVarY);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.H()) {
                    if (gVarTryBeginNesting instanceof j) {
                        strS = aVar.S();
                        if (!JsonParser.isValidString(strS)) {
                            od.f.l("illegal characters in string");
                            return null;
                        }
                    } else {
                        strS = null;
                    }
                    b bVarY2 = aVar.Y();
                    g gVarTryBeginNesting2 = tryBeginNesting(aVar, bVarY2);
                    boolean z10 = gVarTryBeginNesting2 != null;
                    if (gVarTryBeginNesting2 == null) {
                        gVarTryBeginNesting2 = readTerminal(aVar, bVarY2);
                    }
                    if (gVarTryBeginNesting instanceof m7.f) {
                        ((m7.f) gVarTryBeginNesting).k(gVarTryBeginNesting2);
                    } else {
                        j jVar = (j) gVarTryBeginNesting;
                        if (jVar.f8266c.containsKey(strS)) {
                            od.f.l(c.b("duplicate key: ", strS));
                            return null;
                        }
                        jVar.j(strS, gVarTryBeginNesting2);
                    }
                    if (z10) {
                        arrayDeque.addLast(gVarTryBeginNesting);
                        if (arrayDeque.size() > 100) {
                            od.f.l("too many recursions");
                            return null;
                        }
                        gVarTryBeginNesting = gVarTryBeginNesting2;
                    } else {
                        continue;
                    }
                } else {
                    if (gVarTryBeginNesting instanceof m7.f) {
                        aVar.n();
                    } else {
                        aVar.o();
                    }
                    if (arrayDeque.isEmpty()) {
                        return gVarTryBeginNesting;
                    }
                    gVarTryBeginNesting = (g) arrayDeque.removeLast();
                }
            }
        }

        @Override // m7.n
        public void write(u7.c cVar, g gVar) {
            throw new UnsupportedOperationException("write is not supported");
        }

        public /* synthetic */ JsonElementTypeAdapter(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
