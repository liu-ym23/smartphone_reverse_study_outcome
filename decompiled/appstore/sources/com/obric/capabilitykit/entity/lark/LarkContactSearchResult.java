package com.obric.capabilitykit.entity.lark;

import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/entity/lark/LarkContactSearchResult;", "", "asrResult", "", "asrName", "larkContactsResults", "", "Lcom/obric/capabilitykit/entity/lark/LarkContacts;", WsConstants.KEY_EXTRA, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAsrName", "()Ljava/lang/String;", "getAsrResult", "getExtra", "getLarkContactsResults", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkContactSearchResult {

    @Nullable
    private final String asrName;

    @Nullable
    private final String asrResult;

    @Nullable
    private final String extra;

    @Nullable
    private final List<LarkContacts> larkContactsResults;

    public LarkContactSearchResult(@Nullable String r10, @Nullable String r11, @Nullable List<LarkContacts> r12, @Nullable String r13) {
        this.asrResult = r10;
        this.asrName = r11;
        this.larkContactsResults = r12;
        this.extra = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkContactSearchResult copy$default(LarkContactSearchResult r10, String r11, String r12, List r13, String r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.asrResult;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.asrName;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.larkContactsResults;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.extra;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.asrResult;
    }

    @Nullable
    public final String component2() {
        return this.asrName;
    }

    @Nullable
    public final List<LarkContacts> component3() {
        return this.larkContactsResults;
    }

    @Nullable
    public final String component4() {
        return this.extra;
    }

    @NotNull
    public final LarkContactSearchResult copy(@Nullable String r10, @Nullable String r11, @Nullable List<LarkContacts> r12, @Nullable String r13) {
        return new LarkContactSearchResult(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LarkContactSearchResult) == true) goto L8;
        return false;
    L8:
        LarkContactSearchResult r11 = (LarkContactSearchResult) r10;
        if (q.b(this.asrResult, r11.asrResult) == true) goto L12;
        return false;
    L12:
        if (q.b(this.asrName, r11.asrName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.larkContactsResults, r11.larkContactsResults) == true) goto L18;
        return false;
    L18:
        if (q.b(this.extra, r11.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String getAsrName() {
        return this.asrName;
    }

    @Nullable
    public final String getAsrResult() {
        return this.asrResult;
    }

    @Nullable
    public final String getExtra() {
        return this.extra;
    }

    @Nullable
    public final List<LarkContacts> getLarkContactsResults() {
        return this.larkContactsResults;
    }

    public int hashCode() {
        String r10 = this.asrResult;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.asrName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        List<LarkContacts> r17 = this.larkContactsResults;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.extra;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "LarkContactSearchResult(asrResult=" + this.asrResult + ", asrName=" + this.asrName + ", larkContactsResults=" + this.larkContactsResults + ", extra=" + this.extra + ')';
    }
}
