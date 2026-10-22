package com.stepos.mcp.sdk.java;

import android.content.Context;
import androidx.annotation.NonNull;
import com.stepos.mcp.sdk.java.client.AndroidMCPClient;
import com.stepos.mcp.sdk.java.client.IClientDecorator;
import com.stepos.mcp.sdk.java.client.ToolHelper;
import io.modelcontextprotocol.spec.McpError;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class RequestBuilder {
    private static final String TAG = "RequestBuilder";
    private AndroidMCPClient client;
    private Context context;
    private final List<IClientDecorator> decorators = new LinkedList();
    private String target;

    public RequestBuilder(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        this.context = context;
    }

    public RequestBuilder addDecorator(IClientDecorator iClientDecorator) {
        if (iClientDecorator != null) {
            this.decorators.add(iClientDecorator);
        }
        return this;
    }

    public AndroidMCPClient build() {
        AndroidMCPClient client = ToolHelper.getInstance(this.context).getClient(this.target);
        this.client = client;
        List<IClientDecorator> list = this.decorators;
        Objects.requireNonNull(client);
        list.forEach(new a(client, 0));
        return this.client;
    }

    public McpSchema.CallToolResult callToolOnce(McpSchema.CallToolRequest callToolRequest) {
        if (this.client == null) {
            build();
        }
        try {
            try {
                return this.client.callTool(callToolRequest);
            } catch (Exception e) {
                KLog.e(TAG, "callToolOnce fail: " + e.getClass().getSimpleName() + ", code=" + ((!(e instanceof McpError) || ((McpError) e).getJsonRpcError() == null) ? null : ((McpError) e).getJsonRpcError().code()));
                throw e;
            }
        } finally {
            KLog.i(TAG, "callToolOnce end, client will auto release ");
        }
    }

    public RequestBuilder to(@NonNull String str) {
        this.target = str;
        return this;
    }
}
