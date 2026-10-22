package com.bytedance.android.live.liveinteract.videolink;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f78848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f78850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f78851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f78852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f78853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRoomBase f78854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IBaseUser f78855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f78856i;

    public final String a() {
        String r100 = o.a(this.f78855h);
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String b() {
        IBaseUser r100 = this.f78855h;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getIdString();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("InviteAudienceParams{, user=");
        IBaseUser r101 = this.f78855h;
        if (r101 != null) goto L5;
        String r102 = "null";
    L6:
        r100.append(r102);
        r100.append(", position=");
        r100.append(this.f78856i);
        r100.append(", teamId=");
        r100.append(this.f78849b);
        r100.append(", fromList=");
        r100.append(this.f78850c);
        r100.append(", messageBoardItemId=");
        r100.append(this.f78851d);
        r100.append(", inviteSource=");
        r100.append(this.f78852e);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = r101.getIdString();
        goto L6
    }

    public a(IRoomBase r100, IBaseUser r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "user");
        this.f78854g = r100;
        this.f78855h = r101;
        this.f78856i = r102;
        this.f78853f = true;
    }
}
