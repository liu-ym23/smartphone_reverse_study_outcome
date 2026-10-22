package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f117980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Animator f117981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Animator> f117982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f117983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f117984e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f117985a;

        public final void a() {
            e r100 = this.f117985a;
            r100.f117981b.cancel();
            r100.f117981b.removeAllListeners();
            if (r100.f117983d == null) goto L5;
        L7:
            r100.f117981b.addListener(new g(r100));
        L8:
            Animator r101 = r100.f117981b;
            if ((r101 instanceof AnimatorSet) == true) goto L11;
            r101 = null;
        L11:
            AnimatorSet r102 = (AnimatorSet) r101;
            if (r102 == null) goto L14;
            r102.playSequentially(r100.f117982c);
        L14:
            r100.f117981b.start();
            return;
        L5:
            if (r100.f117984e != null) goto L7;
            goto L7
        }

        public b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f117985a = r100;
        }
    }

    static {
    }

    public e() {
        this.f117980a = -1;
        this.f117981b = new AnimatorSet();
        this.f117982c = new ArrayList();
    }

    public final void a(Function1<? super com.bytedance.android.livesdk.chatroom.vs_base.base.view.b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        com.bytedance.android.livesdk.chatroom.vs_base.base.view.b r101 = new com.bytedance.android.livesdk.chatroom.vs_base.base.view.b();
        r100.invoke(r101);
        Animator r102 = r101.f117967a;
        if (r101.f117971e == null) goto L5;
    L7:
        r102.addListener(new com.bytedance.android.livesdk.chatroom.vs_base.base.view.a(r101));
    L8:
        r102.setDuration(r101.f117970d);
        r102.setInterpolator(r101.f117973g);
        r102.setStartDelay(0);
        if ((r102 instanceof AnimatorSet) == true) goto L11;
        Animator r103 = null;
    L12:
        AnimatorSet r104 = (AnimatorSet) r103;
        if (r104 == null) goto L15;
        r104.playTogether(r101.f117968b);
    L15:
        long r105 = this.f117980a;
        if (r105 < 0) goto L18;
        r102.setDuration(r105);
    L18:
        this.f117982c.add(r102);
        return;
    L11:
        r103 = r102;
        goto L12
    L5:
        if (r101.f117972f != null) goto L7;
        goto L7
    }
}
