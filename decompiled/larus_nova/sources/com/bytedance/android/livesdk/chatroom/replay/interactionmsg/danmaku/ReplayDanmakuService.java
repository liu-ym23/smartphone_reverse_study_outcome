package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayDanmakuService implements mq1.h, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<mq1.h.b> f108918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f108919b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.ReplayDanmakuService$onStart$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "p3", "", "p4", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function4<Boolean, Integer, String, Boolean, Unit> {
        public AnonymousClass1(ReplayDanmakuService r100) {
            super(4, r100, ReplayDanmakuService.class, "setToolbarLandscapeBlockEvent", "setToolbarLandscapeBlockEvent(ZILjava/lang/String;Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Integer r101, String r102, Boolean r103) {
            invoke(r100.booleanValue(), r101.intValue(), r102, r103.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean r100, int r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "p3");
            ((ReplayDanmakuService) this.receiver).a(r100, r101, r102, r103);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (this.f108919b != null) goto L6;
        this.f108919b = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.f().K(new AnonymousClass1(this));
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Disposable r100 = this.f108919b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() != true) goto L11;
        Disposable r101 = this.f108919b;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public ReplayDanmakuService() {
        this.f108918a = new ArrayList();
    }

    @Override // mq1.h
    public final void c(mq1.h.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f108918a.remove(r100);
    }

    @Override // mq1.h
    public final void d(mq1.h.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f108918a.add(r100);
    }

    @Override // mq1.h
    public final void a(boolean r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "source");
        Iterator<mq1.h.b> r104 = this.f108918a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().p8(r100, r101, r102);
        goto L4
    }
}
