package okhttp3.internal.http2;

import com.stepos.alphame.awareness.AwarenessDataItem;
import h3.C0611u;
import k3.l;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0019B\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/http2/Header;", "", "", "toString", "()Ljava/lang/String;", "Lk3/l;", "component1", "()Lk3/l;", "component2", "name", "value", "copy", "(Lk3/l;Lk3/l;)Lokhttp3/internal/http2/Header;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lk3/l;", "hpackSize", "I", "<init>", "(Lk3/l;Lk3/l;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Lk3/l;Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final /* data */ class Header {

    @JvmField
    @NotNull
    public static final l PSEUDO_PREFIX;

    @JvmField
    @NotNull
    public static final l RESPONSE_STATUS;

    @NotNull
    public static final String RESPONSE_STATUS_UTF8 = ":status";

    @JvmField
    @NotNull
    public static final l TARGET_AUTHORITY;

    @NotNull
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";

    @JvmField
    @NotNull
    public static final l TARGET_METHOD;

    @NotNull
    public static final String TARGET_METHOD_UTF8 = ":method";

    @JvmField
    @NotNull
    public static final l TARGET_PATH;

    @NotNull
    public static final String TARGET_PATH_UTF8 = ":path";

    @JvmField
    @NotNull
    public static final l TARGET_SCHEME;

    @NotNull
    public static final String TARGET_SCHEME_UTF8 = ":scheme";

    @JvmField
    public final int hpackSize;

    @JvmField
    @NotNull
    public final l name;

    @JvmField
    @NotNull
    public final l value;

    static {
        l lVar = l.f13358d;
        PSEUDO_PREFIX = C0611u.k(AwarenessDataItem.USERID_SPLITTER);
        RESPONSE_STATUS = C0611u.k(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = C0611u.k(TARGET_METHOD_UTF8);
        TARGET_PATH = C0611u.k(TARGET_PATH_UTF8);
        TARGET_SCHEME = C0611u.k(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = C0611u.k(TARGET_AUTHORITY_UTF8);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(@NotNull l name, @NotNull String value) {
        this(name, C0611u.k(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        l lVar = l.f13358d;
    }

    public static /* synthetic */ Header copy$default(Header header, l lVar, l lVar2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            lVar = header.name;
        }
        if ((i4 & 2) != 0) {
            lVar2 = header.value;
        }
        return header.copy(lVar, lVar2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final l getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final l getValue() {
        return this.value;
    }

    @NotNull
    public final Header copy(@NotNull l name, @NotNull l value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new Header(name, value);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Header)) {
            return false;
        }
        Header header = (Header) other;
        return Intrinsics.areEqual(this.name, header.name) && Intrinsics.areEqual(this.value, header.value);
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return this.name.j() + ": " + this.value.j();
    }

    public Header(@NotNull l name, @NotNull l value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = value.c() + name.c() + 32;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(@NotNull String name, @NotNull String value) {
        this(C0611u.k(name), C0611u.k(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        l lVar = l.f13358d;
    }
}
