package com.obric.autogui.common.api.assistant;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.d;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: AssistantAbilityHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistantAbilityHelper {
    private static final Uri CONTENT_URI = null;
    public static final AssistantAbilityHelper INSTANCE = null;
    private static final String SCREENSHOT_EXCLUDE_TRACE = "ScreenshotExcludeTrace";
    private static final String TAG = "AssistantAbilityHelper";
    private static final String kAssistantPkg = "com.larus.nova";
    private static final String[] mAssistantActivityNames = null;
    private static AssistantPrivacyApprovalHelper mAssistantPrivacyApprovalHelper;

    /* JADX INFO: compiled from: AssistantAbilityHelper.kt */
    public static final class ChatPageState {
        private final boolean appIsForeground;
        private final boolean isChatWindow;
        private final boolean isFullScreen;
        private final boolean isInChatPage;
        private final boolean isMainConversation;

        public ChatPageState() {
            this(false, false, false, false, false, 31, null);
        }

        public static /* synthetic */ ChatPageState copy$default(ChatPageState r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.appIsForeground;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.isInChatPage;
        L8:
            boolean r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.isMainConversation;
        L11:
            boolean r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.isChatWindow;
        L14:
            boolean r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.isFullScreen;
        L17:
            boolean r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final boolean component1() {
            return this.appIsForeground;
        }

        public final boolean component2() {
            return this.isInChatPage;
        }

        public final boolean component3() {
            return this.isMainConversation;
        }

        public final boolean component4() {
            return this.isChatWindow;
        }

        public final boolean component5() {
            return this.isFullScreen;
        }

        public final ChatPageState copy(boolean r7, boolean r8, boolean r9, boolean r10, boolean r11) {
            return new ChatPageState(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ChatPageState.class) == true) goto L8;
            return false;
        L8:
            ChatPageState r6 = (ChatPageState) ZeusTransformUtils.preCheckCast(r5, ChatPageState.class, "com.obric.aiagent.plugin");
            if (this.appIsForeground == r6.appIsForeground) goto L12;
            return false;
        L12:
            if (this.isInChatPage == r6.isInChatPage) goto L15;
            return false;
        L15:
            if (this.isMainConversation == r6.isMainConversation) goto L18;
            return false;
        L18:
            if (this.isChatWindow == r6.isChatWindow) goto L21;
            return false;
        L21:
            if (this.isFullScreen == r6.isFullScreen) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.appIsForeground) * 31) + Boolean.hashCode(this.isInChatPage)) * 31) + Boolean.hashCode(this.isMainConversation)) * 31) + Boolean.hashCode(this.isChatWindow)) * 31) + Boolean.hashCode(this.isFullScreen);
        }

        public String toString() {
            return "ChatPageState(appIsForeground=" + this.appIsForeground + ", isInChatPage=" + this.isInChatPage + ", isMainConversation=" + this.isMainConversation + ", isChatWindow=" + this.isChatWindow + ", isFullScreen=" + this.isFullScreen + ')';
        }

        public ChatPageState(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
            this.appIsForeground = r1;
            this.isInChatPage = r2;
            this.isMainConversation = r3;
            this.isChatWindow = r4;
            this.isFullScreen = r5;
        }

        public /* synthetic */ ChatPageState(boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, int r7, h r8) {
            if ((r7 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r4 = false;
        L12:
            if ((r7 & 8) == 0) goto L15;
            r5 = false;
        L15:
            if ((r7 & 16) == 0) goto L17;
            r6 = false;
        L17:
            this(r2, r3, r4, r5, r6);
        }

        public final boolean getAppIsForeground() {
            return this.appIsForeground;
        }

        public final boolean isInChatPage() {
            return this.isInChatPage;
        }

        public final boolean isMainConversation() {
            return this.isMainConversation;
        }

        public final boolean isChatWindow() {
            return this.isChatWindow;
        }

        public final boolean isFullScreen() {
            return this.isFullScreen;
        }
    }

    /* JADX INFO: compiled from: AssistantAbilityHelper.kt */
    public static final class MemorySettingConfig {
        private final boolean oUseMemory;
        private final boolean personalInfoMemory;

        public MemorySettingConfig() {
            boolean r0 = false;
            this(r0, r0, 3, null);
        }

        public static /* synthetic */ MemorySettingConfig copy$default(MemorySettingConfig r0, boolean r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.oUseMemory;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.personalInfoMemory;
        L9:
            return r0.copy(r1, r2);
        }

        public final boolean component1() {
            return this.oUseMemory;
        }

        public final boolean component2() {
            return this.personalInfoMemory;
        }

        public final MemorySettingConfig copy(boolean r1, boolean r2) {
            return new MemorySettingConfig(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, MemorySettingConfig.class) == true) goto L8;
            return false;
        L8:
            MemorySettingConfig r6 = (MemorySettingConfig) ZeusTransformUtils.preCheckCast(r5, MemorySettingConfig.class, "com.obric.aiagent.plugin");
            if (this.oUseMemory == r6.oUseMemory) goto L12;
            return false;
        L12:
            if (this.personalInfoMemory == r6.personalInfoMemory) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.oUseMemory) * 31) + Boolean.hashCode(this.personalInfoMemory);
        }

        public String toString() {
            return "MemorySettingConfig(oUseMemory=" + this.oUseMemory + ", personalInfoMemory=" + this.personalInfoMemory + ')';
        }

        public MemorySettingConfig(boolean r1, boolean r2) {
            this.oUseMemory = r1;
            this.personalInfoMemory = r2;
        }

        public /* synthetic */ MemorySettingConfig(boolean r2, boolean r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = false;
        L8:
            this(r2, r3);
        }

        public final boolean getOUseMemory() {
            return this.oUseMemory;
        }

        public final boolean getPersonalInfoMemory() {
            return this.personalInfoMemory;
        }
    }

    public final String getAssistantPkg() {
        return "com.larus.nova";
    }

    private AssistantAbilityHelper() {
    }

    static {
        INSTANCE = new AssistantAbilityHelper();
        Uri r0 = Uri.parse("content://com.obric.assistant.provider.AssistantHybridAbilityProvider");
        o.c(r0, "parse(...)");
        CONTENT_URI = r0;
        mAssistantActivityNames = new String[]{"com.larus.bmhome.chat.ChatActivity", "com.larus.home.obric.ObricChatActivity"};
    }

    public final boolean isLogin(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        AssistantAbilityHelper r8 = (AssistantAbilityHelper) ZeusTransformUtils.preCheckCast(this, AssistantAbilityHelper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Bundle r11 = ZeusProviderTransform.call(r10.getContentResolver(), CONTENT_URI, "is_login", null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        boolean r12 = r11.getBoolean("is_login");     // Catch: Throwable -> L9
    L7:
        Object r13 = n.f(Boolean.valueOf(r12));     // Catch: Throwable -> L9
    L11:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L15;
        ILogDepend.Companion.w(TAG, "isLogin error: " + r14.getMessage(), r14);
    L15:
        if (n.b(r13) == false) goto L18;
        r13 = false;
    L18:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        r12 = false;
    L9:
        th = move-exception;
        n.a r15 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L11
    }

    public final boolean openLogin(Context r9, String r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "context");
        o.e(r10, "packageName");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        AssistantAbilityHelper r8 = (AssistantAbilityHelper) ZeusTransformUtils.preCheckCast(this, AssistantAbilityHelper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        ContentResolver r3 = r11.getContentResolver();     // Catch: Throwable -> L5
        Uri r4 = CONTENT_URI;     // Catch: Throwable -> L5
        Bundle r6 = new Bundle();     // Catch: Throwable -> L5
        r6.putString("packageName", r10);     // Catch: Throwable -> L5
        x r12 = x.f38692a;     // Catch: Throwable -> L5
        ZeusProviderTransform.call(r3, r4, "open_login", null, r6, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r13 = n.f(true);     // Catch: Throwable -> L5
    L7:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L11;
        ILogDepend.Companion.w(TAG, "openLogin error: " + r14.getMessage(), r14);
    L11:
        if (n.b(r13) == false) goto L14;
        r13 = false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r15 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L7
    }

    public final ChatPageState queryChatPageState(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L21
        AssistantAbilityHelper r12 = (AssistantAbilityHelper) ZeusTransformUtils.preCheckCast(this, AssistantAbilityHelper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Bundle r15 = ZeusProviderTransform.call(r14.getContentResolver(), CONTENT_URI, "query_chat_page_state", null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r15 == null) goto L6;
        boolean r3 = r15.getBoolean("app_is_foreground");     // Catch: Throwable -> L21
    L7:
        if (r15 == null) goto L9;
        boolean r4 = r15.getBoolean("is_in_chat_page");     // Catch: Throwable -> L21
    L10:
        if (r15 == null) goto L12;
        boolean r5 = r15.getBoolean("is_main_conversation");     // Catch: Throwable -> L21
    L13:
        if (r15 == null) goto L15;
        boolean r6 = r15.getBoolean("is_chat_window");     // Catch: Throwable -> L21
    L16:
        if (r15 == null) goto L18;
        boolean r7 = r15.getBoolean("is_full_screen");     // Catch: Throwable -> L21
    L19:
        Object r16 = n.f(new ChatPageState(r3, r4, r5, r6, r7));     // Catch: Throwable -> L21
    L23:
        Throwable r17 = n.c(r16);
        if (r17 == null) goto L26;
        ILogDepend.Companion.w(TAG, "queryChatPageState error: " + r17.getMessage(), r17);
    L26:
        ChatPageState r18 = new ChatPageState(false, false, false, false, false, 31, null);
        if (n.b(r16) == false) goto L30;
        r16 = r18;
    L30:
        return (ChatPageState) ZeusTransformUtils.preCheckCast(r16, ChatPageState.class, "com.obric.aiagent.plugin");
    L18:
        r7 = false;
        goto L19
    L15:
        r6 = false;
        goto L16
    L12:
        r5 = false;
        goto L13
    L9:
        r4 = false;
        goto L10
    L6:
        r3 = false;
    L21:
        th = move-exception;
        n.a r19 = n.f38560a;
        r16 = n.f(d.o.a(th));
        goto L23
    }

    public final MemorySettingConfig queryMemorySettingConfig(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        boolean r0 = false;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L12
        AssistantAbilityHelper r8 = (AssistantAbilityHelper) ZeusTransformUtils.preCheckCast(this, AssistantAbilityHelper.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Bundle r11 = ZeusProviderTransform.call(r10.getContentResolver(), CONTENT_URI, "query_memory_setting_config", null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r11 == null) goto L6;
        boolean r3 = r11.getBoolean("o_use_memory");     // Catch: Throwable -> L12
    L7:
        if (r11 == null) goto L9;
        boolean r12 = r11.getBoolean("personal_info_memory");     // Catch: Throwable -> L12
    L10:
        Object r13 = n.f(new MemorySettingConfig(r3, r12));     // Catch: Throwable -> L12
    L14:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L17;
        ILogDepend.Companion.w(TAG, "queryMemorySettingConfig error: " + r14.getMessage(), r14);
    L17:
        MemorySettingConfig r15 = new MemorySettingConfig(r0, r0, 3, null);
        if (n.b(r13) == false) goto L21;
        r13 = r15;
    L21:
        return (MemorySettingConfig) ZeusTransformUtils.preCheckCast(r13, MemorySettingConfig.class, "com.obric.aiagent.plugin");
    L9:
        r12 = false;
        goto L10
    L6:
        r3 = false;
    L12:
        th = move-exception;
        n.a r16 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L14
    }

    public final List<String> getScreenshotExcludingPackages(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        List<String> r5 = p.b(new String[]{r3.getPackageName(), "com.larus.nova"});
        Loog.INSTANCE.i(TAG, "ScreenshotExcludeTrace getScreenshotExcludingPackages contextPackage=" + r3.getPackageName() + ", assistantPackage=com.larus.nova");
        return r5;
    }

    public final boolean isChatPageInVD() {
        ComponentName r2 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        String r3 = r2.getPackageName();
    L7:
        if (o.a(r3, "com.larus.nova") == true) goto L10;
        return false;
    L10:
        return true;
    L5:
        r3 = null;
        goto L7
    }

    public final IAutoActionPermissionApi.PermissionCheckResult checkAssistantPermission(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "permName");
        IAutoActionPermissionApi r4 = AOPlatformTools.INSTANCE.permission();
        if (r4 != null) goto L7;
        return new IAutoActionPermissionApi.PermissionCheckResult(false, false, "no-perm-api");
    L7:
        return r4.checkPermission(r1, "com.larus.nova", r3);
    }

    public final void initPrivacyApproval(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        AssistantPrivacyApprovalHelper r4 = new AssistantPrivacyApprovalHelper();
        r4.init(r2);     // Catch: Throwable -> L6
        mAssistantPrivacyApprovalHelper = r4;
        return;
    L6:
        th = move-exception;
        Loog.INSTANCE.w(TAG, "initAssistantPrivacyApprovalHelper error: " + th.getMessage(), th);
    }

    public final AssistantPrivacyApprovalStatus checkPrivacyApproval(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        AssistantPrivacyApprovalHelper r3 = mAssistantPrivacyApprovalHelper;
        if (r3 != null) goto L7;
        Loog.INSTANCE.e(TAG, "checkAssistantPrivacyApproved: helper is null");
        return AssistantPrivacyApprovalStatus.CannotObtain;
    L7:
        return r3.checkApproval(r1);
    }

    public final Object checkPrivacyApprovalAsync(Context r2, d<? super AssistantPrivacyApprovalStatus> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d<? super AssistantPrivacyApprovalStatus> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        AssistantPrivacyApprovalHelper r5 = mAssistantPrivacyApprovalHelper;
        if (r5 != null) goto L7;
        Loog.INSTANCE.e(TAG, "checkAssistantPrivacyApproved: helper is null");
        return AssistantPrivacyApprovalStatus.CannotObtain;
    L7:
        return r5.checkApprovalAsync(r1, r4);
    }
}
