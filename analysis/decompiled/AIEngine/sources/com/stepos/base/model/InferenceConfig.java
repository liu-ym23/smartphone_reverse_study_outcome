package com.stepos.base.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InferenceConfig {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f6262i = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f6263a;

    /* renamed from: b, reason: collision with root package name */
    public final ComputeDevice f6264b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6265c;

    /* renamed from: d, reason: collision with root package name */
    public final PerformanceProfile f6266d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6267e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6268f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f6269g;
    public final Map<String, Object> h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ComputeDevice {

        /* renamed from: a, reason: collision with root package name */
        public static final ComputeDevice f6270a;

        /* renamed from: b, reason: collision with root package name */
        public static final ComputeDevice f6271b;

        /* renamed from: c, reason: collision with root package name */
        public static final ComputeDevice f6272c;

        /* renamed from: d, reason: collision with root package name */
        public static final ComputeDevice f6273d;

        /* renamed from: e, reason: collision with root package name */
        public static final ComputeDevice f6274e;
        public static final /* synthetic */ ComputeDevice[] h;

        static {
            ComputeDevice computeDevice = new ComputeDevice("AUTO", 0);
            f6270a = computeDevice;
            ComputeDevice computeDevice2 = new ComputeDevice("CPU", 1);
            f6271b = computeDevice2;
            ComputeDevice computeDevice3 = new ComputeDevice("GPU", 2);
            f6272c = computeDevice3;
            ComputeDevice computeDevice4 = new ComputeDevice("NPU", 3);
            f6273d = computeDevice4;
            ComputeDevice computeDevice5 = new ComputeDevice("DSP", 4);
            f6274e = computeDevice5;
            ComputeDevice[] computeDeviceArr = {computeDevice, computeDevice2, computeDevice3, computeDevice4, computeDevice5};
            h = computeDeviceArr;
            kotlin.enums.a.a(computeDeviceArr);
        }

        public ComputeDevice() {
            throw null;
        }

        public static ComputeDevice valueOf(String str) {
            return (ComputeDevice) Enum.valueOf(ComputeDevice.class, str);
        }

        public static ComputeDevice[] values() {
            return (ComputeDevice[]) h.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PerformanceProfile {

        /* renamed from: a, reason: collision with root package name */
        public static final PerformanceProfile f6275a;

        /* renamed from: b, reason: collision with root package name */
        public static final PerformanceProfile f6276b;

        /* renamed from: c, reason: collision with root package name */
        public static final PerformanceProfile f6277c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ PerformanceProfile[] f6278d;

        static {
            PerformanceProfile performanceProfile = new PerformanceProfile("POWER_SAVING", 0);
            f6275a = performanceProfile;
            PerformanceProfile performanceProfile2 = new PerformanceProfile("BALANCED", 1);
            f6276b = performanceProfile2;
            PerformanceProfile performanceProfile3 = new PerformanceProfile("PERFORMANCE", 2);
            f6277c = performanceProfile3;
            PerformanceProfile[] performanceProfileArr = {performanceProfile, performanceProfile2, performanceProfile3};
            f6278d = performanceProfileArr;
            kotlin.enums.a.a(performanceProfileArr);
        }

        public PerformanceProfile() {
            throw null;
        }

        public static PerformanceProfile valueOf(String str) {
            return (PerformanceProfile) Enum.valueOf(PerformanceProfile.class, str);
        }

        public static PerformanceProfile[] values() {
            return (PerformanceProfile[]) f6278d.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f6279a;

        public static String a(String str) {
            return a0.a.k("InferenceBackend(key=", str, ")");
        }

        public final boolean equals(Object obj) {
            if (obj instanceof a) {
                return g.b(this.f6279a, ((a) obj).f6279a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f6279a.hashCode();
        }

        public final String toString() {
            return a(this.f6279a);
        }
    }

    static {
        new InferenceConfig(null, null, 0, null, false, null, false, null, 511);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.util.Map] */
    public InferenceConfig(String str, ComputeDevice computeDevice, int i10, PerformanceProfile performanceProfile, boolean z, String str2, boolean z3, LinkedHashMap linkedHashMap, int i11) {
        str = (i11 & 1) != 0 ? "AUTO" : str;
        computeDevice = (i11 & 2) != 0 ? ComputeDevice.f6270a : computeDevice;
        i10 = (i11 & 4) != 0 ? 2 : i10;
        performanceProfile = (i11 & 8) != 0 ? PerformanceProfile.f6276b : performanceProfile;
        z = (i11 & 16) != 0 ? true : z;
        str2 = (i11 & 32) != 0 ? "q8_0" : str2;
        z3 = (i11 & 64) != 0 ? true : z3;
        LinkedHashMap linkedHashMapD0 = (i11 & 256) != 0 ? kotlin.collections.b.d0() : linkedHashMap;
        g.f(computeDevice, "computeDevice");
        g.f(performanceProfile, "performanceProfile");
        this.f6263a = str;
        this.f6264b = computeDevice;
        this.f6265c = i10;
        this.f6266d = performanceProfile;
        this.f6267e = z;
        this.f6268f = str2;
        this.f6269g = z3;
        this.h = linkedHashMapD0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InferenceConfig)) {
            return false;
        }
        InferenceConfig inferenceConfig = (InferenceConfig) obj;
        return g.b(this.f6263a, inferenceConfig.f6263a) && this.f6264b == inferenceConfig.f6264b && this.f6265c == inferenceConfig.f6265c && this.f6266d == inferenceConfig.f6266d && this.f6267e == inferenceConfig.f6267e && g.b(this.f6268f, inferenceConfig.f6268f) && this.f6269g == inferenceConfig.f6269g && g.b(this.h, inferenceConfig.h);
    }

    public final int hashCode() {
        return this.h.hashCode() + ai.onnxruntime.a.f(d.a(ai.onnxruntime.a.f((this.f6266d.hashCode() + ai.onnxruntime.a.d(this.f6265c, (this.f6264b.hashCode() + (this.f6263a.hashCode() * 31)) * 31, 31)) * 31, 31, this.f6267e), 31, this.f6268f), 961, this.f6269g);
    }

    public final String toString() {
        return "InferenceConfig(backend=" + a.a(this.f6263a) + ", computeDevice=" + this.f6264b + ", threads=" + this.f6265c + ", performanceProfile=" + this.f6266d + ", quantizationEnabled=" + this.f6267e + ", quantizationType=" + this.f6268f + ", warmupEnabled=" + this.f6269g + ", warmupInput=null, extra=" + this.h + ")";
    }
}
