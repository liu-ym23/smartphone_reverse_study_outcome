package ca4;

import com.bytedance.bdp.bdpbase.core.IBdpApp;
import com.bytedance.bdp.bdpbase.service.BdpServiceImplInfo;
import com.bytedance.bdp.bdpbase.service.BdpServiceInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    List<Class<? extends IBdpApp>> getBdpApps();

    Map<String, BdpServiceImplInfo> getServiceClassMap();

    List<BdpServiceInfo> getServiceList();
}
