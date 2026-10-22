package com.stepos.mcp.sdk.java.client;

import android.content.Context;
import c8.b;
import com.stepos.mcp.sdk.java.KLog;
import io.modelcontextprotocol.util.Assert;
import java.util.concurrent.ConcurrentHashMap;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ToolHelper {
    private static final String TAG = "ToolHelper";
    private static volatile ToolHelper instance;
    private final ConcurrentHashMap<String, AndroidMCPClient> clientCache = new ConcurrentHashMap<>();
    private Context context;

    public ToolHelper(Context context) {
        this.context = context.getApplicationContext();
    }

    public static ToolHelper getInstance(Context context) {
        Assert.notNull(context, "context can not be null");
        if (instance == null) {
            synchronized (ToolHelper.class) {
                try {
                    if (instance == null) {
                        instance = new ToolHelper(context);
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$destroy$0(String str, AndroidMCPClient androidMCPClient) {
        try {
            androidMCPClient.disconnect();
        } catch (Exception e10) {
            KLog.w(TAG, "Error disconnecting client: " + androidMCPClient + "," + e10);
        }
    }

    public void destroy() {
        this.clientCache.forEach(new b(9));
        this.clientCache.clear();
    }

    public AndroidMCPClient getClient(String str) {
        AndroidMCPClient androidMCPClient = this.clientCache.get(str);
        if (androidMCPClient != null) {
            return androidMCPClient;
        }
        KLog.d(TAG, "Creating new MCPClient for service:" + str);
        AndroidMCPClient androidMCPClient2 = new AndroidMCPClient(this.context, str);
        this.clientCache.put(str, androidMCPClient2);
        return androidMCPClient2;
    }

    public AndroidMCPClient releaseClient(String str) {
        if (str == null) {
            return null;
        }
        AndroidMCPClient androidMCPClientRemove = this.clientCache.remove(str);
        if (androidMCPClientRemove != null) {
            androidMCPClientRemove.disconnect();
        }
        return androidMCPClientRemove;
    }

    public static ToolHelper getInstance() {
        if (instance != null) {
            return instance;
        }
        f.o("ToolHelper does not init");
        return null;
    }
}
