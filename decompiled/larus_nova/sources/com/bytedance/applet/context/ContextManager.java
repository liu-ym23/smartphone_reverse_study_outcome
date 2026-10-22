package com.bytedance.applet.context;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.monitor.b;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.api.IAppletPayloadProviderService;
import com.larus.bmhome.chat.api.t0;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin$initAppletPayloadChangeListener$1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import k5.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ4\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applet/context/ContextManager;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "providers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ai/context/IContextProvider;", "appletPayloadChangedListeners", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "addContextProvider", "", ShortVideoSegments.KEY_PROP_PROVIDER, "removeContextProvider", "getAppletPayload", "", "conversationId", "botId", RemoteMessageConst.MSGID, "addOnAppletPayloadChangedListener", "listener", "removeOnAppletPayloadChangedListener", "getWidgetContext", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetContext", PerfLog.PARAM_KEY_CONTEXT_ID, "onAppletPayloadChanged", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextManager implements IAppletPayloadProviderService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContextManager f191491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f191492b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<t4.a> f191493c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArrayList<t0> f191494d = null;

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f191495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f191496b;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            String r101 = this.f191495a;
            if (r101 == null) goto L5;
            r100.f(MusicAppletPage.KEY_MESSAGE_ID, r101);
        L5:
            Gson r102 = new Gson();
            Map<String, String> r103 = this.f191496b;
            LinkedHashMap r104 = new LinkedHashMap();
            Iterator<Map.Entry<String, String>> r105 = r103.entrySet().iterator();
        L7:
            if (r105.hasNext() == false) goto L14;
            Map.Entry<String, String> r106 = r105.next();
            if (r106.getKey() == null) goto L11;
            boolean r107 = true;
        L12:
            if (r107 == false) goto L7;
            r104.put(r106.getKey(), r106.getValue());
            goto L7
        L11:
            r107 = false;
            goto L12
        L14:
            r100.i(new JSONObject(GsonProtectorUtils.toJson(r102, r104)));
        }

        public a(String r100, Map<String, String> r101) {
            this.f191495a = r100;
            this.f191496b = r101;
        }
    }

    private ContextManager() {
    }

    static {
        f191491a = new ContextManager();
        f191492b = new Gson();
        CopyOnWriteArrayList<t4.a> r100 = new CopyOnWriteArrayList();
        f191493c = r100;
        f191494d = new CopyOnWriteArrayList();
        AppletRuntimeManager r101 = AppletRuntimeManager.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        r100.add(r101);
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void a(t0 r100) {
        f191494d.remove(r100);
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final void c(CommonAppletPlugin$initAppletPayloadChangeListener$1 r100) {
        f191494d.add(r100);
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ContextManager$updateWidgetContext$1(r100, r101, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.api.IAppletPayloadProviderService
    public final Map<String, String> b(String r100, String r110, String r111) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<t4.a> r102 = f191493c.iterator();
    L4:
        if (r102.hasNext() == false) goto L25;
        t4.a r103 = r102.next();
        if (r100 != null) goto L8;
        String r104 = "";
    L9:
        if (r110 != null) goto L11;
        String r105 = "";
    L12:
        if (r111 != null) goto L14;
        String r106 = "";
    L15:
        Map<String, String> r107 = r103.getContext(r104, r105, r106);
        if (r107 == null) goto L4;
        Iterator<Map.Entry<String, String>> r108 = r107.entrySet().iterator();
    L19:
        if (r108.hasNext() == false) goto L4;
        Map.Entry<String, String> r109 = r108.next();
        if (o0.d((String) r101.get(r109.getKey())) == false) goto L23;
        String r112 = r109.getKey();
        r101.put(r112, ((String) r101.get(r112)) + '\n');
    L24:
        String r113 = r109.getKey();
        r101.put(r113, ((String) r101.get(r113)) + r109.getValue());
        goto L19
    L23:
        r101.put(r109.getKey(), "");
        goto L24
    L14:
        r106 = r111;
        goto L15
    L11:
        r105 = r110;
        goto L12
    L8:
        r104 = r100;
        goto L9
    L25:
        Iterator r114 = r101.entrySet().iterator();
    L27:
        if (r114.hasNext() == false) goto L34;
        if (((CharSequence) ((Map.Entry) r114.next()).getValue()).length() != 0) goto L31;
        boolean r115 = true;
    L32:
        if (r115 == false) goto L27;
        r114.remove();
        goto L27
    L31:
        r115 = false;
        goto L32
    L34:
        b.d("applet_payload", new a(r111, r101));
        if (r101.isEmpty() == false) goto L50;
        return null;
    L50:
        return r101;
    }
}
