package com.stepos.agentframework.chatcore.session;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentcache.sdk.api.LogLevel;
import com.stepos.agentcache.sdk.api.LogMessage;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.agentframework.chatcore.C1846a;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.agentframework.chatcore.audit.RevertedSessionGuard;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.send.SendContext;
import com.stepos.agentframework.chatcore.send.SessionPrefetchStage;
import com.stepos.agentframework.chatcore.send.SilentImageStage;
import com.stepos.agentframework.chatcore.send.SlaSessionAnchor;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.L0;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import f9.C4063a;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C0919o;
import kotlin.C4848b;
import kotlin.Function2;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s4.C5442c;
import t4.InterfaceC5507a;
import u4.AgentMessage;
import u4.AgentTask;
import u4.m;
import w4.C5732a;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\u0092\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u008c\u00032\u00020\u0001:\u0014\u008d\u0003\u008e\u0003\u008f\u0003\u0090\u0003¤\u0001\u0091\u0003\u0092\u0003\u0093\u0003\u0094\u0003\u0095\u0003B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u0012\u001a\u00020\u00112\n\u0010\r\u001a\u00060\fR\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00020\u00162\n\u0010\u0014\u001a\u00060\fR\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J%\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\"\u0010#J+\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010!0&2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\b\u0018\u00010\fR\u00020\u00002\u0006\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\b\u0018\u00010\fR\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b,\u0010+J\u0017\u0010-\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010\u001bJ\u000f\u0010.\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0011H\u0002¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0018\u00010\fR\u00020\u0000H\u0002¢\u0006\u0004\b2\u00103J\u001d\u00106\u001a\u00020\u000f2\f\u00105\u001a\b\u0012\u0004\u0012\u0002040&H\u0002¢\u0006\u0004\b6\u00107JE\u0010<\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0002¢\u0006\u0004\b<\u0010=J'\u0010?\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0016H\u0002¢\u0006\u0004\b?\u0010@J7\u0010C\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010G\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bG\u0010HJ\u0015\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0IH\u0002¢\u0006\u0004\bJ\u0010KJ%\u0010N\u001a\b\u0012\u0004\u0012\u00020$0&2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020LH\u0002¢\u0006\u0004\bN\u0010OJ%\u0010R\u001a\u00060\fR\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010PH\u0002¢\u0006\u0004\bR\u0010SJ)\u0010T\u001a\u00020\u0011*\u00060\fR\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010PH\u0002¢\u0006\u0004\bT\u0010UJ\u001a\u0010X\u001a\u00020\u00162\b\b\u0002\u0010W\u001a\u00020VH\u0082@¢\u0006\u0004\bX\u0010YJ \u0010[\u001a\u0004\u0018\u00010\u000f2\f\b\u0002\u0010Z\u001a\u00060\fR\u00020\u0000H\u0082@¢\u0006\u0004\b[\u0010\\J\u001c\u0010]\u001a\u00020\u00112\n\u0010Z\u001a\u00060\fR\u00020\u0000H\u0082@¢\u0006\u0004\b]\u0010\\J#\u0010_\u001a\u00020\u000f2\n\u0010Z\u001a\u00060\fR\u00020\u00002\u0006\u0010^\u001a\u00020\u000fH\u0002¢\u0006\u0004\b_\u0010`J \u0010a\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0082@¢\u0006\u0004\ba\u0010bJ#\u0010e\u001a\u00020\u00112\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110cH\u0002¢\u0006\u0004\be\u0010fJ\u001f\u0010h\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020\u000fH\u0002¢\u0006\u0004\bh\u0010iJ\u0017\u0010j\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\bj\u0010\u001bJ#\u0010m\u001a\u0004\u0018\u00010$2\u0006\u0010k\u001a\u00020\u000f2\b\u0010l\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010p\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\u000fH\u0002¢\u0006\u0004\bp\u0010\u001bJ\u001d\u0010s\u001a\u00020\u00162\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000f0qH\u0002¢\u0006\u0004\bs\u0010tJ.\u0010u\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000f0qH\u0082@¢\u0006\u0004\bu\u0010vJ3\u0010x\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u000f2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000f0q2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u000f0IH\u0002¢\u0006\u0004\bx\u0010yJ\u001f\u0010{\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020PH\u0002¢\u0006\u0004\b{\u0010|J\u001d\u0010~\u001a\u00020\u00112\f\u0010}\u001a\b\u0012\u0004\u0012\u00020$0&H\u0002¢\u0006\u0004\b~\u0010\u007fJ\u001a\u0010\u0081\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0005\b\u0081\u0001\u0010\u001bJ\u001a\u0010\u0082\u0001\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0005\b\u0082\u0001\u0010\u001bJ\u001b\u0010\u0084\u0001\u001a\u00030\u0083\u00012\b\u00109\u001a\u0004\u0018\u00010\u000f¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001e\u0010\u0086\u0001\u001a\u00030\u0083\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u001f\u0010\u0089\u0001\u001a\u00030\u0083\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0006\b\u0089\u0001\u0010\u0087\u0001J\u0012\u0010\u008a\u0001\u001a\u00020\u0006H\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0012\u0010\u008c\u0001\u001a\u00020\bH\u0000¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0018\u0010\u008e\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0015\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0I¢\u0006\u0005\b\u0090\u0001\u0010KJ\u0017\u0010\u0091\u0001\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0005\b\u0091\u0001\u0010\u001bJ\u001f\u0010\u0092\u0001\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010o\u001a\u00020\u000f¢\u0006\u0005\b\u0092\u0001\u0010iJ\u001f\u0010\u0093\u0001\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f¢\u0006\u0005\b\u0093\u0001\u0010iJ)\u0010\u0095\u0001\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0007\u0010\u0094\u0001\u001a\u00020\u000f¢\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0017\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0IH\u0000¢\u0006\u0005\b\u0097\u0001\u0010KJ\u000f\u0010\u0098\u0001\u001a\u00020\u0016¢\u0006\u0005\b\u0098\u0001\u0010/J\u001a\u0010\u0099\u0001\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u001d\u0010\u009b\u0001\u001a\b\u0018\u00010\fR\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0005\b\u009b\u0001\u0010+J\u0019\u0010\u009d\u0001\u001a\u00020\u000f2\u0007\u0010\u009c\u0001\u001a\u00020\u000f¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0017\u0010\u009f\u0001\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0005\b\u009f\u0001\u0010\u001bJ\u000f\u0010 \u0001\u001a\u00020\u0011¢\u0006\u0005\b \u0001\u00101J.\u0010¥\u0001\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\u00162\u0013\b\u0002\u0010¤\u0001\u001a\f\u0018\u00010¢\u0001j\u0005\u0018\u0001`£\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001JA\u0010ª\u0001\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u000f2'\u0010©\u0001\u001a\"\u0012\u0007\u0012\u0005\u0018\u00010¨\u0001\u0012\u000e\u0012\f\u0018\u00010¢\u0001j\u0005\u0018\u0001`£\u0001\u0012\u0004\u0012\u00020\u00110§\u0001¢\u0006\u0006\bª\u0001\u0010«\u0001J\u001a\u0010\u00ad\u0001\u001a\u00020\u00112\b\u0010©\u0001\u001a\u00030¬\u0001¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J@\u0010°\u0001\u001a\u00020\u00112\r\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0q2\u001f\u0010©\u0001\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160!\u0012\u0004\u0012\u00020\u00110c¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001a\u0010³\u0001\u001a\u00020\u00112\b\u0010©\u0001\u001a\u00030²\u0001¢\u0006\u0006\b³\u0001\u0010´\u0001Jw\u0010º\u0001\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u000f2\u0007\u0010µ\u0001\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0007\u0010¶\u0001\u001a\u00020\u000f2\u0007\u0010·\u0001\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u00162\u000b\b\u0002\u0010¸\u0001\u001a\u0004\u0018\u00010L2\u000b\b\u0002\u0010¹\u0001\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0006\bº\u0001\u0010»\u0001J%\u0010¾\u0001\u001a\u00020\u00112\u0006\u0010F\u001a\u00020E2\b\u0010½\u0001\u001a\u00030¼\u0001H\u0080@¢\u0006\u0006\b¾\u0001\u0010¿\u0001J4\u0010Æ\u0001\u001a\u00020\u00112\b\u0010Á\u0001\u001a\u00030À\u00012\u000e\u0010Ã\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010&2\b\u0010Å\u0001\u001a\u00030Ä\u0001¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001JE\u0010Ê\u0001\u001a\u00020\u00112\b\u0010Á\u0001\u001a\u00030À\u00012\b\u0010È\u0001\u001a\u00030Â\u00012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000f2\u0013\u0010É\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110c¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J(\u0010Í\u0001\u001a\u00020\u00112\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010Ì\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0005\bÍ\u0001\u0010iJ\u0017\u0010Î\u0001\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0005\bÎ\u0001\u0010\u001bJ\u0011\u0010Ï\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0005\bÏ\u0001\u00101J5\u0010Ñ\u0001\u001a\u00020\u00112\b\b\u0002\u0010M\u001a\u00020L2\u0019\u0010Ð\u0001\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0&\u0012\u0004\u0012\u00020\u00110c¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001JE\u0010Õ\u0001\u001a\u00020\u00112\u0007\u0010Ó\u0001\u001a\u00020V2\u0007\u0010Ô\u0001\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020L2\u0019\u0010Ð\u0001\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0&\u0012\u0004\u0012\u00020\u00110c¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u000f\u0010×\u0001\u001a\u00020\u0011¢\u0006\u0005\b×\u0001\u00101J#\u0010Ù\u0001\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\t\b\u0002\u0010Ø\u0001\u001a\u00020V¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001JO\u0010ß\u0001\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u000f2\u0007\u0010\u0088\u0001\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0007\u0010Û\u0001\u001a\u00020L2\u0007\u0010Ü\u0001\u001a\u00020\u000f2\u0007\u0010Ý\u0001\u001a\u00020\u000f2\t\b\u0002\u0010Þ\u0001\u001a\u00020\u000f¢\u0006\u0006\bß\u0001\u0010à\u0001JU\u0010ã\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0007\u0010á\u0001\u001a\u00020\u000f2\b\b\u0002\u0010o\u001a\u00020\u000f2\u000b\b\u0002\u0010â\u0001\u001a\u0004\u0018\u00010\u000f2\u0013\u0010É\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110c¢\u0006\u0006\bã\u0001\u0010ä\u0001J\u0018\u0010å\u0001\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u00020\u000f¢\u0006\u0005\bå\u0001\u0010\u001bJ\u0018\u0010æ\u0001\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u00020\u000f¢\u0006\u0005\bæ\u0001\u0010\u001bJ+\u0010ê\u0001\u001a\u00020\u00112\u0007\u0010ç\u0001\u001a\u00020\u000f2\u0007\u0010è\u0001\u001a\u00020\u000f2\u0007\u0010é\u0001\u001a\u00020\u000f¢\u0006\u0006\bê\u0001\u0010\u0096\u0001JL\u0010ò\u0001\u001a\u00030ñ\u00012\u000e\u0010ì\u0001\u001a\t\u0012\u0005\u0012\u00030ë\u00010&2\u000b\b\u0002\u0010í\u0001\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010î\u0001\u001a\u0004\u0018\u00010\u000f2\f\b\u0002\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0086@¢\u0006\u0006\bò\u0001\u0010ó\u0001J#\u0010ô\u0001\u001a\u0004\u0018\u00010\u000f2\f\b\u0002\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0086@¢\u0006\u0006\bô\u0001\u0010õ\u0001J\u001e\u0010ö\u0001\u001a\u00020\u000f2\f\b\u0002\u0010Z\u001a\u00060\fR\u00020\u0000¢\u0006\u0006\bö\u0001\u0010÷\u0001J\"\u0010ø\u0001\u001a\u00060\fR\u00020\u00002\n\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0000¢\u0006\u0006\bø\u0001\u0010ù\u0001J\u0015\u0010ú\u0001\u001a\u0004\u0018\u00010\u000fH\u0080@¢\u0006\u0006\bú\u0001\u0010û\u0001J/\u0010ý\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0!2\u000e\u0010ü\u0001\u001a\t\u0012\u0005\u0012\u00030Â\u00010&H\u0080@¢\u0006\u0006\bý\u0001\u0010þ\u0001J+\u0010\u0081\u0002\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u00020\u000f2\u0007\u0010ÿ\u0001\u001a\u00020\u000f2\u0007\u0010\u0080\u0002\u001a\u00020L¢\u0006\u0006\b\u0081\u0002\u0010\u0082\u0002J\u000f\u0010\u0083\u0002\u001a\u00020\u0011¢\u0006\u0005\b\u0083\u0002\u00101J\u001f\u0010\u0085\u0002\u001a\u0004\u0018\u00010$2\u000b\b\u0002\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u000f¢\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002J\u0012\u0010\u0087\u0002\u001a\u0004\u0018\u00010$¢\u0006\u0006\b\u0087\u0002\u0010\u0088\u0002J\u0017\u0010\u0089\u0002\u001a\u00020\u00112\u0006\u0010g\u001a\u00020\u000f¢\u0006\u0005\b\u0089\u0002\u0010\u001bJ\u0012\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u000f¢\u0006\u0006\b\u008a\u0002\u0010\u008b\u0002J\u0012\u0010\u008c\u0002\u001a\u0004\u0018\u00010$¢\u0006\u0006\b\u008c\u0002\u0010\u0088\u0002J\u001a\u0010\u008d\u0002\u001a\u0004\u0018\u00010$2\u0006\u0010k\u001a\u00020\u000f¢\u0006\u0006\b\u008d\u0002\u0010\u0086\u0002J:\u0010\u008e\u0002\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2 \b\u0002\u0010©\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010P\u0012\u0004\u0012\u00020\u0011\u0018\u00010§\u0001¢\u0006\u0006\b\u008e\u0002\u0010«\u0001J\u000f\u0010\u008f\u0002\u001a\u00020\u0011¢\u0006\u0005\b\u008f\u0002\u00101JC\u0010\u0091\u0002\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\u0007\u0010\u0090\u0002\u001a\u00020\u000f2 \b\u0002\u0010©\u0001\u001a\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010P\u0012\u0004\u0012\u00020\u0011\u0018\u00010§\u0001¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u0017\u0010\u0093\u0002\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0005\b\u0093\u0002\u0010\u001bJ&\u0010\u0095\u0002\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000f2\t\b\u0002\u0010\u0094\u0002\u001a\u00020\u0016H\u0086@¢\u0006\u0006\b\u0095\u0002\u0010\u0096\u0002J!\u0010\u0097\u0002\u001a\b\u0012\u0004\u0012\u00020$0&2\u0006\u0010\u0015\u001a\u00020\u000fH\u0086@¢\u0006\u0006\b\u0097\u0002\u0010\u0087\u0001J\u001d\u0010\u009a\u0002\u001a\u00020\u00162\b\u0010\u0099\u0002\u001a\u00030\u0098\u0002H\u0086@¢\u0006\u0006\b\u009a\u0002\u0010\u009b\u0002J\u001d\u0010\u009d\u0002\u001a\u00020\u00162\b\u0010\u0099\u0002\u001a\u00030\u009c\u0002H\u0086@¢\u0006\u0006\b\u009d\u0002\u0010\u009e\u0002J\u001d\u0010 \u0002\u001a\u00020\u00162\b\u0010\u0099\u0002\u001a\u00030\u009f\u0002H\u0086@¢\u0006\u0006\b \u0002\u0010¡\u0002J\u001d\u0010£\u0002\u001a\u00020\u00162\b\u0010\u0099\u0002\u001a\u00030¢\u0002H\u0086@¢\u0006\u0006\b£\u0002\u0010¤\u0002J4\u0010§\u0002\u001a\u00030¦\u00022\u0006\u0010\u0015\u001a\u00020\u000f2\u0007\u0010è\u0001\u001a\u00020\u000f2\r\u0010¥\u0002\u001a\b\u0012\u0004\u0012\u00020\u000f0&H\u0086@¢\u0006\u0006\b§\u0002\u0010¨\u0002J!\u0010ª\u0002\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000f2\u0007\u0010©\u0002\u001a\u00020\u000f¢\u0006\u0006\bª\u0002\u0010«\u0002J*\u0010\u00ad\u0002\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000f2\u0007\u0010©\u0002\u001a\u00020\u000f2\u0007\u0010¬\u0002\u001a\u00020$¢\u0006\u0006\b\u00ad\u0002\u0010®\u0002J\u001d\u0010°\u0002\u001a\u00020\u00162\b\u0010\u0099\u0002\u001a\u00030¯\u0002H\u0086@¢\u0006\u0006\b°\u0002\u0010±\u0002J\u0010\u0010²\u0002\u001a\u00020\u000f¢\u0006\u0006\b²\u0002\u0010\u008b\u0002J\u001a\u0010´\u0002\u001a\u00020\u00112\b\u0010Å\u0001\u001a\u00030³\u0002¢\u0006\u0006\b´\u0002\u0010µ\u0002J\u001a\u0010¶\u0002\u001a\u00020\u00112\b\u0010Å\u0001\u001a\u00030³\u0002¢\u0006\u0006\b¶\u0002\u0010µ\u0002R\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010·\u0002\u001a\u0006\b¸\u0002\u0010¹\u0002R\u001a\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u000f\n\u0005\b\u0005\u0010º\u0002\u001a\u0006\b»\u0002\u0010¼\u0002R\u0015\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010½\u0002R\u0015\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\t\u0010¾\u0002R\u0017\u0010¿\u0002\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\b\n\u0006\b¿\u0002\u0010À\u0002R\u0018\u0010Â\u0002\u001a\u00030Á\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0002\u0010Ã\u0002R\u001f\u0010Æ\u0002\u001a\n\u0012\u0005\u0012\u00030Å\u00020Ä\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0002\u0010Ç\u0002R,\u0010È\u0002\u001a\u00060\fR\u00020\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bÈ\u0002\u0010É\u0002\u001a\u0006\bÊ\u0002\u0010Ë\u0002\"\u0005\bÌ\u0002\u00103R\u0017\u0010Í\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÍ\u0002\u0010Î\u0002R\u0018\u0010Ð\u0002\u001a\u00030Ï\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÐ\u0002\u0010Ñ\u0002R)\u0010Ô\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u000f0Ò\u0002j\t\u0012\u0004\u0012\u00020\u000f`Ó\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0002\u0010Õ\u0002R(\u0010Ö\u0002\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\bÖ\u0002\u0010À\u0002\u001a\u0006\b×\u0002\u0010\u008b\u0002\"\u0005\bØ\u0002\u0010\u001bR*\u0010Ù\u0002\u001a\u00030¨\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÙ\u0002\u0010Ú\u0002\u001a\u0006\bÛ\u0002\u0010Ü\u0002\"\u0006\bÝ\u0002\u0010Þ\u0002R,\u0010à\u0002\u001a\u0005\u0018\u00010ß\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bà\u0002\u0010á\u0002\u001a\u0006\bâ\u0002\u0010ã\u0002\"\u0006\bä\u0002\u0010å\u0002R\u0018\u0010æ\u0002\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0002\u0010ç\u0002R!\u0010ì\u0002\u001a\u00030\u0083\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bè\u0002\u0010é\u0002\u001a\u0006\bê\u0002\u0010ë\u0002R.\u0010ñ\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0005\u0012\u00030\u0083\u00010í\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bî\u0002\u0010é\u0002\u001a\u0006\bï\u0002\u0010ð\u0002R,\u0010ó\u0002\u001a\u0005\u0018\u00010ò\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bó\u0002\u0010ô\u0002\u001a\u0006\bõ\u0002\u0010ö\u0002\"\u0006\b÷\u0002\u0010ø\u0002R\u001e\u0010ú\u0002\u001a\t\u0012\u0004\u0012\u00020\u001d0ù\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bú\u0002\u0010û\u0002R#\u0010ì\u0001\u001a\t\u0012\u0004\u0012\u00020\u001d0ü\u00028\u0006¢\u0006\u0010\n\u0006\bì\u0001\u0010ý\u0002\u001a\u0006\bþ\u0002\u0010ÿ\u0002R-\u0010\u0080\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u00060\fR\u00020\u00000í\u00028\u0006¢\u0006\u0010\n\u0006\b\u0080\u0003\u0010\u0081\u0003\u001a\u0006\b\u0082\u0003\u0010ð\u0002R\u0018\u0010\u0084\u0003\u001a\u00030\u0083\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0003\u0010\u0085\u0003R,\u0010\u008b\u0003\u001a\u00030Å\u00022\b\u0010\u0086\u0003\u001a\u00030Å\u00028F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0087\u0003\u0010\u0088\u0003\"\u0006\b\u0089\u0003\u0010\u008a\u0003¨\u0006\u0096\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession;", "", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "config", "Lx4/f;", "messageRepository", "Lx4/e;", "conversationTitleRepository", "<init>", "(Lcom/stepos/agentframework/chatcore/SessionHandler;Lcom/stepos/agentframework/chatcore/session/SessionConfig;Lx4/f;Lx4/e;)V", "Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "conv", "", "", "out", "LY8/t;", "u0", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;Ljava/util/Set;)V", "conversation", "sessionId", "", "v0", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;Ljava/lang/String;)Z", "requestId", "S1", "(Ljava/lang/String;)V", "U0", "Lcom/stepos/agentframework/chatcore/session/L0;", "event", "F0", "(Lcom/stepos/agentframework/chatcore/session/L0;)Ljava/lang/String;", "", "E0", "(Lcom/stepos/agentframework/chatcore/session/L0;)Ljava/util/Map;", "Lw4/c;", "message", "", "H0", "(Lw4/c;)Ljava/util/List;", "id", "P0", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "O0", "P1", "p1", "()Z", "e0", "()V", "C2", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;)V", "Lu4/a;", "messages", "h0", "(Ljava/util/List;)Ljava/lang/String;", DidiCardProvider.KEY_TRACE_ID, "agentId", "inputText", "bizData", "g2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "committedToUI", SdCardDbCreator.FIELD_LASTLOC_INFO, "(Lw4/c;Ljava/lang/String;Z)V", "msgId", "outputText", "e2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "f0", "(Lcom/stepos/agentframework/chatcore/send/e;)Ljava/lang/String;", "", "g0", "()Ljava/util/Set;", "", "limit", "Q0", "(Ljava/lang/String;I)Ljava/util/List;", "Lw4/e;", "title", "H1", "(Ljava/lang/String;Lw4/e;)Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "Y", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;Ljava/lang/String;Lw4/e;)V", "", "timeoutMillis", "E2", "(JLe9/c;)Ljava/lang/Object;", "target", "l2", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;Le9/c;)Ljava/lang/Object;", "a0", "key", "d0", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;Ljava/lang/String;)Ljava/lang/String;", "Z1", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "executor", "m0", "(Lp9/l;)V", "recalledMessageId", "z0", "(Ljava/lang/String;Ljava/lang/String;)V", "h2", "targetSessionId", "liveStreaming", "V1", "(Ljava/lang/String;Lw4/c;)Lw4/c;", "reason", "y1", "", "keys", "w1", "(Ljava/util/Collection;)Z", "y0", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Le9/c;)Ljava/lang/Object;", "insertedKeys", "o2", "(Ljava/lang/String;Ljava/util/Collection;Ljava/util/Set;)V", "row", "M1", "(Ljava/lang/String;Lw4/e;)V", "chats", "M0", "(Ljava/util/List;)V", "fromKey", "G1", "s0", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher;", "c1", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher;", "e1", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "d1", "j1", "()Lx4/f;", SdCardDbCreator.FIELD_LASTLOC_ID, "()Lx4/e;", "v1", "(Ljava/lang/String;)Z", "U", "u2", "F1", "q1", "source", "R1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", ExifInterface.GPS_DIRECTION_TRUE, "o1", "B0", "(Lcom/stepos/agentframework/chatcore/session/L0;)V", "Y0", "passed", "k2", "(Ljava/lang/String;)Ljava/lang/String;", "u1", "r1", "success", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "I1", "(ZLjava/lang/Exception;)V", "Lkotlin/Function2;", "Lw4/a;", "callback", "W0", "(Ljava/lang/String;Lp9/p;)V", "Lcom/stepos/agentframework/chatcore/session/AgentSession$e;", "z1", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$e;)V", "sessionIds", "O1", "(Ljava/util/Collection;Lp9/l;)V", "Lcom/stepos/agentframework/chatcore/session/AgentSession$b;", "N1", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$b;)V", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "terminalStatus", "terminalReason", "statusCode", "statusMessage", "c2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/send/b;", "result", "f2", "(Lcom/stepos/agentframework/chatcore/send/e;Lcom/stepos/agentframework/chatcore/send/b;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "files", "Lt4/a;", "listener", "D2", "(Landroid/content/Context;Ljava/util/List;Lt4/a;)V", "fileInfo", "onResult", "n0", "(Landroid/content/Context;Lcom/stepos/agentframework/chatcore/file/FileInfo;Ljava/lang/String;Lp9/l;)V", "deviceId", "k0", "i0", "i2", "onLoaded", "A1", "(ILp9/l;)V", "beforeTime", "beforeMessageId", "C1", "(JLjava/lang/String;ILp9/l;)V", "q0", "lastReadAt", "D1", "(Ljava/lang/String;J)V", "likeStatus", "questionType", "questionDesc", "taskId", "L0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "decision", "askUserQuestion", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/l;)Z", "o0", "p0", "askUserMessageId", "inquiryId", c.a.COL_SUMMARY, ExifInterface.LONGITUDE_WEST, "LK6/L;", "events", "endsideDeviceId", "endsideTraceId", "Lcom/stepos/agentframework/chatcore/send/l;", LinkHeader.Parameters.Anchor, "LK6/K;", "X", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;Le9/c;)Ljava/lang/Object;", "D0", "(Lcom/stepos/agentframework/chatcore/send/l;Le9/c;)Ljava/lang/Object;", "C0", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;)Ljava/lang/String;", "j2", "(Lcom/stepos/agentframework/chatcore/send/l;)Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "K1", "(Le9/c;)Ljava/lang/Object;", "images", "L1", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "toolCallId", "toolLikeStatus", "B2", "(Ljava/lang/String;Ljava/lang/String;I)V", "Q1", "stoppedMessageId", "T0", "(Ljava/lang/String;)Lw4/c;", "W1", "()Lw4/c;", "N0", "w0", "()Ljava/lang/String;", "X1", "T1", "x0", "n2", "newTitle", "Y1", "(Ljava/lang/String;Ljava/lang/String;Lp9/p;)V", "r0", "emitConversationChanged", "b0", "(Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "Z", "LK6/G;", "request", "y2", "(LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", "w2", "(LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "x2", "(LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", "z2", "(LK6/H;Le9/c;)Ljava/lang/Object;", "answers", "Lcom/stepos/agentframework/adapter/netcore/q;", "v2", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "outboundId", "c0", "(Ljava/lang/String;Ljava/lang/String;)Z", "existing", "m2", "(Ljava/lang/String;Ljava/lang/String;Lw4/c;)Z", "LK6/I;", "A2", "(LK6/I;Le9/c;)Ljava/lang/Object;", "b1", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$a;", "U1", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$a;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/stepos/agentframework/chatcore/SessionHandler;", "i1", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "X0", "()Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "Lx4/f;", "Lx4/e;", "TAG", "Ljava/lang/String;", "Lcom/stepos/agentframework/chatcore/a;", "chatReporter", "Lcom/stepos/agentframework/chatcore/a;", "LXa/k;", "Lcom/stepos/agentframework/chatcore/session/ESessionStatus;", "statusState", "LXa/k;", "topConversation", "Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "n1", "()Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "t2", "sessionMutationLock", "Ljava/lang/Object;", "Leb/a;", "slaSessionMutex", "Leb/a;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "authHoldRequestIds", "Ljava/util/LinkedHashSet;", "migratingFromSessionId", "k1", "setMigratingFromSessionId$chatcore_release", "agentInfo", "Lw4/a;", "V0", "()Lw4/a;", "setAgentInfo", "(Lw4/a;)V", "Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "prepareCallback", "Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "getPrepareCallback", "()Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "r2", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$f;)V", "dispatcher", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher;", "extDispatcher$delegate", "LY8/h;", "h1", "()Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher;", "extDispatcher", "Ljava/util/concurrent/ConcurrentHashMap;", "dispatchers$delegate", "f1", "()Ljava/util/concurrent/ConcurrentHashMap;", "dispatchers", "Lt4/b;", "preProcessingCallback", "Lt4/b;", "l1", "()Lt4/b;", "q2", "(Lt4/b;)V", "LXa/j;", "_events", "LXa/j;", "LXa/o;", "LXa/o;", "g1", "()LXa/o;", "conversationMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Z0", "Lcom/stepos/agentframework/chatcore/session/CloudSessionTitleSync;", "cloudSessionTitleSync", "Lcom/stepos/agentframework/chatcore/session/CloudSessionTitleSync;", UxipConstants.f30680s, "m1", "()Lcom/stepos/agentframework/chatcore/session/ESessionStatus;", "s2", "(Lcom/stepos/agentframework/chatcore/session/ESessionStatus;)V", "status", "Companion", Const.INTENT_KEY_APIKEY, "AgentConversation", "f", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentSession {
    private static final long ACTIVE_CONVERSATION_WINDOW_MS = 14400000;
    public static final int HISTORY_PAGE_SIZE = 10;
    private static final long OFFLINE_SEND_POLL_INTERVAL_MS = 2000;
    private static final long POST_STOP_RETRY_DELAY_MS = 500;
    private static final long POST_STOP_RETRY_WINDOW_MS = 20000;
    private final String TAG;
    private final Xa.j<L0> _events;
    private C5732a agentInfo;
    private final LinkedHashSet<String> authHoldRequestIds;
    private final C1846a chatReporter;
    private final CloudSessionTitleSync cloudSessionTitleSync;
    private final SessionConfig config;
    private final ConcurrentHashMap<String, AgentConversation> conversationMap;
    private final x4.e conversationTitleRepository;
    private final AgentDispatcher dispatcher;

    /* renamed from: dispatchers$delegate, reason: from kotlin metadata */
    private final Y8.h dispatchers;
    private final Xa.o<L0> events;

    /* renamed from: extDispatcher$delegate, reason: from kotlin metadata */
    private final Y8.h extDispatcher;
    private final SessionHandler handler;
    private final x4.f messageRepository;
    private volatile String migratingFromSessionId;
    private t4.b preProcessingCallback;
    private f prepareCallback;
    private final Object sessionMutationLock;
    private final InterfaceC4021a slaSessionMutex;
    private final Xa.k<ESessionStatus> statusState;
    private AgentConversation topConversation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap.KeySetView<String, Boolean> remoteDeleteInFlight = ConcurrentHashMap.newKeySet();

    @Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\rJC\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b%\u0010 J\u000f\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b'\u0010 J\r\u0010(\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)J\u0011\u0010+\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000b¢\u0006\u0004\b.\u0010 J\u0015\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000b¢\u0006\u0004\b0\u0010 J\u001d\u00102\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000b¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u000b¢\u0006\u0004\b4\u0010$J\u001d\u00107\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b¢\u0006\u0004\b7\u00108J%\u0010:\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00109\u001a\u00020*¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\u000b¢\u0006\u0004\b<\u0010$J\r\u0010=\u001a\u00020\b¢\u0006\u0004\b=\u0010\u001cJ7\u0010A\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u000b2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bA\u0010BJ=\u0010D\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020C0\u000e2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bD\u0010EJ?\u0010F\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bF\u0010GJE\u0010H\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020C0\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\b\u0010@\u001a\u0004\u0018\u00010?H\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u000bH\u0016¢\u0006\u0004\bK\u0010 J\u001f\u0010N\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bN\u0010OJ@\u0010P\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013H\u0086@¢\u0006\u0004\bP\u0010QJ(\u0010T\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u000e2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u000eH\u0086@¢\u0006\u0004\bT\u0010UJ=\u0010V\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013¢\u0006\u0004\bV\u0010WJy\u0010^\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b`\u0010aJ\u0015\u0010b\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\bb\u0010aJ\r\u0010c\u001a\u00020\b¢\u0006\u0004\bc\u0010\u001cJ\u0015\u0010d\u001a\u00020\b2\u0006\u0010>\u001a\u00020*¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\b¢\u0006\u0004\bf\u0010\u001cJ\u0015\u0010g\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\bg\u0010\nJ\u001f\u0010k\u001a\u0004\u0018\u00010*2\u0006\u0010h\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020i¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u0004\u0018\u00010*¢\u0006\u0004\bm\u0010,J\u0013\u0010n\u001a\b\u0012\u0004\u0012\u00020*0\u000e¢\u0006\u0004\bn\u0010oJ\u001f\u0010q\u001a\u00020\b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010p\u001a\u00020\u000bH\u0000¢\u0006\u0004\bq\u00103J\u0015\u0010r\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u000b¢\u0006\u0004\br\u0010 J\u0015\u0010s\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u000b¢\u0006\u0004\bs\u0010 R\u0016\u0010t\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010v\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010uR\u0014\u0010w\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bw\u0010uR\"\u0010x\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010)\"\u0004\b{\u0010|R\"\u0010p\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010u\u001a\u0004\b}\u0010$\"\u0004\b~\u0010 R#\u00105\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b5\u0010u\u001a\u0004\b\u007f\u0010$\"\u0005\b\u0080\u0001\u0010 R#\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u0081\u00018\u0006¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R&\u0010\u0086\u0001\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010y\u001a\u0005\b\u0087\u0001\u0010)\"\u0005\b\u0088\u0001\u0010|R2\u0010\u008a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0089\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R \u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R \u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009b\u0001R-\u0010\u009e\u0001\u001a\u0004\u0018\u00010*2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010*8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0005\b \u0001\u0010,R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010¤\u0001\u001a\u00030£\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010\u007fR\u0018\u0010¦\u0001\u001a\u00030¥\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u009b\u0001R\u0018\u0010¬\u0001\u001a\u00030©\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "Lcom/stepos/agentframework/chatcore/session/Y;", "<init>", "(Lcom/stepos/agentframework/chatcore/session/AgentSession;)V", "Lcom/stepos/agentframework/chatcore/session/ChatRound;", ExifInterface.GPS_DIRECTION_TRUE, "()Lcom/stepos/agentframework/chatcore/session/ChatRound;", "round", "LY8/t;", "g0", "(Lcom/stepos/agentframework/chatcore/session/ChatRound;)V", "", "z", "(Le9/c;)Ljava/lang/Object;", "", "Lu4/a;", "messages", "", "deepThinking", "", "meta", "s", "(Lcom/stepos/agentframework/chatcore/session/ChatRound;Ljava/util/List;ZLjava/util/Map;)V", "Lcom/stepos/agentframework/chatcore/session/x0;", "payload", "i0", "(Lcom/stepos/agentframework/chatcore/session/ChatRound;Lcom/stepos/agentframework/chatcore/session/x0;)V", "U", "()V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "id", "f0", "(Ljava/lang/String;)V", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;)Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/String;", "m0", "D", "n0", "P", "()Z", "Lw4/c;", "x", "()Lw4/c;", "reason", "R", "requestId", "O", "source", "b0", "(Ljava/lang/String;Ljava/lang/String;)V", "B", "sessionId", "outboundId", "t", "(Ljava/lang/String;Ljava/lang/String;)Z", "existing", "e0", "(Ljava/lang/String;Ljava/lang/String;Lw4/c;)Z", "C", "y", "message", "Lcom/stepos/agentframework/chatcore/session/AgentSession$c;", "bizCallback", "c", "(Ljava/lang/String;Ljava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;)V", "Lu4/m;", "c0", "(Ljava/util/List;Ljava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;)V", "f", "(Ljava/lang/String;ZLjava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;)V", Const.INTENT_KEY_UMID, "(Ljava/util/List;ZLjava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;)V", "messageId", "a0", "", "delta", "u0", "(Ljava/lang/String;I)V", "h0", "(Ljava/util/List;ZLjava/util/Map;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "d0", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "Y", "(Ljava/util/List;ZLjava/util/Map;)V", "resendMessage", "Lcom/stepos/agentframework/chatcore/session/AgentSession$d;", "sessionCreateCallback", "Lcom/stepos/agentframework/chatcore/session/h1;", "variantGroup", "regenerateRunId", "j0", "(Ljava/util/List;Lw4/c;Lcom/stepos/agentframework/chatcore/session/AgentSession$d;ZLjava/util/Map;Lcom/stepos/agentframework/chatcore/session/AgentSession$c;Lcom/stepos/agentframework/chatcore/session/h1;Ljava/lang/String;)V", "X", "(Lcom/stepos/agentframework/chatcore/session/ChatRound;)Z", "v0", "t0", "q", "(Lw4/c;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "u", "targetMessageId", "Lu4/m$f;", "echo", "r", "(Ljava/lang/String;Lu4/m$f;)Lw4/c;", "M", "F", "()Ljava/util/List;", "tempSessionId", ExifInterface.LONGITUDE_WEST, "v", "w", "agentId", "Ljava/lang/String;", "deviceId", "TAG", "isTempSession", "Z", "Q", "q0", "(Z)V", "N", "r0", "J", "p0", "", "retiredSessionIds", "Ljava/util/Set;", "I", "()Ljava/util/Set;", "isIndependentConversation", "isIndependentConversation$chatcore_release", "setIndependentConversation$chatcore_release", "LUa/u;", "pendingSessionIdReady", "LUa/u;", "G", "()LUa/u;", "o0", "(LUa/u;)V", "Lcom/stepos/agentframework/chatcore/send/SessionPrefetchStage;", LinkHeader.Rel.Prefetch, "Lcom/stepos/agentframework/chatcore/send/SessionPrefetchStage;", "H", "()Lcom/stepos/agentframework/chatcore/send/SessionPrefetchStage;", "Lcom/stepos/agentframework/chatcore/send/SilentImageStage;", "silentImages", "Lcom/stepos/agentframework/chatcore/send/SilentImageStage;", "K", "()Lcom/stepos/agentframework/chatcore/send/SilentImageStage;", "chatRound", "Lcom/stepos/agentframework/chatcore/session/ChatRound;", "settledRound", UxipConstants.f30680s, "stoppedAssistantSnapshot", "Lw4/c;", "L", "pendingSend", "Lcom/stepos/agentframework/chatcore/session/x0;", "", "recentUserStopAtMs", "", "offlineHoldLock", "Ljava/lang/Object;", "offlineHoldingRound", "Lcom/stepos/agentframework/chatcore/session/AgentSession;", ExifInterface.LONGITUDE_EAST, "()Lcom/stepos/agentframework/chatcore/session/AgentSession;", "owner", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class AgentConversation implements Y {
        private String agentId;
        private ChatRound chatRound;
        private String deviceId;
        private boolean isIndependentConversation;
        private boolean isTempSession;
        private volatile ChatRound offlineHoldingRound;
        private volatile PendingSend pendingSend;
        private volatile InterfaceC1083u<Y8.t> pendingSessionIdReady;
        private final SessionPrefetchStage prefetch;
        private volatile long recentUserStopAtMs;
        private ChatRound settledRound;
        private final SilentImageStage silentImages;
        private ChatMessage stoppedAssistantSnapshot;
        private final String TAG = " [AgentConversation] ";
        private String tempSessionId = "";
        private String sessionId = "";
        private final Set<String> retiredSessionIds = new LinkedHashSet();
        private final Object offlineHoldLock = new Object();

        public AgentConversation() {
            this.agentId = AgentSession.this.getConfig().getAgentId();
            this.prefetch = new SessionPrefetchStage(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSession.AgentConversation.Z(agentSession, (InterfaceC5074l) obj);
                }
            }, new AgentSession$AgentConversation$prefetch$2(AgentSession.this, null));
            this.silentImages = new SilentImageStage(AgentSession.this.getConfig().getSilentUploadWaitMs(), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSession.AgentConversation.s0(agentSession, (InterfaceC5074l) obj);
                }
            }, new AgentSession$AgentConversation$silentImages$2(AgentSession.this, null));
        }

        public static final Ua.Q Z(AgentSession agentSession, InterfaceC5074l block) {
            kotlin.jvm.internal.p.i(block, "block");
            return agentSession.getHandler().z0(new AgentSession$AgentConversation$prefetch$1$1(block, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void k0(AgentConversation agentConversation, List list, ChatMessage chatMessage, d dVar, boolean z10, Map map, c cVar, VariantGroupTag variantGroupTag, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                chatMessage = null;
            }
            if ((i10 & 4) != 0) {
                dVar = null;
            }
            if ((i10 & 8) != 0) {
                z10 = false;
            }
            if ((i10 & 16) != 0) {
                map = null;
            }
            if ((i10 & 32) != 0) {
                cVar = null;
            }
            if ((i10 & 64) != 0) {
                variantGroupTag = null;
            }
            if ((i10 & 128) != 0) {
                str = null;
            }
            agentConversation.j0(list, chatMessage, dVar, z10, map, cVar, variantGroupTag, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final Y8.t l0(AgentConversation agentConversation, AgentSession agentSession, List list, ChatMessage chatMessage, Map map, String str, boolean z10, Map map2, boolean z11) {
            List list2;
            ChatRound chatRound = agentConversation.chatRound;
            if (chatRound != 0) {
                list2 = list;
                chatRound.t1(agentSession.getAgentInfo().getAgentId(), list2, chatMessage, map != null ? (String) map.get(RequestParameter.META_KEY_MESSAGE_ID) : null, map != null ? (String) map.get(RequestParameter.META_KEY_IMAGE_MESSAGE_ID) : null, map != null ? (String) map.get(RequestParameter.META_KEY_FILE_MESSAGE_ID) : null);
            } else {
                list2 = list;
            }
            ChatRound chatRound2 = agentConversation.chatRound;
            if (chatRound2 != null) {
                ChatRound.r1(chatRound2, null, 1, null);
            }
            ChatRound chatRound3 = agentConversation.chatRound;
            if (chatRound3 != null) {
                agentConversation.pendingSend = new PendingSend(chatRound3, list2, z10, map2);
            }
            ChatRound chatRound4 = agentConversation.chatRound;
            if (chatRound4 != null) {
                chatRound4.Y1();
            }
            if (z11) {
                C5442c.l(C5442c.INSTANCE, str, "ready", null, null, "AgentSession.AgentConversation.sendMessage", 12, null);
                agentConversation.Y(list2, z10, map2);
            } else {
                C5442c c5442c = C5442c.INSTANCE;
                com.stepos.agentframework.chatcore.utils.n nVar = com.stepos.agentframework.chatcore.utils.n.INSTANCE;
                ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
                c5442c.k(str, "notReady", Z8.Q.f(Y8.j.a("networkUsable", Boolean.valueOf(nVar.b(chatCoreSdk.c())))), ExifInterface.LONGITUDE_WEST, "AgentSession.AgentConversation.sendMessage");
                if (nVar.b(chatCoreSdk.c())) {
                    ChatRound chatRound5 = agentConversation.chatRound;
                    kotlin.jvm.internal.p.f(chatRound5);
                    chatRound5.c(new AgentError(AgentError.ERROR_CODE_INIT, "agent init error", null, 4, null));
                } else {
                    C4148a.u(agentConversation.TAG, "network unavailable, hold this round in SENDING phase", false, 4, null);
                    ChatRound chatRound6 = agentConversation.chatRound;
                    kotlin.jvm.internal.p.f(chatRound6);
                    agentConversation.s(chatRound6, list2, z10, map2);
                }
            }
            return Y8.t.f7040a;
        }

        public static final Ua.Q s0(AgentSession agentSession, InterfaceC5074l block) {
            kotlin.jvm.internal.p.i(block, "block");
            return agentSession.getHandler().z0(new AgentSession$AgentConversation$silentImages$1$1(block, null));
        }

        /* renamed from: A, reason: from getter */
        public final String getAgentId() {
            return this.agentId;
        }

        public final String B() {
            String str = this.sessionId;
            return str.length() == 0 ? this.tempSessionId : str;
        }

        public final String C() {
            String traceId;
            ChatRound chatRound = this.chatRound;
            return (chatRound == null || (traceId = chatRound.getTraceId()) == null) ? "" : traceId;
        }

        /* renamed from: D, reason: from getter */
        public final String getDeviceId() {
            return this.deviceId;
        }

        /* renamed from: E, reason: from getter */
        public final AgentSession getThis$0() {
            return AgentSession.this;
        }

        public final List<ChatMessage> F() {
            ChatRound chatRound = this.chatRound;
            List<ChatMessage> listG0 = chatRound != null ? chatRound.G0() : null;
            return listG0 == null ? C1173v.m() : listG0;
        }

        public final InterfaceC1083u<Y8.t> G() {
            return this.pendingSessionIdReady;
        }

        /* renamed from: H, reason: from getter */
        public final SessionPrefetchStage getPrefetch() {
            return this.prefetch;
        }

        public final Set<String> I() {
            return this.retiredSessionIds;
        }

        /* renamed from: J, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: K, reason: from getter */
        public final SilentImageStage getSilentImages() {
            return this.silentImages;
        }

        /* renamed from: L, reason: from getter */
        public final ChatMessage getStoppedAssistantSnapshot() {
            return this.stoppedAssistantSnapshot;
        }

        public final ChatMessage M() {
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                return chatRound.K0();
            }
            return null;
        }

        /* renamed from: N, reason: from getter */
        public final String getTempSessionId() {
            return this.tempSessionId;
        }

        public final void O(String requestId) {
            kotlin.jvm.internal.p.i(requestId, "requestId");
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                chatRound.P0(requestId);
            }
        }

        public final boolean P() {
            return this.chatRound != null;
        }

        /* renamed from: Q, reason: from getter */
        public final boolean getIsTempSession() {
            return this.isTempSession;
        }

        public final void R(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                chatRound.i1(reason);
            }
        }

        public final boolean S(String id) {
            kotlin.jvm.internal.p.i(id, "id");
            return C1961w.c(id, this.sessionId, this.tempSessionId, this.retiredSessionIds);
        }

        public final ChatRound T() {
            ChatRound chatRound = this.chatRound;
            return chatRound == null ? this.settledRound : chatRound;
        }

        public final void U() {
            AgentSession.this.getHandler().H2();
        }

        public final void V() {
            AgentSession.this.getHandler().H2();
        }

        public final void W(String sessionId, String tempSessionId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(tempSessionId, "tempSessionId");
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                chatRound.y1(sessionId, tempSessionId);
            }
        }

        public final boolean X(ChatRound round) {
            kotlin.jvm.internal.p.i(round, "round");
            if (this.chatRound != round) {
                C4148a.k(this.TAG, "onSendPhaseNetworkHold rejected: round is no longer current", false, 4, null);
                return false;
            }
            PendingSend c1964x0 = this.pendingSend;
            if (c1964x0 == null || c1964x0.getRound() != round) {
                c1964x0 = null;
            }
            if (c1964x0 == null) {
                C4148a.u(this.TAG, "onSendPhaseNetworkHold rejected: no pending send payload", false, 4, null);
                return false;
            }
            s(round, c1964x0.b(), c1964x0.getDeepThinking(), c1964x0.c());
            return true;
        }

        public final void Y(List<AgentMessage> messages, boolean deepThinking, Map<String, String> meta) {
            kotlin.jvm.internal.p.i(messages, "messages");
            Function2.a(new AgentSession$AgentConversation$preProcessing$1(messages, this, AgentSession.this, deepThinking, meta, null));
        }

        public void a0(String messageId) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            C4148a.k(this.TAG, "regenerate messageId:" + messageId, false, 4, null);
            Function2.a(new AgentSession$AgentConversation$regenerate$1(AgentSession.this, messageId, this, null));
        }

        public final void b0(String requestId, String source) {
            kotlin.jvm.internal.p.i(requestId, "requestId");
            kotlin.jvm.internal.p.i(source, "source");
            ChatRound chatRound = this.chatRound;
            ChatRound chatRound2 = this.settledRound;
            if (chatRound != null || chatRound2 != null) {
                if (chatRound != null) {
                    chatRound.J1(requestId, source);
                }
                if (chatRound2 == null || chatRound2 == chatRound) {
                    return;
                }
                chatRound2.J1(requestId, source);
                return;
            }
            C4148a.k(this.TAG, "releaseExternalUserDecision miss: no round session=" + this.sessionId + " req=" + requestId + " source=" + source, false, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.stepos.agentframework.chatcore.session.Y
        public void c(String message, Map<String, String> meta, c bizCallback) {
            kotlin.jvm.internal.p.i(message, "message");
            C4148a.k(this.TAG, "sendTextMessage len=" + message.length(), false, 4, null);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new m.TextMessage(message, null, 2, 0 == true ? 1 : 0));
            k0(this, AgentMessage.INSTANCE.a(arrayList), null, null, false, meta, bizCallback, null, null, 206, null);
        }

        public void c0(List<? extends u4.m> messages, Map<String, String> meta, c bizCallback) {
            kotlin.jvm.internal.p.i(messages, "messages");
            k0(this, AgentMessage.INSTANCE.a(messages), null, null, false, meta, bizCallback, null, null, 206, null);
        }

        @Override // com.stepos.agentframework.chatcore.session.Y
        public void d(List<? extends u4.m> messages, boolean deepThinking, Map<String, String> meta, c bizCallback) {
            kotlin.jvm.internal.p.i(messages, "messages");
            k0(this, AgentMessage.INSTANCE.a(messages), null, null, deepThinking, meta, bizCallback, null, null, 198, null);
        }

        public final Object d0(List<FileInfo> list, InterfaceC4014c<? super List<FileInfo>> interfaceC4014c) {
            return this.silentImages.f(list, interfaceC4014c);
        }

        public final boolean e0(String sessionId, String outboundId, ChatMessage existing) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(outboundId, "outboundId");
            kotlin.jvm.internal.p.i(existing, "existing");
            if (existing.getMessageId().length() == 0) {
                C4148a.u(this.TAG, "resumeInboundAfterRetry skip: empty assistant messageId", false, 4, null);
                return false;
            }
            if (ApiManager.INSTANCE.L(outboundId)) {
                C4148a.k(this.TAG, "resumeInboundAfterRetry idempotent outboundId=" + outboundId, false, 4, null);
                return true;
            }
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                chatRound.f0("client.superseded");
            }
            this.chatRound = null;
            this.settledRound = null;
            String traceId = existing.getTraceId();
            if (traceId.length() == 0) {
                traceId = f1.INSTANCE.a();
            }
            String str = traceId;
            C0919o.j(str);
            ChatRound chatRound2 = new ChatRound(AgentSession.this, this, null, str, null, null, 48, null);
            this.chatRound = chatRound2;
            String strB = B();
            if (strB.length() > 0) {
                AgentSession.this.Z0().put(strB, this);
            }
            chatRound2.b0(existing);
            chatRound2.Z1(existing);
            AgentDispatcher.RequestWrapper requestWrapperE = AgentSession.this.c1(getAgentId()).e(sessionId, outboundId, chatRound2);
            chatRound2.T1(requestWrapperE);
            boolean z10 = requestWrapperE.getRequest() != null;
            V();
            C4148a.k(this.TAG, "resumeInboundAfterRetry sessionId=" + sessionId + " outboundId=" + outboundId + " messageId=" + existing.getMessageId() + " registered=" + z10, false, 4, null);
            return z10;
        }

        @Override // com.stepos.agentframework.chatcore.session.Y
        public void f(String message, boolean deepThinking, Map<String, String> meta, c bizCallback) {
            kotlin.jvm.internal.p.i(message, "message");
            C4148a.k(this.TAG, "sendTextMessage len=" + message.length() + " deepThinking=" + deepThinking, false, 4, null);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AgentMessage(AgentMessageType.TEXT, message, null, null, false, false, 60, null));
            k0(this, arrayList, null, null, deepThinking, meta, bizCallback, null, null, 198, null);
        }

        public final void f0(String id) {
            kotlin.jvm.internal.p.i(id, "id");
            if (id.length() > 0) {
                this.retiredSessionIds.add(id);
            }
        }

        public final void g0(ChatRound round) {
            if (this.chatRound == round) {
                return;
            }
            this.chatRound = round;
            this.settledRound = null;
            String strB = B();
            if (strB.length() > 0) {
                AgentSession.this.Z0().put(strB, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object h0(java.util.List<u4.AgentMessage> r22, boolean r23, java.util.Map<java.lang.String, java.lang.String> r24, e9.InterfaceC4014c<? super Y8.t> r25) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 463
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation.h0(java.util.List, boolean, java.util.Map, e9.c):java.lang.Object");
        }

        public final void i0(ChatRound round, PendingSend payload) {
            Function2.a(new AgentSession$AgentConversation$schedulePostStopRedispatch$1(round, this, payload, null));
        }

        public final void j() {
            ChatRound chatRound = this.chatRound;
            if (chatRound == null) {
                return;
            }
            C4148a.k(this.TAG, "abandonRoundForRetry", false, 4, null);
            chatRound.u();
            u(chatRound);
        }

        public final void j0(final List<AgentMessage> messages, final ChatMessage resendMessage, d sessionCreateCallback, final boolean deepThinking, final Map<String, String> meta, c bizCallback, VariantGroupTag variantGroup, String regenerateRunId) {
            kotlin.jvm.internal.p.i(messages, "messages");
            InterfaceC1083u<Y8.t> interfaceC1083u = this.pendingSessionIdReady;
            if (interfaceC1083u != null && !interfaceC1083u.g()) {
                Function2.b(new AgentSession$AgentConversation$sendMessage$1(interfaceC1083u, this, messages, resendMessage, sessionCreateCallback, deepThinking, meta, bizCallback, variantGroup, regenerateRunId, null));
                return;
            }
            C4148a.k(this.TAG, "sendMessage message:" + messages.size(), false, 4, null);
            C0919o.k("框架·进入会话发送(sendMessage)");
            if (this.sessionId.length() == 0 && this.tempSessionId.length() == 0) {
                this.isTempSession = true;
                String strI = ConversationSessionIds.INSTANCE.i();
                this.tempSessionId = strI;
                C4148a.k(this.TAG, "sessionId is empty, using tempSessionId:" + strI, false, 4, null);
            }
            String strB = B();
            if (strB.length() <= 0) {
                strB = null;
            }
            if (strB != null) {
                AgentSession.this.getHandler().H3(strB, false);
            }
            String strA = meta != null ? meta.get("trace_id") : null;
            if (strA == null) {
                strA = "";
            }
            if (strA.length() == 0) {
                strA = f1.INSTANCE.a();
            }
            final String str = strA;
            final Map mapS = kotlin.collections.a.s(meta == null ? kotlin.collections.a.i() : meta, Y8.j.a("trace_id", str));
            C0919o.j(str);
            C5442c c5442c = C5442c.INSTANCE;
            Pair pairA = Y8.j.a("sessionId", this.sessionId);
            Pair pairA2 = Y8.j.a("tempSessionId", this.tempSessionId);
            Pair pairA3 = Y8.j.a("isTempSession", Boolean.valueOf(this.isTempSession));
            Pair pairA4 = Y8.j.a("messageSize", Integer.valueOf(messages.size()));
            List<AgentMessage> list = messages;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((AgentMessage) it.next()).getType().name());
            }
            C5442c.l(c5442c, str, "start", kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, Y8.j.a("messageTypes", arrayList), Y8.j.a("meta", mapS), Y8.j.a("deepThinking", Boolean.valueOf(deepThinking))), null, "AgentSession.AgentConversation.sendMessage", 8, null);
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                chatRound.f0("client.superseded");
            }
            this.chatRound = null;
            this.stoppedAssistantSnapshot = null;
            this.settledRound = null;
            this.chatRound = new ChatRound(AgentSession.this, this, sessionCreateCallback, str, variantGroup, regenerateRunId);
            if (bizCallback != null) {
                SessionHandler handler = AgentSession.this.getHandler();
                ChatRound chatRound2 = this.chatRound;
                kotlin.jvm.internal.p.f(chatRound2);
                handler.Z2(chatRound2.getPairId(), bizCallback);
            }
            String strB2 = B();
            if (strB2.length() > 0) {
                AgentSession.this.Z0().put(strB2, this);
            }
            V();
            final AgentSession agentSession = AgentSession.this;
            agentSession.m0(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.r
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AgentSession.AgentConversation.l0(this.f22736a, agentSession, messages, resendMessage, meta, str, deepThinking, mapS, ((Boolean) obj).booleanValue());
                }
            });
        }

        public final void m0(String id) {
            if (id != null) {
                this.agentId = id;
            }
        }

        public final void n0(String id) {
            if (id != null) {
                this.deviceId = id;
            }
        }

        public final void o0(InterfaceC1083u<Y8.t> interfaceC1083u) {
            this.pendingSessionIdReady = interfaceC1083u;
        }

        public final void p0(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.sessionId = str;
        }

        public final void q(ChatMessage message) {
            kotlin.jvm.internal.p.i(message, "message");
            ChatRound chatRound = this.chatRound;
            if (chatRound != null && message.getRole() == AgentRole.ASSISTANT && message.getStatus().isTerminal() && kotlin.jvm.internal.p.d(chatRound.Y(), message.getMessageId())) {
                chatRound.U1(message.getStatus());
                if (this.chatRound == chatRound) {
                    this.chatRound = null;
                    if (this.settledRound == chatRound) {
                        this.settledRound = null;
                    }
                    PendingSend c1964x0 = this.pendingSend;
                    if ((c1964x0 != null ? c1964x0.getRound() : null) == chatRound) {
                        this.pendingSend = null;
                    }
                    U();
                }
            }
        }

        public final void q0(boolean z10) {
            this.isTempSession = z10;
        }

        public final ChatMessage r(String targetMessageId, m.InquiryMessage echo) {
            kotlin.jvm.internal.p.i(targetMessageId, "targetMessageId");
            kotlin.jvm.internal.p.i(echo, "echo");
            ChatRound chatRoundT = T();
            if (chatRoundT != null) {
                return chatRoundT.Q(targetMessageId, echo);
            }
            return null;
        }

        public final void r0(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.tempSessionId = str;
        }

        public final void s(ChatRound round, List<AgentMessage> messages, boolean deepThinking, Map<String, String> meta) {
            synchronized (this.offlineHoldLock) {
                if (this.offlineHoldingRound == round) {
                    C4148a.k(this.TAG, "awaitNetworkThenSend skipped: already waiting for network on this round", false, 4, null);
                    return;
                }
                this.offlineHoldingRound = round;
                Y8.t tVar = Y8.t.f7040a;
                Function2.a(new AgentSession$AgentConversation$awaitNetworkThenSend$2(round, this, AgentSession.this, messages, deepThinking, meta, null));
            }
        }

        public final boolean t(String sessionId, String outboundId) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(outboundId, "outboundId");
            ChatRound chatRound = this.chatRound;
            if (chatRound == null) {
                chatRound = this.settledRound;
            }
            if (kotlin.jvm.internal.p.d(chatRound != null ? chatRound.Y() : null, outboundId) && ApiManager.INSTANCE.L(outboundId)) {
                C4148a.k(this.TAG, "beginServerInitiatedRound idempotent outboundId=" + outboundId, false, 4, null);
                return true;
            }
            if (chatRound != null && chatRound.e0()) {
                g0(chatRound);
                if (!kotlin.jvm.internal.p.d(chatRound.Y(), outboundId)) {
                    chatRound.c0(outboundId);
                }
                AgentDispatcher.RequestWrapper requestWrapperE = AgentSession.this.c1(getAgentId()).e(sessionId, outboundId, chatRound);
                chatRound.T1(requestWrapperE);
                boolean z10 = requestWrapperE.getRequest() != null;
                C4148a.k(this.TAG, "beginServerInitiatedRound reused held round sessionId=" + sessionId + " outboundId=" + outboundId + " registered=" + z10, false, 4, null);
                return z10;
            }
            ChatRound chatRound2 = this.chatRound;
            if (chatRound2 != null) {
                chatRound2.f0("client.superseded");
            }
            this.chatRound = null;
            this.settledRound = null;
            String strA = f1.INSTANCE.a();
            C0919o.j(strA);
            ChatRound chatRound3 = new ChatRound(AgentSession.this, this, null, strA, null, null, 48, null);
            this.chatRound = chatRound3;
            String strB = B();
            if (strB.length() > 0) {
                AgentSession.this.Z0().put(strB, this);
            }
            chatRound3.q1(outboundId);
            chatRound3.b2();
            AgentDispatcher.RequestWrapper requestWrapperE2 = AgentSession.this.c1(getAgentId()).e(sessionId, outboundId, chatRound3);
            chatRound3.T1(requestWrapperE2);
            boolean z11 = requestWrapperE2.getRequest() != null;
            C4148a.k(this.TAG, "beginServerInitiatedRound sessionId=" + sessionId + " outboundId=" + outboundId + " registered=" + z11, false, 4, null);
            return z11;
        }

        public final void t0() {
            ChatMessage chatMessageK0;
            C4148a.k(this.TAG, com.stepos.ailauncher.chat.trace.g.ACTION_STOP, false, 4, null);
            this.recentUserStopAtMs = System.currentTimeMillis();
            String strB = B();
            C5442c c5442c = C5442c.INSTANCE;
            ChatRound chatRound = this.chatRound;
            C5442c.l(c5442c, chatRound != null ? chatRound.getTraceId() : null, "request", null, null, "AgentSession.AgentConversation.stop", 12, null);
            ChatRound chatRound2 = this.chatRound;
            boolean z10 = chatRound2 != null;
            if (chatRound2 == null || (chatMessageK0 = chatRound2.K0()) == null || K.e(chatMessageK0)) {
                chatMessageK0 = null;
            }
            this.stoppedAssistantSnapshot = chatMessageK0;
            ChatRound chatRound3 = this.chatRound;
            if (chatRound3 != null) {
                chatRound3.n1();
            }
            ChatRound chatRound4 = this.chatRound;
            if (chatRound4 != null) {
                ChatRound.g0(chatRound4, null, 1, null);
            }
            this.chatRound = null;
            this.settledRound = null;
            this.pendingSend = null;
            if (strB.length() > 0 && AgentSession.this.Z0().get(strB) == this) {
                AgentSession.this.Z0().remove(strB);
            }
            if (z10) {
                U();
            }
        }

        public final void u(ChatRound round) {
            kotlin.jvm.internal.p.i(round, "round");
            C4148a.k(this.TAG, "chatPairFinish", false, 4, null);
            if (this.chatRound == round) {
                this.chatRound = null;
                this.settledRound = round;
                PendingSend c1964x0 = this.pendingSend;
                if ((c1964x0 != null ? c1964x0.getRound() : null) == round) {
                    this.pendingSend = null;
                }
                String strB = B();
                if (strB.length() > 0 && AgentSession.this.Z0().get(strB) == this) {
                    AgentSession.this.Z0().remove(strB);
                }
                U();
            }
        }

        public void u0(String messageId, int delta) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            C4148a.k(this.TAG, "switchVariant messageId:" + messageId + " delta:" + delta, false, 4, null);
            if (delta == 0) {
                return;
            }
            Function2.a(new AgentSession$AgentConversation$switchVariant$1(AgentSession.this, messageId, this, delta, null));
        }

        public final void v(String messageId) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                chatRound.l0(messageId);
            }
        }

        public final boolean v0(ChatRound round) {
            PendingSend c1964x0;
            kotlin.jvm.internal.p.i(round, "round");
            if (this.chatRound != round) {
                C4148a.k(this.TAG, "tryHoldPostStopSendRetry rejected: round is no longer current", false, 4, null);
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.recentUserStopAtMs;
            if (this.recentUserStopAtMs > 0 && 0 <= jCurrentTimeMillis && jCurrentTimeMillis < 20001 && (c1964x0 = this.pendingSend) != null) {
                PendingSend c1964x02 = c1964x0.getRound() == round ? c1964x0 : null;
                if (c1964x02 == null || !round.k0()) {
                    return false;
                }
                i0(round, c1964x02);
                return true;
            }
            return false;
        }

        public final void w(String messageId) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            ChatRound chatRound = this.chatRound;
            if (chatRound != null) {
                chatRound.m0(messageId);
            }
        }

        public final ChatMessage x() {
            ChatMessage chatMessage = this.stoppedAssistantSnapshot;
            this.stoppedAssistantSnapshot = null;
            return chatMessage;
        }

        public final void y() {
            String strB = B();
            if (strB.length() > 0 && AgentSession.this.Z0().get(strB) == this) {
                AgentSession.this.Z0().remove(strB);
            }
            this.sessionId = "";
            this.tempSessionId = "";
            this.isTempSession = false;
            this.prefetch.c();
            C4148a.k(this.TAG, "detachSessionAfterUserRevert dropped key:" + strB, false, 4, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:126:0x036f, code lost:
        
            if (r12 == r1) goto L131;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x0396, code lost:
        
            if (r12 == r1) goto L131;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0115, code lost:
        
            if (r12 == r1) goto L131;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0200, code lost:
        
            if (r12 == r1) goto L131;
         */
        /* JADX WARN: Removed duplicated region for block: B:100:0x02bc  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x02ff  */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0317  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x033c  */
        /* JADX WARN: Removed duplicated region for block: B:129:0x0375  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x03db  */
        /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x02ae  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x02b3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object z(e9.InterfaceC4014c<? super java.lang.String> r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1010
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation.z(e9.c):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012RT\u0010\u0019\u001aB\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00180\u0018 \u0017* \u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u0016\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u00150\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "config", "Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "callback", "Lcom/stepos/agentframework/chatcore/session/AgentSession;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/SessionHandler;Lcom/stepos/agentframework/chatcore/session/SessionConfig;Lcom/stepos/agentframework/chatcore/session/AgentSession$f;)Lcom/stepos/agentframework/chatcore/session/AgentSession;", "", "HISTORY_PAGE_SIZE", "I", "", "OFFLINE_SEND_POLL_INTERVAL_MS", "J", "POST_STOP_RETRY_WINDOW_MS", "POST_STOP_RETRY_DELAY_MS", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "kotlin.jvm.PlatformType", "", "remoteDeleteInFlight", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "ACTIVE_CONVERSATION_WINDOW_MS", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AgentSession a(SessionHandler handler, SessionConfig config, f callback) {
            kotlin.jvm.internal.p.i(handler, "handler");
            kotlin.jvm.internal.p.i(config, "config");
            AgentSession agentSession = new AgentSession(handler, config, null, null, 12, null);
            if (callback != null) {
                agentSession.r2(callback);
            }
            return agentSession;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$b;", "", "", "Lw4/e;", "titles", "LY8/t;", "onResult", "(Ljava/util/List;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        void onResult(List<w4.e> titles);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$c;", "", "", "result", "LY8/t;", "onSuccess", "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", "c", "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface c {
        void c(AgentError e10);

        void onSuccess(String result);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$d;", "", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface d {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$e;", "", "", "Lw4/e;", "titles", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface e {
        void a(List<w4.e> titles);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$f;", "", "Lcom/stepos/agentframework/chatcore/session/ESessionStatus;", "status", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/ESessionStatus;)V", "", "sessionId", "", "Lw4/c;", "messages", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface f {
        void a(ESessionStatus status);

        void b(String sessionId, List<ChatMessage> messages);

        void i(AgentError e10);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$g;", "", "Lw4/c;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/c;)V", "", "success", "", "code", "", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/Integer;Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface g {
        void a(ChatMessage message);

        default void b(boolean success, Integer code, String message) {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$h;", "", "", "sessionId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface h {
        void a(String sessionId);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentSession$i;", "", "Lw4/c;", "message", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/c;Lcom/stepos/agentframework/chatcore/intent/e;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface i {
        void a(ChatMessage message, AgentTool tool);
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class j {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ESessionStatus.values().length];
            try {
                iArr[ESessionStatus.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ESessionStatus.PREPARING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession(SessionHandler handler, SessionConfig config, x4.f messageRepository, x4.e conversationTitleRepository) {
        kotlin.jvm.internal.p.i(handler, "handler");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(messageRepository, "messageRepository");
        kotlin.jvm.internal.p.i(conversationTitleRepository, "conversationTitleRepository");
        this.handler = handler;
        this.config = config;
        this.messageRepository = messageRepository;
        this.conversationTitleRepository = conversationTitleRepository;
        this.TAG = "AgentSession";
        this.chatReporter = new C1846a();
        this.statusState = Xa.u.a(ESessionStatus.PREPARING);
        this.topConversation = new AgentConversation();
        this.sessionMutationLock = new Object();
        this.slaSessionMutex = eb.f.b(false, 1, null);
        this.authHoldRequestIds = new LinkedHashSet<>();
        this.migratingFromSessionId = "";
        this.agentInfo = new C5732a(config.getAgentId(), "", "", "", "", null, 32, null);
        this.dispatcher = new AgentDispatcher(config, null, 2, 0 == true ? 1 : 0);
        this.extDispatcher = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentSession.G0();
            }
        });
        this.dispatchers = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentSession.A0(this.f22732a);
            }
        });
        Xa.j<L0> jVarA = Xa.p.a(0, 256, BufferOverflow.DROP_OLDEST);
        this._events = jVarA;
        this.events = jVarA;
        this.conversationMap = new ConcurrentHashMap<>();
        CloudSessionTitleSync cloudSessionTitleSync = new CloudSessionTitleSync(conversationTitleRepository, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSession.t0(this.f22733a, (w4.e) obj);
            }
        });
        this.cloudSessionTitleSync = cloudSessionTitleSync;
        cloudSessionTitleSync.d();
        r1();
    }

    public static final ConcurrentHashMap A0(AgentSession agentSession) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Iterator<T> it = ExternalAgent.INSTANCE.a().iterator();
        while (it.hasNext()) {
            concurrentHashMap.put((String) it.next(), agentSession.h1());
        }
        concurrentHashMap.put(La.H.D1(agentSession.config.getAgentId()).toString(), agentSession.dispatcher);
        return concurrentHashMap;
    }

    public static /* synthetic */ void B1(AgentSession agentSession, int i10, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 10;
        }
        agentSession.A1(i10, interfaceC5074l);
    }

    public static /* synthetic */ void E1(AgentSession agentSession, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = System.currentTimeMillis();
        }
        agentSession.D1(str, j10);
    }

    public static /* synthetic */ Object F2(AgentSession agentSession, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 10000;
        }
        return agentSession.E2(j10, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final AgentDispatcher G0() {
        String str = null;
        String str2 = null;
        int i10 = 0;
        long j10 = 0;
        long j11 = 0;
        boolean z10 = false;
        String str3 = null;
        boolean z11 = false;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = C1963x.AGENT_TYPE_AGENTBUS_BFF;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        long j20 = 0;
        return new AgentDispatcher(new SessionConfig(str, str2, i10, j10, j11, z10, str3, z11, str4, str5, str6, str7, j12, j13, j14, j15, j16, j17, j18, j19, j20, 2095103, null), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }

    public static final boolean I0(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TOOL;
    }

    public static final Ka.j J0(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        List<AgentTool> listG = it.g();
        if (listG == null) {
            listG = C1173v.m();
        }
        return Z8.F.d0(listG);
    }

    public static /* synthetic */ void J1(AgentSession agentSession, boolean z10, Exception exc, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            exc = null;
        }
        agentSession.I1(z10, exc);
    }

    public static final Map K0(AgentTool tool) {
        kotlin.jvm.internal.p.i(tool, "tool");
        return kotlin.collections.a.m(Y8.j.a("toolCallId", tool.getToolCallId()), Y8.j.a("name", tool.getName()), Y8.j.a("apiName", tool.getApiName()), Y8.j.a("status", tool.getIsFinished() ? "FINISHED" : "RUNNING"), Y8.j.a("parameter", tool.getParameter()), Y8.j.a("result", tool.getResult()));
    }

    public static final Comparable R0(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Long.valueOf(it.getTime());
    }

    public static final Comparable S0(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getMessageId();
    }

    public static final CharSequence b2(AgentMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getContent().h();
    }

    public static /* synthetic */ void d2(AgentSession agentSession, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z10, Integer num, String str9, int i10, Object obj) {
        if ((i10 & 512) != 0) {
            num = null;
        }
        if ((i10 & 1024) != 0) {
            str9 = null;
        }
        agentSession.c2(str, str2, str3, str4, str5, str6, str7, str8, z10, num, str9);
    }

    public static final Y8.t j0(AgentSession agentSession, String str, boolean z10) {
        if (z10) {
            Function2.a(new AgentSession$changeToConversation$1$1(agentSession, str, null));
        } else {
            C4148a.h(agentSession.TAG, "changeToConversation error", false, 4, null);
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void l0(AgentSession agentSession, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        agentSession.k0(str, str2);
    }

    public static final Y8.t o(SessionHandler sessionHandler) {
        sessionHandler.A2();
        return Y8.t.f7040a;
    }

    public static final String p(SessionHandler sessionHandler) {
        AgentConversation agentConversationR1 = sessionHandler.R1();
        if (agentConversationR1 == null) {
            return null;
        }
        String sessionId = agentConversationR1.getSessionId();
        return sessionId.length() == 0 ? agentConversationR1.getTempSessionId() : sessionId;
    }

    public static final Y8.t s1(final AgentSession agentSession, C5732a c5732a, final Exception exc) {
        boolean z10 = true;
        final boolean z11 = c5732a != null;
        if (z11) {
            agentSession.agentInfo = c5732a;
        }
        if (agentSession.config.getNewSession()) {
            AgentConversation agentConversation = agentSession.topConversation;
            if (kotlin.jvm.internal.p.d(agentConversation.getAgentId(), agentSession.config.getAgentId()) && agentConversation.G() == null) {
                z10 = false;
            }
            if (agentConversation.P() || agentConversation.B().length() > 0 || z10) {
                agentSession.C2(agentConversation);
                C4148a.k(agentSession.TAG, "initAgent keep active topConversation sessionId:" + agentConversation.getSessionId() + " tempSessionId:" + agentConversation.getTempSessionId() + " agentId:" + agentConversation.getAgentId(), false, 4, null);
            } else {
                agentSession.topConversation = agentSession.new AgentConversation();
            }
            J1(agentSession, z11, null, 2, null);
        } else {
            C1939k0.g(agentSession.config.getAgentId(), agentSession.config.getDefaultSessionId(), agentSession.config.E(), 0, new p9.q() { // from class: com.stepos.agentframework.chatcore.session.f
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AgentSession.t1(this.f22724a, z11, exc, (String) obj, (w4.e) obj2, (List) obj3);
                }
            }, 8, null);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t t0(AgentSession agentSession, w4.e row) {
        kotlin.jvm.internal.p.i(row, "row");
        agentSession.B0(new L0.ConversationNameChanged(row.getSessionId(), row, 0L, 4, null));
        Function2.b(new AgentSession$cloudSessionTitleSync$1$1(agentSession, null));
        return Y8.t.f7040a;
    }

    public static final Y8.t t1(AgentSession agentSession, boolean z10, Exception exc, String sessionId, w4.e eVar, List messageList) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(messageList, "messageList");
        agentSession.topConversation = agentSession.H1(sessionId, eVar);
        f fVar = agentSession.prepareCallback;
        if (fVar != null) {
            fVar.b(sessionId, messageList);
        }
        agentSession.handler.g3();
        agentSession.P1(sessionId);
        agentSession.I1(z10, exc);
        return Y8.t.f7040a;
    }

    public static final void x1(LinkedHashSet<String> linkedHashSet, String str) {
        String string = str != null ? La.H.D1(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return;
        }
        linkedHashSet.add(string);
        Z8.A.E(linkedHashSet, M0.INSTANCE.a(string));
    }

    public final void A1(int limit, InterfaceC5074l<? super List<ChatMessage>, Y8.t> onLoaded) {
        kotlin.jvm.internal.p.i(onLoaded, "onLoaded");
        Function2.a(new AgentSession$loadLatestTopConversationMessages$1(this, limit, onLoaded, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A2(kotlin.TaskSyncRemoteRequest r6, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatcore.session.AgentSession$syncTaskWithRemote$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatcore.session.AgentSession$syncTaskWithRemote$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$syncTaskWithRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$syncTaskWithRemote$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$syncTaskWithRemote$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r5 = r0.L$1
            com.stepos.agentframework.chatcore.session.AgentSession r5 = (com.stepos.agentframework.chatcore.session.AgentSession) r5
            java.lang.Object r5 = r0.L$0
            K6.I r5 = (kotlin.TaskSyncRemoteRequest) r5
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L5e
        L32:
            r5 = move-exception
            goto L6d
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.C4849c.b(r7)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r7 = r5.dispatcher     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.chatcore.agents.u r7 = r7.getClient()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L32
            r0.label = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = r7.l(r6, r0)     // Catch: java.lang.Throwable -> L32
            if (r7 != r1) goto L5e
            return r1
        L5e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L32
            boolean r5 = r7.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r5 = g9.C4109a.a(r5)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L32
            goto L77
        L6d:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L77:
            java.lang.Throwable r6 = kotlin.Result.e(r5)
            if (r6 != 0) goto L7e
            goto L82
        L7e:
            java.lang.Boolean r5 = g9.C4109a.a(r3)
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.A2(K6.I, e9.c):java.lang.Object");
    }

    public final void B0(L0 event) {
        kotlin.jvm.internal.p.i(event, "event");
        C5442c c5442c = C5442c.INSTANCE;
        C5442c.o(c5442c, F0(event), E0(event), null, "AgentSession.emitEvent", 4, null);
        if (this._events.a(event)) {
            return;
        }
        C4148a.u(this.TAG, "emitEvent dropped type:" + kotlin.jvm.internal.t.b(event.getClass()).t() + " sessionId:" + event.getSessionId() + " at:" + event.getAt(), false, 4, null);
        c5442c.n(F0(event), kotlin.collections.a.m(Y8.j.a("sessionId", event.getSessionId()), Y8.j.a("accepted", Boolean.FALSE)), ExifInterface.LONGITUDE_WEST, "AgentSession.emitEvent");
    }

    public final void B2(String messageId, String toolCallId, int toolLikeStatus) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        Function2.a(new AgentSession$toolLikeFeedback$1(this, messageId, toolCallId, toolLikeStatus, null));
    }

    public final String C0(AgentConversation target) {
        String sessionId;
        kotlin.jvm.internal.p.i(target, "target");
        synchronized (this.sessionMutationLock) {
            try {
                if (target.getSessionId().length() == 0 && target.getTempSessionId().length() == 0) {
                    target.q0(true);
                    target.r0(ConversationSessionIds.INSTANCE.i());
                }
                sessionId = target.getSessionId();
                if (sessionId.length() == 0) {
                    sessionId = target.getTempSessionId();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sessionId;
    }

    public final void C1(long beforeTime, String beforeMessageId, int limit, InterfaceC5074l<? super List<ChatMessage>, Y8.t> onLoaded) {
        kotlin.jvm.internal.p.i(beforeMessageId, "beforeMessageId");
        kotlin.jvm.internal.p.i(onLoaded, "onLoaded");
        Function2.a(new AgentSession$loadMoreTopConversationMessages$1(this, beforeTime, beforeMessageId, limit, onLoaded, null));
    }

    public final void C2(AgentConversation conversation) {
        if (conversation != null && conversation.P()) {
            String strB = conversation.B();
            if (strB.length() == 0) {
                return;
            }
            this.conversationMap.put(strB, conversation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #2 {all -> 0x0066, blocks: (B:21:0x005e, B:34:0x00af, B:36:0x00b3), top: B:62:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128 A[Catch: all -> 0x0043, TRY_LEAVE, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x003e, B:40:0x00e5, B:42:0x00e9, B:45:0x00f0, B:50:0x0128), top: B:59:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D0(com.stepos.agentframework.chatcore.send.SlaSessionAnchor r13, e9.InterfaceC4014c<? super java.lang.String> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.D0(com.stepos.agentframework.chatcore.send.l, e9.c):java.lang.Object");
    }

    public final void D1(String sessionId, long lastReadAt) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        C4148a.k(this.TAG, "markConversationRead: " + sessionId, false, 4, null);
        if (sessionId.length() == 0) {
            return;
        }
        this.conversationTitleRepository.q(this.config.getAgentId(), sessionId, lastReadAt);
    }

    public final void D2(Context context, List<FileInfo> files, InterfaceC5507a listener) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(files, "files");
        kotlin.jvm.internal.p.i(listener, "listener");
        Function2.a(new AgentSession$uploadFile$1(files, this, context, listener, null));
    }

    public final Map<String, Object> E0(L0 event) {
        if (event instanceof L0.MessageUpsert) {
            L0.MessageUpsert lVar = (L0.MessageUpsert) event;
            Map<String, Object> mapM = kotlin.collections.a.m(Y8.j.a("sessionId", lVar.getSessionId()), Y8.j.a("messageId", lVar.getMessage().getMessageId()), Y8.j.a("status", lVar.getMessage().getStatus().name()));
            List<Map<String, Object>> listH0 = H0(lVar.getMessage());
            return listH0.isEmpty() ? mapM : kotlin.collections.a.r(mapM, Z8.Q.f(Y8.j.a("tools", listH0)));
        }
        if (event instanceof L0.ToolMessageUpsert) {
            L0.ToolMessageUpsert xVar = (L0.ToolMessageUpsert) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", xVar.getSessionId()), Y8.j.a("messageId", xVar.getMessage().getMessageId()), Y8.j.a("status", xVar.getMessage().getStatus().name()));
        }
        if (event instanceof L0.MessageReplace) {
            L0.MessageReplace kVar = (L0.MessageReplace) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", kVar.getSessionId()), Y8.j.a("oldMessageId", kVar.getOldMessageId()), Y8.j.a("newMessageId", kVar.getMessage().getMessageId()), Y8.j.a("status", kVar.getMessage().getStatus().name()));
        }
        if (event instanceof L0.MessageRemove) {
            L0.MessageRemove jVar = (L0.MessageRemove) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", jVar.getSessionId()), Y8.j.a("messageId", jVar.getMessage().getMessageId()));
        }
        if (event instanceof L0.ErrorEvent) {
            L0.ErrorEvent iVar = (L0.ErrorEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", iVar.getSessionId()), Y8.j.a("code", Integer.valueOf(iVar.getError().getCode())), Y8.j.a("message", iVar.getError().getMessage()));
        }
        if (event instanceof L0.NoMessageIdResponseEvent) {
            L0.NoMessageIdResponseEvent oVar = (L0.NoMessageIdResponseEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", oVar.getSessionId()), Y8.j.a("pairId", oVar.getPairId()));
        }
        if (event instanceof L0.SessionCreated) {
            L0.SessionCreated sVar = (L0.SessionCreated) event;
            return kotlin.collections.a.m(Y8.j.a("tempSessionId", sVar.getTempSessionId()), Y8.j.a("createdSessionId", sVar.getCreatedSessionId()));
        }
        if (event instanceof L0.ConversationMessagesCleared) {
            return Z8.Q.f(Y8.j.a("sessionId", ((L0.ConversationMessagesCleared) event).getSessionId()));
        }
        if (event instanceof L0.ConversationChanged) {
            L0.ConversationChanged bVar = (L0.ConversationChanged) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", bVar.getSessionId()), Y8.j.a("messageSize", Integer.valueOf(bVar.b().size())));
        }
        if (event instanceof L0.ConversationDeleted) {
            return Z8.Q.f(Y8.j.a("sessionId", ((L0.ConversationDeleted) event).getSessionId()));
        }
        if (event instanceof L0.ConversationNameChanged) {
            L0.ConversationNameChanged eVar = (L0.ConversationNameChanged) event;
            Pair pairA = Y8.j.a("sessionId", eVar.getSessionId());
            w4.e eVarB = eVar.getTitle();
            return kotlin.collections.a.m(pairA, Y8.j.a("title", eVarB != null ? eVarB.getTitle() : null));
        }
        if (event instanceof L0.TaskPlanEvent) {
            L0.TaskPlanEvent vVar = (L0.TaskPlanEvent) event;
            Pair pairA2 = Y8.j.a("sessionId", vVar.getSessionId());
            List<AgentTask> listA = vVar.getTaskPlan().a();
            return kotlin.collections.a.m(pairA2, Y8.j.a("taskCount", Integer.valueOf(listA != null ? listA.size() : 0)));
        }
        if (event instanceof L0.TaskUpdateEvent) {
            L0.TaskUpdateEvent wVar = (L0.TaskUpdateEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", wVar.getSessionId()), Y8.j.a("taskId", wVar.getTask().getId()), Y8.j.a(D6.a.KEY_TASK_STATUS, Integer.valueOf(wVar.getTask().getStatus())));
        }
        if (event instanceof L0.TaskCompleteEvent) {
            L0.TaskCompleteEvent tVar = (L0.TaskCompleteEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", tVar.getSessionId()), Y8.j.a("planId", tVar.getTask().getPlan_id()));
        }
        if (event instanceof L0.TaskFailedEvent) {
            L0.TaskFailedEvent uVar = (L0.TaskFailedEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", uVar.getSessionId()), Y8.j.a("planId", uVar.getTask().getPlan_id()), Y8.j.a("code", Integer.valueOf(uVar.getTask().getCode())), Y8.j.a("reason", uVar.getTask().getReason()));
        }
        if (event instanceof L0.ModerationEvent) {
            L0.ModerationEvent mVar = (L0.ModerationEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", mVar.getSessionId()), Y8.j.a("decision", mVar.getModeration().getDecision()), Y8.j.a(com.stepos.ailauncher.chat.trace.g.END_INTERRUPTED, Boolean.valueOf(mVar.getModeration().getInterrupted())), Y8.j.a("channelMessageId", mVar.getModeration().getChannelMessageId()), Y8.j.a(SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, mVar.getModeration().getRunId()));
        }
        if (event instanceof L0.SendAckEvent) {
            L0.SendAckEvent rVar = (L0.SendAckEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", rVar.getSessionId()), Y8.j.a("success", Boolean.valueOf(rVar.getSuccess())), Y8.j.a("messageIds", rVar.d()));
        }
        if (event instanceof L0.NetworkToastEvent) {
            L0.NetworkToastEvent nVar = (L0.NetworkToastEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", nVar.getSessionId()), Y8.j.a("phase", nVar.getPhase().name()));
        }
        if (event instanceof L0.COTCollapseEvent) {
            return Z8.Q.f(Y8.j.a("sessionId", ((L0.COTCollapseEvent) event).getSessionId()));
        }
        if (event instanceof L0.ReconnectPromptEvent) {
            L0.ReconnectPromptEvent qVar = (L0.ReconnectPromptEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", qVar.getSessionId()), Y8.j.a("roundAlive", Boolean.valueOf(qVar.getRoundAlive())), Y8.j.a("reason", qVar.getReason()));
        }
        if (event instanceof L0.ReconnectPromptDismissEvent) {
            L0.ReconnectPromptDismissEvent pVar = (L0.ReconnectPromptDismissEvent) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", pVar.getSessionId()), Y8.j.a("reason", pVar.getReason()));
        }
        if (event instanceof L0.CotTimingStart) {
            L0.CotTimingStart gVar = (L0.CotTimingStart) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", gVar.getSessionId()), Y8.j.a("startAtMs", Long.valueOf(gVar.getStartAtMs())));
        }
        if (event instanceof L0.CotTimingTick) {
            L0.CotTimingTick hVar = (L0.CotTimingTick) event;
            return kotlin.collections.a.m(Y8.j.a("sessionId", hVar.getSessionId()), Y8.j.a("elapsedMs", Long.valueOf(hVar.getElapsedMs())));
        }
        if (!(event instanceof L0.CotTimingEnd)) {
            throw new NoWhenBranchMatchedException();
        }
        L0.CotTimingEnd fVar = (L0.CotTimingEnd) event;
        return kotlin.collections.a.m(Y8.j.a("sessionId", fVar.getSessionId()), Y8.j.a("durationMs", Long.valueOf(fVar.getDurationMs())), Y8.j.a("toolCount", Integer.valueOf(fVar.getToolCount())));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E2(long r5, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatcore.session.AgentSession$waitForStatusChange$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatcore.session.AgentSession$waitForStatusChange$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$waitForStatusChange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$waitForStatusChange$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$waitForStatusChange$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r7)
            com.stepos.agentframework.chatcore.session.AgentSession$waitForStatusChange$2 r7 = new com.stepos.agentframework.chatcore.session.AgentSession$waitForStatusChange$2
            r2 = 0
            r7.<init>(r4, r2)
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.e(r5, r7, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L4e
            boolean r4 = r7.booleanValue()
            goto L4f
        L4e:
            r4 = 0
        L4f:
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.E2(long, e9.c):java.lang.Object");
    }

    public final String F0(L0 event) {
        if (event instanceof L0.MessageUpsert) {
            return ((L0.MessageUpsert) event).getMessage().getTraceId();
        }
        if (event instanceof L0.ToolMessageUpsert) {
            return ((L0.ToolMessageUpsert) event).getMessage().getTraceId();
        }
        if (event instanceof L0.MessageReplace) {
            return ((L0.MessageReplace) event).getMessage().getTraceId();
        }
        if (event instanceof L0.MessageRemove) {
            return ((L0.MessageRemove) event).getMessage().getTraceId();
        }
        return null;
    }

    public final void F1(String sessionId, String reason) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (sessionId.length() != 0 && v1(sessionId)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            AgentConversation agentConversation = this.topConversation;
            if (agentConversation.P() && (kotlin.jvm.internal.p.d(agentConversation.getSessionId(), sessionId) || kotlin.jvm.internal.p.d(agentConversation.getTempSessionId(), sessionId))) {
                linkedHashSet.add(agentConversation);
            }
            for (AgentConversation agentConversation2 : this.conversationMap.values()) {
                kotlin.jvm.internal.p.h(agentConversation2, "next(...)");
                AgentConversation agentConversation3 = agentConversation2;
                if (agentConversation3.P() && (kotlin.jvm.internal.p.d(agentConversation3.getSessionId(), sessionId) || kotlin.jvm.internal.p.d(agentConversation3.getTempSessionId(), sessionId))) {
                    linkedHashSet.add(agentConversation3);
                }
            }
            Iterator it = linkedHashSet.iterator();
            kotlin.jvm.internal.p.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.p.h(next, "next(...)");
                ((AgentConversation) next).R(reason);
            }
        }
    }

    public final void G1(String fromKey) {
        kotlin.jvm.internal.p.i(fromKey, "fromKey");
        if (fromKey.length() > 0) {
            this.migratingFromSessionId = fromKey;
        }
    }

    public final List<Map<String, Object>> H0(ChatMessage message) {
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.L(SequencesKt___SequencesKt.F(Z8.F.d0(message.i()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AgentSession.I0((AgentMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSession.J0((AgentMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSession.K0((AgentTool) obj);
            }
        }));
    }

    public final AgentConversation H1(String sessionId, w4.e title) {
        AgentConversation agentConversation = new AgentConversation();
        Y(agentConversation, sessionId, title);
        return agentConversation;
    }

    public final void I1(boolean success, Exception e10) {
        if (success) {
            s2(ESessionStatus.READY);
            f fVar = this.prepareCallback;
            if (fVar != null) {
                fVar.a(m1());
                return;
            }
            return;
        }
        s2(ESessionStatus.PREPARE_ERROR);
        f fVar2 = this.prepareCallback;
        if (fVar2 != null) {
            fVar2.i(new AgentError(AgentError.ERROR_CODE_INIT, "agent prepare error: " + (e10 != null ? e10.getMessage() : null), e10 != null ? e10.getCause() : null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K1(e9.InterfaceC4014c<? super java.lang.String> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.agentframework.chatcore.session.AgentSession$prefetchSessionOrNull$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.agentframework.chatcore.session.AgentSession$prefetchSessionOrNull$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$prefetchSessionOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$prefetchSessionOrNull$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$prefetchSessionOrNull$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.stepos.agentframework.chatcore.session.AgentSession r4 = (com.stepos.agentframework.chatcore.session.AgentSession) r4
            kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L5f
            goto L58
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r5)
            kotlin.Result$a r5 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L5f
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r5 = r4.dispatcher     // Catch: java.lang.Throwable -> L5f
            com.stepos.agentframework.chatcore.agents.u r5 = r5.getClient()     // Catch: java.lang.Throwable -> L5f
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r2 = r4.topConversation     // Catch: java.lang.Throwable -> L5f
            java.lang.String r2 = r2.getAgentId()     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r4 = g9.h.a(r4)     // Catch: java.lang.Throwable -> L5f
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L5f
            r4 = 0
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L5f
            r0.label = r3     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r5 = r5.j(r2, r0)     // Catch: java.lang.Throwable -> L5f
            if (r5 != r1) goto L58
            return r1
        L58:
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r4 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L5f
            goto L6a
        L5f:
            r4 = move-exception
            kotlin.Result$a r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L6a:
            boolean r5 = kotlin.Result.g(r4)
            r0 = 0
            if (r5 == 0) goto L72
            r4 = r0
        L72:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L7d
            int r5 = r4.length()
            if (r5 <= 0) goto L7d
            r0 = r4
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.K1(e9.c):java.lang.Object");
    }

    public final void L0(String traceId, String messageId, String sessionId, int likeStatus, String questionType, String questionDesc, String taskId) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(questionType, "questionType");
        kotlin.jvm.internal.p.i(questionDesc, "questionDesc");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        Function2.a(new AgentSession$feedback$1(this, sessionId, traceId, messageId, likeStatus, taskId, questionType, questionDesc, null));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:57|24|25|59|26|(1:28)(8:29|30|31|37|(0)|43|(0)|50)) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x010c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x010d, code lost:
    
        r11 = r1;
        r14 = r2;
        r13 = r7;
        r9 = r8;
        r2 = r15;
        r12 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x011a, code lost:
    
        r1 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.b(kotlin.C4849c.a(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a2 -> B:51:0x0145). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f8 -> B:30:0x0100). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L1(java.util.List<com.stepos.agentframework.chatcore.file.FileInfo> r19, e9.InterfaceC4014c<? super java.util.Map<java.lang.String, java.lang.String>> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.L1(java.util.List, e9.c):java.lang.Object");
    }

    public final void M0(List<ChatMessage> chats) {
        if (chats.isEmpty()) {
            return;
        }
        Long lValueOf = Long.valueOf(((ChatMessage) Z8.F.C0(chats)).getTime());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        long jLongValue = (lValueOf != null ? lValueOf.longValue() : System.currentTimeMillis()) + 1;
        int size = chats.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i10 = size - 1;
            long time = chats.get(size).getTime();
            jLongValue = (1 > time || time >= jLongValue) ? jLongValue - 1 : time;
            chats.get(size).W(jLongValue);
            if (i10 < 0) {
                return;
            } else {
                size = i10;
            }
        }
    }

    public final void M1(String sessionId, w4.e row) {
        B0(new L0.ConversationNameChanged(sessionId, row, 0L, 4, null));
        C1935i0.INSTANCE.a(sessionId, row.getTitle());
        Function2.b(new AgentSession$publishLocalFixedTitle$1(this, null));
    }

    public final void N0(String recalledMessageId) {
        kotlin.jvm.internal.p.i(recalledMessageId, "recalledMessageId");
        Function2.a(new AgentSession$finalizeTopConversationAfterUserRevert$1(this, recalledMessageId, null));
    }

    public final void N1(b callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        C4148a.k(this.TAG, "queryActiveConversations", false, 4, null);
        Function2.a(new AgentSession$queryActiveConversations$1(this, callback, null));
    }

    public final AgentConversation O0(String sessionId) {
        Object next;
        String strF = M0.INSTANCE.f(sessionId);
        if (strF == null) {
            strF = sessionId;
        }
        AgentConversation agentConversation = this.conversationMap.get(sessionId);
        if (agentConversation != null) {
            return agentConversation;
        }
        AgentConversation agentConversation2 = this.conversationMap.get(strF);
        if (agentConversation2 != null) {
            return agentConversation2;
        }
        Collection<AgentConversation> collectionValues = this.conversationMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AgentConversation agentConversation3 = (AgentConversation) next;
            if (kotlin.jvm.internal.p.d(agentConversation3.getSessionId(), sessionId) || kotlin.jvm.internal.p.d(agentConversation3.getSessionId(), strF) || kotlin.jvm.internal.p.d(agentConversation3.getTempSessionId(), sessionId) || kotlin.jvm.internal.p.d(agentConversation3.getTempSessionId(), strF)) {
                break;
            }
        }
        return (AgentConversation) next;
    }

    public final void O1(Collection<String> sessionIds, InterfaceC5074l<? super Map<String, Boolean>, Y8.t> callback) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        kotlin.jvm.internal.p.i(callback, "callback");
        Function2.a(new AgentSession$querySessionHasMessages$1(sessionIds, this, callback, null));
    }

    public final AgentConversation P0(String id) {
        Object next;
        AgentConversation agentConversation = this.conversationMap.get(id);
        if (agentConversation != null) {
            return agentConversation;
        }
        if (this.topConversation.S(id)) {
            return this.topConversation;
        }
        Collection<AgentConversation> collectionValues = this.conversationMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((AgentConversation) next).S(id)) {
                break;
            }
        }
        return (AgentConversation) next;
    }

    public final void P1(String sessionId) {
        if (sessionId.length() != 0 && this.config.E()) {
            if (this.topConversation.P()) {
                C4148a.k(this.TAG, "skip interrupted-round reconcile: round active sessionId=" + sessionId, false, 4, null);
                return;
            }
            String strC = C1927e0.INSTANCE.c(sessionId);
            if (strC == null) {
                return;
            }
            C4148a.k(this.TAG, "reconcile interrupted round sessionId=" + sessionId + " messageId=" + strC, false, 4, null);
            this.handler.V2(sessionId);
        }
    }

    public final List<ChatMessage> Q0(String sessionId, int limit) {
        M0 m02 = M0.INSTANCE;
        String strF = m02.f(sessionId);
        if (strF == null) {
            strF = sessionId;
        }
        String str = this.migratingFromSessionId;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Z8.A.E(linkedHashSet, m02.a(sessionId));
        if (sessionId.length() > 0) {
            linkedHashSet.add(sessionId);
        }
        if (strF.length() > 0) {
            linkedHashSet.add(strF);
        }
        if (str.length() > 0) {
            linkedHashSet.add(str);
        }
        if (linkedHashSet.isEmpty()) {
            return this.messageRepository.l(sessionId, limit);
        }
        if (linkedHashSet.size() == 1) {
            return this.messageRepository.l((String) Z8.F.p0(linkedHashSet), limit);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Z8.A.E(arrayList, this.messageRepository.l((String) it.next(), limit));
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(((ChatMessage) obj).getMessageId())) {
                arrayList2.add(obj);
            }
        }
        return Z8.F.g1(Z8.F.c1(arrayList2, b9.b.b(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return AgentSession.R0((ChatMessage) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return AgentSession.S0((ChatMessage) obj2);
            }
        })), limit);
    }

    public final void Q1() {
        this.cloudSessionTitleSync.f();
        Collection<AgentDispatcher> collectionValues = f1().values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((AgentDispatcher) it.next()).m();
        }
    }

    public final void R1(String sessionId, String requestId, String source) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(source, "source");
        if (sessionId.length() == 0 || requestId.length() == 0) {
            return;
        }
        U0(requestId);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        AgentConversation agentConversation = this.topConversation;
        if (v0(agentConversation, sessionId)) {
            linkedHashSet.add(agentConversation);
        }
        for (AgentConversation agentConversation2 : this.conversationMap.values()) {
            kotlin.jvm.internal.p.h(agentConversation2, "next(...)");
            AgentConversation agentConversation3 = agentConversation2;
            if (v0(agentConversation3, sessionId)) {
                linkedHashSet.add(agentConversation3);
            }
        }
        Iterator it = linkedHashSet.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            ((AgentConversation) next).b0(requestId, source);
        }
    }

    public final void S1(String requestId) {
        synchronized (this.authHoldRequestIds) {
            this.authHoldRequestIds.add(requestId);
        }
    }

    public final Set<String> T() {
        Set<String> setR1;
        synchronized (this.authHoldRequestIds) {
            setR1 = Z8.F.r1(this.authHoldRequestIds);
        }
        return setR1;
    }

    public final ChatMessage T0(String stoppedMessageId) {
        ChatMessage chatMessageW;
        List<AgentTool> listG;
        List<AgentTool> listG2;
        try {
            String sessionId = this.topConversation.getSessionId();
            if (sessionId.length() == 0) {
                sessionId = this.topConversation.getTempSessionId();
            }
            String str = sessionId;
            if (str.length() == 0 || (chatMessageW = this.messageRepository.w(str)) == null || chatMessageW.getRole() != AgentRole.ASSISTANT) {
                return null;
            }
            if (stoppedMessageId != null && stoppedMessageId.length() != 0 && !kotlin.jvm.internal.p.d(chatMessageW.getMessageId(), stoppedMessageId)) {
                C4148a.k(this.TAG, "forceCancelTopConversationPendingMessage skip: latest=" + chatMessageW.getMessageId() + " stopped=" + stoppedMessageId, false, 4, null);
                return null;
            }
            if (chatMessageW.getStatus() != EReplyStatus.COMPLETED && chatMessageW.getStatus() != EReplyStatus.ERROR) {
                EReplyStatus status = chatMessageW.getStatus();
                EReplyStatus eReplyStatus = EReplyStatus.CANCELED;
                if (status != eReplyStatus) {
                    ChatMessage stoppedAssistantSnapshot = this.topConversation.getStoppedAssistantSnapshot();
                    if (stoppedAssistantSnapshot != null && K.e(chatMessageW) && !K.e(stoppedAssistantSnapshot)) {
                        chatMessageW.L(stoppedAssistantSnapshot.i());
                        chatMessageW.U(eReplyStatus);
                        chatMessageW.H(AgentError.USER_CANCEL);
                        chatMessageW.J(ChatHintType.STOPPED);
                        for (AgentMessage c5574a : chatMessageW.i()) {
                            if (c5574a.getType() == AgentMessageType.TOOL && (listG2 = c5574a.g()) != null) {
                                Iterator<T> it = listG2.iterator();
                                while (it.hasNext()) {
                                    ((AgentTool) it.next()).A(true);
                                }
                            }
                        }
                        this.messageRepository.t(chatMessageW);
                        SessionActivityTracker sessionActivityTracker = SessionActivityTracker.INSTANCE;
                        sessionActivityTracker.l(chatMessageW);
                        B0(new L0.MessageUpsert(str, chatMessageW, 0L, 4, null));
                        C4148a.k(this.TAG, "forceCancelTopConversationPendingMessage backfilled empty DB row from in-flight snapshot messageId:" + chatMessageW.getMessageId() + " sessionId:" + str, false, 4, null);
                        sessionActivityTracker.l(chatMessageW);
                        a2(chatMessageW, str, true);
                        return chatMessageW;
                    }
                    if (K.e(chatMessageW)) {
                        chatMessageW.U(eReplyStatus);
                        chatMessageW.H(AgentError.USER_CANCEL);
                        chatMessageW.J(ChatHintType.STOPPED);
                        this.messageRepository.t(chatMessageW);
                        SessionActivityTracker.INSTANCE.l(chatMessageW);
                        B0(new L0.MessageRemove(str, chatMessageW, 0L, 4, null));
                        C4148a.k(this.TAG, "forceCancelTopConversationPendingMessage kept empty stopped tombstone messageId:" + chatMessageW.getMessageId() + " sessionId:" + str, false, 4, null);
                        a2(chatMessageW, str, false);
                        return chatMessageW;
                    }
                    chatMessageW.U(eReplyStatus);
                    chatMessageW.H(AgentError.USER_CANCEL);
                    chatMessageW.J(ChatHintType.STOPPED);
                    for (AgentMessage c5574a2 : chatMessageW.i()) {
                        if (c5574a2.getType() == AgentMessageType.TOOL && (listG = c5574a2.g()) != null) {
                            Iterator<T> it2 = listG.iterator();
                            while (it2.hasNext()) {
                                ((AgentTool) it2.next()).A(true);
                            }
                        }
                    }
                    this.messageRepository.t(chatMessageW);
                    SessionActivityTracker sessionActivityTracker2 = SessionActivityTracker.INSTANCE;
                    sessionActivityTracker2.l(chatMessageW);
                    B0(new L0.MessageUpsert(str, chatMessageW, 0L, 4, null));
                    C4148a.k(this.TAG, "forceCancelTopConversationPendingMessage messageId:" + chatMessageW.getMessageId() + " sessionId:" + str, false, 4, null);
                    sessionActivityTracker2.l(chatMessageW);
                    a2(chatMessageW, str, true);
                    return chatMessageW;
                }
            }
            return null;
        } catch (Exception e10) {
            C4148a.t(this.TAG, "forceCancelTopConversationPendingMessage error:" + e10.getMessage(), e10, false, 8, null);
            return null;
        }
    }

    public final ChatMessage T1(String targetSessionId) {
        kotlin.jvm.internal.p.i(targetSessionId, "targetSessionId");
        AgentConversation agentConversationO0 = O0(targetSessionId);
        return V1(targetSessionId, agentConversationO0 != null ? agentConversationO0.M() : null);
    }

    public final Set<String> U() {
        HashSet hashSet = new HashSet();
        u0(this.topConversation, hashSet);
        for (AgentConversation agentConversation : this.conversationMap.values()) {
            kotlin.jvm.internal.p.h(agentConversation, "next(...)");
            u0(agentConversation, hashSet);
        }
        return hashSet;
    }

    public final void U0(String requestId) {
        synchronized (this.authHoldRequestIds) {
            this.authHoldRequestIds.remove(requestId);
        }
    }

    public final void U1(AgentDispatcher.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        Collection<AgentDispatcher> collectionValues = f1().values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((AgentDispatcher) it.next()).n(listener);
        }
    }

    public final void V(AgentDispatcher.a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        Collection<AgentDispatcher> collectionValues = f1().values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((AgentDispatcher) it.next()).d(listener);
        }
    }

    /* renamed from: V0, reason: from getter */
    public final C5732a getAgentInfo() {
        return this.agentInfo;
    }

    public final ChatMessage V1(String targetSessionId, ChatMessage liveStreaming) {
        ChatMessage chatMessageB;
        try {
            if (targetSessionId.length() == 0 || (chatMessageB = C1961w.b(liveStreaming, this.messageRepository.w(targetSessionId))) == null) {
                return null;
            }
            this.messageRepository.q(chatMessageB.getMessageId());
            B0(new L0.MessageRemove(targetSessionId, chatMessageB, 0L, 4, null));
            C4148a.k(this.TAG, "removeSessionStreamingAssistantMessage removed messageId:" + chatMessageB.getMessageId() + " sessionId:" + targetSessionId + " parts:" + chatMessageB.i().size(), false, 4, null);
            return chatMessageB;
        } catch (Exception e10) {
            C4148a.t(this.TAG, "removeSessionStreamingAssistantMessage error:" + e10.getMessage(), e10, false, 8, null);
            return null;
        }
    }

    public final void W(String askUserMessageId, String inquiryId, String summary) {
        ChatMessage chatMessage;
        kotlin.jvm.internal.p.i(askUserMessageId, "askUserMessageId");
        kotlin.jvm.internal.p.i(inquiryId, "inquiryId");
        kotlin.jvm.internal.p.i(summary, "summary");
        if (askUserMessageId.length() == 0 || inquiryId.length() == 0) {
            return;
        }
        m.InquiryMessage fVar = new m.InquiryMessage(inquiryId, summary);
        Ka.j jVarV = Ka.t.v(this.topConversation);
        Collection<AgentConversation> collectionValues = this.conversationMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Iterator it = SequencesKt___SequencesKt.V(jVarV, Z8.F.d0(collectionValues)).iterator();
        while (true) {
            if (!it.hasNext()) {
                chatMessage = null;
                break;
            }
            ChatMessage chatMessageR = ((AgentConversation) it.next()).r(askUserMessageId, fVar);
            if (chatMessageR != null) {
                chatMessage = chatMessageR;
                break;
            }
        }
        if (chatMessage == null) {
            Function2.a(new AgentSession$appendInquiryEcho$3(this, askUserMessageId, inquiryId, fVar, null));
            return;
        }
        String sessionId = chatMessage.getSessionId();
        B0(new L0.MessageUpsert(sessionId.length() == 0 ? null : sessionId, chatMessage, 0L, 4, null));
        Function2.a(new AgentSession$appendInquiryEcho$2(this, chatMessage, null));
    }

    public final void W0(String agentId, p9.p<? super C5732a, ? super Exception, Y8.t> callback) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(callback, "callback");
        Function2.a(new AgentSession$getAgentInfo$1(agentId, this, callback, null));
    }

    public final ChatMessage W1() {
        ChatMessage chatMessageW;
        try {
            String sessionId = this.topConversation.getSessionId();
            if (sessionId.length() == 0) {
                sessionId = this.topConversation.getTempSessionId();
            }
            String str = sessionId;
            if (str.length() == 0 || (chatMessageW = this.messageRepository.w(str)) == null || chatMessageW.getRole() != AgentRole.ASSISTANT || !K.e(chatMessageW)) {
                return null;
            }
            this.messageRepository.q(chatMessageW.getMessageId());
            B0(new L0.MessageRemove(str, chatMessageW, 0L, 4, null));
            C4148a.k(this.TAG, "removeTopConversationEmptyAssistantPlaceholder removed messageId:" + chatMessageW.getMessageId() + " sessionId:" + str, false, 4, null);
            return chatMessageW;
        } catch (Exception e10) {
            C4148a.t(this.TAG, "removeTopConversationEmptyAssistantPlaceholder error:" + e10.getMessage(), e10, false, 8, null);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0208 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0209 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X(java.util.List<kotlin.TranscriptEvent> r25, java.lang.String r26, java.lang.String r27, com.stepos.agentframework.chatcore.send.SlaSessionAnchor r28, e9.InterfaceC4014c<? super kotlin.TranscriptAppendResult> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.X(java.util.List, java.lang.String, java.lang.String, com.stepos.agentframework.chatcore.send.l, e9.c):java.lang.Object");
    }

    /* renamed from: X0, reason: from getter */
    public final SessionConfig getConfig() {
        return this.config;
    }

    public final ChatMessage X1() {
        String sessionId = this.topConversation.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = this.topConversation.getTempSessionId();
        }
        return V1(sessionId, this.topConversation.M());
    }

    public final void Y(AgentConversation agentConversation, String str, w4.e eVar) {
        if (eVar != null && eVar.getIsTempSession()) {
            agentConversation.p0("");
            agentConversation.r0(str);
            agentConversation.q0(true);
        } else {
            agentConversation.p0(str);
            agentConversation.r0("");
            agentConversation.q0(false);
            agentConversation.m0(eVar != null ? eVar.getAgentId() : null);
            agentConversation.n0(eVar != null ? eVar.getDeviceId() : null);
        }
    }

    public final AgentConversation Y0(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        C4148a.k(this.TAG, "getConversation sessionId:" + sessionId + " conversation count:" + this.conversationMap.size(), false, 4, null);
        return this.conversationMap.get(sessionId);
    }

    public final void Y1(String sessionId, String newTitle, p9.p<? super Boolean, ? super w4.e, Y8.t> callback) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(newTitle, "newTitle");
        Function2.a(new AgentSession$renameConversation$1(this, sessionId, newTitle, callback, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:38:0x00a6, B:39:0x00b4, B:41:0x00ba, B:43:0x00cc, B:44:0x00d0, B:46:0x00dd, B:47:0x00f8, B:49:0x00fe, B:50:0x010c, B:51:0x013a, B:20:0x004c, B:34:0x0084, B:30:0x006f), top: B:61:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dd A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x0031, B:38:0x00a6, B:39:0x00b4, B:41:0x00ba, B:43:0x00cc, B:44:0x00d0, B:46:0x00dd, B:47:0x00f8, B:49:0x00fe, B:50:0x010c, B:51:0x013a, B:20:0x004c, B:34:0x0084, B:30:0x006f), top: B:61:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Z(java.lang.String r10, e9.InterfaceC4014c<? super java.util.List<w4.ChatMessage>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.Z(java.lang.String, e9.c):java.lang.Object");
    }

    public final ConcurrentHashMap<String, AgentConversation> Z0() {
        return this.conversationMap;
    }

    public final Object Z1(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        if (!com.stepos.agentframework.adapter.agentbus.bff.j.b(str)) {
            return Y8.t.f7040a;
        }
        w4.e eVarG = this.conversationTitleRepository.g(str2);
        String title = eVarG != null ? eVarG.getTitle() : null;
        if (title == null) {
            title = "";
        }
        String str3 = title;
        if (str3.length() == 0) {
            return Y8.t.f7040a;
        }
        C4148a.k(this.TAG, "rename external conversation remote sessionId:" + str2 + " title:" + str3, false, 4, null);
        Object objI = c1(str).getClient().I(str, this.config.getSecretKey(), str2, str3, interfaceC4014c);
        return objI == C4063a.g() ? objI : Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a0(com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.chatcore.session.AgentSession$awaitPendingSessionIdIfInFlight$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.chatcore.session.AgentSession$awaitPendingSessionIdIfInFlight$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$awaitPendingSessionIdIfInFlight$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$awaitPendingSessionIdIfInFlight$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$awaitPendingSessionIdIfInFlight$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r8 = r0.L$2
            com.stepos.agentframework.chatcore.session.AgentSession r8 = (com.stepos.agentframework.chatcore.session.AgentSession) r8
            java.lang.Object r8 = r0.L$1
            Ua.u r8 = (Ua.InterfaceC1083u) r8
            java.lang.Object r8 = r0.L$0
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = (com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation) r8
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L86
            goto L80
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.C4849c.b(r10)
            Ua.u r10 = r9.G()
            if (r10 != 0) goto L49
            Y8.t r8 = Y8.t.f7040a
            return r8
        L49:
            boolean r2 = r10.g()
            if (r2 == 0) goto L52
            Y8.t r8 = Y8.t.f7040a
            return r8
        L52:
            java.lang.String r2 = "框架·等待新建会话领key完成"
            kotlin.C0919o.k(r2)
            java.lang.String r2 = r8.TAG
            r4 = 4
            r5 = 0
            java.lang.String r6 = "await pending session id before resolving canonical key"
            r7 = 0
            h8.C4148a.k(r2, r6, r7, r4, r5)
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L86
            java.lang.Object r9 = g9.h.a(r9)     // Catch: java.lang.Throwable -> L86
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L86
            java.lang.Object r9 = g9.h.a(r10)     // Catch: java.lang.Throwable -> L86
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L86
            java.lang.Object r8 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L86
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L86
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L86
            r0.label = r3     // Catch: java.lang.Throwable -> L86
            java.lang.Object r8 = r10.a1(r0)     // Catch: java.lang.Throwable -> L86
            if (r8 != r1) goto L80
            return r1
        L80:
            Y8.t r8 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L86
            kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L86
            goto L90
        L86:
            r8 = move-exception
            kotlin.Result$a r9 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.C4849c.a(r8)
            kotlin.Result.b(r8)
        L90:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.a0(com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation, e9.c):java.lang.Object");
    }

    /* renamed from: a1, reason: from getter */
    public final x4.e getConversationTitleRepository() {
        return this.conversationTitleRepository;
    }

    public final void a2(ChatMessage message, String sessionId, boolean committedToUI) {
        List<AgentMessage> listI = message.i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listI) {
            if (((AgentMessage) obj).getType() == AgentMessageType.TEXT) {
                arrayList.add(obj);
            }
        }
        String strA0 = Z8.F.A0(arrayList, "", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return AgentSession.b2((AgentMessage) obj2);
            }
        }, 30, null);
        String traceId = message.getTraceId();
        String messageId = message.getMessageId();
        String agentId = message.getAgentId();
        if (agentId.length() == 0) {
            agentId = this.agentInfo.getAgentId();
        }
        d2(this, traceId, messageId, sessionId, agentId, message.getMessageId(), "CANCELED", "user_cancel", strA0, committedToUI, null, null, 1536, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(java.lang.String r19, boolean r20, e9.InterfaceC4014c<? super java.lang.Boolean> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.b0(java.lang.String, boolean, e9.c):java.lang.Object");
    }

    public final String b1() {
        return this.config.getSecretKey();
    }

    public final boolean c0(String sessionId, String outboundId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        String string = La.H.D1(sessionId).toString();
        String string2 = La.H.D1(outboundId).toString();
        if (string.length() == 0 || string2.length() == 0) {
            C4148a.u(this.TAG, "beginServerInitiatedRound skip: empty sessionId/outboundId", false, 4, null);
            return false;
        }
        AgentConversation agentConversationP0 = P0(string);
        if (agentConversationP0 != null) {
            return agentConversationP0.t(string, string2);
        }
        C4148a.u(this.TAG, "beginServerInitiatedRound: no conversation sessionId=" + string, false, 4, null);
        return false;
    }

    public final AgentDispatcher c1(String agentId) {
        AgentDispatcher agentDispatcher;
        String string = agentId != null ? La.H.D1(agentId).toString() : null;
        if (string == null || string.length() == 0) {
            agentDispatcher = this.dispatcher;
        } else {
            agentDispatcher = f1().get(string);
            if (agentDispatcher == null) {
                ConcurrentHashMap<String, AgentDispatcher> concurrentHashMapF1 = f1();
                Locale ROOT = Locale.ROOT;
                kotlin.jvm.internal.p.h(ROOT, "ROOT");
                String lowerCase = string.toLowerCase(ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                agentDispatcher = concurrentHashMapF1.get(lowerCase);
                if (agentDispatcher == null) {
                    agentDispatcher = this.dispatcher;
                }
            }
        }
        C4148a.k(this.TAG, "get dispatchers: " + agentId + "  " + agentDispatcher.getClient(), false, 4, null);
        return agentDispatcher;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c2(java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, boolean r45, java.lang.Integer r46, java.lang.String r47) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.c2(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.Integer, java.lang.String):void");
    }

    public final String d0(AgentConversation target, String key) {
        if (key.length() == 0) {
            return target.getSessionId();
        }
        AgentConversation agentConversation = this.conversationMap.get(key);
        if (agentConversation != null && agentConversation != target && agentConversation.P()) {
            C4148a.u(this.TAG, "bindSessionKey rejected: key=" + key + " already held by another active conversation (existingSid=" + agentConversation.getSessionId() + " existingTemp=" + agentConversation.getTempSessionId() + " targetSid=" + target.getSessionId() + " targetTemp=" + target.getTempSessionId() + ")", false, 4, null);
            return target.getSessionId();
        }
        String sessionId = target.getSessionId();
        if (sessionId.length() > 0 && !kotlin.jvm.internal.p.d(sessionId, key)) {
            C4148a.u(this.TAG, "bindSessionKey rejected: conversation already bound to canonical key=" + sessionId + ", discard rebind to key=" + key + " (concurrent session create)", false, 4, null);
            return sessionId;
        }
        synchronized (this.sessionMutationLock) {
            String sessionId2 = target.getSessionId();
            if (sessionId2.length() > 0 && !kotlin.jvm.internal.p.d(sessionId2, key)) {
                C4148a.u(this.TAG, "bindSessionKey rejected in lock: already bound=" + sessionId2 + ", discard key=" + key, false, 4, null);
                return sessionId2;
            }
            String tempSessionId = target.getTempSessionId();
            target.p0(key);
            target.r0("");
            target.q0(false);
            target.f0(tempSessionId);
            if (tempSessionId.length() > 0 && !kotlin.jvm.internal.p.d(tempSessionId, key) && this.conversationMap.get(tempSessionId) == target) {
                this.conversationMap.remove(tempSessionId);
            }
            this.conversationMap.put(key, target);
            target.W(key, tempSessionId);
            if (!kotlin.jvm.internal.p.d(sessionId, key)) {
                B0(new L0.SessionCreated(tempSessionId.length() > 0 ? tempSessionId : null, key, null, 0L, 12, null));
            }
            if (tempSessionId.length() > 0 && !kotlin.jvm.internal.p.d(tempSessionId, key)) {
                G1(tempSessionId);
                Function2.a(new AgentSession$bindSessionKey$2(this, tempSessionId, key, target, null));
            }
            return key;
        }
    }

    public final Object d1(String str, InterfaceC4014c<? super AgentDispatcher> interfaceC4014c) {
        if (str == null || La.H.x0(str)) {
            return this.dispatcher;
        }
        ChatMessage chatMessageV = this.messageRepository.v(str);
        return c1(chatMessageV != null ? chatMessageV.getAgentId() : null);
    }

    public final void e0() {
        w4.e eVarG = this.conversationTitleRepository.g(ConversationSessionIds.MAIN_SESSION_ID);
        if (eVarG == null || !eVarG.m()) {
            C2(this.topConversation);
            this.topConversation.p0(ConversationSessionIds.MAIN_SESSION_ID);
            this.topConversation.r0("");
            this.topConversation.q0(false);
            this.conversationMap.put(ConversationSessionIds.MAIN_SESSION_ID, this.topConversation);
            B0(new L0.ConversationChanged(ConversationSessionIds.MAIN_SESSION_ID, new w4.e(0, ConversationSessionIds.MAIN_SESSION_ID, ConversationSessionIds.MAIN_SESSION_DISPLAY_NAME, this.topConversation.getAgentId(), null, 0L, 0L, 0L, false, ConversationSessionKind.MAIN.getCode(), false, 0, 0, 7409, null), C1173v.m(), 0L, 8, null));
            return;
        }
        C4148a.u(this.TAG, "skip bind MAIN: session is hidden status=" + eVarG.getDeleteStatus(), false, 4, null);
        B0(new L0.ConversationChanged(null, null, C1173v.m(), 0L, 8, null));
    }

    public final Object e1(String str, InterfaceC4014c<? super AgentDispatcher> interfaceC4014c) {
        if (str == null || La.H.x0(str)) {
            return this.dispatcher;
        }
        AgentConversation agentConversationY0 = Y0(str);
        String agentId = agentConversationY0 != null ? agentConversationY0.getAgentId() : null;
        if (agentId == null) {
            w4.e eVarG = getConversationTitleRepository().g(str);
            agentId = eVarG != null ? eVarG.getAgentId() : null;
        }
        return c1(agentId);
    }

    public final void e2(String traceId, String agentId, String sessionId, String msgId, String outputText) {
        if (traceId.length() == 0) {
            return;
        }
        this.chatReporter.a(traceId, "user_chat", kotlin.collections.a.m(Y8.j.a("output_text", outputText), Y8.j.a("msg_id", msgId), Y8.j.a("msg_type", "downlink"), Y8.j.a("agent_id", agentId), Y8.j.a("session_id", sessionId)));
        C1846a.c(this.chatReporter, traceId, "user_chat", new LogMessage(LogLevel.INFO, "downlink", outputText, null, 8, null), 0, 8, null);
    }

    public final String f0(SendContext ctx) {
        List listM;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String text = ctx.getText();
        List listM2 = null;
        String string = text != null ? La.H.D1(text).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() > 0) {
            linkedHashMap.put("text", string);
        }
        List<FileInfo> listF = ctx.f();
        if (listF != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF) {
                FileInfo fileInfo = (FileInfo) obj;
                if (fileInfo.getFileType() == 1 && !La.H.x0(fileInfo.getFileUrl())) {
                    arrayList.add(obj);
                }
            }
            listM = new ArrayList(C1174w.x(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                listM.add(((FileInfo) it.next()).getFileUrl());
            }
        } else {
            listM = null;
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        if (!listM.isEmpty()) {
            linkedHashMap.put("image", listM.size() == 1 ? (String) listM.get(0) : Z8.F.A0(listM, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null));
        }
        List<FileInfo> listF2 = ctx.f();
        if (listF2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listF2) {
                FileInfo fileInfo2 = (FileInfo) obj2;
                if (fileInfo2.getFileType() == 2 && !La.H.x0(fileInfo2.getFileUrl())) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(((FileInfo) it2.next()).getFileUrl());
            }
            listM2 = arrayList3;
        }
        if (listM2 == null) {
            listM2 = C1173v.m();
        }
        if (!listM2.isEmpty()) {
            linkedHashMap.put("video", listM2.size() == 1 ? (String) listM2.get(0) : Z8.F.A0(listM2, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null));
        }
        return linkedHashMap.isEmpty() ? "" : com.stepos.agentframework.adapter.netcore.j.b(linkedHashMap);
    }

    public final ConcurrentHashMap<String, AgentDispatcher> f1() {
        return (ConcurrentHashMap) this.dispatchers.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f2(com.stepos.agentframework.chatcore.send.SendContext r18, com.stepos.agentframework.chatcore.send.LocalExecResult r19, e9.InterfaceC4014c<? super Y8.t> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.f2(com.stepos.agentframework.chatcore.send.e, com.stepos.agentframework.chatcore.send.b, e9.c):java.lang.Object");
    }

    public final Set<String> g0() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String sessionId = this.topConversation.getSessionId();
        if (sessionId.length() <= 0) {
            sessionId = null;
        }
        if (sessionId != null) {
            linkedHashSet.add(sessionId);
        }
        String tempSessionId = this.topConversation.getTempSessionId();
        if (tempSessionId.length() <= 0) {
            tempSessionId = null;
        }
        if (tempSessionId != null) {
            linkedHashSet.add(tempSessionId);
        }
        String str = this.migratingFromSessionId;
        String str2 = str.length() > 0 ? str : null;
        if (str2 != null) {
            linkedHashSet.add(str2);
        }
        return linkedHashSet;
    }

    public final Xa.o<L0> g1() {
        return this.events;
    }

    public final void g2(String traceId, String agentId, String sessionId, String inputText, Map<String, ? extends Object> bizData) {
        if (traceId.length() == 0 || inputText.length() == 0) {
            return;
        }
        this.chatReporter.a(traceId, "user_chat", kotlin.collections.a.m(Y8.j.a("input_text", inputText), Y8.j.a("msg_type", "uplink"), Y8.j.a("agent_id", agentId), Y8.j.a("session_id", sessionId), Y8.j.a("biz_data", bizData)));
        C1846a.c(this.chatReporter, traceId, "user_chat", new LogMessage(LogLevel.INFO, "uplink", inputText, null, 8, null), 0, 8, null);
    }

    public final String h0(List<AgentMessage> messages) {
        List<AgentMessage> list = messages;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            u4.m mVarC = ((AgentMessage) it.next()).getContent();
            String strN = mVarC instanceof m.TextMessage ? ((m.TextMessage) mVarC).getText() : null;
            if (strN != null) {
                arrayList.add(strN);
            }
        }
        String strA0 = Z8.F.A0(arrayList, "", null, null, 0, null, null, 62, null);
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            u4.m mVarC2 = ((AgentMessage) it2.next()).getContent();
            String strR = mVarC2 instanceof m.ImageMessage ? ((m.ImageMessage) mVarC2).getUrl() : null;
            if (strR != null) {
                arrayList2.add(strR);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (true) {
            boolean z10 = true;
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            String str = (String) next;
            if (str != null && !La.H.x0(str)) {
                z10 = false;
            }
            if (!z10) {
                arrayList3.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (strA0.length() > 0) {
            linkedHashMap.put("text", strA0);
        }
        if (!arrayList3.isEmpty()) {
            linkedHashMap.put("image", arrayList3.size() == 1 ? (String) arrayList3.get(0) : Z8.F.A0(arrayList3, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null));
        }
        return com.stepos.agentframework.adapter.netcore.j.b(linkedHashMap);
    }

    public final AgentDispatcher h1() {
        return (AgentDispatcher) this.extDispatcher.getValue();
    }

    public final void h2(String sessionId) {
        w4.e eVarG = this.conversationTitleRepository.g(sessionId);
        if (eVarG == null) {
            return;
        }
        String strB = P.b(P.INSTANCE, 0L, 1, null);
        if (kotlin.jvm.internal.p.d(eVarG.getTitle(), strB)) {
            return;
        }
        this.conversationTitleRepository.t(eVarG.getAgentId(), sessionId, strB);
        eVarG.s(strB);
        eVarG.t(2);
        C4148a.k(this.TAG, "resetConversationTitleToTimeDefault sessionId:" + sessionId + " title:" + strB, false, 4, null);
        M1(sessionId, eVarG);
    }

    public final void i0(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        String strF = M0.INSTANCE.f(sessionId);
        if (strF != null) {
            sessionId = strF;
        }
        m0(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AgentSession.j0(this.f22728a, sessionId, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* renamed from: i1, reason: from getter */
    public final SessionHandler getHandler() {
        return this.handler;
    }

    public final void i2() {
        this.topConversation = new AgentConversation();
        this.conversationMap.clear();
    }

    /* renamed from: j1, reason: from getter */
    public final x4.f getMessageRepository() {
        return this.messageRepository;
    }

    public final AgentConversation j2(SlaSessionAnchor anchor) {
        AgentConversation conversation;
        if (anchor == null || (conversation = anchor.getConversation()) == null) {
            return this.topConversation;
        }
        if (conversation.getThis$0() == this) {
            return conversation;
        }
        C4148a.u(this.TAG, "resolveAnchoredConversation: anchor from another session, fallback to topConversation", false, 4, null);
        return this.topConversation;
    }

    public final void k0(String agentId, String deviceId) {
        AgentConversation agentConversation = this.topConversation;
        agentConversation.getPrefetch().c();
        InterfaceC1083u<Y8.t> interfaceC1083uC = C1087w.c(null, 1, null);
        if (deviceId == null) {
            deviceId = agentConversation.getDeviceId();
        }
        AgentConversation agentConversation2 = new AgentConversation();
        agentConversation2.o0(interfaceC1083uC);
        if (agentId != null) {
            agentConversation2.m0(agentId);
        }
        if (deviceId != null) {
            agentConversation2.n0(deviceId);
        }
        C2(agentConversation);
        this.topConversation = agentConversation2;
        Function2.a(new AgentSession$changeToNewConversation$1(agentConversation2, this, agentId, interfaceC1083uC, null));
    }

    /* renamed from: k1, reason: from getter */
    public final String getMigratingFromSessionId() {
        return this.migratingFromSessionId;
    }

    public final String k2(String passed) {
        AgentConversation agentConversationP0;
        kotlin.jvm.internal.p.i(passed, "passed");
        if (passed.length() == 0 || (agentConversationP0 = P0(passed)) == null) {
            return passed;
        }
        String strA = C1961w.a(passed, agentConversationP0.getSessionId(), agentConversationP0.getTempSessionId(), agentConversationP0.I());
        if (!kotlin.jvm.internal.p.d(strA, passed)) {
            C4148a.d(this.TAG, "resolveCanonicalSessionId " + passed + " → " + strA, false, 4, null);
        }
        return strA;
    }

    /* renamed from: l1, reason: from getter */
    public final t4.b getPreProcessingCallback() {
        return this.preProcessingCallback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0117, code lost:
    
        if (r11 != r1) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l2(com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation r10, e9.InterfaceC4014c<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.l2(com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation, e9.c):java.lang.Object");
    }

    public final void m0(InterfaceC5074l<? super Boolean, Y8.t> executor) {
        int i10 = j.$EnumSwitchMapping$0[m1().ordinal()];
        if (i10 == 1) {
            executor.invoke(Boolean.TRUE);
            return;
        }
        if (i10 == 2) {
            Function2.a(new AgentSession$check$1(this, executor, null));
        } else if (com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(ChatCoreSdk.INSTANCE.c())) {
            Function2.a(new AgentSession$check$2(this, executor, null));
        } else {
            C4148a.u(this.TAG, "Network not available", false, 4, null);
            executor.invoke(Boolean.FALSE);
        }
    }

    public final ESessionStatus m1() {
        return this.statusState.getValue();
    }

    public final boolean m2(String sessionId, String outboundId, ChatMessage existing) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        kotlin.jvm.internal.p.i(existing, "existing");
        String string = La.H.D1(sessionId).toString();
        String string2 = La.H.D1(outboundId).toString();
        if (string.length() == 0 || string2.length() == 0) {
            C4148a.u(this.TAG, "resumeInboundAfterRetry skip: empty sessionId/outboundId", false, 4, null);
            return false;
        }
        AgentConversation agentConversationP0 = P0(string);
        if (agentConversationP0 != null) {
            return agentConversationP0.e0(string, string2, existing);
        }
        C4148a.u(this.TAG, "resumeInboundAfterRetry: no conversation sessionId=" + string, false, 4, null);
        return false;
    }

    public final void n0(Context context, FileInfo fileInfo, String traceId, InterfaceC5074l<? super Boolean, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(fileInfo, "fileInfo");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        if (fileInfo.getFileType() != 1) {
            onResult.invoke(Boolean.TRUE);
        } else {
            Function2.a(new AgentSession$checkImagePrivacy$1(fileInfo, context, this, traceId, onResult, null));
        }
    }

    /* renamed from: n1, reason: from getter */
    public final AgentConversation getTopConversation() {
        return this.topConversation;
    }

    public final void n2() {
        Function2.a(new AgentSession$retryPendingRemoteDeletes$1(this, null));
    }

    public final void o0(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Set setB = Z8.X.b();
        setB.add(this.topConversation);
        Collection<AgentConversation> collectionValues = this.conversationMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        setB.addAll(collectionValues);
        Iterator it = Z8.X.a(setB).iterator();
        while (it.hasNext()) {
            ((AgentConversation) it.next()).v(messageId);
        }
        Function2.a(new AgentSession$clearApprovalRequestId$3(this, messageId, null));
    }

    public final boolean o1() {
        boolean z10;
        synchronized (this.authHoldRequestIds) {
            z10 = !this.authHoldRequestIds.isEmpty();
        }
        return z10;
    }

    public final void o2(String agentId, Collection<String> keys, Set<String> insertedKeys) {
        for (String str : keys) {
            if (insertedKeys.contains(str)) {
                this.conversationTitleRepository.h(agentId, str);
            } else {
                this.conversationTitleRepository.k(agentId, str);
            }
        }
        Function2.b(new AgentSession$revertDeletingTombstones$2(this, null));
    }

    public final void p0(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        Set setB = Z8.X.b();
        setB.add(this.topConversation);
        Collection<AgentConversation> collectionValues = this.conversationMap.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        setB.addAll(collectionValues);
        Iterator it = Z8.X.a(setB).iterator();
        while (it.hasNext()) {
            ((AgentConversation) it.next()).w(messageId);
        }
    }

    public final boolean p1() {
        if (com.stepos.agentframework.chatcore.audit.l.INSTANCE.b(this.config.getAgentId())) {
            return false;
        }
        List<w4.e> listJ = this.conversationTitleRepository.j(this.config.getAgentId());
        if (!(listJ instanceof Collection) || !listJ.isEmpty()) {
            Iterator<T> it = listJ.iterator();
            while (it.hasNext()) {
                if (!((w4.e) it.next()).getIsTempSession()) {
                    C4148a.k(this.TAG, "hasNeverConversedForMainAgent: hasNonTempTitle=true result=false", false, 4, null);
                    return false;
                }
            }
        }
        boolean zD = this.messageRepository.d();
        boolean z10 = !zD;
        C4148a.k(this.TAG, "hasNeverConversedForMainAgent: hasNonTempTitle=false hasAnyMessage=" + zD + " result=" + z10, false, 4, null);
        return z10;
    }

    public final boolean p2(String sessionId, String requestId, String decision, String reason, String askUserQuestion, InterfaceC5074l<? super Boolean, Y8.t> onResult) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(decision, "decision");
        kotlin.jvm.internal.p.i(reason, "reason");
        kotlin.jvm.internal.p.i(onResult, "onResult");
        if (La.H.x0(sessionId) || La.H.x0(requestId) || La.H.x0(decision)) {
            return false;
        }
        Function2.a(new AgentSession$sendApproval$2(this, sessionId, requestId, decision, reason, askUserQuestion, onResult, null));
        return true;
    }

    public final void q0() {
        C4148a.k(this.TAG, "clearContext", false, 4, null);
    }

    public final void q1(String sessionId, String requestId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        if (sessionId.length() == 0 || requestId.length() == 0) {
            return;
        }
        S1(requestId);
        B0(new L0.ReconnectPromptDismissEvent(sessionId, ReconnectReason.AI_TIMEOUT, 0L, 4, null));
        if (v1(sessionId)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            AgentConversation agentConversation = this.topConversation;
            if (agentConversation.P() && v0(agentConversation, sessionId)) {
                linkedHashSet.add(agentConversation);
            }
            for (AgentConversation agentConversation2 : this.conversationMap.values()) {
                kotlin.jvm.internal.p.h(agentConversation2, "next(...)");
                AgentConversation agentConversation3 = agentConversation2;
                if (agentConversation3.P() && v0(agentConversation3, sessionId)) {
                    linkedHashSet.add(agentConversation3);
                }
            }
            Iterator it = linkedHashSet.iterator();
            kotlin.jvm.internal.p.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.p.h(next, "next(...)");
                ((AgentConversation) next).O(requestId);
            }
        }
    }

    public final void q2(t4.b bVar) {
        this.preProcessingCallback = bVar;
    }

    public final void r0(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        Function2.a(new AgentSession$clearConversationMessages$1(sessionId, this, null));
    }

    public final void r1() {
        W0(this.config.getAgentId(), new p9.p() { // from class: com.stepos.agentframework.chatcore.session.e
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AgentSession.s1(this.f22723a, (C5732a) obj, (Exception) obj2);
            }
        });
    }

    public final void r2(f fVar) {
        this.prepareCallback = fVar;
    }

    public final void s0(String fromKey) {
        kotlin.jvm.internal.p.i(fromKey, "fromKey");
        if (kotlin.jvm.internal.p.d(this.migratingFromSessionId, fromKey)) {
            this.migratingFromSessionId = "";
        }
    }

    public final void s2(ESessionStatus value) {
        kotlin.jvm.internal.p.i(value, "value");
        this.statusState.setValue(value);
    }

    public final void t2(AgentConversation agentConversation) {
        kotlin.jvm.internal.p.i(agentConversation, "<set-?>");
        this.topConversation = agentConversation;
    }

    public final void u0(AgentConversation conv, Set<String> out) {
        if (conv.P()) {
            String sessionId = conv.getSessionId();
            String tempSessionId = conv.getTempSessionId();
            if (sessionId.length() > 0) {
                out.add(sessionId);
                out.addAll(M0.INSTANCE.a(sessionId));
            }
            if (tempSessionId.length() <= 0 || kotlin.jvm.internal.p.d(tempSessionId, sessionId)) {
                return;
            }
            out.add(tempSessionId);
            out.addAll(M0.INSTANCE.a(tempSessionId));
        }
    }

    public final void u1(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (this.conversationMap.containsKey(sessionId)) {
            return;
        }
        ConcurrentHashMap<String, AgentConversation> concurrentHashMap = this.conversationMap;
        AgentConversation agentConversation = new AgentConversation();
        agentConversation.p0(sessionId);
        concurrentHashMap.put(sessionId, agentConversation);
    }

    public final void u2(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() != 0 && v1(sessionId)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            AgentConversation agentConversation = this.topConversation;
            if (agentConversation.P() && v0(agentConversation, sessionId)) {
                linkedHashSet.add(agentConversation);
            }
            for (AgentConversation agentConversation2 : this.conversationMap.values()) {
                kotlin.jvm.internal.p.h(agentConversation2, "next(...)");
                AgentConversation agentConversation3 = agentConversation2;
                if (agentConversation3.P() && v0(agentConversation3, sessionId)) {
                    linkedHashSet.add(agentConversation3);
                }
            }
            Iterator it = linkedHashSet.iterator();
            kotlin.jvm.internal.p.h(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.p.h(next, "next(...)");
                ((AgentConversation) next).t0();
            }
        }
    }

    public final boolean v0(AgentConversation conversation, String sessionId) {
        if (sessionId.length() == 0) {
            return false;
        }
        if (!kotlin.jvm.internal.p.d(conversation.getSessionId(), sessionId) && !kotlin.jvm.internal.p.d(conversation.getTempSessionId(), sessionId)) {
            Set<String> setA = M0.INSTANCE.a(sessionId);
            if (!setA.contains(conversation.getSessionId()) && !setA.contains(conversation.getTempSessionId())) {
                return false;
            }
        }
        return true;
    }

    public final boolean v1(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return false;
        }
        AgentConversation agentConversation = this.topConversation;
        if (agentConversation.P() && v0(agentConversation, sessionId)) {
            return true;
        }
        Iterator<String> it = M0.INSTANCE.a(sessionId).iterator();
        while (it.hasNext()) {
            AgentConversation agentConversation2 = this.conversationMap.get(it.next());
            if (agentConversation2 != null && agentConversation2.P()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v2(java.lang.String r6, java.lang.String r7, java.util.List<java.lang.String> r8, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.InquiryAnswerResult> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentframework.chatcore.session.AgentSession$syncAnswerInquiry$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentframework.chatcore.session.AgentSession$syncAnswerInquiry$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$syncAnswerInquiry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$syncAnswerInquiry$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$syncAnswerInquiry$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r5 = r0.L$3
            com.stepos.agentframework.chatcore.session.AgentSession r5 = (com.stepos.agentframework.chatcore.session.AgentSession) r5
            java.lang.Object r5 = r0.L$2
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3a
            goto L72
        L3a:
            r5 = move-exception
            goto L79
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.C4849c.b(r9)
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r9 = r5.dispatcher     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.chatcore.agents.u r9 = r9.getClient()     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r2 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r2 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r5     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L3a
            r0.label = r4     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r9 = r9.k(r6, r7, r8, r0)     // Catch: java.lang.Throwable -> L3a
            if (r9 != r1) goto L72
            return r1
        L72:
            com.stepos.agentframework.adapter.netcore.q r9 = (com.stepos.agentframework.adapter.netcore.InquiryAnswerResult) r9     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r5 = kotlin.Result.b(r9)     // Catch: java.lang.Throwable -> L3a
            goto L83
        L79:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L83:
            java.lang.Throwable r6 = kotlin.Result.e(r5)
            if (r6 != 0) goto L8a
            goto L91
        L8a:
            com.stepos.agentframework.adapter.netcore.q r5 = new com.stepos.agentframework.adapter.netcore.q
            r6 = 2
            r7 = 0
            r5.<init>(r3, r7, r6, r7)
        L91:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.v2(java.lang.String, java.lang.String, java.util.List, e9.c):java.lang.Object");
    }

    public final String w0() {
        ChatMessage chatMessageM = this.topConversation.M();
        if (chatMessageM != null) {
            return chatMessageM.getMessageId();
        }
        return null;
    }

    public final boolean w1(Collection<String> keys) {
        if (keys.isEmpty()) {
            return false;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        x1(linkedHashSet, this.topConversation.B());
        x1(linkedHashSet, this.topConversation.getSessionId());
        x1(linkedHashSet, this.topConversation.getTempSessionId());
        if (linkedHashSet.isEmpty()) {
            return false;
        }
        Collection<String> collection = keys;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            String string = La.H.D1((String) it.next()).toString();
            if (string.length() > 0) {
                if (linkedHashSet.contains(string)) {
                    return true;
                }
                Set<String> setA = M0.INSTANCE.a(string);
                if (!(setA instanceof Collection) || !setA.isEmpty()) {
                    Iterator<T> it2 = setA.iterator();
                    while (it2.hasNext()) {
                        if (linkedHashSet.contains((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w2(kotlin.TaskBatchDeleteRequest r6, e9.InterfaceC4014c<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatcore.session.AgentSession$syncBatchDeleteTask$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatcore.session.AgentSession$syncBatchDeleteTask$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$syncBatchDeleteTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$syncBatchDeleteTask$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$syncBatchDeleteTask$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r5 = r0.L$1
            com.stepos.agentframework.chatcore.session.AgentSession r5 = (com.stepos.agentframework.chatcore.session.AgentSession) r5
            java.lang.Object r5 = r0.L$0
            K6.E r5 = (kotlin.TaskBatchDeleteRequest) r5
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L32
            goto L5e
        L32:
            r5 = move-exception
            goto L6d
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.C4849c.b(r7)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r7 = r5.dispatcher     // Catch: java.lang.Throwable -> L32
            com.stepos.agentframework.chatcore.agents.u r7 = r7.getClient()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r2 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L32
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L32
            r0.label = r4     // Catch: java.lang.Throwable -> L32
            java.lang.Object r7 = r7.g(r6, r0)     // Catch: java.lang.Throwable -> L32
            if (r7 != r1) goto L5e
            return r1
        L5e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L32
            boolean r5 = r7.booleanValue()     // Catch: java.lang.Throwable -> L32
            java.lang.Boolean r5 = g9.C4109a.a(r5)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L32
            goto L77
        L6d:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L77:
            java.lang.Throwable r6 = kotlin.Result.e(r5)
            if (r6 != 0) goto L7e
            goto L82
        L7e:
            java.lang.Boolean r5 = g9.C4109a.a(r3)
        L82:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.w2(K6.E, e9.c):java.lang.Object");
    }

    public final void x0(String sessionId, p9.p<? super Boolean, ? super w4.e, Y8.t> callback) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        Function2.a(new AgentSession$deleteConversation$1(this, sessionId, callback, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x2(kotlin.TaskCancelRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.session.AgentSession$syncCancelTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.session.AgentSession$syncCancelTask$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$syncCancelTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$syncCancelTask$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$syncCancelTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.L$2
            com.stepos.agentframework.chatcore.session.AgentSession r6 = (com.stepos.agentframework.chatcore.session.AgentSession) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            K6.F r6 = (kotlin.TaskCancelRequest) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L36
            goto L7a
        L36:
            r6 = move-exception
            goto L89
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.C4849c.b(r8)
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = r6.topConversation
            java.lang.String r8 = r8.getSessionId()
            int r2 = r8.length()
            if (r2 != 0) goto L55
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = r6.topConversation
            java.lang.String r8 = r8.getTempSessionId()
        L55:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r2 = r6.dispatcher     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.chatcore.agents.u r2 = r2.getClient()     // Catch: java.lang.Throwable -> L36
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L36
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L36
            java.lang.Object r8 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L36
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L36
            r0.label = r4     // Catch: java.lang.Throwable -> L36
            java.lang.Object r8 = r2.e(r7, r0)     // Catch: java.lang.Throwable -> L36
            if (r8 != r1) goto L7a
            return r1
        L7a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L36
            boolean r6 = r8.booleanValue()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r6 = g9.C4109a.a(r6)     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L36
            goto L93
        L89:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L93:
            java.lang.Throwable r7 = kotlin.Result.e(r6)
            if (r7 != 0) goto L9a
            goto L9e
        L9a:
            java.lang.Boolean r6 = g9.C4109a.a(r3)
        L9e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.x2(K6.F, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c7 -> B:26:0x00d8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y0(java.lang.String r18, java.lang.String r19, java.util.Collection<java.lang.String> r20, e9.InterfaceC4014c<? super java.lang.Boolean> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.y0(java.lang.String, java.lang.String, java.util.Collection, e9.c):java.lang.Object");
    }

    public final void y1(String reason) {
        C4148a.k(this.TAG, "leaveHiddenConversation reason=" + reason + " top=" + this.topConversation.B(), false, 4, null);
        Function2.b(new AgentSession$leaveHiddenConversation$1(this, null));
        l0(this, null, null, 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y2(kotlin.TaskDeleteRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.session.AgentSession$syncDeleteTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.session.AgentSession$syncDeleteTask$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$syncDeleteTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$syncDeleteTask$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$syncDeleteTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.L$2
            com.stepos.agentframework.chatcore.session.AgentSession r6 = (com.stepos.agentframework.chatcore.session.AgentSession) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            K6.G r6 = (kotlin.TaskDeleteRequest) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L36
            goto L7a
        L36:
            r6 = move-exception
            goto L89
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.C4849c.b(r8)
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = r6.topConversation
            java.lang.String r8 = r8.getSessionId()
            int r2 = r8.length()
            if (r2 != 0) goto L55
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = r6.topConversation
            java.lang.String r8 = r8.getTempSessionId()
        L55:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r2 = r6.dispatcher     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.chatcore.agents.u r2 = r2.getClient()     // Catch: java.lang.Throwable -> L36
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L36
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L36
            java.lang.Object r8 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L36
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L36
            r0.label = r4     // Catch: java.lang.Throwable -> L36
            java.lang.Object r8 = r2.f(r7, r0)     // Catch: java.lang.Throwable -> L36
            if (r8 != r1) goto L7a
            return r1
        L7a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L36
            boolean r6 = r8.booleanValue()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r6 = g9.C4109a.a(r6)     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L36
            goto L93
        L89:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L93:
            java.lang.Throwable r7 = kotlin.Result.e(r6)
            if (r7 != 0) goto L9a
            goto L9e
        L9a:
            java.lang.Boolean r6 = g9.C4109a.a(r3)
        L9e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.y2(K6.G, e9.c):java.lang.Object");
    }

    public final void z0(String sessionId, String recalledMessageId) {
        w4.e eVarG = this.conversationTitleRepository.g(sessionId);
        if (eVarG == null) {
            return;
        }
        this.conversationTitleRepository.h(eVarG.getAgentId(), sessionId);
        SessionActivityTracker.INSTANCE.a(sessionId);
        RevertedSessionGuard.INSTANCE.c(sessionId);
        C4148a.k(this.TAG, "finalizeTopConversationAfterUserRevert deleted sessionId:" + sessionId + " recalled:" + recalledMessageId, false, 4, null);
        B0(new L0.ConversationDeleted(sessionId, eVarG, 0L, 4, null));
        Function2.b(new AgentSession$deleteConversationRowAfterUserRevert$1(this, sessionId, null));
    }

    public final void z1(e callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        Function2.a(new AgentSession$loadConversationTitles$1(this, callback, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z2(kotlin.TaskInteractRequest r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.agentframework.chatcore.session.AgentSession$syncInteractTask$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.agentframework.chatcore.session.AgentSession$syncInteractTask$1 r0 = (com.stepos.agentframework.chatcore.session.AgentSession$syncInteractTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.session.AgentSession$syncInteractTask$1 r0 = new com.stepos.agentframework.chatcore.session.AgentSession$syncInteractTask$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.L$2
            com.stepos.agentframework.chatcore.session.AgentSession r6 = (com.stepos.agentframework.chatcore.session.AgentSession) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            K6.H r6 = (kotlin.TaskInteractRequest) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L36
            goto L7a
        L36:
            r6 = move-exception
            goto L89
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.C4849c.b(r8)
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = r6.topConversation
            java.lang.String r8 = r8.getSessionId()
            int r2 = r8.length()
            if (r2 != 0) goto L55
            com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = r6.topConversation
            java.lang.String r8 = r8.getTempSessionId()
        L55:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r2 = r6.dispatcher     // Catch: java.lang.Throwable -> L36
            com.stepos.agentframework.chatcore.agents.u r2 = r2.getClient()     // Catch: java.lang.Throwable -> L36
            java.lang.Object r5 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L36
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L36
            java.lang.Object r8 = g9.h.a(r8)     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L36
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L36
            r0.label = r4     // Catch: java.lang.Throwable -> L36
            java.lang.Object r8 = r2.a(r7, r0)     // Catch: java.lang.Throwable -> L36
            if (r8 != r1) goto L7a
            return r1
        L7a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L36
            boolean r6 = r8.booleanValue()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r6 = g9.C4109a.a(r6)     // Catch: java.lang.Throwable -> L36
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L36
            goto L93
        L89:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L93:
            java.lang.Throwable r7 = kotlin.Result.e(r6)
            if (r7 != 0) goto L9a
            goto L9e
        L9a:
            java.lang.Boolean r6 = g9.C4109a.a(r3)
        L9e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession.z2(K6.H, e9.c):java.lang.Object");
    }

    public /* synthetic */ AgentSession(final SessionHandler sessionHandler, SessionConfig sessionConfig, x4.f fVar, x4.e eVar, int i10, kotlin.jvm.internal.i iVar) {
        this(sessionHandler, sessionConfig, (i10 & 4) != 0 ? new x4.v(null, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentSession.o(sessionHandler);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatcore.session.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AgentSession.p(sessionHandler);
            }
        }, 1, null) : fVar, (i10 & 8) != 0 ? new x4.d() : eVar);
    }
}
