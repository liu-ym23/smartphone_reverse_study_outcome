package u4;

import Y8.t;
import Z8.C1173v;
import android.graphics.Bitmap;
import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.utils.CompressConfig;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Arrays;
import java.util.List;
import kotlin.FolderNode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0005\u0014\u0007\u0013\u0010\n\u0012\u0011\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0006\u0082\u0001\t\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lu4/m;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "c", "delta", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "text", Const.INTENT_KEY_PKGNAME, "streamChunk", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "e", "Lu4/m$a;", "Lu4/m$b;", "Lu4/m$c;", "Lu4/m$d;", "Lu4/m$e;", "Lu4/m$f;", "Lu4/m$g;", "Lu4/m$h;", "Lu4/m$i;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class m {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lu4/m$a;", "Lu4/m;", "", "fileId", "uri", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFileId", "getUri", "getMimeType", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$a, reason: from toString */
    public static final /* data */ class AudioMessage extends m {
        private final String fileId;
        private final String mimeType;
        private final String uri;

        public AudioMessage() {
            this(null, null, null, 7, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AudioMessage)) {
                return false;
            }
            AudioMessage audioMessage = (AudioMessage) other;
            return p.d(this.fileId, audioMessage.fileId) && p.d(this.uri, audioMessage.uri) && p.d(this.mimeType, audioMessage.mimeType);
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.uri;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.mimeType;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "AudioMessage(fileId=" + this.fileId + ", uri=" + this.uri + ", mimeType=" + this.mimeType + ")";
        }

        public AudioMessage(String str, String str2, String str3) {
            super(null);
            this.fileId = str;
            this.uri = str2;
            this.mimeType = str3;
        }

        public /* synthetic */ AudioMessage(String str, String str2, String str3, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019¨\u0006\u001a"}, d2 = {"Lu4/m$b;", "Lu4/m;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "audioId", "Ljava/lang/String;", "getAudioId", "setAudioId", "(Ljava/lang/String;)V", "", "data", "[B", "getData", "()[B", "isEnd", "Z", "()Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$b, reason: from toString */
    public static final /* data */ class AudioStreamMessage extends m {
        private String audioId;
        private final byte[] data;
        private final boolean isEnd;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!p.d(AudioStreamMessage.class, other != null ? other.getClass() : null)) {
                return false;
            }
            p.g(other, "null cannot be cast to non-null type com.stepos.agentframework.chatcore.session.bean.MessageContent.AudioStreamMessage");
            AudioStreamMessage audioStreamMessage = (AudioStreamMessage) other;
            return this.isEnd == audioStreamMessage.isEnd && p.d(this.audioId, audioStreamMessage.audioId) && Arrays.equals(this.data, audioStreamMessage.data);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.isEnd) * 31) + this.audioId.hashCode()) * 31;
            byte[] bArr = this.data;
            return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }

        public String toString() {
            return "AudioStreamMessage(audioId=" + this.audioId + ", data=" + Arrays.toString(this.data) + ", isEnd=" + this.isEnd + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001e\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001f\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b \u0010\u0011R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b!\u0010\u0011R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\"\u0010\u0011R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b#\u0010\u0011R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0013¨\u0006&"}, d2 = {"Lu4/m$c;", "Lu4/m;", "", "fileId", "Landroid/net/Uri;", "uri", "url", "localPath", "fileName", "fileSize", "mimeType", "fileExtension", "", "fileType", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "k", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "p", "getLocalPath", "l", "m", "o", "getFileExtension", "I", "n", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$c, reason: from toString */
    public static final /* data */ class FileMessage extends m {
        private final String fileExtension;
        private final String fileId;
        private final String fileName;
        private final String fileSize;
        private final int fileType;
        private final String localPath;
        private final String mimeType;
        private final Uri uri;
        private final String url;

        public FileMessage() {
            this(null, null, null, null, null, null, null, null, 0, 511, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileMessage)) {
                return false;
            }
            FileMessage fileMessage = (FileMessage) other;
            return p.d(this.fileId, fileMessage.fileId) && p.d(this.uri, fileMessage.uri) && p.d(this.url, fileMessage.url) && p.d(this.localPath, fileMessage.localPath) && p.d(this.fileName, fileMessage.fileName) && p.d(this.fileSize, fileMessage.fileSize) && p.d(this.mimeType, fileMessage.mimeType) && p.d(this.fileExtension, fileMessage.fileExtension) && this.fileType == fileMessage.fileType;
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Uri uri = this.uri;
            int iHashCode2 = (iHashCode + (uri == null ? 0 : uri.hashCode())) * 31;
            String str2 = this.url;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.localPath;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.fileName;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.fileSize;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.mimeType;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.fileExtension;
            return ((iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31) + Integer.hashCode(this.fileType);
        }

        /* renamed from: k, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: l, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        /* renamed from: m, reason: from getter */
        public final String getFileSize() {
            return this.fileSize;
        }

        /* renamed from: n, reason: from getter */
        public final int getFileType() {
            return this.fileType;
        }

        /* renamed from: o, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: p, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public String toString() {
            return "FileMessage(fileId=" + this.fileId + ", uri=" + this.uri + ", url=" + this.url + ", localPath=" + this.localPath + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", mimeType=" + this.mimeType + ", fileExtension=" + this.fileExtension + ", fileType=" + this.fileType + ")";
        }

        public FileMessage(String str, Uri uri, String str2, String str3, String str4, String str5, String str6, String str7, int i10) {
            super(null);
            this.fileId = str;
            this.uri = uri;
            this.url = str2;
            this.localPath = str3;
            this.fileName = str4;
            this.fileSize = str5;
            this.mimeType = str6;
            this.fileExtension = str7;
            this.fileType = i10;
        }

        public /* synthetic */ FileMessage(String str, Uri uri, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, kotlin.jvm.internal.i iVar) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : uri, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : str4, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : str6, (i11 & 128) != 0 ? null : str7, (i11 & 256) != 0 ? 5 : i10);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lu4/m$d;", "Lu4/m;", "", Parameters.ROOT, "", "LK6/t;", "tree", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "k", "(Ljava/lang/String;Ljava/util/List;)Lu4/m$d;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "m", "Ljava/util/List;", "n", "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$d, reason: from toString */
    public static final /* data */ class FolderMessage extends m {
        private final String root;
        private final List<FolderNode> tree;

        /* JADX WARN: Multi-variable type inference failed */
        public FolderMessage() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FolderMessage l(FolderMessage folderMessage, String str, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = folderMessage.root;
            }
            if ((i10 & 2) != 0) {
                list = folderMessage.tree;
            }
            return folderMessage.k(str, list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FolderMessage)) {
                return false;
            }
            FolderMessage folderMessage = (FolderMessage) other;
            return p.d(this.root, folderMessage.root) && p.d(this.tree, folderMessage.tree);
        }

        public int hashCode() {
            String str = this.root;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.tree.hashCode();
        }

        public final FolderMessage k(String root, List<FolderNode> tree) {
            p.i(tree, "tree");
            return new FolderMessage(root, tree);
        }

        /* renamed from: m, reason: from getter */
        public final String getRoot() {
            return this.root;
        }

        public final List<FolderNode> n() {
            return this.tree;
        }

        public String toString() {
            return "FolderMessage(root=" + this.root + ", tree=" + this.tree + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FolderMessage(String str, List<FolderNode> tree) {
            super(null);
            p.i(tree, "tree");
            this.root = str;
            this.tree = tree;
        }

        public /* synthetic */ FolderMessage(String str, List list, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? C1173v.m() : list);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0015R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010!R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010!R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001d\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010!R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b.\u0010\u0015R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b/\u0010\u0015R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b0\u0010\u0015R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lu4/m$e;", "Lu4/m;", "", "fileId", "localPath", "fileName", "Landroid/graphics/Bitmap;", "bitmap", "url", "Landroid/net/Uri;", "uri", "base64", "thumbnailUrl", "mimeType", "Lcom/stepos/agentframework/chatcore/utils/a;", "compressConfig", "", "silent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/utils/a;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "m", "o", "t", "(Ljava/lang/String;)V", "n", "s", "Landroid/graphics/Bitmap;", "k", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "r", "u", "Landroid/net/Uri;", "q", "()Landroid/net/Uri;", "getBase64", "getThumbnailUrl", "getMimeType", "Lcom/stepos/agentframework/chatcore/utils/a;", "l", "()Lcom/stepos/agentframework/chatcore/utils/a;", "setCompressConfig", "(Lcom/stepos/agentframework/chatcore/utils/a;)V", "Z", "p", "()Z", "setSilent", "(Z)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$e, reason: from toString */
    public static final /* data */ class ImageMessage extends m {
        private final String base64;
        private Bitmap bitmap;
        private CompressConfig compressConfig;
        private final String fileId;
        private String fileName;
        private String localPath;
        private final String mimeType;
        private boolean silent;
        private final String thumbnailUrl;
        private final Uri uri;
        private String url;

        public ImageMessage() {
            this(null, null, null, null, null, null, null, null, null, null, false, 2047, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageMessage)) {
                return false;
            }
            ImageMessage imageMessage = (ImageMessage) other;
            return p.d(this.fileId, imageMessage.fileId) && p.d(this.localPath, imageMessage.localPath) && p.d(this.fileName, imageMessage.fileName) && p.d(this.bitmap, imageMessage.bitmap) && p.d(this.url, imageMessage.url) && p.d(this.uri, imageMessage.uri) && p.d(this.base64, imageMessage.base64) && p.d(this.thumbnailUrl, imageMessage.thumbnailUrl) && p.d(this.mimeType, imageMessage.mimeType) && p.d(this.compressConfig, imageMessage.compressConfig) && this.silent == imageMessage.silent;
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.localPath;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.fileName;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Bitmap bitmap = this.bitmap;
            int iHashCode4 = (iHashCode3 + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
            String str4 = this.url;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Uri uri = this.uri;
            int iHashCode6 = (iHashCode5 + (uri == null ? 0 : uri.hashCode())) * 31;
            String str5 = this.base64;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.thumbnailUrl;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.mimeType;
            int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            CompressConfig compressConfig = this.compressConfig;
            return ((iHashCode9 + (compressConfig != null ? compressConfig.hashCode() : 0)) * 31) + Boolean.hashCode(this.silent);
        }

        /* renamed from: k, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* renamed from: l, reason: from getter */
        public final CompressConfig getCompressConfig() {
            return this.compressConfig;
        }

        /* renamed from: m, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: n, reason: from getter */
        public final String getFileName() {
            return this.fileName;
        }

        /* renamed from: o, reason: from getter */
        public final String getLocalPath() {
            return this.localPath;
        }

        /* renamed from: p, reason: from getter */
        public final boolean getSilent() {
            return this.silent;
        }

        /* renamed from: q, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* renamed from: r, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final void s(String str) {
            this.fileName = str;
        }

        public final void t(String str) {
            this.localPath = str;
        }

        public String toString() {
            return "ImageMessage(fileId=" + this.fileId + ", localPath=" + this.localPath + ", fileName=" + this.fileName + ", bitmap=" + this.bitmap + ", url=" + this.url + ", uri=" + this.uri + ", base64=" + this.base64 + ", thumbnailUrl=" + this.thumbnailUrl + ", mimeType=" + this.mimeType + ", compressConfig=" + this.compressConfig + ", silent=" + this.silent + ")";
        }

        public final void u(String str) {
            this.url = str;
        }

        public ImageMessage(String str, String str2, String str3, Bitmap bitmap, String str4, Uri uri, String str5, String str6, String str7, CompressConfig compressConfig, boolean z10) {
            super(null);
            this.fileId = str;
            this.localPath = str2;
            this.fileName = str3;
            this.bitmap = bitmap;
            this.url = str4;
            this.uri = uri;
            this.base64 = str5;
            this.thumbnailUrl = str6;
            this.mimeType = str7;
            this.compressConfig = compressConfig;
            this.silent = z10;
        }

        public /* synthetic */ ImageMessage(String str, String str2, String str3, Bitmap bitmap, String str4, Uri uri, String str5, String str6, String str7, CompressConfig compressConfig, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : bitmap, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : uri, (i10 & 64) != 0 ? null : str5, (i10 & 128) != 0 ? null : str6, (i10 & 256) != 0 ? null : str7, (i10 & 512) != 0 ? null : compressConfig, (i10 & 1024) != 0 ? false : z10);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lu4/m$f;", "Lu4/m;", "", "inquiryId", c.a.COL_SUMMARY, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "k", "l", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$f, reason: from toString */
    public static final /* data */ class InquiryMessage extends m {
        private final String inquiryId;
        private final String summary;

        /* JADX WARN: Multi-variable type inference failed */
        public InquiryMessage() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InquiryMessage)) {
                return false;
            }
            InquiryMessage inquiryMessage = (InquiryMessage) other;
            return p.d(this.inquiryId, inquiryMessage.inquiryId) && p.d(this.summary, inquiryMessage.summary);
        }

        public int hashCode() {
            return (this.inquiryId.hashCode() * 31) + this.summary.hashCode();
        }

        /* renamed from: k, reason: from getter */
        public final String getInquiryId() {
            return this.inquiryId;
        }

        /* renamed from: l, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        public String toString() {
            return "InquiryMessage(inquiryId=" + this.inquiryId + ", summary=" + this.summary + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InquiryMessage(String inquiryId, String summary) {
            super(null);
            p.i(inquiryId, "inquiryId");
            p.i(summary, "summary");
            this.inquiryId = inquiryId;
            this.summary = summary;
        }

        public /* synthetic */ InquiryMessage(String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dBA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tB9\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001b\u0010\f¨\u0006\u001e"}, d2 = {"Lu4/m$g;", "Lu4/m;", "", "taskId", "sessionId", "messageId", "appUIName", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "k", "()Ljava/lang/String;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "l", "getSessionId", "getMessageId", "getAppUIName", "m", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$g, reason: from toString */
    public static final /* data */ class TaskMessage extends m {
        public static final String APP_UI_NAME_TEXT_TO_IMAGE = "app_ui_name_text_to_image";

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final String TASK_CARD_MEDIUM = "TaskInfoCardMediumView";
        public static final String TASK_TYPE_IMAGE = "image";
        public static final String defaultTaskCardAppUIName = "app_ui_name_game";
        private final String appUIName;
        private final String messageId;
        private final String sessionId;
        private final String taskId;
        private final String type;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lu4/m$g$a;", "", "<init>", "()V", "", "type", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "TASK_TYPE_IMAGE", "Ljava/lang/String;", "APP_UI_NAME_TEXT_TO_IMAGE", "defaultTaskCardAppUIName", "TASK_CARD_MEDIUM", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: u4.m$g$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final String b(String type) {
                return (type == null || !p.d(type, "image")) ? TaskMessage.defaultTaskCardAppUIName : TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE;
            }

            public Companion() {
            }
        }

        public TaskMessage() {
            this(null, null, null, null, null, 31, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskMessage)) {
                return false;
            }
            TaskMessage taskMessage = (TaskMessage) other;
            return p.d(this.taskId, taskMessage.taskId) && p.d(this.sessionId, taskMessage.sessionId) && p.d(this.messageId, taskMessage.messageId) && p.d(this.appUIName, taskMessage.appUIName) && p.d(this.type, taskMessage.type);
        }

        public int hashCode() {
            String str = this.taskId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.sessionId;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.messageId;
            int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.appUIName.hashCode()) * 31;
            String str4 = this.type;
            return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        public final String k() {
            return p.d(this.appUIName, TASK_CARD_MEDIUM) ? defaultTaskCardAppUIName : this.appUIName;
        }

        /* renamed from: l, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: m, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public String toString() {
            return "TaskMessage(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", appUIName=" + this.appUIName + ", type=" + this.type + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TaskMessage(String str, String str2, String str3, String appUIName, String str4) {
            super(null);
            p.i(appUIName, "appUIName");
            this.taskId = str;
            this.sessionId = str2;
            this.messageId = str3;
            this.appUIName = appUIName;
            this.type = str4;
        }

        public /* synthetic */ TaskMessage(String str, String str2, String str3, String str4, String str5, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? defaultTaskCardAppUIName : str4, (i10 & 16) != 0 ? null : str5);
        }

        public TaskMessage(String str, String str2, String str3, String str4) {
            this(str, str2, str3, INSTANCE.b(str4), str4);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\u0016R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lu4/m$h;", "Lu4/m;", "", "text", "streamChunk", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "k", "(Ljava/lang/String;Ljava/lang/String;)Lu4/m$h;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "n", "p", "(Ljava/lang/String;)V", "m", "o", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$h, reason: from toString */
    public static final /* data */ class TextMessage extends m {
        private String streamChunk;
        private String text;

        /* JADX WARN: Multi-variable type inference failed */
        public TextMessage() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ TextMessage l(TextMessage textMessage, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = textMessage.text;
            }
            if ((i10 & 2) != 0) {
                str2 = textMessage.streamChunk;
            }
            return textMessage.k(str, str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextMessage)) {
                return false;
            }
            TextMessage textMessage = (TextMessage) other;
            return p.d(this.text, textMessage.text) && p.d(this.streamChunk, textMessage.streamChunk);
        }

        public int hashCode() {
            int iHashCode = this.text.hashCode() * 31;
            String str = this.streamChunk;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public final TextMessage k(String text, String streamChunk) {
            p.i(text, "text");
            return new TextMessage(text, streamChunk);
        }

        /* renamed from: m, reason: from getter */
        public final String getStreamChunk() {
            return this.streamChunk;
        }

        /* renamed from: n, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final void o(String str) {
            this.streamChunk = str;
        }

        public final void p(String str) {
            p.i(str, "<set-?>");
            this.text = str;
        }

        public String toString() {
            return "TextMessage(text=" + this.text + ", streamChunk=" + this.streamChunk + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextMessage(String text, String str) {
            super(null);
            p.i(text, "text");
            this.text = text;
            this.streamChunk = str;
        }

        public /* synthetic */ TextMessage(String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : str2);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010#R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010#R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001a\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b*\u0010\u0011R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b+\u0010\u0011R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lu4/m$i;", "Lu4/m;", "", "fileId", "Landroid/net/Uri;", "uri", "localPath", "compressedPath", "fileName", "url", "coverUrl", "mimeType", "Lcom/stepos/agentframework/chatcore/utils/a;", "compressConfig", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/utils/a;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFileId", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "getLocalPath", "setLocalPath", "(Ljava/lang/String;)V", "getCompressedPath", "setCompressedPath", "getFileName", "setFileName", "getUrl", "setUrl", "getCoverUrl", "getMimeType", "Lcom/stepos/agentframework/chatcore/utils/a;", "getCompressConfig", "()Lcom/stepos/agentframework/chatcore/utils/a;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u4.m$i, reason: from toString */
    public static final /* data */ class VideoMessage extends m {
        private final CompressConfig compressConfig;
        private String compressedPath;
        private final String coverUrl;
        private final String fileId;
        private String fileName;
        private String localPath;
        private final String mimeType;
        private Uri uri;
        private String url;

        public VideoMessage() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoMessage)) {
                return false;
            }
            VideoMessage videoMessage = (VideoMessage) other;
            return p.d(this.fileId, videoMessage.fileId) && p.d(this.uri, videoMessage.uri) && p.d(this.localPath, videoMessage.localPath) && p.d(this.compressedPath, videoMessage.compressedPath) && p.d(this.fileName, videoMessage.fileName) && p.d(this.url, videoMessage.url) && p.d(this.coverUrl, videoMessage.coverUrl) && p.d(this.mimeType, videoMessage.mimeType) && p.d(this.compressConfig, videoMessage.compressConfig);
        }

        public int hashCode() {
            String str = this.fileId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Uri uri = this.uri;
            int iHashCode2 = (iHashCode + (uri == null ? 0 : uri.hashCode())) * 31;
            String str2 = this.localPath;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.compressedPath;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.fileName;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.url;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.coverUrl;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.mimeType;
            int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
            CompressConfig compressConfig = this.compressConfig;
            return iHashCode8 + (compressConfig != null ? compressConfig.hashCode() : 0);
        }

        public String toString() {
            return "VideoMessage(fileId=" + this.fileId + ", uri=" + this.uri + ", localPath=" + this.localPath + ", compressedPath=" + this.compressedPath + ", fileName=" + this.fileName + ", url=" + this.url + ", coverUrl=" + this.coverUrl + ", mimeType=" + this.mimeType + ", compressConfig=" + this.compressConfig + ")";
        }

        public VideoMessage(String str, Uri uri, String str2, String str3, String str4, String str5, String str6, String str7, CompressConfig compressConfig) {
            super(null);
            this.fileId = str;
            this.uri = uri;
            this.localPath = str2;
            this.compressedPath = str3;
            this.fileName = str4;
            this.url = str5;
            this.coverUrl = str6;
            this.mimeType = str7;
            this.compressConfig = compressConfig;
        }

        public /* synthetic */ VideoMessage(String str, Uri uri, String str2, String str3, String str4, String str5, String str6, String str7, CompressConfig compressConfig, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : uri, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : compressConfig);
        }
    }

    public /* synthetic */ m(kotlin.jvm.internal.i iVar) {
        this();
    }

    public final void a(String delta) {
        p.i(delta, "delta");
        if (delta.length() != 0 && (this instanceof TextMessage)) {
            synchronized (this) {
                try {
                    TextMessage textMessage = (TextMessage) this;
                    String streamChunk = ((TextMessage) this).getStreamChunk();
                    if (streamChunk == null) {
                        streamChunk = "";
                    }
                    textMessage.o(streamChunk + delta);
                    t tVar = t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void b(String text) {
        p.i(text, "text");
        if (this instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) this;
            textMessage.p(textMessage.getText() + text);
        }
    }

    public final String c() {
        String streamChunk;
        if (!(this instanceof TextMessage)) {
            return null;
        }
        synchronized (this) {
            streamChunk = ((TextMessage) this).getStreamChunk();
        }
        return streamChunk;
    }

    public final String d() {
        if (this instanceof FileMessage) {
            return ((FileMessage) this).getFileId();
        }
        return null;
    }

    public final String e() {
        if (this instanceof FileMessage) {
            return ((FileMessage) this).getUrl();
        }
        return null;
    }

    public final String f() {
        if (this instanceof ImageMessage) {
            return ((ImageMessage) this).getFileId();
        }
        return null;
    }

    public final String g() {
        if (this instanceof ImageMessage) {
            return ((ImageMessage) this).getUrl();
        }
        return null;
    }

    public final String h() {
        return this instanceof TextMessage ? ((TextMessage) this).getText() : "";
    }

    public final void i(String streamChunk) {
        p.i(streamChunk, "streamChunk");
        if (this instanceof TextMessage) {
            synchronized (this) {
                ((TextMessage) this).o(streamChunk);
                t tVar = t.f7040a;
            }
        }
    }

    public final String j() {
        String streamChunk;
        if (!(this instanceof TextMessage)) {
            return "";
        }
        synchronized (this) {
            try {
                streamChunk = ((TextMessage) this).getStreamChunk();
                if (streamChunk == null) {
                    streamChunk = "";
                }
                if (streamChunk.length() > 0) {
                    ((TextMessage) this).o("");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return streamChunk;
    }

    public m() {
    }
}
