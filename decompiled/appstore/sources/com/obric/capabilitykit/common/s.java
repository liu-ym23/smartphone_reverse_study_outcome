package com.obric.capabilitykit.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ConditionType;", "", "", "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum s extends Enum<s> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f11301b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f11302c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ s[] f11303d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11304a;

    static {
        f11301b = new s("TIME", 0, "time");
        f11302c = new s("LOCATION", 1, "location");
        f11303d = a();
    }

    private s(String r10, int r11, String r12) {
        super(r10, r11);
        this.f11304a = r12;
    }

    private static final /* synthetic */ s[] a() {
        return new s[]{f11301b, f11302c};
    }

    public static s valueOf(String r10) {
        return (s) Enum.valueOf(s.class, r10);
    }

    public static s[] values() {
        return (s[]) f11303d.clone();
    }

    @NotNull
    public final String b() {
        return this.f11304a;
    }
}
