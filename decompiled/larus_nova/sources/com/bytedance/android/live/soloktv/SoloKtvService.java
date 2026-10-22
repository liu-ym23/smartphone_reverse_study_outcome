package com.bytedance.android.live.soloktv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.soloktv.util.SoloKtvSettingHelper;
import com.bytedance.android.live.soloktv.util.f;
import com.bytedance.android.live.soloktv.util.j;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/soloktv/SoloKtvService;", "Lcom/bytedance/android/live/soloktv/ISoloKtvService;", "()V", "enterSoloKtvMainActivity", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "source", "", "songId", "", "schemaParam", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "isInSoloKtvPage", "", "onGuestLinkPermit", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class SoloKtvService implements ISoloKtvService {
    @Override // com.bytedance.android.live.soloktv.ISoloKtvService, com.bytedance.android.live.soloktv.IPlatformSoloKtvService
    public boolean isInSoloKtvPage() {
        SoloKtvContext.Companion.getClass();
        n<Integer> r100 = SoloKtvContext.a.a().isInSoloKtvPage();
        if (r100 == null) goto L7;
        Integer r101 = r100.getValue();
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L8:
        if (r102 <= 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.soloktv.ISoloKtvService, com.bytedance.android.live.soloktv.IPlatformSoloKtvService
    public void onGuestLinkPermit() {
        SoloKtvContext.Companion.getClass();
        n<Integer> r100 = SoloKtvContext.a.a().isInSoloKtvPage();
        if (r100 == null) goto L7;
        Integer r101 = r100.getValue();
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L9:
        if (((Boolean) SoloKtvSettingHelper.f101590c.getValue()).booleanValue() == false) goto L14;
        if (r102 <= 0) goto L16;
        j r103 = j.f101607a;
        Activity r104 = com.bytedance.android.live.core.utils.a.d();
        r103.getClass();
        if (j.g(r104) == true) goto L16;
        f2.b(R.string.ttlive_solo_ktv_link_permist_toast, 0);
    L16:
        xs2.b.a().post(f.f101603a);
        return;
    L14:
        if (r102 <= 0) goto L16;
        f2.b(R.string.ttlive_solo_ktv_link_permist_toast, 0);
    L7:
        r102 = 0;
        goto L9
    }

    public SoloKtvService() {
        k.l(ISoloKtvService.class, this);
    }

    @Override // com.bytedance.android.live.soloktv.ISoloKtvService
    public void enterSoloKtvMainActivity(Context r100, String r101, Long r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r104 = new Intent(r100, SoloKtvActivity.class);
        Bundle r105 = new Bundle();
        if (r101 == null) goto L5;
        r105.putString("source", r101);
    L5:
        if (r102 == null) goto L7;
        r105.putLong("song_id", r102.longValue());
    L7:
        if (r103 == null) goto L13;
        Iterator<Map.Entry<String, String>> r106 = r103.entrySet().iterator();
    L10:
        if (r106.hasNext() == false) goto L13;
        Map.Entry<String, String> r107 = r106.next();
        r105.putString(r107.getKey(), r107.getValue());
    L13:
        if ((r100 instanceof Activity) == true) goto L15;
        r104.setFlags(268435456);
    L15:
        r104.putExtras(r105);
        r100.startActivity(r104);
    }
}
