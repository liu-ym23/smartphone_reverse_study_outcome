package c40;

import com.bytedance.android.live.liveinteract.jsbridge.method.e0;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends BaseJsBridgeMethodFactory {

    public static final class a implements f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22374a = null;

        static {
            f22374a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final f<Object, Object> a() {
            return new e0();
        }
    }

    public b() {
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("live.cloudCollaborateAction", a.f22374a);
        return r101;
    }
}
