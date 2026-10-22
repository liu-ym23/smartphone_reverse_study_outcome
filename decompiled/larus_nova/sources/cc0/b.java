package cc0;

import com.bytedance.android.live.ktv.common.model.bean.h;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface b {
    void onLocalTuningEffectsFailed();

    void onLocalTuningEffectsSuccess(List<h> r100);

    void onSyncTuningEffectsFailed();

    void onSyncTuningEffectsSuccess(List<h> r100);
}
