package a20;

import com.bytedance.android.live.broadcastgame.api.model.OpenFeatureScene;
import com.bytedance.android.live.broadcastgame.api.model.l0;
import com.bytedance.android.live.broadcastgame.api.model.m0;
import com.bytedance.android.live.broadcastgame.api.model.p;
import io.reactivex.Observable;
import java.util.LinkedList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public interface k {
    LinkedList<String> a();

    void b();

    Observable<com.bytedance.android.live.network.response.e<p>> c(long r100, long r101, int r102, String r103, int r104, String r105);

    Observable<com.bytedance.android.live.network.response.e<p>> d(long r100, long r101, int r102, String r103, String r104, int r105, String r106);

    Observable<p> e(@OpenFeatureScene long r100, String r101);

    Observable<Unit> f(p r100, String r101);

    Observable<com.bytedance.android.live.network.response.e<m0>> g(@OpenFeatureScene long r100, Long r101, int r102, String r103);

    void h(String r100);

    Observable<com.bytedance.android.live.network.response.e<l0>> i(long r100, String r101);

    Observable<com.bytedance.android.live.network.response.e<m0>> j(@OpenFeatureScene long r100, Long r101, int r102, String r103);
}
