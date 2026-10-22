package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.user.api.a f115405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdminRecordPermissionChanger f115406b;

    public b(com.bytedance.android.live.user.api.a r100, AdminRecordPermissionChanger r101) {
        this.f115405a = r100;
        this.f115406b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        AdminRecordPermissionChanger r102 = this.f115406b;
        com.bytedance.android.live.user.api.a r103 = this.f115405a;
        r102.getClass();
        if (r103.isAdmin().getValue().booleanValue() == false) goto L10;
        Intrinsics.checkNotNullParameter(r101, "$this$getAllPermissions");
        List r104 = r101;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r105.add(((ec1.a) r106.next()).f471998a);
        goto L6
    L8:
        LiveRoomPermission.D.getClass();
        if (r105.contains(LiveRoomPermission.f105075y) == true) goto L10;
        return;
    L10:
        ALogger.i(r102.f115344a, "录屏权限被下掉了");
        Function1<Boolean, Unit> r107 = r102.f115348e;
        if (r107 == null) goto L16;
        Unit r108 = r107.invoke(Boolean.FALSE);
        return;
    }
}
