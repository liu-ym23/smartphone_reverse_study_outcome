package a77;

import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IMethodObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f2031a;

    @Override // com.bytedance.common.process.cross.IMethodObserver
    public final String getMethodName() {
        return "active_source_method";
    }

    public a() {
    }

    @Override // com.bytedance.common.process.cross.IMethodObserver
    public final String onMethodCall(ProcessEnum r100, List r101) {
        if (r101 != null) goto L4;
        return null;
    L4:
        if (r101.size() <= 0) goto L15;
        String r102 = (String) ListProtector.get(r101, 0);
        if (TextUtils.equals("dau", r102) == false) goto L10;
        return String.valueOf(PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().curIsDau());
    L10:
        if (TextUtils.equals("transmit", r102) == true) goto L12;
        return null;
    L12:
        return String.valueOf(PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().curIsTransmit());
    L15:
        return null;
    }
}
