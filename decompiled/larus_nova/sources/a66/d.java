package a66;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.event.AppEvent;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import com.bytedance.ies.xbridge.utils.f;
import com.bytedance.ies.xbridge.utils.g;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "x.unsubscribeEvent")
public final class d extends z56.c implements h {
    private final Context getContext() {
        return (Context) g(Context.class);
    }

    public d() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r110, v56.a r111, XBridgePlatformType r112) {
        z56.c.b r113 = (z56.c.b) r110;
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        WebView r100 = null;
        boolean r101 = true;
        if (r113.getEventName().length() != 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        CompletionBlock.a.a(r111, -3, null, null, 6);     // Catch: NullPointerException -> L44
        return;
    L10:
        String r114 = r113.getEventName();
        p56.b r115 = (p56.b) g(p56.b.class);
        if (r115 == null) goto L16;
        String r116 = r115.provideContainerID();
        if (r116 == null) goto L16;
        String r103 = r116;
    L17:
        long r104 = System.currentTimeMillis();
        com.bytedance.ies.xbridge.XBridgeMethod.b r105 = (com.bytedance.ies.xbridge.XBridgeMethod.b) g(com.bytedance.ies.xbridge.XBridgeMethod.b.class);
        if (r103.length() == 0) goto L21;
        r101 = false;
    L21:
        if (r101 == false) goto L25;
        n56.a r117 = (n56.a) g(n56.a.class);
        if (r117 == null) goto L25;
        r100 = r117.f518017a;
    L25:
        WebView r118 = r100;
        AppEvent r119 = com.bytedance.ies.xbridge.event.a.a(r114);
        if (r119 == null) goto L29;
        r119.unActive();
    L29:
        if (Intrinsics.areEqual(r114, AppEvent.KeyboardStatusChange.getEventName()) == false) goto L32;
        Context r120 = getContext();
        com.bytedance.ies.xbridge.event.bridge.b.c(f.f249557a.getActivity(r120));
    L43:
        EventCenter.unregisterSubscriber(new com.bytedance.ies.xbridge.event.b(r103, r104, r105, r118), r114);
        KClass r121 = Reflection.getOrCreateKotlinClass(z56.c.InterfaceC8420c.class);
        Intrinsics.checkNotNullParameter(r121, "<this>");
        int r122 = g.f249558a;
        r111.onSuccess((XBaseResultModel) g.c(JvmClassMappingKt.getJavaClass(r121)), "");
        return;
    L32:
        if (Intrinsics.areEqual(r114, AppEvent.AppStatusChange.getEventName()) == false) goto L35;
        Context r123 = getContext();
        f.f249557a.getActivity(r123);
        r56.c r124 = r56.c.f536312g;
        goto L43
    L35:
        if (Intrinsics.areEqual(r114, AppEvent.GeckoResourceUpdated.getEventName()) == false) goto L38;
        r56.c r125 = r56.c.f536312g;
        goto L43
    L38:
        if (Intrinsics.areEqual(r114, AppEvent.OnHeadSetPlug.getEventName()) == false) goto L41;
        r56.c r126 = r56.c.f536312g;
        goto L43
    L41:
        if (Intrinsics.areEqual(r114, AppEvent.MemoryWarning.getEventName()) == false) goto L43;
        r56.c r127 = r56.c.f536312g;
    L16:
        r103 = "";
        goto L17
    L6:
        r102 = false;
    L44:
        CompletionBlock.a.a(r111, -3, null, null, 6);
    }
}
