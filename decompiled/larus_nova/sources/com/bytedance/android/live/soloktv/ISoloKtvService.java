package com.bytedance.android.live.soloktv;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ServiceLookup("com.bytedance.android.live.soloktv.SoloKtvService")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002JA\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0004H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/soloktv/ISoloKtvService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/soloktv/IPlatformSoloKtvService;", "enterSoloKtvMainActivity", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "source", "", "songId", "", "schemaParam", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "isInSoloKtvPage", "", "onGuestLinkPermit", "soloktv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ServiceDummyLookup("com.bytedance.android.live.soloktv.SoloKtvServiceDummy")
public interface ISoloKtvService extends IService, IPlatformSoloKtvService {
    void enterSoloKtvMainActivity(Context r100, String r101, Long r102, Map<String, String> r103);

    @Override // com.bytedance.android.live.soloktv.IPlatformSoloKtvService
    boolean isInSoloKtvPage();

    @Override // com.bytedance.android.live.soloktv.IPlatformSoloKtvService
    void onGuestLinkPermit();
}
