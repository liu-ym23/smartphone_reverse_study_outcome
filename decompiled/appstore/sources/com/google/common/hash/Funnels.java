package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public final class Funnels {

    public static final enum ByteArrayFunnel extends Enum<ByteArrayFunnel> implements Funnel<byte[]> {
        private static final /* synthetic */ ByteArrayFunnel[] $VALUES = null;
        public static final ByteArrayFunnel INSTANCE = null;

        static {
            ByteArrayFunnel r10 = new ByteArrayFunnel("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new ByteArrayFunnel[]{r10};
        }

        private ByteArrayFunnel(String r10, int r11) {
            super(r10, r11);
        }

        public static ByteArrayFunnel valueOf(String r10) {
            return (ByteArrayFunnel) Enum.valueOf(ByteArrayFunnel.class, r10);
        }

        public static ByteArrayFunnel[] values() {
            return (ByteArrayFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(byte[] r10, PrimitiveSink r11) {
            funnel2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(byte[] r10, PrimitiveSink r11) {
            r11.putBytes(r10);
        }
    }

    public static final enum IntegerFunnel extends Enum<IntegerFunnel> implements Funnel<Integer> {
        private static final /* synthetic */ IntegerFunnel[] $VALUES = null;
        public static final IntegerFunnel INSTANCE = null;

        static {
            IntegerFunnel r10 = new IntegerFunnel("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new IntegerFunnel[]{r10};
        }

        private IntegerFunnel(String r10, int r11) {
            super(r10, r11);
        }

        public static IntegerFunnel valueOf(String r10) {
            return (IntegerFunnel) Enum.valueOf(IntegerFunnel.class, r10);
        }

        public static IntegerFunnel[] values() {
            return (IntegerFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Integer r10, PrimitiveSink r11) {
            funnel2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(Integer r10, PrimitiveSink r11) {
            r11.putInt(r10.intValue());
        }
    }

    public static final enum LongFunnel extends Enum<LongFunnel> implements Funnel<Long> {
        private static final /* synthetic */ LongFunnel[] $VALUES = null;
        public static final LongFunnel INSTANCE = null;

        static {
            LongFunnel r10 = new LongFunnel("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new LongFunnel[]{r10};
        }

        private LongFunnel(String r10, int r11) {
            super(r10, r11);
        }

        public static LongFunnel valueOf(String r10) {
            return (LongFunnel) Enum.valueOf(LongFunnel.class, r10);
        }

        public static LongFunnel[] values() {
            return (LongFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Long r10, PrimitiveSink r11) {
            funnel2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(Long r10, PrimitiveSink r11) {
            r11.putLong(r10.longValue());
        }
    }

    public static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        public SequentialFunnel(Funnel<E> r10) {
            this.elementFunnel = (Funnel) Preconditions.checkNotNull(r10);
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof SequentialFunnel) == true) goto L5;
            return false;
        L5:
            return this.elementFunnel.equals(((SequentialFunnel) r10).elementFunnel);
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Object r10, PrimitiveSink r11) {
            funnel((Iterable) r10, r11);
        }

        public int hashCode() {
            int r10 = SequentialFunnel.class.hashCode();
            return this.elementFunnel.hashCode() ^ r10;
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
        }

        public void funnel(Iterable<? extends E> r10, PrimitiveSink r11) {
            Iterator<? extends E> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            E r13 = r12.next();
            this.elementFunnel.funnel(r13, r11);
            goto L4
        }
    }

    public static class SinkAsStream extends OutputStream {
        final PrimitiveSink sink;

        public SinkAsStream(PrimitiveSink r10) {
            this.sink = (PrimitiveSink) Preconditions.checkNotNull(r10);
        }

        public String toString() {
            return "Funnels.asOutputStream(" + this.sink + ")";
        }

        @Override // java.io.OutputStream
        public void write(int r10) {
            this.sink.putByte((byte) r10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r10) {
            this.sink.putBytes(r10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r10, int r11, int r12) {
            this.sink.putBytes(r10, r11, r12);
        }
    }

    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        public static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            public SerializedForm(Charset r10) {
                this.charsetCanonicalName = r10.name();
            }

            private Object readResolve() {
                return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
            }
        }

        public StringCharsetFunnel(Charset r10) {
            this.charset = (Charset) Preconditions.checkNotNull(r10);
        }

        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof StringCharsetFunnel) == true) goto L5;
            return false;
        L5:
            return this.charset.equals(((StringCharsetFunnel) r10).charset);
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(CharSequence r10, PrimitiveSink r11) {
            funnel2(r10, r11);
        }

        public int hashCode() {
            int r10 = StringCharsetFunnel.class.hashCode();
            return this.charset.hashCode() ^ r10;
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + ")";
        }

        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(CharSequence r10, PrimitiveSink r11) {
            r11.putString(r10, this.charset);
        }
    }

    public static final enum UnencodedCharsFunnel extends Enum<UnencodedCharsFunnel> implements Funnel<CharSequence> {
        private static final /* synthetic */ UnencodedCharsFunnel[] $VALUES = null;
        public static final UnencodedCharsFunnel INSTANCE = null;

        static {
            UnencodedCharsFunnel r10 = new UnencodedCharsFunnel("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new UnencodedCharsFunnel[]{r10};
        }

        private UnencodedCharsFunnel(String r10, int r11) {
            super(r10, r11);
        }

        public static UnencodedCharsFunnel valueOf(String r10) {
            return (UnencodedCharsFunnel) Enum.valueOf(UnencodedCharsFunnel.class, r10);
        }

        public static UnencodedCharsFunnel[] values() {
            return (UnencodedCharsFunnel[]) $VALUES.clone();
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(CharSequence r10, PrimitiveSink r11) {
            funnel2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(CharSequence r10, PrimitiveSink r11) {
            r11.putUnencodedChars(r10);
        }
    }

    private Funnels() {
    }

    public static OutputStream asOutputStream(PrimitiveSink r10) {
        return new SinkAsStream(r10);
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<Integer> integerFunnel() {
        return IntegerFunnel.INSTANCE;
    }

    public static Funnel<Long> longFunnel() {
        return LongFunnel.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> r10) {
        return new SequentialFunnel(r10);
    }

    public static Funnel<CharSequence> stringFunnel(Charset r10) {
        return new StringCharsetFunnel(r10);
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return UnencodedCharsFunnel.INSTANCE;
    }
}
