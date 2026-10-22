package c35;

import com.alibaba.fastjson.JSONObject;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;
import tk5.c;
import tk5.d;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f22275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f22276b;

    @Override // tk5.c
    public final void a(d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.f22275a.getId());
        m r101 = this.f22276b;
        if (r101 == null) goto L6;
        r101.b(new JSONObject(MapsKt.mapOf(TuplesKt.to("action", "confirm"))));
        return;
    }

    @Override // tk5.c
    public final void b(d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.f22275a.getId());
        m r101 = this.f22276b;
        if (r101 == null) goto L6;
        r101.b(new JSONObject(MapsKt.mapOf(TuplesKt.to("action", "dismiss"))));
        return;
    }

    @Override // tk5.c
    public final void c(d<? extends vk5.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "mission");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.f22275a.getId());
        m r101 = this.f22276b;
        if (r101 == null) goto L6;
        r101.b(new JSONObject(MapsKt.mapOf(TuplesKt.to("action", "cancel"))));
        return;
    }

    public b(a r100, m r101) {
        this.f22275a = r100;
        this.f22276b = r101;
    }
}
