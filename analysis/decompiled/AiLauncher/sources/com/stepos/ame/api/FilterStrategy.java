package com.stepos.ame.api;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/ame/api/FilterStrategy;", "", "", UxipConstants.f30680s, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", Const.INTENT_KEY_APIKEY, "POST_FILTER", "PRE_FILTER", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FilterStrategy {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FilterStrategy[] $VALUES;
    public static final FilterStrategy POST_FILTER = new FilterStrategy("POST_FILTER", 0, 0);
    public static final FilterStrategy PRE_FILTER = new FilterStrategy("PRE_FILTER", 1, 1);
    private final int value;

    private static final /* synthetic */ FilterStrategy[] $values() {
        return new FilterStrategy[]{POST_FILTER, PRE_FILTER};
    }

    static {
        FilterStrategy[] filterStrategyArr$values = $values();
        $VALUES = filterStrategyArr$values;
        $ENTRIES = a.a(filterStrategyArr$values);
        INSTANCE = new Companion(null);
    }

    private FilterStrategy(String str, int i10, int i11) {
        this.value = i11;
    }

    public static InterfaceC4149a<FilterStrategy> getEntries() {
        return $ENTRIES;
    }

    public static FilterStrategy valueOf(String str) {
        return (FilterStrategy) Enum.valueOf(FilterStrategy.class, str);
    }

    public static FilterStrategy[] values() {
        return (FilterStrategy[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
