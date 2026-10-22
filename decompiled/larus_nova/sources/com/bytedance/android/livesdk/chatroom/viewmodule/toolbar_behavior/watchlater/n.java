package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f117483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f117484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<IWatchLaterData, Unit> f117485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f117486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f117487e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L16;
        n r101 = (n) r100;
        if (this.f117483a == r101.f117483a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f117484b, r101.f117484b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f117485c, r101.f117485c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f117486d, r101.f117486d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f117487e, r101.f117487e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f117483a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f117484b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        Function1<IWatchLaterData, Unit> r106 = this.f117485c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        CompositeDisposable r109 = this.f117486d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f117487e;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "WatchLaterRequestParams(roomId=" + this.f117483a + ", reqFrom=" + this.f117484b + ", onSuccess=" + this.f117485c + ", cd=" + this.f117486d + ", requestTag=" + this.f117487e + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(long r100, String r101, Function1<? super IWatchLaterData, Unit> r102, CompositeDisposable r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "reqFrom");
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "cd");
        Intrinsics.checkNotNullParameter(r104, "requestTag");
        this.f117483a = r100;
        this.f117484b = r101;
        this.f117485c = r102;
        this.f117486d = r103;
        this.f117487e = r104;
    }
}
