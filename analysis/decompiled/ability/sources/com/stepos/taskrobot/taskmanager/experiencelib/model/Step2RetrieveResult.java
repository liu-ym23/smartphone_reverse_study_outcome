package com.stepos.taskrobot.taskmanager.experiencelib.model;

import B7.a;
import androidx.annotation.Keep;
import androidx.compose.material3.internal.TextFieldImplKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b4\b\u0087\b\u0018\u00002\u00020\u0001:\u0006CDEFGHBµ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010+J¼\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\b\u0002\u0010\u000f\u001a\u00020\f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\b\u0002\u0010\u0011\u001a\u00020\f2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\fHÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0016\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0016\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0016\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+¨\u0006I"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult;", "", "hit", "", "reason", "", "query", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$Query;", "taskCandidates", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskCandidate;", "taskCandidatesCount", "", "stepCandidatePool", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepCandidatePair;", "stepCandidatePoolCount", "actionFilteredPairs", "actionFilteredPairCandidatesCount", "pendingXmlVerifyCandidatePair", "pendingXmlVerifyCandidatePairCount", "retrievalMs", "", "artifactPrefix", "taskSimThreshold", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$Query;Ljava/util/List;ILjava/util/List;ILjava/util/List;ILjava/util/List;ILjava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)V", "getHit", "()Z", "getReason", "()Ljava/lang/String;", "getQuery", "()Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$Query;", "getTaskCandidates", "()Ljava/util/List;", "getTaskCandidatesCount", "()I", "getStepCandidatePool", "getStepCandidatePoolCount", "getActionFilteredPairs", "getActionFilteredPairCandidatesCount", "getPendingXmlVerifyCandidatePair", "getPendingXmlVerifyCandidatePairCount", "getRetrievalMs", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getArtifactPrefix", "getTaskSimThreshold", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(ZLjava/lang/String;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$Query;Ljava/util/List;ILjava/util/List;ILjava/util/List;ILjava/util/List;ILjava/lang/Double;Ljava/lang/String;Ljava/lang/Double;)Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult;", "equals", "other", "hashCode", "toString", "Query", "TaskCandidate", "TaskKey", "StepAction", "SpeculationLabel", "StepCandidatePair", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Step2RetrieveResult {

    @SerializedName("action_filtered_pair_candidates_count")
    private final int actionFilteredPairCandidatesCount;

    @SerializedName("action_filtered_pairs")
    private final List<StepCandidatePair> actionFilteredPairs;

    @SerializedName("artifact_prefix")
    private final String artifactPrefix;

    @SerializedName("hit")
    private final boolean hit;

    @SerializedName("pending_xml_verify_candidate_pair")
    private final List<StepCandidatePair> pendingXmlVerifyCandidatePair;

    @SerializedName("pending_xml_verify_candidate_pair_count")
    private final int pendingXmlVerifyCandidatePairCount;

    @SerializedName("query")
    private final Query query;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("retrieval_ms")
    private final Double retrievalMs;

    @SerializedName("step_candidate_pool")
    private final List<StepCandidatePair> stepCandidatePool;

    @SerializedName("step_candidate_pool_count")
    private final int stepCandidatePoolCount;

    @SerializedName("task_candidates")
    private final List<TaskCandidate> taskCandidates;

    @SerializedName("task_candidates_count")
    private final int taskCandidatesCount;

    @SerializedName("task_sim_threshold")
    private final Double taskSimThreshold;

    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$Query;", "", "task", "", "action1", "action1Params", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getTask", "()Ljava/lang/String;", "getAction1", "getAction1Params", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Query {

        @SerializedName("action1")
        private final String action1;

        @SerializedName("action1_params")
        private final Map<String, Object> action1Params;

        @SerializedName("task")
        private final String task;

        public Query() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Query copy$default(Query query, String str, String str2, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = query.task;
            }
            if ((i & 2) != 0) {
                str2 = query.action1;
            }
            if ((i & 4) != 0) {
                map = query.action1Params;
            }
            return query.copy(str, str2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTask() {
            return this.task;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAction1() {
            return this.action1;
        }

        public final Map<String, Object> component3() {
            return this.action1Params;
        }

        public final Query copy(String task, String action1, Map<String, ? extends Object> action1Params) {
            k.f(action1Params, "action1Params");
            return new Query(task, action1, action1Params);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Query)) {
                return false;
            }
            Query query = (Query) other;
            return k.b(this.task, query.task) && k.b(this.action1, query.action1) && k.b(this.action1Params, query.action1Params);
        }

        public final String getAction1() {
            return this.action1;
        }

        public final Map<String, Object> getAction1Params() {
            return this.action1Params;
        }

        public final String getTask() {
            return this.task;
        }

        public int hashCode() {
            String str = this.task;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.action1;
            return this.action1Params.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
        }

        public String toString() {
            String str = this.task;
            String str2 = this.action1;
            Map<String, Object> map = this.action1Params;
            StringBuilder sbW = a.w("Query(task=", str, ", action1=", str2, ", action1Params=");
            sbW.append(map);
            sbW.append(")");
            return sbW.toString();
        }

        public Query(String str, String str2, Map<String, ? extends Object> action1Params) {
            k.f(action1Params, "action1Params");
            this.task = str;
            this.action1 = str2;
            this.action1Params = action1Params;
        }

        public /* synthetic */ Query(String str, String str2, Map map, int i, e eVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? kotlin.collections.a.M() : map);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel;", "", "labels", "", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel$Label;", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "getLabels", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", TextFieldImplKt.LabelId, "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SpeculationLabel {

        @SerializedName("labels")
        private final List<Label> labels;

        @Keep
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J<\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel$Label;", "", "step", "", "isSpeculation", "", "specConfidence", "", "specReason", "", AppAgent.CONSTRUCT, "(Ljava/lang/Integer;ZLjava/lang/Double;Ljava/lang/String;)V", "getStep", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getSpecConfidence", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSpecReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;ZLjava/lang/Double;Ljava/lang/String;)Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel$Label;", "equals", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Label {

            @SerializedName("is_speculation")
            private final boolean isSpeculation;

            @SerializedName("spec_confidence")
            private final Double specConfidence;

            @SerializedName("spec_reason")
            private final String specReason;

            @SerializedName("step")
            private final Integer step;

            public Label() {
                this(null, false, null, null, 15, null);
            }

            public static /* synthetic */ Label copy$default(Label label, Integer num, boolean z10, Double d, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = label.step;
                }
                if ((i & 2) != 0) {
                    z10 = label.isSpeculation;
                }
                if ((i & 4) != 0) {
                    d = label.specConfidence;
                }
                if ((i & 8) != 0) {
                    str = label.specReason;
                }
                return label.copy(num, z10, d, str);
            }

            /* renamed from: component1, reason: from getter */
            public final Integer getStep() {
                return this.step;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsSpeculation() {
                return this.isSpeculation;
            }

            /* renamed from: component3, reason: from getter */
            public final Double getSpecConfidence() {
                return this.specConfidence;
            }

            /* renamed from: component4, reason: from getter */
            public final String getSpecReason() {
                return this.specReason;
            }

            public final Label copy(Integer step, boolean isSpeculation, Double specConfidence, String specReason) {
                return new Label(step, isSpeculation, specConfidence, specReason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Label)) {
                    return false;
                }
                Label label = (Label) other;
                return k.b(this.step, label.step) && this.isSpeculation == label.isSpeculation && k.b(this.specConfidence, label.specConfidence) && k.b(this.specReason, label.specReason);
            }

            public final Double getSpecConfidence() {
                return this.specConfidence;
            }

            public final String getSpecReason() {
                return this.specReason;
            }

            public final Integer getStep() {
                return this.step;
            }

            public int hashCode() {
                Integer num = this.step;
                int iD = androidx.appfunctions.metadata.a.d((num == null ? 0 : num.hashCode()) * 31, 31, this.isSpeculation);
                Double d = this.specConfidence;
                int iHashCode = (iD + (d == null ? 0 : d.hashCode())) * 31;
                String str = this.specReason;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public final boolean isSpeculation() {
                return this.isSpeculation;
            }

            public String toString() {
                return "Label(step=" + this.step + ", isSpeculation=" + this.isSpeculation + ", specConfidence=" + this.specConfidence + ", specReason=" + this.specReason + ")";
            }

            public Label(Integer num, boolean z10, Double d, String str) {
                this.step = num;
                this.isSpeculation = z10;
                this.specConfidence = d;
                this.specReason = str;
            }

            public /* synthetic */ Label(Integer num, boolean z10, Double d, String str, int i, e eVar) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? false : z10, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : str);
            }
        }

        public SpeculationLabel() {
            this(null, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SpeculationLabel copy$default(SpeculationLabel speculationLabel, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = speculationLabel.labels;
            }
            return speculationLabel.copy(list);
        }

        public final List<Label> component1() {
            return this.labels;
        }

        public final SpeculationLabel copy(List<Label> labels) {
            k.f(labels, "labels");
            return new SpeculationLabel(labels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SpeculationLabel) && k.b(this.labels, ((SpeculationLabel) other).labels);
        }

        public final List<Label> getLabels() {
            return this.labels;
        }

        public int hashCode() {
            return this.labels.hashCode();
        }

        public String toString() {
            return "SpeculationLabel(labels=" + this.labels + ")";
        }

        public SpeculationLabel(List list, int i, e eVar) {
            this((i & 1) != 0 ? EmptyList.f4893a : list);
        }

        public SpeculationLabel(List<Label> labels) {
            k.f(labels, "labels");
            this.labels = labels;
        }
    }

    @Keep
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003Jn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0005HÖ\u0001J\t\u0010*\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;", "", "taskKey", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;", "stepIndex", "", "explain", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "summary", "actionParams", "", "speculationLabel", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel;", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel;)V", "getTaskKey", "()Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;", "getStepIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExplain", "()Ljava/lang/String;", "getAction", "getSummary", "getActionParams", "()Ljava/util/Map;", "getSpeculationLabel", "()Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$SpeculationLabel;)Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;", "equals", "", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StepAction {

        @SerializedName(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION)
        private final String action;

        @SerializedName("action_params")
        private final Map<String, Object> actionParams;

        @SerializedName("explain")
        private final String explain;

        @SerializedName("speculation_label")
        private final SpeculationLabel speculationLabel;

        @SerializedName("step_index")
        private final Integer stepIndex;

        @SerializedName("summary")
        private final String summary;

        @SerializedName("task_key")
        private final TaskKey taskKey;

        public StepAction() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ StepAction copy$default(StepAction stepAction, TaskKey taskKey, Integer num, String str, String str2, String str3, Map map, SpeculationLabel speculationLabel, int i, Object obj) {
            if ((i & 1) != 0) {
                taskKey = stepAction.taskKey;
            }
            if ((i & 2) != 0) {
                num = stepAction.stepIndex;
            }
            if ((i & 4) != 0) {
                str = stepAction.explain;
            }
            if ((i & 8) != 0) {
                str2 = stepAction.action;
            }
            if ((i & 16) != 0) {
                str3 = stepAction.summary;
            }
            if ((i & 32) != 0) {
                map = stepAction.actionParams;
            }
            if ((i & 64) != 0) {
                speculationLabel = stepAction.speculationLabel;
            }
            Map map2 = map;
            SpeculationLabel speculationLabel2 = speculationLabel;
            String str4 = str3;
            String str5 = str;
            return stepAction.copy(taskKey, num, str5, str2, str4, map2, speculationLabel2);
        }

        /* renamed from: component1, reason: from getter */
        public final TaskKey getTaskKey() {
            return this.taskKey;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getStepIndex() {
            return this.stepIndex;
        }

        /* renamed from: component3, reason: from getter */
        public final String getExplain() {
            return this.explain;
        }

        /* renamed from: component4, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        public final Map<String, Object> component6() {
            return this.actionParams;
        }

        /* renamed from: component7, reason: from getter */
        public final SpeculationLabel getSpeculationLabel() {
            return this.speculationLabel;
        }

        public final StepAction copy(TaskKey taskKey, Integer stepIndex, String explain, String action, String summary, Map<String, ? extends Object> actionParams, SpeculationLabel speculationLabel) {
            k.f(actionParams, "actionParams");
            return new StepAction(taskKey, stepIndex, explain, action, summary, actionParams, speculationLabel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepAction)) {
                return false;
            }
            StepAction stepAction = (StepAction) other;
            return k.b(this.taskKey, stepAction.taskKey) && k.b(this.stepIndex, stepAction.stepIndex) && k.b(this.explain, stepAction.explain) && k.b(this.action, stepAction.action) && k.b(this.summary, stepAction.summary) && k.b(this.actionParams, stepAction.actionParams) && k.b(this.speculationLabel, stepAction.speculationLabel);
        }

        public final String getAction() {
            return this.action;
        }

        public final Map<String, Object> getActionParams() {
            return this.actionParams;
        }

        public final String getExplain() {
            return this.explain;
        }

        public final SpeculationLabel getSpeculationLabel() {
            return this.speculationLabel;
        }

        public final Integer getStepIndex() {
            return this.stepIndex;
        }

        public final String getSummary() {
            return this.summary;
        }

        public final TaskKey getTaskKey() {
            return this.taskKey;
        }

        public int hashCode() {
            TaskKey taskKey = this.taskKey;
            int iHashCode = (taskKey == null ? 0 : taskKey.hashCode()) * 31;
            Integer num = this.stepIndex;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.explain;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.action;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.summary;
            int iF = androidx.appfunctions.metadata.a.f(this.actionParams, (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31, 31);
            SpeculationLabel speculationLabel = this.speculationLabel;
            return iF + (speculationLabel != null ? speculationLabel.hashCode() : 0);
        }

        public String toString() {
            TaskKey taskKey = this.taskKey;
            Integer num = this.stepIndex;
            String str = this.explain;
            String str2 = this.action;
            String str3 = this.summary;
            Map<String, Object> map = this.actionParams;
            SpeculationLabel speculationLabel = this.speculationLabel;
            StringBuilder sb = new StringBuilder("StepAction(taskKey=");
            sb.append(taskKey);
            sb.append(", stepIndex=");
            sb.append(num);
            sb.append(", explain=");
            androidx.constraintlayout.core.dsl.a.A(sb, str, ", action=", str2, ", summary=");
            sb.append(str3);
            sb.append(", actionParams=");
            sb.append(map);
            sb.append(", speculationLabel=");
            sb.append(speculationLabel);
            sb.append(")");
            return sb.toString();
        }

        public StepAction(TaskKey taskKey, Integer num, String str, String str2, String str3, Map<String, ? extends Object> actionParams, SpeculationLabel speculationLabel) {
            k.f(actionParams, "actionParams");
            this.taskKey = taskKey;
            this.stepIndex = num;
            this.explain = str;
            this.action = str2;
            this.summary = str3;
            this.actionParams = actionParams;
            this.speculationLabel = speculationLabel;
        }

        public /* synthetic */ StepAction(TaskKey taskKey, Integer num, String str, String str2, String str3, Map map, SpeculationLabel speculationLabel, int i, e eVar) {
            this((i & 1) != 0 ? null : taskKey, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? kotlin.collections.a.M() : map, (i & 64) != 0 ? null : speculationLabel);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B§\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010&\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\bHÆ\u0003J\u001d\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\bHÆ\u0003J\u001d\u0010(\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010+\u001a\u00020\u0011HÆ\u0003J®\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\nHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R*\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u000b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR*\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\"¨\u00063"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepCandidatePair;", "", "taskKey", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;", "matchedStep", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;", "nextStep", "nextStepUiXmlInfos", "", "", "", "observedUiXmlInfos", "expectedUiXmlInfos", "matchReason", "matchDistance", "", "isSpeculate", "", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Double;Z)V", "getTaskKey", "()Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;", "getMatchedStep", "()Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;", "getNextStep", "getNextStepUiXmlInfos", "()Ljava/util/List;", "getObservedUiXmlInfos", "getExpectedUiXmlInfos", "getMatchReason", "()Ljava/lang/String;", "getMatchDistance", "()Ljava/lang/Double;", "Ljava/lang/Double;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepAction;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Double;Z)Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$StepCandidatePair;", "equals", "other", "hashCode", "", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class StepCandidatePair {

        @SerializedName("expected_ui_xml_infos")
        private final List<Map<String, Object>> expectedUiXmlInfos;

        @SerializedName("is_speculate")
        private final boolean isSpeculate;

        @SerializedName("match_distance")
        private final Double matchDistance;

        @SerializedName("match_reason")
        private final String matchReason;

        @SerializedName("matched_step")
        private final StepAction matchedStep;

        @SerializedName("next_step")
        private final StepAction nextStep;

        @SerializedName("next_step_ui_xml_infos")
        private final List<Map<String, Object>> nextStepUiXmlInfos;

        @SerializedName("observed_ui_xml_infos")
        private final List<Map<String, Object>> observedUiXmlInfos;

        @SerializedName("task_key")
        private final TaskKey taskKey;

        public StepCandidatePair() {
            this(null, null, null, null, null, null, null, null, false, 511, null);
        }

        public static /* synthetic */ StepCandidatePair copy$default(StepCandidatePair stepCandidatePair, TaskKey taskKey, StepAction stepAction, StepAction stepAction2, List list, List list2, List list3, String str, Double d, boolean z10, int i, Object obj) {
            if ((i & 1) != 0) {
                taskKey = stepCandidatePair.taskKey;
            }
            if ((i & 2) != 0) {
                stepAction = stepCandidatePair.matchedStep;
            }
            if ((i & 4) != 0) {
                stepAction2 = stepCandidatePair.nextStep;
            }
            if ((i & 8) != 0) {
                list = stepCandidatePair.nextStepUiXmlInfos;
            }
            if ((i & 16) != 0) {
                list2 = stepCandidatePair.observedUiXmlInfos;
            }
            if ((i & 32) != 0) {
                list3 = stepCandidatePair.expectedUiXmlInfos;
            }
            if ((i & 64) != 0) {
                str = stepCandidatePair.matchReason;
            }
            if ((i & 128) != 0) {
                d = stepCandidatePair.matchDistance;
            }
            if ((i & 256) != 0) {
                z10 = stepCandidatePair.isSpeculate;
            }
            Double d6 = d;
            boolean z11 = z10;
            List list4 = list3;
            String str2 = str;
            List list5 = list2;
            StepAction stepAction3 = stepAction2;
            return stepCandidatePair.copy(taskKey, stepAction, stepAction3, list, list5, list4, str2, d6, z11);
        }

        /* renamed from: component1, reason: from getter */
        public final TaskKey getTaskKey() {
            return this.taskKey;
        }

        /* renamed from: component2, reason: from getter */
        public final StepAction getMatchedStep() {
            return this.matchedStep;
        }

        /* renamed from: component3, reason: from getter */
        public final StepAction getNextStep() {
            return this.nextStep;
        }

        public final List<Map<String, Object>> component4() {
            return this.nextStepUiXmlInfos;
        }

        public final List<Map<String, Object>> component5() {
            return this.observedUiXmlInfos;
        }

        public final List<Map<String, Object>> component6() {
            return this.expectedUiXmlInfos;
        }

        /* renamed from: component7, reason: from getter */
        public final String getMatchReason() {
            return this.matchReason;
        }

        /* renamed from: component8, reason: from getter */
        public final Double getMatchDistance() {
            return this.matchDistance;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsSpeculate() {
            return this.isSpeculate;
        }

        public final StepCandidatePair copy(TaskKey taskKey, StepAction matchedStep, StepAction nextStep, List<? extends Map<String, ? extends Object>> nextStepUiXmlInfos, List<? extends Map<String, ? extends Object>> observedUiXmlInfos, List<? extends Map<String, ? extends Object>> expectedUiXmlInfos, String matchReason, Double matchDistance, boolean isSpeculate) {
            k.f(nextStepUiXmlInfos, "nextStepUiXmlInfos");
            k.f(observedUiXmlInfos, "observedUiXmlInfos");
            k.f(expectedUiXmlInfos, "expectedUiXmlInfos");
            return new StepCandidatePair(taskKey, matchedStep, nextStep, nextStepUiXmlInfos, observedUiXmlInfos, expectedUiXmlInfos, matchReason, matchDistance, isSpeculate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepCandidatePair)) {
                return false;
            }
            StepCandidatePair stepCandidatePair = (StepCandidatePair) other;
            return k.b(this.taskKey, stepCandidatePair.taskKey) && k.b(this.matchedStep, stepCandidatePair.matchedStep) && k.b(this.nextStep, stepCandidatePair.nextStep) && k.b(this.nextStepUiXmlInfos, stepCandidatePair.nextStepUiXmlInfos) && k.b(this.observedUiXmlInfos, stepCandidatePair.observedUiXmlInfos) && k.b(this.expectedUiXmlInfos, stepCandidatePair.expectedUiXmlInfos) && k.b(this.matchReason, stepCandidatePair.matchReason) && k.b(this.matchDistance, stepCandidatePair.matchDistance) && this.isSpeculate == stepCandidatePair.isSpeculate;
        }

        public final List<Map<String, Object>> getExpectedUiXmlInfos() {
            return this.expectedUiXmlInfos;
        }

        public final Double getMatchDistance() {
            return this.matchDistance;
        }

        public final String getMatchReason() {
            return this.matchReason;
        }

        public final StepAction getMatchedStep() {
            return this.matchedStep;
        }

        public final StepAction getNextStep() {
            return this.nextStep;
        }

        public final List<Map<String, Object>> getNextStepUiXmlInfos() {
            return this.nextStepUiXmlInfos;
        }

        public final List<Map<String, Object>> getObservedUiXmlInfos() {
            return this.observedUiXmlInfos;
        }

        public final TaskKey getTaskKey() {
            return this.taskKey;
        }

        public int hashCode() {
            TaskKey taskKey = this.taskKey;
            int iHashCode = (taskKey == null ? 0 : taskKey.hashCode()) * 31;
            StepAction stepAction = this.matchedStep;
            int iHashCode2 = (iHashCode + (stepAction == null ? 0 : stepAction.hashCode())) * 31;
            StepAction stepAction2 = this.nextStep;
            int iE = androidx.appfunctions.metadata.a.e(this.expectedUiXmlInfos, androidx.appfunctions.metadata.a.e(this.observedUiXmlInfos, androidx.appfunctions.metadata.a.e(this.nextStepUiXmlInfos, (iHashCode2 + (stepAction2 == null ? 0 : stepAction2.hashCode())) * 31, 31), 31), 31);
            String str = this.matchReason;
            int iHashCode3 = (iE + (str == null ? 0 : str.hashCode())) * 31;
            Double d = this.matchDistance;
            return Boolean.hashCode(this.isSpeculate) + ((iHashCode3 + (d != null ? d.hashCode() : 0)) * 31);
        }

        public final boolean isSpeculate() {
            return this.isSpeculate;
        }

        public String toString() {
            TaskKey taskKey = this.taskKey;
            StepAction stepAction = this.matchedStep;
            StepAction stepAction2 = this.nextStep;
            List<Map<String, Object>> list = this.nextStepUiXmlInfos;
            List<Map<String, Object>> list2 = this.observedUiXmlInfos;
            List<Map<String, Object>> list3 = this.expectedUiXmlInfos;
            String str = this.matchReason;
            Double d = this.matchDistance;
            boolean z10 = this.isSpeculate;
            StringBuilder sb = new StringBuilder("StepCandidatePair(taskKey=");
            sb.append(taskKey);
            sb.append(", matchedStep=");
            sb.append(stepAction);
            sb.append(", nextStep=");
            sb.append(stepAction2);
            sb.append(", nextStepUiXmlInfos=");
            sb.append(list);
            sb.append(", observedUiXmlInfos=");
            sb.append(list2);
            sb.append(", expectedUiXmlInfos=");
            sb.append(list3);
            sb.append(", matchReason=");
            sb.append(str);
            sb.append(", matchDistance=");
            sb.append(d);
            sb.append(", isSpeculate=");
            return a.s(sb, z10, ")");
        }

        public StepCandidatePair(TaskKey taskKey, StepAction stepAction, StepAction stepAction2, List list, List list2, List list3, String str, Double d, boolean z10, int i, e eVar) {
            this((i & 1) != 0 ? null : taskKey, (i & 2) != 0 ? null : stepAction, (i & 4) != 0 ? null : stepAction2, (i & 8) != 0 ? EmptyList.f4893a : list, (i & 16) != 0 ? EmptyList.f4893a : list2, (i & 32) != 0 ? EmptyList.f4893a : list3, (i & 64) != 0 ? null : str, (i & 128) != 0 ? null : d, (i & 256) != 0 ? false : z10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StepCandidatePair(TaskKey taskKey, StepAction stepAction, StepAction stepAction2, List<? extends Map<String, ? extends Object>> nextStepUiXmlInfos, List<? extends Map<String, ? extends Object>> observedUiXmlInfos, List<? extends Map<String, ? extends Object>> expectedUiXmlInfos, String str, Double d, boolean z10) {
            k.f(nextStepUiXmlInfos, "nextStepUiXmlInfos");
            k.f(observedUiXmlInfos, "observedUiXmlInfos");
            k.f(expectedUiXmlInfos, "expectedUiXmlInfos");
            this.taskKey = taskKey;
            this.matchedStep = stepAction;
            this.nextStep = stepAction2;
            this.nextStepUiXmlInfos = nextStepUiXmlInfos;
            this.observedUiXmlInfos = observedUiXmlInfos;
            this.expectedUiXmlInfos = expectedUiXmlInfos;
            this.matchReason = str;
            this.matchDistance = d;
            this.isSpeculate = z10;
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006("}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskCandidate;", "", "trajectoryIdx", "", "task", "", "taskSim", "", "idIndex", "taskIndex", "sessionId", "app", AppAgent.CONSTRUCT, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getTrajectoryIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTask", "()Ljava/lang/String;", "getTaskSim", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getIdIndex", "getTaskIndex", "getSessionId", "getApp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskCandidate;", "equals", "", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskCandidate {

        @SerializedName("app")
        private final String app;

        @SerializedName("id_index")
        private final Integer idIndex;

        @SerializedName("session_id")
        private final String sessionId;

        @SerializedName("task")
        private final String task;

        @SerializedName("task_index")
        private final Integer taskIndex;

        @SerializedName("task_sim")
        private final Double taskSim;

        @SerializedName("trajectory_idx")
        private final Integer trajectoryIdx;

        public TaskCandidate() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ TaskCandidate copy$default(TaskCandidate taskCandidate, Integer num, String str, Double d, Integer num2, Integer num3, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                num = taskCandidate.trajectoryIdx;
            }
            if ((i & 2) != 0) {
                str = taskCandidate.task;
            }
            if ((i & 4) != 0) {
                d = taskCandidate.taskSim;
            }
            if ((i & 8) != 0) {
                num2 = taskCandidate.idIndex;
            }
            if ((i & 16) != 0) {
                num3 = taskCandidate.taskIndex;
            }
            if ((i & 32) != 0) {
                str2 = taskCandidate.sessionId;
            }
            if ((i & 64) != 0) {
                str3 = taskCandidate.app;
            }
            String str4 = str2;
            String str5 = str3;
            Integer num4 = num3;
            Double d6 = d;
            return taskCandidate.copy(num, str, d6, num2, num4, str4, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getTrajectoryIdx() {
            return this.trajectoryIdx;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTask() {
            return this.task;
        }

        /* renamed from: component3, reason: from getter */
        public final Double getTaskSim() {
            return this.taskSim;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getIdIndex() {
            return this.idIndex;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getTaskIndex() {
            return this.taskIndex;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component7, reason: from getter */
        public final String getApp() {
            return this.app;
        }

        public final TaskCandidate copy(Integer trajectoryIdx, String task, Double taskSim, Integer idIndex, Integer taskIndex, String sessionId, String app) {
            return new TaskCandidate(trajectoryIdx, task, taskSim, idIndex, taskIndex, sessionId, app);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskCandidate)) {
                return false;
            }
            TaskCandidate taskCandidate = (TaskCandidate) other;
            return k.b(this.trajectoryIdx, taskCandidate.trajectoryIdx) && k.b(this.task, taskCandidate.task) && k.b(this.taskSim, taskCandidate.taskSim) && k.b(this.idIndex, taskCandidate.idIndex) && k.b(this.taskIndex, taskCandidate.taskIndex) && k.b(this.sessionId, taskCandidate.sessionId) && k.b(this.app, taskCandidate.app);
        }

        public final String getApp() {
            return this.app;
        }

        public final Integer getIdIndex() {
            return this.idIndex;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getTask() {
            return this.task;
        }

        public final Integer getTaskIndex() {
            return this.taskIndex;
        }

        public final Double getTaskSim() {
            return this.taskSim;
        }

        public final Integer getTrajectoryIdx() {
            return this.trajectoryIdx;
        }

        public int hashCode() {
            Integer num = this.trajectoryIdx;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.task;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Double d = this.taskSim;
            int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
            Integer num2 = this.idIndex;
            int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.taskIndex;
            int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str2 = this.sessionId;
            int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.app;
            return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            Integer num = this.trajectoryIdx;
            String str = this.task;
            Double d = this.taskSim;
            Integer num2 = this.idIndex;
            Integer num3 = this.taskIndex;
            String str2 = this.sessionId;
            String str3 = this.app;
            StringBuilder sb = new StringBuilder("TaskCandidate(trajectoryIdx=");
            sb.append(num);
            sb.append(", task=");
            sb.append(str);
            sb.append(", taskSim=");
            sb.append(d);
            sb.append(", idIndex=");
            sb.append(num2);
            sb.append(", taskIndex=");
            sb.append(num3);
            sb.append(", sessionId=");
            sb.append(str2);
            sb.append(", app=");
            return a.q(sb, str3, ")");
        }

        public TaskCandidate(Integer num, String str, Double d, Integer num2, Integer num3, String str2, String str3) {
            this.trajectoryIdx = num;
            this.task = str;
            this.taskSim = d;
            this.idIndex = num2;
            this.taskIndex = num3;
            this.sessionId = str2;
            this.app = str3;
        }

        public /* synthetic */ TaskCandidate(Integer num, String str, Double d, Integer num2, Integer num3, String str2, String str3, int i, e eVar) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;", "", "sessionId", "", "idIndex", "", "taskIndex", "task", "app", "taskSim", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getSessionId", "()Ljava/lang/String;", "getIdIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTaskIndex", "getTask", "getApp", "getTaskSim", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveResult$TaskKey;", "equals", "", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskKey {

        @SerializedName("app")
        private final String app;

        @SerializedName("id_index")
        private final Integer idIndex;

        @SerializedName("session_id")
        private final String sessionId;

        @SerializedName("task")
        private final String task;

        @SerializedName("task_index")
        private final Integer taskIndex;

        @SerializedName("task_sim")
        private final Double taskSim;

        public TaskKey() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ TaskKey copy$default(TaskKey taskKey, String str, Integer num, Integer num2, String str2, String str3, Double d, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taskKey.sessionId;
            }
            if ((i & 2) != 0) {
                num = taskKey.idIndex;
            }
            if ((i & 4) != 0) {
                num2 = taskKey.taskIndex;
            }
            if ((i & 8) != 0) {
                str2 = taskKey.task;
            }
            if ((i & 16) != 0) {
                str3 = taskKey.app;
            }
            if ((i & 32) != 0) {
                d = taskKey.taskSim;
            }
            String str4 = str3;
            Double d6 = d;
            return taskKey.copy(str, num, num2, str2, str4, d6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getIdIndex() {
            return this.idIndex;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getTaskIndex() {
            return this.taskIndex;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTask() {
            return this.task;
        }

        /* renamed from: component5, reason: from getter */
        public final String getApp() {
            return this.app;
        }

        /* renamed from: component6, reason: from getter */
        public final Double getTaskSim() {
            return this.taskSim;
        }

        public final TaskKey copy(String sessionId, Integer idIndex, Integer taskIndex, String task, String app, Double taskSim) {
            return new TaskKey(sessionId, idIndex, taskIndex, task, app, taskSim);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskKey)) {
                return false;
            }
            TaskKey taskKey = (TaskKey) other;
            return k.b(this.sessionId, taskKey.sessionId) && k.b(this.idIndex, taskKey.idIndex) && k.b(this.taskIndex, taskKey.taskIndex) && k.b(this.task, taskKey.task) && k.b(this.app, taskKey.app) && k.b(this.taskSim, taskKey.taskSim);
        }

        public final String getApp() {
            return this.app;
        }

        public final Integer getIdIndex() {
            return this.idIndex;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getTask() {
            return this.task;
        }

        public final Integer getTaskIndex() {
            return this.taskIndex;
        }

        public final Double getTaskSim() {
            return this.taskSim;
        }

        public int hashCode() {
            String str = this.sessionId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.idIndex;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.taskIndex;
            int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str2 = this.task;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.app;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Double d = this.taskSim;
            return iHashCode5 + (d != null ? d.hashCode() : 0);
        }

        public String toString() {
            return "TaskKey(sessionId=" + this.sessionId + ", idIndex=" + this.idIndex + ", taskIndex=" + this.taskIndex + ", task=" + this.task + ", app=" + this.app + ", taskSim=" + this.taskSim + ")";
        }

        public TaskKey(String str, Integer num, Integer num2, String str2, String str3, Double d) {
            this.sessionId = str;
            this.idIndex = num;
            this.taskIndex = num2;
            this.task = str2;
            this.app = str3;
            this.taskSim = d;
        }

        public /* synthetic */ TaskKey(String str, Integer num, Integer num2, String str2, String str3, Double d, int i, e eVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : d);
        }
    }

    public Step2RetrieveResult() {
        this(false, null, null, null, 0, null, 0, null, 0, null, 0, null, null, null, 16383, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getHit() {
        return this.hit;
    }

    public final List<StepCandidatePair> component10() {
        return this.pendingXmlVerifyCandidatePair;
    }

    /* renamed from: component11, reason: from getter */
    public final int getPendingXmlVerifyCandidatePairCount() {
        return this.pendingXmlVerifyCandidatePairCount;
    }

    /* renamed from: component12, reason: from getter */
    public final Double getRetrievalMs() {
        return this.retrievalMs;
    }

    /* renamed from: component13, reason: from getter */
    public final String getArtifactPrefix() {
        return this.artifactPrefix;
    }

    /* renamed from: component14, reason: from getter */
    public final Double getTaskSimThreshold() {
        return this.taskSimThreshold;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final Query getQuery() {
        return this.query;
    }

    public final List<TaskCandidate> component4() {
        return this.taskCandidates;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTaskCandidatesCount() {
        return this.taskCandidatesCount;
    }

    public final List<StepCandidatePair> component6() {
        return this.stepCandidatePool;
    }

    /* renamed from: component7, reason: from getter */
    public final int getStepCandidatePoolCount() {
        return this.stepCandidatePoolCount;
    }

    public final List<StepCandidatePair> component8() {
        return this.actionFilteredPairs;
    }

    /* renamed from: component9, reason: from getter */
    public final int getActionFilteredPairCandidatesCount() {
        return this.actionFilteredPairCandidatesCount;
    }

    public final Step2RetrieveResult copy(boolean hit, String reason, Query query, List<TaskCandidate> taskCandidates, int taskCandidatesCount, List<StepCandidatePair> stepCandidatePool, int stepCandidatePoolCount, List<StepCandidatePair> actionFilteredPairs, int actionFilteredPairCandidatesCount, List<StepCandidatePair> pendingXmlVerifyCandidatePair, int pendingXmlVerifyCandidatePairCount, Double retrievalMs, String artifactPrefix, Double taskSimThreshold) {
        k.f(taskCandidates, "taskCandidates");
        k.f(stepCandidatePool, "stepCandidatePool");
        k.f(actionFilteredPairs, "actionFilteredPairs");
        k.f(pendingXmlVerifyCandidatePair, "pendingXmlVerifyCandidatePair");
        return new Step2RetrieveResult(hit, reason, query, taskCandidates, taskCandidatesCount, stepCandidatePool, stepCandidatePoolCount, actionFilteredPairs, actionFilteredPairCandidatesCount, pendingXmlVerifyCandidatePair, pendingXmlVerifyCandidatePairCount, retrievalMs, artifactPrefix, taskSimThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Step2RetrieveResult)) {
            return false;
        }
        Step2RetrieveResult step2RetrieveResult = (Step2RetrieveResult) other;
        return this.hit == step2RetrieveResult.hit && k.b(this.reason, step2RetrieveResult.reason) && k.b(this.query, step2RetrieveResult.query) && k.b(this.taskCandidates, step2RetrieveResult.taskCandidates) && this.taskCandidatesCount == step2RetrieveResult.taskCandidatesCount && k.b(this.stepCandidatePool, step2RetrieveResult.stepCandidatePool) && this.stepCandidatePoolCount == step2RetrieveResult.stepCandidatePoolCount && k.b(this.actionFilteredPairs, step2RetrieveResult.actionFilteredPairs) && this.actionFilteredPairCandidatesCount == step2RetrieveResult.actionFilteredPairCandidatesCount && k.b(this.pendingXmlVerifyCandidatePair, step2RetrieveResult.pendingXmlVerifyCandidatePair) && this.pendingXmlVerifyCandidatePairCount == step2RetrieveResult.pendingXmlVerifyCandidatePairCount && k.b(this.retrievalMs, step2RetrieveResult.retrievalMs) && k.b(this.artifactPrefix, step2RetrieveResult.artifactPrefix) && k.b(this.taskSimThreshold, step2RetrieveResult.taskSimThreshold);
    }

    public final int getActionFilteredPairCandidatesCount() {
        return this.actionFilteredPairCandidatesCount;
    }

    public final List<StepCandidatePair> getActionFilteredPairs() {
        return this.actionFilteredPairs;
    }

    public final String getArtifactPrefix() {
        return this.artifactPrefix;
    }

    public final boolean getHit() {
        return this.hit;
    }

    public final List<StepCandidatePair> getPendingXmlVerifyCandidatePair() {
        return this.pendingXmlVerifyCandidatePair;
    }

    public final int getPendingXmlVerifyCandidatePairCount() {
        return this.pendingXmlVerifyCandidatePairCount;
    }

    public final Query getQuery() {
        return this.query;
    }

    public final String getReason() {
        return this.reason;
    }

    public final Double getRetrievalMs() {
        return this.retrievalMs;
    }

    public final List<StepCandidatePair> getStepCandidatePool() {
        return this.stepCandidatePool;
    }

    public final int getStepCandidatePoolCount() {
        return this.stepCandidatePoolCount;
    }

    public final List<TaskCandidate> getTaskCandidates() {
        return this.taskCandidates;
    }

    public final int getTaskCandidatesCount() {
        return this.taskCandidatesCount;
    }

    public final Double getTaskSimThreshold() {
        return this.taskSimThreshold;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.hit) * 31;
        String str = this.reason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Query query = this.query;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.pendingXmlVerifyCandidatePairCount, androidx.appfunctions.metadata.a.e(this.pendingXmlVerifyCandidatePair, androidx.constraintlayout.core.dsl.a.a(this.actionFilteredPairCandidatesCount, androidx.appfunctions.metadata.a.e(this.actionFilteredPairs, androidx.constraintlayout.core.dsl.a.a(this.stepCandidatePoolCount, androidx.appfunctions.metadata.a.e(this.stepCandidatePool, androidx.constraintlayout.core.dsl.a.a(this.taskCandidatesCount, androidx.appfunctions.metadata.a.e(this.taskCandidates, (iHashCode2 + (query == null ? 0 : query.hashCode())) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
        Double d = this.retrievalMs;
        int iHashCode3 = (iA + (d == null ? 0 : d.hashCode())) * 31;
        String str2 = this.artifactPrefix;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d6 = this.taskSimThreshold;
        return iHashCode4 + (d6 != null ? d6.hashCode() : 0);
    }

    public String toString() {
        return "Step2RetrieveResult(hit=" + this.hit + ", reason=" + this.reason + ", query=" + this.query + ", taskCandidates=" + this.taskCandidates + ", taskCandidatesCount=" + this.taskCandidatesCount + ", stepCandidatePool=" + this.stepCandidatePool + ", stepCandidatePoolCount=" + this.stepCandidatePoolCount + ", actionFilteredPairs=" + this.actionFilteredPairs + ", actionFilteredPairCandidatesCount=" + this.actionFilteredPairCandidatesCount + ", pendingXmlVerifyCandidatePair=" + this.pendingXmlVerifyCandidatePair + ", pendingXmlVerifyCandidatePairCount=" + this.pendingXmlVerifyCandidatePairCount + ", retrievalMs=" + this.retrievalMs + ", artifactPrefix=" + this.artifactPrefix + ", taskSimThreshold=" + this.taskSimThreshold + ")";
    }

    public Step2RetrieveResult(boolean z10, String str, Query query, List<TaskCandidate> taskCandidates, int i, List<StepCandidatePair> stepCandidatePool, int i6, List<StepCandidatePair> actionFilteredPairs, int i10, List<StepCandidatePair> pendingXmlVerifyCandidatePair, int i11, Double d, String str2, Double d6) {
        k.f(taskCandidates, "taskCandidates");
        k.f(stepCandidatePool, "stepCandidatePool");
        k.f(actionFilteredPairs, "actionFilteredPairs");
        k.f(pendingXmlVerifyCandidatePair, "pendingXmlVerifyCandidatePair");
        this.hit = z10;
        this.reason = str;
        this.query = query;
        this.taskCandidates = taskCandidates;
        this.taskCandidatesCount = i;
        this.stepCandidatePool = stepCandidatePool;
        this.stepCandidatePoolCount = i6;
        this.actionFilteredPairs = actionFilteredPairs;
        this.actionFilteredPairCandidatesCount = i10;
        this.pendingXmlVerifyCandidatePair = pendingXmlVerifyCandidatePair;
        this.pendingXmlVerifyCandidatePairCount = i11;
        this.retrievalMs = d;
        this.artifactPrefix = str2;
        this.taskSimThreshold = d6;
    }

    public Step2RetrieveResult(boolean z10, String str, Query query, List list, int i, List list2, int i6, List list3, int i10, List list4, int i11, Double d, String str2, Double d6, int i12, e eVar) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : query, (i12 & 8) != 0 ? EmptyList.f4893a : list, (i12 & 16) != 0 ? 0 : i, (i12 & 32) != 0 ? EmptyList.f4893a : list2, (i12 & 64) != 0 ? 0 : i6, (i12 & 128) != 0 ? EmptyList.f4893a : list3, (i12 & 256) != 0 ? 0 : i10, (i12 & 512) != 0 ? EmptyList.f4893a : list4, (i12 & 1024) == 0 ? i11 : 0, (i12 & 2048) != 0 ? null : d, (i12 & 4096) != 0 ? null : str2, (i12 & 8192) != 0 ? null : d6);
    }
}
