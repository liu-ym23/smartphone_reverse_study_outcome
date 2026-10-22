package bn9;

import android.text.TextUtils;
import com.larus.applog.api.IApplog;
import com.larus.office.base.plugins.statistics.ReportEventData;
import com.larus.office.base.service.m;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.bridge.BridgeHandlerV2;
import com.ss.android.lark.chameleon.bridge.CallBackFunction;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class c extends AbsChameleonPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<CopyOnWriteArrayList<WeakReference<bn9.a>>> f19773a = null;

    public static final class a {
        public static CopyOnWriteArrayList a() {
            return c.f19773a.getValue();
        }
    }

    public static final class b implements BridgeHandlerV2<Void> {
        public b() {
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public final void handle(Object r100, CallBackFunction r101) {
            Void r102 = (Void) r100;
            if (r101 == null) goto L6;
            Lazy r103 = m.f361113a;
            r101.onCallBack(null);
            return;
        }
    }

    /* JADX INFO: renamed from: bn9.c$c, reason: collision with other inner class name */
    public static final class C0320c implements BridgeHandlerV2<ReportEventData> {
        public C0320c() {
        }

        @Override // com.ss.android.lark.chameleon.bridge.JSHandler
        public final void handle(Object r100, CallBackFunction r101) {
            ReportEventData r102 = (ReportEventData) r100;
            if (r102 == null) goto L5;
            String r103 = r102.getEvent_name();
        L7:
            if (TextUtils.isEmpty(r103) == false) goto L9;
            FLogger.f375446a.e("ReportEventPlugin", "empty event name!");
            return;
        L9:
            if (r102 == null) goto L43;
            String r104 = r102.getEvent_name();
            if (r104 != null) goto L13;
            r104 = "";
        L13:
            JSONObject r105 = new JSONObject();
            Map<String, Object> r106 = r102.getData();
            if (r106 == null) goto L24;
            Set<Map.Entry<String, Object>> r107 = r106.entrySet();
            if (r107 == null) goto L24;
            Iterator<T> r108 = r107.iterator();
        L19:
            if (r108.hasNext() == false) goto L24;
            Map.Entry r109 = (Map.Entry) r108.next();
            String r110 = (String) r109.getKey();
            Object r111 = r109.getValue();
            if (r111 != null) goto L23;
            r111 = "";
        L23:
            r105.put(r110, r111);
        L24:
            Lazy<CopyOnWriteArrayList<WeakReference<bn9.a>>> r112 = c.f19773a;
            Iterator r113 = a.a().iterator();
        L26:
            if (r113.hasNext() == false) goto L31;
            WeakReference r114 = (WeakReference) r113.next();
            bn9.a r115 = (bn9.a) r114.get();
            if (r115 == null) goto L29;
            r115.d(r104, r105);
            goto L26
        L29:
            Lazy<CopyOnWriteArrayList<WeakReference<bn9.a>>> r116 = c.f19773a;
            a.a().remove(r114);
            goto L26
        L31:
            IApplog.f287053a.reportEvent(r104, r105);
            FLogger.f375446a.d("ReportEventPlugin", "repostEvent, eventName=" + r104 + ", eventParams=" + r105);
            return;
        L43:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    static {
        f19773a = LazyKt.lazy(new bn9.b());
    }

    @Override // com.ss.android.lark.chameleon.api.AbsChameleonPlugin, com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.BridgeInteractivePlugin
    public final void getBridgeHandlers(Map<String, BridgeHandlerV2<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlersHolder");
        super.getBridgeHandlers(r100);
        r100.put("biz.statistics.reportEvent", new C0320c());
        r100.put("biz.util.getTrackInfo", new b());
    }
}
