package w4;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.core.ability.converter.BundleContentBridge;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.AskUserConversation;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.jvm.internal.p;
import u4.AgentMessage;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bO\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015¢\u0006\u0004\b!\u0010\"J\u0086\u0002\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010&\"\u0004\b.\u0010/R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010,\u001a\u0004\b0\u0010&\"\u0004\b1\u0010/R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010,\u001a\u0004\b2\u0010&\"\u0004\b3\u0010/R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010,\u001a\u0004\b>\u0010&\"\u0004\b?\u0010/R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010@\u001a\u0004\bA\u0010(\"\u0004\bB\u0010CR\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010@\u001a\u0004\bD\u0010(\"\u0004\bE\u0010CR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010,\u001a\u0004\bF\u0010&\"\u0004\bG\u0010/R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010,\u001a\u0004\bH\u0010&\"\u0004\bI\u0010/R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010,\u001a\u0004\bJ\u0010&\"\u0004\bK\u0010/R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010@\u001a\u0004\bQ\u0010(\"\u0004\bR\u0010CR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010,\u001a\u0004\bS\u0010&\"\u0004\b@\u0010/R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b4\u0010\\R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010,\u001a\u0004\bb\u0010&\"\u0004\bc\u0010/R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010T\u001a\u0004\bd\u0010V\"\u0004\be\u0010XR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010,\u001a\u0004\bf\u0010&\"\u0004\bg\u0010/R\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010@\u001a\u0004\bh\u0010(\"\u0004\bi\u0010CR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010T\u001a\u0004\bj\u0010V\"\u0004\bk\u0010XR(\u0010n\u001a\b\u0012\u0004\u0012\u00020m0l8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010T\u001a\u0004\bo\u0010V\"\u0004\bp\u0010XR\"\u0010q\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010,\u001a\u0004\br\u0010&\"\u0004\bs\u0010/R$\u0010u\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\"\u0010{\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b{\u00104\u001a\u0004\b|\u00106\"\u0004\b}\u00108R(\u0010~\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R%\u0010\u0084\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0005\b\u0084\u0001\u0010@\u001a\u0005\b\u0085\u0001\u0010(\"\u0004\b]\u0010C¨\u0006\u0086\u0001"}, d2 = {"Lw4/c;", "", "", "messageId", "sessionId", "agentId", "", "time", "Lcom/stepos/agentframework/chatcore/session/AgentRole;", BundleContentBridge.KEY_ROLE, "viewSpliteId", "", "isLike", "isDisLike", "serverItemId", "pairId", DidiCardProvider.KEY_TRACE_ID, "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "errorCode", "errorMessage", "", "suggestions", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "", "sendFailed", "approvalRequestId", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "variantGroupId", "variantIndex", "uiActions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/stepos/agentframework/chatcore/session/AgentRole;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;ILjava/lang/String;Ljava/util/List;Lcom/stepos/agentframework/chatcore/session/ChatHintType;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/util/List;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/stepos/agentframework/chatcore/session/AgentRole;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;ILjava/lang/String;Ljava/util/List;Lcom/stepos/agentframework/chatcore/session/ChatHintType;ZLjava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/util/List;)Lw4/c;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "M", "(Ljava/lang/String;)V", "r", ExifInterface.LATITUDE_SOUTH, "c", ExifInterface.LONGITUDE_EAST, "J", "v", "()J", ExifInterface.LONGITUDE_WEST, "(J)V", "Lcom/stepos/agentframework/chatcore/session/AgentRole;", "o", "()Lcom/stepos/agentframework/chatcore/session/AgentRole;", "setRole", "(Lcom/stepos/agentframework/chatcore/session/AgentRole;)V", "B", "c0", "I", "D", "K", "(I)V", "C", "setDisLike", "q", "R", "k", "N", "w", "X", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "t", "()Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "U", "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)V", "f", "H", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/List;", "u", "()Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/util/List;)V", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "(Lcom/stepos/agentframework/chatcore/session/ChatHintType;)V", "Z", "p", "()Z", "Q", "(Z)V", Const.INTENT_KEY_UMID, "F", "s", ExifInterface.GPS_DIRECTION_TRUE, "z", "a0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b0", "x", "Y", "", "Lu4/a;", "message", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "L", "requestSessionId", "n", "setRequestSessionId", "LK6/d;", "askUserConversation", "LK6/d;", "e", "()LK6/d;", "G", "(LK6/d;)V", "processingStartAtMs", "m", "P", "processingDurationMs", "Ljava/lang/Long;", "l", "()Ljava/lang/Long;", "O", "(Ljava/lang/Long;)V", "variantCount", "y", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.c, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ChatMessage {
    private String agentId;
    private String approvalRequestId;
    private AskUserConversation askUserConversation;
    private int errorCode;
    private String errorMessage;
    private ChatHintType hint;
    private int isDisLike;
    private int isLike;
    private List<AgentMessage> message;
    private String messageId;
    private String pairId;
    private Long processingDurationMs;
    private long processingStartAtMs;
    private String requestSessionId;
    private AgentRole role;
    private boolean sendFailed;
    private String serverItemId;
    private String sessionId;
    private List<ReferenceSource> sources;
    private EReplyStatus status;
    private List<String> suggestions;
    private long time;
    private String traceId;
    private List<String> uiActions;
    private int variantCount;
    private String variantGroupId;
    private int variantIndex;
    private String viewSpliteId;

    public ChatMessage(String messageId, String sessionId, String agentId, long j10, AgentRole role, String viewSpliteId, int i10, int i11, String serverItemId, String pairId, String traceId, EReplyStatus status, int i12, String errorMessage, List<String> list, ChatHintType hint, boolean z10, String str, List<ReferenceSource> list2, String variantGroupId, int i13, List<String> list3) {
        p.i(messageId, "messageId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(role, "role");
        p.i(viewSpliteId, "viewSpliteId");
        p.i(serverItemId, "serverItemId");
        p.i(pairId, "pairId");
        p.i(traceId, "traceId");
        p.i(status, "status");
        p.i(errorMessage, "errorMessage");
        p.i(hint, "hint");
        p.i(variantGroupId, "variantGroupId");
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.time = j10;
        this.role = role;
        this.viewSpliteId = viewSpliteId;
        this.isLike = i10;
        this.isDisLike = i11;
        this.serverItemId = serverItemId;
        this.pairId = pairId;
        this.traceId = traceId;
        this.status = status;
        this.errorCode = i12;
        this.errorMessage = errorMessage;
        this.suggestions = list;
        this.hint = hint;
        this.sendFailed = z10;
        this.approvalRequestId = str;
        this.sources = list2;
        this.variantGroupId = variantGroupId;
        this.variantIndex = i13;
        this.uiActions = list3;
        this.message = C1173v.h(new AgentMessage(null, null, null, null, false, false, 63, null));
        this.requestSessionId = "";
        this.variantCount = 1;
    }

    public static /* synthetic */ ChatMessage b(ChatMessage chatMessage, String str, String str2, String str3, long j10, AgentRole agentRole, String str4, int i10, int i11, String str5, String str6, String str7, EReplyStatus eReplyStatus, int i12, String str8, List list, ChatHintType chatHintType, boolean z10, String str9, List list2, String str10, int i13, List list3, int i14, Object obj) {
        List list4;
        int i15;
        String str11 = (i14 & 1) != 0 ? chatMessage.messageId : str;
        String str12 = (i14 & 2) != 0 ? chatMessage.sessionId : str2;
        String str13 = (i14 & 4) != 0 ? chatMessage.agentId : str3;
        long j11 = (i14 & 8) != 0 ? chatMessage.time : j10;
        AgentRole agentRole2 = (i14 & 16) != 0 ? chatMessage.role : agentRole;
        String str14 = (i14 & 32) != 0 ? chatMessage.viewSpliteId : str4;
        int i16 = (i14 & 64) != 0 ? chatMessage.isLike : i10;
        int i17 = (i14 & 128) != 0 ? chatMessage.isDisLike : i11;
        String str15 = (i14 & 256) != 0 ? chatMessage.serverItemId : str5;
        String str16 = (i14 & 512) != 0 ? chatMessage.pairId : str6;
        String str17 = (i14 & 1024) != 0 ? chatMessage.traceId : str7;
        EReplyStatus eReplyStatus2 = (i14 & 2048) != 0 ? chatMessage.status : eReplyStatus;
        int i18 = (i14 & 4096) != 0 ? chatMessage.errorCode : i12;
        String str18 = str11;
        String str19 = (i14 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? chatMessage.errorMessage : str8;
        List list5 = (i14 & 16384) != 0 ? chatMessage.suggestions : list;
        ChatHintType chatHintType2 = (i14 & 32768) != 0 ? chatMessage.hint : chatHintType;
        boolean z11 = (i14 & 65536) != 0 ? chatMessage.sendFailed : z10;
        String str20 = (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? chatMessage.approvalRequestId : str9;
        List list6 = (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? chatMessage.sources : list2;
        String str21 = (i14 & 524288) != 0 ? chatMessage.variantGroupId : str10;
        int i19 = (i14 & 1048576) != 0 ? chatMessage.variantIndex : i13;
        if ((i14 & 2097152) != 0) {
            i15 = i19;
            list4 = chatMessage.uiActions;
        } else {
            list4 = list3;
            i15 = i19;
        }
        return chatMessage.a(str18, str12, str13, j11, agentRole2, str14, i16, i17, str15, str16, str17, eReplyStatus2, i18, str19, list5, chatHintType2, z11, str20, list6, str21, i15, list4);
    }

    /* renamed from: A, reason: from getter */
    public final int getVariantIndex() {
        return this.variantIndex;
    }

    /* renamed from: B, reason: from getter */
    public final String getViewSpliteId() {
        return this.viewSpliteId;
    }

    /* renamed from: C, reason: from getter */
    public final int getIsDisLike() {
        return this.isDisLike;
    }

    /* renamed from: D, reason: from getter */
    public final int getIsLike() {
        return this.isLike;
    }

    public final void E(String str) {
        p.i(str, "<set-?>");
        this.agentId = str;
    }

    public final void F(String str) {
        this.approvalRequestId = str;
    }

    public final void G(AskUserConversation askUserConversation) {
        this.askUserConversation = askUserConversation;
    }

    public final void H(int i10) {
        this.errorCode = i10;
    }

    public final void I(String str) {
        p.i(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void J(ChatHintType chatHintType) {
        p.i(chatHintType, "<set-?>");
        this.hint = chatHintType;
    }

    public final void K(int i10) {
        this.isLike = i10;
    }

    public final void L(List<AgentMessage> list) {
        p.i(list, "<set-?>");
        this.message = list;
    }

    public final void M(String str) {
        p.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void N(String str) {
        p.i(str, "<set-?>");
        this.pairId = str;
    }

    public final void O(Long l10) {
        this.processingDurationMs = l10;
    }

    public final void P(long j10) {
        this.processingStartAtMs = j10;
    }

    public final void Q(boolean z10) {
        this.sendFailed = z10;
    }

    public final void R(String str) {
        p.i(str, "<set-?>");
        this.serverItemId = str;
    }

    public final void S(String str) {
        p.i(str, "<set-?>");
        this.sessionId = str;
    }

    public final void T(List<ReferenceSource> list) {
        this.sources = list;
    }

    public final void U(EReplyStatus eReplyStatus) {
        p.i(eReplyStatus, "<set-?>");
        this.status = eReplyStatus;
    }

    public final void V(List<String> list) {
        this.suggestions = list;
    }

    public final void W(long j10) {
        this.time = j10;
    }

    public final void X(String str) {
        p.i(str, "<set-?>");
        this.traceId = str;
    }

    public final void Y(List<String> list) {
        this.uiActions = list;
    }

    public final void Z(int i10) {
        this.variantCount = i10;
    }

    public final ChatMessage a(String messageId, String sessionId, String agentId, long time, AgentRole role, String viewSpliteId, int isLike, int isDisLike, String serverItemId, String pairId, String traceId, EReplyStatus status, int errorCode, String errorMessage, List<String> suggestions, ChatHintType hint, boolean sendFailed, String approvalRequestId, List<ReferenceSource> sources, String variantGroupId, int variantIndex, List<String> uiActions) {
        p.i(messageId, "messageId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(role, "role");
        p.i(viewSpliteId, "viewSpliteId");
        p.i(serverItemId, "serverItemId");
        p.i(pairId, "pairId");
        p.i(traceId, "traceId");
        p.i(status, "status");
        p.i(errorMessage, "errorMessage");
        p.i(hint, "hint");
        p.i(variantGroupId, "variantGroupId");
        return new ChatMessage(messageId, sessionId, agentId, time, role, viewSpliteId, isLike, isDisLike, serverItemId, pairId, traceId, status, errorCode, errorMessage, suggestions, hint, sendFailed, approvalRequestId, sources, variantGroupId, variantIndex, uiActions);
    }

    public final void a0(String str) {
        p.i(str, "<set-?>");
        this.variantGroupId = str;
    }

    public final void b0(int i10) {
        this.variantIndex = i10;
    }

    /* renamed from: c, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    public final void c0(String str) {
        p.i(str, "<set-?>");
        this.viewSpliteId = str;
    }

    /* renamed from: d, reason: from getter */
    public final String getApprovalRequestId() {
        return this.approvalRequestId;
    }

    /* renamed from: e, reason: from getter */
    public final AskUserConversation getAskUserConversation() {
        return this.askUserConversation;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatMessage)) {
            return false;
        }
        ChatMessage chatMessage = (ChatMessage) other;
        return p.d(this.messageId, chatMessage.messageId) && p.d(this.sessionId, chatMessage.sessionId) && p.d(this.agentId, chatMessage.agentId) && this.time == chatMessage.time && this.role == chatMessage.role && p.d(this.viewSpliteId, chatMessage.viewSpliteId) && this.isLike == chatMessage.isLike && this.isDisLike == chatMessage.isDisLike && p.d(this.serverItemId, chatMessage.serverItemId) && p.d(this.pairId, chatMessage.pairId) && p.d(this.traceId, chatMessage.traceId) && this.status == chatMessage.status && this.errorCode == chatMessage.errorCode && p.d(this.errorMessage, chatMessage.errorMessage) && p.d(this.suggestions, chatMessage.suggestions) && this.hint == chatMessage.hint && this.sendFailed == chatMessage.sendFailed && p.d(this.approvalRequestId, chatMessage.approvalRequestId) && p.d(this.sources, chatMessage.sources) && p.d(this.variantGroupId, chatMessage.variantGroupId) && this.variantIndex == chatMessage.variantIndex && p.d(this.uiActions, chatMessage.uiActions);
    }

    /* renamed from: f, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: g, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: h, reason: from getter */
    public final ChatHintType getHint() {
        return this.hint;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((this.messageId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + Long.hashCode(this.time)) * 31) + this.role.hashCode()) * 31) + this.viewSpliteId.hashCode()) * 31) + Integer.hashCode(this.isLike)) * 31) + Integer.hashCode(this.isDisLike)) * 31) + this.serverItemId.hashCode()) * 31) + this.pairId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.errorCode)) * 31) + this.errorMessage.hashCode()) * 31;
        List<String> list = this.suggestions;
        int iHashCode2 = (((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.hint.hashCode()) * 31) + Boolean.hashCode(this.sendFailed)) * 31;
        String str = this.approvalRequestId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<ReferenceSource> list2 = this.sources;
        int iHashCode4 = (((((iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.variantGroupId.hashCode()) * 31) + Integer.hashCode(this.variantIndex)) * 31;
        List<String> list3 = this.uiActions;
        return iHashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public final List<AgentMessage> i() {
        return this.message;
    }

    /* renamed from: j, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: k, reason: from getter */
    public final String getPairId() {
        return this.pairId;
    }

    /* renamed from: l, reason: from getter */
    public final Long getProcessingDurationMs() {
        return this.processingDurationMs;
    }

    /* renamed from: m, reason: from getter */
    public final long getProcessingStartAtMs() {
        return this.processingStartAtMs;
    }

    /* renamed from: n, reason: from getter */
    public final String getRequestSessionId() {
        return this.requestSessionId;
    }

    /* renamed from: o, reason: from getter */
    public final AgentRole getRole() {
        return this.role;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getSendFailed() {
        return this.sendFailed;
    }

    /* renamed from: q, reason: from getter */
    public final String getServerItemId() {
        return this.serverItemId;
    }

    /* renamed from: r, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<ReferenceSource> s() {
        return this.sources;
    }

    /* renamed from: t, reason: from getter */
    public final EReplyStatus getStatus() {
        return this.status;
    }

    public String toString() {
        return "ChatMessage(messageId=" + this.messageId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", time=" + this.time + ", role=" + this.role + ", viewSpliteId=" + this.viewSpliteId + ", isLike=" + this.isLike + ", isDisLike=" + this.isDisLike + ", serverItemId=" + this.serverItemId + ", pairId=" + this.pairId + ", traceId=" + this.traceId + ", status=" + this.status + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", suggestions=" + this.suggestions + ", hint=" + this.hint + ", sendFailed=" + this.sendFailed + ", approvalRequestId=" + this.approvalRequestId + ", sources=" + this.sources + ", variantGroupId=" + this.variantGroupId + ", variantIndex=" + this.variantIndex + ", uiActions=" + this.uiActions + ")";
    }

    public final List<String> u() {
        return this.suggestions;
    }

    /* renamed from: v, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: w, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final List<String> x() {
        return this.uiActions;
    }

    /* renamed from: y, reason: from getter */
    public final int getVariantCount() {
        return this.variantCount;
    }

    /* renamed from: z, reason: from getter */
    public final String getVariantGroupId() {
        return this.variantGroupId;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ ChatMessage(java.lang.String r28, java.lang.String r29, java.lang.String r30, long r31, com.stepos.agentframework.chatcore.session.AgentRole r33, java.lang.String r34, int r35, int r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, com.stepos.agentframework.chatcore.session.EReplyStatus r40, int r41, java.lang.String r42, java.util.List r43, com.stepos.agentframework.chatcore.session.ChatHintType r44, boolean r45, java.lang.String r46, java.util.List r47, java.lang.String r48, int r49, java.util.List r50, int r51, kotlin.jvm.internal.i r52) {
        /*
            r27 = this;
            r0 = r51
            r1 = r0 & 512(0x200, float:7.17E-43)
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r14 = r2
            goto Lc
        La:
            r14 = r38
        Lc:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L12
            r15 = r2
            goto L14
        L12:
            r15 = r39
        L14:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L1d
            com.stepos.agentframework.chatcore.session.EReplyStatus r1 = com.stepos.agentframework.chatcore.session.EReplyStatus.START
            r16 = r1
            goto L1f
        L1d:
            r16 = r40
        L1f:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            r3 = 0
            if (r1 == 0) goto L27
            r17 = r3
            goto L29
        L27:
            r17 = r41
        L29:
            r1 = r0 & 8192(0x2000, float:1.148E-41)
            if (r1 == 0) goto L30
            r18 = r2
            goto L32
        L30:
            r18 = r42
        L32:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            r4 = 0
            if (r1 == 0) goto L3a
            r19 = r4
            goto L3c
        L3a:
            r19 = r43
        L3c:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L47
            com.stepos.agentframework.chatcore.session.ChatHintType r1 = com.stepos.agentframework.chatcore.session.ChatHintType.NONE
            r20 = r1
            goto L49
        L47:
            r20 = r44
        L49:
            r1 = 65536(0x10000, float:9.1835E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L51
            r21 = r3
            goto L53
        L51:
            r21 = r45
        L53:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L5b
            r22 = r4
            goto L5d
        L5b:
            r22 = r46
        L5d:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L65
            r23 = r4
            goto L67
        L65:
            r23 = r47
        L67:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L6f
            r24 = r2
            goto L71
        L6f:
            r24 = r48
        L71:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L79
            r25 = r3
            goto L7b
        L79:
            r25 = r49
        L7b:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L97
            r26 = r4
            r3 = r27
            r5 = r29
            r6 = r30
            r7 = r31
            r9 = r33
            r10 = r34
            r11 = r35
            r12 = r36
            r13 = r37
            r4 = r28
            goto Lad
        L97:
            r26 = r50
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r30
            r7 = r31
            r9 = r33
            r10 = r34
            r11 = r35
            r12 = r36
            r13 = r37
        Lad:
            r3.<init>(r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.ChatMessage.<init>(java.lang.String, java.lang.String, java.lang.String, long, com.stepos.agentframework.chatcore.session.AgentRole, java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.String, com.stepos.agentframework.chatcore.session.EReplyStatus, int, java.lang.String, java.util.List, com.stepos.agentframework.chatcore.session.ChatHintType, boolean, java.lang.String, java.util.List, java.lang.String, int, java.util.List, int, kotlin.jvm.internal.i):void");
    }
}
