package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.amap.api.col.s.ce;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ProtoMessage("webcast.data.NFAPattern")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/t;", "", "", "stateName", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setStateName", "(Ljava/lang/String;)V", "", "patternType", "I", "d", "()I", "setPatternType", "(I)V", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a;", "condition", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a;", "setCondition", "(Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/a;)V", "withTime", ce.f26391f, "setWithTime", "withinType", "getWithinType", "setWithinType", "times", "f", "setTimes", "", "eventNames", "Ljava/util/List;", "b", "()Ljava/util/List;", "setEventNames", "(Ljava/util/List;)V", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/k;", "paramTypeInfo", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "setParamTypeInfo", "(Ljava/util/Map;)V", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t implements vh7.h {

    @SerializedName("condition")
    protected a condition;

    @SerializedName("event_names")
    protected List<String> eventNames;

    @SerializedName("param_infos")
    protected Map<String, k> paramTypeInfo;

    @SerializedName("key_word_type")
    protected int patternType;

    @SerializedName("name")
    protected String stateName;

    @SerializedName("times")
    protected int times;

    @SerializedName("within_time")
    protected int withTime;

    @SerializedName("within_type")
    protected String withinType;

    public t() {
        this.withinType = "";
    }

    public final a a() {
        return this.condition;
    }

    public final List<String> b() {
        return this.eventNames;
    }

    public final Map<String, k> c() {
        return this.paramTypeInfo;
    }

    public final int d() {
        return this.patternType;
    }

    public final String e() {
        return this.stateName;
    }

    public final int f() {
        return this.times;
    }

    public final int g() {
        return this.withTime;
    }

    public t(am3.g r110) {
        this.eventNames = new ArrayList();
        this.paramTypeInfo = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L32;
        switch(r101) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        long r102 = r110.c();
        String r103 = null;
        k r104 = null;
    L8:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L8
    L13:
        if (r105 != 2) goto L14;
        r104 = new k(r110);
        goto L8
    L14:
        am3.h.e(r110);
        goto L8
    L17:
        r110.d(r102);
        Map<String, k> r106 = this.paramTypeInfo;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.eventNames.add(am3.h.c(r110));
        goto L3
    L26:
        this.times = r110.i();
        goto L3
    L27:
        this.withinType = am3.h.c(r110);
        goto L3
    L28:
        this.withTime = r110.i();
        goto L3
    L29:
        this.condition = d0.a(r110);
        goto L3
    L30:
        this.patternType = r110.i();
        goto L3
    L31:
        this.stateName = am3.h.c(r110);
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L32:
        r110.d(r100);
        if (this.withinType != null) goto L67;
        this.withinType = "";
        return;
    }
}
