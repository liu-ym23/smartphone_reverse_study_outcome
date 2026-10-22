package com.stepos.ailauncher.taskstore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ@\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u000eJ\u001a\u0010\"\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u0016R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010\u0019R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010\u001b¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "Landroid/os/Parcelable;", "", "question", "header", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoOption;", "options", "", "multiSelect", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/List;", "component4", "()Ljava/lang/Boolean;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getQuestion", "getHeader", "Ljava/util/List;", "getOptions", "Ljava/lang/Boolean;", "getMultiSelect", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoQuestion implements Parcelable {
    public static final Parcelable.Creator<TaskInfoQuestion> CREATOR = new Creator();
    private final String header;
    private final Boolean multiSelect;
    private final List<TaskInfoOption> options;
    private final String question;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskInfoQuestion> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoQuestion createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                arrayList.add(TaskInfoOption.CREATOR.createFromParcel(parcel));
            }
            return new TaskInfoQuestion(string, string2, arrayList, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoQuestion[] newArray(int i10) {
            return new TaskInfoQuestion[i10];
        }
    }

    public TaskInfoQuestion(String question, String header, List<TaskInfoOption> options, Boolean bool) {
        p.i(question, "question");
        p.i(header, "header");
        p.i(options, "options");
        this.question = question;
        this.header = header;
        this.options = options;
        this.multiSelect = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskInfoQuestion copy$default(TaskInfoQuestion taskInfoQuestion, String str, String str2, List list, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskInfoQuestion.question;
        }
        if ((i10 & 2) != 0) {
            str2 = taskInfoQuestion.header;
        }
        if ((i10 & 4) != 0) {
            list = taskInfoQuestion.options;
        }
        if ((i10 & 8) != 0) {
            bool = taskInfoQuestion.multiSelect;
        }
        return taskInfoQuestion.copy(str, str2, list, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    public final List<TaskInfoOption> component3() {
        return this.options;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final TaskInfoQuestion copy(String question, String header, List<TaskInfoOption> options, Boolean multiSelect) {
        p.i(question, "question");
        p.i(header, "header");
        p.i(options, "options");
        return new TaskInfoQuestion(question, header, options, multiSelect);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoQuestion)) {
            return false;
        }
        TaskInfoQuestion taskInfoQuestion = (TaskInfoQuestion) other;
        return p.d(this.question, taskInfoQuestion.question) && p.d(this.header, taskInfoQuestion.header) && p.d(this.options, taskInfoQuestion.options) && p.d(this.multiSelect, taskInfoQuestion.multiSelect);
    }

    public final String getHeader() {
        return this.header;
    }

    public final Boolean getMultiSelect() {
        return this.multiSelect;
    }

    public final List<TaskInfoOption> getOptions() {
        return this.options;
    }

    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        int iHashCode = ((((this.question.hashCode() * 31) + this.header.hashCode()) * 31) + this.options.hashCode()) * 31;
        Boolean bool = this.multiSelect;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "TaskInfoQuestion(question=" + this.question + ", header=" + this.header + ", options=" + this.options + ", multiSelect=" + this.multiSelect + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.question);
        dest.writeString(this.header);
        List<TaskInfoOption> list = this.options;
        dest.writeInt(list.size());
        Iterator<TaskInfoOption> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        Boolean bool = this.multiSelect;
        if (bool == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public /* synthetic */ TaskInfoQuestion(String str, String str2, List list, Boolean bool, int i10, i iVar) {
        this(str, str2, list, (i10 & 8) != 0 ? null : bool);
    }
}
