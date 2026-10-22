package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import j40.f4;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends r22.a<BusinessConfigure> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList<BusinessConfigure> f133966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<Boolean> f133967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f133968e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.a$a, reason: collision with other inner class name */
    public static final class C2115a {
    }

    static {
    }

    @Override // r22.a
    public final Queue<BusinessConfigure> h() {
        LinkedList<BusinessConfigure> r100 = this.f133966c;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new LinkedList();
    }

    @Override // r22.a
    public final BusinessConfigure j() {
        LinkedList<BusinessConfigure> r100 = this.f133966c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.pollFirst();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void l() {
        LinkedList<BusinessConfigure> r100 = this.f133966c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.f535753b.a() == false) goto L35;
        LinkedList<BusinessConfigure> r101 = this.f133966c;
        Long r102 = null;
        if (r101 == null) goto L12;
        BusinessConfigure r103 = r101.pollFirst();
    L13:
        if (r103 == null) goto L36;
        this.f535753b.b((T) r103);
        IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r104 == null) goto L19;
        com.bytedance.android.livesdk.user.e r105 = r104.user();
        if (r105 == null) goto L19;
        String r106 = r105.n();
    L20:
        BusinessResourceConfigure r107 = r103.resourceConfig;
        if (r107 == null) goto L23;
        Long r108 = Long.valueOf(r107.resourceId);
    L24:
        if (r108 == null) goto L32;
        LruCache<String, Integer> r109 = f4.f497218u.getValue();
        StringBuilder r110 = new StringBuilder();
        if (r106 != null) goto L28;
        r106 = "";
    L28:
        r110.append(r106);
        r110.append("_");
        BusinessResourceConfigure r111 = r103.resourceConfig;
        if (r111 == null) goto L31;
        r102 = Long.valueOf(r111.resourceId);
    L31:
        r110.append(String.valueOf(r102));
        r109.put(r110.toString(), 1);
    L32:
        l();
        return;
    L23:
        r108 = null;
    L19:
        r106 = null;
        goto L20
    L36:
        return;
    L12:
        r103 = null;
        goto L13
    }

    public a(LandscapeDanmakuPresenterV2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        super(r100);
        this.f133968e = new b(this);
    }

    @Override // r22.a
    public final void e(BusinessConfigure r100) {
        BusinessConfigure r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "danmaku");
        LinkedList<BusinessConfigure> r102 = this.f133966c;
        if (r102 == null) goto L6;
        r102.addLast(r101);
        return;
    }
}
