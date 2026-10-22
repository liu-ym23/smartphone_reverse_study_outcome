package ca9;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22971a = null;

    static {
        f22971a = new a();
    }

    public a() {
    }

    @Override // ca9.c
    public final void a(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
    }

    @Override // ca9.c
    public final void b(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
    }

    @Override // ca9.c
    public final void c(String r100, String r101, List<String> r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "what");
        Intrinsics.checkNotNullParameter(r101, "where");
        Intrinsics.checkNotNullParameter(r103, "params");
    }
}
