package j2;

import com.bytedance.apm.npth.NpthUtil;
import com.bytedance.apm6.memory.IMapsCollectService;

/* JADX INFO: loaded from: classes.dex */
public class b implements IMapsCollectService {
    public b() {
    }

    @Override // com.bytedance.apm6.memory.IMapsCollectService
    public void start() {
        NpthUtil.c();
    }

    @Override // com.bytedance.apm6.memory.IMapsCollectService
    public void stop() {
    }
}
