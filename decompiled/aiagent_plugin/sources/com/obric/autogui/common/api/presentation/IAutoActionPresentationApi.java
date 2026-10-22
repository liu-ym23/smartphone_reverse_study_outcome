package com.obric.autogui.common.api.presentation;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.h.a.b;
import d.h.a.m;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: IAutoActionPresentationApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionPresentationApi {

    /* JADX INFO: compiled from: IAutoActionPresentationApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Intent getOpenLauncherPageIntent$default(IAutoActionPresentationApi r2, Context r3, String r4, String r5, String r6, int r7, Object r8) {
            IAutoActionPresentationApi r9 = (IAutoActionPresentationApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L16;
            if ((r7 & 2) == 0) goto L8;
            r4 = null;
        L8:
            if ((r7 & 4) == 0) goto L11;
            r5 = null;
        L11:
            if ((r7 & 8) == 0) goto L14;
            r6 = null;
        L14:
            return r9.getOpenLauncherPageIntent(r10, r4, r5, r6);
        L16:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOpenLauncherPageIntent");
        }

        public static /* synthetic */ Intent getOpenPlayerIntent$default(IAutoActionPresentationApi r2, Context r3, String r4, int r5, Object r6) {
            IAutoActionPresentationApi r7 = (IAutoActionPresentationApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L10;
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            return r7.getOpenPlayerIntent(r8, r4);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOpenPlayerIntent");
        }

        public static /* synthetic */ void openPlayer$default(IAutoActionPresentationApi r2, Context r3, String r4, b r5, int r6, Object r7) {
            IAutoActionPresentationApi r8 = (IAutoActionPresentationApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            b<? super Intent, x> r10 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 2) == 0) goto L8;
            r4 = null;
        L8:
            if ((r6 & 4) == 0) goto L10;
            r10 = null;
        L10:
            r8.openPlayer(r9, r4, r10);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openPlayer");
        }

        public static /* synthetic */ Dialog openGlobalInputDialog$default(IAutoActionPresentationApi r15, Context r16, Integer r17, String r18, String r19, m r20, m r21, String r22, String r23, String r24, String r25, MemoryKey r26, int r27, Object r28) {
            IAutoActionPresentationApi r3 = (IAutoActionPresentationApi) ZeusTransformUtils.wrapperContextForParams(r15, IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.aiagent.plugin");
            m<? super String, ? super String, x> r8 = (m) ZeusTransformUtils.wrapperContextForParams(r20, m.class, "com.obric.aiagent.plugin");
            m<? super String, ? super String, x> r9 = (m) ZeusTransformUtils.wrapperContextForParams(r21, m.class, "com.obric.aiagent.plugin");
            if (r28 != null) goto L27;
            if ((r27 & 64) == 0) goto L7;
            String r10 = null;
        L9:
            if ((r27 & 128) == 0) goto L11;
            String r11 = null;
        L13:
            if ((r27 & 256) == 0) goto L15;
            String r12 = null;
        L17:
            if ((r27 & 512) == 0) goto L19;
            String r13 = null;
        L21:
            if ((r27 & 1024) == 0) goto L23;
            MemoryKey r14 = null;
        L25:
            return r3.openGlobalInputDialog(r4, r17, r18, r19, r8, r9, r10, r11, r12, r13, r14);
        L23:
            r14 = r26;
            goto L25
        L19:
            r13 = r25;
            goto L21
        L15:
            r12 = r24;
            goto L17
        L11:
            r11 = r23;
            goto L13
        L7:
            r10 = r22;
            goto L9
        L27:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openGlobalInputDialog");
        }

        public static /* synthetic */ void openShortCutDetailsPage$default(IAutoActionPresentationApi r8, Context r9, String r10, String r11, String r12, AssistRemoteCardUIParams r13, int r14, Object r15) {
            IAutoActionPresentationApi r2 = (IAutoActionPresentationApi) ZeusTransformUtils.wrapperContextForParams(r8, IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L19;
            if ((r14 & 4) == 0) goto L7;
            String r5 = null;
        L9:
            if ((r14 & 8) == 0) goto L11;
            String r6 = null;
        L13:
            if ((r14 & 16) == 0) goto L15;
            AssistRemoteCardUIParams r7 = null;
        L16:
            r2.openShortCutDetailsPage(r3, r10, r5, r6, r7);
            return;
        L15:
            r7 = r13;
            goto L16
        L11:
            r6 = r12;
            goto L13
        L7:
            r5 = r11;
            goto L9
        L19:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openShortCutDetailsPage");
        }
    }

    /* JADX INFO: compiled from: IAutoActionPresentationApi.kt */
    public interface IStreamingReplyDisplayingChannel {
        void pushThought(String r1);

        void thoughtEnd();
    }

    /* JADX INFO: compiled from: IAutoActionPresentationApi.kt */
    public static final class MemoryKey {
        private final String category;
        private final String key;

        public static /* synthetic */ MemoryKey copy$default(MemoryKey r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.category;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.key;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.category;
        }

        public final String component2() {
            return this.key;
        }

        public final MemoryKey copy(String r1, String r2) {
            o.e(r1, "category");
            o.e(r2, "key");
            return new MemoryKey(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MemoryKey.class) == true) goto L8;
            return false;
        L8:
            MemoryKey r6 = (MemoryKey) ZeusTransformUtils.preCheckCast(r5, MemoryKey.class, "com.obric.aiagent.plugin");
            if (o.a(this.category, r6.category) == true) goto L12;
            return false;
        L12:
            if (o.a(this.key, r6.key) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.category.hashCode() * 31) + this.key.hashCode();
        }

        public String toString() {
            return "MemoryKey(category=" + this.category + ", key=" + this.key + ')';
        }

        public MemoryKey(String r2, String r3) {
            o.e(r2, "category");
            o.e(r3, "key");
            this.category = r2;
            this.key = r3;
        }

        public final String getCategory() {
            return this.category;
        }

        public final String getKey() {
            return this.key;
        }
    }

    /* JADX INFO: compiled from: IAutoActionPresentationApi.kt */
    public static final enum PlayerVisibility extends Enum<PlayerVisibility> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ PlayerVisibility[] $VALUES = null;
        public static final PlayerVisibility Invisible = null;
        public static final PlayerVisibility Visible = null;

        private static final /* synthetic */ PlayerVisibility[] $values() {
            return new PlayerVisibility[]{Visible, Invisible};
        }

        public static a<PlayerVisibility> getEntries() {
            return $ENTRIES;
        }

        private PlayerVisibility(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Visible = new PlayerVisibility("Visible", 0);
            Invisible = new PlayerVisibility("Invisible", 1);
            PlayerVisibility[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static PlayerVisibility valueOf(String r2) {
            return (PlayerVisibility) ZeusTransformUtils.preCheckCast(Enum.valueOf(PlayerVisibility.class, r2), PlayerVisibility.class, "com.obric.aiagent.plugin");
        }

        public static PlayerVisibility[] values() {
            return (PlayerVisibility[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PlayerVisibility[].class, "com.obric.aiagent.plugin");
        }
    }

    void doActionOnFloatingWindowService(Context r1, String r2, Bundle r3);

    void enterAssistInputMode();

    void exitAssistInputMode();

    void exitClarifyStateInSurfaceActivity(String r1);

    Activity getCurrentShowingPlayer();

    Intent getOpenLauncherPageIntent(Context r1, String r2, String r3, String r4);

    Intent getOpenPlayerIntent(Context r1, String r2);

    PlayerVisibility getPlayerVisibility(Context r1);

    void initGui(Context r1);

    void notifyAssistCardUpdate(AssistRemoteCardUIParams r1);

    Dialog openGlobalInputDialog(Context r1, Integer r2, String r3, String r4, m<? super String, ? super String, x> r5, m<? super String, ? super String, x> r6, String r7, String r8, String r9, String r10, MemoryKey r11);

    void openPlayer(Context r1, String r2, b<? super Intent, x> r3);

    void openSharingWebView(Context r1, String r2, String r3, String r4);

    void openShortCutDetailsPage(Context r1, String r2, String r3, String r4, AssistRemoteCardUIParams r5);

    IStreamingReplyDisplayingChannel openStreamingReplyChannel();

    void openTaskListPage(Context r1, String r2, String r3);

    void postTestRunTask(String r1);

    void postTestRunTaskWithQuery(String r1);

    void stopFloatingWindowService(Context r1);
}
