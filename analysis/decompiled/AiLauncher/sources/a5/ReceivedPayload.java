package a5;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0082\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0017R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b#\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b$\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010\u0019R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b*\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b+\u0010\u0019R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b/\u0010.R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b0\u0010.R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b1\u0010.¨\u00062"}, d2 = {"La5/a;", "", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "sessionId", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, SystemDeleteBroadcastReceiver.EXTRA_TERMINAL_STATE, SystemDeleteBroadcastReceiver.EXTRA_PAYLOAD_MODE, SystemDeleteBroadcastReceiver.EXTRA_PAYLOAD_TOKEN, "Landroid/net/Uri;", SystemDeleteBroadcastReceiver.EXTRA_PAYLOAD_URI, "", SystemDeleteBroadcastReceiver.EXTRA_PATH_COUNT, SystemDeleteBroadcastReceiver.EXTRA_PHOTO_PATH_COUNT, SystemDeleteBroadcastReceiver.EXTRA_FILE_PATH_COUNT, "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, SystemDeleteBroadcastReceiver.EXTRA_METHODS, SystemDeleteBroadcastReceiver.EXTRA_PHOTO_PATHS, SystemDeleteBroadcastReceiver.EXTRA_FILE_PATHS, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;IIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "l", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "n", "e", "f", "Landroid/net/Uri;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/net/Uri;", "I", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "m", "()Ljava/util/List;", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_PKGNAME, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a5.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class ReceivedPayload {
    private final int filePathCount;
    private final List<String> filePaths;
    private final List<String> methods;
    private final int pathCount;
    private final String payloadMode;
    private final String payloadToken;
    private final Uri payloadUri;
    private final int photoPathCount;
    private final List<String> photoPaths;
    private final String runId;
    private final String sessionId;
    private final String sessionKey;
    private final List<String> sources;
    private final String terminalState;

    public ReceivedPayload(String sessionKey, String str, String str2, String terminalState, String payloadMode, String str3, Uri uri, int i10, int i11, int i12, List<String> sources, List<String> methods, List<String> photoPaths, List<String> filePaths) {
        p.i(sessionKey, "sessionKey");
        p.i(terminalState, "terminalState");
        p.i(payloadMode, "payloadMode");
        p.i(sources, "sources");
        p.i(methods, "methods");
        p.i(photoPaths, "photoPaths");
        p.i(filePaths, "filePaths");
        this.sessionKey = sessionKey;
        this.sessionId = str;
        this.runId = str2;
        this.terminalState = terminalState;
        this.payloadMode = payloadMode;
        this.payloadToken = str3;
        this.payloadUri = uri;
        this.pathCount = i10;
        this.photoPathCount = i11;
        this.filePathCount = i12;
        this.sources = sources;
        this.methods = methods;
        this.photoPaths = photoPaths;
        this.filePaths = filePaths;
    }

    /* renamed from: a, reason: from getter */
    public final int getFilePathCount() {
        return this.filePathCount;
    }

    public final List<String> b() {
        return this.filePaths;
    }

    public final List<String> c() {
        return this.methods;
    }

    /* renamed from: d, reason: from getter */
    public final int getPathCount() {
        return this.pathCount;
    }

    /* renamed from: e, reason: from getter */
    public final String getPayloadMode() {
        return this.payloadMode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceivedPayload)) {
            return false;
        }
        ReceivedPayload receivedPayload = (ReceivedPayload) other;
        return p.d(this.sessionKey, receivedPayload.sessionKey) && p.d(this.sessionId, receivedPayload.sessionId) && p.d(this.runId, receivedPayload.runId) && p.d(this.terminalState, receivedPayload.terminalState) && p.d(this.payloadMode, receivedPayload.payloadMode) && p.d(this.payloadToken, receivedPayload.payloadToken) && p.d(this.payloadUri, receivedPayload.payloadUri) && this.pathCount == receivedPayload.pathCount && this.photoPathCount == receivedPayload.photoPathCount && this.filePathCount == receivedPayload.filePathCount && p.d(this.sources, receivedPayload.sources) && p.d(this.methods, receivedPayload.methods) && p.d(this.photoPaths, receivedPayload.photoPaths) && p.d(this.filePaths, receivedPayload.filePaths);
    }

    /* renamed from: f, reason: from getter */
    public final String getPayloadToken() {
        return this.payloadToken;
    }

    /* renamed from: g, reason: from getter */
    public final Uri getPayloadUri() {
        return this.payloadUri;
    }

    /* renamed from: h, reason: from getter */
    public final int getPhotoPathCount() {
        return this.photoPathCount;
    }

    public int hashCode() {
        int iHashCode = this.sessionKey.hashCode() * 31;
        String str = this.sessionId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.runId;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.terminalState.hashCode()) * 31) + this.payloadMode.hashCode()) * 31;
        String str3 = this.payloadToken;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Uri uri = this.payloadUri;
        return ((((((((((((((iHashCode4 + (uri != null ? uri.hashCode() : 0)) * 31) + Integer.hashCode(this.pathCount)) * 31) + Integer.hashCode(this.photoPathCount)) * 31) + Integer.hashCode(this.filePathCount)) * 31) + this.sources.hashCode()) * 31) + this.methods.hashCode()) * 31) + this.photoPaths.hashCode()) * 31) + this.filePaths.hashCode();
    }

    public final List<String> i() {
        return this.photoPaths;
    }

    /* renamed from: j, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: k, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: l, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final List<String> m() {
        return this.sources;
    }

    /* renamed from: n, reason: from getter */
    public final String getTerminalState() {
        return this.terminalState;
    }

    public String toString() {
        return "ReceivedPayload(sessionKey=" + this.sessionKey + ", sessionId=" + this.sessionId + ", runId=" + this.runId + ", terminalState=" + this.terminalState + ", payloadMode=" + this.payloadMode + ", payloadToken=" + this.payloadToken + ", payloadUri=" + this.payloadUri + ", pathCount=" + this.pathCount + ", photoPathCount=" + this.photoPathCount + ", filePathCount=" + this.filePathCount + ", sources=" + this.sources + ", methods=" + this.methods + ", photoPaths=" + this.photoPaths + ", filePaths=" + this.filePaths + ")";
    }
}
