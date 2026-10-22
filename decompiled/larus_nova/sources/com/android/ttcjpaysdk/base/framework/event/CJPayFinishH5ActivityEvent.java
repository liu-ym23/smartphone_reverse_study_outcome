package com.android.ttcjpaysdk.base.framework.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayFinishH5ActivityEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "from", "", "(Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "isFromBullet", "", "isFromFaceH5", "isFromFaceNative", "isFromUploadId", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFinishH5ActivityEvent extends BaseEvent {
    public static final Companion Companion = null;
    public static final String ENTER_FROM_FACE_PLUS_CHECK_BULLET = "face_plus_from_bullet";
    public static final String ENTER_FROM_FACE_PLUS_CHECK_H5 = "face_plus_from_h5";
    public static final String ENTER_FROM_FACE_PLUS_CHECK_NATIVE = "face_plus_from_native";
    public static final String ENTER_FROM_PAY_NEW_CARD = "pay_new_card";
    private final String from;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/event/CJPayFinishH5ActivityEvent$Companion;", "", "()V", "ENTER_FROM_FACE_PLUS_CHECK_BULLET", "", "ENTER_FROM_FACE_PLUS_CHECK_H5", "ENTER_FROM_FACE_PLUS_CHECK_NATIVE", "ENTER_FROM_PAY_NEW_CARD", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayFinishH5ActivityEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final boolean isFromBullet() {
        return Intrinsics.areEqual(ENTER_FROM_FACE_PLUS_CHECK_BULLET, this.from);
    }

    public final boolean isFromFaceH5() {
        return Intrinsics.areEqual(ENTER_FROM_FACE_PLUS_CHECK_H5, this.from);
    }

    public final boolean isFromFaceNative() {
        return Intrinsics.areEqual(ENTER_FROM_FACE_PLUS_CHECK_NATIVE, this.from);
    }

    public final boolean isFromUploadId() {
        return Intrinsics.areEqual(ENTER_FROM_PAY_NEW_CARD, this.from);
    }

    public final String getFrom() {
        return this.from;
    }

    public CJPayFinishH5ActivityEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.from = r100;
    }

    public /* synthetic */ CJPayFinishH5ActivityEvent(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
