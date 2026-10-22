package com.stepos.agentframework.chatcore.session;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.adapter.netcore.DownlinkRunTelemetry;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.agentframework.chatcore.audit.RevertedSessionGuard;
import com.stepos.agentframework.chatcore.audit.RunBlockedEvent;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.L0;
import com.stepos.agentframework.chatcore.session.bean.AgentTaskEventType;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.ailauncher.agent.ability.VoiceAbilityService;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C0917m;
import kotlin.C0919o;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReferenceSource;
import kotlin.Result;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import r4.C5218a;
import s4.C5442c;
import u4.AgentMessage;
import u4.AgentModeration;
import u4.AgentResponse;
import u4.AgentTask;
import u4.AgentTaskComplete;
import u4.AgentTaskError;
import u4.AgentTaskEvent;
import u4.AgentTaskPlan;
import u4.m;
import v9.C5685n;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0005\u001a\u00060\u0004R\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0014H\u0002¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u000f\u0010#\u001a\u00020\u0014H\u0002¢\u0006\u0004\b#\u0010\u001eJ\u000f\u0010$\u001a\u00020\u0014H\u0002¢\u0006\u0004\b$\u0010\u001eJ\u0017\u0010%\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010\u0016J\u000f\u0010&\u001a\u00020\u0017H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010\u0016J\u000f\u0010)\u001a\u00020\u0017H\u0002¢\u0006\u0004\b)\u0010'J\u0017\u0010+\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0017H\u0002¢\u0006\u0004\b-\u0010'J\u000f\u0010.\u001a\u00020\u0017H\u0002¢\u0006\u0004\b.\u0010'J\u0017\u0010/\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b/\u0010,J\u001f\u00102\u001a\u00020\u00142\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u00105J!\u00106\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0004\b6\u00103J\u000f\u00107\u001a\u00020\u0017H\u0002¢\u0006\u0004\b7\u0010'J\u000f\u00108\u001a\u00020\u0017H\u0002¢\u0006\u0004\b8\u0010'J\u0017\u0010;\u001a\u00020\u00172\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0017H\u0002¢\u0006\u0004\b=\u0010'J\u001d\u0010@\u001a\u00020\u00142\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090>H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0017H\u0002¢\u0006\u0004\bB\u0010'J\u0017\u0010D\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0012H\u0002¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0014H\u0002¢\u0006\u0004\bF\u0010\u001eJ\u000f\u0010G\u001a\u00020\u0014H\u0002¢\u0006\u0004\bG\u0010\u001eJ\u000f\u0010H\u001a\u00020\u0014H\u0002¢\u0006\u0004\bH\u0010\u001eJ\u000f\u0010I\u001a\u00020\u0014H\u0002¢\u0006\u0004\bI\u0010\u001eJ\u000f\u0010J\u001a\u00020\u0014H\u0002¢\u0006\u0004\bJ\u0010\u001eJ\u000f\u0010K\u001a\u00020\u0014H\u0002¢\u0006\u0004\bK\u0010\u001eJ\u000f\u0010L\u001a\u00020\u0014H\u0002¢\u0006\u0004\bL\u0010\u001eJ\u000f\u0010M\u001a\u00020\u0014H\u0002¢\u0006\u0004\bM\u0010\u001eJ\u000f\u0010N\u001a\u00020\bH\u0002¢\u0006\u0004\bN\u0010\u0010J\u0017\u0010Q\u001a\u00020\u00142\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u00142\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bS\u0010RJ\u0017\u0010T\u001a\u00020\u00142\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bT\u0010RJ\u000f\u0010U\u001a\u00020\u0014H\u0002¢\u0006\u0004\bU\u0010\u001eJ\u001d\u0010V\u001a\u00020\u00142\f\u0010?\u001a\b\u0012\u0004\u0012\u0002090>H\u0002¢\u0006\u0004\bV\u0010AJ\u0017\u0010W\u001a\u00020\b2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0014H\u0002¢\u0006\u0004\bY\u0010\u001eJ\u0017\u0010\\\u001a\u00020\u00142\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\u00172\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b^\u0010_J\u0017\u0010`\u001a\u00020\u00142\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b`\u0010]J\u0017\u0010c\u001a\u00020\u00172\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0017H\u0002¢\u0006\u0004\be\u0010'J\u0017\u0010f\u001a\u00020\u00172\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\u0017H\u0002¢\u0006\u0004\bg\u0010'J\u000f\u0010h\u001a\u00020\u0017H\u0002¢\u0006\u0004\bh\u0010'J\u000f\u0010i\u001a\u00020\u0017H\u0002¢\u0006\u0004\bi\u0010'J\u000f\u0010j\u001a\u00020\u0014H\u0002¢\u0006\u0004\bj\u0010\u001eJ\u0017\u0010k\u001a\u00020\u00142\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0004\bk\u0010lJ\u0017\u0010o\u001a\u00020\u00142\u0006\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\bo\u0010pJ\u0019\u0010q\u001a\u00020\b2\b\u0010P\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0004\bq\u0010rJ\u0019\u0010s\u001a\u00020\b2\b\u0010P\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0004\bs\u0010rJ7\u0010w\u001a\u00020\u00142\u0006\u0010t\u001a\u00020\b2\u0006\u0010u\u001a\u00020\b2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\bw\u0010xJ\u0017\u0010z\u001a\u00020\b2\u0006\u0010y\u001a\u00020\bH\u0002¢\u0006\u0004\bz\u0010{J\u0017\u0010|\u001a\u00020\u00142\u0006\u0010n\u001a\u00020mH\u0002¢\u0006\u0004\b|\u0010pJ!\u0010}\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b}\u00103J\u0017\u0010\u007f\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\bH\u0002¢\u0006\u0004\b\u007f\u00105J\"\u0010\u0081\u0001\u001a\u00020\u00142\u0007\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010~\u001a\u00020\bH\u0002¢\u0006\u0005\b\u0081\u0001\u00103J\"\u0010\u0084\u0001\u001a\u00020\b2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010>H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\u00142\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0005\b\u0086\u0001\u0010lJ\u0011\u0010\u0087\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u001eJ\u0011\u0010\u0088\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\b\u0088\u0001\u0010\u001eJ+\u0010\u008c\u0001\u001a\u00020\u00142\b\u0010\u008a\u0001\u001a\u00030\u0089\u00012\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u0002090>H\u0002¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u0019\u0010\u008e\u0001\u001a\u00020\u00142\u0006\u0010b\u001a\u00020aH\u0002¢\u0006\u0005\b\u008e\u0001\u0010lJ\u000f\u0010\u008f\u0001\u001a\u00020\b¢\u0006\u0005\b\u008f\u0001\u0010\u0010J\u000f\u0010\u0090\u0001\u001a\u00020\b¢\u0006\u0005\b\u0090\u0001\u0010\u0010J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\b¢\u0006\u0005\b\u0091\u0001\u0010\u0010J\u0018\u0010\u0093\u0001\u001a\u00020\u00142\u0007\u0010\u0092\u0001\u001a\u00020O¢\u0006\u0005\b\u0093\u0001\u0010RJ\u0018\u0010\u0094\u0001\u001a\u00020\u00142\u0007\u0010\u0092\u0001\u001a\u00020O¢\u0006\u0005\b\u0094\u0001\u0010RJ\u000f\u0010\u0095\u0001\u001a\u00020\u0017¢\u0006\u0005\b\u0095\u0001\u0010'J\u000f\u0010\u0096\u0001\u001a\u00020\u0017¢\u0006\u0005\b\u0096\u0001\u0010'J\u000f\u0010\u0097\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u0097\u0001\u0010\u001eJ\u000f\u0010\u0098\u0001\u001a\u00020\u0017¢\u0006\u0005\b\u0098\u0001\u0010'J\u000f\u0010\u0099\u0001\u001a\u00020\u0017¢\u0006\u0005\b\u0099\u0001\u0010'J\u000f\u0010\u009a\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u009a\u0001\u0010\u001eJ\u000f\u0010\u009b\u0001\u001a\u00020\u0014¢\u0006\u0005\b\u009b\u0001\u0010\u001eJ\u0017\u0010\u009c\u0001\u001a\u00020\u00142\u0006\u00100\u001a\u00020\b¢\u0006\u0005\b\u009c\u0001\u00105J\u001f\u0010\u009d\u0001\u001a\u00020\u00142\u0006\u00100\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b¢\u0006\u0005\b\u009d\u0001\u00103J\u0017\u0010\u009e\u0001\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0005\b\u009e\u0001\u00105J\u0011\u0010\u009f\u0001\u001a\u00020\u0014H\u0016¢\u0006\u0005\b\u009f\u0001\u0010\u001eJ\u0011\u0010 \u0001\u001a\u00020\u0014H\u0016¢\u0006\u0005\b \u0001\u0010\u001eJ2\u0010¥\u0001\u001a\u00020\u00142\b\u0010¢\u0001\u001a\u00030¡\u00012\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\u00172\t\b\u0002\u0010¤\u0001\u001a\u00020\u0017¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u0019\u0010§\u0001\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\bH\u0016¢\u0006\u0005\b§\u0001\u00105J\u0019\u0010¨\u0001\u001a\u00020\u00142\u0006\u0010n\u001a\u00020mH\u0016¢\u0006\u0005\b¨\u0001\u0010pJ\u0019\u0010©\u0001\u001a\u00020\u00142\u0006\u0010n\u001a\u00020mH\u0016¢\u0006\u0005\b©\u0001\u0010pJ\u0019\u0010ª\u0001\u001a\u00020\u00142\u0006\u0010b\u001a\u00020aH\u0016¢\u0006\u0005\bª\u0001\u0010lJ1\u0010®\u0001\u001a\u00020\u00142\u0007\u0010«\u0001\u001a\u00020\u00172\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00012\b\u0010P\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u000f\u0010°\u0001\u001a\u00020\u0014¢\u0006\u0005\b°\u0001\u0010\u001eJ\u001c\u0010³\u0001\u001a\u00020\u00142\b\u0010²\u0001\u001a\u00030±\u0001H\u0016¢\u0006\u0006\b³\u0001\u0010´\u0001J+\u0010¸\u0001\u001a\u00020\u00142\u0007\u0010µ\u0001\u001a\u00020\b2\u000e\u0010·\u0001\u001a\t\u0012\u0005\u0012\u00030¶\u00010>H\u0016¢\u0006\u0006\b¸\u0001\u0010¹\u0001J-\u0010¼\u0001\u001a\u00020\u00142\u0007\u0010µ\u0001\u001a\u00020\b2\u0007\u0010º\u0001\u001a\u00020\b2\u0007\u0010»\u0001\u001a\u00020\bH\u0016¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u001c\u0010À\u0001\u001a\u00020\u00142\b\u0010¿\u0001\u001a\u00030¾\u0001H\u0016¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u001c\u0010Ã\u0001\u001a\u00020\u00142\b\u0010¿\u0001\u001a\u00030Â\u0001H\u0016¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u001c\u0010Æ\u0001\u001a\u00020\u00142\b\u0010¿\u0001\u001a\u00030Å\u0001H\u0016¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u001c\u0010É\u0001\u001a\u00020\u00142\b\u0010¿\u0001\u001a\u00030È\u0001H\u0016¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J \u0010Ì\u0001\u001a\u00020\u00142\r\u0010?\u001a\t\u0012\u0004\u0012\u0002090Ë\u0001H\u0016¢\u0006\u0005\bÌ\u0001\u0010AJ\u0017\u0010Í\u0001\u001a\u00020\u00142\u0006\u0010n\u001a\u00020m¢\u0006\u0005\bÍ\u0001\u0010pJ\u0017\u0010Î\u0001\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\b¢\u0006\u0005\bÎ\u0001\u00105J@\u0010Ó\u0001\u001a\u00020\u00142\u0007\u0010Ï\u0001\u001a\u00020\b2\u0006\u0010~\u001a\u00020\b2\t\b\u0002\u0010Ð\u0001\u001a\u00020\u00172\u0007\u0010Ñ\u0001\u001a\u00020\b2\t\b\u0002\u0010Ò\u0001\u001a\u00020\b¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u0012\u0010Õ\u0001\u001a\u0004\u0018\u00010O¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u0016\u0010×\u0001\u001a\b\u0012\u0004\u0012\u00020O0>¢\u0006\u0006\b×\u0001\u0010Ø\u0001J]\u0010Ý\u0001\u001a\u00020\u00142\u0007\u0010Ñ\u0001\u001a\u00020\b2\u000e\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010>2\u000b\b\u0002\u0010Ù\u0001\u001a\u0004\u0018\u00010O2\u000b\b\u0002\u0010Ú\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010Û\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010Ü\u0001\u001a\u0004\u0018\u00010\b¢\u0006\u0006\bÝ\u0001\u0010Þ\u0001J\u001b\u0010ß\u0001\u001a\u00020\u00142\n\b\u0002\u00101\u001a\u0004\u0018\u00010\b¢\u0006\u0005\bß\u0001\u00105J\u000f\u0010à\u0001\u001a\u00020\u0014¢\u0006\u0005\bà\u0001\u0010\u001eJ\u000f\u0010á\u0001\u001a\u00020\u0017¢\u0006\u0005\bá\u0001\u0010'J\u0018\u0010ã\u0001\u001a\u00020\u00142\u0007\u0010â\u0001\u001a\u00020\b¢\u0006\u0005\bã\u0001\u00105J\u0017\u0010ä\u0001\u001a\u00020\u00142\u0006\u0010b\u001a\u00020a¢\u0006\u0005\bä\u0001\u0010lJ\u0019\u0010å\u0001\u001a\u00020\u00142\b\b\u0002\u0010y\u001a\u00020\b¢\u0006\u0005\bå\u0001\u00105J\u0018\u0010æ\u0001\u001a\u00020\u00172\u0006\u0010P\u001a\u00020O¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u0019\u0010è\u0001\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\b¢\u0006\u0005\bè\u0001\u00105J\u001c\u0010ë\u0001\u001a\u00020\u00142\b\u0010ê\u0001\u001a\u00030é\u0001H\u0000¢\u0006\u0006\bë\u0001\u0010ì\u0001J\u000f\u0010í\u0001\u001a\u00020\u0014¢\u0006\u0005\bí\u0001\u0010\u001eJ%\u0010ñ\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010î\u0001\u001a\u00020\b2\b\u0010ð\u0001\u001a\u00030ï\u0001¢\u0006\u0006\bñ\u0001\u0010ò\u0001J\u0017\u0010ó\u0001\u001a\u00020\u00142\u0006\u00101\u001a\u00020\b¢\u0006\u0005\bó\u0001\u00105J\u0017\u0010ô\u0001\u001a\u00020\u00142\u0006\u00101\u001a\u00020\b¢\u0006\u0005\bô\u0001\u00105J\"\u0010õ\u0001\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\bH\u0000¢\u0006\u0005\bõ\u0001\u00103R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010ö\u0001R+\u0010\u0005\u001a\u00060\u0004R\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0005\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R)\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0007\u0010ü\u0001\u001a\u0006\bý\u0001\u0010þ\u0001\"\u0006\bÿ\u0001\u0010\u0080\u0002R\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0081\u0002R\u001b\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\u000e\n\u0005\b\f\u0010\u0082\u0002\u001a\u0005\b\u0083\u0002\u0010\u0010R\u0017\u0010\u0084\u0002\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0084\u0002\u0010\u0082\u0002R\u0018\u0010\u0085\u0002\u001a\u00030¬\u00018\u0002X\u0082D¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0017\u0010\u0087\u0002\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0082\u0002R\u0017\u0010\u0088\u0002\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0088\u0002\u0010\u0082\u0002R*\u0010\u008a\u0002\u001a\u00030\u0089\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0002\u0010\u008b\u0002\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002\"\u0006\b\u008e\u0002\u0010\u008f\u0002R\u0019\u0010\u0090\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010\u0082\u0002R\u0019\u0010\u0091\u0002\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0002\u0010\u0082\u0002R\u0018\u0010\u0093\u0002\u001a\u00030\u0092\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0018\u0010\u0096\u0002\u001a\u00030\u0095\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R,\u0010\u0098\u0002\u001a\u0005\u0018\u00010¾\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0002\u0010\u0099\u0002\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002\"\u0006\b\u009c\u0002\u0010Á\u0001R1\u0010\u009f\u0002\u001a\n\u0018\u00010\u009d\u0002R\u00030\u009e\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009f\u0002\u0010 \u0002\u001a\u0006\b¡\u0002\u0010¢\u0002\"\u0006\b£\u0002\u0010¤\u0002R\u0018\u0010¥\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¥\u0002\u0010qR*\u0010§\u0002\u001a\u00020\u00122\u0007\u0010¦\u0002\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b§\u0002\u0010¨\u0002\u001a\u0006\b©\u0002\u0010ª\u0002R\u001a\u0010«\u0002\u001a\u00030\u0089\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0002\u0010\u008b\u0002R\u0018\u0010¬\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¬\u0002\u0010qR\u0018\u0010\u00ad\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0002\u0010qR\u001b\u0010®\u0002\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0002\u0010\u0082\u0002R)\u0010±\u0002\u001a\u0014\u0012\u0004\u0012\u00020\b0¯\u0002j\t\u0012\u0004\u0012\u00020\b`°\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0002\u0010²\u0002R\u0018\u0010³\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b³\u0002\u0010qR\u0018\u0010´\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b´\u0002\u0010qR\u0018\u0010µ\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bµ\u0002\u0010qR\u0017\u0010¶\u0002\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\b¶\u0002\u0010\u0082\u0002R\u0018\u0010·\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b·\u0002\u0010qR\u0017\u0010¸\u0002\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\b¸\u0002\u0010\u0082\u0002R\u0017\u0010¹\u0002\u001a\u00020\b8\u0002X\u0082D¢\u0006\b\n\u0006\b¹\u0002\u0010\u0082\u0002R\u0018\u0010º\u0002\u001a\u00030\u0089\u00028\u0002X\u0082D¢\u0006\b\n\u0006\bº\u0002\u0010\u008b\u0002R^\u0010½\u0002\u001aI\u0012\r\u0012\u000b ¼\u0002*\u0004\u0018\u00010\b0\b\u0012\r\u0012\u000b ¼\u0002*\u0004\u0018\u00010\u00170\u0017 ¼\u0002*#\u0012\r\u0012\u000b ¼\u0002*\u0004\u0018\u00010\b0\b\u0012\r\u0012\u000b ¼\u0002*\u0004\u0018\u00010\u00170\u0017\u0018\u00010»\u00020»\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u0018\u0010À\u0002\u001a\u00030¿\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0002\u0010Á\u0002R\u001a\u0010Â\u0002\u001a\u00030\u0089\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0002\u0010\u008b\u0002R\u0018\u0010Ä\u0002\u001a\u00030Ã\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R\u001a\u0010Æ\u0002\u001a\u00030\u0089\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0002\u0010\u008b\u0002R$\u0010È\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170Ç\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÈ\u0002\u0010É\u0002R\u001c\u0010Ë\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0002\u0010Ì\u0002R\u001c\u0010Í\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0002\u0010Ì\u0002R\u001c\u0010Î\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0002\u0010Ì\u0002R\u001c\u0010Ï\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0002\u0010Ì\u0002R\u001c\u0010Ð\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010Ì\u0002R\u001c\u0010Ñ\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0002\u0010Ì\u0002R\u001a\u0010Ò\u0002\u001a\u00030\u0089\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0002\u0010\u008b\u0002R\u0018\u0010Ó\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÓ\u0002\u0010qR\u001c\u0010Ô\u0002\u001a\u0005\u0018\u00010Ê\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0002\u0010Ì\u0002R\u0018\u0010Õ\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÕ\u0002\u0010qR\u0018\u0010Ö\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÖ\u0002\u0010qR\u0018\u0010×\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b×\u0002\u0010qR\u0018\u0010Ø\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bØ\u0002\u0010qR\u0018\u0010Ù\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÙ\u0002\u0010qR\u001b\u0010Ú\u0002\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0002\u0010\u0082\u0002R\u001c\u0010Û\u0002\u001a\u0005\u0018\u00010é\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0002\u0010Ü\u0002R\u0018\u0010Þ\u0002\u001a\u00030Ý\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0002\u0010ß\u0002R\u0018\u0010à\u0002\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bà\u0002\u0010qR\u0018\u0010á\u0002\u001a\u00030Ã\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0002\u0010Å\u0002R\u001f\u0010â\u0002\u001a\b\u0012\u0004\u0012\u00020\b0>8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0002\u0010ã\u0002¨\u0006ä\u0002"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/ChatRound;", "Lcom/stepos/agentframework/chatcore/session/W;", "Lcom/stepos/agentframework/chatcore/session/AgentSession;", "owner", "Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "session", "Lcom/stepos/agentframework/chatcore/session/AgentSession$d;", "sessionCreateCallback", "", "initialTraceId", "Lcom/stepos/agentframework/chatcore/session/h1;", "variantGroup", "regenerateRunId", "<init>", "(Lcom/stepos/agentframework/chatcore/session/AgentSession;Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;Lcom/stepos/agentframework/chatcore/session/AgentSession$d;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/h1;Ljava/lang/String;)V", "s1", "()Ljava/lang/String;", "B0", "Lcom/stepos/agentframework/chatcore/session/TalkPhase;", "phase", "LY8/t;", "s0", "(Lcom/stepos/agentframework/chatcore/session/TalkPhase;)V", "", "roundAlive", "Lcom/stepos/agentframework/chatcore/session/ReconnectReason;", "reason", "t0", "(ZLcom/stepos/agentframework/chatcore/session/ReconnectReason;)V", "o0", "()V", "p0", SdCardDbCreator.FIELD_LASTLOC_INFO, ExifInterface.LATITUDE_SOUTH, "c2", ExifInterface.GPS_DIRECTION_TRUE, "O1", "U", "j2", "()Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "V0", "source", "f1", "(Ljava/lang/String;)Z", "c1", "W0", "R0", "requestId", "messageId", "h1", "(Ljava/lang/String;Ljava/lang/String;)V", "D1", "(Ljava/lang/String;)V", "I1", "V1", ExifInterface.LONGITUDE_WEST, "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "e1", "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "N0", "", "tools", "Q0", "(Ljava/util/List;)V", "X", "next", "z0", "(Lcom/stepos/agentframework/chatcore/session/TalkPhase;)Z", "g1", "l1", "D0", "E0", "W1", "j0", "h0", "j1", "n0", "Lw4/c;", "message", "r0", "(Lw4/c;)V", "q0", "v0", "C0", "E1", "C1", "(Lcom/stepos/agentframework/chatcore/intent/e;)Ljava/lang/String;", "x0", "Lu4/h;", "event", "z1", "(Lu4/h;)V", "d1", "(Lu4/h;)Z", "A1", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "error", "Y0", "(Lcom/stepos/agentframework/chatcore/session/AgentError;)Z", SdCardDbCreator.FIELD_LASTLOC_ID, "U0", "Z0", "h2", "g2", "p1", "o1", "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "Lu4/d;", UxipConstants.f30685x, "K1", "(Lu4/d;)V", "Z", "(Lw4/c;)Ljava/lang/String;", "P1", "terminalStatus", "terminalReason", "committedToUI", "M1", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/AgentError;Ljava/lang/Boolean;)V", "cancelReason", "f2", "(Ljava/lang/String;)Ljava/lang/String;", "X1", "Q1", "sessionId", "d2", "tempSessionId", "e2", "Lu4/a;", "messages", "d0", "(Ljava/util/List;)Ljava/lang/String;", "L1", "H1", "w1", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "list", "R", "(Lcom/stepos/agentframework/chatcore/agents/y;Ljava/util/List;)V", "x1", "M0", "F0", "Y", "existing", "b0", "Z1", "k0", "O0", "k1", "b1", "m1", "Y1", "w0", "P0", "J1", "i1", "n", "e", "Lcom/stepos/agentframework/chatcore/session/InterruptCause;", "cause", "offline", "force", "S0", "(Lcom/stepos/agentframework/chatcore/session/InterruptCause;Ljava/lang/Boolean;Z)V", "onSessionCreated", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "c", "success", "", "code", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/Integer;Ljava/lang/String;)V", "n1", "Lu4/c;", "moderation", Const.INTENT_KEY_UMID, "(Lu4/c;)V", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/List;)V", "name", "resultJson", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lu4/i;", "task", Const.INTENT_KEY_APIKEY, "(Lu4/i;)V", "Lu4/e;", "f", "(Lu4/e;)V", "Lu4/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lu4/f;)V", "Lu4/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lu4/g;)V", "", "k", "i2", "F1", "title", "isTempSession", "agentId", "deviceId", "R1", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "K0", "()Lw4/c;", "G0", "()Ljava/util/List;", "resendMessage", "userMessageId", "imageMessageId", "fileMessageId", "t1", "(Ljava/lang/String;Ljava/util/List;Lw4/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "q1", "b2", "e0", "outboundId", "c0", "A0", "i0", "X0", "(Lw4/c;)Z", "f0", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "U1", "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)V", "u", "targetMessageId", "Lu4/m$f;", "echo", "Q", "(Ljava/lang/String;Lu4/m$f;)Lw4/c;", "l0", "m0", "y1", "Lcom/stepos/agentframework/chatcore/session/AgentSession;", "Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "J0", "()Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "setSession", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;)V", "Lcom/stepos/agentframework/chatcore/session/AgentSession$d;", "getSessionCreateCallback", "()Lcom/stepos/agentframework/chatcore/session/AgentSession$d;", "setSessionCreateCallback", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$d;)V", "Lcom/stepos/agentframework/chatcore/session/h1;", "Ljava/lang/String;", "H0", "TAG", "OPENCLAW_UNAVAILABLE_CODE", "I", "ASK_USER_TOOL_NAME", "RISK_STATEMENT_TOOL_NAME", "", "lastSaveTime", "J", "getLastSaveTime", "()J", "S1", "(J)V", "pairId", DidiCardProvider.KEY_TRACE_ID, "Lcom/stepos/agentframework/chatcore/session/G0;", "responseAssembler", "Lcom/stepos/agentframework/chatcore/session/G0;", "Lcom/stepos/agentframework/chatcore/session/g1;", "userMessageAssembler", "Lcom/stepos/agentframework/chatcore/session/g1;", "planTask", "Lu4/i;", "getPlanTask", "()Lu4/i;", "setPlanTask", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher;", "requestWrapper", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;", "I0", "()Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;", "T1", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;)V", "hasReceivedAgentResponse", UxipConstants.f30680s, "talkPhase", "Lcom/stepos/agentframework/chatcore/session/TalkPhase;", "L0", "()Lcom/stepos/agentframework/chatcore/session/TalkPhase;", "lastTokenTimeMs", "awaitingUserDecision", "inquiryContinuationActive", "awaitingDecisionMessageId", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "externalDecisionRequestIds", "Ljava/util/LinkedHashSet;", "externalDecisionHoldLatched", "reconnectPromptShown", "networkInterrupted", "ERROR_TOKEN_UPSTREAM_OFFLINE_TIMEOUT", "disconnectedDuringRound", "TOOL_NAME_TASK_CREATE", "TASK_RESULT_KEY_TASK_ID", "TASK_PROGRESS_KEEPALIVE_THROTTLE_MS", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "dispatchedTaskIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Ljava/util/concurrent/atomic/AtomicLong;", "roundActivitySeq", "Ljava/util/concurrent/atomic/AtomicLong;", "taskDispatchActivitySeq", "Ljava/util/concurrent/atomic/AtomicBoolean;", "taskSettleListenerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastTaskProgressKeepAliveMs", "Ljava/util/concurrent/ConcurrentHashMap;", "toastedPhases", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/g;", "sendTimeoutJob", "Lkotlinx/coroutines/g;", "offlineSendTimeoutJob", "postAckTimeoutJob", "streamStallJob", "toastJob", "cotCollapseJob", "cotSendAtMs", "cotStarted", "cotTickJob", "sendSucceeded", "phaseMonitorStarted", "sendPhaseHardTimedOut", "postStopRetryScheduled", "postStopRetryDispatched", "lastLoggedResponseMessageId", "lastLoggedResponseStatus", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "Lcom/stepos/agentframework/chatcore/session/K0;", "sessionCreateCallbackGate", "Lcom/stepos/agentframework/chatcore/session/K0;", "downReported", "uplinkReported", "userMessageIds", "Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatRound implements W {
    private final String ASK_USER_TOOL_NAME;
    private final String ERROR_TOKEN_UPSTREAM_OFFLINE_TIMEOUT;
    private final int OPENCLAW_UNAVAILABLE_CODE;
    private final String RISK_STATEMENT_TOOL_NAME;
    private final String TAG;
    private final long TASK_PROGRESS_KEEPALIVE_THROTTLE_MS;
    private final String TASK_RESULT_KEY_TASK_ID;
    private final String TOOL_NAME_TASK_CREATE;
    private String awaitingDecisionMessageId;
    private volatile boolean awaitingUserDecision;
    private kotlinx.coroutines.g cotCollapseJob;
    private long cotSendAtMs;
    private boolean cotStarted;
    private kotlinx.coroutines.g cotTickJob;
    private boolean disconnectedDuringRound;
    private final ConcurrentHashMap.KeySetView<String, Boolean> dispatchedTaskIds;
    private boolean downReported;
    private boolean externalDecisionHoldLatched;
    private final LinkedHashSet<String> externalDecisionRequestIds;
    private boolean hasReceivedAgentResponse;
    private volatile boolean inquiryContinuationActive;
    private String lastLoggedResponseMessageId;
    private EReplyStatus lastLoggedResponseStatus;
    private long lastSaveTime;
    private volatile long lastTaskProgressKeepAliveMs;
    private long lastTokenTimeMs;
    private boolean networkInterrupted;
    private kotlinx.coroutines.g offlineSendTimeoutJob;
    private final AgentSession owner;
    private String pairId;
    private volatile boolean phaseMonitorStarted;
    private AgentTaskPlan planTask;
    private kotlinx.coroutines.g postAckTimeoutJob;
    private volatile boolean postStopRetryDispatched;
    private volatile boolean postStopRetryScheduled;
    private boolean reconnectPromptShown;
    private final String regenerateRunId;
    private AgentDispatcher.RequestWrapper requestWrapper;
    private final G0 responseAssembler;
    private final AtomicLong roundActivitySeq;
    private volatile boolean sendPhaseHardTimedOut;
    private boolean sendSucceeded;
    private kotlinx.coroutines.g sendTimeoutJob;
    private AgentSession.AgentConversation session;
    private AgentSession.d sessionCreateCallback;
    private final K0 sessionCreateCallbackGate;
    private kotlinx.coroutines.g streamStallJob;
    private volatile TalkPhase talkPhase;
    private volatile long taskDispatchActivitySeq;
    private final AtomicBoolean taskSettleListenerRegistered;
    private kotlinx.coroutines.g toastJob;
    private final ConcurrentHashMap<TalkPhase, Boolean> toastedPhases;
    private String traceId;
    private final AtomicBoolean uplinkReported;
    private final g1 userMessageAssembler;
    private List<String> userMessageIds;
    private final VariantGroupTag variantGroup;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[TalkPhase.values().length];
            try {
                iArr[TalkPhase.THINKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TalkPhase.COT_THINKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TalkPhase.REPLYING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TalkPhase.SENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TalkPhase.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ReconnectReason.values().length];
            try {
                iArr2[ReconnectReason.AGENT_OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ReconnectReason.AI_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ReconnectReason.NETWORK_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AgentMessageType.values().length];
            try {
                iArr3[AgentMessageType.THINKING_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[AgentMessageType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[AgentMessageType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[AgentMessageType.IMAGE_URL.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[AgentMessageType.VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[AgentMessageType.FILE.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[AgentMessageType.FOLDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[EReplyStatus.values().length];
            try {
                iArr4[EReplyStatus.REPLYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr4[EReplyStatus.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    public ChatRound(AgentSession owner, AgentSession.AgentConversation session, AgentSession.d dVar, String initialTraceId, VariantGroupTag variantGroupTag, String str) {
        kotlin.jvm.internal.p.i(owner, "owner");
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(initialTraceId, "initialTraceId");
        this.owner = owner;
        this.session = session;
        this.variantGroup = variantGroupTag;
        this.regenerateRunId = str;
        this.TAG = "ChatRound";
        this.OPENCLAW_UNAVAILABLE_CODE = 5;
        this.ASK_USER_TOOL_NAME = LauncherChatLayout.ASK_USER_TOOL_NAME;
        this.RISK_STATEMENT_TOOL_NAME = VoiceAbilityService.TOOL_SHOW_RISK_STATEMENT;
        this.lastSaveTime = -1L;
        this.pairId = s1();
        this.traceId = initialTraceId.length() == 0 ? f1.INSTANCE.a() : initialTraceId;
        this.responseAssembler = new G0();
        this.userMessageAssembler = new g1();
        this.talkPhase = TalkPhase.SENDING;
        this.externalDecisionRequestIds = new LinkedHashSet<>();
        this.ERROR_TOKEN_UPSTREAM_OFFLINE_TIMEOUT = "upstream_offline_timeout";
        this.TOOL_NAME_TASK_CREATE = "task_create";
        this.TASK_RESULT_KEY_TASK_ID = "taskId";
        this.TASK_PROGRESS_KEEPALIVE_THROTTLE_MS = 5000L;
        this.dispatchedTaskIds = ConcurrentHashMap.newKeySet();
        this.roundActivitySeq = new AtomicLong(0L);
        this.taskDispatchActivitySeq = -1L;
        this.taskSettleListenerRegistered = new AtomicBoolean(false);
        this.toastedPhases = new ConcurrentHashMap<>();
        this.sessionCreateCallbackGate = new K0();
        this.uplinkReported = new AtomicBoolean(false);
        this.userMessageIds = C1173v.m();
    }

    public static final CharSequence B1(AgentTool it) {
        kotlin.jvm.internal.p.i(it, "it");
        return com.stepos.agentframework.chatcore.intent.f.d(it);
    }

    public static final Y8.t G1(ChatRound chatRound, ChatMessage message, String oldMessageId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        AgentSession agentSession = chatRound.owner;
        String sessionId = message.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = null;
        }
        agentSession.B0(new L0.MessageReplace(sessionId, oldMessageId, message, 0L, false, 24, null));
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void N1(ChatRound chatRound, String str, String str2, AgentError agentError, Boolean bool, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            agentError = null;
        }
        if ((i10 & 8) != 0) {
            bool = null;
        }
        chatRound.M1(str, str2, agentError, bool);
    }

    public static /* synthetic */ void T0(ChatRound chatRound, InterruptCause interruptCause, Boolean bool, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bool = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        chatRound.S0(interruptCause, bool, z10);
    }

    public static final CharSequence a0(AgentMessage part) {
        kotlin.jvm.internal.p.i(part, "part");
        return part.getContent().h();
    }

    public static /* synthetic */ void g0(ChatRound chatRound, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "user.abort";
        }
        chatRound.f0(str);
    }

    public static /* synthetic */ void r1(ChatRound chatRound, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        chatRound.q1(str);
    }

    public static /* synthetic */ void u0(ChatRound chatRound, boolean z10, ReconnectReason reconnectReason, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            reconnectReason = ReconnectReason.NETWORK_FAILED;
        }
        chatRound.t0(z10, reconnectReason);
    }

    public static final Y8.t u1(ChatRound chatRound, ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        chatRound.r0(message);
        return Y8.t.f7040a;
    }

    public static final Y8.t v1(ChatRound chatRound, ChatMessage message, String oldMessageId) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        AgentSession agentSession = chatRound.owner;
        String sessionId = message.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = null;
        }
        agentSession.B0(new L0.MessageReplace(sessionId, oldMessageId, message, 0L, false, 24, null));
        return Y8.t.f7040a;
    }

    public static final void y0(ChatRound chatRound, String str, AgentTaskEvent event) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        kotlin.jvm.internal.p.i(event, "event");
        if (chatRound.dispatchedTaskIds.contains(event.y())) {
            if (chatRound.d1(event)) {
                chatRound.A1(event);
            } else {
                chatRound.z1(event);
            }
        }
    }

    public final void A0(AgentError error) {
        kotlin.jvm.internal.p.i(error, "error");
        C5442c.INSTANCE.k(getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("code", Integer.valueOf(error.getCode())), Y8.j.a("message", error.getMessage())), ExifInterface.LONGITUDE_EAST, "ChatRound.errorMessage");
        AgentError agentErrorB = AgentError.b(error, 0, this.owner.getConfig().b(error.getMessage()), null, 5, null);
        G0 g02 = this.responseAssembler;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = this.session.getTempSessionId();
        }
        ChatMessage chatMessageW = g02.w(sessionId, this.owner.getAgentInfo().getAgentId(), this.pairId, agentErrorB);
        if (chatMessageW != null) {
            r0(chatMessageW);
            C1939k0.k(C1173v.h(chatMessageW));
        }
    }

    public final void A1(AgentTaskEvent event) {
        Function2.b(new ChatRound$onDispatchedTaskSettled$1(this, event, null));
    }

    public final String B0() {
        String sessionId = this.session.getSessionId();
        if (sessionId.length() != 0) {
            return sessionId;
        }
        String tempSessionId = this.session.getTempSessionId();
        if (tempSessionId.length() == 0) {
            return null;
        }
        return tempSessionId;
    }

    public final void C0() {
        List<AgentTool> listG;
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null) {
            return;
        }
        boolean z10 = false;
        for (AgentMessage c5574a : assistantMessage.i()) {
            if (c5574a.getType() == AgentMessageType.TOOL && (listG = c5574a.g()) != null) {
                for (AgentTool agentTool : listG) {
                    if (!agentTool.getIsFinished()) {
                        z10 = true;
                        agentTool.A(true);
                    }
                }
            }
        }
        if (z10) {
            C4148a.k(this.TAG, "finalizeToolsOnComplete: force-finished tools messageId=" + assistantMessage.getMessageId() + " pairId=" + this.pairId, false, 4, null);
            C1939k0.k(C1173v.h(assistantMessage));
            v0(assistantMessage);
        }
    }

    public final String C1(AgentTool tool) {
        Object objB;
        String result = tool.getResult();
        if (result.length() == 0) {
            return "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(result).optString(this.TASK_RESULT_KEY_TASK_ID));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(this.TAG, "parse task_create result failed: " + thE.getMessage(), false, 4, null);
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        String string = str != null ? La.H.D1(str).toString() : null;
        return string == null ? "" : string;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0() {
        /*
            r14 = this;
            r0 = 0
            r14.inquiryContinuationActive = r0
            com.stepos.agentframework.chatcore.session.TalkPhase r1 = com.stepos.agentframework.chatcore.session.TalkPhase.FINISHED
            r14.talkPhase = r1
            r14.h0()
            kotlinx.coroutines.g r1 = r14.cotTickJob
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L13
            kotlinx.coroutines.g.Y0(r1, r3, r2, r3)
        L13:
            r14.cotTickJob = r3
            boolean r1 = r14.cotStarted
            if (r1 == 0) goto Lc9
            r14.E0()
            com.stepos.agentframework.chatcore.session.G0 r1 = r14.responseAssembler
            w4.c r1 = r1.getAssistantMessage()
            if (r1 == 0) goto L30
            java.lang.Long r3 = r1.getProcessingDurationMs()
            if (r3 == 0) goto L30
            long r3 = r3.longValue()
        L2e:
            r7 = r3
            goto L38
        L30:
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r14.cotSendAtMs
            long r3 = r3 - r5
            goto L2e
        L38:
            if (r1 == 0) goto Lb5
            java.util.List r1 = r1.i()
            if (r1 == 0) goto Lb5
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L4b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L6a
            java.lang.Object r4 = r1.next()
            r5 = r4
            u4.a r5 = (u4.AgentMessage) r5
            com.stepos.agentframework.chatcore.session.AgentMessageType r6 = r5.getType()
            com.stepos.agentframework.chatcore.session.AgentMessageType r9 = com.stepos.agentframework.chatcore.session.AgentMessageType.TOOL
            if (r6 != r9) goto L4b
            boolean r5 = r5.getHiddenToolExecuteView()
            if (r5 != 0) goto L4b
            r3.add(r4)
            goto L4b
        L6a:
            java.util.Iterator r1 = r3.iterator()
            r3 = r0
        L6f:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto Lb3
            java.lang.Object r4 = r1.next()
            u4.a r4 = (u4.AgentMessage) r4
            java.util.List r4 = r4.g()
            if (r4 == 0) goto Lb0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L91
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L91
            goto Lb0
        L91:
            java.util.Iterator r4 = r4.iterator()
            r5 = r0
        L96:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto Lb1
            java.lang.Object r6 = r4.next()
            com.stepos.agentframework.chatcore.intent.e r6 = (com.stepos.agentframework.chatcore.intent.AgentTool) r6
            boolean r6 = r6.getHidden()
            if (r6 != 0) goto L96
            int r5 = r5 + 1
            if (r5 >= 0) goto L96
            Z8.C1173v.v()
            goto L96
        Lb0:
            r5 = r0
        Lb1:
            int r3 = r3 + r5
            goto L6f
        Lb3:
            r9 = r3
            goto Lb6
        Lb5:
            r9 = r0
        Lb6:
            com.stepos.agentframework.chatcore.session.AgentSession r1 = r14.owner
            com.stepos.agentframework.chatcore.session.L0$f r5 = new com.stepos.agentframework.chatcore.session.L0$f
            java.lang.String r6 = r14.B0()
            r12 = 8
            r13 = 0
            r10 = 0
            r5.<init>(r6, r7, r9, r10, r12, r13)
            r1.B0(r5)
        Lc9:
            java.util.concurrent.atomic.AtomicBoolean r1 = r14.taskSettleListenerRegistered
            boolean r0 = r1.compareAndSet(r2, r0)
            if (r0 == 0) goto Ld4
            com.stepos.agentframework.chatcore.session.P0.c(r14)
        Ld4:
            com.stepos.agentframework.chatcore.agents.AgentDispatcher$RequestWrapper r14 = r14.requestWrapper
            if (r14 == 0) goto Ldb
            r14.d()
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.ChatRound.D0():void");
    }

    public final void D1(String source) {
        U u10 = U.INSTANCE;
        Set<String> setB = u10.b(this.externalDecisionRequestIds, this.owner.T());
        Set<String> set = setB;
        if (!set.isEmpty()) {
            this.externalDecisionRequestIds.removeAll(set);
            C4148a.k(this.TAG, source + " prune stale external decision ids=" + setB + " remaining=" + this.externalDecisionRequestIds.size(), false, 4, null);
        }
        if (u10.a(this.externalDecisionHoldLatched, this.externalDecisionRequestIds, N0())) {
            this.externalDecisionHoldLatched = false;
            I1(null, source + ":stale");
        }
    }

    public final void E0() {
        ChatMessage assistantMessage;
        if (this.cotStarted && (assistantMessage = this.responseAssembler.getAssistantMessage()) != null && assistantMessage.getProcessingDurationMs() == null) {
            assistantMessage.O(Long.valueOf(System.currentTimeMillis() - this.cotSendAtMs));
        }
    }

    public final void E1(List<AgentTool> tools) {
        if (this.talkPhase == TalkPhase.FINISHED) {
            return;
        }
        for (AgentTool agentTool : tools) {
            if (kotlin.jvm.internal.p.d(agentTool.getName(), this.TOOL_NAME_TASK_CREATE)) {
                String strC1 = C1(agentTool);
                if (strC1.length() != 0) {
                    boolean zAdd = this.dispatchedTaskIds.add(strC1);
                    this.taskDispatchActivitySeq = this.roundActivitySeq.get();
                    x0();
                    if (zAdd) {
                        C4148a.k(this.TAG, "background task dispatched taskId=" + strC1 + " pairId=" + this.pairId + " phase=" + this.talkPhase + " activitySeq=" + this.taskDispatchActivitySeq, false, 4, null);
                    }
                }
            }
        }
    }

    /* renamed from: F0, reason: from getter */
    public final String getPairId() {
        return this.pairId;
    }

    public final void F1(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        List<ChatMessage> listE = this.userMessageAssembler.e(sessionId, new p9.p() { // from class: com.stepos.agentframework.chatcore.session.I
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatRound.G1(this.f22466a, (ChatMessage) obj, (String) obj2);
            }
        });
        C1939k0.k(listE);
        C4148a.k(this.TAG, "refreshUserMessages reanchor sessionId:" + sessionId + " count:" + listE.size(), false, 4, null);
    }

    public final List<ChatMessage> G0() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.userMessageAssembler.f());
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage != null) {
            arrayList.add(assistantMessage);
        }
        return arrayList;
    }

    /* renamed from: H0, reason: from getter */
    public final String getRegenerateRunId() {
        return this.regenerateRunId;
    }

    public final void H1() {
        D0();
        this.awaitingUserDecision = false;
        this.awaitingDecisionMessageId = null;
        this.externalDecisionRequestIds.clear();
        this.externalDecisionHoldLatched = false;
        this.inquiryContinuationActive = false;
        this.requestWrapper = null;
        this.lastLoggedResponseMessageId = null;
        this.lastLoggedResponseStatus = null;
        this.lastSaveTime = -1L;
        this.responseAssembler.f();
        this.userMessageAssembler.a();
        this.planTask = null;
    }

    /* renamed from: I0, reason: from getter */
    public final AgentDispatcher.RequestWrapper getRequestWrapper() {
        return this.requestWrapper;
    }

    public final void I1(String messageId, String source) {
        if (this.awaitingUserDecision) {
            if (!this.externalDecisionRequestIds.isEmpty()) {
                C4148a.k(this.TAG, source + " deferred: " + this.externalDecisionRequestIds.size() + " external risk card(s) still pending", false, 4, null);
                return;
            }
            String str = this.awaitingDecisionMessageId;
            if (messageId != null && messageId.length() != 0 && str != null && str.length() != 0 && !kotlin.jvm.internal.p.d(messageId, str)) {
                C4148a.k(this.TAG, source + " ignored: messageId=" + messageId + " not the pending approval (" + str + ")", false, 4, null);
                return;
            }
            this.awaitingUserDecision = false;
            this.awaitingDecisionMessageId = null;
            this.externalDecisionHoldLatched = false;
            C4148a.k(this.TAG, "user decision handled via " + source + ", restart phase timers phase=" + this.talkPhase, false, 4, null);
            C5442c c5442c = C5442c.INSTANCE;
            String traceId = getTraceId();
            Pair pairA = Y8.j.a("phase", this.talkPhase.name());
            Pair pairA2 = Y8.j.a("source", source);
            if (messageId == null) {
                messageId = "";
            }
            C5442c.l(c5442c, traceId, "event", kotlin.collections.a.m(pairA, pairA2, Y8.j.a("messageId", messageId)), null, "ChatRound.releaseAwaitingUserDecision", 8, null);
            if (this.talkPhase == TalkPhase.FINISHED) {
                return;
            }
            this.lastTokenTimeMs = System.currentTimeMillis();
            h0();
            int i10 = a.$EnumSwitchMapping$0[this.talkPhase.ordinal()];
            if (i10 == 1) {
                c2();
                return;
            }
            if (i10 == 2 || i10 == 3) {
                O1();
            } else if (i10 == 4) {
                a2();
            } else if (i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* renamed from: J0, reason: from getter */
    public final AgentSession.AgentConversation getSession() {
        return this.session;
    }

    public final void J1(String requestId, String source) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(source, "source");
        if (!La.H.x0(requestId)) {
            this.externalDecisionRequestIds.remove(requestId);
        }
        D1(source);
        if (this.externalDecisionRequestIds.isEmpty()) {
            if (!N0()) {
                I1(null, source);
                return;
            }
            C4148a.k(this.TAG, source + " keep hold: pending user-decision tool still on assistant message", false, 4, null);
            return;
        }
        C4148a.k(this.TAG, source + " keep hold: " + this.externalDecisionRequestIds.size() + " external risk card(s) still pending", false, 4, null);
    }

    public final ChatMessage K0() {
        return this.responseAssembler.getAssistantMessage();
    }

    public final void K1(AgentResponse response) {
        String messageId = response.getMessageId();
        if (messageId.length() <= 0) {
            messageId = null;
        }
        if (messageId == null) {
            return;
        }
        DownlinkRunTelemetry.INSTANCE.b(messageId, C5685n.f(Z(this.responseAssembler.getAssistantMessage()).length(), response.getContent().length()), response.getStatus() == EReplyStatus.COMPLETED, getTraceId());
    }

    /* renamed from: L0, reason: from getter */
    public final TalkPhase getTalkPhase() {
        return this.talkPhase;
    }

    public final void L1(AgentError error) {
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage != null && !X0(assistantMessage)) {
            A0(error);
        } else if (assistantMessage != null) {
            C1939k0.d(assistantMessage.getMessageId());
            q0(assistantMessage);
            this.responseAssembler.f();
        }
    }

    /* renamed from: M0, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M1(java.lang.String r18, java.lang.String r19, com.stepos.agentframework.chatcore.session.AgentError r20, java.lang.Boolean r21) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.ChatRound.M1(java.lang.String, java.lang.String, com.stepos.agentframework.chatcore.session.AgentError, java.lang.Boolean):void");
    }

    public final boolean N0() {
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null) {
            return false;
        }
        List<AgentMessage> listI = assistantMessage.i();
        if ((listI instanceof Collection) && listI.isEmpty()) {
            return false;
        }
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            List<AgentTool> listG = ((AgentMessage) it.next()).g();
            if (listG == null) {
                listG = C1173v.m();
            }
            List<AgentTool> list = listG;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (AgentTool agentTool : list) {
                    if (e1(agentTool) && !agentTool.getIsFinished()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean O0() {
        return this.postStopRetryScheduled && !this.postStopRetryDispatched;
    }

    public final void O1() {
        TalkPhase talkPhase = this.talkPhase;
        if (c1() && !R0("resetStreamStallTimer")) {
            this.lastTokenTimeMs = System.currentTimeMillis();
            j0();
            o0();
            this.toastJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$resetStreamStallTimer$1(this, talkPhase, null), 3, null);
            if (talkPhase == TalkPhase.COT_THINKING) {
                this.cotCollapseJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$resetStreamStallTimer$2(this, null), 3, null);
            }
            V(talkPhase);
        }
    }

    public final void P0(String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        if (La.H.x0(requestId)) {
            return;
        }
        this.externalDecisionRequestIds.add(requestId);
        this.externalDecisionHoldLatched = true;
        h1(requestId, "");
    }

    public final String P1(ChatMessage message) {
        String strE;
        String messageId = message != null ? message.getMessageId() : null;
        if (messageId == null) {
            messageId = "";
        }
        if (La.D.X(messageId, "ik-", false, 2, null)) {
            return messageId;
        }
        Pair<String, DownlinkRunTelemetry.Snapshot> pairA = DownlinkRunTelemetry.INSTANCE.a(getTraceId());
        if (pairA != null && (strE = pairA.e()) != null) {
            return strE;
        }
        if (messageId.length() > 0) {
            La.D.X(messageId, "assistant-wait", false, 2, null);
        }
        return messageId;
    }

    public final ChatMessage Q(String targetMessageId, m.InquiryMessage echo) {
        kotlin.jvm.internal.p.i(targetMessageId, "targetMessageId");
        kotlin.jvm.internal.p.i(echo, "echo");
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null || !kotlin.jvm.internal.p.d(assistantMessage.getMessageId(), targetMessageId)) {
            return null;
        }
        if (K.c(assistantMessage, echo.getInquiryId())) {
            return assistantMessage;
        }
        assistantMessage.i().add(K.f(echo));
        this.responseAssembler.C(assistantMessage);
        return assistantMessage;
    }

    public final void Q0(List<AgentTool> tools) {
        Object next;
        Iterator<T> it = tools.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AgentTool agentTool = (AgentTool) next;
            if (e1(agentTool) && !agentTool.getIsFinished()) {
                break;
            }
        }
        AgentTool agentTool2 = (AgentTool) next;
        if (agentTool2 == null) {
            return;
        }
        String toolCallId = agentTool2.getToolCallId();
        if (La.H.x0(toolCallId)) {
            toolCallId = agentTool2.getName();
            if (La.H.x0(toolCallId)) {
                toolCallId = this.RISK_STATEMENT_TOOL_NAME;
            }
        }
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        String messageId = assistantMessage != null ? assistantMessage.getMessageId() : null;
        if (messageId == null) {
            messageId = "";
        }
        h1(toolCallId, messageId);
    }

    public final void Q1(String messageId, String reason) {
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        String messageId2 = assistantMessage != null ? assistantMessage.getMessageId() : null;
        C4148a.k(this.TAG, reason + " prev=" + messageId2 + " prevPair=" + this.pairId, false, 4, null);
        this.pairId = s1();
        q1(messageId);
    }

    public final void R(RequestParameter parameter, List<AgentTool> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            V.INSTANCE.b((AgentTool) it.next(), parameter.getGuiAgentModelName());
        }
    }

    public final boolean R0(String source) {
        D1(source);
        if (!W0()) {
            return false;
        }
        C4148a.k(this.TAG, source + " skipped: awaiting user decision, phase timers stay on hold", false, 4, null);
        return true;
    }

    public final void R1(String title, String sessionId, boolean isTempSession, String agentId, String deviceId) {
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        Function2.a(new ChatRound$saveConversationTitle$1(this, sessionId, title, agentId, deviceId, isTempSession, null));
    }

    public final void S() {
        if (this.owner.getConfig().getOfflineSendTimeoutMs() > 0 && this.talkPhase == TalkPhase.SENDING) {
            kotlinx.coroutines.g gVar = this.offlineSendTimeoutJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.offlineSendTimeoutJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$armOfflineSendWatch$1(this, null), 3, null);
        }
    }

    public final void S0(InterruptCause cause, Boolean offline, boolean force) {
        ChatHintType chatHintType;
        String strB0;
        boolean z10;
        kotlin.jvm.internal.p.i(cause, "cause");
        if (this.talkPhase == TalkPhase.FINISHED) {
            return;
        }
        if (W0() && !force) {
            C4148a.u(this.TAG, "interruptForNetwork skipped: awaiting user decision on approval card, phase=" + this.talkPhase, false, 4, null);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.lastTokenTimeMs;
        boolean z11 = cause.getWatchdogTimeout() && kotlin.jvm.internal.p.d(offline, Boolean.FALSE);
        boolean z12 = com.stepos.agentframework.adapter.agentbus.bff.j.b(this.owner.getAgentInfo().getAgentId()) && ((cause == InterruptCause.SEND_TIMEOUT && kotlin.jvm.internal.p.d(offline, Boolean.FALSE)) || cause == InterruptCause.TRANSPORT_ERROR);
        ReconnectReason reconnectReason = z12 ? ReconnectReason.AGENT_OFFLINE : z11 ? ReconnectReason.AI_TIMEOUT : ReconnectReason.NETWORK_FAILED;
        int i10 = a.$EnumSwitchMapping$1[reconnectReason.ordinal()];
        if (i10 == 1) {
            chatHintType = ChatHintType.AGENT_OFFLINE;
        } else if (i10 == 2) {
            chatHintType = ChatHintType.TIMEOUT;
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            chatHintType = ChatHintType.NONE;
        }
        String strN0 = n0();
        boolean z13 = V1() || W0();
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        boolean zD = assistantMessage != null ? B.INSTANCE.d(assistantMessage) : true;
        boolean zF = assistantMessage != null ? B.INSTANCE.f(assistantMessage) : false;
        boolean z14 = z12;
        boolean zG = B.INSTANCE.g(cause == InterruptCause.STREAM_STALL || cause == InterruptCause.POST_ACK_TIMEOUT, z13, (assistantMessage == null || X0(assistantMessage)) ? false : true, zF);
        String str = this.TAG;
        TalkPhase talkPhase = this.talkPhase;
        StringBuilder sb2 = new StringBuilder();
        ChatHintType chatHintType2 = chatHintType;
        sb2.append("interruptForNetwork cause=");
        sb2.append(cause);
        sb2.append(" phase=");
        sb2.append(talkPhase);
        sb2.append(" stalledMs=");
        sb2.append(jCurrentTimeMillis);
        sb2.append(" offline=");
        sb2.append(offline);
        sb2.append(" cloudSilent=");
        sb2.append(z11);
        sb2.append(" closeCloudSilent=");
        sb2.append(zG);
        sb2.append(" lastTool=");
        sb2.append(strN0);
        boolean z15 = z11;
        C4148a.u(str, sb2.toString(), false, 4, null);
        C5442c.INSTANCE.k(getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("cause", cause.name()), Y8.j.a("phase", this.talkPhase.name()), Y8.j.a("stalledMs", Long.valueOf(jCurrentTimeMillis)), Y8.j.a("offline", offline), Y8.j.a("cloudSilent", Boolean.valueOf(z15)), Y8.j.a("closeCloudSilent", Boolean.valueOf(zG)), Y8.j.a("toolsSettled", Boolean.valueOf(zF)), Y8.j.a("lastTool", strN0)), ExifInterface.LONGITUDE_WEST, "ChatRound.interruptForNetwork");
        if (z15 && !z14 && !zG) {
            C4148a.u(this.TAG, "interruptForNetwork cloudSilent: prompt only, keep stream cause=" + cause + " phase=" + this.talkPhase, false, 4, null);
            if (this.talkPhase == TalkPhase.SENDING) {
                z10 = true;
                this.sendSucceeded = true;
            } else {
                z10 = true;
            }
            h0();
            t0(z10, reconnectReason);
            return;
        }
        if (z15 && zG) {
            C4148a.u(this.TAG, "interruptForNetwork cloudSilent: self-running stall timeout, close round cause=" + cause + " phase=" + this.talkPhase + " toolsFinished=" + zD + " toolsSettled=" + zF, false, 4, null);
            if (zF && (strB0 = B0()) != null) {
                N0.INSTANCE.a(strB0);
            }
        }
        AgentDispatcher.RequestWrapper requestWrapper = this.requestWrapper;
        if (requestWrapper != null) {
            requestWrapper.b(cause.getAbortReason());
        }
        this.networkInterrupted = true;
        G0 g02 = this.responseAssembler;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = this.session.getTempSessionId();
        }
        ChatMessage chatMessageX = g02.x(sessionId, this.owner.getAgentInfo().getAgentId(), this.pairId, chatHintType2);
        if (chatMessageX != null) {
            if (X0(chatMessageX)) {
                C1939k0.k(C1173v.h(chatMessageX));
                q0(chatMessageX);
            } else {
                E0();
                r0(chatMessageX);
                C1939k0.k(C1173v.h(chatMessageX));
            }
        }
        D0();
        boolean z16 = false;
        u0(this, false, reconnectReason, 1, null);
        this.session.u(this);
        String str2 = cause.getWatchdogTimeout() ? "auto_cancel" : "error";
        if (this.responseAssembler.getAssistantMessage() != null && (!X0(r1))) {
            z16 = true;
        }
        N1(this, "CANCELED", str2, null, Boolean.valueOf(z16), 4, null);
    }

    public final void S1(long j10) {
        this.lastSaveTime = j10;
    }

    public final void T() {
        this.postAckTimeoutJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$armPostAckTimeoutJob$1(this, null), 3, null);
    }

    public final void T1(AgentDispatcher.RequestWrapper requestWrapper) {
        this.requestWrapper = requestWrapper;
    }

    public final void U(TalkPhase phase) {
        j0();
        long reconnectSettledStallTimeoutMs = this.owner.getConfig().getReconnectSettledStallTimeoutMs();
        C4148a.u(this.TAG, "reconnect with settled tools at " + phase + ", close if still silent after " + reconnectSettledStallTimeoutMs + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
        this.streamStallJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$armReconnectSettledStall$1(reconnectSettledStallTimeoutMs, this, phase, null), 3, null);
    }

    public final boolean U0(AgentError error) {
        return error.getCode() == 10106 || error.getCode() == 10107 || error.getCode() == 10108;
    }

    public final void U1(EReplyStatus status) {
        kotlin.jvm.internal.p.i(status, "status");
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage != null && !assistantMessage.getStatus().isTerminal()) {
            assistantMessage.U(status);
            this.responseAssembler.C(assistantMessage);
            SessionActivityTracker.INSTANCE.l(assistantMessage);
        }
        H1();
    }

    public final void V(TalkPhase phase) {
        this.streamStallJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$armStreamStallJob$1(this, phase, null), 3, null);
    }

    public final boolean V0() {
        return com.stepos.agentframework.adapter.agentbus.bff.j.b(this.session.getAgentId());
    }

    public final boolean V1() {
        D1("completed");
        if (W0()) {
            return true;
        }
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        return assistantMessage != null && K.d(assistantMessage);
    }

    public final boolean W() {
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null) {
            return false;
        }
        List<AgentMessage> listI = assistantMessage.i();
        if ((listI instanceof Collection) && listI.isEmpty()) {
            return false;
        }
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            List<AgentTool> listG = ((AgentMessage) it.next()).g();
            if (listG == null) {
                listG = C1173v.m();
            }
            List<AgentTool> list = listG;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (e1((AgentTool) it2.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean W0() {
        return this.awaitingUserDecision || !this.externalDecisionRequestIds.isEmpty();
    }

    public final void W1() {
        if (this.cotStarted) {
            return;
        }
        this.cotStarted = true;
        this.owner.B0(new L0.CotTimingStart(B0(), this.cotSendAtMs, 0L, 4, null));
        kotlinx.coroutines.g gVar = this.cotTickJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.cotTickJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$startCotTimingIfNeeded$1(this, null), 3, null);
    }

    public final boolean X() {
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null) {
            return false;
        }
        List<AgentMessage> listI = assistantMessage.i();
        if (!(listI instanceof Collection) || !listI.isEmpty()) {
            Iterator<T> it = listI.iterator();
            while (it.hasNext()) {
                if (((AgentMessage) it.next()).getType() == AgentMessageType.INQUIRY) {
                    return true;
                }
            }
        }
        return W();
    }

    public final boolean X0(ChatMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        return K.e(message);
    }

    public final void X1(AgentResponse response) {
        if (this.responseAssembler.D(response)) {
            Q1(null, "startNewSegment new=" + response.getMessageId());
        }
    }

    public final String Y() {
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage != null) {
            return assistantMessage.getMessageId();
        }
        return null;
    }

    public final boolean Y0(AgentError error) {
        if (error.getCode() == 10092 || error.getCode() == 10093 || error.getCode() == -100 || La.H.e0(error.getMessage(), this.ERROR_TOKEN_UPSTREAM_OFFLINE_TIMEOUT, true)) {
            return true;
        }
        return a1();
    }

    public final void Y1() {
        this.hasReceivedAgentResponse = false;
        this.sendSucceeded = false;
        this.reconnectPromptShown = false;
        this.networkInterrupted = false;
        this.disconnectedDuringRound = false;
        this.sendPhaseHardTimedOut = false;
        this.awaitingUserDecision = false;
        this.awaitingDecisionMessageId = null;
        this.externalDecisionRequestIds.clear();
        this.externalDecisionHoldLatched = false;
        this.inquiryContinuationActive = false;
        this.lastTokenTimeMs = System.currentTimeMillis();
        this.cotSendAtMs = System.currentTimeMillis();
        this.cotStarted = false;
        this.toastedPhases.clear();
        h0();
        this.talkPhase = TalkPhase.SENDING;
        this.phaseMonitorStarted = true;
        a2();
    }

    public final String Z(ChatMessage message) {
        if (message == null) {
            return "";
        }
        List<AgentMessage> listI = message.i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listI) {
            if (((AgentMessage) obj).getType() == AgentMessageType.TEXT) {
                arrayList.add(obj);
            }
        }
        return Z8.F.A0(arrayList, "", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.E
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return ChatRound.a0((AgentMessage) obj2);
            }
        }, 30, null);
    }

    public final boolean Z0() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(com.stepos.agentframework.chatcore.utils.n.INSTANCE.b(ChatCoreSdk.INSTANCE.c())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.TRUE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void Z1(ChatMessage existing) {
        List<AgentTool> listG;
        boolean z10;
        kotlin.jvm.internal.p.i(existing, "existing");
        this.hasReceivedAgentResponse = true;
        this.sendSucceeded = true;
        boolean z11 = false;
        this.reconnectPromptShown = false;
        this.networkInterrupted = false;
        this.disconnectedDuringRound = false;
        this.sendPhaseHardTimedOut = false;
        this.inquiryContinuationActive = false;
        this.lastTokenTimeMs = System.currentTimeMillis();
        this.toastedPhases.clear();
        h0();
        List<AgentMessage> listI = existing.i();
        if ((listI instanceof Collection) && listI.isEmpty()) {
            z10 = false;
        } else {
            for (AgentMessage c5574a : listI) {
                if (c5574a.getType() == AgentMessageType.TOOL && (listG = c5574a.g()) != null && !listG.isEmpty()) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        List<AgentMessage> listI2 = existing.i();
        if (!(listI2 instanceof Collection) || !listI2.isEmpty()) {
            Iterator<T> it = listI2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AgentMessage c5574a2 = (AgentMessage) it.next();
                if (c5574a2.getType() == AgentMessageType.TEXT && c5574a2.getContent().h().length() > 0) {
                    z11 = true;
                    break;
                }
            }
        }
        this.talkPhase = z10 ? TalkPhase.COT_THINKING : z11 ? TalkPhase.REPLYING : TalkPhase.THINKING;
        this.phaseMonitorStarted = true;
        int i10 = a.$EnumSwitchMapping$0[this.talkPhase.ordinal()];
        if (i10 == 1) {
            c2();
        } else if (i10 == 2 || i10 == 3) {
            O1();
        }
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void a(AgentTaskPlan task) {
        kotlin.jvm.internal.p.i(task, "task");
        g1();
        task.c(this.session.getTempSessionId());
        this.planTask = task;
        AgentSession agentSession = this.owner;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            String tempSessionId = this.session.getTempSessionId();
            if (tempSessionId.length() == 0) {
                tempSessionId = null;
            }
            sessionId = tempSessionId;
        }
        agentSession.B0(new L0.TaskPlanEvent(sessionId, task, 0L, 4, null));
    }

    public final boolean a1() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(!com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(ChatCoreSdk.INSTANCE.c())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void a2() {
        if (R0("startSendPhaseTimers")) {
            return;
        }
        this.toastJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$startSendPhaseTimers$1(this, null), 3, null);
        this.sendTimeoutJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$startSendPhaseTimers$2(this, null), 3, null);
        S();
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void b(boolean success, Integer code, String message) {
        if (this.networkInterrupted) {
            C4148a.u(this.TAG, "onSendAck ignored: round already converged to network-interrupt, success=" + success, false, 4, null);
            return;
        }
        if (!success && (this.sendSucceeded || this.reconnectPromptShown || this.talkPhase != TalkPhase.SENDING)) {
            C4148a.u(this.TAG, "onSendAck fail ignored: already delivered or timeout-prompted sendSucceeded=" + this.sendSucceeded + " reconnectPromptShown=" + this.reconnectPromptShown + " phase=" + this.talkPhase, false, 4, null);
            return;
        }
        if (success) {
            this.sendSucceeded = true;
            z0(TalkPhase.THINKING);
        } else if (this.talkPhase == TalkPhase.SENDING) {
            if (h2()) {
                C4148a.u(this.TAG, "onSendAck fail held in SENDING, wait for network code=" + code, false, 4, null);
                return;
            }
            if (g2()) {
                C4148a.u(this.TAG, "onSendAck fail held in SENDING: transient after user-stop, will re-dispatch once code=" + code + " msg=" + message, false, 4, null);
                return;
            }
            D0();
        }
        if (this.userMessageIds.isEmpty()) {
            return;
        }
        C4148a.k(this.TAG, "onSendAck success=" + success + " code=" + code + " msg=" + message + " ids=" + this.userMessageIds, false, 4, null);
        this.userMessageAssembler.d(this.userMessageIds, success ^ true);
        C1939k0.m(this.userMessageIds, success ^ true);
        AgentSession agentSession = this.owner;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            String tempSessionId = this.session.getTempSessionId();
            sessionId = tempSessionId.length() != 0 ? tempSessionId : null;
        }
        agentSession.B0(new L0.SendAckEvent(sessionId, this.userMessageIds, success, code, message, 0L, 32, null));
    }

    public final void b0(ChatMessage existing) {
        kotlin.jvm.internal.p.i(existing, "existing");
        if (existing.getPairId().length() > 0) {
            this.pairId = existing.getPairId();
        }
        if (existing.getTraceId().length() > 0) {
            this.traceId = existing.getTraceId();
        }
        this.networkInterrupted = false;
        this.reconnectPromptShown = false;
        H0.b(H0.INSTANCE, existing, 0L, 2, null);
        existing.U(EReplyStatus.REPLYING);
        this.responseAssembler.C(existing);
    }

    /* renamed from: b1, reason: from getter */
    public final boolean getSendPhaseHardTimedOut() {
        return this.sendPhaseHardTimedOut;
    }

    public final void b2() {
        this.hasReceivedAgentResponse = false;
        this.sendSucceeded = true;
        this.reconnectPromptShown = false;
        this.networkInterrupted = false;
        this.disconnectedDuringRound = false;
        this.sendPhaseHardTimedOut = false;
        this.awaitingUserDecision = false;
        this.awaitingDecisionMessageId = null;
        this.externalDecisionRequestIds.clear();
        this.externalDecisionHoldLatched = false;
        this.inquiryContinuationActive = true;
        this.lastTokenTimeMs = System.currentTimeMillis();
        this.toastedPhases.clear();
        h0();
        this.talkPhase = TalkPhase.THINKING;
        this.phaseMonitorStarted = true;
        c2();
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void c(AgentError error) {
        kotlin.jvm.internal.p.i(error, "error");
        if (this.networkInterrupted) {
            C4148a.u(this.TAG, "onError ignored after network interrupt: " + error, false, 4, null);
            return;
        }
        boolean z10 = (this.sendSucceeded || this.hasReceivedAgentResponse) ? false : true;
        if (!z10 && Y0(error)) {
            C4148a.u(this.TAG, "onError treated as network interrupt: " + error, false, 4, null);
            C5442c.INSTANCE.k(getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("code", Integer.valueOf(error.getCode())), Y8.j.a("message", error.getMessage()), Y8.j.a("phase", this.talkPhase.name())), ExifInterface.LONGITUDE_WEST, "ChatRound.onError.networkInterrupt");
            this.hasReceivedAgentResponse = true;
            T0(this, InterruptCause.TRANSPORT_ERROR, null, true, 2, null);
            x1(error);
            o1(error);
            return;
        }
        if (z10 && h2()) {
            C4148a.u(this.TAG, "onError held in SENDING phase, wait for network then resend: " + error, false, 4, null);
            C5442c.INSTANCE.k(getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("code", Integer.valueOf(error.getCode())), Y8.j.a("message", error.getMessage()), Y8.j.a("sendTimeoutMs", Long.valueOf(this.owner.getConfig().getSendTimeoutMs()))), ExifInterface.LONGITUDE_WEST, "ChatRound.onError.holdInSending");
            return;
        }
        if (z10 && g2()) {
            C4148a.u(this.TAG, "onError held in SENDING phase after user-stop, will re-dispatch once: " + error, false, 4, null);
            C5442c.INSTANCE.k(getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("code", Integer.valueOf(error.getCode())), Y8.j.a("message", error.getMessage())), ExifInterface.LONGITUDE_WEST, "ChatRound.onError.holdAfterUserStop");
            return;
        }
        if (z10) {
            TalkPhase talkPhase = this.talkPhase;
            TalkPhase talkPhase2 = TalkPhase.SENDING;
            if (talkPhase == talkPhase2) {
                b(false, Integer.valueOf(error.getCode()), error.getMessage());
                if (this.talkPhase == talkPhase2) {
                    return;
                }
            }
        }
        g1();
        D0();
        C5442c.INSTANCE.k(getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("code", Integer.valueOf(error.getCode())), Y8.j.a("message", error.getMessage())), ExifInterface.LONGITUDE_EAST, "ChatRound.onError");
        AgentSession agentSession = this.owner;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = this.session.getTempSessionId();
            if (sessionId.length() == 0) {
                sessionId = null;
            }
        }
        agentSession.B0(new L0.ErrorEvent(sessionId, error, 0L, 4, null));
        C4148a.k(this.TAG, "onError " + error, false, 4, null);
        this.session.u(this);
        x1(error);
        if (!z10 || U0(error)) {
            if (this.responseAssembler.getAssistantMessage() == null) {
                this.responseAssembler.j(this.session.getSessionId(), this.session.getTempSessionId(), this.owner.getAgentInfo().getAgentId(), this.pairId, getTraceId(), (96 & 32) != 0 ? 0L : 0L, (96 & 64) != 0 ? null : null);
            }
            A0(error);
        } else {
            L1(error);
        }
        o1(error);
    }

    public final void c0(String outboundId) {
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        Q1(outboundId, "beginInquiryAnswerContinuation outboundId=" + outboundId);
        b2();
    }

    public final boolean c1() {
        return this.talkPhase == TalkPhase.COT_THINKING || this.talkPhase == TalkPhase.REPLYING;
    }

    public final void c2() {
        if (R0("startThinkingPhaseTimers")) {
            return;
        }
        this.toastJob = C1060i.d(kotlinx.coroutines.d.a(Ua.Y.b()), null, null, new ChatRound$startThinkingPhaseTimers$1(this, null), 3, null);
        T();
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void d(AgentModeration moderation) {
        String str;
        kotlin.jvm.internal.p.i(moderation, "moderation");
        g1();
        C4148a.k(this.TAG, "onModeration decision=" + moderation.getDecision() + " interrupted=" + moderation.getInterrupted(), false, 4, null);
        AgentSession agentSession = this.owner;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            String tempSessionId = this.session.getTempSessionId();
            str = tempSessionId.length() != 0 ? tempSessionId : null;
        } else {
            str = sessionId;
        }
        agentSession.B0(new L0.ModerationEvent(str, moderation, moderation.getChannelMessageId(), null, 0L, 24, null));
    }

    public final String d0(List<AgentMessage> messages) {
        String string;
        Object next;
        Object next2;
        u4.m mVarC;
        String strH;
        List<AgentMessage> list = messages;
        Iterator<T> it = list.iterator();
        while (true) {
            string = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            u4.m mVarC2 = ((AgentMessage) next).getContent();
            m.ImageMessage eVar = mVarC2 instanceof m.ImageMessage ? (m.ImageMessage) mVarC2 : null;
            boolean z10 = false;
            if (eVar != null && eVar.getSilent()) {
                z10 = true;
            }
            if (!z10) {
                break;
            }
        }
        AgentMessage c5574a = (AgentMessage) next;
        if (c5574a == null) {
            return "";
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (((AgentMessage) next2).getType() == AgentMessageType.TEXT) {
                break;
            }
        }
        AgentMessage c5574a2 = (AgentMessage) next2;
        if (c5574a2 != null && (mVarC = c5574a2.getContent()) != null && (strH = mVarC.h()) != null) {
            string = La.H.D1(strH).toString();
        }
        if (string == null) {
            string = "";
        }
        switch (a.$EnumSwitchMapping$2[c5574a.getType().ordinal()]) {
            case 2:
                if (string.length() == 0) {
                }
                break;
            case 3:
            case 4:
                if (string.length() == 0) {
                }
                break;
            case 5:
                if (string.length() == 0) {
                }
                break;
            case 6:
                if (string.length() == 0) {
                }
                break;
            case 7:
                if (string.length() == 0) {
                }
                break;
        }
        return "";
    }

    public final boolean d1(AgentTaskEvent event) {
        return event.getEventType() == AgentTaskEventType.COMPLETED || event.s() == BusTaskStatus.COMPLETED || event.s() == BusTaskStatus.FAILED || event.s() == BusTaskStatus.CANCELLED || event.s() == BusTaskStatus.SKIPPED;
    }

    public final void d2(String sessionId) {
        String agentId = this.owner.getConfig().getAgentId();
        if (agentId.length() == 0 || sessionId.length() == 0) {
            return;
        }
        x4.e conversationTitleRepository = this.owner.getConversationTitleRepository();
        List<ChatMessage> listG = this.owner.getMessageRepository().g(sessionId);
        boolean z10 = false;
        if (!(listG instanceof Collection) || !listG.isEmpty()) {
            Iterator<T> it = listG.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChatMessage chatMessage = (ChatMessage) it.next();
                if (chatMessage.getRole() == AgentRole.USER && chatMessage.getSendFailed()) {
                    z10 = true;
                    break;
                }
            }
        }
        conversationTitleRepository.o(agentId, sessionId, z10);
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void e() {
        if (this.talkPhase == TalkPhase.FINISHED) {
            C4148a.k(this.TAG, "onNetworkReconnected after finished, catch-up session", false, 4, null);
            this.owner.getHandler().e4("reconnectAfterFinished");
            return;
        }
        C4148a.k(this.TAG, "onNetworkReconnected at phase=" + this.talkPhase + ", restart phase timers", false, 4, null);
        o0();
        int i10 = a.$EnumSwitchMapping$0[this.talkPhase.ordinal()];
        if (i10 == 1) {
            h0();
            c2();
            return;
        }
        if (i10 == 2 || i10 == 3) {
            if (V0() || !j2() || W0()) {
                O1();
                return;
            } else {
                U(this.talkPhase);
                return;
            }
        }
        if (i10 != 4) {
            if (i10 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            h0();
            a2();
        }
    }

    public final boolean e0() {
        return X();
    }

    public final boolean e1(AgentTool tool) {
        String name = tool.getName();
        String apiName = tool.getApiName();
        if (apiName == null) {
            apiName = "";
        }
        List<String> listP = C1173v.p(name, apiName);
        if ((listP instanceof Collection) && listP.isEmpty()) {
            return false;
        }
        for (String str : listP) {
            if (La.D.L(str, this.ASK_USER_TOOL_NAME, true) || La.D.L(str, this.RISK_STATEMENT_TOOL_NAME, true)) {
                return true;
            }
        }
        return false;
    }

    public final void e2(String tempSessionId, String sessionId) {
        if (tempSessionId.length() == 0 || sessionId.length() == 0 || kotlin.jvm.internal.p.d(tempSessionId, sessionId)) {
            return;
        }
        this.owner.G1(tempSessionId);
        Function2.a(new ChatRound$syncConversationTitleSessionId$1(this, tempSessionId, sessionId, null));
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void f(AgentTask task) {
        AgentTask agentTask;
        String str;
        List<AgentTask> listA;
        Object next;
        kotlin.jvm.internal.p.i(task, "task");
        g1();
        C4148a.k(this.TAG, "onTaskExecute task:" + task.getId(), false, 4, null);
        AgentTaskPlan agentTaskPlan = this.planTask;
        if (agentTaskPlan == null || (listA = agentTaskPlan.a()) == null) {
            agentTask = null;
        } else {
            Iterator<T> it = listA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (kotlin.jvm.internal.p.d(((AgentTask) next).getId(), task.getId())) {
                        break;
                    }
                }
            }
            agentTask = (AgentTask) next;
        }
        if (agentTask != null) {
            String url = task.getUrl();
            if (url != null && url.length() != 0) {
                agentTask.m(task.getUrl());
            }
            if (task.getPlanId().length() > 0) {
                agentTask.j(task.getPlanId());
            }
            if (task.getDescription().length() > 0) {
                agentTask.i(task.getDescription());
            }
            if (task.getTitle().length() > 0) {
                agentTask.l(task.getTitle());
            }
            agentTask.k(task.getStatus());
            if (task.getAppUIData() != null) {
                if (agentTask.getAppUIData() == null) {
                    AppUIData appUIData = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData);
                    int uiType = appUIData.getUiType();
                    AppUIData appUIData2 = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData2);
                    String title = appUIData2.getTitle();
                    AppUIData appUIData3 = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData3);
                    String appUIName = appUIData3.getAppUIName();
                    AppUIData appUIData4 = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData4);
                    String description = appUIData4.getDescription();
                    AppUIData appUIData5 = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData5);
                    String content = appUIData5.getContent();
                    AppUIData appUIData6 = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData6);
                    agentTask.h(new AppUIData(null, uiType, title, false, appUIName, description, content, null, appUIData6.getUrl(), null, null, null, null, null, false, false, 65161, null));
                }
                AppUIData appUIData7 = task.getAppUIData();
                kotlin.jvm.internal.p.f(appUIData7);
                if (appUIData7.getHtml().length() > 0) {
                    AppUIData appUIData8 = agentTask.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData8);
                    AppUIData appUIData9 = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData9);
                    appUIData8.setHtml(appUIData9.getHtml());
                }
                AppUIData appUIData10 = task.getAppUIData();
                kotlin.jvm.internal.p.f(appUIData10);
                if (appUIData10.getStructuredContent() != null) {
                    AppUIData appUIData11 = agentTask.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData11);
                    AppUIData appUIData12 = task.getAppUIData();
                    kotlin.jvm.internal.p.f(appUIData12);
                    appUIData11.setStructuredContent(appUIData12.getStructuredContent());
                }
            }
            AgentSession agentSession = this.owner;
            String sessionId = this.session.getSessionId();
            if (sessionId.length() == 0) {
                String tempSessionId = this.session.getTempSessionId();
                str = tempSessionId.length() != 0 ? tempSessionId : null;
            } else {
                str = sessionId;
            }
            agentSession.B0(new L0.TaskUpdateEvent(str, agentTask, 0L, 4, null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "reason"
            kotlin.jvm.internal.p.i(r11, r0)
            s4.c r1 = s4.C5442c.INSTANCE
            java.lang.String r2 = r10.getTraceId()
            r7 = 12
            r8 = 0
            java.lang.String r3 = "request"
            r4 = 0
            r5 = 0
            java.lang.String r6 = "ChatRound.cancel"
            s4.C5442c.l(r1, r2, r3, r4, r5, r6, r7, r8)
            com.stepos.agentframework.chatcore.session.G0 r0 = r10.responseAssembler
            w4.c r0 = r0.getAssistantMessage()
            java.lang.String r1 = r10.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "cancel assistantMessage:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " reason="
            r2.append(r3)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            r3 = 4
            r5 = 0
            h8.C4148a.k(r1, r2, r5, r3, r4)
            if (r0 == 0) goto L5c
            com.stepos.agentframework.chatcore.session.EReplyStatus r1 = r0.getStatus()
            com.stepos.agentframework.chatcore.session.EReplyStatus r2 = com.stepos.agentframework.chatcore.session.EReplyStatus.COMPLETED
            if (r1 == r2) goto L5c
            com.stepos.agentframework.chatcore.session.EReplyStatus r1 = r0.getStatus()
            com.stepos.agentframework.chatcore.session.EReplyStatus r2 = com.stepos.agentframework.chatcore.session.EReplyStatus.CANCELED
            if (r1 == r2) goto L5c
            com.stepos.agentframework.chatcore.session.EReplyStatus r1 = r0.getStatus()
            com.stepos.agentframework.chatcore.session.EReplyStatus r2 = com.stepos.agentframework.chatcore.session.EReplyStatus.ERROR
            if (r1 == r2) goto L5c
            r10.i0(r11)
        L5a:
            r3 = r10
            goto L70
        L5c:
            if (r0 != 0) goto L5a
            java.lang.String r5 = r10.f2(r11)
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r8 = 4
            r9 = 0
            java.lang.String r4 = "CANCELED"
            r6 = 0
            r3 = r10
            N1(r3, r4, r5, r6, r7, r8, r9)
            r3.w1()
        L70:
            com.stepos.agentframework.chatcore.agents.AgentDispatcher$RequestWrapper r10 = r3.requestWrapper
            if (r10 == 0) goto L77
            r10.b(r11)
        L77:
            r3.H1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.ChatRound.f0(java.lang.String):void");
    }

    public final boolean f1(String source) {
        Object objB;
        if (!V0()) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(this.owner.c1(this.session.getAgentId()).getClient().h()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (!((Boolean) objB).booleanValue()) {
            return false;
        }
        C4148a.u(this.TAG, source + " timeout at " + this.talkPhase + " but cloud channel alive, keep waiting", false, 4, null);
        return true;
    }

    public final String f2(String cancelReason) {
        if (kotlin.jvm.internal.p.d(cancelReason, "user.abort")) {
            return "user_cancel";
        }
        if (kotlin.jvm.internal.p.d(cancelReason, "client.superseded")) {
            return "session_switch";
        }
        if (!kotlin.jvm.internal.p.d(cancelReason, InterruptCause.SEND_TIMEOUT.getAbortReason()) && !kotlin.jvm.internal.p.d(cancelReason, InterruptCause.POST_ACK_TIMEOUT.getAbortReason()) && !kotlin.jvm.internal.p.d(cancelReason, InterruptCause.STREAM_STALL.getAbortReason())) {
            if (kotlin.jvm.internal.p.d(cancelReason, InterruptCause.TRANSPORT_ERROR.getAbortReason())) {
                return "error";
            }
            La.D.X(cancelReason, "client.", false, 2, null);
        }
        return "auto_cancel";
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void g(String runId, List<ReferenceSource> sources) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(sources, "sources");
        g1();
        if (sources.isEmpty()) {
            return;
        }
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null) {
            C4148a.u(this.TAG, "onReference dropped: no streaming assistant message runId=" + runId, false, 4, null);
            return;
        }
        C4148a.k(this.TAG, "onReference size=" + sources.size() + " runId=" + runId + " messageId=" + assistantMessage.getMessageId(), false, 4, null);
        assistantMessage.T(sources);
        r0(assistantMessage);
        C1939k0.k(C1173v.h(assistantMessage));
        this.lastSaveTime = System.currentTimeMillis();
    }

    public final void g1() {
        this.hasReceivedAgentResponse = true;
        this.roundActivitySeq.incrementAndGet();
        if (z0(TalkPhase.THINKING)) {
            return;
        }
        l1();
    }

    public final boolean g2() {
        if (this.talkPhase != TalkPhase.SENDING || this.sendPhaseHardTimedOut || !Z0()) {
            return false;
        }
        if (O0()) {
            return true;
        }
        if (this.postStopRetryDispatched) {
            return false;
        }
        return this.session.v0(this);
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void h(AgentTaskComplete task) {
        kotlin.jvm.internal.p.i(task, "task");
        g1();
        AgentSession agentSession = this.owner;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            String tempSessionId = this.session.getTempSessionId();
            if (tempSessionId.length() == 0) {
                tempSessionId = null;
            }
            sessionId = tempSessionId;
        }
        agentSession.B0(new L0.TaskCompleteEvent(sessionId, task, 0L, 4, null));
    }

    public final void h0() {
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.sendTimeoutJob = null;
        kotlinx.coroutines.g gVar2 = this.offlineSendTimeoutJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.offlineSendTimeoutJob = null;
        kotlinx.coroutines.g gVar3 = this.postAckTimeoutJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        this.postAckTimeoutJob = null;
        j0();
    }

    public final void h1(String requestId, String messageId) {
        String str = messageId.length() > 0 ? messageId : null;
        if (this.awaitingUserDecision) {
            if (str != null) {
                this.awaitingDecisionMessageId = str;
            }
            p0();
            return;
        }
        this.awaitingUserDecision = true;
        this.awaitingDecisionMessageId = str;
        p0();
        C4148a.k(this.TAG, "awaiting user decision: hold phase timers phase=" + this.talkPhase + " requestId=" + requestId + " messageId=" + str, false, 4, null);
        C5442c.l(C5442c.INSTANCE, getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("phase", this.talkPhase.name()), Y8.j.a("requestId", requestId), Y8.j.a("messageId", messageId)), null, "ChatRound.markAwaitingUserDecision", 8, null);
        h0();
    }

    public final boolean h2() {
        if (this.talkPhase != TalkPhase.SENDING || this.sendPhaseHardTimedOut || Z0()) {
            return false;
        }
        return this.session.X(this);
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void i(AgentTaskError task) {
        kotlin.jvm.internal.p.i(task, "task");
        g1();
        AgentSession agentSession = this.owner;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            String tempSessionId = this.session.getTempSessionId();
            if (tempSessionId.length() == 0) {
                tempSessionId = null;
            }
            sessionId = tempSessionId;
        }
        agentSession.B0(new L0.TaskFailedEvent(sessionId, task, 0L, 4, null));
    }

    public final void i0(String cancelReason) {
        kotlin.jvm.internal.p.i(cancelReason, "cancelReason");
        C5442c.l(C5442c.INSTANCE, getTraceId(), "event", null, null, "ChatRound.cancelMessage", 12, null);
        D0();
        G0 g02 = this.responseAssembler;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = this.session.getTempSessionId();
        }
        ChatMessage chatMessageU = g02.u(sessionId, this.owner.getAgentInfo().getAgentId(), this.pairId);
        if (chatMessageU == null) {
            N1(this, "CANCELED", f2(cancelReason), null, Boolean.FALSE, 4, null);
            return;
        }
        SessionActivityTracker.INSTANCE.m(chatMessageU);
        r0(chatMessageU);
        C1939k0.k(C1173v.h(chatMessageU));
        boolean zX0 = X0(chatMessageU);
        if (zX0) {
            q0(chatMessageU);
        }
        N1(this, "CANCELED", f2(cancelReason), null, Boolean.valueOf(!zX0), 4, null);
    }

    public final void i1(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        if (this.talkPhase == TalkPhase.FINISHED) {
            return;
        }
        if (R0("markExternalProgress:" + reason)) {
            return;
        }
        C4148a.k(this.TAG, "markExternalProgress reason=" + reason + " phase=" + this.talkPhase, false, 4, null);
        C5442c.l(C5442c.INSTANCE, getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("phase", this.talkPhase.name()), Y8.j.a("reason", reason)), null, "ChatRound.markExternalProgress", 8, null);
        l1();
    }

    public final void i2(AgentResponse response) {
        kotlin.jvm.internal.p.i(response, "response");
        C4148a.k(this.TAG, "updateAssistantMessage status:" + response.getStatus(), false, 4, null);
        X1(response);
        Object extra = response.getExtra();
        C0917m c0917m = extra instanceof C0917m ? (C0917m) extra : null;
        boolean z10 = (c0917m != null ? kotlin.r.a(c0917m) : null) != null;
        ResponseApplyResult d0E = this.responseAssembler.e(response, this.pairId);
        if (d0E != null) {
            ChatMessage chatMessageA = d0E.getMessage();
            if (d0E.getIsFirstResponse()) {
                F1(response.getSessionId());
                AgentSession agentSession = this.owner;
                String sessionId = chatMessageA.getSessionId();
                agentSession.B0(new L0.MessageReplace(sessionId.length() == 0 ? null : sessionId, d0E.getOldMessageId(), chatMessageA, 0L, false, 24, null));
                C1939k0.i(chatMessageA, d0E.getOldMessageId());
                this.lastSaveTime = System.currentTimeMillis();
                return;
            }
            r0(chatMessageA);
            if (response.getStatus() == EReplyStatus.COMPLETED || System.currentTimeMillis() - this.lastSaveTime > 2000 || z10) {
                C1939k0.k(C1173v.h(chatMessageA));
                this.lastSaveTime = System.currentTimeMillis();
            }
        }
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void j(AgentResponse response) {
        kotlin.jvm.internal.p.i(response, "response");
        g1();
        AgentSession agentSession = this.owner;
        String sessionId = response.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = null;
        }
        agentSession.B0(new L0.NoMessageIdResponseEvent(sessionId, response.getContent(), this.pairId, 0L, 8, null));
    }

    public final void j0() {
        kotlinx.coroutines.g gVar = this.toastJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.toastJob = null;
        kotlinx.coroutines.g gVar2 = this.cotCollapseJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.cotCollapseJob = null;
        kotlinx.coroutines.g gVar3 = this.streamStallJob;
        if (gVar3 != null) {
            kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
        }
        this.streamStallJob = null;
    }

    public final void j1() {
        this.disconnectedDuringRound = true;
        C1954s0 c1954s0 = C1954s0.INSTANCE;
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = this.session.getTempSessionId();
        }
        c1954s0.b(sessionId);
    }

    public final boolean j2() {
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null) {
            return false;
        }
        return B.INSTANCE.f(assistantMessage);
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void k(List<AgentTool> tools) {
        String sessionId;
        List<AgentMessage> listI;
        kotlin.jvm.internal.p.i(tools, "tools");
        g1();
        C5442c c5442c = C5442c.INSTANCE;
        String traceId = getTraceId();
        List<AgentTool> list = tools;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.stepos.agentframework.chatcore.intent.f.c((AgentTool) it.next()));
        }
        C5442c.l(c5442c, traceId, "event", arrayList, null, "ChatRound.onRemoteToolsShow", 8, null);
        String str = this.TAG;
        int part = this.responseAssembler.getPart();
        AgentMessageType currentType = this.responseAssembler.getCurrentType();
        String strA0 = Z8.F.A0(list, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.H
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatRound.B1((AgentTool) obj);
            }
        }, 30, null);
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        C4148a.k(str, "onRemoteToolsShow part:" + part + " currentType:" + currentType + " tools=[" + strA0 + "] size:" + ((assistantMessage == null || (listI = assistantMessage.i()) == null) ? null : Integer.valueOf(listI.size())), false, 4, null);
        RequestParameter yVar = new RequestParameter();
        yVar.r(this.owner.getConfig().getAgentId());
        ChatMessage assistantMessage2 = this.responseAssembler.getAssistantMessage();
        if (assistantMessage2 == null || (sessionId = assistantMessage2.getSessionId()) == null) {
            sessionId = "";
        }
        yVar.A(sessionId);
        yVar.z(this.owner.getConfig().getSecretKey());
        yVar.B(this.owner.getConfig().getStream());
        yVar.D(getTraceId());
        yVar.v(C5218a.INSTANCE.a());
        R(yVar, tools);
        ChatMessage chatMessageE = this.responseAssembler.E(tools);
        if (chatMessageE != null) {
            chatMessageE.P(this.cotSendAtMs);
            W1();
            v0(chatMessageE);
            C1939k0.k(C1173v.h(chatMessageE));
            this.lastSaveTime = System.currentTimeMillis();
        }
        E1(tools);
        Q0(tools);
    }

    public final boolean k0() {
        if (this.postStopRetryScheduled || this.postStopRetryDispatched) {
            return false;
        }
        this.postStopRetryScheduled = true;
        return true;
    }

    public final void k1() {
        this.postStopRetryScheduled = false;
        this.postStopRetryDispatched = true;
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void l(AgentResponse response) {
        String strA;
        String str;
        kotlin.jvm.internal.p.i(response, "response");
        g1();
        C5442c c5442c = C5442c.INSTANCE;
        String traceId = getTraceId();
        Pair pairA = Y8.j.a("messageId", response.getMessageId());
        Pair pairA2 = Y8.j.a("sessionId", response.getSessionId());
        Pair pairA3 = Y8.j.a("status", response.getStatus().name());
        Pair pairA4 = Y8.j.a("type", response.getType().name());
        Pair pairA5 = Y8.j.a("contentSize", Integer.valueOf(response.getContent().length()));
        List<AgentTool> listY = response.y();
        C5442c.l(c5442c, traceId, "receive", kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, Y8.j.a("toolSize", Integer.valueOf(listY != null ? listY.size() : 0))), null, "ChatRound.onResponse", 8, null);
        String messageId = response.getMessageId();
        if (messageId.length() <= 0) {
            messageId = null;
        }
        if (messageId == null || !kotlin.jvm.internal.p.d(this.lastLoggedResponseMessageId, messageId) || this.lastLoggedResponseStatus != response.getStatus()) {
            C4148a.k(this.TAG, "AgentSession onResponse " + response.getStatus(), false, 4, null);
            if (messageId != null) {
                this.lastLoggedResponseMessageId = messageId;
                this.lastLoggedResponseStatus = response.getStatus();
            } else {
                this.lastLoggedResponseMessageId = null;
                this.lastLoggedResponseStatus = null;
            }
        }
        K1(response);
        String strA2 = this.owner.getConfig().a(response.getFinishReason());
        if (response.getStatus() == EReplyStatus.COMPLETED && strA2 != null && strA2.length() != 0) {
            C4148a.u(this.TAG, "output block detected finishReason=" + response.getFinishReason() + ", emitting ModerationEvent", false, 4, null);
            AgentSession agentSession = this.owner;
            String sessionId = this.session.getSessionId();
            if (sessionId.length() == 0) {
                String tempSessionId = this.session.getTempSessionId();
                str = tempSessionId.length() != 0 ? tempSessionId : null;
            } else {
                str = sessionId;
            }
            agentSession.B0(new L0.ModerationEvent(str, new AgentModeration(response.getFinishReason(), strA2, null, null, RunBlockedEvent.SCENE_RUN_BLOCKED, null, response.getMessageId(), true, Long.valueOf(System.currentTimeMillis()), strA2, null, null, 3116, null), null, null, 0L, 28, null));
            this.session.u(this);
            D0();
            return;
        }
        int i10 = a.$EnumSwitchMapping$2[response.getType().ordinal()];
        if (i10 == 1) {
            z0(TalkPhase.COT_THINKING);
        } else if (i10 == 2 && response.getContent().length() > 0) {
            z0(TalkPhase.REPLYING);
        }
        Object extra = response.getExtra();
        C0917m c0917m = extra instanceof C0917m ? (C0917m) extra : null;
        if (c0917m != null && (strA = kotlin.r.a(c0917m)) != null) {
            h1(strA, response.getMessageId());
        }
        List<AgentTool> listY2 = response.y();
        if (listY2 == null) {
            listY2 = C1173v.m();
        }
        List<AgentTool> list = listY2;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (e1((AgentTool) it.next())) {
                    String messageId2 = response.getMessageId();
                    if (La.H.x0(messageId2)) {
                        messageId2 = this.RISK_STATEMENT_TOOL_NAME;
                    }
                    h1(messageId2, response.getMessageId());
                }
            }
        }
        int i11 = a.$EnumSwitchMapping$3[response.getStatus().ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (response.getType() == AgentMessageType.TEXT && response.getContent().length() > 0) {
                C0919o.g(getTraceId());
            }
            if (response.getStatus() != EReplyStatus.COMPLETED) {
                i2(response);
                return;
            }
            if (!M.INSTANCE.b(V1(), this.inquiryContinuationActive, response)) {
                E0();
                i2(response);
                if (this.disconnectedDuringRound) {
                    this.owner.getHandler().e4("completedAfterDisconnect");
                }
                D0();
                C0();
                p1();
                this.session.u(this);
                return;
            }
            this.responseAssembler.o();
            i2(AgentResponse.f(response, null, null, null, null, null, null, null, null, EReplyStatus.REPLYING, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194047, null));
            C4148a.k(this.TAG, "COMPLETED held as streaming: userInput=" + V1() + " inquiryCont=" + this.inquiryContinuationActive + " phase=" + this.talkPhase, false, 4, null);
        }
    }

    public final void l0(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        this.responseAssembler.g(messageId);
        I1(messageId, "clearApproval");
    }

    public final void l1() {
        int i10 = a.$EnumSwitchMapping$0[this.talkPhase.ordinal()];
        if (i10 == 1) {
            this.lastTokenTimeMs = System.currentTimeMillis();
            h0();
            c2();
        } else if (i10 == 2 || i10 == 3) {
            O1();
        } else if (i10 != 4 && i10 != 5) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void m(String runId, String name, String resultJson) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(resultJson, "resultJson");
        g1();
        ChatMessage assistantMessage = this.responseAssembler.getAssistantMessage();
        if (assistantMessage == null) {
            C4148a.u(this.TAG, "onCard dropped: no streaming assistant message runId=" + La.K.R1(runId, 32), false, 4, null);
            return;
        }
        if (C1931g0.INSTANCE.c(assistantMessage, name, resultJson)) {
            C4148a.k(this.TAG, "onCard name=" + name + " runId=" + La.K.R1(runId, 32) + " messageId=" + assistantMessage.getMessageId(), false, 4, null);
            v0(assistantMessage);
            C1939k0.k(C1173v.h(assistantMessage));
            this.lastSaveTime = System.currentTimeMillis();
        }
    }

    public final void m0(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        this.responseAssembler.h(messageId);
        I1(messageId, "clearAskUserConversation");
    }

    public final boolean m1() {
        return this.uplinkReported.compareAndSet(false, true);
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void n() {
        if (this.talkPhase == TalkPhase.FINISHED) {
            return;
        }
        C4148a.u(this.TAG, "onNetworkDisconnected at phase=" + this.talkPhase + ", wait for auto-reconnect", false, 4, null);
        j1();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String n0() {
        /*
            r5 = this;
            com.stepos.agentframework.chatcore.session.G0 r5 = r5.responseAssembler
            w4.c r5 = r5.getAssistantMessage()
            java.lang.String r0 = "none"
            if (r5 == 0) goto L8e
            java.util.List r5 = r5.i()
            if (r5 == 0) goto L8e
            int r1 = r5.size()
            java.util.ListIterator r5 = r5.listIterator(r1)
        L18:
            boolean r1 = r5.hasPrevious()
            r2 = 0
            if (r1 == 0) goto L2f
            java.lang.Object r1 = r5.previous()
            r3 = r1
            u4.a r3 = (u4.AgentMessage) r3
            com.stepos.agentframework.chatcore.session.AgentMessageType r3 = r3.getType()
            com.stepos.agentframework.chatcore.session.AgentMessageType r4 = com.stepos.agentframework.chatcore.session.AgentMessageType.TOOL
            if (r3 != r4) goto L18
            goto L30
        L2f:
            r1 = r2
        L30:
            u4.a r1 = (u4.AgentMessage) r1
            if (r1 == 0) goto L8e
            java.util.List r5 = r1.g()
            if (r5 == 0) goto L8e
            java.lang.Object r1 = Z8.F.E0(r5)
            com.stepos.agentframework.chatcore.intent.e r1 = (com.stepos.agentframework.chatcore.intent.AgentTool) r1
            if (r1 != 0) goto L43
            return r0
        L43:
            java.lang.String r0 = r1.getApiName()
            if (r0 == 0) goto L53
            int r3 = r0.length()
            if (r3 <= 0) goto L50
            goto L51
        L50:
            r0 = r2
        L51:
            if (r0 != 0) goto L64
        L53:
            java.lang.String r0 = r1.getName()
            int r3 = r0.length()
            if (r3 <= 0) goto L5e
            r2 = r0
        L5e:
            if (r2 != 0) goto L63
            java.lang.String r0 = "unknown"
            goto L64
        L63:
            r0 = r2
        L64:
            boolean r1 = r1.getIsFinished()
            int r5 = r5.size()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "(finished="
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = ",total="
            r2.append(r0)
            r2.append(r5)
            java.lang.String r5 = ")"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            return r5
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.ChatRound.n0():java.lang.String");
    }

    public final void n1() {
        N1(this, "CANCELED", "user_cancel", null, null, 12, null);
    }

    public final void o0() {
        if (this.reconnectPromptShown) {
            this.reconnectPromptShown = false;
            this.owner.B0(new L0.ReconnectPromptDismissEvent(B0(), null, 0L, 6, null));
        }
    }

    public final void o1(AgentError error) {
        M1("FAILED", La.H.g0(error.getMessage(), "未返回任何内容", false, 2, null) ? "grace_expired" : "error", error, Boolean.FALSE);
    }

    @Override // com.stepos.agentframework.chatcore.session.W
    public void onSessionCreated(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        g1();
        C5442c.l(C5442c.INSTANCE, getTraceId(), "event", kotlin.collections.a.m(Y8.j.a("createdSessionId", sessionId), Y8.j.a("currentSessionId", this.session.getSessionId()), Y8.j.a("tempSessionId", this.session.getTempSessionId())), null, "ChatRound.onSessionCreated", 8, null);
        if (this.session.getSessionId().length() == 0 && !kotlin.jvm.internal.p.d(this.session.getSessionId(), sessionId)) {
            C0919o.k("框架·收到云端sessionId(onSessionCreated)");
            String tempSessionId = this.session.getTempSessionId();
            C4148a.k(this.TAG, "sessionId change from " + sessionId + " to " + this.session.getSessionId(), false, 4, null);
            this.session.p0(sessionId);
            this.session.f0(tempSessionId);
            AgentSession agentSession = this.owner;
            String tempSessionId2 = this.session.getTempSessionId();
            agentSession.B0(new L0.SessionCreated(tempSessionId2.length() == 0 ? null : tempSessionId2, sessionId, null, 0L, 12, null));
            F1(sessionId);
            e2(tempSessionId, sessionId);
            this.responseAssembler.B(sessionId);
            y1(sessionId, tempSessionId);
        }
        if (this.session.getIsTempSession()) {
            C4148a.k(this.TAG, "onSessionCreated sessionId:" + sessionId, false, 4, null);
            this.session.q0(false);
            String tempSessionId3 = this.session.getTempSessionId();
            if (tempSessionId3.length() > 0 && this.owner.Z0().get(tempSessionId3) == this.session) {
                this.owner.Z0().remove(tempSessionId3);
            }
            this.owner.Z0().put(this.session.getSessionId(), this.session);
        }
    }

    public final void p0() {
        if (this.reconnectPromptShown) {
            this.reconnectPromptShown = false;
        }
        this.owner.B0(new L0.ReconnectPromptDismissEvent(B0(), ReconnectReason.AI_TIMEOUT, 0L, 4, null));
    }

    public final void p1() {
        N1(this, "COMPLETED", "", null, null, 12, null);
    }

    public final void q0(ChatMessage message) {
        AgentSession agentSession = this.owner;
        String sessionId = message.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = null;
        }
        agentSession.B0(new L0.MessageRemove(sessionId, message, 0L, 4, null));
    }

    public final void q1(String messageId) {
        ChatMessage chatMessageJ = this.responseAssembler.j(this.session.getSessionId(), this.session.getTempSessionId(), this.owner.getAgentInfo().getAgentId(), this.pairId, this.traceId, this.userMessageAssembler.c() + 1, messageId);
        VariantGroupTag variantGroupTag = this.variantGroup;
        if (variantGroupTag != null) {
            chatMessageJ.a0(variantGroupTag.getGroupId());
            chatMessageJ.b0(variantGroupTag.getVariantIndex());
            chatMessageJ.Z(variantGroupTag.getTotalCount());
        }
        r0(chatMessageJ);
        C1939k0.k(C1173v.h(chatMessageJ));
    }

    public final void r0(ChatMessage message) {
        AgentSession agentSession = this.owner;
        String sessionId = message.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = null;
        }
        agentSession.B0(new L0.MessageUpsert(sessionId, message, 0L, 4, null));
    }

    public final void s0(TalkPhase phase) {
        if (phase == TalkPhase.FINISHED) {
            return;
        }
        if (Z0()) {
            C4148a.d(this.TAG, "network toast skipped: network usable at " + phase, false, 4, null);
            return;
        }
        if (this.toastedPhases.putIfAbsent(phase, Boolean.TRUE) == null) {
            this.owner.B0(new L0.NetworkToastEvent(B0(), phase, 0L, 4, null));
            return;
        }
        C4148a.d(this.TAG, "network toast skipped: already shown at " + phase, false, 4, null);
    }

    public final String s1() {
        return O6.m.INSTANCE.c("pair-" + System.currentTimeMillis() + O6.l.DATE_SEPARATOR + hashCode());
    }

    public final void t0(boolean roundAlive, ReconnectReason reason) {
        this.reconnectPromptShown = true;
        this.owner.B0(new L0.ReconnectPromptEvent(B0(), roundAlive, reason, 0L, 8, null));
    }

    public final void t1(String agentId, List<AgentMessage> messages, ChatMessage resendMessage, String userMessageId, String imageMessageId, String fileMessageId) {
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(messages, "messages");
        String strD0 = d0(messages);
        String sessionId = this.session.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = this.session.getTempSessionId();
        }
        RevertedSessionGuard.INSTANCE.d(sessionId);
        if (strD0.length() > 0 && sessionId.length() > 0) {
            boolean isTempSession = this.session.getIsTempSession();
            String agentId2 = this.session.getAgentId();
            String deviceId = this.session.getDeviceId();
            if (deviceId == null) {
                deviceId = "";
            }
            R1(strD0, sessionId, isTempSession, agentId2, deviceId);
        }
        List<ChatMessage> listB = this.userMessageAssembler.b(agentId, this.session.getSessionId(), this.session.getTempSessionId(), this.pairId, this.traceId, messages, resendMessage, userMessageId, imageMessageId, fileMessageId, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.F
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatRound.u1(this.f22464a, (ChatMessage) obj);
            }
        }, new p9.p() { // from class: com.stepos.agentframework.chatcore.session.G
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return ChatRound.v1(this.f22465a, (ChatMessage) obj, (String) obj2);
            }
        });
        List<ChatMessage> list = listB;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChatMessage) it.next()).getMessageId());
        }
        this.userMessageIds = arrayList;
        C1939k0.k(listB);
    }

    public final void u() {
        C4148a.k(this.TAG, "abandonForRetry at phase=" + this.talkPhase, false, 4, null);
        C5442c.l(C5442c.INSTANCE, getTraceId(), "request", Z8.Q.f(Y8.j.a("phase", this.talkPhase.name())), null, "ChatRound.abandonForRetry", 8, null);
        AgentDispatcher.RequestWrapper requestWrapper = this.requestWrapper;
        if (requestWrapper != null) {
            AgentDispatcher.RequestWrapper.c(requestWrapper, null, 1, null);
        }
        H1();
    }

    public final void v0(ChatMessage message) {
        AgentSession agentSession = this.owner;
        String sessionId = message.getSessionId();
        if (sessionId.length() == 0) {
            sessionId = null;
        }
        agentSession.B0(new L0.ToolMessageUpsert(sessionId, message, 0L, 4, null));
    }

    public final void w0() {
        if (this.talkPhase == TalkPhase.FINISHED) {
            C4148a.k(this.TAG, "ensureResponseTimeoutMonitor skipped: round already finished", false, 4, null);
        } else {
            if (this.phaseMonitorStarted) {
                return;
            }
            C4148a.k(this.TAG, "ensureResponseTimeoutMonitor: start phase timers lazily", false, 4, null);
            Y1();
        }
    }

    public final void w1() {
        List listP = C1173v.p(this.session.getSessionId(), this.session.getTempSessionId());
        ArrayList arrayList = new ArrayList(C1174w.x(listP, 10));
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            arrayList.add(La.H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        List listG0 = Z8.F.g0(arrayList2);
        SessionActivityTracker sessionActivityTracker = SessionActivityTracker.INSTANCE;
        Iterator it2 = listG0.iterator();
        while (it2.hasNext()) {
            sessionActivityTracker.a((String) it2.next());
        }
    }

    public final void x0() {
        if (this.taskSettleListenerRegistered.compareAndSet(false, true)) {
            P0.b(this, new InterfaceC1859a0() { // from class: com.stepos.agentframework.chatcore.session.J
                @Override // com.stepos.agentframework.chatcore.session.InterfaceC1859a0
                public final void b(String str, AgentTaskEvent agentTaskEvent) {
                    ChatRound.y0(this.f22467a, str, agentTaskEvent);
                }
            });
        }
    }

    public final void x1(AgentError error) {
    }

    public final void y1(String sessionId, String tempSessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(tempSessionId, "tempSessionId");
    }

    public final boolean z0(TalkPhase next) {
        if (next.ordinal() <= this.talkPhase.ordinal()) {
            if (next != this.talkPhase || !c1()) {
                return false;
            }
            O1();
            return false;
        }
        this.talkPhase = next;
        h0();
        o0();
        int i10 = a.$EnumSwitchMapping$0[next.ordinal()];
        if (i10 == 1) {
            c2();
        } else if (i10 == 2 || i10 == 3) {
            O1();
        } else if (i10 == 4) {
            a2();
        } else if (i10 != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return true;
    }

    public final void z1(AgentTaskEvent event) {
        if (this.talkPhase == TalkPhase.FINISHED) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = this.lastTaskProgressKeepAliveMs;
        if (j10 == 0 || jCurrentTimeMillis - j10 >= this.TASK_PROGRESS_KEEPALIVE_THROTTLE_MS) {
            this.lastTaskProgressKeepAliveMs = jCurrentTimeMillis;
            Function2.b(new ChatRound$onDispatchedTaskProgress$1(this, event, null));
        }
    }

    public /* synthetic */ ChatRound(AgentSession agentSession, AgentSession.AgentConversation agentConversation, AgentSession.d dVar, String str, VariantGroupTag variantGroupTag, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this(agentSession, agentConversation, (i10 & 4) != 0 ? null : dVar, (i10 & 8) != 0 ? "" : str, (i10 & 16) != 0 ? null : variantGroupTag, (i10 & 32) != 0 ? null : str2);
    }
}
