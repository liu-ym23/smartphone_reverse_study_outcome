package androidx.room;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bg.c f4513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f4514b;

    public a(bg.c r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "resultRange");
        kotlin.jvm.internal.q.g(r11, "resultIndices");
        this.f4513a = r10;
        this.f4514b = r11;
    }

    public final List a() {
        return this.f4514b;
    }

    public final bg.c b() {
        return this.f4513a;
    }
}
