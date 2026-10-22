package com.stepos.mcp.sdk.java;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Bundle;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class MCPHelper {
    private static final String TAG = "MCPHelper";
    private static volatile MCPHelper instance;
    private final Context context;

    private MCPHelper(Context context) {
        this.context = context.getApplicationContext();
        KLog.i(TAG, "MCPHelper initialized");
    }

    private Map<String, List<McpSchema.Tool>> discoverServicesInternal(String str) {
        KLog.i(TAG, "enter discoverServicesInternal: " + str);
        HashMap map = new HashMap();
        try {
            Intent intent = new Intent(AbsMCPService.MCP_SERVICE_ACTION);
            if (str != null) {
                intent.setPackage(str);
            }
            for (ResolveInfo resolveInfo : this.context.getPackageManager().queryIntentServices(intent, 128)) {
                try {
                    List<McpSchema.Tool> serviceTools = parseServiceTools(resolveInfo);
                    if (serviceTools == null || serviceTools.isEmpty()) {
                        KLog.w(TAG, "No tools found for service: " + resolveInfo.serviceInfo.packageName);
                    } else {
                        map.put(resolveInfo.serviceInfo.packageName, serviceTools);
                        KLog.d(TAG, "find from service: " + resolveInfo.serviceInfo.packageName + "," + serviceTools.size());
                    }
                } catch (Exception e10) {
                    KLog.w(TAG, "Failed to parse tools for service: " + e10);
                }
            }
            KLog.i(TAG, "Service discovery completed:" + map.size());
        } catch (Exception e11) {
            KLog.e(TAG, "Service discovery failed" + e11);
        }
        return map;
    }

    public static MCPHelper getInstance(Context context) {
        Assert.notNull(context, "context can not be null");
        if (instance == null) {
            synchronized (MCPHelper.class) {
                try {
                    if (instance == null) {
                        instance = new MCPHelper(context);
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private ServerExt parseExt(ResolveInfo resolveInfo) {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        String str = serviceInfo != null ? serviceInfo.name : "unknown";
        try {
            String file = readFile(resolveInfo);
            if (file == null) {
                return null;
            }
            return (ServerExt) ZyMcpJson.jsonMapper.readValue(file, new TypeRef<ServerExt>() { // from class: com.stepos.mcp.sdk.java.MCPHelper.2
            });
        } catch (Exception e10) {
            KLog.e(TAG, "Failed to parse tools for service: " + str + ", " + e10);
            return null;
        }
    }

    private List<McpSchema.Tool> parseServiceTools(ResolveInfo resolveInfo) throws Resources.NotFoundException, IOException {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        Bundle bundle = serviceInfo.metaData;
        if (bundle == null) {
            return Collections.EMPTY_LIST;
        }
        int i = bundle.getInt(AbsMCPService.METADATA_TOOLS);
        if (i == 0) {
            KLog.w(TAG, "No tools metadata found for service:" + serviceInfo.name);
            return Collections.EMPTY_LIST;
        }
        try {
            InputStream inputStreamOpenRawResource = this.context.getPackageManager().getResourcesForApplication(serviceInfo.applicationInfo).openRawResource(i);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource));
                try {
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                    }
                    List<McpSchema.Tool> toolsJson = parseToolsJson(sb2.toString());
                    bufferedReader.close();
                    if (inputStreamOpenRawResource == null) {
                        return toolsJson;
                    }
                    inputStreamOpenRawResource.close();
                    return toolsJson;
                } finally {
                }
            } finally {
            }
        } catch (Exception e10) {
            KLog.e(TAG, "Failed to parse tools for service: " + serviceInfo.name + ", " + e10);
            return Collections.EMPTY_LIST;
        }
    }

    private List<McpSchema.Tool> parseToolsJson(String str) {
        try {
            return (List) ZyMcpJson.jsonMapper.readValue(str, new TypeRef<List<McpSchema.Tool>>() { // from class: com.stepos.mcp.sdk.java.MCPHelper.1
            });
        } catch (Exception e10) {
            KLog.e(TAG, "Error parsing tools JSON" + e10);
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String readFile(android.content.pm.ApplicationInfo r5, int r6) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L6a
            if (r6 > 0) goto L6
            goto L6a
        L6:
            android.content.Context r4 = r4.context     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.content.res.Resources r4 = r4.getResourcesForApplication(r5)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.io.InputStream r4 = r4.openRawResource(r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            r1.<init>()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
        L23:
            java.lang.String r2 = r5.readLine()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            if (r2 == 0) goto L32
            r1.append(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            goto L23
        L2d:
            r5 = move-exception
            r0 = r4
            goto L64
        L30:
            r5 = move-exception
            goto L40
        L32:
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            if (r4 == 0) goto L3b
            r4.close()     // Catch: java.io.IOException -> L3b
        L3b:
            return r5
        L3c:
            r5 = move-exception
            goto L64
        L3e:
            r5 = move-exception
            r4 = r0
        L40:
            java.lang.String r1 = "MCPHelper"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
            r2.<init>()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = "Failed to read resource: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L2d
            r2.append(r6)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = ", "
            r2.append(r6)     // Catch: java.lang.Throwable -> L2d
            r2.append(r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L2d
            com.stepos.mcp.sdk.java.KLog.e(r1, r5)     // Catch: java.lang.Throwable -> L2d
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.io.IOException -> L63
        L63:
            return r0
        L64:
            if (r0 == 0) goto L69
            r0.close()     // Catch: java.io.IOException -> L69
        L69:
            throw r5
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.mcp.sdk.java.MCPHelper.readFile(android.content.pm.ApplicationInfo, int):java.lang.String");
    }

    public DiscoveryResult discoverAll() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            List<ResolveInfo> listQueryIntentServices = this.context.getPackageManager().queryIntentServices(new Intent(AbsMCPService.MCP_SERVICE_ACTION), 128);
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                String str = resolveInfo.serviceInfo.packageName;
                try {
                    List<McpSchema.Tool> serviceTools = parseServiceTools(resolveInfo);
                    if (serviceTools != null && !serviceTools.isEmpty()) {
                        map.put(str, serviceTools);
                    }
                } catch (Exception e10) {
                    KLog.w(TAG, "Failed to parse tools for: " + str + ", " + e10);
                }
                try {
                    ServerExt ext = parseExt(resolveInfo);
                    if (ext != null) {
                        map2.put(str, ext);
                    }
                } catch (Exception e11) {
                    KLog.w(TAG, "Failed to parse ext for: " + str + ", " + e11);
                }
            }
            listQueryIntentServices.clear();
        } catch (Exception e12) {
            KLog.e(TAG, "discoverAll failed: " + e12);
        }
        KLog.i(TAG, "discoverAll: tools=" + map.size() + " exts=" + map2.size());
        return new DiscoveryResult(map, map2);
    }

    public Map<String, List<McpSchema.Tool>> discoverAllServices() {
        return discoverServicesInternal(null);
    }

    public List<McpSchema.Tool> getServicesByPkgName(String str) {
        Map<String, List<McpSchema.Tool>> mapDiscoverServicesInternal = discoverServicesInternal(str);
        if (mapDiscoverServicesInternal.isEmpty()) {
            return null;
        }
        return mapDiscoverServicesInternal.get(str);
    }

    public Map<String, ServerExt> loadExt(String str) {
        KLog.i(TAG, "enter getToolExtInternal: " + str);
        HashMap map = new HashMap();
        try {
            Intent intent = new Intent(AbsMCPService.MCP_SERVICE_ACTION);
            if (str != null) {
                intent.setPackage(str);
            }
            for (ResolveInfo resolveInfo : this.context.getPackageManager().queryIntentServices(intent, 128)) {
                try {
                    ServerExt ext = parseExt(resolveInfo);
                    if (ext != null) {
                        map.put(resolveInfo.serviceInfo.packageName, ext);
                    }
                } catch (Exception e10) {
                    KLog.w(TAG, "Failed to parse tools for service: " + e10);
                }
            }
            KLog.i(TAG, "Service discovery completed:" + map.size());
        } catch (Exception e11) {
            KLog.e(TAG, "Service discovery failed" + e11);
        }
        return map;
    }

    private String readFile(ResolveInfo resolveInfo) {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        Bundle bundle = serviceInfo.metaData;
        if (bundle == null) {
            return null;
        }
        int i = bundle.getInt(AbsMCPService.METADATA_TOOL_EXT);
        if (i == 0) {
            KLog.e(TAG, serviceInfo.name + " 中未找到Tool的拓展配置文件");
            return null;
        }
        return readFile(resolveInfo.serviceInfo.applicationInfo, i);
    }
}
