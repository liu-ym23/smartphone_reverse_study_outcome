package com.android.contacts.util;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.entity.search.InAppSearchEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.entity.search.InAppSearchResult;
import com.obric.capabilitykit.entity.search.InAppSearchResultWithoutEntity;
import com.obric.capabilitykit.entity.search.InAppSearchSimpleData;
import com.obric.capabilitykit.search.InAppSearchClient;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.contactsdk.loader.ContactEntityUtilKt;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.SearchEvent;
import com.obric.utils.GlobalUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import obric.widget.search.data.SearchConfigTypeData;

/* JADX INFO: compiled from: SearchUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002IJB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0007J>\u0010\u001f\u001a*\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0 j\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d`\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0007J\u001a\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020+H\u0007J\b\u0010-\u001a\u00020+H\u0007JN\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00107\u001a\u00020\bH\u0007J*\u00108\u001a\u00020+2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=H\u0007J4\u0010>\u001a\u00020+2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010?\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=H\u0007J4\u0010@\u001a\u00020+2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u00109\u001a\u00020:2\b\b\u0002\u0010?\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=H\u0007J&\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020\u00042\u0006\u0010C\u001a\u00020!2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020+0DH\u0002J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020\u0004H\u0007J\u0010\u0010G\u001a\u00020+2\u0006\u0010B\u001a\u00020\u0004H\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u00107\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/android/contacts/util/SearchUtils;", "", "()V", "BUSINESS_KEY", "", "FIELD_KEY_NAME", "FIELD_KEY_PHONE", "SEARCH_EVENT_TIMEOUT_ERROR_CODE", "", "SEARCH_MSG", "TAG", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "prepareSearchRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "runnableMap", "", "Ljava/lang/Runnable;", "searchScope", "Lkotlinx/coroutines/CoroutineScope;", "searchState", "Lcom/android/contacts/util/SearchUtils$SearchState;", "stopSearchRunning", "getPhoneNumberBySearch", "inAppSearchEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntity;", "Telephones", "", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "getSearchKeyMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "inAppSearchResultList", "inAppSearchResultAddEntity", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "context", "Landroid/content/Context;", "result", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "prepareSearchAsync", "", "reportSearchEvent", "reportSearchEventAndClear", "saveSearchState", "searchResultSize", "inAppSearch", "", "searchSuccess", "searchDurationMs", "searchErrorMsg", "searchErrorCode", "searchKey", "search_click_action", "startSearch", Ext.KEY_REQUEST, "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "callback", "Lcom/android/contacts/util/SearchUtils$ISearchCallBack;", "startSearchWithTimeOut", "timeoutMs", "startSearchWithTimeOutInCurThread", "startTimer", SearchConfigTypeData.KEY_IDENTIFIER, "delayMillis", "Lkotlin/Function0;", "stopSearchAsync", "reason", "stopTimer", "updateSearchClickAction", "ISearchCallBack", "SearchState", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchUtils {
    private static final String BUSINESS_KEY = "Contacts";
    private static final String FIELD_KEY_NAME = "ContactEntity_name";
    private static final String FIELD_KEY_PHONE = "ContactEntity_telephonesValues";
    public static final SearchUtils INSTANCE = null;
    public static final int SEARCH_EVENT_TIMEOUT_ERROR_CODE = -100;
    public static final String SEARCH_MSG = "search_message: ";
    public static final String TAG = "In_App_Search";
    private static Handler handler;
    private static final HandlerThread handlerThread = null;
    private static final AtomicBoolean prepareSearchRunning = null;
    private static final Map<String, Runnable> runnableMap = null;
    private static final CoroutineScope searchScope = null;
    private static SearchState searchState;
    private static final AtomicBoolean stopSearchRunning = null;

    /* JADX INFO: compiled from: SearchUtils.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/util/SearchUtils$ISearchCallBack;", "", "onCompleted", "", "searchTimeMs", "", "onError", AccountConst.KEY_ERROR_CODE, "", AccountConst.KEY_ERROR_MSG, "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/InAppSearchResult;", "onTimeOut", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ISearchCallBack {
        void onCompleted(long r1);

        void onError(int r1, String r2, long r3);

        void onSearchResult(InAppSearchResult r1);

        void onTimeOut(long r1);
    }

    /* JADX INFO: compiled from: SearchUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Jg\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\nHÖ\u0001R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u0006-"}, d2 = {"Lcom/android/contacts/util/SearchUtils$SearchState;", "", "searchResultSize", "", "inAppSearch", "", "searchSuccess", "searchDurationMs", "", "searchErrorMsg", "", "searchErrorCode", "searchKey", "search_click_action", "hasReported", "(IZZJLjava/lang/String;ILjava/lang/String;IZ)V", "getHasReported", "()Z", "setHasReported", "(Z)V", "getInAppSearch", "getSearchDurationMs", "()J", "getSearchErrorCode", "()I", "getSearchErrorMsg", "()Ljava/lang/String;", "getSearchKey", "getSearchResultSize", "getSearchSuccess", "getSearch_click_action", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SearchState {
        private boolean hasReported;
        private final boolean inAppSearch;
        private final long searchDurationMs;
        private final int searchErrorCode;
        private final String searchErrorMsg;
        private final String searchKey;
        private final int searchResultSize;
        private final boolean searchSuccess;
        private final int search_click_action;

        public static /* synthetic */ SearchState copy$default(SearchState r11, int r12, boolean r13, boolean r14, long r15, String r17, int r18, String r19, int r20, boolean r21, int r22, Object r23) {
            if ((r22 & 1) == 0) goto L5;
            int r2 = r11.searchResultSize;
        L7:
            if ((r22 & 2) == 0) goto L9;
            boolean r3 = r11.inAppSearch;
        L11:
            if ((r22 & 4) == 0) goto L13;
            boolean r4 = r11.searchSuccess;
        L15:
            if ((r22 & 8) == 0) goto L17;
            long r5 = r11.searchDurationMs;
        L19:
            if ((r22 & 16) == 0) goto L21;
            String r7 = r11.searchErrorMsg;
        L23:
            if ((r22 & 32) == 0) goto L25;
            int r8 = r11.searchErrorCode;
        L27:
            if ((r22 & 64) == 0) goto L29;
            String r9 = r11.searchKey;
        L31:
            if ((r22 & 128) == 0) goto L33;
            int r10 = r11.search_click_action;
        L35:
            if ((r22 & 256) == 0) goto L37;
            boolean r1 = r11.hasReported;
        L39:
            return r11.copy(r2, r3, r4, r5, r7, r8, r9, r10, r1);
        L37:
            r1 = r21;
            goto L39
        L33:
            r10 = r20;
            goto L35
        L29:
            r9 = r19;
            goto L31
        L25:
            r8 = r18;
            goto L27
        L21:
            r7 = r17;
            goto L23
        L17:
            r5 = r15;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r3 = r13;
            goto L11
        L5:
            r2 = r12;
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

        public final int component8() {
            return this.search_click_action;
        }

        public final boolean component9() {
            return this.hasReported;
        }

        public final SearchState copy(int r13, boolean r14, boolean r15, long r16, String r18, int r19, String r20, int r21, boolean r22) {
            return new SearchState(r13, r14, r15, r16, r18, r19, r20, r21, r22);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof SearchState) == true) goto L8;
            return false;
        L8:
            SearchState r9 = (SearchState) r8;
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
            if (this.search_click_action == r9.search_click_action) goto L33;
            return false;
        L33:
            if (this.hasReported == r9.hasReported) goto L35;
            return false;
        L35:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
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
            ?? r6 = r5;
            if (r5 == false) goto L8;
            r6 = 1;
        L8:
            int r7 = (((r4 + r6) * 31) + Long.hashCode(this.searchDurationMs)) * 31;
            String r8 = this.searchErrorMsg;
            int r9 = 0;
            if (r8 != null) goto L11;
            int r10 = 0;
        L12:
            int r11 = (((r7 + r10) * 31) + Integer.hashCode(this.searchErrorCode)) * 31;
            String r12 = this.searchKey;
            if (r12 == null) goto L16;
            r9 = r12.hashCode();
        L16:
            int r13 = (((r11 + r9) * 31) + Integer.hashCode(this.search_click_action)) * 31;
            boolean r14 = this.hasReported;
            if (r14 == true) goto L21;
            r2 = r14;
        L21:
            return r13 + r2;
        L11:
            r10 = r8.hashCode();
            goto L12
        }

        public String toString() {
            return "SearchState(searchResultSize=" + this.searchResultSize + ", inAppSearch=" + this.inAppSearch + ", searchSuccess=" + this.searchSuccess + ", searchDurationMs=" + this.searchDurationMs + ", searchErrorMsg=" + this.searchErrorMsg + ", searchErrorCode=" + this.searchErrorCode + ", searchKey=" + this.searchKey + ", search_click_action=" + this.search_click_action + ", hasReported=" + this.hasReported + ')';
        }

        public SearchState(int r1, boolean r2, boolean r3, long r4, String r6, int r7, String r8, int r9, boolean r10) {
            this.searchResultSize = r1;
            this.inAppSearch = r2;
            this.searchSuccess = r3;
            this.searchDurationMs = r4;
            this.searchErrorMsg = r6;
            this.searchErrorCode = r7;
            this.searchKey = r8;
            this.search_click_action = r9;
            this.hasReported = r10;
        }

        public /* synthetic */ SearchState(int r13, boolean r14, boolean r15, long r16, String r18, int r19, String r20, int r21, boolean r22, int r23, DefaultConstructorMarker r24) {
            if ((r23 & 256) == 0) goto L5;
            boolean r11 = false;
        L6:
            this(r13, r14, r15, r16, r18, r19, r20, r21, r11);
            return;
        L5:
            r11 = r22;
            goto L6
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

        public final int getSearch_click_action() {
            return this.search_click_action;
        }

        public final boolean getHasReported() {
            return this.hasReported;
        }

        public final void setHasReported(boolean r1) {
            this.hasReported = r1;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.util.SearchUtils$prepareSearchAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.util.SearchUtils$prepareSearchAsync$1", f = "SearchUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r7);
            long r6 = System.currentTimeMillis();
            InAppSearchClient.INSTANCE.prepareSearch();     // Catch: Throwable -> L8
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SearchUtils.TAG, "SearchUtils#prepareSearchAsync cost = " + (System.currentTimeMillis() - r6) + "ms");     // Catch: Throwable -> L8
            SearchUtils.access$getPrepareSearchRunning$p().set(false);
            return Unit.INSTANCE;
        L8:
            th = move-exception;
            SearchUtils.access$getPrepareSearchRunning$p().set(false);
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.util.SearchUtils$startSearchWithTimeOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.util.SearchUtils$startSearchWithTimeOut$1", f = "SearchUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $action;
        final /* synthetic */ ISearchCallBack $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ InAppSearchRequest $request;
        final /* synthetic */ long $timeoutMs;
        int label;

        C02101(String r1, long r2, InAppSearchRequest r4, ISearchCallBack r5, Context r6, Continuation<? super C02101> r7) {
            this.$action = r1;
            this.$timeoutMs = r2;
            this.$request = r4;
            this.$callback = r5;
            this.$context = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new C02101(this.$action, this.$timeoutMs, this.$request, this.$callback, this.$context, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C02101) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            final String r11 = "Contacts_" + this.$action;
            final long r2 = System.currentTimeMillis();
            SearchUtils r0 = SearchUtils.INSTANCE;
            long r4 = this.$timeoutMs;
            final ISearchCallBack r6 = this.$callback;
            SearchUtils.access$startTimer(r0, r11, r4, new C00361(r11, r2, r6));
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SearchUtils.TAG, "SearchUtils#startSearchWithTimeOut businessName = " + r11 + " , timeoutMs = " + this.$timeoutMs);
            InAppSearchClient r7 = InAppSearchClient.INSTANCE;
            InAppSearchRequest r8 = this.$request;
            final ISearchCallBack r5 = this.$callback;
            final Context r9 = this.$context;
            r7.startAppSearch(r11, r8, new AnonymousClass2(r11, r2, r5, r9));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.util.SearchUtils$stopSearchAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.util.SearchUtils$stopSearchAsync$1", f = "SearchUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C02121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $reason;
        int label;

        C02121(String r1, Continuation<? super C02121> r2) {
            this.$reason = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02121(this.$reason, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C02121) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r7);
            long r1 = System.currentTimeMillis();
            InAppSearchClient.INSTANCE.stopSearch();     // Catch: Throwable -> L8
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(SearchUtils.TAG, "SearchUtils#stopSearchAsync reason = " + this.$reason + " cost = " + (System.currentTimeMillis() - r1) + "ms");     // Catch: Throwable -> L8
            SearchUtils.access$getStopSearchRunning$p().set(false);
            return Unit.INSTANCE;
        L8:
            th = move-exception;
            SearchUtils.access$getStopSearchRunning$p().set(false);
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void $r8$lambda$TgdSGXAmzrNS4dCoz2S1FSugtQ0(SearchState r0) {
        reportSearchEventAndClear$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$hFLXngWbltiVWhhAgZWExWyh8Fc(Function0 r0, String r1) {
        startTimer$lambda$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$vm8riuQ3hnYiP_uiglSKCjPcP4k(SearchState r0) {
        reportSearchEvent$lambda$7$lambda$6(r0);
    }

    private SearchUtils() {
    }

    public static final /* synthetic */ AtomicBoolean access$getPrepareSearchRunning$p() {
        return prepareSearchRunning;
    }

    public static final /* synthetic */ AtomicBoolean access$getStopSearchRunning$p() {
        return stopSearchRunning;
    }

    public static final /* synthetic */ void access$startTimer(SearchUtils r0, String r1, long r2, Function0 r4) {
        r0.startTimer(r1, r2, r4);
    }

    public static final /* synthetic */ void access$stopTimer(SearchUtils r0, String r1) {
        r0.stopTimer(r1);
    }

    static {
        INSTANCE = new SearchUtils();
        HandlerThread r0 = new HandlerThread(TAG);
        handlerThread = r0;
        runnableMap = new LinkedHashMap();
        searchScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        prepareSearchRunning = new AtomicBoolean(false);
        stopSearchRunning = new AtomicBoolean(false);
        r0.start();
        handler = new Handler(r0.getLooper());
    }

    @JvmStatic
    public static final void prepareSearchAsync() {
        if (prepareSearchRunning.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(searchScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @JvmStatic
    public static final void stopSearchAsync(String r7) {
        Intrinsics.checkNotNullParameter(r7, "reason");
        if (stopSearchRunning.compareAndSet(false, true) == true) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SearchUtils#stopSearchAsync skip reason = " + r7);
        return;
    L6:
        BuildersKt.launch$default(searchScope, null, null, new C02121(r7, null), 3, null);
    }

    @JvmStatic
    public static final void startSearch(Context r7, InAppSearchRequest r8, String r9, ISearchCallBack r10) {
        Intrinsics.checkNotNullParameter(r8, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r9, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r10, "callback");
        startSearchWithTimeOut(r7, r8, Long.MAX_VALUE, r9, r10);
    }

    public static /* synthetic */ void startSearchWithTimeOut$default(Context r6, InAppSearchRequest r7, long r8, String r10, ISearchCallBack r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r8 = Long.MAX_VALUE;
    L5:
        startSearchWithTimeOut(r6, r7, r8, r10, r11);
    }

    @JvmStatic
    public static final void startSearchWithTimeOut(Context r12, InAppSearchRequest r13, long r14, String r16, ISearchCallBack r17) {
        Intrinsics.checkNotNullParameter(r13, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r16, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r17, "callback");
        BuildersKt.launch$default(searchScope, null, null, new C02101(r16, r14, r13, r17, r12, null), 3, null);
    }

    public static /* synthetic */ void startSearchWithTimeOutInCurThread$default(Context r6, InAppSearchRequest r7, long r8, String r10, ISearchCallBack r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r8 = Long.MAX_VALUE;
    L5:
        startSearchWithTimeOutInCurThread(r6, r7, r8, r10, r11);
    }

    @Deprecated(message = "Use startSearchWithTimeOut instead, which runs Binder IPC on Dispatchers.IO")
    @JvmStatic
    public static final void startSearchWithTimeOutInCurThread(final Context r6, InAppSearchRequest r7, long r8, String r10, final ISearchCallBack r11) {
        Intrinsics.checkNotNullParameter(r7, Ext.KEY_REQUEST);
        Intrinsics.checkNotNullParameter(r10, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r11, "callback");
        final String r12 = "Contacts_" + r10;
        final long r2 = System.currentTimeMillis();
        INSTANCE.startTimer(r12, r8, new C02111(r12, r2, r11));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "SearchUtils#startSearchWithTimeOut businessName = " + r12 + " , timeoutMs = " + r8);
        InAppSearchClient.INSTANCE.startAppSearch(r12, r7, new AnonymousClass2(r12, r2, r11, r6));
    }

    @JvmStatic
    public static final String getPhoneNumberBySearch(InAppSearchEntity r6, List<MetaTelephone> r7) {
        if (r6 == null) goto L12;
        List<InAppSearchEntityParam> r0 = r6.getParams();
        if (r0 == null) goto L12;
        Iterator<InAppSearchEntityParam> r1 = r0.iterator();
        String r2 = null;
    L8:
        if (r1.hasNext() == false) goto L13;
        InAppSearchEntityParam r3 = r1.next();
        if (TextUtils.equals(FIELD_KEY_PHONE, r3.getField()) == false) goto L8;
        r2 = r3.getKeyword();
    L13:
        if (r6 == null) goto L15;
        AppEntity r8 = r6.getAppEntity();
    L17:
        if ((r8 instanceof ContactEntity) == false) goto L19;
        ContactEntity r9 = (ContactEntity) r8;
    L20:
        if (r9 == null) goto L31;
        List<MetaTelephone> r10 = r9.getTelephones();
        if (r10 == null) goto L31;
        Iterator<MetaTelephone> r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L31;
        String r4 = r11.next().getTelephone();
        if (r2 == null) goto L25;
        if (StringsKt.contains$default(r4, r2, false, 2, null) == false) goto L25;
        return r4;
    L31:
        return null;
    L19:
        r9 = null;
        goto L20
    L15:
        r8 = null;
    L12:
        r2 = null;
        goto L13
    }

    @JvmStatic
    public static final HashMap<Long, List<String>> getSearchKeyMap(List<InAppSearchEntity> r8) {
        Intrinsics.checkNotNullParameter(r8, "inAppSearchResultList");
        HashMap<Long, List<String>> r0 = new HashMap();
        Iterator<InAppSearchEntity> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L17;
        InAppSearchEntity r1 = r9.next();
        ArrayList r2 = new ArrayList();
        long r3 = Long.parseLong(r1.getAppEntity().getId());
        Iterator<InAppSearchEntityParam> r4 = r1.getParams().iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        InAppSearchEntityParam r5 = r4.next();
        if (TextUtils.equals(r5.getField(), FIELD_KEY_NAME) == false) goto L12;
        r2.add(r5.getKeyword());
    L12:
        if (TextUtils.equals(r5.getField(), FIELD_KEY_PHONE) == false) goto L7;
        r2.add(r5.getKeyword());
        goto L7
    L15:
        if ((!r2.isEmpty()) == false) goto L4;
        r0.put(Long.valueOf(r3), r2);
        goto L4
    L17:
        return r0;
    }

    @JvmStatic
    public static final InAppSearchResult inAppSearchResultAddEntity(Context r7, InAppSearchResultWithoutEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        if (r7 == null) goto L5;
        ArrayList r0 = new ArrayList();
        Iterator<InAppSearchSimpleData> r1 = r8.getEntities().iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        InAppSearchSimpleData r2 = r1.next();
        List r4 = CollectionsKt.listOf(Long.valueOf(Long.parseLong(r2.getId())));
        if (r2.getType() != 201) goto L11;
        ContentResolver r3 = r7.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r3, "context.contentResolver");
        r0.add(new InAppSearchEntity(ContactEntityUtilKt.queryContactsByIds(r3, r4, false, false).get(0), r2.getParams()));
        goto L8
    L11:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "inAppSearchResultAddEntity type not contact, type = " + r2.getType());
        goto L8
    L13:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "inAppSearchResultAddEntity old size = " + r8.getEntities().size() + " , new size = " + r0.size() + ' ');
        return new InAppSearchResult(r0);
    L5:
        return new InAppSearchResult(new ArrayList());
    }

    public static /* synthetic */ void saveSearchState$default(int r10, boolean r11, boolean r12, long r13, String r15, int r16, String r17, int r18, int r19, Object r20) {
        if ((r19 & 128) == 0) goto L5;
        int r9 = -1;
    L6:
        saveSearchState(r10, r11, r12, r13, r15, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    @JvmStatic
    public static final void saveSearchState(int r12, boolean r13, boolean r14, long r15, String r17, int r18, String r19, int r20) {
        searchState = new SearchState(r12, r13, r14, r15, r17, r18, r19, r20, false);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "saveSearchState state is " + searchState);
    }

    @JvmStatic
    public static final void updateSearchClickAction(int r13) {
        SearchState r0 = searchState;
        if (r0 == null) goto L6;
        searchState = SearchState.copy$default(r0, 0, false, false, 0, null, 0, null, r13, false, 383, null);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updateSearchClickAction state is " + searchState);
        return;
    }

    @JvmStatic
    public static final void reportSearchEventAndClear() {
        final SearchState r0 = searchState;
        if (r0 != null) goto L5;
    L7:
        searchState = null;
        return;
    L5:
        if (r0.getHasReported() == true) goto L7;
        GlobalUtils.INSTANCE.execute(new SearchUtils$$ExternalSyntheticLambda0(r0));
        r0.setHasReported(true);
        goto L7
    }

    private static final void reportSearchEventAndClear$lambda$5$lambda$4(SearchState r11) {
        Intrinsics.checkNotNullParameter(r11, "$it");
        SearchEvent r0 = new SearchEvent(r11.getSearchResultSize(), r11.getInAppSearch(), r11.getSearchSuccess(), r11.getSearchDurationMs(), r11.getSearchErrorMsg(), r11.getSearchErrorCode(), r11.getSearchKey(), Integer.valueOf(r11.getSearch_click_action()));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "reportSearchEventAndClear event is " + r0);
        EventTrackerManager.INSTANCE.track(r0);
    }

    @JvmStatic
    public static final void reportSearchEvent() {
        final SearchState r0 = searchState;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getHasReported() == true) goto L9;
        GlobalUtils.INSTANCE.execute(new SearchUtils$$ExternalSyntheticLambda2(r0));
        r0.setHasReported(true);
        return;
    }

    private static final void reportSearchEvent$lambda$7$lambda$6(SearchState r11) {
        Intrinsics.checkNotNullParameter(r11, "$it");
        SearchEvent r0 = new SearchEvent(r11.getSearchResultSize(), r11.getInAppSearch(), r11.getSearchSuccess(), r11.getSearchDurationMs(), r11.getSearchErrorMsg(), r11.getSearchErrorCode(), r11.getSearchKey(), Integer.valueOf(r11.getSearch_click_action()));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "reportSearchEvent event is " + r0);
        EventTrackerManager.INSTANCE.track(r0);
    }

    private final void startTimer(final String r1, long r2, final Function0<Unit> r4) {
        stopTimer(r1);
        Runnable r0 = new SearchUtils$$ExternalSyntheticLambda1(r4, r1);
        runnableMap.put(r1, r0);
        handler.postDelayed(r0, r2);
    }

    private static final void startTimer$lambda$8(Function0 r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        Intrinsics.checkNotNullParameter(r2, "$identifier");
        r1.invoke();
        runnableMap.remove(r2);
    }

    private final void stopTimer(String r3) {
        Map<String, Runnable> r2 = runnableMap;
        Runnable r0 = r2.get(r3);
        if (r0 == null) goto L6;
        handler.removeCallbacks(r0);
        Runnable r4 = r2.remove(r3);
        return;
    }
}
