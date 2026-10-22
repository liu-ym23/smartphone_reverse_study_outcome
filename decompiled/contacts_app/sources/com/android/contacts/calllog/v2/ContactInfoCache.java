package com.android.contacts.calllog.v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.calllog.ContactInfo;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.UriUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.capabilitykit.common.Ext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: ContactInfoCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\r\u0018\u0000 C2\u00020\u0001:\u0004BCDEB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0018\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0016\u0010&\u001a\u00020\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0007J\u0006\u0010+\u001a\u00020\u0018J\u0010\u0010,\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010\u0007J\u0006\u0010-\u001a\u00020\u0018J\u001b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010$\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0002\u00100J%\u00101\u001a\u0004\u0018\u00010\b2\u0006\u00102\u001a\u00020\u00072\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000704H\u0002¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u0018J:\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180;2\u0016\b\u0002\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0018\u0018\u00010;J\u0006\u0010=\u001a\u00020\u0018J\u001c\u0010>\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010\u00072\b\u0010@\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010A\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\bH\u0002R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u0011\u001aB\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00140\u0014 \u0013* \u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u001e\u001aB\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00140\u0014 \u0013* \u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lcom/android/contacts/calllog/v2/ContactInfoCache;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lookupFn", "Lkotlin/Function2;", "", "Lcom/android/contacts/calllog/ContactInfo;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineDispatcher;)V", "cache", "com/android/contacts/calllog/v2/ContactInfoCache$cache$1", "Lcom/android/contacts/calllog/v2/ContactInfoCache$cache$1;", "generation", "Ljava/util/concurrent/atomic/AtomicInteger;", "inFlightKeys", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "pauseBarrier", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/CompletableDeferred;", "", "processingJob", "Lkotlinx/coroutines/Job;", "requestChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/android/contacts/calllog/v2/ContactInfoCache$LookupRequest;", "trackedKeys", "buildDiffValues", "Landroid/content/ContentValues;", "existing", AlogMonitor.ALOG_RESULT_INFO, "enqueue", "number", "countryIso", "flushPendingWrites", "writes", "", "Lcom/android/contacts/calllog/v2/ContactInfoCache$WriteEntry;", "get", "invalidate", "invalidateNumber", "pauseProcessing", "queryNumberInfos", "Lcom/android/contacts/numberassistant/NumberInfosManager$NumberInfos;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readCachedFromCallLog", "where", "args", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/android/contacts/calllog/ContactInfo;", "resumeProcessing", "startProcessing", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onUpdated", "Lkotlin/Function1;", "onSelfWriteChanged", "stopProcessing", "strEquals", "a", "b", "updateCallLogCache", "CacheEntry", "Companion", "LookupRequest", "WriteEntry", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactInfoCache {
    private static final String[] CACHED_PROJECTION = null;
    private static final int CACHE_SIZE = 200;
    public static final Companion Companion = null;
    private static final String PARAM_SKIP_OBRIC_DATA_AWARENESS = "obric_skip_data_awareness";
    private static final String TAG = "ContactInfoCache";
    private final ContactInfoCache$cache$1 cache;
    private final Context context;
    private final AtomicInteger generation;
    private final ConcurrentHashMap.KeySetView<String, Boolean> inFlightKeys;
    private final CoroutineDispatcher ioDispatcher;
    private final Function2<String, String, ContactInfo> lookupFn;
    private final AtomicReference<CompletableDeferred<Unit>> pauseBarrier;
    private Job processingJob;
    private final Channel<LookupRequest> requestChannel;
    private final ConcurrentHashMap.KeySetView<String, Boolean> trackedKeys;

    /* JADX INFO: compiled from: ContactInfoCache.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/android/contacts/calllog/v2/ContactInfoCache$CacheEntry;", "", AlogMonitor.ALOG_RESULT_INFO, "Lcom/android/contacts/calllog/ContactInfo;", "gen", "", "(Lcom/android/contacts/calllog/ContactInfo;I)V", "getGen", "()I", "getInfo", "()Lcom/android/contacts/calllog/ContactInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CacheEntry {

        /* JADX INFO: renamed from: gen, reason: collision with root package name */
        private final int f4gen;
        private final ContactInfo info;

        public static /* synthetic */ CacheEntry copy$default(CacheEntry r0, ContactInfo r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.info;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.f4gen;
        L9:
            return r0.copy(r1, r2);
        }

        public final ContactInfo component1() {
            return this.info;
        }

        public final int component2() {
            return this.f4gen;
        }

        public final CacheEntry copy(ContactInfo r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, AlogMonitor.ALOG_RESULT_INFO);
            return new CacheEntry(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof CacheEntry) == true) goto L8;
            return false;
        L8:
            CacheEntry r6 = (CacheEntry) r5;
            if (Intrinsics.areEqual(this.info, r6.info) == true) goto L12;
            return false;
        L12:
            if (this.f4gen == r6.f4gen) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.info.hashCode() * 31) + Integer.hashCode(this.f4gen);
        }

        public String toString() {
            return "CacheEntry(info=" + this.info + ", gen=" + this.f4gen + ')';
        }

        public CacheEntry(ContactInfo r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, AlogMonitor.ALOG_RESULT_INFO);
            this.info = r2;
            this.f4gen = r3;
        }

        public final int getGen() {
            return this.f4gen;
        }

        public final ContactInfo getInfo() {
            return this.info;
        }
    }

    /* JADX INFO: compiled from: ContactInfoCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/contacts/calllog/v2/ContactInfoCache$Companion;", "", "()V", "CACHED_PROJECTION", "", "", "[Ljava/lang/String;", "CACHE_SIZE", "", "PARAM_SKIP_OBRIC_DATA_AWARENESS", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ContactInfoCache.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/android/contacts/calllog/v2/ContactInfoCache$LookupRequest;", "", "number", "", "countryIso", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountryIso", "()Ljava/lang/String;", "key", "getKey", "getNumber", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LookupRequest {
        private final String countryIso;
        private final String number;

        public static /* synthetic */ LookupRequest copy$default(LookupRequest r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.number;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.countryIso;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.number;
        }

        public final String component2() {
            return this.countryIso;
        }

        public final LookupRequest copy(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "number");
            Intrinsics.checkNotNullParameter(r2, "countryIso");
            return new LookupRequest(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof LookupRequest) == true) goto L8;
            return false;
        L8:
            LookupRequest r6 = (LookupRequest) r5;
            if (Intrinsics.areEqual(this.number, r6.number) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.countryIso, r6.countryIso) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.number.hashCode() * 31) + this.countryIso.hashCode();
        }

        public String toString() {
            return "LookupRequest(number=" + this.number + ", countryIso=" + this.countryIso + ')';
        }

        public LookupRequest(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "number");
            Intrinsics.checkNotNullParameter(r3, "countryIso");
            this.number = r2;
            this.countryIso = r3;
        }

        public final String getCountryIso() {
            return this.countryIso;
        }

        public final String getNumber() {
            return this.number;
        }

        public final String getKey() {
            return this.number + '#' + this.countryIso;
        }
    }

    /* JADX INFO: compiled from: ContactInfoCache.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/android/contacts/calllog/v2/ContactInfoCache$WriteEntry;", "", "number", "", "countryIso", AlogMonitor.ALOG_RESULT_INFO, "Lcom/android/contacts/calllog/ContactInfo;", "(Ljava/lang/String;Ljava/lang/String;Lcom/android/contacts/calllog/ContactInfo;)V", "getCountryIso", "()Ljava/lang/String;", "getInfo", "()Lcom/android/contacts/calllog/ContactInfo;", "getNumber", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class WriteEntry {
        private final String countryIso;
        private final ContactInfo info;
        private final String number;

        public static /* synthetic */ WriteEntry copy$default(WriteEntry r0, String r1, String r2, ContactInfo r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.number;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.countryIso;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.info;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.number;
        }

        public final String component2() {
            return this.countryIso;
        }

        public final ContactInfo component3() {
            return this.info;
        }

        public final WriteEntry copy(String r1, String r2, ContactInfo r3) {
            Intrinsics.checkNotNullParameter(r1, "number");
            Intrinsics.checkNotNullParameter(r2, "countryIso");
            Intrinsics.checkNotNullParameter(r3, AlogMonitor.ALOG_RESULT_INFO);
            return new WriteEntry(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof WriteEntry) == true) goto L8;
            return false;
        L8:
            WriteEntry r6 = (WriteEntry) r5;
            if (Intrinsics.areEqual(this.number, r6.number) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.countryIso, r6.countryIso) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.info, r6.info) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.number.hashCode() * 31) + this.countryIso.hashCode()) * 31) + this.info.hashCode();
        }

        public String toString() {
            return "WriteEntry(number=" + this.number + ", countryIso=" + this.countryIso + ", info=" + this.info + ')';
        }

        public WriteEntry(String r2, String r3, ContactInfo r4) {
            Intrinsics.checkNotNullParameter(r2, "number");
            Intrinsics.checkNotNullParameter(r3, "countryIso");
            Intrinsics.checkNotNullParameter(r4, AlogMonitor.ALOG_RESULT_INFO);
            this.number = r2;
            this.countryIso = r3;
            this.info = r4;
        }

        public final String getCountryIso() {
            return this.countryIso;
        }

        public final ContactInfo getInfo() {
            return this.info;
        }

        public final String getNumber() {
            return this.number;
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.v2.ContactInfoCache$startProcessing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ContactInfoCache.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.v2.ContactInfoCache$startProcessing$1", f = "ContactInfoCache.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4}, l = {125, WorkQueueKt.MASK, 142, 154, 173}, m = "invokeSuspend", n = {"pendingWrites", "pendingWrites", Ext.KEY_REQUEST, "pendingWrites", Ext.KEY_REQUEST, AlogMonitor.ALOG_RESULT_INFO, "pendingWrites", Ext.KEY_REQUEST, AlogMonitor.ALOG_RESULT_INFO, "pendingWrites"}, s = {"L$0", "L$0", "L$2", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0"})
    static final class C01851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $onSelfWriteChanged;
        final /* synthetic */ Function1<String, Unit> $onUpdated;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ContactInfoCache this$0;

        /* JADX INFO: renamed from: com.android.contacts.calllog.v2.ContactInfoCache$startProcessing$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ContactInfoCache.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.android.contacts.calllog.v2.ContactInfoCache$startProcessing$1$1", f = "ContactInfoCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<String, Unit> $onUpdated;
            final /* synthetic */ LookupRequest $request;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            C00261(Function1<? super String, Unit> r1, LookupRequest r2, Continuation<? super C00261> r3) {
                this.$onUpdated = r1;
                this.$request = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00261(this.$onUpdated, this.$request, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00261) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$onUpdated.invoke(this.$request.getNumber());
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.android.contacts.calllog.v2.ContactInfoCache$startProcessing$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ContactInfoCache.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.android.contacts.calllog.v2.ContactInfoCache$startProcessing$1$2", f = "ContactInfoCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $onSelfWriteChanged;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function1<? super Boolean, Unit> r1, Continuation<? super AnonymousClass2> r2) {
                this.$onSelfWriteChanged = r1;
                super(2, r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return new AnonymousClass2(this.$onSelfWriteChanged, r2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r2);
                Function1<Boolean, Unit> r1 = this.$onSelfWriteChanged;
                if (r1 == null) goto L7;
                r1.invoke(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            L7:
                return null;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        C01851(ContactInfoCache r1, Function1<? super Boolean, Unit> r2, Function1<? super String, Unit> r3, Continuation<? super C01851> r4) {
            this.this$0 = r1;
            this.$onSelfWriteChanged = r2;
            this.$onUpdated = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01851(this.this$0, this.$onSelfWriteChanged, this.$onUpdated, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01851) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00fb -> B:26:0x008f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0245 -> B:26:0x008f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0277 -> B:26:0x008f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L25;
            if (r1 == 1) goto L23;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L12;
            if (r1 != 5) goto L11;
            ChannelIterator r2 = (ChannelIterator) this.L$1;
            List r8 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);
            ArrayList r16 = r8;
        L26:
            this.L$0 = r16;
            this.L$1 = r2;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 1;
            Object r9 = r2.hasNext(this);
            if (r9 != r0) goto L29;
            return r0;
        L29:
            List r10 = r16;
            r15 = r9;
        L24:
            ChannelIterator r11 = r2;
            if (((Boolean) r15).booleanValue() == false) goto L92;
            LookupRequest r3 = (LookupRequest) r11.next();
            CompletableDeferred r17 = (CompletableDeferred) ContactInfoCache.access$getPauseBarrier$p(this.this$0).get();
            if (r17 == null) goto L37;
            this.L$0 = r10;
            this.L$1 = r11;
            this.L$2 = r3;
            this.label = 2;
            if (r17.await(this) != r0) goto L37;
            return r0;
        L37:
            r16 = r10;
            ChannelIterator r13 = r11;
            LookupRequest r12 = r3;
            r2 = r13;
            CacheEntry r14 = ContactInfoCache.access$getCache$p(this.this$0).get(r12.getKey());     // Catch: Throwable -> L18 Exception -> L69
            if (r14 != null) goto L41;
        L43:
            ContactInfo r18 = (ContactInfo) ContactInfoCache.access$getLookupFn$p(this.this$0).invoke(r12.getNumber(), r12.getCountryIso());     // Catch: Throwable -> L18 Exception -> L69
            if (r18 != null) goto L46;
            ContactInfo r19 = new ContactInfo();     // Catch: Throwable -> L18 Exception -> L69
            r19.number = r12.getNumber();     // Catch: Throwable -> L18 Exception -> L69
            r19.formattedNumber = ContactsUtils.formatNumber(r12.getNumber());     // Catch: Throwable -> L18 Exception -> L69
        L47:
            if (r18 != null) goto L63;
            this.L$0 = r16;     // Catch: Throwable -> L18 Exception -> L69
            this.L$1 = r2;     // Catch: Throwable -> L18 Exception -> L69
            this.L$2 = r12;     // Catch: Throwable -> L18 Exception -> L69
            this.L$3 = r19;     // Catch: Throwable -> L18 Exception -> L69
            this.label = 3;     // Catch: Throwable -> L18 Exception -> L69
            Object r20 = ContactInfoCache.access$queryNumberInfos(this.this$0, r12.getNumber(), this);     // Catch: Throwable -> L18 Exception -> L69
            if (r20 != r0) goto L51;
            return r0;
        L51:
            ContactInfo r110 = r19;
            List r111 = r16;
            r15 = r20;
            ChannelIterator r21 = r2;
            ContactInfo r4 = r110;
        L52:
            NumberInfosManager.NumberInfos r112 = (NumberInfosManager.NumberInfos) r15;     // Catch: Throwable -> L18 Exception -> L20
            if (r112 == null) goto L64;
            String r113 = r112.getLabel();     // Catch: Throwable -> L18 Exception -> L20
            String r114 = "";
            if (r113 != null) goto L58;
            r113 = "";
        L58:
            r4.label = r113;     // Catch: Throwable -> L18 Exception -> L20
            String r115 = r112.getLocation();     // Catch: Throwable -> L18 Exception -> L20
            if (r115 == null) goto L62;
            r114 = r115;
        L62:
            r4.location = r114;     // Catch: Throwable -> L18 Exception -> L20
            r4.hasMarked = r112.isMarked();     // Catch: Throwable -> L18 Exception -> L20
            r4.numberMainMarkClassify = r112.getNumberMainMarkClassify();     // Catch: Throwable -> L18 Exception -> L20
        L64:
            ContactInfoCache.access$getCache$p(this.this$0).put(r12.getKey(), new CacheEntry(r4, ContactInfoCache.access$getGeneration$p(this.this$0).get()));     // Catch: Throwable -> L18 Exception -> L20
            ContactInfoCache.access$getTrackedKeys$p(this.this$0).add(r12.getKey());     // Catch: Throwable -> L18 Exception -> L20
            this.L$0 = r111;     // Catch: Throwable -> L18 Exception -> L20
            this.L$1 = r21;     // Catch: Throwable -> L18 Exception -> L20
            this.L$2 = r12;     // Catch: Throwable -> L18 Exception -> L20
            this.L$3 = r4;     // Catch: Throwable -> L18 Exception -> L20
            this.label = 4;     // Catch: Throwable -> L18 Exception -> L20
            if (BuildersKt.withContext(Dispatchers.getMain(), new C00261(this.$onUpdated, r12, null), this) != r0) goto L67;
            return r0;
        L67:
            r111.add(new WriteEntry(r12.getNumber(), r12.getCountryIso(), r4));     // Catch: Throwable -> L18 Exception -> L20
        L68:
            ContactInfoCache.access$getInFlightKeys$p(this.this$0).remove(r12.getKey());
            r2 = r21;
            r16 = r111;
            if (ContactInfoCache.access$getRequestChannel$p(this.this$0).isEmpty() == false) goto L26;
            Function1<Boolean, Unit> r22 = this.$onSelfWriteChanged;
            if (r22 == null) goto L86;
            r22.invoke(Boxing.boxBoolean(true));
        L86:
            ContactInfoCache.access$flushPendingWrites(this.this$0, r16);
            this.L$0 = r16;
            this.L$1 = r2;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 5;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$onSelfWriteChanged, null), this) != r0) goto L26;
            return r0;
        L63:
            r21 = r2;
            r4 = r19;
            r111 = r16;
            goto L64
        L46:
            r19 = r18;
            goto L47
        L41:
            if (r14.getGen() < ContactInfoCache.access$getGeneration$p(this.this$0).get()) goto L43;
            ContactInfoCache.access$getInFlightKeys$p(this.this$0).remove(r12.getKey());
            goto L26
        L69:
            e = move-exception;
            r111 = r16;
            e = e;
            r21 = r2;
        L73:
            if (ContactsUtils.USER_LOG_ON == false) goto L75;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ContactInfoCache.TAG, "lookup failed for " + r12.getNumber(), e);     // Catch: Throwable -> L18
            goto L68
        L75:
            StringBuilder r5 = new StringBuilder().append("lookup failed, hasNumber=");     // Catch: Throwable -> L18
            if (r12.getNumber().length() <= 0) goto L78;
            boolean r116 = true;
        L79:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(ContactInfoCache.TAG, r5.append(r116).toString(), e);     // Catch: Throwable -> L18
            goto L68
        L78:
            r116 = false;
            goto L79
        L92:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            r4 = (ContactInfo) this.L$3;
            r12 = (LookupRequest) this.L$2;
            r21 = (ChannelIterator) this.L$1;
            r111 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L18 Exception -> L20
            goto L67
        L15:
            r4 = (ContactInfo) this.L$3;
            r12 = (LookupRequest) this.L$2;
            r21 = (ChannelIterator) this.L$1;
            r111 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L18 Exception -> L20
            goto L52
        L22:
            r3 = (LookupRequest) this.L$2;
            r11 = (ChannelIterator) this.L$1;
            r10 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);
            goto L37
        L23:
            r2 = (ChannelIterator) this.L$1;
            List r23 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);
            r10 = r23;
            goto L24
        L25:
            ResultKt.throwOnFailure(r15);
            r16 = new ArrayList();
            r2 = ContactInfoCache.access$getRequestChannel$p(this.this$0).iterator();
        L20:
            e = e;
        L18:
            th = move-exception;
            ContactInfoCache.access$getInFlightKeys$p(this.this$0).remove(r12.getKey());
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.android.contacts.calllog.v2.ContactInfoCache$cache$1] */
    public ContactInfoCache(Context r2, Function2<? super String, ? super String, ContactInfo> r3, CoroutineDispatcher r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lookupFn");
        Intrinsics.checkNotNullParameter(r4, "ioDispatcher");
        this.context = r2;
        this.lookupFn = r3;
        this.ioDispatcher = r4;
        this.trackedKeys = ConcurrentHashMap.newKeySet();
        this.cache = new ContactInfoCache$cache$1(this);
        this.generation = new AtomicInteger(0);
        this.requestChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.inFlightKeys = ConcurrentHashMap.newKeySet();
        this.pauseBarrier = new AtomicReference(null);
    }

    public static final /* synthetic */ void access$flushPendingWrites(ContactInfoCache r0, List r1) {
        r0.flushPendingWrites(r1);
    }

    public static final /* synthetic */ ContactInfoCache$cache$1 access$getCache$p(ContactInfoCache r0) {
        return r0.cache;
    }

    public static final /* synthetic */ AtomicInteger access$getGeneration$p(ContactInfoCache r0) {
        return r0.generation;
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView access$getInFlightKeys$p(ContactInfoCache r0) {
        return r0.inFlightKeys;
    }

    public static final /* synthetic */ Function2 access$getLookupFn$p(ContactInfoCache r0) {
        return r0.lookupFn;
    }

    public static final /* synthetic */ AtomicReference access$getPauseBarrier$p(ContactInfoCache r0) {
        return r0.pauseBarrier;
    }

    public static final /* synthetic */ Channel access$getRequestChannel$p(ContactInfoCache r0) {
        return r0.requestChannel;
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView access$getTrackedKeys$p(ContactInfoCache r0) {
        return r0.trackedKeys;
    }

    public static final /* synthetic */ Object access$queryNumberInfos(ContactInfoCache r0, String r1, Continuation r2) {
        return r0.queryNumberInfos(r1, r2);
    }

    public /* synthetic */ ContactInfoCache(Context r1, Function2 r2, CoroutineDispatcher r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = Dispatchers.getIO();
    L5:
        this(r1, r2, r3);
    }

    public ContactInfoCache(final Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, new AnonymousClass1(r8), null, 4, null);
    }

    public final ContactInfo get(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "number");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        CacheEntry r1 = get(r4 + '#' + r5);
        if (r1 != null) goto L16;
        enqueue(r4, r5);
        return null;
    L16:
        if (r1.getGen() >= this.generation.get()) goto L19;
        enqueue(r4, r5);
    L19:
        return r1.getInfo();
    L5:
        r0 = false;
        goto L7
    }

    public final void invalidate() {
        this.generation.incrementAndGet();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "invalidate: generation=" + this.generation.get());
        ConcurrentHashMap.KeySetView<String, Boolean> r0 = this.trackedKeys;
        Intrinsics.checkNotNullExpressionValue(r0, "trackedKeys");
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) r1.next();
        Intrinsics.checkNotNullExpressionValue(r2, "key");
        int r3 = StringsKt.indexOf$default(r2, '#', 0, false, 6, null);
        if (r3 < 0) goto L4;
        String r4 = r2.substring(0, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        String r5 = r2.substring(r3 + 1);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        enqueue(r4, r5);
        goto L4
    }

    public final void invalidateNumber(String r12) {
        String r0 = r12;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap.KeySetView<String, Boolean> r3 = this.trackedKeys;
        Intrinsics.checkNotNullExpressionValue(r3, "trackedKeys");
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L20;
        String r5 = (String) r4.next();
        Intrinsics.checkNotNullExpressionValue(r5, "key");
        int r6 = StringsKt.indexOf$default(r5, '#', 0, false, 6, null);
        if (r6 < 0) goto L13;
        if (Intrinsics.areEqual(StringsKt.take(r5, r6), r12) == false) goto L13;
        String r7 = r5.substring(r6 + 1);
        Intrinsics.checkNotNullExpressionValue(r7, "substring(...)");
        remove(r5);
        enqueue(r12, r7);
        r1 = true;
        goto L13
    L20:
        if (r1 == true) goto L30;
        enqueue(r12, "");
        return;
    L30:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startProcessing$default(ContactInfoCache r0, CoroutineScope r1, Function1 r2, Function1 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.startProcessing(r1, r2, r3);
    }

    public final void startProcessing(CoroutineScope r8, Function1<? super String, Unit> r9, Function1<? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "onUpdated");
        Job r0 = this.processingJob;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        this.processingJob = BuildersKt.launch$default(r8, this.ioDispatcher, null, new C01851(this, r10, r9, null), 2, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void stopProcessing() {
        Job r0 = this.processingJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.processingJob = null;
    }

    public final void pauseProcessing() {
        if (this.pauseBarrier.get() != null) goto L6;
        this.pauseBarrier.set(CompletableDeferredKt.CompletableDeferred$default(null, 1, null));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "pauseProcessing");
        return;
    }

    public final void resumeProcessing() {
        CompletableDeferred<Unit> r1 = this.pauseBarrier.getAndSet(null);
        if (r1 == null) goto L5;
        r1.complete(Unit.INSTANCE);
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "resumeProcessing");
    }

    private final void enqueue(String r3, String r4) {
        if (this.inFlightKeys.add(r3 + '#' + r4) == true) goto L5;
        return;
    L5:
        this.requestChannel.mo2321trySendJP2dKIU(new LookupRequest(r3, r4));
    }

    private final Object queryNumberInfos(String r4, Continuation<? super NumberInfosManager.NumberInfos> r5) {
        NumberInfosManager r3 = NumberInfosManager.getInstance();
        if (r3 != null) goto L6;
        return null;
    L6:
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r5));
        final SafeContinuation r1 = r0;
        r3.getBaseAndMarkInfos(r4, new ContactInfoCache$queryNumberInfos$2$1(r1));
        Object r6 = r0.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L9:
        return r6;
    }

    private final void flushPendingWrites(List<WriteEntry> r5) {
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<WriteEntry> r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        WriteEntry r1 = r0.next();
        updateCallLogCache(r1.getNumber(), r1.getCountryIso(), r1.getInfo());
        goto L7
    L9:
        r5.clear();
    }

    private final void updateCallLogCache(String r13, String r14, ContactInfo r15) {
        StringBuilder r7 = new StringBuilder("number = ?");
        String r8 = r14;
        if (TextUtils.isEmpty(r8) == false) goto L5;
        r7.append(" AND countryiso IS NULL");
    L6:
        String r9 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        boolean r10 = true;
        if (TextUtils.isEmpty(r8) == false) goto L9;
        String[] r16 = {r13};
    L57:
        ContactInfo r11 = readCachedFromCallLog(r9, r16);     // Catch: Exception -> L54
        if (r11 != null) goto L22;
        ContactInfoCache r12 = this;     // Catch: Exception -> L54
        if (ContactsUtils.USER_LOG_ON == false) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "updateCallLogCache: no existing row for number=" + r13 + ", skip update");     // Catch: Exception -> L54
        return;
    L16:
        StringBuilder r17 = new StringBuilder("updateCallLogCache: no existing row, hasNumber=");     // Catch: Exception -> L54
        if (r13.length() > 0) goto L20;
        r10 = false;
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r17.append(r10).append(", skip update").toString());     // Catch: Exception -> L54
        return;
    L22:
        ContentValues r5 = buildDiffValues(r11, r15);     // Catch: Exception -> L54
        if (r5.size() != 0) goto L35;
        if (ContactsUtils.USER_LOG_ON == false) goto L27;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "updateCallLogCache: no diff for number=" + r13 + ", skip update");     // Catch: Exception -> L54
        return;
    L27:
        StringBuilder r18 = new StringBuilder("updateCallLogCache: no diff, hasNumber=");     // Catch: Exception -> L54
        if (r13.length() > 0) goto L31;
        r10 = false;
    L31:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r18.append(r10).append(", skip update").toString());     // Catch: Exception -> L54
        return;
    L35:
        if (ContactsUtils.USER_LOG_ON == false) goto L37;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "updateCallLogCache: number=" + r13 + ", name=" + r15.name + ", diffKeys=" + r5.keySet());     // Catch: Exception -> L54
    L52:
        this.context.getContentResolver().update(Uri.parse("content://call_log/calls?obric_skip_data_awareness=true"), r5, r9, r16);     // Catch: Exception -> L54
        return;
    L37:
        StringBuilder r1 = new StringBuilder("updateCallLogCache: hasNumber=");     // Catch: Exception -> L54
        if (r13.length() <= 0) goto L40;
        boolean r19 = true;
    L41:
        StringBuilder r110 = r1.append(r19).append(", hasName=");     // Catch: Exception -> L54
        String r111 = r15.name;     // Catch: Exception -> L54
        if (r111 != null) goto L44;
    L47:
        boolean r112 = true;
    L48:
        if (r112 == false) goto L51;
        r10 = false;
    L51:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r110.append(r10).append(", diffKeys=").append(r5.keySet()).toString());     // Catch: Exception -> L54
        goto L52
    L44:
        if (r111.length() == 0) goto L47;
        r112 = false;
        goto L48
    L40:
        r19 = false;
    L54:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "updateCallLogCache failed", e);
        return;
    L9:
        r16 = new String[]{r13, r14};
        goto L57
    L5:
        r7.append(" AND countryiso = ?");
        goto L6
    }

    private final ContactInfo readCachedFromCallLog(String r7, String[] r8) {
        Cursor r6 = this.context.getContentResolver().query(CallLog.Calls.CONTENT_URI, CACHED_PROJECTION, r7, r8, "date DESC LIMIT 1");
        if (r6 == null) goto L41;
        Cursor r9 = r6;
        Cursor r10 = r9;     // Catch: Throwable -> L36
        if (r10.moveToFirst() == true) goto L9;
        CloseableKt.closeFinally(r9, null);
        return null;
    L9:
        ContactInfo r0 = new ContactInfo();     // Catch: Throwable -> L36
        String r1 = r10.getString(0);     // Catch: Throwable -> L36
        String r2 = "";
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        r0.name = r1;     // Catch: Throwable -> L36
        r0.type = r10.getInt(1);     // Catch: Throwable -> L36
        String r3 = r10.getString(2);     // Catch: Throwable -> L36
        if (r3 != null) goto L16;
        r3 = "";
    L16:
        r0.label = r3;     // Catch: Throwable -> L36
        String r4 = r10.getString(3);     // Catch: Throwable -> L36
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        r0.location = r4;     // Catch: Throwable -> L36
        r0.lookupUri = UriUtils.parseUriOrNull(r10.getString(4));     // Catch: Throwable -> L36
        String r5 = r10.getString(5);     // Catch: Throwable -> L36
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        r0.number = r5;     // Catch: Throwable -> L36
        String r11 = r10.getString(6);     // Catch: Throwable -> L36
        if (r11 != null) goto L25;
        r11 = "";
    L25:
        r0.normalizedNumber = r11;     // Catch: Throwable -> L36
        String r12 = r10.getString(7);     // Catch: Throwable -> L36
        if (r12 == null) goto L29;
        r2 = r12;
    L29:
        r0.formattedNumber = r2;     // Catch: Throwable -> L36
        r0.photoId = r10.getLong(8);     // Catch: Throwable -> L36
        String r13 = r10.getString(9);     // Catch: Throwable -> L36
        if (r13 == null) goto L32;
        Intrinsics.checkNotNullExpressionValue(r13, "getString(9)");     // Catch: Throwable -> L36
        Uri r14 = Uri.parse(r13);     // Catch: Throwable -> L36
    L33:
        r0.photoUri = r14;     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r9, null);
        return r0;
    L32:
        r14 = null;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L41:
        return null;
    }

    private final ContentValues buildDiffValues(ContactInfo r6, ContactInfo r7) {
        ContentValues r0 = new ContentValues();
        if (strEquals(r6.name, r7.name) == true) goto L6;
        r0.put("name", r7.name);
    L6:
        if (r6.type == r7.type) goto L9;
        r0.put("numbertype", Integer.valueOf(r7.type));
    L9:
        if (strEquals(r6.label, r7.label) == true) goto L12;
        r0.put("numberlabel", r7.label);
    L12:
        if (strEquals(r6.location, r7.location) == true) goto L14;
        r0.put("geocoded_location", r7.location);
    L14:
        String r1 = UriUtils.uriToString(r7.lookupUri);
        if (strEquals(UriUtils.uriToString(r6.lookupUri), r1) == true) goto L18;
        r0.put(BlockedCallAdapter.KEY_LOOKUP_URI, r1);
    L18:
        if (strEquals(r6.number, r7.number) == true) goto L21;
        r0.put("matched_number", r7.number);
    L21:
        if (strEquals(r6.normalizedNumber, r7.normalizedNumber) == true) goto L24;
        r0.put("normalized_number", r7.normalizedNumber);
    L24:
        if (strEquals(r6.formattedNumber, r7.formattedNumber) == true) goto L27;
        r0.put("formatted_number", r7.formattedNumber);
    L27:
        if (r6.photoId == r7.photoId) goto L29;
        r0.put("photo_id", Long.valueOf(r7.photoId));
    L29:
        Uri r8 = r7.photoUri;
        String r2 = null;
        if (r8 == null) goto L32;
        String r9 = r8.toString();
    L33:
        Uri r10 = r6.photoUri;
        if (r10 == null) goto L37;
        r2 = r10.toString();
    L37:
        if (strEquals(r2, r9) == true) goto L39;
        r0.put("photo_uri", r9);
    L39:
        return r0;
    L32:
        r9 = null;
        goto L33
    }

    private final boolean strEquals(String r1, String r2) {
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        return Intrinsics.areEqual(r1, r2);
    }

    static {
        Companion = new Companion(null);
        CACHED_PROJECTION = new String[]{"name", "numbertype", "numberlabel", "geocoded_location", BlockedCallAdapter.KEY_LOOKUP_URI, "matched_number", "normalized_number", "formatted_number", "photo_id", "photo_uri"};
    }
}
