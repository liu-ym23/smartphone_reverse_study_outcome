package af7;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilderAction;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.showActionSheet")
public final class m extends d {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public m() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        d.InterfaceC0063d r113 = (d.InterfaceC0063d) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L5;
    L18:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        if ((r100 instanceof FragmentActivity) == false) goto L18;
        String r101 = r113.getTitle();
        String r102 = r113.getSubtitle();
        ArrayList r103 = new ArrayList();
        Iterator<T> r114 = r113.getActions().iterator();
    L9:
        if (r114.hasNext() == false) goto L11;
        d.b r104 = (d.b) r114.next();
        r103.add(new ActionSheetBuilderAction(r104.getTitle(), r104.getSubtitle(), r104.getType()));
        goto L9
    L11:
        l r115 = new l(r112);
        IHostStyleUIDepend r116 = com.bytedance.sdk.xbridge.cn.utils.g.h(r110);
        if (r116 == null) goto L14;
        Boolean r117 = r116.showActionSheet(new ActionSheetBuilder(r100, r101, r102, r103), r115);
    L16:
        if (Intrinsics.areEqual(r117, Boolean.TRUE) == true) goto L21;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Failed to show actionSheet in host", null, 4, null);
        return;
    L21:
        return;
    L14:
        r117 = null;
        goto L16
    }
}
