package o5;

import La.H;
import Z8.C1173v;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.ailauncher.chat.wake.ShareWakeBroadcastReceiver;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001bB7\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001d"}, d2 = {"Lo5/e;", "", "", "", "suggestions", "fileUris", HighlightArgsBundle.KEY_PROMPT, "fileId", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", "e", "()Z", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: o5.e, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ChatLaunchPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String fileId;
    private final List<String> fileUris;
    private final String prompt;
    private final List<String> suggestions;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lo5/e$a;", "", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lo5/e;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Lo5/e;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: o5.e$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final ChatLaunchPayload a(Intent intent) {
            List listM;
            List listM2;
            p.i(intent, "intent");
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("extra_suggestions");
            String str = null;
            if (stringArrayListExtra != null) {
                listM = new ArrayList();
                for (Object obj : stringArrayListExtra) {
                    String str2 = (String) obj;
                    p.f(str2);
                    if (!H.x0(str2)) {
                        listM.add(obj);
                    }
                }
            } else {
                listM = null;
            }
            if (listM == null) {
                listM = C1173v.m();
            }
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("extra_file_uris");
            if (stringArrayListExtra2 != null) {
                listM2 = new ArrayList();
                for (Object obj2 : stringArrayListExtra2) {
                    String str3 = (String) obj2;
                    p.f(str3);
                    if (!H.x0(str3)) {
                        listM2.add(obj2);
                    }
                }
            } else {
                listM2 = null;
            }
            if (listM2 == null) {
                listM2 = C1173v.m();
            }
            String stringExtra = intent.getStringExtra("extra_prompt");
            if (stringExtra == null || H.x0(stringExtra)) {
                stringExtra = null;
            }
            String stringExtra2 = intent.getStringExtra(ShareWakeBroadcastReceiver.EXTRA_FILE_ID);
            if (stringExtra2 != null && !H.x0(stringExtra2)) {
                str = stringExtra2;
            }
            return new ChatLaunchPayload(listM, listM2, stringExtra, str);
        }

        public Companion() {
        }
    }

    public ChatLaunchPayload(List<String> suggestions, List<String> fileUris, String str, String str2) {
        p.i(suggestions, "suggestions");
        p.i(fileUris, "fileUris");
        this.suggestions = suggestions;
        this.fileUris = fileUris;
        this.prompt = str;
        this.fileId = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    public final List<String> b() {
        return this.fileUris;
    }

    /* renamed from: c, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    public final List<String> d() {
        return this.suggestions;
    }

    public final boolean e() {
        if (!this.suggestions.isEmpty() || !this.fileUris.isEmpty()) {
            return false;
        }
        String str = this.prompt;
        if (str != null && str.length() != 0) {
            return false;
        }
        String str2 = this.fileId;
        return str2 == null || str2.length() == 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatLaunchPayload)) {
            return false;
        }
        ChatLaunchPayload chatLaunchPayload = (ChatLaunchPayload) other;
        return p.d(this.suggestions, chatLaunchPayload.suggestions) && p.d(this.fileUris, chatLaunchPayload.fileUris) && p.d(this.prompt, chatLaunchPayload.prompt) && p.d(this.fileId, chatLaunchPayload.fileId);
    }

    public int hashCode() {
        int iHashCode = ((this.suggestions.hashCode() * 31) + this.fileUris.hashCode()) * 31;
        String str = this.prompt;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fileId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ChatLaunchPayload(suggestions=" + this.suggestions + ", fileUris=" + this.fileUris + ", prompt=" + this.prompt + ", fileId=" + this.fileId + ")";
    }
}
