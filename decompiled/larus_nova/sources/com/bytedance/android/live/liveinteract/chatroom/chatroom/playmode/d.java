package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f72181a = 0;

    static {
    }

    public static c a(IncompatibleTag r100, xh0.h r101, ArrayList r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "info");
        if (r102 != null) goto L5;
        return null;
    L5:
        HashMap r103 = new HashMap();
        Iterator r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L12;
        xh0.f r105 = (xh0.f) r104.next();
        if (r105.f563844a != r100) goto L7;
        r103.put(Integer.valueOf(r105.f563845b), r105.f563846c);
        goto L7
    L12:
        if (r103.size() != 0) goto L15;
        return null;
    L15:
        return new c(r100, r101, r103);
    }
}
