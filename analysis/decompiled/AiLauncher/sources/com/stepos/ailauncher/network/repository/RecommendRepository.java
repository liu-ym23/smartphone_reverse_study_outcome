package com.stepos.ailauncher.network.repository;

import La.H;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.network.RetrofitProvider;
import com.stepos.ailauncher.network.api.RecommendApi;
import com.stepos.ailauncher.network.model.RecommendCard;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import eb.f;
import g9.InterfaceC4112d;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o6.C5009a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ-\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/network/repository/RecommendRepository;", "", "Lcom/stepos/ailauncher/network/api/RecommendApi;", "api", "<init>", "(Lcom/stepos/ailauncher/network/api/RecommendApi;)V", "", HomeGestureEligibilityContract.EXTRA_SCENE, "", "count", "", "Lcom/stepos/ailauncher/network/model/RecommendCard;", "freshCache", "(Ljava/lang/String;I)Ljava/util/List;", "", "isCacheFresh", "(Ljava/lang/String;I)Z", "readCache", "cards", "LY8/t;", "saveCache", "(Ljava/lang/String;ILjava/util/List;)V", "dataKey", "(Ljava/lang/String;I)Ljava/lang/String;", "timeKey", "getRecommendCards", "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/network/api/RecommendApi;", "Companion", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecommendRepository {
    private static final String CACHE_PREFIX = "recommend_cards_cache";
    private static final long CACHE_TTL_MS = 3600000;
    private static final String TAG = "RecommendRepository";
    private final RecommendApi api;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Gson gson = new Gson();
    private static final Type cardListType = new TypeToken<List<? extends RecommendCard>>() { // from class: com.stepos.ailauncher.network.repository.RecommendRepository$Companion$cardListType$1
    }.getType();
    private static final InterfaceC4021a cacheMutex = f.b(false, 1, null);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/network/repository/RecommendRepository$Companion;", "", "<init>", "()V", "Lcom/stepos/ailauncher/network/repository/RecommendRepository;", "create", "()Lcom/stepos/ailauncher/network/repository/RecommendRepository;", "", "TAG", "Ljava/lang/String;", "CACHE_PREFIX", "", "CACHE_TTL_MS", "J", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "cardListType", "Ljava/lang/reflect/Type;", "Leb/a;", "cacheMutex", "Leb/a;", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final RecommendRepository create() throws SecurityException {
            Object objC = RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).b(), null, true, false, false, 2, null).c(RecommendApi.class);
            p.h(objC, "create(...)");
            return new RecommendRepository((RecommendApi) objC);
        }

        private Companion() {
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.network.repository.RecommendRepository", f = "RecommendRepository.kt", l = {136, 72}, m = "getRecommendCards", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.network.repository.RecommendRepository$getRecommendCards$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecommendRepository.this.getRecommendCards(null, 0, this);
        }
    }

    public RecommendRepository(RecommendApi api) {
        p.i(api, "api");
        this.api = api;
    }

    private final String dataKey(String scene, int count) {
        return "recommend_cards_cache:" + scene + ServerSentEventKt.COLON + count + ":data";
    }

    private final List<RecommendCard> freshCache(String scene, int count) {
        if (isCacheFresh(scene, count)) {
            return readCache(scene, count);
        }
        return null;
    }

    public static /* synthetic */ Object getRecommendCards$default(RecommendRepository recommendRepository, String str, int i10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "default";
        }
        return recommendRepository.getRecommendCards(str, i10, interfaceC4014c);
    }

    private final boolean isCacheFresh(String scene, int count) {
        long jO = C5009a.o(C5009a.INSTANCE, timeKey(scene, count), 0L, false, 4, null);
        return jO > 0 && System.currentTimeMillis() - jO < 3600000;
    }

    private final List<RecommendCard> readCache(String scene, int count) {
        String strT = C5009a.t(C5009a.INSTANCE, dataKey(scene, count), null, false, 6, null);
        if (H.x0(strT)) {
            return null;
        }
        try {
            return (List) gson.fromJson(strT, cardListType);
        } catch (Exception e10) {
            C4148a.t(TAG, "readCache parse failed: scene=" + scene + " count=" + count, e10, false, 8, null);
            return null;
        }
    }

    private final void saveCache(String scene, int count, List<RecommendCard> cards) {
        C5009a c5009a = C5009a.INSTANCE;
        String strDataKey = dataKey(scene, count);
        String json = gson.toJson(cards);
        p.h(json, "toJson(...)");
        C5009a.G(c5009a, strDataKey, json, false, 4, null);
        C5009a.E(c5009a, timeKey(scene, count), System.currentTimeMillis(), false, 4, null);
    }

    private final String timeKey(String scene, int count) {
        return "recommend_cards_cache:" + scene + ServerSentEventKt.COLON + count + ":time";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de A[Catch: all -> 0x0043, Exception -> 0x0046, TryCatch #1 {all -> 0x0043, blocks: (B:13:0x003e, B:46:0x00d4, B:48:0x00de, B:50:0x00e5, B:52:0x00eb, B:54:0x00f3, B:57:0x00fb, B:58:0x00ff, B:59:0x0104, B:61:0x0110, B:63:0x0116, B:65:0x0143, B:71:0x0153, B:72:0x0157, B:75:0x0188), top: B:82:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5 A[Catch: all -> 0x0043, Exception -> 0x0046, TryCatch #1 {all -> 0x0043, blocks: (B:13:0x003e, B:46:0x00d4, B:48:0x00de, B:50:0x00e5, B:52:0x00eb, B:54:0x00f3, B:57:0x00fb, B:58:0x00ff, B:59:0x0104, B:61:0x0110, B:63:0x0116, B:65:0x0143, B:71:0x0153, B:72:0x0157, B:75:0x0188), top: B:82:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0153 A[Catch: all -> 0x0043, TryCatch #1 {all -> 0x0043, blocks: (B:13:0x003e, B:46:0x00d4, B:48:0x00de, B:50:0x00e5, B:52:0x00eb, B:54:0x00f3, B:57:0x00fb, B:58:0x00ff, B:59:0x0104, B:61:0x0110, B:63:0x0116, B:65:0x0143, B:71:0x0153, B:72:0x0157, B:75:0x0188), top: B:82:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0188 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #1 {all -> 0x0043, blocks: (B:13:0x003e, B:46:0x00d4, B:48:0x00de, B:50:0x00e5, B:52:0x00eb, B:54:0x00f3, B:57:0x00fb, B:58:0x00ff, B:59:0x0104, B:61:0x0110, B:63:0x0116, B:65:0x0143, B:71:0x0153, B:72:0x0157, B:75:0x0188), top: B:82:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getRecommendCards(java.lang.String r19, int r20, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.network.model.RecommendCard>> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.network.repository.RecommendRepository.getRecommendCards(java.lang.String, int, e9.c):java.lang.Object");
    }
}
