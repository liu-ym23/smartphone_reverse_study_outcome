package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import com.bytedance.android.live.core.log.ALogger;
import fd2.a0;
import fd2.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbsLyricService implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f143007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ub0.a f143008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<? super Long, Boolean> f143009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvapi.config.a f143010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ud2.b f143011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ud2.a f143012g;

    public static final class a {
    }

    static {
    }

    @Override // fd2.l
    public void reset() {
        this.f143012g.clear();
        this.f143011f.clear();
    }

    @Override // fd2.l
    public void k(final a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (r100.f476462a != null) goto L5;
        ALogger.e(bb0.b.b(), "prepareShow fail, url is null, invoke class :".concat(AbsLyricService.class.getSimpleName()));
    L5:
        this.f143007b = r100;
        final Function1<ub0.a, Unit> r101 = new AbsLyricService$prepareShow$lyricHandleTask$1(this, r100);
        String r102 = r100.f476465d;
        String r103 = "";
        if (r102 != null) goto L8;
    L19:
        ud2.b r104 = this.f143011f;
        String r105 = r100.f476462a;
        if (r105 == null) goto L23;
        r103 = r105;
    L23:
        String r106 = r103;
        r104.a(r106, r100.f476463b, r100.f476464c, new AbsLyricService$prepareShow$2(r101));
        return;
    L8:
        if (r102.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 != true) goto L19;
        ud2.b r108 = this.f143011f;
        long r109 = r100.f476463b;
        int r110 = r100.f476464c;
        String r111 = r100.f476465d;
        if (r111 == null) goto L16;
        r103 = r111;
    L16:
        ub0.a r112 = r108.b(r109, r110, r103);
        if (r112 == null) goto L25;
        Unit r113 = r101.invoke(r112);
        return;
    L25:
        return;
    L10:
        r107 = false;
        goto L11
    }

    public AbsLyricService(com.bytedance.android.livesdk.ktvapi.config.a r100, ud2.b r101, ud2.a r102) {
        Intrinsics.checkNotNullParameter(r100, "displayConfig");
        Intrinsics.checkNotNullParameter(r101, "resourceManager");
        Intrinsics.checkNotNullParameter(r102, "displayModel");
        this.f143010e = r100;
        this.f143011f = r101;
        this.f143012g = r102;
        this.f143009d = new AbsLyricService$lyricChecker$1(this);
    }

    public static List t(List r100, long r101, long r110) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L17;
        com.bytedance.component.lyric.model.b r104 = (com.bytedance.component.lyric.model.b) r103.next();
        long r105 = r104.f203029b;
        if (r105 > r101) goto L8;
    L9:
        long r106 = r104.f203030c;
        if (r106 <= r101) goto L13;
        if (r105 >= r101) goto L13;
    L16:
        r102.add(r104);
    L13:
        if (r105 >= r110) goto L4;
        if (r106 <= r110) goto L4;
    L8:
        if (r104.f203030c < r110) goto L16;
    L17:
        return r102;
    }

    @Override // fd2.l
    public void r(long r100, boolean r101, Boolean r102) {
        this.f143012g.e(r100);
    }
}
