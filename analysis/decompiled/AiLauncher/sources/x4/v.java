package x4;

import La.H;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import Z8.X;
import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.search.MessageSearchProjectionKt;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.C1951q0;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.M0;
import com.stepos.agentframework.chatcore.session.PushMessageCenter;
import com.stepos.agentframework.chatcore.session.db.C0;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.db.I0;
import com.stepos.agentframework.chatcore.session.db.InterfaceC1881f;
import com.stepos.agentframework.chatcore.session.db.InterfaceC1883f1;
import com.stepos.agentframework.chatcore.session.db.InterruptedRoundRow;
import com.stepos.agentframework.chatcore.session.db.VariantGroupCount;
import com.stepos.agentframework.chatcore.session.db.W0;
import com.stepos.agentframework.chatcore.session.db.converter.AgentMessageJson;
import com.stepos.agentframework.chatcore.session.db.q1;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.agentframework.chatcore.session.list.SessionPendingActionKind;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReferenceSource;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import q4.C5151d;
import u4.AgentMessage;
import v4.C5657a;
import v9.C5685n;
import w4.ChatMessage;
import w4.ChatMessageVariant;
import w4.MessagePart;
import w4.MessageSearchProjectionEntity;
import w4.SessionPendingActionEntity;
import w4.TaskResultArtifactEntity;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 \u0088\u00012\u00020\u0001:\u0002r^B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010!J-\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0011H\u0002¢\u0006\u0004\b$\u0010%J%\u0010'\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b'\u0010(J-\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\b\b\u0002\u0010*\u001a\u00020\rH\u0002¢\u0006\u0004\b+\u0010,J\u001f\u00100\u001a\u0004\u0018\u00010\u000f*\u00020-2\b\b\u0002\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0002¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u0004\u0018\u000104*\u00020\u000fH\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b7\u00108J/\u0010=\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u00182\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070:2\b\u0010<\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b?\u0010\u001dJ\u001d\u0010@\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016¢\u0006\u0004\b@\u00103J\u001f\u0010C\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u0007H\u0016¢\u0006\u0004\bC\u0010DJ\u0019\u0010F\u001a\u0004\u0018\u00010\u000f2\u0006\u0010E\u001a\u00020\u0007H\u0016¢\u0006\u0004\bF\u0010GJ\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\bH\u0010IJ%\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ5\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010N\u001a\u00020.2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\bR\u0010GJ\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016¢\u0006\u0004\bS\u0010TJ\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u001fH\u0016¢\u0006\u0004\bW\u0010XJ\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010Y\u001a\u00020.H\u0016¢\u0006\u0004\bZ\u0010[J\u001f\u0010^\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u0007H\u0016¢\u0006\u0004\b^\u0010_J\u0015\u0010a\u001a\b\u0012\u0004\u0012\u00020`0\u0011H\u0016¢\u0006\u0004\ba\u0010TJ\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010b\u001a\u00020\u0007H\u0016¢\u0006\u0004\bc\u0010IJ\u0017\u0010e\u001a\u00020J2\u0006\u0010d\u001a\u00020JH\u0016¢\u0006\u0004\be\u0010fJ%\u0010i\u001a\u00020J2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010h\u001a\u00020\u001fH\u0016¢\u0006\u0004\bi\u0010jJ\u001f\u0010m\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00072\u0006\u0010l\u001a\u00020kH\u0016¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0007H\u0016¢\u0006\u0004\bo\u0010pJ\u0017\u0010q\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\bq\u0010pJ\u000f\u0010r\u001a\u00020\u0005H\u0016¢\u0006\u0004\br\u0010sJ'\u0010v\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020JH\u0016¢\u0006\u0004\bv\u0010wJ\u001d\u0010x\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010t\u001a\u00020\u0007H\u0016¢\u0006\u0004\bx\u0010IJ\u001f\u0010z\u001a\u00020J2\u0006\u0010t\u001a\u00020\u00072\u0006\u0010y\u001a\u00020JH\u0016¢\u0006\u0004\bz\u0010{J!\u0010~\u001a\u0004\u0018\u00010\u000f2\u0006\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020JH\u0016¢\u0006\u0004\b~\u0010\u007fR\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010\u0080\u0001R\u001d\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010\u0081\u0001R\u001f\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\b\u0010\u0081\u0001R\u0016\u0010\u0019\u001a\u00020\u00188BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u000e\u001a\u00020\r8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u0089\u0001"}, d2 = {"Lx4/v;", "Lx4/f;", "Lx4/e;", "conversationTitleRepository", "Lkotlin/Function0;", "LY8/t;", "onConversationOrderMayChange", "", "currentForegroundSessionIdProvider", "<init>", "(Lx4/e;Lp9/a;Lp9/a;)V", "Lcom/stepos/agentframework/chatcore/session/db/f;", "dao", "Lcom/stepos/agentframework/chatcore/session/db/C0;", "partDao", "Lw4/c;", "message", "", "Lw4/f;", "parts", "i0", "(Lcom/stepos/agentframework/chatcore/session/db/f;Lcom/stepos/agentframework/chatcore/session/db/C0;Lw4/c;Ljava/util/List;)V", "v0", "(Lcom/stepos/agentframework/chatcore/session/db/f;Lw4/c;)V", "Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "db", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;Lw4/c;)V", "u0", "(Lw4/c;)V", "sessionId", "", "g0", "(Ljava/lang/String;)Z", "Lu4/a;", "partSnapshot", "Q", "(Lw4/c;Ljava/util/List;)Ljava/util/List;", "msg", "d0", "(Lw4/c;Ljava/util/List;)Lw4/c;", "messages", "messagePartDao", "e0", "(Ljava/util/List;Lcom/stepos/agentframework/chatcore/session/db/C0;)Ljava/util/List;", "Lw4/d;", "", "time", "r0", "(Lw4/d;J)Lw4/c;", "X", "(Ljava/util/List;)V", "Lw4/i;", "t0", "(Lw4/c;)Lw4/i;", "h0", "(Lw4/c;)Ljava/lang/String;", "database", "", "previousRequestIds", "incoming", "j0", "(Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;Ljava/util/Set;Lw4/i;)Z", "t", "k", "newMessage", "oldMessageId", "n", "(Lw4/c;Ljava/lang/String;)V", "messageId", "v", "(Ljava/lang/String;)Lw4/c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/util/List;", "", "limit", "l", "(Ljava/lang/String;I)Ljava/util/List;", "beforeTime", "beforeMessageId", "x", "(Ljava/lang/String;JLjava/lang/String;I)Ljava/util/List;", "w", "s", "()Ljava/util/List;", "p", "(I)Ljava/util/List;", Const.INTENT_KEY_UMID, "()Z", "sinceTime", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)Ljava/util/List;", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/session/db/B0;", "c", "pairId", "m", "batchSize", "O", "(I)I", "messageIds", "failed", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Z)I", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "f", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ChatHintType;)V", "q", "(Ljava/lang/String;)V", "e", Const.INTENT_KEY_APIKEY, "()V", "groupId", "variantIndex", "u", "(Lw4/c;Ljava/lang/String;I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "currentIndex", "r", "(Ljava/lang/String;I)I", "activeMessageId", "targetVariantIndex", "o", "(Ljava/lang/String;I)Lw4/c;", "Lx4/e;", "Lp9/a;", "b0", "()Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "a0", "()Lcom/stepos/agentframework/chatcore/session/db/f;", "c0", "()Lcom/stepos/agentframework/chatcore/session/db/C0;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class v implements f {
    private static final String TAG = "MessageRepositoryImpl";
    private static volatile InterfaceC5063a<String> globalForegroundSessionIdProvider;
    private static volatile InterfaceC5074l<? super String, Boolean> hostForegroundSessionMatcher;
    private final e conversationTitleRepository;
    private final InterfaceC5063a<String> currentForegroundSessionIdProvider;
    private final InterfaceC5063a<Y8.t> onConversationOrderMayChange;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object writeLock = new Object();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lx4/v$a;", "", "<init>", "()V", "Lkotlin/Function0;", "", Const.JSON_KEY_PROVIDER, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lp9/a;)V", "Lkotlin/Function1;", "", "matcher", Const.INTENT_KEY_PKGNAME, "(Lp9/l;)V", "TAG", "Ljava/lang/String;", "writeLock", "Ljava/lang/Object;", "globalForegroundSessionIdProvider", "Lp9/a;", "hostForegroundSessionMatcher", "Lp9/l;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: x4.v$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(InterfaceC5063a<String> provider) {
            v.globalForegroundSessionIdProvider = provider;
        }

        public final void b(InterfaceC5074l<? super String, Boolean> matcher) {
            v.hostForegroundSessionMatcher = matcher;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lx4/v$b;", "", "Lw4/c;", "message", "", "Lw4/f;", "parts", "Lw4/g;", "searchProjection", "Lw4/j;", "artifactRows", "Lw4/i;", "approvalAction", "<init>", "(Lw4/c;Ljava/util/List;Lw4/g;Ljava/util/List;Lw4/i;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lw4/c;", "c", "()Lw4/c;", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "Lw4/g;", "e", "()Lw4/g;", Const.INTENT_KEY_PKGNAME, "Lw4/i;", Const.INTENT_KEY_APIKEY, "()Lw4/i;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: x4.v$b, reason: from toString */
    public static final /* data */ class PersistedMessageSnapshot {
        private final SessionPendingActionEntity approvalAction;
        private final List<TaskResultArtifactEntity> artifactRows;
        private final ChatMessage message;
        private final List<MessagePart> parts;
        private final MessageSearchProjectionEntity searchProjection;

        public PersistedMessageSnapshot(ChatMessage message, List<MessagePart> parts, MessageSearchProjectionEntity searchProjection, List<TaskResultArtifactEntity> artifactRows, SessionPendingActionEntity sessionPendingActionEntity) {
            kotlin.jvm.internal.p.i(message, "message");
            kotlin.jvm.internal.p.i(parts, "parts");
            kotlin.jvm.internal.p.i(searchProjection, "searchProjection");
            kotlin.jvm.internal.p.i(artifactRows, "artifactRows");
            this.message = message;
            this.parts = parts;
            this.searchProjection = searchProjection;
            this.artifactRows = artifactRows;
            this.approvalAction = sessionPendingActionEntity;
        }

        /* renamed from: a, reason: from getter */
        public final SessionPendingActionEntity getApprovalAction() {
            return this.approvalAction;
        }

        public final List<TaskResultArtifactEntity> b() {
            return this.artifactRows;
        }

        /* renamed from: c, reason: from getter */
        public final ChatMessage getMessage() {
            return this.message;
        }

        public final List<MessagePart> d() {
            return this.parts;
        }

        /* renamed from: e, reason: from getter */
        public final MessageSearchProjectionEntity getSearchProjection() {
            return this.searchProjection;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PersistedMessageSnapshot)) {
                return false;
            }
            PersistedMessageSnapshot persistedMessageSnapshot = (PersistedMessageSnapshot) other;
            return kotlin.jvm.internal.p.d(this.message, persistedMessageSnapshot.message) && kotlin.jvm.internal.p.d(this.parts, persistedMessageSnapshot.parts) && kotlin.jvm.internal.p.d(this.searchProjection, persistedMessageSnapshot.searchProjection) && kotlin.jvm.internal.p.d(this.artifactRows, persistedMessageSnapshot.artifactRows) && kotlin.jvm.internal.p.d(this.approvalAction, persistedMessageSnapshot.approvalAction);
        }

        public int hashCode() {
            int iHashCode = ((((((this.message.hashCode() * 31) + this.parts.hashCode()) * 31) + this.searchProjection.hashCode()) * 31) + this.artifactRows.hashCode()) * 31;
            SessionPendingActionEntity sessionPendingActionEntity = this.approvalAction;
            return iHashCode + (sessionPendingActionEntity == null ? 0 : sessionPendingActionEntity.hashCode());
        }

        public String toString() {
            return "PersistedMessageSnapshot(message=" + this.message + ", parts=" + this.parts + ", searchProjection=" + this.searchProjection + ", artifactRows=" + this.artifactRows + ", approvalAction=" + this.approvalAction + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Integer.valueOf(((MessagePart) t10).getPartIndex()), Integer.valueOf(((MessagePart) t11).getPartIndex()));
        }
    }

    public v(e conversationTitleRepository, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC5063a<String> interfaceC5063a2) {
        kotlin.jvm.internal.p.i(conversationTitleRepository, "conversationTitleRepository");
        this.conversationTitleRepository = conversationTitleRepository;
        this.onConversationOrderMayChange = interfaceC5063a;
        this.currentForegroundSessionIdProvider = interfaceC5063a2;
    }

    public static final void P(InterfaceC1881f interfaceC1881f, int i10, v vVar, C0 c02, I0 i02, Ref$IntRef ref$IntRef) {
        List<ChatMessage> listR = interfaceC1881f.r(i10);
        if (listR.isEmpty()) {
            return;
        }
        List<ChatMessage> listE0 = vVar.e0(listR, c02);
        List<ChatMessage> list = listE0;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(MessageSearchProjectionKt.p((ChatMessage) it.next(), null, 1, null));
        }
        i02.d(arrayList);
        ref$IntRef.f34818a = listE0.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List R(v vVar, ChatMessage chatMessage, List list, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            list = F.m1(chatMessage.i());
        }
        return vVar.Q(chatMessage, list);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.List] */
    public static final void S(Ref$ObjectRef ref$ObjectRef, InterfaceC1881f interfaceC1881f, I0 i02) {
        ref$ObjectRef.f34820a = interfaceC1881f.o();
        interfaceC1881f.c();
        i02.c();
    }

    public static final void U(FwkDatabase fwkDatabase, v vVar, Ref$IntRef ref$IntRef) {
        fwkDatabase.l0().a();
        fwkDatabase.p0().a();
        fwkDatabase.j0().a();
        fwkDatabase.m0().a();
        vVar.conversationTitleRepository.a();
        fwkDatabase.q0().a();
        ref$IntRef.f34818a = fwkDatabase.o0().a();
        fwkDatabase.r0().a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, w4.c] */
    public static final void V(InterfaceC1881f interfaceC1881f, String str, Ref$ObjectRef ref$ObjectRef, v vVar, Ref$BooleanRef ref$BooleanRef, FwkDatabase fwkDatabase) {
        ?? P10 = interfaceC1881f.p(str);
        ref$ObjectRef.f34820a = P10;
        String strH0 = vVar.h0(P10);
        interfaceC1881f.g(str);
        if (strH0 == null || interfaceC1881f.s(strH0) != 0) {
            return;
        }
        ref$BooleanRef.f34815a = fwkDatabase.o0().e(strH0) > 0;
    }

    public static final void W(FwkDatabase fwkDatabase, String str, Ref$BooleanRef ref$BooleanRef) {
        fwkDatabase.j0().k(str);
        fwkDatabase.m0().e(str);
        ref$BooleanRef.f34815a = fwkDatabase.o0().d(str) > 0;
    }

    public static final String Y(ChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getVariantGroupId();
    }

    public static final boolean Z(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !H.x0(it);
    }

    public static /* synthetic */ List f0(v vVar, List list, C0 c02, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            c02 = vVar.c0();
        }
        return vVar.e0(list, c02);
    }

    public static final boolean k0(SessionPendingActionEntity sessionPendingActionEntity, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !kotlin.jvm.internal.p.d(it, sessionPendingActionEntity != null ? sessionPendingActionEntity.getRequestId() : null);
    }

    public static final boolean l0(InterfaceC1881f interfaceC1881f, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return interfaceC1881f.s(it) == 0;
    }

    public static final void m0(String str, ChatMessage chatMessage, InterfaceC1881f interfaceC1881f, v vVar, C0 c02, List list, I0 i02, MessageSearchProjectionEntity messageSearchProjectionEntity, List list2, InterfaceC1883f1 interfaceC1883f1, FwkDatabase fwkDatabase, Ref$BooleanRef ref$BooleanRef, SessionPendingActionEntity sessionPendingActionEntity) {
        String strH0;
        Set setB = X.b();
        String strH02 = vVar.h0(interfaceC1881f.p(str));
        if (strH02 != null) {
            setB.add(strH02);
        }
        if (!kotlin.jvm.internal.p.d(str, chatMessage.getMessageId()) && (strH0 = vVar.h0(interfaceC1881f.p(chatMessage.getMessageId()))) != null) {
            setB.add(strH0);
        }
        Set<String> setA = X.a(setB);
        if (!H.x0(str) && !kotlin.jvm.internal.p.d(str, chatMessage.getMessageId())) {
            interfaceC1881f.g(str);
        }
        vVar.i0(interfaceC1881f, c02, chatMessage, list);
        i02.f(messageSearchProjectionEntity);
        if (!list2.isEmpty()) {
            interfaceC1883f1.d(list2);
        }
        vVar.T(fwkDatabase, chatMessage);
        ref$BooleanRef.f34815a = vVar.j0(fwkDatabase, setA, sessionPendingActionEntity);
    }

    public static final void n0(InterfaceC1881f interfaceC1881f, String str, String str2, I0 i02, q1 q1Var, FwkDatabase fwkDatabase, Ref$BooleanRef ref$BooleanRef) {
        interfaceC1881f.b(str, str2);
        i02.b(str, str2);
        q1Var.b(str, str2);
        fwkDatabase.p0().b(str, str2);
        ref$BooleanRef.f34815a = fwkDatabase.o0().b(str, str2) > 0;
    }

    public static final void o0(v vVar, InterfaceC1881f interfaceC1881f, ChatMessage chatMessage, C0 c02, List list, I0 i02, MessageSearchProjectionEntity messageSearchProjectionEntity, List list2, InterfaceC1883f1 interfaceC1883f1, FwkDatabase fwkDatabase, Ref$BooleanRef ref$BooleanRef, SessionPendingActionEntity sessionPendingActionEntity) {
        Set<String> setK = Y.k(vVar.h0(interfaceC1881f.p(chatMessage.getMessageId())));
        vVar.i0(interfaceC1881f, c02, chatMessage, list);
        i02.f(messageSearchProjectionEntity);
        if (!list2.isEmpty()) {
            interfaceC1883f1.d(list2);
        }
        vVar.T(fwkDatabase, chatMessage);
        ref$BooleanRef.f34815a = vVar.j0(fwkDatabase, setK, sessionPendingActionEntity);
    }

    public static final void p0(List list, v vVar, InterfaceC1881f interfaceC1881f, C0 c02, I0 i02, InterfaceC1883f1 interfaceC1883f1, FwkDatabase fwkDatabase, Ref$BooleanRef ref$BooleanRef) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PersistedMessageSnapshot persistedMessageSnapshot = (PersistedMessageSnapshot) it.next();
            Set<String> setK = Y.k(vVar.h0(interfaceC1881f.p(persistedMessageSnapshot.getMessage().getMessageId())));
            vVar.i0(interfaceC1881f, c02, persistedMessageSnapshot.getMessage(), persistedMessageSnapshot.d());
            i02.f(persistedMessageSnapshot.getSearchProjection());
            if (!persistedMessageSnapshot.b().isEmpty()) {
                interfaceC1883f1.d(persistedMessageSnapshot.b());
            }
            vVar.T(fwkDatabase, persistedMessageSnapshot.getMessage());
            ref$BooleanRef.f34815a = vVar.j0(fwkDatabase, setK, persistedMessageSnapshot.getApprovalAction()) || ref$BooleanRef.f34815a;
        }
    }

    public static final void q0(com.stepos.agentframework.chatcore.session.db.F f10, ChatMessage chatMessage, String str, String str2, InterfaceC1881f interfaceC1881f, int i10, v vVar, C0 c02, ChatMessage chatMessage2, List list, I0 i02, MessageSearchProjectionEntity messageSearchProjectionEntity) {
        f10.g(new ChatMessageVariant(0L, chatMessage.getMessageId(), str, chatMessage.getVariantIndex(), chatMessage.getSessionId(), str2, 0L, 65, null));
        interfaceC1881f.g(chatMessage.getMessageId());
        f10.f(str, i10);
        vVar.i0(interfaceC1881f, c02, chatMessage2, list);
        i02.f(messageSearchProjectionEntity);
    }

    public static /* synthetic */ ChatMessage s0(v vVar, ChatMessageVariant chatMessageVariant, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = chatMessageVariant.getArchivedAt();
        }
        return vVar.r0(chatMessageVariant, j10);
    }

    public int O(int batchSize) {
        int i10;
        final int iN = C5685n.n(batchSize, 1, 1000);
        synchronized (writeLock) {
            FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            final C0 c0K0 = fwkDatabaseN.k0();
            final I0 i0L0 = fwkDatabaseN.l0();
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.l
                @Override // java.lang.Runnable
                public final void run() {
                    v.P(interfaceC1881fJ0, iN, this, c0K0, i0L0, ref$IntRef);
                }
            });
            i10 = ref$IntRef.f34818a;
        }
        return i10;
    }

    public final List<MessagePart> Q(ChatMessage message, List<AgentMessage> partSnapshot) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<AgentMessage> list = partSnapshot;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            AgentMessage agentMessage = (AgentMessage) obj;
            arrayList.add(new MessagePart(message.getMessageId(), i10, agentMessage.getType().name(), AgentMessageJson.INSTANCE.c(agentMessage), jCurrentTimeMillis));
            i10 = i11;
        }
        return arrayList;
    }

    public final void T(FwkDatabase db2, ChatMessage message) {
        List<String> listX;
        List<String> listX2;
        if (message.getRole() == AgentRole.ASSISTANT && (listX = message.x()) != null && listX.isEmpty()) {
            String variantGroupId = message.getVariantGroupId();
            if (H.x0(variantGroupId)) {
                return;
            }
            com.stepos.agentframework.chatcore.session.db.F fM0 = db2.m0();
            List<ChatMessageVariant> listJ = fM0.j(variantGroupId);
            if (listJ.isEmpty()) {
                return;
            }
            int i10 = 0;
            for (ChatMessageVariant chatMessageVariant : listJ) {
                ChatMessage chatMessageS0 = s0(this, chatMessageVariant, 0L, 1, null);
                if (chatMessageS0 != null && ((listX2 = chatMessageS0.x()) == null || !listX2.isEmpty())) {
                    chatMessageS0.Y(C1173v.m());
                    String strB = C5657a.INSTANCE.b(chatMessageS0);
                    if (!H.x0(strB)) {
                        fM0.g(ChatMessageVariant.b(chatMessageVariant, 0L, null, null, 0, null, strB, 0L, 95, null));
                        i10++;
                    }
                }
            }
            if (i10 > 0) {
                C4148a.k(TAG, "cleared regenerate on archived variants group=" + variantGroupId + " count=" + i10, false, 4, null);
            }
        }
    }

    public final void X(List<ChatMessage> messages) {
        List<ChatMessage> list = messages;
        List<String> listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(F.d0(list), new InterfaceC5074l() { // from class: x4.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return v.Y((ChatMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: x4.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(v.Z((String) obj));
            }
        })));
        if (listD0.isEmpty()) {
            return;
        }
        try {
            List<VariantGroupCount> listI = b0().m0().i(listD0);
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(listI, 10)), 16));
            for (VariantGroupCount variantGroupCount : listI) {
                Pair pairA = Y8.j.a(variantGroupCount.getGroupId(), Integer.valueOf(variantGroupCount.getCount()));
                linkedHashMap.put(pairA.e(), pairA.f());
            }
            for (ChatMessage chatMessage : list) {
                if (!H.x0(chatMessage.getVariantGroupId())) {
                    Integer num = (Integer) linkedHashMap.get(chatMessage.getVariantGroupId());
                    chatMessage.Z((num != null ? num.intValue() : 0) + 1);
                }
            }
        } catch (Exception e10) {
            C4148a.g(TAG, "fillVariantCounts failed", e10, false, 8, null);
        }
    }

    @Override // x4.f
    public void a() {
        boolean z10;
        synchronized (writeLock) {
            final FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.j
                @Override // java.lang.Runnable
                public final void run() {
                    v.U(fwkDatabaseN, this, ref$IntRef);
                }
            });
            z10 = ref$IntRef.f34818a > 0;
        }
        SessionActivityTracker.INSTANCE.b();
        if (z10) {
            PushMessageCenter.INSTANCE.b0();
        }
    }

    public final InterfaceC1881f a0() {
        return b0().j0();
    }

    @Override // x4.f
    public void b(final String oldSessionId, final String newSessionId) {
        boolean z10;
        kotlin.jvm.internal.p.i(oldSessionId, "oldSessionId");
        kotlin.jvm.internal.p.i(newSessionId, "newSessionId");
        if (oldSessionId.length() == 0 || newSessionId.length() == 0 || kotlin.jvm.internal.p.d(oldSessionId, newSessionId)) {
            return;
        }
        synchronized (writeLock) {
            final FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            final I0 i0L0 = fwkDatabaseN.l0();
            final q1 q1VarQ0 = fwkDatabaseN.q0();
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.r
                @Override // java.lang.Runnable
                public final void run() {
                    v.n0(interfaceC1881fJ0, oldSessionId, newSessionId, i0L0, q1VarQ0, fwkDatabaseN, ref$BooleanRef);
                }
            });
            z10 = ref$BooleanRef.f34815a;
        }
        M0.INSTANCE.e(oldSessionId, newSessionId);
        if (z10) {
            PushMessageCenter.INSTANCE.b0();
        }
    }

    public final FwkDatabase b0() {
        return FwkDatabase.INSTANCE.n();
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.util.List] */
    @Override // x4.f
    public List<InterruptedRoundRow> c() {
        List<InterruptedRoundRow> list;
        synchronized (writeLock) {
            FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            final I0 i0L0 = fwkDatabaseN.l0();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.f34820a = C1173v.m();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.m
                @Override // java.lang.Runnable
                public final void run() {
                    v.S(ref$ObjectRef, interfaceC1881fJ0, i0L0);
                }
            });
            list = (List) ref$ObjectRef.f34820a;
        }
        return list;
    }

    public final C0 c0() {
        return b0().k0();
    }

    @Override // x4.f
    public boolean d() {
        return a0().d();
    }

    public final ChatMessage d0(ChatMessage msg, List<MessagePart> parts) {
        msg.i().clear();
        if (parts.isEmpty()) {
            msg.i().add(new AgentMessage(null, null, null, null, false, false, 63, null));
            return msg;
        }
        Iterator it = F.c1(parts, new c()).iterator();
        while (it.hasNext()) {
            msg.i().add(AgentMessageJson.INSTANCE.a(((MessagePart) it.next()).getPayloadJson()));
        }
        return msg;
    }

    @Override // x4.f
    public void e(final String sessionId) {
        boolean z10;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (H.x0(sessionId)) {
            return;
        }
        synchronized (writeLock) {
            final FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.s
                @Override // java.lang.Runnable
                public final void run() {
                    v.W(fwkDatabaseN, sessionId, ref$BooleanRef);
                }
            });
            z10 = ref$BooleanRef.f34815a;
        }
        SessionActivityTracker.INSTANCE.a(sessionId);
        if (z10) {
            PushMessageCenter.INSTANCE.b0();
        }
    }

    public final List<ChatMessage> e0(List<ChatMessage> messages, C0 messagePartDao) {
        if (messages.isEmpty()) {
            return C1173v.m();
        }
        List<ChatMessage> list = messages;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChatMessage) it.next()).getMessageId());
        }
        List<MessagePart> listM = arrayList.isEmpty() ? C1173v.m() : messagePartDao.a(arrayList);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listM) {
            String messageId = ((MessagePart) obj).getMessageId();
            Object arrayList2 = linkedHashMap.get(messageId);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(messageId, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(list, 10));
        for (ChatMessage chatMessage : list) {
            List<MessagePart> listM2 = (List) linkedHashMap.get(chatMessage.getMessageId());
            if (listM2 == null) {
                listM2 = C1173v.m();
            }
            arrayList3.add(d0(chatMessage, listM2));
        }
        X(arrayList3);
        return arrayList3;
    }

    @Override // x4.f
    public void f(String messageId, ChatHintType hint) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(hint, "hint");
        synchronized (writeLock) {
            FwkDatabase.INSTANCE.n().j0().f(messageId, hint);
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // x4.f
    public List<ChatMessage> g(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        return C1951q0.INSTANCE.k(f0(this, a0().y(sessionId), null, 2, null));
    }

    public final boolean g0(String sessionId) {
        InterfaceC5063a<String> interfaceC5063a = this.currentForegroundSessionIdProvider;
        String strInvoke = interfaceC5063a != null ? interfaceC5063a.invoke() : null;
        InterfaceC5074l<? super String, Boolean> interfaceC5074l = hostForegroundSessionMatcher;
        InterfaceC5063a<String> interfaceC5063a2 = globalForegroundSessionIdProvider;
        return w.a(sessionId, strInvoke, interfaceC5074l, interfaceC5063a2 != null ? interfaceC5063a2.invoke() : null);
    }

    @Override // x4.f
    public int h(List<String> messageIds, boolean failed) {
        int iH;
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
        if (messageIds.isEmpty()) {
            return 0;
        }
        synchronized (writeLock) {
            iH = FwkDatabase.INSTANCE.n().j0().h(messageIds, failed);
        }
        return iH;
    }

    public final String h0(ChatMessage chatMessage) {
        String approvalRequestId;
        String string;
        if (chatMessage == null || (approvalRequestId = chatMessage.getApprovalRequestId()) == null || (string = H.D1(approvalRequestId).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    @Override // x4.f
    public List<String> i(long sinceTime) {
        return a0().i(sinceTime);
    }

    public final void i0(InterfaceC1881f dao, C0 partDao, ChatMessage message, List<MessagePart> parts) {
        partDao.b(message.getMessageId());
        v0(dao, message);
        if (parts.isEmpty()) {
            return;
        }
        partDao.c(parts);
    }

    @Override // x4.f
    public List<ChatMessage> j(String groupId) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        if (H.x0(groupId)) {
            return C1173v.m();
        }
        List<ChatMessageVariant> listJ = b0().m0().j(groupId);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listJ.iterator();
        while (it.hasNext()) {
            v vVar = this;
            ChatMessage chatMessageS0 = s0(vVar, (ChatMessageVariant) it.next(), 0L, 1, null);
            if (chatMessageS0 != null) {
                arrayList.add(chatMessageS0);
            }
            this = vVar;
        }
        return arrayList;
    }

    public final boolean j0(FwkDatabase database, Set<String> previousRequestIds, SessionPendingActionEntity incoming) {
        boolean z10;
        W0 w0O0 = database.o0();
        final InterfaceC1881f interfaceC1881fJ0 = database.j0();
        SessionPendingActionEntity sessionPendingActionEntityF = incoming != null ? w0O0.f(incoming.getRequestId()) : null;
        final SessionPendingActionEntity sessionPendingActionEntityB = (incoming == null || sessionPendingActionEntityF == null) ? incoming : SessionPendingActionEntity.b(incoming, null, null, null, null, sessionPendingActionEntityF.getCreatedAt(), null, 47, null);
        Iterator it = SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.F(F.d0(previousRequestIds), new InterfaceC5074l() { // from class: x4.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(v.k0(sessionPendingActionEntityB, (String) obj));
            }
        }), new InterfaceC5074l() { // from class: x4.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(v.l0(interfaceC1881fJ0, (String) obj));
            }
        }).iterator();
        loop0: while (true) {
            z10 = false;
            while (it.hasNext()) {
                if (w0O0.e((String) it.next()) > 0 || z10) {
                    z10 = true;
                }
            }
        }
        if (sessionPendingActionEntityB == null || kotlin.jvm.internal.p.d(sessionPendingActionEntityF, sessionPendingActionEntityB)) {
            return z10;
        }
        w0O0.c(sessionPendingActionEntityB);
        return true;
    }

    @Override // x4.f
    public void k(List<ChatMessage> messages) {
        boolean z10;
        PersistedMessageSnapshot persistedMessageSnapshot;
        kotlin.jvm.internal.p.i(messages, "messages");
        if (messages.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : messages) {
            if (PushMessageCenter.INSTANCE.F((ChatMessage) obj)) {
                arrayList.add(obj);
            }
        }
        synchronized (writeLock) {
            try {
                final FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
                final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
                final C0 c0K0 = fwkDatabaseN.k0();
                final I0 i0L0 = fwkDatabaseN.l0();
                final InterfaceC1883f1 interfaceC1883f1P0 = fwkDatabaseN.p0();
                final ArrayList arrayList2 = new ArrayList();
                for (ChatMessage chatMessage : messages) {
                    ChatMessage chatMessageB = ChatMessage.b(chatMessage, null, null, null, 0L, null, null, 0, 0, null, null, null, null, 0, null, null, null, false, null, null, null, 0, null, 4194303, null);
                    chatMessageB.L(F.p1(chatMessage.i()));
                    if (H.x0(chatMessageB.getMessageId())) {
                        persistedMessageSnapshot = null;
                        C4148a.u(TAG, "skip saveAll item: blank messageId", false, 4, null);
                    } else {
                        List<AgentMessage> listM1 = F.m1(chatMessageB.i());
                        persistedMessageSnapshot = new PersistedMessageSnapshot(chatMessageB, Q(chatMessageB, listM1), MessageSearchProjectionKt.o(chatMessageB, listM1), C5151d.a(chatMessageB, listM1), t0(chatMessageB));
                    }
                    if (persistedMessageSnapshot != null) {
                        arrayList2.add(persistedMessageSnapshot);
                    }
                }
                final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                fwkDatabaseN.Q(new Runnable() { // from class: x4.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.p0(arrayList2, this, interfaceC1881fJ0, c0K0, i0L0, interfaceC1883f1P0, fwkDatabaseN, ref$BooleanRef);
                    }
                });
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    u0(((PersistedMessageSnapshot) it.next()).getMessage());
                }
                z10 = ref$BooleanRef.f34815a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            PushMessageCenter.INSTANCE.b0();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PushMessageCenter.INSTANCE.L((ChatMessage) it2.next());
        }
    }

    @Override // x4.f
    public List<ChatMessage> l(String sessionId, int limit) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0 || limit <= 0) {
            return C1173v.m();
        }
        return C1951q0.INSTANCE.k(f0(this, a0().n(sessionId, limit), null, 2, null));
    }

    @Override // x4.f
    public List<ChatMessage> m(String pairId) {
        kotlin.jvm.internal.p.i(pairId, "pairId");
        return f0(this, InterfaceC1881f.w(a0(), pairId, null, 2, null), null, 2, null);
    }

    @Override // x4.f
    public void n(ChatMessage newMessage, final String oldMessageId) {
        boolean z10;
        kotlin.jvm.internal.p.i(newMessage, "newMessage");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        if (H.x0(newMessage.getMessageId())) {
            C4148a.u(TAG, "skip replace: blank new messageId", false, 4, null);
            return;
        }
        PushMessageCenter pushMessageCenter = PushMessageCenter.INSTANCE;
        boolean zF = pushMessageCenter.F(newMessage);
        synchronized (writeLock) {
            final FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            final C0 c0K0 = fwkDatabaseN.k0();
            final I0 i0L0 = fwkDatabaseN.l0();
            final InterfaceC1883f1 interfaceC1883f1P0 = fwkDatabaseN.p0();
            final ChatMessage chatMessageB = ChatMessage.b(newMessage, null, null, null, 0L, null, null, 0, 0, null, null, null, null, 0, null, null, null, false, null, null, null, 0, null, 4194303, null);
            chatMessageB.L(F.p1(newMessage.i()));
            List<AgentMessage> listM1 = F.m1(chatMessageB.i());
            final List<MessagePart> listQ = Q(chatMessageB, listM1);
            final MessageSearchProjectionEntity messageSearchProjectionEntityO = MessageSearchProjectionKt.o(chatMessageB, listM1);
            final List<TaskResultArtifactEntity> listA = C5151d.a(chatMessageB, listM1);
            final SessionPendingActionEntity sessionPendingActionEntityT0 = t0(chatMessageB);
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.h
                @Override // java.lang.Runnable
                public final void run() {
                    v.m0(oldMessageId, chatMessageB, interfaceC1881fJ0, this, c0K0, listQ, i0L0, messageSearchProjectionEntityO, listA, interfaceC1883f1P0, fwkDatabaseN, ref$BooleanRef, sessionPendingActionEntityT0);
                }
            });
            u0(chatMessageB);
            z10 = ref$BooleanRef.f34815a;
        }
        if (z10) {
            pushMessageCenter.b0();
        }
        if (zF) {
            pushMessageCenter.L(newMessage);
        }
    }

    @Override // x4.f
    public ChatMessage o(String activeMessageId, final int targetVariantIndex) {
        List<String> listX;
        kotlin.jvm.internal.p.i(activeMessageId, "activeMessageId");
        ChatMessage chatMessage = null;
        if (H.x0(activeMessageId)) {
            return null;
        }
        synchronized (writeLock) {
            try {
                FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
                final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
                final C0 c0K0 = fwkDatabaseN.k0();
                final com.stepos.agentframework.chatcore.session.db.F fM0 = fwkDatabaseN.m0();
                final I0 i0L0 = fwkDatabaseN.l0();
                ChatMessage chatMessageP = interfaceC1881fJ0.p(activeMessageId);
                ChatMessage chatMessageD0 = chatMessageP != null ? d0(chatMessageP, c0K0.d(activeMessageId)) : null;
                if (chatMessageD0 == null) {
                    C4148a.u(TAG, "swapVariant: active message not found, id=" + activeMessageId, false, 4, null);
                } else {
                    final String variantGroupId = chatMessageD0.getVariantGroupId();
                    if (H.x0(variantGroupId)) {
                        C4148a.u(TAG, "swapVariant: active message has no variant group, id=" + activeMessageId, false, 4, null);
                    } else if (targetVariantIndex != chatMessageD0.getVariantIndex()) {
                        ChatMessageVariant chatMessageVariantK = fM0.k(variantGroupId, targetVariantIndex);
                        if (chatMessageVariantK == null) {
                            C4148a.u(TAG, "swapVariant: target not in group, index=" + targetVariantIndex + " group=" + variantGroupId, false, 4, null);
                        } else {
                            final ChatMessage chatMessage2 = chatMessageD0;
                            final ChatMessage chatMessageR0 = r0(chatMessageVariantK, chatMessage2.getTime());
                            if (chatMessageR0 == null) {
                                C4148a.h(TAG, "swapVariant: decode archived snapshot failed, index=" + targetVariantIndex, false, 4, null);
                            } else {
                                chatMessageR0.N(chatMessage2.getPairId());
                                List<String> listX2 = chatMessage2.x();
                                if ((listX2 != null && listX2.isEmpty()) || ((listX = chatMessageR0.x()) != null && listX.isEmpty())) {
                                    chatMessageR0.Y(C1173v.m());
                                    chatMessage2.Y(C1173v.m());
                                }
                                final String strB = C5657a.INSTANCE.b(chatMessage2);
                                if (H.x0(strB)) {
                                    C4148a.h(TAG, "swapVariant: encode active failed, id=" + activeMessageId, false, 4, null);
                                } else {
                                    final List listR = R(this, chatMessageR0, null, 2, null);
                                    final MessageSearchProjectionEntity messageSearchProjectionEntityO = MessageSearchProjectionKt.o(chatMessageR0, F.m1(chatMessageR0.i()));
                                    fwkDatabaseN.Q(new Runnable() { // from class: x4.k
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            v.q0(fM0, chatMessage2, variantGroupId, strB, interfaceC1881fJ0, targetVariantIndex, this, c0K0, chatMessageR0, listR, i0L0, messageSearchProjectionEntityO);
                                        }
                                    });
                                    chatMessageR0.Z(fM0.h(variantGroupId) + 1);
                                    chatMessage = chatMessageR0;
                                }
                            }
                            chatMessage = null;
                        }
                    }
                }
            } finally {
            }
        }
        return chatMessage;
    }

    @Override // x4.f
    public List<ChatMessage> p(int limit) {
        ChatMessage chatMessageT = a0().t();
        if (chatMessageT == null) {
            return C1173v.m();
        }
        String sessionId = chatMessageT.getSessionId();
        return sessionId.length() == 0 ? C1173v.m() : l(sessionId, limit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x4.f
    public void q(final String messageId) {
        boolean z10;
        kotlin.jvm.internal.p.i(messageId, "messageId");
        if (H.x0(messageId)) {
            return;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (writeLock) {
            final FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.t
                @Override // java.lang.Runnable
                public final void run() {
                    v.V(interfaceC1881fJ0, messageId, ref$ObjectRef, this, ref$BooleanRef, fwkDatabaseN);
                }
            });
            z10 = ref$BooleanRef.f34815a;
        }
        ChatMessage chatMessage = (ChatMessage) ref$ObjectRef.f34820a;
        if (chatMessage != null) {
            SessionActivityTracker.INSTANCE.m(chatMessage);
        }
        if (z10) {
            PushMessageCenter.INSTANCE.b0();
        }
    }

    @Override // x4.f
    public int r(String groupId, int currentIndex) {
        kotlin.jvm.internal.p.i(groupId, "groupId");
        if (H.x0(groupId)) {
            return currentIndex + 1;
        }
        Integer numL = b0().m0().l(groupId);
        return Math.max(numL != null ? numL.intValue() : -1, currentIndex) + 1;
    }

    public final ChatMessage r0(ChatMessageVariant chatMessageVariant, long j10) {
        return C5657a.INSTANCE.a(chatMessageVariant.getSnapshotJson(), j10, chatMessageVariant.getGroupId(), chatMessageVariant.getVariantIndex());
    }

    @Override // x4.f
    public List<ChatMessage> s() {
        ChatMessage chatMessageT = a0().t();
        if (chatMessageT == null) {
            return C1173v.m();
        }
        String sessionId = chatMessageT.getSessionId();
        if (sessionId.length() == 0) {
            return C1173v.m();
        }
        return C1951q0.INSTANCE.k(f0(this, a0().y(sessionId), null, 2, null));
    }

    @Override // x4.f
    public void t(ChatMessage message) {
        boolean z10;
        kotlin.jvm.internal.p.i(message, "message");
        if (H.x0(message.getMessageId())) {
            C4148a.u(TAG, "skip save: blank messageId", false, 4, null);
            return;
        }
        PushMessageCenter pushMessageCenter = PushMessageCenter.INSTANCE;
        boolean zF = pushMessageCenter.F(message);
        synchronized (writeLock) {
            final FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
            final InterfaceC1881f interfaceC1881fJ0 = fwkDatabaseN.j0();
            final C0 c0K0 = fwkDatabaseN.k0();
            final I0 i0L0 = fwkDatabaseN.l0();
            final InterfaceC1883f1 interfaceC1883f1P0 = fwkDatabaseN.p0();
            final ChatMessage chatMessageB = ChatMessage.b(message, null, null, null, 0L, null, null, 0, 0, null, null, null, null, 0, null, null, null, false, null, null, null, 0, null, 4194303, null);
            chatMessageB.L(F.p1(message.i()));
            List<AgentMessage> listM1 = F.m1(chatMessageB.i());
            final List<MessagePart> listQ = Q(chatMessageB, listM1);
            final MessageSearchProjectionEntity messageSearchProjectionEntityO = MessageSearchProjectionKt.o(chatMessageB, listM1);
            final List<TaskResultArtifactEntity> listA = C5151d.a(chatMessageB, listM1);
            final SessionPendingActionEntity sessionPendingActionEntityT0 = t0(chatMessageB);
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            fwkDatabaseN.Q(new Runnable() { // from class: x4.n
                @Override // java.lang.Runnable
                public final void run() {
                    v.o0(this.f43528a, interfaceC1881fJ0, chatMessageB, c0K0, listQ, i0L0, messageSearchProjectionEntityO, listA, interfaceC1883f1P0, fwkDatabaseN, ref$BooleanRef, sessionPendingActionEntityT0);
                }
            });
            u0(chatMessageB);
            z10 = ref$BooleanRef.f34815a;
        }
        if (z10) {
            pushMessageCenter.b0();
        }
        if (zF) {
            pushMessageCenter.L(message);
        }
    }

    public final SessionPendingActionEntity t0(ChatMessage chatMessage) {
        String string;
        String approvalRequestId = chatMessage.getApprovalRequestId();
        if (approvalRequestId != null && (string = H.D1(approvalRequestId).toString()) != null) {
            String str = string.length() > 0 ? string : null;
            if (str != null) {
                String string2 = H.D1(chatMessage.getSessionId()).toString();
                if (string2.length() == 0) {
                    return null;
                }
                String string3 = H.D1(chatMessage.getAgentId()).toString();
                String storageValue = SessionPendingActionKind.EXTERNAL_AGENT_AUTHORIZATION.getStorageValue();
                Long lValueOf = Long.valueOf(chatMessage.getTime());
                Long l10 = lValueOf.longValue() > 0 ? lValueOf : null;
                return new SessionPendingActionEntity(str, string2, string3, storageValue, l10 != null ? l10.longValue() : System.currentTimeMillis(), null);
            }
        }
        return null;
    }

    @Override // x4.f
    public void u(ChatMessage message, String groupId, int variantIndex) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(groupId, "groupId");
        if (H.x0(message.getMessageId()) || H.x0(groupId)) {
            C4148a.u(TAG, "skip archiveVariant: blank messageId or groupId", false, 4, null);
            return;
        }
        String strB = C5657a.INSTANCE.b(message);
        if (!H.x0(strB)) {
            synchronized (writeLock) {
                FwkDatabase.INSTANCE.n().m0().g(new ChatMessageVariant(0L, message.getMessageId(), groupId, variantIndex, message.getSessionId(), strB, 0L, 65, null));
                Y8.t tVar = Y8.t.f7040a;
            }
            return;
        }
        C4148a.h(TAG, "skip archiveVariant: encode failed, messageId=" + message.getMessageId(), false, 4, null);
    }

    public final void u0(ChatMessage message) {
        InterfaceC5063a<Y8.t> interfaceC5063a;
        String sessionId = message.getSessionId();
        if (sessionId.length() == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!(g0(sessionId) ? this.conversationTitleRepository.i(message.getAgentId(), sessionId, jCurrentTimeMillis) : this.conversationTitleRepository.u(message.getAgentId(), sessionId, jCurrentTimeMillis)) || (interfaceC5063a = this.onConversationOrderMayChange) == null) {
            return;
        }
        interfaceC5063a.invoke();
    }

    @Override // x4.f
    public ChatMessage v(String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        ChatMessage chatMessageP = a0().p(messageId);
        if (chatMessageP == null) {
            return null;
        }
        ChatMessage chatMessageD0 = d0(chatMessageP, c0().d(messageId));
        X(C1172u.e(chatMessageD0));
        return chatMessageD0;
    }

    public final void v0(InterfaceC1881f dao, ChatMessage message) {
        List<String> listX;
        List<ReferenceSource> listS;
        if (message.getRole() == AgentRole.ASSISTANT) {
            ChatMessage chatMessageP = (message.s() == null || message.x() == null) ? dao.p(message.getMessageId()) : null;
            if (message.s() == null && chatMessageP != null && (listS = chatMessageP.s()) != null) {
                message.T(listS);
            }
            if (message.x() == null && chatMessageP != null && (listX = chatMessageP.x()) != null) {
                message.Y(listX);
            }
        }
        if (dao.j(message) == 0) {
            dao.q(message);
        }
    }

    @Override // x4.f
    public ChatMessage w(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        ChatMessage chatMessageM = a0().m(sessionId);
        if (chatMessageM == null) {
            return null;
        }
        return d0(chatMessageM, c0().d(chatMessageM.getMessageId()));
    }

    @Override // x4.f
    public List<ChatMessage> x(String sessionId, long beforeTime, String beforeMessageId, int limit) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(beforeMessageId, "beforeMessageId");
        if (sessionId.length() == 0 || limit <= 0) {
            return C1173v.m();
        }
        return C1951q0.INSTANCE.k(f0(this, a0().v(sessionId, beforeTime, beforeMessageId, limit), null, 2, null));
    }

    public /* synthetic */ v(e eVar, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? new d() : eVar, (i10 & 2) != 0 ? null : interfaceC5063a, (i10 & 4) != 0 ? null : interfaceC5063a2);
    }
}
