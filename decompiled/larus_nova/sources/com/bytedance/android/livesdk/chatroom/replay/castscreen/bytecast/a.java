package com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast;

import android.view.KeyEvent;
import android.view.Window;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends pic.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f108258c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super KeyEvent, Unit> f108259b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast.a$a, reason: collision with other inner class name */
    public static final class C1642a {
    }

    static {
    }

    public a() {
        throw null;
    }

    @Override // pic.f, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100 == null) goto L7;
        Function1<? super KeyEvent, Unit> r101 = this.f108259b;
        if (r101 == null) goto L7;
        Unit r102 = r101.invoke(r100);
    L7:
        return super.dispatchKeyEvent(r100);
    }

    public a(Window.Callback r100, Function1 r101) {
        super(r100);
        this.f108259b = r101;
    }
}
