package com.volcengine.tos.model.acl;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class Grantee {

    @JsonProperty("DisplayName")
    private String displayName;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Canned")
    private String uri;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getUri() {
        return this.uri;
    }

    public Grantee setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public Grantee setId(String str) {
        this.id = str;
        return this;
    }

    public Grantee setType(String str) {
        this.type = str;
        return this;
    }

    public Grantee setUri(String str) {
        this.uri = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Grantee{id='");
        sb.append(this.id);
        sb.append("', displayName='");
        sb.append(this.displayName);
        sb.append("', type='");
        sb.append(this.type);
        sb.append("', uri='");
        return a.q(sb, this.uri, "'}");
    }
}
