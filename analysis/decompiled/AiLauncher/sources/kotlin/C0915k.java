package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import java.util.List;
import java.util.Map;
import kotlin.AbstractC0913i;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010'8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR$\u00101\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\"\u00105\u001a\u0002048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001b\u001a\u0004\b<\u0010\u001d\"\u0004\b=\u0010\u001fR\"\u0010>\u001a\u00020\u00198\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010\u001b\u001a\u0004\b?\u0010\u001d\"\u0004\b@\u0010\u001fR\"\u0010A\u001a\u00020 8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bA\u0010\"\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\"\u0010C\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u0010\u000e\u001a\u0004\bD\u0010\u0010\"\u0004\bE\u0010\u0012R$\u0010F\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bF\u0010\u000e\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R\"\u0010I\u001a\u00020\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bI\u0010\u000e\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010\u0012R$\u0010M\u001a\u0004\u0018\u00010L8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006S"}, d2 = {"LK6/k;", "", "<init>", "()V", "", "LK6/i;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Ljava/util/List;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "", BundleContentBridge.KEY_ROLE, "Ljava/lang/String;", "getRole", "()Ljava/lang/String;", "setRole", "(Ljava/lang/String;)V", "conversationId", "getConversationId", "setConversationId", "contentType", "getContentType", "setContentType", "", "transferState", "I", "getTransferState", "()I", "setTransferState", "(I)V", "", "stream", "Z", "getStream", "()Z", "setStream", "(Z)V", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", StepOSRecipientEmailHistory._ID, "get_id", "set_id", "uid", "getUid", "setUid", "", "time", "J", UxipConstants.f30686y, "()J", "setTime", "(J)V", "chatState", "getChatState", "setChatState", "contentId", "getContentId", "setContentId", "isClearContext", "setClearContext", "agentId", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "deviceId", Const.INTENT_KEY_PKGNAME, "e", "secretkey", "c", "f", "LK6/i$b;", "audio", "LK6/i$b;", "getAudio", "()LK6/i$b;", "setAudio", "(LK6/i$b;)V", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0915k {
    private transient int _id;
    private transient AbstractC0913i.AudioStream audio;
    private transient List<? extends AbstractC0913i> content;
    private transient int contentId;
    private transient String contentType;
    private transient String conversationId;
    private transient String deviceId;
    private transient Map<String, String> extra;
    private transient boolean isClearContext;
    private transient int transferState;
    private transient String uid;
    private transient String role = "user";
    private transient boolean stream = true;
    private transient long time = System.currentTimeMillis();
    private transient int chatState = -2;
    private transient String agentId = "";
    private transient String secretkey = "";

    /* renamed from: a, reason: from getter */
    public String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: c, reason: from getter */
    public String getSecretkey() {
        return this.secretkey;
    }

    public void d(String str) {
        p.i(str, "<set-?>");
        this.agentId = str;
    }

    public void e(String str) {
        this.deviceId = str;
    }

    public void f(String str) {
        p.i(str, "<set-?>");
        this.secretkey = str;
    }
}
