package com.bytedance.android.livesdkapi.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/P2PSuggestInfo;", "", "triggerType", "", "suggestStatus", "(II)V", "getSuggestStatus", "()I", "getTriggerType", "setTriggerType", "(I)V", "toString", "", "TriggerType", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class P2PSuggestInfo {
    private final int suggestStatus;
    private int triggerType;

    @Target({ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/P2PSuggestInfo$TriggerType;", "", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface TriggerType {
        public static final Companion Companion = null;
        public static final int UNKNOWN = -1;
        public static final int WORMHOLE = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/P2PSuggestInfo$TriggerType$Companion;", "", "()V", "UNKNOWN", "", "WORMHOLE", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int UNKNOWN = -1;
            public static final int WORMHOLE = 1;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    public String toString() {
        return "P2PSuggestInfo(triggerType=" + this.triggerType + ", suggestStatus=" + this.suggestStatus + ')';
    }

    public final int getSuggestStatus() {
        return this.suggestStatus;
    }

    public final int getTriggerType() {
        return this.triggerType;
    }

    public final void setTriggerType(int r100) {
        this.triggerType = r100;
    }

    public P2PSuggestInfo(int r100, int r101) {
        this.triggerType = r100;
        this.suggestStatus = r101;
    }
}
