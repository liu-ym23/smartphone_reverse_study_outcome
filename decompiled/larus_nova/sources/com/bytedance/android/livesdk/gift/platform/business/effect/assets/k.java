package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f129104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f129105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f129106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f129107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f129108e;

        public a() {
            this(0, null, 0, 0, false, 31);
        }

        public a(long r100, String r101, int r102, int r103, boolean r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r105 & 4) == 0) goto L12;
            r102 = 0;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r103 = 0;
        L15:
            if ((r105 & 16) == 0) goto L17;
            r104 = false;
        L17:
            Intrinsics.checkNotNullParameter(r101, "path");
            this.f129104a = r100;
            this.f129105b = r101;
            this.f129106c = r102;
            this.f129107d = r103;
            this.f129108e = r104;
        }
    }

    public interface b {
        void a(List<a> r100);

        void b(boolean r100);

        void onFailed(Throwable r100);

        void onResult(List<a> r100);
    }

    public static void a(IAssetsManager r100, List r101, b r110, int r111, AssetDownloadPriority r112) {
        Intrinsics.checkNotNullParameter(r100, "assetsManager");
        Intrinsics.checkNotNullParameter(r101, "assetsIds");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r112, "priority");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(Observable.create(new l(r100, ((Number) r103.next()).longValue(), r111, r112)));
        goto L4
    L6:
        Observable.merge(r102).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).toList().subscribe(new m(r110), new n(r110));
    }
}
