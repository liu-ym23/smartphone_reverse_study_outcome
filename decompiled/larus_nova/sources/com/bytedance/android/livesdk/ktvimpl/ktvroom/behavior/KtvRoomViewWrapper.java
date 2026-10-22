package com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvRoomViewWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f144532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f144533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f144534c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.KtvRoomViewWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lub0/a;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lub0/a;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ub0.a, Unit> {
        public AnonymousClass1(a r100) {
            super(1, r100, a.class, "onLyricsParseResult", "onLyricsParseResult(Lcom/bytedance/android/live/ktv/common/music/lyric/model/LyricsChangeEvent;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ub0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            ((a) this.receiver).r8(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ub0.a r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.behavior.KtvRoomViewWrapper$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass2(a r100) {
            super(1, r100, a.class, "onListenerProgress", "onListenerProgress(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long r100) {
            invoke(r100.longValue());
            return Unit.INSTANCE;
        }

        public final void invoke(long r100) {
            ((a) this.receiver).c8(r100);
        }
    }

    public KtvRoomViewWrapper(LifecycleOwner r100, c r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "listenerHandler");
        this.f144532a = r100;
        this.f144533b = r101;
        this.f144534c = r102;
        if (r101 == null) goto L5;
        r101.observerOnLyricsChange(r100, new AnonymousClass1(r102));
    L5:
        if (r101 == null) goto L8;
        r101.observerOnProgress(r100, new AnonymousClass2(r102));
        return;
    }
}
