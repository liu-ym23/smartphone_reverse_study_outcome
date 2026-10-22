package com.android.ttcjpaysdk.kmp.base.uri.parts;

import com.android.ttcjpaysdk.kmp.base.uri.NotCachedHolder;
import com.android.ttcjpaysdk.kmp.base.uri.UriCodec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b!\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H$R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/parts/AbstractPart;", "", "encoded", "", "decoded", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "wasEncodedCached", "", "getWasEncodedCached$cj_base_release", "()Z", "wasDecodedCached", "getWasDecodedCached$cj_base_release", "internalDecoded", "getInternalDecoded", "()Ljava/lang/String;", "internalDecoded$delegate", "Lkotlin/Lazy;", "internalEncoded", "getInternalEncoded", "internalEncoded$delegate", "getDecoded", "getEncoded", "encode", "Companion", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbstractPart {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int REPRESENTATION_DECODED = 2;
    public static final int REPRESENTATION_ENCODED = 1;
    private final Lazy internalDecoded$delegate;
    private final Lazy internalEncoded$delegate;
    private final boolean wasDecodedCached;
    private final boolean wasEncodedCached;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/uri/parts/AbstractPart$Companion;", "", "<init>", "()V", "REPRESENTATION_ENCODED", "", "REPRESENTATION_DECODED", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public static /* synthetic */ String a(AbstractPart r100, String r101, String r102) {
        return internalDecoded_delegate$lambda$0(r100, r101, r102);
    }

    public static /* synthetic */ String b(String r100, AbstractPart r101, String r102) {
        return internalEncoded_delegate$lambda$1(r100, r101, r102);
    }

    public abstract String encode(String r100);

    private final String getInternalDecoded() {
        return (String) this.internalDecoded$delegate.getValue();
    }

    private final String getInternalEncoded() {
        return (String) this.internalEncoded$delegate.getValue();
    }

    public final String getDecoded() {
        return getInternalDecoded();
    }

    public final String getEncoded() {
        return getInternalEncoded();
    }

    public final boolean getWasDecodedCached$cj_base_release() {
        return this.wasDecodedCached;
    }

    public final boolean getWasEncodedCached$cj_base_release() {
        return this.wasEncodedCached;
    }

    public AbstractPart(final String r100, final String r101) {
        NotCachedHolder r102 = NotCachedHolder.INSTANCE;
        this.wasEncodedCached = !Intrinsics.areEqual(r100, r102.getNotCached());
        this.wasDecodedCached = !Intrinsics.areEqual(r101, r102.getNotCached());
        this.internalDecoded$delegate = LazyKt.lazy(new a(this, r101, r100));
        this.internalEncoded$delegate = LazyKt.lazy(new b(r100, this, r101));
        if (Intrinsics.areEqual(r100, r102.getNotCached()) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, r102.getNotCached()) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Neither encoded nor decoded");
    }

    private static final String internalDecoded_delegate$lambda$0(AbstractPart r100, String r101, String r102) {
        if (r100.wasEncodedCached == true) goto L7;
        if (Intrinsics.areEqual(r101, NotCachedHolder.INSTANCE.getNotCached()) == true) goto L7;
        return r101;
    L7:
        return UriCodec.decodeOrNull$default(UriCodec.INSTANCE, r102, false, false, 6, null);
    }

    private static final String internalEncoded_delegate$lambda$1(String r100, AbstractPart r101, String r102) {
        if (Intrinsics.areEqual(r100, NotCachedHolder.INSTANCE.getNotCached()) == true) goto L5;
        return r100;
    L5:
        return r101.encode(r102);
    }
}
