package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@ProtoMessage("webcast.data.NFA")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/s;", "", "", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/entity/t;", "nfaPatterns", "Ljava/util/List;", "b", "()Ljava/util/List;", "setNfaPatterns", "(Ljava/util/List;)V", "", "eventNames", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEventNames", "", "scope", "I", "c", "()I", "setScope", "(I)V", "withinTime", "d", "setWithinTime", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s implements vh7.h {

    @SerializedName("event_names")
    protected List<String> eventNames;

    @SerializedName("patterns")
    protected List<t> nfaPatterns;

    @SerializedName("scope")
    protected int scope;

    @SerializedName("within_time")
    protected int withinTime;

    public s() {
    }

    public final List<String> a() {
        return this.eventNames;
    }

    public final List<t> b() {
        return this.nfaPatterns;
    }

    public final int c() {
        return this.scope;
    }

    public final int d() {
        return this.withinTime;
    }

    public s(am3.g r100) {
        this.nfaPatterns = new ArrayList();
        this.eventNames = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        if (r102 == 1) goto L17;
        if (r102 != 2) goto L10;
        List r103 = this.eventNames;
        Object r104 = am3.h.c(r100);
    L18:
        r103.add(r104);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.scope = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.withinTime = r100.i();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L17:
        r103 = this.nfaPatterns;
        r104 = new t(r100);
        goto L18
    L19:
        r100.d(r101);
    }
}
