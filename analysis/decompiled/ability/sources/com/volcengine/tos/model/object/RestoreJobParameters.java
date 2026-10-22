package com.volcengine.tos.model.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.tos.comm.common.TierType;

/* loaded from: classes3.dex */
public class RestoreJobParameters {

    @JsonProperty("Tier")
    private TierType tier;

    public static final class RestoreJobParametersBuilder {
        private TierType tier;

        public RestoreJobParameters build() {
            RestoreJobParameters restoreJobParameters = new RestoreJobParameters();
            restoreJobParameters.setTier(this.tier);
            return restoreJobParameters;
        }

        public RestoreJobParametersBuilder tier(TierType tierType) {
            this.tier = tierType;
            return this;
        }

        private RestoreJobParametersBuilder() {
        }
    }

    public static RestoreJobParametersBuilder builder() {
        return new RestoreJobParametersBuilder();
    }

    public TierType getTier() {
        return this.tier;
    }

    public RestoreJobParameters setTier(TierType tierType) {
        this.tier = tierType;
        return this;
    }

    public String toString() {
        return "RestoreJobParameters{tier='" + this.tier + "'}";
    }
}
