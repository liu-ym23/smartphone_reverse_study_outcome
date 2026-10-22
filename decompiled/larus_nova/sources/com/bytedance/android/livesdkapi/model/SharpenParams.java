package com.bytedance.android.livesdkapi.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0010B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SharpenParams;", "", "legacyOption", "", "level", "operationReason", "", "(Ljava/lang/Integer;ILjava/lang/String;)V", "getLegacyOption", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLevel", "()I", "getOperationReason", "()Ljava/lang/String;", "toString", "Level", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SharpenParams {
    private final Integer legacyOption;
    private final int level;
    private final String operationReason;

    @Target({ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SharpenParams$Level;", "", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Level {
        public static final Companion Companion = null;
        public static final int GAME1 = 4;
        public static final int GAME2 = 5;
        public static final int MEDIUM = 2;
        public static final int STRONG = 3;
        public static final int UNKNOWN = -1;
        public static final int VERYWEAK = 0;
        public static final int WEAK = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/SharpenParams$Level$Companion;", "", "()V", "GAME1", "", "GAME2", "MEDIUM", "STRONG", "UNKNOWN", "VERYWEAK", "WEAK", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int GAME1 = 4;
            public static final int GAME2 = 5;
            public static final int MEDIUM = 2;
            public static final int STRONG = 3;
            public static final int UNKNOWN = -1;
            public static final int VERYWEAK = 0;
            public static final int WEAK = 1;

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

    public SharpenParams() {
        this(null, 0, null, 7, null);
    }

    public String toString() {
        return "SharpenParams(legacyOption=" + this.legacyOption + ", level=" + this.level + ", operationReason=" + this.operationReason + ')';
    }

    public final Integer getLegacyOption() {
        return this.legacyOption;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getOperationReason() {
        return this.operationReason;
    }

    public SharpenParams(Integer r100, int r101, String r102) {
        this.legacyOption = r100;
        this.level = r101;
        this.operationReason = r102;
    }

    public /* synthetic */ SharpenParams(Integer r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
