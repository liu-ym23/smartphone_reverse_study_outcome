package j1;

import com.bytedance.apm.core.IDynamicParams;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements IDynamicParams {
    public a() {
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public Map getCommonParams() {
        return Collections.emptyMap();
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public String getSessionId() {
        return null;
    }

    @Override // com.bytedance.apm.core.IDynamicParams
    public long getUid() {
        return 0;
    }
}
