package com.bytedance.android.livesdk;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.live.IStartRoomIntercept;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class f9 implements IStartRoomIntercept {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f123407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b9 f123408b;

    public interface a {
        boolean intercept(Map<String, String> r100);
    }

    public f9() {
        HashMap r100 = new HashMap();
        this.f123407a = r100;
        b9 r101 = new b9();
        this.f123408b = r101;
        r100.put("new_style", r101);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IStartRoomIntercept
    public final void bindContext(Context r100) {
        b9 r101 = this.f123408b;
        if (r101 == null) goto L8;
        xg1.k r102 = r101.f104238a;
        if (r102 == null) goto L9;
        r102.f563588b = r100;
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IStartRoomIntercept
    public final boolean intercept(Map<String, String> r100) {
        Map<String, a> r101 = this.f123407a;
        if (r101 != null) goto L5;
        return false;
    L5:
        Set r102 = ((HashMap) r101).keySet();
        if (CollectionUtils.isEmpty(r102) == false) goto L8;
        return false;
    L8:
        String r103 = r100.remove("intercept");
        if (StringUtils.isEmpty(r103) == false) goto L11;
    L16:
        return false;
    L11:
        if (r102.contains(r103) == false) goto L16;
        if (((HashMap) this.f123407a).get(r103) == null) goto L16;
        return ((a) ((HashMap) this.f123407a).get(r103)).intercept(r100);
    }
}
