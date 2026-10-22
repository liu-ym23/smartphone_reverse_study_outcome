package kotlin;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0011R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\"\u0010!R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b#\u0010\u0011R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b$\u0010\u0011¨\u0006%"}, d2 = {"LK6/K;", "", "", "ok", "", "appended", "skipped", "", "leafIdAfter", "", "entryIds", "warnings", "errorCode", "errorMessage", "<init>", "(ZIILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", Const.INTENT_KEY_UMID, "()Z", "I", Const.INTENT_KEY_APIKEY, "getSkipped", "Ljava/lang/String;", "getLeafIdAfter", "Ljava/util/List;", "getEntryIds", "()Ljava/util/List;", "getWarnings", Const.INTENT_KEY_PKGNAME, "c", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.K, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TranscriptAppendResult {
    private final int appended;
    private final List<String> entryIds;
    private final String errorCode;
    private final String errorMessage;
    private final String leafIdAfter;
    private final boolean ok;
    private final int skipped;
    private final List<String> warnings;

    public TranscriptAppendResult() {
        this(false, 0, 0, null, null, null, null, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getAppended() {
        return this.appended;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: c, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranscriptAppendResult)) {
            return false;
        }
        TranscriptAppendResult transcriptAppendResult = (TranscriptAppendResult) other;
        return this.ok == transcriptAppendResult.ok && this.appended == transcriptAppendResult.appended && this.skipped == transcriptAppendResult.skipped && p.d(this.leafIdAfter, transcriptAppendResult.leafIdAfter) && p.d(this.entryIds, transcriptAppendResult.entryIds) && p.d(this.warnings, transcriptAppendResult.warnings) && p.d(this.errorCode, transcriptAppendResult.errorCode) && p.d(this.errorMessage, transcriptAppendResult.errorMessage);
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.ok) * 31) + Integer.hashCode(this.appended)) * 31) + Integer.hashCode(this.skipped)) * 31;
        String str = this.leafIdAfter;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.entryIds.hashCode()) * 31) + this.warnings.hashCode()) * 31;
        String str2 = this.errorCode;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.errorMessage;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "TranscriptAppendResult(ok=" + this.ok + ", appended=" + this.appended + ", skipped=" + this.skipped + ", leafIdAfter=" + this.leafIdAfter + ", entryIds=" + this.entryIds + ", warnings=" + this.warnings + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }

    public TranscriptAppendResult(boolean z10, int i10, int i11, String str, List<String> entryIds, List<String> warnings, String str2, String str3) {
        p.i(entryIds, "entryIds");
        p.i(warnings, "warnings");
        this.ok = z10;
        this.appended = i10;
        this.skipped = i11;
        this.leafIdAfter = str;
        this.entryIds = entryIds;
        this.warnings = warnings;
        this.errorCode = str2;
        this.errorMessage = str3;
    }

    public /* synthetic */ TranscriptAppendResult(boolean z10, int i10, int i11, String str, List list, List list2, String str2, String str3, int i12, i iVar) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11, (i12 & 8) != 0 ? null : str, (i12 & 16) != 0 ? C1173v.m() : list, (i12 & 32) != 0 ? C1173v.m() : list2, (i12 & 64) != 0 ? null : str2, (i12 & 128) != 0 ? null : str3);
    }
}
