package com.google.gson;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ReflectionAccessFilter {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class FilterResult {

        /* renamed from: a, reason: collision with root package name */
        public static final FilterResult f5429a;

        /* renamed from: b, reason: collision with root package name */
        public static final FilterResult f5430b;

        /* renamed from: c, reason: collision with root package name */
        public static final FilterResult f5431c;

        /* renamed from: d, reason: collision with root package name */
        public static final FilterResult f5432d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ FilterResult[] f5433e;

        static {
            FilterResult filterResult = new FilterResult("ALLOW", 0);
            f5429a = filterResult;
            FilterResult filterResult2 = new FilterResult("INDECISIVE", 1);
            f5430b = filterResult2;
            FilterResult filterResult3 = new FilterResult("BLOCK_INACCESSIBLE", 2);
            f5431c = filterResult3;
            FilterResult filterResult4 = new FilterResult("BLOCK_ALL", 3);
            f5432d = filterResult4;
            f5433e = new FilterResult[]{filterResult, filterResult2, filterResult3, filterResult4};
        }

        public FilterResult() {
            throw null;
        }

        public static FilterResult valueOf(String str) {
            return (FilterResult) Enum.valueOf(FilterResult.class, str);
        }

        public static FilterResult[] values() {
            return (FilterResult[]) f5433e.clone();
        }
    }

    FilterResult a();
}
