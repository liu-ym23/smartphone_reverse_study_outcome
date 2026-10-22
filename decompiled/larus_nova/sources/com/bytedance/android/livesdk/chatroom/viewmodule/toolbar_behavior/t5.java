package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.av0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.interfaces.DraweeController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class t5 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RoomContext f117377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f117378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f117379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DraweeController f117380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f117381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f117382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f117383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f117384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f117385i;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodel.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t5 f117386a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final ToolbarButton c() {
            return ToolbarButton.VR_MODE;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
            return com.bytedance.android.livesdk.chatroom.viewmodel.a.g.f114779b;
        }

        public a(t5 r100) {
            this.f117386a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean a(long r100) {
            this.f117386a.a("vrAnimScheduled");
            long r101 = System.currentTimeMillis();
            int r102 = av0.f119822a.getValue().a();
            t5 r103 = this.f117386a;
            if ((r101 - r103.f117383g) >= (r102 - 100)) goto L6;
            r103.a("return time=" + (r101 - this.f117386a.f117383g) + ",interval=" + r102);
            return false;
        L6:
            r103.f117383g = r101;
            HSImageView r104 = r103.f117379c;
            if (r104 != null) goto L9;
            return true;
        L9:
            if (r104 == null) goto L11;
            r104.setVisibility(0);
        L11:
            DraweeController r105 = this.f117386a.f117380d;
            if (r105 == null) goto L16;
            Animatable r106 = r105.getAnimatable();
            if (r106 == null) goto L16;
            r106.start();
        L16:
            t5 r107 = this.f117386a;
            if (r107.f117381e == false) goto L21;
            View r108 = r107.f117378b;
            if (r108 == null) goto L21;
            r108.setVisibility(8);
        L21:
            this.f117386a.f117382f = true;
            return true;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public t5(DataCenter r100) {
        this.f117385i = r100;
        this.f117384h = new a(this);
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        ALogger.d("ToolbarVrModeBehavior", r100);
        return;
    }
}
