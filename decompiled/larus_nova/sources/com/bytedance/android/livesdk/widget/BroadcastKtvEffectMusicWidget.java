package com.bytedance.android.livesdk.widget;

import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.model.LiveBroadcastMusicEffectInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/widget/BroadcastKtvEffectMusicWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BroadcastKtvEffectMusicWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f160758a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f160759a;

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "effectId");
            this.f160759a = r100;
        }
    }

    public interface b {
        void a();
    }

    public static final class c {
        public c() {
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f160760a;

        public d(String r100, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.m3.h r101) {
            Intrinsics.checkNotNullParameter(r100, "effectId");
            this.f160760a = r101;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BroadcastKtvEffectMusicWidget f160761a;

        public e(BroadcastKtvEffectMusicWidget r100) {
            this.f160761a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            c r101 = (c) r100;
            b r102 = this.f160761a.f160758a;
            if (r102 == null) goto L6;
            r102.a();
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BroadcastKtvEffectMusicWidget f160762a;

        public f(BroadcastKtvEffectMusicWidget r100) {
            this.f160762a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BroadcastKtvEffectMusicWidget r101 = this.f160762a;
            r101.f160758a = ((d) r100).f160760a;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BroadcastKtvEffectMusicWidget f160763a;

        public g(BroadcastKtvEffectMusicWidget r100) {
            this.f160763a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            a r111 = (a) r110;
            RoomContext.a r100 = RoomContext.Companion;
            RoomContext r101 = RoomContext.a.c(r100, this.f160763a.dataCenter, 0, 2);
            if (r101 == null) goto L8;
            com.bytedance.live.datacontext.n<LiveBroadcastMusicEffectInfo> r102 = r101.getBroadcastMusicEffectInfo();
            if (r102 == null) goto L8;
            LiveBroadcastMusicEffectInfo r103 = r102.getValue();
            if (r103 == null) goto L8;
        L10:
            if (Intrinsics.areEqual(r111.f160759a, r103.getEffectId()) == false) goto L25;
            com.bytedance.android.live.pushstream.d r104 = null;
            RoomContext r112 = RoomContext.a.c(r100, null, 0, 3);
            if (r112 == null) goto L16;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r113 = r112.getLiveStream();
            if (r113 == null) goto L16;
            r104 = r113.getValue();
        L16:
            if (r104 == null) goto L18;
            r104.e0("MusicInformationData", "");
        L18:
            RoomContext r114 = RoomContext.a.c(r100, this.f160763a.dataCenter, 0, 2);
            if (r114 == null) goto L23;
            com.bytedance.live.datacontext.n<LiveBroadcastMusicEffectInfo> r115 = r114.getBroadcastMusicEffectInfo();
            if (r115 == null) goto L23;
            r115.setValue(new LiveBroadcastMusicEffectInfo("", "", null, 4, null));
        L23:
            this.f160763a.dataCenter.put("anchor_interact_effect_music_open", Boolean.FALSE);
            return;
        L25:
            return;
        L8:
            r103 = new LiveBroadcastMusicEffectInfo("", "", null, 4, null);
            goto L10
        }
    }

    public static final class h {
        public h() {
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.f116328e.getClass();
        List<String> r100 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.f116327d;
        List r101 = CollectionsKt.toList(r100);
        ((ArrayList) r100).clear();
        if (r101.isEmpty() == true) goto L7;
        Single.create(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.j0(r101)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.k0.f116363a, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.l0.f116373a);
        return;
    }

    public BroadcastKtvEffectMusicWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ((ObservableSubscribeProxy) xs2.b.a().b(c.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new e(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(d.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new f(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(a.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new g(this));
        List<String> r101 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().r(new h());
    }
}
