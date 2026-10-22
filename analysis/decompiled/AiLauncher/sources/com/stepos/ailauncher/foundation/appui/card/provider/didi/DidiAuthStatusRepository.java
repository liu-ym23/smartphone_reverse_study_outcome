package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import Ua.L0;
import android.os.SystemClock;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthorizationState;
import com.stepos.net.HttpManager;
import eb.InterfaceC4021a;
import h9.InterfaceC4149a;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\f*\u0001B\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003JKLB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u0003J2\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b&\u0010'J*\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0018028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020;0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010+R\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001d\u0010I\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H¨\u0006M"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository;", "", "<init>", "()V", "", "x", "()Z", "", "thirdUid", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "y", "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "t", "(Ljava/lang/String;)Z", "LY8/t;", "u", "(Ljava/lang/String;)V", "deviceId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/l;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$CacheSource;", "source", "", "ageMs", "C", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$CacheSource;J)Z", "dto", "B", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;Ljava/lang/String;Ljava/lang/String;)Z", "reason", "m", "(Ljava/lang/String;Ljava/lang/String;)V", "q", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusApi;", "service", HomeGestureEligibilityContract.EXTRA_GENERATION, "r", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusApi;Ljava/lang/String;Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "p", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusApi;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "BASE_URL_KEY", "POSITIVE_TTL_MS", "J", "LUa/M;", "scope", "LUa/M;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$a;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "generations", "Leb/a;", "mutex", "Leb/a;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$b;", "inflight", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "accountObserverInstalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "activeAccountId", "com/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$d", "accountCallback", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$d;", "api$delegate", "LY8/h;", "s", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusApi;", "api", "CacheSource", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiAuthStatusRepository {
    private static final String BASE_URL_KEY = "didiOauth";
    private static final long POSITIVE_TTL_MS = 600000;
    private static final String TAG = "DidiAuthStatusRepo";
    public static final DidiAuthStatusRepository INSTANCE = new DidiAuthStatusRepository();
    private static final Ua.M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.b()));
    private static final ConcurrentHashMap<String, CachedAuth> cache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Long> generations = new ConcurrentHashMap<>();
    private static final InterfaceC4021a mutex = eb.f.b(false, 1, null);
    private static final Map<String, Inflight> inflight = new LinkedHashMap();
    private static final AtomicBoolean accountObserverInstalled = new AtomicBoolean(false);
    private static volatile String activeAccountId = "";
    private static final d accountCallback = new d();

    /* renamed from: api$delegate, reason: from kotlin metadata */
    private static final Y8.h api = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.s
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return DidiAuthStatusRepository.l();
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$CacheSource;", "", "<init>", "(Ljava/lang/String;I)V", "NETWORK", "PERSISTED", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CacheSource {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ CacheSource[] $VALUES;
        public static final CacheSource NETWORK = new CacheSource("NETWORK", 0);
        public static final CacheSource PERSISTED = new CacheSource("PERSISTED", 1);

        private static final /* synthetic */ CacheSource[] $values() {
            return new CacheSource[]{NETWORK, PERSISTED};
        }

        static {
            CacheSource[] cacheSourceArr$values = $values();
            $VALUES = cacheSourceArr$values;
            $ENTRIES = kotlin.enums.a.a(cacheSourceArr$values);
        }

        private CacheSource(String str, int i10) {
        }

        public static InterfaceC4149a<CacheSource> getEntries() {
            return $ENTRIES;
        }

        public static CacheSource valueOf(String str) {
            return (CacheSource) Enum.valueOf(CacheSource.class, str);
        }

        public static CacheSource[] values() {
            return (CacheSource[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$a;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "dto", "", "atElapsed", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$CacheSource;", "source", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;JLcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$CacheSource;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "J", Const.INTENT_KEY_APIKEY, "()J", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$CacheSource;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$CacheSource;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$a, reason: from toString */
    public static final /* data */ class CachedAuth {
        private final long atElapsed;
        private final DidiAuthStatusDto dto;
        private final CacheSource source;

        public CachedAuth(DidiAuthStatusDto dto, long j10, CacheSource source) {
            kotlin.jvm.internal.p.i(dto, "dto");
            kotlin.jvm.internal.p.i(source, "source");
            this.dto = dto;
            this.atElapsed = j10;
            this.source = source;
        }

        /* renamed from: a, reason: from getter */
        public final long getAtElapsed() {
            return this.atElapsed;
        }

        /* renamed from: b, reason: from getter */
        public final DidiAuthStatusDto getDto() {
            return this.dto;
        }

        /* renamed from: c, reason: from getter */
        public final CacheSource getSource() {
            return this.source;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedAuth)) {
                return false;
            }
            CachedAuth cachedAuth = (CachedAuth) other;
            return kotlin.jvm.internal.p.d(this.dto, cachedAuth.dto) && this.atElapsed == cachedAuth.atElapsed && this.source == cachedAuth.source;
        }

        public int hashCode() {
            return (((this.dto.hashCode() * 31) + Long.hashCode(this.atElapsed)) * 31) + this.source.hashCode();
        }

        public String toString() {
            return "CachedAuth(dto=" + this.dto + ", atElapsed=" + this.atElapsed + ", source=" + this.source + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$b;", "", "", HomeGestureEligibilityContract.EXTRA_GENERATION, "LUa/Q;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "deferred", "<init>", "(JLUa/Q;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", Const.INTENT_KEY_PKGNAME, "()J", "LUa/Q;", Const.INTENT_KEY_APIKEY, "()LUa/Q;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$b, reason: from toString */
    public static final /* data */ class Inflight {
        private final Ua.Q<DidiAuthStatusDto> deferred;
        private final long generation;

        public Inflight(long j10, Ua.Q<DidiAuthStatusDto> deferred) {
            kotlin.jvm.internal.p.i(deferred, "deferred");
            this.generation = j10;
            this.deferred = deferred;
        }

        public final Ua.Q<DidiAuthStatusDto> a() {
            return this.deferred;
        }

        /* renamed from: b, reason: from getter */
        public final long getGeneration() {
            return this.generation;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Inflight)) {
                return false;
            }
            Inflight inflight = (Inflight) other;
            return this.generation == inflight.generation && kotlin.jvm.internal.p.d(this.deferred, inflight.deferred);
        }

        public int hashCode() {
            return (Long.hashCode(this.generation) * 31) + this.deferred.hashCode();
        }

        public String toString() {
            return "Inflight(generation=" + this.generation + ", deferred=" + this.deferred + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CacheSource.values().length];
            try {
                iArr[CacheSource.PERSISTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CacheSource.NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DidiAuthorizationState.values().length];
            try {
                iArr2[DidiAuthorizationState.AUTHORIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[DidiAuthorizationState.NOT_AUTHORIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[DidiAuthorizationState.INDETERMINATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/didi/DidiAuthStatusRepository$d", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements com.stepos.ailauncher.foundation.account.i {
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) throws NoSuchAlgorithmException {
            String accountId = accountInfo != null ? accountInfo.getAccountId() : null;
            if (accountId == null) {
                accountId = "";
            }
            String str = DidiAuthStatusRepository.activeAccountId;
            if (kotlin.jvm.internal.p.d(str, accountId)) {
                return;
            }
            DidiAuthStatusRepository.activeAccountId = accountId;
            if (str.length() > 0) {
                DidiAuthStatusRepository.INSTANCE.m(str, "account_changed");
            } else {
                DidiAuthStatusRepository.cache.clear();
            }
            DidiAuthStatusPoller.INSTANCE.m("account_changed");
        }
    }

    public static final DidiAuthStatusApi l() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((DidiAuthStatusApi) HttpManager.INSTANCE.create(DidiAuthStatusApi.class, BASE_URL_KEY));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "HttpManager.create<DidiAuthStatusApi>(\"didiOauth\") 失败，授权状态查询不可用（多半是 didiOauth baseUrl 未配置，见 IEnvConfig）", thE);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (DidiAuthStatusApi) objB;
    }

    public static final Long n(String str, Long l10) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return Long.valueOf((l10 != null ? l10.longValue() : 0L) + 1);
    }

    public static final Long o(p9.p pVar, Object obj, Object obj2) {
        return (Long) pVar.invoke(obj, obj2);
    }

    public static final Long v(String str, Long l10) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return Long.valueOf((l10 != null ? l10.longValue() : 0L) + 1);
    }

    public static final Long w(p9.p pVar, Object obj, Object obj2) {
        return (Long) pVar.invoke(obj, obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(java.lang.String r19, java.lang.String r20, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3315l> r21) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository.A(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final boolean B(DidiAuthStatusDto dto, String thirdUid, String deviceId) {
        String string;
        String string2;
        kotlin.jvm.internal.p.i(dto, "dto");
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        String thirdUid2 = dto.getThirdUid();
        String str = null;
        if (thirdUid2 == null || (string = La.H.D1(thirdUid2).toString()) == null || string.length() <= 0) {
            string = null;
        }
        String deviceId2 = dto.getDeviceId();
        if (deviceId2 != null && (string2 = La.H.D1(deviceId2).toString()) != null && string2.length() > 0) {
            str = string2;
        }
        if (string == null || kotlin.jvm.internal.p.d(string, thirdUid)) {
            return str == null || kotlin.jvm.internal.p.d(str, deviceId);
        }
        return false;
    }

    public final boolean C(CacheSource source, long ageMs) {
        kotlin.jvm.internal.p.i(source, "source");
        return source == CacheSource.NETWORK && 0 <= ageMs && ageMs < 600000;
    }

    public final void m(String thirdUid, String reason) throws NoSuchAlgorithmException {
        cache.remove(thirdUid);
        ConcurrentHashMap<String, Long> concurrentHashMap = generations;
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.o
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return DidiAuthStatusRepository.n((String) obj, (Long) obj2);
            }
        };
        concurrentHashMap.compute(thirdUid, new BiFunction() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.p
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DidiAuthStatusRepository.o(pVar, obj, obj2);
            }
        });
        C3324v.INSTANCE.e(thirdUid, reason);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$doFetch$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$doFetch$1 r0 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$doFetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$doFetch$1 r0 = new com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$doFetch$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r10 = f9.C4063a.g()
            int r1 = r0.label
            java.lang.String r2 = " "
            r3 = 1
            r4 = 0
            java.lang.String r5 = "DidiAuthStatusRepo"
            if (r1 == 0) goto L47
            if (r1 != r3) goto L3f
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi r7 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi) r7
            kotlin.C4849c.b(r6)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            goto L65
        L3a:
            r6 = move-exception
            goto L94
        L3c:
            r6 = move-exception
            goto Lbc
        L3f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L47:
            kotlin.C4849c.b(r6)
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            r0.L$0 = r6     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            java.lang.Object r6 = g9.h.a(r8)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            r0.L$1 = r6     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            java.lang.Object r6 = g9.h.a(r9)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            r0.L$2 = r6     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            r0.label = r3     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            java.lang.Object r6 = r7.status(r8, r9, r0)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            if (r6 != r10) goto L65
            return r10
        L65:
            yc.v r6 = (yc.v) r6     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            boolean r7 = r6.f()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            if (r7 != 0) goto L8d
            int r6 = r6.b()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            r7.<init>()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            java.lang.String r8 = "授权状态查询 HTTP "
            r7.append(r8)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            r7.append(r6)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            java.lang.String r6 = "，本次不可判定，保留最近状态"
            r7.append(r6)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            android.util.Log.w(r5, r6)     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            return r4
        L8d:
            java.lang.Object r6 = r6.a()     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto r6 = (com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto) r6     // Catch: java.lang.Exception -> L3a java.io.IOException -> L3c java.util.concurrent.CancellationException -> Le4
            return r6
        L94:
            java.lang.Class r7 = r6.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "授权状态查询异常："
            r8.append(r9)
            r8.append(r7)
            r8.append(r2)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            android.util.Log.w(r5, r6)
            goto Le3
        Lbc:
            java.lang.Class r7 = r6.getClass()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "授权状态查询网络失败："
            r8.append(r9)
            r8.append(r7)
            r8.append(r2)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            android.util.Log.w(r5, r6)
        Le3:
            return r4
        Le4:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository.p(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final void q() {
        Object objB;
        if (accountObserverInstalled.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
                activeAccountId = fVar.k();
                fVar.z(accountCallback);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                accountObserverInstalled.set(false);
                Log.w(TAG, "register account observer failed", thE);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(1:(1:(7:14|82|68|(1:70)|73|74|75)(2:15|16))(7:17|88|50|(1:52)|55|56|57))(9:18|80|19|20|86|45|46|(7:49|88|50|(0)|55|56|57)|66))(1:24))(3:25|(1:28)|66)|84|29|(2:38|39)(1:35)|40|90|41|(5:44|86|45|46|(0))|66|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x018c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x018d, code lost:
    
        r3 = r0;
        r5 = r10;
        r10 = r11;
        r12 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0176 A[Catch: all -> 0x017a, TryCatch #4 {all -> 0x017a, blocks: (B:50:0x016e, B:52:0x0176, B:55:0x017c), top: B:88:0x016e }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01be A[Catch: all -> 0x01c2, TryCatch #1 {all -> 0x01c2, blocks: (B:68:0x01b6, B:70:0x01be, B:73:0x01c4), top: B:82:0x01b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi r22, java.lang.String r23, java.lang.String r24, long r25, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository.r(com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi, java.lang.String, java.lang.String, long, e9.c):java.lang.Object");
    }

    public final DidiAuthStatusApi s() {
        return (DidiAuthStatusApi) api.getValue();
    }

    public final boolean t(String thirdUid) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        q();
        ConcurrentHashMap<String, CachedAuth> concurrentHashMap = cache;
        CachedAuth cachedAuth = concurrentHashMap.get(thirdUid);
        if (cachedAuth == null) {
            return false;
        }
        int i10 = c.$EnumSwitchMapping$0[cachedAuth.getSource().ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (C(cachedAuth.getSource(), SystemClock.elapsedRealtime() - cachedAuth.getAtElapsed())) {
            return true;
        }
        concurrentHashMap.remove(thirdUid, cachedAuth);
        return false;
    }

    public final void u(String thirdUid) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        q();
        if (thirdUid.length() == 0) {
            return;
        }
        cache.remove(thirdUid);
        ConcurrentHashMap<String, Long> concurrentHashMap = generations;
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.q
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return DidiAuthStatusRepository.v((String) obj, (Long) obj2);
            }
        };
        concurrentHashMap.compute(thirdUid, new BiFunction() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.r
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DidiAuthStatusRepository.w(pVar, obj, obj2);
            }
        });
    }

    public final boolean x() {
        q();
        return s() != null;
    }

    public final DidiAuthStatusDto y(String thirdUid) {
        kotlin.jvm.internal.p.i(thirdUid, "thirdUid");
        q();
        if (La.H.x0(thirdUid)) {
            return null;
        }
        ConcurrentHashMap<String, CachedAuth> concurrentHashMap = cache;
        CachedAuth cachedAuth = concurrentHashMap.get(thirdUid);
        if (cachedAuth != null) {
            int i10 = c.$EnumSwitchMapping$0[cachedAuth.getSource().ordinal()];
            if (i10 == 1) {
                return cachedAuth.getDto();
            }
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (C(cachedAuth.getSource(), SystemClock.elapsedRealtime() - cachedAuth.getAtElapsed())) {
                return cachedAuth.getDto();
            }
            concurrentHashMap.remove(thirdUid, cachedAuth);
        }
        DidiAuthStatusDto didiAuthStatusDtoG = C3324v.INSTANCE.g(thirdUid);
        if (didiAuthStatusDtoG == null) {
            return null;
        }
        concurrentHashMap.put(thirdUid, new CachedAuth(didiAuthStatusDtoG, SystemClock.elapsedRealtime(), CacheSource.PERSISTED));
        return didiAuthStatusDtoG;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(java.lang.String r5, java.lang.String r6, e9.InterfaceC4014c<? super com.stepos.ailauncher.foundation.appui.card.provider.didi.InterfaceC3315l> r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository.z(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }
}
