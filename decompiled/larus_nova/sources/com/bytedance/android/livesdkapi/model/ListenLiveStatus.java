package com.bytedance.android.livesdkapi.model;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ListenLiveStatus;", "", "()V", "changedFailed", "", "getChangedFailed", "()Z", "setChangedFailed", "(Z)V", "endReason", "", "getEndReason", "()Ljava/lang/String;", "setEndReason", "(Ljava/lang/String;)V", "eventHandler", "Lcom/bytedance/android/livesdkapi/model/ListenLiveEventHandler;", "getEventHandler", "()Lcom/bytedance/android/livesdkapi/model/ListenLiveEventHandler;", "setEventHandler", "(Lcom/bytedance/android/livesdkapi/model/ListenLiveEventHandler;)V", "inChanging", "getInChanging", "setInChanging", "isInit", "setInit", "isOpen", "setOpen", "listenLiveView", "Landroid/view/View;", "getListenLiveView", "()Landroid/view/View;", "setListenLiveView", "(Landroid/view/View;)V", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ListenLiveStatus {
    public static final Companion Companion = null;
    public static final String END_EXIT_ROOM = "exit_room";
    public static final String END_IN_ROOM_WINDOW = "in_room_small_window";
    public static final String END_LINK_ADAPTER = "link_adapter";
    public static final String END_OUT_ROOM_WINDOW = "out_room_small_window";
    public static final String END_USER_OPERATE = "user_operate";
    private boolean changedFailed;
    private String endReason;
    private ListenLiveEventHandler eventHandler;
    private boolean inChanging;
    private boolean isInit;
    private boolean isOpen;
    private View listenLiveView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ListenLiveStatus$Companion;", "", "()V", "END_EXIT_ROOM", "", "END_IN_ROOM_WINDOW", "END_LINK_ADAPTER", "END_OUT_ROOM_WINDOW", "END_USER_OPERATE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ListenLiveStatus() {
        this.isInit = true;
        this.endReason = "";
    }

    public final boolean getChangedFailed() {
        return this.changedFailed;
    }

    public final String getEndReason() {
        return this.endReason;
    }

    public final ListenLiveEventHandler getEventHandler() {
        return this.eventHandler;
    }

    public final boolean getInChanging() {
        return this.inChanging;
    }

    public final View getListenLiveView() {
        return this.listenLiveView;
    }

    public final boolean isInit() {
        return this.isInit;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setChangedFailed(boolean r100) {
        this.changedFailed = r100;
    }

    public final void setEndReason(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.endReason = r100;
    }

    public final void setEventHandler(ListenLiveEventHandler r100) {
        this.eventHandler = r100;
    }

    public final void setInChanging(boolean r100) {
        this.inChanging = r100;
    }

    public final void setInit(boolean r100) {
        this.isInit = r100;
    }

    public final void setListenLiveView(View r100) {
        this.listenLiveView = r100;
    }

    public final void setOpen(boolean r100) {
        this.isOpen = r100;
    }
}
