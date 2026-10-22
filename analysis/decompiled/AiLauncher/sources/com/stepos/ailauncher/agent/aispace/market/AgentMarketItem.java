package com.stepos.ailauncher.agent.aispace.market;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u001d\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0001OBu\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001fJ\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001fJ\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001fJ\u0010\u0010%\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u001fJ\u0010\u0010(\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001fJ\u0010\u0010-\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b-\u0010)J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u001fJ\u0092\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b1\u0010\u001fJ\u0010\u00102\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b2\u0010\u0017J\u001a\u00105\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00107\u001a\u0004\b9\u0010\u001fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00107\u001a\u0004\b:\u0010\u001fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b;\u0010\u001fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u00107\u001a\u0004\b<\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00107\u001a\u0004\b=\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010>\u001a\u0004\b?\u0010&R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00107\u001a\u0004\b@\u0010\u001fR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010A\u001a\u0004\bB\u0010)R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010C\u001a\u0004\bD\u0010+R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u00107\u001a\u0004\bE\u0010\u001fR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010A\u001a\u0004\bF\u0010)R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u00107\u001a\u0004\bG\u0010\u001fR\u0011\u0010I\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bH\u0010\u001fR\u0011\u0010K\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bJ\u0010\u001fR\u0011\u0010M\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bL\u0010\u001f¨\u0006P"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "Landroid/os/Parcelable;", "", "assetId", "reversionId", "version", "displayName", "description", "developer", "", "downloadCount", "installVersion", "", "needUpdate", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "initialStatus", "iconUrl", "testing", "env", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;Ljava/lang/String;ZLjava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "()J", "component8", "component9", "()Z", "component10", "()Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "component11", "component12", "component13", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;Ljava/lang/String;ZLjava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAssetId", "getReversionId", "getVersion", "getDisplayName", "getDescription", "getDeveloper", "J", "getDownloadCount", "getInstallVersion", "Z", "getNeedUpdate", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketStatus;", "getInitialStatus", "getIconUrl", "getTesting", "getEnv", "getIconChar", "iconChar", "getUseCountText", "useCountText", "getMetaText", "metaText", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgentMarketItem implements Parcelable {
    private final String assetId;
    private final String description;
    private final String developer;
    private final String displayName;
    private final long downloadCount;
    private final String env;
    private final String iconUrl;
    private final AgentMarketStatus initialStatus;
    private final String installVersion;
    private final boolean needUpdate;
    private final String reversionId;
    private final boolean testing;
    private final String version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<AgentMarketItem> CREATOR = new b();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/market/data/b;", "dto", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/agent/aispace/market/data/b;)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.AgentMarketItem$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final com.stepos.ailauncher.agent.aispace.market.AgentMarketItem a(com.stepos.ailauncher.agent.aispace.market.data.AgentMarketItemDto r19) {
            /*
                r18 = this;
                java.lang.String r0 = "dto"
                r1 = r19
                kotlin.jvm.internal.p.i(r1, r0)
                java.lang.String r2 = r1.getAgentId()
                java.lang.String r0 = r1.getReversionId()
                java.lang.String r3 = ""
                if (r0 != 0) goto L14
                r0 = r3
            L14:
                java.lang.String r4 = r1.getVersion()
                if (r4 != 0) goto L1b
                r4 = r3
            L1b:
                java.lang.String r5 = r1.getDisplayName()
                if (r5 == 0) goto L2b
                boolean r6 = La.H.x0(r5)
                if (r6 != 0) goto L28
                goto L29
            L28:
                r5 = 0
            L29:
                if (r5 != 0) goto L32
            L2b:
                java.lang.String r5 = r1.getName()
                if (r5 != 0) goto L32
                r5 = r3
            L32:
                java.lang.String r6 = r1.getDescription()
                if (r6 != 0) goto L39
                r6 = r3
            L39:
                java.lang.String r7 = r1.getDeveloper()
                if (r7 != 0) goto L40
                r7 = r3
            L40:
                long r8 = r1.getDownloadCount()
                java.lang.String r10 = r1.getInstallVersion()
                if (r10 != 0) goto L4b
                r10 = r3
            L4b:
                int r11 = r1.getNeedUpdate()
                r12 = 1
                if (r11 != r12) goto L54
                r11 = r12
                goto L55
            L54:
                r11 = 0
            L55:
                int r13 = r1.getInstallStatus()
                if (r13 != r12) goto L67
                int r13 = r1.getEnabled()
                if (r13 != r12) goto L64
                com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus r12 = com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus.INSTALLED_ENABLED
                goto L69
            L64:
                com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus r12 = com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus.INSTALLED_DISABLED
                goto L69
            L67:
                com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus r12 = com.stepos.ailauncher.agent.aispace.market.AgentMarketStatus.NOT_INSTALLED
            L69:
                java.lang.String r13 = r1.getIcon()
                if (r13 != 0) goto L70
                r13 = r3
            L70:
                java.lang.String r1 = r1.getEnv()
                if (r1 != 0) goto L78
                r15 = r3
                goto L79
            L78:
                r15 = r1
            L79:
                com.stepos.ailauncher.agent.aispace.market.AgentMarketItem r1 = new com.stepos.ailauncher.agent.aispace.market.AgentMarketItem
                r14 = 0
                r16 = 2048(0x800, float:2.87E-42)
                r17 = 0
                r3 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketItem.Companion.a(com.stepos.ailauncher.agent.aispace.market.data.b):com.stepos.ailauncher.agent.aispace.market.AgentMarketItem");
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<AgentMarketItem> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AgentMarketItem createFromParcel(Parcel parcel) {
            boolean z10;
            kotlin.jvm.internal.p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            long j10 = parcel.readLong();
            String string7 = parcel.readString();
            boolean z11 = false;
            if (parcel.readInt() != 0) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
            AgentMarketStatus agentMarketStatusValueOf = AgentMarketStatus.valueOf(parcel.readString());
            boolean z12 = true;
            String string8 = parcel.readString();
            if (parcel.readInt() == 0) {
                z12 = z10;
            }
            return new AgentMarketItem(string, string2, string3, string4, string5, string6, j10, string7, z11, agentMarketStatusValueOf, string8, z12, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AgentMarketItem[] newArray(int i10) {
            return new AgentMarketItem[i10];
        }
    }

    public AgentMarketItem(String assetId, String reversionId, String version, String displayName, String description, String developer, long j10, String installVersion, boolean z10, AgentMarketStatus initialStatus, String iconUrl, boolean z11, String env) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(version, "version");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(developer, "developer");
        kotlin.jvm.internal.p.i(installVersion, "installVersion");
        kotlin.jvm.internal.p.i(initialStatus, "initialStatus");
        kotlin.jvm.internal.p.i(iconUrl, "iconUrl");
        kotlin.jvm.internal.p.i(env, "env");
        this.assetId = assetId;
        this.reversionId = reversionId;
        this.version = version;
        this.displayName = displayName;
        this.description = description;
        this.developer = developer;
        this.downloadCount = j10;
        this.installVersion = installVersion;
        this.needUpdate = z10;
        this.initialStatus = initialStatus;
        this.iconUrl = iconUrl;
        this.testing = z11;
        this.env = env;
    }

    /* renamed from: component1, reason: from getter */
    public final String getAssetId() {
        return this.assetId;
    }

    /* renamed from: component10, reason: from getter */
    public final AgentMarketStatus getInitialStatus() {
        return this.initialStatus;
    }

    /* renamed from: component11, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getTesting() {
        return this.testing;
    }

    /* renamed from: component13, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReversionId() {
        return this.reversionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeveloper() {
        return this.developer;
    }

    /* renamed from: component7, reason: from getter */
    public final long getDownloadCount() {
        return this.downloadCount;
    }

    /* renamed from: component8, reason: from getter */
    public final String getInstallVersion() {
        return this.installVersion;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final AgentMarketItem copy(String assetId, String reversionId, String version, String displayName, String description, String developer, long downloadCount, String installVersion, boolean needUpdate, AgentMarketStatus initialStatus, String iconUrl, boolean testing, String env) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(reversionId, "reversionId");
        kotlin.jvm.internal.p.i(version, "version");
        kotlin.jvm.internal.p.i(displayName, "displayName");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(developer, "developer");
        kotlin.jvm.internal.p.i(installVersion, "installVersion");
        kotlin.jvm.internal.p.i(initialStatus, "initialStatus");
        kotlin.jvm.internal.p.i(iconUrl, "iconUrl");
        kotlin.jvm.internal.p.i(env, "env");
        return new AgentMarketItem(assetId, reversionId, version, displayName, description, developer, downloadCount, installVersion, needUpdate, initialStatus, iconUrl, testing, env);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentMarketItem)) {
            return false;
        }
        AgentMarketItem agentMarketItem = (AgentMarketItem) other;
        return kotlin.jvm.internal.p.d(this.assetId, agentMarketItem.assetId) && kotlin.jvm.internal.p.d(this.reversionId, agentMarketItem.reversionId) && kotlin.jvm.internal.p.d(this.version, agentMarketItem.version) && kotlin.jvm.internal.p.d(this.displayName, agentMarketItem.displayName) && kotlin.jvm.internal.p.d(this.description, agentMarketItem.description) && kotlin.jvm.internal.p.d(this.developer, agentMarketItem.developer) && this.downloadCount == agentMarketItem.downloadCount && kotlin.jvm.internal.p.d(this.installVersion, agentMarketItem.installVersion) && this.needUpdate == agentMarketItem.needUpdate && this.initialStatus == agentMarketItem.initialStatus && kotlin.jvm.internal.p.d(this.iconUrl, agentMarketItem.iconUrl) && this.testing == agentMarketItem.testing && kotlin.jvm.internal.p.d(this.env, agentMarketItem.env);
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDeveloper() {
        return this.developer;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getDownloadCount() {
        return this.downloadCount;
    }

    public final String getEnv() {
        return this.env;
    }

    public final String getIconChar() {
        String strValueOf;
        Character chO1 = La.K.O1(La.H.D1(this.displayName).toString());
        return (chO1 == null || (strValueOf = String.valueOf(Character.toUpperCase(chO1.charValue()))) == null) ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : strValueOf;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final AgentMarketStatus getInitialStatus() {
        return this.initialStatus;
    }

    public final String getInstallVersion() {
        return this.installVersion;
    }

    public final String getMetaText() {
        if (La.H.x0(this.developer)) {
            return getUseCountText();
        }
        return getUseCountText() + " ｜ " + this.developer;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final String getReversionId() {
        return this.reversionId;
    }

    public final boolean getTesting() {
        return this.testing;
    }

    public final String getUseCountText() {
        String strValueOf;
        long j10 = this.downloadCount;
        if (j10 < 10000) {
            return j10 + " 使用";
        }
        double d10 = j10 / 10000.0d;
        if (d10 % 1.0d == 0.0d) {
            strValueOf = String.valueOf((int) d10);
        } else {
            kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f34840a;
            strValueOf = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1));
            kotlin.jvm.internal.p.h(strValueOf, "format(...)");
        }
        return strValueOf + " 万使用";
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.assetId.hashCode() * 31) + this.reversionId.hashCode()) * 31) + this.version.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.description.hashCode()) * 31) + this.developer.hashCode()) * 31) + Long.hashCode(this.downloadCount)) * 31) + this.installVersion.hashCode()) * 31) + Boolean.hashCode(this.needUpdate)) * 31) + this.initialStatus.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + Boolean.hashCode(this.testing)) * 31) + this.env.hashCode();
    }

    public String toString() {
        return "AgentMarketItem(assetId=" + this.assetId + ", reversionId=" + this.reversionId + ", version=" + this.version + ", displayName=" + this.displayName + ", description=" + this.description + ", developer=" + this.developer + ", downloadCount=" + this.downloadCount + ", installVersion=" + this.installVersion + ", needUpdate=" + this.needUpdate + ", initialStatus=" + this.initialStatus + ", iconUrl=" + this.iconUrl + ", testing=" + this.testing + ", env=" + this.env + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        kotlin.jvm.internal.p.i(dest, "dest");
        dest.writeString(this.assetId);
        dest.writeString(this.reversionId);
        dest.writeString(this.version);
        dest.writeString(this.displayName);
        dest.writeString(this.description);
        dest.writeString(this.developer);
        dest.writeLong(this.downloadCount);
        dest.writeString(this.installVersion);
        dest.writeInt(this.needUpdate ? 1 : 0);
        dest.writeString(this.initialStatus.name());
        dest.writeString(this.iconUrl);
        dest.writeInt(this.testing ? 1 : 0);
        dest.writeString(this.env);
    }

    public /* synthetic */ AgentMarketItem(String str, String str2, String str3, String str4, String str5, String str6, long j10, String str7, boolean z10, AgentMarketStatus agentMarketStatus, String str8, boolean z11, String str9, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, str5, str6, j10, str7, z10, agentMarketStatus, (i10 & 1024) != 0 ? "" : str8, (i10 & 2048) != 0 ? false : z11, (i10 & 4096) != 0 ? "" : str9);
    }
}
