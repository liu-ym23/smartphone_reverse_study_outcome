package com.bytedance.android.live.impl;

import com.bytedance.android.live.feature.api.IFeatureService;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class AotuCharacterHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f69021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile List<String> f69022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Function1<? super String, Unit> f69023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile a f69024d;

    public static final class a implements z90.a.b {
        public a() {
        }

        @Override // z90.a.b
        public final <T> void a(String r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            boolean r102 = AotuCharacterHandler.f69021a;
            List<String> r103 = AotuCharacterHandler.f69022b;
            if (r103 != null) goto L5;
            return;
        L5:
            if (r103.contains(r100) != true) goto L9;
            AotuCharacterHandler.f69023c.invoke(r100);
            return;
        }
    }

    public static final class b implements z90.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f69025a;

        public b(Function2 r100) {
            this.f69025a = r100;
        }

        @Override // z90.a.c
        public final void a(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f69025a.invoke(r100, Boolean.TRUE);
        }
    }

    public static final class c implements z90.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f69026a;

        public c(Function2 r100) {
            this.f69026a = r100;
        }

        @Override // z90.a.c
        public final void a(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f69026a.invoke(r100, Boolean.TRUE);
        }
    }

    static {
        f69023c = AotuCharacterHandler$updateFunc$1.INSTANCE;
        f69024d = new a();
    }

    public static void a(Function1 r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "update");
        Intrinsics.checkNotNullParameter(r101, "updateList");
        f69023c = r100;
        if (f69021a == false) goto L5;
        return;
    L5:
        IFeatureService r102 = (IFeatureService) k.f(IFeatureService.class);
        if (r102 == null) goto L10;
        z90.a r103 = r102.getFeatureManager();
        if (r103 == null) goto L10;
        r103.e(f69024d, f69022b);
    L10:
        f69021a = true;
        IFeatureService r104 = (IFeatureService) k.f(IFeatureService.class);
        if (r104 == null) goto L16;
        z90.a r105 = r104.getFeatureManager();
        if (r105 == null) goto L17;
        r105.f(new b(r101));
        return;
    L17:
        return;
    }

    public static void b(Function1 r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "update");
        Intrinsics.checkNotNullParameter(r101, "updateList");
        f69023c = r100;
        IFeatureService r102 = (IFeatureService) k.f(IFeatureService.class);
        if (r102 == null) goto L8;
        z90.a r103 = r102.getFeatureManager();
        if (r103 == null) goto L8;
        r103.e(f69024d, f69022b);
    L8:
        if (f69021a == false) goto L10;
        return;
    L10:
        f69021a = true;
        IFeatureService r104 = (IFeatureService) k.f(IFeatureService.class);
        if (r104 == null) goto L16;
        z90.a r105 = r104.getFeatureManager();
        if (r105 == null) goto L17;
        r105.f(new c(r101));
        return;
    L17:
        return;
    }
}
