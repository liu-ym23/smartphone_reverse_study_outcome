package com.obric.aivoice.core;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import com.obric.aivoice.AIVoiceBinder;
import com.obric.aivoice.AIVoiceListener;
import com.obric.aivoice.core.conn.ClientServiceConn;
import com.obric.aivoice.core.data.BundleExtKt;
import com.obric.aivoice.core.data.IdlKeys;
import com.obric.aivoice.core.log.AIVoiceLog;
import com.obric.aivoice.sdk.AIVoiceConfig;
import com.obric.aivoice.sdk.FileAsrTaskListener;
import com.obric.aivoice.sdk.IConnectListener;
import com.obric.aivoice.sdk.IOfflineServerListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIVoiceManagerInner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012J\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\"\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0010J\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J\b\u0010,\u001a\u00020\u001aH\u0002J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u000e\u00100\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020.J\u0016\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u0016\u00107\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/aivoice/core/AIVoiceManagerInner;", "", "()V", "TAG", "", "aiVoiceConfig", "Lcom/obric/aivoice/sdk/AIVoiceConfig;", "getAiVoiceConfig", "()Lcom/obric/aivoice/sdk/AIVoiceConfig;", "setAiVoiceConfig", "(Lcom/obric/aivoice/sdk/AIVoiceConfig;)V", "conn", "Lcom/obric/aivoice/core/conn/ClientServiceConn;", "connectListener", "Lcom/obric/aivoice/sdk/IConnectListener;", "offlineServerListener", "Lcom/obric/aivoice/sdk/IOfflineServerListener;", "createAsrTask", "", "asrConfig", "createFileAsrTask", "listener", "Lcom/obric/aivoice/sdk/FileAsrTaskListener;", "createTtsTask", "ttsConfig", "destroy", "", "enableOfflineServer", "enable", "", "type", "getBinder", "Lcom/obric/aivoice/AIVoiceBinder;", "getOfflineServerStatus", "init", "config", "statusListener", "onConnected", "onDisconnected", "onOfflineStatusChanged", "status", "mode", "queryFileAsrTask", "taskId", "reConn", "registerOfflineServerListener", "Lcom/obric/aivoice/AIVoiceListener;", "removeAsrTask", "removeTtsTask", "unregisterOfflineServerListener", "writeAsrData", "data", "", "asrData", "writeTtsEnd", "writeTtsText", "text", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceManagerInner {
    public static final AIVoiceManagerInner INSTANCE = null;
    private static final String TAG = null;
    private static AIVoiceConfig aiVoiceConfig;
    private static ClientServiceConn conn;
    private static IConnectListener connectListener;
    private static IOfflineServerListener offlineServerListener;

    private AIVoiceManagerInner() {
    }

    static {
        INSTANCE = new AIVoiceManagerInner();
        TAG = "AIVoiceManagerInner";
    }

    public final AIVoiceConfig getAiVoiceConfig() {
        return aiVoiceConfig;
    }

    public final void setAiVoiceConfig(AIVoiceConfig r1) {
        aiVoiceConfig = r1;
    }

    public final synchronized void init(AIVoiceConfig r2, IConnectListener r3, IOfflineServerListener r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "config");     // Catch: Throwable -> L6
        aiVoiceConfig = r2;     // Catch: Throwable -> L6
        connectListener = r3;     // Catch: Throwable -> L6
        offlineServerListener = r4;     // Catch: Throwable -> L6
        reConn();     // Catch: Throwable -> L6
        AIVoiceLog.INSTANCE.v(TAG, "initialize success.");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized AIVoiceBinder getBinder() {
        monitor-enter(this);
        reConn();     // Catch: Throwable -> L10
        ClientServiceConn r0 = conn;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        AIVoiceBinder r1 = r0.getBinder();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r1;
    L7:
        r1 = null;
    L10:
        th = move-exception;
        throw th;
    }

    private final synchronized void reConn() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (conn != null) goto L6;
        conn = ClientServiceConn.Companion.getInstance(new ComponentName("com.obric.aivoice", "com.obric.aivoice.service.AIVoiceService"));     // Catch: Throwable -> L15
    L6:
        AIVoiceConfig r0 = aiVoiceConfig;     // Catch: Throwable -> L15
        Unit r1 = null;
        if (r0 == null) goto L11;
        ClientServiceConn r2 = conn;     // Catch: Throwable -> L15
        if (r2 == null) goto L11;
        r2.conn(r0.getContextGetter());     // Catch: Throwable -> L15
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r1 != null) goto L13;
        AIVoiceManagerInner r3 = this;     // Catch: Throwable -> L15
        AIVoiceLog.INSTANCE.e(TAG, "config is null");     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    public final int enableOfflineServer(boolean r3, int r4) {
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_EnableOfflineServer);
        r0.putBoolean(IdlKeys.Args_EnableOffline, r3);
        r0.putInt(IdlKeys.Args_OfflineType, r4);
        AIVoiceConfig r5 = aiVoiceConfig;
        Integer r6 = null;
        if (r5 == null) goto L5;
        String r7 = r5.getPackageName();
    L6:
        r0.putString("_PackageName", r7);
        AIVoiceBinder r2 = getBinder();     // Catch: RemoteException -> L20
        if (r2 == null) goto L12;
        Bundle r8 = r2.callVoiceSync(r0);     // Catch: RemoteException -> L20
        if (r8 == null) goto L12;
        Object r9 = r8.get("_R");     // Catch: RemoteException -> L20
    L14:
        if ((r9 instanceof Integer) == false) goto L16;
        r6 = (Integer) r9;     // Catch: RemoteException -> L20
    L16:
        if (r6 == null) goto L19;
        return r6.intValue();
    L19:
        return -1;
    L12:
        r9 = null;
    L20:
        e = move-exception;
        AIVoiceLog r10 = AIVoiceLog.INSTANCE;
        String r11 = TAG;
        String r1 = e.getMessage();
        if (r1 != null) goto L24;
        r1 = "";
    L24:
        r10.e(r11, r1, e);
        ClientServiceConn r12 = conn;
        if (r12 == null) goto L27;
        r12.onBinderException();
    L27:
        return 0;
    L5:
        r7 = null;
        goto L6
    }

    public final int getOfflineServerStatus(int r4) {
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_GetOfflineServerStatus);
        r0.putInt(IdlKeys.Args_OfflineType, r4);
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r3 == null) goto L8;
        Bundle r5 = r3.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r5 == null) goto L8;
        Object r6 = r5.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r6 instanceof Integer) == false) goto L12;
        r1 = (Integer) r6;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r6 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r2.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L27;
        r9.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final void registerOfflineServerListener(AIVoiceListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RegisterOfflineServerListener);
        AIVoiceBinder r2 = getBinder();     // Catch: RemoteException -> L7
        if (r2 == null) goto L17;
        r2.callVoice(r0, r3);     // Catch: RemoteException -> L7
        return;
    L17:
        return;
    L7:
        e = move-exception;
        AIVoiceLog r4 = AIVoiceLog.INSTANCE;
        String r1 = TAG;
        String r5 = e.getMessage();
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r4.e(r1, r5, e);
        ClientServiceConn r6 = conn;
        if (r6 == null) goto L18;
        r6.onBinderException();
        return;
    }

    public final void unregisterOfflineServerListener(AIVoiceListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_UnRegisterOfflineServerListener);
        AIVoiceBinder r2 = getBinder();     // Catch: RemoteException -> L7
        if (r2 == null) goto L17;
        r2.callVoice(r0, r3);     // Catch: RemoteException -> L7
        return;
    L17:
        return;
    L7:
        e = move-exception;
        AIVoiceLog r4 = AIVoiceLog.INSTANCE;
        String r1 = TAG;
        String r5 = e.getMessage();
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r4.e(r1, r5, e);
        ClientServiceConn r6 = conn;
        if (r6 == null) goto L18;
        r6.onBinderException();
        return;
    }

    public final int createAsrTask(String r4) {
        Intrinsics.checkNotNullParameter(r4, "asrConfig");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateAsrTask);
        r0.putString(IdlKeys.Args_AsrConfig, r4);
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r3 == null) goto L8;
        Bundle r5 = r3.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r5 == null) goto L8;
        Object r6 = r5.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r6 instanceof Integer) == false) goto L12;
        r1 = (Integer) r6;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r6 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r2.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L27;
        r9.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final int writeAsrData(byte[] r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "asrData");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteAsrData);
        r0.putByteArray(IdlKeys.Args_AudioBin, r3);
        r0.putString(IdlKeys.Args_AsrData, r4);
        AIVoiceBinder r2 = getBinder();     // Catch: RemoteException -> L15
        Integer r5 = null;
        if (r2 == null) goto L8;
        Bundle r6 = r2.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r6 == null) goto L8;
        Object r7 = r6.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r7 instanceof Integer) == false) goto L12;
        r5 = (Integer) r7;     // Catch: RemoteException -> L15
    L12:
        if (r5 == null) goto L25;
        return r5.intValue();
    L25:
        return -1;
    L8:
        r7 = null;
    L15:
        e = move-exception;
        AIVoiceLog r8 = AIVoiceLog.INSTANCE;
        String r1 = TAG;
        String r9 = e.getMessage();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r8.e(r1, r9, e);
        ClientServiceConn r10 = conn;
        if (r10 == null) goto L27;
        r10.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final int removeAsrTask(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RemoveAsrTask);
        r0.putString(IdlKeys.Args_AsrTaskId, r4);
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r3 == null) goto L8;
        Bundle r5 = r3.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r5 == null) goto L8;
        Object r6 = r5.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r6 instanceof Integer) == false) goto L12;
        r1 = (Integer) r6;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r6 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r2.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L27;
        r9.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final String createFileAsrTask(String r4, FileAsrTaskListener r5) {
        Intrinsics.checkNotNullParameter(r4, "asrConfig");
        Bundle r1 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateFileAsrTask);
        r1.putString(IdlKeys.Args_AsrConfig, r4);
        if (r5 == null) goto L25;
        r1.putBinder(IdlKeys.Args_TaskListener, r5.asBinder());
    L25:
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L17
        String r6 = null;
        if (r3 == null) goto L10;
        Bundle r7 = r3.callVoiceSync(r1);     // Catch: RemoteException -> L17
        if (r7 == null) goto L10;
        Object r8 = r7.get("_R");     // Catch: RemoteException -> L17
    L12:
        if ((r8 instanceof String) == false) goto L14;
        r6 = (String) r8;     // Catch: RemoteException -> L17
    L14:
        if (r6 != null) goto L27;
        return "";
    L27:
        return r6;
    L10:
        r8 = null;
    L17:
        e = move-exception;
        AIVoiceLog r9 = AIVoiceLog.INSTANCE;
        String r10 = TAG;
        String r2 = e.getMessage();
        if (r2 != null) goto L21;
        r2 = "";
    L21:
        r9.e(r10, r2, e);
        ClientServiceConn r11 = conn;
        if (r11 == null) goto L28;
        r11.onBinderException();
        return "";
    L28:
        return "";
    }

    public final String queryFileAsrTask(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Bundle r1 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_QueryFileAsrTask);
        r1.putString(IdlKeys.Args_AsrTaskId, r4);
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L15
        String r5 = null;
        if (r3 == null) goto L8;
        Bundle r6 = r3.callVoiceSync(r1);     // Catch: RemoteException -> L15
        if (r6 == null) goto L8;
        Object r7 = r6.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r7 instanceof String) == false) goto L12;
        r5 = (String) r7;     // Catch: RemoteException -> L15
    L12:
        if (r5 != null) goto L25;
        return "";
    L25:
        return r5;
    L8:
        r7 = null;
    L15:
        e = move-exception;
        AIVoiceLog r8 = AIVoiceLog.INSTANCE;
        String r2 = TAG;
        String r9 = e.getMessage();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r8.e(r2, r9, e);
        ClientServiceConn r10 = conn;
        if (r10 == null) goto L26;
        r10.onBinderException();
        return "";
    L26:
        return "";
    }

    public final int createTtsTask(String r4) {
        Intrinsics.checkNotNullParameter(r4, "ttsConfig");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateTtsTask);
        r0.putString(IdlKeys.Args_TtsConfig, r4);
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r3 == null) goto L8;
        Bundle r5 = r3.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r5 == null) goto L8;
        Object r6 = r5.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r6 instanceof Integer) == false) goto L12;
        r1 = (Integer) r6;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r6 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r2.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L27;
        r9.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final int writeTtsText(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r4, "text");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteTtsText);
        r0.putString(IdlKeys.Args_TtsTaskId, r3);
        r0.putString(IdlKeys.Args_TtsText, r4);
        AIVoiceBinder r2 = getBinder();     // Catch: RemoteException -> L15
        Integer r5 = null;
        if (r2 == null) goto L8;
        Bundle r6 = r2.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r6 == null) goto L8;
        Object r7 = r6.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r7 instanceof Integer) == false) goto L12;
        r5 = (Integer) r7;     // Catch: RemoteException -> L15
    L12:
        if (r5 == null) goto L25;
        return r5.intValue();
    L25:
        return -1;
    L8:
        r7 = null;
    L15:
        e = move-exception;
        AIVoiceLog r8 = AIVoiceLog.INSTANCE;
        String r1 = TAG;
        String r9 = e.getMessage();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        r8.e(r1, r9, e);
        ClientServiceConn r10 = conn;
        if (r10 == null) goto L27;
        r10.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final int writeTtsEnd(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteTtsEnd);
        r0.putString(IdlKeys.Args_TtsTaskId, r4);
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r3 == null) goto L8;
        Bundle r5 = r3.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r5 == null) goto L8;
        Object r6 = r5.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r6 instanceof Integer) == false) goto L12;
        r1 = (Integer) r6;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r6 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r2.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L27;
        r9.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final int removeTtsTask(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RemoveTtsTask);
        r0.putString(IdlKeys.Args_TtsTaskId, r4);
        AIVoiceBinder r3 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r3 == null) goto L8;
        Bundle r5 = r3.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r5 == null) goto L8;
        Object r6 = r5.get("_R");     // Catch: RemoteException -> L15
    L10:
        if ((r6 instanceof Integer) == false) goto L12;
        r1 = (Integer) r6;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r6 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = "";
    L19:
        r2.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L27;
        r9.onBinderException();
        return -1;
    L27:
        return -1;
    }

    public final void onConnected() {
        IConnectListener r0 = connectListener;
        if (r0 == null) goto L6;
        r0.onServerConnected();
        return;
    }

    public final void onDisconnected() {
        IConnectListener r0 = connectListener;
        if (r0 == null) goto L6;
        r0.onServerDisconnected();
        return;
    }

    public final void onOfflineStatusChanged(boolean r4, int r5) {
        AIVoiceLog.INSTANCE.d(TAG, "onOfflineStatusChanged status:" + r4 + " mode:" + r5);
        IOfflineServerListener r3 = offlineServerListener;
        if (r3 == null) goto L6;
        r3.onOfflineServerStatusChanged(r4, r5);
        return;
    }

    public final void destroy() {
        AIVoiceConfig r1 = aiVoiceConfig;
        if (r1 == null) goto L8;
        ClientServiceConn r0 = conn;
        if (r0 == null) goto L9;
        r0.disconnect(r1.getContextGetter());
        return;
    L9:
        return;
    }
}
