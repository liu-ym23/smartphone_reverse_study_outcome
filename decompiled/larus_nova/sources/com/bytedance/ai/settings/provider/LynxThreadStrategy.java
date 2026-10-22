package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/settings/provider/LynxThreadStrategy;", "", "asyncCreateView", "", "threadStrategy", "widgets", "", "", "<init>", "(IILjava/util/List;)V", "getAsyncCreateView", "()I", "getThreadStrategy", "getWidgets", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxThreadStrategy {

    @SerializedName("async_create_view")
    private final int asyncCreateView;

    @SerializedName("thread_strategy")
    private final int threadStrategy;

    @SerializedName("widgets")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> widgets;

    public LynxThreadStrategy() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LynxThreadStrategy copy$default(LynxThreadStrategy r100, int r101, int r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.asyncCreateView;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.threadStrategy;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.widgets;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.asyncCreateView;
    }

    public final int component2() {
        return this.threadStrategy;
    }

    public final List<String> component3() {
        return this.widgets;
    }

    public final LynxThreadStrategy copy(int r100, int r101, List<String> r102) {
        return new LynxThreadStrategy(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LynxThreadStrategy) == true) goto L8;
        return false;
    L8:
        LynxThreadStrategy r101 = (LynxThreadStrategy) r100;
        if (this.asyncCreateView == r101.asyncCreateView) goto L12;
        return false;
    L12:
        if (this.threadStrategy == r101.threadStrategy) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.widgets, r101.widgets) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.asyncCreateView * 31) + this.threadStrategy) * 31;
        List<String> r101 = this.widgets;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "LynxThreadStrategy(asyncCreateView=" + this.asyncCreateView + ", threadStrategy=" + this.threadStrategy + ", widgets=" + this.widgets + ')';
    }

    public final int getAsyncCreateView() {
        return this.asyncCreateView;
    }

    public final int getThreadStrategy() {
        return this.threadStrategy;
    }

    public final List<String> getWidgets() {
        return this.widgets;
    }

    public LynxThreadStrategy(int r100, int r101, List<String> r102) {
        this.asyncCreateView = r100;
        this.threadStrategy = r101;
        this.widgets = r102;
    }

    public /* synthetic */ LynxThreadStrategy(int r100, int r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        this(r100, r101, r102);
    }
}
