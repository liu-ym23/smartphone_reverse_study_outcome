package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/gateway/ParsedInvokeError;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "code", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "hadExplicitCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCode", "()Ljava/lang/String;", "getMessage", "getHadExplicitCode", "()Z", "prefixedMessage", "getPrefixedMessage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ParsedInvokeError {
    private final String code;
    private final boolean hadExplicitCode;
    private final String message;

    public ParsedInvokeError(String code, String message, boolean z) {
        p.e(code, "code");
        p.e(message, "message");
        this.code = code;
        this.message = message;
        this.hadExplicitCode = z;
    }

    public static /* synthetic */ ParsedInvokeError copy$default(ParsedInvokeError parsedInvokeError, String str, String str2, boolean z, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = parsedInvokeError.code;
        }
        if ((i8 & 2) != 0) {
            str2 = parsedInvokeError.message;
        }
        if ((i8 & 4) != 0) {
            z = parsedInvokeError.hadExplicitCode;
        }
        return parsedInvokeError.copy(str, str2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHadExplicitCode() {
        return this.hadExplicitCode;
    }

    public final ParsedInvokeError copy(String code, String message, boolean hadExplicitCode) {
        p.e(code, "code");
        p.e(message, "message");
        return new ParsedInvokeError(code, message, hadExplicitCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedInvokeError)) {
            return false;
        }
        ParsedInvokeError parsedInvokeError = (ParsedInvokeError) other;
        return p.a(this.code, parsedInvokeError.code) && p.a(this.message, parsedInvokeError.message) && this.hadExplicitCode == parsedInvokeError.hadExplicitCode;
    }

    public final String getCode() {
        return this.code;
    }

    public final boolean getHadExplicitCode() {
        return this.hadExplicitCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getPrefixedMessage() {
        return a8.b.o(this.code, ": ", this.message);
    }

    public int hashCode() {
        return Boolean.hashCode(this.hadExplicitCode) + a8.b.f(this.code.hashCode() * 31, 31, this.message);
    }

    public String toString() {
        String str = this.code;
        String str2 = this.message;
        boolean z = this.hadExplicitCode;
        StringBuilder sbV = a8.b.v("ParsedInvokeError(code=", str, ", message=", str2, ", hadExplicitCode=");
        sbV.append(z);
        sbV.append(")");
        return sbV.toString();
    }
}
