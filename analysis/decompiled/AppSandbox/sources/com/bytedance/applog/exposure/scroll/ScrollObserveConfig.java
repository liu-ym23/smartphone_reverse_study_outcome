package com.bytedance.applog.exposure.scroll;

import com.bytedance.applog.exposure.IExposureConfig;
import com.bytedance.applog.exposure.ViewExposureParam;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/applog/exposure/scroll/ScrollObserveConfig;", "Lcom/bytedance/applog/exposure/IExposureConfig;", "minOffset", "", "scrollCallback", "Lkotlin/Function1;", "Lcom/bytedance/applog/exposure/ViewExposureParam;", "", "(ILkotlin/jvm/functions/Function1;)V", "getMinOffset", "()I", "getScrollCallback", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "agent_pickerChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final /* data */ class ScrollObserveConfig implements IExposureConfig {
    public final int a;
    public final Function1<ViewExposureParam, Boolean> b;

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

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollObserveConfig() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollObserveConfig(int i) {
        this(i, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollObserveConfig(int i, Function1<? super ViewExposureParam, Boolean> scrollCallback) {
        Intrinsics.checkParameterIsNotNull(scrollCallback, "scrollCallback");
        this.a = i;
        this.b = scrollCallback;
    }

    public /* synthetic */ ScrollObserveConfig(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 30 : i, (i2 & 2) != 0 ? a.a : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScrollObserveConfig copy$default(ScrollObserveConfig scrollObserveConfig, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = scrollObserveConfig.a;
        }
        if ((i2 & 2) != 0) {
            function1 = scrollObserveConfig.b;
        }
        return scrollObserveConfig.copy(i, function1);
    }

    /* renamed from: component1, reason: from getter */
    public final int getA() {
        return this.a;
    }

    public final Function1<ViewExposureParam, Boolean> component2() {
        return this.b;
    }

    public final ScrollObserveConfig copy(int minOffset, Function1<? super ViewExposureParam, Boolean> scrollCallback) {
        Intrinsics.checkParameterIsNotNull(scrollCallback, "scrollCallback");
        return new ScrollObserveConfig(minOffset, scrollCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollObserveConfig)) {
            return false;
        }
        ScrollObserveConfig scrollObserveConfig = (ScrollObserveConfig) other;
        return this.a == scrollObserveConfig.a && Intrinsics.areEqual(this.b, scrollObserveConfig.b);
    }

    public final int getMinOffset() {
        return this.a;
    }

    public final Function1<ViewExposureParam, Boolean> getScrollCallback() {
        return this.b;
    }

    public int hashCode() {
        int i = this.a * 31;
        Function1<ViewExposureParam, Boolean> function1 = this.b;
        return i + (function1 != null ? function1.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbA = com.bytedance.bdtracker.a.a("ScrollObserveConfig(minOffset=");
        sbA.append(this.a);
        sbA.append(", scrollCallback=");
        sbA.append(this.b);
        sbA.append(")");
        return sbA.toString();
    }
}
