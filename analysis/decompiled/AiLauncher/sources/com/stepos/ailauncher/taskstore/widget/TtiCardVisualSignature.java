package com.stepos.ailauncher.taskstore.widget;

import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoProgress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b#\b\u0080\b\u0018\u0000 12\u00020\u0001:\u00012B\u0089\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b!\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\"\u0010\u0017R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b&\u0010%R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b)\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b*\u0010\u0017R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b+\u0010\u0019R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0012\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b/\u0010.R\u0017\u0010\u0013\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b0\u0010.¨\u00063"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/y0;", "", "", "taskId", "versionId", "status", "title", "subTitle", "", "resultKeys", "signedKeys", "", "progressCompleted", "progressTotal", "pendingToolCallKey", "expectedImageCount", "", "generationInFlight", "generatingStalled", "standalone", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;IILjava/lang/String;IZZZ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getVersionId", "getStatus", "getTitle", "getSubTitle", "Ljava/util/List;", "getResultKeys", "()Ljava/util/List;", "getSignedKeys", "I", "getProgressCompleted", "getProgressTotal", "getPendingToolCallKey", "getExpectedImageCount", "Z", "getGenerationInFlight", "()Z", "getGeneratingStalled", "getStandalone", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.widget.y0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TtiCardVisualSignature {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int expectedImageCount;
    private final boolean generatingStalled;
    private final boolean generationInFlight;
    private final String pendingToolCallKey;
    private final int progressCompleted;
    private final int progressTotal;
    private final List<String> resultKeys;
    private final List<String> signedKeys;
    private final boolean standalone;
    private final String status;
    private final String subTitle;
    private final String taskId;
    private final String title;
    private final String versionId;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Je\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/y0$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "imageParts", "", "", "signedUrls", "", "pendingToolCallIds", "", "expectedImageCount", "", "generationInFlight", "generatingStalled", "standalone", "Lcom/stepos/ailauncher/taskstore/widget/y0;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/List;Ljava/util/Map;Ljava/util/Collection;IZZZ)Lcom/stepos/ailauncher/taskstore/widget/y0;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.widget.y0$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TtiCardVisualSignature a(TaskInfoCard card, List<TaskInfoPart> imageParts, Map<String, String> signedUrls, Collection<String> pendingToolCallIds, int expectedImageCount, boolean generationInFlight, boolean generatingStalled, boolean standalone) {
            kotlin.jvm.internal.p.i(card, "card");
            kotlin.jvm.internal.p.i(imageParts, "imageParts");
            kotlin.jvm.internal.p.i(signedUrls, "signedUrls");
            kotlin.jvm.internal.p.i(pendingToolCallIds, "pendingToolCallIds");
            TaskInfoProgress progress = card.getProgress();
            String taskId = card.getTaskId();
            String versionId = card.getVersionId();
            String strName = card.getStatus().name();
            String title = card.getTitle();
            String subTitle = card.getSubTitle();
            List<TaskInfoPart> list = imageParts;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (TaskInfoPart taskInfoPart : list) {
                String partId = taskInfoPart.getPartId();
                String str = partId == null ? "" : partId;
                String fileId = taskInfoPart.getFileId();
                String str2 = fileId == null ? "" : fileId;
                String content = taskInfoPart.getContent();
                String status = taskInfoPart.getStatus();
                String str3 = status == null ? "" : status;
                String errorReason = taskInfoPart.getErrorReason();
                String str4 = errorReason == null ? "" : errorReason;
                String errorDetail = taskInfoPart.getErrorDetail();
                arrayList.add(Z8.F.A0(C1173v.p(str, str2, content, str3, str4, errorDetail == null ? "" : errorDetail), "|", null, null, 0, null, null, 62, null));
            }
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String fileId2 = ((TaskInfoPart) it.next()).getFileId();
                if (fileId2 == null) {
                    fileId2 = "";
                }
                String str5 = signedUrls.get(fileId2);
                if (str5 == null) {
                    str5 = "";
                }
                arrayList2.add(fileId2 + "=" + str5);
            }
            return new TtiCardVisualSignature(taskId, versionId, strName, title, subTitle, arrayList, arrayList2, progress != null ? progress.getCompleted() : 0, progress != null ? progress.getTotal() : 0, Z8.F.A0(pendingToolCallIds, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null), expectedImageCount, generationInFlight, generatingStalled, standalone);
        }

        public Companion() {
        }
    }

    public TtiCardVisualSignature(String taskId, String str, String status, String str2, String str3, List<String> resultKeys, List<String> signedKeys, int i10, int i11, String pendingToolCallKey, int i12, boolean z10, boolean z11, boolean z12) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(resultKeys, "resultKeys");
        kotlin.jvm.internal.p.i(signedKeys, "signedKeys");
        kotlin.jvm.internal.p.i(pendingToolCallKey, "pendingToolCallKey");
        this.taskId = taskId;
        this.versionId = str;
        this.status = status;
        this.title = str2;
        this.subTitle = str3;
        this.resultKeys = resultKeys;
        this.signedKeys = signedKeys;
        this.progressCompleted = i10;
        this.progressTotal = i11;
        this.pendingToolCallKey = pendingToolCallKey;
        this.expectedImageCount = i12;
        this.generationInFlight = z10;
        this.generatingStalled = z11;
        this.standalone = z12;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TtiCardVisualSignature)) {
            return false;
        }
        TtiCardVisualSignature ttiCardVisualSignature = (TtiCardVisualSignature) other;
        return kotlin.jvm.internal.p.d(this.taskId, ttiCardVisualSignature.taskId) && kotlin.jvm.internal.p.d(this.versionId, ttiCardVisualSignature.versionId) && kotlin.jvm.internal.p.d(this.status, ttiCardVisualSignature.status) && kotlin.jvm.internal.p.d(this.title, ttiCardVisualSignature.title) && kotlin.jvm.internal.p.d(this.subTitle, ttiCardVisualSignature.subTitle) && kotlin.jvm.internal.p.d(this.resultKeys, ttiCardVisualSignature.resultKeys) && kotlin.jvm.internal.p.d(this.signedKeys, ttiCardVisualSignature.signedKeys) && this.progressCompleted == ttiCardVisualSignature.progressCompleted && this.progressTotal == ttiCardVisualSignature.progressTotal && kotlin.jvm.internal.p.d(this.pendingToolCallKey, ttiCardVisualSignature.pendingToolCallKey) && this.expectedImageCount == ttiCardVisualSignature.expectedImageCount && this.generationInFlight == ttiCardVisualSignature.generationInFlight && this.generatingStalled == ttiCardVisualSignature.generatingStalled && this.standalone == ttiCardVisualSignature.standalone;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.versionId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.status.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subTitle;
        return ((((((((((((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.resultKeys.hashCode()) * 31) + this.signedKeys.hashCode()) * 31) + Integer.hashCode(this.progressCompleted)) * 31) + Integer.hashCode(this.progressTotal)) * 31) + this.pendingToolCallKey.hashCode()) * 31) + Integer.hashCode(this.expectedImageCount)) * 31) + Boolean.hashCode(this.generationInFlight)) * 31) + Boolean.hashCode(this.generatingStalled)) * 31) + Boolean.hashCode(this.standalone);
    }

    public String toString() {
        return "TtiCardVisualSignature(taskId=" + this.taskId + ", versionId=" + this.versionId + ", status=" + this.status + ", title=" + this.title + ", subTitle=" + this.subTitle + ", resultKeys=" + this.resultKeys + ", signedKeys=" + this.signedKeys + ", progressCompleted=" + this.progressCompleted + ", progressTotal=" + this.progressTotal + ", pendingToolCallKey=" + this.pendingToolCallKey + ", expectedImageCount=" + this.expectedImageCount + ", generationInFlight=" + this.generationInFlight + ", generatingStalled=" + this.generatingStalled + ", standalone=" + this.standalone + ")";
    }
}
