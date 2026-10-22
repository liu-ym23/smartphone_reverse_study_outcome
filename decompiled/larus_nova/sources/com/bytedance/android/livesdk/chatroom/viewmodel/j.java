package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f114798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f114799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f114800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f114801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ClientUIInfo f114802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f114803f;

    public j() {
        throw null;
    }

    public j(int r100, List<Integer> r110, int r111) {
        this(r100, r110, r111, false, null, false, 56);
    }

    public j(int r100, List<Integer> r110, int r111, boolean r112, ClientUIInfo r113) {
        this(r100, r110, r111, r112, r113, false, 32);
    }

    public final String toString() {
        return "SwitchSceneWithPlayModeEvent(scene=" + this.f114798a + ", playMode=" + this.f114799b + ", uiLayout=" + this.f114800c + ", isFromBroadcast=" + this.f114801d + ')';
    }

    public j(int r100, List r101, int r102, boolean r103, ClientUIInfo r104, boolean r105, int r106) {
        if ((r106 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r106 & 8) == 0) goto L9;
        r103 = false;
    L9:
        if ((r106 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 32) == 0) goto L14;
        r105 = false;
    L14:
        this.f114798a = r100;
        this.f114799b = r101;
        this.f114800c = r102;
        this.f114801d = r103;
        this.f114802e = r104;
        this.f114803f = r105;
    }
}
