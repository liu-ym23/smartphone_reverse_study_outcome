package com.stepos.agentframework.chatcore.intent;

import android.graphics.Bitmap;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u0018R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u0018R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u0018¨\u0006&"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/g;", "", "", "taskId", "taskName", "action", "bitmapId", "Landroid/graphics/Bitmap;", "bitmap", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", "setTaskId", "(Ljava/lang/String;)V", "f", "setTaskName", Const.INTENT_KEY_APIKEY, "setAction", "c", "setBitmapId", "Landroid/graphics/Bitmap;", Const.INTENT_KEY_PKGNAME, "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", Const.INTENT_KEY_UMID, "setMessage", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.intent.g, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class GuiTaskProgress {
    private String action;
    private Bitmap bitmap;
    private String bitmapId;
    private String message;
    private String taskId;
    private String taskName;

    public GuiTaskProgress(String taskId, String taskName, String action, String str, Bitmap bitmap, String str2) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(taskName, "taskName");
        kotlin.jvm.internal.p.i(action, "action");
        this.taskId = taskId;
        this.taskName = taskName;
        this.action = action;
        this.bitmapId = str;
        this.bitmap = bitmap;
        this.message = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: c, reason: from getter */
    public final String getBitmapId() {
        return this.bitmapId;
    }

    /* renamed from: d, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTaskProgress)) {
            return false;
        }
        GuiTaskProgress guiTaskProgress = (GuiTaskProgress) other;
        return kotlin.jvm.internal.p.d(this.taskId, guiTaskProgress.taskId) && kotlin.jvm.internal.p.d(this.taskName, guiTaskProgress.taskName) && kotlin.jvm.internal.p.d(this.action, guiTaskProgress.action) && kotlin.jvm.internal.p.d(this.bitmapId, guiTaskProgress.bitmapId) && kotlin.jvm.internal.p.d(this.bitmap, guiTaskProgress.bitmap) && kotlin.jvm.internal.p.d(this.message, guiTaskProgress.message);
    }

    /* renamed from: f, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    public int hashCode() {
        int iHashCode = ((((this.taskId.hashCode() * 31) + this.taskName.hashCode()) * 31) + this.action.hashCode()) * 31;
        String str = this.bitmapId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Bitmap bitmap = this.bitmap;
        int iHashCode3 = (iHashCode2 + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        String str2 = this.message;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "GuiTaskProgress(taskId=" + this.taskId + ", taskName=" + this.taskName + ", action=" + this.action + ", bitmapId=" + this.bitmapId + ", bitmap=" + this.bitmap + ", message=" + this.message + ")";
    }
}
