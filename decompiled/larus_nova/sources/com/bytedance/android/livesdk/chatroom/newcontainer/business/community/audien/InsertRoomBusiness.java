package com.bytedance.android.livesdk.chatroom.newcontainer.business.community.audien;

import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class InsertRoomBusiness extends os2.d<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f107311b = 0;

    public static final class a {
    }

    public static final class b extends ls2.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<Long> f107312c;

        public b() {
            this.f107312c = new LinkedHashSet();
        }
    }

    static {
    }

    @Override // os2.a
    public final ls2.c d() {
        return new b();
    }

    public InsertRoomBusiness() {
    }

    @Override // os2.d
    public final List<com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ?>> g(final ls2.d r100, ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L7;
        ts2.d.a(r101, new InsertRoomBusiness$containerStateChanged$1(this, r100));
        return null;
    L7:
        return null;
    }
}
