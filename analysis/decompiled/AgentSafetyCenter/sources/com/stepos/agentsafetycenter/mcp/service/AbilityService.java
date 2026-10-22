package com.stepos.agentsafetycenter.mcp.service;

import a9.b;
import android.util.Log;
import com.stepos.mcp.sdk.java.server.AndroidMCPServer;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import d9.a;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AbilityService extends AbsMCPService {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f2507g = 0;

    /* renamed from: c, reason: collision with root package name */
    public final String f2508c = "AbilityService";

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f2509f = new LinkedHashMap();

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService
    public final void initToolHandlers() {
        LinkedHashMap linkedHashMap = this.f2509f;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            b bVar = (b) entry.getValue();
            AndroidMCPServer androidMCPServer = this.mcpServer;
            a aVar = new a();
            aVar.f3292c = this;
            aVar.f3293f = str;
            aVar.f3294g = bVar;
            VarHandle.storeStoreFence();
            androidMCPServer.addToolHandler(str, aVar);
        }
        Log.i(this.f2508c, "initToolHandlers count=" + linkedHashMap.size());
    }

    @Override // com.stepos.mcp.sdk.java.service.AbsMCPService, android.app.Service
    public final void onCreate() throws Exception {
        String str;
        String str2 = this.f2508c;
        Log.i(str2, "AbilityService onCreate!");
        b bVar = new b(1);
        bVar.f245b = this;
        VarHandle.storeStoreFence();
        b bVar2 = new b(0);
        bVar2.f245b = this;
        VarHandle.storeStoreFence();
        Iterator it = ac.a.F(bVar, bVar2).iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap = this.f2509f;
            if (!zHasNext) {
                Log.i(str2, "initAbilities registered=" + l.H0(linkedHashMap.keySet()));
                super.onCreate();
                return;
            }
            b bVar3 = (b) it.next();
            bVar3.getClass();
            switch (bVar3.f244a) {
                case 0:
                    str = "file_restore";
                    break;
                default:
                    str = "file_safe_delete";
                    break;
            }
            linkedHashMap.put(str, bVar3);
        }
    }
}
