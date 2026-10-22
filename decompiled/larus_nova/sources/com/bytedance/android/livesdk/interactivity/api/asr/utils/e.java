package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> f132883a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.b> f132884b = null;

    public final class a implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f132885a;

        public a(Function1 r100) {
            this.f132885a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f132885a.invoke(r100);
        }
    }

    static {
        f132883a = new com.bytedance.android.livesdk.sharedpref.e("live_anchor_asr_auth_status", 0);
        f132884b = new com.bytedance.android.livesdk.sharedpref.e("live_anchor_asr_switch_status", new com.bytedance.android.livesdk.chatroom.model.b());
    }

    public static boolean b() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r100 = f132883a;
        Integer r101 = r100.getValue();
        if (r101 != null) goto L6;
    L7:
        Integer r102 = r100.getValue();
        if (r102 != null) goto L11;
    L13:
        return false;
    L11:
        if (r102.intValue() != 1) goto L13;
        return true;
    L6:
        if (r101.intValue() != 0) goto L7;
        return true;
    }

    public static m22.b a() {
        boolean r100 = false;
        if (b() == false) goto L21;
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.b> r101 = f132884b;
        if (r101.getValue().status != 1) goto L7;
        boolean r102 = true;
    L9:
        if (r101.getValue().switchWelcome != 1) goto L11;
        boolean r103 = true;
    L13:
        if (r101.getValue().switchThanks != 1) goto L15;
        boolean r104 = true;
    L17:
        if (r101.getValue().switchCongrats != 1) goto L22;
        r100 = true;
    L22:
        return new m22.b(r102, r103, r104, r100);
    L15:
        r104 = false;
        goto L17
    L11:
        r103 = false;
        goto L13
    L7:
        r102 = false;
        goto L9
    L21:
        return new m22.b(false, false, false, false);
    }

    @JvmStatic
    public static final Disposable c(boolean r100, Function1<? super m22.b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        r101.invoke(a());
        if (r100 == false) goto L6;
        return xs2.b.a().b(m22.b.class).subscribe(new a(r101));
    L6:
        return xs2.b.a().c(m22.b.class).subscribe(new a(r101));
    }
}
