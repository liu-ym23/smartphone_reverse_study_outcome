package com.bytedance.android.live.liveinteract.chatroom.chatroom.list;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<Object> f72160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ILinkPlayerInfoBridge> f72161b;

    /* JADX WARN: Multi-variable type inference failed */
    public e(LinkedList<Object> r100, List<? extends ILinkPlayerInfoBridge> r101) {
        Intrinsics.checkNotNullParameter(r100, "infoList");
        Intrinsics.checkNotNullParameter(r101, "aiGuestList");
        this.f72160a = r100;
        this.f72161b = r101;
    }
}
