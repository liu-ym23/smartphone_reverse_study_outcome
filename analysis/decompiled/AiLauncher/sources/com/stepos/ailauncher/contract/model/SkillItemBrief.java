package com.stepos.ailauncher.contract.model;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0087\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "", "id", "", "name", "description", "installed", "", "iconUrl", "version", "versionName", "installVersion", "needUpdate", "testing", "expired", "env", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getInstalled", "()Z", "getIconUrl", "getVersion", "getVersionName", "getInstallVersion", "getNeedUpdate", "getTesting", "getExpired", "getEnv", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillItemBrief {
    private final String description;
    private final String env;
    private final boolean expired;
    private final String iconUrl;
    private final String id;
    private final String installVersion;
    private final boolean installed;
    private final String name;
    private final boolean needUpdate;
    private final boolean testing;
    private final String version;
    private final String versionName;

    public SkillItemBrief(String str, String str2, String str3, boolean z10, String iconUrl, String version, String versionName, String installVersion, boolean z11, boolean z12, boolean z13, String env) {
        p.i(iconUrl, "iconUrl");
        p.i(version, "version");
        p.i(versionName, "versionName");
        p.i(installVersion, "installVersion");
        p.i(env, "env");
        this.id = str;
        this.name = str2;
        this.description = str3;
        this.installed = z10;
        this.iconUrl = iconUrl;
        this.version = version;
        this.versionName = versionName;
        this.installVersion = installVersion;
        this.needUpdate = z11;
        this.testing = z12;
        this.expired = z13;
        this.env = env;
    }

    public static /* synthetic */ SkillItemBrief copy$default(SkillItemBrief skillItemBrief, String str, String str2, String str3, boolean z10, String str4, String str5, String str6, String str7, boolean z11, boolean z12, boolean z13, String str8, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = skillItemBrief.id;
        }
        if ((i10 & 2) != 0) {
            str2 = skillItemBrief.name;
        }
        if ((i10 & 4) != 0) {
            str3 = skillItemBrief.description;
        }
        if ((i10 & 8) != 0) {
            z10 = skillItemBrief.installed;
        }
        if ((i10 & 16) != 0) {
            str4 = skillItemBrief.iconUrl;
        }
        if ((i10 & 32) != 0) {
            str5 = skillItemBrief.version;
        }
        if ((i10 & 64) != 0) {
            str6 = skillItemBrief.versionName;
        }
        if ((i10 & 128) != 0) {
            str7 = skillItemBrief.installVersion;
        }
        if ((i10 & 256) != 0) {
            z11 = skillItemBrief.needUpdate;
        }
        if ((i10 & 512) != 0) {
            z12 = skillItemBrief.testing;
        }
        if ((i10 & 1024) != 0) {
            z13 = skillItemBrief.expired;
        }
        if ((i10 & 2048) != 0) {
            str8 = skillItemBrief.env;
        }
        boolean z14 = z13;
        String str9 = str8;
        boolean z15 = z11;
        boolean z16 = z12;
        String str10 = str6;
        String str11 = str7;
        String str12 = str4;
        String str13 = str5;
        return skillItemBrief.copy(str, str2, str3, z10, str12, str13, str10, str11, z15, z16, z14, str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getTesting() {
        return this.testing;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getExpired() {
        return this.expired;
    }

    /* renamed from: component12, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getInstalled() {
        return this.installed;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component7, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component8, reason: from getter */
    public final String getInstallVersion() {
        return this.installVersion;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final SkillItemBrief copy(String id, String name, String description, boolean installed, String iconUrl, String version, String versionName, String installVersion, boolean needUpdate, boolean testing, boolean expired, String env) {
        p.i(iconUrl, "iconUrl");
        p.i(version, "version");
        p.i(versionName, "versionName");
        p.i(installVersion, "installVersion");
        p.i(env, "env");
        return new SkillItemBrief(id, name, description, installed, iconUrl, version, versionName, installVersion, needUpdate, testing, expired, env);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillItemBrief)) {
            return false;
        }
        SkillItemBrief skillItemBrief = (SkillItemBrief) other;
        return p.d(this.id, skillItemBrief.id) && p.d(this.name, skillItemBrief.name) && p.d(this.description, skillItemBrief.description) && this.installed == skillItemBrief.installed && p.d(this.iconUrl, skillItemBrief.iconUrl) && p.d(this.version, skillItemBrief.version) && p.d(this.versionName, skillItemBrief.versionName) && p.d(this.installVersion, skillItemBrief.installVersion) && this.needUpdate == skillItemBrief.needUpdate && this.testing == skillItemBrief.testing && this.expired == skillItemBrief.expired && p.d(this.env, skillItemBrief.env);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEnv() {
        return this.env;
    }

    public final boolean getExpired() {
        return this.expired;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInstallVersion() {
        return this.installVersion;
    }

    public final boolean getInstalled() {
        return this.installed;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final boolean getTesting() {
        return this.testing;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return ((((((((((((((((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.installed)) * 31) + this.iconUrl.hashCode()) * 31) + this.version.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.installVersion.hashCode()) * 31) + Boolean.hashCode(this.needUpdate)) * 31) + Boolean.hashCode(this.testing)) * 31) + Boolean.hashCode(this.expired)) * 31) + this.env.hashCode();
    }

    public String toString() {
        return "SkillItemBrief(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", installed=" + this.installed + ", iconUrl=" + this.iconUrl + ", version=" + this.version + ", versionName=" + this.versionName + ", installVersion=" + this.installVersion + ", needUpdate=" + this.needUpdate + ", testing=" + this.testing + ", expired=" + this.expired + ", env=" + this.env + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ SkillItemBrief(java.lang.String r16, java.lang.String r17, java.lang.String r18, boolean r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, boolean r24, boolean r25, boolean r26, java.lang.String r27, int r28, kotlin.jvm.internal.i r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 1
            if (r1 == 0) goto L9
            r1 = 0
            r3 = r1
            goto Lb
        L9:
            r3 = r16
        Lb:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L12
            r6 = r2
            goto L14
        L12:
            r6 = r19
        L14:
            r1 = r0 & 16
            java.lang.String r4 = ""
            if (r1 == 0) goto L1c
            r7 = r4
            goto L1e
        L1c:
            r7 = r20
        L1e:
            r1 = r0 & 32
            if (r1 == 0) goto L24
            r8 = r4
            goto L26
        L24:
            r8 = r21
        L26:
            r1 = r0 & 64
            if (r1 == 0) goto L2c
            r9 = r4
            goto L2e
        L2c:
            r9 = r22
        L2e:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L34
            r10 = r4
            goto L36
        L34:
            r10 = r23
        L36:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L3c
            r11 = r2
            goto L3e
        L3c:
            r11 = r24
        L3e:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L44
            r12 = r2
            goto L46
        L44:
            r12 = r25
        L46:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L4c
            r13 = r2
            goto L4e
        L4c:
            r13 = r26
        L4e:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L59
            r14 = r4
            r2 = r15
            r5 = r18
            r4 = r17
            goto L60
        L59:
            r14 = r27
            r2 = r15
            r4 = r17
            r5 = r18
        L60:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.contract.model.SkillItemBrief.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
