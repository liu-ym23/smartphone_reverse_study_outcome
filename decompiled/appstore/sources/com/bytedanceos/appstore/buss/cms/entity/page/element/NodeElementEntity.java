package com.bytedanceos.appstore.buss.cms.entity.page.element;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NodeElementEntity implements Parcelable {
    public static final Parcelable.Creator<NodeElementEntity> CREATOR = null;
    private List<NodeElementEntity> children;
    private String image;
    private String name;
    private String node_identity;
    private String url;

    public class a implements Parcelable.Creator {
        public a() {
        }

        public NodeElementEntity a(Parcel r10) {
            return new NodeElementEntity(r10);
        }

        public NodeElementEntity[] b(int r10) {
            return new NodeElementEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public NodeElementEntity() {
        this.image = "";
        this.name = "";
        this.url = "";
        this.node_identity = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<NodeElementEntity> getChildren() {
        return this.children;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public String getNode_identity() {
        return this.node_identity;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.image);
        r10.writeString(this.name);
        r10.writeString(this.url);
        r10.writeString(this.node_identity);
        r10.writeTypedList(this.children);
    }

    public NodeElementEntity(Parcel r10) {
        this.image = "";
        this.name = "";
        this.url = "";
        this.node_identity = "";
        this.image = r10.readString();
        this.name = r10.readString();
        this.url = r10.readString();
        this.node_identity = r10.readString();
        this.children = r10.createTypedArrayList(CREATOR);
    }
}
