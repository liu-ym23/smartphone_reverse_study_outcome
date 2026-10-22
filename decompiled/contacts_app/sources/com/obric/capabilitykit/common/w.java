package com.obric.capabilitykit.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityId;", "", "id", "", "type", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getType", "()I", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class w {
    private final String a;
    private final int b;

    public w(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.a = r2;
        this.b = r3;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }
}
