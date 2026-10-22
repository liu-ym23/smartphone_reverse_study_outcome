package com.bytedance.android.shopping.anchorv4.helper;

import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpSliceLocalCacheHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f166923b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f166924c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f166925d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f166926a;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/helper/PdpSliceLocalCacheHelper$b;", "", "", "Lcom/bytedance/android/shopping/anchorv4/helper/PdpSliceLocalCacheHelper$c;", "sliceRules", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("slice_rules")
        private final List<c> sliceRules;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.sliceRules, ((b) r100).sliceRules) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<c> r100 = this.sliceRules;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "SliceCacheConfig(sliceRules=" + this.sliceRules + ")";
        }

        public b() {
            this.sliceRules = null;
        }

        public final List<c> a() {
            return this.sliceRules;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/helper/PdpSliceLocalCacheHelper$c;", "", "", "sliceId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "matchType", "b", "", SlcCommonAction.KEY_PARAMS, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName(SlcCommonAction.KEY_PARAMS)
        private final List<String> fields;

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
        private final String matchType;

        @SerializedName(BaseSlice.KEY_SLICE_ID)
        private final String sliceId;

        public c() {
            this(null, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.sliceId, r101.sliceId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.matchType, r101.matchType) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.sliceId;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.matchType;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            List<String> r107 = this.fields;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "SliceRule(sliceId=" + this.sliceId + ", matchType=" + this.matchType + ", fields=" + this.fields + ")";
        }

        public final List<String> a() {
            return this.fields;
        }

        public final String b() {
            return this.matchType;
        }

        public final String c() {
            return this.sliceId;
        }

        public c(String r100, int r101) {
            if ((r101 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r101 & 2) == 0) goto L8;
            String r102 = "exact";
        L9:
            this.sliceId = r100;
            this.matchType = r102;
            this.fields = null;
            return;
        L8:
            r102 = null;
            goto L9
        }
    }

    static {
        f166925d = new a();
        f166923b = LazyKt.lazy(PdpSliceLocalCacheHelper$Companion$defaultRules$2.INSTANCE);
        f166924c = LazyKt.lazy(PdpSliceLocalCacheHelper$Companion$parsedRules$2.INSTANCE);
    }

    public PdpSliceLocalCacheHelper() {
        this.f166926a = new LinkedHashMap();
    }

    public final void a(String r110, Map<String, ? extends Object> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r111, "incomingData");
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return;
    L11:
        f166925d.getClass();
        Iterator r101 = ((List) f166924c.getValue()).iterator();
    L13:
        if (r101.hasNext() == false) goto L39;
        Object r102 = r101.next();
        c r103 = (c) r102;
        String r104 = r103.b();
        if (r104 == null) goto L36;
        int r105 = r104.hashCode();
        String r106 = "";
        if (r105 == (-980110702)) goto L30;
        if (r105 != (-891422895)) goto L36;
        if (r104.equals("suffix") == false) goto L36;
        String r107 = r103.c();
        if (r107 == null) goto L28;
        r106 = r107;
    L28:
        boolean r108 = StringsKt.endsWith$default(r110, r106, false, 2, null);
    L37:
        if (r108 == false) goto L13;
    L40:
        c r109 = (c) r102;
        if (r109 != null) goto L44;
        if (r112 == true) goto L44;
        return;
    L44:
        if (r109 == null) goto L46;
        List<String> r113 = r109.a();
    L47:
        List<String> r114 = r113;
        if (r114 != null) goto L50;
    L53:
        boolean r115 = true;
    L54:
        if (r115 == true) goto L102;
        Map<String, ? extends Object> r116 = (Map) ((LinkedHashMap) this.f166926a).get(r110);
        if (r116 != null) goto L59;
    L63:
        r116 = new LinkedHashMap();
    L64:
        if (r109 == null) goto L67;
        List<String> r117 = r109.a();
        if (r117 == null) goto L67;
    L68:
        Iterator<String> r118 = r117.iterator();
    L70:
        if (r118.hasNext() == false) goto L100;
        List r119 = StringsKt.split$default(r118.next(), new String[]{"."}, false, 0, 6, null);
        Iterator r120 = r119.iterator();
        Object r121 = r111;
    L73:
        if (r120.hasNext() == false) goto L78;
        String r122 = (String) r120.next();
        if ((r121 instanceof Map) == false) goto L77;
        r121 = ((Map) r121).get(r122);
        goto L73
    L77:
        r121 = null;
    L78:
        if (r121 == null) goto L70;
        if (r119.size() == 1) goto L81;
        int r123 = r119.size() - 1;
        Map<String, ? extends Object> r124 = r116;
        int r125 = 0;
    L85:
        if (r125 >= r123) goto L97;
        String r126 = (String) CollectionsKt.getOrNull(r119, r125);
        if (r126 == null) goto L96;
        Object r127 = r124.get(r126);
        if (TypeIntrinsics.isMutableMap(r127) == false) goto L95;
        if (r127 == null) goto L94;
        r124 = TypeIntrinsics.asMutableMap(r127);
        goto L96
    L94:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any?>");
    L95:
        LinkedHashMap r128 = new LinkedHashMap();
        r124.put(r126, r128);
        r124 = r128;
    L96:
        r125 = r125 + 1;
        goto L85
    L97:
        String r129 = (String) CollectionsKt.lastOrNull(r119);
        if (r129 == null) goto L70;
        r124.put(r129, r121);
        goto L70
    L81:
        String r130 = (String) CollectionsKt.getOrNull(r119, 0);
        if (r130 == null) goto L70;
        r116.put(r130, r121);
        goto L70
    L100:
        r111 = r116;
    L67:
        r117 = CollectionsKt.emptyList();
        goto L68
    L59:
        if (TypeIntrinsics.isMutableMap(r116) == true) goto L62;
        r116 = MapsKt.toMutableMap(r116);
    L62:
        if (r116 != null) goto L64;
    L102:
        if ((!r111.isEmpty()) == false) goto L130;
        this.f166926a.put(r110, r111);
        return;
    L130:
        return;
    L50:
        if (r114.isEmpty() == true) goto L53;
        r115 = false;
        goto L54
    L46:
        r113 = null;
        goto L47
    L30:
        if (r104.equals("prefix") == false) goto L36;
        String r131 = r103.c();
        if (r131 == null) goto L35;
        r106 = r131;
    L35:
        r108 = StringsKt.startsWith$default(r110, r106, false, 2, null);
    L36:
        r108 = Intrinsics.areEqual(r110, r103.c());
        goto L37
    L39:
        r102 = null;
        goto L40
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }
}
