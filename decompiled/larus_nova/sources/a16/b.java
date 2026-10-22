package a16;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.kit.bridge.h;
import h16.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.Charsets;
import org.json.JSONObject;
import yf7.j;
import yf7.n;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1377a;

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f1378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f1379b;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return "bytesyncMsg";
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            if ((this.f1378a.getKitView() instanceof b36.e) == false) goto L6;
            JSONObject r100 = new JSONObject();
            r100.put("data", this.f1379b);
            return r100;
        L6:
            return this.f1379b;
        }

        public a(e r100, JSONObject r101) {
            this.f1378a = r100;
            this.f1379b = r101;
        }
    }

    public b(long r100) {
        this.f1377a = r100;
    }

    @Override // yf7.n
    public final void a(j.a r100) {
        if (r100 != null) goto L25;
        HybridLogger.i("OnDataUpdateListenerImpl", "ISyncClient.Data is null", null, 12);
        return;
    L25:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
        JSONObject r102 = new JSONObject(new String(r100.f567450a, Charsets.UTF_8));     // Catch: Throwable -> L19
        List r103 = (List) ((LinkedHashMap) a16.a.f1376b).get(Long.valueOf(this.f1377a));     // Catch: Throwable -> L19
        if (r103 == null) goto L16;
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L19
    L10:
        if (r104.hasNext() == false) goto L15;
        e r105 = (e) ((WeakReference) r104.next()).get();     // Catch: Throwable -> L19
        if (r105 == null) goto L13;
        r105.onEvent(new a(r105, r102));     // Catch: Throwable -> L19
        HybridLogger r106 = HybridLogger.f246343a;     // Catch: Throwable -> L19
        HybridLogger.m("OnDataUpdateListenerImpl", "container: " + r105.getSessionId() + " send msg: " + r102 + " success !!!", null, null, 12);     // Catch: Throwable -> L19
        goto L10
    L13:
        HybridLogger r107 = HybridLogger.f246343a;     // Catch: Throwable -> L19
        HybridLogger.i("OnDataUpdateListenerImpl", "container is null, drop msg " + r102, null, 12);     // Catch: Throwable -> L19
        goto L10
    L15:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L19
    L21:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L33;
        HybridLogger r111 = HybridLogger.f246343a;
        HybridLogger.i("OnDataUpdateListenerImpl", "error is " + r110.getMessage(), null, 12);
        return;
    L33:
        return;
    L16:
        r108 = null;
    L19:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
