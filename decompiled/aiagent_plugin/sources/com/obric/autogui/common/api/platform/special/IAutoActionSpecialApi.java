package com.obric.autogui.common.api.platform.special;

import android.app.TaskInfo;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.obric.aiagent.product.platform.api.notification.ObricToastShowListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.d.a;
import d.d.b;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IAutoActionSpecialApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionSpecialApi {

    /* JADX INFO: compiled from: IAutoActionSpecialApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ ScreenShotTickToken registerScreenShotTick$default(IAutoActionSpecialApi r2, String r3, int r4, String r5, int r6, Object r7) {
            IAutoActionSpecialApi r8 = (IAutoActionSpecialApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionSpecialApi.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 2) == 0) goto L8;
            r4 = 0;
        L8:
            if ((r6 & 4) == 0) goto L11;
            r5 = null;
        L11:
            return r8.registerScreenShotTick(r3, r4, r5);
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerScreenShotTick");
        }

        public static /* synthetic */ Object awaitScreenShotTick$default(IAutoActionSpecialApi r2, ScreenShotTickToken r3, long r4, d r6, int r7, Object r8) {
            IAutoActionSpecialApi r5 = (IAutoActionSpecialApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionSpecialApi.class, "com.obric.aiagent.plugin");
            d<? super ScreenShotTickResult> r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L10;
            if ((r7 & 2) == 0) goto L8;
            r4 = 1000;
        L8:
            return r5.awaitScreenShotTick(r3, r4, r9);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitScreenShotTick");
        }
    }

    /* JADX INFO: compiled from: IAutoActionSpecialApi.kt */
    public static final class ScreenShotTickResult {
        private final long durationMillis;
        private final String packageName;
        private final int paramInt;
        private final String paramString;
        private final long registerToAwaitDurationMillis;
        private final int requestId;
        private final ScreenShotTickStatus status;

        public static /* synthetic */ ScreenShotTickResult copy$default(ScreenShotTickResult r10, ScreenShotTickStatus r11, long r12, long r14, int r16, String r17, int r18, String r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            ScreenShotTickStatus r1 = r10.status;
        L7:
            if ((r20 & 2) == 0) goto L9;
            long r2 = r10.registerToAwaitDurationMillis;
        L11:
            if ((r20 & 4) == 0) goto L13;
            long r4 = r10.durationMillis;
        L15:
            if ((r20 & 8) == 0) goto L17;
            int r6 = r10.requestId;
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r7 = r10.packageName;
        L23:
            if ((r20 & 32) == 0) goto L25;
            int r8 = r10.paramInt;
        L27:
            if ((r20 & 64) == 0) goto L29;
            String r9 = r10.paramString;
        L31:
            return r10.copy(r1, r2, r4, r6, r7, r8, r9);
        L29:
            r9 = r19;
            goto L31
        L25:
            r8 = r18;
            goto L27
        L21:
            r7 = r17;
            goto L23
        L17:
            r6 = r16;
            goto L19
        L13:
            r4 = r14;
            goto L15
        L9:
            r2 = r12;
            goto L11
        L5:
            r1 = r11;
            goto L7
        }

        public final ScreenShotTickStatus component1() {
            return this.status;
        }

        public final long component2() {
            return this.registerToAwaitDurationMillis;
        }

        public final long component3() {
            return this.durationMillis;
        }

        public final int component4() {
            return this.requestId;
        }

        public final String component5() {
            return this.packageName;
        }

        public final int component6() {
            return this.paramInt;
        }

        public final String component7() {
            return this.paramString;
        }

        public final ScreenShotTickResult copy(ScreenShotTickStatus r12, long r13, long r15, int r17, String r18, int r19, String r20) {
            o.e(r12, "status");
            o.e(r18, "packageName");
            return new ScreenShotTickResult(r12, r13, r15, r17, r18, r19, r20);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, ScreenShotTickResult.class) == true) goto L8;
            return false;
        L8:
            ScreenShotTickResult r10 = (ScreenShotTickResult) ZeusTransformUtils.preCheckCast(r9, ScreenShotTickResult.class, "com.obric.aiagent.plugin");
            if (this.status == r10.status) goto L12;
            return false;
        L12:
            if (this.registerToAwaitDurationMillis == r10.registerToAwaitDurationMillis) goto L15;
            return false;
        L15:
            if (this.durationMillis == r10.durationMillis) goto L18;
            return false;
        L18:
            if (this.requestId == r10.requestId) goto L21;
            return false;
        L21:
            if (o.a(this.packageName, r10.packageName) == true) goto L24;
            return false;
        L24:
            if (this.paramInt == r10.paramInt) goto L27;
            return false;
        L27:
            if (o.a(this.paramString, r10.paramString) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((this.status.hashCode() * 31) + Long.hashCode(this.registerToAwaitDurationMillis)) * 31) + Long.hashCode(this.durationMillis)) * 31) + Integer.hashCode(this.requestId)) * 31) + this.packageName.hashCode()) * 31) + Integer.hashCode(this.paramInt)) * 31;
            String r3 = this.paramString;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r0 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public String toString() {
            return "ScreenShotTickResult(status=" + this.status + ", registerToAwaitDurationMillis=" + this.registerToAwaitDurationMillis + ", durationMillis=" + this.durationMillis + ", requestId=" + this.requestId + ", packageName=" + this.packageName + ", paramInt=" + this.paramInt + ", paramString=" + this.paramString + ')';
        }

        public ScreenShotTickResult(ScreenShotTickStatus r2, long r3, long r5, int r7, String r8, int r9, String r10) {
            o.e(r2, "status");
            o.e(r8, "packageName");
            this.status = r2;
            this.registerToAwaitDurationMillis = r3;
            this.durationMillis = r5;
            this.requestId = r7;
            this.packageName = r8;
            this.paramInt = r9;
            this.paramString = r10;
        }

        public final ScreenShotTickStatus getStatus() {
            return this.status;
        }

        public final long getRegisterToAwaitDurationMillis() {
            return this.registerToAwaitDurationMillis;
        }

        public final long getDurationMillis() {
            return this.durationMillis;
        }

        public final int getRequestId() {
            return this.requestId;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final int getParamInt() {
            return this.paramInt;
        }

        public final String getParamString() {
            return this.paramString;
        }
    }

    /* JADX INFO: compiled from: IAutoActionSpecialApi.kt */
    public static final enum ScreenShotTickStatus extends Enum<ScreenShotTickStatus> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ ScreenShotTickStatus[] $VALUES = null;
        public static final ScreenShotTickStatus Error = null;
        public static final ScreenShotTickStatus NotSupported = null;
        public static final ScreenShotTickStatus Ready = null;
        public static final ScreenShotTickStatus Timeout = null;

        private static final /* synthetic */ ScreenShotTickStatus[] $values() {
            return new ScreenShotTickStatus[]{Ready, NotSupported, Timeout, Error};
        }

        public static a<ScreenShotTickStatus> getEntries() {
            return $ENTRIES;
        }

        private ScreenShotTickStatus(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Ready = new ScreenShotTickStatus("Ready", 0);
            NotSupported = new ScreenShotTickStatus("NotSupported", 1);
            Timeout = new ScreenShotTickStatus("Timeout", 2);
            Error = new ScreenShotTickStatus("Error", 3);
            ScreenShotTickStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static ScreenShotTickStatus valueOf(String r2) {
            return (ScreenShotTickStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(ScreenShotTickStatus.class, r2), ScreenShotTickStatus.class, "com.obric.aiagent.plugin");
        }

        public static ScreenShotTickStatus[] values() {
            return (ScreenShotTickStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ScreenShotTickStatus[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IAutoActionSpecialApi.kt */
    public static final class ScreenShotTickToken {
        private final String packageName;
        private final int requestId;

        public static /* synthetic */ ScreenShotTickToken copy$default(ScreenShotTickToken r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.requestId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.packageName;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.requestId;
        }

        public final String component2() {
            return this.packageName;
        }

        public final ScreenShotTickToken copy(int r1, String r2) {
            o.e(r2, "packageName");
            return new ScreenShotTickToken(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ScreenShotTickToken.class) == true) goto L8;
            return false;
        L8:
            ScreenShotTickToken r6 = (ScreenShotTickToken) ZeusTransformUtils.preCheckCast(r5, ScreenShotTickToken.class, "com.obric.aiagent.plugin");
            if (this.requestId == r6.requestId) goto L12;
            return false;
        L12:
            if (o.a(this.packageName, r6.packageName) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.requestId) * 31) + this.packageName.hashCode();
        }

        public String toString() {
            return "ScreenShotTickToken(requestId=" + this.requestId + ", packageName=" + this.packageName + ')';
        }

        public ScreenShotTickToken(int r2, String r3) {
            o.e(r3, "packageName");
            this.requestId = r2;
            this.packageName = r3;
        }

        public final int getRequestId() {
            return this.requestId;
        }

        public final String getPackageName() {
            return this.packageName;
        }
    }

    void addOAutoPrimaryClipChangedListener(Context r1, ClipboardManager.OnPrimaryClipChangedListener r2);

    boolean addToastShowListener(ObricToastShowListener r1);

    Object awaitScreenShotTick(ScreenShotTickToken r1, long r2, d<? super ScreenShotTickResult> r4);

    void clearOAutoPrimaryClip(Context r1);

    boolean configureHandUsing(boolean r1);

    void configureVDBackNavigationListener(VDBackNavListener r1);

    ClipData getOAutoPrimaryClip(Context r1);

    List<TaskInfo> getTasks(int r1, boolean r2, boolean r3, int r4);

    Boolean isAutoActionTopActivityInSystemAnimation();

    boolean isAutoImeReady();

    ActionSystemAnimationMonitor registerActionSystemAnimationMonitor(String r1);

    ScreenShotTickToken registerScreenShotTick(String r1, int r2, String r3);

    void removeOAutoPrimaryClipChangedListener(Context r1, ClipboardManager.OnPrimaryClipChangedListener r2);

    boolean removeTask(int r1);

    boolean removeToastShowListener(ObricToastShowListener r1);

    void reportOAutoEventToCM(int r1, int r2, int r3, String r4);

    void setOAutoClipdataToUser(Context r1);

    void tryToMuteVD(boolean r1);
}
