package com.tonyodev.fetch2.database;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2core.Extras;
import gb.b;
import h0.e;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DownloadInfo implements Download {
    public static final a CREATOR = new a();
    private int autoRetryAttempts;
    private int autoRetryMaxAttempts;
    private long downloaded;
    private long downloadedBytesPerSecond;
    private long etaInMilliSeconds;
    private Extras extras;
    private int group;

    /* renamed from: id, reason: collision with root package name */
    private int f8202id;
    private long identifier;
    private String tag;
    private String namespace = "";
    private String url = "";
    private String file = "";
    private Priority priority = b.f9099c;
    private Map<String, String> headers = new LinkedHashMap();
    private long total = -1;
    private Status status = b.f9101e;
    private Error error = b.f9100d;
    private NetworkType networkType = b.f9097a;
    private long created = Calendar.getInstance().getTimeInMillis();
    private EnqueueAction enqueueAction = EnqueueAction.f8148c;
    private boolean downloadOnEnqueue = true;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<DownloadInfo> {
        @Override // android.os.Parcelable.Creator
        public final DownloadInfo createFromParcel(Parcel source) {
            g.f(source, "source");
            int i10 = source.readInt();
            String string = source.readString();
            if (string == null) {
                string = "";
            }
            String string2 = source.readString();
            if (string2 == null) {
                string2 = "";
            }
            String string3 = source.readString();
            String str = string3 != null ? string3 : "";
            int i11 = source.readInt();
            Priority.a aVar = Priority.f8179b;
            int i12 = source.readInt();
            aVar.getClass();
            Priority priorityA = Priority.a.a(i12);
            Serializable serializable = source.readSerializable();
            g.d(serializable, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Map<String, String> map = (Map) serializable;
            long j10 = source.readLong();
            long j11 = source.readLong();
            Status.a aVar2 = Status.f8188b;
            int i13 = source.readInt();
            aVar2.getClass();
            Status statusA = Status.a.a(i13);
            Error.a aVar3 = Error.f8153b;
            int i14 = source.readInt();
            aVar3.getClass();
            Error errorA = Error.a.a(i14);
            NetworkType.a aVar4 = NetworkType.f8173b;
            int i15 = source.readInt();
            aVar4.getClass();
            NetworkType networkTypeA = NetworkType.a.a(i15);
            long j12 = source.readLong();
            String string4 = source.readString();
            EnqueueAction.a aVar5 = EnqueueAction.f8147b;
            int i16 = source.readInt();
            aVar5.getClass();
            EnqueueAction enqueueActionA = EnqueueAction.a.a(i16);
            long j13 = source.readLong();
            boolean z = source.readInt() == 1;
            long j14 = source.readLong();
            long j15 = source.readLong();
            Serializable serializable2 = source.readSerializable();
            g.d(serializable2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            int i17 = source.readInt();
            int i18 = source.readInt();
            DownloadInfo downloadInfo = new DownloadInfo();
            downloadInfo.setId(i10);
            downloadInfo.setNamespace(string);
            downloadInfo.setUrl(string2);
            downloadInfo.setFile(str);
            downloadInfo.setGroup(i11);
            downloadInfo.setPriority(priorityA);
            downloadInfo.setHeaders(map);
            downloadInfo.setDownloaded(j10);
            downloadInfo.setTotal(j11);
            downloadInfo.setStatus(statusA);
            downloadInfo.setError(errorA);
            downloadInfo.setNetworkType(networkTypeA);
            downloadInfo.setCreated(j12);
            downloadInfo.setTag(string4);
            downloadInfo.setEnqueueAction(enqueueActionA);
            downloadInfo.setIdentifier(j13);
            downloadInfo.setDownloadOnEnqueue(z);
            downloadInfo.setEtaInMilliSeconds(j14);
            downloadInfo.setDownloadedBytesPerSecond(j15);
            downloadInfo.setExtras(new Extras((Map) serializable2));
            downloadInfo.setAutoRetryMaxAttempts(i17);
            downloadInfo.setAutoRetryAttempts(i18);
            return downloadInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadInfo[] newArray(int i10) {
            return new DownloadInfo[i10];
        }
    }

    public DownloadInfo() {
        Extras.CREATOR.getClass();
        this.extras = Extras.emptyExtras;
        this.etaInMilliSeconds = -1L;
        this.downloadedBytesPerSecond = -1L;
    }

    @Override // com.tonyodev.fetch2.Download
    public Download copy() {
        DownloadInfo downloadInfo = new DownloadInfo();
        a4.a.w(this, downloadInfo);
        return downloadInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.database.DownloadInfo");
        DownloadInfo downloadInfo = (DownloadInfo) obj;
        return getId() == downloadInfo.getId() && g.b(getNamespace(), downloadInfo.getNamespace()) && g.b(getUrl(), downloadInfo.getUrl()) && g.b(getFile(), downloadInfo.getFile()) && getGroup() == downloadInfo.getGroup() && getPriority() == downloadInfo.getPriority() && g.b(getHeaders(), downloadInfo.getHeaders()) && getDownloaded() == downloadInfo.getDownloaded() && getTotal() == downloadInfo.getTotal() && getStatus() == downloadInfo.getStatus() && getError() == downloadInfo.getError() && getNetworkType() == downloadInfo.getNetworkType() && getCreated() == downloadInfo.getCreated() && g.b(getTag(), downloadInfo.getTag()) && getEnqueueAction() == downloadInfo.getEnqueueAction() && getIdentifier() == downloadInfo.getIdentifier() && getDownloadOnEnqueue() == downloadInfo.getDownloadOnEnqueue() && g.b(getExtras(), downloadInfo.getExtras()) && getEtaInMilliSeconds() == downloadInfo.getEtaInMilliSeconds() && getDownloadedBytesPerSecond() == downloadInfo.getDownloadedBytesPerSecond() && getAutoRetryMaxAttempts() == downloadInfo.getAutoRetryMaxAttempts() && getAutoRetryAttempts() == downloadInfo.getAutoRetryAttempts();
    }

    @Override // com.tonyodev.fetch2.Download
    public int getAutoRetryAttempts() {
        return this.autoRetryAttempts;
    }

    @Override // com.tonyodev.fetch2.Download
    public int getAutoRetryMaxAttempts() {
        return this.autoRetryMaxAttempts;
    }

    @Override // com.tonyodev.fetch2.Download
    public long getCreated() {
        return this.created;
    }

    @Override // com.tonyodev.fetch2.Download
    public boolean getDownloadOnEnqueue() {
        return this.downloadOnEnqueue;
    }

    @Override // com.tonyodev.fetch2.Download
    public long getDownloaded() {
        return this.downloaded;
    }

    @Override // com.tonyodev.fetch2.Download
    public long getDownloadedBytesPerSecond() {
        return this.downloadedBytesPerSecond;
    }

    @Override // com.tonyodev.fetch2.Download
    public EnqueueAction getEnqueueAction() {
        return this.enqueueAction;
    }

    @Override // com.tonyodev.fetch2.Download
    public Error getError() {
        return this.error;
    }

    @Override // com.tonyodev.fetch2.Download
    public long getEtaInMilliSeconds() {
        return this.etaInMilliSeconds;
    }

    @Override // com.tonyodev.fetch2.Download
    public Extras getExtras() {
        return this.extras;
    }

    @Override // com.tonyodev.fetch2.Download
    public String getFile() {
        return this.file;
    }

    @Override // com.tonyodev.fetch2.Download
    public Uri getFileUri() {
        return com.tonyodev.fetch2core.b.j(getFile());
    }

    @Override // com.tonyodev.fetch2.Download
    public int getGroup() {
        return this.group;
    }

    @Override // com.tonyodev.fetch2.Download
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.tonyodev.fetch2.Download
    public int getId() {
        return this.f8202id;
    }

    @Override // com.tonyodev.fetch2.Download
    public long getIdentifier() {
        return this.identifier;
    }

    @Override // com.tonyodev.fetch2.Download
    public String getNamespace() {
        return this.namespace;
    }

    @Override // com.tonyodev.fetch2.Download
    public NetworkType getNetworkType() {
        return this.networkType;
    }

    @Override // com.tonyodev.fetch2.Download
    public Priority getPriority() {
        return this.priority;
    }

    @Override // com.tonyodev.fetch2.Download
    public int getProgress() {
        return com.tonyodev.fetch2core.b.c(getDownloaded(), getTotal());
    }

    @Override // com.tonyodev.fetch2.Download
    public Request getRequest() {
        Request request = new Request(getUrl(), getFile());
        request.setGroupId(getGroup());
        request.getHeaders().putAll(getHeaders());
        request.setNetworkType(getNetworkType());
        request.setPriority(getPriority());
        request.setEnqueueAction(getEnqueueAction());
        request.setIdentifier(getIdentifier());
        request.setDownloadOnEnqueue(getDownloadOnEnqueue());
        request.setExtras(getExtras());
        request.setAutoRetryMaxAttempts(getAutoRetryMaxAttempts());
        return request;
    }

    @Override // com.tonyodev.fetch2.Download
    public Status getStatus() {
        return this.status;
    }

    @Override // com.tonyodev.fetch2.Download
    public String getTag() {
        return this.tag;
    }

    @Override // com.tonyodev.fetch2.Download
    public long getTotal() {
        return this.total;
    }

    @Override // com.tonyodev.fetch2.Download
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = (Long.hashCode(getCreated()) + ((getNetworkType().hashCode() + ((getError().hashCode() + ((getStatus().hashCode() + ((Long.hashCode(getTotal()) + ((Long.hashCode(getDownloaded()) + ((getHeaders().hashCode() + ((getPriority().hashCode() + ((getGroup() + ((getFile().hashCode() + ((getUrl().hashCode() + ((getNamespace().hashCode() + (getId() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String tag = getTag();
        return Integer.hashCode(getAutoRetryAttempts()) + ((Integer.hashCode(getAutoRetryMaxAttempts()) + ((Long.hashCode(getDownloadedBytesPerSecond()) + ((Long.hashCode(getEtaInMilliSeconds()) + ((getExtras().hashCode() + ((Boolean.hashCode(getDownloadOnEnqueue()) + ((Long.hashCode(getIdentifier()) + ((getEnqueueAction().hashCode() + ((iHashCode + (tag != null ? tag.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public void setAutoRetryAttempts(int i10) {
        this.autoRetryAttempts = i10;
    }

    public void setAutoRetryMaxAttempts(int i10) {
        this.autoRetryMaxAttempts = i10;
    }

    public void setCreated(long j10) {
        this.created = j10;
    }

    public void setDownloadOnEnqueue(boolean z) {
        this.downloadOnEnqueue = z;
    }

    public void setDownloaded(long j10) {
        this.downloaded = j10;
    }

    public void setDownloadedBytesPerSecond(long j10) {
        this.downloadedBytesPerSecond = j10;
    }

    public void setEnqueueAction(EnqueueAction enqueueAction) {
        g.f(enqueueAction, "<set-?>");
        this.enqueueAction = enqueueAction;
    }

    public void setError(Error error) {
        g.f(error, "<set-?>");
        this.error = error;
    }

    public void setEtaInMilliSeconds(long j10) {
        this.etaInMilliSeconds = j10;
    }

    public void setExtras(Extras extras) {
        g.f(extras, "<set-?>");
        this.extras = extras;
    }

    public void setFile(String str) {
        g.f(str, "<set-?>");
        this.file = str;
    }

    public void setGroup(int i10) {
        this.group = i10;
    }

    public void setHeaders(Map<String, String> map) {
        g.f(map, "<set-?>");
        this.headers = map;
    }

    public void setId(int i10) {
        this.f8202id = i10;
    }

    public void setIdentifier(long j10) {
        this.identifier = j10;
    }

    public void setNamespace(String str) {
        g.f(str, "<set-?>");
        this.namespace = str;
    }

    public void setNetworkType(NetworkType networkType) {
        g.f(networkType, "<set-?>");
        this.networkType = networkType;
    }

    public void setPriority(Priority priority) {
        g.f(priority, "<set-?>");
        this.priority = priority;
    }

    public void setStatus(Status status) {
        g.f(status, "<set-?>");
        this.status = status;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTotal(long j10) {
        this.total = j10;
    }

    public void setUrl(String str) {
        g.f(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        int id2 = getId();
        String namespace = getNamespace();
        String url = getUrl();
        String file = getFile();
        int group = getGroup();
        Priority priority = getPriority();
        Map<String, String> headers = getHeaders();
        long downloaded = getDownloaded();
        long total = getTotal();
        Status status = getStatus();
        Error error = getError();
        NetworkType networkType = getNetworkType();
        long created = getCreated();
        String tag = getTag();
        EnqueueAction enqueueAction = getEnqueueAction();
        long identifier = getIdentifier();
        boolean downloadOnEnqueue = getDownloadOnEnqueue();
        Extras extras = getExtras();
        int autoRetryMaxAttempts = getAutoRetryMaxAttempts();
        int autoRetryAttempts = getAutoRetryAttempts();
        long etaInMilliSeconds = getEtaInMilliSeconds();
        long downloadedBytesPerSecond = getDownloadedBytesPerSecond();
        StringBuilder sbE = e.e("DownloadInfo(id=", id2, ", namespace='", namespace, "', url='");
        ai.onnxruntime.a.z(sbE, url, "', file='", file, "', group=");
        sbE.append(group);
        sbE.append(", priority=");
        sbE.append(priority);
        sbE.append(", headers=");
        sbE.append(headers);
        sbE.append(", downloaded=");
        sbE.append(downloaded);
        a0.a.s(total, ", total=", ", status=", sbE);
        sbE.append(status);
        sbE.append(", error=");
        sbE.append(error);
        sbE.append(", networkType=");
        sbE.append(networkType);
        sbE.append(", created=");
        sbE.append(created);
        sbE.append(", tag=");
        sbE.append(tag);
        sbE.append(", enqueueAction=");
        sbE.append(enqueueAction);
        a0.a.s(identifier, ", identifier=", ", downloadOnEnqueue=", sbE);
        sbE.append(downloadOnEnqueue);
        sbE.append(", extras=");
        sbE.append(extras);
        sbE.append(", autoRetryMaxAttempts=");
        e.l(sbE, autoRetryMaxAttempts, ", autoRetryAttempts=", autoRetryAttempts, ", etaInMilliSeconds=");
        sbE.append(etaInMilliSeconds);
        return a0.a.d(downloadedBytesPerSecond, ", downloadedBytesPerSecond=", ")", sbE);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(getId());
        dest.writeString(getNamespace());
        dest.writeString(getUrl());
        dest.writeString(getFile());
        dest.writeInt(getGroup());
        dest.writeInt(getPriority().f8183a);
        dest.writeSerializable(new HashMap(getHeaders()));
        dest.writeLong(getDownloaded());
        dest.writeLong(getTotal());
        dest.writeInt(getStatus().f8199a);
        dest.writeInt(getError().f8172a);
        dest.writeInt(getNetworkType().f8178a);
        dest.writeLong(getCreated());
        dest.writeString(getTag());
        dest.writeInt(getEnqueueAction().f8152a);
        dest.writeLong(getIdentifier());
        dest.writeInt(getDownloadOnEnqueue() ? 1 : 0);
        dest.writeLong(getEtaInMilliSeconds());
        dest.writeLong(getDownloadedBytesPerSecond());
        dest.writeSerializable(new HashMap(getExtras().getMap()));
        dest.writeInt(getAutoRetryMaxAttempts());
        dest.writeInt(getAutoRetryAttempts());
    }
}
