package z0;

import java.io.IOException;

/* renamed from: z0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1339e extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private final int f24044a;

    public C1339e(int i5) {
        this("Http request failed with status code: " + i5, i5);
    }

    public C1339e(String str) {
        this(str, -1);
    }

    public C1339e(String str, int i5) {
        this(str, i5, null);
    }

    public C1339e(String str, int i5, Throwable th) {
        super(str, th);
        this.f24044a = i5;
    }
}
