package com.stepos.agentframework.adapter;

import C7.r;
import F9.M;
import F9.P;
import J7.c;
import S7.n;
import V4.A;
import V4.B;
import V4.C;
import V4.D;
import V4.E;
import V4.G;
import V4.H;
import V4.I;
import V4.o;
import V4.p;
import V4.w;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.RequiresPermission;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient;
import com.stepos.agentframework.adapter.agentspace.AgentSpaceVoteRequest;
import com.stepos.agentframework.adapter.bff.AuthInfo;
import com.stepos.agentframework.adapter.bff.BffCoreAgentClient;
import com.stepos.agentframework.adapter.bff.BuildConfig;
import com.stepos.agentframework.adapter.coze.CozeCoreAgentClient;
import com.stepos.agentframework.adapter.dify.DifyCoreAgentClient;
import com.stepos.agentframework.adapter.error.AdapterErrorCode;
import com.stepos.agentframework.adapter.error.AdapterException;
import com.stepos.agentframework.adapter.model.UploadStatus;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.EventListener;
import com.stepos.agentframework.adapter.netcore.EventSourceState;
import com.stepos.agentframework.adapter.netcore.ICoreAgentClient;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.agentframework.adapter.netcore.Logger;
import com.stepos.agentframework.adapter.netcore.PushMessageListener;
import com.stepos.agentframework.adapter.netcore.TOSUploadHelper;
import com.stepos.agentframework.adapter.netcore.service.BffService;
import com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.net.HttpConfig;
import com.stepos.net.HttpManager;
import com.stepos.net.exception.ApiException;
import com.stepos.net.token.TokenProvider;
import com.stepos.statsrpk.d;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.zyql.common.utils.upload.UploadConfig;
import j9.m;
import j9.t;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import qa.L;
import w9.InterfaceC2108a;
import z2.l;

@Metadata(d1 = {"\u0000ú\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J \u00101\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020.H\u0086@¢\u0006\u0004\b1\u00102J<\u00107\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u0002032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u000e04H\u0086@¢\u0006\u0004\b7\u00108J \u0010;\u001a\u00020:2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u000209H\u0086@¢\u0006\u0004\b;\u0010<J \u0010>\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020=H\u0086@¢\u0006\u0004\b>\u0010?J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060@H\u0086@¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u00020\u000e¢\u0006\u0004\bC\u0010\u0003J\u0018\u0010E\u001a\u0002002\u0006\u0010/\u001a\u00020DH\u0086@¢\u0006\u0004\bE\u0010FJ \u0010H\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020GH\u0086@¢\u0006\u0004\bH\u0010IJ \u0010J\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020GH\u0086@¢\u0006\u0004\bJ\u0010IJ \u0010L\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020KH\u0086@¢\u0006\u0004\bL\u0010MJ \u0010O\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020NH\u0086@¢\u0006\u0004\bO\u0010PJ \u0010R\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020QH\u0086@¢\u0006\u0004\bR\u0010SJ \u0010U\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020TH\u0086@¢\u0006\u0004\bU\u0010VJ \u0010X\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020WH\u0086@¢\u0006\u0004\bX\u0010YJ \u0010[\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010/\u001a\u00020ZH\u0086@¢\u0006\u0004\b[\u0010\\J \u0010_\u001a\u00020^2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b_\u0010`J \u0010a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0006H\u0086@¢\u0006\u0004\ba\u0010`J \u0010b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bb\u0010`J(\u0010d\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bd\u0010eJ\u0018\u0010g\u001a\u00020f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\bg\u0010hJ\u001a\u0010i\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\bi\u0010hJ\"\u0010k\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010j\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bk\u0010`J(\u0010m\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010j\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bm\u0010eJ\"\u0010o\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010n\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bo\u0010`J(\u0010p\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010n\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0006H\u0086@¢\u0006\u0004\bp\u0010eJ\u0015\u0010q\u001a\u0002002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bq\u0010rJ\u0018\u0010t\u001a\u00020\u00062\u0006\u0010/\u001a\u00020sH\u0086@¢\u0006\u0004\bt\u0010uJ\u0018\u0010w\u001a\u00020\u00062\u0006\u0010/\u001a\u00020vH\u0086@¢\u0006\u0004\bw\u0010xJ\u0018\u0010z\u001a\u00020\u00062\u0006\u0010/\u001a\u00020yH\u0086@¢\u0006\u0004\bz\u0010{J\u0018\u0010}\u001a\u00020\u00062\u0006\u0010/\u001a\u00020|H\u0086@¢\u0006\u0004\b}\u0010~J\u001b\u0010\u0080\u0001\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u007fH\u0086@¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0083\u0001\u001a\u00020\u00062\u0007\u0010/\u001a\u00030\u0082\u0001H\u0086@¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001d\u0010\u0086\u0001\u001a\u0002002\t\b\u0002\u0010\u0085\u0001\u001a\u00020\bH\u0002¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u0088\u0001\u0010\u0003J\u0018\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060@H\u0082@¢\u0006\u0005\b\u0089\u0001\u0010BJK\u0010\u008e\u0001\u001a\u0002002\u0006\u0010\u0016\u001a\u00020\u00152\u0007\u0010\u008a\u0001\u001a\u00020\u00062%\u0010\u008d\u0001\u001a \b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\u000b\u0012\t\u0012\u0004\u0012\u0002000\u008c\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u008b\u0001H\u0082@¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0005\b\u0090\u0001\u0010%J\u001b\u0010\u0092\u0001\u001a\u00020\u000e2\u0007\u0010\u0091\u0001\u001a\u000200H\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\"\u0010\u0094\u0001\u001a\u0002002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\"\u0010\u0096\u0001\u001a\u0002002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0095\u0001J.\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0019\u0010\u0099\u0001\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0005\b\u0099\u0001\u0010#J\u0019\u0010\u009a\u0001\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0005\b\u009a\u0001\u0010#J\u0011\u0010\u009b\u0001\u001a\u00020\u000eH\u0002¢\u0006\u0005\b\u009b\u0001\u0010\u0003J\u0019\u0010\u009c\u0001\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0005\b\u009c\u0001\u0010#JL\u0010¢\u0001\u001a\u00020\u00062\u0007\u0010\u009d\u0001\u001a\u00020\u00062.\u0010¡\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030\u009e\u0001\u0012\u0013\u0012\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030 \u00010\u009f\u00010\u008c\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u008b\u0001H\u0082@¢\u0006\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010¤\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u0017\u0010¦\u0001\u001a\u00020\b8\u0002X\u0082T¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R5\u0010ª\u0001\u001a \u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110¨\u0001j\u000f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0011`©\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R%\u0010®\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u001e0\u00ad\u00010¬\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\"\u0010³\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0019\u0010µ\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010¸\u0001\u001a\u00030·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010»\u0001\u001a\u00030º\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u0019\u0010½\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¶\u0001R\u001f\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010À\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010§\u0001R\u001d\u0010Â\u0001\u001a\u00030Á\u00018\u0006¢\u0006\u0010\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001¨\u0006Æ\u0001"}, d2 = {"Lcom/stepos/agentframework/adapter/ApiManager;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "deviceId", "", "timeOut", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", "Lcom/zyql/common/utils/upload/UploadConfig;", "tosConfig", "LC7/r;", "init", "(Landroid/content/Context;Ljava/lang/String;JLcom/stepos/agentframework/adapter/netcore/ILogger;Lcom/zyql/common/utils/upload/UploadConfig;)V", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "client", "registerClient", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "LV4/l;", "chatInfo", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "eventListener", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "chat", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/netcore/EventSourceState;", "eventSourceState", "addEventSourceState", "(Lcom/stepos/agentframework/adapter/netcore/EventSourceState;)V", "cancelAllRequest", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;)V", "destroy", "(Landroid/content/Context;)V", "Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "authInfo", "updateAuth", "(Lcom/stepos/agentframework/adapter/bff/AuthInfo;)V", "Lcom/stepos/agentframework/adapter/netcore/PushMessageListener;", "callback", "setPushMessageCallback", "(Lcom/stepos/agentframework/adapter/netcore/PushMessageListener;)V", "LV4/q;", "request", "", "feedback", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/q;LH7/c;)Ljava/lang/Object;", "LV4/H;", "Lkotlin/Function1;", "Lcom/stepos/agentframework/adapter/model/UploadStatus;", "onStatusUpdate", "uploadFile", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/H;LS7/k;LH7/c;)Ljava/lang/Object;", "LV4/b;", "LV4/a;", "getAgentDetail", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/b;LH7/c;)Ljava/lang/Object;", "LV4/I;", "vote", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/I;LH7/c;)Ljava/lang/Object;", "", "fetchDislikeFeedbackOptions", "(LH7/c;)Ljava/lang/Object;", "warmupDislikeFeedbackOptions", "Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceVoteRequest;", "submitAgentSpaceVote", "(Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceVoteRequest;LH7/c;)Ljava/lang/Object;", "LV4/F;", "pauseTask", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/F;LH7/c;)Ljava/lang/Object;", "resumeTask", "LV4/C;", "deleteTask", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/C;LH7/c;)Ljava/lang/Object;", "LV4/E;", "renameTask", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/E;LH7/c;)Ljava/lang/Object;", "LV4/A;", "batchDeleteTasks", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/A;LH7/c;)Ljava/lang/Object;", "LV4/G;", "retryTask", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/G;LH7/c;)Ljava/lang/Object;", "LV4/B;", "cancelTask", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/B;LH7/c;)Ljava/lang/Object;", "LV4/D;", "interactTask", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/D;LH7/c;)Ljava/lang/Object;", "sessionKey", "LV4/z;", "syncHistorySession", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "deleteSession", "clearSession", "newTitle", "renameSession", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "LV4/x;", "syncConversations", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LH7/c;)Ljava/lang/Object;", "createSession", "fileType", "readCoreFile", "content", "writeCoreFile", SingleFileBundle.KEY_PATH, "readFile", "writeFile", "isNetworkAvailable", "(Landroid/content/Context;)Z", "LV4/n;", "createVM", "(LV4/n;LH7/c;)Ljava/lang/Object;", "LV4/o;", "deleteVM", "(LV4/o;LH7/c;)Ljava/lang/Object;", "LV4/p;", "doctorFixVM", "(LV4/p;LH7/c;)Ljava/lang/Object;", "LV4/t;", "reInstallVM", "(LV4/t;LH7/c;)Ljava/lang/Object;", "LV4/w;", "restartVM", "(LV4/w;LH7/c;)Ljava/lang/Object;", "LV4/r;", "queryVMStatus", "(LV4/r;LH7/c;)Ljava/lang/Object;", "nowMs", "isDislikeFeedbackCacheExpired", "(J)Z", "refreshDislikeFeedbackOptionsAsync", "refreshDislikeFeedbackOptionsFromNetwork", "op", "Lkotlin/Function2;", "LH7/c;", "block", "invokeTaskOp", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;LS7/n;LH7/c;)Ljava/lang/Object;", "startNetworkMonitor", "isAvailable", "onNetworkChanged", "(Z)V", "checkInitSilent", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;)Z", "checkNetworkSilent", "checkClientSilent", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;)Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "preCheck", "checkInit", "checkNetwork", "checkClient", "logName", "Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "Lqa/L;", "LF9/P;", "call", "executeVMApi", "(Ljava/lang/String;LS7/n;LH7/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "DISLIKE_FEEDBACK_OPTIONS_CACHE_TTL_MS", "J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "clientMap", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "eventSourceStates", "Ljava/util/Set;", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "contextRef", "Ljava/lang/ref/WeakReference;", "inited", "Z", "Lm9/z;", "sdkScope", "Lm9/z;", "Lw9/a;", "dislikeOptionsCacheMutex", "Lw9/a;", "dislikeOptionsRefreshing", "dislikeFeedbackOptionsCache", "Ljava/util/List;", "dislikeFeedbackOptionsCacheAtMs", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiManager {
    private static final long DISLIKE_FEEDBACK_OPTIONS_CACHE_TTL_MS = 21600000;
    private static final String TAG = "ApiManager";
    private static WeakReference<Context> contextRef;
    private static volatile List<String> dislikeFeedbackOptionsCache;
    private static volatile long dislikeFeedbackOptionsCacheAtMs;
    private static final InterfaceC2108a dislikeOptionsCacheMutex;
    private static volatile boolean dislikeOptionsRefreshing;
    private static final Gson gson;
    private static volatile boolean inited;
    private static ConnectivityManager.NetworkCallback networkCallback;
    private static final InterfaceC1733z sdkScope;
    public static final ApiManager INSTANCE = new ApiManager();
    private static final HashMap<ApiType, ICoreAgentClient> clientMap = new HashMap<>();
    private static final Set<WeakReference<EventSourceState>> eventSourceStates = new LinkedHashSet();

    @c(c = "com.stepos.agentframework.adapter.ApiManager$batchDeleteTasks$2", f = "ApiManager.kt", l = {554}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$batchDeleteTasks$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ A $request;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(A a3, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(ICoreAgentClient iCoreAgentClient, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(iCoreAgentClient, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ICoreAgentClient iCoreAgentClient = (ICoreAgentClient) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            this.L$0 = null;
            this.label = 1;
            Object objBatchDeleteTasks = iCoreAgentClient.batchDeleteTasks(null, this);
            return objBatchDeleteTasks == coroutineSingletons ? coroutineSingletons : objBatchDeleteTasks;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$cancelTask$2", f = "ApiManager.kt", l = {560}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$cancelTask$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10482 extends SuspendLambda implements n {
        final /* synthetic */ B $request;
        /* synthetic */ Object L$0;
        int label;

        public C10482(B b, H7.c<? super C10482> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10482 c10482 = new C10482(null, cVar);
            c10482.L$0 = obj;
            return c10482;
        }

        @Override // S7.n
        public final Object invoke(ICoreAgentClient iCoreAgentClient, H7.c<? super Boolean> cVar) {
            return ((C10482) create(iCoreAgentClient, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ICoreAgentClient iCoreAgentClient = (ICoreAgentClient) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            this.L$0 = null;
            this.label = 1;
            Object objCancelTask = iCoreAgentClient.cancelTask(null, this);
            return objCancelTask == coroutineSingletons ? coroutineSingletons : objCancelTask;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {209}, m = "chat", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$chat$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.chat(null, null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m = "clearSession", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$clearSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10491(H7.c<? super C10491> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.clearSession(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {626}, m = "createSession", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$createSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10501 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10501(H7.c<? super C10501> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.createSession(null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$createVM$2", f = "ApiManager.kt", l = {883}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "it", "Lqa/L;", "LF9/P;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/netcore/service/BffService;)Lqa/L;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$createVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10512 extends SuspendLambda implements n {
        final /* synthetic */ V4.n $request;
        /* synthetic */ Object L$0;
        int label;

        public C10512(V4.n nVar, H7.c<? super C10512> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10512 c10512 = new C10512(null, cVar);
            c10512.L$0 = obj;
            return c10512;
        }

        @Override // S7.n
        public final Object invoke(BffService bffService, H7.c<? super L<P>> cVar) {
            return ((C10512) create(bffService, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                throw null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {596}, m = "deleteSession", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$deleteSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10521(H7.c<? super C10521> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.deleteSession(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$deleteTask$2", f = "ApiManager.kt", l = {548}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$deleteTask$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10532 extends SuspendLambda implements n {
        final /* synthetic */ C $request;
        /* synthetic */ Object L$0;
        int label;

        public C10532(C c, H7.c<? super C10532> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10532 c10532 = new C10532(null, cVar);
            c10532.L$0 = obj;
            return c10532;
        }

        @Override // S7.n
        public final Object invoke(ICoreAgentClient iCoreAgentClient, H7.c<? super Boolean> cVar) {
            return ((C10532) create(iCoreAgentClient, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ICoreAgentClient iCoreAgentClient = (ICoreAgentClient) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            this.L$0 = null;
            this.label = 1;
            Object objDeleteTask = iCoreAgentClient.deleteTask(null, this);
            return objDeleteTask == coroutineSingletons ? coroutineSingletons : objDeleteTask;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$deleteVM$2", f = "ApiManager.kt", l = {887}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "it", "Lqa/L;", "LF9/P;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/netcore/service/BffService;)Lqa/L;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$deleteVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10542 extends SuspendLambda implements n {
        final /* synthetic */ o $request;
        /* synthetic */ Object L$0;
        int label;

        public C10542(o oVar, H7.c<? super C10542> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10542 c10542 = new C10542(null, cVar);
            c10542.L$0 = obj;
            return c10542;
        }

        @Override // S7.n
        public final Object invoke(BffService bffService, H7.c<? super L<P>> cVar) {
            return ((C10542) create(bffService, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                throw null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$doctorFixVM$2", f = "ApiManager.kt", l = {890}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "it", "Lqa/L;", "LF9/P;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/netcore/service/BffService;)Lqa/L;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$doctorFixVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10552 extends SuspendLambda implements n {
        final /* synthetic */ p $request;
        /* synthetic */ Object L$0;
        int label;

        public C10552(p pVar, H7.c<? super C10552> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10552 c10552 = new C10552(null, cVar);
            c10552.L$0 = obj;
            return c10552;
        }

        @Override // S7.n
        public final Object invoke(BffService bffService, H7.c<? super L<P>> cVar) {
            return ((C10552) create(bffService, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                throw null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {830}, m = "executeVMApi", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$executeVMApi$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10561(H7.c<? super C10561> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.executeVMApi(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$executeVMApi$2", f = "ApiManager.kt", l = {833}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "kotlin.jvm.PlatformType", "<anonymous>", "(Lm9/z;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$executeVMApi$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10572 extends SuspendLambda implements n {
        final /* synthetic */ n $call;
        final /* synthetic */ String $logName;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10572(n nVar, String str, H7.c<? super C10572> cVar) {
            super(2, cVar);
            this.$call = nVar;
            this.$logName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C10572(this.$call, this.$logName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            P p;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            String strG = null;
            try {
                if (i == 0) {
                    b.b(obj);
                    BffService bffService = (BffService) HttpManager.INSTANCE.create(BffService.class, "__default__");
                    n nVar = this.$call;
                    this.L$0 = null;
                    this.label = 1;
                    obj = nVar.invoke(bffService, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                L l = (L) obj;
                try {
                    M m = l.f5644a;
                    int i6 = m.d;
                    if (!m.c() ? (p = l.c) != null : (p = (P) l.b) != null) {
                        strG = p.g();
                    }
                    d.D(ApiManager.TAG, this.$logName + " raw: " + strG);
                    if (strG == null || m.s0(strG)) {
                        return ApiManager.INSTANCE.getGson().toJson(kotlin.collections.a.R(new Pair("code", new Integer(i6)), new Pair("errorMsg", "raw is empty"), new Pair(SettingsConfig.KEY_DATA, "{}")));
                    }
                    String string = m.R0(strG).toString();
                    return ((t.e0(string, "{", false) && t.W(string, "}", false)) || (t.e0(string, "[", false) && t.W(string, "]", false))) ? strG : ApiManager.INSTANCE.getGson().toJson(kotlin.collections.a.R(new Pair("code", new Integer(i6)), new Pair(SettingsConfig.KEY_DATA, strG)));
                } catch (Throwable th) {
                    d.v(ApiManager.TAG, this.$logName + " read body: " + th.getMessage(), th);
                    Gson gson = ApiManager.INSTANCE.getGson();
                    Pair pair = new Pair("code", new Integer(l.f5644a.d));
                    String message = th.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    return gson.toJson(kotlin.collections.a.R(pair, new Pair("errorMsg", message)));
                }
            } catch (Throwable th2) {
                d.v(ApiManager.TAG, this.$logName + ": " + th2.getMessage(), th2);
                Gson gson2 = ApiManager.INSTANCE.getGson();
                Pair pair2 = new Pair("code", new Integer(-1));
                String message2 = th2.getMessage();
                if (message2 == null) {
                    message2 = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                return gson2.toJson(kotlin.collections.a.R(pair2, new Pair("errorMsg", message2)));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super String> cVar) {
            return ((C10572) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {287}, m = "feedback", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$feedback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10581 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10581(H7.c<? super C10581> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.feedback(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {370}, m = "getAgentDetail", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10591(H7.c<? super C10591> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.getAgentDetail(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$interactTask$2", f = "ApiManager.kt", l = {563}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$interactTask$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10602 extends SuspendLambda implements n {
        final /* synthetic */ D $request;
        /* synthetic */ Object L$0;
        int label;

        public C10602(D d, H7.c<? super C10602> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10602 c10602 = new C10602(null, cVar);
            c10602.L$0 = obj;
            return c10602;
        }

        @Override // S7.n
        public final Object invoke(ICoreAgentClient iCoreAgentClient, H7.c<? super Boolean> cVar) {
            return ((C10602) create(iCoreAgentClient, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ICoreAgentClient iCoreAgentClient = (ICoreAgentClient) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            this.L$0 = null;
            this.label = 1;
            Object objInteractTask = iCoreAgentClient.interactTask(null, this);
            return objInteractTask == coroutineSingletons ? coroutineSingletons : objInteractTask;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {573}, m = "invokeTaskOp", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10611(H7.c<? super C10611> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.invokeTaskOp(null, null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {514}, m = "pauseTask", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$pauseTask$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10621 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10621(H7.c<? super C10621> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.pauseTask(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$queryVMStatus$2", f = "ApiManager.kt", l = {TypedValues.Custom.TYPE_FLOAT}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "it", "Lqa/L;", "LF9/P;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/netcore/service/BffService;)Lqa/L;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$queryVMStatus$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10632 extends SuspendLambda implements n {
        final /* synthetic */ V4.r $request;
        /* synthetic */ Object L$0;
        int label;

        public C10632(V4.r rVar, H7.c<? super C10632> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10632 c10632 = new C10632(null, cVar);
            c10632.L$0 = obj;
            return c10632;
        }

        @Override // S7.n
        public final Object invoke(BffService bffService, H7.c<? super L<P>> cVar) {
            return ((C10632) create(bffService, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                throw null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$reInstallVM$2", f = "ApiManager.kt", l = {894}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "it", "Lqa/L;", "LF9/P;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/netcore/service/BffService;)Lqa/L;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$reInstallVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10642 extends SuspendLambda implements n {
        final /* synthetic */ V4.t $request;
        /* synthetic */ Object L$0;
        int label;

        public C10642(V4.t tVar, H7.c<? super C10642> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10642 c10642 = new C10642(null, cVar);
            c10642.L$0 = obj;
            return c10642;
        }

        @Override // S7.n
        public final Object invoke(BffService bffService, H7.c<? super L<P>> cVar) {
            return ((C10642) create(bffService, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                throw null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {643}, m = "readCoreFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$readCoreFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10651(H7.c<? super C10651> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.readCoreFile(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {671}, m = "readFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$readFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10661(H7.c<? super C10661> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.readFile(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$refreshDislikeFeedbackOptionsAsync$1", f = "ApiManager.kt", l = {433}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$refreshDislikeFeedbackOptionsAsync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10671 extends SuspendLambda implements n {
        int label;

        public C10671(H7.c<? super C10671> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C10671(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    b.b(obj);
                    ApiManager apiManager = ApiManager.INSTANCE;
                    this.label = 1;
                    obj = apiManager.refreshDislikeFeedbackOptionsFromNetwork(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                ApiManager.dislikeOptionsRefreshing = false;
                return r.f317a;
            } catch (Throwable th) {
                ApiManager.dislikeOptionsRefreshing = false;
                throw th;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10671) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {912, 457}, m = "refreshDislikeFeedbackOptionsFromNetwork", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$refreshDislikeFeedbackOptionsFromNetwork$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10681 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10681(H7.c<? super C10681> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.refreshDislikeFeedbackOptionsFromNetwork(this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {TypedValues.MotionType.TYPE_DRAW_PATH}, m = "renameSession", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$renameSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10691(H7.c<? super C10691> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.renameSession(null, null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$renameTask$2", f = "ApiManager.kt", l = {551}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$renameTask$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10702 extends SuspendLambda implements n {
        final /* synthetic */ E $request;
        /* synthetic */ Object L$0;
        int label;

        public C10702(E e, H7.c<? super C10702> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10702 c10702 = new C10702(null, cVar);
            c10702.L$0 = obj;
            return c10702;
        }

        @Override // S7.n
        public final Object invoke(ICoreAgentClient iCoreAgentClient, H7.c<? super Boolean> cVar) {
            return ((C10702) create(iCoreAgentClient, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ICoreAgentClient iCoreAgentClient = (ICoreAgentClient) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            this.L$0 = null;
            this.label = 1;
            Object objRenameTask = iCoreAgentClient.renameTask(null, this);
            return objRenameTask == coroutineSingletons ? coroutineSingletons : objRenameTask;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$restartVM$2", f = "ApiManager.kt", l = {898}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/service/BffService;", "it", "Lqa/L;", "LF9/P;", "<anonymous>", "(Lcom/stepos/agentframework/adapter/netcore/service/BffService;)Lqa/L;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$restartVM$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10712 extends SuspendLambda implements n {
        final /* synthetic */ w $request;
        /* synthetic */ Object L$0;
        int label;

        public C10712(w wVar, H7.c<? super C10712> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10712 c10712 = new C10712(null, cVar);
            c10712.L$0 = obj;
            return c10712;
        }

        @Override // S7.n
        public final Object invoke(BffService bffService, H7.c<? super L<P>> cVar) {
            return ((C10712) create(bffService, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                throw null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return obj;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {537}, m = "resumeTask", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$resumeTask$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10721 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10721(H7.c<? super C10721> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.resumeTask(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$retryTask$2", f = "ApiManager.kt", l = {557}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$retryTask$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10732 extends SuspendLambda implements n {
        final /* synthetic */ G $request;
        /* synthetic */ Object L$0;
        int label;

        public C10732(G g, H7.c<? super C10732> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10732 c10732 = new C10732(null, cVar);
            c10732.L$0 = obj;
            return c10732;
        }

        @Override // S7.n
        public final Object invoke(ICoreAgentClient iCoreAgentClient, H7.c<? super Boolean> cVar) {
            return ((C10732) create(iCoreAgentClient, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ICoreAgentClient iCoreAgentClient = (ICoreAgentClient) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            this.L$0 = null;
            this.label = 1;
            Object objRetryTask = iCoreAgentClient.retryTask(null, this);
            return objRetryTask == coroutineSingletons ? coroutineSingletons : objRetryTask;
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$submitAgentSpaceVote$2", f = "ApiManager.kt", l = {494}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$submitAgentSpaceVote$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10752 extends SuspendLambda implements n {
        final /* synthetic */ AgentSpaceVoteRequest $request;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10752(AgentSpaceVoteRequest agentSpaceVoteRequest, H7.c<? super C10752> cVar) {
            super(2, cVar);
            this.$request = agentSpaceVoteRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C10752(this.$request, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    b.b(obj);
                    if (!ApiManager.inited) {
                        d.O(ApiManager.TAG, "submitAgentSpaceVote: not init");
                        return Boolean.FALSE;
                    }
                    WeakReference weakReference = ApiManager.contextRef;
                    Context context = weakReference != null ? (Context) weakReference.get() : null;
                    if (context != null && !ApiManager.INSTANCE.isNetworkAvailable(context)) {
                        d.O(ApiManager.TAG, "submitAgentSpaceVote: no network");
                        return Boolean.FALSE;
                    }
                    Object obj2 = ApiManager.clientMap.get(ApiType.AGENT_SPACE);
                    AgentSpaceCoreAgentClient agentSpaceCoreAgentClient = obj2 instanceof AgentSpaceCoreAgentClient ? (AgentSpaceCoreAgentClient) obj2 : null;
                    if (agentSpaceCoreAgentClient == null) {
                        d.O(ApiManager.TAG, "submitAgentSpaceVote: AGENT_SPACE client missing");
                        return Boolean.FALSE;
                    }
                    AgentSpaceVoteRequest agentSpaceVoteRequest = this.$request;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 1;
                    obj = agentSpaceCoreAgentClient.submitVote(agentSpaceVoteRequest, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                zBooleanValue = ((Boolean) obj).booleanValue();
            } catch (Throwable th) {
                d.v(ApiManager.TAG, "submitAgentSpaceVote: " + th.getMessage(), th);
                zBooleanValue = false;
            }
            return Boolean.valueOf(zBooleanValue);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C10752) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {615}, m = "syncConversations", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$syncConversations$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10761(H7.c<? super C10761> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.syncConversations(null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {586}, m = "syncHistorySession", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10771(H7.c<? super C10771> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.syncHistorySession(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {326}, m = "uploadFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C10781(H7.c<? super C10781> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.uploadFile(null, null, null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager$vote$2", f = "ApiManager.kt", l = {387}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$vote$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10792 extends SuspendLambda implements n {
        final /* synthetic */ I $request;
        final /* synthetic */ ApiType $type;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10792(ApiType apiType, I i, H7.c<? super C10792> cVar) {
            super(2, cVar);
            this.$type = apiType;
            this.$request = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C10792(this.$type, this.$request, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AdapterException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            boolean z10 = false;
            try {
                if (i == 0) {
                    b.b(obj);
                    ApiManager.INSTANCE.preCheck(this.$type);
                    ICoreAgentClient iCoreAgentClient = (ICoreAgentClient) ApiManager.clientMap.get(this.$type);
                    if (iCoreAgentClient != null) {
                        I i6 = this.$request;
                        this.L$0 = null;
                        this.I$0 = 0;
                        this.label = 1;
                        obj = iCoreAgentClient.vote(i6, this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Boolean.valueOf(z10);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                if (((Boolean) obj).booleanValue()) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            } catch (Throwable th) {
                AdapterErrorCode.AgentInternalError agentInternalError = new AdapterErrorCode.AgentInternalError(th.getMessage());
                d.v(ApiManager.TAG, "Vote failed. Err:" + agentInternalError.message, th);
                throw new AdapterException(agentInternalError, th);
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C10792) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {657}, m = "writeCoreFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10801 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10801(H7.c<? super C10801> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.writeCoreFile(null, null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.ApiManager", f = "ApiManager.kt", l = {685}, m = "writeFile", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.ApiManager$writeFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C10811(H7.c<? super C10811> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApiManager.this.writeFile(null, null, null, this);
        }
    }

    static {
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        sdkScope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        dislikeOptionsCacheMutex = new kotlinx.coroutines.sync.a();
        dislikeFeedbackOptionsCache = EmptyList.f4893a;
        gson = new Gson();
    }

    private ApiManager() {
    }

    private final void checkClient(ApiType type) throws AdapterException {
        if (clientMap.get(type) != null) {
            return;
        }
        d.u(TAG, "No client found for type: " + type);
        throw new AdapterException(new AdapterErrorCode.ClientNotFound(type.name()), null);
    }

    private final ICoreAgentClient checkClientSilent(ApiType type, V4.l chatInfo, EventListener eventListener) {
        ICoreAgentClient iCoreAgentClient = clientMap.get(type);
        if (iCoreAgentClient != null) {
            return iCoreAgentClient;
        }
        d.u(TAG, "No client found for type: " + type);
        AdapterErrorCode.ClientNotFound clientNotFound = new AdapterErrorCode.ClientNotFound(type.name());
        if (eventListener != null) {
            eventListener.onFailure(chatInfo, Integer.valueOf(clientNotFound.code), clientNotFound.message);
        }
        return null;
    }

    private final void checkInit(ApiType type) throws AdapterException {
        if (inited) {
            return;
        }
        d.D(TAG, "Not init. Need call init first.");
        throw new AdapterException(AdapterErrorCode.NotInit.INSTANCE, null);
    }

    private final boolean checkInitSilent(V4.l chatInfo, EventListener eventListener) {
        if (inited) {
            return true;
        }
        d.D(TAG, "not init. Need call init first.");
        AdapterErrorCode.NotInit notInit = AdapterErrorCode.NotInit.INSTANCE;
        eventListener.onFailure(chatInfo, Integer.valueOf(notInit.code), notInit.message);
        return false;
    }

    private final void checkNetwork() throws AdapterException {
        WeakReference<Context> weakReference = contextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context == null || isNetworkAvailable(context)) {
            return;
        }
        d.u(TAG, "No Internet Connection.");
        throw new AdapterException(AdapterErrorCode.NoNetwork.INSTANCE, null);
    }

    private final boolean checkNetworkSilent(V4.l chatInfo, EventListener eventListener) {
        WeakReference<Context> weakReference = contextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context == null || isNetworkAvailable(context)) {
            return true;
        }
        d.u(TAG, "No Internet Connection.");
        AdapterErrorCode.NoNetwork noNetwork = AdapterErrorCode.NoNetwork.INSTANCE;
        eventListener.onFailure(chatInfo, Integer.valueOf(noNetwork.code), noNetwork.message);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeVMApi(java.lang.String r5, S7.n r6, H7.c<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.adapter.ApiManager.C10561
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.adapter.ApiManager$executeVMApi$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$executeVMApi$1 r0 = new com.stepos.agentframework.adapter.ApiManager$executeVMApi$1
            r0.<init>(r7)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r5 = r0.L$1
            S7.n r5 = (S7.n) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r4)
            goto L51
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.b.b(r4)
            u9.d r4 = m9.AbstractC1691I.f5315a
            u9.c r4 = u9.c.f6743a
            com.stepos.agentframework.adapter.ApiManager$executeVMApi$2 r1 = new com.stepos.agentframework.adapter.ApiManager$executeVMApi$2
            r3 = 0
            r1.<init>(r6, r5, r3)
            r0.L$0 = r3
            r0.L$1 = r3
            r0.label = r2
            java.lang.Object r4 = m9.AbstractC1683A.w(r4, r1, r0)
            if (r4 != r7) goto L51
            return r7
        L51:
            java.lang.String r5 = "withContext(...)"
            kotlin.jvm.internal.k.e(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.executeVMApi(java.lang.String, S7.n, H7.c):java.lang.Object");
    }

    public static /* synthetic */ void init$default(ApiManager apiManager, Context context, String str, long j5, ILogger iLogger, UploadConfig uploadConfig, int i, Object obj) {
        if ((i & 4) != 0) {
            j5 = 30;
        }
        long j6 = j5;
        if ((i & 8) != 0) {
            iLogger = Logger.INSTANCE;
        }
        ILogger iLogger2 = iLogger;
        if ((i & 16) != 0) {
            uploadConfig = null;
        }
        apiManager.init(context, str, j6, iLogger2, uploadConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r init$lambda$0$0(Context context, HttpConfig.Builder init) {
        k.f(init, "$this$init");
        init.setDebug(BuildConfig.DEBUG);
        init.setDefaultBaseUrl(M.a.X(context).j());
        init.addBaseUrl("bff_base_url_key", init.getDefaultBaseUrl());
        init.setTokenProvider(new TokenProvider() { // from class: com.stepos.agentframework.adapter.ApiManager$init$1$1$1
            private volatile String cachedToken = "";

            @Override // com.stepos.net.token.TokenProvider
            /* renamed from: getToken, reason: from getter */
            public String getCachedToken() {
                return this.cachedToken;
            }

            @Override // com.stepos.net.token.TokenProvider
            public /* bridge */ String headerName() {
                return super.headerName();
            }

            @Override // com.stepos.net.token.TokenProvider
            public String refreshToken() {
                return this.cachedToken;
            }

            @Override // com.stepos.net.token.TokenProvider
            public /* bridge */ String tokenPrefix() {
                return super.tokenPrefix();
            }
        });
        init.setGlobalErrorListener(new androidx.compose.ui.text.d(17));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r init$lambda$0$0$0(ApiException ex) {
        k.f(ex, "ex");
        d.v(TAG, "Network error: ", ex);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeTaskOp(com.stepos.agentframework.adapter.netcore.ApiType r5, java.lang.String r6, S7.n r7, H7.c<? super java.lang.Boolean> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10611
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1 r0 = new com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r4 = r0.L$3
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            java.lang.Object r4 = r0.L$2
            S7.n r4 = (S7.n) r4
            java.lang.Object r4 = r0.L$1
            r6 = r4
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r4 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r4 = (com.stepos.agentframework.adapter.netcore.ApiType) r4
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L38
            goto L67
        L38:
            r4 = move-exception
            goto L6e
        L3a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L42:
            kotlin.b.b(r8)
            r4.preCheck(r5)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r4 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r4 = r4.get(r5)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            if (r4 != 0) goto L55
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L55:
            r5 = 0
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L38
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L38
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L38
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L38
            r0.label = r3     // Catch: java.lang.Throwable -> L38
            java.lang.Object r8 = r7.invoke(r4, r0)     // Catch: java.lang.Throwable -> L38
            if (r8 != r1) goto L67
            return r1
        L67:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L38
            boolean r4 = r8.booleanValue()     // Catch: java.lang.Throwable -> L38
            goto L8c
        L6e:
            java.lang.String r5 = r4.getMessage()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = " failed. Err:"
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.String r6 = "ApiManager"
            com.stepos.statsrpk.d.v(r6, r5, r4)
            r4 = 0
        L8c:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.invokeTaskOp(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, S7.n, H7.c):java.lang.Object");
    }

    private final boolean isDislikeFeedbackCacheExpired(long nowMs) {
        long j5 = dislikeFeedbackOptionsCacheAtMs;
        return j5 <= 0 || nowMs - j5 >= DISLIKE_FEEDBACK_OPTIONS_CACHE_TTL_MS;
    }

    public static /* synthetic */ boolean isDislikeFeedbackCacheExpired$default(ApiManager apiManager, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = System.currentTimeMillis();
        }
        return apiManager.isDislikeFeedbackCacheExpired(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNetworkChanged(boolean isAvailable) {
        Collection<ICoreAgentClient> collectionValues = clientMap.values();
        k.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((ICoreAgentClient) it.next()).onNetworkChanged(isAvailable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preCheck(ApiType type) throws AdapterException {
        checkInit(type);
        checkNetwork();
        checkClient(type);
    }

    private final void refreshDislikeFeedbackOptionsAsync() {
        if (dislikeOptionsRefreshing) {
            return;
        }
        dislikeOptionsRefreshing = true;
        AbstractC1683A.n(sdkScope, null, new C10671(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(10:12|64|13|47|(1:49)|50|(1:52)|53|56|57)(2:17|18))(1:19))(3:20|(1:23)|45)|61|24|(1:26)(3:29|(1:31)(1:32)|(3:37|(1:39)(1:40)|(1:42)(3:43|(6:46|47|(0)|50|(0)|53)|45))(1:36))|56|57|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        r11 = r10;
        r10 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2 A[Catch: all -> 0x003d, TryCatch #2 {all -> 0x003d, blocks: (B:13:0x0038, B:47:0x00c7, B:49:0x00d2, B:50:0x00da, B:52:0x00e4), top: B:64:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e4 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #2 {all -> 0x003d, blocks: (B:13:0x0038, B:47:0x00c7, B:49:0x00d2, B:50:0x00da, B:52:0x00e4), top: B:64:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshDislikeFeedbackOptionsFromNetwork(H7.c<? super java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.refreshDislikeFeedbackOptionsFromNetwork(H7.c):java.lang.Object");
    }

    public static /* synthetic */ void registerClient$default(ApiManager apiManager, Context context, ICoreAgentClient iCoreAgentClient, ILogger iLogger, int i, Object obj) {
        if ((i & 4) != 0) {
            iLogger = Logger.INSTANCE;
        }
        apiManager.registerClient(context, iCoreAgentClient, iLogger);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    private final void startNetworkMonitor(Context context) {
        Object systemService = context.getSystemService("connectivity");
        k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.stepos.agentframework.adapter.ApiManager.startNetworkMonitor.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                k.f(network, "network");
                d.D(ApiManager.TAG, "Network Available");
                ApiManager.INSTANCE.onNetworkChanged(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                k.f(network, "network");
                d.D(ApiManager.TAG, "Network Lost");
                ApiManager.INSTANCE.onNetworkChanged(false);
            }
        };
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback2 = networkCallback;
        k.c(networkCallback2);
        ((ConnectivityManager) systemService).registerNetworkCallback(networkRequestBuild, networkCallback2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r uploadFile$lambda$0(H h, S7.k kVar, int i, boolean z10, String fileId, String str) {
        k.f(fileId, "fileId");
        if (z10) {
            throw null;
        }
        kVar.invoke(new UploadStatus.Progress(i));
        return r.f317a;
    }

    public final void addEventSourceState(EventSourceState eventSourceState) {
        k.f(eventSourceState, "eventSourceState");
        eventSourceStates.add(new WeakReference<>(eventSourceState));
    }

    public final Object batchDeleteTasks(ApiType apiType, A a3, H7.c<? super Boolean> cVar) {
        return invokeTaskOp(apiType, "batchDeleteTasks", new AnonymousClass2(a3, null), cVar);
    }

    public final void cancelAllRequest(ApiType type) {
        k.f(type, "type");
        d.D(TAG, "cancelAllRequest call");
        Iterator<T> it = eventSourceStates.iterator();
        while (it.hasNext()) {
            EventSourceState eventSourceState = (EventSourceState) ((WeakReference) it.next()).get();
            if (eventSourceState != null) {
                eventSourceState.cancel();
            }
        }
    }

    public final Object cancelTask(ApiType apiType, B b, H7.c<? super Boolean> cVar) {
        return invokeTaskOp(apiType, "cancelTask", new C10482(b, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object chat(com.stepos.agentframework.adapter.netcore.ApiType r8, V4.l r9, com.stepos.agentframework.adapter.netcore.EventListener r10, H7.c<? super com.stepos.agentframework.adapter.netcore.ICancelHandle> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stepos.agentframework.adapter.ApiManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.agentframework.adapter.ApiManager$chat$1 r0 = (com.stepos.agentframework.adapter.ApiManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$chat$1 r0 = new com.stepos.agentframework.adapter.ApiManager$chat$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            java.lang.String r3 = "ApiManager"
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L46
            if (r2 != r4) goto L3e
            java.lang.Object r8 = r0.L$3
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r8 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r8
            java.lang.Object r8 = r0.L$2
            r10 = r8
            com.stepos.agentframework.adapter.netcore.EventListener r10 = (com.stepos.agentframework.adapter.netcore.EventListener) r10
            java.lang.Object r8 = r0.L$1
            r9 = r8
            V4.l r9 = (V4.l) r9
            java.lang.Object r8 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r8 = (com.stepos.agentframework.adapter.netcore.ApiType) r8
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L3c
            goto L84
        L3c:
            r7 = move-exception
            goto L91
        L3e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L46:
            kotlin.b.b(r11)
            boolean r11 = r7.checkInitSilent(r9, r10)
            if (r11 != 0) goto L50
            goto L61
        L50:
            com.stepos.agentframework.adapter.netcore.ApiType r11 = com.stepos.agentframework.adapter.netcore.ApiType.OPENCLAW
            if (r8 == r11) goto L5b
            boolean r11 = r7.checkNetworkSilent(r9, r10)
            if (r11 != 0) goto L5b
            goto L61
        L5b:
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r11 = r7.checkClientSilent(r8, r9, r10)
            if (r11 != 0) goto L62
        L61:
            return r5
        L62:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "Chat with type: "
            r2.<init>(r6)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.stepos.statsrpk.d.D(r3, r8)
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L3c
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L3c
            r0.L$2 = r10     // Catch: java.lang.Throwable -> L3c
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L3c
            r0.label = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r11 = r11.chat(r9, r10, r0)     // Catch: java.lang.Throwable -> L3c
            if (r11 != r1) goto L84
            return r1
        L84:
            com.stepos.agentframework.adapter.netcore.ICancelHandle r11 = (com.stepos.agentframework.adapter.netcore.ICancelHandle) r11     // Catch: java.lang.Throwable -> L3c
            boolean r8 = r11 instanceof com.stepos.agentframework.adapter.netcore.EventSourceState
            if (r8 == 0) goto L90
            r8 = r11
            com.stepos.agentframework.adapter.netcore.EventSourceState r8 = (com.stepos.agentframework.adapter.netcore.EventSourceState) r8
            r7.addEventSourceState(r8)
        L90:
            return r11
        L91:
            com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError r8 = new com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError
            java.lang.String r11 = r7.getMessage()
            r8.<init>(r11)
            int r11 = r8.code
            java.lang.Integer r0 = new java.lang.Integer
            r0.<init>(r11)
            java.lang.String r8 = r8.message
            r10.onFailure(r9, r0, r8)
            java.lang.String r8 = r7.getMessage()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Chat failed. Msg:"
            r9.<init>(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.stepos.statsrpk.d.v(r3, r8, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.chat(com.stepos.agentframework.adapter.netcore.ApiType, V4.l, com.stepos.agentframework.adapter.netcore.EventListener, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object clearSession(com.stepos.agentframework.adapter.netcore.ApiType r6, java.lang.String r7, H7.c<? super C7.r> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10491
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$clearSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$clearSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$clearSession$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L35
            return r3
        L35:
            r5 = move-exception
            goto L61
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.b.b(r8)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 != 0) goto L50
            goto L60
        L50:
            r6 = 0
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L35
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r5 = r5.clearSession(r7, r0)     // Catch: java.lang.Throwable -> L35
            if (r5 != r1) goto L60
            return r1
        L60:
            return r3
        L61:
            java.lang.String r6 = "ApiManager"
            java.lang.String r7 = "clearSession failed"
            com.stepos.statsrpk.d.v(r6, r7, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.clearSession(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createSession(com.stepos.agentframework.adapter.netcore.ApiType r6, H7.c<? super java.lang.String> r7) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.adapter.ApiManager.C10501
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.adapter.ApiManager$createSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10501) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$createSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$createSession$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r7)     // Catch: java.lang.Throwable -> L30
            goto L58
        L30:
            r5 = move-exception
            goto L5b
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.b.b(r7)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 != 0) goto L4b
            return r4
        L4b:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L30
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L30
            r0.label = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r7 = r5.createSession(r0)     // Catch: java.lang.Throwable -> L30
            if (r7 != r1) goto L58
            return r1
        L58:
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L30
            return r7
        L5b:
            java.lang.String r6 = "ApiManager"
            java.lang.String r7 = "createSession failed"
            com.stepos.statsrpk.d.v(r6, r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.createSession(com.stepos.agentframework.adapter.netcore.ApiType, H7.c):java.lang.Object");
    }

    public final Object createVM(V4.n nVar, H7.c<? super String> cVar) {
        return executeVMApi("createVM", new C10512(nVar, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteSession(com.stepos.agentframework.adapter.netcore.ApiType r6, java.lang.String r7, H7.c<? super C7.r> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10521
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$deleteSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$deleteSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$deleteSession$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L35
            return r3
        L35:
            r5 = move-exception
            goto L61
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.b.b(r8)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 != 0) goto L50
            goto L60
        L50:
            r6 = 0
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L35
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r5 = r5.deleteSession(r7, r0)     // Catch: java.lang.Throwable -> L35
            if (r5 != r1) goto L60
            return r1
        L60:
            return r3
        L61:
            java.lang.String r6 = "ApiManager"
            java.lang.String r7 = "deleteSession failed"
            com.stepos.statsrpk.d.v(r6, r7, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.deleteSession(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, H7.c):java.lang.Object");
    }

    public final Object deleteTask(ApiType apiType, C c, H7.c<? super Boolean> cVar) {
        return invokeTaskOp(apiType, "deleteTask", new C10532(c, null), cVar);
    }

    public final Object deleteVM(o oVar, H7.c<? super String> cVar) {
        return executeVMApi("deleteVM", new C10542(oVar, null), cVar);
    }

    public final void destroy(Context context) {
        k.f(context, "context");
        d.D(TAG, "destroy call");
        Object systemService = context.getSystemService("connectivity");
        k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        ConnectivityManager.NetworkCallback networkCallback2 = networkCallback;
        if (networkCallback2 != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback2);
        }
        Collection<ICoreAgentClient> collectionValues = clientMap.values();
        k.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((ICoreAgentClient) it.next()).destroy();
        }
        clientMap.clear();
        inited = false;
    }

    public final Object doctorFixVM(p pVar, H7.c<? super String> cVar) {
        return executeVMApi("doctorFixVM", new C10552(pVar, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object feedback(com.stepos.agentframework.adapter.netcore.ApiType r6, V4.q r7, H7.c<? super java.lang.Boolean> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10581
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$feedback$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10581) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$feedback$1 r0 = new com.stepos.agentframework.adapter.ApiManager$feedback$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$1
            if (r5 != 0) goto L34
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L6e
            goto L64
        L34:
            java.lang.ClassCastException r5 = new java.lang.ClassCastException
            r5.<init>()
            throw r5
        L3a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L42:
            kotlin.b.b(r8)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 == 0) goto L7e
            r6 = 0
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L6e
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L6e
            r0.label = r4     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r8 = r5.feedback(r7, r0)     // Catch: java.lang.Throwable -> L6e
            if (r8 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L6e
            boolean r5 = r8.booleanValue()     // Catch: java.lang.Throwable -> L6e
            if (r5 != r4) goto L7e
            r3 = r4
            goto L7e
        L6e:
            r5 = move-exception
            com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError r6 = new com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            com.stepos.agentframework.adapter.error.AdapterException r7 = new com.stepos.agentframework.adapter.error.AdapterException
            r7.<init>(r6, r5)
            throw r7
        L7e:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.feedback(com.stepos.agentframework.adapter.netcore.ApiType, V4.q, H7.c):java.lang.Object");
    }

    public final Object fetchDislikeFeedbackOptions(H7.c<? super List<String>> cVar) {
        List<String> list = dislikeFeedbackOptionsCache;
        if (list.isEmpty()) {
            return refreshDislikeFeedbackOptionsFromNetwork(cVar);
        }
        if (isDislikeFeedbackCacheExpired$default(this, 0L, 1, null)) {
            refreshDislikeFeedbackOptionsAsync();
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAgentDetail(com.stepos.agentframework.adapter.netcore.ApiType r5, V4.AbstractC0255b r6, H7.c<? super V4.C0254a> r7) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.adapter.ApiManager.C10591
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10591) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1 r0 = new com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            java.lang.Object r4 = r0.L$1
            if (r4 != 0) goto L33
            java.lang.Object r4 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r4 = (com.stepos.agentframework.adapter.netcore.ApiType) r4
            kotlin.b.b(r7)
            goto L61
        L33:
            java.lang.ClassCastException r4 = new java.lang.ClassCastException
            r4.<init>()
            throw r4
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.b.b(r7)
            r4.preCheck(r5)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r4 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r4 = r4.get(r5)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            if (r4 == 0) goto L67
            r5 = 0
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r7 = r4.getAgentDetail(r6, r0)
            if (r7 != r1) goto L61
            return r1
        L61:
            V4.a r7 = (V4.C0254a) r7
            if (r7 != 0) goto L66
            goto L67
        L66:
            return r7
        L67:
            V4.a r4 = new V4.a
            r4.<init>()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.getAgentDetail(com.stepos.agentframework.adapter.netcore.ApiType, V4.b, H7.c):java.lang.Object");
    }

    public final Gson getGson() {
        return gson;
    }

    public final void init(Context context, String deviceId, long timeOut, ILogger logger, UploadConfig tosConfig) {
        k.f(context, "context");
        k.f(deviceId, "deviceId");
        k.f(logger, "logger");
        if (inited) {
            return;
        }
        synchronized (this) {
            try {
                if (inited) {
                    return;
                }
                if (HttpManager.isInitialized()) {
                    d.D(TAG, "HttpManager is already initialized, skip init...");
                    HttpManager.INSTANCE.addBaseUrl("bff_base_url_key", M.a.X(context).j());
                } else {
                    d.D(TAG, "HttpManager is not initialized, init now...");
                    HttpManager httpManager = HttpManager.INSTANCE;
                    Context applicationContext = context.getApplicationContext();
                    k.e(applicationContext, "getApplicationContext(...)");
                    httpManager.init(applicationContext, new a(context, 0));
                }
                contextRef = new WeakReference<>(context.getApplicationContext());
                ApiManager apiManager = INSTANCE;
                apiManager.registerClient(context, new CozeCoreAgentClient(timeOut), logger);
                apiManager.registerClient(context, new DifyCoreAgentClient(timeOut), logger);
                apiManager.registerClient(context, new BffCoreAgentClient(timeOut), logger);
                apiManager.registerClient(context, new OpenClawCoreAgentClient(timeOut), logger);
                apiManager.registerClient(context, new AgentSpaceCoreAgentClient(timeOut), logger);
                Context applicationContext2 = context.getApplicationContext();
                k.e(applicationContext2, "getApplicationContext(...)");
                apiManager.startNetworkMonitor(applicationContext2);
                if (tosConfig != null) {
                    TOSUploadHelper.INSTANCE.init(tosConfig);
                    d.D(TAG, "TOS SDK initialized with custom config");
                }
                inited = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object interactTask(ApiType apiType, D d, H7.c<? super Boolean> cVar) {
        return invokeTaskOp(apiType, "interactTask", new C10602(d, null), cVar);
    }

    public final boolean isNetworkAvailable(Context context) {
        NetworkCapabilities networkCapabilities;
        k.f(context, "context");
        Object systemService = context.getSystemService("connectivity");
        k.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object pauseTask(com.stepos.agentframework.adapter.netcore.ApiType r6, V4.F r7, H7.c<? super java.lang.Boolean> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10621
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$pauseTask$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$pauseTask$1 r0 = new com.stepos.agentframework.adapter.ApiManager$pauseTask$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$1
            if (r5 != 0) goto L34
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L6e
            goto L64
        L34:
            java.lang.ClassCastException r5 = new java.lang.ClassCastException
            r5.<init>()
            throw r5
        L3a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L42:
            kotlin.b.b(r8)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 == 0) goto L93
            r6 = 0
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L6e
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L6e
            r0.label = r4     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r8 = r5.pauseTask(r7, r0)     // Catch: java.lang.Throwable -> L6e
            if (r8 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L6e
            boolean r5 = r8.booleanValue()     // Catch: java.lang.Throwable -> L6e
            if (r5 != r4) goto L93
            r3 = r4
            goto L93
        L6e:
            r5 = move-exception
            com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError r6 = new com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            java.lang.String r7 = r6.message
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "PauseTask failed. Err:"
            r8.<init>(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "ApiManager"
            com.stepos.statsrpk.d.v(r8, r7, r5)
            com.stepos.agentframework.adapter.error.AdapterException r7 = new com.stepos.agentframework.adapter.error.AdapterException
            r7.<init>(r6, r5)
            throw r7
        L93:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.pauseTask(com.stepos.agentframework.adapter.netcore.ApiType, V4.F, H7.c):java.lang.Object");
    }

    public final Object queryVMStatus(V4.r rVar, H7.c<? super String> cVar) {
        return executeVMApi("queryVMStatus", new C10632(rVar, null), cVar);
    }

    public final Object reInstallVM(V4.t tVar, H7.c<? super String> cVar) {
        return executeVMApi("reInstallVM", new C10642(tVar, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readCoreFile(com.stepos.agentframework.adapter.netcore.ApiType r6, java.lang.String r7, H7.c<? super java.lang.String> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10651
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$readCoreFile$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10651) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$readCoreFile$1 r0 = new com.stepos.agentframework.adapter.ApiManager$readCoreFile$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L5e
        L34:
            r5 = move-exception
            goto L61
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.b.b(r8)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 != 0) goto L4f
            return r4
        L4f:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L34
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L34
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L34
            r0.label = r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r8 = r5.readCoreFile(r7, r0)     // Catch: java.lang.Throwable -> L34
            if (r8 != r1) goto L5e
            return r1
        L5e:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L34
            return r8
        L61:
            java.lang.String r6 = "ApiManager"
            java.lang.String r7 = "readCoreFile failed"
            com.stepos.statsrpk.d.v(r6, r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.readCoreFile(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readFile(com.stepos.agentframework.adapter.netcore.ApiType r6, java.lang.String r7, H7.c<? super java.lang.String> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10661
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$readFile$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$readFile$1 r0 = new com.stepos.agentframework.adapter.ApiManager$readFile$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L5e
        L34:
            r5 = move-exception
            goto L61
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.b.b(r8)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 != 0) goto L4f
            return r4
        L4f:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L34
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L34
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L34
            r0.label = r3     // Catch: java.lang.Throwable -> L34
            java.lang.Object r8 = r5.readFile(r7, r0)     // Catch: java.lang.Throwable -> L34
            if (r8 != r1) goto L5e
            return r1
        L5e:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L34
            return r8
        L61:
            java.lang.String r6 = "ApiManager"
            java.lang.String r7 = "readFile failed"
            com.stepos.statsrpk.d.v(r6, r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.readFile(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, H7.c):java.lang.Object");
    }

    public final void registerClient(Context context, ICoreAgentClient client) {
        k.f(context, "context");
        k.f(client, "client");
        registerClient$default(this, context, client, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object renameSession(com.stepos.agentframework.adapter.netcore.ApiType r6, java.lang.String r7, java.lang.String r8, H7.c<? super C7.r> r9) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.adapter.ApiManager.C10691
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.adapter.ApiManager$renameSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$renameSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$renameSession$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 != r4) goto L3b
            java.lang.Object r5 = r0.L$3
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L39
            return r3
        L39:
            r5 = move-exception
            goto L67
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            kotlin.b.b(r9)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 != 0) goto L54
            goto L66
        L54:
            r6 = 0
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L39
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L39
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L39
            r0.L$3 = r6     // Catch: java.lang.Throwable -> L39
            r0.label = r4     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r5.renameSession(r7, r8, r0)     // Catch: java.lang.Throwable -> L39
            if (r5 != r1) goto L66
            return r1
        L66:
            return r3
        L67:
            java.lang.String r6 = "ApiManager"
            java.lang.String r7 = "renameSession failed"
            com.stepos.statsrpk.d.v(r6, r7, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.renameSession(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    public final Object renameTask(ApiType apiType, E e, H7.c<? super Boolean> cVar) {
        return invokeTaskOp(apiType, "renameTask", new C10702(e, null), cVar);
    }

    public final Object restartVM(w wVar, H7.c<? super String> cVar) {
        return executeVMApi("restartVM", new C10712(wVar, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resumeTask(com.stepos.agentframework.adapter.netcore.ApiType r6, V4.F r7, H7.c<? super java.lang.Boolean> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10721
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$resumeTask$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10721) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$resumeTask$1 r0 = new com.stepos.agentframework.adapter.ApiManager$resumeTask$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            java.lang.Object r5 = r0.L$1
            if (r5 != 0) goto L34
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L6e
            goto L64
        L34:
            java.lang.ClassCastException r5 = new java.lang.ClassCastException
            r5.<init>()
            throw r5
        L3a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L42:
            kotlin.b.b(r8)
            r5.preCheck(r6)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r5 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r5
            if (r5 == 0) goto L93
            r6 = 0
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L6e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6e
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L6e
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L6e
            r0.label = r4     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r8 = r5.resumeTask(r7, r0)     // Catch: java.lang.Throwable -> L6e
            if (r8 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L6e
            boolean r5 = r8.booleanValue()     // Catch: java.lang.Throwable -> L6e
            if (r5 != r4) goto L93
            r3 = r4
            goto L93
        L6e:
            r5 = move-exception
            com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError r6 = new com.stepos.agentframework.adapter.error.AdapterErrorCode$AgentInternalError
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            java.lang.String r7 = r6.message
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "ResumeTask failed. Err:"
            r8.<init>(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.String r8 = "ApiManager"
            com.stepos.statsrpk.d.v(r8, r7, r5)
            com.stepos.agentframework.adapter.error.AdapterException r7 = new com.stepos.agentframework.adapter.error.AdapterException
            r7.<init>(r6, r5)
            throw r7
        L93:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.resumeTask(com.stepos.agentframework.adapter.netcore.ApiType, V4.F, H7.c):java.lang.Object");
    }

    public final Object retryTask(ApiType apiType, G g, H7.c<? super Boolean> cVar) {
        return invokeTaskOp(apiType, "retryTask", new C10732(g, null), cVar);
    }

    public final void setPushMessageCallback(PushMessageListener callback) {
        d.s(TAG, "setOpenClawPushMessageCallback: callback set = " + (callback != null));
        ICoreAgentClient iCoreAgentClient = clientMap.get(ApiType.OPENCLAW);
        OpenClawCoreAgentClient openClawCoreAgentClient = iCoreAgentClient instanceof OpenClawCoreAgentClient ? (OpenClawCoreAgentClient) iCoreAgentClient : null;
        if (openClawCoreAgentClient != null) {
            openClawCoreAgentClient.setPushMessageCallback(callback);
        }
        d.s(TAG, "setOpenClawPushMessageCallback: callback set = " + (callback != null) + ", client exists = " + (openClawCoreAgentClient != null));
    }

    public final Object submitAgentSpaceVote(AgentSpaceVoteRequest agentSpaceVoteRequest, H7.c<? super Boolean> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10752(agentSpaceVoteRequest, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object syncConversations(com.stepos.agentframework.adapter.netcore.ApiType r7, H7.c<? super V4.x> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10761
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$syncConversations$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10761) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$syncConversations$1 r0 = new com.stepos.agentframework.adapter.ApiManager$syncConversations$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 != r5) goto L33
            java.lang.Object r6 = r0.L$1
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r6 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r6
            java.lang.Object r6 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r6 = (com.stepos.agentframework.adapter.netcore.ApiType) r6
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L31
            goto L60
        L31:
            r6 = move-exception
            goto L63
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.b.b(r8)
            r6.preCheck(r7)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r6 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r6 = r6.get(r7)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r6 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r6
            if (r6 != 0) goto L53
            V4.x r6 = new V4.x
            java.lang.String r7 = "client not found"
            r6.<init>(r4, r3, r7, r5)
            return r6
        L53:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L31
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L31
            r0.label = r5     // Catch: java.lang.Throwable -> L31
            java.lang.Object r8 = r6.syncConversations(r0)     // Catch: java.lang.Throwable -> L31
            if (r8 != r1) goto L60
            return r1
        L60:
            V4.x r8 = (V4.x) r8     // Catch: java.lang.Throwable -> L31
            return r8
        L63:
            java.lang.String r7 = "ApiManager"
            java.lang.String r8 = "syncConversations failed"
            com.stepos.statsrpk.d.v(r7, r8, r6)
            V4.x r7 = new V4.x
            java.lang.String r6 = r6.getMessage()
            r7.<init>(r4, r3, r6, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.syncConversations(com.stepos.agentframework.adapter.netcore.ApiType, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object syncHistorySession(com.stepos.agentframework.adapter.netcore.ApiType r7, java.lang.String r8, H7.c<? super V4.z> r9) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.adapter.ApiManager.C10771
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10771) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            java.lang.Object r6 = r0.L$2
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r6 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r6 = (com.stepos.agentframework.adapter.netcore.ApiType) r6
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L35
            goto L6b
        L35:
            r6 = move-exception
            goto L6e
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            kotlin.b.b(r9)
            r6.preCheck(r7)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r6 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r6 = r6.get(r7)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r6 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r6
            if (r6 != 0) goto L57
            V4.z r6 = new V4.z
            java.lang.String r7 = "client not found"
            r6.<init>(r5, r3, r7, r4)
            return r6
        L57:
            V4.y r7 = new V4.y     // Catch: java.lang.Throwable -> L35
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L35
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L35
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L35
            java.lang.Object r9 = r6.syncHistory(r7, r0)     // Catch: java.lang.Throwable -> L35
            if (r9 != r1) goto L6b
            return r1
        L6b:
            V4.z r9 = (V4.z) r9     // Catch: java.lang.Throwable -> L35
            return r9
        L6e:
            java.lang.String r7 = "ApiManager"
            java.lang.String r8 = "syncHistory failed"
            com.stepos.statsrpk.d.v(r7, r8, r6)
            V4.z r7 = new V4.z
            java.lang.String r6 = r6.getMessage()
            r7.<init>(r5, r3, r6, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.syncHistorySession(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, H7.c):java.lang.Object");
    }

    public final void updateAuth(AuthInfo authInfo) {
        k.f(authInfo, "authInfo");
        HashMap<ApiType, ICoreAgentClient> map = clientMap;
        ICoreAgentClient iCoreAgentClient = map.get(ApiType.BFF);
        BffCoreAgentClient bffCoreAgentClient = iCoreAgentClient instanceof BffCoreAgentClient ? (BffCoreAgentClient) iCoreAgentClient : null;
        if (bffCoreAgentClient != null) {
            bffCoreAgentClient.updateAuth(authInfo);
        }
        ICoreAgentClient iCoreAgentClient2 = map.get(ApiType.AGENT_SPACE);
        AgentSpaceCoreAgentClient agentSpaceCoreAgentClient = iCoreAgentClient2 instanceof AgentSpaceCoreAgentClient ? (AgentSpaceCoreAgentClient) iCoreAgentClient2 : null;
        if (agentSpaceCoreAgentClient != null) {
            agentSpaceCoreAgentClient.onAuthTokenChanged(authInfo.getToken());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadFile(android.content.Context r17, com.stepos.agentframework.adapter.netcore.ApiType r18, V4.H r19, S7.k r20, H7.c<? super C7.r> r21) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.uploadFile(android.content.Context, com.stepos.agentframework.adapter.netcore.ApiType, V4.H, S7.k, H7.c):java.lang.Object");
    }

    public final Object vote(ApiType apiType, I i, H7.c<? super Boolean> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10792(apiType, i, null), cVar);
    }

    public final void warmupDislikeFeedbackOptions() {
        refreshDislikeFeedbackOptionsAsync();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeCoreFile(com.stepos.agentframework.adapter.netcore.ApiType r5, java.lang.String r6, java.lang.String r7, H7.c<? super java.lang.Boolean> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10801
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1 r0 = new com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.L$3
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            java.lang.Object r4 = r0.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r4 = (com.stepos.agentframework.adapter.netcore.ApiType) r4
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L6b
            goto L64
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            kotlin.b.b(r8)
            r4.preCheck(r5)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r4 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r4 = r4.get(r5)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            if (r4 != 0) goto L52
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L52:
            r5 = 0
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L6b
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L6b
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L6b
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L6b
            r0.label = r3     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r8 = r4.writeCoreFile(r6, r7, r0)     // Catch: java.lang.Throwable -> L6b
            if (r8 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L6b
            boolean r4 = r8.booleanValue()     // Catch: java.lang.Throwable -> L6b
            goto L74
        L6b:
            r4 = move-exception
            java.lang.String r5 = "ApiManager"
            java.lang.String r6 = "writeCoreFile failed"
            com.stepos.statsrpk.d.v(r5, r6, r4)
            r4 = 0
        L74:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.writeCoreFile(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeFile(com.stepos.agentframework.adapter.netcore.ApiType r5, java.lang.String r6, java.lang.String r7, H7.c<? super java.lang.Boolean> r8) throws com.stepos.agentframework.adapter.error.AdapterException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager.C10811
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$writeFile$1 r0 = (com.stepos.agentframework.adapter.ApiManager.C10811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$writeFile$1 r0 = new com.stepos.agentframework.adapter.ApiManager$writeFile$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.L$3
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            java.lang.Object r4 = r0.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r4 = (com.stepos.agentframework.adapter.netcore.ApiType) r4
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L6b
            goto L64
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            kotlin.b.b(r8)
            r4.preCheck(r5)
            java.util.HashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.ICoreAgentClient> r4 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r4 = r4.get(r5)
            com.stepos.agentframework.adapter.netcore.ICoreAgentClient r4 = (com.stepos.agentframework.adapter.netcore.ICoreAgentClient) r4
            if (r4 != 0) goto L52
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L52:
            r5 = 0
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L6b
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L6b
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L6b
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L6b
            r0.label = r3     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r8 = r4.writeFile(r6, r7, r0)     // Catch: java.lang.Throwable -> L6b
            if (r8 != r1) goto L64
            return r1
        L64:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L6b
            boolean r4 = r8.booleanValue()     // Catch: java.lang.Throwable -> L6b
            goto L74
        L6b:
            r4 = move-exception
            java.lang.String r5 = "ApiManager"
            java.lang.String r6 = "writeFile failed"
            com.stepos.statsrpk.d.v(r5, r6, r4)
            r4 = 0
        L74:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.writeFile(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    public final void registerClient(Context context, ICoreAgentClient client, ILogger logger) {
        k.f(context, "context");
        k.f(client, "client");
        k.f(logger, "logger");
        synchronized (this) {
            client.init(context, logger);
            clientMap.put(client.getType(), client);
        }
    }
}
