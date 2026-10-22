package com.obric.capabilitykit.common;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003JC\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/TaskStateInfo;", "Landroid/os/Parcelable;", WsConstants.KEY_CONNECTION_STATE, "Lcom/obric/capabilitykit/common/TaskState;", ServerElements.CONTENT, "", "screenshot", "Landroid/graphics/Bitmap;", "ext", "", "(Lcom/obric/capabilitykit/common/TaskState;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/util/Map;)V", "getContent", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getScreenshot", "()Landroid/graphics/Bitmap;", "setScreenshot", "(Landroid/graphics/Bitmap;)V", "getState", "()Lcom/obric/capabilitykit/common/TaskState;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class TaskStateInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TaskStateInfo> CREATOR = null;

    @Nullable
    private final String content;

    @Nullable
    private Map<String, String> ext;

    @Nullable
    private Bitmap screenshot;

    @NotNull
    private final TaskState state;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<TaskStateInfo> {
        public a() {
        }

        @NotNull
        public final TaskStateInfo a(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            kotlin.jvm.internal.q.g(r10, "parcel");
            TaskState r12 = TaskState.valueOf(r10.readString());
            String r13 = r10.readString();
            Bitmap r14 = (Bitmap) r10.readParcelable(TaskStateInfo.class.getClassLoader());
            if (r10.readInt() != 0) goto L5;
            LinkedHashMap r15 = null;
        L9:
            TaskStateInfo r16 = new TaskStateInfo(r12, r13, r14, r15);
            int r17 = Math.min(r11, 0);
            ClassLoader r18 = a.class.getClassLoader();
            int r19 = 1;
        L10:
            if (r19 > r17) goto L12;
            r19 = r19 + 1;
        L12:
            if (r19 > r11) goto L14;
            be.a.d(r10, r18);
            r19 = r19 + 1;
            goto L12
        L14:
            return r16;
        L5:
            int r20 = r10.readInt();
            LinkedHashMap r21 = new LinkedHashMap(r20);
            int r22 = 0;
        L6:
            if (r22 == r20) goto L8;
            r21.put(r10.readString(), r10.readString());
            r22 = r22 + 1;
            goto L6
        L8:
            r15 = r21;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskStateInfo createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TaskStateInfo[] newArray(int r10) {
            return a(r10);
        }

        @NotNull
        public final TaskStateInfo[] a(int r10) {
            return new TaskStateInfo[r10];
        }
    }

    static {
        CREATOR = new a();
    }

    public TaskStateInfo(@NotNull TaskState r10, @Nullable String r11, @Nullable Bitmap r12, @Nullable Map<String, String> r13) {
        kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        this.state = r10;
        this.content = r11;
        this.screenshot = r12;
        this.ext = r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskStateInfo copy$default(TaskStateInfo r10, TaskState r11, String r12, Bitmap r13, Map r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.state;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.content;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.screenshot;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.ext;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @NotNull
    public final TaskState component1() {
        return this.state;
    }

    @Nullable
    public final String component2() {
        return this.content;
    }

    @Nullable
    public final Bitmap component3() {
        return this.screenshot;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.ext;
    }

    @NotNull
    public final TaskStateInfo copy(@NotNull TaskState r10, @Nullable String r11, @Nullable Bitmap r12, @Nullable Map<String, String> r13) {
        kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        return new TaskStateInfo(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TaskStateInfo) == true) goto L8;
        return false;
    L8:
        TaskStateInfo r11 = (TaskStateInfo) r10;
        if (this.state == r11.state) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.content, r11.content) == true) goto L15;
        return false;
    L15:
        if (kotlin.jvm.internal.q.b(this.screenshot, r11.screenshot) == true) goto L18;
        return false;
    L18:
        if (kotlin.jvm.internal.q.b(this.ext, r11.ext) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Map<String, String> getExt() {
        return this.ext;
    }

    @Nullable
    public final Bitmap getScreenshot() {
        return this.screenshot;
    }

    @NotNull
    public final TaskState getState() {
        return this.state;
    }

    public int hashCode() {
        int r10 = this.state.hashCode() * 31;
        String r11 = this.content;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        Bitmap r15 = this.screenshot;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (r14 + r16) * 31;
        Map<String, String> r18 = this.ext;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        return r17 + r12;
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void setExt(@Nullable Map<String, String> r10) {
        this.ext = r10;
    }

    public final void setScreenshot(@Nullable Bitmap r10) {
        this.screenshot = r10;
    }

    @NotNull
    public String toString() {
        return "TaskStateInfo(state=" + this.state + ", content=" + this.content + ", screenshot=" + this.screenshot + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        kotlin.jvm.internal.q.g(r10, "out");
        r10.writeString(this.state.name());
        r10.writeString(this.content);
        r10.writeParcelable(this.screenshot, r11);
        Map<String, String> r12 = this.ext;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.size());
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        Map.Entry<String, String> r14 = r13.next();
        r10.writeString(r14.getKey());
        r10.writeString(r14.getValue());
        goto L7
    }

    public /* synthetic */ TaskStateInfo(TaskState r10, String r11, Bitmap r12, Map r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = null;
    L11:
        this(r10, r11, r12, r13);
    }
}
