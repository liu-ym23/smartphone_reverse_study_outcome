package com.stepos.agentframework.adapter.bff;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/t;", "", "", "id", "", "data", "Lcom/stepos/agentframework/adapter/bff/l;", "bean", "<init>", "(Ljava/lang/String;[BLcom/stepos/agentframework/adapter/bff/l;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "[B", Const.INTENT_KEY_PKGNAME, "()[B", "Lcom/stepos/agentframework/adapter/bff/l;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/bff/l;", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.bff.t, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class PendingTask {
    private final CacheBean bean;
    private final byte[] data;
    private final String id;

    public PendingTask(String id, byte[] data, CacheBean bean) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(data, "data");
        kotlin.jvm.internal.p.i(bean, "bean");
        this.id = id;
        this.data = data;
        this.bean = bean;
    }

    /* renamed from: a, reason: from getter */
    public final CacheBean getBean() {
        return this.bean;
    }

    /* renamed from: b, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingTask)) {
            return false;
        }
        PendingTask pendingTask = (PendingTask) other;
        return kotlin.jvm.internal.p.d(this.id, pendingTask.id) && kotlin.jvm.internal.p.d(this.data, pendingTask.data) && kotlin.jvm.internal.p.d(this.bean, pendingTask.bean);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + Arrays.hashCode(this.data)) * 31) + this.bean.hashCode();
    }

    public String toString() {
        return "PendingTask(id=" + this.id + ", data=" + Arrays.toString(this.data) + ", bean=" + this.bean + ")";
    }
}
