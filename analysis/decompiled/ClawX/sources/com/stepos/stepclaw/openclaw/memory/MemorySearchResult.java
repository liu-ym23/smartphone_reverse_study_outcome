package com.stepos.stepclaw.openclaw.memory;

import a4.b;
import b5.e;
import b5.f;
import b8.h;
import c5.m;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.gateway.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0002JIB\u008f\u0001\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u008f\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0017J\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b \u0010\u001cJ\u0012\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b$\u0010\u001cJ\u0012\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b%\u0010\"J\u0012\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b&\u0010\"J\u0012\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b'\u0010\u001cJ\u0012\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b(\u0010\u001cJ\u0012\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b)\u0010\u001cJ\u0098\u0001\u0010*\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b,\u0010\u001cJ\u0010\u0010-\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J'\u0010:\u001a\u0002072\u0006\u00102\u001a\u00020\u00002\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0001¢\u0006\u0004\b8\u00109R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010;\u001a\u0004\b<\u0010\u001eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010=\u001a\u0004\b>\u0010\u001cR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010=\u001a\u0004\b?\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010@\u001a\u0004\bA\u0010\"R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010=\u001a\u0004\bB\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010=\u001a\u0004\bC\u0010\u001cR\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\f\u0010@\u001a\u0004\bD\u0010\"R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\r\u0010@\u001a\u0004\bE\u0010\"R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010=\u001a\u0004\bF\u0010\u001cR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010=\u001a\u0004\bG\u0010\u001cR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010=\u001a\u0004\bH\u0010\u001c¨\u0006K"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/MemorySearchResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/openclaw/memory/MemorySearchEntry;", "results", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PROVIDER, ConfigIpcContract.KEY_MODEL, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fallback", "citations", "mode", "disabled", "unavailable", "error", "warning", "action", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "hasError", "()Z", "hasResults", "getCombinedSnippet", "()Ljava/lang/String;", "component1", "()Ljava/util/List;", "component2", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/openclaw/memory/MemorySearchResult;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/openclaw/memory/MemorySearchResult;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getResults", "Ljava/lang/String;", "getProvider", "getModel", "Ljava/lang/Boolean;", "getFallback", "getCitations", "getMode", "getDisabled", "getUnavailable", "getError", "getWarning", "getAction", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class MemorySearchResult {
    private final String action;
    private final String citations;
    private final Boolean disabled;
    private final String error;
    private final Boolean fallback;
    private final String mode;
    private final String model;
    private final String provider;
    private final List<MemorySearchEntry> results;
    private final Boolean unavailable;
    private final String warning;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {h.w(f.f889a, new b(27)), null, null, null, null, null, null, null, null, null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/openclaw/memory/MemorySearchResult$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/openclaw/memory/MemorySearchResult;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<MemorySearchResult> serializer() {
            return MemorySearchResult$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public MemorySearchResult() {
        this((List) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, 2047, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(MemorySearchEntry$$serializer.INSTANCE);
    }

    public static /* synthetic */ MemorySearchResult copy$default(MemorySearchResult memorySearchResult, List list, String str, String str2, Boolean bool, String str3, String str4, Boolean bool2, Boolean bool3, String str5, String str6, String str7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = memorySearchResult.results;
        }
        if ((i8 & 2) != 0) {
            str = memorySearchResult.provider;
        }
        if ((i8 & 4) != 0) {
            str2 = memorySearchResult.model;
        }
        if ((i8 & 8) != 0) {
            bool = memorySearchResult.fallback;
        }
        if ((i8 & 16) != 0) {
            str3 = memorySearchResult.citations;
        }
        if ((i8 & 32) != 0) {
            str4 = memorySearchResult.mode;
        }
        if ((i8 & 64) != 0) {
            bool2 = memorySearchResult.disabled;
        }
        if ((i8 & 128) != 0) {
            bool3 = memorySearchResult.unavailable;
        }
        if ((i8 & 256) != 0) {
            str5 = memorySearchResult.error;
        }
        if ((i8 & 512) != 0) {
            str6 = memorySearchResult.warning;
        }
        if ((i8 & 1024) != 0) {
            str7 = memorySearchResult.action;
        }
        String str8 = str6;
        String str9 = str7;
        Boolean bool4 = bool3;
        String str10 = str5;
        String str11 = str4;
        Boolean bool5 = bool2;
        String str12 = str3;
        String str13 = str2;
        return memorySearchResult.copy(list, str, str13, bool, str12, str11, bool5, bool4, str10, str8, str9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence getCombinedSnippet$lambda$0(MemorySearchEntry it) {
        p.e(it, "it");
        return it.getSnippet();
    }

    public static final /* synthetic */ void write$Self$step_memory_release(MemorySearchResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.results, s.f1092a)) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) eVarArr[0].getValue(), self.results);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.provider != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.provider);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.model != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.model);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fallback != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.fallback);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.citations != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.citations);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.mode != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.mode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.disabled != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.disabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.unavailable != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.unavailable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.error != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.error);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.warning != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.warning);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && self.action == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.action);
    }

    public final List<MemorySearchEntry> component1() {
        return this.results;
    }

    /* renamed from: component10, reason: from getter */
    public final String getWarning() {
        return this.warning;
    }

    /* renamed from: component11, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getFallback() {
        return this.fallback;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCitations() {
        return this.citations;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getUnavailable() {
        return this.unavailable;
    }

    /* renamed from: component9, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final MemorySearchResult copy(List<MemorySearchEntry> results, String provider, String model, Boolean fallback, String citations, String mode, Boolean disabled, Boolean unavailable, String error, String warning, String action) {
        p.e(results, "results");
        return new MemorySearchResult(results, provider, model, fallback, citations, mode, disabled, unavailable, error, warning, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemorySearchResult)) {
            return false;
        }
        MemorySearchResult memorySearchResult = (MemorySearchResult) other;
        return p.a(this.results, memorySearchResult.results) && p.a(this.provider, memorySearchResult.provider) && p.a(this.model, memorySearchResult.model) && p.a(this.fallback, memorySearchResult.fallback) && p.a(this.citations, memorySearchResult.citations) && p.a(this.mode, memorySearchResult.mode) && p.a(this.disabled, memorySearchResult.disabled) && p.a(this.unavailable, memorySearchResult.unavailable) && p.a(this.error, memorySearchResult.error) && p.a(this.warning, memorySearchResult.warning) && p.a(this.action, memorySearchResult.action);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getCitations() {
        return this.citations;
    }

    public final String getCombinedSnippet() {
        return m.A0(this.results, "\n\n", null, null, new d(14), 30);
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getError() {
        return this.error;
    }

    public final Boolean getFallback() {
        return this.fallback;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getProvider() {
        return this.provider;
    }

    public final List<MemorySearchEntry> getResults() {
        return this.results;
    }

    public final Boolean getUnavailable() {
        return this.unavailable;
    }

    public final String getWarning() {
        return this.warning;
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

    public final boolean hasResults() {
        return !this.results.isEmpty();
    }

    public int hashCode() {
        int iHashCode = this.results.hashCode() * 31;
        String str = this.provider;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.model;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.fallback;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.citations;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mode;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool2 = this.disabled;
        int iHashCode7 = (iHashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.unavailable;
        int iHashCode8 = (iHashCode7 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.error;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.warning;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.action;
        return iHashCode10 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        List<MemorySearchEntry> list = this.results;
        String str = this.provider;
        String str2 = this.model;
        Boolean bool = this.fallback;
        String str3 = this.citations;
        String str4 = this.mode;
        Boolean bool2 = this.disabled;
        Boolean bool3 = this.unavailable;
        String str5 = this.error;
        String str6 = this.warning;
        String str7 = this.action;
        StringBuilder sb = new StringBuilder("MemorySearchResult(results=");
        sb.append(list);
        sb.append(", provider=");
        sb.append(str);
        sb.append(", model=");
        sb.append(str2);
        sb.append(", fallback=");
        sb.append(bool);
        sb.append(", citations=");
        a8.b.A(sb, str3, ", mode=", str4, ", disabled=");
        sb.append(bool2);
        sb.append(", unavailable=");
        sb.append(bool3);
        sb.append(", error=");
        a8.b.A(sb, str5, ", warning=", str6, ", action=");
        return m0.f.f(sb, str7, ")");
    }

    public /* synthetic */ MemorySearchResult(int i8, List list, String str, String str2, Boolean bool, String str3, String str4, Boolean bool2, Boolean bool3, String str5, String str6, String str7, SerializationConstructorMarker serializationConstructorMarker) {
        this.results = (i8 & 1) == 0 ? s.f1092a : list;
        if ((i8 & 2) == 0) {
            this.provider = null;
        } else {
            this.provider = str;
        }
        if ((i8 & 4) == 0) {
            this.model = null;
        } else {
            this.model = str2;
        }
        if ((i8 & 8) == 0) {
            this.fallback = null;
        } else {
            this.fallback = bool;
        }
        if ((i8 & 16) == 0) {
            this.citations = null;
        } else {
            this.citations = str3;
        }
        if ((i8 & 32) == 0) {
            this.mode = null;
        } else {
            this.mode = str4;
        }
        if ((i8 & 64) == 0) {
            this.disabled = null;
        } else {
            this.disabled = bool2;
        }
        if ((i8 & 128) == 0) {
            this.unavailable = null;
        } else {
            this.unavailable = bool3;
        }
        if ((i8 & 256) == 0) {
            this.error = null;
        } else {
            this.error = str5;
        }
        if ((i8 & 512) == 0) {
            this.warning = null;
        } else {
            this.warning = str6;
        }
        if ((i8 & 1024) == 0) {
            this.action = null;
        } else {
            this.action = str7;
        }
    }

    public MemorySearchResult(List<MemorySearchEntry> results, String str, String str2, Boolean bool, String str3, String str4, Boolean bool2, Boolean bool3, String str5, String str6, String str7) {
        p.e(results, "results");
        this.results = results;
        this.provider = str;
        this.model = str2;
        this.fallback = bool;
        this.citations = str3;
        this.mode = str4;
        this.disabled = bool2;
        this.unavailable = bool3;
        this.error = str5;
        this.warning = str6;
        this.action = str7;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ MemorySearchResult(java.util.List r2, java.lang.String r3, java.lang.String r4, java.lang.Boolean r5, java.lang.String r6, java.lang.String r7, java.lang.Boolean r8, java.lang.Boolean r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.jvm.internal.i r14) {
        /*
            r1 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L6
            c5.s r2 = c5.s.f1092a
        L6:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto Lc
            r3 = r0
        Lc:
            r14 = r13 & 4
            if (r14 == 0) goto L11
            r4 = r0
        L11:
            r14 = r13 & 8
            if (r14 == 0) goto L16
            r5 = r0
        L16:
            r14 = r13 & 16
            if (r14 == 0) goto L1b
            r6 = r0
        L1b:
            r14 = r13 & 32
            if (r14 == 0) goto L20
            r7 = r0
        L20:
            r14 = r13 & 64
            if (r14 == 0) goto L25
            r8 = r0
        L25:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L2a
            r9 = r0
        L2a:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L2f
            r10 = r0
        L2f:
            r14 = r13 & 512(0x200, float:7.17E-43)
            if (r14 == 0) goto L34
            r11 = r0
        L34:
            r13 = r13 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L45
            r14 = r0
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L51
        L45:
            r14 = r12
            r13 = r11
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L51:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.openclaw.memory.MemorySearchResult.<init>(java.util.List, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
