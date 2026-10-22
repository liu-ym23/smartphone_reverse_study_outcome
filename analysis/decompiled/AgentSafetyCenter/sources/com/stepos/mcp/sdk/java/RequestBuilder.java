package com.stepos.mcp.sdk.java;

import android.content.Context;
import b8.g0;
import com.stepos.mcp.sdk.java.client.AndroidMCPClient;
import com.stepos.mcp.sdk.java.client.IClientDecorator;
import com.stepos.mcp.sdk.java.client.ToolHelper;
import g5.f;
import io.modelcontextprotocol.spec.McpSchema;
import java.lang.invoke.VarHandle;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class RequestBuilder {
    private static final String TAG = "RequestBuilder";
    private AndroidMCPClient client;
    private Context context;
    private final List<IClientDecorator> decorators = new LinkedList();
    private String target;

    public RequestBuilder(Context context) {
        if (context != null) {
            this.context = context;
        } else {
            f.s("You cannot start a load on a null Context");
            throw null;
        }
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
        g0 g0Var = new g0(1);
        g0Var.f1963f = client;
        VarHandle.storeStoreFence();
        list.forEach(g0Var);
        return this.client;
    }

    public McpSchema.CallToolResult callToolOnce(McpSchema.CallToolRequest callToolRequest) {
        if (this.client == null) {
            build();
        }
        try {
            try {
                return this.client.callTool(callToolRequest);
            } catch (Exception e10) {
                e10.printStackTrace();
                KLog.e(TAG, "callToolOnce fail: " + e10);
                throw e10;
            }
        } finally {
            KLog.i(TAG, "callToolOnce end, client will auto release ");
        }
    }

    public RequestBuilder to(String str) {
        this.target = str;
        return this;
    }
}
