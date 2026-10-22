package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f157745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IExternalButton f157746c;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodel.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f157747a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final ToolbarButton c() {
            return ToolbarButton.COMMERCE_LIVE_AD;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
            return com.bytedance.android.livesdk.chatroom.viewmodel.a.e.f114777b;
        }

        public a(k r100) {
            this.f157747a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean a(long r100) {
            ALogger.i("AnimationCenterScheduler", "start live ad windmill");
            return this.f157747a.f157746c.onTriggerAnimation(r100);
        }
    }

    public k(IExternalButton r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        super(r100);
        this.f157746c = r100;
        this.f157745b = new a(this);
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(s r100) {
        this.f157746c.onShow(r100);
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.R9(r100, r101);
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L8;
        ALogger.i("AnimationCenterScheduler", "unregister live ad windmill");
        IAnimationScheduler r102 = IAnimationScheduler.Companion.a(r101);
        if (r102 == null) goto L9;
        r102.unRegisterListener(this.f157745b);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.p4(r100, r101);
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L8;
        ALogger.i("AnimationCenterScheduler", "register live ad windmill");
        IAnimationScheduler r102 = IAnimationScheduler.Companion.a(r101);
        if (r102 == null) goto L9;
        r102.registerListener(this.f157745b);
        return;
    L9:
        return;
    }
}
