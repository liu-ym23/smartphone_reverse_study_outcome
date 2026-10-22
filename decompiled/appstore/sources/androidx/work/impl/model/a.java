package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5630b;

    public a(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "workSpecId");
        kotlin.jvm.internal.q.g(r11, "prerequisiteId");
        this.f5629a = r10;
        this.f5630b = r11;
    }

    public final String a() {
        return this.f5630b;
    }

    public final String b() {
        return this.f5629a;
    }
}
