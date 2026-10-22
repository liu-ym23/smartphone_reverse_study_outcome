package com.stepos.ability.mcpserver.security;

import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.IOException;
import java.util.Map;
import k4.x;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001:\u0001\u0007J3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"com/stepos/ability/mcpserver/security/RemoteKeyValidator$HttpTransport", "", "", BffConstant.Type.Url, "", "headers", "jsonBody", "Lk4/x;", "post", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lk4/x;", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteKeyValidator$HttpTransport {
    x post(String url, Map<String, String> headers, String jsonBody) throws IOException;
}
