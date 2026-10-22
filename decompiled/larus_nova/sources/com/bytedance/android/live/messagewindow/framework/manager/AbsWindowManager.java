package com.bytedance.android.live.messagewindow.framework.manager;

import com.bytedance.live.datacontext.DataContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0014R\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/manager/AbsWindowManager;", "Lcom/bytedance/live/datacontext/DataContext;", "Le71/a;", "Lv61/c;", "msgWindow", "", "show", "", "interceptShow", "hide", "interceptHide", "dismiss", "interceptDismiss", "Ly61/b;", "getMsgWindowCtx", "()Ly61/b;", "msgWindowCtx", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsWindowManager extends DataContext implements e71.a {
    public abstract y61.b getMsgWindowCtx();

    public AbsWindowManager() {
    }

    @Override // e71.a
    public void dismiss(final v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        if (interceptDismiss(r100) == false) goto L5;
        return;
    L5:
        i71.a r101 = getMsgWindowCtx().scheduler();
        if (r101 == null) goto L9;
        r101.execute(new AnonymousClass1(r100));
        return;
    }

    @Override // e71.a
    public void hide(final v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        if (interceptHide(r100) == false) goto L5;
        return;
    L5:
        i71.a r101 = getMsgWindowCtx().scheduler();
        if (r101 == null) goto L9;
        r101.execute(new C99081(r100));
        return;
    }

    public boolean interceptDismiss(v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        d71.d<v61.a, d71.b> r101 = getMsgWindowCtx().recordManager(r100.getPosition());
        if (r101 == null) goto L11;
        if (r101.g(r100) == true) goto L8;
        return true;
    L8:
        return false;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.list.IMsgWindowRecordManager<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow, com.bytedance.android.live.room.api.messagewindow.list.MsgWindowRecord<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow>>");
    }

    public boolean interceptHide(v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        d71.d<v61.a, d71.b> r101 = getMsgWindowCtx().recordManager(r100.getPosition());
        if (r101 == null) goto L14;
        if (r101.c(r100) == false) goto L7;
        return false;
    L7:
        if (r100.isShowing() == true) goto L15;
        return true;
    L15:
        return false;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.list.IMsgWindowRecordManager<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow, com.bytedance.android.live.room.api.messagewindow.list.MsgWindowRecord<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow>>");
    }

    public boolean interceptShow(v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        d71.d<v61.a, d71.b> r101 = getMsgWindowCtx().recordManager(r100.getPosition());
        if (r101 == null) goto L15;
        if (r101.c(r100) == true) goto L7;
        return false;
    L7:
        if (r100.isShowing() == true) goto L11;
        w61.a<v61.a> r102 = getMsgWindowCtx().windowContainer(r100.getPosition());
        if (r102 == null) goto L11;
        r102.yc((v61.a) r100, true, C99091.INSTANCE);
    L11:
        return true;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.list.IMsgWindowRecordManager<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow, com.bytedance.android.live.room.api.messagewindow.list.MsgWindowRecord<com.bytedance.android.live.room.api.messagewindow.carrier.IMsgWindow>>");
    }

    @Override // e71.a
    public void show(final v61.c r100) {
        Intrinsics.checkNotNullParameter(r100, "msgWindow");
        if (interceptShow(r100) == false) goto L5;
        return;
    L5:
        i71.a r101 = getMsgWindowCtx().scheduler();
        if (r101 == null) goto L9;
        r101.execute(new C99101(r100));
        return;
    }
}
