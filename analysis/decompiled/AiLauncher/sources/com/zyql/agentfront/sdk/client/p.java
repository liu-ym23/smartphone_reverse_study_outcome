package com.zyql.agentfront.sdk.client;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.zyql.agentfront.bean.ToolResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/zyql/agentfront/sdk/client/p;", "", "Lcom/zyql/agentfront/bean/ToolResponse;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/zyql/agentfront/bean/ToolResponse;)V", "", "responses", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface p {
    default void a(List<ToolResponse> responses) {
        kotlin.jvm.internal.p.i(responses, "responses");
        Iterator<T> it = responses.iterator();
        while (it.hasNext()) {
            b((ToolResponse) it.next());
        }
    }

    void b(ToolResponse response);
}
