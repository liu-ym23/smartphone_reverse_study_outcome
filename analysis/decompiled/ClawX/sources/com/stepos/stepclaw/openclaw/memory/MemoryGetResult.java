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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002EDB{\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010B\u007f\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0019J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0012\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0019J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0019J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0019J\u0084\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u0019J\u0010\u0010)\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010,\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-J'\u00106\u001a\u0002032\u0006\u0010.\u001a\u00020\u00002\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b4\u00105R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00107\u001a\u0004\b9\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010:\u001a\u0004\b;\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010:\u001a\u0004\b<\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010:\u001a\u0004\b=\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010>\u001a\u0004\b?\u0010!R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010>\u001a\u0004\b@\u0010!R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00107\u001a\u0004\bA\u0010\u0019R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u00107\u001a\u0004\bB\u0010\u0019R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00107\u001a\u0004\bC\u0010\u0019¨\u0006F"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/MemoryGetResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "path", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "startLine", "endLine", "lines", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "disabled", "unavailable", "error", "warning", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "hasError", "()Z", "hasContent", "toCitedText", "()Ljava/lang/String;", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "()Ljava/lang/Boolean;", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/openclaw/memory/MemoryGetResult;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/openclaw/memory/MemoryGetResult;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getPath", "getText", "Ljava/lang/Integer;", "getStartLine", "getEndLine", "getLines", "Ljava/lang/Boolean;", "getDisabled", "getUnavailable", "getError", "getWarning", "getAction", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class MemoryGetResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String action;
    private final Boolean disabled;
    private final Integer endLine;
    private final String error;
    private final Integer lines;
    private final String path;
    private final Integer startLine;
    private final String text;
    private final Boolean unavailable;
    private final String warning;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/MemoryGetResult$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/openclaw/memory/MemoryGetResult;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<MemoryGetResult> serializer() {
            return MemoryGetResult$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public MemoryGetResult() {
        this((String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, 1023, (i) null);
    }

    public static /* synthetic */ MemoryGetResult copy$default(MemoryGetResult memoryGetResult, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, String str3, String str4, String str5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = memoryGetResult.path;
        }
        if ((i8 & 2) != 0) {
            str2 = memoryGetResult.text;
        }
        if ((i8 & 4) != 0) {
            num = memoryGetResult.startLine;
        }
        if ((i8 & 8) != 0) {
            num2 = memoryGetResult.endLine;
        }
        if ((i8 & 16) != 0) {
            num3 = memoryGetResult.lines;
        }
        if ((i8 & 32) != 0) {
            bool = memoryGetResult.disabled;
        }
        if ((i8 & 64) != 0) {
            bool2 = memoryGetResult.unavailable;
        }
        if ((i8 & 128) != 0) {
            str3 = memoryGetResult.error;
        }
        if ((i8 & 256) != 0) {
            str4 = memoryGetResult.warning;
        }
        if ((i8 & 512) != 0) {
            str5 = memoryGetResult.action;
        }
        String str6 = str4;
        String str7 = str5;
        Boolean bool3 = bool2;
        String str8 = str3;
        Integer num4 = num3;
        Boolean bool4 = bool;
        return memoryGetResult.copy(str, str2, num, num2, num4, bool4, bool3, str8, str6, str7);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(MemoryGetResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.path, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 0, self.path);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.text, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.text);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.startLine != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.startLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.endLine != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.endLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.lines != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.lines);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.disabled != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.disabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.unavailable != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.unavailable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.error != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.error);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.warning != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.warning);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && self.action == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.action);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getStartLine() {
        return this.startLine;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getEndLine() {
        return this.endLine;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getLines() {
        return this.lines;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getUnavailable() {
        return this.unavailable;
    }

    /* renamed from: component8, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component9, reason: from getter */
    public final String getWarning() {
        return this.warning;
    }

    public final MemoryGetResult copy(String path, String text, Integer startLine, Integer endLine, Integer lines, Boolean disabled, Boolean unavailable, String error, String warning, String action) {
        p.e(path, "path");
        p.e(text, "text");
        return new MemoryGetResult(path, text, startLine, endLine, lines, disabled, unavailable, error, warning, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryGetResult)) {
            return false;
        }
        MemoryGetResult memoryGetResult = (MemoryGetResult) other;
        return p.a(this.path, memoryGetResult.path) && p.a(this.text, memoryGetResult.text) && p.a(this.startLine, memoryGetResult.startLine) && p.a(this.endLine, memoryGetResult.endLine) && p.a(this.lines, memoryGetResult.lines) && p.a(this.disabled, memoryGetResult.disabled) && p.a(this.unavailable, memoryGetResult.unavailable) && p.a(this.error, memoryGetResult.error) && p.a(this.warning, memoryGetResult.warning) && p.a(this.action, memoryGetResult.action);
    }

    public final String getAction() {
        return this.action;
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final Integer getEndLine() {
        return this.endLine;
    }

    public final String getError() {
        return this.error;
    }

    public final Integer getLines() {
        return this.lines;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getStartLine() {
        return this.startLine;
    }

    public final String getText() {
        return this.text;
    }

    public final Boolean getUnavailable() {
        return this.unavailable;
    }

    public final String getWarning() {
        return this.warning;
    }

    public final boolean hasContent() {
        return !n.t1(this.text);
    }

    public final boolean hasError() {
        Boolean bool = this.disabled;
        Boolean bool2 = Boolean.TRUE;
        if (p.a(bool, bool2) || p.a(this.unavailable, bool2)) {
            return true;
        }
        String str = this.error;
        return (str == null || n.t1(str)) ? false : true;
    }

    public int hashCode() {
        int iF = b.f(this.path.hashCode() * 31, 31, this.text);
        Integer num = this.startLine;
        int iHashCode = (iF + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.endLine;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.lines;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.disabled;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.unavailable;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.error;
        int iHashCode6 = (iHashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.warning;
        int iHashCode7 = (iHashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.action;
        return iHashCode7 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toCitedText() {
        Integer num;
        Integer num2 = this.startLine;
        if (num2 == null || (num = this.endLine) == null || p.a(num2, num)) {
            Integer num3 = this.startLine;
            if (num3 == null) {
                return this.text;
            }
            return this.text + "\n\nSource: " + this.path + "#L" + num3;
        }
        return this.text + "\n\nSource: " + this.path + "#L" + this.startLine + "-L" + this.endLine;
    }

    public String toString() {
        String str = this.path;
        String str2 = this.text;
        Integer num = this.startLine;
        Integer num2 = this.endLine;
        Integer num3 = this.lines;
        Boolean bool = this.disabled;
        Boolean bool2 = this.unavailable;
        String str3 = this.error;
        String str4 = this.warning;
        String str5 = this.action;
        StringBuilder sbV = b.v("MemoryGetResult(path=", str, ", text=", str2, ", startLine=");
        sbV.append(num);
        sbV.append(", endLine=");
        sbV.append(num2);
        sbV.append(", lines=");
        sbV.append(num3);
        sbV.append(", disabled=");
        sbV.append(bool);
        sbV.append(", unavailable=");
        sbV.append(bool2);
        sbV.append(", error=");
        sbV.append(str3);
        sbV.append(", warning=");
        sbV.append(str4);
        sbV.append(", action=");
        sbV.append(str5);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ MemoryGetResult(int i8, String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.path = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.path = str;
        }
        if ((i8 & 2) == 0) {
            this.text = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.text = str2;
        }
        if ((i8 & 4) == 0) {
            this.startLine = null;
        } else {
            this.startLine = num;
        }
        if ((i8 & 8) == 0) {
            this.endLine = null;
        } else {
            this.endLine = num2;
        }
        if ((i8 & 16) == 0) {
            this.lines = null;
        } else {
            this.lines = num3;
        }
        if ((i8 & 32) == 0) {
            this.disabled = null;
        } else {
            this.disabled = bool;
        }
        if ((i8 & 64) == 0) {
            this.unavailable = null;
        } else {
            this.unavailable = bool2;
        }
        if ((i8 & 128) == 0) {
            this.error = null;
        } else {
            this.error = str3;
        }
        if ((i8 & 256) == 0) {
            this.warning = null;
        } else {
            this.warning = str4;
        }
        if ((i8 & 512) == 0) {
            this.action = null;
        } else {
            this.action = str5;
        }
    }

    public MemoryGetResult(String path, String text, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, String str, String str2, String str3) {
        p.e(path, "path");
        p.e(text, "text");
        this.path = path;
        this.text = text;
        this.startLine = num;
        this.endLine = num2;
        this.lines = num3;
        this.disabled = bool;
        this.unavailable = bool2;
        this.error = str;
        this.warning = str2;
        this.action = str3;
    }

    public /* synthetic */ MemoryGetResult(String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool, Boolean bool2, String str3, String str4, String str5, int i8, i iVar) {
        this((i8 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i8 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 4) != 0 ? null : num, (i8 & 8) != 0 ? null : num2, (i8 & 16) != 0 ? null : num3, (i8 & 32) != 0 ? null : bool, (i8 & 64) != 0 ? null : bool2, (i8 & 128) != 0 ? null : str3, (i8 & 256) != 0 ? null : str4, (i8 & 512) != 0 ? null : str5);
    }
}
