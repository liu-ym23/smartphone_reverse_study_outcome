package com.stepos.agentframework.adapter.bff;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/PendingTask;", "", "id", "", SettingsConfig.KEY_DATA, "", "bean", "Lcom/stepos/agentframework/adapter/bff/CacheBean;", AppAgent.CONSTRUCT, "(Ljava/lang/String;[BLcom/stepos/agentframework/adapter/bff/CacheBean;)V", "getId", "()Ljava/lang/String;", "getData", "()[B", "getBean", "()Lcom/stepos/agentframework/adapter/bff/CacheBean;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* data */ class PendingTask {
    private final CacheBean bean;
    private final byte[] data;
    private final String id;

    public PendingTask(String id, byte[] data, CacheBean bean) {
        k.f(id, "id");
        k.f(data, "data");
        k.f(bean, "bean");
        this.id = id;
        this.data = data;
        this.bean = bean;
    }

    public static /* synthetic */ PendingTask copy$default(PendingTask pendingTask, String str, byte[] bArr, CacheBean cacheBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pendingTask.id;
        }
        if ((i & 2) != 0) {
            bArr = pendingTask.data;
        }
        if ((i & 4) != 0) {
            cacheBean = pendingTask.bean;
        }
        return pendingTask.copy(str, bArr, cacheBean);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final CacheBean getBean() {
        return this.bean;
    }

    public final PendingTask copy(String id, byte[] data, CacheBean bean) {
        k.f(id, "id");
        k.f(data, "data");
        k.f(bean, "bean");
        return new PendingTask(id, data, bean);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingTask)) {
            return false;
        }
        PendingTask pendingTask = (PendingTask) other;
        return k.b(this.id, pendingTask.id) && k.b(this.data, pendingTask.data) && k.b(this.bean, pendingTask.bean);
    }

    public final CacheBean getBean() {
        return this.bean;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.bean.hashCode() + ((Arrays.hashCode(this.data) + (this.id.hashCode() * 31)) * 31);
    }

    public String toString() {
        String str = this.id;
        String string = Arrays.toString(this.data);
        CacheBean cacheBean = this.bean;
        StringBuilder sbW = B7.a.w("PendingTask(id=", str, ", data=", string, ", bean=");
        sbW.append(cacheBean);
        sbW.append(")");
        return sbW.toString();
    }
}
