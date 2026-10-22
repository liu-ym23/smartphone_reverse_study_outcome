package com.bytedance.android.live.effect.sticker.presenter;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f68348a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<String> f68349a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f68350b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f68351c = null;

        public a() {
        }

        static {
            f68351c = new a();
            List<String> r100 = CollectionsKt.listOf(new String[]{com.bytedance.android.live.effect.api.d0.f66759i, "beautyclassify", com.bytedance.android.live.effect.api.d0.f66761k, com.bytedance.android.live.effect.api.d0.f66762l, "livebody"});
            f68349a = r100;
            r100.size();
            f68350b = r100.size() - 1;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(n r100, h r101) {
            r100.f(r101, "");
        }

        public static /* synthetic */ void b(n r100, h r101) {
            r100.a(r101, "");
        }
    }

    static {
        f68348a = a.f68351c;
    }

    void a(h r100, String r101);

    List<String> b();

    boolean c();

    boolean d();

    boolean e();

    void f(h r100, String r101);

    String g();

    void h(String r100, String r101);

    Map<String, BeautyModeInfo> i();
}
