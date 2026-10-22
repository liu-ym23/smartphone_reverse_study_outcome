package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.AbstractC0913i;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bK\b\u0016\u0018\u00002\u00020\u0001Bí\u0002\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012(\b\u0002\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010*R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u00100\u001a\u0004\b1\u0010*\"\u0004\b2\u00103R$\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u00100\u001a\u0004\b4\u0010*\"\u0004\b5\u00103R$\u0010\b\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u00100\u001a\u0004\b6\u0010*\"\u0004\b7\u00103R\"\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\n\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010\u000f\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u00100\u001a\u0004\bI\u0010*\"\u0004\bJ\u00103R\"\u0010\u0012\u001a\u00020\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010H\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010\u0013\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u00108\u001a\u0004\bO\u0010:\"\u0004\bP\u0010<R\"\u0010\u0014\u001a\u00020\t8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u00108\u001a\u0004\bQ\u0010:\"\u0004\bR\u0010<R\"\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010=\u001a\u0004\b\u0015\u0010?\"\u0004\bS\u0010AR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010B\u001a\u0004\bY\u0010D\"\u0004\bZ\u0010FR$\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00100\u001a\u0004\b[\u0010*\"\u0004\b\\\u00103R\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010=\u001a\u0004\b\u001a\u0010?\"\u0004\b]\u0010AR\"\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010=\u001a\u0004\b^\u0010?\"\u0004\b_\u0010AR$\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00100\u001a\u0004\b`\u0010*\"\u0004\ba\u00103RB\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010B\u001a\u0004\bg\u0010D\"\u0004\bh\u0010FR$\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\bi\u0010*\"\u0004\bj\u00103R$\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\bk\u0010*\"\u0004\b8\u00103R$\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\bl\u0010*\"\u0004\bm\u00103R*\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010+\u001a\u0004\bn\u0010-\"\u0004\bo\u0010/¨\u0006p"}, d2 = {"LK6/n;", "LK6/k;", "", "LK6/i;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "", BundleContentBridge.KEY_ROLE, "conversationId", "contentType", "", "transferState", "", "stream", "", "extra", StepOSRecipientEmailHistory._ID, "uid", "", "time", "chatState", "contentId", "isClearContext", "LK6/i$b;", "audio", "customVariables", M5.b.CREDENTIAL_TOKEN, "isAutoGetConversationId", SpriteEventAction.AGENT_THINKING_START, "chatId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "toolOutputs", "meta", "guiAgentModelName", DidiCardProvider.KEY_TRACE_ID, "messageId", "LK6/h;", "attachments", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/Map;ILjava/lang/String;JIIZLK6/i$b;Ljava/util/Map;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/HashMap;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/List;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/List;)V", "Ljava/lang/String;", "p", "setRole", "(Ljava/lang/String;)V", "l", "B", "k", "setContentType", "I", "u", "()I", "setTransferState", "(I)V", "Z", "q", "()Z", "setStream", "(Z)V", "Ljava/util/Map;", "m", "()Ljava/util/Map;", "C", "(Ljava/util/Map;)V", "w", "J", "v", "setUid", UxipConstants.f30686y, "()J", "setTime", "(J)V", "getChatState", "setChatState", "getContentId", "setContentId", "setClearContext", "LK6/i$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()LK6/i$b;", "y", "(LK6/i$b;)V", "getCustomVariables", "setCustomVariables", "getToken", "setToken", "setAutoGetConversationId", "r", "G", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "z", "Ljava/util/HashMap;", "s", "()Ljava/util/HashMap;", "H", "(Ljava/util/HashMap;)V", "o", "F", "getGuiAgentModelName", "D", "t", "n", ExifInterface.LONGITUDE_EAST, Const.INTENT_KEY_BACKGROUND_COMMAND, "x", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0918n extends C0915k {
    private int _id;
    private List<ChatAttachment> attachments;
    private AbstractC0913i.AudioStream audio;
    private String chatId;
    private int chatState;
    private List<? extends AbstractC0913i> content;
    private int contentId;
    private String contentType;
    private String conversationId;
    private Map<String, String> customVariables;
    private Map<String, String> extra;
    private String guiAgentModelName;
    private boolean isAutoGetConversationId;
    private boolean isClearContext;
    private String messageId;
    private Map<String, String> meta;
    private String role;
    private boolean stream;
    private boolean thinking;
    private long time;
    private String token;
    private HashMap<String, Object> toolOutputs;
    private String traceId;
    private int transferState;
    private String uid;

    public C0918n() {
        this(null, null, null, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554431, null);
    }

    public void A(List<? extends AbstractC0913i> list) {
        this.content = list;
    }

    public void B(String str) {
        this.conversationId = str;
    }

    public void C(Map<String, String> map) {
        this.extra = map;
    }

    public final void D(String str) {
        this.guiAgentModelName = str;
    }

    public final void E(String str) {
        this.messageId = str;
    }

    public final void F(Map<String, String> map) {
        this.meta = map;
    }

    public final void G(boolean z10) {
        this.thinking = z10;
    }

    public final void H(HashMap<String, Object> map) {
        this.toolOutputs = map;
    }

    public final void I(String str) {
        this.traceId = str;
    }

    public void J(int i10) {
        this._id = i10;
    }

    public final List<ChatAttachment> g() {
        return this.attachments;
    }

    /* renamed from: h, reason: from getter */
    public AbstractC0913i.AudioStream getAudio() {
        return this.audio;
    }

    /* renamed from: i, reason: from getter */
    public final String getChatId() {
        return this.chatId;
    }

    public List<AbstractC0913i> j() {
        return this.content;
    }

    /* renamed from: k, reason: from getter */
    public String getContentType() {
        return this.contentType;
    }

    /* renamed from: l, reason: from getter */
    public String getConversationId() {
        return this.conversationId;
    }

    public Map<String, String> m() {
        return this.extra;
    }

    /* renamed from: n, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public final Map<String, String> o() {
        return this.meta;
    }

    /* renamed from: p, reason: from getter */
    public String getRole() {
        return this.role;
    }

    /* renamed from: q, reason: from getter */
    public boolean getStream() {
        return this.stream;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getThinking() {
        return this.thinking;
    }

    public final HashMap<String, Object> s() {
        return this.toolOutputs;
    }

    /* renamed from: t, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        List<AbstractC0913i> listJ = j();
        return "ChatRequestInfo(contentParts=" + (listJ != null ? listJ.size() : 0) + ", role='" + getRole() + "', conversationId=" + getConversationId() + ", contentType=" + getContentType() + ", transferState=" + getTransferState() + ", stream=" + getStream() + ", extra=" + m() + ", _id=" + get_id() + ", uid=" + getUid() + ", customVariables=" + this.customVariables + ")";
    }

    /* renamed from: u, reason: from getter */
    public int getTransferState() {
        return this.transferState;
    }

    /* renamed from: v, reason: from getter */
    public String getUid() {
        return this.uid;
    }

    /* renamed from: w, reason: from getter */
    public int get_id() {
        return this._id;
    }

    public final void x(List<ChatAttachment> list) {
        this.attachments = list;
    }

    public void y(AbstractC0913i.AudioStream bVar) {
        this.audio = bVar;
    }

    public final void z(String str) {
        this.chatId = str;
    }

    public C0918n(List<? extends AbstractC0913i> list, String role, String str, String str2, int i10, boolean z10, Map<String, String> map, int i11, String str3, long j10, int i12, int i13, boolean z11, AbstractC0913i.AudioStream bVar, Map<String, String> map2, String str4, boolean z12, boolean z13, String str5, HashMap<String, Object> map3, Map<String, String> map4, String str6, String str7, String str8, List<ChatAttachment> list2) {
        p.i(role, "role");
        this.content = list;
        this.role = role;
        this.conversationId = str;
        this.contentType = str2;
        this.transferState = i10;
        this.stream = z10;
        this.extra = map;
        this._id = i11;
        this.uid = str3;
        this.time = j10;
        this.chatState = i12;
        this.contentId = i13;
        this.isClearContext = z11;
        this.audio = bVar;
        this.customVariables = map2;
        this.token = str4;
        this.isAutoGetConversationId = z12;
        this.thinking = z13;
        this.chatId = str5;
        this.toolOutputs = map3;
        this.meta = map4;
        this.guiAgentModelName = str6;
        this.traceId = str7;
        this.messageId = str8;
        this.attachments = list2;
    }

    public /* synthetic */ C0918n(List list, String str, String str2, String str3, int i10, boolean z10, Map map, int i11, String str4, long j10, int i12, int i13, boolean z11, AbstractC0913i.AudioStream bVar, Map map2, String str5, boolean z12, boolean z13, String str6, HashMap map3, Map map4, String str7, String str8, String str9, List list2, int i14, i iVar) {
        this((i14 & 1) != 0 ? null : list, (i14 & 2) != 0 ? "user" : str, (i14 & 4) != 0 ? null : str2, (i14 & 8) != 0 ? "text" : str3, (i14 & 16) != 0 ? 0 : i10, (i14 & 32) != 0 ? true : z10, (i14 & 64) != 0 ? null : map, (i14 & 128) != 0 ? 0 : i11, (i14 & 256) != 0 ? null : str4, (i14 & 512) != 0 ? System.currentTimeMillis() : j10, (i14 & 1024) != 0 ? 1 : i12, (i14 & 2048) != 0 ? 0 : i13, (i14 & 4096) != 0 ? false : z11, (i14 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : bVar, (i14 & 16384) != 0 ? null : map2, (i14 & 32768) != 0 ? null : str5, (i14 & 65536) != 0 ? true : z12, (i14 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? false : z13, (i14 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? null : str6, (i14 & 524288) != 0 ? null : map3, (i14 & 1048576) != 0 ? null : map4, (i14 & 2097152) != 0 ? null : str7, (i14 & 4194304) != 0 ? "" : str8, (i14 & 8388608) != 0 ? null : str9, (i14 & 16777216) != 0 ? null : list2);
    }
}
