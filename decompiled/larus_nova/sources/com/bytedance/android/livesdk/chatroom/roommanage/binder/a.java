package com.bytedance.android.livesdk.chatroom.roommanage.binder;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.chatroom.roommanage.permission.LinkApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import mx.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends l {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f111276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Room f111277q;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.roommanage.binder.a$a, reason: collision with other inner class name */
    public static final class C1666a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f111278a;

        public C1666a(boolean r100) {
            this.f111278a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
            com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.c.f158313v1;
            Boolean r103 = Boolean.valueOf(this.f111278a);
            r102.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        }
    }

    public a(Room r100) {
        super("管理员连线嘉宾有操作权限", "管理员可邀请连线嘉宾上麦、静音等", com.bytedance.android.livesdk.sharedpref.c.f158313v1.getValue().booleanValue(), false, false, null, 120);
        this.f111277q = r100;
        this.f111276p = 24;
    }

    @Override // mx.l
    public final void c(SwitchSettingViewHolder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f516148l = r101;
        Room r102 = this.f111277q;
        if (r102 == null) goto L17;
        long r103 = r102.f162599id;
        Disposable r104 = this.f516149m;
        if (r104 == null) goto L7;
        r104.dispose();
    L7:
        HashMap r105 = new HashMap();
        r105.put("scene", 4);
        JSONArray r106 = new JSONArray();
        JSONObject r107 = new JSONObject();
        r107.put("key", this.f111276p);
        if (r101 == false) goto L10;
        int r108 = 1;
    L11:
        r107.put("value", r108);
        r106.put(r107);
        r105.put("incremental_update", r106);
        this.f516149m = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(r103, r105).compose(RxUtil.rxSchedulerHelper()).subscribe(new C1666a(r101));
        if (r101 == false) goto L14;
        String r109 = "open";
    L15:
        LiveRoomManageAppLogger.f(r109);
        return;
    L14:
        r109 = "close";
        goto L15
    L10:
        r108 = 2;
        goto L11
    }
}
