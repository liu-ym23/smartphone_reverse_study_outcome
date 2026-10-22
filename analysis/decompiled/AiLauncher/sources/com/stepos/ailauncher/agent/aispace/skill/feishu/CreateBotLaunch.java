package com.stepos.ailauncher.agent.aispace.skill.feishu;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/c;", "", "", "url", "", "extras", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.c, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class CreateBotLaunch {
    private final Map<String, String> extras;
    private final String url;

    public CreateBotLaunch(String url, Map<String, String> extras) {
        kotlin.jvm.internal.p.i(url, "url");
        kotlin.jvm.internal.p.i(extras, "extras");
        this.url = url;
        this.extras = extras;
    }

    /* renamed from: a, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateBotLaunch)) {
            return false;
        }
        CreateBotLaunch createBotLaunch = (CreateBotLaunch) other;
        return kotlin.jvm.internal.p.d(this.url, createBotLaunch.url) && kotlin.jvm.internal.p.d(this.extras, createBotLaunch.extras);
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "CreateBotLaunch(url=" + this.url + ", extras=" + this.extras + ")";
    }

    public /* synthetic */ CreateBotLaunch(String str, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? kotlin.collections.a.i() : map);
    }
}
