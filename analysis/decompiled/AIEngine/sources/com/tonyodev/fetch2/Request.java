package com.tonyodev.fetch2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2core.Extras;
import com.tonyodev.fetch2core.b;
import h0.e;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class Request extends RequestInfo implements Parcelable, Serializable {
    public static final a CREATOR = new a();
    private final String file;

    /* renamed from: id, reason: collision with root package name */
    private final int f8187id;
    private final String url;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<Request> {
        @Override // android.os.Parcelable.Creator
        public final Request createFromParcel(Parcel input) {
            g.f(input, "input");
            String string = input.readString();
            if (string == null) {
                string = "";
            }
            String string2 = input.readString();
            String str = string2 != null ? string2 : "";
            long j10 = input.readLong();
            int i10 = input.readInt();
            Serializable serializable = input.readSerializable();
            g.d(serializable, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Map map = (Map) serializable;
            Priority.a aVar = Priority.f8179b;
            int i11 = input.readInt();
            aVar.getClass();
            Priority priorityA = Priority.a.a(i11);
            NetworkType.a aVar2 = NetworkType.f8173b;
            int i12 = input.readInt();
            aVar2.getClass();
            NetworkType networkTypeA = NetworkType.a.a(i12);
            String string3 = input.readString();
            EnqueueAction.a aVar3 = EnqueueAction.f8147b;
            int i13 = input.readInt();
            aVar3.getClass();
            EnqueueAction enqueueActionA = EnqueueAction.a.a(i13);
            boolean z = input.readInt() == 1;
            Serializable serializable2 = input.readSerializable();
            g.d(serializable2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Map map2 = (Map) serializable2;
            int i14 = input.readInt();
            Request request = new Request(string, str);
            request.setIdentifier(j10);
            request.setGroupId(i10);
            for (Map.Entry entry : map.entrySet()) {
                request.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
            request.setPriority(priorityA);
            request.setNetworkType(networkTypeA);
            request.setTag(string3);
            request.setEnqueueAction(enqueueActionA);
            request.setDownloadOnEnqueue(z);
            request.setExtras(new Extras(map2));
            request.setAutoRetryMaxAttempts(i14);
            return request;
        }

        @Override // android.os.Parcelable.Creator
        public final Request[] newArray(int i10) {
            return new Request[i10];
        }
    }

    public Request(String url, String file) {
        g.f(url, "url");
        g.f(file, "file");
        this.url = url;
        this.file = file;
        this.f8187id = file.hashCode() + (url.hashCode() * 31);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tonyodev.fetch2.RequestInfo
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj != null ? obj.getClass() : null) || !super.equals(obj)) {
            return false;
        }
        g.d(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.Request");
        Request request = (Request) obj;
        return this.f8187id == request.f8187id && g.b(this.url, request.url) && g.b(this.file, request.file);
    }

    public final String getFile() {
        return this.file;
    }

    public final Uri getFileUri() {
        return b.j(this.file);
    }

    public final int getId() {
        return this.f8187id;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.tonyodev.fetch2.RequestInfo
    public int hashCode() {
        return this.file.hashCode() + d.a(((super.hashCode() * 31) + this.f8187id) * 31, 31, this.url);
    }

    @Override // com.tonyodev.fetch2.RequestInfo
    public String toString() {
        String str = this.url;
        String str2 = this.file;
        int i10 = this.f8187id;
        int groupId = getGroupId();
        Map<String, String> headers = getHeaders();
        Priority priority = getPriority();
        NetworkType networkType = getNetworkType();
        String tag = getTag();
        StringBuilder sbS = ai.onnxruntime.a.s("Request(url='", str, "', file='", str2, "', id=");
        e.l(sbS, i10, ", groupId=", groupId, ", headers=");
        sbS.append(headers);
        sbS.append(", priority=");
        sbS.append(priority);
        sbS.append(", networkType=");
        sbS.append(networkType);
        sbS.append(", tag=");
        sbS.append(tag);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.file);
        parcel.writeLong(getIdentifier());
        parcel.writeInt(getGroupId());
        parcel.writeSerializable(new HashMap(getHeaders()));
        parcel.writeInt(getPriority().f8183a);
        parcel.writeInt(getNetworkType().f8178a);
        parcel.writeString(getTag());
        parcel.writeInt(getEnqueueAction().f8152a);
        parcel.writeInt(getDownloadOnEnqueue() ? 1 : 0);
        parcel.writeSerializable(new HashMap(getExtras().getMap()));
        parcel.writeInt(getAutoRetryMaxAttempts());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Request(String url, Uri fileUri) {
        g.f(url, "url");
        g.f(fileUri, "fileUri");
        String string = fileUri.toString();
        g.e(string, "toString(...)");
        this(url, string);
    }
}
