package com.bytedance.android.live.soloktv;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/soloktv/SoloKtvServiceDummy;", "Lcom/bytedance/android/live/soloktv/ISoloKtvService;", "()V", "enterSoloKtvMainActivity", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "source", "", "songId", "", "schemaParam", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "isInSoloKtvPage", "", "onGuestLinkPermit", "soloktv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvServiceDummy implements ISoloKtvService {
    public SoloKtvServiceDummy() {
    }

    @Override // com.bytedance.android.live.soloktv.ISoloKtvService
    public void enterSoloKtvMainActivity(Context r100, String r101, Long r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.live.soloktv.ISoloKtvService, com.bytedance.android.live.soloktv.IPlatformSoloKtvService
    public boolean isInSoloKtvPage() {
        return false;
    }

    @Override // com.bytedance.android.live.soloktv.ISoloKtvService, com.bytedance.android.live.soloktv.IPlatformSoloKtvService
    public void onGuestLinkPermit() {
    }
}
