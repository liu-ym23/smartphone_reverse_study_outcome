package com.stepos.agentframework.chatui;

import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002-.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000eH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R$\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R:\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010,\u001a\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/stepos/agentframework/chatui/ToolNameMapping;", "", "<init>", "()V", "LY8/t;", "f", "", "name", "parameter", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Ljava/lang/String;", "", "Lcom/stepos/agentframework/chatui/ToolNameMapping$b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Le9/c;)Ljava/lang/Object;", "json", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/util/Map;", "TAG", "Ljava/lang/String;", "SPECIAL_TOOL_NAME", "ASSET_FILE", "cachedMap", "Ljava/util/Map;", "Lcom/stepos/agentframework/chatui/s2;", "dataSource", "Lcom/stepos/agentframework/chatui/s2;", "getDataSource", "()Lcom/stepos/agentframework/chatui/s2;", "setDataSource", "(Lcom/stepos/agentframework/chatui/s2;)V", "Lkotlin/Function0;", UxipConstants.f30680s, "onMapLoaded", "Lp9/a;", Const.INTENT_KEY_UMID, "()Lp9/a;", "k", "(Lp9/a;)V", "e", "()Ljava/lang/Object;", "snapshotIdentity", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ToolNameMapping {
    public static final String ASSET_FILE = "tool_name_map.json";
    private static final String SPECIAL_TOOL_NAME = "nodes";
    private static final String TAG = "ToolNameMapping";
    private static volatile Map<String, ToolMeta> cachedMap;
    private static InterfaceC5063a<Y8.t> onMapLoaded;
    public static final ToolNameMapping INSTANCE = new ToolNameMapping();
    private static s2 dataSource = new C2039p1(null, 1, null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatui/ToolNameMapping$a;", "", "", "id", "toolName", "toolLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ToolNameMapping$a, reason: from toString */
    public static final /* data */ class ToolLabelEntry {

        @SerializedName("id")
        private final String id;

        @SerializedName("tool_label")
        private final String toolLabel;

        @SerializedName("tool_name")
        private final String toolName;

        public ToolLabelEntry() {
            this(null, null, null, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: b, reason: from getter */
        public final String getToolLabel() {
            return this.toolLabel;
        }

        /* renamed from: c, reason: from getter */
        public final String getToolName() {
            return this.toolName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolLabelEntry)) {
                return false;
            }
            ToolLabelEntry toolLabelEntry = (ToolLabelEntry) other;
            return kotlin.jvm.internal.p.d(this.id, toolLabelEntry.id) && kotlin.jvm.internal.p.d(this.toolName, toolLabelEntry.toolName) && kotlin.jvm.internal.p.d(this.toolLabel, toolLabelEntry.toolLabel);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.toolName.hashCode()) * 31) + this.toolLabel.hashCode();
        }

        public String toString() {
            return "ToolLabelEntry(id=" + this.id + ", toolName=" + this.toolName + ", toolLabel=" + this.toolLabel + ")";
        }

        public ToolLabelEntry(String id, String toolName, String toolLabel) {
            kotlin.jvm.internal.p.i(id, "id");
            kotlin.jvm.internal.p.i(toolName, "toolName");
            kotlin.jvm.internal.p.i(toolLabel, "toolLabel");
            this.id = id;
            this.toolName = toolName;
            this.toolLabel = toolLabel;
        }

        public /* synthetic */ ToolLabelEntry(String str, String str2, String str3, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatui/ToolNameMapping$b;", "", "", "id", "label", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.ToolNameMapping$b, reason: from toString */
    public static final /* data */ class ToolMeta {
        private final String id;
        private final String label;

        /* JADX WARN: Multi-variable type inference failed */
        public ToolMeta() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolMeta)) {
                return false;
            }
            ToolMeta toolMeta = (ToolMeta) other;
            return kotlin.jvm.internal.p.d(this.id, toolMeta.id) && kotlin.jvm.internal.p.d(this.label, toolMeta.label);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.label.hashCode();
        }

        public String toString() {
            return "ToolMeta(id=" + this.id + ", label=" + this.label + ")";
        }

        public ToolMeta(String id, String label) {
            kotlin.jvm.internal.p.i(id, "id");
            kotlin.jvm.internal.p.i(label, "label");
            this.id = id;
            this.label = label;
        }

        public /* synthetic */ ToolMeta(String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2);
        }
    }

    public final String c(String name, String parameter) {
        String label;
        kotlin.jvm.internal.p.i(name, "name");
        String strJ = j(name, parameter);
        Map<String, ToolMeta> map = cachedMap;
        if (map != null) {
            String lowerCase = strJ.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            ToolMeta toolMeta = map.get(lowerCase);
            if (toolMeta != null && (label = toolMeta.getLabel()) != null) {
                return label;
            }
        }
        return strJ;
    }

    public final InterfaceC5063a<Y8.t> d() {
        return onMapLoaded;
    }

    public final Object e() {
        return cachedMap;
    }

    public final void f() {
        Function2.a(new ToolNameMapping$init$1(null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(e9.InterfaceC4014c<? super java.util.Map<java.lang.String, com.stepos.agentframework.chatui.ToolNameMapping.ToolMeta>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.agentframework.chatui.ToolNameMapping$loadFromSource$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.agentframework.chatui.ToolNameMapping$loadFromSource$1 r0 = (com.stepos.agentframework.chatui.ToolNameMapping$loadFromSource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatui.ToolNameMapping$loadFromSource$1 r0 = new com.stepos.agentframework.chatui.ToolNameMapping$loadFromSource$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)     // Catch: java.lang.Exception -> L4c
            goto L45
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            com.stepos.agentframework.chatui.s2 r5 = com.stepos.agentframework.chatui.ToolNameMapping.dataSource     // Catch: java.lang.Exception -> L4c
            com.stepos.agentframework.chatcore.session.ChatCoreSdk r2 = com.stepos.agentframework.chatcore.session.ChatCoreSdk.INSTANCE     // Catch: java.lang.Exception -> L4c
            android.content.Context r2 = r2.c()     // Catch: java.lang.Exception -> L4c
            r0.label = r3     // Catch: java.lang.Exception -> L4c
            java.lang.Object r5 = r5.a(r2, r0)     // Catch: java.lang.Exception -> L4c
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L4c
            java.util.Map r4 = r4.h(r5)     // Catch: java.lang.Exception -> L4c
            return r4
        L4c:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "load from source failed: "
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r5 = 4
            r0 = 0
            java.lang.String r1 = "ToolNameMapping"
            r2 = 0
            h8.C4148a.u(r1, r4, r2, r5, r0)
            java.util.Map r4 = kotlin.collections.a.i()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.ToolNameMapping.g(e9.c):java.lang.Object");
    }

    public final Map<String, ToolMeta> h(String json) {
        try {
            Object objFromJson = new Gson().fromJson(json, new TypeToken<List<? extends ToolLabelEntry>>() { // from class: com.stepos.agentframework.chatui.ToolNameMapping$parse$type$1
            }.getType());
            kotlin.jvm.internal.p.h(objFromJson, "fromJson(...)");
            ArrayList<ToolLabelEntry> arrayList = new ArrayList();
            for (Object obj : (List) objFromJson) {
                if (!La.H.x0(((ToolLabelEntry) obj).getToolName())) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(arrayList, 10)), 16));
            for (ToolLabelEntry toolLabelEntry : arrayList) {
                String lowerCase = toolLabelEntry.getToolName().toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
                Pair pairA = Y8.j.a(lowerCase, new ToolMeta(toolLabelEntry.getId(), toolLabelEntry.getToolLabel()));
                linkedHashMap.put(pairA.e(), pairA.f());
            }
            return linkedHashMap;
        } catch (Exception e10) {
            C4148a.u(TAG, "parse name map failed: " + e10.getMessage(), false, 4, null);
            return kotlin.collections.a.i();
        }
    }

    public final String i(String parameter) {
        if (parameter != null && !La.H.x0(parameter)) {
            try {
                String strOptString = new JSONObject(parameter).optString("invokeParamsJson", "");
                kotlin.jvm.internal.p.f(strOptString);
                if (La.H.x0(strOptString)) {
                    return null;
                }
                String strOptString2 = new JSONObject(strOptString).optString("method", "");
                kotlin.jvm.internal.p.f(strOptString2);
                if (La.H.x0(strOptString2)) {
                    return null;
                }
                return strOptString2;
            } catch (Exception e10) {
                C4148a.u(TAG, "parse method failed: " + e10.getMessage(), false, 4, null);
            }
        }
        return null;
    }

    public final String j(String name, String parameter) {
        String strI;
        return (La.D.L(name, SPECIAL_TOOL_NAME, true) && (strI = i(parameter)) != null) ? strI : name;
    }

    public final void k(InterfaceC5063a<Y8.t> interfaceC5063a) {
        if (interfaceC5063a == null || cachedMap == null) {
            onMapLoaded = interfaceC5063a;
        } else {
            onMapLoaded = null;
            Function2.b(new ToolNameMapping$onMapLoaded$1(interfaceC5063a, null));
        }
    }
}
