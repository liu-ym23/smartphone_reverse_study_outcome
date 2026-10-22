package a06;

import com.bytedance.helios.api.consumer.EventHandler;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.lynx.tasm.LynxError;
import com.vivo.push.PushClientConstants;
import fz5.b;
import hz5.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements EventHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<b.a> f1316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1317b = null;

    public a() {
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final int stage() {
        return 1;
    }

    static {
        f1317b = new a();
        f1316a = new LinkedHashSet();
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final void a(PrivacyEvent r110) {
        if (f1316a.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = r110.f245366c;
        int r102 = 0;
        Object r103 = null;
        if (r101 != 102003) goto L8;
    L27:
        Object[] r104 = r110.f245389z.getParameters();
        if (r104 == null) goto L31;
        r102 = r104.length;
    L31:
        if (r102 < 2) goto L36;
        if (r104 == null) goto L34;
        Object r105 = r104[1];
    L35:
        r100.put("settingsKey", String.valueOf(r105));
        goto L36
    L34:
        r105 = null;
    L36:
        r100.put("apiId", Integer.valueOf(r110.f245366c));
        r100.put("resourceId", r110.f245365b);
        r100.put(PushClientConstants.TAG_CLASS_NAME, r110.f245363J);
        r100.put("memberName", r110.K);
        r100.put("isBackgroundInvoke", Boolean.valueOf(r110.f245372i));
        r100.put("pageName", r110.f245374k);
        r100.put("pageHashcode", Integer.valueOf(r110.f245375l));
        r100.put("pageStack", r110.f245371h);
        r100.put("invokeTime", Long.valueOf(r110.f245376m));
        r100.put("isReflection", Boolean.valueOf(r110.f245381r));
        r100.put("userRegion", r110.f245385v);
        r100.put("threadName", r110.f245382s);
        r100.put(LynxError.LYNX_THROWABLE, r110.f245369f);
        r100.put("isIntercept", r110.f245389z.getInterceptResult().first);
        Object r106 = r110.f245377n.get("strategyNames");
        if (TypeIntrinsics.isMutableSet(r106) == true) goto L39;
        r106 = null;
    L39:
        Set r107 = (Set) r106;
        if (r107 != null) goto L43;
        r107 = new LinkedHashSet();
    L43:
        r100.put("strategyNames", com.bytedance.helios.common.utils.a.a(r107));
        r100.put("rulerKeys", com.bytedance.helios.common.utils.a.a(r110.f245384u));
        r100.put("matrixFactors", r110.L);
        Object r108 = r110.f245377n.get("deny_params");
        if ((r108 instanceof Map) == false) goto L47;
        r103 = r108;
    L47:
        Map r109 = (Map) r103;
        if (r109 == null) goto L53;
        Iterator r111 = r109.entrySet().iterator();
    L51:
        if (r111.hasNext() == false) goto L53;
        Map.Entry r112 = (Map.Entry) r111.next();
        r100.put(r112.getKey(), String.valueOf(r112.getValue()));
    L53:
        k.b("Helios-Log-Monitor-Ability-Api-Call", "onApiStatistics map=" + r100);
        Iterator<T> r113 = f1316a.iterator();
    L55:
        if (r113.hasNext() == false) goto L57;
        ((b.a) r113.next()).onCallback();
        goto L55
    L57:
        return;
    L8:
        if (r101 == 102004) goto L27;
        if (r101 != 102900) goto L36;
        Object[] r114 = r110.f245389z.getParameters();
        if (r114 == null) goto L15;
        int r115 = r114.length;
    L16:
        if (r115 < 1) goto L36;
        if (r114 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        Object r116 = r114[0];
        if ((r116 instanceof String) == false) goto L23;
        String r117 = (String) r116;
    L26:
        r100.put("cmd", r117);
        goto L36
    L23:
        if ((r116 instanceof Object[]) == false) goto L25;
        r117 = ArraysKt.joinToString$default((Object[]) r116, " ", null, null, 0, null, null, 62, null);
        goto L26
    L25:
        r117 = "";
        goto L26
    L15:
        r115 = 0;
        goto L16
    }
}
