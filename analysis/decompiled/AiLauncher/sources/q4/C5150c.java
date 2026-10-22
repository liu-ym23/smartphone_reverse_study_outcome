package q4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w4.TaskResultArtifactEntity;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lw4/j;", "Lq4/b;", Const.INTENT_KEY_APIKEY, "(Lw4/j;)Lq4/b;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: q4.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5150c {
    public static final TaskResultArtifact a(TaskResultArtifactEntity taskResultArtifactEntity) {
        p.i(taskResultArtifactEntity, "<this>");
        return new TaskResultArtifact(taskResultArtifactEntity.getFileId(), taskResultArtifactEntity.getSessionId(), taskResultArtifactEntity.getMessageId(), taskResultArtifactEntity.getToolCallId(), taskResultArtifactEntity.getTaskId(), taskResultArtifactEntity.getVersionId(), taskResultArtifactEntity.getCloudPath(), taskResultArtifactEntity.getFileName(), taskResultArtifactEntity.getTitle(), taskResultArtifactEntity.getMimeType(), taskResultArtifactEntity.getSize(), taskResultArtifactEntity.getCreatedAt());
    }
}
