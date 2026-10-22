package kotlin;

import com.stepos.core.download.ModelFlowMeta;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LazyThreadSafetyMode {

    /* renamed from: a, reason: collision with root package name */
    public static final LazyThreadSafetyMode f9983a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LazyThreadSafetyMode[] f9984b;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = new LazyThreadSafetyMode("SYNCHRONIZED", 0);
        LazyThreadSafetyMode lazyThreadSafetyMode2 = new LazyThreadSafetyMode("PUBLICATION", 1);
        f9983a = lazyThreadSafetyMode2;
        LazyThreadSafetyMode[] lazyThreadSafetyModeArr = {lazyThreadSafetyMode, lazyThreadSafetyMode2, new LazyThreadSafetyMode(ModelFlowMeta.PLAN_NONE, 2)};
        f9984b = lazyThreadSafetyModeArr;
        kotlin.enums.a.a(lazyThreadSafetyModeArr);
    }

    public LazyThreadSafetyMode() {
        throw null;
    }

    public static LazyThreadSafetyMode valueOf(String str) {
        return (LazyThreadSafetyMode) Enum.valueOf(LazyThreadSafetyMode.class, str);
    }

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[]) f9984b.clone();
    }
}
