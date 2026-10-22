package com.obric.oui.avatar;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;

/* JADX INFO: compiled from: OAvatarQueueViewV2WithClip.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OAvatar.a f33996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f33997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<Bitmap> f33998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33999d;

    public a() {
        this(null, null, null, 0, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f33996a == r6.f33996a) goto L12;
        return false;
    L12:
        if (this.f33997b == r6.f33997b) goto L15;
        return false;
    L15:
        if (o.a(this.f33998c, r6.f33998c) == true) goto L18;
        return false;
    L18:
        if (this.f33999d == r6.f33999d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f33996a.hashCode() * 31) + this.f33997b.hashCode()) * 31) + this.f33998c.hashCode()) * 31) + Integer.hashCode(this.f33999d);
    }

    public String toString() {
        return "OAvatarInParam(avatarSize=" + this.f33996a + ", shape=" + this.f33997b + ", avatarBitmapQueue=" + this.f33998c + ", overLapSizeDp=" + this.f33999d + ')';
    }

    public a(OAvatar.a r2, b r3, ArrayList<Bitmap> r4, int r5) {
        o.e(r2, "avatarSize");
        o.e(r3, "shape");
        o.e(r4, "avatarBitmapQueue");
        this.f33996a = r2;
        this.f33997b = r3;
        this.f33998c = r4;
        this.f33999d = r5;
    }

    public /* synthetic */ a(OAvatar.a r1, b r2, ArrayList r3, int r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = OAvatar.a.f33984a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = b.f34000a;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = new ArrayList();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = 3;
    L14:
        this(r1, r2, r3, r4);
    }

    public final OAvatar.a a() {
        return this.f33996a;
    }

    public final b b() {
        return this.f33997b;
    }

    public final ArrayList<Bitmap> c() {
        return this.f33998c;
    }

    public final int d() {
        return this.f33999d;
    }
}
