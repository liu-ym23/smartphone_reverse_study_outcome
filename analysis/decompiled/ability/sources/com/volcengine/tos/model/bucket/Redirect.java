package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.RedirectType;

/* loaded from: classes3.dex */
public class Redirect {

    @JsonProperty("FetchSourceOnRedirect")
    private boolean fetchSourceOnRedirect;

    @JsonProperty("FollowRedirect")
    private boolean followRedirect;

    @JsonProperty("MirrorHeader")
    private MirrorHeader mirrorHeader;

    @JsonProperty("PassQuery")
    private boolean passQuery;

    @JsonProperty("PublicSource")
    private PublicSource publicSource;

    @JsonProperty("RedirectType")
    private RedirectType redirectType;

    @JsonProperty("Transform")
    private Transform transform;

    public static final class RedirectBuilder {
        private boolean fetchSourceOnRedirect;
        private boolean followRedirect;
        private MirrorHeader mirrorHeader;
        private boolean passQuery;
        private PublicSource publicSource;
        private RedirectType redirectType;
        private Transform transform;

        public Redirect build() {
            Redirect redirect = new Redirect();
            redirect.setRedirectType(this.redirectType);
            redirect.setFetchSourceOnRedirect(this.fetchSourceOnRedirect);
            redirect.setPassQuery(this.passQuery);
            redirect.setFollowRedirect(this.followRedirect);
            redirect.setMirrorHeader(this.mirrorHeader);
            redirect.setPublicSource(this.publicSource);
            redirect.setTransform(this.transform);
            return redirect;
        }

        public RedirectBuilder fetchSourceOnRedirect(boolean z10) {
            this.fetchSourceOnRedirect = z10;
            return this;
        }

        public RedirectBuilder followRedirect(boolean z10) {
            this.followRedirect = z10;
            return this;
        }

        public RedirectBuilder mirrorHeader(MirrorHeader mirrorHeader) {
            this.mirrorHeader = mirrorHeader;
            return this;
        }

        public RedirectBuilder passQuery(boolean z10) {
            this.passQuery = z10;
            return this;
        }

        public RedirectBuilder publicSource(PublicSource publicSource) {
            this.publicSource = publicSource;
            return this;
        }

        public RedirectBuilder redirectType(RedirectType redirectType) {
            this.redirectType = redirectType;
            return this;
        }

        public RedirectBuilder transform(Transform transform) {
            this.transform = transform;
            return this;
        }

        private RedirectBuilder() {
        }
    }

    public static RedirectBuilder builder() {
        return new RedirectBuilder();
    }

    public MirrorHeader getMirrorHeader() {
        return this.mirrorHeader;
    }

    public PublicSource getPublicSource() {
        return this.publicSource;
    }

    public RedirectType getRedirectType() {
        return this.redirectType;
    }

    public Transform getTransform() {
        return this.transform;
    }

    public boolean isFetchSourceOnRedirect() {
        return this.fetchSourceOnRedirect;
    }

    public boolean isFollowRedirect() {
        return this.followRedirect;
    }

    public boolean isPassQuery() {
        return this.passQuery;
    }

    public Redirect setFetchSourceOnRedirect(boolean z10) {
        this.fetchSourceOnRedirect = z10;
        return this;
    }

    public Redirect setFollowRedirect(boolean z10) {
        this.followRedirect = z10;
        return this;
    }

    public Redirect setMirrorHeader(MirrorHeader mirrorHeader) {
        this.mirrorHeader = mirrorHeader;
        return this;
    }

    public Redirect setPassQuery(boolean z10) {
        this.passQuery = z10;
        return this;
    }

    public Redirect setPublicSource(PublicSource publicSource) {
        this.publicSource = publicSource;
        return this;
    }

    public Redirect setRedirectType(RedirectType redirectType) {
        this.redirectType = redirectType;
        return this;
    }

    public Redirect setTransform(Transform transform) {
        this.transform = transform;
        return this;
    }

    public String toString() {
        return "Redirect{redirectType=" + this.redirectType + ", fetchSourceOnRedirect=" + this.fetchSourceOnRedirect + ", passQuery=" + this.passQuery + ", followRedirect=" + this.followRedirect + ", mirrorHeader=" + this.mirrorHeader + ", publicSource=" + this.publicSource + ", transform=" + this.transform + '}';
    }
}
