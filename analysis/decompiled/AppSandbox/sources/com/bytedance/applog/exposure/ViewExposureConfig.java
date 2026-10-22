package com.bytedance.applog.exposure;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/bytedance/applog/exposure/ViewExposureConfig;", "Lcom/bytedance/applog/exposure/IExposureConfig;", "areaRatio", "", "visualDiagnosis", "", "stayTriggerTime", "", "exposureCallback", "Lkotlin/Function1;", "Lcom/bytedance/applog/exposure/ViewExposureParam;", "(Ljava/lang/Float;Ljava/lang/Boolean;JLkotlin/jvm/functions/Function1;)V", "getAreaRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getExposureCallback", "()Lkotlin/jvm/functions/Function1;", "getStayTriggerTime", "()J", "getVisualDiagnosis", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Boolean;JLkotlin/jvm/functions/Function1;)Lcom/bytedance/applog/exposure/ViewExposureConfig;", "equals", "other", "", "hashCode", "", "toString", "", "agent_pickerChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final /* data */ class ViewExposureConfig implements IExposureConfig {
    public final Float a;
    public final Boolean b;
    public final long c;
    public final Function1<ViewExposureParam, Boolean> d;

    public static final class a extends Lambda implements Function1<ViewExposureParam, Boolean> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(ViewExposureParam viewExposureParam) {
            ViewExposureParam it = viewExposureParam;
            Intrinsics.checkParameterIsNotNull(it, "it");
            return true;
        }
    }

    public ViewExposureConfig() {
        this(null, null, 0L, null, 15, null);
    }

    public ViewExposureConfig(Float f) {
        this(f, null, 0L, null, 14, null);
    }

    public ViewExposureConfig(Float f, Boolean bool) {
        this(f, bool, 0L, null, 12, null);
    }

    public ViewExposureConfig(Float f, Boolean bool, long j) {
        this(f, bool, j, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewExposureConfig(Float f, Boolean bool, long j, Function1<? super ViewExposureParam, Boolean> exposureCallback) {
        Intrinsics.checkParameterIsNotNull(exposureCallback, "exposureCallback");
        this.a = f;
        this.b = bool;
        this.c = j;
        this.d = exposureCallback;
    }

    public /* synthetic */ ViewExposureConfig(Float f, Boolean bool, long j, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? 0L : j, (i & 8) != 0 ? a.a : function1);
    }

    public static /* synthetic */ ViewExposureConfig copy$default(ViewExposureConfig viewExposureConfig, Float f, Boolean bool, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = viewExposureConfig.a;
        }
        if ((i & 2) != 0) {
            bool = viewExposureConfig.b;
        }
        if ((i & 4) != 0) {
            j = viewExposureConfig.c;
        }
        if ((i & 8) != 0) {
            function1 = viewExposureConfig.d;
        }
        Function1 function12 = function1;
        return viewExposureConfig.copy(f, bool, j, function12);
    }

    /* renamed from: component1, reason: from getter */
    public final Float getA() {
        return this.a;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getB() {
        return this.b;
    }

    /* renamed from: component3, reason: from getter */
    public final long getC() {
        return this.c;
    }

    public final Function1<ViewExposureParam, Boolean> component4() {
        return this.d;
    }

    public final ViewExposureConfig copy(Float areaRatio, Boolean visualDiagnosis, long stayTriggerTime, Function1<? super ViewExposureParam, Boolean> exposureCallback) {
        Intrinsics.checkParameterIsNotNull(exposureCallback, "exposureCallback");
        return new ViewExposureConfig(areaRatio, visualDiagnosis, stayTriggerTime, exposureCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewExposureConfig)) {
            return false;
        }
        ViewExposureConfig viewExposureConfig = (ViewExposureConfig) other;
        return Intrinsics.areEqual((Object) this.a, (Object) viewExposureConfig.a) && Intrinsics.areEqual(this.b, viewExposureConfig.b) && this.c == viewExposureConfig.c && Intrinsics.areEqual(this.d, viewExposureConfig.d);
    }

    public final Float getAreaRatio() {
        return this.a;
    }

    public final Function1<ViewExposureParam, Boolean> getExposureCallback() {
        return this.d;
    }

    public final long getStayTriggerTime() {
        return this.c;
    }

    public final Boolean getVisualDiagnosis() {
        return this.b;
    }

    public int hashCode() {
        Float f = this.a;
        int iHashCode = (f != null ? f.hashCode() : 0) * 31;
        Boolean bool = this.b;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        long j = this.c;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        Function1<ViewExposureParam, Boolean> function1 = this.d;
        return i + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbA = com.bytedance.bdtracker.a.a("ViewExposureConfig(areaRatio=");
        sbA.append(this.a);
        sbA.append(", visualDiagnosis=");
        sbA.append(this.b);
        sbA.append(", stayTriggerTime=");
        sbA.append(this.c);
        sbA.append(", exposureCallback=");
        sbA.append(this.d);
        sbA.append(")");
        return sbA.toString();
    }
}
