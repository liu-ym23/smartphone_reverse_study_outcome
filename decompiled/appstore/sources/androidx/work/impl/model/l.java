package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.c f5659b;

    public l(String r10, androidx.work.c r11) {
        kotlin.jvm.internal.q.g(r10, "workSpecId");
        kotlin.jvm.internal.q.g(r11, "progress");
        this.f5658a = r10;
        this.f5659b = r11;
    }

    public final androidx.work.c a() {
        return this.f5659b;
    }

    public final String b() {
        return this.f5658a;
    }
}
