package com.volcengine.tos.model.bucket;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.StatusType;
import java.util.List;

/* loaded from: classes3.dex */
public class LifecycleRule {

    @JsonProperty("AbortIncompleteMultipartUpload")
    private AbortInCompleteMultipartUpload abortInCompleteMultipartUpload;

    @JsonProperty("Expiration")
    private Expiration expiration;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("NoncurrentVersionExpiration")
    private NoncurrentVersionExpiration noncurrentVersionExpiration;

    @JsonProperty("NoncurrentVersionTransitions")
    private List<NoncurrentVersionTransition> noncurrentVersionTransitions;

    @JsonProperty(TextFieldImplKt.PrefixId)
    private String prefix;

    @JsonProperty("Status")
    private StatusType status;

    @JsonProperty("Tags")
    private List<Tag> tags;

    @JsonProperty(TypedValues.TransitionType.NAME)
    private List<Transition> transitions;

    public static final class LifecycleRuleBuilder {
        private AbortInCompleteMultipartUpload abortInCompleteMultipartUpload;
        private Expiration expiration;
        private String id;
        private NoncurrentVersionExpiration noncurrentVersionExpiration;
        private List<NoncurrentVersionTransition> noncurrentVersionTransitions;
        private String prefix;
        private StatusType status;
        private List<Tag> tags;
        private List<Transition> transitions;

        public LifecycleRuleBuilder abortInCompleteMultipartUpload(AbortInCompleteMultipartUpload abortInCompleteMultipartUpload) {
            this.abortInCompleteMultipartUpload = abortInCompleteMultipartUpload;
            return this;
        }

        public LifecycleRule build() {
            LifecycleRule lifecycleRule = new LifecycleRule();
            lifecycleRule.setId(this.id);
            lifecycleRule.setPrefix(this.prefix);
            lifecycleRule.setStatus(this.status);
            lifecycleRule.setTransitions(this.transitions);
            lifecycleRule.setExpiration(this.expiration);
            lifecycleRule.setNoncurrentVersionTransitions(this.noncurrentVersionTransitions);
            lifecycleRule.setNoncurrentVersionExpiration(this.noncurrentVersionExpiration);
            lifecycleRule.setTags(this.tags);
            lifecycleRule.setAbortInCompleteMultipartUpload(this.abortInCompleteMultipartUpload);
            return lifecycleRule;
        }

        public LifecycleRuleBuilder expiration(Expiration expiration) {
            this.expiration = expiration;
            return this;
        }

        public LifecycleRuleBuilder id(String str) {
            this.id = str;
            return this;
        }

        public LifecycleRuleBuilder noncurrentVersionExpiration(NoncurrentVersionExpiration noncurrentVersionExpiration) {
            this.noncurrentVersionExpiration = noncurrentVersionExpiration;
            return this;
        }

        public LifecycleRuleBuilder noncurrentVersionTransitions(List<NoncurrentVersionTransition> list) {
            this.noncurrentVersionTransitions = list;
            return this;
        }

        public LifecycleRuleBuilder prefix(String str) {
            this.prefix = str;
            return this;
        }

        public LifecycleRuleBuilder status(StatusType statusType) {
            this.status = statusType;
            return this;
        }

        public LifecycleRuleBuilder tags(List<Tag> list) {
            this.tags = list;
            return this;
        }

        public LifecycleRuleBuilder transitions(List<Transition> list) {
            this.transitions = list;
            return this;
        }

        private LifecycleRuleBuilder() {
        }
    }

    public static LifecycleRuleBuilder builder() {
        return new LifecycleRuleBuilder();
    }

    public AbortInCompleteMultipartUpload getAbortInCompleteMultipartUpload() {
        return this.abortInCompleteMultipartUpload;
    }

    public Expiration getExpiration() {
        return this.expiration;
    }

    public String getId() {
        return this.id;
    }

    public NoncurrentVersionExpiration getNoncurrentVersionExpiration() {
        return this.noncurrentVersionExpiration;
    }

    public List<NoncurrentVersionTransition> getNoncurrentVersionTransitions() {
        return this.noncurrentVersionTransitions;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public StatusType getStatus() {
        return this.status;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public List<Transition> getTransitions() {
        return this.transitions;
    }

    public LifecycleRule setAbortInCompleteMultipartUpload(AbortInCompleteMultipartUpload abortInCompleteMultipartUpload) {
        this.abortInCompleteMultipartUpload = abortInCompleteMultipartUpload;
        return this;
    }

    public LifecycleRule setExpiration(Expiration expiration) {
        this.expiration = expiration;
        return this;
    }

    public LifecycleRule setId(String str) {
        this.id = str;
        return this;
    }

    public LifecycleRule setNoncurrentVersionExpiration(NoncurrentVersionExpiration noncurrentVersionExpiration) {
        this.noncurrentVersionExpiration = noncurrentVersionExpiration;
        return this;
    }

    public LifecycleRule setNoncurrentVersionTransitions(List<NoncurrentVersionTransition> list) {
        this.noncurrentVersionTransitions = list;
        return this;
    }

    public LifecycleRule setPrefix(String str) {
        this.prefix = str;
        return this;
    }

    public LifecycleRule setStatus(StatusType statusType) {
        this.status = statusType;
        return this;
    }

    public LifecycleRule setTags(List<Tag> list) {
        this.tags = list;
        return this;
    }

    public LifecycleRule setTransitions(List<Transition> list) {
        this.transitions = list;
        return this;
    }

    public String toString() {
        return "LifecycleRule{id='" + this.id + "', prefix='" + this.prefix + "', status=" + this.status + ", transitions=" + this.transitions + ", expiration=" + this.expiration + ", noncurrentVersionTransitions=" + this.noncurrentVersionTransitions + ", noncurrentVersionExpiration=" + this.noncurrentVersionExpiration + ", tags=" + this.tags + ", abortInCompleteMultipartUpload=" + this.abortInCompleteMultipartUpload + '}';
    }
}
