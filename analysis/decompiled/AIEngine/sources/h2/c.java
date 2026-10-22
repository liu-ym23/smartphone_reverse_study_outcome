package h2;

import android.annotation.SuppressLint;
import android.net.NetworkRequest;
import android.net.Uri;
import androidx.work.NetworkType;
import java.util.Set;
import kotlin.collections.EmptySet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: j, reason: collision with root package name */
    public static final c f9255j = new c();

    /* renamed from: a, reason: collision with root package name */
    public final NetworkType f9256a;

    /* renamed from: b, reason: collision with root package name */
    public final r2.g f9257b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9258c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9259d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9260e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9261f;

    /* renamed from: g, reason: collision with root package name */
    public final long f9262g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final Set<a> f9263i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9264a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9265b;

        public a(boolean z, Uri uri) {
            this.f9264a = uri;
            this.f9265b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!a.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            a aVar = (a) obj;
            return kotlin.jvm.internal.g.b(this.f9264a, aVar.f9264a) && this.f9265b == aVar.f9265b;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.f9265b) + (this.f9264a.hashCode() * 31);
        }
    }

    public c() {
        EmptySet contentUriTriggers = EmptySet.f10003a;
        kotlin.jvm.internal.g.f(contentUriTriggers, "contentUriTriggers");
        this.f9257b = new r2.g(null);
        this.f9256a = NetworkType.f2783a;
        this.f9258c = false;
        this.f9259d = false;
        this.f9260e = false;
        this.f9261f = false;
        this.f9262g = -1L;
        this.h = -1L;
        this.f9263i = contentUriTriggers;
    }

    public final NetworkRequest a() {
        return (NetworkRequest) this.f9257b.f11693a;
    }

    public final boolean b() {
        return !this.f9263i.isEmpty();
    }

    @SuppressLint({"NewApi"})
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !c.class.equals(obj.getClass())) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f9258c == cVar.f9258c && this.f9259d == cVar.f9259d && this.f9260e == cVar.f9260e && this.f9261f == cVar.f9261f && this.f9262g == cVar.f9262g && this.h == cVar.h && kotlin.jvm.internal.g.b(a(), cVar.a()) && this.f9256a == cVar.f9256a) {
            return kotlin.jvm.internal.g.b(this.f9263i, cVar.f9263i);
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public final int hashCode() {
        int iHashCode = ((((((((this.f9256a.hashCode() * 31) + (this.f9258c ? 1 : 0)) * 31) + (this.f9259d ? 1 : 0)) * 31) + (this.f9260e ? 1 : 0)) * 31) + (this.f9261f ? 1 : 0)) * 31;
        long j10 = this.f9262g;
        int i10 = (iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.h;
        int iHashCode2 = (this.f9263i.hashCode() + ((i10 + ((int) (j11 ^ (j11 >>> 32)))) * 31)) * 31;
        NetworkRequest networkRequestA = a();
        return iHashCode2 + (networkRequestA != null ? networkRequestA.hashCode() : 0);
    }

    @SuppressLint({"NewApi"})
    public final String toString() {
        return "Constraints{requiredNetworkType=" + this.f9256a + ", requiresCharging=" + this.f9258c + ", requiresDeviceIdle=" + this.f9259d + ", requiresBatteryNotLow=" + this.f9260e + ", requiresStorageNotLow=" + this.f9261f + ", contentTriggerUpdateDelayMillis=" + this.f9262g + ", contentTriggerMaxDelayMillis=" + this.h + ", contentUriTriggers=" + this.f9263i + ", }";
    }

    public c(r2.g gVar, NetworkType networkType, boolean z, boolean z3, boolean z10, boolean z11, long j10, long j11, Set<a> contentUriTriggers) {
        kotlin.jvm.internal.g.f(contentUriTriggers, "contentUriTriggers");
        this.f9257b = gVar;
        this.f9256a = networkType;
        this.f9258c = z;
        this.f9259d = z3;
        this.f9260e = z10;
        this.f9261f = z11;
        this.f9262g = j10;
        this.h = j11;
        this.f9263i = contentUriTriggers;
    }

    @SuppressLint({"NewApi"})
    public c(c other) {
        kotlin.jvm.internal.g.f(other, "other");
        this.f9258c = other.f9258c;
        this.f9259d = other.f9259d;
        this.f9257b = other.f9257b;
        this.f9256a = other.f9256a;
        this.f9260e = other.f9260e;
        this.f9261f = other.f9261f;
        this.f9263i = other.f9263i;
        this.f9262g = other.f9262g;
        this.h = other.h;
    }
}
