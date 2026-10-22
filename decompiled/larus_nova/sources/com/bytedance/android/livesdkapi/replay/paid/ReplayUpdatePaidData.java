package com.bytedance.android.livesdkapi.replay.paid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/paid/ReplayUpdatePaidData;", "", "()V", "newDelivery", "", "getNewDelivery", "()I", "setNewDelivery", "(I)V", "newViewRight", "getNewViewRight", "setNewViewRight", "parentTicketId", "", "getParentTicketId", "()J", "setParentTicketId", "(J)V", "ticketId", "getTicketId", "setTicketId", "updateType", "getUpdateType", "setUpdateType", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayUpdatePaidData {
    public static final Companion Companion = null;
    public static final int UPDATE_TYPE_PAID_CAMERA = 1;
    public static final int UPDATE_TYPE_PRIVILEGE = 2;
    public static final int UPDATE_TYPE_SUBSCRIBE_REPLAY = 0;
    private int newDelivery;
    private int newViewRight;
    private long parentTicketId;
    private long ticketId;
    private int updateType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/paid/ReplayUpdatePaidData$Companion;", "", "()V", "UPDATE_TYPE_PAID_CAMERA", "", "UPDATE_TYPE_PRIVILEGE", "UPDATE_TYPE_SUBSCRIBE_REPLAY", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public ReplayUpdatePaidData() {
        this.updateType = 1;
    }

    public final int getNewDelivery() {
        return this.newDelivery;
    }

    public final int getNewViewRight() {
        return this.newViewRight;
    }

    public final long getParentTicketId() {
        return this.parentTicketId;
    }

    public final long getTicketId() {
        return this.ticketId;
    }

    public final int getUpdateType() {
        return this.updateType;
    }

    public final void setNewDelivery(int r100) {
        this.newDelivery = r100;
    }

    public final void setNewViewRight(int r100) {
        this.newViewRight = r100;
    }

    public final void setParentTicketId(long r100) {
        this.parentTicketId = r100;
    }

    public final void setTicketId(long r100) {
        this.ticketId = r100;
    }

    public final void setUpdateType(int r100) {
        this.updateType = r100;
    }
}
