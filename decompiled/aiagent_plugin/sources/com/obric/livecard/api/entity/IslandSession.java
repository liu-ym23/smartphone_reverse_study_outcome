package com.obric.livecard.api.entity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.notification.INotificationLiveView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: IslandSessionEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IslandSession implements Parcelable, INotificationLiveView {
    public static final CREATOR CREATOR = null;
    public static final int MAGIC_CODE = 429261353;
    public static final int VERSION_CODE = 1;
    private final Long autoDismissDuration;
    private final IslandCardCallback callback;
    private Boolean canFrontShow;
    private final IslandWidget collapseWidget;
    private IslandWidget currWidget;
    private final IslandWidget expandWidget;
    private JsonObject ext;
    private long flags;
    private PendingIntent intent;
    private Object sessionContext;
    private long taskId;
    private final LiveCardType type;
    private final int version;

    /* JADX INFO: compiled from: IslandSessionEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<IslandSession> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        public static final /* synthetic */ int access$readVersion(CREATOR r0, Parcel r1) {
            return r0.readVersion(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IslandSession[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new IslandSession(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IslandSession[] newArray(int r1) {
            return new IslandSession[r1];
        }

        private final int readVersion(Parcel r4) {
            int r3 = r4.dataPosition();
            int r0 = 0;
        L8:
            r4.setDataPosition(r3);
        L9:
            return r0;
        L4:
            if (r4.readInt() != 429261353) goto L6;
            r3 = r4.readInt();     // Catch: Exception -> L8
            r0 = r3;
        L10:
            goto L9
        L6:
            r4.setDataPosition(r3);     // Catch: Exception -> L8
            goto L10
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public IslandSession() {
        this(null, null, null, null, null, 0, null, null, null, null, 0, null, 0, 8191, null);
    }

    private final int component13() {
        return this.version;
    }

    public static /* synthetic */ IslandSession copy$default(IslandSession r16, IslandWidget r17, IslandWidget r18, PendingIntent r19, IslandCardCallback r20, Long r21, long r22, LiveCardType r24, IslandWidget r25, Boolean r26, JsonObject r27, long r28, Object r30, int r31, int r32, Object r33) {
        IslandCardCallback r2 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r20, IslandCardCallback.class, "com.obric.aiagent.plugin");
        if ((r32 & 1) == 0) goto L5;
        IslandWidget r3 = r16.collapseWidget;
    L7:
        if ((r32 & 2) == 0) goto L9;
        IslandWidget r4 = r16.expandWidget;
    L11:
        if ((r32 & 4) == 0) goto L13;
        PendingIntent r5 = r16.intent;
    L15:
        if ((r32 & 8) == 0) goto L18;
        r2 = r16.callback;
    L18:
        if ((r32 & 16) == 0) goto L20;
        Long r6 = r16.autoDismissDuration;
    L22:
        if ((r32 & 32) == 0) goto L24;
        long r7 = r16.taskId;
    L26:
        if ((r32 & 64) == 0) goto L28;
        LiveCardType r9 = r16.type;
    L30:
        if ((r32 & 128) == 0) goto L32;
        IslandWidget r10 = r16.currWidget;
    L34:
        if ((r32 & 256) == 0) goto L36;
        Boolean r11 = r16.canFrontShow;
    L38:
        if ((r32 & 512) == 0) goto L40;
        JsonObject r12 = r16.ext;
    L42:
        if ((r32 & 1024) == 0) goto L44;
        long r13 = r16.flags;
    L46:
        if ((r32 & 2048) == 0) goto L48;
        Object r15 = r16.sessionContext;
    L50:
        if ((r32 & 4096) == 0) goto L52;
        int r1 = r16.version;
    L54:
        return r16.copy(r3, r4, r5, r2, r6, r7, r9, r10, r11, r12, r13, r15, r1);
    L52:
        r1 = r31;
        goto L54
    L48:
        r15 = r30;
        goto L50
    L44:
        r13 = r28;
        goto L46
    L40:
        r12 = r27;
        goto L42
    L36:
        r11 = r26;
        goto L38
    L32:
        r10 = r25;
        goto L34
    L28:
        r9 = r24;
        goto L30
    L24:
        r7 = r22;
        goto L26
    L20:
        r6 = r21;
        goto L22
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    public final IslandWidget component1() {
        return this.collapseWidget;
    }

    public final JsonObject component10() {
        return this.ext;
    }

    public final long component11() {
        return this.flags;
    }

    public final Object component12() {
        return this.sessionContext;
    }

    public final IslandWidget component2() {
        return this.expandWidget;
    }

    public final PendingIntent component3() {
        return this.intent;
    }

    public final IslandCardCallback component4() {
        return this.callback;
    }

    public final Long component5() {
        return this.autoDismissDuration;
    }

    public final long component6() {
        return this.taskId;
    }

    public final LiveCardType component7() {
        return this.type;
    }

    public final IslandWidget component8() {
        return this.currWidget;
    }

    public final Boolean component9() {
        return this.canFrontShow;
    }

    public final IslandSession copy(IslandWidget r18, IslandWidget r19, PendingIntent r20, IslandCardCallback r21, Long r22, long r23, LiveCardType r25, IslandWidget r26, Boolean r27, JsonObject r28, long r29, Object r31, int r32) {
        return new IslandSession(r18, r19, r20, (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r21, IslandCardCallback.class, "com.obric.aiagent.plugin"), r22, r23, r25, r26, r27, r28, r29, r31, r32);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IslandSession(IslandWidget r5, IslandWidget r6, PendingIntent r7, IslandCardCallback r8, Long r9, long r10, LiveCardType r12, IslandWidget r13, Boolean r14, JsonObject r15, long r16, Object r18, int r19) {
        IslandCardCallback r1 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r8, IslandCardCallback.class, "com.obric.aiagent.plugin");
        this.collapseWidget = r5;
        this.expandWidget = r6;
        this.intent = r7;
        this.callback = r1;
        this.autoDismissDuration = r9;
        this.taskId = r10;
        this.type = r12;
        this.currWidget = r13;
        this.canFrontShow = r14;
        this.ext = r15;
        this.flags = r16;
        this.sessionContext = r18;
        this.version = r19;
    }

    public final IslandWidget getCollapseWidget() {
        return this.collapseWidget;
    }

    public final IslandWidget getExpandWidget() {
        return this.expandWidget;
    }

    public final PendingIntent getIntent() {
        return this.intent;
    }

    public final void setIntent(PendingIntent r1) {
        this.intent = r1;
    }

    public final IslandCardCallback getCallback() {
        return this.callback;
    }

    public final Long getAutoDismissDuration() {
        return this.autoDismissDuration;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(long r1) {
        this.taskId = r1;
    }

    public final LiveCardType getType() {
        return this.type;
    }

    public final IslandWidget getCurrWidget() {
        return this.currWidget;
    }

    public final void setCurrWidget(IslandWidget r1) {
        this.currWidget = r1;
    }

    public /* synthetic */ IslandSession(IslandWidget r17, IslandWidget r18, PendingIntent r19, IslandCardCallback r20, Long r21, long r22, LiveCardType r24, IslandWidget r25, Boolean r26, JsonObject r27, long r28, Object r30, int r31, int r32, h r33) {
        IslandCardCallback r1 = (IslandCardCallback) ZeusTransformUtils.wrapperContextForParams(r20, IslandCardCallback.class, "com.obric.aiagent.plugin");
        Object r3 = null;
        if ((r32 & 1) == 0) goto L5;
        IslandWidget r2 = null;
    L7:
        if ((r32 & 2) == 0) goto L9;
        IslandWidget r4 = null;
    L11:
        if ((r32 & 4) == 0) goto L13;
        PendingIntent r5 = null;
    L15:
        if ((r32 & 8) == 0) goto L18;
        r1 = null;
    L18:
        if ((r32 & 16) == 0) goto L20;
        Long r6 = null;
    L21:
        long r8 = 0;
        if ((r32 & 32) == 0) goto L24;
        long r10 = 0;
    L26:
        if ((r32 & 64) == 0) goto L28;
        LiveCardType r7 = null;
    L30:
        if ((r32 & 128) == 0) goto L32;
        IslandWidget r12 = null;
    L34:
        if ((r32 & 256) == 0) goto L36;
        Boolean r13 = false;
    L38:
        if ((r32 & 512) == 0) goto L40;
        JsonObject r14 = null;
    L42:
        if ((r32 & 1024) != 0) goto L46;
        r8 = r28;
    L46:
        if ((r32 & 2048) != 0) goto L50;
        r3 = r30;
    L50:
        if ((r32 & 4096) == 0) goto L52;
        int r0 = 1;
    L53:
        this(r2, r4, r5, r1, r6, r10, r7, r12, r13, r14, r8, r3, r0);
        return;
    L52:
        r0 = r31;
        goto L53
    L40:
        r14 = r27;
        goto L42
    L36:
        r13 = r26;
        goto L38
    L32:
        r12 = r25;
        goto L34
    L28:
        r7 = r24;
        goto L30
    L24:
        r10 = r22;
        goto L26
    L20:
        r6 = r21;
        goto L21
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final Boolean getCanFrontShow() {
        return this.canFrontShow;
    }

    public final void setCanFrontShow(Boolean r1) {
        this.canFrontShow = r1;
    }

    public final JsonObject getExt() {
        return this.ext;
    }

    public final void setExt(JsonObject r1) {
        this.ext = r1;
    }

    public final long getFlags() {
        return this.flags;
    }

    public final void setFlags(long r1) {
        this.flags = r1;
    }

    public final Object getSessionContext() {
        return this.sessionContext;
    }

    public final void setSessionContext(Object r1) {
        this.sessionContext = r1;
    }

    public IslandSession(Parcel r2) {
        o.e(r2, "parcel");
        this(CREATOR.access$readVersion(CREATOR, r2), r2);
    }

    private IslandSession(int r21, Parcel r22) {
        IslandWidget r5 = (IslandWidget) ZeusTransformUtils.preCheckCast(r22.readParcelable(IslandWidget.class.getClassLoader()), IslandWidget.class, "com.obric.aiagent.plugin");
        IslandWidget r6 = (IslandWidget) ZeusTransformUtils.preCheckCast(r22.readParcelable(IslandWidget.class.getClassLoader()), IslandWidget.class, "com.obric.aiagent.plugin");
        PendingIntent r7 = (PendingIntent) ZeusTransformUtils.preCheckCast(r22.readParcelable(PendingIntent.class.getClassLoader()), PendingIntent.class, "com.obric.aiagent.plugin");
        Object r1 = r22.readValue(Long.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L5;
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.aiagent.plugin");
    L6:
        long r10 = r22.readLong();
        LiveCardType.Companion r2 = LiveCardType.Companion;
        String r3 = r22.readString();
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        LiveCardType r12 = r2.fromString(r3);
        boolean r4 = r22.readBoolean();
        String r8 = r22.readString();
        if (r8 == null) goto L12;
        JsonObject r15 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r8, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
    L13:
        if (r21 != 0) goto L15;
        long r11 = 0;
    L16:
        this(r5, r6, r7, null, r9, r10, r12, null, Boolean.valueOf(r4), r15, r11, null, r21);
        return;
    L15:
        r11 = r22.readLong();
        goto L16
    L12:
        r15 = null;
        goto L13
    L5:
        r9 = null;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r9) {
        o.e(r8, "parcel");
        boolean r0 = false;
        if (1 != r9) goto L5;
        int r2 = this.version;
    L9:
        if (r2 <= 0) goto L11;
        r8.writeInt(MAGIC_CODE);
        r8.writeInt(1);
    L11:
        r8.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.collapseWidget, Parcelable.class, "com.obric.aiagent.plugin"), r9);
        r8.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.expandWidget, Parcelable.class, "com.obric.aiagent.plugin"), r9);
        r8.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.intent, Parcelable.class, "com.obric.aiagent.plugin"), r9);
        r8.writeValue(this.autoDismissDuration);
        r8.writeLong(this.taskId);
        LiveCardType r10 = this.type;
        String r1 = null;
        if (r10 == null) goto L14;
        String r11 = r10.name();
    L15:
        r8.writeString(r11);
        Boolean r12 = this.canFrontShow;
        if (r12 == null) goto L18;
        r0 = r12.booleanValue();
    L18:
        r8.writeBoolean(r0);
        JsonObject r13 = this.ext;
        if (r13 == null) goto L21;
        r1 = new Gson().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r13, JsonElement.class, "com.obric.aiagent.plugin"));
    L21:
        r8.writeString(r1);
        if (r2 <= 0) goto L25;
        r8.writeLong(this.flags);
        return;
    L25:
        return;
    L14:
        r11 = null;
        goto L15
    L5:
        IslandApi r3 = ILiveCard.Companion.getInst().getIslandService();
        if (r3 == null) goto L8;
        r2 = r3.getIslandVersion();
        goto L9
    L8:
        r2 = 0;
        goto L9
    }

    public final void readFromParcel(Parcel r6) {
        o.e(r6, "parcel");
        int r0 = CREATOR.access$readVersion(CREATOR, r6);
        r6.readParcelable(IslandWidget.class.getClassLoader());
        r6.readParcelable(IslandWidget.class.getClassLoader());
        r6.readParcelable(PendingIntent.class.getClassLoader());
        Object r1 = r6.readValue(Long.TYPE.getClassLoader());
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == false) goto L5;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.aiagent.plugin");
    L5:
        this.taskId = r6.readLong();
        r6.readString();
        r6.readBoolean();
        String r3 = r6.readString();
        if (r3 == null) goto L8;
        JsonObject r4 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r3, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
    L9:
        this.ext = r4;
        if (r0 <= 0) goto L13;
        r6.readLong();
        return;
    L13:
        return;
    L8:
        r4 = null;
        goto L9
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r9 == null) goto L8;
        Class<?> r3 = r9.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L13;
        return false;
    L13:
        if (this.taskId != 0) goto L15;
        return false;
    L15:
        o.a(r9, "null cannot be cast to non-null type com.obric.livecard.api.entity.IslandSession");
        IslandSession r4 = (IslandSession) ZeusTransformUtils.preCheckCast(r9, IslandSession.class, "com.obric.aiagent.plugin");
        if (this.taskId != ((IslandSession) ZeusTransformUtils.preCheckCast(r9, IslandSession.class, "com.obric.aiagent.plugin")).taskId) goto L19;
        return true;
    L19:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public int hashCode() {
        return Long.hashCode(this.taskId);
    }

    public final void update(IslandWidget r2) {
        o.e(r2, "targetWidget");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.updateWidget(this, r2);
        return;
    }

    public final Object updateAnimation(IslandWidget r3, d<? super x> r4) {
        d<? super x> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L10;
        Object r2 = r0.updateAnimation(this, r3, r5);
        if (r2 != b.a()) goto L8;
        return r2;
    L8:
        return x.f38692a;
    L10:
        return x.f38692a;
    }

    public final void sendAnyEvent(IslandWidget r4, String r5, Object r6) {
        o.e(r4, "targetWidget");
        o.e(r5, "eventId");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r6, JsonObject.class) == false) goto L5;
        JsonObject r0 = (JsonObject) ZeusTransformUtils.preCheckCast(r6, JsonObject.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L10;
        sendEvent(r4, r5, r0);
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L13:
        if (r1 == null) goto L16;
        sendEventInner(r4, r5, r1);
        return;
    L16:
        if (r6 == null) goto L18;
        r2 = new Gson().toJson(r6);
    L18:
        sendEventInner(r4, r5, r2);
        return;
    L12:
        r1 = null;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final void sendEvent(IslandWidget r2, String r3, JsonObject r4) {
        o.e(r2, "targetWidget");
        o.e(r3, "eventId");
        if (r4 == null) goto L5;
        String r5 = r4.toString();
    L6:
        sendEventInner(r2, r3, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void updateFlags() {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.updateSessionFlags(this);
        return;
    }

    private final void sendEventInner(IslandWidget r2, String r3, String r4) {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.sendEvent(this, r2, r3, r4);
        return;
    }

    public final void setPriority(long r2) {
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 == null) goto L6;
        r0.setPriority(this, r2);
        return;
    }

    public final Object getPriority(d<? super Long> r3) {
        d<? super Long> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        IslandApi r0 = ILiveCard.Companion.getInst().getIslandService();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPriority(this, r4);
    }

    public String toString() {
        return "IslandSession(collapseWidget=" + this.collapseWidget + ", expandWidget=" + this.expandWidget + ", intent=" + this.intent + ", autoDismissDuration=" + this.autoDismissDuration + ", taskId=" + this.taskId + ", type=" + this.type + ", currWidget=" + this.currWidget + ", canFontShow=" + this.canFrontShow + ", flags=" + this.flags + ')';
    }

    @Override // com.obric.livecard.api.notification.INotificationLiveView
    public View getView() {
        IslandWidget r0 = this.expandWidget;
        o.a(r0);
        View r1 = r0.getView();
        o.a(r1);
        return r1;
    }

    @Override // com.obric.livecard.api.notification.INotificationLiveView
    public IslandWidget getWidget() {
        IslandWidget r0 = this.expandWidget;
        o.a(r0);
        return r0;
    }

    @Override // com.obric.livecard.api.notification.INotificationLiveView
    public long getWidgetId() {
        return this.taskId;
    }

    @Override // com.obric.livecard.api.notification.INotificationLiveView
    public LiveCardType getLiveCardType() {
        return this.type;
    }
}
