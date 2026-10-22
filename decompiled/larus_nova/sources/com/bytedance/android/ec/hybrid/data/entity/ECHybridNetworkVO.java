package com.bytedance.android.ec.hybrid.data.entity;

import com.alipay.sdk.m.p.e;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridNetworkVO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f46666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f46667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f46668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f46669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f46670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Metrics f46671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f46672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f46673h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f46674i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f46675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f46676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f46677l;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridNetworkVO$Metrics;", "Ljava/io/Serializable;", "()V", "chunkedDataReceivedTimestamps", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getChunkedDataReceivedTimestamps", "()Ljava/util/HashMap;", "setChunkedDataReceivedTimestamps", "(Ljava/util/HashMap;)V", "isCookieAttached", "", "()Z", "setCookieAttached", "(Z)V", "waitingDuration", "getWaitingDuration", "()Ljava/lang/Long;", "setWaitingDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Metrics implements Serializable {
        private HashMap<String, Long> chunkedDataReceivedTimestamps;
        private boolean isCookieAttached;
        private Long waitingDuration;

        public Metrics() {
            this.chunkedDataReceivedTimestamps = new HashMap();
        }

        public final HashMap<String, Long> getChunkedDataReceivedTimestamps() {
            return this.chunkedDataReceivedTimestamps;
        }

        public final Long getWaitingDuration() {
            return this.waitingDuration;
        }

        public final boolean isCookieAttached() {
            return this.isCookieAttached;
        }

        public final void setChunkedDataReceivedTimestamps(HashMap<String, Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.chunkedDataReceivedTimestamps = r100;
        }

        public final void setCookieAttached(boolean r100) {
            this.isCookieAttached = r100;
        }

        public final void setWaitingDuration(Long r100) {
            this.waitingDuration = r100;
        }
    }

    public final Map<String, String> a() {
        return (Map) this.f46668c.getValue();
    }

    public final Map<String, Object> b() {
        return (Map) this.f46669d.getValue();
    }

    public final String toString() {
        return "ECHybridNetworkVO(url='" + this.f46672g + "', method='" + this.f46673h + "', apiType=" + this.f46674i + ", isMain=" + this.f46675j + ", headers=" + a() + ", params=" + b() + ')';
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof ECHybridNetworkVO) == false) goto L37;
        ECHybridNetworkVO r101 = (ECHybridNetworkVO) r100;
        if (Intrinsics.areEqual(this.f46672g, r101.f46672g) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f46673h, r101.f46673h) == true) goto L12;
        return false;
    L12:
        if (this.f46674i == r101.f46674i) goto L14;
        return false;
    L14:
        if (this.f46675j == r101.f46675j) goto L16;
        return false;
    L16:
        if (this.f46677l == r101.f46677l) goto L18;
        return false;
    L18:
        if (this.f46667b == r101.f46667b) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(a(), r101.a()) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(b(), r101.b()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f46670e, r101.f46670e) == false) goto L36;
        return true;
    L36:
        return false;
    L37:
        return false;
    }

    public ECHybridNetworkVO(String r100, String r101, int r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r104, "apiKey");
        this.f46672g = r100;
        this.f46673h = r101;
        this.f46674i = r102;
        this.f46675j = r103;
        this.f46676k = r104;
        this.f46677l = false;
        this.f46668c = LazyKt.lazy(ECHybridNetworkVO$headers$2.INSTANCE);
        this.f46669d = LazyKt.lazy(ECHybridNetworkVO$params$2.INSTANCE);
        this.f46671f = new Metrics();
    }
}
