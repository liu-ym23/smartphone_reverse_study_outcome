package com.obric.autogui.common.api.space;

import android.content.Context;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.space.handusing.HandUsingConfigResult;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor;
import com.obric.autogui.common.api.space.status.SpaceStatusCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.d.a;
import d.d.b;
import d.h.b.o;
import d.x;
import java.util.Collection;

/* JADX INFO: compiled from: IOperatingSpaceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IOperatingSpaceManager {

    /* JADX INFO: compiled from: IOperatingSpaceManager.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object createSpace$default(IOperatingSpaceManager r2, Context r3, CCLifecycleListener r4, d r5, int r6, Object r7) {
            IOperatingSpaceManager r8 = (IOperatingSpaceManager) ZeusTransformUtils.wrapperContextForParams(r2, IOperatingSpaceManager.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            CCLifecycleListener r10 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r4, CCLifecycleListener.class, "com.obric.aiagent.plugin");
            d<? super OpSpaceCreationResult> r11 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 2) == 0) goto L8;
            r10 = null;
        L8:
            return r8.createSpace(r9, r10, r11);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSpace");
        }
    }

    /* JADX INFO: compiled from: IOperatingSpaceManager.kt */
    public static final class OpSpaceCreationResult {
        private final AOOperatingSpace space;
        private final Status status;

        /* JADX INFO: compiled from: IOperatingSpaceManager.kt */
        public static final enum Status extends Enum<Status> {
            private static final /* synthetic */ a $ENTRIES = null;
            private static final /* synthetic */ Status[] $VALUES = null;
            public static final Status AlreadyExist = null;
            public static final Status FailedToCreate = null;
            public static final Status Success = null;

            private static final /* synthetic */ Status[] $values() {
                return new Status[]{Success, FailedToCreate, AlreadyExist};
            }

            public static a<Status> getEntries() {
                return $ENTRIES;
            }

            private Status(String r1, int r2) {
                super(r1, r2);
            }

            static {
                Success = new Status("Success", 0);
                FailedToCreate = new Status("FailedToCreate", 1);
                AlreadyExist = new Status("AlreadyExist", 2);
                Status[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            public static Status valueOf(String r2) {
                return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.aiagent.plugin");
            }

            public static Status[] values() {
                return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.aiagent.plugin");
            }
        }

        public static /* synthetic */ OpSpaceCreationResult copy$default(OpSpaceCreationResult r1, Status r2, AOOperatingSpace r3, int r4, Object r5) {
            AOOperatingSpace r6 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = r1.status;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r6 = r1.space;
        L9:
            return r1.copy(r2, r6);
        }

        public final Status component1() {
            return this.status;
        }

        public final AOOperatingSpace component2() {
            return this.space;
        }

        public final OpSpaceCreationResult copy(Status r2, AOOperatingSpace r3) {
            AOOperatingSpace r1 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            o.e(r2, "status");
            return new OpSpaceCreationResult(r2, r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, OpSpaceCreationResult.class) == true) goto L8;
            return false;
        L8:
            OpSpaceCreationResult r6 = (OpSpaceCreationResult) ZeusTransformUtils.preCheckCast(r5, OpSpaceCreationResult.class, "com.obric.aiagent.plugin");
            if (this.status == r6.status) goto L12;
            return false;
        L12:
            if (o.a(this.space, r6.space) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.status.hashCode() * 31;
            AOOperatingSpace r1 = this.space;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "OpSpaceCreationResult(status=" + this.status + ", space=" + this.space + ')';
        }

        public OpSpaceCreationResult(Status r3, AOOperatingSpace r4) {
            AOOperatingSpace r5 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            o.e(r3, "status");
            this.status = r3;
            this.space = r5;
        }

        public final Status getStatus() {
            return this.status;
        }

        public final AOOperatingSpace getSpace() {
            return this.space;
        }
    }

    void attachMonitor(OperatingSpaceMonitor r1);

    HandUsingConfigResult configureHandUsing(Context r1, boolean r2, DisplayHost r3, HandUsingEventsCallback r4);

    void configureStatusListening(Context r1, SpaceStatusCallback r2);

    Object createSpace(Context r1, CCLifecycleListener r2, d<? super OpSpaceCreationResult> r3);

    Object destroySpace(Context r1, AOOperatingSpace r2, d<? super x> r3);

    void detachMonitor(OperatingSpaceMonitor r1);

    AOOperatingSpace getActiveSpace();

    void postDestroyAllSpaces(Context r1);

    void setGlobalDisabledApps(Collection<String> r1);

    void setMuted(boolean r1);
}
