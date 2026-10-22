package com.volcengine.tos.model.object;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.model.bucket.Tag;
import java.util.List;

/* loaded from: classes3.dex */
public class TagSet {

    @JsonProperty("Tags")
    private List<Tag> tags;

    public static final class TagSetBuilder {
        private List<Tag> tags;

        public TagSet build() {
            TagSet tagSet = new TagSet();
            tagSet.setTags(this.tags);
            return tagSet;
        }

        public TagSetBuilder tags(List<Tag> list) {
            this.tags = list;
            return this;
        }

        private TagSetBuilder() {
        }
    }

    public static TagSetBuilder builder() {
        return new TagSetBuilder();
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public TagSet setTags(List<Tag> list) {
        this.tags = list;
        return this;
    }

    public String toString() {
        return a.r(new StringBuilder("TagSet{tags="), this.tags, '}');
    }
}
