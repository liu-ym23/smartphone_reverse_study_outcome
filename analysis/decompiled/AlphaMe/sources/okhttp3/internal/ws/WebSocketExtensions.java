package okhttp3.internal.ws;

import ch.qos.logback.core.CoreConstants;
import h3.H;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class WebSocketExtensions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @JvmField
    @Nullable
    public final Integer clientMaxWindowBits;

    @JvmField
    public final boolean clientNoContextTakeover;

    @JvmField
    public final boolean perMessageDeflate;

    @JvmField
    @Nullable
    public final Integer serverMaxWindowBits;

    @JvmField
    public final boolean serverNoContextTakeover;

    @JvmField
    public final boolean unknownValues;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "Lh3/H;", "responseHeaders", "Lokhttp3/internal/ws/WebSocketExtensions;", "parse", "(Lh3/H;)Lokhttp3/internal/ws/WebSocketExtensions;", "", "HEADER_WEB_SOCKET_EXTENSION", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull H responseHeaders) throws IOException {
            Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            Integer intOrNull = null;
            Integer intOrNull2 = null;
            int i4 = 0;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            while (i4 < size) {
                int i5 = i4 + 1;
                if (StringsKt__StringsJVMKt.equals(responseHeaders.c(i4), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String strF = responseHeaders.f(i4);
                    int i6 = 0;
                    while (i6 < strF.length()) {
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strF, ',', i6, 0, 4, (Object) null);
                        int iDelimiterOffset = Util.delimiterOffset(strF, ';', i6, iDelimiterOffset$default);
                        String strTrimSubstring = Util.trimSubstring(strF, i6, iDelimiterOffset);
                        int i7 = iDelimiterOffset + 1;
                        if (StringsKt__StringsJVMKt.equals(strTrimSubstring, "permessage-deflate", true)) {
                            if (z4) {
                                z7 = true;
                            }
                            i6 = i7;
                            while (i6 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strF, ';', i6, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strF, '=', i6, iDelimiterOffset2);
                                String strTrimSubstring2 = Util.trimSubstring(strF, i6, iDelimiterOffset3);
                                String strRemoveSurrounding = iDelimiterOffset3 < iDelimiterOffset2 ? StringsKt__StringsKt.removeSurrounding(Util.trimSubstring(strF, iDelimiterOffset3 + 1, iDelimiterOffset2), (CharSequence) "\"") : null;
                                int i8 = iDelimiterOffset2 + 1;
                                if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "client_max_window_bits", true)) {
                                    if (intOrNull != null) {
                                        z7 = true;
                                    }
                                    intOrNull = strRemoveSurrounding == null ? null : StringsKt.toIntOrNull(strRemoveSurrounding);
                                    if (intOrNull == null) {
                                        i6 = i8;
                                        z7 = true;
                                    } else {
                                        i6 = i8;
                                    }
                                } else if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "client_no_context_takeover", true)) {
                                    if (z5) {
                                        z7 = true;
                                    }
                                    if (strRemoveSurrounding != null) {
                                        z7 = true;
                                    }
                                    i6 = i8;
                                    z5 = true;
                                } else {
                                    if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "server_max_window_bits", true)) {
                                        if (intOrNull2 != null) {
                                            z7 = true;
                                        }
                                        intOrNull2 = strRemoveSurrounding == null ? null : StringsKt.toIntOrNull(strRemoveSurrounding);
                                        if (intOrNull2 != null) {
                                            i6 = i8;
                                        }
                                    } else if (StringsKt__StringsJVMKt.equals(strTrimSubstring2, "server_no_context_takeover", true)) {
                                        if (z6) {
                                            z7 = true;
                                        }
                                        if (strRemoveSurrounding != null) {
                                            z7 = true;
                                        }
                                        i6 = i8;
                                        z6 = true;
                                    }
                                    i6 = i8;
                                    z7 = true;
                                }
                            }
                            z4 = true;
                        } else {
                            i6 = i7;
                            z7 = true;
                        }
                    }
                }
                i4 = i5;
            }
            return new WebSocketExtensions(z4, intOrNull, z5, intOrNull2, z6, z7);
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z4, Integer num, boolean z5, Integer num2, boolean z6, boolean z7, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = webSocketExtensions.perMessageDeflate;
        }
        if ((i4 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i4 & 4) != 0) {
            z5 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z8 = z5;
        if ((i4 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i4 & 16) != 0) {
            z6 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z9 = z6;
        if ((i4 & 32) != 0) {
            z7 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z4, num3, z8, num4, z9, z7);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getPerMessageDeflate() {
        return this.perMessageDeflate;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getClientMaxWindowBits() {
        return this.clientMaxWindowBits;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getClientNoContextTakeover() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getServerMaxWindowBits() {
        return this.serverMaxWindowBits;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getServerNoContextTakeover() {
        return this.serverNoContextTakeover;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getUnknownValues() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean perMessageDeflate, @Nullable Integer clientMaxWindowBits, boolean clientNoContextTakeover, @Nullable Integer serverMaxWindowBits, boolean serverNoContextTakeover, boolean unknownValues) {
        return new WebSocketExtensions(perMessageDeflate, clientMaxWindowBits, clientNoContextTakeover, serverMaxWindowBits, serverNoContextTakeover, unknownValues);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) other;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z4 = this.perMessageDeflate;
        ?? r02 = z4;
        if (z4) {
            r02 = 1;
        }
        int i4 = r02 * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (i4 + (num == null ? 0 : num.hashCode())) * 31;
        ?? r22 = this.clientNoContextTakeover;
        int i5 = r22;
        if (r22 != 0) {
            i5 = 1;
        }
        int i6 = (iHashCode + i5) * 31;
        Integer num2 = this.serverMaxWindowBits;
        int iHashCode2 = (i6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        ?? r23 = this.serverNoContextTakeover;
        int i7 = r23;
        if (r23 != 0) {
            i7 = 1;
        }
        int i8 = (iHashCode2 + i7) * 31;
        boolean z5 = this.unknownValues;
        return i8 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public final boolean noContextTakeover(boolean clientOriginated) {
        return clientOriginated ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public WebSocketExtensions(boolean z4, @Nullable Integer num, boolean z5, @Nullable Integer num2, boolean z6, boolean z7) {
        this.perMessageDeflate = z4;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z5;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z6;
        this.unknownValues = z7;
    }

    public /* synthetic */ WebSocketExtensions(boolean z4, Integer num, boolean z5, Integer num2, boolean z6, boolean z7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z4, (i4 & 2) != 0 ? null : num, (i4 & 4) != 0 ? false : z5, (i4 & 8) != 0 ? null : num2, (i4 & 16) != 0 ? false : z6, (i4 & 32) != 0 ? false : z7);
    }
}
