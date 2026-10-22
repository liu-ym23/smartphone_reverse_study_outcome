package com.volcengine.tos.model.bucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.StatusType;
import java.util.List;

/* loaded from: classes3.dex */
public class ReplicationRule {

    @JsonProperty("Destination")
    private Destination destination;

    @JsonProperty("HistoricalObjectReplication")
    private StatusType historicalObjectReplication;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("PrefixSet")
    private List<String> prefixSet;

    @JsonProperty("Progress")
    private Progress progress;

    @JsonProperty("Status")
    private StatusType status;

    public static final class ReplicationRuleBuilder {
        private Destination destination;
        private StatusType historicalObjectReplication;
        private String id;
        private List<String> prefixSet;
        private Progress progress;
        private StatusType status;

        public ReplicationRule build() {
            ReplicationRule replicationRule = new ReplicationRule();
            replicationRule.setId(this.id);
            replicationRule.setStatus(this.status);
            replicationRule.setPrefixSet(this.prefixSet);
            replicationRule.setDestination(this.destination);
            replicationRule.setHistoricalObjectReplication(this.historicalObjectReplication);
            replicationRule.setProgress(this.progress);
            return replicationRule;
        }

        public ReplicationRuleBuilder destination(Destination destination) {
            this.destination = destination;
            return this;
        }

        public ReplicationRuleBuilder historicalObjectReplication(StatusType statusType) {
            this.historicalObjectReplication = statusType;
            return this;
        }

        public ReplicationRuleBuilder id(String str) {
            this.id = str;
            return this;
        }

        public ReplicationRuleBuilder prefixSet(List<String> list) {
            this.prefixSet = list;
            return this;
        }

        public ReplicationRuleBuilder progress(Progress progress) {
            this.progress = progress;
            return this;
        }

        public ReplicationRuleBuilder status(StatusType statusType) {
            this.status = statusType;
            return this;
        }

        private ReplicationRuleBuilder() {
        }
    }

    public static ReplicationRuleBuilder builder() {
        return new ReplicationRuleBuilder();
    }

    public Destination getDestination() {
        return this.destination;
    }

    public StatusType getHistoricalObjectReplication() {
        return this.historicalObjectReplication;
    }

    public String getId() {
        return this.id;
    }

    public List<String> getPrefixSet() {
        return this.prefixSet;
    }

    public Progress getProgress() {
        return this.progress;
    }

    public StatusType getStatus() {
        return this.status;
    }

    public ReplicationRule setDestination(Destination destination) {
        this.destination = destination;
        return this;
    }

    public ReplicationRule setHistoricalObjectReplication(StatusType statusType) {
        this.historicalObjectReplication = statusType;
        return this;
    }

    public ReplicationRule setId(String str) {
        this.id = str;
        return this;
    }

    public ReplicationRule setPrefixSet(List<String> list) {
        this.prefixSet = list;
        return this;
    }

    public ReplicationRule setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }

    public ReplicationRule setStatus(StatusType statusType) {
        this.status = statusType;
        return this;
    }

    public String toString() {
        return "ReplicationRule{id='" + this.id + "', status=" + this.status + ", prefixSet=" + this.prefixSet + ", destination=" + this.destination + ", historicalObjectReplication=" + this.historicalObjectReplication + ", progress=" + this.progress + '}';
    }
}
