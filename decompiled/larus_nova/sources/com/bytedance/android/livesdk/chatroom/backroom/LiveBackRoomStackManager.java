package com.bytedance.android.livesdk.chatroom.backroom;

import android.app.Activity;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStack;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import xf1.a;
import xf1.b;
import xf1.d;
import xf1.e;
import xf1.f;
import yf1.c;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveBackRoomStackManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f105110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<c> f105111b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<a> f105112c = null;

    public static Map c() {
        return (Map) f105110a.getValue();
    }

    static {
        f105110a = LazyKt.lazy(LiveBackRoomStackManager$mBackRoomStacks$2.INSTANCE);
        ArrayList<c> r100 = new ArrayList();
        f105111b = r100;
        ArrayList<a> r101 = new ArrayList();
        f105112c = r101;
        d(r101, new f());
        d(r101, new xf1.c());
        d(r101, new d());
        d(r101, new e());
        d(r101, new b());
        d(r100, new yf1.a());
        d(r100, new yf1.e());
        d(r100, new yf1.d());
        d(r100, new yf1.f());
        d(r100, new yf1.b());
    }

    public static IBackRoomStack a(int r100) {
        IBackRoomStack r101 = (IBackRoomStack) c().get(Integer.valueOf(r100));
        if (r101 != null) goto L6;
        r101 = new LiveBackRoomStack(f105112c, f105111b);
    L6:
        if (((IBackRoomStack) c().get(Integer.valueOf(r100))) != null) goto L8;
        IBackRoomStack r102 = (IBackRoomStack) c().put(Integer.valueOf(r100), r101);
    L8:
        return r101;
    }

    public static IBackRoomStack b(Activity r100) {
        if (r100 == null) goto L4;
        int r101 = r100.hashCode();
    L6:
        return a(r101);
    L4:
        r101 = 0;
        goto L6
    }

    public static void d(ArrayList r100, Object r101) {
        if (r100.contains(r101) == true) goto L6;
        r100.add(r101);
        return;
    }
}
