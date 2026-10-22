package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ListedBucket implements Serializable {

    @JsonProperty("CreationDate")
    private String creationDate;

    @JsonProperty("ExtranetEndpoint")
    private String extranetEndpoint;

    @JsonProperty("IntranetEndpoint")
    private String intranetEndpoint;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("Name")
    private String name;

    public String getCreationDate() {
        return this.creationDate;
    }

    public String getExtranetEndpoint() {
        return this.extranetEndpoint;
    }

    public String getIntranetEndpoint() {
        return this.intranetEndpoint;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public ListedBucket setCreationDate(String str) {
        this.creationDate = str;
        return this;
    }

    public ListedBucket setExtranetEndpoint(String str) {
        this.extranetEndpoint = str;
        return this;
    }

    public ListedBucket setIntranetEndpoint(String str) {
        this.intranetEndpoint = str;
        return this;
    }

    public ListedBucket setLocation(String str) {
        this.location = str;
        return this;
    }

    public ListedBucket setName(String str) {
        this.name = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListedBucket{creationDate='");
        sb.append(this.creationDate);
        sb.append("', name='");
        sb.append(this.name);
        sb.append("', location='");
        sb.append(this.location);
        sb.append("', extranetEndpoint='");
        sb.append(this.extranetEndpoint);
        sb.append("', intranetEndpoint='");
        return a.q(sb, this.intranetEndpoint, "'}");
    }
}
