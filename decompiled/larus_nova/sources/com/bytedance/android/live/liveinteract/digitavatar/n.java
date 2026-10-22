package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.ec.slice.SliceInitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f72675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AvatarGender f72676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f72677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f72678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f72679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f72680f;

    public n() {
        this(false, null, null, 63);
    }

    public final boolean b() {
        String r100 = this.f72678d;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        if ((!Intrinsics.areEqual(SliceInitService.DEFAULT_SWITCH, this.f72678d)) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final String toString() {
        return "defaultAvatar:" + this.f72675a + ", gender=" + this.f72676b + ", audited=" + this.f72679e + " auditOk=" + this.f72677c + ",avatarData=" + this.f72678d + ", auditId=" + this.f72680f;
    }

    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        this.f72675a = r100.f72675a;
        this.f72677c = r100.f72677c;
        this.f72678d = r100.f72678d;
        this.f72679e = r100.f72679e;
        this.f72676b = r100.f72676b;
        this.f72680f = r100.f72680f;
    }

    public n(boolean r100, AvatarGender r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = AvatarGender.Male;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = null;
    L11:
        Intrinsics.checkNotNullParameter(r101, "gender");
        this.f72675a = r100;
        this.f72676b = r101;
        this.f72677c = false;
        this.f72678d = r102;
        this.f72679e = false;
        this.f72680f = 0;
    }
}
