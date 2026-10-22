package com.bytedance.android.shopping.api.video;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/video/SelectBitrateResolutionStrategy;", "", "", "resolution", "I", "getResolution", "()I", "setResolution", "(I)V", "viewHeight", "getViewHeight", "viewWidth", "getViewWidth", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DEFAULT", "VIEW_SIZE_ADAPTION", "LOWEST", "HIGHEST", "LESS_RESOLUTION", "MORE_RESOLUTION", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SelectBitrateResolutionStrategy extends Enum<SelectBitrateResolutionStrategy> {
    public static final a Companion = null;
    public static final SelectBitrateResolutionStrategy DEFAULT = null;
    public static final SelectBitrateResolutionStrategy HIGHEST = null;
    public static final SelectBitrateResolutionStrategy LESS_RESOLUTION = null;
    public static final SelectBitrateResolutionStrategy LOWEST = null;
    public static final SelectBitrateResolutionStrategy MORE_RESOLUTION = null;
    public static final SelectBitrateResolutionStrategy VIEW_SIZE_ADAPTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectBitrateResolutionStrategy[] f170629a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, SelectBitrateResolutionStrategy> f170630b = null;
    private int resolution;
    private final int viewHeight;
    private final int viewWidth;

    public static final class a {
        public a() {
        }
    }

    static {
        SelectBitrateResolutionStrategy r100 = new SelectBitrateResolutionStrategy("DEFAULT", 0, 0, 0, 0, 7, null);
        DEFAULT = r100;
        int r101 = 0;
        SelectBitrateResolutionStrategy r102 = new SelectBitrateResolutionStrategy("VIEW_SIZE_ADAPTION", 1, 0, 0, 0, 7, null);
        VIEW_SIZE_ADAPTION = r102;
        SelectBitrateResolutionStrategy r103 = new SelectBitrateResolutionStrategy("LOWEST", 2, 0, 0, 0, 7, null);
        LOWEST = r103;
        SelectBitrateResolutionStrategy r104 = new SelectBitrateResolutionStrategy("HIGHEST", 3, 0, 0, 0, 7, null);
        HIGHEST = r104;
        SelectBitrateResolutionStrategy r105 = new SelectBitrateResolutionStrategy("LESS_RESOLUTION", 4, 0, 0, 0, 7, null);
        LESS_RESOLUTION = r105;
        SelectBitrateResolutionStrategy r106 = new SelectBitrateResolutionStrategy("MORE_RESOLUTION", 5, 0, 0, 0, 7, null);
        MORE_RESOLUTION = r106;
        f170629a = new SelectBitrateResolutionStrategy[]{r100, r102, r103, r104, r105, r106};
        Companion = new a();
        SelectBitrateResolutionStrategy[] r107 = values();
        LinkedHashMap r108 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r107.length), 16));
        int r109 = r107.length;
    L3:
        if (r101 >= r109) goto L5;
        SelectBitrateResolutionStrategy r110 = r107[r101];
        r108.put(Integer.valueOf(r110.ordinal()), r110);
        r101 = r101 + 1;
        goto L3
    L5:
        f170630b = r108;
    }

    public SelectBitrateResolutionStrategy() {
        throw null;
    }

    public static SelectBitrateResolutionStrategy valueOf(String r100) {
        return (SelectBitrateResolutionStrategy) r27.a.a(SelectBitrateResolutionStrategy.class, r100);
    }

    public static SelectBitrateResolutionStrategy[] values() {
        return (SelectBitrateResolutionStrategy[]) f170629a.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return f170630b;
    }

    public final int getResolution() {
        return this.resolution;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final void setResolution(int r100) {
        this.resolution = r100;
    }

    public SelectBitrateResolutionStrategy(String r100, int r101, int r102, int r103, int r104, int r105, DefaultConstructorMarker r106) {
        if ((r105 & 1) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r103 = 0;
    L9:
        if ((r105 & 4) == 0) goto L11;
        r104 = 0;
    L11:
        super(r100, r101);
        this.resolution = r102;
        this.viewHeight = r103;
        this.viewWidth = r104;
    }
}
