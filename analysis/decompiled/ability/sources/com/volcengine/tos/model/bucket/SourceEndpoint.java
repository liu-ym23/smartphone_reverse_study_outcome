package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class SourceEndpoint {

    @JsonProperty("Follower")
    private List<String> follower;

    @JsonProperty("Primary")
    private List<String> primary;

    public static final class SourceEndpointBuilder {
        private List<String> follower;
        private List<String> primary;

        public SourceEndpoint build() {
            SourceEndpoint sourceEndpoint = new SourceEndpoint();
            sourceEndpoint.setPrimary(this.primary);
            sourceEndpoint.setFollower(this.follower);
            return sourceEndpoint;
        }

        public SourceEndpointBuilder follower(List<String> list) {
            this.follower = list;
            return this;
        }

        public SourceEndpointBuilder primary(List<String> list) {
            this.primary = list;
            return this;
        }

        private SourceEndpointBuilder() {
        }
    }

    public static SourceEndpointBuilder builder() {
        return new SourceEndpointBuilder();
    }

    public List<String> getFollower() {
        return this.follower;
    }

    public List<String> getPrimary() {
        return this.primary;
    }

    public SourceEndpoint setFollower(List<String> list) {
        this.follower = list;
        return this;
    }

    public SourceEndpoint setPrimary(List<String> list) {
        this.primary = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SourceEndpoint{primary=");
        sb.append(this.primary);
        sb.append(", follower=");
        return a.r(sb, this.follower, '}');
    }
}
