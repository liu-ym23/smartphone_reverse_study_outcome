package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
final class Descriptors$DescriptorPool$SearchFilter {

    /* renamed from: a, reason: collision with root package name */
    public static final Descriptors$DescriptorPool$SearchFilter f2821a;
    public static final Descriptors$DescriptorPool$SearchFilter b;
    public static final Descriptors$DescriptorPool$SearchFilter c;
    public static final /* synthetic */ Descriptors$DescriptorPool$SearchFilter[] d;

    static {
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter = new Descriptors$DescriptorPool$SearchFilter("TYPES_ONLY", 0);
        f2821a = descriptors$DescriptorPool$SearchFilter;
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter2 = new Descriptors$DescriptorPool$SearchFilter("AGGREGATES_ONLY", 1);
        b = descriptors$DescriptorPool$SearchFilter2;
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter3 = new Descriptors$DescriptorPool$SearchFilter("ALL_SYMBOLS", 2);
        c = descriptors$DescriptorPool$SearchFilter3;
        d = new Descriptors$DescriptorPool$SearchFilter[]{descriptors$DescriptorPool$SearchFilter, descriptors$DescriptorPool$SearchFilter2, descriptors$DescriptorPool$SearchFilter3};
    }

    public static Descriptors$DescriptorPool$SearchFilter valueOf(String str) {
        return (Descriptors$DescriptorPool$SearchFilter) Enum.valueOf(Descriptors$DescriptorPool$SearchFilter.class, str);
    }

    public static Descriptors$DescriptorPool$SearchFilter[] values() {
        return (Descriptors$DescriptorPool$SearchFilter[]) d.clone();
    }
}
