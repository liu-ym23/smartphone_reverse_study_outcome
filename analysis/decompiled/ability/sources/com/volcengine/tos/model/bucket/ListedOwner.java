package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

@Deprecated
/* loaded from: classes3.dex */
public class ListedOwner {

    @JsonProperty("DisplayName")
    private String displayName;

    @JsonProperty("ID")
    private String id;

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public ListedOwner setDisplayName(String str) {
        this.displayName = str;
        return this;
    }

    public ListedOwner setId(String str) {
        this.id = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListedOwner{id='");
        sb.append(this.id);
        sb.append("', displayName='");
        return a.q(sb, this.displayName, "'}");
    }
}
