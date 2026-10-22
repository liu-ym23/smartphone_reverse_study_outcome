package com.bytedance.android.livesdk.interactivity.like.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f137726a = null;

    static {
        f137726a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Pair<Uri, Uri>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ArrayList<com.bytedance.android.livesdk.gecko.offline.d> r101 = com.bytedance.android.livesdk.gecko.offline.f.f125830a;
        String r102 = j.f137743m;
        File r103 = com.bytedance.android.livesdk.gecko.offline.f.a(r102);
        String r104 = j.f137742l;
        File r105 = com.bytedance.android.livesdk.gecko.offline.f.a(r104);
        if (r103 == null) goto L6;
        if (r105 == null) goto L6;
        r100.onNext(new Pair(Uri.fromFile(r103), Uri.fromFile(r105)));
    L7:
        r100.onComplete();
        return;
    L6:
        r100.onNext(new Pair(UriProtector.parse(r102), UriProtector.parse(r104)));
        goto L7
    }
}
