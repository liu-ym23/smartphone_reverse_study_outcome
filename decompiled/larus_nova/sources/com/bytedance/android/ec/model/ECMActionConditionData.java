package com.bytedance.android.ec.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR,\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/model/ECMActionConditionData;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/model/ECMActionConditionData$a;", "ruleDataList", "Ljava/util/List;", "getRuleDataList", "()Ljava/util/List;", "setRuleDataList", "(Ljava/util/List;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECMActionConditionData implements Serializable {

    @SerializedName("action_tracker_condition")
    private List<a> ruleDataList;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/ECMActionConditionData$a;", "", "", "action", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "", "life", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setLife", "(Ljava/lang/Integer;)V", "", "Lcom/bytedance/android/ec/model/ECMActionConditionData$a$a;", "rules", "Ljava/util/List;", "c", "()Ljava/util/List;", "isAutoTrigger", "d", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("action")
        private String action;

        @SerializedName("is_auto_trigger")
        private final Integer isAutoTrigger;

        @SerializedName("life")
        private Integer life;

        @SerializedName("rules")
        private final List<C0834a> rules;

        /* JADX INFO: renamed from: com.bytedance.android.ec.model.ECMActionConditionData$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/ECMActionConditionData$a$a;", "", "", "condition", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setCondition", "(I)V", "", ControlRule.KEY_RULE_ID, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setRuleId", "(Ljava/lang/String;)V", "", "isCycle", "Z", "d", "()Z", "setCycle", "(Z)V", "probability", "b", "setProbability", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
        public static final class C0834a {

            @SerializedName("condition")
            private int condition;

            @SerializedName("is_cycle")
            private boolean isCycle;

            @SerializedName("probability")
            private int probability;

            @SerializedName("rule_id")
            private String ruleId;

            public C0834a() {
                this.probability = 100;
            }

            public final int a() {
                return this.condition;
            }

            public final int b() {
                return this.probability;
            }

            public final String c() {
                return this.ruleId;
            }

            public final boolean d() {
                return this.isCycle;
            }
        }

        public a() {
        }

        public final String a() {
            return this.action;
        }

        public final Integer b() {
            return this.life;
        }

        public final List<C0834a> c() {
            return this.rules;
        }

        public final Integer d() {
            return this.isAutoTrigger;
        }
    }

    public ECMActionConditionData() {
    }

    public final List<a> getRuleDataList() {
        return this.ruleDataList;
    }

    public final void setRuleDataList(List<a> r100) {
        this.ruleDataList = r100;
    }
}
