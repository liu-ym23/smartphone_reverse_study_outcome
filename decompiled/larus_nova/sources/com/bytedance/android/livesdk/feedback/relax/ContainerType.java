package com.bytedance.android.livesdk.feedback.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/relax/ContainerType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Small", "Big", "Four", "SmallScreenSmall", "SmallScreenBig", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType Big = null;
    public static final ContainerType Four = null;
    public static final ContainerType Small = null;
    public static final ContainerType SmallScreenBig = null;
    public static final ContainerType SmallScreenSmall = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f124737a = null;
    private final String value;

    static {
        ContainerType r100 = new ContainerType("Small", 0, "small");
        Small = r100;
        ContainerType r101 = new ContainerType("Big", 1, "big");
        Big = r101;
        ContainerType r102 = new ContainerType("Four", 2, "four");
        Four = r102;
        ContainerType r103 = new ContainerType("SmallScreenSmall", 3, "smallScreenSmall");
        SmallScreenSmall = r103;
        ContainerType r104 = new ContainerType("SmallScreenBig", 4, "smallScreenBig");
        SmallScreenBig = r104;
        f124737a = new ContainerType[]{r100, r101, r102, r103, r104};
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) r27.a.a(ContainerType.class, r100);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f124737a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ContainerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
