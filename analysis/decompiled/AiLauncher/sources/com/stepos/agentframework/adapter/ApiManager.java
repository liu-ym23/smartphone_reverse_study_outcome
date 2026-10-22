package com.stepos.agentframework.adapter;

import La.H;
import Ua.C1056g;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1173v;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient;
import com.stepos.agentframework.adapter.agentbus.bff.ABBffCoreAgentClient;
import com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient;
import com.stepos.agentframework.adapter.bff.BffCoreAgentClient;
import com.stepos.agentframework.adapter.coze.CozeCoreAgentClient;
import com.stepos.agentframework.adapter.dify.DifyCoreAgentClient;
import com.stepos.agentframework.adapter.error.AdapterException;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.FileStorageConfig;
import com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper;
import com.stepos.agentframework.adapter.netcore.h;
import com.stepos.agentframework.adapter.netcore.i;
import com.stepos.agentframework.adapter.netcore.n;
import com.stepos.agentframework.adapter.netcore.o;
import com.stepos.agentframework.adapter.netcore.s;
import com.stepos.agentframework.adapter.netcore.y;
import com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.net.HttpConfig;
import com.stepos.net.HttpManager;
import com.stepos.net.exception.ApiException;
import com.stepos.net.token.TokenProvider;
import e8.UploadConfig;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import eb.f;
import h8.C4148a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C0918n;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TaskBatchDeleteRequest;
import kotlin.TaskCancelRequest;
import kotlin.TaskDeleteRequest;
import kotlin.TaskInteractRequest;
import kotlin.TaskSyncRemoteRequest;
import kotlin.UploadFileRequest;
import kotlin.VoteRequest;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import m4.AbstractC4898a;
import n4.AbstractC4939a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014JD\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00122\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"J\u001f\u0010'\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\f2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b)\u0010(J+\u0010*\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u0010\u0003J\u0017\u00100\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u0010-JS\u0010:\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u00020\u00062\b\b\u0002\u00104\u001a\u0002032\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\n\b\u0002\u00108\u001a\u0004\u0018\u0001072\b\b\u0002\u00109\u001a\u00020\u0012¢\u0006\u0004\b:\u0010;J\u001b\u0010=\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b=\u0010>J)\u0010@\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\b2\b\b\u0002\u00104\u001a\u000203H\u0007¢\u0006\u0004\b@\u0010AJ!\u0010B\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u000203H\u0007¢\u0006\u0004\bB\u0010CJ*\u0010E\u001a\u0004\u0018\u00010D2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0086@¢\u0006\u0004\bE\u0010FJ2\u0010H\u001a\u0004\u0018\u00010D2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010G\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%H\u0086@¢\u0006\u0004\bH\u0010IJ\u0015\u0010L\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\u000f2\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bP\u0010QJ)\u0010S\u001a\u00020\u000f2\u001a\u0010R\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017¢\u0006\u0004\bS\u0010TJ'\u0010X\u001a\u0004\u0018\u00010D2\u0006\u0010U\u001a\u00020\u00122\u0006\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020%¢\u0006\u0004\bX\u0010YJ\u0015\u0010Z\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u0012¢\u0006\u0004\bZ\u0010[J\u001d\u0010]\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\\¢\u0006\u0004\b]\u0010^J\u001d\u0010_\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\\¢\u0006\u0004\b_\u0010`J \u0010c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010b\u001a\u00020aH\u0086@¢\u0006\u0004\bc\u0010dJ<\u0010i\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010b\u001a\u00020e2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020\u000f0fH\u0086@¢\u0006\u0004\bi\u0010jJ4\u0010n\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\u00122\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\bn\u0010oJ \u0010r\u001a\u00020q2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010b\u001a\u00020pH\u0086@¢\u0006\u0004\br\u0010sJ \u0010u\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010b\u001a\u00020tH\u0086@¢\u0006\u0004\bu\u0010vJF\u0010{\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00122\b\b\u0002\u0010y\u001a\u00020\u00122\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\b{\u0010|J\u0016\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@¢\u0006\u0004\b}\u0010\u0014J\r\u0010~\u001a\u00020\u000f¢\u0006\u0004\b~\u0010\u0003J#\u0010\u0080\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u007fH\u0086@¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J$\u0010\u0083\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010b\u001a\u00030\u0082\u0001H\u0086@¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J$\u0010\u0086\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010b\u001a\u00030\u0085\u0001H\u0086@¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J$\u0010\u0089\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010b\u001a\u00030\u0088\u0001H\u0086@¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J<\u0010\u008e\u0001\u001a\u00030\u008d\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00122\u0007\u0010\u008b\u0001\u001a\u00020\u00122\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0086@¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J$\u0010\u0091\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010b\u001a\u00030\u0090\u0001H\u0086@¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J%\u0010\u0095\u0001\u001a\u00030\u0094\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0018\u0010\u0097\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J$\u0010\u0099\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b\u0099\u0001\u0010\u0096\u0001J$\u0010\u009a\u0001\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b\u009a\u0001\u0010\u0096\u0001J$\u0010\u009b\u0001\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b\u009b\u0001\u0010\u0096\u0001J-\u0010\u009d\u0001\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020\u00122\u0007\u0010\u009c\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001d\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0086@¢\u0006\u0006\b\u009f\u0001\u0010 \u0001J&\u0010¢\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010¡\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b¢\u0001\u0010\u0096\u0001J&\u0010£\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010¡\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b£\u0001\u0010\u0096\u0001J2\u0010¥\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010¤\u0001\u001a\u00020\u00122\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0006\b¥\u0001\u0010\u009e\u0001J&\u0010§\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010¦\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b§\u0001\u0010\u0096\u0001J-\u0010©\u0001\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010¦\u0001\u001a\u00020\u00122\u0007\u0010¨\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b©\u0001\u0010\u009e\u0001J\u0018\u0010ª\u0001\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0006\bª\u0001\u0010«\u0001J\u001d\u0010¬\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0004H\u0086@¢\u0006\u0006\b¬\u0001\u0010 \u0001J&\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010¡\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b\u00ad\u0001\u0010\u0096\u0001J%\u0010°\u0001\u001a\u00030¯\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0007\u0010b\u001a\u00030®\u0001H\u0086@¢\u0006\u0006\b°\u0001\u0010±\u0001R\u0017\u0010²\u0001\u001a\u00020\u00128\u0002X\u0082T¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0017\u0010´\u0001\u001a\u00020\u00068\u0002X\u0082T¢\u0006\b\n\u0006\b´\u0001\u0010¬\u0001R$\u0010¶\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R%\u0010º\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020J0¹\u00010¸\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001c\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\"\u0010¿\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001c\u0018\u00010¹\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u0018\u0010Á\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÁ\u0001\u0010\u0010R\u0018\u0010Ã\u0001\u001a\u00030Â\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0018\u0010Æ\u0001\u001a\u00030Å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u0018\u0010È\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÈ\u0001\u0010\u0010R\u001f\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0019\u0010Ë\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010¬\u0001R\u0019\u0010Ì\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010¬\u0001R\u001d\u0010Î\u0001\u001a\u00030Í\u00018\u0006¢\u0006\u0010\n\u0006\bÎ\u0001\u0010Ï\u0001\u001a\u0006\bÐ\u0001\u0010Ñ\u0001¨\u0006Ò\u0001"}, d2 = {"Lcom/stepos/agentframework/adapter/ApiManager;", "", "<init>", "()V", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "apiType", "", "timeout", "Lcom/stepos/agentframework/adapter/netcore/o;", "z", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;J)Lcom/stepos/agentframework/adapter/netcore/o;", "nowMs", "", ExifInterface.GPS_DIRECTION_TRUE, "(J)Z", "LY8/t;", "Z", "", "", "a0", "(Le9/c;)Ljava/lang/Object;", "type", "op", "Lkotlin/Function2;", "Le9/c;", "block", "R", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;Lp9/p;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "m0", "(Landroid/content/Context;)V", "isAvailable", ExifInterface.LONGITUDE_WEST, "(Z)V", "LK6/n;", "chatInfo", "Lcom/stepos/agentframework/adapter/netcore/h;", "eventListener", "v", "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;)Z", "x", "s", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;)Lcom/stepos/agentframework/adapter/netcore/o;", "X", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;)V", "u", "w", "r", "deviceId", "timeOut", "Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "Le8/b;", "tosConfig", "Lcom/stepos/agentframework/adapter/netcore/k;", "fileStorageConfig", "agentProxyBaseUrl", "M", "(Landroid/content/Context;Ljava/lang/String;JLcom/stepos/agentframework/adapter/netcore/p;Le8/b;Lcom/stepos/agentframework/adapter/netcore/k;Ljava/lang/String;)V", "types", "l0", "(Ljava/util/List;)V", "client", "c0", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/o;Lcom/stepos/agentframework/adapter/netcore/p;)V", "d0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Lcom/stepos/agentframework/adapter/netcore/p;)V", "Lcom/stepos/agentframework/adapter/netcore/n;", "q", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "originRunId", "b0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/n;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/netcore/i;", "eventSourceState", "k", "(Lcom/stepos/agentframework/adapter/netcore/i;)V", "Lcom/stepos/agentframework/adapter/netcore/t;", "callback", "j0", "(Lcom/stepos/agentframework/adapter/netcore/t;)V", "adopter", "k0", "(Lp9/p;)V", "sessionId", "outboundId", "listener", "f0", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/h;)Lcom/stepos/agentframework/adapter/netcore/n;", "L", "(Ljava/lang/String;)Z", "Lcom/stepos/agentframework/adapter/netcore/B;", "l", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Lcom/stepos/agentframework/adapter/netcore/B;)Z", "g0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Lcom/stepos/agentframework/adapter/netcore/B;)V", "LK6/s;", "request", "G", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/s;Le9/c;)Ljava/lang/Object;", "LK6/M;", "Lkotlin/Function1;", "Ln4/a;", "onStatusUpdate", "p0", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/M;Lp9/l;Le9/c;)Ljava/lang/Object;", "fileUri", "mime", DidiCardProvider.KEY_TRACE_ID, "t", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LK6/b;", "LK6/a;", "I", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/b;Le9/c;)Ljava/lang/Object;", "LK6/O;", "r0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/O;Le9/c;)Ljava/lang/Object;", "requestId", "decision", "reason", "askUserQuestion", "i0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "H", "s0", "LK6/G;", "F", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", "o", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "p", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", "Q", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/H;Le9/c;)Ljava/lang/Object;", "inquiryId", "answers", "Lcom/stepos/agentframework/adapter/netcore/q;", "m", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "LK6/I;", "o0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/I;Le9/c;)Ljava/lang/Object;", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "LK6/D;", "n0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/adapter/netcore/ApiType;)Z", ExifInterface.LONGITUDE_EAST, Const.INTENT_KEY_UMID, "y", "newTitle", "h0", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/agentframework/adapter/netcore/ApiType;Le9/c;)Ljava/lang/Object;", "agentId", "D", "C", "agent", "B", "fileType", "Y", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "t0", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Landroid/content/Context;)Z", "J", "K", "LK6/J;", "LK6/K;", "n", "(Lcom/stepos/agentframework/adapter/netcore/ApiType;LK6/J;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "DISLIKE_FEEDBACK_OPTIONS_CACHE_TTL_MS", "Ljava/util/concurrent/ConcurrentHashMap;", "clientMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/ref/WeakReference;", "eventSourceStates", "Ljava/util/Set;", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "contextRef", "Ljava/lang/ref/WeakReference;", "inited", "LUa/M;", "sdkScope", "LUa/M;", "Leb/a;", "dislikeOptionsCacheMutex", "Leb/a;", "dislikeOptionsRefreshing", "dislikeFeedbackOptionsCache", "Ljava/util/List;", "dislikeFeedbackOptionsCacheAtMs", "agentClientTimeout", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiManager {
    private static final long DISLIKE_FEEDBACK_OPTIONS_CACHE_TTL_MS = 21600000;
    private static final String TAG = "ApiManager";
    private static WeakReference<Context> contextRef;
    private static volatile long dislikeFeedbackOptionsCacheAtMs;
    private static volatile boolean dislikeOptionsRefreshing;
    private static volatile boolean inited;
    private static ConnectivityManager.NetworkCallback networkCallback;
    public static final ApiManager INSTANCE = new ApiManager();
    private static final ConcurrentHashMap<ApiType, o> clientMap = new ConcurrentHashMap<>();
    private static final Set<WeakReference<i>> eventSourceStates = new LinkedHashSet();
    private static final M sdkScope = d.a(L0.b(null, 1, null).plus(Y.b()));
    private static final InterfaceC4021a dislikeOptionsCacheMutex = f.b(false, 1, null);
    private static volatile List<String> dislikeFeedbackOptionsCache = C1173v.m();
    private static long agentClientTimeout = 30;
    private static final Gson gson = new Gson();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApiType.values().length];
            try {
                iArr[ApiType.COZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ApiType.DIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ApiType.BFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ApiType.OPENCLAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ApiType.AGENTBUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ApiType.AGENT_SPACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ApiType.AGENTBUS_BFF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/agentframework/adapter/ApiManager$b", "Lcom/stepos/net/token/TokenProvider;", "", "getToken", "()Ljava/lang/String;", "refreshToken", "cachedToken", "Ljava/lang/String;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements TokenProvider {
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
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/adapter/ApiManager$c", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "LY8/t;", "onAvailable", "(Landroid/net/Network;)V", "onLost", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            p.i(network, "network");
            C4148a.k(ApiManager.TAG, "Network Available", false, 4, null);
            ApiManager.INSTANCE.W(true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            p.i(network, "network");
            C4148a.k(ApiManager.TAG, "Network Lost", false, 4, null);
            ApiManager.INSTANCE.W(false);
        }
    }

    public static /* synthetic */ void N(ApiManager apiManager, Context context, String str, long j10, com.stepos.agentframework.adapter.netcore.p pVar, UploadConfig uploadConfig, FileStorageConfig fileStorageConfig, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = 30;
        }
        apiManager.M(context, str, j10, (i10 & 8) != 0 ? s.INSTANCE : pVar, (i10 & 16) != 0 ? null : uploadConfig, (i10 & 32) != 0 ? null : fileStorageConfig, (i10 & 64) != 0 ? "" : str2);
    }

    public static final t O(Context context, String str, HttpConfig.Builder init) {
        p.i(init, "$this$init");
        init.setDebug(false);
        init.setDefaultBaseUrl(C4.a.INSTANCE.a(context).c());
        init.addBaseUrl("bff_base_url_key", init.getDefaultBaseUrl());
        if (!H.x0(str)) {
            init.addBaseUrl("agent_proxy_base_url_key", str);
        }
        init.setTokenProvider(new b());
        init.setGlobalErrorListener(new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ApiManager.P((ApiException) obj);
            }
        });
        return t.f7040a;
    }

    public static final t P(ApiException ex) {
        p.i(ex, "ex");
        C4148a.g(TAG, "Network error: ", ex, false, 8, null);
        return t.f7040a;
    }

    public static /* synthetic */ boolean U(ApiManager apiManager, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = System.currentTimeMillis();
        }
        return apiManager.T(j10);
    }

    public static /* synthetic */ void e0(ApiManager apiManager, ApiType apiType, com.stepos.agentframework.adapter.netcore.p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            pVar = s.INSTANCE;
        }
        apiManager.d0(apiType, pVar);
    }

    public static final t q0(UploadFileRequest uploadFileRequest, InterfaceC5074l interfaceC5074l, int i10, boolean z10, String fileId, String str, Long l10) {
        p.i(fileId, "fileId");
        if (!z10) {
            interfaceC5074l.invoke(new AbstractC4939a.Progress(i10));
        } else if (uploadFileRequest.getUseFileId()) {
            if (fileId.length() > 0) {
                C4148a.k(TAG, "Upload success (fileId mode): " + fileId, false, 4, null);
                interfaceC5074l.invoke(new AbstractC4939a.Success(fileId, str, l10));
            } else {
                AbstractC4898a.AgentInternalError agentInternalError = new AbstractC4898a.AgentInternalError("上传失败：未获取到文件ID");
                interfaceC5074l.invoke(new AbstractC4939a.Failed(agentInternalError.code, agentInternalError.message, null, 4, null));
                C4148a.h(TAG, "Upload failed. Err:" + agentInternalError.message, false, 4, null);
            }
        } else if (str == null || str.length() == 0) {
            AbstractC4898a.AgentInternalError agentInternalError2 = new AbstractC4898a.AgentInternalError("上传失败：未获取到文件URL");
            interfaceC5074l.invoke(new AbstractC4939a.Failed(agentInternalError2.code, agentInternalError2.message, null, 4, null));
            C4148a.h(TAG, "Upload failed. Err:" + agentInternalError2.message, false, 4, null);
        } else {
            C4148a.k(TAG, "Upload success (URL mode): " + str, false, 4, null);
            interfaceC5074l.invoke(new AbstractC4939a.Success(fileId, str, l10));
        }
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(com.stepos.agentframework.adapter.netcore.ApiType r11, e9.InterfaceC4014c<? super java.lang.String> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stepos.agentframework.adapter.ApiManager$createSession$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.agentframework.adapter.ApiManager$createSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager$createSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$createSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$createSession$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r10 = r0.L$1
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L32
            goto L64
        L32:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L67
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.C4849c.b(r12)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L4f
            return r3
        L4f:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L32
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L32
            r0.label = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r12 = r10.m(r0)     // Catch: java.lang.Throwable -> L32
            if (r12 != r1) goto L64
            return r1
        L64:
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L32
            return r12
        L67:
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            java.lang.String r5 = "createSession failed"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.A(com.stepos.agentframework.adapter.netcore.ApiType, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(com.stepos.agentframework.adapter.netcore.ApiType r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super java.lang.String> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.agentframework.adapter.ApiManager$createSession$2
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.agentframework.adapter.ApiManager$createSession$2 r0 = (com.stepos.agentframework.adapter.ApiManager$createSession$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$createSession$2 r0 = new com.stepos.agentframework.adapter.ApiManager$createSession$2
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 != r4) goto L3f
            java.lang.Object r10 = r0.L$3
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$1
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L3b
            goto L75
        L3b:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L78
        L3f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L47:
            kotlin.C4849c.b(r14)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L58
            return r3
        L58:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3b
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L3b
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r11 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L3b
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L3b
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L3b
            r0.label = r4     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r14 = r10.Q(r12, r13, r0)     // Catch: java.lang.Throwable -> L3b
            if (r14 != r1) goto L75
            return r1
        L75:
            java.lang.String r14 = (java.lang.String) r14     // Catch: java.lang.Throwable -> L3b
            return r14
        L78:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "createSession(agent="
            r10.append(r11)
            r10.append(r12)
            java.lang.String r11 = ") failed"
            r10.append(r11)
            java.lang.String r5 = r10.toString()
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.B(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(com.stepos.agentframework.adapter.netcore.ApiType r11, java.lang.String r12, e9.InterfaceC4014c<? super java.lang.String> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.agentframework.adapter.ApiManager$createSessionForAgent$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.agentframework.adapter.ApiManager$createSessionForAgent$1 r0 = (com.stepos.agentframework.adapter.ApiManager$createSessionForAgent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$createSessionForAgent$1 r0 = new com.stepos.agentframework.adapter.ApiManager$createSessionForAgent$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 != r4) goto L3b
            java.lang.Object r10 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$1
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L37
            goto L6b
        L37:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L6e
        L3b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            kotlin.C4849c.b(r13)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L54
            return r3
        L54:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L37
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L37
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L37
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L37
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L37
            r0.label = r4     // Catch: java.lang.Throwable -> L37
            java.lang.Object r13 = r10.j(r12, r0)     // Catch: java.lang.Throwable -> L37
            if (r13 != r1) goto L6b
            return r1
        L6b:
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L37
            return r13
        L6e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "createSessionForAgent(agentId="
            r10.append(r11)
            r10.append(r12)
            java.lang.String r11 = ") failed"
            r10.append(r11)
            java.lang.String r5 = r10.toString()
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.C(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        if (r13 == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(com.stepos.agentframework.adapter.netcore.ApiType r11, java.lang.String r12, e9.InterfaceC4014c<? super java.lang.String> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.agentframework.adapter.ApiManager$createSessionFresh$2
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.agentframework.adapter.ApiManager$createSessionFresh$2 r0 = (com.stepos.agentframework.adapter.ApiManager$createSessionFresh$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$createSessionFresh$2 r0 = new com.stepos.agentframework.adapter.ApiManager$createSessionFresh$2
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L57
            if (r2 == r5) goto L46
            if (r2 != r4) goto L3e
            java.lang.Object r10 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$1
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L3a
            goto La4
        L3a:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto La7
        L3e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L46:
            java.lang.Object r10 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$1
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L3a
            goto L8a
        L57:
            kotlin.C4849c.b(r13)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L68
            return r3
        L68:
            com.stepos.agentframework.adapter.netcore.ApiType r13 = com.stepos.agentframework.adapter.netcore.ApiType.AGENTBUS     // Catch: java.lang.Throwable -> L3a
            if (r11 != r13) goto L8d
            boolean r13 = r10 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient     // Catch: java.lang.Throwable -> L3a
            if (r13 == 0) goto L8d
            r13 = r10
            com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient r13 = (com.stepos.agentframework.adapter.agentbus.AgentBusCoreAgentClient) r13     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r10 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r10     // Catch: java.lang.Throwable -> L3a
            r0.label = r5     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r13 = r13.Q0(r12, r0)     // Catch: java.lang.Throwable -> L3a
            if (r13 != r1) goto L8a
            goto La3
        L8a:
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L3a
            return r13
        L8d:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r13 = r10.j(r12, r0)     // Catch: java.lang.Throwable -> L3a
            if (r13 != r1) goto La4
        La3:
            return r1
        La4:
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L3a
            return r13
        La7:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "createSessionFresh(agentId="
            r10.append(r11)
            r10.append(r12)
            java.lang.String r11 = ") failed"
            r10.append(r11)
            java.lang.String r5 = r10.toString()
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.D(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(com.stepos.agentframework.adapter.netcore.ApiType r12, java.lang.String r13, e9.InterfaceC4014c<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stepos.agentframework.adapter.ApiManager$deleteSession$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.agentframework.adapter.ApiManager$deleteSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager$deleteSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$deleteSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$deleteSession$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r11 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r11 = (com.stepos.agentframework.adapter.netcore.o) r11
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r11 = (com.stepos.agentframework.adapter.netcore.ApiType) r11
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            goto L76
        L36:
            r0 = move-exception
            r11 = r0
            r7 = r11
            goto L7d
        L3a:
            r0 = move-exception
            r11 = r0
            r7 = r11
            goto L89
        L3e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L46:
            kotlin.C4849c.b(r14)
            r11.X(r12)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r11 = com.stepos.agentframework.adapter.ApiManager.clientMap     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            java.lang.Object r11 = r11.get(r12)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            com.stepos.agentframework.adapter.netcore.o r11 = (com.stepos.agentframework.adapter.netcore.o) r11     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            if (r11 != 0) goto L5b
            java.lang.Boolean r11 = g9.C4109a.a(r4)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            return r11
        L5b:
            java.lang.Object r12 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            java.lang.Object r12 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            java.lang.Object r12 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            r0.L$2 = r12     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            r0.label = r3     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            java.lang.Object r14 = r11.a0(r13, r0)     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            if (r14 != r1) goto L76
            return r1
        L76:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            boolean r4 = r14.booleanValue()     // Catch: java.lang.Throwable -> L36 com.stepos.agentframework.adapter.error.AdapterException -> L3a
            goto La6
        L7d:
            r9 = 8
            r10 = 0
            java.lang.String r5 = "ApiManager"
            java.lang.String r6 = "deleteSession failed"
            r8 = 0
            h8.C4148a.g(r5, r6, r7, r8, r9, r10)
            goto La6
        L89:
            m4.a r11 = r7.getError()
            boolean r11 = r11 instanceof m4.AbstractC4898a.d
            if (r11 == 0) goto L9b
            r11 = 4
            r12 = 0
            java.lang.String r13 = "ApiManager"
            java.lang.String r14 = "deleteSession no network"
            h8.C4148a.h(r13, r14, r4, r11, r12)
            goto La6
        L9b:
            r9 = 8
            r10 = 0
            java.lang.String r5 = "ApiManager"
            java.lang.String r6 = "deleteSession failed"
            r8 = 0
            h8.C4148a.g(r5, r6, r7, r8, r9, r10)
        La6:
            java.lang.Boolean r11 = g9.C4109a.a(r4)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.E(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    public final Object F(ApiType apiType, TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return R(apiType, "deleteTask", new ApiManager$deleteTask$2(taskDeleteRequest, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(com.stepos.agentframework.adapter.netcore.ApiType r6, kotlin.FeedbackRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.adapter.ApiManager$feedback$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.adapter.ApiManager$feedback$1 r0 = (com.stepos.agentframework.adapter.ApiManager$feedback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$feedback$1 r0 = new com.stepos.agentframework.adapter.ApiManager$feedback$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r5 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r5 = (com.stepos.agentframework.adapter.netcore.o) r5
            java.lang.Object r5 = r0.L$1
            K6.s r5 = (kotlin.FeedbackRequest) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r5 = (com.stepos.agentframework.adapter.netcore.ApiType) r5
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L75
            goto L6b
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.C4849c.b(r8)
            r5.X(r6)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r5 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r5 = r5.get(r6)
            com.stepos.agentframework.adapter.netcore.o r5 = (com.stepos.agentframework.adapter.netcore.o) r5
            if (r5 == 0) goto L85
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L75
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L75
            java.lang.Object r6 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L75
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L75
            java.lang.Object r6 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L75
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L75
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L75
            r0.label = r4     // Catch: java.lang.Throwable -> L75
            java.lang.Object r8 = r5.C(r7, r0)     // Catch: java.lang.Throwable -> L75
            if (r8 != r1) goto L6b
            return r1
        L6b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L75
            boolean r5 = r8.booleanValue()     // Catch: java.lang.Throwable -> L75
            if (r5 != r4) goto L85
            r3 = r4
            goto L85
        L75:
            r5 = move-exception
            m4.a$a r6 = new m4.a$a
            java.lang.String r7 = r5.getMessage()
            r6.<init>(r7)
            com.stepos.agentframework.adapter.error.AdapterException r7 = new com.stepos.agentframework.adapter.error.AdapterException
            r7.<init>(r6, r5)
            throw r7
        L85:
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.G(com.stepos.agentframework.adapter.netcore.ApiType, K6.s, e9.c):java.lang.Object");
    }

    public final Object H(InterfaceC4014c<? super List<String>> interfaceC4014c) {
        List<String> list = dislikeFeedbackOptionsCache;
        if (list.isEmpty()) {
            return a0(interfaceC4014c);
        }
        if (U(this, 0L, 1, null)) {
            Z();
        }
        return list;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(com.stepos.agentframework.adapter.netcore.ApiType r5, kotlin.AgentDetailRequest r6, e9.InterfaceC4014c<? super kotlin.C0905a> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1 r0 = (com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1 r0 = new com.stepos.agentframework.adapter.ApiManager$getAgentDetail$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r4 = (com.stepos.agentframework.adapter.netcore.o) r4
            java.lang.Object r4 = r0.L$1
            K6.b r4 = (kotlin.AgentDetailRequest) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r4 = (com.stepos.agentframework.adapter.netcore.ApiType) r4
            kotlin.C4849c.b(r7)
            goto L68
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C4849c.b(r7)
            r4.X(r5)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r4 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r4 = r4.get(r5)
            com.stepos.agentframework.adapter.netcore.o r4 = (com.stepos.agentframework.adapter.netcore.o) r4
            if (r4 == 0) goto L6e
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$1 = r5
            java.lang.Object r5 = g9.h.a(r4)
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r7 = r4.A(r6, r0)
            if (r7 != r1) goto L68
            return r1
        L68:
            K6.a r7 = (kotlin.C0905a) r7
            if (r7 != 0) goto L6d
            goto L6e
        L6d:
            return r7
        L6e:
            K6.a r4 = new K6.a
            r4.<init>()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.I(com.stepos.agentframework.adapter.netcore.ApiType, K6.b, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(com.stepos.agentframework.adapter.netcore.ApiType r11, e9.InterfaceC4014c<? super java.lang.String> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stepos.agentframework.adapter.ApiManager$getHotSession$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.agentframework.adapter.ApiManager$getHotSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager$getHotSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$getHotSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$getHotSession$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r10 = r0.L$1
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L32
            goto L64
        L32:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L67
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.C4849c.b(r12)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L4f
            return r3
        L4f:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L32
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L32
            r0.label = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r12 = r10.i(r0)     // Catch: java.lang.Throwable -> L32
            if (r12 != r1) goto L64
            return r1
        L64:
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L32
            return r12
        L67:
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            java.lang.String r5 = "getHotSession failed"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.J(com.stepos.agentframework.adapter.netcore.ApiType, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(com.stepos.agentframework.adapter.netcore.ApiType r11, java.lang.String r12, e9.InterfaceC4014c<? super java.lang.String> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.agentframework.adapter.ApiManager$getHotSession$2
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.agentframework.adapter.ApiManager$getHotSession$2 r0 = (com.stepos.agentframework.adapter.ApiManager$getHotSession$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$getHotSession$2 r0 = new com.stepos.agentframework.adapter.ApiManager$getHotSession$2
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 != r4) goto L3b
            java.lang.Object r10 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$1
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L37
            goto L6b
        L37:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L6e
        L3b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            kotlin.C4849c.b(r13)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L54
            return r3
        L54:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L37
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L37
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L37
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L37
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L37
            r0.label = r4     // Catch: java.lang.Throwable -> L37
            java.lang.Object r13 = r10.b(r12, r0)     // Catch: java.lang.Throwable -> L37
            if (r13 != r1) goto L6b
            return r1
        L6b:
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L37
            return r13
        L6e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "getHotSession(agentId="
            r10.append(r11)
            r10.append(r12)
            java.lang.String r11 = ") failed"
            r10.append(r11)
            java.lang.String r5 = r10.toString()
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.K(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    public final boolean L(String outboundId) {
        p.i(outboundId, "outboundId");
        o oVar = clientMap.get(ApiType.AGENTBUS);
        AgentBusCoreAgentClient agentBusCoreAgentClient = oVar instanceof AgentBusCoreAgentClient ? (AgentBusCoreAgentClient) oVar : null;
        if (agentBusCoreAgentClient == null) {
            return false;
        }
        return agentBusCoreAgentClient.u1(outboundId);
    }

    public final void M(final Context context, String deviceId, long timeOut, com.stepos.agentframework.adapter.netcore.p logger, UploadConfig tosConfig, FileStorageConfig fileStorageConfig, final String agentProxyBaseUrl) {
        p.i(context, "context");
        p.i(deviceId, "deviceId");
        p.i(logger, "logger");
        p.i(agentProxyBaseUrl, "agentProxyBaseUrl");
        if (inited) {
            return;
        }
        synchronized (this) {
            try {
                if (inited) {
                    return;
                }
                if (HttpManager.isInitialized()) {
                    C4148a.k(TAG, "HttpManager is already initialized, skip init...", false, 4, null);
                    HttpManager httpManager = HttpManager.INSTANCE;
                    httpManager.addBaseUrl("bff_base_url_key", C4.a.INSTANCE.a(context).c());
                    if (!H.x0(agentProxyBaseUrl)) {
                        httpManager.addBaseUrl("agent_proxy_base_url_key", agentProxyBaseUrl);
                    }
                } else {
                    C4148a.k(TAG, "HttpManager is not initialized, init now...", false, 4, null);
                    HttpManager httpManager2 = HttpManager.INSTANCE;
                    Context applicationContext = context.getApplicationContext();
                    p.h(applicationContext, "getApplicationContext(...)");
                    httpManager2.init(applicationContext, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.c
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return ApiManager.O(context, agentProxyBaseUrl, (HttpConfig.Builder) obj);
                        }
                    });
                }
                agentClientTimeout = timeOut;
                ApiManager apiManager = INSTANCE;
                apiManager.c0(context, new AgentSpaceCoreAgentClient(timeOut), logger);
                contextRef = new WeakReference<>(context.getApplicationContext());
                Context applicationContext2 = context.getApplicationContext();
                p.h(applicationContext2, "getApplicationContext(...)");
                apiManager.m0(applicationContext2);
                if (tosConfig != null) {
                    y.INSTANCE.a(tosConfig);
                    C4148a.k(TAG, "TOS SDK initialized with custom config", false, 4, null);
                }
                if (fileStorageConfig != null) {
                    FileStorageUploadHelper.INSTANCE.h(fileStorageConfig);
                    C4148a.k(TAG, "FileStorage SDK initialized, upload mode = FileStorage", false, 4, null);
                }
                inited = true;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object Q(ApiType apiType, TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return R(apiType, "interactTask", new ApiManager$interactTask$2(taskInteractRequest, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object R(com.stepos.agentframework.adapter.netcore.ApiType r11, java.lang.String r12, p9.p<? super com.stepos.agentframework.adapter.netcore.o, ? super e9.InterfaceC4014c<? super java.lang.Boolean>, ? extends java.lang.Object> r13, e9.InterfaceC4014c<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1 r0 = (com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1 r0 = new com.stepos.agentframework.adapter.ApiManager$invokeTaskOp$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 != r4) goto L3f
            java.lang.Object r10 = r0.L$3
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$2
            p9.p r10 = (p9.p) r10
            java.lang.Object r10 = r0.L$1
            r12 = r10
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L3b
            goto L79
        L3b:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L80
        L3f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L47:
            kotlin.C4849c.b(r14)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L5c
            java.lang.Boolean r10 = g9.C4109a.a(r3)
            return r10
        L5c:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3b
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L3b
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r11 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L3b
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L3b
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L3b
            r0.label = r4     // Catch: java.lang.Throwable -> L3b
            java.lang.Object r14 = r13.invoke(r10, r0)     // Catch: java.lang.Throwable -> L3b
            if (r14 != r1) goto L79
            return r1
        L79:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Throwable -> L3b
            boolean r3 = r14.booleanValue()     // Catch: java.lang.Throwable -> L3b
            goto La1
        L80:
            java.lang.String r10 = r6.getMessage()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r12)
            java.lang.String r12 = " failed. Err:"
            r11.append(r12)
            r11.append(r10)
            java.lang.String r5 = r11.toString()
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
        La1:
            java.lang.Boolean r10 = g9.C4109a.a(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.R(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, p9.p, e9.c):java.lang.Object");
    }

    public final boolean S(ApiType type) {
        p.i(type, "type");
        o oVar = clientMap.get(type);
        if (oVar != null) {
            return oVar.h();
        }
        return false;
    }

    public final boolean T(long nowMs) {
        long j10 = dislikeFeedbackOptionsCacheAtMs;
        return j10 <= 0 || nowMs - j10 >= 21600000;
    }

    public final boolean V(Context context) {
        NetworkCapabilities networkCapabilities;
        p.i(context, "context");
        Object systemService = context.getSystemService("connectivity");
        p.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    public final void W(boolean isAvailable) {
        Collection<o> collectionValues = clientMap.values();
        p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((o) it.next()).b0(isAvailable);
        }
    }

    public final void X(ApiType type) throws AdapterException {
        u(type);
        w();
        r(type);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(com.stepos.agentframework.adapter.netcore.ApiType r11, java.lang.String r12, e9.InterfaceC4014c<? super java.lang.String> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.stepos.agentframework.adapter.ApiManager$readCoreFile$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.agentframework.adapter.ApiManager$readCoreFile$1 r0 = (com.stepos.agentframework.adapter.ApiManager$readCoreFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$readCoreFile$1 r0 = new com.stepos.agentframework.adapter.ApiManager$readCoreFile$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r10 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L36
            goto L6e
        L36:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L71
        L3a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L42:
            kotlin.C4849c.b(r13)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L53
            return r3
        L53:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L36
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L36
            java.lang.Object r11 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L36
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L36
            r0.label = r4     // Catch: java.lang.Throwable -> L36
            java.lang.Object r13 = r10.I(r12, r0)     // Catch: java.lang.Throwable -> L36
            if (r13 != r1) goto L6e
            return r1
        L6e:
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Throwable -> L36
            return r13
        L71:
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            java.lang.String r5 = "readCoreFile failed"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.Y(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    public final void Z() {
        if (dislikeOptionsRefreshing) {
            return;
        }
        dislikeOptionsRefreshing = true;
        C1060i.d(sdkScope, null, null, new ApiManager$refreshDislikeFeedbackOptionsAsync$1(null), 3, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:7))(0)|8|(1:(1:(11:12|65|13|48|(1:50)|51|(1:53)(1:54)|55|56|59|60)(2:17|18))(1:19))(3:20|(1:23)|46)|64|24|25|(1:27)(3:30|(1:32)(1:33)|(3:38|(1:40)(1:41)|(1:43)(3:44|(7:47|48|(0)|51|(0)(0)|55|56)|46))(1:37))|59|60|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0077, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        r8 = r0;
        r14 = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:13:0x0036, B:48:0x00d3, B:50:0x00de, B:51:0x00e6, B:55:0x00f2), top: B:65:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a0(e9.InterfaceC4014c<? super java.util.List<java.lang.String>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.a0(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(com.stepos.agentframework.adapter.netcore.ApiType r11, kotlin.C0918n r12, java.lang.String r13, com.stepos.agentframework.adapter.netcore.h r14, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.b0(com.stepos.agentframework.adapter.netcore.ApiType, K6.n, java.lang.String, com.stepos.agentframework.adapter.netcore.h, e9.c):java.lang.Object");
    }

    public final void c0(Context context, o client, com.stepos.agentframework.adapter.netcore.p logger) {
        p.i(context, "context");
        p.i(client, "client");
        p.i(logger, "logger");
        synchronized (this) {
            client.r(context, logger);
            clientMap.put(client.getType(), client);
            t tVar = t.f7040a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.stepos.agentframework.adapter.netcore.ApiType r8, java.lang.String r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.ApiManager$abortSession$1
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.agentframework.adapter.ApiManager$abortSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager$abortSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.stepos.agentframework.adapter.ApiManager$abortSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$abortSession$1
            r0.<init>(r7, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L3f
            if (r1 != r2) goto L37
            java.lang.Object r7 = r4.L$2
            com.stepos.agentframework.adapter.netcore.o r7 = (com.stepos.agentframework.adapter.netcore.o) r7
            java.lang.Object r7 = r4.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r4.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r7 = (com.stepos.agentframework.adapter.netcore.ApiType) r7
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L72
            goto L80
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            kotlin.C4849c.b(r10)
            r7.X(r8)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r7 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r7 = r7.get(r8)
            r1 = r7
            com.stepos.agentframework.adapter.netcore.o r1 = (com.stepos.agentframework.adapter.netcore.o) r1
            if (r1 != 0) goto L53
            Y8.t r7 = Y8.t.f7040a
            return r7
        L53:
            java.lang.Object r7 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L72
            r4.L$0 = r7     // Catch: java.lang.Throwable -> L72
            java.lang.Object r7 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L72
            r4.L$1 = r7     // Catch: java.lang.Throwable -> L72
            java.lang.Object r7 = g9.h.a(r1)     // Catch: java.lang.Throwable -> L72
            r4.L$2 = r7     // Catch: java.lang.Throwable -> L72
            r4.label = r2     // Catch: java.lang.Throwable -> L72
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r9
            java.lang.Object r7 = com.stepos.agentframework.adapter.netcore.o.V(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L72
            if (r7 != r0) goto L80
            return r0
        L72:
            r0 = move-exception
            r7 = r0
            r2 = r7
            r4 = 8
            r5 = 0
            java.lang.String r0 = "ApiManager"
            java.lang.String r1 = "abortSession failed"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
        L80:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.d(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    public final void d0(ApiType apiType, com.stepos.agentframework.adapter.netcore.p logger) {
        p.i(apiType, "apiType");
        p.i(logger, "logger");
        if (clientMap.get(apiType) != null) {
            return;
        }
        o oVarZ = z(apiType, agentClientTimeout);
        WeakReference<Context> weakReference = contextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        p.f(context);
        c0(context, oVarZ, logger);
    }

    public final n f0(String sessionId, String outboundId, h listener) {
        p.i(sessionId, "sessionId");
        p.i(outboundId, "outboundId");
        p.i(listener, "listener");
        o oVar = clientMap.get(ApiType.AGENTBUS);
        AgentBusCoreAgentClient agentBusCoreAgentClient = oVar instanceof AgentBusCoreAgentClient ? (AgentBusCoreAgentClient) oVar : null;
        if (agentBusCoreAgentClient == null) {
            return null;
        }
        return agentBusCoreAgentClient.Q1(sessionId, outboundId, listener);
    }

    public final void g0(ApiType type, B listener) {
        p.i(type, "type");
        p.i(listener, "listener");
        o oVar = clientMap.get(type);
        if (oVar != null) {
            oVar.y(listener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h0(com.stepos.agentframework.adapter.netcore.ApiType r7, java.lang.String r8, java.lang.String r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.ApiManager$renameSession$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.adapter.ApiManager$renameSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager$renameSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$renameSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$renameSession$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.L$3
            com.stepos.agentframework.adapter.netcore.o r6 = (com.stepos.agentframework.adapter.netcore.o) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r6 = (com.stepos.agentframework.adapter.netcore.ApiType) r6
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L75
            goto L83
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.C4849c.b(r10)
            r6.X(r7)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r6 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r6 = r6.get(r7)
            com.stepos.agentframework.adapter.netcore.o r6 = (com.stepos.agentframework.adapter.netcore.o) r6
            if (r6 != 0) goto L54
            Y8.t r6 = Y8.t.f7040a
            return r6
        L54:
            java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L75
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L75
            java.lang.Object r7 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L75
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L75
            java.lang.Object r7 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L75
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L75
            java.lang.Object r7 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L75
            r0.L$3 = r7     // Catch: java.lang.Throwable -> L75
            r0.label = r3     // Catch: java.lang.Throwable -> L75
            java.lang.Object r6 = r6.W(r8, r9, r0)     // Catch: java.lang.Throwable -> L75
            if (r6 != r1) goto L83
            return r1
        L75:
            r0 = move-exception
            r6 = r0
            r2 = r6
            r4 = 8
            r5 = 0
            java.lang.String r0 = "ApiManager"
            java.lang.String r1 = "renameSession failed"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
        L83:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.h0(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final Object i0(ApiType apiType, String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new ApiManager$sendApproval$2(apiType, str, str2, str3, str4, str5, null), interfaceC4014c);
    }

    public final void j0(com.stepos.agentframework.adapter.netcore.t callback) {
        C4148a.d(TAG, "setOpenClawPushMessageCallback: callback set = " + (callback != null), false, 4, null);
        ConcurrentHashMap<ApiType, o> concurrentHashMap = clientMap;
        o oVar = concurrentHashMap.get(ApiType.OPENCLAW);
        OpenClawCoreAgentClient openClawCoreAgentClient = oVar instanceof OpenClawCoreAgentClient ? (OpenClawCoreAgentClient) oVar : null;
        if (openClawCoreAgentClient != null) {
            openClawCoreAgentClient.I0(callback);
        }
        o oVar2 = concurrentHashMap.get(ApiType.AGENTBUS);
        AgentBusCoreAgentClient agentBusCoreAgentClient = oVar2 instanceof AgentBusCoreAgentClient ? (AgentBusCoreAgentClient) oVar2 : null;
        if (agentBusCoreAgentClient != null) {
            agentBusCoreAgentClient.W1(callback);
        }
        C4148a.d(TAG, "AgentBusCoreAgentClient push message: callback set = " + (callback != null), false, 4, null);
        C4148a.d(TAG, "setOpenClawPushMessageCallback: callback set = " + (callback != null) + ", client exists = " + (openClawCoreAgentClient != null), false, 4, null);
    }

    public final void k(i eventSourceState) {
        p.i(eventSourceState, "eventSourceState");
        eventSourceStates.add(new WeakReference<>(eventSourceState));
    }

    public final void k0(p9.p<? super String, ? super String, Boolean> adopter) {
        o oVar = clientMap.get(ApiType.AGENTBUS);
        AgentBusCoreAgentClient agentBusCoreAgentClient = oVar instanceof AgentBusCoreAgentClient ? (AgentBusCoreAgentClient) oVar : null;
        if (agentBusCoreAgentClient != null) {
            agentBusCoreAgentClient.X1(adopter);
        }
        C4148a.d(TAG, "setServerInitiatedRoundAdopter: " + (adopter != null), false, 4, null);
    }

    public final boolean l(ApiType type, B listener) {
        p.i(type, "type");
        p.i(listener, "listener");
        o oVar = clientMap.get(type);
        if (oVar != null) {
            oVar.n(listener);
            return true;
        }
        C4148a.u(TAG, "addTaskEventListener skipped: no client for " + type, false, 4, null);
        return false;
    }

    public final void l0(List<? extends ApiType> types) {
        p.i(types, "types");
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            e0(INSTANCE, (ApiType) it.next(), null, 2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(com.stepos.agentframework.adapter.netcore.ApiType r10, java.lang.String r11, java.lang.String r12, java.util.List<java.lang.String> r13, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.InquiryAnswerResult> r14) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r1 = r14 instanceof com.stepos.agentframework.adapter.ApiManager$answerInquiry$1
            if (r1 == 0) goto L13
            r1 = r14
            com.stepos.agentframework.adapter.ApiManager$answerInquiry$1 r1 = (com.stepos.agentframework.adapter.ApiManager$answerInquiry$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L13
            int r2 = r2 - r3
            r1.label = r2
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$answerInquiry$1 r1 = new com.stepos.agentframework.adapter.ApiManager$answerInquiry$1
            r1.<init>(r9, r14)
        L18:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = f9.C4063a.g()
            int r4 = r1.label
            r5 = 2
            r6 = 0
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L4a
            if (r4 != r7) goto L42
            java.lang.Object r2 = r1.L$4
            com.stepos.agentframework.adapter.netcore.o r2 = (com.stepos.agentframework.adapter.netcore.o) r2
            java.lang.Object r2 = r1.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = r1.L$2
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r1.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r1 = (com.stepos.agentframework.adapter.netcore.ApiType) r1
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L40
            goto L87
        L40:
            r0 = move-exception
            goto L8a
        L42:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4a:
            kotlin.C4849c.b(r0)
            r9.X(r10)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r0 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r0 = r0.get(r10)
            com.stepos.agentframework.adapter.netcore.o r0 = (com.stepos.agentframework.adapter.netcore.o) r0
            if (r0 != 0) goto L60
            com.stepos.agentframework.adapter.netcore.q r0 = new com.stepos.agentframework.adapter.netcore.q
            r0.<init>(r6, r8, r5, r8)
            return r0
        L60:
            java.lang.Object r2 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L40
            r1.L$0 = r2     // Catch: java.lang.Throwable -> L40
            java.lang.Object r2 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L40
            r1.L$1 = r2     // Catch: java.lang.Throwable -> L40
            java.lang.Object r2 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L40
            r1.L$2 = r2     // Catch: java.lang.Throwable -> L40
            java.lang.Object r2 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L40
            r1.L$3 = r2     // Catch: java.lang.Throwable -> L40
            java.lang.Object r2 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L40
            r1.L$4 = r2     // Catch: java.lang.Throwable -> L40
            r1.label = r7     // Catch: java.lang.Throwable -> L40
            java.lang.Object r0 = r0.k(r11, r12, r13, r1)     // Catch: java.lang.Throwable -> L40
            if (r0 != r3) goto L87
            return r3
        L87:
            com.stepos.agentframework.adapter.netcore.q r0 = (com.stepos.agentframework.adapter.netcore.InquiryAnswerResult) r0     // Catch: java.lang.Throwable -> L40
            return r0
        L8a:
            java.lang.String r1 = r0.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "answerInquiry failed. Err:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 8
            r3 = 0
            java.lang.String r4 = "ApiManager"
            r7 = 0
            r11 = r0
            r10 = r1
            r13 = r2
            r14 = r3
            r9 = r4
            r12 = r7
            h8.C4148a.g(r9, r10, r11, r12, r13, r14)
            com.stepos.agentframework.adapter.netcore.q r0 = new com.stepos.agentframework.adapter.netcore.q
            r0.<init>(r6, r8, r5, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.m(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, java.util.List, e9.c):java.lang.Object");
    }

    public final void m0(Context context) {
        Object systemService = context.getSystemService("connectivity");
        p.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        networkCallback = new c();
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback2 = networkCallback;
        p.f(networkCallback2);
        ((ConnectivityManager) systemService).registerNetworkCallback(networkRequestBuild, networkCallback2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(com.stepos.agentframework.adapter.netcore.ApiType r18, kotlin.TranscriptAppendRequest r19, e9.InterfaceC4014c<? super kotlin.TranscriptAppendResult> r20) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r20
            boolean r1 = r0 instanceof com.stepos.agentframework.adapter.ApiManager$appendTranscript$1
            if (r1 == 0) goto L17
            r1 = r0
            com.stepos.agentframework.adapter.ApiManager$appendTranscript$1 r1 = (com.stepos.agentframework.adapter.ApiManager$appendTranscript$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L1e
        L17:
            com.stepos.agentframework.adapter.ApiManager$appendTranscript$1 r1 = new com.stepos.agentframework.adapter.ApiManager$appendTranscript$1
            r2 = r17
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = f9.C4063a.g()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L43
            if (r4 != r5) goto L3b
            java.lang.Object r2 = r1.L$2
            com.stepos.agentframework.adapter.netcore.o r2 = (com.stepos.agentframework.adapter.netcore.o) r2
            java.lang.Object r2 = r1.L$1
            K6.J r2 = (kotlin.TranscriptAppendRequest) r2
            java.lang.Object r1 = r1.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r1 = (com.stepos.agentframework.adapter.netcore.ApiType) r1
            kotlin.C4849c.b(r0)     // Catch: java.lang.Throwable -> L88
            goto L85
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            kotlin.C4849c.b(r0)
            r17.X(r18)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r0 = com.stepos.agentframework.adapter.ApiManager.clientMap
            r2 = r18
            java.lang.Object r0 = r0.get(r2)
            com.stepos.agentframework.adapter.netcore.o r0 = (com.stepos.agentframework.adapter.netcore.o) r0
            if (r0 != 0) goto L68
            K6.K r6 = new K6.K
            r15 = 190(0xbe, float:2.66E-43)
            r16 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            java.lang.String r13 = "no_client"
            r14 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r6
        L68:
            java.lang.Object r2 = g9.h.a(r2)     // Catch: java.lang.Throwable -> L88
            r1.L$0 = r2     // Catch: java.lang.Throwable -> L88
            java.lang.Object r2 = g9.h.a(r19)     // Catch: java.lang.Throwable -> L88
            r1.L$1 = r2     // Catch: java.lang.Throwable -> L88
            java.lang.Object r2 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L88
            r1.L$2 = r2     // Catch: java.lang.Throwable -> L88
            r1.label = r5     // Catch: java.lang.Throwable -> L88
            r2 = r19
            java.lang.Object r0 = r0.d(r2, r1)     // Catch: java.lang.Throwable -> L88
            if (r0 != r3) goto L85
            return r3
        L85:
            K6.K r0 = (kotlin.TranscriptAppendResult) r0     // Catch: java.lang.Throwable -> L88
            return r0
        L88:
            r0 = move-exception
            r3 = r0
            r5 = 8
            r6 = 0
            java.lang.String r1 = "ApiManager"
            java.lang.String r2 = "appendTranscript failed"
            r4 = 0
            h8.C4148a.g(r1, r2, r3, r4, r5, r6)
            K6.K r4 = new K6.K
            java.lang.String r12 = r3.getMessage()
            r13 = 62
            r14 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            java.lang.String r11 = "exception"
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.n(com.stepos.agentframework.adapter.netcore.ApiType, K6.J, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(com.stepos.agentframework.adapter.netcore.ApiType r12, java.lang.String r13, e9.InterfaceC4014c<? super kotlin.SyncHistoryResult> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1 r0 = (com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$syncHistorySession$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r11 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r11 = (com.stepos.agentframework.adapter.netcore.o) r11
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r11 = (com.stepos.agentframework.adapter.netcore.ApiType) r11
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L7e
            goto L7b
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            kotlin.C4849c.b(r14)
            r11.X(r12)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r11 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r11 = r11.get(r12)
            com.stepos.agentframework.adapter.netcore.o r11 = (com.stepos.agentframework.adapter.netcore.o) r11
            if (r11 != 0) goto L5b
            K6.D r4 = new K6.D
            r9 = 9
            r10 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "client not found"
            r8 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r4
        L5b:
            K6.C r14 = new K6.C     // Catch: java.lang.Throwable -> L7e
            r14.<init>(r13)     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r12 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L7e
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r12 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L7e
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r12 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L7e
            r0.L$2 = r12     // Catch: java.lang.Throwable -> L7e
            r0.label = r3     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r14 = r11.K(r14, r0)     // Catch: java.lang.Throwable -> L7e
            if (r14 != r1) goto L7b
            return r1
        L7b:
            K6.D r14 = (kotlin.SyncHistoryResult) r14     // Catch: java.lang.Throwable -> L7e
            return r14
        L7e:
            r0 = move-exception
            r11 = r0
            r2 = r11
            r4 = 8
            r5 = 0
            java.lang.String r0 = "ApiManager"
            java.lang.String r1 = "syncHistory failed"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
            K6.D r3 = new K6.D
            java.lang.String r6 = r2.getMessage()
            r8 = 9
            r9 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.n0(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    public final Object o(ApiType apiType, TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return R(apiType, "batchDeleteTasks", new ApiManager$batchDeleteTasks$2(taskBatchDeleteRequest, null), interfaceC4014c);
    }

    public final Object o0(ApiType apiType, TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return R(apiType, "syncTaskWithRemote", new ApiManager$syncTaskWithRemote$2(taskSyncRemoteRequest, null), interfaceC4014c);
    }

    public final Object p(ApiType apiType, TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return R(apiType, "cancelTask", new ApiManager$cancelTask$2(taskCancelRequest, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p0(android.content.Context r11, com.stepos.agentframework.adapter.netcore.ApiType r12, final kotlin.UploadFileRequest r13, final p9.InterfaceC5074l<? super n4.AbstractC4939a, Y8.t> r14, e9.InterfaceC4014c<? super Y8.t> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.p0(android.content.Context, com.stepos.agentframework.adapter.netcore.ApiType, K6.M, p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(com.stepos.agentframework.adapter.netcore.ApiType r12, kotlin.C0918n r13, com.stepos.agentframework.adapter.netcore.h r14, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> r15) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.stepos.agentframework.adapter.ApiManager$chat$1
            if (r0 == 0) goto L13
            r0 = r15
            com.stepos.agentframework.adapter.ApiManager$chat$1 r0 = (com.stepos.agentframework.adapter.ApiManager$chat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$chat$1 r0 = new com.stepos.agentframework.adapter.ApiManager$chat$1
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r12 = r0.L$3
            com.stepos.agentframework.adapter.netcore.o r12 = (com.stepos.agentframework.adapter.netcore.o) r12
            java.lang.Object r12 = r0.L$2
            r14 = r12
            com.stepos.agentframework.adapter.netcore.h r14 = (com.stepos.agentframework.adapter.netcore.h) r14
            java.lang.Object r12 = r0.L$1
            r13 = r12
            K6.n r13 = (kotlin.C0918n) r13
            java.lang.Object r12 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r12 = (com.stepos.agentframework.adapter.netcore.ApiType) r12
            kotlin.C4849c.b(r15)     // Catch: java.lang.Throwable -> L3c
            goto L95
        L3c:
            r0 = move-exception
            r11 = r0
            r7 = r11
            goto La2
        L40:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L48:
            kotlin.C4849c.b(r15)
            boolean r15 = r11.v(r13, r14)
            if (r15 != 0) goto L52
            return r4
        L52:
            com.stepos.agentframework.adapter.netcore.ApiType r15 = com.stepos.agentframework.adapter.netcore.ApiType.OPENCLAW
            if (r12 == r15) goto L5d
            boolean r15 = r11.x(r13, r14)
            if (r15 != 0) goto L5d
            return r4
        L5d:
            com.stepos.agentframework.adapter.netcore.o r15 = r11.s(r12, r13, r14)
            if (r15 != 0) goto L64
            return r4
        L64:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Chat with type: "
            r2.append(r5)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r5 = 0
            r6 = 4
            java.lang.String r7 = "ApiManager"
            h8.C4148a.k(r7, r2, r5, r6, r4)
            java.lang.Object r12 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L3c
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L3c
            r0.L$1 = r13     // Catch: java.lang.Throwable -> L3c
            r0.L$2 = r14     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r12 = g9.h.a(r15)     // Catch: java.lang.Throwable -> L3c
            r0.L$3 = r12     // Catch: java.lang.Throwable -> L3c
            r0.label = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r15 = r15.E(r13, r14, r0)     // Catch: java.lang.Throwable -> L3c
            if (r15 != r1) goto L95
            return r1
        L95:
            com.stepos.agentframework.adapter.netcore.n r15 = (com.stepos.agentframework.adapter.netcore.n) r15     // Catch: java.lang.Throwable -> L3c
            boolean r12 = r15 instanceof com.stepos.agentframework.adapter.netcore.i
            if (r12 == 0) goto La1
            r12 = r15
            com.stepos.agentframework.adapter.netcore.i r12 = (com.stepos.agentframework.adapter.netcore.i) r12
            r11.k(r12)
        La1:
            return r15
        La2:
            m4.a$a r11 = new m4.a$a
            java.lang.String r12 = r7.getMessage()
            r11.<init>(r12)
            int r12 = r11.code
            java.lang.Integer r12 = g9.C4109a.f(r12)
            java.lang.String r11 = r11.message
            r14.b(r13, r12, r11)
            java.lang.String r11 = r7.getMessage()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Chat failed. Msg:"
            r12.append(r13)
            r12.append(r11)
            java.lang.String r6 = r12.toString()
            r9 = 8
            r10 = 0
            java.lang.String r5 = "ApiManager"
            r8 = 0
            h8.C4148a.g(r5, r6, r7, r8, r9, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.q(com.stepos.agentframework.adapter.netcore.ApiType, K6.n, com.stepos.agentframework.adapter.netcore.h, e9.c):java.lang.Object");
    }

    public final void r(ApiType type) throws AdapterException {
        if (clientMap.get(type) != null) {
            return;
        }
        C4148a.h(TAG, "No client found for type: " + type, false, 4, null);
        throw new AdapterException(new AbstractC4898a.ClientNotFound(type.name()), null);
    }

    public final Object r0(ApiType apiType, VoteRequest voteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new ApiManager$vote$2(apiType, voteRequest, null), interfaceC4014c);
    }

    public final o s(ApiType type, C0918n chatInfo, h eventListener) {
        o oVar = clientMap.get(type);
        if (oVar != null) {
            return oVar;
        }
        C4148a.h(TAG, "No client found for type: " + type, false, 4, null);
        AbstractC4898a.ClientNotFound clientNotFound = new AbstractC4898a.ClientNotFound(type.name());
        if (eventListener != null) {
            eventListener.b(chatInfo, Integer.valueOf(clientNotFound.code), clientNotFound.message);
        }
        return null;
    }

    public final void s0() {
        Z();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(com.stepos.agentframework.adapter.netcore.ApiType r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.adapter.ApiManager$checkImagePrivacy$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.adapter.ApiManager$checkImagePrivacy$1 r0 = (com.stepos.agentframework.adapter.ApiManager$checkImagePrivacy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$checkImagePrivacy$1 r0 = new com.stepos.agentframework.adapter.ApiManager$checkImagePrivacy$1
            r0.<init>(r4, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r4 = r0.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r4 = (com.stepos.agentframework.adapter.netcore.ApiType) r4
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L39
            goto L74
        L39:
            r4 = move-exception
            goto L7b
        L3b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L43:
            kotlin.C4849c.b(r9)
            r4.X(r5)     // Catch: java.lang.Throwable -> L39
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r4 = com.stepos.agentframework.adapter.ApiManager.clientMap     // Catch: java.lang.Throwable -> L39
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L39
            com.stepos.agentframework.adapter.netcore.o r4 = (com.stepos.agentframework.adapter.netcore.o) r4     // Catch: java.lang.Throwable -> L39
            if (r4 == 0) goto L98
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L39
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L39
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L39
            r0.L$2 = r5     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L39
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L39
            r0.label = r3     // Catch: java.lang.Throwable -> L39
            java.lang.Object r9 = r4.N(r6, r7, r8, r0)     // Catch: java.lang.Throwable -> L39
            if (r9 != r1) goto L74
            return r1
        L74:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L39
            boolean r3 = r9.booleanValue()     // Catch: java.lang.Throwable -> L39
            goto L98
        L7b:
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "checkImagePrivacy failed, fail-open. Err:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r5 = 4
            r6 = 0
            java.lang.String r7 = "ApiManager"
            r8 = 0
            h8.C4148a.h(r7, r4, r8, r5, r6)
        L98:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.t(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t0(com.stepos.agentframework.adapter.netcore.ApiType r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super java.lang.Boolean> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1 r0 = (com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1 r0 = new com.stepos.agentframework.adapter.ApiManager$writeCoreFile$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 != r4) goto L3e
            java.lang.Object r10 = r0.L$3
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            java.lang.Object r10 = r0.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r10 = (com.stepos.agentframework.adapter.netcore.ApiType) r10
            kotlin.C4849c.b(r14)     // Catch: java.lang.Throwable -> L3a
            goto L7c
        L3a:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L83
        L3e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L46:
            kotlin.C4849c.b(r14)
            r10.X(r11)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r10 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r10 = r10.get(r11)
            com.stepos.agentframework.adapter.netcore.o r10 = (com.stepos.agentframework.adapter.netcore.o) r10
            if (r10 != 0) goto L5b
            java.lang.Boolean r10 = g9.C4109a.a(r3)
            return r10
        L5b:
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r11     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r11     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r14 = r10.Z(r12, r13, r0)     // Catch: java.lang.Throwable -> L3a
            if (r14 != r1) goto L7c
            return r1
        L7c:
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch: java.lang.Throwable -> L3a
            boolean r3 = r14.booleanValue()     // Catch: java.lang.Throwable -> L3a
            goto L8e
        L83:
            r8 = 8
            r9 = 0
            java.lang.String r4 = "ApiManager"
            java.lang.String r5 = "writeCoreFile failed"
            r7 = 0
            h8.C4148a.g(r4, r5, r6, r7, r8, r9)
        L8e:
            java.lang.Boolean r10 = g9.C4109a.a(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.t0(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    public final void u(ApiType type) throws AdapterException {
        if (inited) {
            return;
        }
        C4148a.k(TAG, "Not init. Need call init first.", false, 4, null);
        throw new AdapterException(AbstractC4898a.e.INSTANCE, null);
    }

    public final boolean v(C0918n chatInfo, h eventListener) {
        if (inited) {
            return true;
        }
        C4148a.k(TAG, "not init. Need call init first.", false, 4, null);
        AbstractC4898a.e eVar = AbstractC4898a.e.INSTANCE;
        eventListener.b(chatInfo, Integer.valueOf(eVar.code), eVar.message);
        return false;
    }

    public final void w() throws AdapterException {
        WeakReference<Context> weakReference = contextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context == null || V(context)) {
            return;
        }
        C4148a.h(TAG, "No Internet Connection.", false, 4, null);
        throw new AdapterException(AbstractC4898a.d.INSTANCE, null);
    }

    public final boolean x(C0918n chatInfo, h eventListener) {
        WeakReference<Context> weakReference = contextRef;
        Context context = weakReference != null ? weakReference.get() : null;
        if (context == null || V(context)) {
            return true;
        }
        C4148a.h(TAG, "No Internet Connection.", false, 4, null);
        AbstractC4898a.d dVar = AbstractC4898a.d.INSTANCE;
        eventListener.b(chatInfo, Integer.valueOf(dVar.code), dVar.message);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(com.stepos.agentframework.adapter.netcore.ApiType r7, java.lang.String r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.adapter.ApiManager$clearSession$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.adapter.ApiManager$clearSession$1 r0 = (com.stepos.agentframework.adapter.ApiManager$clearSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.ApiManager$clearSession$1 r0 = new com.stepos.agentframework.adapter.ApiManager$clearSession$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$2
            com.stepos.agentframework.adapter.netcore.o r6 = (com.stepos.agentframework.adapter.netcore.o) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            com.stepos.agentframework.adapter.netcore.ApiType r6 = (com.stepos.agentframework.adapter.netcore.ApiType) r6
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L6b
            goto L79
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.C4849c.b(r9)
            r6.X(r7)
            java.util.concurrent.ConcurrentHashMap<com.stepos.agentframework.adapter.netcore.ApiType, com.stepos.agentframework.adapter.netcore.o> r6 = com.stepos.agentframework.adapter.ApiManager.clientMap
            java.lang.Object r6 = r6.get(r7)
            com.stepos.agentframework.adapter.netcore.o r6 = (com.stepos.agentframework.adapter.netcore.o) r6
            if (r6 != 0) goto L50
            Y8.t r6 = Y8.t.f7040a
            return r6
        L50:
            java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L6b
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r7 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L6b
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r7 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L6b
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L6b
            r0.label = r3     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r6 = r6.L(r8, r0)     // Catch: java.lang.Throwable -> L6b
            if (r6 != r1) goto L79
            return r1
        L6b:
            r0 = move-exception
            r6 = r0
            r2 = r6
            r4 = 8
            r5 = 0
            java.lang.String r0 = "ApiManager"
            java.lang.String r1 = "clearSession failed"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
        L79:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.ApiManager.y(com.stepos.agentframework.adapter.netcore.ApiType, java.lang.String, e9.c):java.lang.Object");
    }

    public final o z(ApiType apiType, long timeout) {
        switch (a.$EnumSwitchMapping$0[apiType.ordinal()]) {
            case 1:
                return new CozeCoreAgentClient(timeout);
            case 2:
                return new DifyCoreAgentClient(timeout);
            case 3:
                return new BffCoreAgentClient(timeout);
            case 4:
                return new OpenClawCoreAgentClient(timeout);
            case 5:
                return new AgentBusCoreAgentClient();
            case 6:
                return new AgentSpaceCoreAgentClient(timeout);
            case 7:
                return new ABBffCoreAgentClient();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
