package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.l9;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes8.dex */
public interface IWidget extends q46.a, LifecycleOwnerCompat {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.IWidget$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static String $default$getLogTag(IWidget r100) {
            return r100.getClass().getName();
        }

        public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_chatroom_viewmodule_IWidget_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l9 r100) {
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r100);
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L7:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
        }

        public static void $default$logThrowable(IWidget r100, Throwable r101) {
            ALogger.stacktrace(6, r100.getLogTag(), r101.getStackTrace());
            LocalTestManager.a(new Class[]{wy.a.class});
        }

        public static void INVOKEINTERFACE_com_bytedance_android_livesdk_chatroom_viewmodule_IWidget_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r100, View r101, ViewGroup.LayoutParams r102) {
            WindowManagerLancet.bindToAssistantWindowIfNeeded(r101, r102);
            r100.addView(r101, r102);
        }

        public static /* synthetic */ void lambda$logThrowable$0(WindowManager r100, View r101, View r102) {
            r100.removeView(r101);
        }
    }

    Context getContext();

    DataCenter getDataCenter();

    String getLogTag();
}
