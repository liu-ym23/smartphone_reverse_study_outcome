package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/RandomMatchStrategy;", "", "Unknown", "Normal", "LargeMatch", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RandomMatchStrategy extends Enum<RandomMatchStrategy> {
    public static final RandomMatchStrategy LargeMatch = null;
    public static final RandomMatchStrategy Normal = null;
    public static final RandomMatchStrategy Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RandomMatchStrategy[] f147078a = null;

    static {
        RandomMatchStrategy r100 = new RandomMatchStrategy("Unknown", 0);
        Unknown = r100;
        RandomMatchStrategy r101 = new RandomMatchStrategy("Normal", 1);
        Normal = r101;
        RandomMatchStrategy r102 = new RandomMatchStrategy("LargeMatch", 2);
        LargeMatch = r102;
        f147078a = new RandomMatchStrategy[]{r100, r101, r102};
    }

    public static RandomMatchStrategy valueOf(String r100) {
        return (RandomMatchStrategy) r27.a.a(RandomMatchStrategy.class, r100);
    }

    public static RandomMatchStrategy[] values() {
        return (RandomMatchStrategy[]) f147078a.clone();
    }

    public RandomMatchStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
