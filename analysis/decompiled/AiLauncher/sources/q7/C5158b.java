package q7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: q7.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5158b {

    /* renamed from: e, reason: collision with root package name */
    public static volatile C5158b f38606e;

    /* renamed from: a, reason: collision with root package name */
    public Context f38607a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, List<McpSchema.Tool>> f38608b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f38609c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f38610d = new AtomicBoolean(false);

    /* renamed from: q7.b$a */
    public class a extends TypeRef<List<McpSchema.Tool>> {
        public a() {
        }
    }

    public C5158b(Context context) {
        this.f38607a = context.getApplicationContext();
        C5157a.c("MCPHelper", "MCPHelper initialized");
    }

    public static C5158b b(Context context) {
        Assert.notNull(context, "context can not be null");
        if (f38606e == null) {
            synchronized (C5158b.class) {
                try {
                    if (f38606e == null) {
                        f38606e = new C5158b(context);
                    }
                } finally {
                }
            }
        }
        return f38606e;
    }

    public final Map<String, List<McpSchema.Tool>> a(String str) {
        C5157a.c("MCPHelper", "enter discoverServicesInternal: " + str);
        HashMap map = new HashMap();
        try {
            Intent intent = new Intent(AbsMCPService.MCP_SERVICE_ACTION);
            if (str != null) {
                intent.setPackage(str);
            }
            for (ResolveInfo resolveInfo : this.f38607a.getPackageManager().queryIntentServices(intent, 128)) {
                try {
                    List<McpSchema.Tool> listE = e(resolveInfo);
                    if (listE != null && !listE.isEmpty()) {
                        map.put(resolveInfo.serviceInfo.packageName, listE);
                    }
                    C5157a.a("MCPHelper", "find from service: " + resolveInfo.serviceInfo.packageName + Const.STR_MART_COMMA + listE.size());
                } catch (Exception e10) {
                    C5157a.d("MCPHelper", "Failed to parse tools for service: " + e10);
                }
            }
            C5157a.c("MCPHelper", "Service discovery completed:" + map.size());
        } catch (Exception e11) {
            C5157a.b("MCPHelper", "Service discovery failed" + e11);
        }
        return map;
    }

    public List<McpSchema.Tool> c(String str) {
        return d(str, false);
    }

    public List<McpSchema.Tool> d(String str, boolean z10) {
        List<McpSchema.Tool> list;
        if (str == null) {
            return null;
        }
        if (!z10 && this.f38609c.get() && !this.f38608b.isEmpty() && (list = this.f38608b.get(str)) != null && !list.isEmpty()) {
            return list;
        }
        if (z10) {
            this.f38608b.remove(str);
        }
        Map<String, List<McpSchema.Tool>> mapA = a(str);
        if (mapA.isEmpty()) {
            return null;
        }
        this.f38608b.putAll(mapA);
        return mapA.get(str);
    }

    public final List<McpSchema.Tool> e(ResolveInfo resolveInfo) throws Resources.NotFoundException, IOException {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        Bundle bundle = serviceInfo.metaData;
        if (bundle == null) {
            return Collections.EMPTY_LIST;
        }
        int i10 = bundle.getInt(AbsMCPService.METADATA_TOOLS);
        if (i10 == 0) {
            C5157a.d("MCPHelper", "No tools metadata found for service:" + serviceInfo.name);
            return Collections.EMPTY_LIST;
        }
        try {
            InputStream inputStreamOpenRawResource = this.f38607a.getPackageManager().getResourcesForApplication(serviceInfo.applicationInfo).openRawResource(i10);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    inputStreamOpenRawResource.close();
                    return f(sb2.toString());
                }
                sb2.append(line);
            }
        } catch (Exception e10) {
            C5157a.b("MCPHelper", "Failed to parse tools for service: ${serviceInfo.name}" + e10);
            return Collections.EMPTY_LIST;
        }
    }

    public final List<McpSchema.Tool> f(String str) {
        try {
            return (List) C5159c.f38612a.readValue(str, new a());
        } catch (Exception e10) {
            C5157a.b("MCPHelper", "Error parsing tools JSON" + e10);
            return Collections.EMPTY_LIST;
        }
    }
}
