package com.tonyodev.fetch2;

import ai.onnxruntime.a;
import com.tonyodev.fetch2core.Extras;
import gb.b;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class RequestInfo implements Serializable {
    private int autoRetryMaxAttempts;
    private Extras extras;
    private int groupId;
    private long identifier;
    private String tag;
    private final Map<String, String> headers = new LinkedHashMap();
    private Priority priority = b.f9099c;
    private NetworkType networkType = b.f9097a;
    private EnqueueAction enqueueAction = b.f9103g;
    private boolean downloadOnEnqueue = true;

    public RequestInfo() {
        Extras.CREATOR.getClass();
        this.extras = Extras.emptyExtras;
    }

    public final void addHeader(String key, String value) {
        g.f(key, "key");
        g.f(value, "value");
        this.headers.put(key, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.RequestInfo");
        RequestInfo requestInfo = (RequestInfo) obj;
        return this.identifier == requestInfo.identifier && this.groupId == requestInfo.groupId && g.b(this.headers, requestInfo.headers) && this.priority == requestInfo.priority && this.networkType == requestInfo.networkType && g.b(this.tag, requestInfo.tag) && this.enqueueAction == requestInfo.enqueueAction && this.downloadOnEnqueue == requestInfo.downloadOnEnqueue && g.b(this.extras, requestInfo.extras) && this.autoRetryMaxAttempts == requestInfo.autoRetryMaxAttempts;
    }

    public final int getAutoRetryMaxAttempts() {
        return this.autoRetryMaxAttempts;
    }

    public final boolean getDownloadOnEnqueue() {
        return this.downloadOnEnqueue;
    }

    public final EnqueueAction getEnqueueAction() {
        return this.enqueueAction;
    }

    public final Extras getExtras() {
        return this.extras;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final long getIdentifier() {
        return this.identifier;
    }

    public final NetworkType getNetworkType() {
        return this.networkType;
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        int iHashCode = (this.networkType.hashCode() + ((this.priority.hashCode() + ((this.headers.hashCode() + (((Long.hashCode(this.identifier) * 31) + this.groupId) * 31)) * 31)) * 31)) * 31;
        String str = this.tag;
        return ((this.extras.hashCode() + a.f((this.enqueueAction.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31)) * 31, 31, this.downloadOnEnqueue)) * 31) + this.autoRetryMaxAttempts;
    }

    public final void setAutoRetryMaxAttempts(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("The maximum number of attempts has to be greater than -1");
        }
        this.autoRetryMaxAttempts = i10;
    }

    public final void setDownloadOnEnqueue(boolean z) {
        this.downloadOnEnqueue = z;
    }

    public final void setEnqueueAction(EnqueueAction enqueueAction) {
        g.f(enqueueAction, "<set-?>");
        this.enqueueAction = enqueueAction;
    }

    public final void setExtras(Extras value) {
        g.f(value, "value");
        this.extras = value.copy();
    }

    public final void setGroupId(int i10) {
        this.groupId = i10;
    }

    public final void setIdentifier(long j10) {
        this.identifier = j10;
    }

    public final void setNetworkType(NetworkType networkType) {
        g.f(networkType, "<set-?>");
        this.networkType = networkType;
    }

    public final void setPriority(Priority priority) {
        g.f(priority, "<set-?>");
        this.priority = priority;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public String toString() {
        long j10 = this.identifier;
        int i10 = this.groupId;
        Map<String, String> map = this.headers;
        Priority priority = this.priority;
        NetworkType networkType = this.networkType;
        String str = this.tag;
        EnqueueAction enqueueAction = this.enqueueAction;
        boolean z = this.downloadOnEnqueue;
        int i11 = this.autoRetryMaxAttempts;
        Extras extras = this.extras;
        StringBuilder sbR = a.r(j10, "RequestInfo(identifier=", ", groupId=", i10);
        sbR.append(", headers=");
        sbR.append(map);
        sbR.append(", priority=");
        sbR.append(priority);
        sbR.append(", networkType=");
        sbR.append(networkType);
        sbR.append(", tag=");
        sbR.append(str);
        sbR.append(", enqueueAction=");
        sbR.append(enqueueAction);
        sbR.append(", downloadOnEnqueue=");
        sbR.append(z);
        sbR.append(", autoRetryMaxAttempts=");
        sbR.append(i11);
        sbR.append(", extras=");
        sbR.append(extras);
        sbR.append(")");
        return sbR.toString();
    }
}
