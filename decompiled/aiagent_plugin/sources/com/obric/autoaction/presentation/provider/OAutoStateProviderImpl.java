package com.obric.autoaction.presentation.provider;

import android.app.ActivityOptions;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AOUserInterfaceTools;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.presentation.WidgetState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: OAutoStateProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OAutoStateProviderImpl extends PluginContentProvider {
    private static final int ANDROID_API_34 = 34;
    private static final String AUTHORITY = "com.obric.assistantaiagent.OAutoStateProvider";
    public static final a Companion = null;
    private static final String DEFAULT_SOURCE_FROM = "oautoStateProvider";
    private static final String KEY_DISABLE_DOUBAO_INTERACTION = "disable_doubao_interaction";
    private static final String KEY_ERROR = "error";
    private static final String KEY_OPEN_PLAYER_PENDING_INTENT = "open_player_pending_intent";
    private static final String KEY_SOURCE_FROM = "source_from";
    private static final String METHOD_CHECK_WAITING_PROGRESS = "check_waiting_progress";
    private static final String METHOD_GET_CURRENT_STATE = "get_current_state";
    private static final String METHOD_GET_OPEN_PLAYER_PENDING_INTENT = "get_open_player_pending_intent";
    private static final String SURFACE_CARD_STARTER_ACTIVITY = "com.obric.autoaction.app.presentation.SurfaceCardStarterActivity";
    private static final String TAG = "OAutoState-Prov";
    private static final AtomicInteger pendingIntentRequestCode = null;

    /* JADX INFO: compiled from: OAutoStateProviderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(String r3) {
            o.e(r3, "reason");
            Loog.INSTANCE.i(OAutoStateProviderImpl.TAG, "notifyOAutoStateChanged for " + r3);
            ZeusProviderTransform.notifyChange(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), com.obric.autoaction.presentation.provider.a.a("content://com.obric.assistantaiagent.OAutoStateProvider"), null, "com.obric.aiagent.plugin");
        }
    }

    public int delete(Uri r1, String r2, String[] r3) {
        o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        o.e(r1, "uri");
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.e(r1, "uri");
        return 0;
    }

    public OAutoStateProviderImpl() {
    }

    static {
        Companion = new a(null);
        pendingIntentRequestCode = new AtomicInteger();
    }

    public Bundle call(String r6, String r7, Bundle r8) {
        o.e(r6, "method");
        Loog.INSTANCE.i(TAG, "called OAutoStateProvider, meth=" + r6);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        Loog.INSTANCE.w(TAG, "reject OAutoStateProvider." + r6 + " because provider context is null");
        return null;
    L7:
        if (com.obric.aiagent.utils.c.b.f22336a.a(r0, "OAutoStateProvider." + r6).a() == true) goto L9;
        return null;
    L9:
        int r1 = r6.hashCode();
        if (r1 == (-1782449886)) goto L27;
        if (r1 == (-231371338)) goto L22;
        if (r1 == (-78949834)) goto L17;
    L28:
        return null;
    L17:
        if (r6.equals(METHOD_CHECK_WAITING_PROGRESS) == false) goto L28;
        return methCheckWaitingProgress();
    L22:
        if (r6.equals(METHOD_GET_OPEN_PLAYER_PENDING_INTENT) == false) goto L28;
        return methGetOpenPlayerPendingIntent(r7, r8);
    L27:
        if (r6.equals(METHOD_GET_CURRENT_STATE) == false) goto L28;
        return methGetCurrentState();
    }

    private final Bundle methGetCurrentState() {
        Bundle r3 = new Bundle();
        r3.putString("state", b.f25106a.a().a());
        WidgetState r0 = ((GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin")).getWidgetState();
        if (r0 == null) goto L9;
        IAutoActionAgentEventListener.SessionInfo r1 = r0.getSessionInfo();
        if (r1 == null) goto L9;
        AutoOperateTask r2 = r1.getTask();
        if (r2 == null) goto L9;
        Integer r4 = Integer.valueOf(r2.getLaunchOrigin());
    L10:
        r3.putString("o_task_source", String.valueOf(r4));
        return r3;
    L9:
        r4 = null;
        goto L10
    }

    private final Bundle methCheckWaitingProgress() {
        IAutoActionAgentEventListener.SessionInfo r8 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r8 != null) goto L5;
    L7:
        r0 = false;
    L9:
        if (r0 == false) goto L11;
        AOUserInterfaceTools.showAppToast$default(AOUserInterfaceTools.INSTANCE, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.string.obric_assist_card_service_busy, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_assist_card_service_busy"), false, 4, null);
    L20:
        return null;
    L11:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IAutoActionPresentationApi r2 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r2 == null) goto L15;
        Intent r3 = r2.getOpenPlayerIntent(r1, "click_from_starter_entry");     // Catch: Throwable -> L18
    L16:
        ZeusTransformUtils.startActivity(r1, r3, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        goto L20
    L15:
        r3 = null;
    L18:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to open player", th);
        goto L20
    L5:
        if (r8.isQueued() != true) goto L7;
        goto L7
    }

    private final Bundle methGetOpenPlayerPendingIntent(String r8, Bundle r9) {
        String r1 = null;
        if (r9 == null) goto L11;
        String r3 = r9.getString(KEY_SOURCE_FROM);
        if (r3 == null) goto L11;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L11;
    L20:
        boolean r2 = false;
        if (r9 == null) goto L31;
        r2 = r9.getBoolean(KEY_DISABLE_DOUBAO_INTERACTION, false);
    L31:
        Application r10 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getHostAppContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        Intent r4 = new Intent();     // Catch: Throwable -> L25
        r4.setClassName(AOHostAppTools.INSTANCE.getHostAppPackage(), SURFACE_CARD_STARTER_ACTIVITY);     // Catch: Throwable -> L25
        r4.addFlags(268435456);     // Catch: Throwable -> L25
        r4.putExtra(KEY_SOURCE_FROM, r3);     // Catch: Throwable -> L25
        r4.putExtra(KEY_DISABLE_DOUBAO_INTERACTION, r2);     // Catch: Throwable -> L25
        Bundle r11 = new Bundle();     // Catch: Throwable -> L25
        r11.putParcelable(KEY_OPEN_PLAYER_PENDING_INTENT, (Parcelable) ZeusTransformUtils.preCheckCast(PendingIntent.getActivity((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"), pendingIntentRequestCode.getAndIncrement(), r4, 201326592, buildOpenPlayerPendingIntentOptions()), Parcelable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L25
        return r11;
    L25:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "failed to build open player pending intent", th);
        Bundle r12 = new Bundle();
        String r7 = th.getMessage();
        if (r7 != null) goto L29;
        r7 = "open player pending intent unavailable";
    L29:
        r12.putString("error", r7);
        return r12;
    L11:
        if (r8 != null) goto L13;
    L17:
        if (r1 != null) goto L19;
        r3 = DEFAULT_SOURCE_FROM;
        goto L20
    L19:
        r3 = r1;
        goto L20
    L13:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r8 = null;
    L16:
        r1 = r8;
        goto L17
    }

    private final Bundle buildOpenPlayerPendingIntentOptions() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return null;
    L5:
        ActivityOptions r6 = ActivityOptions.makeBasic();
        int r0 = ActivityOptions.class.getField("MODE_BACKGROUND_ACTIVITY_START_ALLOWED").getInt(null);
        ActivityOptions.class.getMethod("setPendingIntentCreatorBackgroundActivityStartMode", new Class[]{Integer.TYPE}).invoke(r6, new Object[]{Integer.valueOf(r0)});
        return r6.toBundle();
    }

    public boolean onCreate() {
        Loog.INSTANCE.i(TAG, "created OAutoStateProvider.");
        return true;
    }
}
