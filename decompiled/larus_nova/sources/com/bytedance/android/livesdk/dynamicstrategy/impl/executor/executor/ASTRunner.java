package com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.mapapi.http.HttpClient;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.c0;
import com.bytedance.android.livesdk.model.z0;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import j40.f4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public final class ASTRunner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b0> f123060a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f123061b = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/executor/executor/ASTRunner$ASTExecuteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ASTExecuteException extends RuntimeException {
        private final String message;

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }

        public ASTExecuteException(String r100) {
            this.message = r100;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, Object> f123062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f123063b;

        public a(Map<String, ? extends Object> r100) {
            this.f123063b = r100;
            this.f123062a = new LinkedHashMap();
        }
    }

    public static final class a0 implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a0 f123064a = null;

        public a0() {
        }

        static {
            f123064a = new a0();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r110, a r111) {
            Intrinsics.checkNotNullParameter(r110, "params");
            Intrinsics.checkNotNullParameter(r111, "dataContext");
            Map<String, b0> r100 = ASTRunner.f123060a;
            Intrinsics.checkNotNullParameter("context_strategy_name", "key");
            Object r101 = ((LinkedHashMap) r111.f123062a).get("context_strategy_name");
            if (r101 != null) goto L9;
            Map<String, Object> r112 = r111.f123063b;
            if (r112 == null) goto L7;
            r101 = r112.get("context_strategy_name");
            goto L9
        L7:
            r101 = null;
        L9:
            if ((r101 instanceof String) == true) goto L11;
            r101 = null;
        L11:
            String r102 = (String) r101;
            Object r103 = CollectionsKt.getOrNull(r110, 0);
            if ((r103 instanceof Number) == true) goto L14;
            r103 = null;
        L14:
            Number r104 = (Number) r103;
            if (r104 == null) goto L17;
            Integer r105 = Integer.valueOf(r104.intValue());
        L18:
            Object r106 = CollectionsKt.getOrNull(r110, 1);
            if ((r106 instanceof Number) == true) goto L21;
            r106 = null;
        L21:
            Number r107 = (Number) r106;
            if (r107 == null) goto L24;
            Long r108 = Long.valueOf(r107.longValue());
        L25:
            Object r109 = CollectionsKt.getOrNull(r110, 2);
            if ((r109 instanceof Number) == true) goto L28;
            r109 = null;
        L28:
            Number r113 = (Number) r109;
            if (r113 == null) goto L31;
            Integer r114 = Integer.valueOf(r113.intValue());
        L32:
            Object r115 = CollectionsKt.getOrNull(r110, 3);
            if (r115 == null) goto L35;
            String r116 = r115.toString();
        L37:
            if ((r102 instanceof String) == true) goto L39;
        L67:
            int r117 = lu1.k.f510820a;
            lu1.k.h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "strategy_frequency_error"), TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, String.valueOf(r102)), TuplesKt.to("consecutive_times", String.valueOf(r105)), TuplesKt.to("interval_in_sec", String.valueOf(r108)), TuplesKt.to("total_times", String.valueOf(r114)), TuplesKt.to("tag", String.valueOf(r116))}), null);
            return Boolean.TRUE;
        L39:
            if ((r105 instanceof Integer) == false) goto L67;
            if ((r108 instanceof Long) == false) goto L67;
            if ((r114 instanceof Integer) == false) goto L67;
            if ((r116 instanceof String) == false) goto L67;
            com.bytedance.android.livesdk.sharedpref.e<z0> r118 = f4.f497221x;
            z0 r119 = r118.getValue();
            if (r119 != null) goto L49;
            r119 = new z0(null);
        L49:
            Map<String, List<Long>> r120 = r119.a();
            if (r120 != null) goto L52;
            r120 = new LinkedHashMap();
            r119.b(r120);
        L52:
            String r121 = r102 + '@' + r116;
            List<Long> r122 = r120.get(r121);
            if (r122 != null) goto L56;
            r122 = new ArrayList();
            r120.put(r121, r122);
        L56:
            if (r122.size() >= r114.intValue()) goto L58;
            long r123 = System.currentTimeMillis() / ((long) 1000);
            if (r122.size() >= r105.intValue()) goto L62;
        L65:
            r122.add(Long.valueOf(r123));
            com.bytedance.android.livesdk.sharedpref.f.d(r118, r119);
            return Boolean.TRUE;
        L62:
            if ((r123 - ((Number) ListProtector.get(r122, r122.size() - r105.intValue())).longValue()) > r108.longValue()) goto L65;
            return Boolean.FALSE;
        L58:
            return Boolean.FALSE;
        L35:
            r116 = null;
            goto L37
        L31:
            r114 = null;
            goto L32
        L24:
            r108 = null;
            goto L25
        L17:
            r105 = null;
            goto L18
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f123065a = null;

        public b() {
        }

        static {
            f123065a = new b();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            if ((r100 instanceof Boolean) == false) goto L15;
            if ((r101 instanceof Boolean) == false) goto L15;
            if (((Boolean) r100).booleanValue() == true) goto L9;
        L11:
            boolean r103 = false;
        L13:
            return Boolean.valueOf(r103);
        L9:
            if (((Boolean) r101).booleanValue() == false) goto L11;
            r103 = true;
        L15:
            throw new ASTExecuteException("AndOperation error, param is not Boolean");
        }
    }

    public interface b0 {
        Object a(Object r100, a r101);
    }

    public interface c {
        Object a(Object r100, Object r101, a r102);
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f123066a;

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, OnekeyLoginConstants.CU_KEY_OPERATOR);
            this.f123066a = r100;
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            boolean r103 = false;
            if ((r100 instanceof String) == false) goto L8;
            if ((r101 instanceof String) == false) goto L8;
            int r104 = ((String) r100).compareTo((String) r101);
        L29:
            String r105 = this.f123066a;
            int r106 = r105.hashCode();
            if (r106 == 60) goto L64;
            if (r106 == 62) goto L60;
            if (r106 == 1084) goto L56;
            if (r106 == 1921) goto L51;
            if (r106 == 1952) goto L47;
            if (r106 != 1983) goto L70;
            if (r105.equals(">=") == false) goto L70;
            if (r104 == 0) goto L66;
            if (r104 > 0) goto L66;
        L68:
            return Boolean.valueOf(r103);
        L66:
            r103 = true;
        L70:
            throw new ASTExecuteException("CompareOperation error, unknown operator[" + this.f123066a + ']');
        L47:
            if (r105.equals("==") == false) goto L70;
            if (r104 != 0) goto L68;
        L51:
            if (r105.equals("<=") == false) goto L70;
            if (r104 == 0) goto L66;
            if (r104 >= 0) goto L68;
        L56:
            if (r105.equals("!=") == false) goto L70;
            if (r104 == 0) goto L68;
        L60:
            if (r105.equals(">") == false) goto L70;
            if (r104 <= 0) goto L68;
        L64:
            if (r105.equals("<") == false) goto L70;
            if (r104 >= 0) goto L68;
        L8:
            if ((r100 instanceof Boolean) == false) goto L16;
            if ((r101 instanceof Boolean) == false) goto L16;
            if (Intrinsics.areEqual(r100, r101) == false) goto L14;
            r104 = 0;
            goto L29
        L14:
            r104 = -1;
        L16:
            if ((r100 instanceof Number) == false) goto L72;
            if ((r101 instanceof Number) == false) goto L72;
            Map<String, b0> r107 = ASTRunner.f123060a;
            Number r108 = (Number) r100;
            Number r109 = (Number) r101;
            int r110 = Math.max(ASTRunner.a(r108), ASTRunner.a(r109));
            if (r110 != 2) goto L22;
            r104 = (r108.longValue() > r109.longValue() ? 1 : (r108.longValue() == r109.longValue() ? 0 : -1));
            goto L29
        L22:
            if (r110 != 3) goto L24;
            r104 = Float.compare(r108.floatValue(), r109.floatValue());
            goto L29
        L24:
            if (r110 == 4) goto L26;
            r104 = Intrinsics.compare(r108.intValue(), r109.intValue());
            goto L29
        L26:
            r104 = Double.compare(r108.doubleValue(), r109.doubleValue());
        L72:
            throw new ASTExecuteException("CompareOperation error, params can not compare, paramA is " + r100 + ", paramB is " + r101);
        }
    }

    public static final class e implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f123067a = null;

        public e() {
        }

        static {
            f123067a = new e();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            if ((r100 instanceof Double) == false) goto L6;
            return Double.valueOf(((Number) r100).doubleValue() - 1.0d);
        L6:
            if ((r100 instanceof Long) == false) goto L9;
            return Long.valueOf(((Number) r100).longValue() - 1);
        L9:
            if ((r100 instanceof Integer) == false) goto L12;
            return Integer.valueOf(((Number) r100).intValue() - 1);
        L12:
            if ((r100 instanceof Float) == false) goto L16;
            return Float.valueOf(((Number) r100).floatValue() - 1.0f);
        L16:
            throw new ASTExecuteException("DecOperation error, unknown param type[" + r100.getClass() + ']');
        }
    }

    public static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f123068a = null;

        public f() {
        }

        static {
            f123068a = new f();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            if ((r100 instanceof Number) == false) goto L20;
            if ((r101 instanceof Number) == false) goto L20;
            if ((!Intrinsics.areEqual(r101, 0)) == false) goto L20;
            Map<String, b0> r103 = ASTRunner.f123060a;
            Number r104 = (Number) r100;
            Number r105 = (Number) r101;
            int r106 = Math.max(ASTRunner.a(r104), ASTRunner.a(r105));
            if (r106 == 2) goto L18;
            if (r106 == 3) goto L23;
            if (r106 == 4) goto L22;
            return Integer.valueOf(r104.intValue() / r105.intValue());
        L22:
            return Double.valueOf(r104.doubleValue() / r105.doubleValue());
        L23:
            return Float.valueOf(r104.floatValue() / r105.floatValue());
        L18:
            return Long.valueOf(r104.longValue() / r105.longValue());
        L20:
            throw new ASTExecuteException("DivOperation error, param can not calculate or is zero, paramA is " + r100 + ", paramB is " + r101);
        }
    }

    public static final class g implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f123069a = null;

        public g() {
        }

        static {
            f123069a = new g();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            if ((r100 instanceof Double) == false) goto L6;
            return Double.valueOf(((Number) r100).doubleValue() + 1.0d);
        L6:
            if ((r100 instanceof Long) == false) goto L9;
            return Long.valueOf(((Number) r100).longValue() + 1);
        L9:
            if ((r100 instanceof Integer) == false) goto L12;
            return Integer.valueOf(((Number) r100).intValue() + 1);
        L12:
            if ((r100 instanceof Float) == false) goto L16;
            return Float.valueOf(((Number) r100).floatValue() + 1.0f);
        L16:
            throw new ASTExecuteException("IncOperation error, unknown param type[" + r100.getClass() + ']');
        }
    }

    public static final class h implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f123070a = null;

        public h() {
        }

        static {
            f123070a = new h();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            Object r103 = CollectionsKt.getOrNull(r100, 1);
            if ((r102 instanceof List) == false) goto L8;
            if (r103 == null) goto L8;
            return Boolean.valueOf(((List) r102).contains(r103));
        L8:
            throw new ASTExecuteException("ListContainOperation error, param can not calculate, list is " + r102 + ", value is " + r103);
        }
    }

    public static final class i implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f123071a = null;

        public i() {
        }

        static {
            f123071a = new i();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            Integer r103 = null;
            if ((r102 instanceof List) == true) goto L5;
            r102 = null;
        L5:
            List r104 = (List) r102;
            Object r105 = CollectionsKt.getOrNull(r100, 1);
            if ((r105 instanceof Number) == true) goto L8;
            r105 = null;
        L8:
            Number r106 = (Number) r105;
            if (r106 == null) goto L11;
            r103 = Integer.valueOf(r106.intValue());
        L11:
            Object r107 = CollectionsKt.getOrNull(r100, 2);
            if (r104 == null) goto L26;
            if (r103 == null) goto L26;
            if (r107 == null) goto L26;
            if (r103.intValue() < r104.size()) goto L18;
            return r107;
        L18:
            if (r103.intValue() < 0) goto L28;
            Object r108 = ListProtector.get(r104, r103.intValue());
            if (r108 != null) goto L24;
            return r107;
        L24:
            return r108;
        L28:
            return r107;
        L26:
            throw new ASTExecuteException("ListGetOperation error, param can not calculate, list is " + r104 + ", index is " + r103 + ", defaultValue is " + r107);
        }
    }

    public static final class j implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f123072a = null;

        public j() {
        }

        static {
            f123072a = new j();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            if ((r102 instanceof Number) == false) goto L7;
            return Double.valueOf(Math.log10(((Number) r102).doubleValue()));
        L7:
            throw new ASTExecuteException("Log10Operation error, param can not calculate, param is " + r102);
        }
    }

    public static final class k implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f123073a = null;

        public k() {
        }

        static {
            f123073a = new k();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            if ((r102 instanceof Number) == false) goto L7;
            return Double.valueOf(MathKt.log2(((Number) r102).doubleValue()));
        L7:
            throw new ASTExecuteException("Log2Operation error, param can not calculate, param is " + r102);
        }
    }

    public static final class l implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f123074a = null;

        public l() {
        }

        static {
            f123074a = new l();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            Object r103 = CollectionsKt.getOrNull(r100, 1);
            if ((r102 instanceof Number) == false) goto L9;
            if ((r103 instanceof Number) == false) goto L9;
            return Double.valueOf(Math.log(((Number) r103).doubleValue()) / Math.log(((Number) r102).doubleValue()));
        L9:
            throw new ASTExecuteException("LogOperation error, param can not calculate, paramA is " + r102 + ", paramB is " + r103);
        }
    }

    public static final class m implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f123075a = null;

        public m() {
        }

        static {
            f123075a = new m();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            Object r103 = CollectionsKt.getOrNull(r100, 1);
            Object r104 = CollectionsKt.getOrNull(r100, 2);
            if ((r102 instanceof Map) == false) goto L12;
            if (r103 == null) goto L12;
            if (r104 == null) goto L12;
            Object r105 = ((Map) r102).get(r103);
            if (r105 != null) goto L10;
            return r104;
        L10:
            return r105;
        L12:
            throw new ASTExecuteException("MapGetOperation error, param can not calculate, map is " + r102 + ", key is " + r103 + ", defaultValue is " + r104);
        }
    }

    public static final class n implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f123076a = null;

        public n() {
        }

        static {
            f123076a = new n();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            Object r103 = CollectionsKt.getOrNull(r100, 1);
            if ((r102 instanceof Number) == false) goto L18;
            if ((r103 instanceof Number) == false) goto L18;
            Map<String, b0> r104 = ASTRunner.f123060a;
            Number r105 = (Number) r102;
            Number r106 = (Number) r103;
            int r107 = Math.max(ASTRunner.a(r105), ASTRunner.a(r106));
            if (r107 == 2) goto L16;
            if (r107 == 3) goto L21;
            if (r107 == 4) goto L20;
            return Integer.valueOf(RangesKt.coerceAtLeast(r105.intValue(), r106.intValue()));
        L20:
            return Double.valueOf(RangesKt.coerceAtLeast(r105.doubleValue(), r106.doubleValue()));
        L21:
            return Float.valueOf(RangesKt.coerceAtLeast(r105.floatValue(), r106.floatValue()));
        L16:
            return Long.valueOf(RangesKt.coerceAtLeast(r105.longValue(), r106.longValue()));
        L18:
            throw new ASTExecuteException("MaxOperation error, param can not calculate, paramA is " + r102 + ", paramB is " + r103);
        }
    }

    public static final class o implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f123077a = null;

        public o() {
        }

        static {
            f123077a = new o();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            Object r103 = CollectionsKt.getOrNull(r100, 1);
            if ((r102 instanceof Number) == false) goto L18;
            if ((r103 instanceof Number) == false) goto L18;
            Map<String, b0> r104 = ASTRunner.f123060a;
            Number r105 = (Number) r102;
            Number r106 = (Number) r103;
            int r107 = Math.max(ASTRunner.a(r105), ASTRunner.a(r106));
            if (r107 == 2) goto L16;
            if (r107 == 3) goto L21;
            if (r107 == 4) goto L20;
            return Integer.valueOf(RangesKt.coerceAtMost(r105.intValue(), r106.intValue()));
        L20:
            return Double.valueOf(RangesKt.coerceAtMost(r105.doubleValue(), r106.doubleValue()));
        L21:
            return Float.valueOf(RangesKt.coerceAtMost(r105.floatValue(), r106.floatValue()));
        L16:
            return Long.valueOf(RangesKt.coerceAtMost(r105.longValue(), r106.longValue()));
        L18:
            throw new ASTExecuteException("MinOperation error, param can not calculate, paramA is " + r102 + ", paramB is " + r103);
        }
    }

    public static final class p implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f123078a = null;

        public p() {
        }

        static {
            f123078a = new p();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            if ((r100 instanceof Number) == false) goto L18;
            if ((r101 instanceof Number) == false) goto L18;
            Map<String, b0> r103 = ASTRunner.f123060a;
            Number r104 = (Number) r100;
            Number r105 = (Number) r101;
            int r106 = Math.max(ASTRunner.a(r104), ASTRunner.a(r105));
            if (r106 == 2) goto L16;
            if (r106 == 3) goto L21;
            if (r106 == 4) goto L20;
            return Integer.valueOf(r104.intValue() - r105.intValue());
        L20:
            return Double.valueOf(r104.doubleValue() - r105.doubleValue());
        L21:
            return Float.valueOf(r104.floatValue() - r105.floatValue());
        L16:
            return Long.valueOf(r104.longValue() - r105.longValue());
        L18:
            throw new ASTExecuteException("MinusOperation error, param can not calculate, paramA is " + r100 + ", paramB is " + r101);
        }
    }

    public interface q {
        Object a(List<? extends Object> r100, a r101);
    }

    public static final class r implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f123079a = null;

        public r() {
        }

        static {
            f123079a = new r();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            if ((r100 instanceof Boolean) == false) goto L7;
            return Boolean.valueOf(!((Boolean) r100).booleanValue());
        L7:
            throw new ASTExecuteException("NegateOperation error, param is not Boolean, param is " + r100);
        }
    }

    public static final class s implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f123080a = null;

        public s() {
        }

        static {
            f123080a = new s();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            if ((r100 instanceof Number) == false) goto L16;
            Map<String, b0> r102 = ASTRunner.f123060a;
            Number r103 = (Number) r100;
            int r104 = ASTRunner.a(r103);
            if (r104 == 2) goto L14;
            if (r104 == 3) goto L19;
            if (r104 == 4) goto L18;
            return Integer.valueOf(0 - r103.intValue());
        L18:
            return Double.valueOf(((double) 0) - r103.doubleValue());
        L19:
            return Float.valueOf(0 - r103.floatValue());
        L14:
            return Long.valueOf(0 - r103.longValue());
        L16:
            throw new ASTExecuteException("NegativeSignOperation error, param can not calculate");
        }
    }

    public static final class t implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f123081a = null;

        public t() {
        }

        static {
            f123081a = new t();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            if ((r100 instanceof Boolean) == false) goto L16;
            if ((r101 instanceof Boolean) == false) goto L16;
            if (((Boolean) r100).booleanValue() == false) goto L9;
        L12:
            boolean r103 = true;
        L14:
            return Boolean.valueOf(r103);
        L9:
            if (((Boolean) r101).booleanValue() == true) goto L12;
            r103 = false;
        L16:
            throw new ASTExecuteException("OrOperation error, param is not Boolean, paramA is " + r100 + ", paramB is " + r101);
        }
    }

    public static final class u implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f123082a = null;

        public u() {
        }

        static {
            f123082a = new u();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            if ((r100 instanceof Number) == false) goto L18;
            if ((r101 instanceof Number) == false) goto L18;
            Map<String, b0> r103 = ASTRunner.f123060a;
            Number r104 = (Number) r100;
            Number r105 = (Number) r101;
            int r106 = Math.max(ASTRunner.a(r104), ASTRunner.a(r105));
            if (r106 == 2) goto L16;
            if (r106 == 3) goto L21;
            if (r106 == 4) goto L20;
            return Integer.valueOf(r104.intValue() + r105.intValue());
        L20:
            return Double.valueOf(r104.doubleValue() + r105.doubleValue());
        L21:
            return Float.valueOf(r104.floatValue() + r105.floatValue());
        L16:
            return Long.valueOf(r104.longValue() + r105.longValue());
        L18:
            throw new ASTExecuteException("PlusOperation error, param can not calculate, paramA is " + r100 + ", paramB is " + r101);
        }
    }

    public static final class v implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f123083a = null;

        public v() {
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.b0
        public final Object a(Object r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            return r100;
        }

        static {
            f123083a = new v();
        }
    }

    public static final class w implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f123084a = null;

        public w() {
        }

        static {
            f123084a = new w();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            Object r103 = CollectionsKt.getOrNull(r100, 1);
            if ((r102 instanceof Number) == false) goto L9;
            if ((r103 instanceof Number) == false) goto L9;
            return Double.valueOf(Math.pow(((Number) r102).doubleValue(), ((Number) r103).doubleValue()));
        L9:
            throw new ASTExecuteException("PowOperation error, param can not calculate, paramA is " + r102 + ", paramB is " + r103);
        }
    }

    public static final class x implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f123085a = null;

        public x() {
        }

        static {
            f123085a = new x();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            if ((r100 instanceof Number) == false) goto L20;
            if ((r101 instanceof Number) == false) goto L20;
            if ((!Intrinsics.areEqual(r101, 0)) == false) goto L20;
            Map<String, b0> r103 = ASTRunner.f123060a;
            Number r104 = (Number) r100;
            Number r105 = (Number) r101;
            int r106 = Math.max(ASTRunner.a(r104), ASTRunner.a(r105));
            if (r106 == 2) goto L18;
            if (r106 == 3) goto L23;
            if (r106 == 4) goto L22;
            return Integer.valueOf(r104.intValue() % r105.intValue());
        L22:
            return Double.valueOf(r104.doubleValue() % r105.doubleValue());
        L23:
            return Float.valueOf(r104.floatValue() % r105.floatValue());
        L18:
            return Long.valueOf(r104.longValue() % r105.longValue());
        L20:
            throw new ASTExecuteException("RemOperation error, param can not calculate or is zero, paramA is " + r100 + ", paramB is " + r101);
        }
    }

    public static final class y implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f123086a = null;

        public y() {
        }

        static {
            f123086a = new y();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.q
        public final Object a(List<? extends Object> r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "dataContext");
            Object r102 = CollectionsKt.getOrNull(r100, 0);
            if ((r102 instanceof String) == false) goto L7;
            return ((String) r102).toLowerCase(Locale.ENGLISH);
        L7:
            throw new ASTExecuteException("StrToLowerOperation error, param can not calculate, param is " + r102);
        }
    }

    public static final class z implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f123087a = null;

        public z() {
        }

        static {
            f123087a = new z();
        }

        @Override // com.bytedance.android.livesdk.dynamicstrategy.impl.executor.executor.ASTRunner.c
        public final Object a(Object r100, Object r101, a r102) {
            Intrinsics.checkNotNullParameter(r100, "paramA");
            Intrinsics.checkNotNullParameter(r101, "paramB");
            Intrinsics.checkNotNullParameter(r102, "dataContext");
            if ((r100 instanceof Number) == false) goto L18;
            if ((r101 instanceof Number) == false) goto L18;
            Map<String, b0> r103 = ASTRunner.f123060a;
            Number r104 = (Number) r100;
            Number r105 = (Number) r101;
            int r106 = Math.max(ASTRunner.a(r104), ASTRunner.a(r105));
            if (r106 == 2) goto L16;
            if (r106 == 3) goto L21;
            if (r106 == 4) goto L20;
            return Integer.valueOf(r104.intValue() * r105.intValue());
        L20:
            return Double.valueOf(r104.doubleValue() * r105.doubleValue());
        L21:
            return Float.valueOf(r104.floatValue() * r105.floatValue());
        L16:
            return Long.valueOf(r104.longValue() * r105.longValue());
        L18:
            throw new ASTExecuteException("TimesOperation error, param can not calculate, paramA is " + r100 + ", paramB is " + r101);
        }
    }

    public ASTRunner() {
    }

    static {
        f123060a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("!", r.f123079a), TuplesKt.to("++", g.f123069a), TuplesKt.to(HttpClient.ENDFLAG, e.f123067a), TuplesKt.to(Marker.ANY_NON_NULL_MARKER, v.f123083a), TuplesKt.to("-", s.f123080a)});
        f123061b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("&&", b.f123065a), TuplesKt.to("||", t.f123081a), TuplesKt.to(Marker.ANY_NON_NULL_MARKER, u.f123082a), TuplesKt.to("-", p.f123078a), TuplesKt.to("*", z.f123087a), TuplesKt.to(HTTP.URL_DEFAULT, f.f123068a), TuplesKt.to(GXTemplateKey.GAIAX_PE, x.f123085a), TuplesKt.to("==", new d("==")), TuplesKt.to(">=", new d(">=")), TuplesKt.to(">", new d(">")), TuplesKt.to("<=", new d("<=")), TuplesKt.to("<", new d("<")), TuplesKt.to("!=", new d("!=")), TuplesKt.to(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, o.f123077a), TuplesKt.to(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, n.f123076a), TuplesKt.to("pow", w.f123084a), TuplesKt.to("log", l.f123074a), TuplesKt.to("log2", k.f123073a), TuplesKt.to("log10", j.f123072a), TuplesKt.to("listget", i.f123071a), TuplesKt.to("listcontain", h.f123070a), TuplesKt.to("mapget", m.f123075a), TuplesKt.to("strtolower", y.f123086a), TuplesKt.to("triggerfrequency", a0.f123064a)});
    }

    public static final int a(Number r100) {
        if ((r100 instanceof Long) == false) goto L6;
        return 2;
    L6:
        if ((r100 instanceof Float) == false) goto L9;
        return 3;
    L9:
        if ((r100 instanceof Double) == false) goto L11;
        return 4;
    L11:
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v37, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object] */
    public static Object b(com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "astRuleDetail");
        Intrinsics.checkNotNullParameter(r101, "astDataContext");
        Object r102 = null;
        String r103 = null;
        Object r104 = null;
        String r105 = null;
        switch(r100.nodeType) {
            case 1: goto L133;
            case 2: goto L128;
            case 3: goto L123;
            case 4: goto L116;
            case 5: goto L97;
            case 6: goto L87;
            case 7: goto L66;
            case 8: goto L48;
            case 9: goto L29;
            case 10: goto L5;
            case 11: goto L19;
            case 12: goto L6;
            default: goto L5;
        };
    L6:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.c r106 = r100.array_node;
        if (r106 == null) goto L18;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.a> r107 = r106.nodes;
        if (r107 == null) goto L18;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.a> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L12:
        if (r110.hasNext() == false) goto L14;
        r109.add(b((com.bytedance.android.livesdk.dynamicstrategy.api.entity.a) r110.next(), r101));
        goto L12
    L14:
        List r111 = CollectionsKt.toList(r109);
        if (r111 == null) goto L18;
        return r111;
    L18:
        throw new ASTExecuteException("arrayNode error, node is null");
    L19:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.r r112 = r100.map_node;
        if (r112 == null) goto L28;
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.u> r113 = r112.pairs;
        if (r113 == null) goto L28;
        ?? r114 = new LinkedHashMap();
        Iterator r115 = r113.iterator();
    L25:
        if (r115.hasNext() == false) goto L149;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.u r116 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.u) r115.next();
        r114.put(r116.key, r116.value);
    L149:
        return r114;
    L28:
        throw new ASTExecuteException("mapNode error, node is null");
    L29:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.h r117 = r100.conditionNode;
        Object r118 = b(r117.condition, r101);
        if ((r118 instanceof Boolean) == true) goto L45;
        int r119 = lu1.k.f510820a;
        Intrinsics.checkNotNullParameter("context_strategy_name", "key");
        Object r120 = ((LinkedHashMap) r101.f123062a).get("context_strategy_name");
        if (r120 != null) goto L38;
        Map<String, Object> r121 = r101.f123063b;
        if (r121 == null) goto L36;
        r120 = r121.get("context_strategy_name");
        goto L38
    L36:
        r120 = null;
    L38:
        if ((r120 instanceof String) == true) goto L40;
        r120 = null;
    L40:
        String r122 = (String) r120;
        if (r122 != null) goto L43;
        r122 = "unknown";
    L43:
        lu1.k.h(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", "strategy_condition_error"), TuplesKt.to(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r122), TuplesKt.to("condition_result", String.valueOf(r118))}), null);
    L45:
        if (Intrinsics.areEqual(r118, Boolean.TRUE) == false) goto L147;
        return b(r117.then, r101);
    L147:
        return b(r117.otherwise, r101);
    L48:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.o r123 = r100.identifierNode;
        if (r123 == null) goto L61;
        String r124 = r123.value;
        if (r124 == null) goto L61;
        Intrinsics.checkNotNullParameter(r124, "key");
        Object r125 = ((LinkedHashMap) r101.f123062a).get(r124);
        if (r125 != null) goto L58;
        Map<String, Object> r126 = r101.f123063b;
        if (r126 == null) goto L57;
        r125 = r126.get(r124);
        goto L58
    L57:
        r125 = null;
    L58:
        if (r125 == null) goto L61;
        return r125;
    L61:
        StringBuilder r127 = new StringBuilder("identifierNode[");
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.o r128 = r100.identifierNode;
        if (r128 == null) goto L64;
        r103 = r128.value;
    L64:
        r127.append(r103);
        r127.append("] error, value is null");
        throw new ASTExecuteException(r127.toString());
    L66:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.g r129 = r100.callNode;
        ArrayList r130 = new ArrayList();
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.a> r131 = r129.arguments;
        if (r131 == null) goto L72;
        Iterator r132 = r131.iterator();
    L70:
        if (r132.hasNext() == false) goto L72;
        r130.add(b((com.bytedance.android.livesdk.dynamicstrategy.api.entity.a) r132.next(), r101));
    L72:
        Map<String, Object> r133 = f123061b;
        String r134 = r129.caller.value;
        if (r134 == null) goto L75;
        String r135 = r134.toLowerCase(Locale.ENGLISH);
    L76:
        Object r136 = r133.get(r135);
        if ((r136 instanceof q) == false) goto L80;
        r104 = r136;
    L80:
        q r137 = (q) r104;
        if (r137 == null) goto L86;
        r114 = r137.a(r130, r101);
        if (r114 != 0) goto L149;
    L86:
        throw new ASTExecuteException("callNode error, unknown operation[" + r129.caller.value + ']');
    L75:
        r135 = null;
        goto L76
    L87:
        c0 r138 = r100.unaryNode;
        Object r139 = b(r138.node, r101);
        Map<String, b0> r140 = f123060a;
        String r141 = r138.operator;
        if (r141 == null) goto L90;
        r105 = r141.toLowerCase(Locale.ENGLISH);
    L90:
        b0 r142 = r140.get(r105);
        if (r142 == null) goto L96;
        r114 = r142.a(r139, r101);
        if (r114 != 0) goto L149;
    L96:
        throw new ASTExecuteException("unaryNode error, unknown operation[" + r138.operator + ']');
    L97:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.e r143 = r100.binaryNode;
        Object r144 = b(r143.left, r101);
        Object r145 = b(r143.right, r101);     // Catch: Throwable -> L114
        Map<String, Object> r146 = f123061b;
        String r147 = r143.operator;
        if (r147 == null) goto L102;
        String r148 = r147.toLowerCase(Locale.ENGLISH);
    L103:
        Object r149 = r146.get(r148);
        if ((r149 instanceof c) == false) goto L107;
        r102 = r149;
    L107:
        c r150 = (c) r102;
        if (r150 == null) goto L113;
        r114 = r150.a(r144, r145, r101);
        if (r114 != 0) goto L149;
    L113:
        throw new ASTExecuteException("binaryNode error, unknown operation[" + r143.operator + ']');
    L102:
        r148 = null;
    L114:
        th = move-exception;
        throw th;
    L116:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.b0 r151 = r100.stringNode;
        if (r151 == null) goto L122;
        String r152 = r151.value;
        if (r152 == null) goto L122;
        return r152;
    L122:
        throw new ASTExecuteException("stringNode error, node is null");
    L123:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.j r153 = r100.doubleNode;
        if (r153 == null) goto L127;
        return Double.valueOf(r153.value);
    L127:
        throw new ASTExecuteException("doubleNode error, node is null");
    L128:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.q r154 = r100.longNode;
        if (r154 == null) goto L132;
        return Long.valueOf(r154.value);
    L132:
        throw new ASTExecuteException("longNode error, node is null");
    L133:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.f r155 = r100.boolNode;
        if (r155 == null) goto L140;
        Boolean r156 = r155.value;
        if (r156 == null) goto L140;
        return Boolean.valueOf(r156.booleanValue());
    L140:
        throw new ASTExecuteException("boolNode error, node is null");
    L5:
        throw new ASTExecuteException("Node error, unknown node type, type is " + r100.nodeType);
    }

    public static Object c(com.bytedance.android.livesdk.dynamicstrategy.api.entity.b r110, Map r111) {
        Intrinsics.checkNotNullParameter(r110, "astStrategy");
        Intrinsics.checkNotNullParameter(r111, "stateMap");
        a r100 = new a(r111);
        String r112 = r110.f123026a;
        Intrinsics.checkNotNullParameter("context_strategy_name", "key");
        Intrinsics.checkNotNullParameter(r112, "value");
        r100.f123062a.put("context_strategy_name", r112);
        List<com.bytedance.android.livesdk.dynamicstrategy.api.entity.w> r113 = r110.f123030e.rules;
        Object r101 = null;
        if (r113 == null) goto L29;
        Iterator<T> r114 = r113.iterator();
    L6:
        if (r114.hasNext() == false) goto L29;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.w r102 = (com.bytedance.android.livesdk.dynamicstrategy.api.entity.w) r114.next();
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.d r103 = r102.astRule;
        if (r103 == null) goto L11;
        String r104 = r103.ruleKeyName;
        if (r104 == null) goto L11;
    L12:
        if (r103 == null) goto L6;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.a r105 = r103.root;
        if (r105 == null) goto L6;
        r101 = b(r105, r100);
        Intrinsics.checkNotNullParameter(r104, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.f123062a.put(r104, r101);
        int r106 = lu1.k.f510820a;
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.d r107 = r102.astRule;
        if (r107 == null) goto L20;
        String r108 = r107.rule;
        if (r108 == null) goto L20;
    L21:
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r104, "ruleName");
        Intrinsics.checkNotNullParameter(r108, "ruleValue");
        if (ku1.c.f506181a.getValue().e() == false) goto L6;
        String r109 = String.valueOf(r101);
        if (r101 == null) goto L27;
        String r115 = Reflection.getOrCreateKotlinClass(r101.getClass()).getSimpleName();
        if (r115 == null) goto L27;
    L28:
        lu1.k.g("DynamicStrategy_strategy_execute", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("name", r110.f123026a), TuplesKt.to("rule_name", r104), TuplesKt.to("rule_value", r108), TuplesKt.to("rule_result", r109), TuplesKt.to("rule_result_type", r115)}));
    L27:
        r115 = "null";
    L20:
        r108 = "";
    L11:
        r104 = "unknown_rule";
    L29:
        if (r101 == null) goto L32;
        return r101;
    L32:
        throw new ASTExecuteException("ASTRuleStrategy error, result is null");
    }
}
