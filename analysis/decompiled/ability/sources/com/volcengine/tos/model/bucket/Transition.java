package com.volcengine.tos.model.bucket;

import Y6.d;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.volcengine.tos.comm.common.StorageClassType;
import java.util.Date;

/* loaded from: classes3.dex */
public class Transition {

    @JsonProperty("Date")
    @JsonSerialize(using = d.class)
    private Date date;

    @JsonProperty("Days")
    private int days;

    @JsonProperty("StorageClass")
    private StorageClassType storageClass;

    public static final class TransitionBuilder {
        private Date date;
        private int days;
        private StorageClassType storageClass;

        public Transition build() {
            Transition transition = new Transition();
            transition.setDate(this.date);
            transition.setDays(this.days);
            transition.setStorageClass(this.storageClass);
            return transition;
        }

        public TransitionBuilder date(Date date) {
            this.date = date;
            return this;
        }

        public TransitionBuilder days(int i) {
            this.days = i;
            return this;
        }

        public TransitionBuilder storageClass(StorageClassType storageClassType) {
            this.storageClass = storageClassType;
            return this;
        }

        private TransitionBuilder() {
        }
    }

    public static TransitionBuilder builder() {
        return new TransitionBuilder();
    }

    public Date getDate() {
        return this.date;
    }

    public int getDays() {
        return this.days;
    }

    public StorageClassType getStorageClass() {
        return this.storageClass;
    }

    public Transition setDate(Date date) {
        this.date = date;
        return this;
    }

    public Transition setDays(int i) {
        this.days = i;
        return this;
    }

    public Transition setStorageClass(StorageClassType storageClassType) {
        this.storageClass = storageClassType;
        return this;
    }

    public String toString() {
        return "Transition{date=" + this.date + ", days=" + this.days + ", storageClass=" + this.storageClass + '}';
    }
}
