package com.obric.tracker.event;

import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.tracker.intf.event.ITeaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJd\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020,H\u0016J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006/"}, d2 = {"Lcom/obric/tracker/event/SearchEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "searchResultSize", "", "inAppSearch", "", "searchSuccess", "searchDurationMs", "", "searchErrorMsg", "", "searchErrorCode", "searchKey", "search_click_action", "(IZZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getInAppSearch", "()Z", "getSearchDurationMs", "()J", "getSearchErrorCode", "()I", "getSearchErrorMsg", "()Ljava/lang/String;", "getSearchKey", "getSearchResultSize", "getSearchSuccess", "getSearch_click_action", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IZZJLjava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)Lcom/obric/tracker/event/SearchEvent;", "equals", "other", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchEvent implements ITeaEvent {
    private final boolean inAppSearch;
    private final long searchDurationMs;
    private final int searchErrorCode;
    private final String searchErrorMsg;
    private final String searchKey;
    private final int searchResultSize;
    private final boolean searchSuccess;
    private final Integer search_click_action;

    public static /* synthetic */ SearchEvent copy$default(SearchEvent r10, int r11, boolean r12, boolean r13, long r14, String r16, int r17, String r18, Integer r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.searchResultSize;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.inAppSearch;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.searchSuccess;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r5 = r10.searchDurationMs;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = r10.searchErrorMsg;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r8 = r10.searchErrorCode;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.searchKey;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Integer r1 = r10.search_click_action;
    L35:
        return r10.copy(r2, r3, r4, r5, r7, r8, r9, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r9 = r18;
        goto L31
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final int component1() {
        return this.searchResultSize;
    }

    public final boolean component2() {
        return this.inAppSearch;
    }

    public final boolean component3() {
        return this.searchSuccess;
    }

    public final long component4() {
        return this.searchDurationMs;
    }

    public final String component5() {
        return this.searchErrorMsg;
    }

    public final int component6() {
        return this.searchErrorCode;
    }

    public final String component7() {
        return this.searchKey;
    }

    public final Integer component8() {
        return this.search_click_action;
    }

    public final SearchEvent copy(int r12, boolean r13, boolean r14, long r15, String r17, int r18, String r19, Integer r20) {
        return new SearchEvent(r12, r13, r14, r15, r17, r18, r19, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SearchEvent) == true) goto L8;
        return false;
    L8:
        SearchEvent r9 = (SearchEvent) r8;
        if (this.searchResultSize == r9.searchResultSize) goto L12;
        return false;
    L12:
        if (this.inAppSearch == r9.inAppSearch) goto L15;
        return false;
    L15:
        if (this.searchSuccess == r9.searchSuccess) goto L18;
        return false;
    L18:
        if (this.searchDurationMs == r9.searchDurationMs) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.searchErrorMsg, r9.searchErrorMsg) == true) goto L24;
        return false;
    L24:
        if (this.searchErrorCode == r9.searchErrorCode) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.searchKey, r9.searchKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.search_click_action, r9.search_click_action) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.SEARCH_RESULT_EVENT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.searchResultSize) * 31;
        boolean r1 = this.inAppSearch;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.searchSuccess;
        if (r5 == true) goto L9;
        r2 = r5;
    L9:
        int r6 = (((r4 + r2) * 31) + Long.hashCode(this.searchDurationMs)) * 31;
        String r7 = this.searchErrorMsg;
        int r8 = 0;
        if (r7 != null) goto L12;
        int r9 = 0;
    L13:
        int r10 = (((r6 + r9) * 31) + Integer.hashCode(this.searchErrorCode)) * 31;
        String r11 = this.searchKey;
        if (r11 != null) goto L16;
        int r12 = 0;
    L17:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.search_click_action;
        if (r14 == null) goto L22;
        r8 = r14.hashCode();
    L22:
        return r13 + r8;
    L16:
        r12 = r11.hashCode();
        goto L17
    L12:
        r9 = r7.hashCode();
        goto L13
    }

    public String toString() {
        return "SearchEvent(searchResultSize=" + this.searchResultSize + ", inAppSearch=" + this.inAppSearch + ", searchSuccess=" + this.searchSuccess + ", searchDurationMs=" + this.searchDurationMs + ", searchErrorMsg=" + this.searchErrorMsg + ", searchErrorCode=" + this.searchErrorCode + ", searchKey=" + this.searchKey + ", search_click_action=" + this.search_click_action + ')';
    }

    public SearchEvent(int r1, boolean r2, boolean r3, long r4, String r6, int r7, String r8, Integer r9) {
        this.searchResultSize = r1;
        this.inAppSearch = r2;
        this.searchSuccess = r3;
        this.searchDurationMs = r4;
        this.searchErrorMsg = r6;
        this.searchErrorCode = r7;
        this.searchKey = r8;
        this.search_click_action = r9;
    }

    public final int getSearchResultSize() {
        return this.searchResultSize;
    }

    public final boolean getInAppSearch() {
        return this.inAppSearch;
    }

    public final boolean getSearchSuccess() {
        return this.searchSuccess;
    }

    public final long getSearchDurationMs() {
        return this.searchDurationMs;
    }

    public final String getSearchErrorMsg() {
        return this.searchErrorMsg;
    }

    public final int getSearchErrorCode() {
        return this.searchErrorCode;
    }

    public final String getSearchKey() {
        return this.searchKey;
    }

    public final Integer getSearch_click_action() {
        return this.search_click_action;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public JSONObject getEventParams() {
        JSONObject r0 = new JSONObject();
        r0.put("did", MatrixTeaManager.Companion.getInstance().getDeviceId());
        r0.put("package_name", "com.android.contacts");
        r0.put("search_result_size", this.searchResultSize);
        r0.put("is_in_app_search", this.inAppSearch ? 1 : 0);
        r0.put("search_time", this.searchDurationMs);
        r0.put("search_success", this.searchSuccess ? 1 : 0);
        r0.put("search_err_message", this.searchErrorMsg);
        r0.put("search_err_code", this.searchErrorCode);
        r0.put("search_key", this.searchKey);
        r0.put("search_click_action", this.search_click_action);
        return r0;
    }
}
