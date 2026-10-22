package com.stepos.ailauncher.taskstore.artifact;

import La.H;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.database.TaskInfoConverters;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPartType;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001a\u0015,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJX\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010!\u001a\u00020 2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b!\u0010\"J#\u0010&\u001a\u00020%2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger;", "", "<init>", "()V", "", "resultJson", "Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$b;", "taskId", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "parts", "sessionId", "fallbackType", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "existingCard", "incomingVersionId", "Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$a;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "previous", "", "incomingVersion", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "existing", "incoming", "f", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$c;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;Ljava/util/List;)Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$c;", "mimeType", "fileName", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "TAG", "Ljava/lang/String;", "ARTIFACT_ARRAY_KEYS", "Ljava/util/List;", "c", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskArtifactPartMerger {
    private static final String TAG = "TaskArtifactPartMerger";
    public static final TaskArtifactPartMerger INSTANCE = new TaskArtifactPartMerger();
    private static final List<String> ARTIFACT_ARRAY_KEYS = C1173v.p("artifacts", "files");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$a;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "addedParts", "<init>", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/List;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final List<TaskInfoPart> addedParts;
        private final TaskInfoCard card;

        public a(TaskInfoCard card, List<TaskInfoPart> addedParts) {
            p.i(card, "card");
            p.i(addedParts, "addedParts");
            this.card = card;
            this.addedParts = addedParts;
        }

        public final List<TaskInfoPart> a() {
            return this.addedParts;
        }

        /* renamed from: b, reason: from getter */
        public final TaskInfoCard getCard() {
            return this.card;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$b;", "", "", "taskId", "versionId", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "parts", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "c", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger$b, reason: from toString */
    public static final /* data */ class Parsed {
        private final List<TaskInfoPart> parts;
        private final String taskId;
        private final String versionId;

        public Parsed(String str, String str2, List<TaskInfoPart> parts) {
            p.i(parts, "parts");
            this.taskId = str;
            this.versionId = str2;
            this.parts = parts;
        }

        public final List<TaskInfoPart> a() {
            return this.parts;
        }

        /* renamed from: b, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: c, reason: from getter */
        public final String getVersionId() {
            return this.versionId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parsed)) {
                return false;
            }
            Parsed parsed = (Parsed) other;
            return p.d(this.taskId, parsed.taskId) && p.d(this.versionId, parsed.versionId) && p.d(this.parts, parsed.parts);
        }

        public int hashCode() {
            String str = this.taskId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.versionId;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.parts.hashCode();
        }

        public String toString() {
            return "Parsed(taskId=" + this.taskId + ", versionId=" + this.versionId + ", parts=" + this.parts + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/taskstore/artifact/TaskArtifactPartMerger$c;", "", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "parts", "addedParts", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger$c, reason: from toString */
    public static final /* data */ class PartsMerge {
        private final List<TaskInfoPart> addedParts;
        private final List<TaskInfoPart> parts;

        public PartsMerge(List<TaskInfoPart> parts, List<TaskInfoPart> addedParts) {
            p.i(parts, "parts");
            p.i(addedParts, "addedParts");
            this.parts = parts;
            this.addedParts = addedParts;
        }

        public final List<TaskInfoPart> a() {
            return this.addedParts;
        }

        public final List<TaskInfoPart> b() {
            return this.parts;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PartsMerge)) {
                return false;
            }
            PartsMerge partsMerge = (PartsMerge) other;
            return p.d(this.parts, partsMerge.parts) && p.d(this.addedParts, partsMerge.addedParts);
        }

        public int hashCode() {
            return (this.parts.hashCode() * 31) + this.addedParts.hashCode();
        }

        public String toString() {
            return "PartsMerge(parts=" + this.parts + ", addedParts=" + this.addedParts + ")";
        }
    }

    public static /* synthetic */ List c(TaskArtifactPartMerger taskArtifactPartMerger, TaskInfoCard taskInfoCard, String str, Integer num, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            num = null;
        }
        return taskArtifactPartMerger.b(taskInfoCard, str, num);
    }

    public static /* synthetic */ Object e(TaskArtifactPartMerger taskArtifactPartMerger, String str, List list, String str2, String str3, TaskInfoCard taskInfoCard, String str4, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            taskInfoCard = null;
        }
        if ((i10 & 32) != 0) {
            str4 = null;
        }
        return taskArtifactPartMerger.d(str, list, str2, str3, taskInfoCard, str4, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoCard a(java.lang.String r42, java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoPart> r43, java.lang.String r44, java.lang.String r45) {
        /*
            r41 = this;
            java.lang.String r0 = "taskId"
            r6 = r42
            kotlin.jvm.internal.p.i(r6, r0)
            java.lang.String r0 = "parts"
            r1 = r43
            kotlin.jvm.internal.p.i(r1, r0)
            long r24 = java.lang.System.currentTimeMillis()
            com.stepos.ailauncher.taskstore.entity.TaskInfoEventType r2 = com.stepos.ailauncher.taskstore.entity.TaskInfoEventType.COMPLETED
            r0 = 0
            if (r45 == 0) goto L28
            boolean r3 = La.H.x0(r45)
            if (r3 != 0) goto L22
            r3 = r45
            goto L23
        L22:
            r3 = r0
        L23:
            if (r3 != 0) goto L26
            goto L28
        L26:
            r9 = r3
            goto L2b
        L28:
            java.lang.String r3 = "agent_task"
            goto L26
        L2b:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r15 = com.stepos.ailauncher.taskstore.entity.TaskInfoStatus.COMPLETED
            java.lang.Object r3 = Z8.F.s0(r1)
            com.stepos.ailauncher.taskstore.entity.TaskInfoPart r3 = (com.stepos.ailauncher.taskstore.entity.TaskInfoPart) r3
            if (r3 == 0) goto L4b
            java.lang.String r4 = r3.getTitle()
            if (r4 != 0) goto L3f
            java.lang.String r4 = r3.getFileName()
        L3f:
            if (r4 == 0) goto L4b
            r3 = 46
            r5 = 2
            java.lang.String r3 = La.H.A1(r4, r3, r0, r5, r0)
            r16 = r3
            goto L4d
        L4b:
            r16 = r0
        L4d:
            if (r44 == 0) goto L58
            boolean r3 = La.H.x0(r44)
            if (r3 != 0) goto L58
            r21 = r44
            goto L5a
        L58:
            r21 = r0
        L5a:
            java.lang.Long r26 = java.lang.Long.valueOf(r24)
            java.lang.Long r27 = java.lang.Long.valueOf(r24)
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r1 = new com.stepos.ailauncher.taskstore.entity.TaskInfoCard
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = -130572434(0xfffffffff8379f6e, float:-1.4897249E34)
            r39 = 3
            r40 = 0
            r28 = r24
            r30 = r43
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger.a(java.lang.String, java.util.List, java.lang.String, java.lang.String):com.stepos.ailauncher.taskstore.entity.TaskInfoCard");
    }

    public final List<TaskInfoPart> b(TaskInfoCard previous, String incomingVersionId, Integer incomingVersion) {
        List<TaskInfoPart> result;
        if (previous != null && (result = previous.getResult()) != null) {
            TaskInfoConverters taskInfoConverters = TaskInfoConverters.INSTANCE;
            String versionId = previous.getVersionId();
            Integer version = previous.getVersion();
            int taskVersion = previous.getTaskVersion();
            if (incomingVersionId == null) {
                incomingVersionId = previous.getVersionId();
            }
            String str = incomingVersionId;
            if (incomingVersion == null) {
                incomingVersion = previous.getVersion();
            }
            if (taskInfoConverters.b(versionId, version, taskVersion, str, incomingVersion, previous.getTaskVersion())) {
                return result;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : result) {
                if (((TaskInfoPart) obj).getType() != TaskInfoPartType.IMAGE) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x02dc A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r60, java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoPart> r61, java.lang.String r62, java.lang.String r63, com.stepos.ailauncher.taskstore.entity.TaskInfoCard r64, java.lang.String r65, e9.InterfaceC4014c<? super com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger.a> r66) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1167
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger.d(java.lang.String, java.util.List, java.lang.String, java.lang.String, com.stepos.ailauncher.taskstore.entity.TaskInfoCard, java.lang.String, e9.c):java.lang.Object");
    }

    public final List<TaskInfoPart> f(List<TaskInfoPart> existing, List<TaskInfoPart> incoming) {
        p.i(incoming, "incoming");
        return g(existing, incoming).b();
    }

    public final PartsMerge g(List<TaskInfoPart> existing, List<TaskInfoPart> incoming) {
        p.i(incoming, "incoming");
        if (existing == null) {
            existing = C1173v.m();
        }
        ArrayList arrayList = new ArrayList(existing);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            String fileId = ((TaskInfoPart) next).getFileId();
            if (fileId != null) {
                String str = H.x0(fileId) ? null : fileId;
                if (str != null) {
                    map.putIfAbsent(str, Integer.valueOf(i10));
                }
            }
            i10 = i11;
        }
        ArrayList arrayList2 = new ArrayList();
        for (TaskInfoPart taskInfoPart : incoming) {
            String fileId2 = taskInfoPart.getFileId();
            if (fileId2 == null || H.x0(fileId2)) {
                fileId2 = null;
            }
            Integer num = fileId2 != null ? (Integer) map.get(fileId2) : null;
            if (num != null) {
                arrayList.set(num.intValue(), taskInfoPart);
            } else {
                if (fileId2 != null) {
                    map.put(fileId2, Integer.valueOf(arrayList.size()));
                }
                arrayList.add(taskInfoPart);
                if (fileId2 != null) {
                    arrayList2.add(taskInfoPart);
                }
            }
        }
        return new PartsMerge(arrayList, arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger.Parsed h(java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger.h(java.lang.String):com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger$b");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0089, code lost:
    
        if (r0.equals("markdown") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0094, code lost:
    
        if (r0.equals("webp") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009e, code lost:
    
        if (r0.equals("jpeg") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
    
        if (r0.equals("html") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b1, code lost:
    
        if (r0.equals("heif") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ba, code lost:
    
        if (r0.equals("heic") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c4, code lost:
    
        if (r0.equals("svg") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ce, code lost:
    
        if (r0.equals("png") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d7, code lost:
    
        if (r0.equals(u6.C5578a.DST_JPG) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e0, code lost:
    
        if (r0.equals("htm") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e5, code lost:
    
        return com.stepos.ailauncher.taskstore.entity.TaskInfoPartType.HTML;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ec, code lost:
    
        if (r0.equals("gif") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f5, code lost:
    
        if (r0.equals("bmp") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00fa, code lost:
    
        return com.stepos.ailauncher.taskstore.entity.TaskInfoPartType.IMAGE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0101, code lost:
    
        if (r0.equals("md") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0106, code lost:
    
        return com.stepos.ailauncher.taskstore.entity.TaskInfoPartType.MARKDOWN;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoPartType i(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger.i(java.lang.String, java.lang.String):com.stepos.ailauncher.taskstore.entity.TaskInfoPartType");
    }
}
