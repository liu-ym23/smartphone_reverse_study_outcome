package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f115825b;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ToolbarButton f115826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final pp1.c f115827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f115828c;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return 1007;
        }

        public a() {
            this.f115826a = ToolbarButton.PLAY_QUALITY_OPT;
            int r100 = pp1.c.f530166o;
            this.f115827b = pp1.c.a.a("可在「播放优化」中修改设置");
            this.f115828c = new c();
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.f115826a;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return this.f115828c;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.f115827b;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f115829a;

        public b(d r100) {
            this.f115829a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == true) goto L5;
            return;
        L5:
            if (TopSpeedModeUtils.d().k() == false) goto L9;
            i0.h(new e(this));
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return new a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        TopSpeedModeManager r100 = TopSpeedModeManager.f99061l;
        if (r100.f99069h.f64752a.booleanValue() == true) goto L5;
        RxUtilKt.c(r100.f99069h.subscribe(new b(this)), this.f115825b);
        return;
    L5:
        if (TopSpeedModeUtils.d().k() == false) goto L9;
        a();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
        this.f115825b.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        if (TopSpeedModeUtils.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (TopSpeedModeUtils.d().k() == false) goto L7;
        return true;
    }

    public d(BubbleEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        super(r100);
        this.f115825b = new CompositeDisposable();
    }
}
