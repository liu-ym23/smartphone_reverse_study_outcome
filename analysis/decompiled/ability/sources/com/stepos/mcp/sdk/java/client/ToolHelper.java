package com.stepos.mcp.sdk.java.client;

import A3.b;
import android.content.Context;
import androidx.annotation.NonNull;
import com.stepos.mcp.sdk.java.KLog;
import io.modelcontextprotocol.util.Assert;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
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
        } catch (Exception e) {
            KLog.w(TAG, "Error disconnecting client: " + androidMCPClient + "," + e);
        }
    }

    public void destroy() {
        this.clientCache.forEach(new b(9));
        this.clientCache.clear();
    }

    public AndroidMCPClient getClient(@NonNull String str) {
        AndroidMCPClient androidMCPClient = this.clientCache.get(str);
        if (androidMCPClient != null) {
            return androidMCPClient;
        }
        KLog.d(TAG, "Creating new MCPClient for service:" + str);
        AndroidMCPClient androidMCPClient2 = new AndroidMCPClient(this.context, str);
        this.clientCache.put(str, androidMCPClient2);
        return androidMCPClient2;
    }

    public AndroidMCPClient releaseClient(@NonNull String str) {
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
        throw new RuntimeException("ToolHelper does not init");
    }
}
