package w4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.C0905a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0017\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\rBA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lw4/a;", "", "", "agentId", "agentName", "description", "avatarUrl", "prologue", "", "suggestedQuestions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "setAgentId", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "setAgentName", Const.INTENT_KEY_UMID, "setDescription", "c", "setAvatarUrl", "e", "setPrologue", "Ljava/util/List;", "f", "()Ljava/util/List;", "setSuggestedQuestions", "(Ljava/util/List;)V", "Companion", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5732a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String agentId;
    private String agentName;
    private String avatarUrl;
    private String description;
    private String prologue;
    private List<String> suggestedQuestions;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lw4/a$a;", "", "<init>", "()V", "LK6/a;", "agentDetail", "Lw4/a;", Const.INTENT_KEY_APIKEY, "(LK6/a;)Lw4/a;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: w4.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C5732a a(C0905a agentDetail) {
            p.i(agentDetail, "agentDetail");
            String botId = agentDetail.getBotId();
            if (botId == null) {
                botId = "";
            }
            String name = agentDetail.getName();
            if (name == null) {
                name = "";
            }
            String iconUrl = agentDetail.getIconUrl();
            String str = iconUrl == null ? "" : iconUrl;
            String prologue = agentDetail.getPrologue();
            return new C5732a(botId, name, "", str, prologue == null ? "" : prologue, agentDetail.e());
        }

        public Companion() {
        }
    }

    public C5732a(String agentId, String agentName, String description, String avatarUrl, String prologue, List<String> list) {
        p.i(agentId, "agentId");
        p.i(agentName, "agentName");
        p.i(description, "description");
        p.i(avatarUrl, "avatarUrl");
        p.i(prologue, "prologue");
        this.agentId = agentId;
        this.agentName = agentName;
        this.description = description;
        this.avatarUrl = avatarUrl;
        this.prologue = prologue;
        this.suggestedQuestions = list;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getAgentName() {
        return this.agentName;
    }

    /* renamed from: c, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: d, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: e, reason: from getter */
    public final String getPrologue() {
        return this.prologue;
    }

    public final List<String> f() {
        return this.suggestedQuestions;
    }

    public /* synthetic */ C5732a(String str, String str2, String str3, String str4, String str5, List list, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, str5, (i10 & 32) != 0 ? null : list);
    }
}
