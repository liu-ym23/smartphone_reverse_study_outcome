package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f81470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f81471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f81472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f81473d;

    public n(o r100, String r101, String r102, long r103) {
        this.f81470a = r100;
        this.f81471b = r101;
        this.f81472c = r102;
        this.f81473d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        this.f81470a.f81480g.remove(this.f81471b);
        Iterator<g> r100 = this.f81470a.f81478e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().L2(this.f81471b, r111);
        goto L4
    L6:
        String r101 = this.f81471b;
        String r102 = this.f81472c;
        long r103 = this.f81473d;
        long r104 = System.currentTimeMillis() - r103;
        if (this.f81470a.f81477d == false) goto L9;
        String r105 = "anchor";
    L10:
        dl0.m r106 = dl0.m.f469074a;
        Intrinsics.checkNotNullParameter(r101, "toUserId");
        Intrinsics.checkNotNullParameter(r105, "role");
        JSONObject r112 = new JSONObject();
        BaseMonitor.add(r112, com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101.toString());
        BaseMonitor.add(r112, "sec_to_user_id", String.valueOf(r102));
        BaseMonitor.add(r112, "operate_role_type", r105);
        if (r111 != null) goto L13;
        return;
    L13:
        if ((r111 instanceof ApiServerException) == false) goto L18;
        dl0.m r107 = dl0.m.f469074a;
        ApiServerException r113 = (ApiServerException) r111;
        int r108 = r113.getErrorCode();
        String r114 = r113.getErrorMsg();
        if (r114 != null) goto L17;
        r114 = "";
    L17:
        r107.getClass();
        dl0.m.z("audience_invite", r108, r114, r104, r112);
        return;
    L18:
        dl0.m r109 = dl0.m.f469074a;
        String r115 = r111.toString();
        r109.getClass();
        dl0.m.z("audience_invite", 1, r115, r104, r112);
        return;
    L9:
        r105 = "administrator";
        goto L10
    }
}
