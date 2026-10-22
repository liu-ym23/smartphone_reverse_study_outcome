package com.stepos.stepclaw.chroot;

import a4.b;
import a6.z;
import android.content.Context;
import b5.a0;
import b5.e;
import b5.f;
import b8.h;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import x5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002?@Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010B{\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0016J\u0010\u0010\u001d\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0018J\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rHÆ\u0003¢\u0006\u0004\b \u0010!Jv\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0016J\u0010\u0010%\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b%\u0010\u0018J\u001a\u0010'\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(J'\u00101\u001a\u00020.2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b5\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00102\u001a\u0004\b6\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00102\u001a\u0004\b7\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b8\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b9\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\b;\u0010\u001eR\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u00104\u001a\u0004\b<\u0010\u0018R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010=\u001a\u0004\b>\u0010!¨\u0006A"}, d2 = {"Lcom/stepos/stepclaw/chroot/AssetManifest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "gatewayVersion", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "apkVersionCode", "rootfsVersion", "configVersion", "buildTimestamp", "releaseProfileId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "snapshotBeforeRootfs", "snapshotMaxKeep", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "binaryPatches", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/Map;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "component5", "component6", "component7", "()Z", "component8", "component9", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/Map;)Lcom/stepos/stepclaw/chroot/AssetManifest;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_runtime_release", "(Lcom/stepos/stepclaw/chroot/AssetManifest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getGatewayVersion", "I", "getApkVersionCode", "getRootfsVersion", "getConfigVersion", "getBuildTimestamp", "getReleaseProfileId", "Z", "getSnapshotBeforeRootfs", "getSnapshotMaxKeep", "Ljava/util/Map;", "getBinaryPatches", "Companion", "$serializer", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class AssetManifest {
    private static final String ASSET_PATH = "openclaw/manifest.json";
    private static final String TAG = "AssetManifest";
    private final int apkVersionCode;
    private final Map<String, String> binaryPatches;
    private final String buildTimestamp;
    private final String configVersion;
    private final String gatewayVersion;
    private final String releaseProfileId;
    private final String rootfsVersion;
    private final boolean snapshotBeforeRootfs;
    private final int snapshotMaxKeep;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, null, null, null, null, null, null, h.w(f.f889a, new b(6))};
    private static final Json json = JsonKt.Json$default(null, new z(17), 1, null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/stepclaw/chroot/AssetManifest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ASSET_PATH", "json", "Lkotlinx/serialization/json/Json;", "fromAssets", "Lcom/stepos/stepclaw/chroot/AssetManifest;", "context", "Landroid/content/Context;", "serializer", "Lkotlinx/serialization/KSerializer;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final AssetManifest fromAssets(Context context) {
            p.e(context, "context");
            try {
                InputStream inputStreamOpen = context.getAssets().open(AssetManifest.ASSET_PATH);
                p.d(inputStreamOpen, "open(...)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, a.f6276a), 8192);
                try {
                    String strC = k4.z.C(bufferedReader);
                    bufferedReader.close();
                    Json json = AssetManifest.json;
                    json.getSerializersModule();
                    return (AssetManifest) json.decodeFromString(AssetManifest.INSTANCE.serializer(), strC);
                } finally {
                }
            } catch (Exception e9) {
                a8.b.y("Failed to read asset manifest: ", e9.getMessage(), AssetManifest.TAG);
                return null;
            }
        }

        public final KSerializer<AssetManifest> serializer() {
            return AssetManifest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AssetManifest(int i8, String str, int i9, String str2, String str3, String str4, String str5, boolean z, int i10, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (5 != (i8 & 5)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 5, AssetManifest$$serializer.INSTANCE.getDescriptor());
        }
        this.gatewayVersion = str;
        if ((i8 & 2) == 0) {
            this.apkVersionCode = 0;
        } else {
            this.apkVersionCode = i9;
        }
        this.rootfsVersion = str2;
        if ((i8 & 8) == 0) {
            this.configVersion = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.configVersion = str3;
        }
        if ((i8 & 16) == 0) {
            this.buildTimestamp = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.buildTimestamp = str4;
        }
        if ((i8 & 32) == 0) {
            this.releaseProfileId = "stepclaw-android";
        } else {
            this.releaseProfileId = str5;
        }
        if ((i8 & 64) == 0) {
            this.snapshotBeforeRootfs = true;
        } else {
            this.snapshotBeforeRootfs = z;
        }
        if ((i8 & 128) == 0) {
            this.snapshotMaxKeep = 5;
        } else {
            this.snapshotMaxKeep = i10;
        }
        if ((i8 & 256) == 0) {
            this.binaryPatches = t.f1093a;
        } else {
            this.binaryPatches = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new LinkedHashMapSerializer(stringSerializer, stringSerializer);
    }

    public static /* synthetic */ AssetManifest copy$default(AssetManifest assetManifest, String str, int i8, String str2, String str3, String str4, String str5, boolean z, int i9, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = assetManifest.gatewayVersion;
        }
        if ((i10 & 2) != 0) {
            i8 = assetManifest.apkVersionCode;
        }
        if ((i10 & 4) != 0) {
            str2 = assetManifest.rootfsVersion;
        }
        if ((i10 & 8) != 0) {
            str3 = assetManifest.configVersion;
        }
        if ((i10 & 16) != 0) {
            str4 = assetManifest.buildTimestamp;
        }
        if ((i10 & 32) != 0) {
            str5 = assetManifest.releaseProfileId;
        }
        if ((i10 & 64) != 0) {
            z = assetManifest.snapshotBeforeRootfs;
        }
        if ((i10 & 128) != 0) {
            i9 = assetManifest.snapshotMaxKeep;
        }
        if ((i10 & 256) != 0) {
            map = assetManifest.binaryPatches;
        }
        int i11 = i9;
        Map map2 = map;
        String str6 = str5;
        boolean z2 = z;
        String str7 = str4;
        String str8 = str2;
        return assetManifest.copy(str, i8, str8, str3, str7, str6, z2, i11, map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return a0.f883a;
    }

    public static final /* synthetic */ void write$Self$step_runtime_release(AssetManifest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.gatewayVersion);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.apkVersionCode != 0) {
            output.encodeIntElement(serialDesc, 1, self.apkVersionCode);
        }
        output.encodeStringElement(serialDesc, 2, self.rootfsVersion);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !p.a(self.configVersion, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 3, self.configVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !p.a(self.buildTimestamp, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 4, self.buildTimestamp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !p.a(self.releaseProfileId, "stepclaw-android")) {
            output.encodeStringElement(serialDesc, 5, self.releaseProfileId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !self.snapshotBeforeRootfs) {
            output.encodeBooleanElement(serialDesc, 6, self.snapshotBeforeRootfs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.snapshotMaxKeep != 5) {
            output.encodeIntElement(serialDesc, 7, self.snapshotMaxKeep);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && p.a(self.binaryPatches, t.f1093a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 8, (SerializationStrategy) eVarArr[8].getValue(), self.binaryPatches);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGatewayVersion() {
        return this.gatewayVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final int getApkVersionCode() {
        return this.apkVersionCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRootfsVersion() {
        return this.rootfsVersion;
    }

    /* renamed from: component4, reason: from getter */
    public final String getConfigVersion() {
        return this.configVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBuildTimestamp() {
        return this.buildTimestamp;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReleaseProfileId() {
        return this.releaseProfileId;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getSnapshotBeforeRootfs() {
        return this.snapshotBeforeRootfs;
    }

    /* renamed from: component8, reason: from getter */
    public final int getSnapshotMaxKeep() {
        return this.snapshotMaxKeep;
    }

    public final Map<String, String> component9() {
        return this.binaryPatches;
    }

    public final AssetManifest copy(String gatewayVersion, int apkVersionCode, String rootfsVersion, String configVersion, String buildTimestamp, String releaseProfileId, boolean snapshotBeforeRootfs, int snapshotMaxKeep, Map<String, String> binaryPatches) {
        p.e(gatewayVersion, "gatewayVersion");
        p.e(rootfsVersion, "rootfsVersion");
        p.e(configVersion, "configVersion");
        p.e(buildTimestamp, "buildTimestamp");
        p.e(releaseProfileId, "releaseProfileId");
        p.e(binaryPatches, "binaryPatches");
        return new AssetManifest(gatewayVersion, apkVersionCode, rootfsVersion, configVersion, buildTimestamp, releaseProfileId, snapshotBeforeRootfs, snapshotMaxKeep, binaryPatches);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssetManifest)) {
            return false;
        }
        AssetManifest assetManifest = (AssetManifest) other;
        return p.a(this.gatewayVersion, assetManifest.gatewayVersion) && this.apkVersionCode == assetManifest.apkVersionCode && p.a(this.rootfsVersion, assetManifest.rootfsVersion) && p.a(this.configVersion, assetManifest.configVersion) && p.a(this.buildTimestamp, assetManifest.buildTimestamp) && p.a(this.releaseProfileId, assetManifest.releaseProfileId) && this.snapshotBeforeRootfs == assetManifest.snapshotBeforeRootfs && this.snapshotMaxKeep == assetManifest.snapshotMaxKeep && p.a(this.binaryPatches, assetManifest.binaryPatches);
    }

    public final int getApkVersionCode() {
        return this.apkVersionCode;
    }

    public final Map<String, String> getBinaryPatches() {
        return this.binaryPatches;
    }

    public final String getBuildTimestamp() {
        return this.buildTimestamp;
    }

    public final String getConfigVersion() {
        return this.configVersion;
    }

    public final String getGatewayVersion() {
        return this.gatewayVersion;
    }

    public final String getReleaseProfileId() {
        return this.releaseProfileId;
    }

    public final String getRootfsVersion() {
        return this.rootfsVersion;
    }

    public final boolean getSnapshotBeforeRootfs() {
        return this.snapshotBeforeRootfs;
    }

    public final int getSnapshotMaxKeep() {
        return this.snapshotMaxKeep;
    }

    public int hashCode() {
        return this.binaryPatches.hashCode() + a8.b.C(this.snapshotMaxKeep, a8.b.g(a8.b.f(a8.b.f(a8.b.f(a8.b.f(a8.b.C(this.apkVersionCode, this.gatewayVersion.hashCode() * 31, 31), 31, this.rootfsVersion), 31, this.configVersion), 31, this.buildTimestamp), 31, this.releaseProfileId), 31, this.snapshotBeforeRootfs), 31);
    }

    public String toString() {
        String str = this.gatewayVersion;
        int i8 = this.apkVersionCode;
        String str2 = this.rootfsVersion;
        String str3 = this.configVersion;
        String str4 = this.buildTimestamp;
        String str5 = this.releaseProfileId;
        boolean z = this.snapshotBeforeRootfs;
        int i9 = this.snapshotMaxKeep;
        Map<String, String> map = this.binaryPatches;
        StringBuilder sbU = a8.b.u("AssetManifest(gatewayVersion=", i8, str, ", apkVersionCode=", ", rootfsVersion=");
        a8.b.A(sbU, str2, ", configVersion=", str3, ", buildTimestamp=");
        a8.b.A(sbU, str4, ", releaseProfileId=", str5, ", snapshotBeforeRootfs=");
        sbU.append(z);
        sbU.append(", snapshotMaxKeep=");
        sbU.append(i9);
        sbU.append(", binaryPatches=");
        sbU.append(map);
        sbU.append(")");
        return sbU.toString();
    }

    public AssetManifest(String gatewayVersion, int i8, String rootfsVersion, String configVersion, String buildTimestamp, String releaseProfileId, boolean z, int i9, Map<String, String> binaryPatches) {
        p.e(gatewayVersion, "gatewayVersion");
        p.e(rootfsVersion, "rootfsVersion");
        p.e(configVersion, "configVersion");
        p.e(buildTimestamp, "buildTimestamp");
        p.e(releaseProfileId, "releaseProfileId");
        p.e(binaryPatches, "binaryPatches");
        this.gatewayVersion = gatewayVersion;
        this.apkVersionCode = i8;
        this.rootfsVersion = rootfsVersion;
        this.configVersion = configVersion;
        this.buildTimestamp = buildTimestamp;
        this.releaseProfileId = releaseProfileId;
        this.snapshotBeforeRootfs = z;
        this.snapshotMaxKeep = i9;
        this.binaryPatches = binaryPatches;
    }

    public /* synthetic */ AssetManifest(String str, int i8, String str2, String str3, String str4, String str5, boolean z, int i9, Map map, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? 0 : i8, str2, (i10 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i10 & 16) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str4, (i10 & 32) != 0 ? "stepclaw-android" : str5, (i10 & 64) != 0 ? true : z, (i10 & 128) != 0 ? 5 : i9, (i10 & 256) != 0 ? t.f1093a : map);
    }
}
