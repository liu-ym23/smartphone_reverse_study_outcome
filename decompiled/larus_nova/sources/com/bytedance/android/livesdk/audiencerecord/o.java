package com.bytedance.android.livesdk.audiencerecord;

import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements se1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BacktrackState f104061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f104062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<se1.a> f104063c;

    public o() {
        this.f104061a = BacktrackState.IDLE;
        this.f104063c = new ArrayList();
    }

    @Override // se1.b
    public final BacktrackState a() {
        return this.f104061a;
    }

    @Override // se1.b
    public final float c() {
        return this.f104062b;
    }

    @Override // se1.b
    public final void b(se1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ArrayList<se1.a> r101 = this.f104063c;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    @Override // se1.b
    public final void d(se1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ArrayList<se1.a> r101 = this.f104063c;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public final void e(float r100) {
        this.f104062b = r100;
        ArrayList<se1.a> r101 = this.f104063c;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((se1.a) r102.next()).G0(r100);
        goto L6
    L10:
        return;
    }

    public final void f(BacktrackState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f104061a = r100;
        ArrayList<se1.a> r101 = this.f104063c;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ((se1.a) r102.next()).UL(r100);
        goto L6
    L10:
        return;
    }
}
