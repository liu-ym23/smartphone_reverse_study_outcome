package com.stepos.stepclaw.bridge.openclaw;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ImplementedBy;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import f5.c;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.json.Json;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@ImplementedBy(implClass = "com.stepos.stepclaw.openclaw.OpenClawClient")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J0\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H¦@¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H¦@¢\u0006\u0004\b\r\u0010\u000bJ\\\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072$\u0010\u0011\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u0007\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u000fH¦@¢\u0006\u0004\b\n\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H¦@¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/bridge/openclaw/IOpenClawClient;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toolName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "args", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResponse;", "invokeTool", "(Ljava/lang/String;Ljava/util/Map;Lf5/c;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonObject;", "invokeToolRaw", "T", "Lkotlin/Function2;", "Lkotlinx/serialization/json/JsonElement;", "parser", "(Ljava/lang/String;Ljava/util/Map;Lp5/p;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "healthCheck", "(Lf5/c;)Ljava/lang/Object;", "getBaseUrl", "()Ljava/lang/String;", ConfigIpcContract.KEY_BASE_URL, "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IOpenClawClient {
    String getBaseUrl();

    Json getJson();

    Object healthCheck(c cVar);

    Object invokeTool(String str, Map<String, ? extends Object> map, c cVar);

    <T> Object invokeTool(String str, Map<String, ? extends Object> map, p pVar, c cVar);

    Object invokeToolRaw(String str, Map<String, ? extends Object> map, c cVar);
}
