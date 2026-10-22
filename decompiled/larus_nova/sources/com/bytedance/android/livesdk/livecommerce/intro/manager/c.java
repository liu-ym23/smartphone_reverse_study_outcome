package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(i r100, IntroCardScene r101, int r110) {
            r100.e(r101, null, null, null, null, null, null);
        }
    }

    boolean a(Integer r100);

    List<uh2.a> b();

    com.bytedance.android.livesdk.livecommerce.intro.event.j c();

    void d(LiveIntroResponse r100);

    void e(IntroCardScene r100, Pair<Long, Long> r101, sh2.b r102, String r103, Map<String, String> r104, Function2<? super LiveIntroResponse, ? super List<? extends uh2.a>, Unit> r105, sh2.a r106);

    void f(List<? extends uh2.a> r100);

    void g(String r100, String r101, boolean r102);

    boolean h(sh2.a r100);

    Integer j();
}
