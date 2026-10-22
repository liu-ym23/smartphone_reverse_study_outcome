package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l {
    public static final ArrayList<String> a(ArrayList<ILinkPlayerInfoBridge> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toUserIdList");
        ArrayList<String> r101 = new ArrayList();
        Iterator<ILinkPlayerInfoBridge> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        IBaseUser r103 = r102.next().getUser();
        if (r103 == null) goto L4;
        String r104 = r103.getIdString();
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L10:
        return r101;
    }
}
