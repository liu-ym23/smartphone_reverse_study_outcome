package com.stepos.taskrobot.taskmanager.experiencelib.model;

import androidx.annotation.Keep;
import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010+\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u008f\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R*\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Action;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "explain", "value", "id", "", "point", "", "reusable", "", "summary", "actionSource", "regionXmlInfo", "", "speculationLabel", "Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SpeculationLabel;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SpeculationLabel;)V", "getAction", "()Ljava/lang/String;", "getExplain", "getValue", "getId", "()I", "getPoint", "()Ljava/util/List;", "getReusable", "()Z", "getSummary", "getActionSource", "getRegionXmlInfo", "getSpeculationLabel", "()Lcom/stepos/taskrobot/taskmanager/experiencelib/model/SpeculationLabel;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Action {

    @SerializedName(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION)
    private final String action;

    @SerializedName("actionsource")
    private final String actionSource;

    @SerializedName("explain")
    private final String explain;

    @SerializedName("id")
    private final int id;

    @SerializedName("point")
    private final List<Integer> point;

    @SerializedName("clickregionxmlinfo")
    private final List<Map<String, Object>> regionXmlInfo;

    @SerializedName("reusable")
    private final boolean reusable;

    @SerializedName("speculation_label")
    private final SpeculationLabel speculationLabel;

    @SerializedName("summary")
    private final String summary;

    @SerializedName("value")
    private final String value;

    /* JADX WARN: Multi-variable type inference failed */
    public Action(String action, String str, String value, int i, List<Integer> point, boolean z10, String str2, String str3, List<? extends Map<String, ? extends Object>> list, SpeculationLabel speculationLabel) {
        k.f(action, "action");
        k.f(value, "value");
        k.f(point, "point");
        this.action = action;
        this.explain = str;
        this.value = value;
        this.id = i;
        this.point = point;
        this.reusable = z10;
        this.summary = str2;
        this.actionSource = str3;
        this.regionXmlInfo = list;
        this.speculationLabel = speculationLabel;
    }

    public static /* synthetic */ Action copy$default(Action action, String str, String str2, String str3, int i, List list, boolean z10, String str4, String str5, List list2, SpeculationLabel speculationLabel, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = action.action;
        }
        if ((i6 & 2) != 0) {
            str2 = action.explain;
        }
        if ((i6 & 4) != 0) {
            str3 = action.value;
        }
        if ((i6 & 8) != 0) {
            i = action.id;
        }
        if ((i6 & 16) != 0) {
            list = action.point;
        }
        if ((i6 & 32) != 0) {
            z10 = action.reusable;
        }
        if ((i6 & 64) != 0) {
            str4 = action.summary;
        }
        if ((i6 & 128) != 0) {
            str5 = action.actionSource;
        }
        if ((i6 & 256) != 0) {
            list2 = action.regionXmlInfo;
        }
        if ((i6 & 512) != 0) {
            speculationLabel = action.speculationLabel;
        }
        List list3 = list2;
        SpeculationLabel speculationLabel2 = speculationLabel;
        String str6 = str4;
        String str7 = str5;
        List list4 = list;
        boolean z11 = z10;
        return action.copy(str, str2, str3, i, list4, z11, str6, str7, list3, speculationLabel2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component10, reason: from getter */
    public final SpeculationLabel getSpeculationLabel() {
        return this.speculationLabel;
    }

    /* renamed from: component2, reason: from getter */
    public final String getExplain() {
        return this.explain;
    }

    /* renamed from: component3, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component4, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<Integer> component5() {
        return this.point;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getReusable() {
        return this.reusable;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: component8, reason: from getter */
    public final String getActionSource() {
        return this.actionSource;
    }

    public final List<Map<String, Object>> component9() {
        return this.regionXmlInfo;
    }

    public final Action copy(String action, String explain, String value, int id, List<Integer> point, boolean reusable, String summary, String actionSource, List<? extends Map<String, ? extends Object>> regionXmlInfo, SpeculationLabel speculationLabel) {
        k.f(action, "action");
        k.f(value, "value");
        k.f(point, "point");
        return new Action(action, explain, value, id, point, reusable, summary, actionSource, regionXmlInfo, speculationLabel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Action)) {
            return false;
        }
        Action action = (Action) other;
        return k.b(this.action, action.action) && k.b(this.explain, action.explain) && k.b(this.value, action.value) && this.id == action.id && k.b(this.point, action.point) && this.reusable == action.reusable && k.b(this.summary, action.summary) && k.b(this.actionSource, action.actionSource) && k.b(this.regionXmlInfo, action.regionXmlInfo) && k.b(this.speculationLabel, action.speculationLabel);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getActionSource() {
        return this.actionSource;
    }

    public final String getExplain() {
        return this.explain;
    }

    public final int getId() {
        return this.id;
    }

    public final List<Integer> getPoint() {
        return this.point;
    }

    public final List<Map<String, Object>> getRegionXmlInfo() {
        return this.regionXmlInfo;
    }

    public final boolean getReusable() {
        return this.reusable;
    }

    public final SpeculationLabel getSpeculationLabel() {
        return this.speculationLabel;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = this.action.hashCode() * 31;
        String str = this.explain;
        int iD = a.d(a.e(this.point, androidx.constraintlayout.core.dsl.a.a(this.id, B7.a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.value), 31), 31), 31, this.reusable);
        String str2 = this.summary;
        int iHashCode2 = (iD + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.actionSource;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Map<String, Object>> list = this.regionXmlInfo;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        SpeculationLabel speculationLabel = this.speculationLabel;
        return iHashCode4 + (speculationLabel != null ? speculationLabel.hashCode() : 0);
    }

    public String toString() {
        String str = this.action;
        String str2 = this.explain;
        String str3 = this.value;
        int i = this.id;
        List<Integer> list = this.point;
        boolean z10 = this.reusable;
        String str4 = this.summary;
        String str5 = this.actionSource;
        List<Map<String, Object>> list2 = this.regionXmlInfo;
        SpeculationLabel speculationLabel = this.speculationLabel;
        StringBuilder sbW = B7.a.w("Action(action=", str, ", explain=", str2, ", value=");
        b.B(sbW, str3, ", id=", i, ", point=");
        sbW.append(list);
        sbW.append(", reusable=");
        sbW.append(z10);
        sbW.append(", summary=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str4, ", actionSource=", str5, ", regionXmlInfo=");
        sbW.append(list2);
        sbW.append(", speculationLabel=");
        sbW.append(speculationLabel);
        sbW.append(")");
        return sbW.toString();
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Action(java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, java.util.List r18, boolean r19, java.lang.String r20, java.lang.String r21, java.util.List r22, com.stepos.taskrobot.taskmanager.experiencelib.model.SpeculationLabel r23, int r24, kotlin.jvm.internal.e r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 32
            if (r1 == 0) goto L9
            r1 = 1
            r8 = r1
            goto Lb
        L9:
            r8 = r19
        Lb:
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L12
            r11 = r2
            goto L14
        L12:
            r11 = r22
        L14:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L27
            r12 = r2
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r9 = r20
            r10 = r21
            r2 = r13
            goto L36
        L27:
            r12 = r23
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r9 = r20
            r10 = r21
        L36:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.taskmanager.experiencelib.model.Action.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.util.List, boolean, java.lang.String, java.lang.String, java.util.List, com.stepos.taskrobot.taskmanager.experiencelib.model.SpeculationLabel, int, kotlin.jvm.internal.e):void");
    }
}
