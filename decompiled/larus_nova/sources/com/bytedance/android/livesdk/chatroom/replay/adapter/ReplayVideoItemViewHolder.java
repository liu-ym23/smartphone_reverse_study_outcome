package com.bytedance.android.livesdk.chatroom.replay.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mq1.p;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/adapter/ReplayVideoItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayVideoItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f108099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f108100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f108101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f108102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f108103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f108104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f108105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f108106h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p f108107i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DataCenter f108108j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<com.bytedance.android.livesdk.chatroom.replay.adapter.a, Unit> f108109k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<com.bytedance.android.livesdk.chatroom.replay.adapter.a, Unit> f108110l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f108111m;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.adapter.ReplayVideoItemViewHolder$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/adapter/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/replay/adapter/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<com.bytedance.android.livesdk.chatroom.replay.adapter.a, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.bytedance.android.livesdk.chatroom.replay.adapter.a r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.livesdk.chatroom.replay.adapter.a r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    static {
    }

    public final TextView T3() {
        return (TextView) this.f108105g.getValue();
    }

    public final TextView U3() {
        return (TextView) this.f108103e.getValue();
    }

    public final TextView V3() {
        return (TextView) this.f108104f.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReplayVideoItemViewHolder(p r100, DataCenter r101, Function1<? super com.bytedance.android.livesdk.chatroom.replay.adapter.a, Unit> r102, Function1<? super com.bytedance.android.livesdk.chatroom.replay.adapter.a, Unit> r103, View r104) {
        Intrinsics.checkNotNullParameter(r102, "selectedListener");
        Intrinsics.checkNotNullParameter(r103, "actionListener");
        Intrinsics.checkNotNullParameter(r104, "rootView");
        super(r104);
        this.f108107i = r100;
        this.f108108j = r101;
        this.f108109k = r102;
        this.f108110l = r103;
        this.f108111m = r104;
        this.f108099a = LazyKt.lazy(new ReplayVideoItemViewHolder$coverImage$2(this));
        this.f108100b = LazyKt.lazy(new ReplayVideoItemViewHolder$currentPlayingContainer$2(this));
        this.f108101c = LazyKt.lazy(new ReplayVideoItemViewHolder$currentPlaying$2(this));
        this.f108102d = LazyKt.lazy(new ReplayVideoItemViewHolder$episodeTitle$2(this));
        this.f108103e = LazyKt.lazy(new ReplayVideoItemViewHolder$episodeDate$2(this));
        this.f108104f = LazyKt.lazy(new ReplayVideoItemViewHolder$episodeLabel$2(this));
        this.f108105g = LazyKt.lazy(new ReplayVideoItemViewHolder$actionButton$2(this));
    }
}
