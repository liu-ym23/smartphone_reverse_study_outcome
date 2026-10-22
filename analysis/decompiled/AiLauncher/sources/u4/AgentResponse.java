package u4;

import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.ame.sdk.SkillStoreKt;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.List;
import kotlin.AbstractC0913i;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bU\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0010\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0000H\u0016¢\u0006\u0004\b*\u0010+J\u0096\u0002\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010'\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00105\u001a\u0002042\b\u00103\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b5\u00106R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010/\"\u0004\b9\u0010:R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u00107\u001a\u0004\b;\u0010/\"\u0004\b<\u0010:R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00107\u001a\u0004\b=\u0010/\"\u0004\b>\u0010:R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00107\u001a\u0004\bI\u0010/\"\u0004\bJ\u0010:R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00107\u001a\u0004\bK\u0010/\"\u0004\bL\u0010:R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00107\u001a\u0004\bM\u0010/\"\u0004\bN\u0010:R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010?\u001a\u0004\bT\u0010A\"\u0004\bU\u0010CR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00107\u001a\u0004\bj\u0010/\"\u0004\bk\u0010:R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR*\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b$\u0010?\u001a\u0005\b\u0080\u0001\u0010A\"\u0005\b\u0081\u0001\u0010CR)\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b&\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R$\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b'\u00107\u001a\u0005\b\u0087\u0001\u0010/\"\u0005\b\u0088\u0001\u0010:¨\u0006\u0089\u0001"}, d2 = {"Lu4/d;", "", "", "agentId", "messageId", "sessionId", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "toolList", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "type", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "deepThinkingText", "url", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "", "suggest", "", "extra", "Lu4/i;", "taskPlan", "Lu4/e;", "taskUpdate", "Lu4/h;", "taskEvent", "serverItemId", "Lu4/f;", "workComplete", "Lu4/g;", "workError", "Lu4/c;", "moderation", "LK6/i$b;", "audio", "LK6/i$e;", "files", "LK6/i$f;", "folder", "finishReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/agentframework/chatcore/session/AgentMessageType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;Ljava/util/List;Ljava/lang/Object;Lu4/i;Lu4/e;Lu4/h;Ljava/lang/String;Lu4/f;Lu4/g;Lu4/c;LK6/i$b;Ljava/util/List;LK6/i$f;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()Lu4/d;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/agentframework/chatcore/session/AgentMessageType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/EReplyStatus;Ljava/util/List;Ljava/lang/Object;Lu4/i;Lu4/e;Lu4/h;Ljava/lang/String;Lu4/f;Lu4/g;Lu4/c;LK6/i$b;Ljava/util/List;LK6/i$f;Ljava/lang/String;)Lu4/d;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "D", "(Ljava/lang/String;)V", "p", "N", "s", "Q", "Ljava/util/List;", "y", "()Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/util/List;)V", "Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "z", "()Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", ExifInterface.LONGITUDE_WEST, "(Lcom/stepos/agentframework/chatcore/session/AgentMessageType;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "H", "getUrl", "setUrl", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "t", "()Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "R", "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)V", "u", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/lang/Object;", "I", "(Ljava/lang/Object;)V", "Lu4/i;", "w", "()Lu4/i;", ExifInterface.GPS_DIRECTION_TRUE, "(Lu4/i;)V", "Lu4/e;", "x", "()Lu4/e;", "U", "(Lu4/e;)V", "Lu4/h;", "v", "()Lu4/h;", "setTaskEvent", "(Lu4/h;)V", "r", "P", "Lu4/f;", "B", "()Lu4/f;", "X", "(Lu4/f;)V", "Lu4/g;", "C", "()Lu4/g;", "Y", "(Lu4/g;)V", "Lu4/c;", "q", "()Lu4/c;", "O", "(Lu4/c;)V", "LK6/i$b;", "getAudio", "()LK6/i$b;", ExifInterface.LONGITUDE_EAST, "(LK6/i$b;)V", "k", "K", "LK6/i$f;", "o", "()LK6/i$f;", "M", "(LK6/i$f;)V", "n", "L", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.d, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentResponse implements Cloneable {
    private String agentId;
    private AbstractC0913i.AudioStream audio;
    private String content;
    private String deepThinkingText;
    private Object extra;
    private List<AbstractC0913i.File> files;
    private String finishReason;
    private AbstractC0913i.Folder folder;
    private String messageId;
    private AgentModeration moderation;
    private String serverItemId;
    private String sessionId;
    private EReplyStatus status;
    private List<String> suggest;
    private AgentTaskEvent taskEvent;
    private AgentTaskPlan taskPlan;
    private AgentTask taskUpdate;
    private List<AgentTool> toolList;
    private AgentMessageType type;
    private String url;
    private AgentTaskComplete workComplete;
    private AgentTaskError workError;

    public AgentResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    public static /* synthetic */ AgentResponse f(AgentResponse agentResponse, String str, String str2, String str3, List list, AgentMessageType agentMessageType, String str4, String str5, String str6, EReplyStatus eReplyStatus, List list2, Object obj, AgentTaskPlan agentTaskPlan, AgentTask agentTask, AgentTaskEvent agentTaskEvent, String str7, AgentTaskComplete agentTaskComplete, AgentTaskError agentTaskError, AgentModeration cVar, AbstractC0913i.AudioStream audioStream, List list3, AbstractC0913i.Folder folder, String str8, int i10, Object obj2) {
        String str9;
        AbstractC0913i.Folder folder2;
        String str10 = (i10 & 1) != 0 ? agentResponse.agentId : str;
        String str11 = (i10 & 2) != 0 ? agentResponse.messageId : str2;
        String str12 = (i10 & 4) != 0 ? agentResponse.sessionId : str3;
        List list4 = (i10 & 8) != 0 ? agentResponse.toolList : list;
        AgentMessageType agentMessageType2 = (i10 & 16) != 0 ? agentResponse.type : agentMessageType;
        String str13 = (i10 & 32) != 0 ? agentResponse.content : str4;
        String str14 = (i10 & 64) != 0 ? agentResponse.deepThinkingText : str5;
        String str15 = (i10 & 128) != 0 ? agentResponse.url : str6;
        EReplyStatus eReplyStatus2 = (i10 & 256) != 0 ? agentResponse.status : eReplyStatus;
        List list5 = (i10 & 512) != 0 ? agentResponse.suggest : list2;
        Object obj3 = (i10 & 1024) != 0 ? agentResponse.extra : obj;
        AgentTaskPlan agentTaskPlan2 = (i10 & 2048) != 0 ? agentResponse.taskPlan : agentTaskPlan;
        AgentTask agentTask2 = (i10 & 4096) != 0 ? agentResponse.taskUpdate : agentTask;
        AgentTaskEvent agentTaskEvent2 = (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? agentResponse.taskEvent : agentTaskEvent;
        String str16 = str10;
        String str17 = (i10 & 16384) != 0 ? agentResponse.serverItemId : str7;
        AgentTaskComplete agentTaskComplete2 = (i10 & 32768) != 0 ? agentResponse.workComplete : agentTaskComplete;
        AgentTaskError agentTaskError2 = (i10 & 65536) != 0 ? agentResponse.workError : agentTaskError;
        AgentModeration cVar2 = (i10 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? agentResponse.moderation : cVar;
        AbstractC0913i.AudioStream audioStream2 = (i10 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? agentResponse.audio : audioStream;
        List list6 = (i10 & 524288) != 0 ? agentResponse.files : list3;
        AbstractC0913i.Folder folder3 = (i10 & 1048576) != 0 ? agentResponse.folder : folder;
        if ((i10 & 2097152) != 0) {
            folder2 = folder3;
            str9 = agentResponse.finishReason;
        } else {
            str9 = str8;
            folder2 = folder3;
        }
        return agentResponse.d(str16, str11, str12, list4, agentMessageType2, str13, str14, str15, eReplyStatus2, list5, obj3, agentTaskPlan2, agentTask2, agentTaskEvent2, str17, agentTaskComplete2, agentTaskError2, cVar2, audioStream2, list6, folder2, str9);
    }

    /* renamed from: B, reason: from getter */
    public final AgentTaskComplete getWorkComplete() {
        return this.workComplete;
    }

    /* renamed from: C, reason: from getter */
    public final AgentTaskError getWorkError() {
        return this.workError;
    }

    public final void D(String str) {
        p.i(str, "<set-?>");
        this.agentId = str;
    }

    public final void E(AbstractC0913i.AudioStream audioStream) {
        this.audio = audioStream;
    }

    public final void F(String str) {
        p.i(str, "<set-?>");
        this.content = str;
    }

    public final void H(String str) {
        p.i(str, "<set-?>");
        this.deepThinkingText = str;
    }

    public final void I(Object obj) {
        this.extra = obj;
    }

    public final void K(List<AbstractC0913i.File> list) {
        p.i(list, "<set-?>");
        this.files = list;
    }

    public final void L(String str) {
        p.i(str, "<set-?>");
        this.finishReason = str;
    }

    public final void M(AbstractC0913i.Folder folder) {
        this.folder = folder;
    }

    public final void N(String str) {
        p.i(str, "<set-?>");
        this.messageId = str;
    }

    public final void O(AgentModeration cVar) {
        this.moderation = cVar;
    }

    public final void P(String str) {
        this.serverItemId = str;
    }

    public final void Q(String str) {
        p.i(str, "<set-?>");
        this.sessionId = str;
    }

    public final void R(EReplyStatus eReplyStatus) {
        p.i(eReplyStatus, "<set-?>");
        this.status = eReplyStatus;
    }

    public final void S(List<String> list) {
        this.suggest = list;
    }

    public final void T(AgentTaskPlan agentTaskPlan) {
        this.taskPlan = agentTaskPlan;
    }

    public final void U(AgentTask agentTask) {
        this.taskUpdate = agentTask;
    }

    public final void V(List<AgentTool> list) {
        this.toolList = list;
    }

    public final void W(AgentMessageType agentMessageType) {
        p.i(agentMessageType, "<set-?>");
        this.type = agentMessageType;
    }

    public final void X(AgentTaskComplete agentTaskComplete) {
        this.workComplete = agentTaskComplete;
    }

    public final void Y(AgentTaskError agentTaskError) {
        this.workError = agentTaskError;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AgentResponse clone() throws CloneNotSupportedException {
        try {
            Object objClone = super.clone();
            p.g(objClone, "null cannot be cast to non-null type com.stepos.agentframework.chatcore.session.bean.AgentResponse");
            return (AgentResponse) objClone;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public final AgentResponse d(String agentId, String messageId, String sessionId, List<AgentTool> toolList, AgentMessageType type, String content, String deepThinkingText, String url, EReplyStatus status, List<String> suggest, Object extra, AgentTaskPlan taskPlan, AgentTask taskUpdate, AgentTaskEvent taskEvent, String serverItemId, AgentTaskComplete workComplete, AgentTaskError workError, AgentModeration moderation, AbstractC0913i.AudioStream audio, List<AbstractC0913i.File> files, AbstractC0913i.Folder folder, String finishReason) {
        p.i(agentId, "agentId");
        p.i(messageId, "messageId");
        p.i(sessionId, "sessionId");
        p.i(type, "type");
        p.i(content, "content");
        p.i(deepThinkingText, "deepThinkingText");
        p.i(url, "url");
        p.i(status, "status");
        p.i(files, "files");
        p.i(finishReason, "finishReason");
        return new AgentResponse(agentId, messageId, sessionId, toolList, type, content, deepThinkingText, url, status, suggest, extra, taskPlan, taskUpdate, taskEvent, serverItemId, workComplete, workError, moderation, audio, files, folder, finishReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentResponse)) {
            return false;
        }
        AgentResponse agentResponse = (AgentResponse) other;
        return p.d(this.agentId, agentResponse.agentId) && p.d(this.messageId, agentResponse.messageId) && p.d(this.sessionId, agentResponse.sessionId) && p.d(this.toolList, agentResponse.toolList) && this.type == agentResponse.type && p.d(this.content, agentResponse.content) && p.d(this.deepThinkingText, agentResponse.deepThinkingText) && p.d(this.url, agentResponse.url) && this.status == agentResponse.status && p.d(this.suggest, agentResponse.suggest) && p.d(this.extra, agentResponse.extra) && p.d(this.taskPlan, agentResponse.taskPlan) && p.d(this.taskUpdate, agentResponse.taskUpdate) && p.d(this.taskEvent, agentResponse.taskEvent) && p.d(this.serverItemId, agentResponse.serverItemId) && p.d(this.workComplete, agentResponse.workComplete) && p.d(this.workError, agentResponse.workError) && p.d(this.moderation, agentResponse.moderation) && p.d(this.audio, agentResponse.audio) && p.d(this.files, agentResponse.files) && p.d(this.folder, agentResponse.folder) && p.d(this.finishReason, agentResponse.finishReason);
    }

    /* renamed from: g, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: h, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public int hashCode() {
        int iHashCode = ((((this.agentId.hashCode() * 31) + this.messageId.hashCode()) * 31) + this.sessionId.hashCode()) * 31;
        List<AgentTool> list = this.toolList;
        int iHashCode2 = (((((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + this.type.hashCode()) * 31) + this.content.hashCode()) * 31) + this.deepThinkingText.hashCode()) * 31) + this.url.hashCode()) * 31) + this.status.hashCode()) * 31;
        List<String> list2 = this.suggest;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Object obj = this.extra;
        int iHashCode4 = (iHashCode3 + (obj == null ? 0 : obj.hashCode())) * 31;
        AgentTaskPlan agentTaskPlan = this.taskPlan;
        int iHashCode5 = (iHashCode4 + (agentTaskPlan == null ? 0 : agentTaskPlan.hashCode())) * 31;
        AgentTask agentTask = this.taskUpdate;
        int iHashCode6 = (iHashCode5 + (agentTask == null ? 0 : agentTask.hashCode())) * 31;
        AgentTaskEvent agentTaskEvent = this.taskEvent;
        int iHashCode7 = (iHashCode6 + (agentTaskEvent == null ? 0 : agentTaskEvent.hashCode())) * 31;
        String str = this.serverItemId;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        AgentTaskComplete agentTaskComplete = this.workComplete;
        int iHashCode9 = (iHashCode8 + (agentTaskComplete == null ? 0 : agentTaskComplete.hashCode())) * 31;
        AgentTaskError agentTaskError = this.workError;
        int iHashCode10 = (iHashCode9 + (agentTaskError == null ? 0 : agentTaskError.hashCode())) * 31;
        AgentModeration cVar = this.moderation;
        int iHashCode11 = (iHashCode10 + (cVar == null ? 0 : cVar.hashCode())) * 31;
        AbstractC0913i.AudioStream audioStream = this.audio;
        int iHashCode12 = (((iHashCode11 + (audioStream == null ? 0 : audioStream.hashCode())) * 31) + this.files.hashCode()) * 31;
        AbstractC0913i.Folder folder = this.folder;
        return ((iHashCode12 + (folder != null ? folder.hashCode() : 0)) * 31) + this.finishReason.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getDeepThinkingText() {
        return this.deepThinkingText;
    }

    /* renamed from: j, reason: from getter */
    public final Object getExtra() {
        return this.extra;
    }

    public final List<AbstractC0913i.File> k() {
        return this.files;
    }

    /* renamed from: n, reason: from getter */
    public final String getFinishReason() {
        return this.finishReason;
    }

    /* renamed from: o, reason: from getter */
    public final AbstractC0913i.Folder getFolder() {
        return this.folder;
    }

    /* renamed from: p, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: q, reason: from getter */
    public final AgentModeration getModeration() {
        return this.moderation;
    }

    /* renamed from: r, reason: from getter */
    public final String getServerItemId() {
        return this.serverItemId;
    }

    /* renamed from: s, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: t, reason: from getter */
    public final EReplyStatus getStatus() {
        return this.status;
    }

    public String toString() {
        return "AgentResponse(agentId=" + this.agentId + ", messageId=" + this.messageId + ", sessionId=" + this.sessionId + ", toolList=" + this.toolList + ", type=" + this.type + ", content=" + this.content + ", deepThinkingText=" + this.deepThinkingText + ", url=" + this.url + ", status=" + this.status + ", suggest=" + this.suggest + ", extra=" + this.extra + ", taskPlan=" + this.taskPlan + ", taskUpdate=" + this.taskUpdate + ", taskEvent=" + this.taskEvent + ", serverItemId=" + this.serverItemId + ", workComplete=" + this.workComplete + ", workError=" + this.workError + ", moderation=" + this.moderation + ", audio=" + this.audio + ", files=" + this.files + ", folder=" + this.folder + ", finishReason=" + this.finishReason + ")";
    }

    public final List<String> u() {
        return this.suggest;
    }

    /* renamed from: v, reason: from getter */
    public final AgentTaskEvent getTaskEvent() {
        return this.taskEvent;
    }

    /* renamed from: w, reason: from getter */
    public final AgentTaskPlan getTaskPlan() {
        return this.taskPlan;
    }

    /* renamed from: x, reason: from getter */
    public final AgentTask getTaskUpdate() {
        return this.taskUpdate;
    }

    public final List<AgentTool> y() {
        return this.toolList;
    }

    /* renamed from: z, reason: from getter */
    public final AgentMessageType getType() {
        return this.type;
    }

    public AgentResponse(String agentId, String messageId, String sessionId, List<AgentTool> list, AgentMessageType type, String content, String deepThinkingText, String url, EReplyStatus status, List<String> list2, Object obj, AgentTaskPlan agentTaskPlan, AgentTask agentTask, AgentTaskEvent agentTaskEvent, String str, AgentTaskComplete agentTaskComplete, AgentTaskError agentTaskError, AgentModeration cVar, AbstractC0913i.AudioStream audioStream, List<AbstractC0913i.File> files, AbstractC0913i.Folder folder, String finishReason) {
        p.i(agentId, "agentId");
        p.i(messageId, "messageId");
        p.i(sessionId, "sessionId");
        p.i(type, "type");
        p.i(content, "content");
        p.i(deepThinkingText, "deepThinkingText");
        p.i(url, "url");
        p.i(status, "status");
        p.i(files, "files");
        p.i(finishReason, "finishReason");
        this.agentId = agentId;
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.toolList = list;
        this.type = type;
        this.content = content;
        this.deepThinkingText = deepThinkingText;
        this.url = url;
        this.status = status;
        this.suggest = list2;
        this.extra = obj;
        this.taskPlan = agentTaskPlan;
        this.taskUpdate = agentTask;
        this.taskEvent = agentTaskEvent;
        this.serverItemId = str;
        this.workComplete = agentTaskComplete;
        this.workError = agentTaskError;
        this.moderation = cVar;
        this.audio = audioStream;
        this.files = files;
        this.folder = folder;
        this.finishReason = finishReason;
    }

    public /* synthetic */ AgentResponse(String str, String str2, String str3, List list, AgentMessageType agentMessageType, String str4, String str5, String str6, EReplyStatus eReplyStatus, List list2, Object obj, AgentTaskPlan agentTaskPlan, AgentTask agentTask, AgentTaskEvent agentTaskEvent, String str7, AgentTaskComplete agentTaskComplete, AgentTaskError agentTaskError, AgentModeration cVar, AbstractC0913i.AudioStream audioStream, List list3, AbstractC0913i.Folder folder, String str8, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? null : list, (i10 & 16) != 0 ? AgentMessageType.TEXT : agentMessageType, (i10 & 32) != 0 ? "" : str4, (i10 & 64) != 0 ? "" : str5, (i10 & 128) != 0 ? "" : str6, (i10 & 256) != 0 ? EReplyStatus.START : eReplyStatus, (i10 & 512) != 0 ? null : list2, (i10 & 1024) != 0 ? null : obj, (i10 & 2048) != 0 ? null : agentTaskPlan, (i10 & 4096) != 0 ? null : agentTask, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : agentTaskEvent, (i10 & 16384) != 0 ? null : str7, (i10 & 32768) != 0 ? null : agentTaskComplete, (i10 & 65536) != 0 ? null : agentTaskError, (i10 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? null : cVar, (i10 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? null : audioStream, (i10 & 524288) != 0 ? C1173v.m() : list3, (i10 & 1048576) != 0 ? null : folder, (i10 & 2097152) != 0 ? "" : str8);
    }
}
