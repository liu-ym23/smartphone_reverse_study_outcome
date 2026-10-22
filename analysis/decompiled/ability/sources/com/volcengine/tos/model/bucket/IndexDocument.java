package com.volcengine.tos.model.bucket;

import androidx.appfunctions.metadata.a;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class IndexDocument {

    @JsonProperty("ForbiddenSubDir")
    private boolean forbiddenSubDir;

    @JsonProperty(TextFieldImplKt.SuffixId)
    private String suffix;

    public static final class IndexDocumentBuilder {
        private boolean forbiddenSubDir;
        private String suffix;

        public IndexDocument build() {
            IndexDocument indexDocument = new IndexDocument();
            indexDocument.setSuffix(this.suffix);
            indexDocument.setForbiddenSubDir(this.forbiddenSubDir);
            return indexDocument;
        }

        public IndexDocumentBuilder forbiddenSubDir(boolean z10) {
            this.forbiddenSubDir = z10;
            return this;
        }

        public IndexDocumentBuilder suffix(String str) {
            this.suffix = str;
            return this;
        }

        private IndexDocumentBuilder() {
        }
    }

    public static IndexDocumentBuilder builder() {
        return new IndexDocumentBuilder();
    }

    public String getSuffix() {
        return this.suffix;
    }

    public boolean isForbiddenSubDir() {
        return this.forbiddenSubDir;
    }

    public IndexDocument setForbiddenSubDir(boolean z10) {
        this.forbiddenSubDir = z10;
        return this;
    }

    public IndexDocument setSuffix(String str) {
        this.suffix = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IndexDocument{suffix='");
        sb.append(this.suffix);
        sb.append("', forbiddenSubDir=");
        return a.r(sb, this.forbiddenSubDir, '}');
    }
}
