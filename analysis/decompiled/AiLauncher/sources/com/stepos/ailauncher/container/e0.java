package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001\u001bB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\bJ\r\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0012R$\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/container/e0;", "", "", "closedEpsilon", "<init>", "(F)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_UMID, "progress", "", "fingerStillDown", Const.INTENT_KEY_BACKGROUND_COMMAND, "(FZ)V", "e", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "panelMarkedOpen", "contentPending", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ZZ)Z", "F", UxipConstants.f30680s, "dragSeen", "Z", Const.INTENT_KEY_APIKEY, "settledClosed", "c", "lastProgress", Const.INTENT_KEY_PKGNAME, "()F", "Companion", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e0 {
    public static final float CLOSED_EPSILON = 0.001f;
    private final float closedEpsilon;
    private boolean dragSeen;
    private float lastProgress;
    private boolean settledClosed;

    public e0(float f10) {
        this.closedEpsilon = f10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDragSeen() {
        return this.dragSeen;
    }

    /* renamed from: b, reason: from getter */
    public final float getLastProgress() {
        return this.lastProgress;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSettledClosed() {
        return this.settledClosed;
    }

    public final void d() {
        this.dragSeen = true;
        this.settledClosed = false;
    }

    public final void e() {
        if (this.lastProgress <= this.closedEpsilon || this.settledClosed) {
            this.dragSeen = false;
            this.settledClosed = true;
        }
    }

    public final void f() {
        this.dragSeen = false;
        this.settledClosed = true;
        this.lastProgress = 0.0f;
    }

    public final void g(float progress, boolean fingerStillDown) {
        this.lastProgress = progress;
        if (progress <= this.closedEpsilon) {
            this.dragSeen = false;
            this.settledClosed = true;
        } else if (fingerStillDown) {
            this.settledClosed = false;
            this.dragSeen = true;
        }
    }

    public final void h() {
        this.dragSeen = false;
        this.settledClosed = false;
        this.lastProgress = 0.0f;
    }

    public final boolean i(boolean panelMarkedOpen, boolean contentPending) {
        return panelMarkedOpen && contentPending;
    }

    public final boolean j() {
        return this.dragSeen && !this.settledClosed;
    }

    public /* synthetic */ e0(float f10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? 0.001f : f10);
    }
}
