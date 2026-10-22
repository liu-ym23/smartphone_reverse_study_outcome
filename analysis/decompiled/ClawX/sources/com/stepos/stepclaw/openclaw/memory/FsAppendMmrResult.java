package com.stepos.stepclaw.openclaw.memory;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ:\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\"\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b#\u0010\u001cJ\u001a\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b+\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010\u001f¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/FsAppendMmrResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_OK, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "appendedCount", "skippedCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "error", "<init>", "(ZIILjava/lang/String;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IZIILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/openclaw/memory/FsAppendMmrResult;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "hasError", "()Z", "component1", "component2", "()I", "component3", "component4", "()Ljava/lang/String;", "copy", "(ZIILjava/lang/String;)Lcom/stepos/stepclaw/openclaw/memory/FsAppendMmrResult;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getOk", "I", "getAppendedCount", "getSkippedCount", "Ljava/lang/String;", "getError", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class FsAppendMmrResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int appendedCount;
    private final String error;
    private final boolean ok;
    private final int skippedCount;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/FsAppendMmrResult$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/openclaw/memory/FsAppendMmrResult;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<FsAppendMmrResult> serializer() {
            return FsAppendMmrResult$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public FsAppendMmrResult() {
        this(false, 0, 0, (String) null, 15, (i) null);
    }

    public static /* synthetic */ FsAppendMmrResult copy$default(FsAppendMmrResult fsAppendMmrResult, boolean z, int i8, int i9, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = fsAppendMmrResult.ok;
        }
        if ((i10 & 2) != 0) {
            i8 = fsAppendMmrResult.appendedCount;
        }
        if ((i10 & 4) != 0) {
            i9 = fsAppendMmrResult.skippedCount;
        }
        if ((i10 & 8) != 0) {
            str = fsAppendMmrResult.error;
        }
        return fsAppendMmrResult.copy(z, i8, i9, str);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(FsAppendMmrResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ok) {
            output.encodeBooleanElement(serialDesc, 0, self.ok);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.appendedCount != 0) {
            output.encodeIntElement(serialDesc, 1, self.appendedCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.skippedCount != 0) {
            output.encodeIntElement(serialDesc, 2, self.skippedCount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.error == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.error);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAppendedCount() {
        return this.appendedCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSkippedCount() {
        return this.skippedCount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final FsAppendMmrResult copy(boolean ok, int appendedCount, int skippedCount, String error) {
        return new FsAppendMmrResult(ok, appendedCount, skippedCount, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FsAppendMmrResult)) {
            return false;
        }
        FsAppendMmrResult fsAppendMmrResult = (FsAppendMmrResult) other;
        return this.ok == fsAppendMmrResult.ok && this.appendedCount == fsAppendMmrResult.appendedCount && this.skippedCount == fsAppendMmrResult.skippedCount && p.a(this.error, fsAppendMmrResult.error);
    }

    public final int getAppendedCount() {
        return this.appendedCount;
    }

    public final String getError() {
        return this.error;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final int getSkippedCount() {
        return this.skippedCount;
    }

    public final boolean hasError() {
        if (!this.ok) {
            return true;
        }
        String str = this.error;
        return (str == null || n.t1(str)) ? false : true;
    }

    public int hashCode() {
        int iC = b.C(this.skippedCount, b.C(this.appendedCount, Boolean.hashCode(this.ok) * 31, 31), 31);
        String str = this.error;
        return iC + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FsAppendMmrResult(ok=" + this.ok + ", appendedCount=" + this.appendedCount + ", skippedCount=" + this.skippedCount + ", error=" + this.error + ")";
    }

    public /* synthetic */ FsAppendMmrResult(int i8, boolean z, int i9, int i10, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.ok = false;
        } else {
            this.ok = z;
        }
        if ((i8 & 2) == 0) {
            this.appendedCount = 0;
        } else {
            this.appendedCount = i9;
        }
        if ((i8 & 4) == 0) {
            this.skippedCount = 0;
        } else {
            this.skippedCount = i10;
        }
        if ((i8 & 8) == 0) {
            this.error = null;
        } else {
            this.error = str;
        }
    }

    public FsAppendMmrResult(boolean z, int i8, int i9, String str) {
        this.ok = z;
        this.appendedCount = i8;
        this.skippedCount = i9;
        this.error = str;
    }

    public /* synthetic */ FsAppendMmrResult(boolean z, int i8, int i9, String str, int i10, i iVar) {
        this((i10 & 1) != 0 ? false : z, (i10 & 2) != 0 ? 0 : i8, (i10 & 4) != 0 ? 0 : i9, (i10 & 8) != 0 ? null : str);
    }
}
