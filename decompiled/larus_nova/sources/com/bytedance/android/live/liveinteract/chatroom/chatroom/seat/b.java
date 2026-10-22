package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import android.net.Uri;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f72213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f72214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f72215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f72216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f72217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f72218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f72219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f72220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f72221i;

    public final String toString() {
        return "GuestBattleSeatAnimEvent(userId=" + this.f72215c + ", type=" + this.f72216d + ", level=" + this.f72217e + ", uri=" + this.f72218f + ", animEnd=" + this.f72221i + ", stop=" + this.f72213a + ", forceCallback=" + this.f72214b + ')';
    }

    public final int getType() {
        return this.f72216d;
    }

    public /* synthetic */ b(String r100, int r110, Uri r111) {
        this(r100, r110, -1, r111, null, null, null);
    }

    public b(String r100, int r101, int r102, Uri r103, String r104, String r105, Function0 r106) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f72215c = r100;
        this.f72216d = r101;
        this.f72217e = r102;
        this.f72218f = r103;
        this.f72219g = r104;
        this.f72220h = r105;
        this.f72221i = r106;
    }
}
