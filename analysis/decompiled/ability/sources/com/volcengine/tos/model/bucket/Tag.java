package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class Tag {

    @JsonProperty("Key")
    private String key;

    @JsonProperty("Value")
    private String value;

    public static final class TagBuilder {
        private String key;
        private String value;

        public Tag build() {
            Tag tag = new Tag();
            tag.setKey(this.key);
            tag.setValue(this.value);
            return tag;
        }

        public TagBuilder key(String str) {
            this.key = str;
            return this;
        }

        public TagBuilder value(String str) {
            this.value = str;
            return this;
        }

        private TagBuilder() {
        }
    }

    public static TagBuilder builder() {
        return new TagBuilder();
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public Tag setKey(String str) {
        this.key = str;
        return this;
    }

    public Tag setValue(String str) {
        this.value = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Tag{key='");
        sb.append(this.key);
        sb.append("', value='");
        return a.q(sb, this.value, "'}");
    }
}
