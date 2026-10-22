package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0005\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/n2;", "", "", "imagePath", "", "isSelected", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Z", "()Z", "setSelected", "(Z)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.n2, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskRobotExecuteThumbnailBean {
    private final String imagePath;
    private boolean isSelected;

    public TaskRobotExecuteThumbnailBean(String imagePath, boolean z10) {
        kotlin.jvm.internal.p.i(imagePath, "imagePath");
        this.imagePath = imagePath;
        this.isSelected = z10;
    }

    /* renamed from: a, reason: from getter */
    public final String getImagePath() {
        return this.imagePath;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskRobotExecuteThumbnailBean)) {
            return false;
        }
        TaskRobotExecuteThumbnailBean taskRobotExecuteThumbnailBean = (TaskRobotExecuteThumbnailBean) other;
        return kotlin.jvm.internal.p.d(this.imagePath, taskRobotExecuteThumbnailBean.imagePath) && this.isSelected == taskRobotExecuteThumbnailBean.isSelected;
    }

    public int hashCode() {
        return (this.imagePath.hashCode() * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        return "TaskRobotExecuteThumbnailBean(imagePath=" + this.imagePath + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ TaskRobotExecuteThumbnailBean(String str, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? false : z10);
    }
}
