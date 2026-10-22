package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/chatroom/event/AddPictureEvent;", "", "state", "", "(I)V", "getState", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddPictureEvent {
    public static final Companion Companion = null;
    public static final int STATE_CLOSE = 2;
    public static final int STATE_OPEN = 1;
    private final int state;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/chatroom/event/AddPictureEvent$Companion;", "", "()V", "STATE_CLOSE", "", "STATE_OPEN", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public static /* synthetic */ AddPictureEvent copy$default(AddPictureEvent r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.state;
    }

    public final AddPictureEvent copy(int r100) {
        return new AddPictureEvent(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AddPictureEvent) == true) goto L6;
        return false;
    L6:
        if (this.state == ((AddPictureEvent) r100).state) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.state;
    }

    public String toString() {
        return "AddPictureEvent(state=" + this.state + ")";
    }

    public final int getState() {
        return this.state;
    }

    public AddPictureEvent(int r100) {
        this.state = r100;
    }
}
