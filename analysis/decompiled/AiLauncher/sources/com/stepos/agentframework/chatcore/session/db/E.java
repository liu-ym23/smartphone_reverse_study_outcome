package com.stepos.agentframework.chatcore.session.db;

import Z8.C1173v;
import androidx.room.AbstractC1409e;
import androidx.room.AbstractC1410f;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.RequestParameter;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.db.converter.ListConverter;
import com.stepos.agentframework.chatcore.session.db.converter.ReferenceSourceListConverter;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.core.ability.converter.BundleContentBridge;
import f1.C4031a;
import f1.C4038h;
import f1.C4039i;
import f1.C4043m;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import p9.InterfaceC5074l;
import v4.C5658b;
import w4.ChatMessage;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 a2\u00020\u0001:\u0001GB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\"J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010$J5\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010\u0011J\u0019\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b+\u0010\u0011J\u0019\u0010,\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010\u0011J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010-\u001a\u00020%H\u0016¢\u0006\u0004\b.\u0010/J\u0011\u00100\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000eH\u0016¢\u0006\u0004\b3\u00104J\u0015\u00106\u001a\b\u0012\u0004\u0012\u0002050\u0014H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b:\u00109J\u001f\u0010=\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000eH\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ%\u0010E\u001a\u00020\u000b2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010D\u001a\u00020\u0017H\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u000bH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\bH\u0016¢\u0006\u0004\bI\u0010JR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00060L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00060^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/E;", "Lcom/stepos/agentframework/chatcore/session/db/f;", "Landroidx/room/RoomDatabase;", "__db", "<init>", "(Landroidx/room/RoomDatabase;)V", "Lw4/c;", "chatMessage", "LY8/t;", "q", "(Lw4/c;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lw4/c;)I", "", "messageId", "p", "(Ljava/lang/String;)Lw4/c;", "pairId", "userRole", "", "u", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", Const.INTENT_KEY_UMID, "()Z", "sessionIds", "x", "(Ljava/util/List;)Ljava/util/List;", "limit", "r", "(I)Ljava/util/List;", "sessionId", "y", "(Ljava/lang/String;)Ljava/util/List;", "n", "(Ljava/lang/String;I)Ljava/util/List;", "", "beforeTime", "beforeMessageId", "v", "(Ljava/lang/String;JLjava/lang/String;I)Ljava/util/List;", "m", "z", "l", "sinceTime", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(J)Ljava/util/List;", "t", "()Lw4/c;", "requestId", "s", "(Ljava/lang/String;)I", "Lcom/stepos/agentframework/chatcore/session/db/B0;", "o", "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "k", "oldSessionId", "newSessionId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "f", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/ChatHintType;)V", "messageIds", "failed", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Z)I", "c", "()I", Const.INTENT_KEY_APIKEY, "()V", "Landroidx/room/RoomDatabase;", "Landroidx/room/f;", "__insertAdapterOfChatMessage", "Landroidx/room/f;", "Lv4/d;", "__roleConverter", "Lv4/d;", "Lv4/e;", "__statusConverter", "Lv4/e;", "Lcom/stepos/agentframework/chatcore/session/db/converter/ListConverter;", "__listConverter", "Lcom/stepos/agentframework/chatcore/session/db/converter/ListConverter;", "Lv4/b;", "__hintTypeConverter", "Lv4/b;", "Lcom/stepos/agentframework/chatcore/session/db/converter/ReferenceSourceListConverter;", "__referenceSourceListConverter", "Lcom/stepos/agentframework/chatcore/session/db/converter/ReferenceSourceListConverter;", "Landroidx/room/e;", "__updateAdapterOfChatMessage", "Landroidx/room/e;", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class E implements InterfaceC1881f {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RoomDatabase __db;
    private final C5658b __hintTypeConverter;
    private final AbstractC1410f<ChatMessage> __insertAdapterOfChatMessage;
    private final ListConverter __listConverter;
    private final ReferenceSourceListConverter __referenceSourceListConverter;
    private final v4.d __roleConverter;
    private final v4.e __statusConverter;
    private final AbstractC1409e<ChatMessage> __updateAdapterOfChatMessage;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/E$a", "Landroidx/room/f;", "Lw4/c;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", "f", "(Li1/d;Lw4/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC1410f<ChatMessage> {
        public a() {
        }

        @Override // androidx.room.AbstractC1410f
        public String b() {
            return "INSERT OR ABORT INTO `chat_message` (`message_id`,`session_id`,`agent_id`,`time`,`role`,`view_splite_id`,`is_like`,`is_dislike`,`server_item_id`,`pair_id`,`trace_id`,`status`,`error_code`,`error_message`,`suggestions`,`hint`,`send_failed`,`approval_request_id`,`sources`,`variant_group_id`,`variant_index`,`ui_actions`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // androidx.room.AbstractC1410f
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, ChatMessage entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getMessageId());
            statement.H(2, entity.getSessionId());
            statement.H(3, entity.getAgentId());
            statement.bindLong(4, entity.getTime());
            statement.H(5, E.this.__roleConverter.a(entity.getRole()));
            statement.H(6, entity.getViewSpliteId());
            statement.bindLong(7, entity.getIsLike());
            statement.bindLong(8, entity.getIsDisLike());
            statement.H(9, entity.getServerItemId());
            statement.H(10, entity.getPairId());
            statement.H(11, entity.getTraceId());
            statement.H(12, E.this.__statusConverter.a(entity.getStatus()));
            statement.bindLong(13, entity.getErrorCode());
            statement.H(14, entity.getErrorMessage());
            String strA = E.this.__listConverter.a(entity.u());
            if (strA == null) {
                statement.bindNull(15);
            } else {
                statement.H(15, strA);
            }
            statement.bindLong(16, E.this.__hintTypeConverter.a(entity.getHint()));
            statement.bindLong(17, entity.getSendFailed() ? 1L : 0L);
            String approvalRequestId = entity.getApprovalRequestId();
            if (approvalRequestId == null) {
                statement.bindNull(18);
            } else {
                statement.H(18, approvalRequestId);
            }
            String strA2 = E.this.__referenceSourceListConverter.a(entity.s());
            if (strA2 == null) {
                statement.bindNull(19);
            } else {
                statement.H(19, strA2);
            }
            statement.H(20, entity.getVariantGroupId());
            statement.bindLong(21, entity.getVariantIndex());
            String strA3 = E.this.__listConverter.a(entity.x());
            if (strA3 == null) {
                statement.bindNull(22);
            } else {
                statement.H(22, strA3);
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/session/db/E$b", "Landroidx/room/e;", "Lw4/c;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", Const.INTENT_KEY_UMID, "(Li1/d;Lw4/c;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC1409e<ChatMessage> {
        public b() {
        }

        @Override // androidx.room.AbstractC1409e
        public String b() {
            return "UPDATE OR ABORT `chat_message` SET `message_id` = ?,`session_id` = ?,`agent_id` = ?,`time` = ?,`role` = ?,`view_splite_id` = ?,`is_like` = ?,`is_dislike` = ?,`server_item_id` = ?,`pair_id` = ?,`trace_id` = ?,`status` = ?,`error_code` = ?,`error_message` = ?,`suggestions` = ?,`hint` = ?,`send_failed` = ?,`approval_request_id` = ?,`sources` = ?,`variant_group_id` = ?,`variant_index` = ?,`ui_actions` = ? WHERE `message_id` = ?";
        }

        @Override // androidx.room.AbstractC1409e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(InterfaceC4162d statement, ChatMessage entity) {
            kotlin.jvm.internal.p.i(statement, "statement");
            kotlin.jvm.internal.p.i(entity, "entity");
            statement.H(1, entity.getMessageId());
            statement.H(2, entity.getSessionId());
            statement.H(3, entity.getAgentId());
            statement.bindLong(4, entity.getTime());
            statement.H(5, E.this.__roleConverter.a(entity.getRole()));
            statement.H(6, entity.getViewSpliteId());
            statement.bindLong(7, entity.getIsLike());
            statement.bindLong(8, entity.getIsDisLike());
            statement.H(9, entity.getServerItemId());
            statement.H(10, entity.getPairId());
            statement.H(11, entity.getTraceId());
            statement.H(12, E.this.__statusConverter.a(entity.getStatus()));
            statement.bindLong(13, entity.getErrorCode());
            statement.H(14, entity.getErrorMessage());
            String strA = E.this.__listConverter.a(entity.u());
            if (strA == null) {
                statement.bindNull(15);
            } else {
                statement.H(15, strA);
            }
            statement.bindLong(16, E.this.__hintTypeConverter.a(entity.getHint()));
            statement.bindLong(17, entity.getSendFailed() ? 1L : 0L);
            String approvalRequestId = entity.getApprovalRequestId();
            if (approvalRequestId == null) {
                statement.bindNull(18);
            } else {
                statement.H(18, approvalRequestId);
            }
            String strA2 = E.this.__referenceSourceListConverter.a(entity.s());
            if (strA2 == null) {
                statement.bindNull(19);
            } else {
                statement.H(19, strA2);
            }
            statement.H(20, entity.getVariantGroupId());
            statement.bindLong(21, entity.getVariantIndex());
            String strA3 = E.this.__listConverter.a(entity.x());
            if (strA3 == null) {
                statement.bindNull(22);
            } else {
                statement.H(22, strA3);
            }
            statement.H(23, entity.getMessageId());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/E$c;", "", "<init>", "()V", "", "Lw9/d;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.db.E$c, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final List<InterfaceC5745d<?>> a() {
            return C1173v.m();
        }

        public Companion() {
        }
    }

    public E(RoomDatabase __db) {
        kotlin.jvm.internal.p.i(__db, "__db");
        this.__roleConverter = new v4.d();
        this.__statusConverter = new v4.e();
        this.__listConverter = new ListConverter();
        this.__hintTypeConverter = new C5658b();
        this.__referenceSourceListConverter = new ReferenceSourceListConverter();
        this.__db = __db;
        this.__insertAdapterOfChatMessage = new a();
        this.__updateAdapterOfChatMessage = new b();
    }

    public static final int c0(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.n1();
            return C4038h.b(_connection);
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final int d0(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            return interfaceC4162dQ1.n1() ? (int) interfaceC4162dQ1.getLong(0) : 0;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t e0(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t f0(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t g0(String str, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List h0(String str, long j10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, j10);
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(interfaceC4162dQ1.X0(0));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List i0(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(new InterruptedRoundRow(interfaceC4162dQ1.X0(0), interfaceC4162dQ1.X0(1), interfaceC4162dQ1.getLong(2)));
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final ChatMessage j0(String str, String str2, E e10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ChatMessage chatMessage = null;
            if (interfaceC4162dQ1.n1()) {
                chatMessage = new ChatMessage(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.getLong(iC4), e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5)), interfaceC4162dQ1.X0(iC6), (int) interfaceC4162dQ1.getLong(iC7), (int) interfaceC4162dQ1.getLong(iC8), interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.X0(iC10), interfaceC4162dQ1.X0(iC11), e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12)), (int) interfaceC4162dQ1.getLong(iC13), interfaceC4162dQ1.X0(iC14), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC15) ? null : interfaceC4162dQ1.X0(iC15)), e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(iC16)), ((int) interfaceC4162dQ1.getLong(iC17)) != 0, interfaceC4162dQ1.isNull(iC18) ? null : interfaceC4162dQ1.X0(iC18), e10.__referenceSourceListConverter.b(interfaceC4162dQ1.isNull(iC19) ? null : interfaceC4162dQ1.X0(iC19)), interfaceC4162dQ1.X0(iC20), (int) interfaceC4162dQ1.getLong(iC21), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC22) ? null : interfaceC4162dQ1.X0(iC22)));
            }
            return chatMessage;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final ChatMessage k0(String str, String str2, E e10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ChatMessage chatMessage = null;
            if (interfaceC4162dQ1.n1()) {
                chatMessage = new ChatMessage(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.getLong(iC4), e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5)), interfaceC4162dQ1.X0(iC6), (int) interfaceC4162dQ1.getLong(iC7), (int) interfaceC4162dQ1.getLong(iC8), interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.X0(iC10), interfaceC4162dQ1.X0(iC11), e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12)), (int) interfaceC4162dQ1.getLong(iC13), interfaceC4162dQ1.X0(iC14), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC15) ? null : interfaceC4162dQ1.X0(iC15)), e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(iC16)), ((int) interfaceC4162dQ1.getLong(iC17)) != 0, interfaceC4162dQ1.isNull(iC18) ? null : interfaceC4162dQ1.X0(iC18), e10.__referenceSourceListConverter.b(interfaceC4162dQ1.isNull(iC19) ? null : interfaceC4162dQ1.X0(iC19)), interfaceC4162dQ1.X0(iC20), (int) interfaceC4162dQ1.getLong(iC21), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC22) ? null : interfaceC4162dQ1.X0(iC22)));
            }
            return chatMessage;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final ChatMessage l0(String str, E e10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ChatMessage chatMessage = null;
            if (interfaceC4162dQ1.n1()) {
                chatMessage = new ChatMessage(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.getLong(iC4), e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5)), interfaceC4162dQ1.X0(iC6), (int) interfaceC4162dQ1.getLong(iC7), (int) interfaceC4162dQ1.getLong(iC8), interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.X0(iC10), interfaceC4162dQ1.X0(iC11), e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12)), (int) interfaceC4162dQ1.getLong(iC13), interfaceC4162dQ1.X0(iC14), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC15) ? null : interfaceC4162dQ1.X0(iC15)), e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(iC16)), ((int) interfaceC4162dQ1.getLong(iC17)) != 0, interfaceC4162dQ1.isNull(iC18) ? null : interfaceC4162dQ1.X0(iC18), e10.__referenceSourceListConverter.b(interfaceC4162dQ1.isNull(iC19) ? null : interfaceC4162dQ1.X0(iC19)), interfaceC4162dQ1.X0(iC20), (int) interfaceC4162dQ1.getLong(iC21), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC22) ? null : interfaceC4162dQ1.X0(iC22)));
            }
            return chatMessage;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final ChatMessage m0(String str, String str2, E e10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ChatMessage chatMessage = null;
            if (interfaceC4162dQ1.n1()) {
                chatMessage = new ChatMessage(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.getLong(iC4), e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5)), interfaceC4162dQ1.X0(iC6), (int) interfaceC4162dQ1.getLong(iC7), (int) interfaceC4162dQ1.getLong(iC8), interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.X0(iC10), interfaceC4162dQ1.X0(iC11), e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12)), (int) interfaceC4162dQ1.getLong(iC13), interfaceC4162dQ1.X0(iC14), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC15) ? null : interfaceC4162dQ1.X0(iC15)), e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(iC16)), ((int) interfaceC4162dQ1.getLong(iC17)) != 0, interfaceC4162dQ1.isNull(iC18) ? null : interfaceC4162dQ1.X0(iC18), e10.__referenceSourceListConverter.b(interfaceC4162dQ1.isNull(iC19) ? null : interfaceC4162dQ1.X0(iC19)), interfaceC4162dQ1.X0(iC20), (int) interfaceC4162dQ1.getLong(iC21), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC22) ? null : interfaceC4162dQ1.X0(iC22)));
            }
            return chatMessage;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List n0(String str, String str2, int i10, E e10, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        String strX0;
        int i11;
        String strX02;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.bindLong(2, i10);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX03 = interfaceC4162dQ1.X0(iC);
                String strX04 = interfaceC4162dQ1.X0(iC2);
                String strX05 = interfaceC4162dQ1.X0(iC3);
                long j10 = interfaceC4162dQ1.getLong(iC4);
                int i12 = iC;
                int i13 = iC2;
                AgentRole agentRoleB = e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5));
                String strX06 = interfaceC4162dQ1.X0(iC6);
                int i14 = (int) interfaceC4162dQ1.getLong(iC7);
                int i15 = (int) interfaceC4162dQ1.getLong(iC8);
                String strX07 = interfaceC4162dQ1.X0(iC9);
                String strX08 = interfaceC4162dQ1.X0(iC10);
                String strX09 = interfaceC4162dQ1.X0(iC11);
                EReplyStatus eReplyStatusB = e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12));
                int i16 = (int) interfaceC4162dQ1.getLong(iC13);
                int i17 = iC14;
                String strX010 = interfaceC4162dQ1.X0(i17);
                int i18 = iC15;
                if (interfaceC4162dQ1.isNull(i18)) {
                    iC15 = i18;
                    strX0 = null;
                } else {
                    iC15 = i18;
                    strX0 = interfaceC4162dQ1.X0(i18);
                }
                iC14 = i17;
                List<String> listB = e10.__listConverter.b(strX0);
                int i19 = iC16;
                int i20 = iC3;
                int i21 = iC4;
                ChatHintType chatHintTypeB = e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(i19));
                int i22 = iC17;
                boolean z10 = ((int) interfaceC4162dQ1.getLong(i22)) != 0;
                int i23 = iC18;
                String strX011 = interfaceC4162dQ1.isNull(i23) ? null : interfaceC4162dQ1.X0(i23);
                int i24 = iC19;
                if (interfaceC4162dQ1.isNull(i24)) {
                    i11 = i23;
                    strX02 = null;
                } else {
                    i11 = i23;
                    strX02 = interfaceC4162dQ1.X0(i24);
                }
                List<ReferenceSource> listB2 = e10.__referenceSourceListConverter.b(strX02);
                int i25 = iC20;
                int i26 = iC21;
                int i27 = iC22;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new ChatMessage(strX03, strX04, strX05, j10, agentRoleB, strX06, i14, i15, strX07, strX08, strX09, eReplyStatusB, i16, strX010, listB, chatHintTypeB, z10, strX011, listB2, interfaceC4162dQ1.X0(i25), (int) interfaceC4162dQ1.getLong(i26), e10.__listConverter.b(interfaceC4162dQ1.isNull(i27) ? null : interfaceC4162dQ1.X0(i27))));
                    int i28 = i11;
                    iC19 = i24;
                    iC18 = i28;
                    iC3 = i20;
                    iC21 = i26;
                    iC16 = i19;
                    iC17 = i22;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i12;
                    iC2 = i13;
                    iC20 = i25;
                    iC22 = i27;
                    iC4 = i21;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final ChatMessage o0(String str, String str2, E e10, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ChatMessage chatMessage = null;
            if (interfaceC4162dQ1.n1()) {
                chatMessage = new ChatMessage(interfaceC4162dQ1.X0(iC), interfaceC4162dQ1.X0(iC2), interfaceC4162dQ1.X0(iC3), interfaceC4162dQ1.getLong(iC4), e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5)), interfaceC4162dQ1.X0(iC6), (int) interfaceC4162dQ1.getLong(iC7), (int) interfaceC4162dQ1.getLong(iC8), interfaceC4162dQ1.X0(iC9), interfaceC4162dQ1.X0(iC10), interfaceC4162dQ1.X0(iC11), e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12)), (int) interfaceC4162dQ1.getLong(iC13), interfaceC4162dQ1.X0(iC14), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC15) ? null : interfaceC4162dQ1.X0(iC15)), e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(iC16)), ((int) interfaceC4162dQ1.getLong(iC17)) != 0, interfaceC4162dQ1.isNull(iC18) ? null : interfaceC4162dQ1.X0(iC18), e10.__referenceSourceListConverter.b(interfaceC4162dQ1.isNull(iC19) ? null : interfaceC4162dQ1.X0(iC19)), interfaceC4162dQ1.X0(iC20), (int) interfaceC4162dQ1.getLong(iC21), e10.__listConverter.b(interfaceC4162dQ1.isNull(iC22) ? null : interfaceC4162dQ1.X0(iC22)));
            }
            return chatMessage;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final List p0(String str, int i10, E e10, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        String strX0;
        int i11;
        String strX02;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, i10);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX03 = interfaceC4162dQ1.X0(iC);
                String strX04 = interfaceC4162dQ1.X0(iC2);
                String strX05 = interfaceC4162dQ1.X0(iC3);
                long j10 = interfaceC4162dQ1.getLong(iC4);
                int i12 = iC;
                int i13 = iC2;
                AgentRole agentRoleB = e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5));
                String strX06 = interfaceC4162dQ1.X0(iC6);
                int i14 = (int) interfaceC4162dQ1.getLong(iC7);
                int i15 = (int) interfaceC4162dQ1.getLong(iC8);
                String strX07 = interfaceC4162dQ1.X0(iC9);
                String strX08 = interfaceC4162dQ1.X0(iC10);
                String strX09 = interfaceC4162dQ1.X0(iC11);
                EReplyStatus eReplyStatusB = e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12));
                int i16 = (int) interfaceC4162dQ1.getLong(iC13);
                int i17 = iC14;
                String strX010 = interfaceC4162dQ1.X0(i17);
                int i18 = iC15;
                if (interfaceC4162dQ1.isNull(i18)) {
                    iC15 = i18;
                    strX0 = null;
                } else {
                    iC15 = i18;
                    strX0 = interfaceC4162dQ1.X0(i18);
                }
                iC14 = i17;
                List<String> listB = e10.__listConverter.b(strX0);
                int i19 = iC4;
                int i20 = iC16;
                int i21 = iC3;
                ChatHintType chatHintTypeB = e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(i20));
                int i22 = iC17;
                boolean z10 = ((int) interfaceC4162dQ1.getLong(i22)) != 0;
                int i23 = iC18;
                String strX011 = interfaceC4162dQ1.isNull(i23) ? null : interfaceC4162dQ1.X0(i23);
                int i24 = iC19;
                if (interfaceC4162dQ1.isNull(i24)) {
                    i11 = i23;
                    strX02 = null;
                } else {
                    i11 = i23;
                    strX02 = interfaceC4162dQ1.X0(i24);
                }
                List<ReferenceSource> listB2 = e10.__referenceSourceListConverter.b(strX02);
                int i25 = iC20;
                int i26 = iC21;
                int i27 = iC22;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new ChatMessage(strX03, strX04, strX05, j10, agentRoleB, strX06, i14, i15, strX07, strX08, strX09, eReplyStatusB, i16, strX010, listB, chatHintTypeB, z10, strX011, listB2, interfaceC4162dQ1.X0(i25), (int) interfaceC4162dQ1.getLong(i26), e10.__listConverter.b(interfaceC4162dQ1.isNull(i27) ? null : interfaceC4162dQ1.X0(i27))));
                    int i28 = i11;
                    iC19 = i24;
                    iC18 = i28;
                    iC21 = i26;
                    iC3 = i21;
                    iC16 = i20;
                    iC17 = i22;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i12;
                    iC2 = i13;
                    iC20 = i25;
                    iC22 = i27;
                    iC4 = i19;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final List q0(String str, String str2, String str3, E e10, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        String strX0;
        int i10;
        String strX02;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str3);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX03 = interfaceC4162dQ1.X0(iC);
                String strX04 = interfaceC4162dQ1.X0(iC2);
                String strX05 = interfaceC4162dQ1.X0(iC3);
                long j10 = interfaceC4162dQ1.getLong(iC4);
                int i11 = iC;
                int i12 = iC2;
                AgentRole agentRoleB = e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5));
                String strX06 = interfaceC4162dQ1.X0(iC6);
                int i13 = (int) interfaceC4162dQ1.getLong(iC7);
                int i14 = (int) interfaceC4162dQ1.getLong(iC8);
                String strX07 = interfaceC4162dQ1.X0(iC9);
                String strX08 = interfaceC4162dQ1.X0(iC10);
                String strX09 = interfaceC4162dQ1.X0(iC11);
                EReplyStatus eReplyStatusB = e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12));
                int i15 = (int) interfaceC4162dQ1.getLong(iC13);
                int i16 = iC14;
                String strX010 = interfaceC4162dQ1.X0(i16);
                int i17 = iC15;
                if (interfaceC4162dQ1.isNull(i17)) {
                    iC15 = i17;
                    strX0 = null;
                } else {
                    iC15 = i17;
                    strX0 = interfaceC4162dQ1.X0(i17);
                }
                iC14 = i16;
                List<String> listB = e10.__listConverter.b(strX0);
                int i18 = iC16;
                int i19 = iC3;
                int i20 = iC4;
                ChatHintType chatHintTypeB = e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(i18));
                int i21 = iC17;
                boolean z10 = ((int) interfaceC4162dQ1.getLong(i21)) != 0;
                int i22 = iC18;
                String strX011 = interfaceC4162dQ1.isNull(i22) ? null : interfaceC4162dQ1.X0(i22);
                int i23 = iC19;
                if (interfaceC4162dQ1.isNull(i23)) {
                    i10 = i22;
                    strX02 = null;
                } else {
                    i10 = i22;
                    strX02 = interfaceC4162dQ1.X0(i23);
                }
                List<ReferenceSource> listB2 = e10.__referenceSourceListConverter.b(strX02);
                int i24 = iC20;
                int i25 = iC21;
                int i26 = iC22;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new ChatMessage(strX03, strX04, strX05, j10, agentRoleB, strX06, i13, i14, strX07, strX08, strX09, eReplyStatusB, i15, strX010, listB, chatHintTypeB, z10, strX011, listB2, interfaceC4162dQ1.X0(i24), (int) interfaceC4162dQ1.getLong(i25), e10.__listConverter.b(interfaceC4162dQ1.isNull(i26) ? null : interfaceC4162dQ1.X0(i26))));
                    int i27 = i10;
                    iC19 = i23;
                    iC18 = i27;
                    iC3 = i19;
                    iC21 = i25;
                    iC16 = i18;
                    iC17 = i21;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i11;
                    iC2 = i12;
                    iC20 = i24;
                    iC22 = i26;
                    iC4 = i20;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final List r0(String str, String str2, E e10, InterfaceC4160b _connection) throws Throwable {
        InterfaceC4162d interfaceC4162d;
        String strX0;
        int i10;
        String strX02;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX03 = interfaceC4162dQ1.X0(iC);
                String strX04 = interfaceC4162dQ1.X0(iC2);
                String strX05 = interfaceC4162dQ1.X0(iC3);
                long j10 = interfaceC4162dQ1.getLong(iC4);
                int i11 = iC;
                int i12 = iC2;
                AgentRole agentRoleB = e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5));
                String strX06 = interfaceC4162dQ1.X0(iC6);
                int i13 = (int) interfaceC4162dQ1.getLong(iC7);
                int i14 = (int) interfaceC4162dQ1.getLong(iC8);
                String strX07 = interfaceC4162dQ1.X0(iC9);
                String strX08 = interfaceC4162dQ1.X0(iC10);
                String strX09 = interfaceC4162dQ1.X0(iC11);
                EReplyStatus eReplyStatusB = e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12));
                int i15 = (int) interfaceC4162dQ1.getLong(iC13);
                int i16 = iC14;
                String strX010 = interfaceC4162dQ1.X0(i16);
                int i17 = iC15;
                if (interfaceC4162dQ1.isNull(i17)) {
                    iC15 = i17;
                    strX0 = null;
                } else {
                    iC15 = i17;
                    strX0 = interfaceC4162dQ1.X0(i17);
                }
                iC14 = i16;
                List<String> listB = e10.__listConverter.b(strX0);
                int i18 = iC4;
                int i19 = iC16;
                int i20 = iC3;
                ChatHintType chatHintTypeB = e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(i19));
                int i21 = iC17;
                boolean z10 = ((int) interfaceC4162dQ1.getLong(i21)) != 0;
                int i22 = iC18;
                String strX011 = interfaceC4162dQ1.isNull(i22) ? null : interfaceC4162dQ1.X0(i22);
                int i23 = iC19;
                if (interfaceC4162dQ1.isNull(i23)) {
                    i10 = i22;
                    strX02 = null;
                } else {
                    i10 = i22;
                    strX02 = interfaceC4162dQ1.X0(i23);
                }
                List<ReferenceSource> listB2 = e10.__referenceSourceListConverter.b(strX02);
                int i24 = iC20;
                int i25 = iC21;
                int i26 = iC22;
                interfaceC4162d = interfaceC4162dQ1;
                try {
                    arrayList.add(new ChatMessage(strX03, strX04, strX05, j10, agentRoleB, strX06, i13, i14, strX07, strX08, strX09, eReplyStatusB, i15, strX010, listB, chatHintTypeB, z10, strX011, listB2, interfaceC4162dQ1.X0(i24), (int) interfaceC4162dQ1.getLong(i25), e10.__listConverter.b(interfaceC4162dQ1.isNull(i26) ? null : interfaceC4162dQ1.X0(i26))));
                    int i27 = i10;
                    iC19 = i23;
                    iC18 = i27;
                    iC21 = i25;
                    iC3 = i20;
                    iC16 = i19;
                    iC17 = i21;
                    interfaceC4162dQ1 = interfaceC4162d;
                    iC = i11;
                    iC2 = i12;
                    iC20 = i24;
                    iC22 = i26;
                    iC4 = i18;
                } catch (Throwable th) {
                    th = th;
                    interfaceC4162d.close();
                    throw th;
                }
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            interfaceC4162d = interfaceC4162dQ1;
        }
    }

    public static final List s0(String str, String str2, long j10, String str3, int i10, E e10, InterfaceC4160b _connection) {
        String strX0;
        String strX02;
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.bindLong(2, j10);
            interfaceC4162dQ1.bindLong(3, j10);
            interfaceC4162dQ1.H(4, str3);
            interfaceC4162dQ1.bindLong(5, i10);
            int iC = C4039i.c(interfaceC4162dQ1, RequestParameter.META_KEY_MESSAGE_ID);
            int iC2 = C4039i.c(interfaceC4162dQ1, "session_id");
            int iC3 = C4039i.c(interfaceC4162dQ1, "agent_id");
            int iC4 = C4039i.c(interfaceC4162dQ1, "time");
            int iC5 = C4039i.c(interfaceC4162dQ1, BundleContentBridge.KEY_ROLE);
            int iC6 = C4039i.c(interfaceC4162dQ1, "view_splite_id");
            int iC7 = C4039i.c(interfaceC4162dQ1, "is_like");
            int iC8 = C4039i.c(interfaceC4162dQ1, "is_dislike");
            int iC9 = C4039i.c(interfaceC4162dQ1, "server_item_id");
            int iC10 = C4039i.c(interfaceC4162dQ1, "pair_id");
            int iC11 = C4039i.c(interfaceC4162dQ1, "trace_id");
            int iC12 = C4039i.c(interfaceC4162dQ1, "status");
            int iC13 = C4039i.c(interfaceC4162dQ1, "error_code");
            int iC14 = C4039i.c(interfaceC4162dQ1, "error_message");
            int iC15 = C4039i.c(interfaceC4162dQ1, "suggestions");
            int iC16 = C4039i.c(interfaceC4162dQ1, "hint");
            int iC17 = C4039i.c(interfaceC4162dQ1, "send_failed");
            int iC18 = C4039i.c(interfaceC4162dQ1, kotlin.r.EXTRA_EXTERNAL_APPROVAL_REQUEST_ID);
            int iC19 = C4039i.c(interfaceC4162dQ1, SystemDeleteBroadcastReceiver.EXTRA_SOURCES);
            int iC20 = C4039i.c(interfaceC4162dQ1, "variant_group_id");
            int iC21 = C4039i.c(interfaceC4162dQ1, "variant_index");
            int iC22 = C4039i.c(interfaceC4162dQ1, "ui_actions");
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                String strX03 = interfaceC4162dQ1.X0(iC);
                String strX04 = interfaceC4162dQ1.X0(iC2);
                String strX05 = interfaceC4162dQ1.X0(iC3);
                long j11 = interfaceC4162dQ1.getLong(iC4);
                int i11 = iC;
                int i12 = iC2;
                AgentRole agentRoleB = e10.__roleConverter.b(interfaceC4162dQ1.X0(iC5));
                String strX06 = interfaceC4162dQ1.X0(iC6);
                int i13 = (int) interfaceC4162dQ1.getLong(iC7);
                int i14 = (int) interfaceC4162dQ1.getLong(iC8);
                String strX07 = interfaceC4162dQ1.X0(iC9);
                String strX08 = interfaceC4162dQ1.X0(iC10);
                String strX09 = interfaceC4162dQ1.X0(iC11);
                EReplyStatus eReplyStatusB = e10.__statusConverter.b(interfaceC4162dQ1.X0(iC12));
                int i15 = (int) interfaceC4162dQ1.getLong(iC13);
                int i16 = iC14;
                String strX010 = interfaceC4162dQ1.X0(i16);
                int i17 = iC15;
                if (interfaceC4162dQ1.isNull(i17)) {
                    iC15 = i17;
                    strX0 = null;
                } else {
                    iC15 = i17;
                    strX0 = interfaceC4162dQ1.X0(i17);
                }
                iC14 = i16;
                List<String> listB = e10.__listConverter.b(strX0);
                int i18 = iC16;
                int i19 = iC3;
                int i20 = iC4;
                ChatHintType chatHintTypeB = e10.__hintTypeConverter.b((int) interfaceC4162dQ1.getLong(i18));
                int i21 = iC17;
                boolean z10 = ((int) interfaceC4162dQ1.getLong(i21)) != 0;
                int i22 = iC18;
                String strX011 = interfaceC4162dQ1.isNull(i22) ? null : interfaceC4162dQ1.X0(i22);
                int i23 = iC19;
                if (interfaceC4162dQ1.isNull(i23)) {
                    iC18 = i22;
                    strX02 = null;
                } else {
                    iC18 = i22;
                    strX02 = interfaceC4162dQ1.X0(i23);
                }
                iC19 = i23;
                List<ReferenceSource> listB2 = e10.__referenceSourceListConverter.b(strX02);
                int i24 = iC20;
                int i25 = iC21;
                int i26 = iC22;
                arrayList.add(new ChatMessage(strX03, strX04, strX05, j11, agentRoleB, strX06, i13, i14, strX07, strX08, strX09, eReplyStatusB, i15, strX010, listB, chatHintTypeB, z10, strX011, listB2, interfaceC4162dQ1.X0(i24), (int) interfaceC4162dQ1.getLong(i25), e10.__listConverter.b(interfaceC4162dQ1.isNull(i26) ? null : interfaceC4162dQ1.X0(i26))));
                iC3 = i19;
                iC17 = i21;
                iC16 = i18;
                iC20 = i24;
                iC = i11;
                iC2 = i12;
                iC21 = i25;
                iC22 = i26;
                iC4 = i20;
            }
            return arrayList;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final boolean t0(String str, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            boolean z10 = false;
            if (interfaceC4162dQ1.n1()) {
                if (((int) interfaceC4162dQ1.getLong(0)) != 0) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            interfaceC4162dQ1.close();
        }
    }

    public static final Y8.t u0(E e10, ChatMessage chatMessage, InterfaceC4160b _connection) throws Exception {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        e10.__insertAdapterOfChatMessage.d(_connection, chatMessage);
        return Y8.t.f7040a;
    }

    public static final Y8.t v0(String str, String str2, String str3, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.H(1, str2);
            interfaceC4162dQ1.H(2, str3);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final List w0(String str, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            Iterator it = list.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            ArrayList arrayList = new ArrayList();
            while (interfaceC4162dQ1.n1()) {
                arrayList.add(interfaceC4162dQ1.X0(0));
            }
            interfaceC4162dQ1.close();
            return arrayList;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final Y8.t x0(String str, E e10, ChatHintType chatHintType, String str2, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, e10.__hintTypeConverter.a(chatHintType));
            interfaceC4162dQ1.H(2, str2);
            interfaceC4162dQ1.n1();
            interfaceC4162dQ1.close();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    public static final int y0(E e10, ChatMessage chatMessage, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        return e10.__updateAdapterOfChatMessage.c(_connection, chatMessage);
    }

    public static final int z0(String str, boolean z10, List list, InterfaceC4160b _connection) {
        kotlin.jvm.internal.p.i(_connection, "_connection");
        InterfaceC4162d interfaceC4162dQ1 = _connection.q1(str);
        try {
            interfaceC4162dQ1.bindLong(1, z10 ? 1L : 0L);
            Iterator it = list.iterator();
            int i10 = 2;
            while (it.hasNext()) {
                interfaceC4162dQ1.H(i10, (String) it.next());
                i10++;
            }
            interfaceC4162dQ1.n1();
            int iB = C4038h.b(_connection);
            interfaceC4162dQ1.close();
            return iB;
        } catch (Throwable th) {
            interfaceC4162dQ1.close();
            throw th;
        }
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public void a() {
        final String str = "delete from chat_message";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.f0(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public void b(final String oldSessionId, final String newSessionId) {
        kotlin.jvm.internal.p.i(oldSessionId, "oldSessionId");
        kotlin.jvm.internal.p.i(newSessionId, "newSessionId");
        final String str = "update chat_message set session_id = (?) where session_id = (?)";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.v0(str, newSessionId, oldSessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public int c() {
        final String str = "update chat_message set status = 'CANCELED' where role = 'ASSISTANT' and status in ('START', 'TOOL_EXECUTING', 'REPLYING')";
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(E.c0(str, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public boolean d() {
        final String str = "select exists(select 1 from chat_message)";
        return ((Boolean) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(E.t0(str, (InterfaceC4160b) obj));
            }
        })).booleanValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public void f(final String messageId, final ChatHintType hint) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(hint, "hint");
        final String str = "update chat_message set hint = (?) where message_id = (?)";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.x0(str, this, hint, messageId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public void g(final String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        final String str = "delete from chat_message where message_id = ?";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.e0(str, messageId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public int h(final List<String> messageIds, final boolean failed) {
        kotlin.jvm.internal.p.i(messageIds, "messageIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("update chat_message set send_failed = (");
        sb2.append("?");
        sb2.append(") where message_id in (");
        C4043m.a(sb2, messageIds.size());
        sb2.append(")");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(E.z0(string, failed, messageIds, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<String> i(final long sinceTime) {
        final String str = "select session_id from chat_message group by session_id having max(time) > ?";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.h0(str, sinceTime, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public int j(final ChatMessage chatMessage) {
        kotlin.jvm.internal.p.i(chatMessage, "chatMessage");
        return ((Number) C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(E.y0(this.f22714a, chatMessage, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public void k(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "delete from chat_message where session_id = (?)";
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.g0(str, sessionId, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public ChatMessage l(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "select * from chat_message where session_id = ? and role = 'ASSISTANT' and status in ('COMPLETED', 'ERROR', 'CANCELED') order by time desc, message_id desc limit 1";
        return (ChatMessage) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.m0(str, sessionId, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public ChatMessage m(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "select * from chat_message where session_id = (?) order by time desc limit 1";
        return (ChatMessage) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.j0(str, sessionId, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<ChatMessage> n(final String sessionId, final int limit) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "select * from chat_message where session_id = (?) order by time desc, message_id desc limit ?";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.n0(str, sessionId, limit, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<InterruptedRoundRow> o() {
        final String str = "select message_id as messageId, session_id as sessionId, time as time from chat_message where role = 'ASSISTANT' and status in ('START', 'TOOL_EXECUTING', 'REPLYING') order by time desc";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.i0(str, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public ChatMessage p(final String messageId) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        final String str = "select * from chat_message where message_id = (?)";
        return (ChatMessage) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.x
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.o0(str, messageId, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public void q(final ChatMessage chatMessage) {
        kotlin.jvm.internal.p.i(chatMessage, "chatMessage");
        C4031a.c(this.__db, false, true, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.A
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.u0(this.f22470a, chatMessage, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<ChatMessage> r(final int limit) {
        final String str = "SELECT m.* FROM chat_message AS m LEFT JOIN message_search_document AS d ON d.message_id = m.message_id WHERE d.message_id IS NULL ORDER BY m.time ASC LIMIT ?";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.p0(str, limit, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public int s(final String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        final String str = "select count(*) from chat_message where approval_request_id = (?)";
        return ((Number) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Integer.valueOf(E.d0(str, requestId, (InterfaceC4160b) obj));
            }
        })).intValue();
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public ChatMessage t() {
        final String str = "select * from chat_message order by time desc limit 1";
        return (ChatMessage) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.l0(str, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<ChatMessage> u(final String pairId, final String userRole) {
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(userRole, "userRole");
        final String str = "select * from chat_message where pair_id = (?) and role = (?)";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.q0(str, pairId, userRole, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<ChatMessage> v(final String sessionId, final long beforeTime, final String beforeMessageId, final int limit) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(beforeMessageId, "beforeMessageId");
        final String str = "select * from chat_message where session_id = (?) and (time < ? or (time = ? and message_id < ?)) order by time desc, message_id desc limit ?";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.s0(str, sessionId, beforeTime, beforeMessageId, limit, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<String> x(final List<String> sessionIds) {
        kotlin.jvm.internal.p.i(sessionIds, "sessionIds");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("select distinct session_id from chat_message where session_id in (");
        C4043m.a(sb2, sessionIds.size());
        sb2.append(") and role = 'USER'");
        final String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.w0(string, sessionIds, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public List<ChatMessage> y(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "select * from chat_message where session_id = (?) order by time ASC, message_id ASC";
        return (List) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.r0(str, sessionId, this, (InterfaceC4160b) obj);
            }
        });
    }

    @Override // com.stepos.agentframework.chatcore.session.db.InterfaceC1881f
    public ChatMessage z(final String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        final String str = "select * from chat_message where session_id = ? and role = 'ASSISTANT' order by time desc, message_id desc limit 1";
        return (ChatMessage) C4031a.c(this.__db, true, false, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.db.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return E.k0(str, sessionId, this, (InterfaceC4160b) obj);
            }
        });
    }
}
