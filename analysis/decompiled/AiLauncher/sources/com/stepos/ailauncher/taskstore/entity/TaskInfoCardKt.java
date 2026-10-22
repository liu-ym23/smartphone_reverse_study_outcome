package com.stepos.ailauncher.taskstore.entity;

import La.D;
import La.H;
import Z8.C1173v;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import q4.i;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0004*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0007"}, d2 = {"TaskInfoType", "", "isImageTaskCard", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "hasSuccessfulImagePart", "shouldHideImageCard", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardKt {
    public static final boolean hasSuccessfulImagePart(TaskInfoCard taskInfoCard) {
        String errorReason;
        p.i(taskInfoCard, "<this>");
        List<TaskInfoPart> result = taskInfoCard.getResult();
        if (result == null) {
            result = C1173v.m();
        }
        List<TaskInfoPart> list = result;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (TaskInfoPart taskInfoPart : list) {
            if (taskInfoPart.getType() == TaskInfoPartType.IMAGE && !D.L(taskInfoPart.getStatus(), "failed", true) && ((errorReason = taskInfoPart.getErrorReason()) == null || H.x0(errorReason))) {
                String errorDetail = taskInfoPart.getErrorDetail();
                if (errorDetail == null || H.x0(errorDetail)) {
                    String fileId = taskInfoPart.getFileId();
                    if ((fileId != null && !H.x0(fileId)) || !H.x0(taskInfoPart.getContent())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isImageTaskCard(TaskInfoCard taskInfoCard) {
        p.i(taskInfoCard, "<this>");
        return p.d(taskInfoCard.getType(), "image") || p.d(taskInfoCard.getType(), i.TOOL_NAME_TEXT_TO_IMAGE);
    }

    public static final boolean shouldHideImageCard(TaskInfoCard taskInfoCard) {
        p.i(taskInfoCard, "<this>");
        return taskInfoCard.getStatus().isTerminalFailure() && !hasSuccessfulImagePart(taskInfoCard);
    }
}
