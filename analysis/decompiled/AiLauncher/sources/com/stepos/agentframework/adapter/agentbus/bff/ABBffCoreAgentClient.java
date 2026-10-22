package com.stepos.agentframework.adapter.agentbus.bff;

import La.D;
import La.H;
import La.K;
import Ua.C1060i;
import Ua.I;
import Ua.L0;
import Ua.M;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.Y;
import Z8.Z;
import a4.Message;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.google.protobuf.InvalidProtocolBufferException;
import com.stepos.agentframework.adapter.agentbus.ClawChannel;
import com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding;
import com.stepos.agentframework.adapter.agentbus.G;
import com.stepos.agentframework.adapter.agentbus.N;
import com.stepos.agentframework.adapter.agentbus.bff.r;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.protobuf.Abbff$Role;
import com.stepos.agentframework.protobuf.Abbff$ToolStatus;
import com.stepos.agentframework.protobuf.d;
import com.stepos.agentframework.protobuf.e;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.common.FunctionCall;
import com.stepos.core.ability.AbilityType;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import g9.C4109a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.AbstractC0913i;
import kotlin.AgentDetailRequest;
import kotlin.AskUserConversation;
import kotlin.C0905a;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4849c;
import kotlin.FeedbackRequest;
import kotlin.FolderNode;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.Result;
import kotlin.SyncHistoryRequest;
import kotlin.SyncHistoryResult;
import kotlin.TaskBatchDeleteRequest;
import kotlin.TaskCancelRequest;
import kotlin.TaskDeleteRequest;
import kotlin.TaskInteractRequest;
import kotlin.TaskSyncRemoteRequest;
import kotlin.TranscriptAppendRequest;
import kotlin.TranscriptAppendResult;
import kotlin.UploadFileRequest;
import kotlin.VoteRequest;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import p9.s;
import u6.C5578a;

@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\b\u0018\u0000 \u009f\u00012\u00020\u0001:\b \u0001¡\u0001¢\u0001£\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001c\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\u001e*\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J(\u0010(\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0082@¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010+J#\u0010.\u001a\u00020\t2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,H\u0002¢\u0006\u0004\b.\u0010/J#\u00100\u001a\u00020\t2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,H\u0002¢\u0006\u0004\b0\u0010/J+\u00101\u001a\u00020\t2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b1\u00102J)\u00105\u001a\b\u0012\u0004\u0012\u000204032\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,H\u0002¢\u0006\u0004\b5\u00106J3\u0010;\u001a\u0002042\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000f2\b\b\u0002\u00109\u001a\u00020\u000f2\b\b\u0002\u0010:\u001a\u00020\u000fH\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u000fH\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\t2\u0006\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\bA\u0010BJ1\u0010H\u001a\b\u0012\u0004\u0012\u00020G03*\u00020#2\u0006\u0010D\u001a\u00020C2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bH\u0010IJ7\u0010K\u001a\u00020G*\u00020?2\u0006\u0010D\u001a\u00020C2\u0006\u0010\u001a\u001a\u00020\u000f2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,H\u0002¢\u0006\u0004\bK\u0010LJ7\u0010M\u001a\u00020G*\u00020?2\u0006\u0010D\u001a\u00020C2\u0006\u0010\u001a\u001a\u00020\u000f2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,H\u0002¢\u0006\u0004\bM\u0010LJ7\u0010N\u001a\u00020G*\u00020?2\u0006\u0010D\u001a\u00020C2\u0006\u0010\u001a\u001a\u00020\u000f2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,H\u0002¢\u0006\u0004\bN\u0010LJ\u001b\u0010Q\u001a\u00020P*\u00020?2\u0006\u0010O\u001a\u00020'H\u0002¢\u0006\u0004\bQ\u0010RJ/\u0010U\u001a\u00020G*\u00020#2\u0006\u0010D\u001a\u00020C2\u0006\u0010\u001a\u001a\u00020\u000f2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010SH\u0002¢\u0006\u0004\bU\u0010VJ \u0010W\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0082@¢\u0006\u0004\bW\u0010\u001dJ)\u0010[\u001a\b\u0012\u0004\u0012\u00020Z03*\u00020#2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020'H\u0002¢\u0006\u0004\b[\u0010\\J\u001b\u0010_\u001a\u0004\u0018\u00010^2\b\u0010]\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b_\u0010`J\u001f\u0010d\u001a\b\u0012\u0004\u0012\u00020c032\b\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0004\bd\u0010eJ\u001f\u0010j\u001a\u00020\t2\u0006\u0010g\u001a\u00020f2\u0006\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020'H\u0016¢\u0006\u0004\bl\u0010mJ\"\u0010q\u001a\u0004\u0018\u00010p2\u0006\u0010D\u001a\u00020C2\u0006\u0010o\u001a\u00020nH\u0096@¢\u0006\u0004\bq\u0010rJ\u0012\u0010s\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\bs\u0010\u0006J$\u0010v\u001a\u0004\u0018\u00010\u000f2\u0006\u0010t\u001a\u00020\u000f2\b\u0010u\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0004\bv\u0010\u001dJ\u0018\u0010x\u001a\u00020'2\u0006\u0010w\u001a\u00020\u000fH\u0096@¢\u0006\u0004\bx\u0010yJ \u0010z\u001a\u00020\t2\u0006\u0010w\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000fH\u0096@¢\u0006\u0004\bz\u0010\u001dJ;\u0010\u007f\u001a\u00020'2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010{\u001a\u00020\u000f2\u0006\u0010|\u001a\u00020\u000f2\u0006\u0010}\u001a\u00020\u000f2\b\u0010~\u001a\u0004\u0018\u00010\u000fH\u0096@¢\u0006\u0005\b\u007f\u0010\u0080\u0001J$\u0010\u0081\u0001\u001a\u00020\u000f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0,¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001R \u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R$\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020%0\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R)\u0010\u008c\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\t\u0012\u00070\u008b\u0001R\u00020\u00000\u0088\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008a\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0018\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001d\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001e\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u009c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006¤\u0001"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/o;", "<init>", "()V", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "G0", "(Le9/c;)Ljava/lang/Object;", "", "br", "LY8/t;", "U0", "([B)V", "Lcom/stepos/agentframework/protobuf/e;", "D0", "()Lcom/stepos/agentframework/protobuf/e;", "", "code", "", "Q0", "(Ljava/lang/String;)I", "V0", "([BLe9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/protobuf/g;", "resp", "J0", "(Lcom/stepos/agentframework/protobuf/g;)V", "sessionId", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, SdCardDbCreator.FIELD_LASTLOC_ID, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/protobuf/e$a;", "R0", "()Lcom/stepos/agentframework/protobuf/e$a;", "A0", "(Lcom/stepos/agentframework/protobuf/e$a;)Lcom/stepos/agentframework/protobuf/e$a;", "Lcom/stepos/agentframework/protobuf/f;", "msg", "Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$a;", AbilityType.CHAT, "", "b1", "(Ljava/lang/String;Lcom/stepos/agentframework/protobuf/f;Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$a;Le9/c;)Ljava/lang/Object;", "L0", "(Ljava/lang/String;)V", "", "meta", "O0", "(Ljava/util/Map;)V", "P0", "E0", "(Ljava/util/Map;Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$a;)V", "", "LK6/A;", "Z0", "(Ljava/util/Map;)Ljava/util/List;", "title", "url", "site", "iconUrl", "S0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)LK6/A;", "I0", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/agentframework/protobuf/h;", "tc", "M0", "(Lcom/stepos/agentframework/protobuf/h;)V", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/agentbus/N;", "toolTracker", "LK6/m;", "e1", "(Lcom/stepos/agentframework/protobuf/f;LK6/n;Ljava/lang/String;Lcom/stepos/agentframework/adapter/agentbus/N;)Ljava/util/List;", "metadata", "j1", "(Lcom/stepos/agentframework/protobuf/h;LK6/n;Ljava/lang/String;Ljava/util/Map;)LK6/m;", "i1", "B0", "isResult", "Lcom/stepos/common/FunctionCall;", "f1", "(Lcom/stepos/agentframework/protobuf/h;Z)Lcom/stepos/common/FunctionCall;", "LK6/d;", "askUserConversation", "g1", "(Lcom/stepos/agentframework/protobuf/f;LK6/n;Ljava/lang/String;LK6/d;)LK6/m;", "d1", "text", "finish", "LK6/i;", "C0", "(Lcom/stepos/agentframework/protobuf/f;Ljava/lang/String;Z)Ljava/util/List;", "raw", "LK6/i$f;", "Y0", "(Ljava/lang/String;)LK6/i$f;", "Lorg/json/JSONArray;", "arr", "LK6/t;", "X0", "(Lorg/json/JSONArray;)Ljava/util/List;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/p;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/netcore/n;", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "m", "agent", "deviceId", "Q", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "a0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", ExifInterface.LONGITUDE_WEST, "requestId", "decision", "reason", "askUserQuestion", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "c1", "(Ljava/util/Map;)Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Ljava/util/concurrent/ConcurrentHashMap;", "activeChats", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$SeqReorderBuffer;", "reorderBuffers", "pkgName", "Ljava/lang/String;", "LUa/M;", "scope", "LUa/M;", "LUa/I;", "inboundSerial", "LUa/I;", "Leb/a;", "connectMutex", "Leb/a;", "binding", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "TERMINAL_META_KEYS", "Ljava/util/List;", "", "KNOWN_META_KEYS", "Ljava/util/Set;", "Companion", Const.INTENT_KEY_PKGNAME, "CancelHandle", Const.INTENT_KEY_APIKEY, "SeqReorderBuffer", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ABBffCoreAgentClient implements com.stepos.agentframework.adapter.netcore.o {
    private static final long CONNECT_TIMEOUT_MS = 10000;
    private static final int DELETE_SESSION_ATTEMPTS = 3;
    private static final long DELETE_SESSION_RETRY_DELAY_MS = 400;
    private static final long GAP_TIMEOUT_MS = 100;
    private static final String META_KEY_WEB_SEARCH_RESULT = "web_search_result";
    private static final int RESULT_VALUE_PREVIEW = 300;
    private static final long SEQ_START = 1;
    private static final String TAG = "ABBffCoreAgentClient";
    private final Set<String> KNOWN_META_KEYS;
    private final List<String> TERMINAL_META_KEYS;
    private volatile ClawChannelAgentBusBinding binding;
    private String pkgName;
    private static final Set<String> DOWNLINK_PREVIEW_EXTS = Y.j("md", "txt", "csv", "js", "ts", "py", "java", "go", "css", "json", "pdf", ChatTracker.CONTENT_DOC, "docx", ChatTracker.CONTENT_PPT, "pptx", "xls", "xlsx", "zip", "html", "htm", "png", C5578a.DST_JPG, "jpeg", "gif", "webp", "bmp");
    private final ApiType type = ApiType.AGENTBUS_BFF;
    private final ConcurrentHashMap<String, ActiveChat> activeChats = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, SeqReorderBuffer> reorderBuffers = new ConcurrentHashMap<>();
    private final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Ua.Y.b()));
    private final I inboundSerial = I.t1(Ua.Y.b(), 1, null, 2, null);
    private final InterfaceC4021a connectMutex = eb.f.b(false, 1, null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$CancelHandle;", "Lcom/stepos/agentframework/adapter/netcore/n;", "", "sessionId", "messageId", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient;Ljava/lang/String;Ljava/lang/String;)V", "LY8/t;", Const.INTENT_KEY_UMID, "()V", "reason", "", "cancel", "(Ljava/lang/String;)Z", "isCancelled", "()Z", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "finished", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class CancelHandle implements com.stepos.agentframework.adapter.netcore.n {
        private final AtomicBoolean cancelled;
        private final AtomicBoolean finished;
        private final String messageId;
        private final String sessionId;
        final /* synthetic */ ABBffCoreAgentClient this$0;

        public CancelHandle(ABBffCoreAgentClient aBBffCoreAgentClient, String sessionId, String messageId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(messageId, "messageId");
            this.this$0 = aBBffCoreAgentClient;
            this.sessionId = sessionId;
            this.messageId = messageId;
            this.cancelled = new AtomicBoolean(false);
            this.finished = new AtomicBoolean(false);
        }

        @Override // com.stepos.agentframework.adapter.netcore.n
        public boolean cancel(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            C4148a.k(ABBffCoreAgentClient.TAG, "cancel sessionId=" + this.sessionId + " messageId=" + this.messageId + " reason=" + reason, false, 4, null);
            this.cancelled.set(true);
            this.this$0.activeChats.remove(this.messageId);
            SeqReorderBuffer seqReorderBuffer = (SeqReorderBuffer) this.this$0.reorderBuffers.remove(this.messageId);
            if (seqReorderBuffer != null) {
                seqReorderBuffer.i();
            }
            C1060i.d(this.this$0.scope, null, null, new ABBffCoreAgentClient$CancelHandle$cancel$1(this.this$0, this, null), 3, null);
            return true;
        }

        public final void d() {
            this.finished.set(true);
            this.this$0.activeChats.remove(this.messageId);
            SeqReorderBuffer seqReorderBuffer = (SeqReorderBuffer) this.this$0.reorderBuffers.remove(this.messageId);
            if (seqReorderBuffer != null) {
                seqReorderBuffer.i();
            }
        }

        @Override // com.stepos.agentframework.adapter.netcore.n
        /* renamed from: isCancelled */
        public boolean getCancelled() {
            return this.cancelled.get();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$SeqReorderBuffer;", "", "<init>", "(Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient;)V", "", "sessionId", "Lcom/stepos/agentframework/protobuf/f;", "msg", "Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$a;", AbilityType.CHAT, "LY8/t;", "m", "(Ljava/lang/String;Lcom/stepos/agentframework/protobuf/f;Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$a;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "k", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/protobuf/f;Le9/c;)Ljava/lang/Object;", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "expectedSeq", "J", "Ljava/util/TreeMap;", AuthSessionDto.STATUS_PENDING, "Ljava/util/TreeMap;", "Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$a;", "Ljava/lang/String;", "Lkotlinx/coroutines/g;", "gapTimerJob", "Lkotlinx/coroutines/g;", "gapWaitingSeq", "Ljava/lang/Long;", "", AlipayXuiIsland.REASON_CLOSED, "Z", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class SeqReorderBuffer {
        private ActiveChat chat;
        private boolean closed;
        private kotlinx.coroutines.g gapTimerJob;
        private Long gapWaitingSeq;
        private String sessionId;
        private long expectedSeq = 1;
        private final TreeMap<Long, com.stepos.agentframework.protobuf.f> pending = new TreeMap<>();

        public SeqReorderBuffer() {
        }

        public final void h() {
            kotlinx.coroutines.g gVar = this.gapTimerJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.gapTimerJob = null;
            this.gapWaitingSeq = null;
        }

        public final void i() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            h();
            this.pending.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object j(com.stepos.agentframework.protobuf.f r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$dispatch$1
                if (r0 == 0) goto L13
                r0 = r8
                com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$dispatch$1 r0 = (com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$dispatch$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$dispatch$1 r0 = new com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$dispatch$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3d
                if (r2 != r3) goto L35
                java.lang.Object r7 = r0.L$2
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r7 = r0.L$1
                com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$a r7 = (com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.ActiveChat) r7
                java.lang.Object r7 = r0.L$0
                com.stepos.agentframework.protobuf.f r7 = (com.stepos.agentframework.protobuf.f) r7
                kotlin.C4849c.b(r8)
                goto L67
            L35:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3d:
                kotlin.C4849c.b(r8)
                com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$a r8 = r6.chat
                if (r8 != 0) goto L47
                Y8.t r6 = Y8.t.f7040a
                return r6
            L47:
                java.lang.String r2 = r6.sessionId
                if (r2 != 0) goto L4e
                Y8.t r6 = Y8.t.f7040a
                return r6
            L4e:
                com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient r4 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.this
                r0.L$0 = r7
                java.lang.Object r5 = g9.h.a(r8)
                r0.L$1 = r5
                java.lang.Object r5 = g9.h.a(r2)
                r0.L$2 = r5
                r0.label = r3
                java.lang.Object r8 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.y0(r4, r2, r7, r8, r0)
                if (r8 != r1) goto L67
                return r1
            L67:
                java.util.Map r7 = r7.getMetadataMap()
                java.lang.String r8 = "message_partial"
                java.lang.Object r7 = r7.get(r8)
                java.lang.String r8 = "false"
                boolean r7 = kotlin.jvm.internal.p.d(r7, r8)
                if (r7 == 0) goto L7c
                r6.i()
            L7c:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.j(com.stepos.agentframework.protobuf.f, e9.c):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:23:0x005c). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object k(e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r9 instanceof com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$drainContiguous$1
                if (r0 == 0) goto L13
                r0 = r9
                com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$drainContiguous$1 r0 = (com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$drainContiguous$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$drainContiguous$1 r0 = new com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$SeqReorderBuffer$drainContiguous$1
                r0.<init>(r8, r9)
            L18:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r2 = r0.L$0
                com.stepos.agentframework.protobuf.f r2 = (com.stepos.agentframework.protobuf.f) r2
                kotlin.C4849c.b(r9)
                goto L5c
            L2d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L35:
                kotlin.C4849c.b(r9)
            L38:
                boolean r9 = r8.closed
                if (r9 != 0) goto L6b
                java.util.TreeMap<java.lang.Long, com.stepos.agentframework.protobuf.f> r9 = r8.pending
                long r4 = r8.expectedSeq
                java.lang.Long r2 = g9.C4109a.g(r4)
                java.lang.Object r9 = r9.remove(r2)
                com.stepos.agentframework.protobuf.f r9 = (com.stepos.agentframework.protobuf.f) r9
                if (r9 != 0) goto L4d
                goto L6b
            L4d:
                java.lang.Object r2 = g9.h.a(r9)
                r0.L$0 = r2
                r0.label = r3
                java.lang.Object r9 = r8.j(r9, r0)
                if (r9 != r1) goto L5c
                return r1
            L5c:
                boolean r9 = r8.closed
                if (r9 == 0) goto L63
                Y8.t r8 = Y8.t.f7040a
                return r8
            L63:
                long r4 = r8.expectedSeq
                r6 = 1
                long r4 = r4 + r6
                r8.expectedSeq = r4
                goto L38
            L6b:
                Y8.t r8 = Y8.t.f7040a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.k(e9.c):java.lang.Object");
        }

        public final void l() {
            Long l10;
            long j10 = this.expectedSeq;
            if (this.pending.isEmpty() || this.pending.firstKey().longValue() <= j10) {
                h();
                return;
            }
            kotlinx.coroutines.g gVar = this.gapTimerJob;
            if (gVar == null || !gVar.b() || (l10 = this.gapWaitingSeq) == null || l10.longValue() != j10) {
                kotlinx.coroutines.g gVar2 = this.gapTimerJob;
                if (gVar2 != null) {
                    kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
                }
                this.gapWaitingSeq = Long.valueOf(j10);
                this.gapTimerJob = C1060i.d(ABBffCoreAgentClient.this.scope, ABBffCoreAgentClient.this.inboundSerial, null, new ABBffCoreAgentClient$SeqReorderBuffer$ensureGapTimer$1(this, j10, null), 2, null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c0, code lost:
        
            if (j(r17, r3) == r4) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x011f, code lost:
        
            if (k(r3) == r4) goto L37;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object m(java.lang.String r16, com.stepos.agentframework.protobuf.f r17, com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.ActiveChat r18, e9.InterfaceC4014c<? super Y8.t> r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.SeqReorderBuffer.m(java.lang.String, com.stepos.agentframework.protobuf.f, com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$a, e9.c):java.lang.Object");
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Abbff$ToolStatus.values().length];
            try {
                iArr[Abbff$ToolStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Abbff$ToolStatus.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Abbff$ToolStatus.OK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Abbff$ToolStatus.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Abbff$ToolStatus.CANCELLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ABBffCoreAgentClient() {
        List<String> listP = C1173v.p("stop_reason", "terminal_reason", "duration_ms", "cost_usd", "usage");
        this.TERMINAL_META_KEYS = listP;
        this.KNOWN_META_KEYS = Z.o(Y.j("session_id", "run_id", RequestParameter.META_KEY_MESSAGE_ID, "message_seq", "seq_no", "message_partial", "agent", "reasoning", "code", "error_message", "request_id", "approval", "trace_id", "tools", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "cwd", META_KEY_WEB_SEARCH_RESULT), listP);
    }

    public static final String F0(String str) {
        String string;
        if (str == null || (string = H.D1(str).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        if (r13 == r1) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2 A[Catch: all -> 0x00f2, TryCatch #1 {all -> 0x00f2, blocks: (B:43:0x00ae, B:45:0x00b2, B:47:0x00b8), top: B:82:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0136 A[Catch: all -> 0x003f, TryCatch #4 {all -> 0x003f, blocks: (B:14:0x003a, B:51:0x00cf, B:58:0x00ef, B:69:0x0130, B:71:0x0136, B:72:0x0150, B:75:0x0157, B:68:0x0126, B:57:0x00e6, B:65:0x00fa, B:54:0x00da), top: B:88:0x003a, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G0(e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.G0(e9.c):java.lang.Object");
    }

    public static final t H0(String sessionId, Message message) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(message, "message");
        return t.f7040a;
    }

    public static final t K0(String sessionId, Message message) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(message, "message");
        return t.f7040a;
    }

    public static final CharSequence N0(Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        String str = (String) entry.getKey();
        String str2 = (String) entry.getValue();
        int length = str2.length();
        kotlin.jvm.internal.p.f(str2);
        return str + "(len=" + length + ")='" + K.R1(D.T(str2, "\n", " ", false, 4, null), 300) + "'";
    }

    public static /* synthetic */ ReferenceSource T0(ABBffCoreAgentClient aBBffCoreAgentClient, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        if ((i10 & 8) != 0) {
            str4 = "";
        }
        return aBBffCoreAgentClient.S0(str, str2, str3, str4);
    }

    public static final CharSequence W0(com.stepos.agentframework.protobuf.b bVar) {
        String strG = bVar.g();
        String strH = bVar.h();
        String str = bVar.getMetadataMap().get("file_name");
        String str2 = bVar.getMetadataMap().get("file_status");
        return "[blob=" + strG + " mime=" + strH + " name=" + ((Object) str) + " status=" + ((Object) str2) + " size=" + bVar.i() + "]";
    }

    public static /* synthetic */ C0917m h1(ABBffCoreAgentClient aBBffCoreAgentClient, com.stepos.agentframework.protobuf.f fVar, C0918n c0918n, String str, AskUserConversation askUserConversation, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            askUserConversation = null;
        }
        return aBBffCoreAgentClient.g1(fVar, c0918n, str, askUserConversation);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object A(AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return super.A(agentDetailRequest, interfaceC4014c);
    }

    public final e.a A0(e.a aVar) {
        aVar.a("packageName", this.pkgName);
        aVar.f("agentproxy");
        return aVar;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object B(C0918n c0918n, String str, com.stepos.agentframework.adapter.netcore.h hVar, InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> interfaceC4014c) {
        return super.B(c0918n, str, hVar, interfaceC4014c);
    }

    public final C0917m B0(com.stepos.agentframework.protobuf.h hVar, C0918n c0918n, String str, Map<String, String> map) {
        String agentId = c0918n.getAgentId();
        String secretkey = c0918n.getSecretkey();
        List listM = C1173v.m();
        String id = hVar.getId();
        String id2 = hVar.getId();
        String traceId = c0918n.getTraceId();
        if (traceId == null) {
            traceId = map.get("trace_id");
        }
        String str2 = traceId;
        Map mapC = Q.c();
        String str3 = map.get("run_id");
        if (str3 != null) {
            if (str3.length() <= 0) {
                str3 = null;
            }
            if (str3 != null) {
                mapC.put("run_id", str3);
            }
        }
        return new C0917m(listM, null, str, null, 0, false, Q.b(mapC), 0, null, 0L, 0, 0, false, agentId, secretkey, null, 5, false, null, 0, null, 0, null, null, null, null, null, null, null, id, id2, null, null, null, null, null, null, null, str2, null, null, null, null, null, null, -1610833990, 8127, null);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object C(FeedbackRequest feedbackRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.C(feedbackRequest, interfaceC4014c);
    }

    public final List<AbstractC0913i> C0(com.stepos.agentframework.protobuf.f fVar, String str, boolean z10) {
        List<AbstractC0913i> listE = C1172u.e(new AbstractC0913i.Text(str));
        if (z10) {
            AbstractC0913i.Folder folderY0 = Y0(fVar.getMetadataMap().get("output_dirs"));
            if (folderY0 != null) {
                return F.T0(listE, folderY0);
            }
            if (!fVar.i().isEmpty()) {
                List<com.stepos.agentframework.protobuf.b> listI = fVar.i();
                kotlin.jvm.internal.p.h(listI, "getAttachmentsList(...)");
                ArrayList arrayList = new ArrayList();
                for (com.stepos.agentframework.protobuf.b bVar : listI) {
                    String str2 = bVar.getMetadataMap().get("file_name");
                    String str3 = str2 == null ? "" : str2;
                    String lowerCase = H.q1(str3, '.', "").toLowerCase(Locale.ROOT);
                    kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                    AbstractC0913i.File file = null;
                    if (DOWNLINK_PREVIEW_EXTS.contains(lowerCase)) {
                        String strG = bVar.g();
                        kotlin.jvm.internal.p.f(strG);
                        file = new AbstractC0913i.File(strG.length() > 0 ? strG : null, null, null, str3, Long.valueOf(bVar.i()), bVar.h(), str3, 6, null);
                    }
                    if (file != null) {
                        arrayList.add(file);
                    }
                }
                if (!arrayList.isEmpty()) {
                    return F.S0(listE, arrayList);
                }
            }
        }
        return listE;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ boolean D() {
        return super.D();
    }

    public final com.stepos.agentframework.protobuf.e D0() {
        com.stepos.agentframework.protobuf.e eVarBuild = R0().d("Chat").g(0).build();
        kotlin.jvm.internal.p.f(eVarBuild);
        return eVarBuild;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object E(kotlin.C0918n r29, com.stepos.agentframework.adapter.netcore.h r30, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.E(K6.n, com.stepos.agentframework.adapter.netcore.h, e9.c):java.lang.Object");
    }

    public final void E0(Map<String, String> meta, ActiveChat chat) {
        String str = meta.get(META_KEY_WEB_SEARCH_RESULT);
        if (str == null || H.x0(str)) {
            return;
        }
        String str2 = (String) SequencesKt___SequencesKt.K(SequencesKt___SequencesKt.S(Ka.t.w(meta.get("run_id"), meta.get(RequestParameter.META_KEY_MESSAGE_ID)), new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.bff.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ABBffCoreAgentClient.F0((String) obj);
            }
        }));
        if (str2 == null) {
            C4148a.u(TAG, "web_search_result dropped: 无 run_id/message_id", false, 4, null);
            return;
        }
        List<ReferenceSource> listZ0 = Z0(meta);
        if (listZ0.isEmpty()) {
            C4148a.u(TAG, "web_search_result dropped: 解析后为空 runId=" + K.R1(str2, 32), false, 4, null);
            return;
        }
        L0("   ◀ 📚 onReference runId=" + K.R1(str2, 32) + " size=" + listZ0.size());
        chat.getListener().e(chat.getRequest(), str2, listZ0);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object I(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.I(str, interfaceC4014c);
    }

    public final String I0(String url) {
        Object objB;
        if (!k.INSTANCE.a()) {
            return "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Uri.parse(url).getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str != null) {
            String str2 = H.x0(str) ? null : str;
            if (str2 != null) {
                return "https://" + str2 + "/favicon.ico";
            }
        }
        return "";
    }

    public final void J0(com.stepos.agentframework.protobuf.g resp) throws InvalidProtocolBufferException {
        com.stepos.agentframework.protobuf.c cVarB = com.stepos.agentframework.protobuf.c.b(resp.getBody());
        C4148a.h(TAG, "receive error: " + cVarB.getCode() + ", " + cVarB.getReason(), false, 4, null);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object K(SyncHistoryRequest syncHistoryRequest, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return super.K(syncHistoryRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object L(String str, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.L(str, interfaceC4014c);
    }

    public final void L0(String msg) {
        C4148a.k(TAG, msg, false, 4, null);
    }

    public final void M0(com.stepos.agentframework.protobuf.h tc2) {
        String strA0 = F.A0(tc2.f().entrySet(), ", ", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.bff.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ABBffCoreAgentClient.N0((Map.Entry) obj);
            }
        }, 30, null);
        L0("   ◀ ⚠ tool[" + tc2.getId() + "] status=OK 的 result 未透传给 UI(FunctionCall.content=null): " + strA0);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object N(String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.N(str, str2, str3, interfaceC4014c);
    }

    public final void O0(Map<String, String> meta) {
        if (meta.isEmpty()) {
            return;
        }
        Set<String> setM = Z.m(meta.keySet(), this.KNOWN_META_KEYS);
        if (setM.isEmpty()) {
            return;
        }
        L0("   ◀ ⚠ 新增 metadata key(端侧未解析) keys=" + setM + " allKeys=" + meta.keySet());
        for (String str : setM) {
            String str2 = meta.get(str);
            if (str2 == null) {
                str2 = "";
            }
            L0("   ◀ ⚠ metadata[" + str + "] len=" + str2.length() + " value=" + str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(java.util.Map<java.lang.String, java.lang.String> r12) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.P0(java.util.Map):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object Q(java.lang.String r18, java.lang.String r19, e9.InterfaceC4014c<? super java.lang.String> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.Q(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final int Q0(String code) {
        if (code == null) {
            return -1;
        }
        int iHashCode = code.hashCode();
        if (iHashCode == -1548612125) {
            if (code.equals("offline")) {
                return AgentError.ERROR_CODE_AGENT_OFFLINE;
            }
            return -1;
        }
        if (iHashCode == 979182767) {
            if (code.equals("resource_fail")) {
                return AgentError.ERROR_CODE_RESOURCE_FAIL;
            }
            return -1;
        }
        if (iHashCode == 1822594088 && code.equals("stepai_account_unbound")) {
            return AgentError.ERROR_CODE_STEPAI_ACCOUNT_UNBOUND;
        }
        return -1;
    }

    public final e.a R0() {
        e.a aVarG = com.stepos.agentframework.protobuf.e.g();
        kotlin.jvm.internal.p.f(aVarG);
        A0(aVarG);
        return aVarG;
    }

    public final ReferenceSource S0(String title, String url, String site, String iconUrl) {
        if (iconUrl.length() == 0) {
            iconUrl = I0(url);
        }
        return new ReferenceSource(site, title, url, iconUrl);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object T(String str, String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.T(str, str2, interfaceC4014c);
    }

    public final void U0(byte[] br) {
        C1060i.d(this.scope, this.inboundSerial, null, new ABBffCoreAgentClient$onIncomingMessage$1(this, br, null), 2, null);
    }

    public final Object V0(byte[] bArr, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        SeqReorderBuffer seqReorderBufferPutIfAbsent;
        String str;
        String str2;
        com.stepos.agentframework.protobuf.g gVarF = com.stepos.agentframework.protobuf.g.f(bArr);
        C4148a.h(TAG, "onReceived msgType: " + gVarF.d().getMsgType() + ", command: " + gVarF.d().getCommand(), false, 4, null);
        if (gVarF.d().getMsgType() == 4) {
            kotlin.jvm.internal.p.f(gVarF);
            J0(gVarF);
            return t.f7040a;
        }
        kotlin.jvm.internal.p.f(gVarF);
        if (j.a(gVarF)) {
            com.stepos.agentframework.protobuf.d dVarE = com.stepos.agentframework.protobuf.d.e(gVarF.getBody());
            String command = gVarF.d().getCommand();
            if (kotlin.jvm.internal.p.d(command, AgentProxyCommand.COMMAND_CHAT.getValue())) {
                Map<String, String> metadataMap = dVarE.getMetadataMap();
                String str3 = metadataMap != null ? metadataMap.get(RequestParameter.META_KEY_MESSAGE_ID) : null;
                Map<String, String> metadataMap2 = dVarE.getMetadataMap();
                String str4 = metadataMap2 != null ? metadataMap2.get("code") : null;
                ActiveChat activeChat = str3 != null ? this.activeChats.get(str3) : null;
                if (kotlin.jvm.internal.p.d(str4, "ok")) {
                    if (activeChat != null) {
                        activeChat.getListener().c(activeChat.getRequest(), true, C4109a.f(1), null);
                    }
                    Map<String, String> metadataMap3 = dVarE.getMetadataMap();
                    String str5 = metadataMap3 != null ? metadataMap3.get("session_id") : null;
                    Map<String, String> metadataMap4 = dVarE.getMetadataMap();
                    if (metadataMap4 != null && (str2 = metadataMap4.get("run_id")) != null) {
                        str3 = str2;
                    }
                    Object objA1 = a1(str5, str3, interfaceC4014c);
                    return objA1 == C4063a.g() ? objA1 : t.f7040a;
                }
                Map<String, String> metadataMap5 = dVarE.getMetadataMap();
                if (metadataMap5 == null || (str = metadataMap5.get("error_message")) == null) {
                    str = "Unknown Error";
                }
                int iQ0 = Q0(str4);
                C4148a.h(TAG, "receive chat command failed: messageId=" + str3 + ", code=" + str4 + ", error: " + str, false, 4, null);
                if (activeChat != null) {
                    activeChat.getListener().c(activeChat.getRequest(), false, C4109a.f(iQ0), str);
                    activeChat.getListener().b(activeChat.getRequest(), C4109a.f(iQ0), str);
                    activeChat.getCancelHandle().d();
                }
            } else if (kotlin.jvm.internal.p.d(command, AgentProxyCommand.COMMAND_CHAT_APPROVAL.getValue())) {
                Map<String, String> metadataMap6 = dVarE.getMetadataMap();
                if (kotlin.jvm.internal.p.d(metadataMap6 != null ? metadataMap6.get("code") : null, "ok")) {
                    C4148a.h(TAG, "receive chat approval command ok: ", false, 4, null);
                } else {
                    Map<String, String> metadataMap7 = dVarE.getMetadataMap();
                    C4148a.h(TAG, "receive chat approval command failed: " + (metadataMap7 != null ? metadataMap7.get("error_message") : null), false, 4, null);
                }
            }
        } else if (j.c(gVarF)) {
            com.stepos.agentframework.protobuf.f fVarM = com.stepos.agentframework.protobuf.f.m(gVarF.getBody());
            String str6 = fVarM.getMetadataMap().get("session_id");
            String strJ = fVarM.j();
            ActiveChat activeChat2 = this.activeChats.get(strJ);
            C4148a.j(TAG, "process response message: session id: " + str6 + ", replyTo: " + strJ + ", chat: " + activeChat2, true);
            if (fVarM.h() > 0) {
                String str7 = fVarM.getMetadataMap().get("message_partial");
                int iH = fVarM.h();
                List<com.stepos.agentframework.protobuf.b> listI = fVarM.i();
                kotlin.jvm.internal.p.h(listI, "getAttachmentsList(...)");
                C4148a.k(TAG, "◀ receive attachments raw partial=" + ((Object) str7) + " count=" + iH + ": " + F.A0(listI, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.bff.b
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return ABBffCoreAgentClient.W0((com.stepos.agentframework.protobuf.b) obj);
                    }
                }, 31, null), false, 4, null);
            }
            r rVar = r.INSTANCE;
            Abbff$Role abbff$RoleK = fVarM.k();
            String strName = abbff$RoleK != null ? abbff$RoleK.name() : null;
            String str8 = fVarM.getMetadataMap().get("message_partial");
            String delta = fVarM.getDelta();
            String content = fVarM.getContent();
            List<com.stepos.agentframework.protobuf.h> toolCallsList = fVarM.getToolCallsList();
            kotlin.jvm.internal.p.h(toolCallsList, "getToolCallsList(...)");
            List<com.stepos.agentframework.protobuf.h> list = toolCallsList;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (com.stepos.agentframework.protobuf.h hVar : list) {
                String name = hVar.getName();
                r rVar2 = rVar;
                String id = hVar.getId();
                Map<String, String> mapB = hVar.b();
                arrayList.add(new r.ToolCallDump(name, id, mapB != null ? mapB.toString() : null));
                rVar = rVar2;
            }
            r rVar3 = rVar;
            List<com.stepos.agentframework.protobuf.b> listI2 = fVarM.i();
            kotlin.jvm.internal.p.h(listI2, "getAttachmentsList(...)");
            List<com.stepos.agentframework.protobuf.b> list2 = listI2;
            ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
            for (com.stepos.agentframework.protobuf.b bVar : list2) {
                arrayList2.add(new r.AttachmentDump(bVar.g(), bVar.h(), bVar.getMetadataMap().get("file_name"), bVar.getMetadataMap().get("file_status"), bVar.i()));
            }
            Map<String, String> metadataMap8 = fVarM.getMetadataMap();
            kotlin.jvm.internal.p.h(metadataMap8, "getMetadataMap(...)");
            rVar3.b(str6, strJ, strName, str8, delta, content, arrayList, arrayList2, metadataMap8);
            if (str6 == null || H.x0(str6) || activeChat2 == null) {
                return t.f7040a;
            }
            ConcurrentHashMap<String, SeqReorderBuffer> concurrentHashMap = this.reorderBuffers;
            SeqReorderBuffer seqReorderBuffer = concurrentHashMap.get(strJ);
            if (seqReorderBuffer == null && (seqReorderBufferPutIfAbsent = concurrentHashMap.putIfAbsent(strJ, (seqReorderBuffer = new SeqReorderBuffer()))) != null) {
                seqReorderBuffer = seqReorderBufferPutIfAbsent;
            }
            kotlin.jvm.internal.p.f(fVarM);
            Object objM = seqReorderBuffer.m(str6, fVarM, activeChat2, interfaceC4014c);
            return objM == C4063a.g() ? objM : t.f7040a;
        }
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object W(java.lang.String r13, java.lang.String r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.W(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final List<FolderNode> X0(JSONArray arr) {
        if (arr == null || arr.length() == 0) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = arr.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("name");
                String strOptString2 = jSONObjectOptJSONObject.optString("file_id");
                kotlin.jvm.internal.p.f(strOptString2);
                String str = strOptString2.length() > 0 ? strOptString2 : null;
                if (str != null) {
                    kotlin.jvm.internal.p.f(strOptString);
                    String strOptString3 = jSONObjectOptJSONObject.optString("mime");
                    kotlin.jvm.internal.p.f(strOptString3);
                    String str2 = strOptString3.length() > 0 ? strOptString3 : null;
                    String strOptString4 = jSONObjectOptJSONObject.optString("file_name");
                    kotlin.jvm.internal.p.f(strOptString4);
                    arrayList.add(new FolderNode(strOptString, null, str, str2, strOptString4.length() > 0 ? strOptString4 : null, 2, null));
                } else {
                    kotlin.jvm.internal.p.f(strOptString);
                    arrayList.add(new FolderNode(strOptString, X0(jSONObjectOptJSONObject.optJSONArray("children")), null, null, null, 28, null));
                }
            }
        }
        return arrayList;
    }

    public final AbstractC0913i.Folder Y0(String raw) {
        Object objB;
        AbstractC0913i.Folder folder;
        if (raw == null || H.x0(raw)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(raw);
            List<FolderNode> listX0 = X0(jSONObject.optJSONArray("tree"));
            if (listX0.isEmpty()) {
                folder = null;
            } else {
                String strOptString = jSONObject.optString(Parameters.ROOT);
                kotlin.jvm.internal.p.f(strOptString);
                if (strOptString.length() <= 0) {
                    strOptString = null;
                }
                folder = new AbstractC0913i.Folder(strOptString, listX0);
            }
            objB = Result.b(folder);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "parse output_dirs failed: " + thE.getMessage(), false, 4, null);
        }
        return (AbstractC0913i.Folder) (Result.g(objB) ? null : objB);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object Z(String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.Z(str, str2, interfaceC4014c);
    }

    public final List<ReferenceSource> Z0(Map<String, String> meta) {
        String string;
        Object objB;
        ABBffCoreAgentClient aBBffCoreAgentClient;
        String str = meta.get(META_KEY_WEB_SEARCH_RESULT);
        if (str != null && (string = H.D1(str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (D.X(string, Const.STR_MART_JSON_BEGIN, false, 2, null)) {
                        JSONObject jSONObject = new JSONObject(string);
                        Iterator<String> itKeys = jSONObject.keys();
                        kotlin.jvm.internal.p.h(itKeys, "keys(...)");
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            String strOptString = jSONObject.optString(next);
                            kotlin.jvm.internal.p.h(strOptString, "optString(...)");
                            String string2 = H.D1(strOptString).toString();
                            if (string2.length() > 0) {
                                kotlin.jvm.internal.p.f(next);
                                aBBffCoreAgentClient = this;
                                linkedHashMap.putIfAbsent(string2, T0(aBBffCoreAgentClient, H.D1(next).toString(), string2, null, null, 12, null));
                            } else {
                                aBBffCoreAgentClient = this;
                            }
                            this = aBBffCoreAgentClient;
                        }
                    } else if (D.X(string, "[", false, 2, null)) {
                        JSONArray jSONArray = new JSONArray(string);
                        int length = jSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
                            if (jSONObjectOptJSONObject != null) {
                                String strOptString2 = jSONObjectOptJSONObject.optString("url");
                                kotlin.jvm.internal.p.h(strOptString2, "optString(...)");
                                String string3 = H.D1(strOptString2).toString();
                                if (string3.length() != 0) {
                                    String strOptString3 = jSONObjectOptJSONObject.optString("title");
                                    kotlin.jvm.internal.p.h(strOptString3, "optString(...)");
                                    String string4 = H.D1(strOptString3).toString();
                                    String strOptString4 = jSONObjectOptJSONObject.optString("site");
                                    kotlin.jvm.internal.p.h(strOptString4, "optString(...)");
                                    String string5 = H.D1(strOptString4).toString();
                                    String strOptString5 = jSONObjectOptJSONObject.optString("icon_url");
                                    kotlin.jvm.internal.p.h(strOptString5, "optString(...)");
                                    linkedHashMap.putIfAbsent(string3, S0(string4, string3, string5, H.D1(strOptString5).toString()));
                                }
                            }
                        }
                    }
                    objB = Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.u(TAG, "web_search_result parse failed: " + thE.getMessage(), false, 4, null);
                }
                Collection collectionValues = linkedHashMap.values();
                kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
                return F.m1(collectionValues);
            }
        }
        return C1173v.m();
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object a(TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.a(taskInteractRequest, interfaceC4014c);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:(1:122)|44|120|45|(1:47)(1:50)|51|54|(1:56)|57|(1:59)|60|61|131|62|63|128|64|(2:77|78)(2:68|(3:76|113|(2:116|117)(1:(3:29|(3:32|33|35)|37)(2:34|35)))(2:72|73))) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:122|44|120|45|(1:47)(1:50)|51|54|(1:56)|57|(1:59)|60|61|131|62|63|128|64|(2:77|78)(2:68|(3:76|113|(2:116|117)(1:(3:29|(3:32|33|35)|37)(2:34|35)))(2:72|73))) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:124|13|14)|118|38|(1:40)|41|42|(18:122|44|120|45|(1:47)(1:50)|51|54|(1:56)|57|(1:59)|60|61|131|62|63|128|64|(2:77|78)(2:68|(3:76|113|(2:116|117)(1:(3:29|(3:32|33|35)|37)(2:34|35)))(2:72|73)))(11:83|129|84|(4:89|(1:91)(1:92)|93|94)|(1:96)(1:97)|(1:99)(1:101)|102|103|126|104|105)) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0242, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0243, code lost:
    
        r17 = r8;
        r4 = 4;
        r8 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0118, code lost:
    
        if (r0 == r2) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0143, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x014b, code lost:
    
        r16 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.b(kotlin.C4849c.a(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x019d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019e, code lost:
    
        r20 = r0;
        r4 = 4;
        r17 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01af, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01b0, code lost:
    
        r8 = r27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0118 -> B:118:0x011b). Please report as a decompilation issue!!! */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a0(java.lang.String r26, e9.InterfaceC4014c<? super java.lang.Boolean> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 651
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.a0(java.lang.String, e9.c):java.lang.Object");
    }

    public final Object a1(String str, String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        ClawChannelAgentBusBinding.BffApi bff;
        C4148a.k(TAG, "call receive: session=" + str + " run=" + str2, false, 4, null);
        com.stepos.agentframework.protobuf.e eVarBuild = R0().d("Receive").build();
        d.a aVarA = com.stepos.agentframework.protobuf.d.d().a("session_id", str);
        if (str2 != null) {
            if (H.x0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                aVarA.a("run_id", str2);
            }
        }
        byte[] byteArray = com.stepos.agentframework.protobuf.g.e().d(eVarBuild).a(aVarA.build().toByteString()).build().toByteArray();
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.binding;
        if (clawChannelAgentBusBinding == null || (bff = clawChannelAgentBusBinding.getBff()) == null) {
            return t.f7040a;
        }
        kotlin.jvm.internal.p.f(byteArray);
        Object objE = ClawChannelAgentBusBinding.BffApi.e(bff, byteArray, 0L, interfaceC4014c, 2, null);
        return objE == C4063a.g() ? objE : t.f7040a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object b(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.b(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void b0(boolean z10) {
        super.b0(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b1(java.lang.String r18, com.stepos.agentframework.protobuf.f r19, com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.ActiveChat r20, e9.InterfaceC4014c<? super java.lang.Boolean> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.b1(java.lang.String, com.stepos.agentframework.protobuf.f, com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$a, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x01d9, code lost:
    
        if (r1 == r3) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, e9.InterfaceC4014c<? super java.lang.Boolean> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.c(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final String c1(Map<String, String> meta) {
        kotlin.jvm.internal.p.i(meta, "meta");
        ArrayList arrayList = new ArrayList();
        for (String str : this.TERMINAL_META_KEYS) {
            String str2 = meta.get(str);
            if (str2 != null) {
                arrayList.add(str + "=" + str2);
            }
        }
        String str3 = meta.get("error_message");
        if (str3 != null) {
            arrayList.add("error='" + str3 + "'");
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        return "  " + F.A0(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object d(TranscriptAppendRequest transcriptAppendRequest, InterfaceC4014c<? super TranscriptAppendResult> interfaceC4014c) {
        return super.d(transcriptAppendRequest, interfaceC4014c);
    }

    public final Object d1(String str, String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        ClawChannelAgentBusBinding.BffApi bff;
        C4148a.k(TAG, "request cancel: " + str + ", " + str2, false, 4, null);
        byte[] byteArray = com.stepos.agentframework.protobuf.g.e().d(R0().d("ChatCancel").build()).a(com.stepos.agentframework.protobuf.d.d().a("session_id", str).a("run_id", str2).build().toByteString()).build().toByteArray();
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.binding;
        if (clawChannelAgentBusBinding == null || (bff = clawChannelAgentBusBinding.getBff()) == null) {
            return t.f7040a;
        }
        kotlin.jvm.internal.p.f(byteArray);
        Object objE = ClawChannelAgentBusBinding.BffApi.e(bff, byteArray, 0L, interfaceC4014c, 2, null);
        return objE == C4063a.g() ? objE : t.f7040a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object e(TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.e(taskCancelRequest, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<kotlin.C0917m> e1(com.stepos.agentframework.protobuf.f r10, kotlin.C0918n r11, java.lang.String r12, com.stepos.agentframework.adapter.agentbus.N r13) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.stepos.agentframework.protobuf.Abbff$Role r1 = r10.k()
            com.stepos.agentframework.protobuf.Abbff$Role r2 = com.stepos.agentframework.protobuf.Abbff$Role.ASSISTANT
            if (r1 != r2) goto L3d
            java.util.Map r1 = r10.getMetadataMap()
            java.lang.String r2 = "reasoning"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r2 = "true"
            boolean r1 = kotlin.jvm.internal.p.d(r1, r2)
            if (r1 != 0) goto L3d
            java.lang.String r1 = r10.getDelta()
            java.lang.String r2 = "getDelta(...)"
            kotlin.jvm.internal.p.h(r1, r2)
            int r1 = r1.length()
            if (r1 <= 0) goto L3d
            r7 = 4
            r8 = 0
            r6 = 0
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            K6.m r9 = h1(r2, r3, r4, r5, r6, r7, r8)
            r0.add(r9)
            goto L41
        L3d:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
        L41:
            java.util.List r9 = r3.getToolCallsList()
            java.lang.String r10 = "getToolCallsList(...)"
            kotlin.jvm.internal.p.h(r9, r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L50:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Ldd
            java.lang.Object r10 = r9.next()
            com.stepos.agentframework.protobuf.h r10 = (com.stepos.agentframework.protobuf.h) r10
            com.stepos.agentframework.protobuf.Abbff$ToolStatus r11 = r10.g()
            if (r11 != 0) goto L64
            r11 = -1
            goto L6c
        L64:
            int[] r12 = com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.c.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r12[r11]
        L6c:
            r12 = 1
            java.lang.String r1 = "getMetadataMap(...)"
            java.lang.String r6 = "getId(...)"
            if (r11 == r12) goto Lbd
            r12 = 2
            if (r11 == r12) goto Lbd
            r12 = 3
            if (r11 == r12) goto L80
            r12 = 4
            if (r11 == r12) goto L80
            r12 = 5
            if (r11 == r12) goto L80
            goto L50
        L80:
            java.lang.String r11 = r10.getId()
            kotlin.jvm.internal.p.h(r11, r6)
            boolean r11 = r13.c(r11)
            if (r11 == 0) goto L9e
            kotlin.jvm.internal.p.f(r10)
            java.util.Map r11 = r3.getMetadataMap()
            kotlin.jvm.internal.p.h(r11, r1)
            K6.m r11 = r2.j1(r10, r4, r5, r11)
            r0.add(r11)
        L9e:
            java.lang.String r11 = r10.getId()
            kotlin.jvm.internal.p.h(r11, r6)
            boolean r11 = r13.b(r11)
            if (r11 == 0) goto L50
            kotlin.jvm.internal.p.f(r10)
            java.util.Map r11 = r3.getMetadataMap()
            kotlin.jvm.internal.p.h(r11, r1)
            K6.m r10 = r2.i1(r10, r4, r5, r11)
            r0.add(r10)
            goto L50
        Lbd:
            java.lang.String r11 = r10.getId()
            kotlin.jvm.internal.p.h(r11, r6)
            boolean r11 = r13.c(r11)
            if (r11 == 0) goto L50
            kotlin.jvm.internal.p.f(r10)
            java.util.Map r11 = r3.getMetadataMap()
            kotlin.jvm.internal.p.h(r11, r1)
            K6.m r10 = r2.j1(r10, r4, r5, r11)
            r0.add(r10)
            goto L50
        Ldd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.e1(com.stepos.agentframework.protobuf.f, K6.n, java.lang.String, com.stepos.agentframework.adapter.agentbus.N):java.util.List");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object f(TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.f(taskDeleteRequest, interfaceC4014c);
    }

    public final FunctionCall f1(com.stepos.agentframework.protobuf.h hVar, boolean z10) {
        String errorMessage;
        String str = (!z10 || hVar.g() == Abbff$ToolStatus.OK || (errorMessage = hVar.getErrorMessage()) == null || errorMessage.length() <= 0) ? null : errorMessage;
        if (z10 && hVar.g() == Abbff$ToolStatus.OK) {
            Map<String, String> mapF = hVar.f();
            kotlin.jvm.internal.p.h(mapF, "getResultMap(...)");
            if (!mapF.isEmpty()) {
                M0(hVar);
            }
        }
        String displayName = hVar.getDisplayName();
        kotlin.jvm.internal.p.f(displayName);
        return new FunctionCall(null, hVar.getName(), hVar.c(), hVar.getName(), null, null, null, null, null, null, hVar.getId(), str, false, !H.x0(displayName) ? displayName : null, 5105, null);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object g(TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.g(taskBatchDeleteRequest, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.C0917m g1(com.stepos.agentframework.protobuf.f r57, kotlin.C0918n r58, java.lang.String r59, kotlin.AskUserConversation r60) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient.g1(com.stepos.agentframework.protobuf.f, K6.n, java.lang.String, K6.d):K6.m");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public ApiType getType() {
        return this.type;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public boolean h() {
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.binding;
        return clawChannelAgentBusBinding != null && clawChannelAgentBusBinding.C();
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object i(InterfaceC4014c<? super String> interfaceC4014c) {
        return super.i(interfaceC4014c);
    }

    public final C0917m i1(com.stepos.agentframework.protobuf.h hVar, C0918n c0918n, String str, Map<String, String> map) {
        C0917m c0917mB0 = B0(hVar, c0918n, str, map);
        c0917mB0.O(0);
        c0917mB0.L("tool_response");
        c0917mB0.R(f1(hVar, true));
        return c0917mB0;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object j(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.j(str, interfaceC4014c);
    }

    public final C0917m j1(com.stepos.agentframework.protobuf.h hVar, C0918n c0918n, String str, Map<String, String> map) {
        C0917m c0917mB0 = B0(hVar, c0918n, str, map);
        c0917mB0.O(0);
        c0917mB0.L("function_call");
        c0917mB0.R(f1(hVar, false));
        return c0917mB0;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object k(String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return super.k(str, str2, list, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object l(TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.l(taskSyncRemoteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object m(InterfaceC4014c<? super String> interfaceC4014c) {
        return null;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void n(B b10) {
        super.n(b10);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object o(Context context, UploadFileRequest uploadFileRequest, s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, t> sVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.o(context, uploadFileRequest, sVar, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void r(Context context, com.stepos.agentframework.adapter.netcore.p log) {
        ClawChannelAgentBusBinding.BffApi bff;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(log, "log");
        this.pkgName = context.getPackageName();
        ClawChannel clawChannel = new ClawChannel(new p9.p() { // from class: com.stepos.agentframework.adapter.agentbus.bff.e
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ABBffCoreAgentClient.K0((String) obj, (Message) obj2);
            }
        });
        String str = this.pkgName;
        if (str == null) {
            str = "agentframework";
        }
        this.binding = G.b(clawChannel, context, str);
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = this.binding;
        if (clawChannelAgentBusBinding != null && (bff = clawChannelAgentBusBinding.getBff()) != null) {
            bff.b(new ABBffCoreAgentClient$init$2(this, null));
        }
        ClawChannelAgentBusBinding clawChannelAgentBusBinding2 = this.binding;
        if (clawChannelAgentBusBinding2 != null) {
            clawChannelAgentBusBinding2.Q();
        }
        C1060i.d(this.scope, null, null, new ABBffCoreAgentClient$init$3(this, null), 3, null);
        C4148a.k(TAG, "initialized", false, 4, null);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object u(VoteRequest voteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.u(voteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void y(B b10) {
        super.y(b10);
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0082\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\u0010\n\u001a\u00060\bR\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010\n\u001a\u00060\bR\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010-R\u001f\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010.\u001a\u0004\b/\u00100R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00101\u001a\u0004\b2\u00103¨\u00064"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$a;", "", "", "messageId", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$CancelHandle;", "Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient;", "cancelHandle", "Lcom/stepos/agentframework/adapter/agentbus/N;", "toolEmitTracker", "outboundId", "Ljava/util/concurrent/atomic/AtomicReference;", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "Ljava/util/concurrent/atomic/AtomicBoolean;", "finished", "<init>", "(Ljava/lang/String;LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$CancelHandle;Lcom/stepos/agentframework/adapter/agentbus/N;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessageId", "LK6/n;", "c", "()LK6/n;", "Lcom/stepos/agentframework/adapter/netcore/h;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/netcore/h;", "Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$CancelHandle;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/agentbus/bff/ABBffCoreAgentClient$CancelHandle;", "Lcom/stepos/agentframework/adapter/agentbus/N;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/adapter/agentbus/N;", "getOutboundId", "setOutboundId", "(Ljava/lang/String;)V", "Ljava/util/concurrent/atomic/AtomicReference;", "getRunId", "()Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getFinished", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient$a, reason: from toString */
    public static final /* data */ class ActiveChat {
        private final CancelHandle cancelHandle;
        private final AtomicBoolean finished;
        private final com.stepos.agentframework.adapter.netcore.h listener;
        private final String messageId;
        private String outboundId;
        private final C0918n request;
        private final AtomicReference<String> runId;
        private final N toolEmitTracker;

        public ActiveChat(String messageId, C0918n request, com.stepos.agentframework.adapter.netcore.h listener, CancelHandle cancelHandle, N toolEmitTracker, String str, AtomicReference<String> runId, AtomicBoolean finished) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            kotlin.jvm.internal.p.i(request, "request");
            kotlin.jvm.internal.p.i(listener, "listener");
            kotlin.jvm.internal.p.i(cancelHandle, "cancelHandle");
            kotlin.jvm.internal.p.i(toolEmitTracker, "toolEmitTracker");
            kotlin.jvm.internal.p.i(runId, "runId");
            kotlin.jvm.internal.p.i(finished, "finished");
            this.messageId = messageId;
            this.request = request;
            this.listener = listener;
            this.cancelHandle = cancelHandle;
            this.toolEmitTracker = toolEmitTracker;
            this.outboundId = str;
            this.runId = runId;
            this.finished = finished;
        }

        /* renamed from: a, reason: from getter */
        public final CancelHandle getCancelHandle() {
            return this.cancelHandle;
        }

        /* renamed from: b, reason: from getter */
        public final com.stepos.agentframework.adapter.netcore.h getListener() {
            return this.listener;
        }

        /* renamed from: c, reason: from getter */
        public final C0918n getRequest() {
            return this.request;
        }

        /* renamed from: d, reason: from getter */
        public final N getToolEmitTracker() {
            return this.toolEmitTracker;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActiveChat)) {
                return false;
            }
            ActiveChat activeChat = (ActiveChat) other;
            return kotlin.jvm.internal.p.d(this.messageId, activeChat.messageId) && kotlin.jvm.internal.p.d(this.request, activeChat.request) && kotlin.jvm.internal.p.d(this.listener, activeChat.listener) && kotlin.jvm.internal.p.d(this.cancelHandle, activeChat.cancelHandle) && kotlin.jvm.internal.p.d(this.toolEmitTracker, activeChat.toolEmitTracker) && kotlin.jvm.internal.p.d(this.outboundId, activeChat.outboundId) && kotlin.jvm.internal.p.d(this.runId, activeChat.runId) && kotlin.jvm.internal.p.d(this.finished, activeChat.finished);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.messageId.hashCode() * 31) + this.request.hashCode()) * 31) + this.listener.hashCode()) * 31) + this.cancelHandle.hashCode()) * 31) + this.toolEmitTracker.hashCode()) * 31;
            String str = this.outboundId;
            return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.runId.hashCode()) * 31) + this.finished.hashCode();
        }

        public String toString() {
            return "ActiveChat(messageId=" + this.messageId + ", request=" + this.request + ", listener=" + this.listener + ", cancelHandle=" + this.cancelHandle + ", toolEmitTracker=" + this.toolEmitTracker + ", outboundId=" + this.outboundId + ", runId=" + this.runId + ", finished=" + this.finished + ")";
        }

        public /* synthetic */ ActiveChat(String str, C0918n c0918n, com.stepos.agentframework.adapter.netcore.h hVar, CancelHandle cancelHandle, N n10, String str2, AtomicReference atomicReference, AtomicBoolean atomicBoolean, int i10, kotlin.jvm.internal.i iVar) {
            this(str, c0918n, hVar, cancelHandle, (i10 & 16) != 0 ? new N() : n10, (i10 & 32) != 0 ? null : str2, (i10 & 64) != 0 ? new AtomicReference(null) : atomicReference, (i10 & 128) != 0 ? new AtomicBoolean(false) : atomicBoolean);
        }
    }
}
