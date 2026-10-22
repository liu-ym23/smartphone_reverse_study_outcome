package com.bytedance.android.ec.core.address;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/core/address/x;", "", "", "Lcom/bytedance/android/ec/core/address/a0;", "mainBtmList", "Ljava/util/List;", "getMainBtmList", "()Ljava/util/List;", "Lcom/bytedance/android/ec/core/address/i0;", "ruleList", "getRuleList", "Lcom/bytedance/android/ec/core/address/b0;", "btmTraceConfig", "Lcom/bytedance/android/ec/core/address/b0;", "c", "()Lcom/bytedance/android/ec/core/address/b0;", "", "virtualStackSize", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "", "useVirtualStack", "Z", "d", "()Z", "effectRequestTag", "Ljava/lang/Boolean;", "getEffectRequestTag", "()Ljava/lang/Boolean;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, a0> f43736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0[][] f43737b;

    @SerializedName("btm_trace_config")
    private final b0 btmTraceConfig;

    @SerializedName("effect_request_tag")
    private final Boolean effectRequestTag;

    @SerializedName("main_btm_list")
    private final List<a0> mainBtmList;

    @SerializedName("rule_list")
    private final List<i0> ruleList;

    @SerializedName("use_virtual_stack")
    private final boolean useVirtualStack;

    @SerializedName("virtual_stack_size")
    private final Integer virtualStackSize;

    public x() {
        this(null);
    }

    public final b0 c() {
        return this.btmTraceConfig;
    }

    public final boolean d() {
        return this.useVirtualStack;
    }

    public final Integer e() {
        return this.virtualStackSize;
    }

    public x(Object r100) {
        Boolean r101 = Boolean.FALSE;
        this.mainBtmList = null;
        this.ruleList = null;
        this.btmTraceConfig = null;
        this.virtualStackSize = null;
        this.useVirtualStack = false;
        this.effectRequestTag = r101;
    }

    public final a0 a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f43736a != null) goto L16;
        LinkedHashMap r101 = new LinkedHashMap();
        List<a0> r102 = this.mainBtmList;
        if (r102 == null) goto L15;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        a0 r104 = (a0) r103.next();
        if (r104.a() == null) goto L11;
        r101.put(r104.a(), r104);
    L15:
        Unit r105 = Unit.INSTANCE;
        this.f43736a = r101;
    L16:
        Map<String, a0> r106 = this.f43736a;
        if (r106 != null) goto L19;
        return null;
    L19:
        return r106.get(r100);
    }

    public final Integer b(int r100, int r101) {
        if (this.f43737b != null) goto L26;
        i0[][] r102 = new i0[3][];
        int r103 = 0;
    L5:
        if (r103 >= 3) goto L10;
        i0[] r104 = new i0[3];
        int r105 = 0;
    L7:
        if (r105 >= 3) goto L9;
        r104[r105] = null;
        r105 = r105 + 1;
        goto L7
    L9:
        r102[r103] = r104;
        r103 = r103 + 1;
        goto L5
    L10:
        List<i0> r106 = this.ruleList;
        if (r106 == null) goto L25;
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L25;
        i0 r108 = (i0) r107.next();
        int r109 = r108.a();
        if (r109 < 0) goto L14;
        if (2 < r109) goto L14;
        int r110 = r108.b();
        if (r110 < 0) goto L14;
        if (2 < r110) goto L14;
        r102[r108.a()][r108.b()] = r108;
    L25:
        this.f43737b = r102;
    L26:
        i0[][] r111 = this.f43737b;
        if (r111 == null) goto L47;
        i0[] r112 = (i0[]) ArraysKt.getOrNull(r111, r100);
        if (r112 == null) goto L48;
        i0 r113 = (i0) ArraysKt.getOrNull(r112, r101);
        if (r113 != null) goto L33;
        return null;
    L33:
        return Integer.valueOf(r113.c());
    L48:
        return null;
    L47:
        return null;
    }
}
