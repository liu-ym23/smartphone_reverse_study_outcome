package com.stepos.ailauncher.agent.aispace.market;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0013J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"J%\u0010%\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0002¢\u0006\u0004\b%\u0010&J\u0013\u0010(\u001a\u00020'*\u00020\u001aH\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010+R\u0014\u0010/\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010+¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/U0;", "", "<init>", "()V", "", "id", "name", "description", "iconUrl", "version", "versionName", "installVersion", "LY8/t;", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "assetId", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "prefix", "idsKey", "Lcom/stepos/ailauncher/agent/aispace/market/U0$a;", "entry", "c", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/market/U0$a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", "", "ids", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/util/List;)V", "Lorg/json/JSONObject;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/agent/aispace/market/U0$a;)Lorg/json/JSONObject;", "MMKV_ID", "Ljava/lang/String;", "KEY_SKILL_IDS", "KEY_AGENT_IDS", "PREFIX_SKILL", "PREFIX_AGENT", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U0 {
    public static final U0 INSTANCE = new U0();
    private static final String KEY_AGENT_IDS = "agent_ids";
    private static final String KEY_SKILL_IDS = "skill_ids";
    private static final String MMKV_ID = "testing_install_store";
    private static final String PREFIX_AGENT = "a_";
    private static final String PREFIX_SKILL = "s_";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/U0$a;", "", "", "id", "name", "description", "iconUrl", "version", "versionName", "installVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.market.U0$a, reason: from toString */
    public static final /* data */ class Entry {
        private final String description;
        private final String iconUrl;
        private final String id;
        private final String installVersion;
        private final String name;
        private final String version;
        private final String versionName;

        public Entry(String id, String name, String description, String iconUrl, String version, String versionName, String installVersion) {
            kotlin.jvm.internal.p.i(id, "id");
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(description, "description");
            kotlin.jvm.internal.p.i(iconUrl, "iconUrl");
            kotlin.jvm.internal.p.i(version, "version");
            kotlin.jvm.internal.p.i(versionName, "versionName");
            kotlin.jvm.internal.p.i(installVersion, "installVersion");
            this.id = id;
            this.name = name;
            this.description = description;
            this.iconUrl = iconUrl;
            this.version = version;
            this.versionName = versionName;
            this.installVersion = installVersion;
        }

        /* renamed from: a, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* renamed from: b, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: c, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: d, reason: from getter */
        public final String getInstallVersion() {
            return this.installVersion;
        }

        /* renamed from: e, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return kotlin.jvm.internal.p.d(this.id, entry.id) && kotlin.jvm.internal.p.d(this.name, entry.name) && kotlin.jvm.internal.p.d(this.description, entry.description) && kotlin.jvm.internal.p.d(this.iconUrl, entry.iconUrl) && kotlin.jvm.internal.p.d(this.version, entry.version) && kotlin.jvm.internal.p.d(this.versionName, entry.versionName) && kotlin.jvm.internal.p.d(this.installVersion, entry.installVersion);
        }

        /* renamed from: f, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        /* renamed from: g, reason: from getter */
        public final String getVersionName() {
            return this.versionName;
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.version.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.installVersion.hashCode();
        }

        public String toString() {
            return "Entry(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", iconUrl=" + this.iconUrl + ", version=" + this.version + ", versionName=" + this.versionName + ", installVersion=" + this.installVersion + ")";
        }
    }

    public final Set<String> a() {
        return Z8.F.r1(b(KEY_AGENT_IDS));
    }

    public final List<String> b(String idsKey) {
        Object objB;
        String strV = C5009a.v(C5009a.INSTANCE, MMKV_ID, idsKey, null, 4, null);
        if (La.H.x0(strV)) {
            return new ArrayList();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONArray(strV));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JSONArray jSONArray = (JSONArray) objB;
        if (jSONArray == null) {
            return new ArrayList();
        }
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(jSONArray.optString(i10));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            String str = (String) obj;
            kotlin.jvm.internal.p.f(str);
            if (!La.H.x0(str)) {
                arrayList2.add(obj);
            }
        }
        return Z8.F.p1(arrayList2);
    }

    public final void c(String prefix, String idsKey, Entry entry) {
        C5009a c5009a = C5009a.INSTANCE;
        String str = prefix + entry.getId();
        String string = j(entry).toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        c5009a.H(MMKV_ID, str, string);
        List<String> listB = b(idsKey);
        if (listB.contains(entry.getId())) {
            return;
        }
        listB.add(entry.getId());
        d(idsKey, listB);
    }

    public final void d(String idsKey, List<String> ids) {
        C5009a c5009a = C5009a.INSTANCE;
        String string = new JSONArray((Collection) ids).toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        c5009a.H(MMKV_ID, idsKey, string);
    }

    public final synchronized void e(String assetId, String name, String description, String iconUrl, String version, String installVersion) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(iconUrl, "iconUrl");
        kotlin.jvm.internal.p.i(version, "version");
        kotlin.jvm.internal.p.i(installVersion, "installVersion");
        if (La.H.x0(assetId)) {
            return;
        }
        c(PREFIX_AGENT, KEY_AGENT_IDS, new Entry(assetId, name, description, iconUrl, version, "", installVersion));
    }

    public final synchronized void f(String id, String name, String description, String iconUrl, String version, String versionName, String installVersion) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(iconUrl, "iconUrl");
        kotlin.jvm.internal.p.i(version, "version");
        kotlin.jvm.internal.p.i(versionName, "versionName");
        kotlin.jvm.internal.p.i(installVersion, "installVersion");
        if (La.H.x0(id)) {
            return;
        }
        c(PREFIX_SKILL, KEY_SKILL_IDS, new Entry(id, name, description, iconUrl, version, versionName, installVersion));
    }

    public final synchronized void g(String assetId) {
        kotlin.jvm.internal.p.i(assetId, "assetId");
        h(PREFIX_AGENT, KEY_AGENT_IDS, assetId);
    }

    public final void h(String prefix, String idsKey, String id) {
        if (La.H.x0(id)) {
            return;
        }
        C5009a.INSTANCE.J(MMKV_ID, prefix + id);
        List<String> listB = b(idsKey);
        if (listB.remove(id)) {
            d(idsKey, listB);
        }
    }

    public final synchronized void i(String id) {
        kotlin.jvm.internal.p.i(id, "id");
        h(PREFIX_SKILL, KEY_SKILL_IDS, id);
    }

    public final JSONObject j(Entry entry) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", entry.getName());
        jSONObject.put("description", entry.getDescription());
        jSONObject.put("iconUrl", entry.getIconUrl());
        jSONObject.put("version", entry.getVersion());
        jSONObject.put("versionName", entry.getVersionName());
        jSONObject.put("installVersion", entry.getInstallVersion());
        return jSONObject;
    }
}
