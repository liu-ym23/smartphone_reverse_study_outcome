package com.stepos.agentbus.generated;

import D7.q;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eHÆ\u0003J\u0084\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/stepos/agentbus/generated/Attachment;", "", "type", "", "blob", "mime", "sha256", "size", "", "width", "height", "durationMs", "", "metadata", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)V", "getType", "()Ljava/lang/String;", "getBlob", "getMime", "getSha256", "getSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "getHeight", "getDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMetadata", "()Ljava/util/Map;", "toMap", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;)Lcom/stepos/agentbus/generated/Attachment;", "equals", "", "other", "hashCode", "toString", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Attachment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> KNOWN_KEYS = q.K0(new String[]{"type", "blob", "mime", "sha256", "size", "width", "height", TypedValues.TransitionType.S_DURATION, "durationMs"});
    private final String blob;
    private final Long durationMs;
    private final Integer height;
    private final Map<String, Object> metadata;
    private final String mime;
    private final String sha256;
    private final Integer size;
    private final String type;
    private final Integer width;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007J=\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentbus/generated/Attachment$Companion;", "", AppAgent.CONSTRUCT, "()V", "image", "Lcom/stepos/agentbus/generated/Attachment;", "blob", "", "width", "", "height", "mime", "sha256", "size", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stepos/agentbus/generated/Attachment;", BffConstant.Type.File, BffConstant.Type.Audio, "durationMs", "", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stepos/agentbus/generated/Attachment;", "fromMap", "m", "", "KNOWN_KEYS", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ Attachment audio$default(Companion companion, String str, long j5, String str2, String str3, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = "audio/m4a";
            }
            return companion.audio(str, j5, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num);
        }

        public static /* synthetic */ Attachment file$default(Companion companion, String str, int i, String str2, String str3, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                str2 = "application/octet-stream";
            }
            if ((i6 & 8) != 0) {
                str3 = null;
            }
            return companion.file(str, i, str2, str3);
        }

        public static /* synthetic */ Attachment image$default(Companion companion, String str, int i, int i6, String str2, String str3, Integer num, int i10, Object obj) {
            if ((i10 & 8) != 0) {
                str2 = "image/jpeg";
            }
            return companion.image(str, i, i6, str2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : num);
        }

        public final Attachment audio(String blob, long durationMs, String mime, String sha256, Integer size) {
            k.f(blob, "blob");
            k.f(mime, "mime");
            return new Attachment(BffConstant.Type.Audio, blob, mime, sha256, size, null, null, Long.valueOf(durationMs), null, 352, null);
        }

        public final Attachment file(String blob, int size, String mime, String sha256) {
            k.f(blob, "blob");
            k.f(mime, "mime");
            return new Attachment(BffConstant.Type.File, blob, mime, sha256, Integer.valueOf(size), null, null, null, null, 480, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x00a7 A[PHI: r12
          0x00a7: PHI (r12v36 java.lang.Number) = (r12v28 java.lang.Number), (r12v32 java.lang.Number) binds: [B:45:0x00a5, B:52:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.agentbus.generated.Attachment fromMap(java.util.Map<java.lang.String, ? extends java.lang.Object> r13) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.Attachment.Companion.fromMap(java.util.Map):com.stepos.agentbus.generated.Attachment");
        }

        public final Attachment image(String blob, int width, int height, String mime, String sha256, Integer size) {
            k.f(blob, "blob");
            k.f(mime, "mime");
            return new Attachment("image", blob, mime, sha256, size, Integer.valueOf(width), Integer.valueOf(height), null, null, 384, null);
        }

        private Companion() {
        }
    }

    public Attachment(String type, String str, String str2, String str3, Integer num, Integer num2, Integer num3, Long l, Map<String, ? extends Object> metadata) {
        k.f(type, "type");
        k.f(metadata, "metadata");
        this.type = type;
        this.blob = str;
        this.mime = str2;
        this.sha256 = str3;
        this.size = num;
        this.width = num2;
        this.height = num3;
        this.durationMs = l;
        this.metadata = metadata;
    }

    public static /* synthetic */ Attachment copy$default(Attachment attachment, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, Long l, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attachment.type;
        }
        if ((i & 2) != 0) {
            str2 = attachment.blob;
        }
        if ((i & 4) != 0) {
            str3 = attachment.mime;
        }
        if ((i & 8) != 0) {
            str4 = attachment.sha256;
        }
        if ((i & 16) != 0) {
            num = attachment.size;
        }
        if ((i & 32) != 0) {
            num2 = attachment.width;
        }
        if ((i & 64) != 0) {
            num3 = attachment.height;
        }
        if ((i & 128) != 0) {
            l = attachment.durationMs;
        }
        if ((i & 256) != 0) {
            map = attachment.metadata;
        }
        Long l5 = l;
        Map map2 = map;
        Integer num4 = num2;
        Integer num5 = num3;
        Integer num6 = num;
        String str5 = str3;
        return attachment.copy(str, str2, str5, str4, num6, num4, num5, l5, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBlob() {
        return this.blob;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMime() {
        return this.mime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSha256() {
        return this.sha256;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getSize() {
        return this.size;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final Map<String, Object> component9() {
        return this.metadata;
    }

    public final Attachment copy(String type, String blob, String mime, String sha256, Integer size, Integer width, Integer height, Long durationMs, Map<String, ? extends Object> metadata) {
        k.f(type, "type");
        k.f(metadata, "metadata");
        return new Attachment(type, blob, mime, sha256, size, width, height, durationMs, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) other;
        return k.b(this.type, attachment.type) && k.b(this.blob, attachment.blob) && k.b(this.mime, attachment.mime) && k.b(this.sha256, attachment.sha256) && k.b(this.size, attachment.size) && k.b(this.width, attachment.width) && k.b(this.height, attachment.height) && k.b(this.durationMs, attachment.durationMs) && k.b(this.metadata, attachment.metadata);
    }

    public final String getBlob() {
        return this.blob;
    }

    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getMime() {
        return this.mime;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getWidth() {
        return this.width;
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
        Long l = this.durationMs;
        return this.metadata.hashCode() + ((iHashCode7 + (l != null ? l.hashCode() : 0)) * 31);
    }

    public final Map<String, Object> toMap() {
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
            map.put("size", Integer.valueOf(num.intValue()));
        }
        Integer num2 = this.width;
        if (num2 != null) {
            map.put("width", Integer.valueOf(num2.intValue()));
        }
        Integer num3 = this.height;
        if (num3 != null) {
            map.put("height", Integer.valueOf(num3.intValue()));
        }
        Long l = this.durationMs;
        if (l != null) {
            map.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(l.longValue()));
        }
        if (!this.metadata.isEmpty()) {
            map.putAll(this.metadata);
        }
        return map;
    }

    public String toString() {
        String str = this.type;
        String str2 = this.blob;
        String str3 = this.mime;
        String str4 = this.sha256;
        Integer num = this.size;
        Integer num2 = this.width;
        Integer num3 = this.height;
        Long l = this.durationMs;
        Map<String, Object> map = this.metadata;
        StringBuilder sbW = B7.a.w("Attachment(type=", str, ", blob=", str2, ", mime=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", sha256=", str4, ", size=");
        sbW.append(num);
        sbW.append(", width=");
        sbW.append(num2);
        sbW.append(", height=");
        sbW.append(num3);
        sbW.append(", durationMs=");
        sbW.append(l);
        sbW.append(", metadata=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ Attachment(String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, Long l, Map map, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : l, (i & 256) != 0 ? kotlin.collections.a.M() : map);
    }
}
