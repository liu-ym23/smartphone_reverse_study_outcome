package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\u0010\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\"H\u0016J\t\u0010#\u001a\u00020\u001cHÖ\u0001J\b\u0010$\u001a\u00020\u001eH\u0016J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010 H\u0016J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/intent/NotesUpdateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "title", "", ServerElements.CONTENT, "Lcom/obric/capabilitykit/common/intent/NoteContent;", "(Lcom/obric/capabilitykit/entity/app/NoteEntity;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/NoteContent;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/NoteContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/NoteContent;)V", "getTarget", "()Lcom/obric/capabilitykit/entity/app/NoteEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/NoteEntity;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class NotesUpdateParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<NotesUpdateParams> CREATOR = null;

    @Nullable
    private NoteContent content;

    @Nullable
    private NoteEntity target;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NotesUpdateParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotesUpdateParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            NoteEntity r12 = (NoteEntity) r10.readParcelable(NotesUpdateParams.class.getClassLoader());
            String r13 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            NoteContent r14 = null;
        L6:
            NotesUpdateParams r15 = new NotesUpdateParams(r12, r13, r14);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
            int r18 = 1;
        L7:
            if (r18 > r16) goto L9;
            r18 = r18 + 1;
        L9:
            if (r18 > r11) goto L11;
            a.d(r10, r17);
            r18 = r18 + 1;
            goto L9
        L11:
            return r15;
        L5:
            r14 = NoteContent.CREATOR.createFromParcel(r10);
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotesUpdateParams[] newArray(int r10) {
            return new NotesUpdateParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesUpdateParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesUpdateParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public NotesUpdateParams() {
        NoteEntity r10 = null;
        String r11 = null;
        NoteContent r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ NotesUpdateParams copy$default(NotesUpdateParams r10, NoteEntity r11, String r12, NoteContent r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.title;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.content;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final NoteEntity component1() {
        return this.target;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final NoteContent component3() {
        return this.content;
    }

    @NotNull
    public final NotesUpdateParams copy(@Nullable NoteEntity r10, @Nullable String r11, @Nullable NoteContent r12) {
        return new NotesUpdateParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NotesUpdateParams) == true) goto L8;
        return false;
    L8:
        NotesUpdateParams r11 = (NotesUpdateParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.title, r11.title) == true) goto L15;
        return false;
    L15:
        if (q.b(this.content, r11.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final NoteContent getContent() {
        return this.content;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final NoteEntity getTarget() {
        return this.target;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return t.l(new Object[]{this.target, this.content});
    }

    public int hashCode() {
        NoteEntity r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.title;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        NoteContent r17 = this.content;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof NotesUpdateParams) == true) goto L5;
        return this;
    L5:
        NoteEntity r11 = this.target;
        if (r11 != null) goto L8;
        r11 = ((NotesUpdateParams) r10).target;
    L8:
        String r12 = this.title;
        if (r12 != null) goto L11;
        r12 = ((NotesUpdateParams) r10).title;
    L11:
        NoteContent r13 = this.content;
        if (r13 != null) goto L15;
        r13 = ((NotesUpdateParams) r10).content;
    L15:
        return new NotesUpdateParams(r11, r12, r13);
    }

    public final void setContent(@Nullable NoteContent r10) {
        this.content = r10;
    }

    public final void setTarget(@Nullable NoteEntity r10) {
        this.target = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    @NotNull
    public String toString() {
        return "NotesUpdateParams(target=" + this.target + ", title=" + this.title + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.target, r11);
        r10.writeString(this.title);
        NoteContent r12 = this.content;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r12.writeToParcel(r10, r11);
    }

    public NotesUpdateParams(@Nullable NoteEntity r10, @Nullable String r11, @Nullable NoteContent r12) {
        this.target = r10;
        this.title = r11;
        this.content = r12;
    }

    public /* synthetic */ NotesUpdateParams(NoteEntity r10, String r11, NoteContent r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
