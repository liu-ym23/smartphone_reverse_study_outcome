package b1b;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleonv2.lkapi.biz.statistics.IBizStatistics$SendEventData;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: b1b.a$a, reason: collision with other inner class name */
    public static final class C0250a {
    }

    public final class b extends AbsChameleonHandler<IBizStatistics$SendEventData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f16961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f16962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f16963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f16964d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f16965e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f16966f;

        public b() {
            this.f16966f = LKAPIModules.Biz.Statistics.SendEvent.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f16966f;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IBizStatistics$SendEventData r100, Callback r101) {
            IBizStatistics$SendEventData r102 = r100;
            Intrinsics.checkNotNullParameter(r102, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            String r103 = r102.getEventType();
            long r104 = r102.getTimeStamp();
            IChameleonHandlerContext r105 = getContext();
            IChameleonHandlerContext r106 = null;
            if (r105 == null) goto L5;
            String r107 = r105.getSession();
        L6:
            j.e("LK_API_TAG_BizStatistics", "sendEvent eventType: " + r103 + ", timeStamp: " + r104 + ", session: " + r107);
            switch(r103.hashCode()) {
                case -1335757144: goto L37;
                case 22961241: goto L33;
                case 533049767: goto L29;
                case 1258430724: goto L25;
                case 1680455314: goto L14;
                case 1868695392: goto L10;
                default: goto L50;
            };
        L50:
            j.f("LK_API_TAG_BizStatistics", "unkown eventType");
        L51:
            r101.success("");
            return;
        L10:
            if (r103.equals(ChameleonOpenTracker.EventType.PULL_DATA_END) == false) goto L50;
            this.f16963c = r104;
            goto L51
        L14:
            if (r103.equals(ChameleonOpenTracker.EventType.RENDER_END) == false) goto L50;
            u1b.a.C7822a r108 = u1b.a.a(r107);
            if (r108 != null) goto L19;
            j.f("LK_API_TAG_BizStatistics", "sessionTracker is null");
            r101.error(new LKAPIError(-1, "sessionTracker is null"));
            return;
        L19:
            r108.c("preload", this.f16961a);
            r108.d(ChameleonOpenTracker.Stage.PULLDATA, this.f16962b);
            r108.c(ChameleonOpenTracker.Stage.PULLDATA, this.f16963c);
            r108.d(ChameleonOpenTracker.Stage.RENDER, this.f16964d);
            r108.d("preloadrender", this.f16961a);
            r108.c("preloadrender", this.f16965e);
            r108.c(ChameleonOpenTracker.Stage.RENDER, r104);
            Iterator<Map.Entry<String, String>> r109 = r102.getParams().entrySet().iterator();
        L21:
            if (r109.hasNext() == false) goto L23;
            Map.Entry<String, String> r110 = r109.next();
            r108.f548365e.put(r110.getKey(), r110.getValue());
            goto L21
        L23:
            r108.a("success", 0, r104);
            goto L51
        L25:
            if (r103.equals(ChameleonOpenTracker.EventType.RES_READY) == false) goto L50;
            this.f16961a = r104;
            goto L51
        L29:
            if (r103.equals(ChameleonOpenTracker.EventType.PULL_DATA_START) == false) goto L50;
            this.f16962b = r104;
            goto L51
        L33:
            if (r103.equals(ChameleonOpenTracker.EventType.RENDER_START) == false) goto L50;
            this.f16964d = r104;
            goto L51
        L37:
            if (r103.equals("PRELOAD_RENDER_END") == false) goto L50;
            this.f16965e = r104;
            IChameleonHandlerContext r111 = getContext();
            if (r111 == null) goto L42;
            WebView r112 = r111.getWebview();
        L44:
            if ((r112 instanceof IChameleonHandlerContext) == false) goto L46;
            r106 = (IChameleonHandlerContext) r112;
        L46:
            if (r106 == null) goto L51;
            IChameleonLoader r113 = r106.getWebviewLoader();
            if (r113 == null) goto L51;
            r113.onLoadSuccess();
            goto L51
        L42:
            r112 = null;
            goto L44
        L5:
            r107 = null;
            goto L6
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
