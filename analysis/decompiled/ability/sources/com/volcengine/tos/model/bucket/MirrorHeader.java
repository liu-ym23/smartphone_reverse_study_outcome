package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* loaded from: classes3.dex */
public class MirrorHeader {

    @JsonProperty("Pass")
    private List<String> pass;

    @JsonProperty("PassAll")
    private boolean passAll;

    @JsonProperty("Remove")
    private List<String> remove;

    public static final class MirrorHeaderBuilder {
        private List<String> pass;
        private boolean passAll;
        private List<String> remove;

        public MirrorHeader build() {
            MirrorHeader mirrorHeader = new MirrorHeader();
            mirrorHeader.setPassAll(this.passAll);
            mirrorHeader.setPass(this.pass);
            mirrorHeader.setRemove(this.remove);
            return mirrorHeader;
        }

        public MirrorHeaderBuilder pass(List<String> list) {
            this.pass = list;
            return this;
        }

        public MirrorHeaderBuilder passAll(boolean z10) {
            this.passAll = z10;
            return this;
        }

        public MirrorHeaderBuilder remove(List<String> list) {
            this.remove = list;
            return this;
        }

        private MirrorHeaderBuilder() {
        }
    }

    public static MirrorHeaderBuilder builder() {
        return new MirrorHeaderBuilder();
    }

    public List<String> getPass() {
        return this.pass;
    }

    public List<String> getRemove() {
        return this.remove;
    }

    public boolean isPassAll() {
        return this.passAll;
    }

    public MirrorHeader setPass(List<String> list) {
        this.pass = list;
        return this;
    }

    public MirrorHeader setPassAll(boolean z10) {
        this.passAll = z10;
        return this;
    }

    public MirrorHeader setRemove(List<String> list) {
        this.remove = list;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MirrorHeader{passAll=");
        sb.append(this.passAll);
        sb.append(", pass=");
        sb.append(this.pass);
        sb.append(", remove=");
        return a.r(sb, this.remove, '}');
    }
}
