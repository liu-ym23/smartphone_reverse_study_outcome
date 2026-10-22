package com.stepos.stepclaw.chroot;

import a6.z;
import a8.b;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import m0.f;
import m5.l;
import x5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000234B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001fJ\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001fJB\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u001fJ\u0010\u0010(\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b(\u0010!J\u001a\u0010*\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010.\u001a\u0004\b/\u0010!R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010,\u001a\u0004\b0\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b1\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b2\u0010\u001f¨\u00065"}, d2 = {"Lcom/stepos/stepclaw/chroot/InstalledVersions;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "gatewayVersion", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "gatewayAppliedApkVersionCode", "rootfsVersion", "configVersion", "appliedManifestBuildTimestamp", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_runtime_release", "(Lcom/stepos/stepclaw/chroot/InstalledVersions;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Lcom/stepos/stepclaw/chroot/AssetManifest;", "manifest", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "needsGatewayUpgrade", "(Lcom/stepos/stepclaw/chroot/AssetManifest;)Z", "needsConfigUpgrade", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/chroot/InstalledVersions;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGatewayVersion", "I", "getGatewayAppliedApkVersionCode", "getRootfsVersion", "getConfigVersion", "getAppliedManifestBuildTimestamp", "Companion", "$serializer", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class InstalledVersions {
    private static final String TAG = "InstalledVersions";
    private final String appliedManifestBuildTimestamp;
    private final String configVersion;
    private final int gatewayAppliedApkVersionCode;
    private final String gatewayVersion;
    private final String rootfsVersion;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Json json = JsonKt.Json$default(null, new z(21), 1, null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/chroot/InstalledVersions$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "filesDir", "Lcom/stepos/stepclaw/chroot/InstalledVersions;", "load", "(Ljava/lang/String;)Lcom/stepos/stepclaw/chroot/InstalledVersions;", "versions", "Lb5/a0;", "save", "(Ljava/lang/String;Lcom/stepos/stepclaw/chroot/InstalledVersions;)V", "Lkotlinx/serialization/KSerializer;", "serializer", "()Lkotlinx/serialization/KSerializer;", "TAG", "Ljava/lang/String;", "Lkotlinx/serialization/json/Json;", "json", "Lkotlinx/serialization/json/Json;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final InstalledVersions load(String filesDir) {
            p.e(filesDir, "filesDir");
            File file = new File(filesDir, "installed-versions.json");
            if (!file.exists()) {
                return null;
            }
            try {
                Json json = InstalledVersions.json;
                String strE0 = l.E0(file, a.f6276a);
                json.getSerializersModule();
                return (InstalledVersions) json.decodeFromString(InstalledVersions.INSTANCE.serializer(), strE0);
            } catch (Exception e9) {
                b.y("Failed to read installed versions: ", e9.getMessage(), InstalledVersions.TAG);
                return null;
            }
        }

        public final void save(String filesDir, InstalledVersions versions) {
            p.e(filesDir, "filesDir");
            p.e(versions, "versions");
            l.G0(new File(filesDir, "installed-versions.json"), InstalledVersions.json.encodeToString(InstalledVersions.INSTANCE.serializer(), versions), a.f6276a);
        }

        public final KSerializer<InstalledVersions> serializer() {
            return InstalledVersions$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public InstalledVersions() {
        this((String) null, 0, (String) null, (String) null, (String) null, 31, (i) null);
    }

    public static /* synthetic */ InstalledVersions copy$default(InstalledVersions installedVersions, String str, int i8, String str2, String str3, String str4, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = installedVersions.gatewayVersion;
        }
        if ((i9 & 2) != 0) {
            i8 = installedVersions.gatewayAppliedApkVersionCode;
        }
        if ((i9 & 4) != 0) {
            str2 = installedVersions.rootfsVersion;
        }
        if ((i9 & 8) != 0) {
            str3 = installedVersions.configVersion;
        }
        if ((i9 & 16) != 0) {
            str4 = installedVersions.appliedManifestBuildTimestamp;
        }
        String str5 = str4;
        String str6 = str2;
        return installedVersions.copy(str, i8, str6, str3, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 json$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        return a0.f883a;
    }

    public static final /* synthetic */ void write$Self$step_runtime_release(InstalledVersions self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.gatewayVersion, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 0, self.gatewayVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gatewayAppliedApkVersionCode != 0) {
            output.encodeIntElement(serialDesc, 1, self.gatewayAppliedApkVersionCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !p.a(self.rootfsVersion, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 2, self.rootfsVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !p.a(self.configVersion, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 3, self.configVersion);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && p.a(self.appliedManifestBuildTimestamp, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            return;
        }
        output.encodeStringElement(serialDesc, 4, self.appliedManifestBuildTimestamp);
    }

    /* renamed from: component1, reason: from getter */
    public final String getGatewayVersion() {
        return this.gatewayVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final int getGatewayAppliedApkVersionCode() {
        return this.gatewayAppliedApkVersionCode;
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
    public final String getAppliedManifestBuildTimestamp() {
        return this.appliedManifestBuildTimestamp;
    }

    public final InstalledVersions copy(String gatewayVersion, int gatewayAppliedApkVersionCode, String rootfsVersion, String configVersion, String appliedManifestBuildTimestamp) {
        p.e(gatewayVersion, "gatewayVersion");
        p.e(rootfsVersion, "rootfsVersion");
        p.e(configVersion, "configVersion");
        p.e(appliedManifestBuildTimestamp, "appliedManifestBuildTimestamp");
        return new InstalledVersions(gatewayVersion, gatewayAppliedApkVersionCode, rootfsVersion, configVersion, appliedManifestBuildTimestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstalledVersions)) {
            return false;
        }
        InstalledVersions installedVersions = (InstalledVersions) other;
        return p.a(this.gatewayVersion, installedVersions.gatewayVersion) && this.gatewayAppliedApkVersionCode == installedVersions.gatewayAppliedApkVersionCode && p.a(this.rootfsVersion, installedVersions.rootfsVersion) && p.a(this.configVersion, installedVersions.configVersion) && p.a(this.appliedManifestBuildTimestamp, installedVersions.appliedManifestBuildTimestamp);
    }

    public final String getAppliedManifestBuildTimestamp() {
        return this.appliedManifestBuildTimestamp;
    }

    public final String getConfigVersion() {
        return this.configVersion;
    }

    public final int getGatewayAppliedApkVersionCode() {
        return this.gatewayAppliedApkVersionCode;
    }

    public final String getGatewayVersion() {
        return this.gatewayVersion;
    }

    public final String getRootfsVersion() {
        return this.rootfsVersion;
    }

    public int hashCode() {
        return this.appliedManifestBuildTimestamp.hashCode() + b.f(b.f(b.C(this.gatewayAppliedApkVersionCode, this.gatewayVersion.hashCode() * 31, 31), 31, this.rootfsVersion), 31, this.configVersion);
    }

    public final boolean needsConfigUpgrade(AssetManifest manifest) {
        p.e(manifest, "manifest");
        return manifest.getConfigVersion().length() > 0 && !p.a(this.configVersion, manifest.getConfigVersion());
    }

    public final boolean needsGatewayUpgrade(AssetManifest manifest) {
        p.e(manifest, "manifest");
        if (p.a(this.gatewayVersion, manifest.getGatewayVersion())) {
            return (manifest.getApkVersionCode() == 0 || this.gatewayAppliedApkVersionCode == manifest.getApkVersionCode()) ? false : true;
        }
        return true;
    }

    public String toString() {
        String str = this.gatewayVersion;
        int i8 = this.gatewayAppliedApkVersionCode;
        String str2 = this.rootfsVersion;
        String str3 = this.configVersion;
        String str4 = this.appliedManifestBuildTimestamp;
        StringBuilder sbU = b.u("InstalledVersions(gatewayVersion=", i8, str, ", gatewayAppliedApkVersionCode=", ", rootfsVersion=");
        b.A(sbU, str2, ", configVersion=", str3, ", appliedManifestBuildTimestamp=");
        return f.f(sbU, str4, ")");
    }

    public /* synthetic */ InstalledVersions(int i8, String str, int i9, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.gatewayVersion = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.gatewayVersion = str;
        }
        if ((i8 & 2) == 0) {
            this.gatewayAppliedApkVersionCode = 0;
        } else {
            this.gatewayAppliedApkVersionCode = i9;
        }
        if ((i8 & 4) == 0) {
            this.rootfsVersion = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.rootfsVersion = str2;
        }
        if ((i8 & 8) == 0) {
            this.configVersion = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.configVersion = str3;
        }
        if ((i8 & 16) == 0) {
            this.appliedManifestBuildTimestamp = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.appliedManifestBuildTimestamp = str4;
        }
    }

    public InstalledVersions(String gatewayVersion, int i8, String rootfsVersion, String configVersion, String appliedManifestBuildTimestamp) {
        p.e(gatewayVersion, "gatewayVersion");
        p.e(rootfsVersion, "rootfsVersion");
        p.e(configVersion, "configVersion");
        p.e(appliedManifestBuildTimestamp, "appliedManifestBuildTimestamp");
        this.gatewayVersion = gatewayVersion;
        this.gatewayAppliedApkVersionCode = i8;
        this.rootfsVersion = rootfsVersion;
        this.configVersion = configVersion;
        this.appliedManifestBuildTimestamp = appliedManifestBuildTimestamp;
    }

    public /* synthetic */ InstalledVersions(String str, int i8, String str2, String str3, String str4, int i9, i iVar) {
        this((i9 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i9 & 2) != 0 ? 0 : i8, (i9 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i9 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i9 & 16) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str4);
    }
}
