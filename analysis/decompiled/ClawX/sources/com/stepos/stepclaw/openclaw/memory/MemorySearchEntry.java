package com.stepos.stepclaw.openclaw.memory;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000265BE\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fBQ\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000b\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001bJN\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u001bJ\u0010\u0010'\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010\u001fJ\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b1\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u0010\"R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b4\u0010\u001b¨\u00067"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/MemorySearchEntry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "path", "snippet", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "startLine", "endLine", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "score", "citation", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIDLjava/lang/String;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;IIDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/openclaw/memory/MemorySearchEntry;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toCitedSnippet", "()Ljava/lang/String;", "component1", "component2", "component3", "()I", "component4", "component5", "()D", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;IIDLjava/lang/String;)Lcom/stepos/stepclaw/openclaw/memory/MemorySearchEntry;", "toString", "hashCode", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPath", "getSnippet", "I", "getStartLine", "getEndLine", "D", "getScore", "getCitation", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class MemorySearchEntry {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String citation;
    private final int endLine;
    private final String path;
    private final double score;
    private final String snippet;
    private final int startLine;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/MemorySearchEntry$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/openclaw/memory/MemorySearchEntry;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<MemorySearchEntry> serializer() {
            return MemorySearchEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public MemorySearchEntry() {
        this((String) null, (String) null, 0, 0, 0.0d, (String) null, 63, (i) null);
    }

    public static /* synthetic */ MemorySearchEntry copy$default(MemorySearchEntry memorySearchEntry, String str, String str2, int i8, int i9, double d, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = memorySearchEntry.path;
        }
        if ((i10 & 2) != 0) {
            str2 = memorySearchEntry.snippet;
        }
        if ((i10 & 4) != 0) {
            i8 = memorySearchEntry.startLine;
        }
        if ((i10 & 8) != 0) {
            i9 = memorySearchEntry.endLine;
        }
        if ((i10 & 16) != 0) {
            d = memorySearchEntry.score;
        }
        if ((i10 & 32) != 0) {
            str3 = memorySearchEntry.citation;
        }
        String str4 = str3;
        double d9 = d;
        return memorySearchEntry.copy(str, str2, i8, i9, d9, str4);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(MemorySearchEntry self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.path, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 0, self.path);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.snippet, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.snippet);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.startLine != 0) {
            output.encodeIntElement(serialDesc, 2, self.startLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.endLine != 0) {
            output.encodeIntElement(serialDesc, 3, self.endLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || Double.compare(self.score, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 4, self.score);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.citation == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.citation);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSnippet() {
        return this.snippet;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStartLine() {
        return this.startLine;
    }

    /* renamed from: component4, reason: from getter */
    public final int getEndLine() {
        return this.endLine;
    }

    /* renamed from: component5, reason: from getter */
    public final double getScore() {
        return this.score;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCitation() {
        return this.citation;
    }

    public final MemorySearchEntry copy(String path, String snippet, int startLine, int endLine, double score, String citation) {
        p.e(path, "path");
        p.e(snippet, "snippet");
        return new MemorySearchEntry(path, snippet, startLine, endLine, score, citation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemorySearchEntry)) {
            return false;
        }
        MemorySearchEntry memorySearchEntry = (MemorySearchEntry) other;
        return p.a(this.path, memorySearchEntry.path) && p.a(this.snippet, memorySearchEntry.snippet) && this.startLine == memorySearchEntry.startLine && this.endLine == memorySearchEntry.endLine && Double.compare(this.score, memorySearchEntry.score) == 0 && p.a(this.citation, memorySearchEntry.citation);
    }

    public final String getCitation() {
        return this.citation;
    }

    public final int getEndLine() {
        return this.endLine;
    }

    public final String getPath() {
        return this.path;
    }

    public final double getScore() {
        return this.score;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final int getStartLine() {
        return this.startLine;
    }

    public int hashCode() {
        int iHashCode = (Double.hashCode(this.score) + b.C(this.endLine, b.C(this.startLine, b.f(this.path.hashCode() * 31, 31, this.snippet), 31), 31)) * 31;
        String str = this.citation;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toCitedSnippet() {
        String str = this.citation;
        return (str == null || n.t1(str)) ? this.snippet : b.o(this.snippet, "\n\nSource: ", this.citation);
    }

    public String toString() {
        String str = this.path;
        String str2 = this.snippet;
        int i8 = this.startLine;
        int i9 = this.endLine;
        double d = this.score;
        String str3 = this.citation;
        StringBuilder sbV = b.v("MemorySearchEntry(path=", str, ", snippet=", str2, ", startLine=");
        b.z(sbV, i8, ", endLine=", i9, ", score=");
        sbV.append(d);
        sbV.append(", citation=");
        sbV.append(str3);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ MemorySearchEntry(int i8, String str, String str2, int i9, int i10, double d, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.path = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.path = str;
        }
        if ((i8 & 2) == 0) {
            this.snippet = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.snippet = str2;
        }
        if ((i8 & 4) == 0) {
            this.startLine = 0;
        } else {
            this.startLine = i9;
        }
        if ((i8 & 8) == 0) {
            this.endLine = 0;
        } else {
            this.endLine = i10;
        }
        if ((i8 & 16) == 0) {
            this.score = 0.0d;
        } else {
            this.score = d;
        }
        if ((i8 & 32) == 0) {
            this.citation = null;
        } else {
            this.citation = str3;
        }
    }

    public MemorySearchEntry(String path, String snippet, int i8, int i9, double d, String str) {
        p.e(path, "path");
        p.e(snippet, "snippet");
        this.path = path;
        this.snippet = snippet;
        this.startLine = i8;
        this.endLine = i9;
        this.score = d;
        this.citation = str;
    }

    public /* synthetic */ MemorySearchEntry(String str, String str2, int i8, int i9, double d, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i10 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i10 & 4) != 0 ? 0 : i8, (i10 & 8) != 0 ? 0 : i9, (i10 & 16) != 0 ? 0.0d : d, (i10 & 32) != 0 ? null : str3);
    }
}
