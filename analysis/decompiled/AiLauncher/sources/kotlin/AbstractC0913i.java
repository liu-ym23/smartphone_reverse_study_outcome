package kotlin;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.common.ChatContentType;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00020\u0001:\t\u0014\u0015\u0016\u0010\u0017\u0007\r\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0007\u001a\u00020\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\b\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"LK6/i;", "", "<init>", "()V", "", "", C3081a.FOCUS_MAP_NAME, Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;)LK6/i;", "", "_extra", "Ljava/util/Map;", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "contentType", "c", "()Ljava/util/Map;", "extra", "Companion", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "e", "f", "LK6/i$a;", "LK6/i$b;", "LK6/i$c;", "LK6/i$e;", "LK6/i$f;", "LK6/i$g;", "LK6/i$h;", "LK6/i$i;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0913i {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, String> _extra;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\nR\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"LK6/i$a;", "LK6/i;", "", "fileId", "uri", "mimeType", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFileId", "f", "e", Const.INTENT_KEY_UMID, "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$a, reason: from toString */
    public static final /* data */ class Audio extends AbstractC0913i {
        private final ChatContentType contentType;
        private final String displayName;
        private final String fileId;
        private final String mimeType;
        private final String uri;

        public Audio() {
            this(null, null, null, null, 15, null);
        }

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* renamed from: e, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Audio)) {
                return false;
            }
            Audio audio = (Audio) other;
            return p.d(this.fileId, audio.fileId) && p.d(this.uri, audio.uri) && p.d(this.mimeType, audio.mimeType) && p.d(this.displayName, audio.displayName);
        }

        /* renamed from: f, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.uri;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.mimeType;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.displayName;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Audio(fileId=" + this.fileId + ", uri=" + this.uri + ", mimeType=" + this.mimeType + ", displayName=" + this.displayName + ")";
        }

        public Audio(String str, String str2, String str3, String str4) {
            super(null);
            this.fileId = str;
            this.uri = str2;
            this.mimeType = str3;
            this.displayName = str4;
            this.contentType = ChatContentType.AUDIO;
        }

        public /* synthetic */ Audio(String str, String str2, String str3, String str4, int i10, i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? "" : str4);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"LK6/i$b;", "LK6/i;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "audioId", "Ljava/lang/String;", "getAudioId", "setAudioId", "(Ljava/lang/String;)V", "", "data", "[B", Const.INTENT_KEY_UMID, "()[B", "isEnd", "Z", "e", "()Z", "displayName", "getDisplayName", "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$b, reason: from toString */
    public static final /* data */ class AudioStream extends AbstractC0913i {
        private String audioId;
        private final ChatContentType contentType;
        private final byte[] data;
        private final String displayName;
        private final boolean isEnd;

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final byte[] getData() {
            return this.data;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsEnd() {
            return this.isEnd;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioStream)) {
                return false;
            }
            AudioStream audioStream = (AudioStream) other;
            return p.d(this.audioId, audioStream.audioId) && p.d(this.data, audioStream.data) && this.isEnd == audioStream.isEnd && p.d(this.displayName, audioStream.displayName);
        }

        public int hashCode() {
            int iHashCode = this.audioId.hashCode() * 31;
            byte[] bArr = this.data;
            int iHashCode2 = (((iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31) + Boolean.hashCode(this.isEnd)) * 31;
            String str = this.displayName;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "AudioStream(audioId=" + this.audioId + ", data=" + Arrays.toString(this.data) + ", isEnd=" + this.isEnd + ", displayName=" + this.displayName + ")";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LK6/i$c;", "LK6/i;", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "<init>", "([B)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", Const.INTENT_KEY_UMID, "()[B", "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$c, reason: from toString */
    public static final /* data */ class Bytes extends AbstractC0913i {
        private final byte[] content;
        private final ChatContentType contentType;

        public Bytes(byte[] bArr) {
            super(null);
            this.content = bArr;
            this.contentType = ChatContentType.BYTES;
        }

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final byte[] getContent() {
            return this.content;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Bytes) && p.d(this.content, ((Bytes) other).content);
        }

        public int hashCode() {
            byte[] bArr = this.content;
            if (bArr == null) {
                return 0;
            }
            return Arrays.hashCode(bArr);
        }

        public String toString() {
            return "Bytes(content=" + Arrays.toString(this.content) + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"LK6/i$d;", "", "<init>", "()V", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$d, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u000eR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u000eR\u001a\u0010\"\u001a\u00020!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"LK6/i$e;", "LK6/i;", "", "fileId", "uri", "url", "fileName", "", "fileSize", "mimeType", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$e, reason: from toString */
    public static final /* data */ class File extends AbstractC0913i {
        private final ChatContentType contentType;
        private final String displayName;
        private final String fileId;
        private final String fileName;
        private final Long fileSize;
        private final String mimeType;
        private final String uri;
        private final String url;

        public File() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        /* renamed from: e, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof File)) {
                return false;
            }
            File file = (File) other;
            return p.d(this.fileId, file.fileId) && p.d(this.uri, file.uri) && p.d(this.url, file.url) && p.d(this.fileName, file.fileName) && p.d(this.fileSize, file.fileSize) && p.d(this.mimeType, file.mimeType) && p.d(this.displayName, file.displayName);
        }

        /* renamed from: f, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        /* renamed from: g, reason: from getter */
        public final Long getFileSize() {
            return this.fileSize;
        }

        /* renamed from: h, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.uri;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.url;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.fileName;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Long l10 = this.fileSize;
            int iHashCode5 = (iHashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31;
            String str5 = this.mimeType;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.displayName;
            return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
        }

        /* renamed from: i, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        /* renamed from: j, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public String toString() {
            return "File(fileId=" + this.fileId + ", uri=" + this.uri + ", url=" + this.url + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", mimeType=" + this.mimeType + ", displayName=" + this.displayName + ")";
        }

        public File(String str, String str2, String str3, String str4, Long l10, String str5, String str6) {
            super(null);
            this.fileId = str;
            this.uri = str2;
            this.url = str3;
            this.fileName = str4;
            this.fileSize = l10;
            this.mimeType = str5;
            this.displayName = str6;
            this.contentType = ChatContentType.FILE;
        }

        public /* synthetic */ File(String str, String str2, String str3, String str4, Long l10, String str5, String str6, int i10, i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : l10, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? "" : str6);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"LK6/i$f;", "LK6/i;", "", Parameters.ROOT, "", "LK6/t;", "tree", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Ljava/util/List;", "e", "()Ljava/util/List;", "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$f, reason: from toString */
    public static final /* data */ class Folder extends AbstractC0913i {
        private final ChatContentType contentType;
        private final String root;
        private final List<FolderNode> tree;

        /* JADX WARN: Multi-variable type inference failed */
        public Folder() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final String getRoot() {
            return this.root;
        }

        public final List<FolderNode> e() {
            return this.tree;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Folder)) {
                return false;
            }
            Folder folder = (Folder) other;
            return p.d(this.root, folder.root) && p.d(this.tree, folder.tree);
        }

        public int hashCode() {
            String str = this.root;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.tree.hashCode();
        }

        public String toString() {
            return "Folder(root=" + this.root + ", tree=" + this.tree + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Folder(String str, List<FolderNode> tree) {
            super(null);
            p.i(tree, "tree");
            this.root = str;
            this.tree = tree;
            this.contentType = ChatContentType.FOLDER;
        }

        public /* synthetic */ Folder(String str, List list, int i10, i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? C1173v.m() : list);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001c\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001d\u0010\rR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"LK6/i$g;", "LK6/i;", "", "fileId", "uri", "base64", "thumbnailUrl", "mimeType", "url", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "e", "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$g, reason: from toString */
    public static final /* data */ class Image extends AbstractC0913i {
        private final String base64;
        private final ChatContentType contentType;
        private final String displayName;
        private final String fileId;
        private final String mimeType;
        private final String thumbnailUrl;
        private final String uri;
        private final String url;

        public Image() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final String getBase64() {
            return this.base64;
        }

        /* renamed from: e, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return p.d(this.fileId, image.fileId) && p.d(this.uri, image.uri) && p.d(this.base64, image.base64) && p.d(this.thumbnailUrl, image.thumbnailUrl) && p.d(this.mimeType, image.mimeType) && p.d(this.url, image.url) && p.d(this.displayName, image.displayName);
        }

        /* renamed from: f, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: g, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: h, reason: from getter */
        public final String getThumbnailUrl() {
            return this.thumbnailUrl;
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.uri;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.base64;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.thumbnailUrl;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.mimeType;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.url;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.displayName;
            return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
        }

        /* renamed from: i, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        /* renamed from: j, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public String toString() {
            return "Image(fileId=" + this.fileId + ", uri=" + this.uri + ", base64=" + this.base64 + ", thumbnailUrl=" + this.thumbnailUrl + ", mimeType=" + this.mimeType + ", url=" + this.url + ", displayName=" + this.displayName + ")";
        }

        public Image(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            super(null);
            this.fileId = str;
            this.uri = str2;
            this.base64 = str3;
            this.thumbnailUrl = str4;
            this.mimeType = str5;
            this.url = str6;
            this.displayName = str7;
            this.contentType = ChatContentType.IMAGE;
        }

        public /* synthetic */ Image(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? "" : str7);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"LK6/i$h;", "LK6/i;", "", "text", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$h, reason: from toString */
    public static final /* data */ class Text extends AbstractC0913i {
        private final ChatContentType contentType;
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(String text) {
            super(null);
            p.i(text, "text");
            this.text = text;
            this.contentType = ChatContentType.TEXT;
        }

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Text) && p.d(this.text, ((Text) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Text(text=" + this.text + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"LK6/i$i;", "LK6/i;", "", "fileId", "uri", "coverUrl", "mimeType", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFileId", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "f", "e", "Lcom/stepos/common/ChatContentType;", "contentType", "Lcom/stepos/common/ChatContentType;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/common/ChatContentType;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: K6.i$i, reason: collision with other inner class name and from toString */
    public static final /* data */ class Video extends AbstractC0913i {
        private final ChatContentType contentType;
        private final String coverUrl;
        private final String displayName;
        private final String fileId;
        private final String mimeType;
        private final String uri;

        public Video() {
            this(null, null, null, null, null, 31, null);
        }

        @Override // kotlin.AbstractC0913i
        /* renamed from: b, reason: from getter */
        public ChatContentType getContentType() {
            return this.contentType;
        }

        /* renamed from: d, reason: from getter */
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        /* renamed from: e, reason: from getter */
        public final String getDisplayName() {
            return this.displayName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return p.d(this.fileId, video.fileId) && p.d(this.uri, video.uri) && p.d(this.coverUrl, video.coverUrl) && p.d(this.mimeType, video.mimeType) && p.d(this.displayName, video.displayName);
        }

        /* renamed from: f, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: g, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.uri;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.coverUrl;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.mimeType;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.displayName;
            return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Video(fileId=" + this.fileId + ", uri=" + this.uri + ", coverUrl=" + this.coverUrl + ", mimeType=" + this.mimeType + ", displayName=" + this.displayName + ")";
        }

        public Video(String str, String str2, String str3, String str4, String str5) {
            super(null);
            this.fileId = str;
            this.uri = str2;
            this.coverUrl = str3;
            this.mimeType = str4;
            this.displayName = str5;
            this.contentType = ChatContentType.VIDEO;
        }

        public /* synthetic */ Video(String str, String str2, String str3, String str4, String str5, int i10, i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? "" : str5);
        }
    }

    public /* synthetic */ AbstractC0913i(i iVar) {
        this();
    }

    public final AbstractC0913i a(Map<String, String> map) {
        if (map != null) {
            this._extra.putAll(map);
        }
        return this;
    }

    /* renamed from: b */
    public abstract ChatContentType getContentType();

    public final Map<String, String> c() {
        return this._extra;
    }

    public AbstractC0913i() {
        this._extra = new LinkedHashMap();
    }
}
