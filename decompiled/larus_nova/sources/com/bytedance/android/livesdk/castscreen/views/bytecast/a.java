package com.bytedance.android.livesdk.castscreen.views.bytecast;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.Window;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends pic.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f104879c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super KeyEvent, Unit> f104880b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.castscreen.views.bytecast.a$a, reason: collision with other inner class name */
    public static final class C1579a {
        public static void b(Context r100) {
            if (r100 != null) goto L5;
            return;
        L5:
            if ((r100 instanceof Activity) == true) goto L7;
            r100 = null;
        L7:
            Activity r101 = (Activity) r100;
            if (r101 == null) goto L21;
            Window r102 = r101.getWindow();
            if (r102 != null) goto L13;
            return;
        L13:
            if ((r102.getCallback() instanceof a) == false) goto L22;
            Window.Callback r103 = r102.getCallback();
            if ((r103 instanceof a) == true) goto L17;
            r103 = null;
        L17:
            a r104 = (a) r103;
            if (r104 == null) goto L23;
            r104.f104880b = null;
            return;
        L23:
            return;
        L22:
            return;
        }

        public static void a(Context r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r101, "block");
            if (r100 != null) goto L5;
            return;
        L5:
            Window.Callback r102 = null;
            if ((r100 instanceof Activity) == true) goto L8;
            r100 = null;
        L8:
            Activity r103 = (Activity) r100;
            if (r103 == null) goto L27;
            Window r104 = r103.getWindow();
            if (r104 != null) goto L14;
            return;
        L14:
            if (r104.getCallback() != null) goto L17;
            return;
        L17:
            if ((r104.getCallback() instanceof a) == false) goto L25;
            Window.Callback r105 = r104.getCallback();
            if ((r105 instanceof a) == false) goto L22;
            r102 = r105;
        L22:
            a r106 = (a) r102;
            if (r106 == null) goto L28;
            r106.f104880b = r101;
            return;
        L28:
            return;
        L25:
            r104.setCallback(new a(r104.getCallback(), r101));
            return;
        }
    }

    static {
    }

    public a() {
        throw null;
    }

    @Override // pic.f, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100 == null) goto L7;
        Function1<? super KeyEvent, Unit> r101 = this.f104880b;
        if (r101 == null) goto L7;
        Unit r102 = r101.invoke(r100);
    L7:
        return super.dispatchKeyEvent(r100);
    }

    public a(Window.Callback r100, Function1 r101) {
        super(r100);
        this.f104880b = r101;
    }
}
