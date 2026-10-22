package a4;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0001\u001bB{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001e\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u0014R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010&R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010\u0012¨\u00063"}, d2 = {"La4/l;", "", "", "type", "blob", "mime", "sha256", "", ContentDisposition.Parameters.Size, "width", "height", "", "durationMs", "", "metadata", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Map;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getType", "getBlob", "c", "getMime", Const.INTENT_KEY_UMID, "getSha256", "e", "Ljava/lang/Integer;", "getSize", "()Ljava/lang/Integer;", "f", "getWidth", Const.INTENT_KEY_BACKGROUND_COMMAND, "getHeight", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Long;", "getDurationMs", "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/Map;", "getMetadata", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.l, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class Attachment {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    public static final Set<String> f7998k = Y.j("type", "blob", "mime", "sha256", ContentDisposition.Parameters.Size, "width", "height", "duration", "durationMs");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String blob;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String mime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sha256;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer size;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer width;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer height;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final Long durationMs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> metadata;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"La4/l$a;", "", "<init>", "()V", "", "", "m", "La4/l;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;)La4/l;", "", "KNOWN_KEYS", "Ljava/util/Set;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: a4.l$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00a7 A[PHI: r12
          0x00a7: PHI (r12v36 java.lang.Number) = (r12v28 java.lang.Number), (r12v32 java.lang.Number) binds: [B:45:0x00a5, B:52:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final a4.Attachment a(java.util.Map<java.lang.String, ? extends java.lang.Object> r13) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: a4.Attachment.Companion.a(java.util.Map):a4.l");
        }

        public Companion() {
        }
    }

    public Attachment(String type, String str, String str2, String str3, Integer num, Integer num2, Integer num3, Long l10, Map<String, ? extends Object> metadata) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(metadata, "metadata");
        this.type = type;
        this.blob = str;
        this.mime = str2;
        this.sha256 = str3;
        this.size = num;
        this.width = num2;
        this.height = num3;
        this.durationMs = l10;
        this.metadata = metadata;
    }

    public final Map<String, Object> b() {
        HashMap map = new HashMap();
        map.put("type", this.type);
        String str = this.blob;
        if (str != null) {
            map.put("blob", str);
        }
        String str2 = this.mime;
        if (str2 != null) {
            map.put("mime", str2);
        }
        String str3 = this.sha256;
        if (str3 != null) {
            map.put("sha256", str3);
        }
        Integer num = this.size;
        if (num != null) {
            map.put(ContentDisposition.Parameters.Size, Integer.valueOf(num.intValue()));
        }
        Integer num2 = this.width;
        if (num2 != null) {
            map.put("width", Integer.valueOf(num2.intValue()));
        }
        Integer num3 = this.height;
        if (num3 != null) {
            map.put("height", Integer.valueOf(num3.intValue()));
        }
        Long l10 = this.durationMs;
        if (l10 != null) {
            map.put("duration", Long.valueOf(l10.longValue()));
        }
        if (!this.metadata.isEmpty()) {
            map.putAll(this.metadata);
        }
        return map;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) other;
        return kotlin.jvm.internal.p.d(this.type, attachment.type) && kotlin.jvm.internal.p.d(this.blob, attachment.blob) && kotlin.jvm.internal.p.d(this.mime, attachment.mime) && kotlin.jvm.internal.p.d(this.sha256, attachment.sha256) && kotlin.jvm.internal.p.d(this.size, attachment.size) && kotlin.jvm.internal.p.d(this.width, attachment.width) && kotlin.jvm.internal.p.d(this.height, attachment.height) && kotlin.jvm.internal.p.d(this.durationMs, attachment.durationMs) && kotlin.jvm.internal.p.d(this.metadata, attachment.metadata);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.blob;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mime;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sha256;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.size;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.width;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.height;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Long l10 = this.durationMs;
        return ((iHashCode7 + (l10 != null ? l10.hashCode() : 0)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "Attachment(type=" + this.type + ", blob=" + this.blob + ", mime=" + this.mime + ", sha256=" + this.sha256 + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ", durationMs=" + this.durationMs + ", metadata=" + this.metadata + ")";
    }
}
