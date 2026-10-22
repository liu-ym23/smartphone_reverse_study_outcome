package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.XBridge3MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f40190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<MethodFinder> f40191b = null;

    public s() {
    }

    static {
        f40190a = AnnieConfigSettingKeys.LIVE_XBRIDGE_JSB_SUPPORT.a();
        ArrayList r100 = new ArrayList();
        r100.add(new XBridge3MethodFinder());
        r100.add(new com.bytedance.ies.bullet.base.bridge.p(new m16.b()));
        f40191b = r100;
    }

    public static Map a() {
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<T> r101 = f40190a.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        String r102 = (String) r101.next();
        Iterator r103 = ((ArrayList) f40191b).iterator();
        IDLXBridgeMethod r104 = null;
    L7:
        if (r103.hasNext() == false) goto L10;
        r104 = ((MethodFinder) r103.next()).d("", r102);
        if (r104 == null) goto L7;
    L10:
        if (r104 == null) goto L4;
        r100.put(r102, new q(r104));
        goto L4
    L12:
        return r100;
    }
}
