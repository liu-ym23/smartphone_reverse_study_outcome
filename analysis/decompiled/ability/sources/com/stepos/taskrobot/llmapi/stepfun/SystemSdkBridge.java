package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import D7.v;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.Surface;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.mdisdk.TaskManager;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.model.WindowType;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.KeepAliveHelper;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.commoninternal.NetworkStateBridge;
import com.stepos.ability.commoninternal.VirtualDisplayCgroupHelper;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.common.bean.AppOccupationResult;
import com.stepos.taskrobot.common.bean.MainDisplayTopAppHistory;
import com.stepos.taskrobot.llmapi.stepfun.RedirectTaskMatcher;
import com.stepos.taskrobot.llmapi.stepfun.TaskParamsParser;
import com.stepos.taskrobot.llmapi.stepfun.internal.ChatActiveQuery;
import com.stepos.taskrobot.llmapi.stepfun.internal.ConflictVisibilityDecider;
import com.stepos.taskrobot.notification.TaskRobotNotifier;
import f6.AbstractC1436a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import org.json.JSONObject;
import p9.t;
import stepai.aios.guiagent.ability.GuiAbilityProvider;
import stepai.aios.guiagent.llm.cell.config.IModelConfig;
import stepai.aios.guiagent.llm.cell.config.ModelConfigs;
import stepai.aios.guiagent.llm.parser.IModelCell;
import stepai.aios.guiagent.model.SessionState;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import ua.C2052a;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000Ú\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\bÑ\u0002Ò\u0002Ó\u0002Ô\u0002B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001a¢\u0006\u0004\b!\u0010\"J\u008b\u0001\u00103\u001a\u0004\u0018\u0001022\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00100\u001a\u00020%2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u0004\u0018\u0001022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u0004\u0018\u00010\u00042\u0006\u00107\u001a\u00020\u0004¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u0004¢\u0006\u0004\b:\u0010\u001cJ!\u0010@\u001a\f\u0012\b\u0012\u00060<j\u0002`=0;2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b>\u0010?J!\u0010E\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010AH\u0000¢\u0006\u0004\bC\u0010DJ!\u0010H\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\bG\u0010\u0018J\u0017\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010KJ\u0017\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u0004\u0018\u00010O2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bP\u0010QJ\u0015\u0010R\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bR\u0010SJ\u0013\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040T¢\u0006\u0004\bU\u0010VJ\r\u0010W\u001a\u00020%¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\u001a¢\u0006\u0004\bY\u0010\"J\u0015\u0010Z\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bZ\u0010\u001cJ)\u0010]\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010[\u001a\u00020\u001a2\b\b\u0002\u0010\\\u001a\u00020\u0004¢\u0006\u0004\b]\u0010^J\u001a\u0010_\u001a\u00020\b2\b\b\u0002\u0010[\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b_\u0010`J\u001f\u0010a\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u0004¢\u0006\u0004\ba\u0010bJ \u0010c\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bc\u0010dJ\u001a\u0010f\u001a\u0004\u0018\u00010e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bf\u0010gJ \u0010h\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bh\u0010dJ\u001a\u0010i\u001a\u0004\u0018\u00010e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bi\u0010gJ\u0017\u0010k\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\bj\u0010\u0013J\u0019\u0010m\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\bl\u00109J\u0017\u0010o\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\bn\u0010\u0013J\u0015\u0010p\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bp\u0010\u001cJ\u0015\u0010q\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bq\u0010\u001cJ\u0018\u0010r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\br\u0010gJ\u0018\u0010s\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bs\u0010gJ\u0018\u0010t\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bt\u0010gJ!\u0010v\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\bv\u0010wJ/\u0010z\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010x\u001a\u00020\u00042\b\u0010y\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bz\u0010{J\u0017\u0010}\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b|\u0010\u001cJ#\u0010\u0081\u0001\u001a\u00020\u001a2\u0006\u0010~\u001a\u00020\u00042\b\u0010\u007f\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0005\b\u0080\u0001\u0010bJ\u001c\u0010\u0084\u0001\u001a\u00020\u001a2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0005\b\u0083\u0001\u0010\u001cJ*\u0010\u0087\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010y\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J,\u0010\u008b\u0001\u001a\u00020\b2\u0006\u0010~\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u00042\u0007\u0010\u0089\u0001\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u0086\u0001J\u0017\u0010\u008c\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\b\u008c\u0001\u0010\u0013J\u0019\u0010\u008d\u0001\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0005\b\u008d\u0001\u0010\u0013J\u0019\u0010\u008e\u0001\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0005\b\u008e\u0001\u0010\u0013J\u001c\u0010\u0093\u0001\u001a\u00020\b2\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0000¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u0019\u0010\u0095\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0005\b\u0094\u0001\u0010\u0013J\u0019\u0010\u0097\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0005\b\u0096\u0001\u0010\u0013J$\u0010\u009b\u0001\u001a\u00020\b2\b\u0010\u0098\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u001c\u0010\u009d\u0001\u001a\u00020\b2\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u0092\u0001J\u0011\u0010\u009f\u0001\u001a\u00020\u001aH\u0000¢\u0006\u0005\b\u009e\u0001\u0010\"J\"\u0010 \u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0006\b \u0001\u0010¡\u0001J\u000f\u0010¢\u0001\u001a\u00020\b¢\u0006\u0005\b¢\u0001\u0010\u0003J!\u0010£\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0004¢\u0006\u0005\b£\u0001\u0010\u0018J\u0019\u0010¤\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\b¤\u0001\u00109J+\u0010¦\u0001\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020%2\t\u0010¥\u0001\u001a\u0004\u0018\u00010+¢\u0006\u0006\b¦\u0001\u0010§\u0001J \u0010¨\u0001\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00100\u001a\u00020%¢\u0006\u0006\b¨\u0001\u0010©\u0001JG\u0010\u00ad\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010x\u001a\u00020\u00042\f\b\u0002\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00012\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001JH\u0010°\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010x\u001a\u00020\u00042\f\b\u0002\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00012\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010¯\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0006\b°\u0001\u0010®\u0001J\u0081\u0001\u0010¶\u0001\u001a\u00020\b2\u000b\b\u0002\u0010±\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010²\u0001\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020%2\u0007\u0010³\u0001\u001a\u00020%2\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00012\b\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00100\u001a\u00020%¢\u0006\u0006\b¶\u0001\u0010·\u0001J%\u0010º\u0001\u001a\u00020\b2\u0007\u0010¸\u0001\u001a\u00020\u00042\u0007\u0010¹\u0001\u001a\u00020%H\u0086@¢\u0006\u0006\bº\u0001\u0010»\u0001J\"\u0010¼\u0001\u001a\u00020\b2\u0007\u0010¸\u0001\u001a\u00020\u00042\u0007\u0010¹\u0001\u001a\u00020%¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u0017\u0010¿\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040¾\u0001¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0010\u0010Á\u0001\u001a\u00020\u0004¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J%\u0010Ä\u0001\u001a\u00020\b2\u0007\u0010±\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0004¢\u0006\u0005\bÄ\u0001\u0010\u0018J\u000f\u0010Å\u0001\u001a\u00020%¢\u0006\u0005\bÅ\u0001\u0010XJ\u0018\u0010Æ\u0001\u001a\u00020\u001a2\u0007\u0010±\u0001\u001a\u00020\u0004¢\u0006\u0005\bÆ\u0001\u0010\u001cJ\u0018\u0010Ç\u0001\u001a\u00020\u001a2\u0007\u0010±\u0001\u001a\u00020\u0004¢\u0006\u0005\bÇ\u0001\u0010\u001cJ\u001a\u0010È\u0001\u001a\u00020%2\u0006\u00107\u001a\u00020\u0004H\u0086@¢\u0006\u0005\bÈ\u0001\u0010gJ\u001a\u0010É\u0001\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u0004H\u0086@¢\u0006\u0005\bÉ\u0001\u0010gJ#\u0010Ì\u0001\u001a\u00030Ë\u00012\u0007\u0010Ê\u0001\u001a\u00020\u00042\u0007\u0010¸\u0001\u001a\u00020\u0004¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J!\u0010Î\u0001\u001a\u00020\b2\u0007\u0010Ê\u0001\u001a\u00020\u00042\u0007\u0010¸\u0001\u001a\u00020\u0004¢\u0006\u0005\bÎ\u0001\u0010\u0018J \u0010Ï\u0001\u001a\u00020\b2\u0007\u0010Ê\u0001\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\bÏ\u0001\u0010\u0018J\u001d\u0010Ñ\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040Ð\u0001¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u0019\u0010Ô\u0001\u001a\u00030Ó\u00012\u0006\u0010$\u001a\u00020\u0004¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u0010\u0010Ö\u0001\u001a\u00020\u0004¢\u0006\u0006\bÖ\u0001\u0010Â\u0001J\u0010\u0010×\u0001\u001a\u00020\u0004¢\u0006\u0006\b×\u0001\u0010Â\u0001J\u0010\u0010Ø\u0001\u001a\u00020\u0004¢\u0006\u0006\bØ\u0001\u0010Â\u0001J\u0018\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010¾\u0001¢\u0006\u0006\bÚ\u0001\u0010À\u0001J\u0017\u0010Û\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\bÛ\u0001\u0010\u0013J*\u0010Þ\u0001\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010Ü\u0001\u001a\u00020\u00042\u0007\u0010Ý\u0001\u001a\u00020\u0004¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J+\u0010à\u0001\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010Ü\u0001\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u0004¢\u0006\u0006\bà\u0001\u0010ß\u0001J$\u0010â\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010á\u0001\u001a\u0005\u0018\u00010´\u0001¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u0019\u0010ä\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\bä\u0001\u00109J\u0011\u0010æ\u0001\u001a\u00030å\u0001¢\u0006\u0006\bæ\u0001\u0010ç\u0001J'\u0010é\u0001\u001a\u00020\b*\u00020'2\u0006\u0010\u0005\u001a\u00020\u00042\u0007\u0010è\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0006\bé\u0001\u0010ê\u0001J\u001b\u0010ì\u0001\u001a\u00020\b2\u0007\u0010ë\u0001\u001a\u000202H\u0002¢\u0006\u0006\bì\u0001\u0010í\u0001J!\u0010î\u0001\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010x\u001a\u00020\u0004H\u0002¢\u0006\u0005\bî\u0001\u0010bJ\u001b\u0010ð\u0001\u001a\u00030ï\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\u0019\u0010ò\u0001\u001a\u00020\b2\u0006\u0010~\u001a\u00020\u0004H\u0002¢\u0006\u0005\bò\u0001\u0010\u0013J\u001a\u0010ô\u0001\u001a\u00020\b2\u0007\u0010ó\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\bô\u0001\u0010\u0013J$\u0010õ\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0006\bõ\u0001\u0010¡\u0001J\u001c\u0010ö\u0001\u001a\u0004\u0018\u00010'2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0006\bö\u0001\u0010÷\u0001J\u0019\u0010ø\u0001\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bø\u0001\u0010\u0013J\u001b\u0010ù\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0005\bù\u0001\u00109J\u0015\u0010ú\u0001\u001a\u0004\u0018\u00010IH\u0082@¢\u0006\u0006\bú\u0001\u0010û\u0001J\u0012\u0010ü\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0006\bü\u0001\u0010Â\u0001J\u001b\u0010þ\u0001\u001a\u00030ý\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0006\bþ\u0001\u0010ÿ\u0001J\u009d\u0001\u0010\u0081\u0002\u001a\u00020\b2\u0007\u0010¸\u0001\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u00042\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010²\u0001\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020%2\u0007\u0010³\u0001\u001a\u00020%2\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00012\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u00100\u001a\u00020%2\u0007\u0010\u0080\u0002\u001a\u00020\u0004H\u0002¢\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002J+\u0010\u0083\u0002\u001a\u00020\b2\u0007\u0010¸\u0001\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u0010~\u001a\u00020\u0004H\u0002¢\u0006\u0006\b\u0083\u0002\u0010\u0086\u0001J&\u0010\u0087\u0002\u001a\u00020\b2\b\u0010\u0085\u0002\u001a\u00030\u0084\u00022\u0007\u0010\u0086\u0002\u001a\u000202H\u0082@¢\u0006\u0006\b\u0087\u0002\u0010\u0088\u0002J4\u0010\u008b\u0002\u001a\u00020\b2\u0007\u0010\u0089\u0002\u001a\u00020I2\u0007\u0010\u008a\u0002\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u0004H\u0002¢\u0006\u0006\b\u008b\u0002\u0010\u008c\u0002J<\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008d\u00022\u0007\u0010²\u0001\u001a\u00020\u00042\n\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00012\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\b\u008e\u0002\u0010\u008f\u0002R\u0017\u0010\u0090\u0002\u001a\u00020\u00048\u0002X\u0082T¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0017\u0010\u0092\u0002\u001a\u00020%8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002R\u0017\u0010\u0094\u0002\u001a\u00020%8\u0006X\u0086T¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u0093\u0002R\u0017\u0010\u0095\u0002\u001a\u00020\u00048\u0002X\u0082T¢\u0006\b\n\u0006\b\u0095\u0002\u0010\u0091\u0002R\u0018\u0010\u0097\u0002\u001a\u00030\u0096\u00028\u0002X\u0082T¢\u0006\b\n\u0006\b\u0097\u0002\u0010\u0098\u0002R\u0019\u0010\u0099\u0002\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u0018\u0010\u009b\u0002\u001a\u00030ý\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R%\u0010\u009e\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030ý\u00010\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0002\u0010\u009f\u0002R\u001b\u0010 \u0002\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0002\u0010¡\u0002R\u0018\u0010¢\u0002\u001a\u00030ý\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0002\u0010\u009c\u0002R\u0018\u0010¤\u0002\u001a\u00030£\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R\u0018\u0010§\u0002\u001a\u00030¦\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0002\u0010¨\u0002R\u0019\u0010©\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b©\u0002\u0010ª\u0002R\u001a\u0010¬\u0002\u001a\u00030«\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¬\u0002\u0010\u00ad\u0002R$\u0010®\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002020\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0002\u0010\u009f\u0002R!\u0010´\u0002\u001a\u00030¯\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b°\u0002\u0010±\u0002\u001a\u0006\b²\u0002\u0010³\u0002R\u0017\u0010µ\u0002\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010\u0093\u0002R\u0017\u0010¶\u0002\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0002\u0010\u0093\u0002R\u0017\u0010·\u0002\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0002\u0010\u0093\u0002R%\u0010¹\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030¸\u00020\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0002\u0010\u009f\u0002R$\u0010º\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0002\u0010\u009f\u0002R$\u0010»\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0002\u0010\u009f\u0002R\u001e\u0010½\u0002\u001a\t\u0012\u0004\u0012\u00020+0¼\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R$\u0010¿\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0002\u0010\u009f\u0002R\u0018\u0010Á\u0002\u001a\u00030À\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u001a\u0010Ä\u0002\u001a\u00030Ã\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R\u001e\u0010Ç\u0002\u001a\t\u0012\u0004\u0012\u00020\b0Æ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÇ\u0002\u0010È\u0002R$\u0010É\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÉ\u0002\u0010\u009f\u0002R%\u0010Ë\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030Ê\u00020\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0002\u0010\u009f\u0002R$\u0010Ì\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u009d\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0002\u0010\u009f\u0002R\u0017\u0010Í\u0002\u001a\u00020\u00048\u0006X\u0086T¢\u0006\b\n\u0006\bÍ\u0002\u0010\u0091\u0002R\u0017\u0010Î\u0002\u001a\u00020\u00048\u0006X\u0086T¢\u0006\b\n\u0006\bÎ\u0002\u0010\u0091\u0002R\u001c\u0010\u001b\u001a\u00020\u001a8FX\u0087\u0004¢\u0006\u000e\u0012\u0005\bÐ\u0002\u0010\u0003\u001a\u0005\bÏ\u0002\u0010\"¨\u0006Õ\u0002"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge;", "", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "Landroid/net/Uri;", "uri", "LC7/r;", "registerDocUri$stepfun_release", "(Ljava/lang/String;Landroid/net/Uri;)V", "registerDocUri", "getDocUriForTask$stepfun_release", "(Ljava/lang/String;)Landroid/net/Uri;", "getDocUriForTask", "resolveCurrentTaskId$stepfun_release", "(Landroid/net/Uri;)Ljava/lang/String;", "resolveCurrentTaskId", "unregisterDocUri$stepfun_release", "(Ljava/lang/String;)V", "unregisterDocUri", "fromTaskId", "toTaskId", "transferDocUri$stepfun_release", "(Ljava/lang/String;Ljava/lang/String;)V", "transferDocUri", "", "fullScreenInteractionEnabled", "(Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "isInitialized", "()Z", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "appName", "", "taskType", "Landroid/view/Surface;", "surface", "Lm9/z;", "scope", "Lcom/stepos/taskrobot/common/ITaskProgressCallback;", "progressCallback", "guiModelName", "chatSessionId", "subSessionId", "callerPid", "resolvedPackageName", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "createTask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/view/Surface;Lm9/z;Lcom/stepos/taskrobot/common/ITaskProgressCallback;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "getTask", "(Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "packageName", "findTaskIdByPackage", "(Ljava/lang/String;)Ljava/lang/String;", "showFullScreenForPackage", "Lp9/t;", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper$FullScreenTaskUiState;", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenTaskUiState;", "observeFullScreenTaskUiState$stepfun_release", "(Ljava/lang/String;)Lp9/t;", "observeFullScreenTaskUiState", "Lstepai/aios/guiagent/model/SessionState;", "state", "updateFullScreenTaskState$stepfun_release", "(Ljava/lang/String;Lstepai/aios/guiagent/model/SessionState;)V", "updateFullScreenTaskState", "explain", "updateFullScreenTaskExplain$stepfun_release", "updateFullScreenTaskExplain", "Lcom/mdisdk/Task;", "getMdiTask", "(Ljava/lang/String;)Lcom/mdisdk/Task;", "Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "getExecutor", "(Ljava/lang/String;)Lstepai/aios/guiexecutor/api/GuiActionExecutor;", "Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "getAbilityProvider", "(Ljava/lang/String;)Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "getDisplayId", "(Ljava/lang/String;)I", "", "getActiveTaskIds", "()Ljava/util/Set;", "getActiveTaskCount", "()I", "hasAnyActiveHandle", "hasTask", "ignoreActions", "reason", "clearTask", "(Ljava/lang/String;ZLjava/lang/String;)V", "clearAllTasks", "(ZLH7/c;)Ljava/lang/Object;", "cancelTask", "(Ljava/lang/String;Ljava/lang/String;)Z", "pause", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lza/d;", "resume", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "takeoverTask", "recoverFromTakeover", "onLlmRequestTakeover$stepfun_release", "onLlmRequestTakeover", "getLastLlmTakeoverMessage$stepfun_release", "getLastLlmTakeoverMessage", "onFullscreenTouchInjectionEnabled$stepfun_release", "onFullscreenTouchInjectionEnabled", "isFullScreenActivityBoundToTask", "isTaskTakenOverByExternal", "onTaskCompleted", "switchToVirtualDisplay", "switchToMainDisplay", "enableInteraction", "showFullScreenActivity", "(Ljava/lang/String;Ljava/lang/Boolean;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "message", "onTaskActionForNotification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isCallerVisibleForTask$stepfun_release", "isCallerVisibleForTask", "runningTaskId", "newChatSessionId", "isConflictVisibleToCaller$stepfun_release", "isConflictVisibleToCaller", "sessionId", "isChatActive$stepfun_release", "isChatActive", "showInfoNotification$stepfun_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "showInfoNotification", "newTaskName", "newTaskAppName", "showConflictNotification$stepfun_release", "showConflictNotification", "hideFullScreenActivity", "dismissFullScreenOverlay", "resumeFullScreenOverlay", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;", "activity", "onFullScreenActivityCreated$stepfun_release", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;)V", "onFullScreenActivityCreated", "onFullScreenActivityForeground$stepfun_release", "onFullScreenActivityForeground", "onFullScreenActivityBackground$stepfun_release", "onFullScreenActivityBackground", "destroyed", "onFullScreenActivityDestroyed$stepfun_release", "(Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenActivity;Ljava/lang/String;)V", "onFullScreenActivityDestroyed", "ensureFullScreenActivityRegistered$stepfun_release", "ensureFullScreenActivityRegistered", "isFullScreenActivityInForeground$stepfun_release", "isFullScreenActivityInForeground", "setOutputSurface", "(Ljava/lang/String;Landroid/view/Surface;)V", "clearAllPendingSurfaces", "setChatSessionId", "peekPendingChatSessionId", "callback", "registerProgressCallback", "(Ljava/lang/String;ILcom/stepos/taskrobot/common/ITaskProgressCallback;)Z", "unregisterProgressCallback", "(Ljava/lang/String;I)Z", "Landroid/graphics/Bitmap;", "bitmap", GuiTaskProgressKt.GuiTaskProgress_KEY_BITMAP_ID, "notifyProgressChanged", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", BffConstant.Type.Url, "notifyProgressChangedPair", "modelId", "paramsJson", "startMode", "Landroid/os/Bundle;", "bundle", "startTask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/Surface;IILandroid/os/Bundle;Lcom/stepos/taskrobot/common/ITaskProgressCallback;Ljava/lang/String;Ljava/lang/String;I)V", "newTaskId", "conflictKind", "confirmPackageConflict", "(Ljava/lang/String;ILH7/c;)Ljava/lang/Object;", "cancelPackageConflict", "(Ljava/lang/String;I)V", "", "getModelOptions", "()Ljava/util/List;", "getCurrentModelId", "()Ljava/lang/String;", "modelCellType", "addModel", "removeAllCustomModels", "deleteCustomModelById", "isCustomModel", "getShowingDisplayId", "isOmniDisplayId", "pkg", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision;", "reservePackageForTask", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision;", "forceTakePackageForTask", "releasePackageFromTask", "", "getPackageToTaskIdSnapshot", "()Ljava/util/Map;", "Lcom/stepos/taskrobot/common/bean/AppOccupationResult;", "queryAppOccupation", "(Ljava/lang/String;)Lcom/stepos/taskrobot/common/bean/AppOccupationResult;", "getForegroundTaskId", "getForegroundTaskSessionId", "getLastActiveTaskSessionId", "Lcom/stepos/taskrobot/common/bean/TaskSnapshot;", "listActiveTasks", "dismissVoiceInput", "requestId", "content", "submitUserInput", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "cancelUserInput", "options", "showFullScreenActivityV2", "(Ljava/lang/String;Landroid/os/Bundle;)V", "getTargetPackageOverride", "Lcom/stepos/taskrobot/common/bean/MainDisplayTopAppHistory;", "getMainDisplayTopAppHistory", "()Lcom/stepos/taskrobot/common/bean/MainDisplayTopAppHistory;", "what", "safeRelease", "(Landroid/view/Surface;Ljava/lang/String;Ljava/lang/String;)V", "guiTask", "preShowReopenTargetAppIfOnLauncher", "(Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;)V", "shouldSuppressTakeover", "Landroid/app/PendingIntent;", "buildLiveNotificationIntent", "(Ljava/lang/String;)Landroid/app/PendingIntent;", "resendPackageConflictsForRunningTask", "terminalTaskId", "cancelPendingConflictsBlockedBy", "cachePendingSurface", "takePendingSurface", "(Ljava/lang/String;)Landroid/view/Surface;", "evictPendingSurface", "takePendingChatSessionId", "getOrCreateQueryTask", "(LH7/c;)Ljava/lang/Object;", "generateTaskId", "Lw9/a;", "getExecutionMutex", "(Ljava/lang/String;)Lw9/a;", "openAppName", "handleStartConflict", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/Surface;IILandroid/os/Bundle;Lcom/stepos/taskrobot/common/ITaskProgressCallback;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "handleResumeConflict", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict$Start;", "pending", "oldTask", "continueTaskInPlace", "(Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict$Start;Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;LH7/c;)Ljava/lang/Object;", "mdiTask", WindowStateInfo.KEY_DISPLAY_ID, "handoverFailureCleanup", "(Lcom/mdisdk/Task;ILjava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ParsedStartParams;", "parseStartParams", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Lcom/stepos/taskrobot/common/ITaskProgressCallback;)Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ParsedStartParams;", "TAG", "Ljava/lang/String;", "FALLBACK_DISPLAY_ID", "I", "NO_CALLER_PID", "QUERY_TASK_ID", "", "QUERY_TASK_IDLE_TIMEOUT_MS", "J", "initialized", "Z", "taskMutex", "Lw9/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "executionMutexMap", "Ljava/util/concurrent/ConcurrentHashMap;", "queryTask", "Lcom/mdisdk/Task;", "queryTaskMutex", "Ljava/lang/Runnable;", "queryTaskIdleRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/taskrobot/llmapi/stepfun/MainDisplayWatcher;", "mainDisplayWatcher", "Lcom/stepos/taskrobot/llmapi/stepfun/MainDisplayWatcher;", "appContext", "Landroid/content/Context;", "Landroid/hardware/display/DisplayManager;", "displayManager", "Landroid/hardware/display/DisplayManager;", "tasks", "Lcom/stepos/taskrobot/notification/TaskRobotNotifier;", "notifier$delegate", "LC7/f;", "getNotifier", "()Lcom/stepos/taskrobot/notification/TaskRobotNotifier;", "notifier", "NOTIF_ICON_RES", "NOTIF_THUMBNAIL_RES", "NOTIF_CAPSULE_ICON_RES", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingSurfaceEntry;", "pendingOutputSurfaces", "taskIdToDocUri", "docUriToCurrentTaskId", "Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskCache;", "endedTaskCache", "Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskCache;", "pendingChatSessionIds", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper;", "fullScreenHelper", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper;", "Lkotlin/Function0;", "networkLostListener", "LS7/a;", "packageToTaskId", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict;", "pendingConflicts", "targetPackageOverride", "KEY_ENABLE_INTERACTION_V2", "KEY_TARGET_PACKAGE_V2", "getFullScreenInteractionEnabled", "getFullScreenInteractionEnabled$annotations", "PendingSurfaceEntry", "ParsedStartParams", "PendingConflict", "ConflictDecision", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SystemSdkBridge {
    private static final int FALLBACK_DISPLAY_ID = -1;
    public static final String KEY_ENABLE_INTERACTION_V2 = "fs_enable_interaction";
    public static final String KEY_TARGET_PACKAGE_V2 = "fs_target_package";
    private static final int NOTIF_CAPSULE_ICON_RES;
    private static final int NOTIF_ICON_RES;
    private static final int NOTIF_THUMBNAIL_RES;
    public static final int NO_CALLER_PID = -1;
    private static final String QUERY_TASK_ID = "__query_task__";
    private static final long QUERY_TASK_IDLE_TIMEOUT_MS = 600000;
    private static final String TAG = "SystemSdkBridge";
    private static Context appContext;
    private static DisplayManager displayManager;
    private static final ConcurrentHashMap<String, String> docUriToCurrentTaskId;
    private static final EndedTaskCache<ITaskProgressCallback> endedTaskCache;
    private static FullScreenHelper fullScreenHelper;
    private static volatile boolean initialized;
    private static final Handler mainHandler;
    private static final S7.a networkLostListener;
    private static final ConcurrentHashMap<String, String> packageToTaskId;
    private static final ConcurrentHashMap<String, String> pendingChatSessionIds;
    private static final ConcurrentHashMap<String, PendingConflict> pendingConflicts;
    private static final ConcurrentHashMap<String, PendingSurfaceEntry> pendingOutputSurfaces;
    private static volatile Task queryTask;
    private static final ConcurrentHashMap<String, String> targetPackageOverride;
    private static final ConcurrentHashMap<String, Uri> taskIdToDocUri;
    public static final SystemSdkBridge INSTANCE = new SystemSdkBridge();
    private static final InterfaceC2108a taskMutex = new kotlinx.coroutines.sync.a();
    private static final ConcurrentHashMap<String, InterfaceC2108a> executionMutexMap = new ConcurrentHashMap<>();
    private static final InterfaceC2108a queryTaskMutex = new kotlinx.coroutines.sync.a();
    private static final Runnable queryTaskIdleRunnable = new h();
    private static final MainDisplayWatcher mainDisplayWatcher = new MainDisplayWatcher();
    private static final ConcurrentHashMap<String, ZyqlGuiAgentTask> tasks = new ConcurrentHashMap<>();

    /* renamed from: notifier$delegate, reason: from kotlin metadata */
    private static final C7.f notifier = kotlin.a.a(new i(0));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision;", "", AppAgent.CONSTRUCT, "()V", "OK", "Conflict", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision$Conflict;", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision$OK;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ConflictDecision {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision$Conflict;", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision;", "existingTaskId", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "getExistingTaskId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Conflict extends ConflictDecision {
            private final String existingTaskId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Conflict(String existingTaskId) {
                super(null);
                kotlin.jvm.internal.k.f(existingTaskId, "existingTaskId");
                this.existingTaskId = existingTaskId;
            }

            public static /* synthetic */ Conflict copy$default(Conflict conflict, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = conflict.existingTaskId;
                }
                return conflict.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getExistingTaskId() {
                return this.existingTaskId;
            }

            public final Conflict copy(String existingTaskId) {
                kotlin.jvm.internal.k.f(existingTaskId, "existingTaskId");
                return new Conflict(existingTaskId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Conflict) && kotlin.jvm.internal.k.b(this.existingTaskId, ((Conflict) other).existingTaskId);
            }

            public final String getExistingTaskId() {
                return this.existingTaskId;
            }

            public int hashCode() {
                return this.existingTaskId.hashCode();
            }

            public String toString() {
                return B7.a.m("Conflict(existingTaskId=", this.existingTaskId, ")");
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision$OK;", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ConflictDecision;", AppAgent.CONSTRUCT, "()V", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class OK extends ConflictDecision {
            public static final OK INSTANCE = new OK();

            private OK() {
                super(null);
            }
        }

        public /* synthetic */ ConflictDecision(kotlin.jvm.internal.e eVar) {
            this();
        }

        private ConflictDecision() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J%\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$ParsedStartParams;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", "meta", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "guiModelName", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)V", "getTaskName", "()Ljava/lang/String;", "getMeta", "()Ljava/util/HashMap;", "getGuiModelName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ParsedStartParams {
        private final String guiModelName;
        private final HashMap<String, Object> meta;
        private final String taskName;

        public ParsedStartParams(String taskName, HashMap<String, Object> meta, String str) {
            kotlin.jvm.internal.k.f(taskName, "taskName");
            kotlin.jvm.internal.k.f(meta, "meta");
            this.taskName = taskName;
            this.meta = meta;
            this.guiModelName = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParsedStartParams copy$default(ParsedStartParams parsedStartParams, String str, HashMap map, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parsedStartParams.taskName;
            }
            if ((i & 2) != 0) {
                map = parsedStartParams.meta;
            }
            if ((i & 4) != 0) {
                str2 = parsedStartParams.guiModelName;
            }
            return parsedStartParams.copy(str, map, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTaskName() {
            return this.taskName;
        }

        public final HashMap<String, Object> component2() {
            return this.meta;
        }

        /* renamed from: component3, reason: from getter */
        public final String getGuiModelName() {
            return this.guiModelName;
        }

        public final ParsedStartParams copy(String taskName, HashMap<String, Object> meta, String guiModelName) {
            kotlin.jvm.internal.k.f(taskName, "taskName");
            kotlin.jvm.internal.k.f(meta, "meta");
            return new ParsedStartParams(taskName, meta, guiModelName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsedStartParams)) {
                return false;
            }
            ParsedStartParams parsedStartParams = (ParsedStartParams) other;
            return kotlin.jvm.internal.k.b(this.taskName, parsedStartParams.taskName) && kotlin.jvm.internal.k.b(this.meta, parsedStartParams.meta) && kotlin.jvm.internal.k.b(this.guiModelName, parsedStartParams.guiModelName);
        }

        public final String getGuiModelName() {
            return this.guiModelName;
        }

        public final HashMap<String, Object> getMeta() {
            return this.meta;
        }

        public final String getTaskName() {
            return this.taskName;
        }

        public int hashCode() {
            int iHashCode = (this.meta.hashCode() + (this.taskName.hashCode() * 31)) * 31;
            String str = this.guiModelName;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.taskName;
            HashMap<String, Object> map = this.meta;
            String str2 = this.guiModelName;
            StringBuilder sb = new StringBuilder("ParsedStartParams(taskName=");
            sb.append(str);
            sb.append(", meta=");
            sb.append(map);
            sb.append(", guiModelName=");
            return B7.a.q(sb, str2, ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict;", "", AppAgent.CONSTRUCT, "()V", "newTaskId", "", "getNewTaskId", "()Ljava/lang/String;", "packageName", "getPackageName", "conflictKind", "", "getConflictKind", "()I", "Start", "Resume", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict$Resume;", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict$Start;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class PendingConflict {
        public /* synthetic */ PendingConflict(kotlin.jvm.internal.e eVar) {
            this();
        }

        public abstract int getConflictKind();

        public abstract String getNewTaskId();

        public abstract String getPackageName();

        private PendingConflict() {
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict$Resume;", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict;", "newTaskId", "", "packageName", "conflictKind", "", "runningTaskId", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getNewTaskId", "()Ljava/lang/String;", "getPackageName", "getConflictKind", "()I", "getRunningTaskId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Resume extends PendingConflict {
            private final int conflictKind;
            private final String newTaskId;
            private final String packageName;
            private final String runningTaskId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resume(String newTaskId, String packageName, int i, String runningTaskId) {
                super(null);
                kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
                kotlin.jvm.internal.k.f(packageName, "packageName");
                kotlin.jvm.internal.k.f(runningTaskId, "runningTaskId");
                this.newTaskId = newTaskId;
                this.packageName = packageName;
                this.conflictKind = i;
                this.runningTaskId = runningTaskId;
            }

            public static /* synthetic */ Resume copy$default(Resume resume, String str, String str2, int i, String str3, int i6, Object obj) {
                if ((i6 & 1) != 0) {
                    str = resume.newTaskId;
                }
                if ((i6 & 2) != 0) {
                    str2 = resume.packageName;
                }
                if ((i6 & 4) != 0) {
                    i = resume.conflictKind;
                }
                if ((i6 & 8) != 0) {
                    str3 = resume.runningTaskId;
                }
                return resume.copy(str, str2, i, str3);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewTaskId() {
                return this.newTaskId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getPackageName() {
                return this.packageName;
            }

            /* renamed from: component3, reason: from getter */
            public final int getConflictKind() {
                return this.conflictKind;
            }

            /* renamed from: component4, reason: from getter */
            public final String getRunningTaskId() {
                return this.runningTaskId;
            }

            public final Resume copy(String newTaskId, String packageName, int conflictKind, String runningTaskId) {
                kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
                kotlin.jvm.internal.k.f(packageName, "packageName");
                kotlin.jvm.internal.k.f(runningTaskId, "runningTaskId");
                return new Resume(newTaskId, packageName, conflictKind, runningTaskId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Resume)) {
                    return false;
                }
                Resume resume = (Resume) other;
                return kotlin.jvm.internal.k.b(this.newTaskId, resume.newTaskId) && kotlin.jvm.internal.k.b(this.packageName, resume.packageName) && this.conflictKind == resume.conflictKind && kotlin.jvm.internal.k.b(this.runningTaskId, resume.runningTaskId);
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.PendingConflict
            public int getConflictKind() {
                return this.conflictKind;
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.PendingConflict
            public String getNewTaskId() {
                return this.newTaskId;
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.PendingConflict
            public String getPackageName() {
                return this.packageName;
            }

            public final String getRunningTaskId() {
                return this.runningTaskId;
            }

            public int hashCode() {
                return this.runningTaskId.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.conflictKind, B7.a.c(this.newTaskId.hashCode() * 31, 31, this.packageName), 31);
            }

            public String toString() {
                String str = this.newTaskId;
                String str2 = this.packageName;
                int i = this.conflictKind;
                String str3 = this.runningTaskId;
                StringBuilder sbW = B7.a.w("Resume(newTaskId=", str, ", packageName=", str2, ", conflictKind=");
                sbW.append(i);
                sbW.append(", runningTaskId=");
                sbW.append(str3);
                sbW.append(")");
                return sbW.toString();
            }

            public /* synthetic */ Resume(String str, String str2, int i, String str3, int i6, kotlin.jvm.internal.e eVar) {
                this(str, str2, (i6 & 4) != 0 ? 2 : i, str3);
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003Jµ\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020\u0006HÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006E"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict$Start;", "Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingConflict;", "newTaskId", "", "packageName", "conflictKind", "", "runningTaskId", "modelId", "paramsJson", "surface", "Landroid/view/Surface;", "taskType", "startMode", "bundle", "Landroid/os/Bundle;", "progressCallback", "Lcom/stepos/taskrobot/common/ITaskProgressCallback;", "chatSessionId", "subSessionId", "callerPid", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "openAppName", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/Surface;IILandroid/os/Bundle;Lcom/stepos/taskrobot/common/ITaskProgressCallback;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getNewTaskId", "()Ljava/lang/String;", "getPackageName", "getConflictKind", "()I", "getRunningTaskId", "getModelId", "getParamsJson", "getSurface", "()Landroid/view/Surface;", "getTaskType", "getStartMode", "getBundle", "()Landroid/os/Bundle;", "getProgressCallback", "()Lcom/stepos/taskrobot/common/ITaskProgressCallback;", "getChatSessionId", "getSubSessionId", "getCallerPid", "getTaskName", "getOpenAppName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "", "hashCode", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Start extends PendingConflict {
            private final Bundle bundle;
            private final int callerPid;
            private final String chatSessionId;
            private final int conflictKind;
            private final String modelId;
            private final String newTaskId;
            private final String openAppName;
            private final String packageName;
            private final String paramsJson;
            private final ITaskProgressCallback progressCallback;
            private final String runningTaskId;
            private final int startMode;
            private final String subSessionId;
            private final Surface surface;
            private final String taskName;
            private final int taskType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Start(String newTaskId, String packageName, int i, String runningTaskId, String str, String paramsJson, Surface surface, int i6, int i10, Bundle bundle, ITaskProgressCallback iTaskProgressCallback, String str2, String str3, int i11, String taskName, String openAppName) {
                super(null);
                kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
                kotlin.jvm.internal.k.f(packageName, "packageName");
                kotlin.jvm.internal.k.f(runningTaskId, "runningTaskId");
                kotlin.jvm.internal.k.f(paramsJson, "paramsJson");
                kotlin.jvm.internal.k.f(taskName, "taskName");
                kotlin.jvm.internal.k.f(openAppName, "openAppName");
                this.newTaskId = newTaskId;
                this.packageName = packageName;
                this.conflictKind = i;
                this.runningTaskId = runningTaskId;
                this.modelId = str;
                this.paramsJson = paramsJson;
                this.surface = surface;
                this.taskType = i6;
                this.startMode = i10;
                this.bundle = bundle;
                this.progressCallback = iTaskProgressCallback;
                this.chatSessionId = str2;
                this.subSessionId = str3;
                this.callerPid = i11;
                this.taskName = taskName;
                this.openAppName = openAppName;
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewTaskId() {
                return this.newTaskId;
            }

            /* renamed from: component10, reason: from getter */
            public final Bundle getBundle() {
                return this.bundle;
            }

            /* renamed from: component11, reason: from getter */
            public final ITaskProgressCallback getProgressCallback() {
                return this.progressCallback;
            }

            /* renamed from: component12, reason: from getter */
            public final String getChatSessionId() {
                return this.chatSessionId;
            }

            /* renamed from: component13, reason: from getter */
            public final String getSubSessionId() {
                return this.subSessionId;
            }

            /* renamed from: component14, reason: from getter */
            public final int getCallerPid() {
                return this.callerPid;
            }

            /* renamed from: component15, reason: from getter */
            public final String getTaskName() {
                return this.taskName;
            }

            /* renamed from: component16, reason: from getter */
            public final String getOpenAppName() {
                return this.openAppName;
            }

            /* renamed from: component2, reason: from getter */
            public final String getPackageName() {
                return this.packageName;
            }

            /* renamed from: component3, reason: from getter */
            public final int getConflictKind() {
                return this.conflictKind;
            }

            /* renamed from: component4, reason: from getter */
            public final String getRunningTaskId() {
                return this.runningTaskId;
            }

            /* renamed from: component5, reason: from getter */
            public final String getModelId() {
                return this.modelId;
            }

            /* renamed from: component6, reason: from getter */
            public final String getParamsJson() {
                return this.paramsJson;
            }

            /* renamed from: component7, reason: from getter */
            public final Surface getSurface() {
                return this.surface;
            }

            /* renamed from: component8, reason: from getter */
            public final int getTaskType() {
                return this.taskType;
            }

            /* renamed from: component9, reason: from getter */
            public final int getStartMode() {
                return this.startMode;
            }

            public final Start copy(String newTaskId, String packageName, int conflictKind, String runningTaskId, String modelId, String paramsJson, Surface surface, int taskType, int startMode, Bundle bundle, ITaskProgressCallback progressCallback, String chatSessionId, String subSessionId, int callerPid, String taskName, String openAppName) {
                kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
                kotlin.jvm.internal.k.f(packageName, "packageName");
                kotlin.jvm.internal.k.f(runningTaskId, "runningTaskId");
                kotlin.jvm.internal.k.f(paramsJson, "paramsJson");
                kotlin.jvm.internal.k.f(taskName, "taskName");
                kotlin.jvm.internal.k.f(openAppName, "openAppName");
                return new Start(newTaskId, packageName, conflictKind, runningTaskId, modelId, paramsJson, surface, taskType, startMode, bundle, progressCallback, chatSessionId, subSessionId, callerPid, taskName, openAppName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Start)) {
                    return false;
                }
                Start start = (Start) other;
                return kotlin.jvm.internal.k.b(this.newTaskId, start.newTaskId) && kotlin.jvm.internal.k.b(this.packageName, start.packageName) && this.conflictKind == start.conflictKind && kotlin.jvm.internal.k.b(this.runningTaskId, start.runningTaskId) && kotlin.jvm.internal.k.b(this.modelId, start.modelId) && kotlin.jvm.internal.k.b(this.paramsJson, start.paramsJson) && kotlin.jvm.internal.k.b(this.surface, start.surface) && this.taskType == start.taskType && this.startMode == start.startMode && kotlin.jvm.internal.k.b(this.bundle, start.bundle) && kotlin.jvm.internal.k.b(this.progressCallback, start.progressCallback) && kotlin.jvm.internal.k.b(this.chatSessionId, start.chatSessionId) && kotlin.jvm.internal.k.b(this.subSessionId, start.subSessionId) && this.callerPid == start.callerPid && kotlin.jvm.internal.k.b(this.taskName, start.taskName) && kotlin.jvm.internal.k.b(this.openAppName, start.openAppName);
            }

            public final Bundle getBundle() {
                return this.bundle;
            }

            public final int getCallerPid() {
                return this.callerPid;
            }

            public final String getChatSessionId() {
                return this.chatSessionId;
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.PendingConflict
            public int getConflictKind() {
                return this.conflictKind;
            }

            public final String getModelId() {
                return this.modelId;
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.PendingConflict
            public String getNewTaskId() {
                return this.newTaskId;
            }

            public final String getOpenAppName() {
                return this.openAppName;
            }

            @Override // com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.PendingConflict
            public String getPackageName() {
                return this.packageName;
            }

            public final String getParamsJson() {
                return this.paramsJson;
            }

            public final ITaskProgressCallback getProgressCallback() {
                return this.progressCallback;
            }

            public final String getRunningTaskId() {
                return this.runningTaskId;
            }

            public final int getStartMode() {
                return this.startMode;
            }

            public final String getSubSessionId() {
                return this.subSessionId;
            }

            public final Surface getSurface() {
                return this.surface;
            }

            public final String getTaskName() {
                return this.taskName;
            }

            public final int getTaskType() {
                return this.taskType;
            }

            public int hashCode() {
                int iC = B7.a.c(androidx.constraintlayout.core.dsl.a.a(this.conflictKind, B7.a.c(this.newTaskId.hashCode() * 31, 31, this.packageName), 31), 31, this.runningTaskId);
                String str = this.modelId;
                int iC2 = B7.a.c((iC + (str == null ? 0 : str.hashCode())) * 31, 31, this.paramsJson);
                Surface surface = this.surface;
                int iA = androidx.constraintlayout.core.dsl.a.a(this.startMode, androidx.constraintlayout.core.dsl.a.a(this.taskType, (iC2 + (surface == null ? 0 : surface.hashCode())) * 31, 31), 31);
                Bundle bundle = this.bundle;
                int iHashCode = (iA + (bundle == null ? 0 : bundle.hashCode())) * 31;
                ITaskProgressCallback iTaskProgressCallback = this.progressCallback;
                int iHashCode2 = (iHashCode + (iTaskProgressCallback == null ? 0 : iTaskProgressCallback.hashCode())) * 31;
                String str2 = this.chatSessionId;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.subSessionId;
                return this.openAppName.hashCode() + B7.a.c(androidx.constraintlayout.core.dsl.a.a(this.callerPid, (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31, 31), 31, this.taskName);
            }

            public String toString() {
                String str = this.newTaskId;
                String str2 = this.packageName;
                int i = this.conflictKind;
                String str3 = this.runningTaskId;
                String str4 = this.modelId;
                String str5 = this.paramsJson;
                Surface surface = this.surface;
                int i6 = this.taskType;
                int i10 = this.startMode;
                Bundle bundle = this.bundle;
                ITaskProgressCallback iTaskProgressCallback = this.progressCallback;
                String str6 = this.chatSessionId;
                String str7 = this.subSessionId;
                int i11 = this.callerPid;
                String str8 = this.taskName;
                String str9 = this.openAppName;
                StringBuilder sbW = B7.a.w("Start(newTaskId=", str, ", packageName=", str2, ", conflictKind=");
                sbW.append(i);
                sbW.append(", runningTaskId=");
                sbW.append(str3);
                sbW.append(", modelId=");
                androidx.constraintlayout.core.dsl.a.A(sbW, str4, ", paramsJson=", str5, ", surface=");
                sbW.append(surface);
                sbW.append(", taskType=");
                sbW.append(i6);
                sbW.append(", startMode=");
                sbW.append(i10);
                sbW.append(", bundle=");
                sbW.append(bundle);
                sbW.append(", progressCallback=");
                sbW.append(iTaskProgressCallback);
                sbW.append(", chatSessionId=");
                sbW.append(str6);
                sbW.append(", subSessionId=");
                androidx.compose.foundation.b.B(sbW, str7, ", callerPid=", i11, ", taskName=");
                return androidx.appfunctions.metadata.a.p(sbW, str8, ", openAppName=", str9, ")");
            }

            public /* synthetic */ Start(String str, String str2, int i, String str3, String str4, String str5, Surface surface, int i6, int i10, Bundle bundle, ITaskProgressCallback iTaskProgressCallback, String str6, String str7, int i11, String str8, String str9, int i12, kotlin.jvm.internal.e eVar) {
                this(str, str2, (i12 & 4) != 0 ? 1 : i, str3, str4, str5, surface, i6, i10, bundle, iTaskProgressCallback, str6, str7, i11, str8, str9);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SystemSdkBridge$PendingSurfaceEntry;", "", "surface", "Landroid/view/Surface;", "timeoutRunnable", "Ljava/lang/Runnable;", AppAgent.CONSTRUCT, "(Landroid/view/Surface;Ljava/lang/Runnable;)V", "getSurface", "()Landroid/view/Surface;", "getTimeoutRunnable", "()Ljava/lang/Runnable;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PendingSurfaceEntry {
        private final Surface surface;
        private final Runnable timeoutRunnable;

        public PendingSurfaceEntry(Surface surface, Runnable timeoutRunnable) {
            kotlin.jvm.internal.k.f(surface, "surface");
            kotlin.jvm.internal.k.f(timeoutRunnable, "timeoutRunnable");
            this.surface = surface;
            this.timeoutRunnable = timeoutRunnable;
        }

        public final Surface getSurface() {
            return this.surface;
        }

        public final Runnable getTimeoutRunnable() {
            return this.timeoutRunnable;
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {2400}, m = "clearAllTasks", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$clearAllTasks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.clearAllTasks(false, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {1778}, m = "continueTaskInPlace", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$continueTaskInPlace$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11591 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C11591(H7.c<? super C11591> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.continueTaskInPlace(null, null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {2400}, m = "getOrCreateQueryTask", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getOrCreateQueryTask$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11601 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11601(H7.c<? super C11601> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.getOrCreateQueryTask(this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {WindowType.VOICE_INTERACTION_STARTING}, m = "getShowingDisplayId", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getShowingDisplayId$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11611(H7.c<? super C11611> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.getShowingDisplayId(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {2047}, m = "isOmniDisplayId", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$isOmniDisplayId$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11621(H7.c<? super C11621> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.isOmniDisplayId(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$onTaskCompleted$4", f = "SystemSdkBridge.kt", l = {TypedValues.TransitionType.TYPE_DURATION}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$onTaskCompleted$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements S7.k {
        final /* synthetic */ String $taskId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str, H7.c<? super AnonymousClass4> cVar) {
            super(1, cVar);
            this.$taskId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new AnonymousClass4(this.$taskId, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((AnonymousClass4) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                ZyqlGuiAgentTask zyqlGuiAgentTask = (ZyqlGuiAgentTask) SystemSdkBridge.tasks.get(this.$taskId);
                if (zyqlGuiAgentTask != null) {
                    Context context = SystemSdkBridge.appContext;
                    if (context == null) {
                        kotlin.jvm.internal.k.n("appContext");
                        throw null;
                    }
                    this.label = 1;
                    if (zyqlGuiAgentTask.switchToMainDisplay(context, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$preShowReopenTargetAppIfOnLauncher$1", f = "SystemSdkBridge.kt", l = {TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$preShowReopenTargetAppIfOnLauncher$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11631 extends SuspendLambda implements S7.n {
        final /* synthetic */ ZyqlGuiAgentTask $guiTask;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11631(ZyqlGuiAgentTask zyqlGuiAgentTask, H7.c<? super C11631> cVar) {
            super(2, cVar);
            this.$guiTask = zyqlGuiAgentTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C11631 c11631 = new C11631(this.$guiTask, cVar);
            c11631.L$0 = obj;
            return c11631;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    ZyqlGuiAgentTask zyqlGuiAgentTask = this.$guiTask;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.I$0 = 0;
                    this.label = 1;
                    obj = zyqlGuiAgentTask.reopenTargetAppIfOnLauncher$stepfun_release(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                objA = (Boolean) obj;
                objA.getClass();
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            ZyqlGuiAgentTask zyqlGuiAgentTask2 = this.$guiTask;
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.e(SystemSdkBridge.TAG, B7.a.n("[", zyqlGuiAgentTask2.getTaskId(), "] pre-show reopenTargetApp failed: ", thA.getMessage()), true);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11631) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {651}, m = "recoverFromTakeover", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$recoverFromTakeover$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11641 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11641(H7.c<? super C11641> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.recoverFromTakeover(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {736}, m = "switchToMainDisplay", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToMainDisplay$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11651(H7.c<? super C11651> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.switchToMainDisplay(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {716}, m = "switchToVirtualDisplay", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToVirtualDisplay$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11661(H7.c<? super C11661> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.switchToVirtualDisplay(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge", f = "SystemSdkBridge.kt", l = {631}, m = "takeoverTask", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$takeoverTask$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11671(H7.c<? super C11671> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemSdkBridge.this.takeoverTask(null, null, this);
        }
    }

    static {
        int i = R.drawable.icon_notification;
        NOTIF_ICON_RES = i;
        NOTIF_THUMBNAIL_RES = i;
        NOTIF_CAPSULE_ICON_RES = R.drawable.ic_capsule_agent;
        pendingOutputSurfaces = new ConcurrentHashMap<>();
        taskIdToDocUri = new ConcurrentHashMap<>();
        docUriToCurrentTaskId = new ConcurrentHashMap<>();
        endedTaskCache = new EndedTaskCache<>(1220000L, 64, null, 4, null);
        pendingChatSessionIds = new ConcurrentHashMap<>();
        mainHandler = new Handler(Looper.getMainLooper());
        networkLostListener = new i(1);
        packageToTaskId = new ConcurrentHashMap<>();
        pendingConflicts = new ConcurrentHashMap<>();
        targetPackageOverride = new ConcurrentHashMap<>();
    }

    private SystemSdkBridge() {
    }

    public static /* synthetic */ void addModel$default(SystemSdkBridge systemSdkBridge, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        systemSdkBridge.addModel(str, str2);
    }

    private final PendingIntent buildLiveNotificationIntent(String taskId) {
        Context context = appContext;
        if (context == null) {
            kotlin.jvm.internal.k.n("appContext");
            throw null;
        }
        Intent intent = new Intent(context, (Class<?>) LiveNotificationLaunchActivity.class);
        intent.putExtra("extra_task_id", taskId);
        intent.addFlags(805306368);
        Context context2 = appContext;
        if (context2 == null) {
            kotlin.jvm.internal.k.n("appContext");
            throw null;
        }
        PendingIntent activity = PendingIntent.getActivity(context2, taskId.hashCode(), intent, 201326592);
        kotlin.jvm.internal.k.e(activity, "getActivity(...)");
        return activity;
    }

    private final void cachePendingSurface(String taskId, Surface surface) {
        evictPendingSurface(taskId);
        if (surface == null) {
            B7.a.z("[", taskId, "] setOutputSurface(null) but no live task; pending evicted", TAG, true);
            return;
        }
        j jVar = new j(taskId, 0);
        pendingOutputSurfaces.put(taskId, new PendingSurfaceEntry(surface, jVar));
        mainHandler.postDelayed(jVar, 1220000L);
        AbstractC1436a.d(TAG, "[" + taskId + "] pending surface cached, will expire in 1220000ms", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cachePendingSurface$lambda$0(String str) {
        PendingSurfaceEntry pendingSurfaceEntryRemove = pendingOutputSurfaces.remove(str);
        if (pendingSurfaceEntryRemove == null) {
            return;
        }
        INSTANCE.safeRelease(pendingSurfaceEntryRemove.getSurface(), str, "expired pending surface");
        B7.a.z("[", str, "] pending surface timeout (1220000ms), released", TAG, true);
    }

    private final void cancelPendingConflictsBlockedBy(String terminalTaskId) throws RemoteException {
        Object objA;
        ConcurrentHashMap<String, PendingConflict> concurrentHashMap = pendingConflicts;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        Collection<PendingConflict> collectionValues = concurrentHashMap.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            boolean zB = true;
            if (!it.hasNext()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    PendingConflict pendingConflict = (PendingConflict) it2.next();
                    AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.m("[", pendingConflict.getNewTaskId(), "] cancelPendingConflictsBlockedBy: terminalTaskId=", terminalTaskId, ", auto-cancel"), true);
                    try {
                        INSTANCE.cancelPackageConflict(pendingConflict.getNewTaskId(), pendingConflict.getConflictKind());
                        objA = r.f317a;
                    } catch (Throwable th) {
                        objA = kotlin.b.a(th);
                    }
                    Throwable thA = Result.a(objA);
                    if (thA != null) {
                        AbstractC1436a.e(TAG, B7.a.n("[", pendingConflict.getNewTaskId(), "] auto-cancel on terminal failed: ", thA.getMessage()), true);
                    }
                }
                return;
            }
            Object next = it.next();
            PendingConflict pendingConflict2 = (PendingConflict) next;
            if (pendingConflict2 instanceof PendingConflict.Start) {
                zB = kotlin.jvm.internal.k.b(((PendingConflict.Start) pendingConflict2).getRunningTaskId(), terminalTaskId);
            } else {
                if (!(pendingConflict2 instanceof PendingConflict.Resume)) {
                    throw new NoWhenBranchMatchedException();
                }
                PendingConflict.Resume resume = (PendingConflict.Resume) pendingConflict2;
                if (!kotlin.jvm.internal.k.b(resume.getRunningTaskId(), terminalTaskId) && !kotlin.jvm.internal.k.b(resume.getNewTaskId(), terminalTaskId)) {
                    zB = false;
                }
            }
            if (zB) {
                arrayList.add(next);
            }
        }
    }

    public static /* synthetic */ boolean cancelTask$default(SystemSdkBridge systemSdkBridge, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "Task cancelled";
        }
        return systemSdkBridge.cancelTask(str, str2);
    }

    public static /* synthetic */ boolean cancelUserInput$default(SystemSdkBridge systemSdkBridge, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "chat_cancel";
        }
        return systemSdkBridge.cancelUserInput(str, str2, str3);
    }

    public static /* synthetic */ Object clearAllTasks$default(SystemSdkBridge systemSdkBridge, boolean z10, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return systemSdkBridge.clearAllTasks(z10, cVar);
    }

    public static /* synthetic */ void clearTask$default(SystemSdkBridge systemSdkBridge, String str, boolean z10, String str2, int i, Object obj) throws RemoteException {
        if ((i & 2) != 0) {
            z10 = true;
        }
        if ((i & 4) != 0) {
            str2 = "用户取消任务";
        }
        systemSdkBridge.clearTask(str, z10, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object continueTaskInPlace(com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.PendingConflict.Start r31, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r32, H7.c<? super C7.r> r33) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.continueTaskInPlace(com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$PendingConflict$Start, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask, H7.c):java.lang.Object");
    }

    public static /* synthetic */ ZyqlGuiAgentTask createTask$default(SystemSdkBridge systemSdkBridge, String str, String str2, String str3, int i, Surface surface, InterfaceC1733z interfaceC1733z, ITaskProgressCallback iTaskProgressCallback, String str4, String str5, String str6, int i6, String str7, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            surface = null;
        }
        if ((i10 & 128) != 0) {
            str4 = null;
        }
        if ((i10 & 256) != 0) {
            str5 = null;
        }
        if ((i10 & 512) != 0) {
            str6 = null;
        }
        if ((i10 & 1024) != 0) {
            i6 = -1;
        }
        if ((i10 & 2048) != 0) {
            str7 = null;
        }
        return systemSdkBridge.createTask(str, str2, str3, i, surface, interfaceC1733z, iTaskProgressCallback, str4, str5, str6, i6, str7);
    }

    private final void evictPendingSurface(String taskId) {
        PendingSurfaceEntry pendingSurfaceEntryRemove = pendingOutputSurfaces.remove(taskId);
        if (pendingSurfaceEntryRemove == null) {
            return;
        }
        mainHandler.removeCallbacks(pendingSurfaceEntryRemove.getTimeoutRunnable());
        safeRelease(pendingSurfaceEntryRemove.getSurface(), taskId, "evicted pending surface");
        com.stepos.statsrpk.service.c.p("[", taskId, "] pending surface evicted and released", TAG, true);
    }

    private final String generateTaskId() {
        return "task_" + System.currentTimeMillis() + "_" + ((int) (Math.random() * 10000));
    }

    private final InterfaceC2108a getExecutionMutex(String taskId) {
        InterfaceC2108a interfaceC2108aPutIfAbsent;
        ConcurrentHashMap<String, InterfaceC2108a> concurrentHashMap = executionMutexMap;
        InterfaceC2108a aVar = concurrentHashMap.get(taskId);
        if (aVar == null && (interfaceC2108aPutIfAbsent = concurrentHashMap.putIfAbsent(taskId, (aVar = new kotlinx.coroutines.sync.a()))) != null) {
            aVar = interfaceC2108aPutIfAbsent;
        }
        return aVar;
    }

    @C7.c
    public static /* synthetic */ void getFullScreenInteractionEnabled$annotations() {
    }

    private final TaskRobotNotifier getNotifier() {
        return (TaskRobotNotifier) notifier.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getOrCreateQueryTask(H7.c<? super com.mdisdk.Task> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11601
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getOrCreateQueryTask$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getOrCreateQueryTask$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getOrCreateQueryTask$1
            r0.<init>(r6)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r6 = r0.L$0
            w9.a r6 = (w9.InterfaceC2108a) r6
            kotlin.b.b(r5)
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.b.b(r5)
            w9.a r5 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.queryTaskMutex
            r0.L$0 = r5
            r0.I$0 = r3
            r0.label = r2
            java.lang.Object r0 = r5.lock(r4, r0)
            if (r0 != r6) goto L47
            return r6
        L47:
            r6 = r5
        L48:
            com.mdisdk.Task r5 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.queryTask     // Catch: java.lang.Throwable -> L6a
            if (r5 != 0) goto L6c
            java.lang.String r5 = "__query_task__"
            r0 = 4
            com.mdisdk.Task r5 = com.mdisdk.TaskManager.create$default(r5, r4, r3, r0, r4)     // Catch: java.lang.Throwable -> L54
            goto L59
        L54:
            r5 = move-exception
            kotlin.Result$Failure r5 = kotlin.b.a(r5)     // Catch: java.lang.Throwable -> L6a
        L59:
            boolean r0 = r5 instanceof kotlin.Result.Failure     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L5e
            r5 = r4
        L5e:
            com.mdisdk.Task r5 = (com.mdisdk.Task) r5     // Catch: java.lang.Throwable -> L6a
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.queryTask = r5     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = "SystemSdkBridge"
            java.lang.String r0 = "queryTask created"
            f6.AbstractC1436a.d(r5, r0, r2)     // Catch: java.lang.Throwable -> L6a
            goto L6c
        L6a:
            r5 = move-exception
            goto L7f
        L6c:
            android.os.Handler r5 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.mainHandler     // Catch: java.lang.Throwable -> L6a
            java.lang.Runnable r0 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.queryTaskIdleRunnable     // Catch: java.lang.Throwable -> L6a
            r5.removeCallbacks(r0)     // Catch: java.lang.Throwable -> L6a
            r1 = 600000(0x927c0, double:2.964394E-318)
            r5.postDelayed(r0, r1)     // Catch: java.lang.Throwable -> L6a
            com.mdisdk.Task r5 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.queryTask     // Catch: java.lang.Throwable -> L6a
            r6.unlock(r4)
            return r5
        L7f:
            r6.unlock(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.getOrCreateQueryTask(H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleResumeConflict(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask> r0 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.tasks
            java.lang.Object r0 = r0.get(r10)
            r1 = r0
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r1 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r1
            if (r1 != 0) goto Lc
            return
        Lc:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$PendingConflict> r0 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.pendingConflicts
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$PendingConflict$Resume r2 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$PendingConflict$Resume
            r7 = 4
            r8 = 0
            r5 = 0
            r3 = r10
            r4 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r5 = r6
            r0.put(r3, r2)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "包名 "
            r10.<init>(r11)
            r10.append(r4)
            java.lang.String r11 = " 已被 "
            java.lang.String r12 = " 占用，无法恢复 "
            java.lang.String r7 = androidx.appfunctions.metadata.a.p(r10, r11, r5, r12, r3)
            java.lang.String r10 = "] resume conflict: "
            java.lang.String r11 = ", pending stored"
            java.lang.String r12 = "["
            java.lang.String r10 = androidx.appfunctions.metadata.a.m(r12, r3, r10, r7, r11)
            java.lang.String r11 = "SystemSdkBridge"
            r0 = 1
            f6.AbstractC1436a.d(r11, r10, r0)
            java.lang.String r10 = r1.getChatSessionId()
            boolean r10 = r9.isConflictVisibleToCaller$stepfun_release(r5, r10)
            if (r10 != 0) goto La9
            java.lang.String r10 = r1.getChatSessionId()
            java.lang.String r2 = "] onPackageConflict suppressed (caller invisible): kind=RESUME running="
            java.lang.String r6 = " sid="
            java.lang.StringBuilder r12 = B7.a.w(r12, r3, r2, r5, r6)
            java.lang.String r2 = " pkg="
            java.lang.String r10 = androidx.constraintlayout.core.dsl.a.j(r12, r10, r2, r4)
            f6.AbstractC1436a.e(r11, r10, r0)
            r10 = 0
            com.stepos.taskrobot.llmapi.stepfun.PackageUtil r11 = com.stepos.taskrobot.llmapi.stepfun.PackageUtil.INSTANCE     // Catch: java.lang.Throwable -> L70
            android.content.Context r12 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.appContext     // Catch: java.lang.Throwable -> L70
            if (r12 == 0) goto L75
            kotlin.Pair r11 = r11.getAppInfoByPackageName(r12, r4)     // Catch: java.lang.Throwable -> L70
            if (r11 == 0) goto L73
            java.lang.Object r11 = r11.f4886a     // Catch: java.lang.Throwable -> L70
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L70
            goto L7f
        L70:
            r0 = move-exception
            r11 = r0
            goto L7b
        L73:
            r11 = r10
            goto L7f
        L75:
            java.lang.String r11 = "appContext"
            kotlin.jvm.internal.k.n(r11)     // Catch: java.lang.Throwable -> L70
            throw r10     // Catch: java.lang.Throwable -> L70
        L7b:
            kotlin.Result$Failure r11 = kotlin.b.a(r11)
        L7f:
            boolean r12 = r11 instanceof kotlin.Result.Failure
            if (r12 == 0) goto L84
            r11 = r10
        L84:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L93
            boolean r12 = j9.m.s0(r11)
            if (r12 != 0) goto L8f
            r10 = r11
        L8f:
            if (r10 == 0) goto L93
            r11 = r10
            goto L94
        L93:
            r11 = r4
        L94:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask> r10 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.tasks
            java.lang.Object r10 = r10.get(r5)
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r10 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r10
            if (r10 == 0) goto La1
            r10.getTaskName()
        La1:
            java.lang.String r10 = r1.getTaskName()
            r9.showConflictNotification$stepfun_release(r5, r10, r11)
            return
        La9:
            r2 = 2
            r6 = r4
            java.lang.String r4 = r1.getTaskName()
            r1.notifyPackageConflict(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.handleResumeConflict(java.lang.String, java.lang.String, java.lang.String):void");
    }

    private final void handleStartConflict(String newTaskId, String taskName, String packageName, String runningTaskId, String modelId, String paramsJson, Surface surface, int taskType, int startMode, Bundle bundle, ITaskProgressCallback progressCallback, String chatSessionId, String subSessionId, int callerPid, String openAppName) throws RemoteException {
        Object objA;
        pendingConflicts.put(newTaskId, new PendingConflict.Start(newTaskId, packageName, 0, runningTaskId, modelId, paramsJson, surface, taskType, startMode, bundle, progressCallback, chatSessionId, subSessionId, callerPid, taskName, openAppName, 4, null));
        StringBuilder sb = new StringBuilder("包名 ");
        sb.append(packageName);
        String strJ = androidx.constraintlayout.core.dsl.a.j(sb, " 已被 ", runningTaskId, " 占用");
        AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.m("[", newTaskId, "] startTask conflict: ", strJ, ", pending stored"), true);
        if (!isConflictVisibleToCaller$stepfun_release(runningTaskId, chatSessionId)) {
            AbstractC1436a.e(TAG, androidx.constraintlayout.core.dsl.a.j(B7.a.w("[", newTaskId, "] onPackageConflict suppressed (caller invisible): kind=START running=", runningTaskId, " sid="), chatSessionId, " pkg=", packageName), true);
            showConflictNotification$stepfun_release(runningTaskId, taskName, openAppName);
            return;
        }
        if (progressCallback != null) {
            try {
                progressCallback.onPackageConflict(1, newTaskId, taskName, runningTaskId, packageName, strJ);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        } else {
            objA = null;
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", newTaskId, "] onPackageConflict push failed: ", thA.getMessage()), true);
        }
    }

    private final void handoverFailureCleanup(Task mdiTask, int displayId, String fromTaskId, String reason) {
        Object objA;
        Object objA2;
        AbstractC1436a.e(TAG, androidx.appfunctions.metadata.a.m("[", fromTaskId, "] handoverFailureCleanup: reason=", reason, ", destroying virtual display"), true);
        try {
            objA = Boolean.valueOf(VirtualDisplayCgroupHelper.INSTANCE.reset(displayId));
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", fromTaskId, "] vdcgroup reset failed: ", thA.getMessage()), true);
        }
        try {
            SystemSdkBridgeKt.finishWithRedirectCleanup(mdiTask, true);
            objA2 = r.f317a;
        } catch (Throwable th2) {
            objA2 = kotlin.b.a(th2);
        }
        Throwable thA2 = Result.a(objA2);
        if (thA2 != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", fromTaskId, "] mdiTask.finish failed: ", thA2.getMessage()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SessionState init$lambda$0$0(String tid) {
        kotlin.jvm.internal.k.f(tid, "tid");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(tid);
        if (zyqlGuiAgentTask != null) {
            return zyqlGuiAgentTask.getState();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$0$1(String tid) {
        kotlin.jvm.internal.k.f(tid, "tid");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(tid);
        return zyqlGuiAgentTask != null && zyqlGuiAgentTask.getLlmTakeoverPending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r init$lambda$0$2(SystemSdkBridge systemSdkBridge, String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        systemSdkBridge.onFullscreenTouchInjectionEnabled$stepfun_release(taskId);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isConflictVisibleToCaller$lambda$0(String str) {
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 == null) {
            return false;
        }
        if (fullScreenHelper2 != null) {
            return fullScreenHelper2.isTaskBoundAndInForeground(str);
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isConflictVisibleToCaller$lambda$1(String str) {
        if (str == null) {
            str = "";
        }
        if (str.length() <= 0 || appContext == null) {
            return false;
        }
        ChatActiveQuery chatActiveQuery = ChatActiveQuery.INSTANCE;
        Context context = appContext;
        if (context != null) {
            return chatActiveQuery.isActive(context, str);
        }
        kotlin.jvm.internal.k.n("appContext");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r networkLostListener$lambda$0() {
        Object objA;
        Collection<ZyqlGuiAgentTask> collectionValues = tasks.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            r rVar = r.f317a;
            if (!zHasNext) {
                return rVar;
            }
            try {
                ((ZyqlGuiAgentTask) it.next()).failTaskForNetworkLost();
                objA = rVar;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                AbstractC1436a.e(TAG, "networkLostListener: failTaskForNetworkLost failed: " + thA.getMessage(), true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskRobotNotifier notifier_delegate$lambda$0() {
        Context context = appContext;
        if (context != null) {
            return m6.b.d.g(context);
        }
        kotlin.jvm.internal.k.n("appContext");
        throw null;
    }

    public static /* synthetic */ void notifyProgressChanged$default(SystemSdkBridge systemSdkBridge, String str, String str2, Bitmap bitmap, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            bitmap = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        systemSdkBridge.notifyProgressChanged(str, str2, bitmap, str3, str4);
    }

    public static /* synthetic */ void notifyProgressChangedPair$default(SystemSdkBridge systemSdkBridge, String str, String str2, Bitmap bitmap, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            bitmap = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        systemSdkBridge.notifyProgressChangedPair(str, str2, bitmap, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onFullScreenActivityBackground$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onFullScreenActivityCreated$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onFullScreenActivityDestroyed$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onFullScreenActivityForeground$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onLlmRequestTakeover$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTaskCompleted$lambda$0(String str, Map.Entry it) {
        kotlin.jvm.internal.k.f(it, "it");
        return kotlin.jvm.internal.k.b(it.getValue(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onTaskCompleted$lambda$1(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task onTaskCompleted$lambda$2(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    private final ParsedStartParams parseStartParams(String paramsJson, Bundle bundle, String taskId, ITaskProgressCallback progressCallback) throws RemoteException {
        try {
            TaskParamsParser taskParamsParser = TaskParamsParser.INSTANCE;
            Context context = appContext;
            if (context == null) {
                kotlin.jvm.internal.k.n("appContext");
                throw null;
            }
            String packageName = context.getPackageName();
            kotlin.jvm.internal.k.e(packageName, "getPackageName(...)");
            TaskParamsParser.ParsedStartParams parsedStartParams = taskParamsParser.parse(paramsJson, packageName, bundle != null ? bundle.getString(Key.KEY_TRACE_ID) : null, bundle != null ? bundle.getString(Key.KEY_TOOL_CALL_ID) : null);
            return new ParsedStartParams(parsedStartParams.getTaskName(), parsedStartParams.getMeta(), parsedStartParams.getGuiModelName());
        } catch (Exception e) {
            AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] parseStartParams failed: ", e.getMessage()), true);
            if (progressCallback != null) {
                progressCallback.onTaskAction(taskId, "", Actions.INSTANCE.getERROR(), null, null, B7.a.m("参数[", paramsJson, "]解析失败 "));
            }
            return null;
        }
    }

    private final void preShowReopenTargetAppIfOnLauncher(ZyqlGuiAgentTask guiTask) {
        AbstractC1683A.n(AbstractC1683A.b(AbstractC1691I.f5315a), null, new C11631(guiTask, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryTaskIdleRunnable$lambda$0() {
        Task task = queryTask;
        if (task != null) {
            task.finish(true);
        }
        queryTask = null;
        AbstractC1436a.d(TAG, "queryTask idle timeout, finished", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task recoverFromTakeover$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    private final void resendPackageConflictsForRunningTask(String runningTaskId) {
        Object objA;
        ZyqlGuiAgentTask zyqlGuiAgentTask;
        ConcurrentHashMap<String, PendingConflict> concurrentHashMap = pendingConflicts;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        Collection<PendingConflict> collectionValues = concurrentHashMap.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        for (PendingConflict pendingConflict : v.f1(collectionValues)) {
            if (pendingConflicts.containsKey(pendingConflict.getNewTaskId())) {
                if (pendingConflict instanceof PendingConflict.Start) {
                    PendingConflict.Start start = (PendingConflict.Start) pendingConflict;
                    if (kotlin.jvm.internal.k.b(start.getRunningTaskId(), runningTaskId)) {
                        String strM = androidx.appfunctions.metadata.a.m("包名 ", start.getPackageName(), " 已被 ", runningTaskId, " 占用");
                        AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.m("[", start.getNewTaskId(), "] resend onPackageConflict(START) triggered by runningTaskId=", runningTaskId, " foreground"), true);
                        try {
                            ITaskProgressCallback progressCallback = ((PendingConflict.Start) pendingConflict).getProgressCallback();
                            if (progressCallback != null) {
                                progressCallback.onPackageConflict(1, ((PendingConflict.Start) pendingConflict).getNewTaskId(), ((PendingConflict.Start) pendingConflict).getTaskName(), runningTaskId, ((PendingConflict.Start) pendingConflict).getPackageName(), strM);
                                objA = r.f317a;
                            } else {
                                objA = null;
                            }
                        } catch (Throwable th) {
                            objA = kotlin.b.a(th);
                        }
                        Throwable thA = Result.a(objA);
                        if (thA != null) {
                            AbstractC1436a.e(TAG, B7.a.n("[", start.getNewTaskId(), "] resend onPackageConflict push failed: ", thA.getMessage()), true);
                        }
                    }
                } else {
                    if (!(pendingConflict instanceof PendingConflict.Resume)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    PendingConflict.Resume resume = (PendingConflict.Resume) pendingConflict;
                    if (kotlin.jvm.internal.k.b(resume.getRunningTaskId(), runningTaskId) && (zyqlGuiAgentTask = tasks.get(resume.getNewTaskId())) != null) {
                        String packageName = resume.getPackageName();
                        String newTaskId = resume.getNewTaskId();
                        StringBuilder sbW = B7.a.w("包名 ", packageName, " 已被 ", runningTaskId, " 占用，无法恢复 ");
                        sbW.append(newTaskId);
                        String string = sbW.toString();
                        AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.m("[", resume.getNewTaskId(), "] resend onPackageConflict(RESUME) triggered by runningTaskId=", runningTaskId, " foreground"), true);
                        zyqlGuiAgentTask.notifyPackageConflict(2, resume.getNewTaskId(), zyqlGuiAgentTask.getTaskName(), runningTaskId, resume.getPackageName(), string);
                    }
                }
            }
        }
    }

    private final void safeRelease(Surface surface, String str, String str2) {
        Object objA;
        try {
            surface.release();
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            String message = thA.getMessage();
            StringBuilder sbW = B7.a.w("[", str, "] release ", str2, " failed: ");
            sbW.append(message);
            AbstractC1436a.b(TAG, sbW.toString(), true);
        }
    }

    private final boolean shouldSuppressTakeover(String taskId, String action) {
        if (!isCallerVisibleForTask$stepfun_release(taskId)) {
            return false;
        }
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        String chatSessionId = zyqlGuiAgentTask != null ? zyqlGuiAgentTask.getChatSessionId() : null;
        if (chatSessionId == null) {
            chatSessionId = "";
        }
        com.stepos.statsrpk.service.c.r(B7.a.w("[", taskId, "] notification suppressed (caller visible), action=", action, ", sid="), chatSessionId, TAG, true);
        return true;
    }

    public static /* synthetic */ void showFullScreenActivity$default(SystemSdkBridge systemSdkBridge, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        systemSdkBridge.showFullScreenActivity(str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task showFullScreenActivity$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task showFullScreenForPackage$lambda$2(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    public static /* synthetic */ void startTask$default(SystemSdkBridge systemSdkBridge, String str, String str2, String str3, Surface surface, int i, int i6, Bundle bundle, ITaskProgressCallback iTaskProgressCallback, String str4, String str5, int i10, int i11, Object obj) throws RemoteException {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 256) != 0) {
            str4 = null;
        }
        if ((i11 & 512) != 0) {
            str5 = null;
        }
        if ((i11 & 1024) != 0) {
            i10 = -1;
        }
        systemSdkBridge.startTask(str, str2, str3, surface, i, i6, bundle, iTaskProgressCallback, str4, str5, i10);
    }

    private final String takePendingChatSessionId(String taskId) {
        String strRemove = pendingChatSessionIds.remove(taskId);
        if (strRemove == null) {
            return null;
        }
        AbstractC1436a.d(TAG, B7.a.n("[", taskId, "] pending chat session id taken: ", strRemove), true);
        return strRemove;
    }

    private final Surface takePendingSurface(String taskId) {
        PendingSurfaceEntry pendingSurfaceEntryRemove = pendingOutputSurfaces.remove(taskId);
        if (pendingSurfaceEntryRemove == null) {
            return null;
        }
        mainHandler.removeCallbacks(pendingSurfaceEntryRemove.getTimeoutRunnable());
        AbstractC1436a.d(TAG, "[" + taskId + "] pending surface taken (ownership transferred)", true);
        return pendingSurfaceEntryRemove.getSurface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Task updateFullScreenTaskState$lambda$0(String it) {
        kotlin.jvm.internal.k.f(it, "it");
        return INSTANCE.getMdiTask(it);
    }

    public final void addModel(String modelId, String modelCellType) {
        kotlin.jvm.internal.k.f(modelId, "modelId");
        IModelConfig iModelConfig = ModelConfigs.instance;
        if (iModelConfig.hasModel(modelId)) {
            com.stepos.statsrpk.service.c.w("[", modelId, "] 已存在", TAG, true);
            return;
        }
        IModelCell iModelCellResolveModelCellForTask = (modelCellType == null || j9.m.s0(modelCellType)) ? iModelConfig.resolveModelCellForTask(modelId) : iModelConfig.createModelCellByType(modelCellType);
        StringBuilder sbW = B7.a.w("[", modelId, "] addModel cell=", iModelCellResolveModelCellForTask.getType(), " (requested=");
        sbW.append(modelCellType);
        sbW.append(")");
        AbstractC1436a.d(TAG, sbW.toString(), true);
        iModelConfig.addModel(modelId, iModelCellResolveModelCellForTask);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void cancelPackageConflict(java.lang.String r13, int r14) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.cancelPackageConflict(java.lang.String, int):void");
    }

    public final boolean cancelTask(String taskId, String reason) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(reason, "reason");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask == null) {
            com.stepos.statsrpk.service.c.w("[", taskId, "] Cannot cancel: task not found", TAG, true);
            return false;
        }
        String targetPackageName = zyqlGuiAgentTask.getTargetPackageName();
        if (targetPackageName != null) {
            INSTANCE.releasePackageFromTask(targetPackageName, taskId);
        }
        try {
            zyqlGuiAgentTask.cancel(reason);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean cancelUserInput(String taskId, String requestId, String reason) {
        Object objA;
        stepai.aios.guiagent.runtime.a aVar;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(requestId, "requestId");
        kotlin.jvm.internal.k.f(reason, "reason");
        if (requestId.length() == 0) {
            return false;
        }
        try {
            aVar = C2052a.c;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (aVar == null) {
            throw new IllegalStateException("GuiAgentManager is not initialized");
        }
        objA = Boolean.valueOf(aVar.f.cancelUserInput(requestId, reason));
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c(TAG, B7.a.n("[", taskId, "] cancelUserInput failed: ", thA.getMessage()), thA);
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void clearAllPendingSurfaces() {
        Set<String> setKeySet = pendingOutputSurfaces.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        List<String> listF1 = v.f1(setKeySet);
        for (String str : listF1) {
            SystemSdkBridge systemSdkBridge = INSTANCE;
            kotlin.jvm.internal.k.c(str);
            systemSdkBridge.evictPendingSurface(str);
        }
        if (listF1.isEmpty()) {
            return;
        }
        AbstractC1436a.d(TAG, "clearAllPendingSurfaces released " + listF1.size() + " pending surfaces", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearAllTasks(boolean r11, H7.c<? super C7.r> r12) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.clearAllTasks(boolean, H7.c):java.lang.Object");
    }

    public final void clearTask(String taskId, boolean ignoreActions, String reason) throws RemoteException {
        String targetPackageName;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(reason, "reason");
        KeepAliveHelper.INSTANCE.endKeepAlive();
        ZyqlGuiAgentTask zyqlGuiAgentTaskRemove = tasks.remove(taskId);
        if (zyqlGuiAgentTaskRemove != null && (targetPackageName = zyqlGuiAgentTaskRemove.getTargetPackageName()) != null) {
            INSTANCE.releasePackageFromTask(targetPackageName, taskId);
        }
        evictPendingSurface(taskId);
        pendingChatSessionIds.remove(taskId);
        cancelPendingConflictsBlockedBy(taskId);
        Object objA = r.f317a;
        try {
            if (zyqlGuiAgentTaskRemove != null) {
                zyqlGuiAgentTaskRemove.release(ignoreActions, reason);
                executionMutexMap.remove(taskId);
            } else {
                AbstractC1436a.e(TAG, "[" + taskId + "] No task to end", true);
            }
            FullScreenHelper fullScreenHelper2 = fullScreenHelper;
            if (fullScreenHelper2 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            fullScreenHelper2.clearInteractionPolicy(taskId);
            FullScreenHelper fullScreenHelper3 = fullScreenHelper;
            if (fullScreenHelper3 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            fullScreenHelper3.clearTaskUiState(taskId);
            if (zyqlGuiAgentTaskRemove != null) {
                try {
                    mainDisplayWatcher.onTaskReleased(zyqlGuiAgentTaskRemove);
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    AbstractC1436a.e(TAG, B7.a.n("[", taskId, "] mainDisplayWatcher.onTaskReleased failed: ", thA.getMessage()), true);
                }
            }
            FullScreenHelper fullScreenHelper4 = fullScreenHelper;
            if (fullScreenHelper4 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            fullScreenHelper4.hideActivity(taskId);
            unregisterDocUri$stepfun_release(taskId);
            if (zyqlGuiAgentTaskRemove != null) {
                com.stepos.statsrpk.service.c.p("[", taskId, "] Task ended", TAG, true);
            }
        } catch (Throwable th2) {
            FullScreenHelper fullScreenHelper5 = fullScreenHelper;
            if (fullScreenHelper5 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            fullScreenHelper5.clearInteractionPolicy(taskId);
            FullScreenHelper fullScreenHelper6 = fullScreenHelper;
            if (fullScreenHelper6 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            fullScreenHelper6.clearTaskUiState(taskId);
            if (zyqlGuiAgentTaskRemove != null) {
                try {
                    mainDisplayWatcher.onTaskReleased(zyqlGuiAgentTaskRemove);
                } catch (Throwable th3) {
                    objA = kotlin.b.a(th3);
                }
                Throwable thA2 = Result.a(objA);
                if (thA2 != null) {
                    AbstractC1436a.e(TAG, B7.a.n("[", taskId, "] mainDisplayWatcher.onTaskReleased failed: ", thA2.getMessage()), true);
                }
            }
            FullScreenHelper fullScreenHelper7 = fullScreenHelper;
            if (fullScreenHelper7 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            fullScreenHelper7.hideActivity(taskId);
            throw th2;
        }
    }

    public final Object confirmPackageConflict(String str, int i, H7.c<? super r> cVar) throws RemoteException {
        Object objResume;
        Object objA;
        FullScreenHelper fullScreenHelper2;
        PendingConflict pendingConflictRemove = pendingConflicts.remove(str);
        r rVar = r.f317a;
        if (pendingConflictRemove == null) {
            B7.a.z("[", str, "] confirmPackageConflict: no pending found, ignored", TAG, true);
            return rVar;
        }
        String packageName = pendingConflictRemove.getPackageName();
        String str2 = packageToTaskId.get(packageName);
        ZyqlGuiAgentTask zyqlGuiAgentTask = str2 != null ? tasks.get(str2) : null;
        if (zyqlGuiAgentTask == null || !(pendingConflictRemove instanceof PendingConflict.Start) || zyqlGuiAgentTask.getState().a() || (fullScreenHelper2 = fullScreenHelper) == null || !fullScreenHelper2.isTaskBoundAndInForeground(zyqlGuiAgentTask.getTaskId())) {
            if (zyqlGuiAgentTask != null && !kotlin.jvm.internal.k.b(zyqlGuiAgentTask.getTaskId(), str)) {
                try {
                    String chatSessionId = zyqlGuiAgentTask.getChatSessionId();
                    if (chatSessionId == null) {
                        chatSessionId = "";
                    }
                    AbstractC1436a.d(TAG, "[" + str + "] confirmPackageConflict: cancel occupier=" + zyqlGuiAgentTask.getTaskId() + ", chatSessionId=" + chatSessionId, true);
                    notifyProgressChanged$default(INSTANCE, zyqlGuiAgentTask.getTaskId(), Actions.USER_CANCEL, null, null, chatSessionId, 12, null);
                    objA = rVar;
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    String taskId = zyqlGuiAgentTask.getTaskId();
                    String message = thA.getMessage();
                    StringBuilder sbW = B7.a.w("[", str, "] clearTask occupier=", taskId, " failed: ");
                    sbW.append(message);
                    AbstractC1436a.e(TAG, sbW.toString(), true);
                }
            }
            forceTakePackageForTask(packageName, str);
            if (pendingConflictRemove instanceof PendingConflict.Start) {
                PendingConflict.Start start = (PendingConflict.Start) pendingConflictRemove;
                startTask(start.getModelId(), start.getNewTaskId(), start.getParamsJson(), start.getSurface(), start.getTaskType(), start.getStartMode(), start.getBundle(), start.getProgressCallback(), start.getChatSessionId(), start.getSubSessionId(), start.getCallerPid());
            } else {
                if (!(pendingConflictRemove instanceof PendingConflict.Resume)) {
                    throw new NoWhenBranchMatchedException();
                }
                ZyqlGuiAgentTask zyqlGuiAgentTask2 = tasks.get(str);
                if (zyqlGuiAgentTask2 != null && (objResume = zyqlGuiAgentTask2.resume(cVar)) == CoroutineSingletons.f4909a) {
                    return objResume;
                }
            }
        } else {
            AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.m("[", str, "] confirmPackageConflict: enter continueTaskInPlace (occupier=", zyqlGuiAgentTask.getTaskId(), ")"), true);
            Object objContinueTaskInPlace = continueTaskInPlace((PendingConflict.Start) pendingConflictRemove, zyqlGuiAgentTask, cVar);
            if (objContinueTaskInPlace == CoroutineSingletons.f4909a) {
                return objContinueTaskInPlace;
            }
        }
        return rVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask createTask(java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, android.view.Surface r27, m9.InterfaceC1733z r28, com.stepos.taskrobot.common.ITaskProgressCallback r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, int r33, java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.createTask(java.lang.String, java.lang.String, java.lang.String, int, android.view.Surface, m9.z, com.stepos.taskrobot.common.ITaskProgressCallback, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String):com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask");
    }

    public final boolean deleteCustomModelById(String modelId) {
        kotlin.jvm.internal.k.f(modelId, "modelId");
        boolean zRemoveCustomModelsById = ModelConfigs.instance.removeCustomModelsById(modelId);
        AbstractC1436a.a(TAG, "[" + modelId + "] deleteCustomModelById: " + zRemoveCustomModelsById, true);
        return zRemoveCustomModelsById;
    }

    public final void dismissFullScreenOverlay(String taskId) {
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.dismissFullScreenOverlay(taskId);
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void dismissVoiceInput(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        if (taskId.length() == 0) {
            return;
        }
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask == null) {
            B7.a.z("[", taskId, "] dismissVoiceInput: task not found", TAG, true);
        } else {
            zyqlGuiAgentTask.dismissVoiceInput();
        }
    }

    public final void ensureFullScreenActivityRegistered$stepfun_release(FullScreenActivity activity) {
        kotlin.jvm.internal.k.f(activity, "activity");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.ensureActivityRegistered(activity);
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final String findTaskIdByPackage(String packageName) {
        kotlin.jvm.internal.k.f(packageName, "packageName");
        ConcurrentHashMap<String, ZyqlGuiAgentTask> concurrentHashMap = tasks;
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        for (Map.Entry<String, ZyqlGuiAgentTask> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            ZyqlGuiAgentTask value = entry.getValue();
            arrayList.add(new RedirectTaskMatcher.TaskSnapshot(key, value.getTargetPackageName(), value.getState(), value.getTopApp(value.getDisplayId())));
        }
        return RedirectTaskMatcher.INSTANCE.findTaskId(arrayList, packageName);
    }

    public final void forceTakePackageForTask(String pkg, String newTaskId) {
        kotlin.jvm.internal.k.f(pkg, "pkg");
        kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
        if (pkg.length() == 0) {
            return;
        }
        packageToTaskId.put(pkg, newTaskId);
    }

    public final boolean fullScreenInteractionEnabled(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 == null) {
            return false;
        }
        if (fullScreenHelper2 != null) {
            return fullScreenHelper2.getInteractionEnabled(taskId);
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    public final GuiAbilityProvider getAbilityProvider(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            return zyqlGuiAgentTask.getAbilityProvider();
        }
        return null;
    }

    public final int getActiveTaskCount() {
        return tasks.size();
    }

    public final Set<String> getActiveTaskIds() {
        Set<String> setKeySet = tasks.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        return v.j1(setKeySet);
    }

    public final String getCurrentModelId() {
        return ModelConfigs.instance.getCurrentModelId();
    }

    public final int getDisplayId(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            return zyqlGuiAgentTask.getDisplayId();
        }
        return -1;
    }

    public final Uri getDocUriForTask$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        return taskIdToDocUri.get(taskId);
    }

    public final GuiActionExecutor getExecutor(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            return zyqlGuiAgentTask.getExecutor();
        }
        return null;
    }

    public final String getForegroundTaskId() {
        Object obj;
        if (!initialized || fullScreenHelper == null) {
            return "";
        }
        Set<String> setKeySet = tasks.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            FullScreenHelper fullScreenHelper2 = fullScreenHelper;
            if (fullScreenHelper2 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            kotlin.jvm.internal.k.c(str);
            if (fullScreenHelper2.isTaskBoundAndInForeground(str)) {
                obj = next;
                break;
            }
        }
        String str2 = (String) obj;
        return str2 == null ? "" : str2;
    }

    public final String getForegroundTaskSessionId() {
        Object next;
        if (!initialized || fullScreenHelper == null) {
            return "";
        }
        Set<String> setKeySet = tasks.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String str = (String) next;
            FullScreenHelper fullScreenHelper2 = fullScreenHelper;
            if (fullScreenHelper2 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            kotlin.jvm.internal.k.c(str);
            if (fullScreenHelper2.isTaskBoundAndInForeground(str)) {
                break;
            }
        }
        String str2 = (String) next;
        if (str2 == null) {
            return "";
        }
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(str2);
        String chatSessionId = zyqlGuiAgentTask != null ? zyqlGuiAgentTask.getChatSessionId() : null;
        return chatSessionId == null ? "" : chatSessionId;
    }

    public final boolean getFullScreenInteractionEnabled() {
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 == null) {
            return false;
        }
        if (fullScreenHelper2 != null) {
            return fullScreenHelper2.isAnyInteractionEnabled();
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    public final String getLastActiveTaskSessionId() {
        return "";
    }

    public final String getLastLlmTakeoverMessage$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            return zyqlGuiAgentTask.getLastLlmTakeoverMessage();
        }
        return null;
    }

    public final MainDisplayTopAppHistory getMainDisplayTopAppHistory() {
        MainDisplayTopAppHistory mainDisplayTopAppHistorySnapshot = mainDisplayWatcher.snapshot();
        boolean watching = mainDisplayTopAppHistorySnapshot.getWatching();
        boolean changed = mainDisplayTopAppHistorySnapshot.getChanged();
        String baselinePackage = mainDisplayTopAppHistorySnapshot.getBaselinePackage();
        String currentPackage = mainDisplayTopAppHistorySnapshot.getCurrentPackage();
        long baselineAt = mainDisplayTopAppHistorySnapshot.getBaselineAt();
        long lastChangeAt = mainDisplayTopAppHistorySnapshot.getLastChangeAt();
        String chatSessionId = mainDisplayTopAppHistorySnapshot.getChatSessionId();
        StringBuilder sb = new StringBuilder("getMainDisplayTopAppHistory: watching=");
        sb.append(watching);
        sb.append(", changed=");
        sb.append(changed);
        sb.append(", baselinePackage='");
        androidx.constraintlayout.core.dsl.a.A(sb, baselinePackage, "', currentPackage='", currentPackage, "', baselineAt=");
        sb.append(baselineAt);
        androidx.compose.foundation.b.y(lastChangeAt, ", lastChangeAt=", ", chatSessionId='", sb);
        sb.append(chatSessionId);
        sb.append("'");
        AbstractC1436a.d(TAG, sb.toString(), true);
        return mainDisplayTopAppHistorySnapshot;
    }

    public final Task getMdiTask(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            return zyqlGuiAgentTask.getTask();
        }
        return null;
    }

    public final List<String> getModelOptions() {
        return ModelConfigs.instance.getAllModelIds();
    }

    public final Map<String, String> getPackageToTaskIdSnapshot() {
        return kotlin.collections.a.Y(packageToTaskId);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getShowingDisplayId(java.lang.String r5, H7.c<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11611
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getShowingDisplayId$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getShowingDisplayId$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$getShowingDisplayId$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r4 = r0.L$0
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r6)
            goto L42
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.b.b(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.getOrCreateQueryTask(r0)
            if (r6 != r1) goto L42
            return r1
        L42:
            com.mdisdk.Task r6 = (com.mdisdk.Task) r6
            r4 = -1
            if (r6 != 0) goto L4d
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            return r5
        L4d:
            int r5 = r6.getShowingDisplayId(r5)     // Catch: java.lang.Throwable -> L57
            java.lang.Integer r6 = new java.lang.Integer     // Catch: java.lang.Throwable -> L57
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L57
            goto L5c
        L57:
            r5 = move-exception
            kotlin.Result$Failure r6 = kotlin.b.a(r5)
        L5c:
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r4)
            boolean r4 = r6 instanceof kotlin.Result.Failure
            if (r4 == 0) goto L66
            r6 = r5
        L66:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.getShowingDisplayId(java.lang.String, H7.c):java.lang.Object");
    }

    public final String getTargetPackageOverride(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        return targetPackageOverride.get(taskId);
    }

    public final ZyqlGuiAgentTask getTask(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        return tasks.get(taskId);
    }

    public final boolean hasAnyActiveHandle() {
        Collection<ZyqlGuiAgentTask> collectionValues = tasks.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        Collection<ZyqlGuiAgentTask> collection = collectionValues;
        if (collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (((ZyqlGuiAgentTask) it.next()).isHandleActive()) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasTask(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        return tasks.containsKey(taskId);
    }

    public final void hideFullScreenActivity(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.hideActivity(taskId);
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void init(Context context) {
        Object objA;
        Context context2;
        kotlin.jvm.internal.k.f(context, "context");
        try {
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
            appContext = applicationContext;
            Object systemService = applicationContext.getSystemService("display");
            kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
            displayManager = (DisplayManager) systemService;
            context2 = appContext;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (context2 == null) {
            kotlin.jvm.internal.k.n("appContext");
            throw null;
        }
        TaskManager.initialize$default(context2, false, 2, null);
        Context context3 = appContext;
        if (context3 == null) {
            kotlin.jvm.internal.k.n("appContext");
            throw null;
        }
        FullScreenHelper fullScreenHelper2 = new FullScreenHelper(context3, mainHandler);
        fullScreenHelper = fullScreenHelper2;
        fullScreenHelper2.setSessionStateProvider(new n(18));
        FullScreenHelper fullScreenHelper3 = fullScreenHelper;
        if (fullScreenHelper3 == null) {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
        fullScreenHelper3.setLlmTakeoverPendingProvider(new n(7));
        FullScreenHelper fullScreenHelper4 = fullScreenHelper;
        if (fullScreenHelper4 == null) {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
        fullScreenHelper4.setOnFullscreenTouchInjectionEnabled(new g(this, 0));
        NetworkStateBridge.INSTANCE.registerOnNetworkLost(networkLostListener);
        initialized = true;
        AbstractC1436a.d(TAG, "MDI SDK initialized!", true);
        objA = r.f317a;
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, "MDI SDK init failed: " + thA.getMessage(), true);
        }
    }

    public final boolean isCallerVisibleForTask$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            if (fullScreenHelper2 == null) {
                kotlin.jvm.internal.k.n("fullScreenHelper");
                throw null;
            }
            if (fullScreenHelper2.isTaskBoundAndInForeground(taskId)) {
                return true;
            }
        }
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        String chatSessionId = zyqlGuiAgentTask != null ? zyqlGuiAgentTask.getChatSessionId() : null;
        if (chatSessionId == null) {
            chatSessionId = "";
        }
        if (chatSessionId.length() <= 0) {
            return false;
        }
        ChatActiveQuery chatActiveQuery = ChatActiveQuery.INSTANCE;
        Context context = appContext;
        if (context != null) {
            return chatActiveQuery.isActive(context, chatSessionId);
        }
        kotlin.jvm.internal.k.n("appContext");
        throw null;
    }

    public final boolean isChatActive$stepfun_release(String sessionId) {
        if (appContext == null || sessionId == null || j9.m.s0(sessionId)) {
            return false;
        }
        ChatActiveQuery chatActiveQuery = ChatActiveQuery.INSTANCE;
        Context context = appContext;
        if (context != null) {
            return chatActiveQuery.isActive(context, sessionId);
        }
        kotlin.jvm.internal.k.n("appContext");
        throw null;
    }

    public final boolean isConflictVisibleToCaller$stepfun_release(String runningTaskId, String newChatSessionId) {
        kotlin.jvm.internal.k.f(runningTaskId, "runningTaskId");
        return ConflictVisibilityDecider.INSTANCE.decide(new a(runningTaskId, 1), new a(newChatSessionId, 2));
    }

    public final boolean isCustomModel(String modelId) {
        kotlin.jvm.internal.k.f(modelId, "modelId");
        boolean zIsCustomModel = ModelConfigs.instance.isCustomModel(modelId);
        AbstractC1436a.a(TAG, "[" + modelId + "] isCustomModel: " + zIsCustomModel, true);
        return zIsCustomModel;
    }

    public final boolean isFullScreenActivityBoundToTask(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 == null) {
            return false;
        }
        if (fullScreenHelper2 != null) {
            return fullScreenHelper2.isTaskBoundAndInForeground(taskId);
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    public final boolean isFullScreenActivityInForeground$stepfun_release() {
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            return fullScreenHelper2.isAnyInForeground();
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    public final boolean isInitialized() {
        return initialized;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object isOmniDisplayId(java.lang.String r5, H7.c<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11621
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$isOmniDisplayId$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$isOmniDisplayId$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$isOmniDisplayId$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r4 = r0.L$0
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r6)
            goto L42
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.b.b(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.getOrCreateQueryTask(r0)
            if (r6 != r1) goto L42
            return r1
        L42:
            com.mdisdk.Task r6 = (com.mdisdk.Task) r6
            if (r6 != 0) goto L49
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L49:
            boolean r4 = r6.isOmniDisplayId(r5)     // Catch: java.lang.Throwable -> L52
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L52
            goto L57
        L52:
            r4 = move-exception
            kotlin.Result$Failure r4 = kotlin.b.a(r4)
        L57:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            boolean r6 = r4 instanceof kotlin.Result.Failure
            if (r6 == 0) goto L5e
            r4 = r5
        L5e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.isOmniDisplayId(java.lang.String, H7.c):java.lang.Object");
    }

    public final boolean isTaskTakenOverByExternal(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 == null) {
            return false;
        }
        if (fullScreenHelper2 != null) {
            return fullScreenHelper2.isTaskTakenOverByExternal(taskId);
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.stepos.taskrobot.common.bean.TaskSnapshot> listActiveTasks() {
        /*
            r12 = this;
            boolean r12 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.initialized
            if (r12 != 0) goto L7
            kotlin.collections.EmptyList r12 = kotlin.collections.EmptyList.f4893a
            return r12
        L7:
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper r12 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.fullScreenHelper
            r1 = 0
            r2 = 1
            if (r12 == 0) goto Lf
            r12 = r2
            goto L10
        Lf:
            r12 = r1
        L10:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask> r0 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.tasks
            java.util.Collection r0 = r0.values()
            java.lang.String r3 = "<get-values>(...)"
            kotlin.jvm.internal.k.e(r0, r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = D7.w.c0(r0, r4)
            r3.<init>(r4)
            java.util.Iterator r4 = r0.iterator()
        L2c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L84
            java.lang.Object r0 = r4.next()
            r5 = r0
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r5 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r5
            stepai.aios.guiagent.runtime.b r0 = r5.getGuiTaskHandle()     // Catch: java.lang.Throwable -> L4a
            kotlinx.coroutines.flow.i r0 = r0.d     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L4a
            stepai.aios.guiagent.model.SessionState r0 = (stepai.aios.guiagent.model.SessionState) r0     // Catch: java.lang.Throwable -> L4a
            java.lang.String r0 = r0.name()     // Catch: java.lang.Throwable -> L4a
            goto L4f
        L4a:
            r0 = move-exception
            kotlin.Result$Failure r0 = kotlin.b.a(r0)
        L4f:
            boolean r6 = r0 instanceof kotlin.Result.Failure
            if (r6 == 0) goto L55
            java.lang.String r0 = "UNKNOWN"
        L55:
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            if (r12 == 0) goto L71
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper r0 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.fullScreenHelper
            if (r0 == 0) goto L6a
            java.lang.String r6 = r5.getTaskId()
            boolean r0 = r0.isTaskBoundAndInForeground(r6)
            if (r0 == 0) goto L71
            r11 = r2
            goto L72
        L6a:
            java.lang.String r12 = "fullScreenHelper"
            kotlin.jvm.internal.k.n(r12)
            r12 = 0
            throw r12
        L71:
            r11 = r1
        L72:
            com.stepos.taskrobot.common.bean.TaskSnapshot r6 = new com.stepos.taskrobot.common.bean.TaskSnapshot
            java.lang.String r7 = r5.getTaskId()
            java.lang.String r8 = r5.getTargetPackageName()
            r9 = 0
            r6.<init>(r7, r8, r9, r10, r11)
            r3.add(r6)
            goto L2c
        L84:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.listActiveTasks():java.util.List");
    }

    public final synchronized void notifyProgressChanged(String taskId, String action, Bitmap bitmap, String bitmapId, String message) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(action, "action");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            zyqlGuiAgentTask.notifyProgressChanged(action, bitmap, bitmapId, message);
            return;
        }
        AbstractC1436a.b(TAG, "[" + taskId + "] Cannot notify progress: task not found", true);
    }

    public final synchronized void notifyProgressChangedPair(String taskId, String action, Bitmap bitmap, String bitmapId, String url) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(action, "action");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            zyqlGuiAgentTask.notifyProgressChangedPair(action, bitmap, bitmapId, url);
            return;
        }
        AbstractC1436a.b(TAG, "[" + taskId + "] Cannot notify progress: task not found", true);
    }

    public final t observeFullScreenTaskUiState$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            return fullScreenHelper2.observeTaskUiState(taskId);
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    public final void onFullScreenActivityBackground$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.onActivityBackground(taskId, new n(10));
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void onFullScreenActivityCreated$stepfun_release(FullScreenActivity activity) {
        kotlin.jvm.internal.k.f(activity, "activity");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.onActivityCreated(activity, new n(12));
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void onFullScreenActivityDestroyed$stepfun_release(FullScreenActivity destroyed, String taskId) {
        kotlin.jvm.internal.k.f(destroyed, "destroyed");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.onActivityDestroyed(destroyed, taskId, new n(13));
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void onFullScreenActivityForeground$stepfun_release(String taskId) {
        Object objA;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 == null) {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
        fullScreenHelper2.onActivityForeground(taskId, new n(16));
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            zyqlGuiAgentTask.flushPendingInfoIfAny$stepfun_release();
        }
        try {
            resendPackageConflictsForRunningTask(taskId);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", taskId, "] resendPackageConflicts failed: ", thA.getMessage()), true);
        }
    }

    public final void onFullscreenTouchInjectionEnabled$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask != null) {
            zyqlGuiAgentTask.acknowledgeLlmTakeoverSupersededByFullscreen$stepfun_release();
        }
    }

    public final void onLlmRequestTakeover$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.onLlmRequestTakeover(taskId, new n(17));
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void onTaskActionForNotification(String taskId, String taskName, String action, String message) throws RemoteException {
        Object objA;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(action, "action");
        if (appContext == null) {
            return;
        }
        Actions actions = Actions.INSTANCE;
        if (!action.equals(actions.getLLM_TAKE_OVER()) && !action.equals(actions.getINFO())) {
            if (action.equals(actions.getFINISH()) || action.equals(actions.getERROR()) || action.equals(actions.getCANCEL())) {
                getNotifier().dismiss(taskId);
                EndedTaskCache<ITaskProgressCallback> endedTaskCache2 = endedTaskCache;
                ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
                endedTaskCache2.put(taskId, taskName, action, message, zyqlGuiAgentTask != null ? zyqlGuiAgentTask.peekProgressCallback$stepfun_release() : null);
                cancelPendingConflictsBlockedBy(taskId);
                return;
            }
            return;
        }
        if (shouldSuppressTakeover(taskId, action)) {
            return;
        }
        String str = message == null ? "" : message;
        if (action.equals(actions.getLLM_TAKE_OVER())) {
            try {
                objA = new JSONObject(str).optString("content");
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            boolean z10 = objA instanceof Result.Failure;
            Object obj = objA;
            if (z10) {
                obj = null;
            }
            String str2 = (String) obj;
            if (str2 != null) {
                String str3 = j9.m.s0(str2) ? null : str2;
                if (str3 != null) {
                    str = str3;
                }
            }
        }
        if (j9.m.s0(str)) {
            str = TaskRobotNotifier.DEFAULT_RUNNING_SUBTITLE;
        }
        getNotifier().showTakeover(taskId, taskName, str, NOTIF_ICON_RES, NOTIF_THUMBNAIL_RES, "查看详情", buildLiveNotificationIntent(taskId), NOTIF_CAPSULE_ICON_RES);
    }

    public final Object onTaskCompleted(String str, H7.c<? super r> cVar) {
        packageToTaskId.entrySet().removeIf(new androidx.window.embedding.b(new R3.c(str, 18), 2));
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            Object objOnTaskCompleted = fullScreenHelper2.onTaskCompleted(str, new n(8), new AnonymousClass4(str, null), cVar);
            return objOnTaskCompleted == CoroutineSingletons.f4909a ? objOnTaskCompleted : r.f317a;
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    public final Object pause(String str, String str2, H7.c<? super Boolean> cVar) {
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(str);
        if (zyqlGuiAgentTask != null) {
            return zyqlGuiAgentTask.pause(str2, cVar);
        }
        com.stepos.statsrpk.service.c.w("[", str, "] Cannot pause: task not found", TAG, true);
        return Boolean.FALSE;
    }

    public final String peekPendingChatSessionId(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        return pendingChatSessionIds.get(taskId);
    }

    public final AppOccupationResult queryAppOccupation(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        if (!initialized || appName.length() == 0) {
            return new AppOccupationResult(false, "", "");
        }
        PackageUtil packageUtil = PackageUtil.INSTANCE;
        Context context = appContext;
        if (context == null) {
            kotlin.jvm.internal.k.n("appContext");
            throw null;
        }
        String packageNameByAppName = packageUtil.getPackageNameByAppName(context, appName);
        if (packageNameByAppName == null || packageNameByAppName.length() == 0) {
            return new AppOccupationResult(false, "", "");
        }
        String str = packageToTaskId.get(packageNameByAppName);
        return str == null ? new AppOccupationResult(false, "", packageNameByAppName) : new AppOccupationResult(true, str, packageNameByAppName);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object recoverFromTakeover(java.lang.String r5, H7.c<? super za.d> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11641
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$recoverFromTakeover$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11641) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$recoverFromTakeover$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$recoverFromTakeover$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r5 = r0.L$1
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r5 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r4)
            goto L5c
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.b.b(r4)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask> r4 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.tasks
            java.lang.Object r4 = r4.get(r5)
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r4 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r4
            if (r4 != 0) goto L4f
            java.lang.String r4 = "["
            java.lang.String r6 = "] Cannot recover: task not found"
            java.lang.String r0 = "SystemSdkBridge"
            com.stepos.statsrpk.service.c.w(r4, r5, r6, r0, r2)
            return r3
        L4f:
            r0.L$0 = r5
            r0.L$1 = r3
            r0.label = r2
            java.lang.Object r4 = r4.recoverFromTakeover(r0)
            if (r4 != r6) goto L5c
            return r6
        L5c:
            za.d r4 = (za.d) r4
            if (r4 == 0) goto L85
            boolean r6 = r4.f7001a
            if (r6 != r2) goto L85
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper r6 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.fullScreenHelper
            java.lang.String r0 = "fullScreenHelper"
            if (r6 == 0) goto L81
            r6.clearDesiredInteractionAfterRecover(r5)
            com.stepos.taskrobot.llmapi.stepfun.FullScreenHelper r6 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.fullScreenHelper
            if (r6 == 0) goto L7d
            com.stepos.taskrobot.llmapi.stepfun.n r0 = new com.stepos.taskrobot.llmapi.stepfun.n
            r1 = 11
            r0.<init>(r1)
            r1 = 0
            r6.updateInteraction(r5, r1, r0)
            return r4
        L7d:
            kotlin.jvm.internal.k.n(r0)
            throw r3
        L81:
            kotlin.jvm.internal.k.n(r0)
            throw r3
        L85:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.recoverFromTakeover(java.lang.String, H7.c):java.lang.Object");
    }

    public final void registerDocUri$stepfun_release(String taskId, Uri uri) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(uri, "uri");
        taskIdToDocUri.put(taskId, uri);
        docUriToCurrentTaskId.put(uri.toString(), taskId);
        AbstractC1436a.a(TAG, "[" + taskId + "] registerDocUri: " + uri, true);
    }

    public final boolean registerProgressCallback(String taskId, int callerPid, ITaskProgressCallback callback) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask == null) {
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.d(callerPid, "[", taskId, "] Cannot register callback for callerPid=", ": task not found"), true);
            return false;
        }
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(callerPid, "[", taskId, "] registerProgressCallback callerPid=", " callback=");
        sbT.append(callback);
        AbstractC1436a.a(TAG, sbT.toString(), true);
        zyqlGuiAgentTask.registerProgressCallback(callerPid, callback);
        return true;
    }

    public final void releasePackageFromTask(String pkg, String taskId) {
        kotlin.jvm.internal.k.f(pkg, "pkg");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        if (pkg.length() == 0) {
            return;
        }
        packageToTaskId.remove(pkg, taskId);
    }

    public final int removeAllCustomModels() {
        int iRemoveAllCustomModels = ModelConfigs.instance.removeAllCustomModels();
        AbstractC1436a.a(TAG, "removeAllCustomModels :" + iRemoveAllCustomModels, true);
        return iRemoveAllCustomModels;
    }

    public final ConflictDecision reservePackageForTask(String pkg, String newTaskId) {
        kotlin.jvm.internal.k.f(pkg, "pkg");
        kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
        if (pkg.length() == 0) {
            return ConflictDecision.OK.INSTANCE;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = packageToTaskId;
        String strPutIfAbsent = concurrentHashMap.putIfAbsent(pkg, newTaskId);
        if (strPutIfAbsent != null && !strPutIfAbsent.equals(newTaskId)) {
            return new ConflictDecision.Conflict(strPutIfAbsent);
        }
        concurrentHashMap.put(pkg, newTaskId);
        return ConflictDecision.OK.INSTANCE;
    }

    public final String resolveCurrentTaskId$stepfun_release(Uri uri) {
        kotlin.jvm.internal.k.f(uri, "uri");
        return docUriToCurrentTaskId.get(uri.toString());
    }

    public final Object resume(String str, H7.c<? super za.d> cVar) {
        String str2;
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(str);
        if (zyqlGuiAgentTask == null) {
            com.stepos.statsrpk.service.c.w("[", str, "] Cannot resume: task not found", TAG, true);
            return null;
        }
        String targetPackageName = zyqlGuiAgentTask.getTargetPackageName();
        if (targetPackageName == null || targetPackageName.length() == 0 || (str2 = packageToTaskId.get(targetPackageName)) == null || str2.equals(str)) {
            return zyqlGuiAgentTask.resume(cVar);
        }
        handleResumeConflict(str, targetPackageName, str2);
        return null;
    }

    public final void resumeFullScreenOverlay(String taskId) {
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.resumeFullScreenOverlay(taskId);
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void setChatSessionId(String taskId, String chatSessionId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        if (chatSessionId == null || chatSessionId.length() <= 0) {
            chatSessionId = null;
        }
        if (chatSessionId == null) {
            AbstractC1436a.a(TAG, "[" + taskId + "] setChatSessionId no-op (null/empty), preserve existing value", true);
            return;
        }
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask == null) {
            if (endedTaskCache.peek(taskId) != null) {
                AbstractC1436a.d(TAG, B7.a.n("[", taskId, "] setChatSessionId no-op (task already ended), drop: ", chatSessionId), true);
                return;
            }
            pendingChatSessionIds.put(taskId, chatSessionId);
            AbstractC1436a.d(TAG, "[" + taskId + "] chat session id cached (task not yet created): " + chatSessionId, true);
            return;
        }
        String chatSessionId2 = zyqlGuiAgentTask.getChatSessionId();
        if (kotlin.jvm.internal.k.b(chatSessionId2, chatSessionId)) {
            AbstractC1436a.a(TAG, B7.a.n("[", taskId, "] setChatSessionId no-op (same value): ", chatSessionId), true);
            return;
        }
        zyqlGuiAgentTask.setChatSessionId(chatSessionId);
        StringBuilder sb = new StringBuilder("[");
        sb.append(taskId);
        sb.append("] chat session id bound to live task: '");
        AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.p(sb, chatSessionId2, "' -> '", chatSessionId, "'"), true);
    }

    public final void setOutputSurface(String taskId, Surface surface) throws RemoteException {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        EndedTaskSnapshot<ITaskProgressCallback> endedTaskSnapshotPeek = endedTaskCache.peek(taskId);
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        ConcurrentHashMap<String, ZyqlGuiAgentTask> concurrentHashMap = tasks;
        boolean zContainsKey = concurrentHashMap.containsKey(taskId);
        boolean z10 = false;
        boolean z11 = endedTaskSnapshotPeek != null;
        AbstractC1436a.a(TAG, "[" + taskId + "] setOutputSurface entry, surface=" + surface + ", taskExists=" + zContainsKey + ", endedExists=" + z11 + ", pendingExists=" + pendingOutputSurfaces.containsKey(taskId) + ", callingPid=" + callingPid + ", callingUid=" + callingUid, true);
        ZyqlGuiAgentTask zyqlGuiAgentTask = concurrentHashMap.get(taskId);
        Object objA = r.f317a;
        if (zyqlGuiAgentTask == null) {
            if (endedTaskSnapshotPeek == null) {
                cachePendingSurface(taskId, surface);
                return;
            }
            if (surface != null) {
                safeRelease(surface, taskId, "ended-task setOutputSurface");
            }
            boolean z12 = endedTaskSnapshotPeek.getCallback() != null;
            ITaskProgressCallback callback = endedTaskSnapshotPeek.getCallback();
            if (callback != null) {
                try {
                    callback.onTaskAction(taskId, endedTaskSnapshotPeek.getTaskName(), endedTaskSnapshotPeek.getAction(), null, null, endedTaskSnapshotPeek.getMessage());
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    AbstractC1436a.e(TAG, B7.a.n("[", taskId, "] replay onTaskAction failed: ", thA.getMessage()), true);
                }
            }
            if (z12) {
                AbstractC1436a.d(TAG, B7.a.n("[", taskId, "] ended-task setOutputSurface, replay terminal action=", endedTaskSnapshotPeek.getAction()), true);
                return;
            } else {
                com.stepos.statsrpk.service.c.p("[", taskId, "] ended-task setOutputSurface, no callback to replay, surface released only", TAG, true);
                return;
            }
        }
        evictPendingSurface(taskId);
        boolean zIsFullScreenActivityInForeground$stepfun_release = isFullScreenActivityInForeground$stepfun_release();
        if (surface != null) {
            String string = surface.toString();
            kotlin.jvm.internal.k.e(string, "toString(...)");
            if (j9.m.h0(string, "SurfaceTexture", false)) {
                z10 = true;
            }
        }
        if (zIsFullScreenActivityInForeground$stepfun_release && z10) {
            StringBuilder sbT = androidx.appfunctions.metadata.a.t(callingPid, "[", taskId, "] setOutputSurface: external surface overrides foreground FullScreenActivity mirror, callingPid=", ", surface=");
            sbT.append(surface);
            AbstractC1436a.e(TAG, sbT.toString(), true);
        }
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("[", taskId, "] live task, attach surface directly, fsForeground=", ", isExternalSurface=", zIsFullScreenActivityInForeground$stepfun_release);
        sbL.append(z10);
        AbstractC1436a.d(TAG, sbL.toString(), true);
        try {
            zyqlGuiAgentTask.setOutputSurface(surface);
        } catch (Throwable th2) {
            objA = kotlin.b.a(th2);
        }
        Throwable thA2 = Result.a(objA);
        if (thA2 != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", taskId, "] setOutputSurface failed: ", thA2.getMessage()), true);
        }
    }

    public final void showConflictNotification$stepfun_release(String runningTaskId, String newTaskName, String newTaskAppName) {
        Object objA;
        kotlin.jvm.internal.k.f(runningTaskId, "runningTaskId");
        kotlin.jvm.internal.k.f(newTaskName, "newTaskName");
        kotlin.jvm.internal.k.f(newTaskAppName, "newTaskAppName");
        if (appContext == null) {
            B7.a.z("[", runningTaskId, "] showConflictNotification skipped: bridge not initialized", TAG, true);
            return;
        }
        try {
            getNotifier().showTakeover(runningTaskId, newTaskName, B7.a.m("将使用", newTaskAppName, "，会终止前序任务"), NOTIF_ICON_RES, NOTIF_THUMBNAIL_RES, "查看详情", buildLiveNotificationIntent(runningTaskId), NOTIF_CAPSULE_ICON_RES);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", runningTaskId, "] showConflictNotification failed: ", thA.getMessage()), true);
        }
    }

    public final void showFullScreenActivity(String taskId, Boolean enableInteraction) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        if (!initialized) {
            com.stepos.statsrpk.service.c.w("[", taskId, "] showFullScreenActivity: SDK not initialized", TAG, true);
            return;
        }
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask == null) {
            com.stepos.statsrpk.service.c.w("[", taskId, "] Cannot showFullScreenActivity: task not found", TAG, true);
            return;
        }
        if (!zyqlGuiAgentTask.isHandleActive()) {
            com.stepos.statsrpk.service.c.w("[", taskId, "] Cannot showFullScreenActivity: task not active", TAG, true);
            return;
        }
        preShowReopenTargetAppIfOnLauncher(zyqlGuiAgentTask);
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.showActivity(taskId, enableInteraction, new n(14));
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void showFullScreenActivityV2(String taskId, Bundle options) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        Boolean boolValueOf = (options == null || !options.containsKey("fs_enable_interaction")) ? null : Boolean.valueOf(options.getBoolean("fs_enable_interaction", true));
        String string = options != null ? options.getString("fs_target_package") : null;
        if (string != null && string.length() != 0) {
            targetPackageOverride.put(taskId, string);
            AbstractC1436a.a(TAG, "[" + taskId + "] showFullScreenActivityV2: override targetPackage=" + string, true);
        }
        showFullScreenActivity(taskId, boolValueOf);
    }

    public final boolean showFullScreenForPackage(String packageName) {
        kotlin.jvm.internal.k.f(packageName, "packageName");
        if (!initialized) {
            AbstractC1436a.e(TAG, "showFullScreenForPackage: not initialized, pkg=".concat(packageName), true);
            return false;
        }
        String strFindTaskIdByPackage = findTaskIdByPackage(packageName);
        if (strFindTaskIdByPackage == null) {
            AbstractC1436a.d(TAG, "showFullScreenForPackage: no active task for pkg=".concat(packageName), true);
            return false;
        }
        AbstractC1436a.d(TAG, androidx.appfunctions.metadata.a.m("[", strFindTaskIdByPackage, "] showFullScreenForPackage: pkg=", packageName, " -> fullscreen"), true);
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(strFindTaskIdByPackage);
        if (zyqlGuiAgentTask != null) {
            INSTANCE.preShowReopenTargetAppIfOnLauncher(zyqlGuiAgentTask);
        }
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.showActivity(strFindTaskIdByPackage, null, new n(15));
            return true;
        }
        kotlin.jvm.internal.k.n("fullScreenHelper");
        throw null;
    }

    public final void showInfoNotification$stepfun_release(String taskId, String taskName, String message) {
        Object objA;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(message, "message");
        if (appContext == null) {
            B7.a.z("[", taskId, "] showInfoNotification skipped: bridge not initialized", TAG, true);
            return;
        }
        try {
            getNotifier().showTakeover(taskId, taskName, j9.m.s0(message) ? TaskRobotNotifier.DEFAULT_RUNNING_SUBTITLE : message, NOTIF_ICON_RES, NOTIF_THUMBNAIL_RES, "查看详情", buildLiveNotificationIntent(taskId), NOTIF_CAPSULE_ICON_RES);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", taskId, "] showInfoNotification failed: ", thA.getMessage()), true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void startTask(java.lang.String r26, java.lang.String r27, java.lang.String r28, android.view.Surface r29, int r30, int r31, android.os.Bundle r32, com.stepos.taskrobot.common.ITaskProgressCallback r33, java.lang.String r34, java.lang.String r35, int r36) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.startTask(java.lang.String, java.lang.String, java.lang.String, android.view.Surface, int, int, android.os.Bundle, com.stepos.taskrobot.common.ITaskProgressCallback, java.lang.String, java.lang.String, int):void");
    }

    public final boolean submitUserInput(String taskId, String requestId, String content) {
        Object objA;
        ZyqlGuiAgentTask zyqlGuiAgentTask;
        stepai.aios.guiagent.runtime.a aVar;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(requestId, "requestId");
        kotlin.jvm.internal.k.f(content, "content");
        if (requestId.length() == 0) {
            return false;
        }
        try {
            aVar = C2052a.c;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (aVar == null) {
            throw new IllegalStateException("GuiAgentManager is not initialized");
        }
        objA = Boolean.valueOf(aVar.f.provideUserInput(requestId, content));
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c(TAG, B7.a.n("[", taskId, "] submitUserInput failed: ", thA.getMessage()), thA);
            objA = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        if (zBooleanValue && (zyqlGuiAgentTask = tasks.get(taskId)) != null) {
            zyqlGuiAgentTask.clearPendingInfo$stepfun_release("user submitted input via submitUserInput");
        }
        return zBooleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object switchToMainDisplay(java.lang.String r7, H7.c<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11651
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToMainDisplay$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11651) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToMainDisplay$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToMainDisplay$1
            r0.<init>(r8)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            java.lang.String r2 = "["
            java.lang.String r3 = "SystemSdkBridge"
            r4 = 1
            if (r1 == 0) goto L3d
            if (r1 != r4) goto L35
            java.lang.Object r7 = r0.L$1
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r7 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.b.b(r6)     // Catch: java.lang.Exception -> L33
            goto L78
        L33:
            r6 = move-exception
            goto L6a
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.b.b(r6)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask> r6 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.tasks
            java.lang.Object r6 = r6.get(r7)
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r6 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r6
            if (r6 != 0) goto L52
            java.lang.String r6 = "] Cannot switch to main display: task not found"
            com.stepos.statsrpk.service.c.w(r2, r7, r6, r3, r4)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        L52:
            android.content.Context r1 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.appContext     // Catch: java.lang.Exception -> L33
            r5 = 0
            if (r1 == 0) goto L64
            r0.L$0 = r7     // Catch: java.lang.Exception -> L33
            r0.L$1 = r5     // Catch: java.lang.Exception -> L33
            r0.label = r4     // Catch: java.lang.Exception -> L33
            java.lang.Object r6 = r6.switchToMainDisplay(r1, r0)     // Catch: java.lang.Exception -> L33
            if (r6 != r8) goto L78
            return r8
        L64:
            java.lang.String r6 = "appContext"
            kotlin.jvm.internal.k.n(r6)     // Catch: java.lang.Exception -> L33
            throw r5     // Catch: java.lang.Exception -> L33
        L6a:
            java.lang.String r6 = r6.getMessage()
            java.lang.String r8 = "] switchToMainDisplay failed: "
            java.lang.String r6 = B7.a.n(r2, r7, r8, r6)
            f6.AbstractC1436a.b(r3, r6, r4)
            r4 = 0
        L78:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.switchToMainDisplay(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object switchToVirtualDisplay(java.lang.String r7, H7.c<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11661
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToVirtualDisplay$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToVirtualDisplay$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$switchToVirtualDisplay$1
            r0.<init>(r8)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            java.lang.String r2 = "["
            java.lang.String r3 = "SystemSdkBridge"
            r4 = 1
            if (r1 == 0) goto L3d
            if (r1 != r4) goto L35
            java.lang.Object r7 = r0.L$1
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r7 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.b.b(r6)     // Catch: java.lang.Exception -> L33
            goto L78
        L33:
            r6 = move-exception
            goto L6a
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.b.b(r6)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask> r6 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.tasks
            java.lang.Object r6 = r6.get(r7)
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r6 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r6
            if (r6 != 0) goto L52
            java.lang.String r6 = "] Cannot switch to virtual display: task not found"
            com.stepos.statsrpk.service.c.w(r2, r7, r6, r3, r4)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        L52:
            android.content.Context r1 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.appContext     // Catch: java.lang.Exception -> L33
            r5 = 0
            if (r1 == 0) goto L64
            r0.L$0 = r7     // Catch: java.lang.Exception -> L33
            r0.L$1 = r5     // Catch: java.lang.Exception -> L33
            r0.label = r4     // Catch: java.lang.Exception -> L33
            java.lang.Object r6 = r6.switchToVirtualDisplay(r1, r0)     // Catch: java.lang.Exception -> L33
            if (r6 != r8) goto L78
            return r8
        L64:
            java.lang.String r6 = "appContext"
            kotlin.jvm.internal.k.n(r6)     // Catch: java.lang.Exception -> L33
            throw r5     // Catch: java.lang.Exception -> L33
        L6a:
            java.lang.String r6 = r6.getMessage()
            java.lang.String r8 = "] switchToVirtualDisplay failed: "
            java.lang.String r6 = B7.a.n(r2, r7, r8, r6)
            f6.AbstractC1436a.b(r3, r6, r4)
            r4 = 0
        L78:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.switchToVirtualDisplay(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object takeoverTask(java.lang.String r7, java.lang.String r8, H7.c<? super java.lang.Boolean> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11671
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$takeoverTask$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.C11671) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$takeoverTask$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge$takeoverTask$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            java.lang.String r3 = "["
            java.lang.String r4 = "SystemSdkBridge"
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 != r5) goto L37
            java.lang.Object r7 = r0.L$2
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r7 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.b.b(r9)
            goto L64
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.b.b(r9)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask> r9 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.tasks
            java.lang.Object r9 = r9.get(r7)
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r9 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask) r9
            if (r9 != 0) goto L54
            java.lang.String r6 = "] Cannot takeover: task not found"
            com.stepos.statsrpk.service.c.w(r3, r7, r6, r4, r5)
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        L54:
            r0.L$0 = r7
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r5
            java.lang.Object r9 = r9.takeover(r8, r0)
            if (r9 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r8 = r9.booleanValue()
            if (r8 == 0) goto L7e
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            r6.showFullScreenActivity(r7, r8)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            r6.append(r7)
            java.lang.String r7 = "] takeoverTask: using Activity interaction path"
            com.stepos.statsrpk.service.c.r(r6, r7, r4, r5)
        L7e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.takeoverTask(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    public final void transferDocUri$stepfun_release(String fromTaskId, String toTaskId) {
        kotlin.jvm.internal.k.f(fromTaskId, "fromTaskId");
        kotlin.jvm.internal.k.f(toTaskId, "toTaskId");
        ConcurrentHashMap<String, Uri> concurrentHashMap = taskIdToDocUri;
        Uri uriRemove = concurrentHashMap.remove(fromTaskId);
        if (uriRemove == null) {
            B7.a.z("transferDocUri: no uri for ", fromTaskId, ", skip", TAG, true);
            return;
        }
        concurrentHashMap.put(toTaskId, uriRemove);
        docUriToCurrentTaskId.put(uriRemove.toString(), toTaskId);
        StringBuilder sb = new StringBuilder("transferDocUri: ");
        sb.append(fromTaskId);
        sb.append(" → ");
        sb.append(toTaskId);
        sb.append(" (uri=");
        sb.append(uriRemove);
        com.stepos.statsrpk.service.c.r(sb, ")", TAG, true);
    }

    public final void unregisterDocUri$stepfun_release(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        Uri uriRemove = taskIdToDocUri.remove(taskId);
        if (uriRemove == null) {
            return;
        }
        docUriToCurrentTaskId.remove(uriRemove.toString(), taskId);
        AbstractC1436a.a(TAG, "[" + taskId + "] unregisterDocUri: " + uriRemove, true);
    }

    public final boolean unregisterProgressCallback(String taskId, int callerPid) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        ZyqlGuiAgentTask zyqlGuiAgentTask = tasks.get(taskId);
        if (zyqlGuiAgentTask == null) {
            AbstractC1436a.b(TAG, androidx.constraintlayout.core.dsl.a.d(callerPid, "[", taskId, "] Cannot unregister callback for callerPid=", ": task not found"), true);
            return false;
        }
        AbstractC1436a.a(TAG, "[" + taskId + "] unregisterProgressCallback callerPid=" + callerPid, true);
        zyqlGuiAgentTask.unregisterProgressCallback(callerPid);
        return true;
    }

    public final void updateFullScreenTaskExplain$stepfun_release(String taskId, String explain) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 != null) {
            fullScreenHelper2.updateTaskExplain(taskId, explain);
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }

    public final void updateFullScreenTaskState$stepfun_release(String taskId, SessionState state) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        FullScreenHelper fullScreenHelper2 = fullScreenHelper;
        if (fullScreenHelper2 == null) {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
        fullScreenHelper2.updateTaskState(taskId, state);
        FullScreenHelper fullScreenHelper3 = fullScreenHelper;
        if (fullScreenHelper3 != null) {
            fullScreenHelper3.maybeRefreshTouchForFollowMode(taskId, new n(9));
        } else {
            kotlin.jvm.internal.k.n("fullScreenHelper");
            throw null;
        }
    }
}
