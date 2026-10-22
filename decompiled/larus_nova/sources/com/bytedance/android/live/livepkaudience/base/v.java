package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.config.k9;
import com.bytedance.android.livesdk.config.z01;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;

/* JADX INFO: loaded from: classes46.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f81569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f81571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f81572d;

    public static final class a {
    }

    static {
    }

    public v() {
        z01 r100 = k9.f120582a.getValue();
        this.f81569a = r100.fatalRollbackLimit;
        this.f81571c = r100.monitorVersionRollback;
        this.f81572d = System.currentTimeMillis();
    }

    public static String a(AnchorLinkUser r100) {
        StringBuilder r101 = new StringBuilder("AnchorLinkUser{uid=");
        IBaseUser r102 = r100.getUser();
        if (r102 == null) goto L7;
        String r103 = r102.getIdString();
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(d5.c(r103));
    L8:
        r101.append(r104);
        r101.append(",linkId=");
        r101.append(r100.getLinkMicIdStr());
        r101.append(",linkType=");
        r101.append(r100.getLinkType());
        r101.append(",silence=");
        r101.append(r100.getSilenceStatus());
        r101.append(",userPos=");
        r101.append(r100.getUserPosition());
        r101.append(",mc=");
        r101.append(r100.getMcStatus());
        r101.append(",isBg=");
        r101.append(r100.isBackground());
        r101.append(", isCPos=");
        r101.append(CPositionModeUtil.isCPositionUser(r100));
        r101.append('}');
        return r101.toString();
    L7:
        r104 = null;
        goto L8
    }
}
