package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011¨\u0006("}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayConnectOptions;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "role", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "scopes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "caps", "commands", "permissions", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "client", "Lcom/stepos/stepclaw/gateway/GatewayClientInfo;", "userAgent", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lcom/stepos/stepclaw/gateway/GatewayClientInfo;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getScopes", "()Ljava/util/List;", "getCaps", "getCommands", "getPermissions", "()Ljava/util/Map;", "getClient", "()Lcom/stepos/stepclaw/gateway/GatewayClientInfo;", "getUserAgent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayConnectOptions {
    private final List<String> caps;
    private final GatewayClientInfo client;
    private final List<String> commands;
    private final Map<String, Boolean> permissions;
    private final String role;
    private final List<String> scopes;
    private final String userAgent;

    public GatewayConnectOptions(String role, List<String> scopes, List<String> caps, List<String> commands, Map<String, Boolean> permissions, GatewayClientInfo client, String str) {
        p.e(role, "role");
        p.e(scopes, "scopes");
        p.e(caps, "caps");
        p.e(commands, "commands");
        p.e(permissions, "permissions");
        p.e(client, "client");
        this.role = role;
        this.scopes = scopes;
        this.caps = caps;
        this.commands = commands;
        this.permissions = permissions;
        this.client = client;
        this.userAgent = str;
    }

    public static /* synthetic */ GatewayConnectOptions copy$default(GatewayConnectOptions gatewayConnectOptions, String str, List list, List list2, List list3, Map map, GatewayClientInfo gatewayClientInfo, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = gatewayConnectOptions.role;
        }
        if ((i8 & 2) != 0) {
            list = gatewayConnectOptions.scopes;
        }
        if ((i8 & 4) != 0) {
            list2 = gatewayConnectOptions.caps;
        }
        if ((i8 & 8) != 0) {
            list3 = gatewayConnectOptions.commands;
        }
        if ((i8 & 16) != 0) {
            map = gatewayConnectOptions.permissions;
        }
        if ((i8 & 32) != 0) {
            gatewayClientInfo = gatewayConnectOptions.client;
        }
        if ((i8 & 64) != 0) {
            str2 = gatewayConnectOptions.userAgent;
        }
        GatewayClientInfo gatewayClientInfo2 = gatewayClientInfo;
        String str3 = str2;
        Map map2 = map;
        List list4 = list2;
        return gatewayConnectOptions.copy(str, list, list4, list3, map2, gatewayClientInfo2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    public final List<String> component2() {
        return this.scopes;
    }

    public final List<String> component3() {
        return this.caps;
    }

    public final List<String> component4() {
        return this.commands;
    }

    public final Map<String, Boolean> component5() {
        return this.permissions;
    }

    /* renamed from: component6, reason: from getter */
    public final GatewayClientInfo getClient() {
        return this.client;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    public final GatewayConnectOptions copy(String role, List<String> scopes, List<String> caps, List<String> commands, Map<String, Boolean> permissions, GatewayClientInfo client, String userAgent) {
        p.e(role, "role");
        p.e(scopes, "scopes");
        p.e(caps, "caps");
        p.e(commands, "commands");
        p.e(permissions, "permissions");
        p.e(client, "client");
        return new GatewayConnectOptions(role, scopes, caps, commands, permissions, client, userAgent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayConnectOptions)) {
            return false;
        }
        GatewayConnectOptions gatewayConnectOptions = (GatewayConnectOptions) other;
        return p.a(this.role, gatewayConnectOptions.role) && p.a(this.scopes, gatewayConnectOptions.scopes) && p.a(this.caps, gatewayConnectOptions.caps) && p.a(this.commands, gatewayConnectOptions.commands) && p.a(this.permissions, gatewayConnectOptions.permissions) && p.a(this.client, gatewayConnectOptions.client) && p.a(this.userAgent, gatewayConnectOptions.userAgent);
    }

    public final List<String> getCaps() {
        return this.caps;
    }

    public final GatewayClientInfo getClient() {
        return this.client;
    }

    public final List<String> getCommands() {
        return this.commands;
    }

    public final Map<String, Boolean> getPermissions() {
        return this.permissions;
    }

    public final String getRole() {
        return this.role;
    }

    public final List<String> getScopes() {
        return this.scopes;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public int hashCode() {
        int iHashCode = (this.client.hashCode() + ((this.permissions.hashCode() + ((this.commands.hashCode() + ((this.caps.hashCode() + ((this.scopes.hashCode() + (this.role.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.userAgent;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.role;
        List<String> list = this.scopes;
        List<String> list2 = this.caps;
        List<String> list3 = this.commands;
        Map<String, Boolean> map = this.permissions;
        GatewayClientInfo gatewayClientInfo = this.client;
        String str2 = this.userAgent;
        StringBuilder sb = new StringBuilder("GatewayConnectOptions(role=");
        sb.append(str);
        sb.append(", scopes=");
        sb.append(list);
        sb.append(", caps=");
        sb.append(list2);
        sb.append(", commands=");
        sb.append(list3);
        sb.append(", permissions=");
        sb.append(map);
        sb.append(", client=");
        sb.append(gatewayClientInfo);
        sb.append(", userAgent=");
        return m0.f.f(sb, str2, ")");
    }

    public /* synthetic */ GatewayConnectOptions(String str, List list, List list2, List list3, Map map, GatewayClientInfo gatewayClientInfo, String str2, int i8, i iVar) {
        this(str, list, list2, list3, map, gatewayClientInfo, (i8 & 64) != 0 ? null : str2);
    }
}
