package com.stepos.datacenter.api;

import La.H;
import V6.SearchHit;
import V6.SearchRequest;
import Z8.F;
import a7.InterfaceC1238b;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o9.C5013a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/datacenter/api/UnifiedSearchOps;", "", "<init>", "()V", "Lcom/stepos/datacenter/api/DataCenter;", "inst", "LV6/j;", "request", "LV6/k;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/datacenter/api/DataCenter;LV6/j;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/datacenter/api/SearchStyle;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LV6/j;)Lcom/stepos/datacenter/api/SearchStyle;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LV6/j;)Ljava/lang/String;", "", "Lcom/stepos/datacenter/api/UnifiedSearchOps$a;", "e", "(LV6/j;Le9/c;)Ljava/lang/Object;", "collection", "f", "(Lcom/stepos/datacenter/api/DataCenter;LV6/j;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "(LV6/j;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedSearchOps {

    /* renamed from: a, reason: collision with root package name */
    public static final UnifiedSearchOps f29900a = new UnifiedSearchOps();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/stepos/datacenter/api/UnifiedSearchOps$a;", "", "", "score", "", "entityId", "", "entityType", "<init>", "(FJLjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(FJLjava/lang/String;)Lcom/stepos/datacenter/api/UnifiedSearchOps$a;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", "e", "()F", Const.INTENT_KEY_PKGNAME, "J", "c", "()J", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.api.UnifiedSearchOps$a, reason: from toString */
    public static final /* data */ class InternalHit {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final float score;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long entityId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String entityType;

        public InternalHit(float f10, long j10, String entityType) {
            p.i(entityType, "entityType");
            this.score = f10;
            this.entityId = j10;
            this.entityType = entityType;
        }

        public static /* synthetic */ InternalHit b(InternalHit internalHit, float f10, long j10, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                f10 = internalHit.score;
            }
            if ((i10 & 2) != 0) {
                j10 = internalHit.entityId;
            }
            if ((i10 & 4) != 0) {
                str = internalHit.entityType;
            }
            return internalHit.a(f10, j10, str);
        }

        public final InternalHit a(float score, long entityId, String entityType) {
            p.i(entityType, "entityType");
            return new InternalHit(score, entityId, entityType);
        }

        /* renamed from: c, reason: from getter */
        public final long getEntityId() {
            return this.entityId;
        }

        /* renamed from: d, reason: from getter */
        public final String getEntityType() {
            return this.entityType;
        }

        /* renamed from: e, reason: from getter */
        public final float getScore() {
            return this.score;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InternalHit)) {
                return false;
            }
            InternalHit internalHit = (InternalHit) other;
            return Float.compare(this.score, internalHit.score) == 0 && this.entityId == internalHit.entityId && p.d(this.entityType, internalHit.entityType);
        }

        public int hashCode() {
            return (((Float.hashCode(this.score) * 31) + Long.hashCode(this.entityId)) * 31) + this.entityType.hashCode();
        }

        public String toString() {
            return "InternalHit(score=" + this.score + ", entityId=" + this.entityId + ", entityType=" + this.entityType + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29904a;

        static {
            int[] iArr = new int[SearchStyle.values().length];
            try {
                iArr[SearchStyle.KEYWORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SearchStyle.SEMANTIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SearchStyle.HYBRID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SearchStyle.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f29904a = iArr;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Float.valueOf(((SearchHit) t11).getScore()), Float.valueOf(((SearchHit) t10).getScore()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0124, code lost:
    
        if (r3 == r5) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(V6.SearchRequest r35, java.lang.String r36, e9.InterfaceC4014c<? super java.util.List<com.stepos.datacenter.api.UnifiedSearchOps.InternalHit>> r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.UnifiedSearchOps.d(V6.j, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0198 A[LOOP:0: B:57:0x0192->B:59:0x0198, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x021e A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0187 -> B:56:0x018c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(V6.SearchRequest r18, e9.InterfaceC4014c<? super java.util.List<com.stepos.datacenter.api.UnifiedSearchOps.InternalHit>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.UnifiedSearchOps.e(V6.j, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dc, code lost:
    
        if (r1 == r3) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(com.stepos.datacenter.api.DataCenter r21, V6.SearchRequest r22, java.lang.String r23, e9.InterfaceC4014c<? super java.util.List<com.stepos.datacenter.api.UnifiedSearchOps.InternalHit>> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.UnifiedSearchOps.f(com.stepos.datacenter.api.DataCenter, V6.j, java.lang.String, e9.c):java.lang.Object");
    }

    public final String g(SearchRequest request) {
        InterfaceC5745d interfaceC5745d;
        InterfaceC1238b interfaceC1238b;
        String strCollection;
        String collection = request.getCollection();
        if (collection != null) {
            if (H.x0(collection)) {
                collection = null;
            }
            if (collection != null) {
                return collection;
            }
        }
        List<InterfaceC5745d<?>> listF = request.f();
        if (listF != null && (interfaceC5745d = (InterfaceC5745d) F.s0(listF)) != null && (interfaceC1238b = (InterfaceC1238b) C5013a.b(interfaceC5745d).getAnnotation(InterfaceC1238b.class)) != null && (strCollection = interfaceC1238b.collection()) != null) {
            String str = H.x0(strCollection) ? null : strCollection;
            if (str != null) {
                return str;
            }
        }
        Set<String> setD = U6.e.f6308a.d();
        if (setD.size() == 1) {
            return (String) F.p0(setD);
        }
        if (setD.size() <= 1) {
            return "";
        }
        int size = setD.size();
        Set<String> set = setD;
        Log.w("DataCenter", "resolveSearchCollection: " + size + " collections registered, none specified; picking '" + F.p0(set) + "'. 跨集合搜请用 searchAcrossCollections");
        return (String) F.p0(set);
    }

    public final SearchStyle h(SearchRequest request) {
        if (request.getStyle() != SearchStyle.AUTO) {
            return request.getStyle();
        }
        String string = H.D1(request.getText()).toString();
        if (string.length() == 0) {
            return SearchStyle.KEYWORD;
        }
        int i10 = 0;
        if (string.length() <= 16 && !H.f0(string, ' ', false, 2, null)) {
            for (int i11 = 0; i11 < string.length(); i11++) {
                if (string.charAt(i11) < 128) {
                }
            }
            return SearchStyle.KEYWORD;
        }
        while (true) {
            if (i10 < string.length()) {
                char cCharAt = string.charAt(i10);
                if (19968 <= cCharAt && cCharAt < 40960) {
                    break;
                }
                i10++;
            } else if (string.length() <= 24) {
                return SearchStyle.HYBRID;
            }
        }
        return SearchStyle.SEMANTIC;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:106|71|(2:74|72)|97|75|(8:78|79|84|(1:85)|102|91|107|(1:63))|77) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f4, code lost:
    
        if (r2 == r4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0108, code lost:
    
        if (r2 == r4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012f, code lost:
    
        if (r2 == r4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0143, code lost:
    
        if (r2 == r4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0223, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0224, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0225, code lost:
    
        android.util.Log.w("DataCenter", "search: binding(" + r10 + ").findByIds failed", r0);
        r2 = Z8.C1173v.m();
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0289  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x021e -> B:79:0x0220). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(com.stepos.datacenter.api.DataCenter r23, V6.SearchRequest r24, e9.InterfaceC4014c<? super V6.SearchResult> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.api.UnifiedSearchOps.i(com.stepos.datacenter.api.DataCenter, V6.j, e9.c):java.lang.Object");
    }
}
