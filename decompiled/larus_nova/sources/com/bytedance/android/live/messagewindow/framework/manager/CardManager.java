package com.bytedance.android.live.messagewindow.framework.manager;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/manager/CardManager;", "Lcom/bytedance/android/live/messagewindow/framework/manager/AbsWindowManager;", "Lv61/c;", "msgWindow", "", "interceptShow", "interceptDismiss", "Ly61/b;", "msgWindowCtx", "Ly61/b;", "getMsgWindowCtx", "()Ly61/b;", "<init>", "(Ly61/b;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardManager extends AbsWindowManager {
    private final y61.b msgWindowCtx;

    @Override // com.bytedance.android.live.messagewindow.framework.manager.AbsWindowManager
    public y61.b getMsgWindowCtx() {
        return this.msgWindowCtx;
    }

    public CardManager(y61.b r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindowCtx");
        this.msgWindowCtx = r100;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.manager.AbsWindowManager
    public boolean interceptDismiss(v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        boolean r101 = super.interceptDismiss(r100);
        i r102 = getMsgWindowCtx().monitor();
        if (r101 == false) goto L11;
        String r103 = "card of [" + r100.getIdentity() + "] wanna dismiss but intercepted, it is not in the records";
        if (r102 == null) goto L8;
        CardAlogParamsBuilder r104 = new CardAlogParamsBuilder();
        r104.c(r103);
        Unit r105 = Unit.INSTANCE;
        r102.d(r104.b());
    L8:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r106 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_intercept_dismiss_card");
        r106.a(r100.getIdentity());
        i r107 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r107 == null) goto L14;
        r107.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r106));
    L14:
        return r101;
    L11:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r108 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_request_dismiss_card");
        r108.a(r100.getIdentity());
        i r109 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r109 == null) goto L14;
        r109.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r108));
        goto L14
    }

    @Override // com.bytedance.android.live.messagewindow.framework.manager.AbsWindowManager
    public boolean interceptShow(v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        boolean r101 = super.interceptShow(r100);
        i r102 = getMsgWindowCtx().monitor();
        if (r101 == false) goto L17;
        String r103 = "card of [" + r100.getIdentity() + "] wanna show but intercepted, it is already showing";
        if (r102 == null) goto L8;
        CardAlogParamsBuilder r104 = new CardAlogParamsBuilder();
        r104.c(r103);
        Unit r105 = Unit.INSTANCE;
        r102.d(r104.b());
    L8:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r106 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_intercept_show_card");
        r106.a(r100.getIdentity());
        i r107 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r107 == null) goto L12;
        r107.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r106));
    L12:
        if ((r100 instanceof v61.a) == true) goto L14;
        r100 = null;
    L14:
        v61.a r108 = (v61.a) r100;
        if (r108 == null) goto L20;
        r108.H(p71.a.C7158a.f527979c);
    L20:
        return r101;
    L17:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r109 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_manager_request_show_card");
        r109.a(r100.getIdentity());
        i r110 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r110 == null) goto L20;
        r110.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r109));
        goto L20
    }
}
