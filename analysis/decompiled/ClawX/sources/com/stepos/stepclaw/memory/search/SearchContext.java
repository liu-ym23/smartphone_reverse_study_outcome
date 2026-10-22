package com.stepos.stepclaw.memory.search;

import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.remote.MessageItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003Jy\u0010+\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0017R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0017R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u001a¨\u00062"}, d2 = {"Lcom/stepos/stepclaw/memory/search/SearchContext;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "messages", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "sessionId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", "userQuery", "queryItems", "Lcom/stepos/stepclaw/memory/search/QueryItem;", "rawResults", "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "rankedResults", "formattedOutput", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getMessages", "()Ljava/util/List;", "getSessionId", "()Ljava/lang/String;", "getCategories", "setCategories", "(Ljava/util/List;)V", "getUserQuery", "setUserQuery", "(Ljava/lang/String;)V", "getQueryItems", "setQueryItems", "getRawResults", "setRawResults", "getRankedResults", "setRankedResults", "getFormattedOutput", "setFormattedOutput", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SearchContext {
    private List<String> categories;
    private String formattedOutput;
    private final List<MessageItem> messages;
    private List<QueryItem> queryItems;
    private List<RetrievalResult> rankedResults;
    private List<RetrievalResult> rawResults;
    private final String sessionId;
    private String userQuery;

    public SearchContext(List<MessageItem> messages, String str, List<String> categories, String userQuery, List<QueryItem> queryItems, List<RetrievalResult> rawResults, List<RetrievalResult> rankedResults, String formattedOutput) {
        p.e(messages, "messages");
        p.e(categories, "categories");
        p.e(userQuery, "userQuery");
        p.e(queryItems, "queryItems");
        p.e(rawResults, "rawResults");
        p.e(rankedResults, "rankedResults");
        p.e(formattedOutput, "formattedOutput");
        this.messages = messages;
        this.sessionId = str;
        this.categories = categories;
        this.userQuery = userQuery;
        this.queryItems = queryItems;
        this.rawResults = rawResults;
        this.rankedResults = rankedResults;
        this.formattedOutput = formattedOutput;
    }

    public static /* synthetic */ SearchContext copy$default(SearchContext searchContext, List list, String str, List list2, String str2, List list3, List list4, List list5, String str3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = searchContext.messages;
        }
        if ((i8 & 2) != 0) {
            str = searchContext.sessionId;
        }
        if ((i8 & 4) != 0) {
            list2 = searchContext.categories;
        }
        if ((i8 & 8) != 0) {
            str2 = searchContext.userQuery;
        }
        if ((i8 & 16) != 0) {
            list3 = searchContext.queryItems;
        }
        if ((i8 & 32) != 0) {
            list4 = searchContext.rawResults;
        }
        if ((i8 & 64) != 0) {
            list5 = searchContext.rankedResults;
        }
        if ((i8 & 128) != 0) {
            str3 = searchContext.formattedOutput;
        }
        List list6 = list5;
        String str4 = str3;
        List list7 = list3;
        List list8 = list4;
        return searchContext.copy(list, str, list2, str2, list7, list8, list6, str4);
    }

    public final List<MessageItem> component1() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<String> component3() {
        return this.categories;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserQuery() {
        return this.userQuery;
    }

    public final List<QueryItem> component5() {
        return this.queryItems;
    }

    public final List<RetrievalResult> component6() {
        return this.rawResults;
    }

    public final List<RetrievalResult> component7() {
        return this.rankedResults;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFormattedOutput() {
        return this.formattedOutput;
    }

    public final SearchContext copy(List<MessageItem> messages, String sessionId, List<String> categories, String userQuery, List<QueryItem> queryItems, List<RetrievalResult> rawResults, List<RetrievalResult> rankedResults, String formattedOutput) {
        p.e(messages, "messages");
        p.e(categories, "categories");
        p.e(userQuery, "userQuery");
        p.e(queryItems, "queryItems");
        p.e(rawResults, "rawResults");
        p.e(rankedResults, "rankedResults");
        p.e(formattedOutput, "formattedOutput");
        return new SearchContext(messages, sessionId, categories, userQuery, queryItems, rawResults, rankedResults, formattedOutput);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchContext)) {
            return false;
        }
        SearchContext searchContext = (SearchContext) other;
        return p.a(this.messages, searchContext.messages) && p.a(this.sessionId, searchContext.sessionId) && p.a(this.categories, searchContext.categories) && p.a(this.userQuery, searchContext.userQuery) && p.a(this.queryItems, searchContext.queryItems) && p.a(this.rawResults, searchContext.rawResults) && p.a(this.rankedResults, searchContext.rankedResults) && p.a(this.formattedOutput, searchContext.formattedOutput);
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final String getFormattedOutput() {
        return this.formattedOutput;
    }

    public final List<MessageItem> getMessages() {
        return this.messages;
    }

    public final List<QueryItem> getQueryItems() {
        return this.queryItems;
    }

    public final List<RetrievalResult> getRankedResults() {
        return this.rankedResults;
    }

    public final List<RetrievalResult> getRawResults() {
        return this.rawResults;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getUserQuery() {
        return this.userQuery;
    }

    public int hashCode() {
        int iHashCode = this.messages.hashCode() * 31;
        String str = this.sessionId;
        return this.formattedOutput.hashCode() + ((this.rankedResults.hashCode() + ((this.rawResults.hashCode() + ((this.queryItems.hashCode() + a8.b.f((this.categories.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31, 31, this.userQuery)) * 31)) * 31)) * 31);
    }

    public final void setCategories(List<String> list) {
        p.e(list, "<set-?>");
        this.categories = list;
    }

    public final void setFormattedOutput(String str) {
        p.e(str, "<set-?>");
        this.formattedOutput = str;
    }

    public final void setQueryItems(List<QueryItem> list) {
        p.e(list, "<set-?>");
        this.queryItems = list;
    }

    public final void setRankedResults(List<RetrievalResult> list) {
        p.e(list, "<set-?>");
        this.rankedResults = list;
    }

    public final void setRawResults(List<RetrievalResult> list) {
        p.e(list, "<set-?>");
        this.rawResults = list;
    }

    public final void setUserQuery(String str) {
        p.e(str, "<set-?>");
        this.userQuery = str;
    }

    public String toString() {
        return "SearchContext(messages=" + this.messages + ", sessionId=" + this.sessionId + ", categories=" + this.categories + ", userQuery=" + this.userQuery + ", queryItems=" + this.queryItems + ", rawResults=" + this.rawResults + ", rankedResults=" + this.rankedResults + ", formattedOutput=" + this.formattedOutput + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SearchContext(List list, String str, List list2, String str2, List list3, List list4, List list5, String str3, int i8, i iVar) {
        String str4 = (i8 & 2) != 0 ? null : str;
        int i9 = i8 & 4;
        s sVar = s.f1092a;
        this(list, str4, i9 != 0 ? sVar : list2, (i8 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 16) != 0 ? sVar : list3, (i8 & 32) != 0 ? sVar : list4, (i8 & 64) != 0 ? sVar : list5, (i8 & 128) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3);
    }
}
