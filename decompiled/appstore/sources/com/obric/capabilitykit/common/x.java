package com.obric.capabilitykit.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityId;", "", "id", "", "type", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getType", "()I", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11311b;

    public x(@NotNull String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "id");
        this.f11310a = r10;
        this.f11311b = r11;
    }

    @NotNull
    public final String a() {
        return this.f11310a;
    }

    public final int b() {
        return this.f11311b;
    }
}
