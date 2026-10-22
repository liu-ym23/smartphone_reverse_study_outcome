package com.stepos.core.ota.confirmui;

import Ua.C1060i;
import Z8.C1172u;
import Z8.C1174w;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.flow.ModelFlowCallback;
import com.stepos.aiengine.flow.ModelFlowError;
import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.core.deepbinder.ICtaResultCallback;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.download.IDownloadCallback;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0002¨\u0001\u0018\u0000 «\u00012\u00020\u0001:\b¬\u0001\u00ad\u0001®\u0001«\u0001B_\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0016\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010 \u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%J!\u0010)\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010-\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010*J!\u00100\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b4\u00103J\u0017\u00105\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b5\u00103J7\u0010:\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0002H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0002H\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b>\u00103J\u0017\u0010?\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b?\u00103J\u0017\u0010@\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b@\u00103J\u0017\u0010C\u001a\u00020\r2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\r2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bJ\u0010KJ'\u0010N\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\bP\u0010OJ'\u0010Q\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\bQ\u0010OJ\u001f\u0010R\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\bR\u0010*J\u001f\u0010S\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\bS\u0010*J\u0017\u0010U\u001a\u00020\r2\u0006\u0010T\u001a\u00020IH\u0002¢\u0006\u0004\bU\u0010VJ\u001f\u0010W\u001a\u00020I2\u0006\u0010T\u001a\u00020I2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020I2\u0006\u0010T\u001a\u00020IH\u0002¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\rH\u0002¢\u0006\u0004\b[\u0010\\J'\u0010]\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000fH\u0002¢\u0006\u0004\b]\u0010OJ\u0017\u0010_\u001a\u00020^2\u0006\u00106\u001a\u00020\u0002H\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020IH\u0002¢\u0006\u0004\ba\u0010KJ\u000f\u0010b\u001a\u00020\rH\u0002¢\u0006\u0004\bb\u0010\\J\u0017\u0010c\u001a\u00020\r2\u0006\u0010.\u001a\u00020^H\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010f\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u000fH\u0002¢\u0006\u0004\bf\u0010gJ\u001f\u0010j\u001a\u00020\r2\u0006\u0010h\u001a\u00020I2\u0006\u0010i\u001a\u00020\u0002H\u0002¢\u0006\u0004\bj\u0010kJ\u0015\u0010m\u001a\b\u0012\u0004\u0012\u00020\u001b0lH\u0002¢\u0006\u0004\bm\u0010nJ\u000f\u0010o\u001a\u00020\rH\u0002¢\u0006\u0004\bo\u0010\\J9\u0010p\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\bp\u0010qJW\u0010t\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010r\u001a\u00020\u000f2\b\b\u0002\u0010(\u001a\u00020\u000f2\b\b\u0002\u0010s\u001a\u00020\u000fH\u0007¢\u0006\u0004\bt\u0010uJ/\u0010v\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\bv\u0010wR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010xR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010yR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010xR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010zR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010xR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010{R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010|R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010}R\u0015\u0010\u007f\u001a\u00020~8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0083\u0001R+\u0010\u0089\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0087\u00010\u0086\u0001j\n\u0012\u0005\u0012\u00030\u0087\u0001`\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u0010\u008b\u0001\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001a\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010xR\u0016\u0010\u008e\u0001\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010zR\u0019\u0010\u008f\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001f\u0010\u0097\u0001R\u001a\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010xR\u0018\u0010\u0099\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010zR\u0018\u0010\u009a\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010xR\u0018\u0010\u009b\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010xR\u0018\u0010\u009c\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010}R\u0016\u0010r\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010}R\u0016\u0010s\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010}R\u001b\u0010\u009d\u0001\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001a\u0010 \u0001\u001a\u00030\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¤\u0001\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b¤\u0001\u0010{R\u001c\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010©\u0001\u001a\u00030¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001¨\u0006¯\u0001"}, d2 = {"Lcom/stepos/core/ota/confirmui/ModelConfirmFlow;", "", "", "algorithmId", "Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Mode;", "mode", OtaConfirmTrampolineActivity.EXTRA_TRACE_ID, "", OtaConfirmTrampolineActivity.EXTRA_T0, "displayLabel", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "confirmHost", "Lkotlin/Function0;", "LY8/t;", "attachOnConfirm", "", OtaConfirmTrampolineActivity.EXTRA_UPDATE_CONFIRM_FIRST, "<init>", "(Ljava/lang/String;Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Mode;Ljava/lang/String;JLjava/lang/String;Lcom/stepos/core/ota/confirmui/ConfirmUiHost;Lp9/a;Z)V", "Lkotlin/Function1;", "Lcom/stepos/core/download/IDownloadCallback;", "action", "forEachProgress", "(Lp9/l;)V", "Landroid/content/Context;", "context", "key", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "callback", "progress", "LUa/M;", "scope", "becomeOwner", "(Landroid/content/Context;Ljava/lang/String;Lcom/stepos/aiengine/flow/ModelFlowCallback;Lcom/stepos/core/download/IDownloadCallback;LUa/M;)V", "tryAttach", "(Lcom/stepos/aiengine/flow/ModelFlowCallback;Lcom/stepos/core/download/IDownloadCallback;)Z", "isStale", "()Z", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "service", "cellularPreapproved", "runResumeGate", "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Z)V", "ensureResumable", "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;)Z", "resumeAfterCta", "stage", "extra", "perf", "(Ljava/lang/String;Ljava/lang/String;)V", "runFlow", "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;)V", "requestCtaThenContinue", "afterCta", "plan", "sizeBytes", "label", "updateInfo", "showConfirm", "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "showUnavailable", "(Ljava/lang/String;)V", "runPreflight", "runPreflightAfterCta", "showNoNetworkGuide", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;", "sub", "onSubStage", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;)V", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;", "decision", "onDecision", "(Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;)V", "", "canceledCodeForCurrentStep", "()I", ModelFlowMeta.KEY_CELLULAR_ALLOWED, "enableWifiAuto", "gateThenDownload", "(Lcom/stepos/core/deepbinder/IOtaDeepBinderService;ZZ)V", "proceedDownload", "proceedWithNetworkCheck", "showResumeConfirmThenProceed", "showCellularReminderThenProceed", "errorCode", "showResourceGateBlocked", "(I)V", "gateFlowCode", "(ILcom/stepos/core/ota/confirmui/ConfirmDecisionBus$Decision;)I", "gateBlockedCode", "(I)I", "registerInternalCallback", "()V", "executeDownload", "Lcom/stepos/aiengine/flow/ModelFlowStage;", "topStageFor", "(Ljava/lang/String;)Lcom/stepos/aiengine/flow/ModelFlowStage;", "userCanceledCode", "postDownloadingOnce", "postStage", "(Lcom/stepos/aiengine/flow/ModelFlowStage;)V", ModelFlowMeta.KEY_CAN_UPDATE, "ready", "(Z)V", "code", "message", "fail", "(ILjava/lang/String;)V", "", "detachAllAndUnregisterKey", "()Ljava/util/List;", "cleanup", "start", "(Landroid/content/Context;Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Lcom/stepos/aiengine/flow/ModelFlowCallback;Lcom/stepos/core/download/IDownloadCallback;LUa/M;)V", "isRetry", "resumeConfirm", "startResume", "(Landroid/content/Context;Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Lcom/stepos/aiengine/flow/ModelFlowCallback;Lcom/stepos/core/download/IDownloadCallback;LUa/M;ZZZ)V", "startInferencePreflight", "(Landroid/content/Context;Lcom/stepos/core/deepbinder/IOtaDeepBinderService;Lcom/stepos/aiengine/flow/ModelFlowCallback;LUa/M;)V", "Ljava/lang/String;", "Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Mode;", "J", "Lcom/stepos/core/ota/confirmui/ConfirmUiHost;", "Lp9/a;", "Z", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "terminated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "downloadingPosted", "sessionBegun", "Ljava/util/ArrayList;", "Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Follower;", "Lkotlin/collections/ArrayList;", "followers", "Ljava/util/ArrayList;", "dedupeLock", "Ljava/lang/Object;", "dedupeKey", "startedAtMs", "appContext", "Landroid/content/Context;", "flowCallback", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "progressCallback", "Lcom/stepos/core/download/IDownloadCallback;", "svc", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "LUa/M;", OtaConfirmTrampolineActivity.EXTRA_REQ_ID, "pendingSizeBytes", "pendingLabel", "pendingUpdateInfo", "isResume", "lastSubStage", "Lcom/stepos/core/ota/confirmui/ConfirmDecisionBus$SubStage;", "Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Phase;", "phase", "Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Phase;", "lastStage", "Lcom/stepos/aiengine/flow/ModelFlowStage;", "uiHost", "Lcom/stepos/core/deepbinder/ICtaResultCallback;", "ctaCallback", "Lcom/stepos/core/deepbinder/ICtaResultCallback;", "com/stepos/core/ota/confirmui/ModelConfirmFlow$internalCb$1", "internalCb", "Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$internalCb$1;", "Companion", "Mode", "Follower", "Phase", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ModelConfirmFlow {
    private static final String PERF_TAG = "OtaConfirmPerf";
    private static final long STALE_TTL_MS = 300000;
    private static final String TAG = "ModelConfirmFlow";
    private final String algorithmId;
    private Context appContext;
    private final InterfaceC5063a<Y8.t> attachOnConfirm;
    private final ConfirmUiHost confirmHost;
    private ICtaResultCallback ctaCallback;
    private String dedupeKey;
    private final Object dedupeLock;
    private final String displayLabel;
    private final AtomicBoolean downloadingPosted;
    private ModelFlowCallback flowCallback;
    private final ArrayList<Follower> followers;
    private final ModelConfirmFlow$internalCb$1 internalCb;
    private boolean isResume;
    private boolean isRetry;
    private volatile ModelFlowStage lastStage;
    private volatile ConfirmDecisionBus.SubStage lastSubStage;
    private final Handler main;
    private final Mode mode;
    private String pendingLabel;
    private long pendingSizeBytes;
    private String pendingUpdateInfo;
    private final long perfT0;
    private final String perfTraceId;
    private volatile Phase phase;
    private IDownloadCallback progressCallback;
    private String reqId;
    private boolean resumeConfirm;
    private Ua.M scope;
    private final AtomicBoolean sessionBegun;
    private final long startedAtMs;
    private IOtaDeepBinderService svc;
    private final AtomicBoolean terminated;
    private ConfirmUiHost uiHost;
    private final boolean updateConfirmFirst;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, ModelConfirmFlow> inFlight = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Companion;", "", "<init>", "()V", "", "algorithmId", "LY8/t;", "markDetachedFromExternalControl", "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "PERF_TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/core/ota/confirmui/ModelConfirmFlow;", "inFlight", "Ljava/util/concurrent/ConcurrentHashMap;", "", "STALE_TTL_MS", "J", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void markDetachedFromExternalControl(String algorithmId) {
            kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
            for (Map.Entry entry : ModelConfirmFlow.inFlight.entrySet()) {
                String str = (String) entry.getKey();
                ModelConfirmFlow modelConfirmFlow = (ModelConfirmFlow) entry.getValue();
                if (La.D.X(str, algorithmId + Const.STR_MART_WELL, false, 2, null)) {
                    synchronized (modelConfirmFlow.dedupeLock) {
                        try {
                            if (!modelConfirmFlow.terminated.get() && modelConfirmFlow.phase == Phase.RUNNING) {
                                modelConfirmFlow.phase = Phase.DETACHED;
                                modelConfirmFlow.downloadingPosted.set(false);
                            }
                            Y8.t tVar = Y8.t.f7040a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Follower;", "", "flowCallback", "Lcom/stepos/aiengine/flow/ModelFlowCallback;", "progressCallback", "Lcom/stepos/core/download/IDownloadCallback;", "<init>", "(Lcom/stepos/aiengine/flow/ModelFlowCallback;Lcom/stepos/core/download/IDownloadCallback;)V", "getFlowCallback", "()Lcom/stepos/aiengine/flow/ModelFlowCallback;", "getProgressCallback", "()Lcom/stepos/core/download/IDownloadCallback;", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Follower {
        private final ModelFlowCallback flowCallback;
        private final IDownloadCallback progressCallback;

        public Follower(ModelFlowCallback flowCallback, IDownloadCallback iDownloadCallback) {
            kotlin.jvm.internal.p.i(flowCallback, "flowCallback");
            this.flowCallback = flowCallback;
            this.progressCallback = iDownloadCallback;
        }

        public final ModelFlowCallback getFlowCallback() {
            return this.flowCallback;
        }

        public final IDownloadCallback getProgressCallback() {
            return this.progressCallback;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD", "UPDATE", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Mode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode DOWNLOAD = new Mode("DOWNLOAD", 0);
        public static final Mode UPDATE = new Mode("UPDATE", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{DOWNLOAD, UPDATE};
        }

        static {
            Mode[] modeArr$values = $values();
            $VALUES = modeArr$values;
            $ENTRIES = kotlin.enums.a.a(modeArr$values);
        }

        private Mode(String str, int i10) {
        }

        public static InterfaceC4149a<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/core/ota/confirmui/ModelConfirmFlow$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "INTERACTIVE", "RUNNING", "DETACHED", "aiengine-ota-confirm_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Phase {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Phase[] $VALUES;
        public static final Phase INTERACTIVE = new Phase("INTERACTIVE", 0);
        public static final Phase RUNNING = new Phase("RUNNING", 1);
        public static final Phase DETACHED = new Phase("DETACHED", 2);

        private static final /* synthetic */ Phase[] $values() {
            return new Phase[]{INTERACTIVE, RUNNING, DETACHED};
        }

        static {
            Phase[] phaseArr$values = $values();
            $VALUES = phaseArr$values;
            $ENTRIES = kotlin.enums.a.a(phaseArr$values);
        }

        private Phase(String str, int i10) {
        }

        public static InterfaceC4149a<Phase> getEntries() {
            return $ENTRIES;
        }

        public static Phase valueOf(String str) {
            return (Phase) Enum.valueOf(Phase.class, str);
        }

        public static Phase[] values() {
            return (Phase[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ConfirmDecisionBus.Decision.values().length];
            try {
                iArr[ConfirmDecisionBus.Decision.SCHEDULE_WIFI_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.CONFIRM_CELLULAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_AND_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.ENABLE_WIFI_AUTO_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ConfirmDecisionBus.Decision.OPEN_SERVICE_SETTINGS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ConfirmDecisionBus.SubStage.values().length];
            try {
                iArr2[ConfirmDecisionBus.SubStage.CELLULAR_REMINDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ConfirmDecisionBus.SubStage.WIFI_GUIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.core.ota.confirmui.ModelConfirmFlow$startInferencePreflight$1", f = "ModelConfirmFlow.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.confirmui.ModelConfirmFlow$startInferencePreflight$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ IOtaDeepBinderService $service;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(IOtaDeepBinderService iOtaDeepBinderService, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$service = iOtaDeepBinderService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return ModelConfirmFlow.this.new AnonymousClass1(this.$service, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ModelConfirmFlow.this.runPreflight(this.$service);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode) {
        this(algorithmId, mode, null, 0L, null, null, null, false, 252, null);
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        kotlin.jvm.internal.p.i(mode, "mode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void afterCta(IOtaDeepBinderService service) {
        Object objB;
        Object objB2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        perf("FETCH_META_START", "modelId=" + this.algorithmId + " mode=" + this.mode);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.mode == Mode.DOWNLOAD ? service.fetchDownloadMeta(this.algorithmId) : service.fetchUpdateMeta(this.algorithmId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            if (message == null) {
                message = "fetchMeta failed";
            }
            fail(ModelFlowError.SERVICE_UNAVAILABLE, message);
            return;
        }
        Bundle bundle = (Bundle) objB;
        if (!bundle.getBoolean(ModelFlowMeta.KEY_SERVICE_ENABLED, true)) {
            Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " model service disabled → gate dialog");
            showResourceGateBlocked(5022);
            return;
        }
        if (bundle.getBoolean(ModelFlowMeta.KEY_CTA_BLOCKED, false)) {
            Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " fetch blocked by CTA → CTA_DENIED");
            fail(4001, "fetch blocked: CTA not granted");
            return;
        }
        boolean z10 = bundle.getBoolean(ModelFlowMeta.KEY_FETCH_OK, false);
        boolean z11 = bundle.getBoolean(ModelFlowMeta.KEY_REMOTE_AVAILABLE, false);
        boolean z12 = bundle.getBoolean(ModelFlowMeta.KEY_SERVER_REACHED, false);
        boolean z13 = bundle.getBoolean(ModelFlowMeta.KEY_HAS_UPDATE);
        perf("FETCH_META_DONE", "modelId=" + this.algorithmId + " dur=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms fetchOk=" + z10 + " remoteAvailable=" + z11 + " serverReached=" + z12 + " hasUpdate=" + z13);
        Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " mode=" + this.mode + " fetchOk=" + z10 + " remoteAvailable=" + z11 + " serverReached=" + z12 + " hasUpdate=" + z13);
        if (!z11 && !z12) {
            fail(5001, "server unreachable, no cached data");
            return;
        }
        long j10 = bundle.getLong("sizeBytes");
        String string = this.displayLabel;
        if (La.H.x0(string) && (string = bundle.getString("modelLabel")) == null) {
            string = this.algorithmId;
        }
        String str = string;
        String string2 = bundle.getString("updateInfo");
        if (string2 == null) {
            string2 = "";
        }
        String string3 = bundle.getString("plan");
        String str2 = string3 == null ? ModelFlowMeta.PLAN_NONE : string3;
        if (!z11) {
            Log.i(TAG, "[DIAG] afterCta " + this.algorithmId + " model not available (server reached, no entry) → MODEL_NOT_AVAILABLE");
            fail(ModelFlowError.MODEL_NOT_AVAILABLE, "model not available on server");
            return;
        }
        if (this.mode == Mode.UPDATE && !z13) {
            fail(ModelFlowError.ALREADY_UP_TO_DATE, "already up to date");
            return;
        }
        if (kotlin.jvm.internal.p.d(str2, ModelFlowMeta.PLAN_NO_NETWORK) || kotlin.jvm.internal.p.d(str2, ModelFlowMeta.PLAN_NONE)) {
            fail(5001, "no network");
            return;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        try {
            objB2 = Result.b(service.queryPrecheckEnv());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        Bundle bundle2 = (Bundle) objB2;
        perf("PRECHECK_DONE", "modelId=" + this.algorithmId + " dur=" + (SystemClock.elapsedRealtime() - jElapsedRealtime2) + "ms envOk=" + (bundle2 != null ? Boolean.valueOf(bundle2.getBoolean(ModelFlowMeta.KEY_ENV_OK, true)) : null));
        if (bundle2 == null || bundle2.getBoolean(ModelFlowMeta.KEY_ENV_OK, true)) {
            showConfirm(service, str2, j10, str, string2);
            return;
        }
        Integer numValueOf = Integer.valueOf(bundle2.getInt(ModelFlowMeta.KEY_ENV_ERROR, 0));
        Integer num = numValueOf.intValue() != 0 ? numValueOf : null;
        fail(num != null ? num.intValue() : 5001, "env precheck failed");
    }

    private final void becomeOwner(Context context, String key, ModelFlowCallback callback, IDownloadCallback progress, Ua.M scope) {
        this.flowCallback = callback;
        this.progressCallback = progress;
        this.scope = scope;
        ConfirmUiHost trampolineConfirmHost = this.confirmHost;
        if (trampolineConfirmHost == null) {
            Context context2 = this.appContext;
            if (context2 == null) {
                kotlin.jvm.internal.p.A("appContext");
                context2 = null;
            }
            trampolineConfirmHost = new TrampolineConfirmHost(context2);
        }
        this.uiHost = trampolineConfirmHost;
        this.dedupeKey = key;
        synchronized (this.dedupeLock) {
            this.followers.add(new Follower(callback, progress));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int canceledCodeForCurrentStep() {
        ConfirmDecisionBus.SubStage subStage = this.lastSubStage;
        int i10 = subStage == null ? -1 : WhenMappings.$EnumSwitchMapping$1[subStage.ordinal()];
        if (i10 == -1) {
            return userCanceledCode();
        }
        if (i10 == 1) {
            return ModelFlowError.USER_CANCELED_CELLULAR;
        }
        if (i10 == 2) {
            return ModelFlowError.USER_CANCELED_WIFI_GUIDE;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void cleanup() {
        Y8.t tVar;
        Y8.t tVar2;
        try {
            Result.Companion companion = Result.INSTANCE;
            IOtaDeepBinderService iOtaDeepBinderService = this.svc;
            if (iOtaDeepBinderService != null) {
                iOtaDeepBinderService.unregisterDownloadCallback(this.algorithmId, this.internalCb);
                tVar2 = Y8.t.f7040a;
            } else {
                tVar2 = null;
            }
            Result.b(tVar2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (this.sessionBegun.compareAndSet(true, false)) {
            try {
                IOtaDeepBinderService iOtaDeepBinderService2 = this.svc;
                if (iOtaDeepBinderService2 != null) {
                    iOtaDeepBinderService2.endInteractiveSession(this.algorithmId);
                    tVar = Y8.t.f7040a;
                } else {
                    tVar = null;
                }
                Result.b(tVar);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
        }
        String str = this.reqId;
        if (str != null) {
            ConfirmDecisionBus.INSTANCE.clear(str);
        }
        this.ctaCallback = null;
    }

    private final List<ModelFlowCallback> detachAllAndUnregisterKey() {
        ArrayList arrayList;
        String str = this.dedupeKey;
        if (str == null) {
            ModelFlowCallback modelFlowCallback = this.flowCallback;
            if (modelFlowCallback == null) {
                kotlin.jvm.internal.p.A("flowCallback");
                modelFlowCallback = null;
            }
            return C1172u.e(modelFlowCallback);
        }
        inFlight.remove(str, this);
        synchronized (this.dedupeLock) {
            try {
                ArrayList<Follower> arrayList2 = this.followers;
                arrayList = new ArrayList(C1174w.x(arrayList2, 10));
                Iterator<T> it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Follower) it.next()).getFlowCallback());
                }
                this.followers.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private final boolean ensureResumable(IOtaDeepBinderService service) {
        Object objB;
        Object objB2;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.mode == Mode.DOWNLOAD ? service.queryDownloadMeta(this.algorithmId) : service.queryUpdateMeta(this.algorithmId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Bundle bundle = (Bundle) objB;
        if (bundle != null && bundle.getBoolean("active")) {
            Log.i(TAG, "[DIAG] resume → attach active task " + this.algorithmId);
            registerInternalCallback();
            postDownloadingOnce();
            return false;
        }
        try {
            objB2 = Result.b(Integer.valueOf(service.getDownloadStatus(this.algorithmId)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Integer num = (Integer) (Result.g(objB2) ? null : objB2);
        if ((num != null && num.intValue() == 4) || (num != null && num.intValue() == 3)) {
            return true;
        }
        if (this.isRetry) {
            Log.i(TAG, "[DIAG] resume → retry without first confirm " + this.algorithmId + " status=" + num);
            return true;
        }
        if (this.mode == Mode.DOWNLOAD && bundle != null && bundle.getBoolean("installed")) {
            Log.i(TAG, "[DIAG] resume → already installed, report ready " + this.algorithmId);
            ready(bundle.getBoolean(ModelFlowMeta.KEY_CAN_UPDATE));
            return false;
        }
        Log.i(TAG, "[DIAG] resume rejected " + this.algorithmId + ": no resumable task status=" + num);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("no resumable task (status=");
        sb2.append(num);
        sb2.append(")");
        fail(ModelFlowError.MODEL_NOT_INSTALLED, sb2.toString());
        return false;
    }

    private final void executeDownload(IOtaDeepBinderService service, boolean cellularAllowed, boolean enableWifiAuto) {
        Object objB;
        Object objB2;
        InterfaceC5063a<Y8.t> interfaceC5063a = this.attachOnConfirm;
        if (interfaceC5063a == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                if (!this.isResume || cellularAllowed) {
                    service.executeDownload(this.algorithmId, cellularAllowed, enableWifiAuto);
                } else {
                    service.resumeDownload(this.algorithmId);
                }
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                String message = thE.getMessage();
                if (message == null) {
                    message = "executeDownload failed";
                }
                fail(ModelFlowError.DOWNLOAD_ENQUEUE_FAILED, message);
                return;
            }
            return;
        }
        Log.i(TAG, "[DIAG] confirmed active silent task " + this.algorithmId + " → attach as user task, no re-enqueue");
        try {
            Result.Companion companion3 = Result.INSTANCE;
            interfaceC5063a.invoke();
            objB2 = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB2);
        if (thE2 != null) {
            Log.w(TAG, "attachOnConfirm failed for " + this.algorithmId, thE2);
        }
        ready(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fail(final int code, final String message) {
        if (this.terminated.compareAndSet(false, true)) {
            Log.i(TAG, "[DIAG] terminal " + this.algorithmId + " mode=" + this.mode + " result=FAIL code=" + code);
            cleanup();
            final List<ModelFlowCallback> listDetachAllAndUnregisterKey = detachAllAndUnregisterKey();
            this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.q
                @Override // java.lang.Runnable
                public final void run() {
                    ModelConfirmFlow.fail$lambda$90(listDetachAllAndUnregisterKey, this, code, message);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fail$lambda$90(List list, ModelConfirmFlow modelConfirmFlow, int i10, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ModelFlowCallback modelFlowCallback = (ModelFlowCallback) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                modelFlowCallback.onFailed(i10, str);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forEachProgress(InterfaceC5074l<? super IDownloadCallback, Y8.t> action) {
        ArrayList<IDownloadCallback> arrayList;
        synchronized (this.dedupeLock) {
            ArrayList<Follower> arrayList2 = this.followers;
            arrayList = new ArrayList();
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                IDownloadCallback progressCallback = ((Follower) it.next()).getProgressCallback();
                if (progressCallback != null) {
                    arrayList.add(progressCallback);
                }
            }
        }
        for (IDownloadCallback iDownloadCallback : arrayList) {
            try {
                Result.Companion companion = Result.INSTANCE;
                action.invoke(iDownloadCallback);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    private final int gateBlockedCode(int errorCode) {
        if (errorCode != 5021) {
            return errorCode != 5022 ? 5020 : 5022;
        }
        return 5021;
    }

    private final int gateFlowCode(int errorCode, ConfirmDecisionBus.Decision decision) {
        return errorCode == 5022 ? decision == ConfirmDecisionBus.Decision.OPEN_SERVICE_SETTINGS ? ModelFlowError.SERVICE_ENABLE_GUIDED : ModelFlowError.USER_CANCELED_SERVICE_GUIDE : gateBlockedCode(errorCode);
    }

    private final void gateThenDownload(IOtaDeepBinderService service, boolean cellularAllowed, boolean enableWifiAuto) {
        ModelConfirmFlow modelConfirmFlow;
        kotlinx.coroutines.g gVarD;
        long j10 = this.pendingSizeBytes;
        Ua.M m10 = this.scope;
        if (m10 != null) {
            modelConfirmFlow = this;
            gVarD = C1060i.d(m10, Ua.Y.b(), null, new ModelConfirmFlow$gateThenDownload$job$1(modelConfirmFlow, j10, service, cellularAllowed, enableWifiAuto, null), 2, null);
        } else {
            modelConfirmFlow = this;
            gVarD = null;
        }
        if (gVarD == null) {
            modelConfirmFlow.fail(ModelFlowError.SERVICE_UNAVAILABLE, "resource gate scope missing");
        }
    }

    private final boolean isStale() {
        return SystemClock.elapsedRealtime() - this.startedAtMs > 300000;
    }

    public static final void markDetachedFromExternalControl(String str) {
        INSTANCE.markDetachedFromExternalControl(str);
    }

    private final void onDecision(ConfirmDecisionBus.Decision decision) {
        IOtaDeepBinderService iOtaDeepBinderService = this.svc;
        if (iOtaDeepBinderService == null) {
            fail(ModelFlowError.SERVICE_UNAVAILABLE, "OTA service unavailable");
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[decision.ordinal()]) {
            case 1:
                try {
                    Result.Companion companion = Result.INSTANCE;
                    iOtaDeepBinderService.recordNoNetworkDownloadDecision(this.algorithmId, true);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
                try {
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.b(C4849c.a(th2));
                }
                fail(ModelFlowError.DOWNLOAD_SCHEDULED, "scheduled wifi auto-download");
                return;
            case 2:
                gateThenDownload(iOtaDeepBinderService, false, false);
                return;
            case 3:
                gateThenDownload(iOtaDeepBinderService, true, false);
                return;
            case 4:
                gateThenDownload(iOtaDeepBinderService, false, true);
                return;
            case 5:
                try {
                    Result.Companion companion4 = Result.INSTANCE;
                    iOtaDeepBinderService.setWlanAutoUpgrade(true);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th3) {
                    Result.Companion companion5 = Result.INSTANCE;
                    Result.b(C4849c.a(th3));
                }
                try {
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.INSTANCE;
                    Result.b(C4849c.a(th4));
                }
                fail(ModelFlowError.USER_WIFI_AUTO_ONLY, "enable wifi-auto only, not downloading");
                return;
            case 6:
                try {
                    Result.Companion companion7 = Result.INSTANCE;
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th5) {
                    Result.Companion companion8 = Result.INSTANCE;
                    Result.b(C4849c.a(th5));
                }
                fail(canceledCodeForCurrentStep(), "user canceled");
                return;
            case 7:
                try {
                    Result.Companion companion9 = Result.INSTANCE;
                    iOtaDeepBinderService.endInteractiveSession(this.algorithmId);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th6) {
                    Result.Companion companion10 = Result.INSTANCE;
                    Result.b(C4849c.a(th6));
                }
                fail(ModelFlowError.SERVICE_ENABLE_GUIDED, "guided to enhanced service settings");
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void onSubStage(ConfirmDecisionBus.SubStage sub) {
        this.lastSubStage = sub;
        int i10 = WhenMappings.$EnumSwitchMapping$1[sub.ordinal()];
        if (i10 == 1) {
            postStage(this.mode == Mode.DOWNLOAD ? ModelFlowStage.DOWNLOAD_CELLULAR_CONFIRM : ModelFlowStage.UPDATE_CELLULAR_CONFIRM);
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            postStage(ModelFlowStage.UPDATE_WIFI_GUIDE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void perf(String stage, String extra) {
        if (this.perfTraceId.length() == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.perfT0;
        Log.i(PERF_TAG, "OCPERF tid=" + this.perfTraceId + " +" + jElapsedRealtime + "ms stage=" + stage + " " + extra);
    }

    public static /* synthetic */ void perf$default(ModelConfirmFlow modelConfirmFlow, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "";
        }
        modelConfirmFlow.perf(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postDownloadingOnce() {
        this.phase = Phase.RUNNING;
        if (this.downloadingPosted.compareAndSet(false, true)) {
            postStage(ModelFlowStage.DOWNLOADING);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postStage(final ModelFlowStage stage) {
        final List list;
        if (this.terminated.get()) {
            return;
        }
        this.lastStage = stage;
        synchronized (this.dedupeLock) {
            try {
                ArrayList<Follower> arrayList = this.followers;
                List arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Follower) it.next()).getFlowCallback());
                }
                if (arrayList2.isEmpty()) {
                    ModelFlowCallback modelFlowCallback = this.flowCallback;
                    if (modelFlowCallback == null) {
                        kotlin.jvm.internal.p.A("flowCallback");
                        modelFlowCallback = null;
                    }
                    arrayList2 = C1172u.e(modelFlowCallback);
                }
                list = arrayList2;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.K
            @Override // java.lang.Runnable
            public final void run() {
                ModelConfirmFlow.postStage$lambda$84(this.f29539a, list, stage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postStage$lambda$84(ModelConfirmFlow modelConfirmFlow, List list, ModelFlowStage modelFlowStage) {
        if (modelConfirmFlow.terminated.get()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ModelFlowCallback modelFlowCallback = (ModelFlowCallback) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                modelFlowCallback.onStateChanged(modelFlowStage);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    private final void proceedDownload(IOtaDeepBinderService service, boolean cellularAllowed, boolean enableWifiAuto) {
        registerInternalCallback();
        postDownloadingOnce();
        executeDownload(service, cellularAllowed, enableWifiAuto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void proceedWithNetworkCheck(IOtaDeepBinderService service, boolean cellularAllowed, boolean enableWifiAuto) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(service.queryPrecheckEnv());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Bundle bundle = (Bundle) objB;
        if (bundle == null) {
            Log.w(TAG, "[DIAG] proceedNetwork " + this.algorithmId + " precheckEnv unavailable (fail-closed, block)");
            fail(ModelFlowError.SERVICE_UNAVAILABLE, "precheck env unavailable");
            return;
        }
        boolean z10 = bundle.getBoolean(ModelFlowMeta.KEY_HAS_NETWORK, false);
        boolean z11 = bundle.getBoolean(ModelFlowMeta.KEY_IS_WIFI, false);
        Log.i(TAG, "[DIAG] proceedNetwork " + this.algorithmId + " hasNet=" + z10 + " wifi=" + z11 + " cellularAllowed=" + cellularAllowed);
        if (!z10) {
            fail(5001, "no network at proceed");
            return;
        }
        if (z11 && this.resumeConfirm) {
            showResumeConfirmThenProceed(service, enableWifiAuto);
            return;
        }
        if (z11) {
            proceedDownload(service, false, enableWifiAuto);
        } else if (cellularAllowed) {
            proceedDownload(service, true, enableWifiAuto);
        } else {
            showCellularReminderThenProceed(service, enableWifiAuto);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ready(final boolean canUpdate) {
        if (this.terminated.compareAndSet(false, true)) {
            Log.i(TAG, "[DIAG] terminal " + this.algorithmId + " mode=" + this.mode + " result=READY canUpdate=" + canUpdate);
            cleanup();
            final List<ModelFlowCallback> listDetachAllAndUnregisterKey = detachAllAndUnregisterKey();
            this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.G
                @Override // java.lang.Runnable
                public final void run() {
                    ModelConfirmFlow.ready$lambda$87(listDetachAllAndUnregisterKey, this, canUpdate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ready$lambda$87(List list, ModelConfirmFlow modelConfirmFlow, boolean z10) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ModelFlowCallback modelFlowCallback = (ModelFlowCallback) it.next();
            try {
                Result.Companion companion = Result.INSTANCE;
                modelFlowCallback.onReady(z10);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    private final void registerInternalCallback() {
        Y8.t tVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            IOtaDeepBinderService iOtaDeepBinderService = this.svc;
            if (iOtaDeepBinderService != null) {
                iOtaDeepBinderService.registerDownloadCallback(this.algorithmId, this.internalCb);
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    private final void requestCtaThenContinue(final IOtaDeepBinderService service) {
        Object objB;
        postStage(ModelFlowStage.CTA);
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        perf("CTA_REQUEST_START", "modelId=" + this.algorithmId);
        ICtaResultCallback iCtaResultCallback = new ICtaResultCallback() { // from class: com.stepos.core.ota.confirmui.ModelConfirmFlow$requestCtaThenContinue$cb$1
            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onRecycle() {
                ICtaResultCallback.DefaultImpls.onRecycle(this);
            }

            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onResult(boolean granted) {
                ModelConfirmFlow modelConfirmFlow = this.this$0;
                modelConfirmFlow.perf("CTA_RESULT", "modelId=" + modelConfirmFlow.algorithmId + " dur=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms granted=" + granted);
                String str = this.this$0.algorithmId;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[DIAG] requestCta result ");
                sb2.append(str);
                sb2.append(" granted=");
                sb2.append(granted);
                Log.i("ModelConfirmFlow", sb2.toString());
                Ua.M m10 = this.this$0.scope;
                if (m10 != null) {
                    C1060i.d(m10, Ua.Y.b(), null, new ModelConfirmFlow$requestCtaThenContinue$cb$1$onResult$1(granted, this.this$0, service, null), 2, null);
                }
            }
        };
        this.ctaCallback = iCtaResultCallback;
        try {
            Result.Companion companion = Result.INSTANCE;
            service.requestCta(this.algorithmId, iCtaResultCallback);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            if (message == null) {
                message = "requestCta failed";
            }
            fail(ModelFlowError.SERVICE_UNAVAILABLE, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resumeAfterCta(com.stepos.core.deepbinder.IOtaDeepBinderService r5, boolean r6) {
        /*
            r4 = this;
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lf
            com.stepos.core.ota.confirmui.ModelConfirmFlow$Mode r0 = r4.mode     // Catch: java.lang.Throwable -> Lf
            com.stepos.core.ota.confirmui.ModelConfirmFlow$Mode r1 = com.stepos.core.ota.confirmui.ModelConfirmFlow.Mode.DOWNLOAD     // Catch: java.lang.Throwable -> Lf
            if (r0 != r1) goto L11
            java.lang.String r0 = r4.algorithmId     // Catch: java.lang.Throwable -> Lf
            android.os.Bundle r0 = r5.queryDownloadMeta(r0)     // Catch: java.lang.Throwable -> Lf
            goto L17
        Lf:
            r0 = move-exception
            goto L1c
        L11:
            java.lang.String r0 = r4.algorithmId     // Catch: java.lang.Throwable -> Lf
            android.os.Bundle r0 = r5.queryUpdateMeta(r0)     // Catch: java.lang.Throwable -> Lf
        L17:
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> Lf
            goto L26
        L1c:
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L26:
            boolean r1 = kotlin.Result.g(r0)
            if (r1 == 0) goto L2d
            r0 = 0
        L2d:
            android.os.Bundle r0 = (android.os.Bundle) r0
            if (r0 == 0) goto L39
            java.lang.String r1 = "sizeBytes"
            long r1 = r0.getLong(r1)
            goto L3b
        L39:
            r1 = 0
        L3b:
            r4.pendingSizeBytes = r1
            java.lang.String r1 = r4.displayLabel
            boolean r2 = La.H.x0(r1)
            if (r2 == 0) goto L51
            if (r0 == 0) goto L4f
            java.lang.String r1 = "modelLabel"
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L51
        L4f:
            java.lang.String r1 = r4.algorithmId
        L51:
            r4.pendingLabel = r1
            if (r0 == 0) goto L5e
            java.lang.String r1 = "updateInfo"
            java.lang.String r1 = r0.getString(r1)
            if (r1 != 0) goto L60
        L5e:
            java.lang.String r1 = ""
        L60:
            r4.pendingUpdateInfo = r1
            boolean r1 = r4.resumeConfirm
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L76
            if (r0 == 0) goto L71
            java.lang.String r1 = "cellularAllowed"
            boolean r0 = r0.getBoolean(r1, r3)
            goto L72
        L71:
            r0 = r3
        L72:
            if (r0 == 0) goto L76
            r0 = r2
            goto L77
        L76:
            r0 = r3
        L77:
            if (r6 != 0) goto L7d
            if (r0 == 0) goto L7c
            goto L7d
        L7c:
            r2 = r3
        L7d:
            r4.gateThenDownload(r5, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.confirmui.ModelConfirmFlow.resumeAfterCta(com.stepos.core.deepbinder.IOtaDeepBinderService, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runFlow(IOtaDeepBinderService service) {
        Object objB;
        Object objB2;
        perf("RUNFLOW_ENTER", "modelId=" + this.algorithmId + " mode=" + this.mode);
        Log.i(TAG, "[DIAG] runFlow " + this.algorithmId + " mode=" + this.mode);
        if (service == null) {
            fail(ModelFlowError.SERVICE_UNAVAILABLE, "OTA service unavailable");
            return;
        }
        this.svc = service;
        postStage(ModelFlowStage.CHECKING);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.mode == Mode.DOWNLOAD ? service.queryDownloadMeta(this.algorithmId) : service.queryUpdateMeta(this.algorithmId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            if (message == null) {
                message = "queryMeta failed";
            }
            fail(ModelFlowError.SERVICE_UNAVAILABLE, message);
            return;
        }
        Bundle bundle = (Bundle) objB;
        perf("RUNFLOW_QUERYMETA_DONE", "modelId=" + this.algorithmId + " dur=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        if (bundle.getBoolean("active") && this.attachOnConfirm == null) {
            registerInternalCallback();
            postDownloadingOnce();
            return;
        }
        boolean z10 = bundle.getBoolean("installed");
        if (this.mode == Mode.DOWNLOAD) {
            if (z10) {
                ready(bundle.getBoolean(ModelFlowMeta.KEY_CAN_UPDATE));
                return;
            }
        } else if (!z10) {
            fail(ModelFlowError.MODEL_NOT_INSTALLED, "model not installed");
            return;
        }
        try {
            objB2 = Result.b(Integer.valueOf(service.getDownloadStatus(this.algorithmId)));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = null;
        }
        Integer num = (Integer) objB2;
        if (this.mode != Mode.DOWNLOAD || num == null || num.intValue() != 4) {
            requestCtaThenContinue(service);
            return;
        }
        Log.i(TAG, "[DIAG] runFlow → paused task, switch to resume flow " + this.algorithmId);
        this.isResume = true;
        this.resumeConfirm = true;
        runResumeGate(service, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runPreflight(final IOtaDeepBinderService service) {
        Object objB;
        if (service == null) {
            fail(ModelFlowError.SERVICE_UNAVAILABLE, "OTA service unavailable");
            return;
        }
        this.svc = service;
        postStage(ModelFlowStage.CTA);
        ICtaResultCallback iCtaResultCallback = new ICtaResultCallback() { // from class: com.stepos.core.ota.confirmui.ModelConfirmFlow$runPreflight$cb$1
            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onRecycle() {
                ICtaResultCallback.DefaultImpls.onRecycle(this);
            }

            @Override // com.stepos.core.deepbinder.ICtaResultCallback
            public void onResult(boolean granted) {
                Ua.M m10 = this.this$0.scope;
                if (m10 != null) {
                    C1060i.d(m10, Ua.Y.b(), null, new ModelConfirmFlow$runPreflight$cb$1$onResult$1(granted, this.this$0, service, null), 2, null);
                }
            }
        };
        this.ctaCallback = iCtaResultCallback;
        try {
            Result.Companion companion = Result.INSTANCE;
            service.requestCta(this.algorithmId, iCtaResultCallback);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            if (message == null) {
                message = "requestCta failed";
            }
            fail(ModelFlowError.SERVICE_UNAVAILABLE, message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runPreflightAfterCta(IOtaDeepBinderService service) {
        Object objB;
        Object objB2;
        Object objB3;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(service.queryPrecheckEnv());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Bundle bundle = (Bundle) objB;
        if (bundle != null && bundle.getInt(ModelFlowMeta.KEY_ENV_ERROR, 0) == 5022) {
            Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " model service disabled → gate dialog");
            showResourceGateBlocked(5022);
            return;
        }
        if (bundle != null && bundle.getBoolean(ModelFlowMeta.KEY_HAS_NETWORK, false)) {
            Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " → READY(network)");
            ready(false);
            return;
        }
        try {
            objB2 = Result.b(service.queryDownloadMeta(this.algorithmId));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        Bundle bundle2 = (Bundle) (Result.g(objB2) ? null : objB2);
        if (bundle2 != null && bundle2.getBoolean("installed")) {
            Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " → READY(local installed)");
            ready(false);
            return;
        }
        try {
            objB3 = Result.b(Integer.valueOf(service.queryNoNetworkPromptState(this.algorithmId)));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objB3 = Result.b(C4849c.a(th3));
        }
        Throwable thE = Result.e(objB3);
        if (thE != null) {
            Log.w(TAG, "[DIAG] preflight " + this.algorithmId + " queryNoNetworkPromptState FAILED (回退 PROMPT，可能服务端未更新)", thE);
        }
        if (Result.g(objB3)) {
            objB3 = 0;
        }
        int iIntValue = ((Number) objB3).intValue();
        Log.i(TAG, "[DIAG] preflight " + this.algorithmId + " offline+missing state=" + iIntValue);
        if (iIntValue == 1) {
            fail(4002, "user declined recently");
            return;
        }
        if (iIntValue == 2) {
            fail(ModelFlowError.DOWNLOAD_SCHEDULED, "wifi auto-download pending");
        } else if (iIntValue != 3) {
            showNoNetworkGuide(service);
        } else {
            fail(ModelFlowError.NEED_DOWNLOAD_SUPPRESSED, "prompt suppressed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runResumeGate(final IOtaDeepBinderService service, final boolean cellularPreapproved) {
        Object objB;
        if (service == null) {
            fail(ModelFlowError.SERVICE_UNAVAILABLE, "OTA service unavailable");
            return;
        }
        this.svc = service;
        postStage(ModelFlowStage.CHECKING);
        if (ensureResumable(service)) {
            ICtaResultCallback iCtaResultCallback = new ICtaResultCallback() { // from class: com.stepos.core.ota.confirmui.ModelConfirmFlow$runResumeGate$cb$1
                @Override // com.stepos.core.deepbinder.ICtaResultCallback
                public void onRecycle() {
                    ICtaResultCallback.DefaultImpls.onRecycle(this);
                }

                @Override // com.stepos.core.deepbinder.ICtaResultCallback
                public void onResult(boolean granted) {
                    Log.i("ModelConfirmFlow", "[DIAG] resume requestCta result " + this.this$0.algorithmId + " granted=" + granted);
                    Ua.M m10 = this.this$0.scope;
                    if (m10 != null) {
                        C1060i.d(m10, Ua.Y.b(), null, new ModelConfirmFlow$runResumeGate$cb$1$onResult$1(granted, this.this$0, service, cellularPreapproved, null), 2, null);
                    }
                }
            };
            this.ctaCallback = iCtaResultCallback;
            try {
                Result.Companion companion = Result.INSTANCE;
                service.requestCta(this.algorithmId, iCtaResultCallback);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                String message = thE.getMessage();
                if (message == null) {
                    message = "requestCta failed";
                }
                fail(ModelFlowError.SERVICE_UNAVAILABLE, message);
            }
        }
    }

    private final void showCellularReminderThenProceed(final IOtaDeepBinderService service, final boolean enableWifiAuto) {
        Mode mode = this.mode;
        Mode mode2 = Mode.DOWNLOAD;
        ConfirmDialogParams confirmDialogParamsResumeCellular = mode == mode2 ? this.resumeConfirm ? ConfirmDialogParams.INSTANCE.resumeCellular(this.pendingLabel) : ConfirmDialogParams.INSTANCE.cellularReminderDownload(this.pendingLabel, this.pendingSizeBytes) : ConfirmDialogParams.INSTANCE.cellularReminderUpdate(this.pendingLabel, this.pendingSizeBytes, this.pendingUpdateInfo);
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new ConfirmDecisionBus.DecisionListener() { // from class: com.stepos.core.ota.confirmui.n
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
            public final void onDecision(ConfirmDecisionBus.Decision decision) {
                ModelConfirmFlow.showCellularReminderThenProceed$lambda$67(this.f29603a, service, enableWifiAuto, decision);
            }
        }, new ConfirmDecisionBus.StageListener() { // from class: com.stepos.core.ota.confirmui.o
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
            public final void onStage(ConfirmDecisionBus.SubStage subStage) {
                kotlin.jvm.internal.p.i(subStage, "it");
            }
        });
        this.reqId = strRegister;
        this.lastSubStage = ConfirmDecisionBus.SubStage.CELLULAR_REMINDER;
        postStage(this.mode == mode2 ? ModelFlowStage.DOWNLOAD_CELLULAR_CONFIRM : ModelFlowStage.UPDATE_CELLULAR_CONFIRM);
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost = null;
        }
        confirmUiHost.show(new ConfirmUiRequest(strRegister, confirmDialogParamsResumeCellular, this.perfTraceId, this.perfT0, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ModelConfirmFlow.showCellularReminderThenProceed$lambda$69(this.f29608a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCellularReminderThenProceed$lambda$67(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, boolean z10, ConfirmDecisionBus.Decision d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        if (d10 == ConfirmDecisionBus.Decision.CONFIRM_CELLULAR) {
            modelConfirmFlow.proceedDownload(iOtaDeepBinderService, true, z10);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            iOtaDeepBinderService.endInteractiveSession(modelConfirmFlow.algorithmId);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        modelConfirmFlow.fail(ModelFlowError.USER_CANCELED_CELLULAR, "user declined cellular");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showCellularReminderThenProceed$lambda$69(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(ModelFlowError.CONFIRM_UI_UNAVAILABLE, "cannot show cellular reminder");
        return Y8.t.f7040a;
    }

    private final void showConfirm(IOtaDeepBinderService service, String plan, long sizeBytes, String label, String updateInfo) {
        Object objB;
        Log.i(TAG, "[DIAG] showConfirm " + this.algorithmId + " mode=" + this.mode + " plan=" + plan);
        this.pendingSizeBytes = sizeBytes;
        this.pendingLabel = label;
        this.pendingUpdateInfo = updateInfo;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            Result.Companion companion = Result.INSTANCE;
            service.beginInteractiveSession(this.algorithmId);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            this.sessionBegun.set(true);
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            if (message == null) {
                message = "beginInteractiveSession failed";
            }
            fail(ModelFlowError.SERVICE_UNAVAILABLE, message);
            return;
        }
        perf("BEGIN_SESSION_DONE", "modelId=" + this.algorithmId + " dur=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new ConfirmDecisionBus.DecisionListener() { // from class: com.stepos.core.ota.confirmui.r
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
            public final void onDecision(ConfirmDecisionBus.Decision decision) {
                ModelConfirmFlow.showConfirm$lambda$33(this.f29615a, decision);
            }
        }, new ConfirmDecisionBus.StageListener() { // from class: com.stepos.core.ota.confirmui.s
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
            public final void onStage(ConfirmDecisionBus.SubStage subStage) {
                ModelConfirmFlow.showConfirm$lambda$34(this.f29617a, subStage);
            }
        });
        this.reqId = strRegister;
        postStage(topStageFor(plan));
        String str = this.algorithmId;
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost = null;
        }
        perf("UIHOST_DISPATCH", "modelId=" + str + " host=" + confirmUiHost.getPerfLabel());
        ConfirmUiHost confirmUiHost2 = this.uiHost;
        if (confirmUiHost2 == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost2 = null;
        }
        confirmUiHost2.show(new ConfirmUiRequest(strRegister, new ConfirmDialogParams(plan, sizeBytes, label, updateInfo, this.mode == Mode.DOWNLOAD, this.updateConfirmFirst), this.perfTraceId, this.perfT0, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.t
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ModelConfirmFlow.showConfirm$lambda$35(this.f29619a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirm$lambda$33(ModelConfirmFlow modelConfirmFlow, ConfirmDecisionBus.Decision d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        modelConfirmFlow.onDecision(d10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirm$lambda$34(ModelConfirmFlow modelConfirmFlow, ConfirmDecisionBus.SubStage s10) {
        kotlin.jvm.internal.p.i(s10, "s");
        modelConfirmFlow.onSubStage(s10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showConfirm$lambda$35(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(ModelFlowError.CONFIRM_UI_UNAVAILABLE, "cannot show confirm dialog");
        return Y8.t.f7040a;
    }

    private final void showNoNetworkGuide(final IOtaDeepBinderService service) {
        String str = this.displayLabel;
        if (La.H.x0(str)) {
            str = this.pendingLabel;
            if (La.H.x0(str)) {
                str = this.algorithmId;
            }
        }
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new ConfirmDecisionBus.DecisionListener() { // from class: com.stepos.core.ota.confirmui.B
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
            public final void onDecision(ConfirmDecisionBus.Decision decision) {
                ModelConfirmFlow.showNoNetworkGuide$lambda$51(this.f29527a, service, decision);
            }
        }, new ConfirmDecisionBus.StageListener() { // from class: com.stepos.core.ota.confirmui.C
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
            public final void onStage(ConfirmDecisionBus.SubStage subStage) {
                kotlin.jvm.internal.p.i(subStage, "it");
            }
        });
        this.reqId = strRegister;
        postStage(ModelFlowStage.DOWNLOAD_CONFIRM);
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost = null;
        }
        confirmUiHost.show(new ConfirmUiRequest(strRegister, ConfirmDialogParams.INSTANCE.noNetworkGuide(str), this.perfTraceId, this.perfT0, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ModelConfirmFlow.showNoNetworkGuide$lambda$53(this.f29529a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNoNetworkGuide$lambda$51(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, ConfirmDecisionBus.Decision d10) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(d10, "d");
        if (WhenMappings.$EnumSwitchMapping$0[d10.ordinal()] == 1) {
            try {
                Result.Companion companion = Result.INSTANCE;
                iOtaDeepBinderService.recordNoNetworkDownloadDecision(modelConfirmFlow.algorithmId, true);
                objB2 = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB2);
            if (thE != null) {
                Log.w(TAG, "[DIAG] recordNoNetworkDownloadDecision(true) FAILED " + modelConfirmFlow.algorithmId + "（服务端可能未更新）", thE);
            }
            modelConfirmFlow.fail(ModelFlowError.DOWNLOAD_SCHEDULED, "scheduled wifi auto-download");
            return;
        }
        try {
            Result.Companion companion3 = Result.INSTANCE;
            iOtaDeepBinderService.recordNoNetworkDownloadDecision(modelConfirmFlow.algorithmId, false);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th2));
        }
        Throwable thE2 = Result.e(objB);
        if (thE2 != null) {
            Log.w(TAG, "[DIAG] recordNoNetworkDownloadDecision(false) FAILED " + modelConfirmFlow.algorithmId + "（服务端可能未更新）", thE2);
        }
        modelConfirmFlow.fail(4002, "user declined offline download");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showNoNetworkGuide$lambda$53(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(ModelFlowError.NEED_DOWNLOAD_SUPPRESSED, "cannot show no-network guide");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showResourceGateBlocked(final int errorCode) {
        ConfirmDialogParams confirmDialogParamsLowBattery;
        switch (errorCode) {
            case 5020:
                confirmDialogParamsLowBattery = ConfirmDialogParams.INSTANCE.lowBattery();
                break;
            case 5021:
                confirmDialogParamsLowBattery = ConfirmDialogParams.INSTANCE.insufficientSpace();
                break;
            case 5022:
                confirmDialogParamsLowBattery = ConfirmDialogParams.INSTANCE.serviceDisabled();
                break;
            default:
                Log.w(TAG, "[DIAG] showResourceGateBlocked unknown code=" + errorCode + " → fail without dialog " + this.algorithmId);
                if (errorCode == 0) {
                    errorCode = ModelFlowError.SERVICE_UNAVAILABLE;
                }
                fail(errorCode, "resource gate blocked");
                return;
        }
        ConfirmDialogParams confirmDialogParams = confirmDialogParamsLowBattery;
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new ConfirmDecisionBus.DecisionListener() { // from class: com.stepos.core.ota.confirmui.y
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
            public final void onDecision(ConfirmDecisionBus.Decision decision) {
                ModelConfirmFlow.showResourceGateBlocked$lambda$70(this.f29633a, errorCode, decision);
            }
        }, new ConfirmDecisionBus.StageListener() { // from class: com.stepos.core.ota.confirmui.z
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
            public final void onStage(ConfirmDecisionBus.SubStage subStage) {
                kotlin.jvm.internal.p.i(subStage, "it");
            }
        });
        this.reqId = strRegister;
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost = null;
        }
        Log.i(TAG, "[DIAG] showResourceGateBlocked code=" + errorCode + " → uiHost.show host=" + confirmUiHost.getPerfLabel() + " reqId=" + strRegister);
        ConfirmUiHost confirmUiHost2 = this.uiHost;
        if (confirmUiHost2 == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost2 = null;
        }
        confirmUiHost2.show(new ConfirmUiRequest(strRegister, confirmDialogParams, this.perfTraceId, this.perfT0, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ModelConfirmFlow.showResourceGateBlocked$lambda$72(this.f29525a, errorCode);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showResourceGateBlocked$lambda$70(ModelConfirmFlow modelConfirmFlow, int i10, ConfirmDecisionBus.Decision d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        modelConfirmFlow.fail(modelConfirmFlow.gateFlowCode(i10, d10), "resource gate blocked code=" + i10 + " decision=" + d10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showResourceGateBlocked$lambda$72(ModelConfirmFlow modelConfirmFlow, int i10) {
        modelConfirmFlow.fail(modelConfirmFlow.gateBlockedCode(i10), "cannot show resource gate dialog");
        return Y8.t.f7040a;
    }

    private final void showResumeConfirmThenProceed(final IOtaDeepBinderService service, final boolean enableWifiAuto) {
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new ConfirmDecisionBus.DecisionListener() { // from class: com.stepos.core.ota.confirmui.H
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
            public final void onDecision(ConfirmDecisionBus.Decision decision) {
                ModelConfirmFlow.showResumeConfirmThenProceed$lambda$63(this.f29535a, service, enableWifiAuto, decision);
            }
        }, new ConfirmDecisionBus.StageListener() { // from class: com.stepos.core.ota.confirmui.I
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
            public final void onStage(ConfirmDecisionBus.SubStage subStage) {
                kotlin.jvm.internal.p.i(subStage, "it");
            }
        });
        this.reqId = strRegister;
        postStage(ModelFlowStage.DOWNLOAD_CONFIRM);
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost = null;
        }
        confirmUiHost.show(new ConfirmUiRequest(strRegister, ConfirmDialogParams.INSTANCE.resumeConfirm(this.pendingLabel), this.perfTraceId, this.perfT0, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ModelConfirmFlow.showResumeConfirmThenProceed$lambda$65(this.f29538a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showResumeConfirmThenProceed$lambda$63(ModelConfirmFlow modelConfirmFlow, IOtaDeepBinderService iOtaDeepBinderService, boolean z10, ConfirmDecisionBus.Decision d10) {
        kotlin.jvm.internal.p.i(d10, "d");
        if (d10 == ConfirmDecisionBus.Decision.CONFIRM) {
            modelConfirmFlow.proceedDownload(iOtaDeepBinderService, false, z10);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            iOtaDeepBinderService.endInteractiveSession(modelConfirmFlow.algorithmId);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        modelConfirmFlow.fail(modelConfirmFlow.userCanceledCode(), "user declined resume");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showResumeConfirmThenProceed$lambda$65(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(ModelFlowError.CONFIRM_UI_UNAVAILABLE, "cannot show resume confirm");
        return Y8.t.f7040a;
    }

    private final void showUnavailable(String label) {
        Log.i(TAG, "[DIAG] showUnavailable " + this.algorithmId + " mode=" + this.mode);
        String strRegister = ConfirmDecisionBus.INSTANCE.register(new ConfirmDecisionBus.DecisionListener() { // from class: com.stepos.core.ota.confirmui.u
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
            public final void onDecision(ConfirmDecisionBus.Decision decision) {
                ModelConfirmFlow.showUnavailable$lambda$36(this.f29621a, decision);
            }
        }, new ConfirmDecisionBus.StageListener() { // from class: com.stepos.core.ota.confirmui.w
            @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.StageListener
            public final void onStage(ConfirmDecisionBus.SubStage subStage) {
                kotlin.jvm.internal.p.i(subStage, "it");
            }
        });
        this.reqId = strRegister;
        ConfirmUiHost confirmUiHost = this.uiHost;
        if (confirmUiHost == null) {
            kotlin.jvm.internal.p.A("uiHost");
            confirmUiHost = null;
        }
        confirmUiHost.show(new ConfirmUiRequest(strRegister, ConfirmDialogParams.INSTANCE.unavailable(label), this.perfTraceId, this.perfT0, new InterfaceC5063a() { // from class: com.stepos.core.ota.confirmui.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return ModelConfirmFlow.showUnavailable$lambda$38(this.f29631a);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUnavailable$lambda$36(ModelConfirmFlow modelConfirmFlow, ConfirmDecisionBus.Decision it) {
        kotlin.jvm.internal.p.i(it, "it");
        modelConfirmFlow.fail(ModelFlowError.MODEL_NOT_AVAILABLE, "model not available");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t showUnavailable$lambda$38(ModelConfirmFlow modelConfirmFlow) {
        modelConfirmFlow.fail(ModelFlowError.MODEL_NOT_AVAILABLE, "model not available");
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow start$lambda$3(ModelFlowCallback modelFlowCallback, IDownloadCallback iDownloadCallback, ModelConfirmFlow modelConfirmFlow, Context context, String str, Ua.M m10, String str2, ModelConfirmFlow modelConfirmFlow2) {
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        if (modelConfirmFlow2 != null && !modelConfirmFlow2.isStale() && modelConfirmFlow2.tryAttach(modelFlowCallback, iDownloadCallback)) {
            return modelConfirmFlow2;
        }
        modelConfirmFlow.becomeOwner(context, str, modelFlowCallback, iDownloadCallback, m10);
        return modelConfirmFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow start$lambda$4(p9.p pVar, Object obj, Object obj2) {
        return (ModelConfirmFlow) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t start$lambda$5(ModelConfirmFlow modelConfirmFlow, Throwable th) {
        if (th != null && !modelConfirmFlow.terminated.get()) {
            Log.w(TAG, "[DIAG] runFlow interrupted (" + th + ") before terminal → fail " + modelConfirmFlow.algorithmId);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("flow interrupted: ");
            sb2.append(th);
            modelConfirmFlow.fail(ModelFlowError.SERVICE_UNAVAILABLE, sb2.toString());
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void startResume$default(ModelConfirmFlow modelConfirmFlow, Context context, IOtaDeepBinderService iOtaDeepBinderService, ModelFlowCallback modelFlowCallback, IDownloadCallback iDownloadCallback, Ua.M m10, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 64) != 0) {
            z11 = false;
        }
        if ((i10 & 128) != 0) {
            z12 = false;
        }
        modelConfirmFlow.startResume(context, iOtaDeepBinderService, modelFlowCallback, iDownloadCallback, m10, z10, z11, z12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow startResume$lambda$11(ModelFlowCallback modelFlowCallback, IDownloadCallback iDownloadCallback, ModelConfirmFlow modelConfirmFlow, Context context, String str, Ua.M m10, String str2, ModelConfirmFlow modelConfirmFlow2) {
        kotlin.jvm.internal.p.i(str2, "<unused var>");
        if (modelConfirmFlow2 != null && !modelConfirmFlow2.isStale() && modelConfirmFlow2.tryAttach(modelFlowCallback, iDownloadCallback)) {
            return modelConfirmFlow2;
        }
        modelConfirmFlow.becomeOwner(context, str, modelFlowCallback, iDownloadCallback, m10);
        return modelConfirmFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModelConfirmFlow startResume$lambda$12(p9.p pVar, Object obj, Object obj2) {
        return (ModelConfirmFlow) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t startResume$lambda$13(ModelConfirmFlow modelConfirmFlow, Throwable th) {
        if (th != null && !modelConfirmFlow.terminated.get()) {
            Log.w(TAG, "[DIAG] runResumeGate interrupted (" + th + ") before terminal → fail " + modelConfirmFlow.algorithmId);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("resume flow interrupted: ");
            sb2.append(th);
            modelConfirmFlow.fail(ModelFlowError.SERVICE_UNAVAILABLE, sb2.toString());
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_DL_CONFIRM_THEN_CELLULAR) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        return com.stepos.aiengine.flow.ModelFlowStage.DOWNLOAD_CONFIRM;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_OFF) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004b, code lost:
    
        return com.stepos.aiengine.flow.ModelFlowStage.UPDATE_CELLULAR_CONFIRM;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_DL_CONFIRM_ONLY) == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r1.equals(com.stepos.core.download.ModelFlowMeta.PLAN_UPD_CELLULAR_AUTO_ON) == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.aiengine.flow.ModelFlowStage topStageFor(java.lang.String r1) {
        /*
            r0 = this;
            int r0 = r1.hashCode()
            switch(r0) {
                case -633829314: goto L3e;
                case 521900019: goto L32;
                case 660809078: goto L26;
                case 848119483: goto L1a;
                case 1226479888: goto L11;
                case 2007072834: goto L8;
                default: goto L7;
            }
        L7:
            goto L46
        L8:
            java.lang.String r0 = "DL_CONFIRM_ONLY"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2f
            goto L46
        L11:
            java.lang.String r0 = "UPD_CELLULAR_AUTO_ON"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L49
            goto L46
        L1a:
            java.lang.String r0 = "UPD_WIFI_AUTO_ON"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L23
            goto L46
        L23:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.UPDATE_CONFIRM
            return r0
        L26:
            java.lang.String r0 = "DL_CONFIRM_THEN_CELLULAR"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2f
            goto L46
        L2f:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.DOWNLOAD_CONFIRM
            return r0
        L32:
            java.lang.String r0 = "UPD_WIFI_AUTO_OFF"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L3b
            goto L46
        L3b:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.UPDATE_WIFI_GUIDE
            return r0
        L3e:
            java.lang.String r0 = "UPD_CELLULAR_AUTO_OFF"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L49
        L46:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.DOWNLOAD_CONFIRM
            return r0
        L49:
            com.stepos.aiengine.flow.ModelFlowStage r0 = com.stepos.aiengine.flow.ModelFlowStage.UPDATE_CELLULAR_CONFIRM
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.confirmui.ModelConfirmFlow.topStageFor(java.lang.String):com.stepos.aiengine.flow.ModelFlowStage");
    }

    private final boolean tryAttach(final ModelFlowCallback callback, IDownloadCallback progress) {
        synchronized (this.dedupeLock) {
            if (!this.terminated.get() && this.phase != Phase.DETACHED) {
                this.followers.add(new Follower(callback, progress));
                final ModelFlowStage modelFlowStage = this.lastStage;
                if (modelFlowStage == null) {
                    return true;
                }
                this.main.post(new Runnable() { // from class: com.stepos.core.ota.confirmui.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        ModelConfirmFlow.tryAttach$lambda$10$lambda$9(this.f29595a, callback, modelFlowStage);
                    }
                });
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryAttach$lambda$10$lambda$9(ModelConfirmFlow modelConfirmFlow, ModelFlowCallback modelFlowCallback, ModelFlowStage modelFlowStage) {
        if (modelConfirmFlow.terminated.get()) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            modelFlowCallback.onStateChanged(modelFlowStage);
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int userCanceledCode() {
        if (this.mode == Mode.DOWNLOAD) {
            return 4002;
        }
        return ModelFlowError.USER_CANCELED_UPDATE;
    }

    public final void start(final Context context, IOtaDeepBinderService service, final ModelFlowCallback callback, final IDownloadCallback progress, final Ua.M scope) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.appContext = context.getApplicationContext();
        final String str = this.algorithmId + Const.STR_MART_WELL + this.mode;
        ConcurrentHashMap<String, ModelConfirmFlow> concurrentHashMap = inFlight;
        final p9.p pVar = new p9.p() { // from class: com.stepos.core.ota.confirmui.L
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ModelConfirmFlow.start$lambda$3(callback, progress, this, context, str, scope, (String) obj, (ModelConfirmFlow) obj2);
            }
        };
        if (concurrentHashMap.compute(str, new BiFunction() { // from class: com.stepos.core.ota.confirmui.l
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ModelConfirmFlow.start$lambda$4(pVar, obj, obj2);
            }
        }) == this) {
            C1060i.d(scope, Ua.Y.b(), null, new ModelConfirmFlow$start$job$1(this, service, null), 2, null).J(new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.m
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ModelConfirmFlow.start$lambda$5(this.f29601a, (Throwable) obj);
                }
            });
            return;
        }
        Log.i(TAG, "[DIAG] start " + this.algorithmId + " mode=" + this.mode + " attached to in-flight flow, share result");
    }

    public final void startInferencePreflight(Context context, IOtaDeepBinderService service, ModelFlowCallback callback, Ua.M scope) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.appContext = context.getApplicationContext();
        this.flowCallback = callback;
        this.scope = scope;
        ConfirmUiHost trampolineConfirmHost = this.confirmHost;
        if (trampolineConfirmHost == null) {
            Context context2 = this.appContext;
            if (context2 == null) {
                kotlin.jvm.internal.p.A("appContext");
                context2 = null;
            }
            trampolineConfirmHost = new TrampolineConfirmHost(context2);
        }
        this.uiHost = trampolineConfirmHost;
        C1060i.d(scope, Ua.Y.b(), null, new AnonymousClass1(service, null), 2, null);
    }

    public final void startResume(Context context, IOtaDeepBinderService iOtaDeepBinderService, ModelFlowCallback callback, IDownloadCallback iDownloadCallback, Ua.M scope, boolean z10) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(scope, "scope");
        startResume$default(this, context, iOtaDeepBinderService, callback, iDownloadCallback, scope, z10, false, false, 192, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId) {
        this(algorithmId, mode, perfTraceId, 0L, null, null, null, false, 248, null);
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
    }

    public final void startResume(Context context, IOtaDeepBinderService iOtaDeepBinderService, ModelFlowCallback callback, IDownloadCallback iDownloadCallback, Ua.M scope, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(scope, "scope");
        startResume$default(this, context, iOtaDeepBinderService, callback, iDownloadCallback, scope, z10, z11, false, 128, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10) {
        this(algorithmId, mode, perfTraceId, j10, null, null, null, false, 240, null);
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
    }

    public final void startResume(final Context context, IOtaDeepBinderService service, final ModelFlowCallback callback, final IDownloadCallback progress, final Ua.M scope, boolean isRetry, boolean cellularPreapproved, boolean resumeConfirm) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.appContext = context.getApplicationContext();
        this.isResume = !isRetry;
        this.isRetry = isRetry;
        this.resumeConfirm = resumeConfirm;
        final String str = this.algorithmId + Const.STR_MART_WELL + this.mode + "#resume";
        ConcurrentHashMap<String, ModelConfirmFlow> concurrentHashMap = inFlight;
        final p9.p pVar = new p9.p() { // from class: com.stepos.core.ota.confirmui.v
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ModelConfirmFlow.startResume$lambda$11(callback, progress, this, context, str, scope, (String) obj, (ModelConfirmFlow) obj2);
            }
        };
        if (concurrentHashMap.compute(str, new BiFunction() { // from class: com.stepos.core.ota.confirmui.E
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ModelConfirmFlow.startResume$lambda$12(pVar, obj, obj2);
            }
        }) == this) {
            C1060i.d(scope, Ua.Y.b(), null, new ModelConfirmFlow$startResume$job$1(this, service, cellularPreapproved, null), 2, null).J(new InterfaceC5074l() { // from class: com.stepos.core.ota.confirmui.F
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ModelConfirmFlow.startResume$lambda$13(this.f29531a, (Throwable) obj);
                }
            });
            return;
        }
        Log.i(TAG, "[DIAG] startResume " + this.algorithmId + " mode=" + this.mode + " attached to in-flight resume flow, share result");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel) {
        this(algorithmId, mode, perfTraceId, j10, displayLabel, null, null, false, 224, null);
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.p.i(displayLabel, "displayLabel");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel, ConfirmUiHost confirmUiHost) {
        this(algorithmId, mode, perfTraceId, j10, displayLabel, confirmUiHost, null, false, 192, null);
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.p.i(displayLabel, "displayLabel");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel, ConfirmUiHost confirmUiHost, InterfaceC5063a<Y8.t> interfaceC5063a) {
        this(algorithmId, mode, perfTraceId, j10, displayLabel, confirmUiHost, interfaceC5063a, false, 128, null);
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.p.i(displayLabel, "displayLabel");
    }

    public ModelConfirmFlow(String algorithmId, Mode mode, String perfTraceId, long j10, String displayLabel, ConfirmUiHost confirmUiHost, InterfaceC5063a<Y8.t> interfaceC5063a, boolean z10) {
        kotlin.jvm.internal.p.i(algorithmId, "algorithmId");
        kotlin.jvm.internal.p.i(mode, "mode");
        kotlin.jvm.internal.p.i(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.p.i(displayLabel, "displayLabel");
        this.algorithmId = algorithmId;
        this.mode = mode;
        this.perfTraceId = perfTraceId;
        this.perfT0 = j10;
        this.displayLabel = displayLabel;
        this.confirmHost = confirmUiHost;
        this.attachOnConfirm = interfaceC5063a;
        this.updateConfirmFirst = z10;
        this.main = new Handler(Looper.getMainLooper());
        this.terminated = new AtomicBoolean(false);
        this.downloadingPosted = new AtomicBoolean(false);
        this.sessionBegun = new AtomicBoolean(false);
        this.followers = new ArrayList<>();
        this.dedupeLock = new Object();
        this.startedAtMs = SystemClock.elapsedRealtime();
        this.pendingLabel = "";
        this.pendingUpdateInfo = "";
        this.phase = Phase.INTERACTIVE;
        this.internalCb = new ModelConfirmFlow$internalCb$1(this);
    }

    public /* synthetic */ ModelConfirmFlow(String str, Mode mode, String str2, long j10, String str3, ConfirmUiHost confirmUiHost, InterfaceC5063a interfaceC5063a, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, mode, (i10 & 4) != 0 ? "" : str2, (i10 & 8) != 0 ? 0L : j10, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? null : confirmUiHost, (i10 & 64) != 0 ? null : interfaceC5063a, (i10 & 128) != 0 ? false : z10);
    }
}
