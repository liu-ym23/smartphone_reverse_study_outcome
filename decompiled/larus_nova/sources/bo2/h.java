package bo2;

import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.performance.hprof.api.ILiveCrashApi;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f19796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile SharedPreferences f19797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f19798c;

    public static final class a {
        public a() {
        }
    }

    public h() {
        this.f19796a = new CompositeDisposable();
        this.f19798c = new a();
    }

    @Override // bo2.c
    public final void a(PolarisFileWrapper r100, ff7.e r101) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.getName();
        JSONObject r102 = new JSONObject();
        Map<String, String> r103 = com.bytedance.apm.d.g();
        if (r103 == null) goto L8;
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, String> r105 = r104.next();
        r102.put(r105.getKey(), r105.getValue());
    L8:
        RxUtilKt.c(((ILiveCrashApi) com.bytedance.android.live.network.c.b().e(ILiveCrashApi.class)).getUploadInfo(1).timeout(2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new j(this, r100, r101), k.f19809a), this.f19796a);
    }
}
