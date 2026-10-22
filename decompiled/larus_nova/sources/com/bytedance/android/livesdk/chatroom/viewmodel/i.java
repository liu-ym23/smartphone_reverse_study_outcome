package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f114792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f114793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Integer> f114794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f114795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f114796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ClientUIInfo f114797f;

    public final String toString() {
        return "SwitchSceneEvent(scene=" + this.f114792a + ", uiLayout=" + this.f114793b + ", playModes=" + this.f114794c + ", isFromBroadcast=" + this.f114795d + ')';
    }

    public ClientUIInfo a() {
        return this.f114797f;
    }

    public void b(ClientUIInfo r100) {
        this.f114797f = r100;
    }

    public i(int r100, int r101, List<Integer> r102, boolean r103, boolean r104, ClientUIInfo r105) {
        this.f114792a = r100;
        this.f114793b = r101;
        this.f114794c = r102;
        this.f114795d = r103;
        this.f114796e = r104;
        this.f114797f = r105;
    }

    public /* synthetic */ i(int r110, int r111, List r112, boolean r113, boolean r114, ClientUIInfo r115, int r116) {
        if ((r116 & 2) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r116 & 4) == 0) goto L9;
        List r101 = CollectionsKt.emptyList();
    L11:
        if ((r116 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r116 & 16) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r116 & 32) == 0) goto L21;
        ClientUIInfo r104 = null;
    L22:
        this(r110, r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = r115;
        goto L22
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
