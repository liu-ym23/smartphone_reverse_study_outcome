package j3;

import h3.H;
import h3.L;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import y1.f;

/* renamed from: j3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0639c implements L {

    /* renamed from: a, reason: collision with root package name */
    public volatile Set f13138a;

    /* renamed from: b, reason: collision with root package name */
    public volatile EnumC0637a f13139b;

    public C0639c() {
        f logger = InterfaceC0638b.f13137e0;
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f13138a = SetsKt.emptySet();
        this.f13139b = EnumC0637a.f13133a;
    }

    public final void a(H h4, int i4) {
        String message = h4.c(i4) + ": " + (this.f13138a.contains(h4.c(i4)) ? "██" : h4.f(i4));
        Intrinsics.checkNotNullParameter(message, "message");
        Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02f8  */
    @Override // h3.L
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final h3.b0 intercept(h3.K r32) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.C0639c.intercept(h3.K):h3.b0");
    }
}
