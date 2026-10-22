package com.stepos.mcp.sdk.java;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class MCP {
    public static RequestBuilder with(@NonNull Context context) {
        return new RequestBuilder(context);
    }
}
