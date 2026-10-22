package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import Ca.G;
import D7.v;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdisdk.Task;
import com.mdisdk.TaskManager;
import com.mdisdk.capability.model.RequestInfo;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.model.WindowType;
import com.mdisdk.observer.AppDiedFilter;
import com.mdisdk.observer.AppDiedInfo;
import com.mdisdk.observer.DisplayObserver;
import com.mdisdk.observer.ForegroundAppFilter;
import com.mdisdk.observer.ForegroundAppInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.VirtualDisplayCgroupHelper;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.common.bean.ExplainSnapshot;
import com.stepos.taskrobot.llmapi.stepfun.util.AuthTokenCache;
import com.stepos.taskrobot.taskmanager.experiencelib.model.SearchExperienceResult;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import f6.AbstractC1436a;
import g6.AbstractC1462b;
import g6.C1461a;
import g6.C1463c;
import h6.C1490b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.c0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import stepai.aios.guiagent.config.TaskConfig;
import stepai.aios.guiagent.llm.cell.config.ModelConfigs;
import stepai.aios.guiagent.llm.parser.IModelCell;
import stepai.aios.guiagent.model.SessionState;
import stepai.aios.guiagent.tracer.GuiNodeStepTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTaskNodeTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTaskTreeTraceSnapshot;
import stepai.aios.guiagent.tracer.GuiTracerManager;
import stepai.aios.guiagent.tracer.remote.GuiAgentTraceManager;
import stepai.aios.guiexecutor.input.UserInputListener;
import stepai.aios.guiexecutor.input.UserInputRequest;
import ua.C2052a;

@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ±\u00022\u00020\u0001:\u0004±\u0002²\u0002B]\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0019¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\"\u0010#J\u0012\u0010%\u001a\u0004\u0018\u00010$H\u0086@¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b'\u0010#J\u0012\u0010(\u001a\u0004\u0018\u00010$H\u0086@¢\u0006\u0004\b(\u0010&J\u000f\u0010*\u001a\u00020\u0019H\u0000¢\u0006\u0004\b)\u0010!J!\u0010,\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u00020\u0019H\u0000¢\u0006\u0004\b2\u0010!J\u000f\u00105\u001a\u00020\u0019H\u0000¢\u0006\u0004\b4\u0010!J\r\u00106\u001a\u00020\u0007¢\u0006\u0004\b6\u00107J\u0018\u00108\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b:\u00109J\u000f\u0010<\u001a\u00020\u0019H\u0000¢\u0006\u0004\b;\u0010!J\u001b\u0010@\u001a\u00020\u00192\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b>\u0010?J\u000f\u0010B\u001a\u00020\u0019H\u0000¢\u0006\u0004\bA\u0010!J\u001b\u0010D\u001a\u00020\u00192\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bC\u0010?J\u0019\u0010F\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010E\u001a\u00020\u0007¢\u0006\u0004\bF\u0010GJ\u0010\u0010I\u001a\u00020\u0011H\u0080@¢\u0006\u0004\bH\u0010&J\u001f\u0010M\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u00072\b\u0010L\u001a\u0004\u0018\u00010K¢\u0006\u0004\bM\u0010NJ\u0015\u0010O\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u0007¢\u0006\u0004\bO\u0010PJ\u0011\u0010S\u001a\u0004\u0018\u00010KH\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010U\u001a\u00020\u0011H\u0000¢\u0006\u0004\bT\u0010\u0013J9\u0010[\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u00022\n\b\u0002\u0010X\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b[\u0010\\J9\u0010^\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u00022\n\b\u0002\u0010X\u001a\u0004\u0018\u00010W2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b^\u0010\\J5\u0010d\u001a\u00020\u00192\u0006\u0010_\u001a\u00020\u00022\u0006\u0010`\u001a\u00020\u00022\u0006\u0010Z\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u00022\u0006\u0010c\u001a\u00020b¢\u0006\u0004\bd\u0010eJ\u001d\u0010f\u001a\u00020\u00192\u0006\u0010_\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\bf\u0010gJ\u0015\u0010j\u001a\u00020\u00192\u0006\u0010i\u001a\u00020h¢\u0006\u0004\bj\u0010kJ=\u0010r\u001a\u00020\u00192\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u00022\u0006\u0010n\u001a\u00020\u00022\u0006\u0010o\u001a\u00020\u00022\u0006\u0010p\u001a\u00020\u00022\u0006\u0010q\u001a\u00020\u0002¢\u0006\u0004\br\u0010sJ\r\u0010t\u001a\u00020\u0019¢\u0006\u0004\bt\u0010!J\u0017\u0010v\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0002H\u0000¢\u0006\u0004\bu\u0010\u001fJ\u000f\u0010x\u001a\u00020\u0019H\u0000¢\u0006\u0004\bw\u0010!J7\u0010z\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\b\b\u0002\u0010V\u001a\u00020\u00022\b\b\u0002\u0010y\u001a\u00020\u0002¢\u0006\u0004\bz\u0010{J#\u0010|\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017¢\u0006\u0004\b|\u0010}J\u000f\u0010~\u001a\u00020\u0002H\u0016¢\u0006\u0004\b~\u0010\u007fJ2\u0010\u0080\u0001\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u0082\u0001\u0010!J\u0011\u0010\u0083\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u0083\u0001\u0010!J\u001c\u0010\u0085\u0001\u001a\u00020\u00192\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0005\b\u0085\u0001\u0010\u001fJ\u001c\u0010\u0088\u0001\u001a\u00020\u00192\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001H\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001b\u0010\u008a\u0001\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0005\b\u008a\u0001\u0010\u001fJ\u0011\u0010\u008b\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u008b\u0001\u0010!J\u0011\u0010\u008c\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u008c\u0001\u0010!J\u0011\u0010\u008d\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u008d\u0001\u0010!J\u0011\u0010\u008e\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u008e\u0001\u0010!J\u0012\u0010\u008f\u0001\u001a\u00020\u0011H\u0082@¢\u0006\u0005\b\u008f\u0001\u0010&J%\u0010\u0091\u0001\u001a\u00020\u00192\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u00192\u0007\u0010\u0093\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0011\u0010\u0096\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u0096\u0001\u0010!J\u001f\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0097\u0001H\u0002¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u0011\u0010\u009a\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b\u009a\u0001\u0010!J\u001c\u0010\u009d\u0001\u001a\u00020\u00192\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001c\u0010 \u0001\u001a\u00020\u00192\b\u0010\u009c\u0001\u001a\u00030\u009f\u0001H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J$\u0010¤\u0001\u001a\u00020\u00192\b\u0010£\u0001\u001a\u00030¢\u00012\u0006\u0010a\u001a\u00020\u0002H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J#\u0010§\u0001\u001a\u00020\u00022\u0006\u0010a\u001a\u00020\u00022\u0007\u0010¦\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001c\u0010©\u0001\u001a\u00020\u00022\b\u0010£\u0001\u001a\u00030¢\u0001H\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u0011\u0010«\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b«\u0001\u0010!J\u0011\u0010¬\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0005\b¬\u0001\u0010!R\u0019\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u0003\u0010\u00ad\u0001\u001a\u0005\b®\u0001\u0010\u007fR\u0019\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\u000e\n\u0005\b\u0004\u0010\u00ad\u0001\u001a\u0005\b¯\u0001\u0010\u007fR\u0019\u0010\b\u001a\u00020\u00078\u0006¢\u0006\u000e\n\u0005\b\b\u0010°\u0001\u001a\u0005\b±\u0001\u00107R\u0019\u0010\t\u001a\u00020\u00078\u0006¢\u0006\u000e\n\u0005\b\t\u0010°\u0001\u001a\u0005\b²\u0001\u00107R\u001a\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\u000f\n\u0005\b\u000b\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b\f\u0010\u00ad\u0001\u001a\u0005\b¶\u0001\u0010\u007fR'\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\r\u0010\u00ad\u0001\u001a\u0005\b·\u0001\u0010\u007f\"\u0005\b¸\u0001\u0010\u001fR'\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u000e\u0010\u00ad\u0001\u001a\u0005\b¹\u0001\u0010\u007f\"\u0005\bº\u0001\u0010\u001fR\u001e\u0010»\u0001\u001a\u00020\u00028\u0006X\u0086D¢\u0006\u000f\n\u0006\b»\u0001\u0010\u00ad\u0001\u001a\u0005\b¼\u0001\u0010\u007fR5\u0010¾\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00058\u0006@@X\u0086\u000e¢\u0006\u0017\n\u0006\b¾\u0001\u0010¿\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0005\bÂ\u0001\u0010?R,\u0010Ä\u0001\u001a\u00030Ã\u00012\b\u0010½\u0001\u001a\u00030Ã\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R)\u0010È\u0001\u001a\u00020\u00112\u0007\u0010½\u0001\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0005\bÈ\u0001\u0010\u0013R(\u0010Ê\u0001\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÊ\u0001\u0010É\u0001\u001a\u0005\bË\u0001\u0010\u0013\"\u0006\bÌ\u0001\u0010\u0095\u0001R)\u0010Í\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÍ\u0001\u0010\u00ad\u0001\u001a\u0005\bÎ\u0001\u0010\u007f\"\u0005\bÏ\u0001\u0010\u001fR\u001b\u0010Ð\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010\u00ad\u0001R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010\u00ad\u0001R,\u0010Ó\u0001\u001a\u0005\u0018\u00010Ò\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R,\u0010\u0015\u001a\u0004\u0018\u00010\u00142\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00148\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u0015\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001R*\u0010Ý\u0001\u001a\u00030Ü\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÝ\u0001\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R*\u0010ä\u0001\u001a\u00030ã\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001\"\u0006\bè\u0001\u0010é\u0001R'\u0010ê\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0016\n\u0006\bê\u0001\u0010\u00ad\u0001\u001a\u0005\bë\u0001\u0010\u007f\"\u0005\bì\u0001\u0010\u001fR$\u0010î\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020K0í\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R,\u0010ñ\u0001\u001a\u00030ð\u00012\b\u0010½\u0001\u001a\u00030ð\u00018\u0006@BX\u0086.¢\u0006\u0010\n\u0006\bñ\u0001\u0010ò\u0001\u001a\u0006\bó\u0001\u0010ô\u0001R'\u0010õ\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bõ\u0001\u0010\u00ad\u0001\u001a\u0005\bö\u0001\u0010\u007f\"\u0005\b÷\u0001\u0010\u001fR\u001b\u0010ø\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010\u00ad\u0001R\u001b\u0010ù\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010\u00ad\u0001R\u0019\u0010ú\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010É\u0001R,\u0010ü\u0001\u001a\u0005\u0018\u00010û\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bü\u0001\u0010ý\u0001\u001a\u0006\bþ\u0001\u0010ÿ\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R*\u0010\u0082\u0002\u001a\u0004\u0018\u00010.8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0082\u0002\u0010\u0083\u0002\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0005\b\u0086\u0002\u00101R\u001f\u0010\u0087\u0002\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R\u001c\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R\u0019\u0010\u008e\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010°\u0001R\u001c\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u008b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010\u008d\u0002R\u001c\u0010\u0090\u0002\u001a\u0005\u0018\u00010\u008b\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u008d\u0002R\u0018\u0010\u0092\u0002\u001a\u00030\u0091\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002R\u001b\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0094\u0002\u0010\u00ad\u0001R\u0019\u0010\u0095\u0002\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0002\u0010É\u0001R-\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u00022\t\u0010½\u0001\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b\u0096\u0002\u0010\u00ad\u0001\u001a\u0005\b\u0097\u0002\u0010\u007fR)\u0010\u0098\u0002\u001a\u00020\u00112\u0007\u0010½\u0001\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b\u0098\u0002\u0010É\u0001\u001a\u0005\b\u0099\u0002\u0010\u0013R!\u0010\u009f\u0002\u001a\u00030\u009a\u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u009b\u0002\u0010\u009c\u0002\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002R!\u0010¤\u0002\u001a\u00030 \u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b¡\u0002\u0010\u009c\u0002\u001a\u0006\b¢\u0002\u0010£\u0002R!\u0010©\u0002\u001a\u00030¥\u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b¦\u0002\u0010\u009c\u0002\u001a\u0006\b§\u0002\u0010¨\u0002R\u001c\u0010«\u0002\u001a\u0005\u0018\u00010ª\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010¬\u0002R\u001c\u0010®\u0002\u001a\u0005\u0018\u00010\u00ad\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0002\u0010¯\u0002R\u0018\u0010°\u0002\u001a\u00030ª\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0002\u0010¬\u0002¨\u0006³\u0002"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "Lcom/mdisdk/Task;", "initialTask", "", WindowStateInfo.KEY_DISPLAY_ID, "taskType", "Landroid/content/Context;", "context", "guiModelName", "chatSessionId", "subSessionId", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lcom/mdisdk/Task;IILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "isHandleActive", "()Z", "Lm9/z;", "scope", "openAppName", "", "meta", "LC7/r;", "start", "(Lm9/z;Ljava/lang/String;Ljava/util/Map;)V", "checkExperinceUpdate", "reason", "cancel", "(Ljava/lang/String;)V", "failTaskForNetworkLost", "()V", "pause", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lza/d;", "resume", "(LH7/c;)Ljava/lang/Object;", "takeover", "recoverFromTakeover", "acknowledgeLlmTakeoverSupersededByFullscreen$stepfun_release", "acknowledgeLlmTakeoverSupersededByFullscreen", "ignoreActions", "release", "(ZLjava/lang/String;)V", "Landroid/view/Surface;", "surface", "setOutputSurface", "(Landroid/view/Surface;)V", "releaseDebugCompositor$stepfun_release", "releaseDebugCompositor", "pauseDebugToggleForHandover$stepfun_release", "pauseDebugToggleForHandover", "getActionDisplayId", "()I", "switchToVirtualDisplay", "(Landroid/content/Context;LH7/c;)Ljava/lang/Object;", "switchToMainDisplay", "registerForegroundAppObserver$stepfun_release", "registerForegroundAppObserver", "mdiTaskRef", "unregisterForegroundAppObserver$stepfun_release", "(Lcom/mdisdk/Task;)V", "unregisterForegroundAppObserver", "registerAppDiedObserver$stepfun_release", "registerAppDiedObserver", "unregisterAppDiedObserver$stepfun_release", "unregisterAppDiedObserver", "targetDisplayId", "getTopApp", "(I)Ljava/lang/String;", "reopenTargetAppIfOnLauncher$stepfun_release", "reopenTargetAppIfOnLauncher", "callerPid", "Lcom/stepos/taskrobot/common/ITaskProgressCallback;", "progressCallback", "registerProgressCallback", "(ILcom/stepos/taskrobot/common/ITaskProgressCallback;)V", "unregisterProgressCallback", "(I)V", "peekProgressCallback$stepfun_release", "()Lcom/stepos/taskrobot/common/ITaskProgressCallback;", "peekProgressCallback", "hasActiveProgressCallback$stepfun_release", "hasActiveProgressCallback", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Landroid/graphics/Bitmap;", "bitmap", GuiTaskProgressKt.GuiTaskProgress_KEY_BITMAP_ID, "message", "notifyProgressChanged", "(Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)V", BffConstant.Type.Url, "notifyProgressChangedPair", "requestId", "inputType", "payloadJson", "", "timeoutMs", "notifyInfoRequested", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "notifyInfoDismissed", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/taskrobot/common/bean/ExplainSnapshot;", RequestInfo.FUNCTION_SNAPSHOT, "notifyExplainUpdated", "(Lcom/stepos/taskrobot/common/bean/ExplainSnapshot;)V", "conflictKind", "newTaskId", "newTaskName", "runningTaskId", "packageName", "hint", "notifyPackageConflict", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dismissVoiceInput", "clearPendingInfo$stepfun_release", "clearPendingInfo", "flushPendingInfoIfAny$stepfun_release", "flushPendingInfoIfAny", "lastMessage", "upLoadLog", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "upLoadLogAgentCache", "(Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "collectTaskEvents", "(Lm9/z;Ljava/util/Map;)V", "sendDismissWakeBroadcast", "revokeOmniDisplayImeIfNeeded", "explain", "dispatchStepExplain", "Lza/g;", "stepInfo", "captureLlmTakeoverMessageIfNeeded", "(Lza/g;)V", "handleLlmRequestTakeover", "startLlmTakeoverTimeoutTimer", "cancelLlmTakeoverTimeoutTimer", "startTaskTimeoutTimer", "cancelTaskTimeoutTimer", "tryAutoRecoverFromLlmTakeover", "externalSurface", "installOutputSurface", "(Landroid/view/Surface;I)V", "enabled", "applyDebugOverlayState", "(Z)V", "observeDebugOverlayToggle", "Lkotlin/Pair;", "resolveOutputSize", "()Lkotlin/Pair;", "pushDebugInfo", "Lcom/mdisdk/observer/AppDiedInfo;", "info", "handleTargetAppDied", "(Lcom/mdisdk/observer/AppDiedInfo;)V", "Lcom/mdisdk/observer/ForegroundAppInfo;", "handleForegroundAppChange", "(Lcom/mdisdk/observer/ForegroundAppInfo;)V", "Lstepai/aios/guiexecutor/input/UserInputRequest;", "req", "cachePendingInfo", "(Lstepai/aios/guiexecutor/input/UserInputRequest;Ljava/lang/String;)V", "inFullScreen", "patchInFullScreen", "(Ljava/lang/String;Z)Ljava/lang/String;", "buildInfoPayload", "(Lstepai/aios/guiexecutor/input/UserInputRequest;)Ljava/lang/String;", "installInfoListenerIfNeeded", "uninstallInfoListenerIfNeeded", "Ljava/lang/String;", "getTaskId", "getTaskName", "I", "getDisplayId", "getTaskType", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getGuiModelName", "getChatSessionId", "setChatSessionId", "getSubSessionId", "setSubSessionId", "TASK_ID", "getTASK_ID", "value", "task", "Lcom/mdisdk/Task;", "getTask", "()Lcom/mdisdk/Task;", "setTask$stepfun_release", "Lstepai/aios/guiagent/model/SessionState;", "state", "Lstepai/aios/guiagent/model/SessionState;", "getState", "()Lstepai/aios/guiagent/model/SessionState;", "isTargetAppOpened", "Z", "runOnVirtualDisplay", "getRunOnVirtualDisplay", "setRunOnVirtualDisplay", "targetPackageName", "getTargetPackageName", "setTargetPackageName", "foregroundAppObserverId", "appDiedObserverId", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "experienceResult", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "getExperienceResult", "()Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;", "setExperienceResult", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SearchExperienceResult;)V", "Lm9/z;", "getScope", "()Lm9/z;", "Lza/f;", "sessionParam", "Lza/f;", "getSessionParam", "()Lza/f;", "setSessionParam", "(Lza/f;)V", "Lstepai/aios/guiagent/runtime/b;", "guiTaskHandle", "Lstepai/aios/guiagent/runtime/b;", "getGuiTaskHandle", "()Lstepai/aios/guiagent/runtime/b;", "setGuiTaskHandle", "(Lstepai/aios/guiagent/runtime/b;)V", "sessionId", "getSessionId", "setSessionId", "", "progressCallbacks", "Ljava/util/Map;", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "guiTaskRecord", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "getGuiTaskRecord", "()Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", AgentBusWakeContract.EXTRA_TRACE_ID, "getTraceId", "setTraceId", "taskSource", "msgSource", "aiWakeFullscreenTriggered", "Lg6/c;", "debugCompositor", "Lg6/c;", "getDebugCompositor$stepfun_release", "()Lg6/c;", "setDebugCompositor$stepfun_release", "(Lg6/c;)V", "lastExternalSurface", "Landroid/view/Surface;", "getLastExternalSurface$stepfun_release", "()Landroid/view/Surface;", "setLastExternalSurface$stepfun_release", "debugLock", "Ljava/lang/Object;", "getDebugLock$stepfun_release", "()Ljava/lang/Object;", "Lm9/c0;", "debugToggleJob", "Lm9/c0;", "llmTakeoverRetryCount", "llmTakeoverTimeoutJob", "taskTimeoutJob", "Ljava/util/concurrent/atomic/AtomicBoolean;", "networkFailTriggered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingFailureMessage", "takeOverProgressNotifiedForCurrentManualCycle", "lastLlmTakeoverMessage", "getLastLlmTakeoverMessage", "llmTakeoverPending", "getLlmTakeoverPending", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlSystemGuiActionExecutor;", "executor$delegate", "LC7/f;", "getExecutor", "()Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlSystemGuiActionExecutor;", "executor", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlSystemGuiAbilityProvider;", "abilityProvider$delegate", "getAbilityProvider", "()Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlSystemGuiAbilityProvider;", "abilityProvider", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlAppLauncher;", "appLauncher$delegate", "getAppLauncher", "()Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlAppLauncher;", "appLauncher", "Lstepai/aios/guiexecutor/input/UserInputListener;", "installedListener", "Lstepai/aios/guiexecutor/input/UserInputListener;", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask$PendingSuppressedInfo;", "pendingSuppressedInfo", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask$PendingSuppressedInfo;", "infoListener", "Companion", "PendingSuppressedInfo", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask {
    private static final String ACTION_DISMISS_WAKE = "com.stepos.ailauncher.action.DISMISS_WAKE";
    private static final String ACTION_SOURCE_LLM = "llm";
    private static final int FALLBACK_DISPLAY_ID = 0;
    private static final String FLOW_TAG = "DebugOverlayFlow";
    private static final String PKG_AILAUNCHER = "com.stepos.ailauncher";
    private static final String TAG = "ZyqlGuiAgentTask";
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final String TASK_ID;

    /* renamed from: abilityProvider$delegate, reason: from kotlin metadata */
    private final C7.f abilityProvider;
    private volatile boolean aiWakeFullscreenTriggered;
    private volatile String appDiedObserverId;

    /* renamed from: appLauncher$delegate, reason: from kotlin metadata */
    private final C7.f appLauncher;
    private volatile String chatSessionId;
    private final Context context;
    private volatile C1463c debugCompositor;
    private final Object debugLock;
    private c0 debugToggleJob;
    private final int displayId;

    /* renamed from: executor$delegate, reason: from kotlin metadata */
    private final C7.f executor;
    private SearchExperienceResult experienceResult;
    private volatile String foregroundAppObserverId;
    private final String guiModelName;
    public stepai.aios.guiagent.runtime.b guiTaskHandle;
    private GuiTaskRecord guiTaskRecord;
    private final UserInputListener infoListener;
    private UserInputListener installedListener;
    private volatile boolean isTargetAppOpened;
    private volatile Surface lastExternalSurface;
    private volatile String lastLlmTakeoverMessage;
    private volatile boolean llmTakeoverPending;
    private int llmTakeoverRetryCount;
    private c0 llmTakeoverTimeoutJob;
    private volatile String msgSource;
    private final AtomicBoolean networkFailTriggered;
    private volatile String pendingFailureMessage;
    private PendingSuppressedInfo pendingSuppressedInfo;
    private final Map<Integer, ITaskProgressCallback> progressCallbacks;
    private volatile boolean runOnVirtualDisplay;
    private InterfaceC1733z scope;
    public String sessionId;
    public za.f sessionParam;
    private volatile SessionState state;
    private volatile String subSessionId;
    private volatile boolean takeOverProgressNotifiedForCurrentManualCycle;
    private String targetPackageName;
    private volatile Task task;
    private final String taskId;
    private final String taskName;
    private volatile String taskSource;
    private c0 taskTimeoutJob;
    private final int taskType;
    private String traceId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> nonChangeForegroundAPP = H4.o.M("com.android.permissioncontroller");

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0013\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0097\u0001\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b!\u0010\"R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010)R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010)R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010)¨\u00061"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask$Companion;", "", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", "taskType", "Landroid/view/Surface;", "surface", "Lcom/mdisdk/Task;", "createMdiTask", "(Ljava/lang/String;Ljava/lang/String;ILandroid/view/Surface;)Lcom/mdisdk/Task;", "chatSessionId", "", "chatActive", "aiWakeShouldShowFullscreen$stepfun_release", "(Ljava/lang/String;Ljava/lang/Boolean;)Z", "aiWakeShouldShowFullscreen", "getCurrentTimeString", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "openAppName", "Lm9/z;", "scope", "guiModelName", "subSessionId", "resolvedPackageName", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "handoverFrom", "handoverMdiTask", "create", "(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;Ljava/lang/String;Lm9/z;Landroid/view/Surface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;Lcom/mdisdk/Task;)Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "", "nonChangeForegroundAPP", "Ljava/util/List;", "getNonChangeForegroundAPP", "()Ljava/util/List;", "TAG", "Ljava/lang/String;", "FLOW_TAG", "ACTION_SOURCE_LLM", "FALLBACK_DISPLAY_ID", "I", "TIME_FORMAT", "ACTION_DISMISS_WAKE", "PKG_AILAUNCHER", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final Task createMdiTask(String taskId, String taskName, int taskType, Surface surface) {
            Object objA;
            try {
                objA = TaskManager.create$default(taskId, null, false, 4, null);
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            Task task = (Task) objA;
            if (task != null) {
                return task;
            }
            AbstractC1436a.b(ZyqlGuiAgentTask.TAG, B7.a.n("[", taskId, "] Create MDI task failed: name=", taskName), true);
            return null;
        }

        public final boolean aiWakeShouldShowFullscreen$stepfun_release(String chatSessionId, Boolean chatActive) {
            if (chatSessionId == null || j9.m.s0(chatSessionId)) {
                return true;
            }
            return kotlin.jvm.internal.k.b(chatActive, Boolean.TRUE);
        }

        public final ZyqlGuiAgentTask create(String taskId, String taskName, int taskType, Context context, String openAppName, InterfaceC1733z scope, Surface surface, String guiModelName, String chatSessionId, String subSessionId, String resolvedPackageName, ZyqlGuiAgentTask handoverFrom, Task handoverMdiTask) {
            Object objA;
            Object objA2;
            int displayId;
            Task task;
            String currentModelId;
            String name;
            String str;
            IModelCell currentModelCell;
            kotlin.jvm.internal.k.f(taskId, "taskId");
            kotlin.jvm.internal.k.f(taskName, "taskName");
            kotlin.jvm.internal.k.f(context, "context");
            kotlin.jvm.internal.k.f(scope, "scope");
            boolean z10 = handoverFrom != null;
            if (!z10) {
                AbstractC1436a.d("========", "createMdiTask前", true);
                Task taskCreateMdiTask = createMdiTask(taskId, taskName, taskType, surface);
                AbstractC1436a.d("========", "createMdiTask后", true);
                if (taskCreateMdiTask == null) {
                    com.stepos.statsrpk.service.c.w("[", taskId, "] Failed to create MDI Task", ZyqlGuiAgentTask.TAG, true);
                    return null;
                }
                try {
                    objA = Integer.valueOf(taskCreateMdiTask.getDisplayId());
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                if (objA instanceof Result.Failure) {
                    objA = 0;
                }
                int iIntValue = ((Number) objA).intValue();
                AbstractC1436a.d(ZyqlGuiAgentTask.TAG, "[" + taskId + "] MDI Task created: displayId=" + iIntValue, true);
                VirtualDisplayCgroupHelper.INSTANCE.applyTier(iIntValue, 2);
                AbstractC1436a.d(ZyqlGuiAgentTask.TAG, "[" + taskId + "] vdcgroup set IMPORTANT display=" + iIntValue, true);
                try {
                    TaskManager.setRedirectActivity(new ComponentName(context.getApplicationContext(), (Class<?>) RedirectTrampolineActivity.class));
                    AbstractC1436a.d(ZyqlGuiAgentTask.TAG, "[" + taskId + "] setRedirectActivity registered", true);
                    objA2 = r.f317a;
                } catch (Throwable th2) {
                    objA2 = kotlin.b.a(th2);
                }
                Throwable thA = Result.a(objA2);
                if (thA != null) {
                    AbstractC1436a.b(ZyqlGuiAgentTask.TAG, B7.a.n("[", taskId, "] setRedirectActivity failed: ", thA.getMessage()), true);
                }
                displayId = iIntValue;
                task = taskCreateMdiTask;
            } else {
                if (handoverMdiTask == null) {
                    com.stepos.statsrpk.service.c.w("[", taskId, "] handover mdi task is null, abort", ZyqlGuiAgentTask.TAG, true);
                    return null;
                }
                kotlin.jvm.internal.k.c(handoverFrom);
                displayId = handoverFrom.getDisplayId();
                StringBuilder sbW = B7.a.w("[", taskId, "] create in handover mode: from=", handoverFrom.getTaskId(), ", displayId=");
                sbW.append(displayId);
                AbstractC1436a.d(ZyqlGuiAgentTask.TAG, sbW.toString(), true);
                task = handoverMdiTask;
            }
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
            Task task2 = task;
            ZyqlGuiAgentTask zyqlGuiAgentTask = new ZyqlGuiAgentTask(taskId, taskName, task2, displayId, taskType, applicationContext, guiModelName, chatSessionId, subSessionId, null);
            zyqlGuiAgentTask.setTargetPackageName(resolvedPackageName == null ? handoverFrom != null ? handoverFrom.getTargetPackageName() : null : resolvedPackageName);
            if (guiModelName == null || j9.m.s0(guiModelName)) {
                try {
                    currentModelId = ModelConfigs.instance.getCurrentModelId();
                } catch (Exception e) {
                    AbstractC1436a.b(ZyqlGuiAgentTask.TAG, B7.a.n("[", taskId, "] Failed to get currentModelId: ", e.getMessage()), true);
                    currentModelId = null;
                }
                try {
                    currentModelCell = ModelConfigs.instance.getCurrentModelCell();
                } catch (Exception e6) {
                    AbstractC1436a.b(ZyqlGuiAgentTask.TAG, B7.a.n("[", taskId, "] Failed to get currentModelCell: ", e6.getMessage()), true);
                }
                name = currentModelCell != null ? currentModelCell.getName() : null;
                str = currentModelId;
            } else {
                try {
                    name = ModelConfigs.instance.resolveModelCellForTask(guiModelName).getName();
                } catch (Exception e9) {
                    AbstractC1436a.b(ZyqlGuiAgentTask.TAG, B7.a.n("[", taskId, "] resolve task-level modelCell failed: ", e9.getMessage()), true);
                    name = null;
                }
                str = guiModelName;
            }
            String str2 = name;
            AbstractC1436a.d(ZyqlGuiAgentTask.TAG, androidx.constraintlayout.core.dsl.a.j(B7.a.w("[", taskId, "] Effective model: modelId=", str, ", modelCell="), str2, ", guiModelName=", guiModelName), true);
            zyqlGuiAgentTask.guiTaskRecord = GuiTaskRecordManager.INSTANCE.createRecord(taskName, taskId, openAppName, taskType, str, str2);
            GuitaskreportManager.createReport$default(GuitaskreportManager.INSTANCE, taskName, taskId, openAppName, null, 8, null);
            if (z10) {
                kotlin.jvm.internal.k.c(handoverFrom);
                handoverFrom.pauseDebugToggleForHandover$stepfun_release();
                synchronized (zyqlGuiAgentTask.getDebugLock()) {
                    zyqlGuiAgentTask.setDebugCompositor$stepfun_release(handoverFrom.getDebugCompositor());
                    zyqlGuiAgentTask.setLastExternalSurface$stepfun_release(handoverFrom.getLastExternalSurface());
                }
                zyqlGuiAgentTask.isTargetAppOpened = true;
                handoverFrom.setDebugCompositor$stepfun_release(null);
                handoverFrom.setLastExternalSurface$stepfun_release(null);
                AbstractC1436a.d(ZyqlGuiAgentTask.TAG, B7.a.n("[", taskId, "] handover complete: from=", handoverFrom.getTaskId()), true);
            } else {
                zyqlGuiAgentTask.installOutputSurface(surface, taskType);
            }
            if (z10) {
                AbstractC1683A.n(scope, null, new ZyqlGuiAgentTask$Companion$create$6(zyqlGuiAgentTask, taskId, context, openAppName, taskName, null), 3);
                return zyqlGuiAgentTask;
            }
            AbstractC1683A.n(scope, null, new ZyqlGuiAgentTask$Companion$create$job$1(zyqlGuiAgentTask, context, openAppName, taskName, taskType, task2, taskId, null), 3);
            return zyqlGuiAgentTask;
        }

        public final String getCurrentTimeString() {
            String str = new SimpleDateFormat(ZyqlGuiAgentTask.TIME_FORMAT, Locale.getDefault()).format(new Date());
            kotlin.jvm.internal.k.e(str, "format(...)");
            return str;
        }

        public final List<String> getNonChangeForegroundAPP() {
            return ZyqlGuiAgentTask.nonChangeForegroundAPP;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask$PendingSuppressedInfo;", "", "requestId", "", "inputType", "message", "payloadJson", "timeoutMs", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getRequestId", "()Ljava/lang/String;", "getInputType", "getMessage", "getPayloadJson", "getTimeoutMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PendingSuppressedInfo {
        private final String inputType;
        private final String message;
        private final String payloadJson;
        private final String requestId;
        private final long timeoutMs;

        public PendingSuppressedInfo(String requestId, String inputType, String message, String payloadJson, long j5) {
            kotlin.jvm.internal.k.f(requestId, "requestId");
            kotlin.jvm.internal.k.f(inputType, "inputType");
            kotlin.jvm.internal.k.f(message, "message");
            kotlin.jvm.internal.k.f(payloadJson, "payloadJson");
            this.requestId = requestId;
            this.inputType = inputType;
            this.message = message;
            this.payloadJson = payloadJson;
            this.timeoutMs = j5;
        }

        public static /* synthetic */ PendingSuppressedInfo copy$default(PendingSuppressedInfo pendingSuppressedInfo, String str, String str2, String str3, String str4, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingSuppressedInfo.requestId;
            }
            if ((i & 2) != 0) {
                str2 = pendingSuppressedInfo.inputType;
            }
            if ((i & 4) != 0) {
                str3 = pendingSuppressedInfo.message;
            }
            if ((i & 8) != 0) {
                str4 = pendingSuppressedInfo.payloadJson;
            }
            if ((i & 16) != 0) {
                j5 = pendingSuppressedInfo.timeoutMs;
            }
            long j6 = j5;
            return pendingSuppressedInfo.copy(str, str2, str3, str4, j6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRequestId() {
            return this.requestId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getInputType() {
            return this.inputType;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final String getPayloadJson() {
            return this.payloadJson;
        }

        /* renamed from: component5, reason: from getter */
        public final long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final PendingSuppressedInfo copy(String requestId, String inputType, String message, String payloadJson, long timeoutMs) {
            kotlin.jvm.internal.k.f(requestId, "requestId");
            kotlin.jvm.internal.k.f(inputType, "inputType");
            kotlin.jvm.internal.k.f(message, "message");
            kotlin.jvm.internal.k.f(payloadJson, "payloadJson");
            return new PendingSuppressedInfo(requestId, inputType, message, payloadJson, timeoutMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingSuppressedInfo)) {
                return false;
            }
            PendingSuppressedInfo pendingSuppressedInfo = (PendingSuppressedInfo) other;
            return kotlin.jvm.internal.k.b(this.requestId, pendingSuppressedInfo.requestId) && kotlin.jvm.internal.k.b(this.inputType, pendingSuppressedInfo.inputType) && kotlin.jvm.internal.k.b(this.message, pendingSuppressedInfo.message) && kotlin.jvm.internal.k.b(this.payloadJson, pendingSuppressedInfo.payloadJson) && this.timeoutMs == pendingSuppressedInfo.timeoutMs;
        }

        public final String getInputType() {
            return this.inputType;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getPayloadJson() {
            return this.payloadJson;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final long getTimeoutMs() {
            return this.timeoutMs;
        }

        public int hashCode() {
            return Long.hashCode(this.timeoutMs) + B7.a.c(B7.a.c(B7.a.c(this.requestId.hashCode() * 31, 31, this.inputType), 31, this.message), 31, this.payloadJson);
        }

        public String toString() {
            String str = this.requestId;
            String str2 = this.inputType;
            String str3 = this.message;
            String str4 = this.payloadJson;
            long j5 = this.timeoutMs;
            StringBuilder sbW = B7.a.w("PendingSuppressedInfo(requestId=", str, ", inputType=", str2, ", message=");
            androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", payloadJson=", str4, ", timeoutMs=");
            return androidx.constraintlayout.core.dsl.a.e(j5, ")", sbW);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$collectTaskEvents$1", f = "ZyqlGuiAgentTask.kt", l = {951}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$collectTaskEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
        final /* synthetic */ Gson $gson;
        final /* synthetic */ Map<String, Object> $meta;
        final /* synthetic */ InterfaceC1733z $scope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Gson gson, InterfaceC1733z interfaceC1733z, Map<String, ? extends Object> map, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$gson = gson;
            this.$scope = interfaceC1733z;
            this.$meta = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ZyqlGuiAgentTask.this.new AnonymousClass1(this.$gson, this.$scope, this.$meta, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                throw new KotlinNothingValueException();
            }
            kotlin.b.b(obj);
            kotlinx.coroutines.flow.h hVar = ZyqlGuiAgentTask.this.getGuiTaskHandle().c;
            C01651 c01651 = new C01651(ZyqlGuiAgentTask.this, this.$gson, this.$scope, this.$meta);
            this.label = 1;
            hVar.collect(c01651, this);
            return coroutineSingletons;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$collectTaskEvents$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01651<T> implements p9.d {
            final /* synthetic */ Gson $gson;
            final /* synthetic */ Map<String, Object> $meta;
            final /* synthetic */ InterfaceC1733z $scope;
            final /* synthetic */ ZyqlGuiAgentTask this$0;

            public C01651(ZyqlGuiAgentTask zyqlGuiAgentTask, Gson gson, InterfaceC1733z interfaceC1733z, Map<String, ? extends Object> map) {
                this.this$0 = zyqlGuiAgentTask;
                this.$gson = gson;
                this.$scope = interfaceC1733z;
                this.$meta = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:106:0x03f9  */
            /* JADX WARN: Removed duplicated region for block: B:107:0x03fe  */
            /* JADX WARN: Removed duplicated region for block: B:110:0x0409  */
            /* JADX WARN: Removed duplicated region for block: B:113:0x0430  */
            /* JADX WARN: Removed duplicated region for block: B:121:0x0456  */
            /* JADX WARN: Removed duplicated region for block: B:126:0x047d  */
            /* JADX WARN: Removed duplicated region for block: B:139:0x04cc  */
            /* JADX WARN: Removed duplicated region for block: B:160:0x0571  */
            /* JADX WARN: Removed duplicated region for block: B:201:0x06a4  */
            /* JADX WARN: Removed duplicated region for block: B:219:0x0789  */
            /* JADX WARN: Removed duplicated region for block: B:226:0x07c1 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x01e3  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x021c  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x0257  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x026c  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x027f A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:70:0x02af  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x02c5  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
            /* JADX WARN: Removed duplicated region for block: B:87:0x0319 A[Catch: Exception -> 0x032f, TryCatch #1 {Exception -> 0x032f, blocks: (B:85:0x0315, B:87:0x0319, B:90:0x0331, B:92:0x0337, B:93:0x034e, B:95:0x0354), top: B:270:0x0315 }] */
            /* JADX WARN: Removed duplicated region for block: B:90:0x0331 A[Catch: Exception -> 0x032f, TryCatch #1 {Exception -> 0x032f, blocks: (B:85:0x0315, B:87:0x0319, B:90:0x0331, B:92:0x0337, B:93:0x034e, B:95:0x0354), top: B:270:0x0315 }] */
            /* JADX WARN: Type inference failed for: r11v0 */
            /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r11v2 */
            /* JADX WARN: Type inference failed for: r13v7 */
            /* JADX WARN: Type inference failed for: r13v8, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r13v9 */
            /* JADX WARN: Type inference failed for: r14v2 */
            /* JADX WARN: Type inference failed for: r14v3, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r14v4 */
            /* JADX WARN: Type inference failed for: r5v43 */
            /* JADX WARN: Type inference failed for: r5v44, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r5v48 */
            /* JADX WARN: Type inference failed for: r6v32 */
            /* JADX WARN: Type inference failed for: r6v33, types: [boolean, int] */
            /* JADX WARN: Type inference failed for: r6v34 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(Ca.G r34, H7.c<? super C7.r> r35) throws org.json.JSONException, android.os.RemoteException {
                /*
                    Method dump skipped, instructions count: 2294
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.AnonymousClass1.C01651.emit(Ca.G, H7.c):java.lang.Object");
            }

            @Override // p9.d
            public /* bridge */ /* synthetic */ Object emit(Object obj, H7.c cVar) {
                return emit((G) obj, (H7.c<? super r>) cVar);
            }
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$collectTaskEvents$2", f = "ZyqlGuiAgentTask.kt", l = {1203}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$collectTaskEvents$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements S7.n {
        int label;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ZyqlGuiAgentTask.this.new AnonymousClass2(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                throw new KotlinNothingValueException();
            }
            kotlin.b.b(obj);
            kotlinx.coroutines.flow.i iVar = ZyqlGuiAgentTask.this.getGuiTaskHandle().d;
            final ZyqlGuiAgentTask zyqlGuiAgentTask = ZyqlGuiAgentTask.this;
            p9.d dVar = new p9.d() { // from class: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.collectTaskEvents.2.1
                @Override // p9.d
                public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                    return emit((SessionState) obj2, (H7.c<? super r>) cVar);
                }

                public final Object emit(SessionState sessionState, H7.c<? super r> cVar) {
                    Boolean boolValueOf;
                    AbstractC1436a.a(ZyqlGuiAgentTask.TAG, "[" + zyqlGuiAgentTask.getTaskId() + "] Session state changed: " + sessionState, true);
                    SessionState sessionState2 = (zyqlGuiAgentTask.networkFailTriggered.get() && sessionState.a()) ? SessionState.h : sessionState;
                    zyqlGuiAgentTask.state = sessionState2;
                    zyqlGuiAgentTask.getGuiTaskRecord().setTaskState(sessionState2);
                    SessionState sessionState3 = SessionState.f;
                    if (sessionState != sessionState3) {
                        zyqlGuiAgentTask.takeOverProgressNotifiedForCurrentManualCycle = false;
                        zyqlGuiAgentTask.llmTakeoverPending = false;
                    }
                    SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
                    systemSdkBridge.updateFullScreenTaskState$stepfun_release(zyqlGuiAgentTask.getTaskId(), sessionState2);
                    if (kotlin.jvm.internal.k.b(zyqlGuiAgentTask.msgSource, "ai_wake") && !zyqlGuiAgentTask.aiWakeFullscreenTriggered) {
                        sessionState.getClass();
                        if (H4.o.N(SessionState.b, SessionState.c, SessionState.d, SessionState.e, sessionState3).contains(sessionState)) {
                            zyqlGuiAgentTask.aiWakeFullscreenTriggered = true;
                            String chatSessionId = zyqlGuiAgentTask.getChatSessionId();
                            if (chatSessionId == null || j9.m.s0(chatSessionId)) {
                                com.stepos.statsrpk.service.c.p("[", zyqlGuiAgentTask.getTaskId(), "] ai_wake fullscreen: no chatSessionId yet, fallback to msgSource-only -> fullscreen", ZyqlGuiAgentTask.TAG, true);
                                boolValueOf = null;
                            } else {
                                boolean zIsChatActive$stepfun_release = systemSdkBridge.isChatActive$stepfun_release(chatSessionId);
                                boolValueOf = Boolean.valueOf(zIsChatActive$stepfun_release);
                                StringBuilder sbW = B7.a.w("[", zyqlGuiAgentTask.getTaskId(), "] ai_wake fullscreen: re-query chat_active sid=", chatSessionId, " active=");
                                sbW.append(zIsChatActive$stepfun_release);
                                AbstractC1436a.d(ZyqlGuiAgentTask.TAG, sbW.toString(), true);
                            }
                            if (ZyqlGuiAgentTask.INSTANCE.aiWakeShouldShowFullscreen$stepfun_release(chatSessionId, boolValueOf)) {
                                AbstractC1436a.d(ZyqlGuiAgentTask.TAG, androidx.appfunctions.metadata.a.m("[", zyqlGuiAgentTask.getTaskId(), "] ai_wake: auto show FullScreenActivity (sid=", chatSessionId, ")"), true);
                                systemSdkBridge.showFullScreenActivity(zyqlGuiAgentTask.getTaskId(), null);
                                zyqlGuiAgentTask.sendDismissWakeBroadcast();
                            } else {
                                StringBuilder sbW2 = B7.a.w("[", zyqlGuiAgentTask.getTaskId(), "] ai_wake: skip fullscreen, ailauncher chat not active (sid=", chatSessionId, ", active=");
                                sbW2.append(boolValueOf);
                                sbW2.append(")");
                                AbstractC1436a.d(ZyqlGuiAgentTask.TAG, sbW2.toString(), true);
                            }
                        }
                    }
                    zyqlGuiAgentTask.pushDebugInfo();
                    return r.f317a;
                }
            };
            this.label = 1;
            iVar.collect(dVar, this);
            return coroutineSingletons;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$handleTargetAppDied$1", f = "ZyqlGuiAgentTask.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$handleTargetAppDied$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11681 extends SuspendLambda implements S7.n {
        int label;

        public C11681(H7.c<? super C11681> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ZyqlGuiAgentTask.this.new C11681(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws RemoteException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            SystemSdkBridge.clearTask$default(SystemSdkBridge.INSTANCE, ZyqlGuiAgentTask.this.getTaskId(), false, "目标应用进程死亡", 2, null);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11681) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$observeDebugOverlayToggle$1", f = "ZyqlGuiAgentTask.kt", l = {1915}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$observeDebugOverlayToggle$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11691 extends SuspendLambda implements S7.n {
        int label;

        public C11691(H7.c<? super C11691> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ZyqlGuiAgentTask.this.new C11691(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                p9.l lVar = AbstractC1462b.b;
                final ZyqlGuiAgentTask zyqlGuiAgentTask = ZyqlGuiAgentTask.this;
                p9.d dVar = new p9.d() { // from class: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.observeDebugOverlayToggle.1.1
                    @Override // p9.d
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                        return emit(((Boolean) obj2).booleanValue(), (H7.c<? super r>) cVar);
                    }

                    public final Object emit(boolean z10, H7.c<? super r> cVar) {
                        zyqlGuiAgentTask.applyDebugOverlayState(z10);
                        return r.f317a;
                    }
                };
                this.label = 1;
                if (lVar.f5562a.collect(dVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11691) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {1350}, m = "pause", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$pause$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11701 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11701(H7.c<? super C11701> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlGuiAgentTask.this.pause(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {1447, 1454}, m = "recoverFromTakeover", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$recoverFromTakeover$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C11711(H7.c<? super C11711> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlGuiAgentTask.this.recoverFromTakeover(this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {1377}, m = "resume", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$resume$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11721 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C11721(H7.c<? super C11721> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlGuiAgentTask.this.resume(this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$3", f = "ZyqlGuiAgentTask.kt", l = {778}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements S7.n {
        final /* synthetic */ Map<String, Object> $meta;
        final /* synthetic */ String $openAppName;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ZyqlGuiAgentTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Map<String, ? extends Object> map, ZyqlGuiAgentTask zyqlGuiAgentTask, String str, H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$meta = map;
            this.this$0 = zyqlGuiAgentTask;
            this.$openAppName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$meta, this.this$0, this.$openAppName, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0096  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = r11.L$0
                m9.z r0 = (m9.InterfaceC1733z) r0
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r11.label
                r2 = 1
                if (r1 == 0) goto L28
                if (r1 != r2) goto L20
                java.lang.Object r0 = r11.L$1
                m9.z r0 = (m9.InterfaceC1733z) r0
                kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L1b
                kotlin.Result r12 = (kotlin.Result) r12     // Catch: java.lang.Throwable -> L1b
                java.lang.Object r12 = r12.f4887a     // Catch: java.lang.Throwable -> L1b
                r10 = r11
                goto L7a
            L1b:
                r0 = move-exception
                r12 = r0
                r10 = r11
                goto L8a
            L20:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L28:
                kotlin.b.b(r12)
                java.util.Map<java.lang.String, java.lang.Object> r8 = r11.$meta
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r12 = r11.this$0
                java.lang.String r1 = r11.$openAppName
                com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2 r3 = com.stepos.taskrobot.llmapi.stepfun.trace.GuiAgentTraceManagerV2.INSTANCE     // Catch: java.lang.Throwable -> L87
                java.lang.String r4 = r12.getTASK_ID()     // Catch: java.lang.Throwable -> L87
                java.lang.Object r4 = r8.get(r4)     // Catch: java.lang.Throwable -> L87
                boolean r5 = r4 instanceof java.lang.String     // Catch: java.lang.Throwable -> L87
                r6 = 0
                if (r5 == 0) goto L43
                java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L1b
                goto L44
            L43:
                r4 = r6
            L44:
                java.lang.String r5 = ""
                if (r4 != 0) goto L49
                r4 = r5
            L49:
                java.lang.String r7 = "trace_id"
                java.lang.Object r7 = r8.get(r7)     // Catch: java.lang.Throwable -> L87
                boolean r9 = r7 instanceof java.lang.String     // Catch: java.lang.Throwable -> L87
                if (r9 == 0) goto L56
                java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L1b
                goto L57
            L56:
                r7 = r6
            L57:
                if (r7 != 0) goto L5a
                r7 = r5
            L5a:
                r9 = r6
                java.lang.String r6 = r12.getTaskName()     // Catch: java.lang.Throwable -> L87
                if (r1 != 0) goto L62
                r1 = r5
            L62:
                java.lang.String r12 = r12.getSubSessionId()     // Catch: java.lang.Throwable -> L87
                r11.L$0 = r9     // Catch: java.lang.Throwable -> L87
                r11.L$1 = r9     // Catch: java.lang.Throwable -> L87
                r5 = 0
                r11.I$0 = r5     // Catch: java.lang.Throwable -> L87
                r11.label = r2     // Catch: java.lang.Throwable -> L87
                r10 = r11
                r9 = r12
                r5 = r7
                r7 = r1
                java.lang.Object r12 = r3.m7355postTaskStartbMdYcbs(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L84
                if (r12 != r0) goto L7a
                return r0
            L7a:
                kotlin.Result r11 = new kotlin.Result     // Catch: java.lang.Throwable -> L80
                r11.<init>(r12)     // Catch: java.lang.Throwable -> L80
                goto L8e
            L80:
                r0 = move-exception
                r11 = r0
                r12 = r11
                goto L8a
            L84:
                r0 = move-exception
            L85:
                r12 = r0
                goto L8a
            L87:
                r0 = move-exception
                r10 = r11
                goto L85
            L8a:
                kotlin.Result$Failure r11 = kotlin.b.a(r12)
            L8e:
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r12 = r10.this$0
                java.lang.Throwable r11 = kotlin.Result.a(r11)
                if (r11 == 0) goto Lab
                java.lang.String r12 = r12.getTaskId()
                java.lang.String r11 = r11.getMessage()
                java.lang.String r0 = "["
                java.lang.String r1 = "] uplink report failed: "
                java.lang.String r11 = B7.a.n(r0, r12, r1, r11)
                java.lang.String r12 = "ZyqlGuiAgentTask"
                f6.AbstractC1436a.b(r12, r11, r2)
            Lab:
                C7.r r11 = C7.r.f317a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$5", f = "ZyqlGuiAgentTask.kt", l = {872}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements S7.n {
        final /* synthetic */ TaskEntity $taskEntity;
        int label;
        final /* synthetic */ ZyqlGuiAgentTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(TaskEntity taskEntity, ZyqlGuiAgentTask zyqlGuiAgentTask, H7.c<? super AnonymousClass5> cVar) {
            super(2, cVar);
            this.$taskEntity = taskEntity;
            this.this$0 = zyqlGuiAgentTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass5(this.$taskEntity, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                com.stepos.taskrobot.taskmemory.a aVar = com.stepos.taskrobot.taskmemory.a.f4061a;
                TaskEntity taskEntity = this.$taskEntity;
                this.label = 1;
                obj = aVar.a(taskEntity, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            ((Number) obj).longValue();
            s6.f fVarB = s6.f.b();
            String taskId = this.this$0.getTaskId();
            TaskEntity taskEntity2 = this.$taskEntity;
            fVarB.getClass();
            kotlin.jvm.internal.k.f(taskId, "taskId");
            kotlin.jvm.internal.k.f(taskEntity2, "taskEntity");
            s6.f.c.a(taskEntity2, taskId);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass5) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$6", f = "ZyqlGuiAgentTask.kt", l = {896, 917, 925, 928}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements S7.n {
        final /* synthetic */ Map<String, Object> $meta;
        final /* synthetic */ String $openAppName;
        final /* synthetic */ InterfaceC1733z $scope;
        final /* synthetic */ TaskConfig $taskConfig;
        final /* synthetic */ za.j $taskTreeContext;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ZyqlGuiAgentTask this$0;

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$6$1", f = "ZyqlGuiAgentTask.kt", l = {911}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$6$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.n {
            int label;

            public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    AuthTokenCache authTokenCache = AuthTokenCache.INSTANCE;
                    this.label = 1;
                    if (authTokenCache.refreshForTaskStart(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$6$2", f = "ZyqlGuiAgentTask.kt", l = {}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lkotlin/Result;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
        /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$start$6$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements S7.n {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ZyqlGuiAgentTask this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ZyqlGuiAgentTask zyqlGuiAgentTask, H7.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.this$0 = zyqlGuiAgentTask;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, cVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objA;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                try {
                    Object systemService = this.this$0.getContext().getSystemService("clipboard");
                    kotlin.jvm.internal.k.d(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("", ""));
                    objA = r.f317a;
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                ZyqlGuiAgentTask zyqlGuiAgentTask = this.this$0;
                Throwable thA = Result.a(objA);
                if (thA != null) {
                    AbstractC1436a.b(ZyqlGuiAgentTask.TAG, B7.a.n("[", zyqlGuiAgentTask.getTaskId(), "] Failed to clear clipboard: ", thA.getMessage()), true);
                }
                return new Result(objA);
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Result<r>> cVar) {
                return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Map<String, ? extends Object> map, ZyqlGuiAgentTask zyqlGuiAgentTask, za.j jVar, TaskConfig taskConfig, String str, InterfaceC1733z interfaceC1733z, H7.c<? super AnonymousClass6> cVar) {
            super(2, cVar);
            this.$meta = map;
            this.this$0 = zyqlGuiAgentTask;
            this.$taskTreeContext = jVar;
            this.$taskConfig = taskConfig;
            this.$openAppName = str;
            this.$scope = interfaceC1733z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass6(this.$meta, this.this$0, this.$taskTreeContext, this.$taskConfig, this.$openAppName, this.$scope, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0137, code lost:
        
            if (r4.o(r2.f6130a, r18) == r1) goto L34;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x011c  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0156  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 354
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.AnonymousClass6.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass6) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$startLlmTakeoverTimeoutTimer$1", f = "ZyqlGuiAgentTask.kt", l = {1580, 1591}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$startLlmTakeoverTimeoutTimer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11731 extends SuspendLambda implements S7.n {
        private /* synthetic */ Object L$0;
        boolean Z$0;
        int label;

        public C11731(H7.c<? super C11731> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C11731 c11731 = ZyqlGuiAgentTask.this.new C11731(cVar);
            c11731.L$0 = obj;
            return c11731;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
        
            if (r8 == r1) goto L22;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005c -> B:23:0x005f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                m9.z r0 = (m9.InterfaceC1733z) r0
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L20
                if (r2 == r4) goto L1c
                if (r2 != r3) goto L14
                kotlin.b.b(r8)
                goto L5f
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1c:
                kotlin.b.b(r8)
                goto L31
            L20:
                kotlin.b.b(r8)
                r7.L$0 = r0
                r7.label = r4
                r5 = 60000(0xea60, double:2.9644E-319)
                java.lang.Object r8 = kotlinx.coroutines.a.f(r5, r7)
                if (r8 != r1) goto L31
                goto L5e
            L31:
                boolean r8 = m9.AbstractC1683A.l(r0)
                if (r8 == 0) goto L8c
                com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge r8 = com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge.INSTANCE
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r2 = com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.this
                java.lang.String r2 = r2.getTaskId()
                boolean r8 = r8.isTaskTakenOverByExternal(r2)
                if (r8 != 0) goto L68
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r2 = com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.this
                stepai.aios.guiagent.model.SessionState r2 = r2.getState()
                stepai.aios.guiagent.model.SessionState r5 = stepai.aios.guiagent.model.SessionState.f
                if (r2 == r5) goto L50
                goto L68
            L50:
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r2 = com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.this
                r7.L$0 = r0
                r7.Z$0 = r8
                r7.label = r3
                java.lang.Object r8 = com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.access$tryAutoRecoverFromLlmTakeover(r2, r7)
                if (r8 != r1) goto L5f
            L5e:
                return r1
            L5f:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L31
                goto L8c
            L68:
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r8 = com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.this
                r0 = 0
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.access$setLlmTakeoverRetryCount$p(r8, r0)
                com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask r7 = com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.this
                java.lang.String r7 = r7.getTaskId()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r0 = "["
                r8.<init>(r0)
                r8.append(r7)
                java.lang.String r7 = "] External takeover or left MANUAL_TAKEOVER, stop LLM takeover timer"
                r8.append(r7)
                java.lang.String r7 = r8.toString()
                java.lang.String r8 = "ZyqlGuiAgentTask"
                f6.AbstractC1436a.a(r8, r7, r4)
            L8c:
                C7.r r7 = C7.r.f317a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11731.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11731) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$startTaskTimeoutTimer$1", f = "ZyqlGuiAgentTask.kt", l = {1607}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$startTaskTimeoutTimer$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11741 extends SuspendLambda implements S7.n {
        int label;

        public C11741(H7.c<? super C11741> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return ZyqlGuiAgentTask.this.new C11741(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws RemoteException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                this.label = 1;
                if (kotlinx.coroutines.a.f(1220000L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            B7.a.z("[", ZyqlGuiAgentTask.this.getTaskId(), "] Task execution timeout after 1220000ms, force stopping", ZyqlGuiAgentTask.TAG, true);
            SystemSdkBridge.clearTask$default(SystemSdkBridge.INSTANCE, ZyqlGuiAgentTask.this.getTaskId(), false, InjectExperienceResult.REASON_TIMEOUT, 2, null);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11741) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {WindowType.VOICE_INTERACTION_STARTING}, m = "switchToMainDisplay", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToMainDisplay$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11751 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11751(H7.c<? super C11751> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlGuiAgentTask.this.switchToMainDisplay(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {WindowType.SYSTEM_DIALOG}, m = "switchToVirtualDisplay", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToVirtualDisplay$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11761 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11761(H7.c<? super C11761> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlGuiAgentTask.this.switchToVirtualDisplay(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {1415}, m = "takeover", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$takeover$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11771 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C11771(H7.c<? super C11771> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlGuiAgentTask.this.takeover(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask", f = "ZyqlGuiAgentTask.kt", l = {1630}, m = "tryAutoRecoverFromLlmTakeover", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$tryAutoRecoverFromLlmTakeover$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11781 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C11781(H7.c<? super C11781> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlGuiAgentTask.this.tryAutoRecoverFromLlmTakeover(this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$upLoadLog$1", f = "ZyqlGuiAgentTask.kt", l = {2771, 2783}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$upLoadLog$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11791 extends SuspendLambda implements S7.n {
        final /* synthetic */ String $action;
        final /* synthetic */ String $lastMessage;
        final /* synthetic */ Map<String, Object> $meta;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ZyqlGuiAgentTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11791(Map<String, ? extends Object> map, ZyqlGuiAgentTask zyqlGuiAgentTask, String str, String str2, H7.c<? super C11791> cVar) {
            super(2, cVar);
            this.$meta = map;
            this.this$0 = zyqlGuiAgentTask;
            this.$action = str;
            this.$lastMessage = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r invokeSuspend$lambda$2(String str) {
            AbstractC1436a.a("upLoadLog", "日志上传中 progress = " + str, true);
            return r.f317a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r invokeSuspend$lambda$5(String str) {
            AbstractC1436a.a("RobotTraceV2", "日志上传中 progress = " + str, true);
            return r.f317a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C11791(this.$meta, this.this$0, this.$action, this.$lastMessage, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01ea A[Catch: Exception -> 0x022b, TryCatch #0 {Exception -> 0x022b, blocks: (B:7:0x0023, B:85:0x01e4, B:87:0x01ea, B:88:0x01fc, B:90:0x0200, B:92:0x0204, B:94:0x020b, B:96:0x020f, B:100:0x0218, B:12:0x0040, B:46:0x0134, B:48:0x013a, B:49:0x014c, B:51:0x0150, B:53:0x0154, B:55:0x015a, B:57:0x015e, B:61:0x0166, B:62:0x0178, B:64:0x0198, B:66:0x019e, B:68:0x01a2, B:73:0x01ac, B:75:0x01b4, B:77:0x01b8, B:81:0x01c0, B:15:0x0055, B:17:0x005e, B:18:0x0066, B:20:0x006c, B:21:0x0099, B:23:0x009d, B:25:0x00a8, B:27:0x00c8, B:30:0x00d4, B:33:0x00e2, B:35:0x00fd, B:36:0x0102, B:38:0x010c, B:42:0x0114, B:29:0x00ce), top: B:105:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0200 A[Catch: Exception -> 0x022b, TryCatch #0 {Exception -> 0x022b, blocks: (B:7:0x0023, B:85:0x01e4, B:87:0x01ea, B:88:0x01fc, B:90:0x0200, B:92:0x0204, B:94:0x020b, B:96:0x020f, B:100:0x0218, B:12:0x0040, B:46:0x0134, B:48:0x013a, B:49:0x014c, B:51:0x0150, B:53:0x0154, B:55:0x015a, B:57:0x015e, B:61:0x0166, B:62:0x0178, B:64:0x0198, B:66:0x019e, B:68:0x01a2, B:73:0x01ac, B:75:0x01b4, B:77:0x01b8, B:81:0x01c0, B:15:0x0055, B:17:0x005e, B:18:0x0066, B:20:0x006c, B:21:0x0099, B:23:0x009d, B:25:0x00a8, B:27:0x00c8, B:30:0x00d4, B:33:0x00e2, B:35:0x00fd, B:36:0x0102, B:38:0x010c, B:42:0x0114, B:29:0x00ce), top: B:105:0x0015 }] */
        /* JADX WARN: Type inference failed for: r0v44, types: [java.util.Map] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 565
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11791.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11791) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$upLoadLogAgentCache$1", f = "ZyqlGuiAgentTask.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$upLoadLogAgentCache$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11801 extends SuspendLambda implements S7.n {
        int label;

        public C11801(H7.c<? super C11801> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C11801(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C11801) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public /* synthetic */ ZyqlGuiAgentTask(String str, String str2, Task task, int i, int i6, Context context, String str3, String str4, String str5, kotlin.jvm.internal.e eVar) {
        this(str, str2, task, i, i6, context, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZyqlSystemGuiAbilityProvider abilityProvider_delegate$lambda$0(ZyqlGuiAgentTask zyqlGuiAgentTask) {
        return new ZyqlSystemGuiAbilityProvider(new m(zyqlGuiAgentTask, 0), new ZyqlGuiAgentTask$abilityProvider$2$2(zyqlGuiAgentTask), zyqlGuiAgentTask.taskId, zyqlGuiAgentTask.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZyqlAppLauncher appLauncher_delegate$lambda$0(ZyqlGuiAgentTask zyqlGuiAgentTask) {
        return new ZyqlAppLauncher(zyqlGuiAgentTask.taskId, zyqlGuiAgentTask.context, new ZyqlGuiAgentTask$appLauncher$2$1(zyqlGuiAgentTask), new m(zyqlGuiAgentTask, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyDebugOverlayState(boolean enabled) {
        String str;
        boolean z10;
        Object objA;
        Object objA2;
        if (this.taskType == 0) {
            AbstractC1436a.a(FLOW_TAG, "[" + this.taskId + "] applyDebugOverlayState(" + enabled + ") skip: taskType=NORMAL", true);
            return;
        }
        Task task = this.task;
        if (task == null) {
            AbstractC1436a.a(FLOW_TAG, "[" + this.taskId + "] applyDebugOverlayState(" + enabled + ") skip: task is null (handed over)", true);
            return;
        }
        synchronized (this.debugLock) {
            try {
                Surface surface = this.lastExternalSurface;
                C1463c c1463c = this.debugCompositor;
                String str2 = this.taskId;
                if (c1463c != null) {
                    str = "[";
                    z10 = true;
                } else {
                    str = "[";
                    z10 = false;
                }
                AbstractC1436a.d(FLOW_TAG, "[" + str2 + "] applyDebugOverlayState enter: enabled=" + enabled + " hasComp=" + z10 + " external=" + surface + " externalValid=" + (surface != null ? Boolean.valueOf(surface.isValid()) : null), true);
                if (enabled && c1463c == null) {
                    if (surface == null) {
                        AbstractC1436a.a(FLOW_TAG, "[" + this.taskId + "] OFF→ON skip: no external surface yet", true);
                    } else {
                        Pair<Integer, Integer> pairResolveOutputSize = resolveOutputSize();
                        int iIntValue = ((Number) pairResolveOutputSize.f4886a).intValue();
                        int iIntValue2 = ((Number) pairResolveOutputSize.b).intValue();
                        if (iIntValue <= 0 || iIntValue2 <= 0) {
                            AbstractC1436a.e(FLOW_TAG, "[" + this.taskId + "] OFF→ON: invalid size " + iIntValue + "x" + iIntValue2 + ", fallback direct", true);
                            try {
                                task.setOutputSurface(surface);
                            } catch (Throwable th) {
                                kotlin.b.a(th);
                            }
                        } else {
                            AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] OFF→ON: building compositor " + iIntValue + "x" + iIntValue2, true);
                            try {
                                C1463c c1463c2 = new C1463c(iIntValue, iIntValue2);
                                try {
                                    Surface surfaceA = c1463c2.a(surface);
                                    AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] OFF→ON: comp.attach done, intermediate=" + surfaceA + " intermediateValid=" + surfaceA.isValid(), true);
                                    task.setOutputSurface(surfaceA);
                                    this.debugCompositor = c1463c2;
                                    AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] OFF→ON: SDK switched to intermediate, debugCompositor set", true);
                                    pushDebugInfo();
                                } catch (Throwable th2) {
                                    AbstractC1436a.c(FLOW_TAG, "[" + this.taskId + "] OFF→ON: attach failed: " + th2.getMessage(), th2);
                                    c1463c2.c();
                                    try {
                                        task.setOutputSurface(surface);
                                    } catch (Throwable th3) {
                                        kotlin.b.a(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                AbstractC1436a.c(FLOW_TAG, "[" + this.taskId + "] OFF→ON: compositor ctor failed: " + th4.getMessage(), th4);
                                try {
                                    task.setOutputSurface(surface);
                                } catch (Throwable th5) {
                                    kotlin.b.a(th5);
                                }
                            }
                        }
                    }
                } else if (enabled || c1463c == null) {
                    AbstractC1436a.a(FLOW_TAG, "[" + this.taskId + "] applyDebugOverlayState(" + enabled + "): no-op (already in target state)", true);
                } else {
                    AbstractC1436a.d(FLOW_TAG, str + this.taskId + "] ON→OFF: begin, external=" + surface + " externalValid=" + (surface != null ? Boolean.valueOf(surface.isValid()) : null), true);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        c1463c.b();
                        objA = r.f317a;
                    } catch (Throwable th6) {
                        objA = kotlin.b.a(th6);
                    }
                    Throwable thA = Result.a(objA);
                    if (thA != null) {
                        AbstractC1436a.b(FLOW_TAG, "[" + this.taskId + "] ON→OFF: detachExternalSync failed: " + thA.getMessage(), true);
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] ON→OFF: compositor external EGL released (" + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms), now SDK takeover", true);
                    try {
                        task.setOutputSurface(surface);
                        objA2 = r.f317a;
                    } catch (Throwable th7) {
                        objA2 = kotlin.b.a(th7);
                    }
                    Throwable thA2 = Result.a(objA2);
                    if (thA2 != null) {
                        AbstractC1436a.b(FLOW_TAG, "[" + this.taskId + "] ON→OFF: SDK setOutputSurface(external) failed: " + thA2.getMessage(), true);
                    }
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] ON→OFF: SDK setOutputSurface returned (" + (jCurrentTimeMillis3 - jCurrentTimeMillis2) + "ms)", true);
                    this.debugCompositor = null;
                    InterfaceC1733z interfaceC1733z = this.scope;
                    if (interfaceC1733z != null) {
                        AbstractC1683A.n(interfaceC1733z, AbstractC1691I.f5315a, new ZyqlGuiAgentTask$applyDebugOverlayState$1$7(this, c1463c, null), 2);
                    } else {
                        AbstractC1436a.e(FLOW_TAG, "[" + this.taskId + "] ON→OFF: scope null, releasing compositor immediately (no delay)", true);
                        c1463c.c();
                    }
                    AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] ON→OFF: complete (release deferred)", true);
                }
            } catch (Throwable th8) {
                throw th8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildInfoPayload(UserInputRequest req) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("inputType", req.getInputType().name());
        jSONObject.put(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, this.taskName);
        List<String> options = req.getOptions();
        if (options != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = options.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject.put("options", jSONArray);
        }
        String placeholder = req.getPlaceholder();
        if (placeholder != null) {
            jSONObject.put("placeholder", placeholder);
        }
        jSONObject.put("timeoutMs", req.getTimeout());
        jSONObject.put("inFullScreen", SystemSdkBridge.INSTANCE.isFullScreenActivityBoundToTask(this.taskId));
        String string = jSONObject.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void cachePendingInfo(UserInputRequest req, String payloadJson) {
        try {
            PendingSuppressedInfo pendingSuppressedInfo = this.pendingSuppressedInfo;
            if (pendingSuppressedInfo != null) {
                AbstractC1436a.b(TAG, "[" + this.taskId + "] cachePendingInfo TRIPWIRE: overwriting existing pending (invariant violated, guiagent should serialize INQUIRY): old=" + pendingSuppressedInfo.getRequestId() + ", new=" + req.getRequestId(), true);
            }
            this.pendingSuppressedInfo = new PendingSuppressedInfo(req.getRequestId(), req.getInputType().name(), req.getMessage(), payloadJson, req.getTimeout());
            AbstractC1436a.d(TAG, "[" + this.taskId + "] cachePendingInfo: requestId=" + req.getRequestId(), true);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void cancel$default(ZyqlGuiAgentTask zyqlGuiAgentTask, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Task cancelled";
        }
        zyqlGuiAgentTask.cancel(str);
    }

    private final void cancelLlmTakeoverTimeoutTimer() {
        c0 c0Var = this.llmTakeoverTimeoutJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.llmTakeoverTimeoutJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTaskTimeoutTimer() {
        c0 c0Var = this.taskTimeoutJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.taskTimeoutJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void captureLlmTakeoverMessageIfNeeded(za.g r5) {
        /*
            r4 = this;
            stepai.aios.guiagent.config.ActionType r0 = r5.d
            stepai.aios.guiagent.config.ActionType r1 = stepai.aios.guiagent.config.ActionType.TAKEOVER
            if (r0 == r1) goto L7
            goto L48
        L7:
            r0 = 1
            r4.llmTakeoverPending = r0
            java.util.Map r1 = r5.n
            java.lang.String r2 = "model_param_message"
            java.lang.Object r1 = r1.get(r2)
            boolean r2 = r1 instanceof java.lang.String
            r3 = 0
            if (r2 == 0) goto L1a
            java.lang.String r1 = (java.lang.String) r1
            goto L1b
        L1a:
            r1 = r3
        L1b:
            if (r1 == 0) goto L2a
            boolean r2 = j9.m.s0(r1)
            if (r2 != 0) goto L24
            goto L25
        L24:
            r1 = r3
        L25:
            if (r1 != 0) goto L28
            goto L2a
        L28:
            r3 = r1
            goto L35
        L2a:
            java.lang.String r5 = r5.l
            if (r5 == 0) goto L35
            boolean r1 = j9.m.s0(r5)
            if (r1 != 0) goto L35
            r3 = r5
        L35:
            if (r3 == 0) goto L48
            r4.lastLlmTakeoverMessage = r3
            java.lang.String r4 = r4.taskId
            java.lang.String r5 = "["
            java.lang.String r1 = "] captured LLM takeover message: "
            java.lang.String r4 = B7.a.n(r5, r4, r1, r3)
            java.lang.String r5 = "ZyqlGuiAgentTask"
            f6.AbstractC1436a.d(r5, r4, r0)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.captureLlmTakeoverMessageIfNeeded(za.g):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void collectTaskEvents(InterfaceC1733z scope, Map<String, ? extends Object> meta) {
        AbstractC1683A.n(scope, null, new AnonymousClass1(new GsonBuilder().disableHtmlEscaping().create(), scope, meta, null), 3);
        AbstractC1683A.n(scope, null, new AnonymousClass2(null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void collectTaskEvents$default(ZyqlGuiAgentTask zyqlGuiAgentTask, InterfaceC1733z interfaceC1733z, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        zyqlGuiAgentTask.collectTaskEvents(interfaceC1733z, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchStepExplain(String explain) {
        SystemSdkBridge.INSTANCE.updateFullScreenTaskExplain$stepfun_release(this.taskId, explain);
        notifyProgressChanged$default(this, Actions.INSTANCE.getEXPLAIN(), null, null, explain, 6, null);
        getExecutor().setCurrentExplain(explain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ZyqlSystemGuiActionExecutor executor_delegate$lambda$0(ZyqlGuiAgentTask zyqlGuiAgentTask) {
        return new ZyqlSystemGuiActionExecutor(zyqlGuiAgentTask.context, new m(zyqlGuiAgentTask, 2), new ZyqlGuiAgentTask$executor$2$2(zyqlGuiAgentTask), zyqlGuiAgentTask.taskId);
    }

    public static /* synthetic */ String getTopApp$default(ZyqlGuiAgentTask zyqlGuiAgentTask, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = zyqlGuiAgentTask.getActionDisplayId();
        }
        return zyqlGuiAgentTask.getTopApp(i);
    }

    private final void handleForegroundAppChange(ForegroundAppInfo info) {
        Task task;
        if (this.runOnVirtualDisplay && (task = this.task) != null && task.getDisplayId() == info.getDisplayId()) {
            AbstractC1436a.d(TAG, B7.a.n("[", this.taskId, "] handleForegroundAppChange foregroundAppinfo  ", new Gson().toJson(info)), true);
            if (kotlin.jvm.internal.k.b(info.getPackageName(), this.targetPackageName)) {
                this.isTargetAppOpened = true;
                AbstractC1436a.d(TAG, "[" + this.taskId + "] handleForegroundAppChange isTargetAppOpened " + this.isTargetAppOpened, true);
            } else {
                String str = this.taskId;
                String packageName = info.getPackageName();
                boolean z10 = this.isTargetAppOpened;
                StringBuilder sbW = B7.a.w("[", str, "] handleForegroundAppChange info.packageName ", packageName, "  isTargetAppOpened ");
                sbW.append(z10);
                AbstractC1436a.d(TAG, sbW.toString(), true);
                if ("com.android.launcher3".equals(info.getPackageName()) && !this.isTargetAppOpened) {
                    return;
                }
            }
            String str2 = this.targetPackageName;
            if (str2 == null) {
                str2 = "";
            }
            int showingDisplayId = task.getShowingDisplayId(str2);
            StringBuilder sbW2 = B7.a.w("[", this.taskId, "]  handleForegroundAppChange targetPackageName ", this.targetPackageName, " displayId ");
            sbW2.append(showingDisplayId);
            AbstractC1436a.d(TAG, sbW2.toString(), true);
            if (showingDisplayId != task.getDisplayId()) {
                AbstractC1436a.a(TAG, "[" + this.taskId + "] handleForegroundAppChange Foreground app changed, notifying...The target application has been preempted by display: " + showingDisplayId, true);
                notifyProgressChanged$default(this, Actions.INSTANCE.getFOREGROUND_APP_CHANGE(), null, null, null, 14, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLlmRequestTakeover(String reason) throws JSONException, RemoteException {
        StringBuilder sbW = B7.a.w("[", this.taskId, "] LLM_REQUEST takeover triggered, taskSource=", this.taskSource, ", reason=");
        sbW.append(reason);
        AbstractC1436a.a(TAG, sbW.toString(), true);
        if (kotlin.jvm.internal.k.b(this.taskSource, "rollout")) {
            com.stepos.statsrpk.service.c.p("[", this.taskId, "] rollout + LLM_REQUEST → auto clearTask", TAG, true);
            SystemSdkBridge.clearTask$default(SystemSdkBridge.INSTANCE, this.taskId, false, "rollout场景下,自动终止任务", 2, null);
            return;
        }
        this.llmTakeoverRetryCount = 0;
        this.takeOverProgressNotifiedForCurrentManualCycle = false;
        this.llmTakeoverPending = true;
        SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
        boolean zIsFullScreenActivityBoundToTask = systemSdkBridge.isFullScreenActivityBoundToTask(this.taskId);
        JSONObject jSONObject = new JSONObject();
        if (reason == null) {
            reason = "";
        }
        jSONObject.put("content", reason);
        String str = this.chatSessionId;
        jSONObject.put("chatSessionId", str != null ? str : "");
        jSONObject.put(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, this.taskName);
        jSONObject.put("inFullScreen", zIsFullScreenActivityBoundToTask);
        String string = jSONObject.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        notifyProgressChanged$default(this, Actions.INSTANCE.getLLM_TAKE_OVER(), null, null, string, 6, null);
        if (zIsFullScreenActivityBoundToTask) {
            systemSdkBridge.onLlmRequestTakeover$stepfun_release(this.taskId);
            AbstractC1436a.a(TAG, "[" + this.taskId + "] LLM takeover: in fullscreen, prompt shown, awaiting user choice", true);
            return;
        }
        startLlmTakeoverTimeoutTimer();
        AbstractC1436a.a(TAG, "[" + this.taskId + "] LLM takeover: not in fullscreen, waiting for external takeover", true);
    }

    private final void handleTargetAppDied(AppDiedInfo info) {
        if (this.runOnVirtualDisplay) {
            String str = this.taskId;
            String packageName = info.getPackageName();
            int uid = info.getUid();
            boolean restarting = info.getRestarting();
            StringBuilder sbW = B7.a.w("[", str, "] Target app died: ", packageName, ", uid=");
            sbW.append(uid);
            sbW.append(", restarting=");
            sbW.append(restarting);
            AbstractC1436a.e(TAG, sbW.toString(), true);
            notifyProgressChanged$default(this, Actions.INSTANCE.getTARGET_APP_DIED(), null, null, info.getPackageName(), 6, null);
            InterfaceC1733z interfaceC1733z = this.scope;
            if (interfaceC1733z != null) {
                AbstractC1683A.n(interfaceC1733z, null, new C11681(null), 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installInfoListenerIfNeeded() {
        Object objA;
        try {
            if (Config.INSTANCE.getDebugInfoDialogEnabled()) {
                DebugInfoDialogListener listener = DebugInfoDialogListener.INSTANCE;
                this.installedListener = listener;
                stepai.aios.guiagent.runtime.a aVar = C2052a.c;
                if (aVar == null) {
                    throw new IllegalStateException("GuiAgentManager is not initialized");
                }
                kotlin.jvm.internal.k.f(listener, "listener");
                aVar.f.addUserInputListener(listener);
                AbstractC1436a.d(TAG, "[" + this.taskId + "] listener installed: DebugInfoDialogListener (debug=true, global)", true);
            } else {
                this.installedListener = this.infoListener;
                stepai.aios.guiagent.runtime.a aVar2 = C2052a.c;
                if (aVar2 == null) {
                    throw new IllegalStateException("GuiAgentManager is not initialized");
                }
                String sessionId = getSessionId();
                UserInputListener listener2 = this.infoListener;
                kotlin.jvm.internal.k.f(sessionId, "sessionId");
                kotlin.jvm.internal.k.f(listener2, "listener");
                aVar2.f.addUserInputListener(sessionId, listener2);
                AbstractC1436a.d(TAG, "[" + this.taskId + "] listener installed: infoListener (debug=false, sessionId=" + getSessionId() + ")", true);
            }
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c(TAG, B7.a.n("[", this.taskId, "] installInfoListener failed: ", thA.getMessage()), thA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installOutputSurface(Surface externalSurface, int taskType) {
        Object objA = null;
        AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] installOutputSurface(surface=" + externalSurface + ", valid=" + (externalSurface != null ? Boolean.valueOf(externalSurface.isValid()) : null) + ", taskType=" + taskType + ")", true);
        if (externalSurface == null || taskType == 0) {
            com.stepos.statsrpk.service.c.p("[", this.taskId, "] installOutputSurface: skip (null or normal/foreground)", FLOW_TAG, true);
            return;
        }
        synchronized (this.debugLock) {
            this.lastExternalSurface = externalSurface;
        }
        if (((Boolean) AbstractC1462b.f4485a.getValue()).booleanValue()) {
            applyDebugOverlayState(true);
            return;
        }
        try {
            Task task = this.task;
            if (task != null) {
                task.setOutputSurface(externalSurface);
                objA = r.f317a;
            }
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(FLOW_TAG, B7.a.n("[", this.taskId, "] installOutputSurface direct failed: ", thA.getMessage()), true);
        }
        com.stepos.statsrpk.service.c.p("[", this.taskId, "] installOutputSurface: SDK direct (debug off)", FLOW_TAG, true);
    }

    public static /* synthetic */ void notifyProgressChanged$default(ZyqlGuiAgentTask zyqlGuiAgentTask, String str, Bitmap bitmap, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            bitmap = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        zyqlGuiAgentTask.notifyProgressChanged(str, bitmap, str2, str3);
    }

    public static /* synthetic */ void notifyProgressChangedPair$default(ZyqlGuiAgentTask zyqlGuiAgentTask, String str, Bitmap bitmap, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            bitmap = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        zyqlGuiAgentTask.notifyProgressChangedPair(str, bitmap, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeDebugOverlayToggle() {
        InterfaceC1733z interfaceC1733z = this.scope;
        if (interfaceC1733z != null && this.debugToggleJob == null) {
            this.debugToggleJob = AbstractC1683A.n(interfaceC1733z, AbstractC1691I.f5315a, new C11691(null), 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.Result$Failure] */
    private final String patchInFullScreen(String payloadJson, boolean inFullScreen) {
        String strA;
        try {
            JSONObject jSONObject = new JSONObject(payloadJson);
            jSONObject.put("inFullScreen", inFullScreen);
            strA = jSONObject.toString();
        } catch (Throwable th) {
            strA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(strA);
        if (thA == null) {
            payloadJson = strA;
        } else {
            AbstractC1436a.e(TAG, B7.a.n("[", this.taskId, "] patchInFullScreen failed, using original: ", thA.getMessage()), true);
        }
        return payloadJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pushDebugInfo() {
        List<GuiActionRecord> actions;
        GuiActionRecord guiActionRecord;
        String strB;
        C1463c c1463c = this.debugCompositor;
        if (c1463c == null) {
            return;
        }
        String str = this.taskId;
        String str2 = this.taskName;
        String strName = this.state.name();
        GuiTaskRecord guiTaskRecord = getGuiTaskRecord();
        if (this.guiTaskRecord == null) {
            guiTaskRecord = null;
        }
        String modelId = guiTaskRecord != null ? guiTaskRecord.getModelId() : null;
        if (modelId == null) {
            modelId = "";
        }
        ZyqlSystemGuiActionExecutor executor = getExecutor();
        if (this.state == SessionState.f6031a) {
            executor = null;
        }
        String currentExplain = executor != null ? executor.getCurrentExplain() : null;
        if (currentExplain == null) {
            currentExplain = "";
        }
        GuiTaskRecord guiTaskRecord2 = getGuiTaskRecord();
        if (this.guiTaskRecord == null) {
            guiTaskRecord2 = null;
        }
        C1461a c1461a = new C1461a(str, str2, strName, modelId, currentExplain, (guiTaskRecord2 == null || (actions = guiTaskRecord2.getActions()) == null || (guiActionRecord = (GuiActionRecord) v.L0(actions)) == null || (strB = B7.a.B(guiActionRecord.getActionType(), " ", guiActionRecord.getActionResult())) == null) ? "" : strB);
        if (c1463c.b) {
            return;
        }
        C1490b c1490b = c1463c.f4486a;
        c1490b.getClass();
        if (c1490b.g) {
            Handler handler = c1490b.d;
            if (handler != null) {
                handler.post(new I4.l(18, c1490b, c1461a));
            } else {
                kotlin.jvm.internal.k.n("handler");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerAppDiedObserver$lambda$1(ZyqlGuiAgentTask zyqlGuiAgentTask, AppDiedInfo info) {
        kotlin.jvm.internal.k.f(info, "info");
        zyqlGuiAgentTask.handleTargetAppDied(info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerForegroundAppObserver$lambda$1(ZyqlGuiAgentTask zyqlGuiAgentTask, ForegroundAppInfo info) {
        kotlin.jvm.internal.k.f(info, "info");
        zyqlGuiAgentTask.handleForegroundAppChange(info);
    }

    public static /* synthetic */ void release$default(ZyqlGuiAgentTask zyqlGuiAgentTask, boolean z10, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        if ((i & 2) != 0) {
            str = "用户取消任务";
        }
        zyqlGuiAgentTask.release(z10, str);
    }

    private final Pair<Integer, Integer> resolveOutputSize() {
        Object objA;
        Task task;
        Display display;
        try {
            task = this.task;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        if (task == null || (display = task.getDisplay()) == null) {
            throw new IllegalStateException("task is null");
        }
        Display.Mode mode = display.getMode();
        objA = new Pair(Integer.valueOf(mode.getPhysicalWidth()), Integer.valueOf(mode.getPhysicalHeight()));
        if (Result.a(objA) != null) {
            DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
            objA = new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
        return (Pair) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void revokeOmniDisplayImeIfNeeded() {
        Object objA;
        Task task = this.task;
        if (task == null) {
            return;
        }
        try {
            if (task.getImeEnabled()) {
                task.setOmniDisplayImeEnabled(false);
                task.setOmniDisplayTakeover(false);
            }
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", this.taskId, "] revokeOmniDisplayImeIfNeeded failed: ", thA.getMessage()), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendDismissWakeBroadcast() {
        try {
            Intent intent = new Intent(ACTION_DISMISS_WAKE);
            intent.setPackage(PKG_AILAUNCHER);
            this.context.sendBroadcast(intent);
            AbstractC1436a.d(TAG, "[" + this.taskId + "] ai_wake: sent DISMISS_WAKE broadcast", true);
        } catch (Exception e) {
            AbstractC1436a.c(TAG, "[" + this.taskId + "] ai_wake: sendDismissWakeBroadcast failed", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void start$default(ZyqlGuiAgentTask zyqlGuiAgentTask, InterfaceC1733z interfaceC1733z, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            map = new HashMap();
        }
        zyqlGuiAgentTask.start(interfaceC1733z, str, map);
    }

    private final void startLlmTakeoverTimeoutTimer() {
        cancelLlmTakeoverTimeoutTimer();
        InterfaceC1733z interfaceC1733z = this.scope;
        this.llmTakeoverTimeoutJob = interfaceC1733z != null ? AbstractC1683A.n(interfaceC1733z, null, new C11731(null), 3) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTaskTimeoutTimer() {
        cancelTaskTimeoutTimer();
        InterfaceC1733z interfaceC1733z = this.scope;
        this.taskTimeoutJob = interfaceC1733z != null ? AbstractC1683A.n(interfaceC1733z, null, new C11741(null), 3) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object tryAutoRecoverFromLlmTakeover(H7.c<? super java.lang.Boolean> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11781
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$tryAutoRecoverFromLlmTakeover$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11781) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$tryAutoRecoverFromLlmTakeover$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$tryAutoRecoverFromLlmTakeover$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            java.lang.String r3 = "["
            java.lang.String r4 = "ZyqlGuiAgentTask"
            r5 = 1
            if (r2 == 0) goto L33
            if (r2 != r5) goto L2b
            kotlin.b.b(r9)
            goto L51
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.b.b(r9)
            int r9 = r8.llmTakeoverRetryCount
            int r9 = r9 + r5
            r8.llmTakeoverRetryCount = r9
            java.lang.String r2 = r8.taskId
            java.lang.String r6 = "] Auto recover attempt "
            java.lang.String r7 = "/2"
            java.lang.String r9 = androidx.constraintlayout.core.dsl.a.d(r9, r3, r2, r6, r7)
            f6.AbstractC1436a.d(r4, r9, r5)
            r0.label = r5
            java.lang.Object r9 = r8.recoverFromTakeover(r0)
            if (r9 != r1) goto L51
            return r1
        L51:
            za.d r9 = (za.d) r9
            if (r9 == 0) goto L66
            boolean r9 = r9.f7001a
            if (r9 == 0) goto L66
            java.lang.String r9 = r8.taskId
            java.lang.String r0 = "] Auto recover succeeded"
            com.stepos.statsrpk.service.c.p(r3, r9, r0, r4, r5)
            r9 = 0
            r8.llmTakeoverRetryCount = r9
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L66:
            java.lang.String r9 = r8.taskId
            java.lang.String r0 = "] Auto recover failed"
            B7.a.z(r3, r9, r0, r4, r5)
            int r9 = r8.llmTakeoverRetryCount
            r0 = 2
            if (r9 < r0) goto L81
            java.lang.String r9 = r8.taskId
            java.lang.String r0 = "] Max retries reached, stopping task"
            com.stepos.statsrpk.service.c.w(r3, r9, r0, r4, r5)
            java.lang.String r9 = "LLM takeover auto-recover failed after 2 attempts"
            r8.release(r5, r9)
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            return r8
        L81:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.tryAutoRecoverFromLlmTakeover(H7.c):java.lang.Object");
    }

    private final void uninstallInfoListenerIfNeeded() {
        Object objA;
        try {
            UserInputListener userInputListener = this.installedListener;
            if (userInputListener != null) {
                if (userInputListener == DebugInfoDialogListener.INSTANCE) {
                    stepai.aios.guiagent.runtime.a aVar = C2052a.c;
                    if (aVar == null) {
                        throw new IllegalStateException("GuiAgentManager is not initialized");
                    }
                    aVar.f.removeUserInputListener(userInputListener);
                } else {
                    stepai.aios.guiagent.runtime.a aVar2 = C2052a.c;
                    if (aVar2 == null) {
                        throw new IllegalStateException("GuiAgentManager is not initialized");
                    }
                    String sessionId = getSessionId();
                    kotlin.jvm.internal.k.f(sessionId, "sessionId");
                    aVar2.f.removeUserInputListener(sessionId, userInputListener);
                }
                AbstractC1436a.d(TAG, "[" + this.taskId + "] listener removed: " + userInputListener.getClass().getSimpleName(), true);
            }
            this.installedListener = null;
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c(TAG, B7.a.n("[", this.taskId, "] uninstallInfoListener failed: ", thA.getMessage()), thA);
        }
    }

    public static /* synthetic */ void unregisterAppDiedObserver$stepfun_release$default(ZyqlGuiAgentTask zyqlGuiAgentTask, Task task, int i, Object obj) {
        if ((i & 1) != 0) {
            task = null;
        }
        zyqlGuiAgentTask.unregisterAppDiedObserver$stepfun_release(task);
    }

    public static /* synthetic */ void unregisterForegroundAppObserver$stepfun_release$default(ZyqlGuiAgentTask zyqlGuiAgentTask, Task task, int i, Object obj) {
        if ((i & 1) != 0) {
            task = null;
        }
        zyqlGuiAgentTask.unregisterForegroundAppObserver$stepfun_release(task);
    }

    public static /* synthetic */ void upLoadLog$default(ZyqlGuiAgentTask zyqlGuiAgentTask, Map map, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = Actions.INSTANCE.getERROR();
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        zyqlGuiAgentTask.upLoadLog(map, str, str2);
    }

    public final void acknowledgeLlmTakeoverSupersededByFullscreen$stepfun_release() {
        cancelLlmTakeoverTimeoutTimer();
        this.llmTakeoverRetryCount = 0;
        if (this.state != SessionState.f || this.takeOverProgressNotifiedForCurrentManualCycle) {
            return;
        }
        notifyProgressChanged$default(this, Actions.INSTANCE.getTAKE_OVER(), null, null, "true", 6, null);
        this.takeOverProgressNotifiedForCurrentManualCycle = true;
    }

    public final void cancel(String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        cancelLlmTakeoverTimeoutTimer();
        if (this.guiTaskHandle == null) {
            B7.a.z("[", this.taskId, "] Cannot cancel: handler not initialized", TAG, true);
        } else {
            getGuiTaskHandle().a(reason);
            AbstractC1436a.d(TAG, B7.a.n("[", this.taskId, "] Task cancelled: reason=", reason), true);
        }
    }

    public final boolean checkExperinceUpdate() {
        return true;
    }

    public final synchronized void clearPendingInfo$stepfun_release(String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        PendingSuppressedInfo pendingSuppressedInfo = this.pendingSuppressedInfo;
        if (pendingSuppressedInfo == null) {
            return;
        }
        AbstractC1436a.d(TAG, "[" + this.taskId + "] clearPendingInfo: requestId=" + pendingSuppressedInfo.getRequestId() + ", reason=" + reason, true);
        this.pendingSuppressedInfo = null;
    }

    public final void dismissVoiceInput() {
        Task task = this.task;
        if (task == null) {
            B7.a.z("[", this.taskId, "] dismissVoiceInput skip: task is null", TAG, true);
            return;
        }
        try {
            task.setOmniDisplayImeEnabled(false);
            task.setOmniDisplayTakeover(false);
            AbstractC1436a.d(TAG, "[" + this.taskId + "] dismissVoiceInput: IME disabled", true);
        } catch (Throwable th) {
            AbstractC1436a.c(TAG, B7.a.n("[", this.taskId, "] dismissVoiceInput failed: ", th.getMessage()), th);
        }
    }

    public final void failTaskForNetworkLost() {
        if (this.guiTaskHandle == null) {
            B7.a.z("[", this.taskId, "] failTaskForNetworkLost: handler not initialized", TAG, true);
            return;
        }
        if (this.networkFailTriggered.compareAndSet(false, true)) {
            if (!this.state.a()) {
                this.pendingFailureMessage = "网络已断开，任务已失败";
                B7.a.z("[", this.taskId, "] Network lost, force-failing task", TAG, true);
                cancelLlmTakeoverTimeoutTimer();
                getGuiTaskHandle().a("网络已断开");
                return;
            }
            AbstractC1436a.a(TAG, "[" + this.taskId + "] failTaskForNetworkLost: already terminal (" + this.state + "), skip", true);
        }
    }

    public final synchronized void flushPendingInfoIfAny$stepfun_release() {
        PendingSuppressedInfo pendingSuppressedInfo = this.pendingSuppressedInfo;
        if (pendingSuppressedInfo == null) {
            return;
        }
        AbstractC1436a.d(TAG, "[" + this.taskId + "] flushPendingInfo: requestId=" + pendingSuppressedInfo.getRequestId(), true);
        String strPatchInFullScreen = patchInFullScreen(pendingSuppressedInfo.getPayloadJson(), true);
        notifyProgressChanged$default(this, Actions.INSTANCE.getINFO(), null, null, pendingSuppressedInfo.getMessage(), 6, null);
        notifyInfoRequested(pendingSuppressedInfo.getRequestId(), pendingSuppressedInfo.getInputType(), pendingSuppressedInfo.getMessage(), strPatchInFullScreen, pendingSuppressedInfo.getTimeoutMs());
        this.pendingSuppressedInfo = null;
    }

    public final ZyqlSystemGuiAbilityProvider getAbilityProvider() {
        return (ZyqlSystemGuiAbilityProvider) this.abilityProvider.getF4884a();
    }

    public final int getActionDisplayId() {
        if (!this.runOnVirtualDisplay) {
            return 0;
        }
        Task task = this.task;
        return task != null ? task.getDisplayId() : this.displayId;
    }

    public final ZyqlAppLauncher getAppLauncher() {
        return (ZyqlAppLauncher) this.appLauncher.getF4884a();
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final Context getContext() {
        return this.context;
    }

    /* renamed from: getDebugCompositor$stepfun_release, reason: from getter */
    public final C1463c getDebugCompositor() {
        return this.debugCompositor;
    }

    /* renamed from: getDebugLock$stepfun_release, reason: from getter */
    public final Object getDebugLock() {
        return this.debugLock;
    }

    public final int getDisplayId() {
        return this.displayId;
    }

    public final ZyqlSystemGuiActionExecutor getExecutor() {
        return (ZyqlSystemGuiActionExecutor) this.executor.getF4884a();
    }

    public final SearchExperienceResult getExperienceResult() {
        return this.experienceResult;
    }

    public final String getGuiModelName() {
        return this.guiModelName;
    }

    public final stepai.aios.guiagent.runtime.b getGuiTaskHandle() {
        stepai.aios.guiagent.runtime.b bVar = this.guiTaskHandle;
        if (bVar != null) {
            return bVar;
        }
        kotlin.jvm.internal.k.n("guiTaskHandle");
        throw null;
    }

    public final GuiTaskRecord getGuiTaskRecord() {
        GuiTaskRecord guiTaskRecord = this.guiTaskRecord;
        if (guiTaskRecord != null) {
            return guiTaskRecord;
        }
        kotlin.jvm.internal.k.n("guiTaskRecord");
        throw null;
    }

    /* renamed from: getLastExternalSurface$stepfun_release, reason: from getter */
    public final Surface getLastExternalSurface() {
        return this.lastExternalSurface;
    }

    public final String getLastLlmTakeoverMessage() {
        return this.lastLlmTakeoverMessage;
    }

    public final boolean getLlmTakeoverPending() {
        return this.llmTakeoverPending;
    }

    public final boolean getRunOnVirtualDisplay() {
        return this.runOnVirtualDisplay;
    }

    public final InterfaceC1733z getScope() {
        return this.scope;
    }

    public final String getSessionId() {
        String str = this.sessionId;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.k.n("sessionId");
        throw null;
    }

    public final za.f getSessionParam() {
        za.f fVar = this.sessionParam;
        if (fVar != null) {
            return fVar;
        }
        kotlin.jvm.internal.k.n("sessionParam");
        throw null;
    }

    public final SessionState getState() {
        return this.state;
    }

    public final String getSubSessionId() {
        return this.subSessionId;
    }

    public final String getTASK_ID() {
        return this.TASK_ID;
    }

    public final String getTargetPackageName() {
        return this.targetPackageName;
    }

    public final Task getTask() {
        return this.task;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final String getTopApp(int targetDisplayId) {
        Object objA;
        try {
            Task task = this.task;
            objA = task != null ? task.getTopApp(Integer.valueOf(targetDisplayId)) : null;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        String str = (String) (objA instanceof Result.Failure ? null : objA);
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(targetDisplayId, "[", this.taskId, "] getTopApp(", ") = ");
        sbT.append(str);
        AbstractC1436a.a(TAG, sbT.toString(), true);
        return str;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final synchronized boolean hasActiveProgressCallback$stepfun_release() {
        return !this.progressCallbacks.isEmpty();
    }

    public final boolean isHandleActive() {
        if (this.guiTaskHandle == null) {
            return false;
        }
        SessionState sessionState = (SessionState) getGuiTaskHandle().d.getValue();
        sessionState.getClass();
        return H4.o.N(SessionState.b, SessionState.c, SessionState.d, SessionState.e, SessionState.f).contains(sessionState);
    }

    /* renamed from: isTargetAppOpened, reason: from getter */
    public final boolean getIsTargetAppOpened() {
        return this.isTargetAppOpened;
    }

    public final synchronized void notifyExplainUpdated(ExplainSnapshot snapshot) {
        try {
            kotlin.jvm.internal.k.f(snapshot, "snapshot");
            if (this.progressCallbacks.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Integer, ITaskProgressCallback> entry : this.progressCallbacks.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                try {
                    entry.getValue().onExplainUpdated(this.taskId, snapshot);
                } catch (DeadObjectException e) {
                    AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyExplainUpdated dead pid=" + iIntValue + ": " + e.getMessage(), true);
                    arrayList.add(Integer.valueOf(iIntValue));
                } catch (Throwable th) {
                    AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyExplainUpdated ignored pid=" + iIntValue + ": " + th.getMessage(), true);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.progressCallbacks.remove(Integer.valueOf(((Number) it.next()).intValue()));
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void notifyInfoDismissed(String requestId, String reason) {
        try {
            kotlin.jvm.internal.k.f(requestId, "requestId");
            kotlin.jvm.internal.k.f(reason, "reason");
            AbstractC1436a.d(TAG, "[" + this.taskId + "] notifyInfoDismissed: requestId=" + requestId + ", reason=" + reason + ", chatSessionId=" + this.chatSessionId, true);
            if (this.progressCallbacks.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Integer, ITaskProgressCallback> entry : this.progressCallbacks.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                ITaskProgressCallback value = entry.getValue();
                try {
                    String str = this.taskId;
                    String str2 = this.chatSessionId;
                    if (str2 == null) {
                        str2 = "";
                    }
                    value.onInfoDismissed(str, requestId, reason, str2);
                } catch (DeadObjectException e) {
                    AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyInfoDismissed dead pid=" + iIntValue + ": " + e.getMessage(), true);
                    arrayList.add(Integer.valueOf(iIntValue));
                } catch (Throwable th) {
                    AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyInfoDismissed ignored pid=" + iIntValue + ": " + th.getMessage(), true);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.progressCallbacks.remove(Integer.valueOf(((Number) it.next()).intValue()));
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void notifyInfoRequested(String requestId, String inputType, String message, String payloadJson, long timeoutMs) {
        String requestId2 = requestId;
        String inputType2 = inputType;
        synchronized (this) {
            try {
                kotlin.jvm.internal.k.f(requestId2, "requestId");
                kotlin.jvm.internal.k.f(inputType2, "inputType");
                String message2 = message;
                kotlin.jvm.internal.k.f(message2, "message");
                String payloadJson2 = payloadJson;
                kotlin.jvm.internal.k.f(payloadJson2, "payloadJson");
                String str = this.taskId;
                String str2 = this.chatSessionId;
                StringBuilder sb = new StringBuilder("[");
                sb.append(str);
                sb.append("] notifyInfoRequested: requestId=");
                sb.append(requestId2);
                sb.append(", inputType=");
                sb.append(inputType2);
                sb.append(", timeoutMs=");
                long j5 = timeoutMs;
                sb.append(j5);
                sb.append(", chatSessionId=");
                sb.append(str2);
                AbstractC1436a.d(TAG, sb.toString(), true);
                if (this.progressCallbacks.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<Integer, ITaskProgressCallback> entry : this.progressCallbacks.entrySet()) {
                    int iIntValue = entry.getKey().intValue();
                    ITaskProgressCallback value = entry.getValue();
                    try {
                        String str3 = this.taskId;
                        String str4 = this.taskName;
                        String str5 = this.chatSessionId;
                        if (str5 == null) {
                            str5 = "";
                        }
                        value.onInfoRequested(str3, str4, requestId2, inputType2, message2, payloadJson2, j5, str5);
                    } catch (DeadObjectException e) {
                        AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyInfoRequested dead pid=" + iIntValue + ": " + e.getMessage(), true);
                        arrayList.add(Integer.valueOf(iIntValue));
                    } catch (Throwable th) {
                        AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyInfoRequested ignored pid=" + iIntValue + ": " + th.getMessage(), true);
                    }
                    requestId2 = requestId;
                    inputType2 = inputType;
                    message2 = message;
                    payloadJson2 = payloadJson;
                    j5 = timeoutMs;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.progressCallbacks.remove(Integer.valueOf(((Number) it.next()).intValue()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final synchronized void notifyPackageConflict(int conflictKind, String newTaskId, String newTaskName, String runningTaskId, String packageName, String hint) {
        try {
            kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
            kotlin.jvm.internal.k.f(newTaskName, "newTaskName");
            String runningTaskId2 = runningTaskId;
            kotlin.jvm.internal.k.f(runningTaskId2, "runningTaskId");
            String packageName2 = packageName;
            kotlin.jvm.internal.k.f(packageName2, "packageName");
            String hint2 = hint;
            kotlin.jvm.internal.k.f(hint2, "hint");
            if (this.progressCallbacks.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Integer, ITaskProgressCallback> entry : this.progressCallbacks.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                try {
                    try {
                        entry.getValue().onPackageConflict(conflictKind, newTaskId, newTaskName, runningTaskId2, packageName2, hint2);
                    } catch (Throwable th) {
                        AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyPackageConflict ignored pid=" + iIntValue + ": " + th.getMessage(), true);
                    }
                } catch (DeadObjectException e) {
                    AbstractC1436a.e(TAG, "[" + this.taskId + "] notifyPackageConflict dead pid=" + iIntValue + ": " + e.getMessage(), true);
                    arrayList.add(Integer.valueOf(iIntValue));
                }
                runningTaskId2 = runningTaskId;
                packageName2 = packageName;
                hint2 = hint;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.progressCallbacks.remove(Integer.valueOf(((Number) it.next()).intValue()));
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void notifyProgressChanged(String action, Bitmap bitmap, String bitmapId, String message) {
        kotlin.jvm.internal.k.f(action, "action");
        String str = this.taskId;
        boolean z10 = bitmap != null;
        AbstractC1436a.d(TAG, "[" + str + "] notifyProgressChanged: action=" + action + ", message=" + message + ", bitmap=" + z10 + ", callbacks=" + this.progressCallbacks.size(), true);
        SystemSdkBridge.INSTANCE.onTaskActionForNotification(this.taskId, this.taskName, action, message);
        if (this.progressCallbacks.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, ITaskProgressCallback> entry : this.progressCallbacks.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            ITaskProgressCallback value = entry.getValue();
            try {
                AbstractC1436a.a(TAG, "[" + this.taskId + "] dispatch onTaskAction pid=" + iIntValue + " action=" + action, true);
                value.onTaskAction(this.taskId, this.taskName, action, bitmapId, bitmap, message);
            } catch (DeadObjectException e) {
                AbstractC1436a.e(TAG, "[" + this.taskId + "] dead callback pid=" + iIntValue + ", removing: " + e.getMessage(), true);
                arrayList.add(Integer.valueOf(iIntValue));
            } catch (Exception e6) {
                AbstractC1436a.a(TAG, "[" + this.taskId + "] callback pid=" + iIntValue + " exception: " + e6.getMessage(), true);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.progressCallbacks.remove(Integer.valueOf(((Number) it.next()).intValue()));
        }
    }

    public final synchronized void notifyProgressChangedPair(String action, Bitmap bitmap, String bitmapId, String url) {
        kotlin.jvm.internal.k.f(action, "action");
        String str = this.taskId;
        boolean z10 = bitmap != null;
        int size = this.progressCallbacks.size();
        StringBuilder sb = new StringBuilder("[");
        sb.append(str);
        sb.append("] notifyProgressChangedPair: action=");
        sb.append(action);
        sb.append(", bitmap=");
        sb.append(z10);
        sb.append(", url=");
        String str2 = url;
        sb.append(str2);
        sb.append(", callbacks=");
        sb.append(size);
        AbstractC1436a.d(TAG, sb.toString(), true);
        if (this.progressCallbacks.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, ITaskProgressCallback> entry : this.progressCallbacks.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            ITaskProgressCallback value = entry.getValue();
            try {
                AbstractC1436a.a(TAG, "[" + this.taskId + "] dispatch onTaskActionPair pid=" + iIntValue + " action=" + action, true);
                value.onTaskActionPair(this.taskId, this.taskName, "", bitmapId, bitmap, str2);
            } catch (DeadObjectException e) {
                AbstractC1436a.e(TAG, "[" + this.taskId + "] dead callback pid=" + iIntValue + ", removing: " + e.getMessage(), true);
                arrayList.add(Integer.valueOf(iIntValue));
            } catch (Exception e6) {
                AbstractC1436a.a(TAG, "[" + this.taskId + "] callback pid=" + iIntValue + " exception: " + e6.getMessage(), true);
            }
            str2 = url;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.progressCallbacks.remove(Integer.valueOf(((Number) it.next()).intValue()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object pause(java.lang.String r14, H7.c<? super java.lang.Boolean> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11701
            if (r0 == 0) goto L13
            r0 = r15
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$pause$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11701) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$pause$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$pause$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "["
            java.lang.String r5 = "ZyqlGuiAgentTask"
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r14 = r0.L$0
            java.lang.String r14 = (java.lang.String) r14
            kotlin.b.b(r15)
            r6 = r13
            goto L94
        L30:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L38:
            kotlin.b.b(r15)
            stepai.aios.guiagent.runtime.b r15 = r13.guiTaskHandle
            if (r15 != 0) goto L59
            java.lang.String r14 = r13.taskId
            java.lang.String r15 = "] Cannot pause: handler not initialized"
            B7.a.z(r4, r14, r15, r5, r3)
            com.stepos.taskrobot.llmapi.stepfun.Actions r14 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r1 = r14.getPAUSE()
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "false"
            r0 = r13
            notifyProgressChanged$default(r0, r1, r2, r3, r4, r5, r6)
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            return r13
        L59:
            r6 = r13
            stepai.aios.guiagent.model.SessionState r13 = r6.state
            stepai.aios.guiagent.model.SessionState r15 = stepai.aios.guiagent.model.SessionState.f
            if (r13 != r15) goto L7a
            java.lang.String r13 = r6.taskId
            java.lang.String r14 = "] Cannot recover: currentState is takeover"
            B7.a.z(r4, r13, r14, r5, r3)
            com.stepos.taskrobot.llmapi.stepfun.Actions r13 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r1 = r13.getPAUSE()
            r5 = 6
            r0 = r6
            r6 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "false"
            notifyProgressChanged$default(r0, r1, r2, r3, r4, r5, r6)
            java.lang.Boolean r13 = java.lang.Boolean.FALSE
            return r13
        L7a:
            stepai.aios.guiagent.runtime.b r13 = r6.getGuiTaskHandle()
            r0.L$0 = r14
            r0.label = r3
            stepai.aios.guiagent.runtime.a r15 = r13.b
            java.lang.String r13 = r13.f6130a
            stepai.aios.guiagent.pipeline.b r15 = r15.g
            stepai.aios.guiagent.model.TakeoverReasonType r2 = stepai.aios.guiagent.model.TakeoverReasonType.f6034a
            r15.getClass()
            java.lang.Object r15 = stepai.aios.guiagent.pipeline.b.M(r15, r13, r14, r2, r0)
            if (r15 != r1) goto L94
            return r1
        L94:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r13 = r15.booleanValue()
            com.stepos.taskrobot.llmapi.stepfun.Actions r0 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r7 = r0.getPAUSE()
            if (r13 == 0) goto La6
            java.lang.String r0 = "true"
        La4:
            r10 = r0
            goto La9
        La6:
            java.lang.String r0 = "false"
            goto La4
        La9:
            r11 = 6
            r12 = 0
            r8 = 0
            r9 = 0
            notifyProgressChanged$default(r6, r7, r8, r9, r10, r11, r12)
            r0 = r6
            java.lang.String r0 = r0.taskId
            java.lang.String r1 = "] Task pause: reason="
            java.lang.String r2 = ", result="
            java.lang.StringBuilder r14 = B7.a.w(r4, r0, r1, r14, r2)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            f6.AbstractC1436a.d(r5, r13, r3)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.pause(java.lang.String, H7.c):java.lang.Object");
    }

    public final void pauseDebugToggleForHandover$stepfun_release() {
        c0 c0Var = this.debugToggleJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.debugToggleJob = null;
        com.stepos.statsrpk.service.c.p("[", this.taskId, "] pauseDebugToggleForHandover: job cancelled", FLOW_TAG, true);
    }

    public final synchronized ITaskProgressCallback peekProgressCallback$stepfun_release() {
        return (ITaskProgressCallback) v.B0(this.progressCallbacks.values());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object recoverFromTakeover(H7.c<? super za.d> r24) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.recoverFromTakeover(H7.c):java.lang.Object");
    }

    public final void registerAppDiedObserver$stepfun_release() {
        Task task = this.task;
        if (task == null) {
            B7.a.z("[", this.taskId, "] registerAppDiedObserver skip: task is null", TAG, true);
            return;
        }
        String str = this.targetPackageName;
        if (str == null) {
            return;
        }
        this.appDiedObserverId = task.registerAppDiedObserver(AppDiedFilter.INSTANCE.forPackages(str), new DisplayObserver.OnAppDiedListener() { // from class: com.stepos.taskrobot.llmapi.stepfun.l
            @Override // com.mdisdk.observer.DisplayObserver.OnAppDiedListener
            public final void onAppDied(AppDiedInfo appDiedInfo) {
                ZyqlGuiAgentTask.registerAppDiedObserver$lambda$1(this.f4038a, appDiedInfo);
            }
        });
        String str2 = this.taskId;
        com.stepos.statsrpk.service.c.r(B7.a.w("[", str2, "] AppDiedObserver registered for ", str, " id="), this.appDiedObserverId, TAG, true);
    }

    public final void registerForegroundAppObserver$stepfun_release() {
        Task task = this.task;
        if (task == null) {
            B7.a.z("[", this.taskId, "] registerForegroundAppObserver skip: task is null", TAG, true);
        } else {
            this.foregroundAppObserverId = task.registerForegroundAppObserver(ForegroundAppFilter.ACCEPT_ALL, new c(this, 2));
            AbstractC1436a.d(TAG, B7.a.n("[", this.taskId, "] ForegroundAppObserver registered id=", this.foregroundAppObserverId), true);
        }
    }

    public final synchronized void registerProgressCallback(int callerPid, ITaskProgressCallback progressCallback) {
        if (progressCallback == null) {
            AbstractC1436a.e(TAG, "[" + this.taskId + "] register null callback for pid=" + callerPid + ", ignored", true);
            return;
        }
        ITaskProgressCallback iTaskProgressCallbackPut = this.progressCallbacks.put(Integer.valueOf(callerPid), progressCallback);
        String str = this.taskId;
        boolean z10 = iTaskProgressCallbackPut != null;
        AbstractC1436a.d(TAG, "[" + str + "] callback registered pid=" + callerPid + ", replaced=" + z10 + ", total=" + this.progressCallbacks.size(), true);
    }

    public final void release(boolean ignoreActions, String reason) {
        Object objA;
        Object objA2;
        Object objA3;
        Object objA4;
        stepai.aios.guiagent.runtime.a aVar;
        Object objA5 = r.f317a;
        kotlin.jvm.internal.k.f(reason, "reason");
        com.stepos.statsrpk.service.c.p("[", this.taskId, "] Releasing resources", TAG, true);
        cancelLlmTakeoverTimeoutTimer();
        cancelTaskTimeoutTimer();
        try {
            if (this.sessionId != null && getSessionId().length() > 0) {
                stepai.aios.guiagent.runtime.a aVar2 = C2052a.c;
                if (aVar2 == null) {
                    throw new IllegalStateException("GuiAgentManager is not initialized");
                }
                String sessionId = getSessionId();
                kotlin.jvm.internal.k.f(sessionId, "sessionId");
                aVar2.f.cancelSessionInputs(sessionId, "task_released");
            }
            objA = objA5;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c(TAG, B7.a.n("[", this.taskId, "] cancelSessionInputs on release failed: ", thA.getMessage()), thA);
        }
        uninstallInfoListenerIfNeeded();
        try {
            if (this.guiTaskHandle != null) {
                getGuiTaskHandle().a(reason);
            }
            revokeOmniDisplayImeIfNeeded();
            Task task = this.task;
            if (task != null) {
                try {
                    setOutputSurface(null);
                } catch (Throwable th2) {
                    kotlin.b.a(th2);
                }
                Thread.sleep(50L);
                VirtualDisplayCgroupHelper.INSTANCE.reset(this.displayId);
                AbstractC1436a.d(TAG, "[" + this.taskId + "] vdcgroup reset display=" + this.displayId, true);
                SystemSdkBridgeKt.finishWithRedirectCleanup(task, ignoreActions);
            }
            releaseDebugCompositor$stepfun_release();
            objA2 = objA5;
        } catch (Throwable th3) {
            objA2 = kotlin.b.a(th3);
        }
        Throwable thA2 = Result.a(objA2);
        if (thA2 != null) {
            AbstractC1436a.b(TAG, B7.a.n("[", this.taskId, "] Error finishing task: ", thA2.getMessage()), true);
        }
        String str = this.targetPackageName;
        if (str != null) {
            SystemSdkBridge.INSTANCE.releasePackageFromTask(str, this.taskId);
        }
        try {
            SystemSdkBridge.INSTANCE.onTaskActionForNotification(this.taskId, this.taskName, Actions.INSTANCE.getCANCEL(), "released");
            objA3 = objA5;
        } catch (Throwable th4) {
            objA3 = kotlin.b.a(th4);
        }
        Throwable thA3 = Result.a(objA3);
        if (thA3 != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", this.taskId, "] release: notifier dismiss failed: ", thA3.getMessage()), true);
        }
        try {
            aVar = C2052a.c;
        } catch (Throwable th5) {
            objA4 = kotlin.b.a(th5);
        }
        if (aVar == null) {
            throw new IllegalStateException("GuiAgentManager is not initialized");
        }
        String treeId = this.taskId;
        kotlin.jvm.internal.k.f(treeId, "treeId");
        GuiTracerManager guiTracerManager = aVar.e;
        GuiTaskTreeTraceSnapshot taskTreeTrace = guiTracerManager != null ? guiTracerManager.getTaskTreeTrace(treeId) : null;
        if (taskTreeTrace != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            List<GuiTaskNodeTraceSnapshot> nodeTraces = taskTreeTrace.getNodeTraces();
            if (nodeTraces != null) {
                Iterator<T> it = nodeTraces.iterator();
                while (it.hasNext()) {
                    Iterator<T> it2 = ((GuiTaskNodeTraceSnapshot) it.next()).getSteps().iterator();
                    while (it2.hasNext()) {
                        String llmTraceId = ((GuiNodeStepTraceSnapshot) it2.next()).getLlmTraceId();
                        if (j9.m.s0(llmTraceId)) {
                            llmTraceId = null;
                        }
                        if (llmTraceId != null) {
                            linkedHashSet.add(llmTraceId);
                        }
                    }
                }
            }
            if (!linkedHashSet.isEmpty()) {
                GuiAgentTraceManager.INSTANCE.evictLlmTraceCache(linkedHashSet);
            }
        }
        objA4 = objA5;
        Throwable thA4 = Result.a(objA4);
        if (thA4 != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", this.taskId, "] release: evictLlmTraceCache fallback failed: ", thA4.getMessage()), true);
        }
        try {
            if (this.sessionId != null && getSessionId().length() > 0) {
                String currentModelId = this.guiModelName;
                if (currentModelId == null) {
                    currentModelId = ModelConfigs.instance.getCurrentModelId();
                    ModelConfigs.instance.resolveModelCellForTask(currentModelId).removeSession(getSessionId());
                    AbstractC1436a.d(TAG, "[" + this.taskId + "] release: modelCell.removeSession(" + getSessionId() + ")", true);
                } else {
                    if (j9.m.s0(currentModelId)) {
                        currentModelId = null;
                    }
                    if (currentModelId == null) {
                        currentModelId = ModelConfigs.instance.getCurrentModelId();
                    }
                    ModelConfigs.instance.resolveModelCellForTask(currentModelId).removeSession(getSessionId());
                    AbstractC1436a.d(TAG, "[" + this.taskId + "] release: modelCell.removeSession(" + getSessionId() + ")", true);
                }
            }
        } catch (Throwable th6) {
            objA5 = kotlin.b.a(th6);
        }
        Throwable thA5 = Result.a(objA5);
        if (thA5 != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", this.taskId, "] release: removeSession failed: ", thA5.getMessage()), true);
        }
        try {
            u9.d dVar = AbstractC1691I.f5315a;
            AbstractC1683A.n(AbstractC1683A.b(u9.c.f6743a), null, new ZyqlGuiAgentTask$release$12$1(this, null), 3);
        } catch (Throwable th7) {
            kotlin.b.a(th7);
        }
        com.stepos.statsrpk.service.c.p("[", this.taskId, "] Resources released", TAG, true);
    }

    public final void releaseDebugCompositor$stepfun_release() {
        String str = this.taskId;
        boolean z10 = this.debugCompositor != null;
        boolean z11 = this.debugToggleJob != null;
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("[", str, "] releaseDebugCompositor: hasComp=", " hasJob=", z10);
        sbL.append(z11);
        AbstractC1436a.d(FLOW_TAG, sbL.toString(), true);
        c0 c0Var = this.debugToggleJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.debugToggleJob = null;
        synchronized (this.debugLock) {
            try {
                C1463c c1463c = this.debugCompositor;
                if (c1463c != null) {
                    c1463c.c();
                }
                this.debugCompositor = null;
                this.lastExternalSurface = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object reopenTargetAppIfOnLauncher$stepfun_release(H7.c<? super java.lang.Boolean> r15) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.reopenTargetAppIfOnLauncher$stepfun_release(H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resume(H7.c<? super za.d> r12) {
        /*
            r11 = this;
            boolean r2 = r12 instanceof com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11721
            if (r2 == 0) goto L13
            r2 = r12
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$resume$1 r2 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11721) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L13
            int r3 = r3 - r4
            r2.label = r3
            goto L18
        L13:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$resume$1 r2 = new com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$resume$1
            r2.<init>(r12)
        L18:
            java.lang.Object r1 = r2.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r4 = r2.label
            r7 = 1
            java.lang.String r8 = "["
            java.lang.String r9 = "ZyqlGuiAgentTask"
            if (r4 == 0) goto L33
            if (r4 != r7) goto L2b
            kotlin.b.b(r1)
            goto L89
        L2b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L33:
            kotlin.b.b(r1)
            stepai.aios.guiagent.runtime.b r1 = r11.guiTaskHandle
            r10 = 0
            if (r1 != 0) goto L53
            java.lang.String r1 = r11.taskId
            java.lang.String r2 = "] Cannot recover: handler not initialized"
            B7.a.z(r8, r1, r2, r9, r7)
            com.stepos.taskrobot.llmapi.stepfun.Actions r1 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r1 = r1.getRECOVER_FROM_PAUSE()
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "false"
            r0 = r11
            notifyProgressChanged$default(r0, r1, r2, r3, r4, r5, r6)
            return r10
        L53:
            stepai.aios.guiagent.model.SessionState r1 = r11.state
            stepai.aios.guiagent.model.SessionState r4 = stepai.aios.guiagent.model.SessionState.f
            if (r1 == r4) goto L71
            java.lang.String r1 = r11.taskId
            java.lang.String r2 = "] Cannot recover: currentState not takeover"
            B7.a.z(r8, r1, r2, r9, r7)
            com.stepos.taskrobot.llmapi.stepfun.Actions r1 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r1 = r1.getRECOVER_FROM_PAUSE()
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "false"
            r0 = r11
            notifyProgressChanged$default(r0, r1, r2, r3, r4, r5, r6)
            return r10
        L71:
            java.lang.String r1 = r11.taskId
            java.lang.String r4 = "] Recovering from takeover"
            com.stepos.statsrpk.service.c.p(r8, r1, r4, r9, r7)
            stepai.aios.guiagent.runtime.b r1 = r11.getGuiTaskHandle()
            r2.label = r7
            stepai.aios.guiagent.runtime.a r4 = r1.b
            java.lang.String r1 = r1.f6130a
            java.lang.Object r1 = r4.m(r1, r2)
            if (r1 != r3) goto L89
            return r3
        L89:
            r10 = r1
            za.d r10 = (za.d) r10
            com.stepos.taskrobot.llmapi.stepfun.Actions r1 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r1 = r1.getRECOVER_FROM_PAUSE()
            boolean r2 = r10.f7001a
            if (r2 == 0) goto L9a
            java.lang.String r2 = "true"
        L98:
            r4 = r2
            goto L9d
        L9a:
            java.lang.String r2 = "false"
            goto L98
        L9d:
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            r0 = r11
            notifyProgressChanged$default(r0, r1, r2, r3, r4, r5, r6)
            java.lang.String r0 = r11.taskId
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r8)
            r1.append(r0)
            java.lang.String r0 = "] Recovered from pause "
            r1.append(r0)
            r1.append(r10)
            java.lang.String r0 = r1.toString()
            f6.AbstractC1436a.d(r9, r0, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.resume(H7.c):java.lang.Object");
    }

    public final void setChatSessionId(String str) {
        this.chatSessionId = str;
    }

    public final void setDebugCompositor$stepfun_release(C1463c c1463c) {
        this.debugCompositor = c1463c;
    }

    public final void setExperienceResult(SearchExperienceResult searchExperienceResult) {
        this.experienceResult = searchExperienceResult;
    }

    public final void setGuiTaskHandle(stepai.aios.guiagent.runtime.b bVar) {
        kotlin.jvm.internal.k.f(bVar, "<set-?>");
        this.guiTaskHandle = bVar;
    }

    public final void setLastExternalSurface$stepfun_release(Surface surface) {
        this.lastExternalSurface = surface;
    }

    public final void setOutputSurface(Surface surface) {
        Object objA;
        Task task = this.task;
        if (task == null) {
            AbstractC1436a.a(FLOW_TAG, "[" + this.taskId + "] setOutputSurface skip: task is null (handed over)", true);
            return;
        }
        try {
            task.detachMirrorView();
            synchronized (this.debugLock) {
                try {
                    Surface surface2 = this.lastExternalSurface;
                    this.lastExternalSurface = surface;
                    C1463c c1463c = this.debugCompositor;
                    AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] setOutputSurface(surface=" + surface + ", valid=" + (surface != null ? Boolean.valueOf(surface.isValid()) : null) + ") prev=" + surface2 + " hasComp=" + (c1463c != null), true);
                    if (c1463c != null) {
                        if (!c1463c.b) {
                            c1463c.f4486a.e(surface);
                        }
                        AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] setOutputSurface → routed to compositor", true);
                    } else {
                        task.setOutputSurface(surface);
                        AbstractC1436a.d(FLOW_TAG, "[" + this.taskId + "] setOutputSurface → SDK direct", true);
                    }
                } finally {
                }
            }
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(FLOW_TAG, B7.a.n("[", this.taskId, "] setOutputSurface failed: ", thA.getMessage()), true);
        }
    }

    public final void setRunOnVirtualDisplay(boolean z10) {
        this.runOnVirtualDisplay = z10;
    }

    public final void setSessionId(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        this.sessionId = str;
    }

    public final void setSessionParam(za.f fVar) {
        kotlin.jvm.internal.k.f(fVar, "<set-?>");
        this.sessionParam = fVar;
    }

    public final void setSubSessionId(String str) {
        this.subSessionId = str;
    }

    public final void setTargetPackageName(String str) {
        this.targetPackageName = str;
    }

    public final void setTask$stepfun_release(Task task) {
        this.task = task;
    }

    public final void setTraceId(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        this.traceId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void start(m9.InterfaceC1733z r36, java.lang.String r37, java.util.Map<java.lang.String, ? extends java.lang.Object> r38) {
        /*
            Method dump skipped, instructions count: 1020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.start(m9.z, java.lang.String, java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object switchToMainDisplay(android.content.Context r10, H7.c<? super C7.r> r11) {
        /*
            r9 = this;
            C7.r r10 = C7.r.f317a
            boolean r0 = r11 instanceof com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11751
            if (r0 == 0) goto L15
            r0 = r11
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToMainDisplay$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L15
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L15:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToMainDisplay$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToMainDisplay$1
            r0.<init>(r11)
        L1a:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r1 = r0.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r0.L$1
            com.mdisdk.Task r1 = (com.mdisdk.Task) r1
            java.lang.Object r0 = r0.L$0
            android.content.Context r0 = (android.content.Context) r0
            kotlin.b.b(r11)
            goto L95
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            kotlin.b.b(r11)
            com.mdisdk.Task r11 = r9.task
            java.lang.String r2 = "["
            java.lang.String r4 = "ZyqlGuiAgentTask"
            if (r11 != 0) goto L50
            java.lang.String r9 = r9.taskId
            java.lang.String r11 = "] switchToMainDisplay skip: task is null"
            B7.a.z(r2, r9, r11, r4, r3)
            return r10
        L50:
            int r5 = r11.getDisplayId()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            java.lang.String r11 = r11.getTopApp(r6)
            java.lang.String r6 = r9.taskId
            java.lang.String r7 = "] switchToMainDisplay: 把 displayId="
            java.lang.String r8 = " 的 "
            java.lang.StringBuilder r6 = androidx.appfunctions.metadata.a.t(r5, r2, r6, r7, r8)
            r6.append(r11)
            java.lang.String r7 = " 移动到主屏"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            f6.AbstractC1436a.a(r4, r6, r3)
            if (r11 == 0) goto La1
            int r6 = r11.length()
            if (r6 != 0) goto L7f
            goto La1
        L7f:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor r2 = r9.getExecutor()
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r11 = r2.moveAppToMain(r11, r5, r3, r0)
            if (r11 != r1) goto L95
            return r1
        L95:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La0
            r11 = 0
            r9.runOnVirtualDisplay = r11
        La0:
            return r10
        La1:
            java.lang.String r9 = r9.taskId
            java.lang.String r11 = "] switchToMainDisplay failed: topPackage is null or empty"
            B7.a.z(r2, r9, r11, r4, r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.switchToMainDisplay(android.content.Context, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object switchToVirtualDisplay(android.content.Context r10, H7.c<? super C7.r> r11) {
        /*
            r9 = this;
            C7.r r10 = C7.r.f317a
            boolean r0 = r11 instanceof com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11761
            if (r0 == 0) goto L15
            r0 = r11
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToVirtualDisplay$1 r0 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11761) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L15
            int r1 = r1 - r2
            r0.label = r1
            goto L1a
        L15:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToVirtualDisplay$1 r0 = new com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$switchToVirtualDisplay$1
            r0.<init>(r11)
        L1a:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r1 = r0.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r0.L$1
            com.mdisdk.Task r1 = (com.mdisdk.Task) r1
            java.lang.Object r0 = r0.L$0
            android.content.Context r0 = (android.content.Context) r0
            kotlin.b.b(r11)
            goto L91
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3d:
            kotlin.b.b(r11)
            com.mdisdk.Task r11 = r9.task
            java.lang.String r2 = "["
            java.lang.String r4 = "ZyqlGuiAgentTask"
            if (r11 != 0) goto L50
            java.lang.String r9 = r9.taskId
            java.lang.String r11 = "] switchToVirtualDisplay skip: task is null"
            B7.a.z(r2, r9, r11, r4, r3)
            return r10
        L50:
            int r5 = r11.getDisplayId()
            java.lang.Integer r6 = new java.lang.Integer
            r7 = 0
            r6.<init>(r7)
            java.lang.String r11 = r11.getTopApp(r6)
            java.lang.String r6 = r9.taskId
            java.lang.String r7 = "] switchToVirtualDisplay: 把主屏的 "
            java.lang.String r8 = " 切换到 displayId="
            java.lang.StringBuilder r6 = B7.a.w(r2, r6, r7, r11, r8)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            f6.AbstractC1436a.a(r4, r6, r3)
            if (r11 == 0) goto L9c
            int r6 = r11.length()
            if (r6 != 0) goto L7b
            goto L9c
        L7b:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiActionExecutor r2 = r9.getExecutor()
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r11 = r2.moveAppToVirtual(r11, r5, r3, r0)
            if (r11 != r1) goto L91
            return r1
        L91:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L9b
            r9.runOnVirtualDisplay = r3
        L9b:
            return r10
        L9c:
            java.lang.String r9 = r9.taskId
            java.lang.String r11 = "] switchToVirtualDisplay failed: topPackage is null or empty"
            B7.a.z(r2, r9, r11, r4, r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.switchToVirtualDisplay(android.content.Context, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object takeover(java.lang.String r15, H7.c<? super java.lang.Boolean> r16) {
        /*
            r14 = this;
            r2 = r16
            boolean r3 = r2 instanceof com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11771
            if (r3 == 0) goto L15
            r3 = r2
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$takeover$1 r3 = (com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.C11771) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L15
            int r4 = r4 - r5
            r3.label = r4
            goto L1a
        L15:
            com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$takeover$1 r3 = new com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$takeover$1
            r3.<init>(r2)
        L1a:
            java.lang.Object r2 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r5 = r3.label
            java.lang.String r7 = "["
            java.lang.String r8 = "ZyqlGuiAgentTask"
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L3b
            if (r5 != r9) goto L33
            java.lang.Object r1 = r3.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.b.b(r2)
            r11 = r1
            goto L92
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.b.b(r2)
            r14.cancelLlmTakeoverTimeoutTimer()
            r14.llmTakeoverRetryCount = r10
            stepai.aios.guiagent.runtime.b r2 = r14.guiTaskHandle
            if (r2 != 0) goto L53
            java.lang.String r1 = r14.taskId
            java.lang.String r2 = "] Cannot takeover: handler not initialized"
            B7.a.z(r7, r1, r2, r8, r9)
            r14.takeOverProgressNotifiedForCurrentManualCycle = r10
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        L53:
            stepai.aios.guiagent.model.SessionState r2 = r14.state
            stepai.aios.guiagent.model.SessionState r5 = stepai.aios.guiagent.model.SessionState.f
            if (r2 != r5) goto L77
            java.lang.String r1 = r14.taskId
            java.lang.String r2 = "] takeover: already MANUAL_TAKEOVER, treat as success"
            com.stepos.statsrpk.service.c.p(r7, r1, r2, r8, r9)
            com.stepos.taskrobot.llmapi.stepfun.Actions r1 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r1 = r1.getTAKE_OVER()
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "true"
            r0 = r14
            notifyProgressChanged$default(r0, r1, r2, r3, r4, r5, r6)
            r14.takeOverProgressNotifiedForCurrentManualCycle = r9
            r14.llmTakeoverPending = r10
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L77:
            stepai.aios.guiagent.runtime.b r2 = r14.getGuiTaskHandle()
            r3.L$0 = r15
            r3.label = r9
            stepai.aios.guiagent.runtime.a r5 = r2.b
            java.lang.String r2 = r2.f6130a
            stepai.aios.guiagent.pipeline.b r5 = r5.g
            stepai.aios.guiagent.model.TakeoverReasonType r6 = stepai.aios.guiagent.model.TakeoverReasonType.f6034a
            r5.getClass()
            java.lang.Object r2 = stepai.aios.guiagent.pipeline.b.M(r5, r2, r15, r6, r3)
            if (r2 != r4) goto L91
            return r4
        L91:
            r11 = r15
        L92:
            r12 = r2
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r13 = r12.booleanValue()
            if (r13 == 0) goto Lad
            com.stepos.taskrobot.llmapi.stepfun.Actions r1 = com.stepos.taskrobot.llmapi.stepfun.Actions.INSTANCE
            java.lang.String r1 = r1.getTAKE_OVER()
            r5 = 6
            r6 = 0
            r2 = 0
            r3 = 0
            java.lang.String r4 = "true"
            r0 = r14
            notifyProgressChanged$default(r0, r1, r2, r3, r4, r5, r6)
            r14.llmTakeoverPending = r10
        Lad:
            r14.takeOverProgressNotifiedForCurrentManualCycle = r13
            java.lang.String r0 = r14.taskId
            java.lang.String r1 = "] Task takeover: reason="
            java.lang.String r2 = ", result="
            java.lang.StringBuilder r0 = B7.a.w(r7, r0, r1, r11, r2)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            f6.AbstractC1436a.d(r8, r0, r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask.takeover(java.lang.String, H7.c):java.lang.Object");
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.taskName;
        SessionState sessionState = this.state;
        int i = this.displayId;
        boolean z10 = this.runOnVirtualDisplay;
        StringBuilder sbW = B7.a.w("ZyqlGuiAgentTask(taskId='", str, "', taskName='", str2, "', state=");
        sbW.append(sessionState);
        sbW.append(", displayId=");
        sbW.append(i);
        sbW.append(", runOnVirtualDisplay=");
        return B7.a.s(sbW, z10, ")");
    }

    public final void unregisterAppDiedObserver$stepfun_release(Task mdiTaskRef) {
        String str = this.appDiedObserverId;
        if (str == null) {
            return;
        }
        Object objA = null;
        this.appDiedObserverId = null;
        Task task = mdiTaskRef == null ? this.task : mdiTaskRef;
        if (task != null) {
            try {
                task.unregisterAppDiedObserver(str);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", this.taskId, "] unregisterAppDiedObserver failed: ", thA.getMessage()), true);
        }
        String str2 = this.taskId;
        boolean z10 = mdiTaskRef != null;
        StringBuilder sbW = B7.a.w("[", str2, "] AppDiedObserver unregistered id=", str, ", viaRef=");
        sbW.append(z10);
        AbstractC1436a.d(TAG, sbW.toString(), true);
    }

    public final void unregisterForegroundAppObserver$stepfun_release(Task mdiTaskRef) {
        String str = this.foregroundAppObserverId;
        if (str == null) {
            return;
        }
        Object objA = null;
        this.foregroundAppObserverId = null;
        Task task = mdiTaskRef == null ? this.task : mdiTaskRef;
        if (task != null) {
            try {
                task.unregisterForegroundAppObserver(str);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, B7.a.n("[", this.taskId, "] unregisterForegroundAppObserver failed: ", thA.getMessage()), true);
        }
        String str2 = this.taskId;
        boolean z10 = mdiTaskRef != null;
        StringBuilder sbW = B7.a.w("[", str2, "] ForegroundAppObserver unregistered id=", str, ", viaRef=");
        sbW.append(z10);
        AbstractC1436a.d(TAG, sbW.toString(), true);
    }

    public final synchronized void unregisterProgressCallback(int callerPid) {
        ITaskProgressCallback iTaskProgressCallbackRemove = this.progressCallbacks.remove(Integer.valueOf(callerPid));
        String str = this.taskId;
        boolean z10 = iTaskProgressCallbackRemove != null;
        AbstractC1436a.e(TAG, "[" + str + "] callback unregistered pid=" + callerPid + ", hit=" + z10 + ", total=" + this.progressCallbacks.size(), true);
    }

    public final void upLoadLog(Map<String, ? extends Object> meta, String action, String lastMessage) {
        kotlin.jvm.internal.k.f(action, "action");
        kotlin.jvm.internal.k.f(lastMessage, "lastMessage");
        AbstractC1436a.d("RobotTraceV2", "[TRACE-DBG] upLoadLog entered, action=" + action + ", scope=" + this.scope, true);
        InterfaceC1733z interfaceC1733z = this.scope;
        if (interfaceC1733z != null) {
            u9.d dVar = AbstractC1691I.f5315a;
            AbstractC1683A.n(interfaceC1733z, u9.c.f6743a, new C11791(meta, this, action, lastMessage, null), 2);
        }
    }

    public final void upLoadLogAgentCache(Map<String, ? extends Object> meta) {
        InterfaceC1733z interfaceC1733z = this.scope;
        if (interfaceC1733z != null) {
            u9.d dVar = AbstractC1691I.f5315a;
            AbstractC1683A.n(interfaceC1733z, u9.c.f6743a, new C11801(null), 2);
        }
    }

    private ZyqlGuiAgentTask(String str, String str2, Task task, int i, int i6, Context context, String str3, String str4, String str5) {
        this.taskId = str;
        this.taskName = str2;
        this.displayId = i;
        this.taskType = i6;
        this.context = context;
        this.guiModelName = str3;
        this.chatSessionId = str4;
        this.subSessionId = str5;
        this.TASK_ID = "task_id";
        this.task = task;
        this.state = SessionState.f6031a;
        this.progressCallbacks = new LinkedHashMap();
        this.traceId = "";
        this.debugLock = new Object();
        this.networkFailTriggered = new AtomicBoolean(false);
        this.executor = kotlin.a.a(new m(this, 3));
        this.abilityProvider = kotlin.a.a(new m(this, 4));
        this.appLauncher = kotlin.a.a(new m(this, 5));
        this.infoListener = new UserInputListener() { // from class: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$infoListener$1
            @Override // stepai.aios.guiexecutor.input.UserInputListener
            public void onUserInputCancelled(String sessionId, UserInputRequest inputRequest, String reason) {
                kotlin.jvm.internal.k.f(sessionId, "sessionId");
                kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
                kotlin.jvm.internal.k.f(reason, "reason");
                ZyqlGuiAgentTask.notifyProgressChanged$default(this.this$0, Actions.INSTANCE.getINFO_DISMISSED(), null, null, reason, 6, null);
                this.this$0.notifyInfoDismissed(inputRequest.getRequestId(), reason);
                this.this$0.clearPendingInfo$stepfun_release("onUserInputCancelled reason=".concat(reason));
            }

            @Override // stepai.aios.guiexecutor.input.UserInputListener
            public void onUserInputRequested(String sessionId, UserInputRequest inputRequest) throws JSONException {
                kotlin.jvm.internal.k.f(sessionId, "sessionId");
                kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
                String strBuildInfoPayload = this.this$0.buildInfoPayload(inputRequest);
                SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
                boolean zIsCallerVisibleForTask$stepfun_release = systemSdkBridge.isCallerVisibleForTask$stepfun_release(this.this$0.getTaskId());
                StringBuilder sbW = B7.a.w("[", this.this$0.getTaskId(), "] info routed: requestId=", inputRequest.getRequestId(), ", callerVisible=");
                sbW.append(zIsCallerVisibleForTask$stepfun_release);
                AbstractC1436a.d("ZyqlGuiAgentTask", sbW.toString(), true);
                if (zIsCallerVisibleForTask$stepfun_release) {
                    ZyqlGuiAgentTask.notifyProgressChanged$default(this.this$0, Actions.INSTANCE.getINFO(), null, null, inputRequest.getMessage(), 6, null);
                    this.this$0.notifyInfoRequested(inputRequest.getRequestId(), inputRequest.getInputType().name(), inputRequest.getMessage(), strBuildInfoPayload, inputRequest.getTimeout());
                } else {
                    this.this$0.cachePendingInfo(inputRequest, strBuildInfoPayload);
                    systemSdkBridge.showInfoNotification$stepfun_release(this.this$0.getTaskId(), this.this$0.getTaskName(), inputRequest.getMessage());
                }
            }

            @Override // stepai.aios.guiexecutor.input.UserInputListener
            public void onUserInputTimeout(String sessionId, UserInputRequest inputRequest) {
                kotlin.jvm.internal.k.f(sessionId, "sessionId");
                kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
                ZyqlGuiAgentTask.notifyProgressChanged$default(this.this$0, Actions.INSTANCE.getINFO_DISMISSED(), null, null, InjectExperienceResult.REASON_TIMEOUT, 6, null);
                this.this$0.notifyInfoDismissed(inputRequest.getRequestId(), InjectExperienceResult.REASON_TIMEOUT);
                this.this$0.clearPendingInfo$stepfun_release("onUserInputTimeout");
            }

            @Override // stepai.aios.guiexecutor.input.UserInputListener
            public void onUserInputValidationFailed(String sessionId, UserInputRequest inputRequest, String errorMessage) {
                kotlin.jvm.internal.k.f(sessionId, "sessionId");
                kotlin.jvm.internal.k.f(inputRequest, "inputRequest");
                kotlin.jvm.internal.k.f(errorMessage, "errorMessage");
                AbstractC1436a.e("ZyqlGuiAgentTask", B7.a.n("[", this.this$0.getTaskId(), "] UserInput validation failed: ", errorMessage), true);
            }
        };
    }

    public /* synthetic */ ZyqlGuiAgentTask(String str, String str2, Task task, int i, int i6, Context context, String str3, String str4, String str5, int i10, kotlin.jvm.internal.e eVar) {
        this(str, str2, task, i, i6, context, (i10 & 64) != 0 ? null : str3, (i10 & 128) != 0 ? null : str4, (i10 & 256) != 0 ? null : str5);
    }
}
