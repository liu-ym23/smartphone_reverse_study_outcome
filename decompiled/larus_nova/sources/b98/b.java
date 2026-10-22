package b98;

import com.larus.avlink.model.FlowDoraScene;
import com.larus.avlink.model.FlowDoraSceneState;
import com.larus.avlink.n1;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<d> f18331a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Integer> f18332b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final IDoraService f18333c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f18334d;

    public static String d(@FlowDoraScene int r100) {
        switch(r100) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            case 8: goto L4;
            default: goto L3;
        };
    L3:
        return "Unknown Scene";
    L4:
        return "Headphone";
    L5:
        return "G Recording";
    L6:
        return "Simultaneous Interpret";
    L7:
        return "Feedback";
    L8:
        return FlowDoraWifiScene.OTA;
    L9:
        return "Video Record";
    L10:
        return "Env Observer";
    L11:
        return "Live AI";
    L12:
        return "Session";
    }

    static {
        f18331a = new ArrayList();
        f18332b = new LinkedHashMap();
        f18333c = (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    @FlowDoraSceneState
    public static int a(@FlowDoraScene int r100) {
        Map<Integer, Integer> r101 = f18332b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Integer r103 = (Integer) r102.get(Integer.valueOf(r100));
        if (r103 != null) goto L7;
        return 0;
    L7:
        return r103.intValue();
    }

    public static boolean b(@FlowDoraScene int r100) {
        boolean r101 = true;
        if (a(r100) == 1) goto L6;
        r101 = false;
    L6:
        FLogger.f375446a.i("DoraSceneManager", "isInScene: scene:" + d(r100) + ", result:" + r101);
        return r101;
    }

    public static void c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) f18331a).add(r100);
    }

    public static void e(d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) f18331a).remove(r100);
    }

    public static void f(@FlowDoraScene int r100, @FlowDoraSceneState int r101) {
        StringBuilder r102 = new StringBuilder("updateSceneState: scene:");
        r102.append(d(r100));
        r102.append(", state:");
        if (r101 != 1) goto L5;
        String r103 = "Enter";
    L9:
        r102.append(r103);
        n1.d("DoraSceneManager", r102.toString());
        Integer r104 = Integer.valueOf(r100);
        Integer r105 = Integer.valueOf(r101);
        f18332b.put(r104, r105);
        Iterator r106 = ((ArrayList) f18331a).iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        ((d) r106.next()).a(r100, r101);
        goto L11
    L13:
        return;
    L5:
        if (r101 == 2) goto L7;
        r103 = "Unknown State";
        goto L9
    L7:
        r103 = "Exit";
        goto L9
    }
}
