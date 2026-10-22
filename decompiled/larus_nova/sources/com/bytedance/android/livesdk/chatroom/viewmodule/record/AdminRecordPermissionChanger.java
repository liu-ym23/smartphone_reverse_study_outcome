package com.bytedance.android.livesdk.chatroom.viewmodule.record;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import py.t;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/record/AdminRecordPermissionChanger;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminRecordPermissionChanger implements Observer<KVData>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f115344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vlc.d f115345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f115346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f115347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Boolean, Unit> f115348e;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-1741164106)) goto L12;
        return;
    L12:
        if (r102.equals("data_user_in_room") == false) goto L23;
        IUser r103 = (IUser) r101.getData();
        if (r103 == null) goto L24;
        t r104 = r103.getUserAttr();
        if (r104 != null) goto L18;
        return;
    L18:
        if (r104.isAdmin() == true) goto L26;
        ALogger.i(this.f115344a, "管理员权限被下掉了");
        Function1<Boolean, Unit> r105 = this.f115348e;
        if (r105 == null) goto L27;
        Unit r106 = r105.invoke(Boolean.FALSE);
        return;
    L27:
        return;
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.message.model.k) == false) goto L25;
        if (r100 == null) goto L24;
        com.bytedance.android.livesdk.message.model.k r101 = (com.bytedance.android.livesdk.message.model.k) r100;
        if (((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().isAdmin() == false) goto L20;
        com.bytedance.android.livesdk.message.model.k.a r102 = r101.E();
        if (r102 == null) goto L26;
        int r103 = r102.c();
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r104 = LiveRoomPermission.f105075y;
        if (r103 == r104.f105077a) goto L12;
    L13:
        List<Integer> r105 = r102.a();
        if (r105 != null) goto L16;
    L18:
        boolean r106 = false;
    L19:
        if (r106 == true) goto L20;
        return;
    L16:
        if (r105.contains(Integer.valueOf(r104.f105077a)) == true) goto L18;
    L17:
        r106 = true;
        goto L19
    L12:
        if (r102.b() == 2) goto L17;
    L26:
        return;
    L20:
        ALogger.i(this.f115344a, "录屏权限被下掉了");
        Function1<Boolean, Unit> r107 = this.f115348e;
        if (r107 == null) goto L28;
        Unit r108 = r107.invoke(Boolean.FALSE);
        return;
    L28:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.AdminPrivilegeMessage");
    }

    public AdminRecordPermissionChanger(DataCenter r100, j r101) {
        Intrinsics.checkNotNullParameter(r101, "onChange");
        this.f115347d = r100;
        this.f115348e = r101;
        this.f115344a = "AdminRecordPermissionChanger";
        this.f115346c = new CompositeDisposable();
    }
}
