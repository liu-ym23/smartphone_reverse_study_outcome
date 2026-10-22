package com.bytedance.android.live.revenue.platform.network.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.google.gson.JsonObject;
import dy0.c;
import f80.a;
import io.reactivex.Observable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public interface INetworkService extends a, c {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/api/INetworkService$Biz;", "", "Revenue", "MultiLink", "GameCp", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Biz extends Enum<Biz> {
        public static final Biz GameCp = null;
        public static final Biz MultiLink = null;
        public static final Biz Revenue = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Biz[] f91488a = null;

        static {
            Biz r100 = new Biz("Revenue", 0);
            Revenue = r100;
            Biz r101 = new Biz("MultiLink", 1);
            MultiLink = r101;
            Biz r102 = new Biz("GameCp", 2);
            GameCp = r102;
            f91488a = new Biz[]{r100, r101, r102};
        }

        public static Biz valueOf(String r100) {
            return (Biz) r27.a.a(Biz.class, r100);
        }

        public static Biz[] values() {
            return (Biz[]) f91488a.clone();
        }

        public Biz(String r100, int r101) {
            super(r100, r101);
        }
    }

    void K0(Biz r100, com.bytedance.android.livesdk.revenue.network.a r101);

    <DATA, EXTRA extends Extra> Observable<ExtraResponse<DATA, EXTRA>> L4(Biz r100, String r101, Type r102, Type r103, List<? extends com.bytedance.android.livesdk.revenue.network.a> r104, Map<String, String> r105, Map<String, String> r106, Map<String, ? extends List<String>> r107, Map<String, String> r108, Map<String, ? extends List<String>> r110, JsonObject r111);

    void s(Biz r100, com.bytedance.android.livesdk.revenue.network.a r101);

    <DATA, EXTRA extends Extra> Observable<ExtraResponse<DATA, EXTRA>> x0(Biz r100, String r101, Type r102, Type r103, List<? extends com.bytedance.android.livesdk.revenue.network.a> r104, Map<String, String> r105, Map<String, String> r106, Map<String, ? extends List<String>> r107);
}
