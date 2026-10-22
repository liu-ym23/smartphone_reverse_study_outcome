package com.stepos.ailauncher.chat.view.sla;

import La.D;
import La.K;
import O6.x;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Q;
import Ua.Y;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.provider.Settings;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.chatcore.InterfaceC1848c;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.send.LocalExecResult;
import com.stepos.agentframework.chatcore.send.SendContext;
import com.stepos.agentframework.chatcore.send.SlaSessionAnchor;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.C1939k0;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.T1;
import com.stepos.agentframework.util.C;
import com.stepos.agentframework.util.E;
import com.stepos.aiengine.algorithm.sla.SlaDecision;
import com.stepos.aiengine.algorithm.sla.SlaResult;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.lockscreen.H;
import com.stepos.ailauncher.chat.lockscreen.O;
import com.stepos.ailauncher.chat.view.sla.a;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.sla.C3474c;
import com.stepos.ailauncher.sla.SlaGate;
import com.stepos.ailauncher.sla.SlaRouter;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import com.stepos.ailauncher.sla.w;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import io.ktor.sse.ServerSentEventKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.C0919o;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.AgentMessage;
import u4.m;
import v9.C5680i;
import v9.C5685n;
import w4.ChatMessage;
import y4.InterfaceC5940b;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Ñ\u00012\u00020\u00012\u00020\u0002:\u0006\u009a\u0001\u009c\u0001\u0094\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u001c\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0010H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010!J\u001f\u0010&\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0012H\u0002¢\u0006\u0004\b(\u0010\u001fJ\u001f\u0010-\u001a\u00020\u00122\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00122\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0012H\u0002¢\u0006\u0004\b3\u0010\u001fJ5\u00108\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0012052\u0006\u00107\u001a\u00020\tH\u0002¢\u0006\u0004\b8\u00109J'\u0010:\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u00122\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00102\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u001d\u0010F\u001a\u00020\u00122\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\t0DH\u0002¢\u0006\u0004\bF\u0010GJ3\u0010K\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010\t2\u0006\u0010I\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010J\u001a\u00020/H\u0002¢\u0006\u0004\bK\u0010LJ\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020M0D2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bN\u0010OJ!\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010D2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bR\u0010SJ\u001f\u0010T\u001a\b\u0012\u0004\u0012\u00020\t0D2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bT\u0010SJ'\u0010V\u001a\u00020\u00122\b\u0010H\u001a\u0004\u0018\u00010\t2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001205H\u0002¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u0012H\u0002¢\u0006\u0004\bX\u0010\u001fJ\u0017\u0010Y\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\bY\u0010ZJ?\u0010\\\u001a\u00020\u00102\u0006\u00104\u001a\u00020\t2\b\u0010H\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\t2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\\\u0010]JU\u0010d\u001a\u00020\u00122\u0006\u00104\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\r2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020`0D2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010c\u001a\u00020/H\u0002¢\u0006\u0004\bd\u0010eJ\u001f\u0010f\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\rH\u0002¢\u0006\u0004\bf\u0010gJ\u001b\u0010h\u001a\u0004\u0018\u00010Q2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bh\u0010iJ\u001b\u0010j\u001a\u0004\u0018\u00010Q2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bj\u0010iJ\u001b\u0010k\u001a\u0004\u0018\u00010\t2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bk\u0010lJ\u001b\u0010m\u001a\u0004\u0018\u00010\t2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bm\u0010lJ\u001b\u0010n\u001a\u0004\u0018\u00010\t2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bn\u0010lJ\u0019\u0010o\u001a\u00020\t2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bo\u0010lJ\u001b\u0010p\u001a\u0004\u0018\u00010`2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bp\u0010qJ\u0019\u0010r\u001a\u00020\r2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\br\u0010sJ1\u0010v\u001a\u0004\u0018\u00010\t2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\t0D2\u0006\u0010_\u001a\u00020\r2\b\u0010u\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bv\u0010wJ\u001b\u0010x\u001a\u0004\u0018\u00010\t2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bx\u0010lJ\u001b\u0010y\u001a\u0004\u0018\u00010\t2\b\u0010P\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\by\u0010lJS\u0010~\u001a\u00020}2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010[\u001a\u00020\t2\u0006\u0010{\u001a\u00020z2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020/2\u0010\b\u0002\u0010|\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010D2\b\b\u0002\u0010H\u001a\u00020\tH\u0002¢\u0006\u0004\b~\u0010\u007fJ5\u0010\u0080\u0001\u001a\u00020\u00122\u0006\u00104\u001a\u00020\t2\u0006\u0010A\u001a\u00020@2\u0006\u0010#\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0082@¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\tH\u0002¢\u0006\u0005\b\u0082\u0001\u0010\u000bJ\u000f\u0010\u0083\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0083\u0001\u0010\u001fJ+\u0010\u0087\u0001\u001a\u00020\u00122\b\u0010\u0085\u0001\u001a\u00030\u0084\u00012\u000f\b\u0002\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u001005¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u000f\u0010\u0089\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u0089\u0001\u0010!J\u000f\u0010\u008a\u0001\u001a\u00020\u0010¢\u0006\u0005\b\u008a\u0001\u0010!J\u0019\u0010\u008c\u0001\u001a\u00020\u00102\u0007\u0010\u008b\u0001\u001a\u00020\u0005¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u000f\u0010\u008e\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u008e\u0001\u0010\u001fJ\u0019\u0010\u008f\u0001\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0005\b\u008f\u0001\u0010ZJ!\u0010\u0090\u0001\u001a\u00020\u00122\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0005\b\u0090\u0001\u0010.J8\u0010\u0091\u0001\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u0010A\u001a\u00020@2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001205H\u0016¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J+\u0010\u0094\u0001\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0007\u0010\u0093\u0001\u001a\u00020\rH\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J,\u0010\u0098\u0001\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\b\u0010\u0097\u0001\u001a\u00030\u0096\u0001H\u0016¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001a\u0010\u009a\u0001\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\tH\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J)\u0010\u009c\u0001\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0016¢\u0006\u0005\b\u009c\u0001\u0010;J,\u0010\u009f\u0001\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\t2\u0007\u0010\u009d\u0001\u001a\u00020\r2\u0007\u0010\u009e\u0001\u001a\u00020/H\u0016¢\u0006\u0006\b\u009f\u0001\u0010 \u0001R\u0015\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010¡\u0001R\u0017\u0010¢\u0001\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001d\u0010¨\u0001\u001a\u00030§\u00018\u0006¢\u0006\u0010\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R#\u0010\u00ad\u0001\u001a\f\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R!\u0010¯\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010±\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\"\u0010´\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010³\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R8\u0010·\u0001\u001a\u0011\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u0012\u0018\u00010¶\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010²\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010²\u0001R\u0018\u0010À\u0001\u001a\u00030¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001f\u0010Å\u0001\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\bÂ\u0001\u0010Ã\u0001\u001a\u0005\bÄ\u0001\u0010\u000bR\u001c\u0010Ç\u0001\u001a\u0005\u0018\u00010Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001b\u0010É\u0001\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010Í\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010²\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001¨\u0006Ò\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/SlaChatController;", "Lcom/stepos/ailauncher/sla/SlaGate$d;", "Lcom/stepos/agentframework/chatcore/send/j;", "Landroid/content/Context;", "hostContext", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "<init>", "(Landroid/content/Context;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "", "d0", "()Ljava/lang/String;", "sessionId", "", "c0", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "persisted", "LY8/t;", "W0", "(Z)V", "title", "Lcom/stepos/agentframework/chatcore/send/l;", LinkHeader.Parameters.Anchor, "Y0", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;)V", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;Le9/c;)Ljava/lang/Object;", "g0", "(Lcom/stepos/agentframework/chatcore/SessionHandler;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;Le9/c;)Ljava/lang/Object;", "X", "()V", "X0", "()Z", "P0", DidiCardProvider.KEY_TRACE_ID, "Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;", "settled", "G0", "(Ljava/lang/String;Lcom/stepos/ailauncher/sla/SlaVoiceBridge$VoiceSendBind;)V", "t0", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "Lcom/stepos/agentframework/chatcore/send/k;", "cb", "b0", "(Lcom/stepos/agentframework/chatcore/send/e;Lcom/stepos/agentframework/chatcore/send/k;)V", "", "budgetMs", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(J)V", "U", "query", "Lkotlin/Function0;", "routeToBackend", "reason", "U0", "(Ljava/lang/String;Ljava/lang/String;Lp9/a;Ljava/lang/String;)V", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/view/sla/a;", "resolution", "T0", "(Lcom/stepos/ailauncher/chat/view/sla/a;)V", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "result", "C0", "(Lcom/stepos/aiengine/algorithm/sla/SlaResult;)Z", "", "messageIds", "b1", "(Ljava/util/List;)V", "messageId", "text", "time", "R0", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;J)V", "Lcom/stepos/ailauncher/sla/w$a;", "j0", "(Lcom/stepos/aiengine/algorithm/sla/SlaResult;)Ljava/util/List;", "resultJson", "Lorg/json/JSONObject;", "I0", "(Ljava/lang/String;)Ljava/util/List;", "h0", "action", "P", "(Ljava/lang/String;Lp9/a;)V", "n0", "N0", "(Lcom/stepos/agentframework/chatcore/send/e;)Z", "agentId", "O0", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;Ljava/lang/String;Ljava/lang/String;)Z", "replyText", HomeGestureEligibilityContract.EXTRA_SCENE, "Lcom/stepos/agentframework/chatcore/intent/e;", "appUiTools", "reuseUserMessageId", "userTime", "u0", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Lcom/stepos/agentframework/chatcore/send/l;Ljava/lang/String;J)V", "D0", "(Ljava/lang/String;I)V", "M0", "(Ljava/lang/String;)Lorg/json/JSONObject;", "J0", "L0", "(Ljava/lang/String;)Ljava/lang/String;", "K0", "H0", "k0", "i0", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/intent/e;", "l0", "(Ljava/lang/String;)I", "actionJsons", "fallbackFunction", "m0", "(Ljava/util/List;ILjava/lang/String;)Ljava/lang/String;", "Z0", SdCardDbCreator.FIELD_LASTLOC_ID, "Lcom/stepos/agentframework/chatcore/session/AgentRole;", BundleContentBridge.KEY_ROLE, "tools", "Lw4/c;", "Z", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/AgentRole;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;)Lw4/c;", "S0", "(Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaResult;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;Le9/c;)Ljava/lang/Object;", "E0", "F0", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "chatLayout", "suppressUserMessage", "v0", "(Lcom/stepos/agentframework/chatui/AgentChatLayout;Lp9/a;)V", "A0", "Q0", "handler", "B0", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)Z", "e0", Const.INTENT_KEY_UMID, "e", "f", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaResult;Lp9/a;)V", "errorCode", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;I)V", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/aiengine/algorithm/sla/SlaDecision;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "c", "actionCount", "executionBudgetMs", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;IJ)V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "context", "Landroid/content/Context;", "LUa/M;", "ioScope", "LUa/M;", "Lcom/stepos/ailauncher/sla/SlaGate;", "gate", "Lcom/stepos/ailauncher/sla/SlaGate;", "s0", "()Lcom/stepos/ailauncher/sla/SlaGate;", "Ljava/lang/ref/WeakReference;", "chatLayoutRef", "Ljava/lang/ref/WeakReference;", "suppressUserMessageProvider", "Lp9/a;", "pendingRoundSessionId", "Ljava/lang/String;", "LUa/Q;", "pendingSessionJob", "LUa/Q;", "Lkotlin/Function1;", "onHalfPopupResolved", "Lp9/l;", "getOnHalfPopupResolved$chat_release", "()Lp9/l;", "V0", "(Lp9/l;)V", "lastHalfPopupResolutionTraceId", "pendingUserMessageId", "Ljava/util/concurrent/atomic/AtomicLong;", "eventCounter", "Ljava/util/concurrent/atomic/AtomicLong;", "deviceId$delegate", "LY8/h;", "r0", "deviceId", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController$a;", "cloudFirstPending", "Lcom/stepos/ailauncher/chat/view/sla/SlaChatController$a;", "pendingArbitrateCtx", "Lcom/stepos/agentframework/chatcore/send/e;", "pendingArbitrateCb", "Lcom/stepos/agentframework/chatcore/send/k;", "pendingTraceId", "Lkotlinx/coroutines/g;", "sendTimeoutJob", "Lkotlinx/coroutines/g;", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaChatController implements SlaGate.d, com.stepos.agentframework.chatcore.send.j {
    private static final String EXECUTED_TEXT = "已执行";
    private static final String KEY_SLA_ACTIONS = "slaActions";
    private static final long LOCK_MISS_WAIT_MS = 120000;
    private static final int MAX_SLA_QUERY_CHARS = 480;
    private static final String MISSING_STRUCTURED_CONTENT_HINT = "Response missing structured content";
    private static final String NO_ATOMIC_ABILITY_CODE = "codeString=20004";
    private static final long SEND_TIMEOUT_MS = 15000;
    private static final long SEND_TIMEOUT_SLACK_MS = 2000;
    private static final String SLA_ASSISTANT_MESSAGE_ID_PREFIX = "sla-assistant-";
    private static final String SLA_LOG_TAG = "SLA";
    private static final int SLA_SCENE_CLOSE_HOST = 2;
    private static final int SLA_SCENE_NONE = -1;
    private static final String TAG = "SlaChatController";
    private WeakReference<AgentChatLayout> chatLayoutRef;
    private volatile CloudFirstPending cloudFirstPending;
    private final Context context;

    /* renamed from: deviceId$delegate, reason: from kotlin metadata */
    private final Y8.h deviceId;
    private final AtomicLong eventCounter;
    private final SlaGate gate;
    private final M ioScope;
    private String lastHalfPopupResolutionTraceId;
    private InterfaceC5074l<? super a, t> onHalfPopupResolved;
    private com.stepos.agentframework.chatcore.send.k pendingArbitrateCb;
    private SendContext pendingArbitrateCtx;
    private volatile String pendingRoundSessionId;
    private volatile Q<String> pendingSessionJob;
    private String pendingTraceId;
    private String pendingUserMessageId;
    private kotlinx.coroutines.g sendTimeoutJob;
    private final SessionHandler sessionHandler;
    private InterfaceC5063a<Boolean> suppressUserMessageProvider;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> TARGET_PAGE_PARAM_KEYS = C1173v.p("packageName", "appName", "pageName");

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/SlaChatController$a;", "", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "", "query", "messageId", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Lcom/stepos/agentframework/chatcore/send/e;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/send/e;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/send/e;", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$a, reason: from toString */
    public static final /* data */ class CloudFirstPending {
        private final SendContext ctx;
        private final String messageId;
        private final String query;
        private final String traceId;

        public CloudFirstPending(SendContext ctx, String query, String messageId, String traceId) {
            kotlin.jvm.internal.p.i(ctx, "ctx");
            kotlin.jvm.internal.p.i(query, "query");
            kotlin.jvm.internal.p.i(messageId, "messageId");
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.ctx = ctx;
            this.query = query;
            this.messageId = messageId;
            this.traceId = traceId;
        }

        /* renamed from: a, reason: from getter */
        public final SendContext getCtx() {
            return this.ctx;
        }

        /* renamed from: b, reason: from getter */
        public final String getMessageId() {
            return this.messageId;
        }

        /* renamed from: c, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        /* renamed from: d, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloudFirstPending)) {
                return false;
            }
            CloudFirstPending cloudFirstPending = (CloudFirstPending) other;
            return kotlin.jvm.internal.p.d(this.ctx, cloudFirstPending.ctx) && kotlin.jvm.internal.p.d(this.query, cloudFirstPending.query) && kotlin.jvm.internal.p.d(this.messageId, cloudFirstPending.messageId) && kotlin.jvm.internal.p.d(this.traceId, cloudFirstPending.traceId);
        }

        public int hashCode() {
            return (((((this.ctx.hashCode() * 31) + this.query.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.traceId.hashCode();
        }

        public String toString() {
            return "CloudFirstPending(ctx=" + this.ctx + ", query=" + this.query + ", messageId=" + this.messageId + ", traceId=" + this.traceId + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/SlaChatController$b;", "", "<init>", "()V", "", "messageId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "", "MAX_SLA_QUERY_CHARS", "I", "SLA_LOG_TAG", "EXECUTED_TEXT", "NO_ATOMIC_ABILITY_CODE", "MISSING_STRUCTURED_CONTENT_HINT", "KEY_SLA_ACTIONS", "SLA_SCENE_NONE", "SLA_SCENE_CLOSE_HOST", "", "TARGET_PAGE_PARAM_KEYS", "Ljava/util/List;", "", "SEND_TIMEOUT_MS", "J", "LOCK_MISS_WAIT_MS", "SEND_TIMEOUT_SLACK_MS", "SLA_ASSISTANT_MESSAGE_ID_PREFIX", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(String messageId) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            return D.X(messageId, SlaChatController.SLA_ASSISTANT_MESSAGE_ID_PREFIX, false, 2, null);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b \u0010\u0010R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b$\u0010\u0010¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/SlaChatController$c;", "", "", "toolName", "", "arguments", "statusName", "", "isError", "text", "", "elapsedMs", "resultJson", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", Const.INTENT_KEY_UMID, "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "e", "J", Const.INTENT_KEY_PKGNAME, "()J", "c", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$c, reason: from toString */
    public static final /* data */ class TranscriptToolEvent {
        private final Map<String, String> arguments;
        private final long elapsedMs;
        private final boolean isError;
        private final String resultJson;
        private final String statusName;
        private final String text;
        private final String toolName;

        public TranscriptToolEvent(String toolName, Map<String, String> arguments, String statusName, boolean z10, String text, long j10, String str) {
            kotlin.jvm.internal.p.i(toolName, "toolName");
            kotlin.jvm.internal.p.i(arguments, "arguments");
            kotlin.jvm.internal.p.i(statusName, "statusName");
            kotlin.jvm.internal.p.i(text, "text");
            this.toolName = toolName;
            this.arguments = arguments;
            this.statusName = statusName;
            this.isError = z10;
            this.text = text;
            this.elapsedMs = j10;
            this.resultJson = str;
        }

        public final Map<String, String> a() {
            return this.arguments;
        }

        /* renamed from: b, reason: from getter */
        public final long getElapsedMs() {
            return this.elapsedMs;
        }

        /* renamed from: c, reason: from getter */
        public final String getResultJson() {
            return this.resultJson;
        }

        /* renamed from: d, reason: from getter */
        public final String getStatusName() {
            return this.statusName;
        }

        /* renamed from: e, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TranscriptToolEvent)) {
                return false;
            }
            TranscriptToolEvent transcriptToolEvent = (TranscriptToolEvent) other;
            return kotlin.jvm.internal.p.d(this.toolName, transcriptToolEvent.toolName) && kotlin.jvm.internal.p.d(this.arguments, transcriptToolEvent.arguments) && kotlin.jvm.internal.p.d(this.statusName, transcriptToolEvent.statusName) && this.isError == transcriptToolEvent.isError && kotlin.jvm.internal.p.d(this.text, transcriptToolEvent.text) && this.elapsedMs == transcriptToolEvent.elapsedMs && kotlin.jvm.internal.p.d(this.resultJson, transcriptToolEvent.resultJson);
        }

        /* renamed from: f, reason: from getter */
        public final String getToolName() {
            return this.toolName;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsError() {
            return this.isError;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.toolName.hashCode() * 31) + this.arguments.hashCode()) * 31) + this.statusName.hashCode()) * 31) + Boolean.hashCode(this.isError)) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.elapsedMs)) * 31;
            String str = this.resultJson;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "TranscriptToolEvent(toolName=" + this.toolName + ", arguments=" + this.arguments + ", statusName=" + this.statusName + ", isError=" + this.isError + ", text=" + this.text + ", elapsedMs=" + this.elapsedMs + ", resultJson=" + this.resultJson + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class d {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SlaVoiceBridge.VoiceSendBind.values().length];
            try {
                iArr[SlaVoiceBridge.VoiceSendBind.NO_ROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SlaVoiceBridge.VoiceSendBind.LOCAL_WON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SlaVoiceBridge.VoiceSendBind.EXEC_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SlaVoiceBridge.VoiceSendBind.RESULT_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SlaVoiceBridge.VoiceSendBind.LEDGER_PENDING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SlaVoiceBridge.VoiceSendBind.BOUND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SlaChatController(Context hostContext, SessionHandler sessionHandler) {
        kotlin.jvm.internal.p.i(hostContext, "hostContext");
        kotlin.jvm.internal.p.i(sessionHandler, "sessionHandler");
        this.sessionHandler = sessionHandler;
        Context applicationContext = hostContext.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        this.context = applicationContext;
        this.ioScope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.b()));
        this.gate = new SlaGate(applicationContext, this, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.sla.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaChatController.o0(this.f26333a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.sla.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaChatController.p0();
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.sla.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SlaChatController.q0(this.f26337a, (String) obj);
            }
        }, 0L, null, 96, null);
        this.pendingRoundSessionId = "";
        this.eventCounter = new AtomicLong(0L);
        this.deviceId = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.sla.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaChatController.f0(this.f26338a);
            }
        });
        this.pendingTraceId = "";
    }

    public static final void Q(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
    }

    public static final t R(SlaChatController slaChatController, String str, com.stepos.agentframework.chatcore.send.k kVar, SendContext sendContext) {
        InterfaceC5940b inputLayout;
        if (com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(slaChatController.context)) {
            slaChatController.T0(new a.Expand(str, "routeToCloud", true));
            C0919o.c("SLA", "竞速结束,放行上云", true);
            kVar.a(sendContext);
            slaChatController.W0(true);
            kotlinx.coroutines.g gVar = slaChatController.sendTimeoutJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            slaChatController.pendingArbitrateCtx = null;
            slaChatController.pendingArbitrateCb = null;
        } else {
            C0919o.c("SLA", "无网络,中止发送", true);
            H h10 = H.INSTANCE;
            Context context = slaChatController.context;
            String string = context.getString(R$string.voice_network_unavailable);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            H.k(h10, context, string, 0L, 4, null);
            boolean zN0 = slaChatController.N0(sendContext);
            String strD0 = slaChatController.d0();
            InterfaceC1848c chatView = slaChatController.sessionHandler.getChatView();
            if (chatView != null) {
                chatView.E();
            }
            slaChatController.sessionHandler.H3(strD0, true);
            if (chatView != null) {
                chatView.T();
            }
            AgentChatLayout agentChatLayout = chatView instanceof AgentChatLayout ? (AgentChatLayout) chatView : null;
            if (agentChatLayout != null && (inputLayout = agentChatLayout.getInputLayout()) != null) {
                inputLayout.setReplyingStatus(false);
            }
            slaChatController.T0(new a.RestoreInput(str, "noNetwork"));
            slaChatController.W0(zN0);
            kVar.c(sendContext);
            kotlinx.coroutines.g gVar2 = slaChatController.sendTimeoutJob;
            if (gVar2 != null) {
                kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
            }
            slaChatController.pendingArbitrateCtx = null;
            slaChatController.pendingArbitrateCb = null;
        }
        return t.f7040a;
    }

    public static final t S(SlaChatController slaChatController, String str, SlaVoiceBridge.VoiceSendBind settled) {
        kotlin.jvm.internal.p.i(settled, "settled");
        slaChatController.G0(str, settled);
        return t.f7040a;
    }

    public static final t T(SlaChatController slaChatController, String str, SlaVoiceBridge.VoiceSendBind settled) {
        kotlin.jvm.internal.p.i(settled, "settled");
        slaChatController.G0(str, settled);
        return t.f7040a;
    }

    public static final t Y(Context ctx) {
        kotlin.jvm.internal.p.i(ctx, "ctx");
        if (!com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(ctx)) {
            C4148a.k(TAG, "SLA-only proceed fallback: no network, show voice_network_unavailable", false, 4, null);
            H h10 = H.INSTANCE;
            String string = ctx.getString(R$string.voice_network_unavailable);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            H.k(h10, ctx, string, 0L, 4, null);
        }
        return t.f7040a;
    }

    public static /* synthetic */ ChatMessage a0(SlaChatController slaChatController, String str, String str2, AgentRole agentRole, String str3, long j10, List list, String str4, int i10, Object obj) {
        String str5;
        List list2 = (i10 & 32) != 0 ? null : list;
        if ((i10 & 64) != 0) {
            String lowerCase = agentRole.name().toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            str5 = "sla-" + lowerCase + O6.l.DATE_SEPARATOR + System.nanoTime();
        } else {
            str5 = str4;
        }
        return slaChatController.Z(str, str2, agentRole, str3, j10, list2, str5);
    }

    public static final t c1(SlaChatController slaChatController) {
        C4148a.k(TAG, "cloud-fail local fallback miss/reject -> keep sendFailed", false, 4, null);
        C0919o.c("SLA", "云失败本地兜底未命中", true);
        slaChatController.pendingArbitrateCtx = null;
        slaChatController.pendingUserMessageId = null;
        return t.f7040a;
    }

    public static final String f0(SlaChatController slaChatController) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Settings.Secure.getString(slaChatController.context.getContentResolver(), "android_id"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            str = "unknown";
        }
        return "clawphone-" + ((Object) str);
    }

    public static final String o0(SlaChatController slaChatController) {
        String strD0 = slaChatController.d0();
        return strD0.length() == 0 ? SessionHandler.P2(slaChatController.sessionHandler, null, 1, null) : strD0;
    }

    public static final String p0() {
        return x.INSTANCE.a();
    }

    public static final Integer q0(SlaChatController slaChatController, String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return slaChatController.c0(sessionId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w0(SlaChatController slaChatController, AgentChatLayout agentChatLayout, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.sla.m
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(SlaChatController.x0());
                }
            };
        }
        slaChatController.v0(agentChatLayout, interfaceC5063a);
    }

    public static final boolean x0() {
        return false;
    }

    public static final boolean y0(SlaChatController slaChatController) {
        return slaChatController.X0();
    }

    public static final t z0(SlaChatController slaChatController, List messageIds, String str, boolean z10) {
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
        if (z10) {
            CloudFirstPending cloudFirstPending = slaChatController.cloudFirstPending;
            if (cloudFirstPending != null && (cloudFirstPending.getMessageId().length() == 0 || messageIds.isEmpty() || messageIds.contains(cloudFirstPending.getMessageId()))) {
                slaChatController.cloudFirstPending = null;
            }
        } else {
            slaChatController.b1(messageIds);
        }
        return t.f7040a;
    }

    public final boolean A0() {
        if (SlaVoiceBridge.j(SlaVoiceBridge.INSTANCE, this.gate, SlaVoiceBridge.GateBindPriority.VOICE_ONLY, null, 4, null)) {
            X();
            return true;
        }
        C4148a.k(TAG, "installVoiceBridgeOnly skip: chat layout holds gate", false, 4, null);
        return false;
    }

    public final boolean B0(SessionHandler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        return this.sessionHandler == handler;
    }

    public final boolean C0(SlaResult result) {
        List<JSONObject> listI0 = I0(result.getExecution().getResultJson());
        List<JSONObject> list = listI0;
        if (list == null || list.isEmpty()) {
            String errorMsg = result.getExecution().getErrorMsg();
            return errorMsg != null && La.H.g0(errorMsg, NO_ATOMIC_ABILITY_CODE, false, 2, null);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listI0) {
            if (!kotlin.jvm.internal.p.d(((JSONObject) obj).optString("status"), AMapLocationStaticsEntity.SUCCESS_STATUS)) {
                arrayList.add(obj);
            }
        }
        ArrayList<String> arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((JSONObject) it.next()).optString(C3081a.ERROR_MSG));
        }
        if (!arrayList2.isEmpty()) {
            if (!arrayList2.isEmpty()) {
                for (String str : arrayList2) {
                    kotlin.jvm.internal.p.f(str);
                    if (!La.H.g0(str, NO_ATOMIC_ABILITY_CODE, false, 2, null)) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void D0(String replyText, int scene) {
        AgentChatLayout agentChatLayout;
        Object objB;
        if (La.H.x0(replyText)) {
            return;
        }
        t tVar = null;
        if (scene == 2) {
            C4148a.d(TAG, "跳转场景(sla_scene=" + scene + ")，跳过 SLA TTS 播报", false, 4, null);
            return;
        }
        if (!E.e(E.INSTANCE.a(), this.context, C.INSTANCE.b(), false, null, 12, null)) {
            C4148a.d(TAG, "语音开关关闭，跳过 SLA TTS 播报", false, 4, null);
            return;
        }
        WeakReference<AgentChatLayout> weakReference = this.chatLayoutRef;
        if (weakReference == null || (agentChatLayout = weakReference.get()) == null) {
            C4148a.h(TAG, "chatLayout 已释放，跳过 SLA TTS 播报", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            agentChatLayout.p7();
            T1 t12 = agentChatLayout.get_ttsPlayer();
            if (t12 != null) {
                t12.b(replyText, false);
                tVar = t.f7040a;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "SLA TTS 播报失败", thE, false, 8, null);
        }
    }

    public final String E0() {
        return r0() + ServerSentEventKt.COLON + this.eventCounter.incrementAndGet();
    }

    public final void F0() {
        q.INSTANCE.b(d0());
    }

    public final void G0(String traceId, SlaVoiceBridge.VoiceSendBind settled) {
        com.stepos.agentframework.chatcore.send.k kVar;
        kotlinx.coroutines.g gVar;
        if (kotlin.jvm.internal.p.d(this.pendingTraceId, traceId)) {
            boolean z10 = false;
            boolean z11 = SlaVoiceBridge.INSTANCE.p() != this.gate;
            if (z11) {
                int i10 = d.$EnumSwitchMapping$0[settled.ordinal()];
                if (i10 == 2) {
                    SendContext sendContext = this.pendingArbitrateCtx;
                    if (sendContext == null || (kVar = this.pendingArbitrateCb) == null) {
                        return;
                    } else {
                        b0(sendContext, kVar);
                    }
                } else if (i10 == 3) {
                    t0();
                } else if (i10 == 4 && (gVar = this.sendTimeoutJob) != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
            }
            if (z11 && (settled == SlaVoiceBridge.VoiceSendBind.EXEC_FAILED || settled == SlaVoiceBridge.VoiceSendBind.RESULT_PENDING)) {
                z10 = true;
            }
            if (this.pendingArbitrateCb == null || z10) {
                return;
            }
            V(15000L);
        }
    }

    public final String H0(String resultJson) {
        Object objB;
        String strOptString;
        JSONObject jSONObjectOptJSONObject;
        if (resultJson == null || La.H.x0(resultJson)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONArray jSONArrayOptJSONArray = new JSONObject(resultJson).optJSONArray("toolCallEvents");
            if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || (strOptString = jSONObjectOptJSONObject.optString("toolCallId")) == null || La.H.x0(strOptString)) {
                strOptString = null;
            }
            objB = Result.b(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final List<JSONObject> I0(String resultJson) {
        Object objB;
        ArrayList arrayList;
        if (resultJson == null || La.H.x0(resultJson)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONArray jSONArrayOptJSONArray = new JSONObject(resultJson).optJSONArray("slaActions");
            if (jSONArrayOptJSONArray == null) {
                arrayList = null;
            } else {
                C5680i c5680iS = C5685n.s(0, jSONArrayOptJSONArray.length());
                arrayList = new ArrayList();
                Iterator<Integer> it = c5680iS.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(((Z8.M) it).nextInt());
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(jSONObjectOptJSONObject);
                    }
                }
            }
            objB = Result.b(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (List) (Result.g(objB) ? null : objB);
    }

    public final JSONObject J0(String resultJson) {
        Object objB;
        if (resultJson == null || La.H.x0(resultJson)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(resultJson).optJSONObject("task"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (JSONObject) (Result.g(objB) ? null : objB);
    }

    public final String K0(String resultJson) {
        Object objB;
        JSONObject jSONObjectJ0 = J0(resultJson);
        if (jSONObjectJ0 == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String strOptString = jSONObjectJ0.optString("name");
            kotlin.jvm.internal.p.f(strOptString);
            if (La.H.x0(strOptString)) {
                strOptString = null;
            }
            objB = Result.b(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final String L0(String resultJson) {
        Object objB;
        String strOptString;
        JSONObject jSONObjectJ0 = J0(resultJson);
        if (jSONObjectJ0 == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObjectOptJSONObject = jSONObjectJ0.optJSONObject("params");
            if (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.toString()) == null) {
                strOptString = jSONObjectJ0.optString("params");
                kotlin.jvm.internal.p.f(strOptString);
                if (La.H.x0(strOptString)) {
                    strOptString = null;
                }
            }
            objB = Result.b(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject M0(java.lang.String r2) {
        /*
            r1 = this;
            r1 = 0
            if (r2 == 0) goto L57
            boolean r0 = La.H.x0(r2)
            if (r0 == 0) goto La
            goto L57
        La:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3b
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = "task"
            org.json.JSONObject r2 = r0.optJSONObject(r2)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L3d
            java.lang.String r0 = "bundle"
            org.json.JSONObject r2 = r2.optJSONObject(r0)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L3d
            java.lang.String r0 = "tool_call_response"
            java.lang.String r2 = r2.optString(r0)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L3d
            boolean r0 = La.H.x0(r2)     // Catch: java.lang.Throwable -> L3b
            if (r0 != 0) goto L32
            goto L33
        L32:
            r2 = r1
        L33:
            if (r2 == 0) goto L3d
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L3b
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L3b
            goto L3e
        L3b:
            r2 = move-exception
            goto L43
        L3d:
            r0 = r1
        L3e:
            java.lang.Object r2 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L3b
            goto L4d
        L43:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r2 = kotlin.C4849c.a(r2)
            java.lang.Object r2 = kotlin.Result.b(r2)
        L4d:
            boolean r0 = kotlin.Result.g(r2)
            if (r0 == 0) goto L54
            goto L55
        L54:
            r1 = r2
        L55:
            org.json.JSONObject r1 = (org.json.JSONObject) r1
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.M0(java.lang.String):org.json.JSONObject");
    }

    public final boolean N0(SendContext ctx) {
        String str;
        String text = ctx.getText();
        if (text == null) {
            text = "";
        }
        String string = La.H.D1(text).toString();
        String messageId = ctx.getIds().getMessageId();
        if (messageId.length() == 0) {
            messageId = this.pendingUserMessageId;
        }
        String str2 = messageId;
        SlaSessionAnchor slaAnchor = ctx.getSlaAnchor();
        String str3 = ctx.d().get("trace_id");
        String str4 = str3 == null ? "" : str3;
        String agentId = ctx.getAgentId();
        if (agentId != null) {
            if (La.H.x0(agentId)) {
                agentId = null;
            }
            str = agentId;
        } else {
            str = null;
        }
        return O0(string, str2, slaAnchor, str4, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean O0(java.lang.String r16, java.lang.String r17, com.stepos.agentframework.chatcore.send.SlaSessionAnchor r18, java.lang.String r19, java.lang.String r20) {
        /*
            r15 = this;
            java.lang.CharSequence r1 = La.H.D1(r16)
            java.lang.String r4 = r1.toString()
            int r1 = r4.length()
            r11 = 4
            java.lang.String r12 = "SlaChatController"
            r13 = 0
            r14 = 0
            if (r1 != 0) goto L1c
            java.lang.String r1 = "persistOfflineFailedUserMessage skip: empty text"
            h8.C4148a.k(r12, r1, r13, r11, r14)
            r15.pendingUserMessageId = r14
            return r13
        L1c:
            com.stepos.agentframework.chatcore.SessionHandler r1 = r15.sessionHandler
            r2 = 50
            java.lang.String r2 = La.K.R1(r4, r2)
            r3 = r18
            java.lang.String r1 = r1.u1(r2, r3)
            int r2 = r1.length()
            if (r2 != 0) goto L37
            java.lang.String r0 = "persistOfflineFailedUserMessage skip: empty sessionId"
            h8.C4148a.u(r12, r0, r13, r11, r14)
            return r13
        L37:
            if (r20 != 0) goto L48
            com.stepos.agentframework.chatcore.SessionHandler r2 = r15.sessionHandler
            com.stepos.agentframework.chatcore.Configuration r2 = r2.getConfiguration()
            com.stepos.agentframework.chatcore.session.SessionConfig r2 = r2.getSessionConfig()
            java.lang.String r2 = r2.getAgentId()
            goto L4a
        L48:
            r2 = r20
        L4a:
            if (r17 == 0) goto L5b
            int r3 = r17.length()
            if (r3 <= 0) goto L55
            r3 = r17
            goto L56
        L55:
            r3 = r14
        L56:
            if (r3 != 0) goto L59
            goto L5b
        L59:
            r8 = r3
            goto L76
        L5b:
            java.lang.String r3 = r15.pendingUserMessageId
            if (r3 != 0) goto L59
            long r5 = java.lang.System.nanoTime()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "sla-user-"
            r3.append(r7)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            goto L59
        L76:
            r15.pendingUserMessageId = r14
            com.stepos.agentframework.chatcore.session.AgentRole r3 = com.stepos.agentframework.chatcore.session.AgentRole.USER
            long r5 = java.lang.System.currentTimeMillis()
            r9 = 32
            r10 = 0
            r7 = 0
            r0 = r15
            w4.c r0 = a0(r0, r1, r2, r3, r4, r5, r7, r8, r9, r10)
            r2 = 1
            r0.Q(r2)
            r0.N(r8)
            r3 = r19
            r0.X(r3)
            java.util.List r0 = Z8.C1172u.e(r0)
            com.stepos.agentframework.chatcore.session.C1939k0.k(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "persistOfflineFailedUserMessage sessionId="
            r0.append(r3)
            r0.append(r1)
            java.lang.String r1 = " messageId="
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            h8.C4148a.k(r12, r0, r13, r11, r14)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.O0(java.lang.String, java.lang.String, com.stepos.agentframework.chatcore.send.l, java.lang.String, java.lang.String):boolean");
    }

    public final void P(String messageId, final InterfaceC5063a<t> action) {
        InterfaceC1848c chatView = this.sessionHandler.getChatView();
        AgentChatLayout agentChatLayout = chatView instanceof AgentChatLayout ? (AgentChatLayout) chatView : null;
        if (agentChatLayout == null || messageId == null || messageId.length() == 0 || !agentChatLayout.isAttachedToWindow()) {
            action.invoke();
            return;
        }
        agentChatLayout.W(C1172u.e(messageId), true);
        if (agentChatLayout.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.sla.e
            @Override // java.lang.Runnable
            public final void run() {
                SlaChatController.Q(action);
            }
        })) {
            return;
        }
        action.invoke();
    }

    public final boolean P0() {
        return C3474c.INSTANCE.a() && com.stepos.agentframework.chatcore.utils.n.INSTANCE.a(this.context);
    }

    public final boolean Q0() {
        SlaVoiceBridge slaVoiceBridge = SlaVoiceBridge.INSTANCE;
        if (!slaVoiceBridge.E(this.gate)) {
            return false;
        }
        slaVoiceBridge.l(null);
        return true;
    }

    public final void R0(String messageId, String text, SlaSessionAnchor anchor, long time) {
        if (messageId == null || messageId.length() == 0 || La.H.x0(text)) {
            return;
        }
        ChatMessage chatMessageA0 = a0(this, this.sessionHandler.u1(K.R1(text, 50), anchor), this.sessionHandler.getConfiguration().getSessionConfig().getAgentId(), AgentRole.USER, text, time, null, messageId, 32, null);
        C1939k0.k(C1172u.e(chatMessageA0));
        InterfaceC1848c chatView = this.sessionHandler.getChatView();
        if (chatView != null) {
            chatView.r(chatMessageA0);
        }
        C4148a.k(TAG, "SLA user bubble replaced with matched copy messageId=" + messageId, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object S0(java.lang.String r37, com.stepos.aiengine.algorithm.sla.SlaResult r38, java.lang.String r39, com.stepos.agentframework.chatcore.send.SlaSessionAnchor r40, e9.InterfaceC4014c<? super Y8.t> r41) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1132
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.S0(java.lang.String, com.stepos.aiengine.algorithm.sla.SlaResult, java.lang.String, com.stepos.agentframework.chatcore.send.l, e9.c):java.lang.Object");
    }

    public final void T0(a resolution) {
        String str;
        if (kotlin.jvm.internal.p.d(this.lastHalfPopupResolutionTraceId, resolution.getTraceId())) {
            C4148a.d(TAG, "resolveHalfPopup skip duplicate resolution=" + resolution, false, 4, null);
            return;
        }
        this.lastHalfPopupResolutionTraceId = resolution.getTraceId();
        C4148a.d(TAG, "resolveHalfPopup resolution=" + resolution, false, 4, null);
        if (resolution instanceof a.Expand) {
            a.Expand expand = (a.Expand) resolution;
            str = "决议=展开 reason=" + expand.getReason() + ",waitUser=" + expand.getWaitForUserMessage();
        } else if (resolution instanceof a.Close) {
            str = "决议=关闭";
        } else {
            if (!(resolution instanceof a.RestoreInput)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "决议=恢复输入 reason=" + ((a.RestoreInput) resolution).getReason();
        }
        C0919o.d("INPUT_BAR", str, false, 4, null);
        InterfaceC5074l<? super a, t> interfaceC5074l = this.onHalfPopupResolved;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(resolution);
        }
    }

    public final void U() {
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.sendTimeoutJob = C1060i.d(this.ioScope, null, null, new SlaChatController$armLockMissWaitTimeout$1(this, null), 3, null);
    }

    public final void U0(String traceId, String query, InterfaceC5063a<t> routeToBackend, String reason) {
        com.stepos.agentframework.chatcore.send.k kVar = this.pendingArbitrateCb;
        routeToBackend.invoke();
        if (kVar == null || this.pendingArbitrateCb != kVar) {
            return;
        }
        C4148a.u(TAG, "onSlaResult 失败但 routeToBackend 未收敛 pipeline reason=" + reason + " -> abandon", false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("unrouted:");
        sb2.append(reason);
        v(traceId, query, sb2.toString());
    }

    public final void V(long budgetMs) {
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.sendTimeoutJob = C1060i.d(this.ioScope, null, null, new SlaChatController$armSendTimeout$1(budgetMs, this, null), 3, null);
    }

    public final void V0(InterfaceC5074l<? super a, t> interfaceC5074l) {
        this.onHalfPopupResolved = interfaceC5074l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b7, code lost:
    
        if (r10 == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W(java.lang.String r8, com.stepos.agentframework.chatcore.send.SlaSessionAnchor r9, e9.InterfaceC4014c<? super java.lang.String> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.chat.view.sla.SlaChatController$awaitSessionPrepared$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.chat.view.sla.SlaChatController$awaitSessionPrepared$1 r0 = (com.stepos.ailauncher.chat.view.sla.SlaChatController$awaitSessionPrepared$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.view.sla.SlaChatController$awaitSessionPrepared$1 r0 = new com.stepos.ailauncher.chat.view.sla.SlaChatController$awaitSessionPrepared$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            java.lang.String r3 = ""
            r4 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L57
            if (r2 == r6) goto L44
            if (r2 != r5) goto L3c
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            com.stepos.agentframework.chatcore.send.l r7 = (com.stepos.agentframework.chatcore.send.SlaSessionAnchor) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.C4849c.b(r10)
            goto Lba
        L3c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L44:
            java.lang.Object r8 = r0.L$2
            com.stepos.ailauncher.chat.view.sla.SlaChatController r8 = (com.stepos.ailauncher.chat.view.sla.SlaChatController) r8
            java.lang.Object r8 = r0.L$1
            r9 = r8
            com.stepos.agentframework.chatcore.send.l r9 = (com.stepos.agentframework.chatcore.send.SlaSessionAnchor) r9
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L55
            goto L75
        L55:
            r10 = move-exception
            goto L81
        L57:
            kotlin.C4849c.b(r10)
            kotlin.Result$a r10 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L55
            Ua.Q<java.lang.String> r10 = r7.pendingSessionJob     // Catch: java.lang.Throwable -> L55
            if (r10 == 0) goto L78
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L55
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L55
            java.lang.Object r2 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L55
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L55
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L55
            r0.label = r6     // Catch: java.lang.Throwable -> L55
            java.lang.Object r10 = r10.a1(r0)     // Catch: java.lang.Throwable -> L55
            if (r10 != r1) goto L75
            goto Lb9
        L75:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L55
            goto L79
        L78:
            r10 = 0
        L79:
            if (r10 != 0) goto L7c
            r10 = r3
        L7c:
            java.lang.Object r10 = kotlin.Result.b(r10)     // Catch: java.lang.Throwable -> L55
            goto L8b
        L81:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.C4849c.a(r10)
            java.lang.Object r10 = kotlin.Result.b(r10)
        L8b:
            boolean r2 = kotlin.Result.g(r10)
            if (r2 == 0) goto L92
            goto L93
        L92:
            r3 = r10
        L93:
            java.lang.String r3 = (java.lang.String) r3
            int r10 = r3.length()
            if (r10 != 0) goto Lbd
            com.stepos.agentframework.chatcore.SessionHandler r10 = r7.sessionHandler
            java.lang.Object r2 = g9.h.a(r8)
            r0.L$0 = r2
            java.lang.Object r2 = g9.h.a(r9)
            r0.L$1 = r2
            java.lang.Object r2 = g9.h.a(r3)
            r0.L$2 = r2
            r0.I$0 = r4
            r0.label = r5
            java.lang.Object r10 = r7.g0(r10, r8, r9, r0)
            if (r10 != r1) goto Lba
        Lb9:
            return r1
        Lba:
            r3 = r10
            java.lang.String r3 = (java.lang.String) r3
        Lbd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.W(java.lang.String, com.stepos.agentframework.chatcore.send.l, e9.c):java.lang.Object");
    }

    public final void W0(boolean persisted) {
        String str = this.pendingRoundSessionId;
        if (str.length() == 0) {
            return;
        }
        this.pendingRoundSessionId = "";
        q.INSTANCE.c(persisted, str, this.sessionHandler);
    }

    public final void X() {
        SlaVoiceBridge.INSTANCE.l(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.sla.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SlaChatController.Y((Context) obj);
            }
        });
    }

    public final boolean X0() {
        InterfaceC5063a<Boolean> interfaceC5063a = this.suppressUserMessageProvider;
        return interfaceC5063a != null && interfaceC5063a.invoke().booleanValue();
    }

    public final void Y0(String title, SlaSessionAnchor anchor) {
        Q<String> q10 = this.pendingSessionJob;
        if (q10 != null) {
            kotlinx.coroutines.g.Y0(q10, null, 1, null);
        }
        this.pendingSessionJob = C1060i.b(this.ioScope, null, null, new SlaChatController$startSessionPrepare$1(this, title, anchor, null), 3, null);
    }

    public final ChatMessage Z(String sessionId, String agentId, AgentRole role, String text, long time, List<AgentTool> tools, String messageId) {
        ChatMessage chatMessage = new ChatMessage(messageId, sessionId, agentId, time, role, "", 0, 0, "", null, null, EReplyStatus.COMPLETED, 0, null, null, ChatHintType.NONE, false, null, null, null, 0, null, 4158976, null);
        List<AgentMessage> listS = C1173v.s(new AgentMessage(AgentMessageType.TEXT, null, new m.TextMessage(text, null, 2, null), null, false, false, 58, null));
        if (tools != null) {
            listS.add(new AgentMessage(AgentMessageType.TOOL, null, new m.TextMessage(text, null, 2, null), tools, false, true, 18, null));
        }
        chatMessage.L(listS);
        return chatMessage;
    }

    public final String Z0(String resultJson) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        Object objB;
        String strOptString2;
        JSONObject jSONObjectM0 = M0(resultJson);
        if (jSONObjectM0 == null || (jSONObjectOptJSONObject = jSONObjectM0.optJSONObject("meta")) == null || (strOptString = jSONObjectOptJSONObject.optString("appUI")) == null) {
            return null;
        }
        if (La.H.x0(strOptString)) {
            strOptString = null;
        }
        if (strOptString == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(strOptString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JSONObject jSONObject = (JSONObject) objB;
        if (jSONObject == null || (strOptString2 = jSONObject.optString("packageName")) == null || La.H.x0(strOptString2)) {
            return null;
        }
        return strOptString2;
    }

    @Override // com.stepos.ailauncher.sla.SlaGate.d
    public void a(String traceId) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        C4148a.k(TAG, "SLA lock replay started traceId=" + traceId, false, 4, null);
        C0919o.d("SLA", "解锁成功,开始重放", false, 4, null);
    }

    public final String a1(String resultJson) {
        Object objB;
        String strL0 = L0(resultJson);
        if (strL0 == null) {
            return null;
        }
        if (La.H.x0(strL0)) {
            strL0 = null;
        }
        if (strL0 == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(strL0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JSONObject jSONObject = (JSONObject) objB;
        if (jSONObject == null) {
            return null;
        }
        Iterator<T> it = TARGET_PAGE_PARAM_KEYS.iterator();
        while (it.hasNext()) {
            String strOptString = jSONObject.optString((String) it.next());
            kotlin.jvm.internal.p.f(strOptString);
            if (La.H.x0(strOptString)) {
                strOptString = null;
            }
            if (strOptString != null) {
                return strOptString;
            }
        }
        return null;
    }

    @Override // com.stepos.ailauncher.sla.SlaGate.d
    public void b(String traceId, String query, int errorCode) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(query, "query");
        C4148a.d(TAG, "SLA rejected query=" + query + " code=" + errorCode + " -> 走原通路", false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("拒绝(不可执行/执行错误 code=");
        sb2.append(errorCode);
        sb2.append(")");
        C0919o.d("SLA", sb2.toString(), false, 4, null);
    }

    public final void b0(SendContext ctx, com.stepos.agentframework.chatcore.send.k cb2) {
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        String messageId = ctx.getIds().getMessageId();
        if (messageId.length() == 0 && (messageId = this.pendingUserMessageId) == null) {
            messageId = "";
        }
        String str = this.pendingTraceId;
        if (str.length() == 0) {
            String str2 = ctx.d().get("trace_id");
            str = str2 != null ? str2 : "";
        }
        SlaVoiceBridge.INSTANCE.C(str, messageId);
        this.pendingArbitrateCtx = null;
        this.pendingArbitrateCb = null;
        this.pendingUserMessageId = null;
        C0919o.c("SLA", "命中本地执行(不上云)", true);
        C4148a.k(TAG, "voice SLA 已在其它 Gate 胜出 -> 本 pipeline 按本地已处理收敛, 不上云", false, 4, null);
        cb2.b(ctx, new LocalExecResult("", 0, null, 6, null));
        n0();
    }

    public final void b1(List<String> messageIds) {
        CloudFirstPending cloudFirstPending = this.cloudFirstPending;
        if (cloudFirstPending == null) {
            return;
        }
        if (La.H.x0(cloudFirstPending.getQuery())) {
            this.cloudFirstPending = null;
            return;
        }
        if (cloudFirstPending.getMessageId().length() > 0 && !messageIds.isEmpty() && !messageIds.contains(cloudFirstPending.getMessageId())) {
            C4148a.d(TAG, "cloud-fail fallback skip: messageId mismatch pending=" + cloudFirstPending.getMessageId() + " ack=" + messageIds, false, 4, null);
            return;
        }
        if (!SlaRouter.INSTANCE.v(this.context)) {
            C4148a.k(TAG, "cloud-fail fallback skip: SLA unavailable", false, 4, null);
            this.cloudFirstPending = null;
            return;
        }
        this.cloudFirstPending = null;
        String traceId = cloudFirstPending.getTraceId();
        if (traceId.length() == 0) {
            traceId = this.gate.M();
        }
        C4148a.k(TAG, "cloud-fail -> local SLA fallback query=" + cloudFirstPending.getQuery() + " traceId=" + traceId, false, 4, null);
        C0919o.b("SLA", "云失败本地兜底");
        this.pendingArbitrateCtx = cloudFirstPending.getCtx();
        this.pendingArbitrateCb = null;
        this.pendingUserMessageId = cloudFirstPending.getMessageId();
        this.pendingTraceId = traceId;
        C0919o.j(traceId);
        this.gate.N(cloudFirstPending.getQuery(), traceId, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.sla.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return SlaChatController.c1(this.f26335a);
            }
        });
    }

    @Override // com.stepos.ailauncher.sla.SlaGate.d
    public void c(String traceId, String query, String reason) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(reason, "reason");
        v(traceId, query, reason);
    }

    public final Integer c0(String sessionId) {
        if (sessionId.length() == 0) {
            return null;
        }
        this.pendingRoundSessionId = sessionId;
        return q.INSTANCE.a(this.sessionHandler.R1(), sessionId, this.sessionHandler);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    @Override // com.stepos.agentframework.chatcore.send.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean d(com.stepos.agentframework.chatcore.send.SendContext r8) {
        /*
            r7 = this;
            java.lang.String r7 = "ctx"
            kotlin.jvm.internal.p.i(r8, r7)
            java.lang.String r7 = r8.getAgentId()
            r0 = 0
            if (r7 == 0) goto L11
            boolean r7 = com.stepos.agentframework.adapter.agentbus.bff.j.b(r7)
            goto L12
        L11:
            r7 = r0
        L12:
            if (r7 == 0) goto L15
            return r0
        L15:
            java.lang.String r7 = r8.getText()
            if (r7 != 0) goto L1d
            java.lang.String r7 = ""
        L1d:
            int r1 = r7.length()
            r2 = 480(0x1e0, float:6.73E-43)
            r3 = 4
            java.lang.String r4 = "SlaChatController"
            r5 = 0
            if (r1 <= r2) goto L48
            int r7 = r7.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "shouldArbitrate skip: textLen="
            r8.append(r1)
            r8.append(r7)
            java.lang.String r7 = " > 480"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            h8.C4148a.k(r4, r7, r0, r3, r5)
            return r0
        L48:
            java.util.List r8 = r8.f()
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1
            r2 = 1
            if (r1 == 0) goto L5b
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L59
            goto L5b
        L59:
            r1 = r0
            goto L5c
        L5b:
            r1 = r2
        L5c:
            if (r1 != 0) goto L8b
            r1 = r8
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r6 = r1 instanceof java.util.Collection
            if (r6 == 0) goto L70
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L70
        L6e:
            r1 = r0
            goto L87
        L70:
            java.util.Iterator r1 = r1.iterator()
        L74:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L6e
            java.lang.Object r6 = r1.next()
            com.stepos.agentframework.chatcore.file.FileInfo r6 = (com.stepos.agentframework.chatcore.file.FileInfo) r6
            boolean r6 = r6.getSilent()
            if (r6 != 0) goto L74
            r1 = r2
        L87:
            if (r1 == 0) goto L8b
            r1 = r2
            goto L8c
        L8b:
            r1 = r0
        L8c:
            if (r1 == 0) goto Lb0
            if (r8 == 0) goto L99
            int r7 = r8.size()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L9a
        L99:
            r7 = r5
        L9a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "shouldArbitrate skip: user upload size="
            r8.append(r1)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            h8.C4148a.k(r4, r7, r0, r3, r5)
            return r0
        Lb0:
            int r7 = r7.length()
            if (r7 <= 0) goto Lb7
            return r2
        Lb7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.d(com.stepos.agentframework.chatcore.send.e):boolean");
    }

    public final String d0() {
        AgentSession.AgentConversation agentConversationR1 = this.sessionHandler.R1();
        String strB = agentConversationR1 != null ? agentConversationR1.B() : null;
        return strB == null ? "" : strB;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    @Override // com.stepos.agentframework.chatcore.send.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(com.stepos.agentframework.chatcore.send.SendContext r22, final com.stepos.agentframework.chatcore.send.k r23) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.e(com.stepos.agentframework.chatcore.send.e, com.stepos.agentframework.chatcore.send.k):void");
    }

    public final void e0() {
        SessionHandler.o1(this.sessionHandler, null, null, this, 3, null);
        this.chatLayoutRef = null;
        this.suppressUserMessageProvider = null;
        this.onHalfPopupResolved = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0347  */
    @Override // com.stepos.ailauncher.sla.SlaGate.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.lang.String r29, java.lang.String r30, com.stepos.aiengine.algorithm.sla.SlaResult r31, p9.InterfaceC5063a<Y8.t> r32) {
        /*
            Method dump skipped, instructions count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.f(java.lang.String, java.lang.String, com.stepos.aiengine.algorithm.sla.SlaResult, p9.a):void");
    }

    @Override // com.stepos.ailauncher.sla.SlaGate.d
    public void g(String traceId, int actionCount, long executionBudgetMs) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        long j10 = executionBudgetMs + 2000;
        C4148a.k(TAG, "onSlaMultiActionCommitted traceId=" + traceId + " actionCount=" + actionCount + " -> 发送超时 15000ms 放宽至 " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("多动作(");
        sb2.append(actionCount);
        sb2.append(")命中,发送超时放宽至 ");
        sb2.append(j10);
        sb2.append(Const.SP_KEY_GSM_UPLOAD_MXSIZE);
        C0919o.d("SLA", sb2.toString(), false, 4, null);
        V(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g0(com.stepos.agentframework.chatcore.SessionHandler r5, java.lang.String r6, com.stepos.agentframework.chatcore.send.SlaSessionAnchor r7, e9.InterfaceC4014c<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.chat.view.sla.SlaChatController$ensureSessionForSla$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.chat.view.sla.SlaChatController$ensureSessionForSla$1 r0 = (com.stepos.ailauncher.chat.view.sla.SlaChatController$ensureSessionForSla$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.view.sla.SlaChatController$ensureSessionForSla$1 r0 = new com.stepos.ailauncher.chat.view.sla.SlaChatController$ensureSessionForSla$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L46
            if (r1 != r3) goto L3e
            java.lang.Object r5 = r0.L$3
            com.stepos.agentframework.chatcore.SessionHandler r5 = (com.stepos.agentframework.chatcore.SessionHandler) r5
            java.lang.Object r5 = r0.L$2
            r7 = r5
            com.stepos.agentframework.chatcore.send.l r7 = (com.stepos.agentframework.chatcore.send.SlaSessionAnchor) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            com.stepos.agentframework.chatcore.SessionHandler r5 = (com.stepos.agentframework.chatcore.SessionHandler) r5
            kotlin.C4849c.b(r4)     // Catch: java.lang.Throwable -> L3c
            goto L62
        L3c:
            r4 = move-exception
            goto L69
        L3e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L46:
            kotlin.C4849c.b(r4)
            kotlin.Result$a r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3c
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L3c
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L3c
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r4 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L3c
            r0.L$3 = r4     // Catch: java.lang.Throwable -> L3c
            r0.I$0 = r2     // Catch: java.lang.Throwable -> L3c
            r0.label = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r4 = r5.w1(r6, r7, r0)     // Catch: java.lang.Throwable -> L3c
            if (r4 != r8) goto L62
            return r8
        L62:
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch: java.lang.Throwable -> L3c
            goto L73
        L69:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.C4849c.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L73:
            boolean r8 = kotlin.Result.g(r4)
            if (r8 == 0) goto L7b
            java.lang.String r4 = ""
        L7b:
            java.lang.String r4 = (java.lang.String) r4
            int r8 = r4.length()
            if (r8 <= 0) goto L84
            return r4
        L84:
            java.lang.String r4 = r5.u1(r6, r7)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "SLA 会话准备退回本地临时会话 sessionId="
            r5.append(r6)
            r5.append(r4)
            java.lang.String r6 = " —— 本轮若不上云则不会做 temp→real 迁移(AIOSBUG-14555)"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r6 = 4
            r7 = 0
            java.lang.String r8 = "SlaChatController"
            h8.C4148a.u(r8, r5, r2, r6, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.g0(com.stepos.agentframework.chatcore.SessionHandler, java.lang.String, com.stepos.agentframework.chatcore.send.l, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.sla.SlaGate.d
    public void h(String traceId, String query, SlaDecision decision) {
        kotlin.jvm.internal.p.i(traceId, "traceId");
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(decision, "decision");
        C4148a.k(TAG, "SLA lockMiss function=" + decision.getFunction() + " query=" + query + " -> 调起解锁接续", false, 4, null);
        String function = decision.getFunction();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("锁屏不可执行 function=");
        sb2.append(function);
        sb2.append(" -> 等待解锁重放");
        C0919o.d("SLA", sb2.toString(), false, 4, null);
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        U();
        O.INSTANCE.c(this.context, this.gate);
    }

    public final List<String> h0(String resultJson) {
        String strOptString;
        List<JSONObject> listI0 = I0(resultJson);
        if (listI0 == null) {
            if (resultJson == null) {
                resultJson = "";
            }
            return C1172u.e(resultJson);
        }
        List<String> arrayList = new ArrayList<>();
        for (JSONObject jSONObject : listI0) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
            if (jSONObjectOptJSONObject == null || (strOptString = jSONObjectOptJSONObject.toString()) == null) {
                strOptString = jSONObject.optString("result");
                kotlin.jvm.internal.p.f(strOptString);
                if (La.H.x0(strOptString) || kotlin.jvm.internal.p.d(strOptString, "null")) {
                    strOptString = null;
                }
            }
            if (strOptString != null) {
                arrayList.add(strOptString);
            }
        }
        if (arrayList.isEmpty()) {
            if (resultJson == null) {
                resultJson = "";
            }
            arrayList = C1172u.e(resultJson);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.chatcore.intent.AgentTool i0(java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.i0(java.lang.String):com.stepos.agentframework.chatcore.intent.e");
    }

    public final List<w.Action> j0(SlaResult result) {
        Map mapI;
        List<JSONObject> listI0 = I0(result.getExecution().getResultJson());
        List<JSONObject> list = listI0;
        if (list == null || list.isEmpty()) {
            SlaDecision decision = result.getDecision();
            return C1172u.e(new w.Action(decision.getFunction(), kotlin.collections.a.A(decision.getParams())));
        }
        List<JSONObject> list2 = listI0;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (JSONObject jSONObject : list2) {
            String strOptString = jSONObject.optString("function");
            kotlin.jvm.internal.p.f(strOptString);
            if (La.H.x0(strOptString)) {
                strOptString = null;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                kotlin.jvm.internal.p.h(itKeys, "keys(...)");
                Ka.j jVarH = Ka.t.h(itKeys);
                mapI = new LinkedHashMap();
                for (Object obj : jVarH) {
                    mapI.put(obj, jSONObjectOptJSONObject.optString((String) obj));
                }
            } else {
                mapI = kotlin.collections.a.i();
            }
            arrayList.add(new w.Action(strOptString, mapI));
        }
        return arrayList;
    }

    public final String k0(String resultJson) {
        String strOptString;
        JSONObject jSONObjectM0 = M0(resultJson);
        if (jSONObjectM0 == null) {
            return EXECUTED_TEXT;
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectM0.optJSONObject("meta");
        String str = null;
        if (jSONObjectOptJSONObject != null && (strOptString = jSONObjectOptJSONObject.optString("display_text")) != null) {
            if (La.H.x0(strOptString)) {
                strOptString = null;
            }
            if (strOptString != null) {
                return strOptString;
            }
        }
        String strOptString2 = jSONObjectM0.optString(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        kotlin.jvm.internal.p.f(strOptString2);
        if (La.H.x0(strOptString2)) {
            strOptString2 = null;
        }
        if (strOptString2 != null && !La.H.g0(strOptString2, MISSING_STRUCTURED_CONTENT_HINT, false, 2, null)) {
            str = strOptString2;
        }
        return str == null ? EXECUTED_TEXT : str;
    }

    public final int l0(String resultJson) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectM0 = M0(resultJson);
        if (jSONObjectM0 == null || (jSONObjectOptJSONObject = jSONObjectM0.optJSONObject("meta")) == null) {
            return -1;
        }
        return jSONObjectOptJSONObject.optInt("sla_scene", -1);
    }

    public final String m0(List<String> actionJsons, int scene, String fallbackFunction) {
        String strZ0;
        if (scene != 2) {
            return null;
        }
        Iterator<T> it = actionJsons.iterator();
        while (true) {
            if (!it.hasNext()) {
                strZ0 = null;
                break;
            }
            String str = (String) it.next();
            strZ0 = Z0(str);
            if (strZ0 == null) {
                strZ0 = a1(str);
            }
            if (strZ0 != null) {
                break;
            }
        }
        if (strZ0 != null) {
            return strZ0;
        }
        if (fallbackFunction == null || La.H.x0(fallbackFunction)) {
            return null;
        }
        return fallbackFunction;
    }

    public final void n0() {
        InterfaceC5940b inputLayout;
        InterfaceC1848c chatView = this.sessionHandler.getChatView();
        if (chatView == null) {
            return;
        }
        chatView.T();
        AgentChatLayout agentChatLayout = chatView instanceof AgentChatLayout ? (AgentChatLayout) chatView : null;
        if (agentChatLayout == null || (inputLayout = agentChatLayout.getInputLayout()) == null) {
            return;
        }
        inputLayout.setReplyingStatus(false);
    }

    public final String r0() {
        return (String) this.deviceId.getValue();
    }

    /* renamed from: s0, reason: from getter */
    public final SlaGate getGate() {
        return this.gate;
    }

    public final void t0() {
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        C4148a.k(TAG, "voice SLA 执行未成功 -> 不占本地终态, 留给回云", false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u0(java.lang.String r18, java.lang.String r19, int r20, java.util.List<com.stepos.agentframework.chatcore.intent.AgentTool> r21, com.stepos.agentframework.chatcore.send.SlaSessionAnchor r22, java.lang.String r23, long r24) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController.u0(java.lang.String, java.lang.String, int, java.util.List, com.stepos.agentframework.chatcore.send.l, java.lang.String, long):void");
    }

    public final void v(String traceId, String query, String reason) {
        kotlinx.coroutines.g gVar = this.sendTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        C4148a.k(TAG, "SLA lock replay abandoned reason=" + reason + " query=" + query, false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("锁屏重放放弃(");
        sb2.append(reason);
        sb2.append(")");
        C0919o.c("SLA", sb2.toString(), true);
        SendContext sendContext = this.pendingArbitrateCtx;
        com.stepos.agentframework.chatcore.send.k kVar = this.pendingArbitrateCb;
        this.pendingArbitrateCtx = null;
        this.pendingArbitrateCb = null;
        W0(false);
        n0();
        if (traceId.length() == 0) {
            traceId = this.pendingTraceId;
        }
        T0(new a.RestoreInput(traceId, "lockReplayAbandoned:" + reason));
        if (kVar == null || sendContext == null) {
            return;
        }
        kVar.c(sendContext);
    }

    public final void v0(AgentChatLayout chatLayout, InterfaceC5063a<Boolean> suppressUserMessage) {
        kotlin.jvm.internal.p.i(chatLayout, "chatLayout");
        kotlin.jvm.internal.p.i(suppressUserMessage, "suppressUserMessage");
        this.chatLayoutRef = new WeakReference<>(chatLayout);
        SlaVoiceBridge.INSTANCE.i(this.gate, SlaVoiceBridge.GateBindPriority.CHAT, chatLayout);
        X();
        this.suppressUserMessageProvider = suppressUserMessage;
        chatLayout.setSuppressImmediateUserBubble(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.sla.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(SlaChatController.y0(this.f26347a));
            }
        });
        this.sessionHandler.c3(this);
        this.sessionHandler.Y2(this, new p9.q() { // from class: com.stepos.ailauncher.chat.view.sla.c
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SlaChatController.z0(this.f26334a, (List) obj, (String) obj2, ((Boolean) obj3).booleanValue());
            }
        });
        q.INSTANCE.b(d0());
    }
}
