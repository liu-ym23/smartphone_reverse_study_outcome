package com.stepos.ability.sdk.client;

import B9.Q;
import C7.r;
import D7.v;
import D7.w;
import R3.i;
import R3.l;
import S7.k;
import S7.n;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.IAbilityQueryCallback;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.AbilityMetadataParcelable;
import com.stepos.ability.bean.AppOccupationResult;
import com.stepos.ability.bean.GuiAgentConfig;
import com.stepos.ability.bean.MainDisplayTopAppHistory;
import com.stepos.ability.bean.OriginalTaskConfig;
import com.stepos.ability.bean.OriginalTaskConfigKt;
import com.stepos.ability.bean.SlaPermissionResult;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.ability.bean.TaskSnapshot;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.common.AbilityException;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ability.commoninternal.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1718k;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import w0.C2085f;
import x4.C2114a;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0002¯\u0001\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002²\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b$\u0010#J\u0015\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b)\u0010(J\u0015\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b*\u0010(J\u0015\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b+\u0010(J\u0015\u0010,\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b,\u0010(J\u001d\u0010.\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\u0006\u0010-\u001a\u00020\u0018¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020%¢\u0006\u0004\b0\u00101J\r\u00102\u001a\u00020%¢\u0006\u0004\b2\u00101J\r\u00103\u001a\u00020%¢\u0006\u0004\b3\u00101J\u0013\u00106\u001a\b\u0012\u0004\u0012\u00020504¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b8\u0010(J%\u0010;\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020%¢\u0006\u0004\b;\u0010<J'\u0010A\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020%2\b\b\u0002\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u001d\u0010C\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\u0006\u00109\u001a\u00020%¢\u0006\u0004\bC\u0010DJ!\u0010F\u001a\u00020\b2\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010?¢\u0006\u0004\bF\u0010GJ#\u0010J\u001a\u00020?2\b\b\u0002\u0010H\u001a\u00020\u00072\n\b\u0002\u0010I\u001a\u0004\u0018\u00010%¢\u0006\u0004\bJ\u0010KJ\u0019\u0010L\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\bL\u0010(J\u0019\u0010M\u001a\u00020\b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\bM\u0010(J2\u0010Q\u001a\n\u0012\u0004\u0012\u00020P\u0018\u0001042\n\b\u0002\u0010N\u001a\u0004\u0018\u00010%2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000104H\u0086@¢\u0006\u0004\bQ\u0010RJ\u0018\u0010U\u001a\u00020T2\u0006\u0010S\u001a\u00020%H\u0086@¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u0004\u0018\u00010W¢\u0006\u0004\bX\u0010YJ\u0018\u0010[\u001a\u00020Z2\u0006\u0010S\u001a\u00020%H\u0086@¢\u0006\u0004\b[\u0010VJ\u001e\u0010^\u001a\u00020]2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020%04H\u0086@¢\u0006\u0004\b^\u0010_J\u001d\u0010c\u001a\u00020\b2\u0006\u0010`\u001a\u00020%2\u0006\u0010b\u001a\u00020a¢\u0006\u0004\bc\u0010dJ\u001d\u0010e\u001a\u00020\b2\u0006\u0010`\u001a\u00020%2\u0006\u0010b\u001a\u00020a¢\u0006\u0004\be\u0010dJ\u000f\u0010f\u001a\u00020\bH\u0002¢\u0006\u0004\bf\u0010\u0003J+\u0010j\u001a\u00020\b2\u0006\u0010g\u001a\u00020%2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020%2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\bl\u0010mJ\u0017\u0010o\u001a\u00020\b2\u0006\u0010n\u001a\u00020hH\u0002¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020\bH\u0002¢\u0006\u0004\bq\u0010\u0003J\u000f\u0010r\u001a\u00020\bH\u0002¢\u0006\u0004\br\u0010\u0003J!\u0010v\u001a\u00020\b2\u0006\u0010s\u001a\u00020\u00072\b\u0010u\u001a\u0004\u0018\u00010tH\u0002¢\u0006\u0004\bv\u0010wJ\u0017\u0010y\u001a\u00020\b2\u0006\u0010x\u001a\u00020tH\u0002¢\u0006\u0004\by\u0010zJ\u000f\u0010|\u001a\u00020{H\u0002¢\u0006\u0004\b|\u0010}J\u0017\u0010~\u001a\u00020\b2\u0006\u0010s\u001a\u00020\u0007H\u0002¢\u0006\u0004\b~\u0010\u007fJ*\u0010\u0080\u0001\u001a\u00020\b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\b2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\bH\u0002¢\u0006\u0005\b\u0086\u0001\u0010\u0003R\u0017\u0010\u0087\u0001\u001a\u00020%8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010\u0089\u0001\u001a\u00020%8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0088\u0001R\u0017\u0010\u008a\u0001\u001a\u00020%8\u0002X\u0082T¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0088\u0001R\u0017\u0010\u008b\u0001\u001a\u00020%8\u0002X\u0082T¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0088\u0001R\u0017\u0010\u008c\u0001\u001a\u00020%8\u0006X\u0086T¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u0088\u0001R\u0017\u0010\u008d\u0001\u001a\u00020%8\u0006X\u0086T¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u0088\u0001R\u0017\u0010\u008e\u0001\u001a\u00020%8\u0006X\u0086T¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u0088\u0001R\u0017\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0005\u0010\u008f\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0096\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0096\u0001R\u0017\u0010\u0099\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001RE\u0010\u009d\u0001\u001a0\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00060\u009b\u0001j\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006`\u009c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R$\u0010 \u0001\u001a\u000f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0\u009f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0019\u0010§\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0096\u0001R\u001e\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020\r0¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\t\u0010«\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0018\u0010°\u0001\u001a\u00030¯\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001¨\u0006³\u0001"}, d2 = {"Lcom/stepos/ability/sdk/client/AgentServiceClient;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "LC7/r;", "stateCallback", "init", "(Landroid/content/Context;LS7/k;)V", "release", "Lcom/stepos/ability/sdk/client/AgentServiceClient$ConnectionCallback;", "callback", "addConnectionCallback", "(Lcom/stepos/ability/sdk/client/AgentServiceClient$ConnectionCallback;)V", "removeConnectionCallback", "isInitialized", "()Z", "Lcom/stepos/ability/sdk/client/h;", "toolTaskConfig", "submitToolTask", "(Lcom/stepos/ability/sdk/client/h;)V", "Lcom/stepos/ability/sdk/client/g;", "guiTaskConfig", "submitGuiTask", "(Lcom/stepos/ability/sdk/client/g;)V", "Lcom/stepos/ability/bean/ToolCallEvent;", "toolCallEvent", "submitTooCallEvent", "(Landroid/content/Context;Lcom/stepos/ability/bean/ToolCallEvent;)V", "Lcom/stepos/ability/ITaskListener;", "listener", "registerTaskListener", "(Lcom/stepos/ability/ITaskListener;)V", "unRegisterTaskListener", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "takeOverGui", "(Ljava/lang/String;)V", "unTakeOverGui", "fullScreenGui", "cancelFullScreenGui", "cancelTask", "config", "updateGuiAgent", "(Ljava/lang/String;Lcom/stepos/ability/sdk/client/g;)V", "getForegroundTaskId", "()Ljava/lang/String;", "getForegroundTaskSessionId", "getLastActiveTaskSessionId", "", "Lcom/stepos/ability/bean/TaskSnapshot;", "listActiveTasks", "()Ljava/util/List;", "dismissVoiceInput", "requestId", "content", "submitUserInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "agreed", Key.KEY_TOOL_CALL_ID, "Landroid/os/Bundle;", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "submitPermissionAuthResult", "(ZLjava/lang/String;Landroid/os/Bundle;)V", "cancelUserInput", "(Ljava/lang/String;Ljava/lang/String;)V", "options", "showFullScreenGuiV2", "(Ljava/lang/String;Landroid/os/Bundle;)V", "enableInteraction", "targetPackage", "buildFullScreenOptions", "(ZLjava/lang/String;)Landroid/os/Bundle;", "dismissFullScreenOverlay", "resumeFullScreenOverlay", "query", "params", "Lx4/a;", "queryAbilities", "(Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "appName", "Lcom/stepos/ability/bean/WhitelistCheckResult;", "checkAppWhitelist", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/bean/MainDisplayTopAppHistory;", "getMainDisplayTopAppHistory", "()Lcom/stepos/ability/bean/MainDisplayTopAppHistory;", "Lcom/stepos/ability/bean/AppOccupationResult;", "isAppOccupied", "functions", "Lcom/stepos/ability/bean/SlaPermissionResult;", "checkSlaPermission", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "newTaskId", "", "conflictKind", "confirmPackageConflict", "(Ljava/lang/String;I)V", "cancelPackageConflict", "checkInitialized", "actionName", "Lcom/stepos/ability/IAgentServiceManager;", "block", "withService", "(Ljava/lang/String;LS7/k;)V", "listenerKey", "(Lcom/stepos/ability/ITaskListener;)Ljava/lang/String;", "sm", "reRegisterAllTaskListeners", "(Lcom/stepos/ability/IAgentServiceManager;)V", "cancelBindTimeoutRunnableOnly", "cancelBindTimeout", "success", "Ljava/util/concurrent/atomic/AtomicBoolean;", "invoked", "completeBindAttemptAfterConnection", "(ZLjava/util/concurrent/atomic/AtomicBoolean;)V", "callbackInvoked", "scheduleBindTimeout", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "Landroid/content/Intent;", "agentServiceIntent", "()Landroid/content/Intent;", "finishBindAttempt", "(Z)V", "bind", "(LS7/k;)V", "Lcom/stepos/ability/bean/TaskConfig;", "taskConfig", "internalSubmitTask", "(Lcom/stepos/ability/bean/TaskConfig;)V", "logSdkVersionIfNeeded", "TAG", "Ljava/lang/String;", "SERVICE_PACKAGE", "SERVICE_CLASS", "ACTION_BIND", "KEY_ENABLE_INTERACTION", "KEY_TARGET_PACKAGE", "KEY_CHAT_SESSION_ID", "Landroid/content/Context;", "serviceManager", "Lcom/stepos/ability/IAgentServiceManager;", "Landroid/content/ServiceConnection;", "serviceConnection", "Landroid/content/ServiceConnection;", "bindingInProgress", "Z", "serviceStarted", "serviceBound", "bindLock", "Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pendingBindCallbacks", "Ljava/util/ArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "registeredTaskListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "currentBindCallbackInvoked", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Runnable;", "currentBindTimeoutRunnable", "Ljava/lang/Runnable;", "initialized", "Ljava/util/concurrent/CopyOnWriteArrayList;", "connectionCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "LS7/k;", "Landroid/os/IBinder$DeathRecipient;", "binderDeathRecipient", "Landroid/os/IBinder$DeathRecipient;", "com/stepos/ability/sdk/client/c", "agentServiceConnection", "Lcom/stepos/ability/sdk/client/c;", "ConnectionCallback", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class AgentServiceClient {
    private static final String ACTION_BIND = "com.stepos.ability.BIND_AGENT_SERVICE";
    public static final String KEY_CHAT_SESSION_ID = "chat_session_id";
    public static final String KEY_ENABLE_INTERACTION = "fs_enable_interaction";
    public static final String KEY_TARGET_PACKAGE = "fs_target_package";
    private static final String SERVICE_CLASS = "com.stepos.ability.service.AgentService";
    private static final String SERVICE_PACKAGE = "com.stepos.ability";
    private static final String TAG = "Ability_AgentServiceClient";
    private static volatile boolean bindingInProgress;
    private static Context context;
    private static volatile AtomicBoolean currentBindCallbackInvoked;
    private static volatile Runnable currentBindTimeoutRunnable;
    private static volatile boolean initialized;
    private static volatile boolean serviceBound;
    private static volatile ServiceConnection serviceConnection;
    private static volatile IAgentServiceManager serviceManager;
    private static volatile boolean serviceStarted;
    private static k stateCallback;
    public static final AgentServiceClient INSTANCE = new AgentServiceClient();
    private static final Object bindLock = new Object();
    private static final ArrayList<k> pendingBindCallbacks = new ArrayList<>();
    private static final ConcurrentHashMap<String, ITaskListener> registeredTaskListeners = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<ConnectionCallback> connectionCallbacks = new CopyOnWriteArrayList<>();
    private static final IBinder.DeathRecipient binderDeathRecipient = new b();
    private static final c agentServiceConnection = new c();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/sdk/client/AgentServiceClient$ConnectionCallback;", "", "LC7/r;", "onConnected", "()V", "onDisconnected", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ConnectionCallback {
        default void onConnected() {
        }

        default void onDisconnected() {
        }
    }

    @J7.c(c = "com.stepos.ability.sdk.client.AgentServiceClient", f = "AgentServiceClient.kt", l = {944}, m = "checkAppWhitelist", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3243a;
        public int c;

        public AnonymousClass1(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3243a = obj;
            this.c |= Integer.MIN_VALUE;
            return AgentServiceClient.this.checkAppWhitelist(null, this);
        }
    }

    @J7.c(c = "com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$2", f = "AgentServiceClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/bean/WhitelistCheckResult;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/bean/WhitelistCheckResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3244a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, H7.c cVar) {
            super(2, cVar);
            this.f3244a = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass2(this.f3244a, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            AgentServiceClient.INSTANCE.checkInitialized();
            IAgentServiceManager iAgentServiceManager = AgentServiceClient.serviceManager;
            if (iAgentServiceManager != null) {
                return iAgentServiceManager.checkAppWhitelistV1(this.f3244a);
            }
            throw new AbilityException(O3.b.f, null, null);
        }
    }

    @J7.c(c = "com.stepos.ability.sdk.client.AgentServiceClient$checkSlaPermission$2", f = "AgentServiceClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/bean/SlaPermissionResult;", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/bean/SlaPermissionResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.sdk.client.AgentServiceClient$checkSlaPermission$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10312 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f3245a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10312(List list, H7.c cVar) {
            super(2, cVar);
            this.f3245a = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new C10312(this.f3245a, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C10312) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SlaPermissionResult slaPermissionResultUnavailable;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            IAgentServiceManager iAgentServiceManager = AgentServiceClient.serviceManager;
            P3.b bVar = P3.c.f1086a;
            if (iAgentServiceManager == null) {
                bVar.invoke(5, "Ability_".concat(AgentServiceClient.TAG), "checkSlaPermission: service not bound -> UNAVAILABLE", null);
                return SlaPermissionResult.INSTANCE.unavailable("service not bound");
            }
            try {
                slaPermissionResultUnavailable = iAgentServiceManager.checkSlaPermissionV1(this.f3245a);
            } catch (CancellationException e) {
                throw e;
            } catch (Exception e6) {
                bVar.invoke(5, "Ability_".concat(AgentServiceClient.TAG), androidx.constraintlayout.core.dsl.a.h("checkSlaPermission failed: ", e6.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e6);
                SlaPermissionResult.Companion companion = SlaPermissionResult.INSTANCE;
                String message = e6.getMessage();
                if (message == null) {
                    message = e6.getClass().getSimpleName();
                }
                slaPermissionResultUnavailable = companion.unavailable("binder failed: ".concat(message));
            }
            kotlin.jvm.internal.k.c(slaPermissionResultUnavailable);
            return slaPermissionResultUnavailable;
        }
    }

    @J7.c(c = "com.stepos.ability.sdk.client.AgentServiceClient", f = "AgentServiceClient.kt", l = {1024}, m = "isAppOccupied", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10321 extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3246a;
        public int c;

        public C10321(H7.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3246a = obj;
            this.c |= Integer.MIN_VALUE;
            return AgentServiceClient.this.isAppOccupied(null, this);
        }
    }

    @J7.c(c = "com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$2", f = "AgentServiceClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/stepos/ability/bean/AppOccupationResult;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lm9/z;)Lcom/stepos/ability/bean/AppOccupationResult;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10332 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3247a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10332(String str, H7.c cVar) {
            super(2, cVar);
            this.b = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            C10332 c10332 = new C10332(this.b, cVar);
            c10332.f3247a = obj;
            return c10332;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((C10332) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            IAgentServiceManager iAgentServiceManager;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            String str = this.b;
            try {
                AgentServiceClient.INSTANCE.checkInitialized();
                iAgentServiceManager = AgentServiceClient.serviceManager;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (iAgentServiceManager == null) {
                throw new AbilityException(O3.b.f, null, null);
            }
            objA = iAgentServiceManager.isAppOccupiedV1(str);
            Throwable thA = Result.a(objA);
            if (thA == null) {
                return objA;
            }
            String strH = androidx.constraintlayout.core.dsl.a.h("isAppOccupied failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE);
            P3.c.f1086a.invoke(6, "Ability_".concat(AgentServiceClient.TAG), strH, thA);
            return new AppOccupationResult(false, "", "");
        }
    }

    private AgentServiceClient() {
    }

    private final Intent agentServiceIntent() {
        Intent component = new Intent(ACTION_BIND).setComponent(new ComponentName(SERVICE_PACKAGE, SERVICE_CLASS));
        kotlin.jvm.internal.k.e(component, "setComponent(...)");
        return component;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bind(k callback) {
        Context context2;
        if (serviceManager != null) {
            if (callback != null) {
                callback.invoke(Boolean.TRUE);
            }
            P3.c.f1086a.invoke(3, "Ability_".concat(TAG), "bind: reuse existing", null);
            return;
        }
        synchronized (bindLock) {
            if (callback != null) {
                try {
                    pendingBindCallbacks.add(callback);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bindingInProgress) {
                String msg = "bind: in progress, callback queued (queueSize=" + pendingBindCallbacks.size() + ")";
                kotlin.jvm.internal.k.f(msg, "msg");
                P3.c.f1086a.invoke(3, "Ability_".concat(TAG), msg, null);
                return;
            }
            bindingInProgress = true;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            scheduleBindTimeout(atomicBoolean);
            if (serviceBound) {
                P3.c.f1086a.invoke(3, "Ability_".concat(TAG), "bind: waiting for BIND_AUTO_CREATE reconnect", null);
                return;
            }
            String msg2 = "bind: start+bind (serviceStarted=" + serviceStarted + ")";
            kotlin.jvm.internal.k.f(msg2, "msg");
            P3.c.f1086a.invoke(3, "Ability_".concat(TAG), msg2, null);
            Intent intentAgentServiceIntent = agentServiceIntent();
            if (!serviceStarted) {
                try {
                    Context context3 = context;
                    if (context3 == null) {
                        kotlin.jvm.internal.k.n("context");
                        throw null;
                    }
                    context3.startService(intentAgentServiceIntent);
                    serviceStarted = true;
                } catch (Exception e) {
                    P3.c.f1086a.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("startService failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), null);
                }
            }
            try {
                Context context4 = context;
                if (context4 == null) {
                    kotlin.jvm.internal.k.n("context");
                    throw null;
                }
                c cVar = agentServiceConnection;
                if (context4.bindService(intentAgentServiceIntent, cVar, 1)) {
                    serviceConnection = cVar;
                    serviceBound = true;
                    return;
                }
                P3.c.f1086a.invoke(5, "Ability_".concat(TAG), "bindService returned false — releasing", null);
                try {
                    context2 = context;
                } catch (Throwable th2) {
                    kotlin.b.a(th2);
                }
                if (context2 == null) {
                    kotlin.jvm.internal.k.n("context");
                    throw null;
                }
                context2.unbindService(cVar);
                cancelBindTimeout();
                if (atomicBoolean.compareAndSet(false, true)) {
                    finishBindAttempt(false);
                }
            } catch (Exception e6) {
                P3.c.f1086a.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("bindService failed: ", e6.getMessage(), NotificationCompat.CATEGORY_MESSAGE), null);
                cancelBindTimeout();
                if (atomicBoolean.compareAndSet(false, true)) {
                    finishBindAttempt(false);
                }
            }
        }
    }

    public static /* synthetic */ void bind$default(AgentServiceClient agentServiceClient, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = null;
        }
        agentServiceClient.bind(kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void binderDeathRecipient$lambda$0() {
        P3.c.f1086a.invoke(5, "Ability_".concat(TAG), "binder died — clearing state", null);
        serviceManager = null;
        serviceBound = false;
    }

    public static /* synthetic */ Bundle buildFullScreenOptions$default(AgentServiceClient agentServiceClient, boolean z10, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return agentServiceClient.buildFullScreenOptions(z10, str);
    }

    private final void cancelBindTimeout() {
        cancelBindTimeoutRunnableOnly();
        currentBindCallbackInvoked = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelBindTimeoutRunnableOnly() {
        Runnable runnable = currentBindTimeoutRunnable;
        if (runnable != null) {
            ((Handler) P3.e.f1088a.getF4884a()).removeCallbacks(runnable);
        }
        currentBindTimeoutRunnable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r cancelFullScreenGui$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.cancelFullScreenGui(str);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r cancelTask$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        C2085f c2085f = TaskStatus.b;
        it.updateTaskStatusAndControl(str, 6);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r cancelUserInput$lambda$0(String str, String str2, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.cancelUserInput(str, str2);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkInitialized() {
        if (initialized) {
            return;
        }
        P3.c.f1086a.invoke(6, "Ability_".concat(TAG), "AgentServiceClient not initialized. Call AgentServiceClient.init(context) first !", null);
        throw new IllegalStateException("AgentServiceClient not initialized. Call AgentServiceClient.init(context) first !");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeBindAttemptAfterConnection(boolean success, AtomicBoolean invoked) {
        if (invoked != null && invoked.compareAndSet(false, true)) {
            finishBindAttempt(success);
            return;
        }
        synchronized (bindLock) {
            if (bindingInProgress) {
                bindingInProgress = false;
                ArrayList<k> arrayList = pendingBindCallbacks;
                List<k> listF1 = v.f1(arrayList);
                arrayList.clear();
                for (k kVar : listF1) {
                    if (kVar != null) {
                        kVar.invoke(Boolean.valueOf(success));
                    }
                }
            }
        }
    }

    public static /* synthetic */ void dismissFullScreenOverlay$default(AgentServiceClient agentServiceClient, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        agentServiceClient.dismissFullScreenOverlay(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r dismissFullScreenOverlay$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.dismissFullScreenOverlay(str);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r dismissVoiceInput$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.dismissVoiceInput(str);
        return r.f317a;
    }

    private final void finishBindAttempt(boolean success) {
        List<k> listF1;
        synchronized (bindLock) {
            bindingInProgress = false;
            ArrayList<k> arrayList = pendingBindCallbacks;
            listF1 = v.f1(arrayList);
            arrayList.clear();
        }
        for (k kVar : listF1) {
            if (kVar != null) {
                kVar.invoke(Boolean.valueOf(success));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r fullScreenGui$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.fullScreenGui(str);
        return r.f317a;
    }

    public static /* synthetic */ void init$default(AgentServiceClient agentServiceClient, Context context2, k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            kVar = null;
        }
        agentServiceClient.init(context2, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r init$lambda$0(boolean z10) {
        P3.b bVar = P3.c.f1086a;
        if (z10) {
            bVar.invoke(3, "Ability_".concat(TAG), "Bind service success !", null);
        } else {
            bVar.invoke(6, "Ability_".concat(TAG), "Bind service failed !", null);
        }
        return r.f317a;
    }

    private final void internalSubmitTask(TaskConfig taskConfig) throws Exception {
        String msg = "internalSubmitTask taskConfig" + taskConfig;
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat(TAG), msg, null);
        IAgentServiceManager iAgentServiceManager = serviceManager;
        if (iAgentServiceManager != null) {
            iAgentServiceManager.submitTask(taskConfig);
        }
    }

    private final String listenerKey(ITaskListener listener) {
        Context context2 = context;
        if (context2 == null) {
            kotlin.jvm.internal.k.n("context");
            throw null;
        }
        return context2.getPackageName() + "#" + System.identityHashCode(listener);
    }

    private final void logSdkVersionIfNeeded() {
        P3.c.b(TAG, "SDK version=1.11");
    }

    public static /* synthetic */ Object queryAbilities$default(AgentServiceClient agentServiceClient, String str, List list, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return agentServiceClient.queryAbilities(str, list, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryAbilities$lambda$0$executeQueryAbility(String str, List<Object> list, final InterfaceC1717j interfaceC1717j, IAgentServiceManager iAgentServiceManager) {
        if (str == null) {
            str = "";
        }
        try {
            kotlin.jvm.internal.k.f(list, "<this>");
            List<Object> list2 = list;
            ArrayList arrayList = new ArrayList(w.c0(list2, 10));
            Iterator<T> it = list2.iterator();
            if (!it.hasNext()) {
                iAgentServiceManager.queryAbilities(str, arrayList, new IAbilityQueryCallback.Stub() { // from class: com.stepos.ability.sdk.client.AgentServiceClient$queryAbilities$2$executeQueryAbility$1
                    @Override // com.stepos.ability.IAbilityQueryCallback
                    public void onComplete(boolean isSuccess, String errorMsg, List<AbilityMetadataParcelable> result) {
                        if (interfaceC1717j.isActive()) {
                            P3.b bVar = P3.c.f1086a;
                            ArrayList arrayList2 = null;
                            if (!isSuccess) {
                                O3.b bVar2 = O3.b.d;
                                bVar.invoke(6, "Ability_".concat("Ability_AgentServiceClient"), androidx.constraintlayout.core.dsl.a.h("queryAbilities Query meta info failed. Msg: ", errorMsg, NotificationCompat.CATEGORY_MESSAGE), null);
                                interfaceC1717j.resumeWith(kotlin.b.a(new AbilityException(bVar2, null, null)));
                                return;
                            }
                            String msg = "queryAbilities Query success: " + result;
                            kotlin.jvm.internal.k.f(msg, "msg");
                            bVar.invoke(3, "Ability_".concat("Ability_AgentServiceClient"), msg, null);
                            InterfaceC1717j interfaceC1717j2 = interfaceC1717j;
                            if (result != null) {
                                List<AbilityMetadataParcelable> list3 = result;
                                arrayList2 = new ArrayList(w.c0(list3, 10));
                                for (AbilityMetadataParcelable abilityMetadataParcelable : list3) {
                                    arrayList2.add(new C2114a(abilityMetadataParcelable.getToolName(), abilityMetadataParcelable.getDescription(), abilityMetadataParcelable.getInputSchema(), abilityMetadataParcelable.getPackageName()));
                                }
                            }
                            interfaceC1717j2.resumeWith(arrayList2);
                        }
                    }
                });
            } else {
                if (it.next() != null) {
                    throw new ClassCastException();
                }
                throw null;
            }
        } catch (Exception e) {
            P3.c.f1086a.invoke(6, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("queryAbilities IPC Call error: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), null);
            queryAbilities$lambda$0$safeResumeException(interfaceC1717j, new AbilityException(e instanceof DeadObjectException ? O3.a.d : e instanceof RemoteException ? O3.b.f : O3.b.g, e.getMessage(), e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryAbilities$lambda$0$safeResumeException(InterfaceC1717j interfaceC1717j, Throwable th) {
        String strH = androidx.constraintlayout.core.dsl.a.h("queryAbilities Query failed. msg:", th.getMessage(), NotificationCompat.CATEGORY_MESSAGE);
        P3.c.f1086a.invoke(6, "Ability_".concat(TAG), strH, th);
        if (interfaceC1717j.isActive()) {
            interfaceC1717j.resumeWith(kotlin.b.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reRegisterAllTaskListeners(IAgentServiceManager sm) {
        P3.b bVar = P3.c.f1086a;
        ConcurrentHashMap<String, ITaskListener> concurrentHashMap = registeredTaskListeners;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ITaskListener> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            try {
                sm.registerTaskListener(entry.getValue(), key);
                String msg = "reRegisterTaskListener done: key=" + key;
                kotlin.jvm.internal.k.f(msg, "msg");
                bVar.invoke(3, "Ability_".concat(TAG), msg, null);
            } catch (Exception e) {
                bVar.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("reRegisterTaskListener failed: key=", key, NotificationCompat.CATEGORY_MESSAGE), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r registerTaskListener$lambda$0(ITaskListener iTaskListener, String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.registerTaskListener(iTaskListener, str);
        String msg = "registerTaskListener done: key=" + str;
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat(TAG), msg, null);
        return r.f317a;
    }

    public static /* synthetic */ void resumeFullScreenOverlay$default(AgentServiceClient agentServiceClient, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        agentServiceClient.resumeFullScreenOverlay(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r resumeFullScreenOverlay$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.resumeFullScreenOverlay(str);
        return r.f317a;
    }

    private final void scheduleBindTimeout(AtomicBoolean callbackInvoked) {
        cancelBindTimeout();
        D6.b bVar = new D6.b(callbackInvoked, 22);
        currentBindTimeoutRunnable = bVar;
        currentBindCallbackInvoked = callbackInvoked;
        ((Handler) P3.e.f1088a.getF4884a()).postDelayed(bVar, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleBindTimeout$lambda$0(AtomicBoolean atomicBoolean) {
        if (atomicBoolean.compareAndSet(false, true)) {
            P3.c.f1086a.invoke(5, "Ability_".concat(TAG), "bind timeout", null);
            INSTANCE.finishBindAttempt(false);
        }
    }

    public static /* synthetic */ void showFullScreenGuiV2$default(AgentServiceClient agentServiceClient, String str, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        agentServiceClient.showFullScreenGuiV2(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r showFullScreenGuiV2$lambda$0(String str, Bundle bundle, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.showFullScreenGuiV2(str, bundle);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r submitGuiTask$lambda$0(g gVar, boolean z10) {
        P3.b bVar = P3.c.f1086a;
        if (serviceManager != null) {
            try {
                AgentServiceClient agentServiceClient = INSTANCE;
                Context context2 = context;
                if (context2 == null) {
                    kotlin.jvm.internal.k.n("context");
                    throw null;
                }
                agentServiceClient.internalSubmitTask(com.stepos.ability.task.executor.e.L(gVar, context2));
            } catch (Exception e) {
                bVar.invoke(6, "Ability_".concat(TAG), "submitTask failed", e);
            }
        } else {
            bVar.invoke(6, "Ability_".concat(TAG), "submitTask failed: service not connected", null);
        }
        return r.f317a;
    }

    public static /* synthetic */ void submitPermissionAuthResult$default(AgentServiceClient agentServiceClient, boolean z10, String str, Bundle bundle, int i, Object obj) {
        if ((i & 4) != 0) {
            bundle = new Bundle();
        }
        agentServiceClient.submitPermissionAuthResult(z10, str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r submitPermissionAuthResult$lambda$0(boolean z10, String str, Bundle bundle, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.submitPermissionAuthResult(z10, str, bundle);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r submitTooCallEvent$lambda$0(ToolCallEvent toolCallEvent, boolean z10) {
        P3.b bVar = P3.c.f1086a;
        if (serviceManager != null) {
            try {
                IAgentServiceManager iAgentServiceManager = serviceManager;
                if (iAgentServiceManager != null) {
                    iAgentServiceManager.submitToolCallEvent(toolCallEvent);
                }
            } catch (Exception e) {
                bVar.invoke(6, "Ability_".concat(TAG), "submitTask failed", e);
            }
        } else {
            bVar.invoke(6, "Ability_".concat(TAG), "submitTask failed: service not connected", null);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r submitToolTask$lambda$0(h hVar, boolean z10) {
        r rVar = r.f317a;
        P3.b bVar = P3.c.f1086a;
        if (serviceManager == null) {
            bVar.invoke(6, "Ability_".concat(TAG), "submitTask failed: service not connected", null);
            return rVar;
        }
        try {
            if (!kotlin.jvm.internal.k.b(hVar.f3253a, "add_task") && !kotlin.jvm.internal.k.b(hVar.f3253a, "update_task")) {
                bVar.invoke(3, "Ability_".concat(TAG), "branch2 normal tool", null);
                AgentServiceClient agentServiceClient = INSTANCE;
                Context context2 = context;
                if (context2 == null) {
                    kotlin.jvm.internal.k.n("context");
                    throw null;
                }
                f fVar = hVar.e;
                String str = fVar.f3251a;
                if (str == null) {
                    str = hVar.b;
                }
                agentServiceClient.internalSubmitTask(new TaskConfig(str, hVar.b, null, 0, fVar.b, null, hVar.d, hVar.f3253a, null, null, hVar.c, fVar.c, context2.getPackageName(), 0, 8708, null));
                return rVar;
            }
            String str2 = hVar.c;
            OriginalTaskConfig originalTaskConfig = str2 != null ? OriginalTaskConfigKt.toOriginalTaskConfig(str2) : null;
            P3.c.a(TAG, "submitToolTask OriginalTaskConfig: " + originalTaskConfig);
            if (originalTaskConfig == null) {
                bVar.invoke(6, "Ability_".concat(TAG), "submitToolTask failed: originalTaskConfig is null", null);
                return rVar;
            }
            P3.c.b(TAG, "originalTaskConfig.toolName:" + originalTaskConfig.getToolName());
            String toolName = originalTaskConfig.getToolName();
            if (toolName != null && toolName.length() != 0 && !kotlin.jvm.internal.k.b(originalTaskConfig.getToolName(), "null")) {
                Bundle bundle = hVar.e.c;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                String string = bundle.getString("session_id");
                if (string == null || string.length() == 0) {
                    Log.w(TAG, "SDK Client sessionId is NULL! conversionId=null");
                } else {
                    Log.i(TAG, "SDK Client sessionId found: ".concat(string));
                }
                Context context3 = context;
                if (context3 == null) {
                    kotlin.jvm.internal.k.n("context");
                    throw null;
                }
                TaskConfig taskConfig = OriginalTaskConfigKt.toTaskConfig(originalTaskConfig, context3, bundle);
                P3.c.a(TAG, "branch1 normal tool call " + taskConfig);
                INSTANCE.internalSubmitTask(taskConfig);
                return rVar;
            }
            IAgentServiceManager iAgentServiceManager = serviceManager;
            if (iAgentServiceManager != null) {
                iAgentServiceManager.toolUpdateTask(OriginalTaskConfigKt.toTask(originalTaskConfig));
            }
            return rVar;
        } catch (Exception e) {
            bVar.invoke(6, "Ability_".concat(TAG), "submitTask failed", e);
            return rVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r submitUserInput$lambda$0(String str, String str2, String str3, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.submitUserInput(str, str2, str3);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r takeOverGui$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        C2085f c2085f = TaskStatus.b;
        it.updateTaskStatusAndControl(str, 8);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r unRegisterTaskListener$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        it.unRegisterTaskListener(str);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r unTakeOverGui$lambda$0(String str, IAgentServiceManager it) throws RemoteException {
        kotlin.jvm.internal.k.f(it, "it");
        C2085f c2085f = TaskStatus.b;
        it.updateTaskStatusAndControl(str, 2);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updateGuiAgent$lambda$0(String str, g gVar, IAgentServiceManager it) throws RemoteException {
        String string;
        kotlin.jvm.internal.k.f(it, "it");
        Bundle bundle = new Bundle();
        kotlin.jvm.internal.k.f(gVar, "<this>");
        bundle.putParcelable(Key.KEY_GUI_AGENT_CONFIG, new GuiAgentConfig(null, 2, 0, null, null, false, null, LocationRequestCompat.QUALITY_LOW_POWER, null));
        Bundle bundle2 = gVar.c.c;
        if (bundle2 != null && (string = bundle2.getString(KEY_CHAT_SESSION_ID)) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                bundle.putString(KEY_CHAT_SESSION_ID, string);
            }
        }
        it.updateTask(str, bundle);
        return r.f317a;
    }

    private final void withService(String actionName, k block) {
        checkInitialized();
        bind(new R3.b(19, actionName, block));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r withService$lambda$0(String msg, k kVar, boolean z10) {
        r rVar = r.f317a;
        P3.b bVar = P3.c.f1086a;
        try {
            kotlin.jvm.internal.k.f(msg, "msg");
            bVar.invoke(3, "Ability_".concat(TAG), msg, null);
            IAgentServiceManager iAgentServiceManager = serviceManager;
            if (iAgentServiceManager != null) {
                kVar.invoke(iAgentServiceManager);
                return rVar;
            }
            String msg2 = msg.concat(" skipped: not bound yet");
            kotlin.jvm.internal.k.f(msg2, "msg");
            bVar.invoke(5, "Ability_".concat(TAG), msg2, null);
            return rVar;
        } catch (Exception e) {
            String msg3 = msg + " failed";
            kotlin.jvm.internal.k.f(msg3, "msg");
            bVar.invoke(3, "Ability_".concat(TAG), msg3, e);
            return rVar;
        }
    }

    public final void addConnectionCallback(ConnectionCallback callback) {
        kotlin.jvm.internal.k.f(callback, "callback");
        connectionCallbacks.addIfAbsent(callback);
    }

    public final Bundle buildFullScreenOptions(boolean enableInteraction, String targetPackage) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("fs_enable_interaction", enableInteraction);
        if (targetPackage != null && targetPackage.length() != 0) {
            bundle.putString("fs_target_package", targetPackage);
        }
        return bundle;
    }

    public final void cancelFullScreenGui(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        withService("cancelFullScreenGui ".concat(taskId), new R3.c(taskId, 12));
    }

    public final void cancelPackageConflict(String newTaskId, int conflictKind) {
        Object objA;
        IAgentServiceManager iAgentServiceManager;
        kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
        try {
            checkInitialized();
            iAgentServiceManager = serviceManager;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (iAgentServiceManager == null) {
            throw new AbilityException(O3.b.f, null, null);
        }
        iAgentServiceManager.cancelPackageConflict(newTaskId, conflictKind);
        objA = r.f317a;
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("cancelPackageConflict failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
    }

    public final void cancelTask(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        withService("cancelTask ".concat(taskId), new R3.c(taskId, 14));
    }

    public final void cancelUserInput(String taskId, String requestId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(requestId, "requestId");
        withService(androidx.constraintlayout.core.dsl.a.j(new StringBuilder("cancelUserInput "), taskId, " ", requestId), new l(1, taskId, requestId));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkAppWhitelist(java.lang.String r5, H7.c<? super com.stepos.ability.bean.WhitelistCheckResult> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ability.sdk.client.AgentServiceClient.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$1 r0 = (com.stepos.ability.sdk.client.AgentServiceClient.AnonymousClass1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$1 r0 = new com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f3243a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L45
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            u9.d r4 = m9.AbstractC1691I.f5315a
            u9.c r4 = u9.c.f6743a
            com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$2 r1 = new com.stepos.ability.sdk.client.AgentServiceClient$checkAppWhitelist$2
            r3 = 0
            r1.<init>(r5, r3)
            r0.c = r2
            java.lang.Object r4 = m9.AbstractC1683A.w(r4, r1, r0)
            if (r4 != r6) goto L45
            return r6
        L45:
            java.lang.String r5 = "withContext(...)"
            kotlin.jvm.internal.k.e(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.sdk.client.AgentServiceClient.checkAppWhitelist(java.lang.String, H7.c):java.lang.Object");
    }

    public final Object checkSlaPermission(List<String> list, H7.c<? super SlaPermissionResult> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10312(list, null), cVar);
    }

    public final void confirmPackageConflict(String newTaskId, int conflictKind) {
        Object objA;
        IAgentServiceManager iAgentServiceManager;
        kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
        try {
            checkInitialized();
            iAgentServiceManager = serviceManager;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (iAgentServiceManager == null) {
            throw new AbilityException(O3.b.f, null, null);
        }
        iAgentServiceManager.confirmPackageConflict(newTaskId, conflictKind);
        objA = r.f317a;
        Throwable thA = Result.a(objA);
        if (thA != null) {
            P3.c.f1086a.invoke(6, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("confirmPackageConflict failed: ", thA.getMessage(), NotificationCompat.CATEGORY_MESSAGE), thA);
        }
    }

    public final void dismissFullScreenOverlay(String taskId) {
        withService(B7.a.k("dismissFullScreenOverlay ", taskId), new R3.c(taskId, 15));
    }

    public final void dismissVoiceInput(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        withService("dismissVoiceInput ".concat(taskId), new R3.c(taskId, 16));
    }

    public final void fullScreenGui(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        withService("fullScreenGui ".concat(taskId), new R3.c(taskId, 10));
    }

    public final String getForegroundTaskId() {
        checkInitialized();
        try {
            IAgentServiceManager iAgentServiceManager = serviceManager;
            String foregroundTaskId = iAgentServiceManager != null ? iAgentServiceManager.getForegroundTaskId() : null;
            return foregroundTaskId == null ? "" : foregroundTaskId;
        } catch (Exception e) {
            P3.c.f1086a.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("getForegroundTaskId failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e);
            return "";
        }
    }

    public final String getForegroundTaskSessionId() {
        P3.b bVar = P3.c.f1086a;
        checkInitialized();
        try {
            IAgentServiceManager iAgentServiceManager = serviceManager;
            String foregroundTaskSessionId = iAgentServiceManager != null ? iAgentServiceManager.getForegroundTaskSessionId() : null;
            if (foregroundTaskSessionId == null) {
                foregroundTaskSessionId = "";
            }
            String msg = "getForegroundTaskSessionId ".concat(foregroundTaskSessionId);
            kotlin.jvm.internal.k.f(msg, "msg");
            bVar.invoke(5, "Ability_".concat(TAG), msg, null);
            return foregroundTaskSessionId;
        } catch (Exception e) {
            bVar.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("getForegroundTaskSessionId failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e);
            return "";
        }
    }

    public final String getLastActiveTaskSessionId() {
        checkInitialized();
        try {
            IAgentServiceManager iAgentServiceManager = serviceManager;
            String lastActiveTaskSessionId = iAgentServiceManager != null ? iAgentServiceManager.getLastActiveTaskSessionId() : null;
            return lastActiveTaskSessionId == null ? "" : lastActiveTaskSessionId;
        } catch (Exception e) {
            P3.c.f1086a.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("getLastActiveTaskSessionId failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e);
            return "";
        }
    }

    public final MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
        checkInitialized();
        try {
            IAgentServiceManager iAgentServiceManager = serviceManager;
            if (iAgentServiceManager != null) {
                return iAgentServiceManager.getMainDisplayTopAppHistory();
            }
            return null;
        } catch (Exception e) {
            P3.c.f1086a.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("getMainDisplayTopAppHistory failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e);
            return null;
        }
    }

    public final void init(Context context2, k stateCallback2) {
        kotlin.jvm.internal.k.f(context2, "context");
        stateCallback = stateCallback2;
        if (initialized) {
            P3.c.b(TAG, "Init ignore. Cause already init.");
            return;
        }
        P3.c.b(TAG, "Init start.");
        initialized = true;
        Context applicationContext = context2.getApplicationContext();
        kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
        context = applicationContext;
        bind(new androidx.compose.ui.text.d(15));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object isAppOccupied(java.lang.String r5, H7.c<? super com.stepos.ability.bean.AppOccupationResult> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ability.sdk.client.AgentServiceClient.C10321
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$1 r0 = (com.stepos.ability.sdk.client.AgentServiceClient.C10321) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$1 r0 = new com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.f3246a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L45
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            u9.d r4 = m9.AbstractC1691I.f5315a
            u9.c r4 = u9.c.f6743a
            com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$2 r1 = new com.stepos.ability.sdk.client.AgentServiceClient$isAppOccupied$2
            r3 = 0
            r1.<init>(r5, r3)
            r0.c = r2
            java.lang.Object r4 = m9.AbstractC1683A.w(r4, r1, r0)
            if (r4 != r6) goto L45
            return r6
        L45:
            java.lang.String r5 = "withContext(...)"
            kotlin.jvm.internal.k.e(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.sdk.client.AgentServiceClient.isAppOccupied(java.lang.String, H7.c):java.lang.Object");
    }

    public final boolean isInitialized() {
        return initialized;
    }

    public final List<TaskSnapshot> listActiveTasks() {
        checkInitialized();
        try {
            IAgentServiceManager iAgentServiceManager = serviceManager;
            List<TaskSnapshot> listListActiveTasks = iAgentServiceManager != null ? iAgentServiceManager.listActiveTasks() : null;
            return listListActiveTasks == null ? EmptyList.f4893a : listListActiveTasks;
        } catch (Exception e) {
            P3.c.f1086a.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("listActiveTasks failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), e);
            return EmptyList.f4893a;
        }
    }

    public final Object queryAbilities(String str, List<Object> list, H7.c<? super List<C2114a>> cVar) {
        C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        AgentServiceClient agentServiceClient = INSTANCE;
        agentServiceClient.checkInitialized();
        String msg = "queryAbilities called params: " + list;
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat(TAG), msg, null);
        agentServiceClient.bind(new d(c1718k, str, list));
        c1718k.j(e.f3250a);
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    public final void registerTaskListener(ITaskListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        checkInitialized();
        String strListenerKey = listenerKey(listener);
        registeredTaskListeners.put(strListenerKey, listener);
        Context context2 = context;
        if (context2 == null) {
            kotlin.jvm.internal.k.n("context");
            throw null;
        }
        withService("registerTaskListener " + context2.getPackageName() + " listener:" + listener, new R3.b(20, listener, strListenerKey));
    }

    public final void release() {
        ServiceConnection serviceConnection2;
        List<k> listF1;
        Object objA;
        if (!initialized) {
            P3.c.b(TAG, "release ignore: not initialized");
            return;
        }
        P3.c.b(TAG, "release start");
        cancelBindTimeout();
        synchronized (bindLock) {
            serviceConnection2 = serviceConnection;
            ArrayList<k> arrayList = pendingBindCallbacks;
            listF1 = v.f1(arrayList);
            arrayList.clear();
            bindingInProgress = false;
            serviceManager = null;
            serviceConnection = null;
            serviceStarted = false;
            serviceBound = false;
            initialized = false;
            registeredTaskListeners.clear();
        }
        if (serviceConnection2 != null) {
            try {
                Context context2 = context;
                if (context2 == null) {
                    kotlin.jvm.internal.k.n("context");
                    throw null;
                }
                context2.unbindService(serviceConnection2);
            } catch (Exception e) {
                P3.c.f1086a.invoke(5, "Ability_".concat(TAG), androidx.constraintlayout.core.dsl.a.h("release unbindService: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), null);
            }
        }
        for (k kVar : listF1) {
            if (kVar != null) {
                kVar.invoke(Boolean.FALSE);
            }
        }
        k kVar2 = stateCallback;
        if (kVar2 != null) {
            kVar2.invoke(Boolean.FALSE);
        }
        Iterator<T> it = connectionCallbacks.iterator();
        while (it.hasNext()) {
            try {
                ((ConnectionCallback) it.next()).onDisconnected();
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                P3.c.f1086a.invoke(5, "Ability_".concat(TAG), "release: onDisconnected callback threw", thA);
            }
        }
        connectionCallbacks.clear();
        stateCallback = null;
        P3.c.f1086a.invoke(3, "Ability_".concat(TAG), "release done", null);
    }

    public final void removeConnectionCallback(ConnectionCallback callback) {
        kotlin.jvm.internal.k.f(callback, "callback");
        connectionCallbacks.remove(callback);
    }

    public final void resumeFullScreenOverlay(String taskId) {
        withService(B7.a.k("resumeFullScreenOverlay ", taskId), new R3.c(taskId, 13));
    }

    public final void showFullScreenGuiV2(String taskId, Bundle options) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        withService("showFullScreenGuiV2 ".concat(taskId), new R3.b(21, taskId, options));
    }

    public final void submitGuiTask(g guiTaskConfig) {
        kotlin.jvm.internal.k.f(guiTaskConfig, "guiTaskConfig");
        checkInitialized();
        logSdkVersionIfNeeded();
        String msg = "submitGuiTask " + guiTaskConfig;
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat(TAG), msg, null);
        bind(new Q(guiTaskConfig, 24));
    }

    public final void submitPermissionAuthResult(final boolean agreed, final String toolCallId, final Bundle extras) {
        kotlin.jvm.internal.k.f(toolCallId, "toolCallId");
        kotlin.jvm.internal.k.f(extras, "extras");
        withService("submitPermissionAuthResult agreed=" + agreed, new k() { // from class: com.stepos.ability.sdk.client.a
            @Override // S7.k
            public final Object invoke(Object obj) {
                return AgentServiceClient.submitPermissionAuthResult$lambda$0(agreed, toolCallId, extras, (IAgentServiceManager) obj);
            }
        });
    }

    public final void submitTooCallEvent(Context context2, ToolCallEvent toolCallEvent) {
        kotlin.jvm.internal.k.f(context2, "context");
        kotlin.jvm.internal.k.f(toolCallEvent, "toolCallEvent");
        checkInitialized();
        bind(new Q(toolCallEvent, 25));
    }

    public final void submitToolTask(h toolTaskConfig) {
        kotlin.jvm.internal.k.f(toolTaskConfig, "toolTaskConfig");
        checkInitialized();
        logSdkVersionIfNeeded();
        String msg = "submitToolTask " + toolTaskConfig;
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat(TAG), msg, null);
        bind(new Q(toolTaskConfig, 23));
    }

    public final void submitUserInput(String taskId, String requestId, String content) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(requestId, "requestId");
        kotlin.jvm.internal.k.f(content, "content");
        withService(androidx.constraintlayout.core.dsl.a.j(new StringBuilder("submitUserInput "), taskId, " ", requestId), new i(taskId, requestId, content, 1));
    }

    public final void takeOverGui(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        withService("takeOverGui ".concat(taskId), new R3.c(taskId, 8));
    }

    public final void unRegisterTaskListener(ITaskListener listener) {
        kotlin.jvm.internal.k.f(listener, "listener");
        checkInitialized();
        String strListenerKey = listenerKey(listener);
        registeredTaskListeners.remove(strListenerKey);
        Context context2 = context;
        if (context2 == null) {
            kotlin.jvm.internal.k.n("context");
            throw null;
        }
        withService("unRegisterTaskListener " + context2.getPackageName() + " listener:" + listener, new R3.c(strListenerKey, 9));
    }

    public final void unTakeOverGui(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        withService("unTakeOverGui ".concat(taskId), new R3.c(taskId, 11));
    }

    public final void updateGuiAgent(String taskId, g config) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(config, "config");
        withService("updateGuiAgent ".concat(taskId), new R3.b(18, taskId, config));
    }
}
