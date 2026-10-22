package com.bytedance.android.live.revenuelink.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revenuelink.withroom.LinkStoreService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.withroom.a f91798a;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.connect.a$a, reason: collision with other inner class name */
    public static final class C1425a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final LiveData<ey.f> connectState() {
        com.bytedance.android.live.revenuelink.withroom.a r100 = this.f91798a;
        if (r100 == null) goto L7;
        f r101 = r100.Z0();
        if (r101 == null) goto L7;
        return r101.connectState();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final int s1() {
        com.bytedance.android.live.revenuelink.withroom.a r100 = this.f91798a;
        if (r100 == null) goto L11;
        f r101 = r100.Z0();
        if (r101 == null) goto L11;
        LiveData<ey.f> r102 = r101.connectState();
        if (r102 == null) goto L11;
        ey.f r103 = r102.getValue();
        if (r103 == null) goto L11;
        return r103.f474774d;
    L11:
        return 0;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final long getChannelId() {
        LiveData<ey.f> r100 = connectState();
        if (r100 == null) goto L7;
        ey.f r101 = r100.getValue();
        if (r101 == null) goto L7;
        return r101.f474771a;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final String getLinkMicId() {
        LiveData<ey.f> r100 = connectState();
        if (r100 == null) goto L8;
        ey.f r101 = r100.getValue();
        if (r101 == null) goto L8;
        String r102 = r101.f474775e;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean t1() {
        LiveData<ey.f> r100 = connectState();
        if (r100 == null) goto L9;
        ey.f r101 = r100.getValue();
        if (r101 == null) goto L9;
        if (r101.f474774d != 4) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean u1() {
        LiveData<ey.f> r100 = connectState();
        if (r100 == null) goto L10;
        ey.f r101 = r100.getValue();
        if (r101 == null) goto L10;
        if (r101.f474774d != 0) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean v1() {
        LiveData<ey.f> r100 = connectState();
        if (r100 == null) goto L21;
        ey.f r101 = r100.getValue();
        if (r101 == null) goto L22;
        Intrinsics.checkNotNullParameter(r101, "$this$isClassicDouble");
        int r102 = r101.f474773c;
        if (r102 == 2) goto L11;
        if (r102 == 1) goto L11;
        boolean r103 = false;
    L12:
        if (r103 != true) goto L23;
        LiveData<ey.f> r104 = connectState();
        if (r104 == null) goto L19;
        ey.f r105 = r104.getValue();
        if (r105 == null) goto L19;
        if (r105.f474774d != 0) goto L19;
        return false;
    L19:
        return true;
    L23:
        return false;
    L11:
        r103 = true;
        goto L12
    L22:
        return false;
    L21:
        return false;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.g
    public final boolean w1() {
        LiveData<ey.f> r100 = connectState();
        if (r100 == null) goto L22;
        ey.f r101 = r100.getValue();
        if (r101 == null) goto L23;
        Intrinsics.checkNotNullParameter(r101, "$this$isClassicMulti");
        int r102 = r101.f474773c;
        if (r102 != 0) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 != true) goto L24;
        LiveData<ey.f> r104 = connectState();
        if (r104 == null) goto L20;
        ey.f r105 = r104.getValue();
        if (r105 == null) goto L20;
        if (r105.f474774d != 0) goto L20;
        return false;
    L20:
        return true;
    L24:
        return false;
    L9:
        if (r102 == 3) goto L12;
        r103 = false;
        goto L13
    L23:
        return false;
    L22:
        return false;
    }

    public a(LinkStoreService r100) {
        this.f91798a = r100;
    }
}
