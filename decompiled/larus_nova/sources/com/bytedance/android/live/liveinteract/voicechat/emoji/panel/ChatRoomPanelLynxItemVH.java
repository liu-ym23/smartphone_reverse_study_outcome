package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelLynxItemVH;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/ChatRoomPanelItemBaseVH;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomPanelLynxItemVH extends ChatRoomPanelItemBaseVH {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f80183d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f80184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HybridCard f80185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f80186c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatRoomPanelLynxItemVH f80187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f80188b;

        public a(ChatRoomPanelLynxItemVH r100, g r101) {
            this.f80187a = r100;
            this.f80188b = r101;
        }

        public final void a() {
            ChatRoomPanelLynxItemVH r100 = this.f80187a;
            String r101 = this.f80188b.e();
            int r102 = ChatRoomPanelLynxItemVH.f80183d;
            r100.getClass();
            if (r101.length() != 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L9;
            return;
        L9:
            if (r100.f80185b != null) goto L19;
            HybridCard r104 = ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).getHybridCard(r100.f80186c.getContext(), x6.a.d(r101 + "&width=" + r100.f80186c.getMeasuredWidth() + "&height=" + r100.f80186c.getMeasuredHeight()), new h(r100));
            r100.f80185b = r104;
            if (r104 == null) goto L15;
            a7.a.a(r104, null, null, 3);
            FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(s1.f(48.0f), s1.f(72.0f));
            r105.gravity = 17;
            r104.setLayoutParams(r105);
            FrameLayout r106 = r100.f80184a;
            if (r106 == null) goto L15;
            r106.addView(r104);
        L15:
            FrameLayout r107 = r100.f80184a;
            if (r107 == null) goto L20;
            UtilityKotlinExtentionsKt.w(r107);
            return;
        L20:
            return;
        L19:
            return;
        L5:
            r103 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ChatRoomPanelLynxItemVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f80186c = r100;
        this.f80184a = (FrameLayout) r100.findViewById(R.id.lynx_container);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void T3(g r100) {
        Intrinsics.checkNotNullParameter(r100, "panelItem");
        this.f80186c.post(new a(this, r100));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemBaseVH
    public final void U3(ChatRoomPanelItemBaseVH r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        HybridCard r101 = this.f80185b;
        if (r101 == null) goto L5;
        r101.release();
    L5:
        this.f80185b = null;
    }
}
