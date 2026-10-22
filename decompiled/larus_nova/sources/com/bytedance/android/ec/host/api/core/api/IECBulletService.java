package com.bytedance.android.ec.host.api.core.api;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import ti.b;
import ti.c;
import ti.d;
import ti.e;
import ti.h;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\u0007\u001a\u00020\u0006H&J¸\u0001\u0010\u001e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00062\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0006H&J\"\u0010$\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H&J$\u0010%\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H&JV\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0018\b\u0002\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010,\u001a\u00020\u0010H&J\n\u00100\u001a\u0004\u0018\u00010/H&JJ\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\u0006\u0010!\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00102\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\u0006\u0010+\u001a\u000202H\u0016J\"\u00108\u001a\u0004\u0018\u0001072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0006\u00106\u001a\u000205H&¨\u00069"}, d2 = {"Lcom/bytedance/android/ec/host/api/core/api/IECBulletService;", "", "factory", "", "injectExternalBridges", "getCoreProvider", "", "getBid", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "schema", "Lorg/json/JSONObject;", "extras", "", "type", "triggerOrigin", "", "showClose", "height", "maskColor", "closeByMask", "closeByGesture", "keyboardStyle", "style", "blockBackPress", "listenKeyboard", "lastContainerId", "Lkotlin/Function1;", "containerCB", "loadStatusCB", "showBulletPanel", "containerID", "closeBulletPanel", "url", "Landroid/os/Bundle;", "bundle", "openWithRifle", "openSchema", "", "initialData", "Landroid/view/ViewGroup;", "viewGroup", "Lti/k;", "callback", "useAnnie", "Lti/l;", "createLiveHybridComponent", "Lti/h;", "getBridgeProvider", "isLynx", "Lti/b;", "Lti/c;", "createAnnieCardComponentAndRegisterCrashMonitor", "Lti/e;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lti/d;", "createLiveAnnieComponent", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECBulletService {
    void closeBulletPanel(String r100);

    c createAnnieCardComponentAndRegisterCrashMonitor(Context r100, ViewGroup r101, String r102, boolean r103, Map<String, ? extends Object> r104, b r105);

    d createLiveAnnieComponent(Context r100, String r101, e r102);

    l createLiveHybridComponent(Context r100, String r101, Map<String, ? extends Object> r102, ViewGroup r103, k r104, boolean r105);

    String getBid();

    h getBridgeProvider();

    @Deprecated(message = "replace with getBid")
    Object getCoreProvider();

    void injectExternalBridges(Object r100);

    void openSchema(Context r100, String r101, Bundle r102);

    void openWithRifle(Context r100, String r101, Bundle r102);

    void showBulletPanel(Context r100, String r101, JSONObject r102, int r103, int r104, boolean r105, int r106, String r107, boolean r108, boolean r110, JSONObject r111, JSONObject r112, boolean r113, boolean r114, String r115, Function1<? super String, Unit> r116, Function1<? super String, Unit> r117);
}
