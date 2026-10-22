package com.bytedance.android.live.liveinteract.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.common.utility.Lists;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements qd0.b {
    public f() {
    }

    public final boolean P() {
        com.bytedance.android.live.liveinteract.plantform.base.d.f75487j0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a() != null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.base.e.f75489l0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a() == null) goto L17;
        if (com.bytedance.android.live.liveinteract.plantform.base.e.a.a().H() != 0) goto L22;
        return false;
    L22:
        return true;
    L17:
        if (jc1.k.f(IPkAudienceLinkOutService.class) != null) goto L19;
        return false;
    L19:
        return ((IPkAudienceLinkOutService) jc1.k.f(IPkAudienceLinkOutService.class)).isLinkAudience();
    L5:
        if (com.bytedance.android.live.liveinteract.plantform.base.d.a.a().H() != 0) goto L21;
        return false;
    L21:
        return true;
    }

    @Override // rj0.d
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        com.bytedance.android.live.liveinteract.plantform.base.d.f75487j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r100 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r100 != null) goto L5;
        com.bytedance.android.live.liveinteract.plantform.base.e.f75489l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r101 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getLiveStream();
    L5:
        return r100.xd();
    }

    public static List<ILinkPlayerInfoBridge> O(boolean r100) {
        if (r100 == false) goto L7;
        com.bytedance.android.live.liveinteract.plantform.base.d.f75487j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r101 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r101 == null) goto L10;
        y r102 = r101.getLinkUserCenter();
    L11:
        if (r102 != null) goto L13;
    L16:
        return null;
    L13:
        if (Lists.isEmpty(r102.f76316c) == true) goto L16;
        return r102.f76316c;
    L10:
        r102 = null;
        goto L11
    L7:
        com.bytedance.android.live.liveinteract.plantform.base.c.f75485i0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.c r103 = com.bytedance.android.live.liveinteract.plantform.base.c.a.a();
        if (r103 == null) goto L10;
        r102 = r103.getLinkUserCenter();
        goto L11
    }

    public final boolean R(boolean r100, IBaseUser r101) {
        List<ILinkPlayerInfoBridge> r102 = O(r100);
        if (r101 != null) goto L5;
    L18:
        return false;
    L5:
        if (Lists.isEmpty(r102) == true) goto L18;
        Iterator<ILinkPlayerInfoBridge> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L18;
        ILinkPlayerInfoBridge r104 = r103.next();
        if (r104 == null) goto L9;
        if (r104.getUser() == null) goto L9;
        if (r104.getUser().getIdString().equals(r101.getIdString()) == false) goto L9;
        return true;
    }

    public final boolean S(boolean r100, IBaseUser r101) {
        if (R(r100, r101) == true) goto L5;
        return false;
    L5:
        if (r100 == false) goto L8;
        return true;
    L8:
        com.bytedance.android.live.liveinteract.plantform.base.d.f75487j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r102 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (r102 != null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.base.e.f75489l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r103 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r103 != null) goto L14;
        return false;
    L14:
        return r103.isEngineOn();
    L15:
        return r102.isEngineOn();
    }
}
