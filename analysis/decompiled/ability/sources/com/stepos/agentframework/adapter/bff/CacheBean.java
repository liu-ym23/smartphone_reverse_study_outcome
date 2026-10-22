package com.stepos.agentframework.adapter.bff;

import V4.l;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J6\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u000eR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/CacheBean;", "", "", "sendId", "LV4/l;", "chatRequestInfo", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/agentframework/adapter/bff/IDataCallback;", "callback", AppAgent.CONSTRUCT, "(Ljava/lang/String;LV4/l;Ljava/lang/ref/WeakReference;)V", "component1", "()Ljava/lang/String;", "component2", "()LV4/l;", "component3", "()Ljava/lang/ref/WeakReference;", "copy", "(Ljava/lang/String;LV4/l;Ljava/lang/ref/WeakReference;)Lcom/stepos/agentframework/adapter/bff/CacheBean;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSendId", "LV4/l;", "getChatRequestInfo", "Ljava/lang/ref/WeakReference;", "getCallback", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CacheBean {
    private final WeakReference<IDataCallback> callback;
    private final l chatRequestInfo;
    private final String sendId;

    public CacheBean(String sendId, l lVar, WeakReference<IDataCallback> callback) {
        k.f(sendId, "sendId");
        k.f(callback, "callback");
        this.sendId = sendId;
        this.chatRequestInfo = lVar;
        this.callback = callback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CacheBean copy$default(CacheBean cacheBean, String str, l lVar, WeakReference weakReference, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cacheBean.sendId;
        }
        if ((i & 2) != 0) {
            lVar = cacheBean.chatRequestInfo;
        }
        if ((i & 4) != 0) {
            weakReference = cacheBean.callback;
        }
        return cacheBean.copy(str, lVar, weakReference);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSendId() {
        return this.sendId;
    }

    /* renamed from: component2, reason: from getter */
    public final l getChatRequestInfo() {
        return this.chatRequestInfo;
    }

    public final WeakReference<IDataCallback> component3() {
        return this.callback;
    }

    public final CacheBean copy(String sendId, l chatRequestInfo, WeakReference<IDataCallback> callback) {
        k.f(sendId, "sendId");
        k.f(callback, "callback");
        return new CacheBean(sendId, chatRequestInfo, callback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheBean)) {
            return false;
        }
        CacheBean cacheBean = (CacheBean) other;
        return k.b(this.sendId, cacheBean.sendId) && k.b(this.chatRequestInfo, cacheBean.chatRequestInfo) && k.b(this.callback, cacheBean.callback);
    }

    public final WeakReference<IDataCallback> getCallback() {
        return this.callback;
    }

    public final l getChatRequestInfo() {
        return this.chatRequestInfo;
    }

    public final String getSendId() {
        return this.sendId;
    }

    public int hashCode() {
        int iHashCode = this.sendId.hashCode() * 31;
        l lVar = this.chatRequestInfo;
        return this.callback.hashCode() + ((iHashCode + (lVar == null ? 0 : lVar.hashCode())) * 31);
    }

    public String toString() {
        return "CacheBean(sendId=" + this.sendId + ", chatRequestInfo=" + this.chatRequestInfo + ", callback=" + this.callback + ")";
    }
}
