package com.bytedance.android.livesdk.arch.container;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends AbsTbContainer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d.c f103753g;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a {
        public a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a
        public final void b(AbsTbContainer$contentHelper$2.a r100) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a
        public final void onDestroy() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a
        public final void a(com.bytedance.android.livesdk.arch.comp.b r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "comp");
            ALogger.i("LiveTbMorePanelContainer", "loadComp");
        }
    }

    @Override // com.bytedance.android.livesdk.arch.container.AbsTbContainer
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a g() {
        return new a();
    }

    @Override // com.bytedance.android.livesdk.arch.container.AbsTbContainer, com.bytedance.android.livesdk.arch.container.a
    public d getType() {
        return this.f103753g;
    }

    public c(ot2.d r100) {
        super(r100, null);
        this.f103753g = d.c.f103757c;
    }
}
