package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import kotlin.C0918n;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/l;", "", "", "sendId", "LK6/n;", "chatRequestInfo", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/agentframework/adapter/bff/p;", "callback", "<init>", "(Ljava/lang/String;LK6/n;Ljava/lang/ref/WeakReference;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "LK6/n;", Const.INTENT_KEY_PKGNAME, "()LK6/n;", "Ljava/lang/ref/WeakReference;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/ref/WeakReference;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.bff.l, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class CacheBean {
    private final WeakReference<p> callback;
    private final C0918n chatRequestInfo;
    private final String sendId;

    public CacheBean(String sendId, C0918n c0918n, WeakReference<p> callback) {
        kotlin.jvm.internal.p.i(sendId, "sendId");
        kotlin.jvm.internal.p.i(callback, "callback");
        this.sendId = sendId;
        this.chatRequestInfo = c0918n;
        this.callback = callback;
    }

    public final WeakReference<p> a() {
        return this.callback;
    }

    /* renamed from: b, reason: from getter */
    public final C0918n getChatRequestInfo() {
        return this.chatRequestInfo;
    }

    /* renamed from: c, reason: from getter */
    public final String getSendId() {
        return this.sendId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheBean)) {
            return false;
        }
        CacheBean cacheBean = (CacheBean) other;
        return kotlin.jvm.internal.p.d(this.sendId, cacheBean.sendId) && kotlin.jvm.internal.p.d(this.chatRequestInfo, cacheBean.chatRequestInfo) && kotlin.jvm.internal.p.d(this.callback, cacheBean.callback);
    }

    public int hashCode() {
        int iHashCode = this.sendId.hashCode() * 31;
        C0918n c0918n = this.chatRequestInfo;
        return ((iHashCode + (c0918n == null ? 0 : c0918n.hashCode())) * 31) + this.callback.hashCode();
    }

    public String toString() {
        return "CacheBean(sendId=" + this.sendId + ", chatRequestInfo=" + this.chatRequestInfo + ", callback=" + this.callback + ")";
    }
}
