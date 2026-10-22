package com.bytedance.android.ec.core.abtest;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class NetworkABTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f43632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f43633b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final API f43634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f43635d = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\bb\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J?\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/NetworkABTest$API;", "", "getApi", "", "", "url", "query", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postApi", ContainerPosition.BODY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface API {
        @GET
        Object getApi(@Url String r100, @QueryMap Map<String, String> r101, Continuation<? super Map<String, ? extends Object>> r102);

        @POST
        Object postApi(@Url String r100, @Body Map<String, String> r101, Continuation<? super Map<String, ? extends Object>> r102);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/abtest/NetworkABTest$a;", "", "", "delayTime", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "", "performanceGet", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "performancePost", "e", "", "getSize", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "postSize", "f", "keySize", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("delay_time")
        private final Long delayTime;

        @SerializedName("get_size")
        private final Integer getSize;

        @SerializedName("key_size")
        private final Integer keySize;

        @SerializedName("performance_get")
        private final String performanceGet;

        @SerializedName("performance_post")
        private final String performancePost;

        @SerializedName("post_size")
        private final Integer postSize;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L18;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.delayTime, r101.delayTime) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.performanceGet, r101.performanceGet) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.performancePost, r101.performancePost) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.getSize, r101.getSize) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.postSize, r101.postSize) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.keySize, r101.keySize) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            Long r100 = this.delayTime;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.performanceGet;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.performancePost;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.getSize;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.postSize;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            Integer r116 = this.keySize;
            if (r116 == null) goto L26;
            r101 = r116.hashCode();
        L26:
            return r115 + r101;
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(delayTime=" + this.delayTime + ", performanceGet=" + this.performanceGet + ", performancePost=" + this.performancePost + ", getSize=" + this.getSize + ", postSize=" + this.postSize + ", keySize=" + this.keySize + ")";
        }

        public final Long a() {
            return this.delayTime;
        }

        public final Integer b() {
            return this.getSize;
        }

        public final Integer c() {
            return this.keySize;
        }

        public final String d() {
            return this.performanceGet;
        }

        public final String e() {
            return this.performancePost;
        }

        public final Integer f() {
            return this.postSize;
        }

        public a(int r100) {
            this.delayTime = null;
            this.performanceGet = null;
            this.performancePost = null;
            this.getSize = null;
            this.postSize = null;
            this.keySize = null;
        }
    }

    public NetworkABTest() {
    }

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f43632a = LazyKt.lazy(r100, NetworkABTest$config$2.INSTANCE);
        f43633b = new AtomicBoolean(true);
        f43634c = (API) n.f48128a.create("https://ecom.snssdk.com", API.class);
        f43635d = LazyKt.lazy(r100, NetworkABTest$enable$2.INSTANCE);
    }

    public static final a b() {
        return (a) f43632a.getValue();
    }

    public static Object c(Continuation r100) {
        if (f43633b.compareAndSet(true, false) == false) goto L5;
        Object r101 = BuildersKt.withContext(Dispatchers.getIO(), new NetworkABTest$onNetworkTest$2(null), r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r101;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static final Map a(int r100, String r101) {
        if (r100 <= 0) goto L12;
        LinkedHashMap r102 = new LinkedHashMap();
        int r103 = 1;
        if (1 > r100) goto L10;
    L6:
        r102.put("empty_K" + r103, r101);
        if (r103 == r100) goto L10;
        r103 = r103 + 1;
    L10:
        return r102;
    L12:
        return MapsKt.emptyMap();
    }
}
