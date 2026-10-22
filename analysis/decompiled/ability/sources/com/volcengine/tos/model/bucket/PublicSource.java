package com.volcengine.tos.model.bucket;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class PublicSource {

    @JsonProperty("FixedEndpoint")
    private boolean fixedEndpoint;

    @JsonProperty("SourceEndpoint")
    private SourceEndpoint sourceEndpoint;

    public static final class PublicSourceBuilder {
        private boolean fixedEndpoint;
        private SourceEndpoint sourceEndpoint;

        public PublicSource build() {
            PublicSource publicSource = new PublicSource();
            publicSource.setSourceEndpoint(this.sourceEndpoint);
            publicSource.setFixedEndpoint(this.fixedEndpoint);
            return publicSource;
        }

        public PublicSourceBuilder fixedEndpoint(boolean z10) {
            this.fixedEndpoint = z10;
            return this;
        }

        public PublicSourceBuilder sourceEndpoint(SourceEndpoint sourceEndpoint) {
            this.sourceEndpoint = sourceEndpoint;
            return this;
        }

        private PublicSourceBuilder() {
        }
    }

    public static PublicSourceBuilder builder() {
        return new PublicSourceBuilder();
    }

    public SourceEndpoint getSourceEndpoint() {
        return this.sourceEndpoint;
    }

    public boolean isFixedEndpoint() {
        return this.fixedEndpoint;
    }

    public PublicSource setFixedEndpoint(boolean z10) {
        this.fixedEndpoint = z10;
        return this;
    }

    public PublicSource setSourceEndpoint(SourceEndpoint sourceEndpoint) {
        this.sourceEndpoint = sourceEndpoint;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PublicSource{sourceEndpoint=");
        sb.append(this.sourceEndpoint);
        sb.append(", fixedEndpoint=");
        return a.r(sb, this.fixedEndpoint, '}');
    }
}
