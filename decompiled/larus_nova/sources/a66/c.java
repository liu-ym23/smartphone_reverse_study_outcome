package a66;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
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
@XBridgeMethod(name = "x.subscribeEvent")
public final class c extends z56.b implements h {
    private final Context getContext() {
        return (Context) g(Context.class);
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        p56.b r100 = (p56.b) g(p56.b.class);
        if (r100 == null) goto L6;
        String r101 = r100.provideContainerID();
        if (r101 == null) goto L6;
    L7:
        EventCenter.release(r101);
        return;
    L6:
        r101 = "";
        goto L7
    }

    public c() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r110, v56.a r111, XBridgePlatformType r112) {
        z56.b.InterfaceC8419b r113 = (z56.b.InterfaceC8419b) r110;
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        p56.b r114 = (p56.b) g(p56.b.class);
        if (r114 == null) goto L8;
        String r115 = r114.provideContainerID();
        if (r115 == null) goto L8;
        String r100 = r115;
    L9:
        String r116 = r113.getEventName();
        IDLXBridgeMethod.b r101 = (IDLXBridgeMethod.b) g(IDLXBridgeMethod.b.class);
        n56.a r102 = (n56.a) g(n56.a.class);
        Window r103 = null;
        if (r102 == null) goto L12;
        WebView r104 = r102.f518017a;
    L13:
        AppEvent r105 = com.bytedance.ies.xbridge.event.a.a(r116);
        if (r105 == null) goto L16;
        r105.active();
    L16:
        boolean r106 = true;
        if (r116.length() != 0) goto L19;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
        CompletionBlock.a.a(r111, -3, null, null, 6);
        return;
    L23:
        Number r108 = r113.getTimestamp();
        if ((r108 instanceof Number) == false) goto L27;
        long r109 = (long) v56.c.c(r113.getTimestamp());
    L30:
        if (Intrinsics.areEqual(r116, AppEvent.KeyboardStatusChange.getEventName()) == false) goto L63;
        Context r117 = getContext();
        Activity r118 = f.f249557a.getActivity(r117);
        if ((r118 instanceof FragmentActivity) == false) goto L34;
        FragmentActivity r119 = (FragmentActivity) r118;
    L35:
        if (r119 == null) goto L39;
        FragmentManager r120 = r119.getSupportFragmentManager();
        if (r120 == null) goto L39;
        Fragment r121 = r120.findFragmentByTag("BulletPopUp");
    L41:
        if ((r121 instanceof DialogFragment) == false) goto L43;
        DialogFragment r122 = (DialogFragment) r121;
    L44:
        AppEvent r123 = com.bytedance.ies.xbridge.event.a.a(r116);
        if (r123 != null) goto L47;
    L49:
        r106 = false;
    L50:
        if (r106 == false) goto L95;
        int r124 = com.bytedance.ies.xbridge.event.bridge.b.f249480a;
        if (r122 == null) goto L59;
        Dialog r125 = r122.getDialog();
        if (r125 == null) goto L59;
        Window r126 = r125.getWindow();
        if (r126 == null) goto L59;
        r103 = r126;
    L61:
        com.bytedance.ies.xbridge.event.bridge.b.b(r117, r103, new b(r118));
    L59:
        if (r118 == null) goto L61;
        r103 = r118.getWindow();
    L95:
        com.bytedance.ies.xbridge.event.b r127 = new com.bytedance.ies.xbridge.event.b(r100, r109, null, r104);
        r127.f249478e = r101;
        EventCenter.registerSubscriber(r127, r116);
        KClass r128 = Reflection.getOrCreateKotlinClass(z56.b.c.class);
        Intrinsics.checkNotNullParameter(r128, "<this>");
        int r129 = g.f249558a;
        r111.onSuccess((XBaseResultModel) g.c(JvmClassMappingKt.getJavaClass(r128)), "");
        return;
    L47:
        if (r123.isActive() != true) goto L49;
    L43:
        r122 = null;
    L39:
        r121 = null;
        goto L41
    L34:
        r119 = null;
        goto L35
    L63:
        if (Intrinsics.areEqual(r116, AppEvent.AppStatusChange.getEventName()) == false) goto L66;
        f.f249557a.getActivity(getContext());
        r56.c r130 = r56.c.f536312g;
        goto L95
    L66:
        if (Intrinsics.areEqual(r116, AppEvent.GeckoResourceUpdated.getEventName()) == false) goto L76;
        AppEvent r131 = com.bytedance.ies.xbridge.event.a.a(r116);
        if (r131 != null) goto L70;
    L72:
        r106 = false;
    L73:
        if (r106 == false) goto L95;
        r56.c r132 = r56.c.f536312g;
        goto L95
    L70:
        if (r131.isActive() != true) goto L72;
    L76:
        if (Intrinsics.areEqual(r116, AppEvent.OnHeadSetPlug.getEventName()) == false) goto L86;
        AppEvent r133 = com.bytedance.ies.xbridge.event.a.a(r116);
        if (r133 != null) goto L80;
    L82:
        r106 = false;
    L83:
        if (r106 == false) goto L95;
        r56.c r134 = r56.c.f536312g;
        goto L95
    L80:
        if (r133.isActive() != true) goto L82;
    L86:
        if (Intrinsics.areEqual(r116, AppEvent.MemoryWarning.getEventName()) == false) goto L95;
        AppEvent r135 = com.bytedance.ies.xbridge.event.a.a(r116);
        if (r135 != null) goto L90;
    L92:
        r106 = false;
    L93:
        if (r106 == false) goto L95;
        r56.c r136 = r56.c.f536312g;
        goto L95
    L90:
        if (r135.isActive() != true) goto L92;
    L27:
        if ((r108 instanceof Integer) == false) goto L96;
        r109 = r113.getTimestamp().longValue();
        goto L30
    L96:
        CompletionBlock.a.a(r111, -3, null, null, 6);
        return;
    L19:
        r107 = false;
        goto L21
    L12:
        r104 = null;
    L8:
        r100 = "";
        goto L9
    }
}
