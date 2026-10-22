package com.bytedance.android.livesdk.chatroom.ui;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f112737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f112738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f112739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f112740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f112741e;

    public static final class a {
    }

    public interface b {
        boolean a(long r100, long r101, int r102);

        String getTag();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f112742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f112743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f112744c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f112742a, r101.f112742a) == true) goto L8;
            return false;
        L8:
            if (this.f112743b == r101.f112743b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f112744c, r101.f112744c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f112742a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((r102 * 31) + this.f112743b) * 31;
            b r104 = this.f112744c;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ListenerInfo(tag=" + this.f112742a + ", successInvokeTimes=" + this.f112743b + ", listener=" + this.f112744c + ")";
        }

        public c(String r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            this.f112742a = r100;
            this.f112743b = 0;
            this.f112744c = r101;
        }
    }

    static {
    }

    public final void b() {
        Disposable r100 = this.f112737a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f112737a = null;
        ((ArrayList) this.f112738b).clear();
        this.f112739c = true;
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f112739c == false) goto L5;
        return;
    L5:
        Iterator r101 = ((ArrayList) this.f112738b).iterator();
    L6:
        c r102 = null;
        if (r101.hasNext() == false) goto L11;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((c) r103).f112742a, r100.getTag()) == false) goto L6;
    L12:
        c r104 = (c) r103;
        if (r104 != null) goto L15;
        r102 = new c(r100.getTag(), r100);
    L16:
        if (r102 == null) goto L19;
        ((ArrayList) this.f112738b).add(r102);
    L19:
        if (this.f112739c == false) goto L21;
        return;
    L21:
        if (this.f112737a != null) goto L29;
        com.bytedance.android.live.core.utils.rxutils.j.a r105 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        com.bytedance.android.live.core.utils.rxutils.j.a(0, this.f112741e, TimeUnit.MILLISECONDS).take(this.f112740d).observeOn(AndroidSchedulers.mainThread()).subscribe(new e9(this));
        return;
    L29:
        return;
    L15:
        r104.f112744c = r100;
        goto L16
    L11:
        r103 = null;
        goto L12
    }

    public final void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f112739c == false) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f112738b.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((c) r102).f112742a, r100.getTag()) == false) goto L7;
    L12:
        c r103 = (c) r102;
        if (r103 == null) goto L19;
        r103.f112744c = null;
        return;
    L19:
        return;
    L11:
        r102 = null;
        goto L12
    }

    public d9(long r100, long r101) {
        this.f112740d = r100;
        this.f112741e = r101;
        this.f112738b = new ArrayList();
    }
}
