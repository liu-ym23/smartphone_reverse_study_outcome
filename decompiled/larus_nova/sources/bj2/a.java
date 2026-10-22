package bj2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f19209a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter("ExplainPlaybackPresenter", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
        dm.a.a("ExplainPlayback_ExplainPlaybackPresenter").a(r100);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        dm.a.b r102 = dm.a.f469202a;
        dm.a.a("ExplainPlayback_".concat(r100)).i(r101);
    }
}
