package com.stepos.ailauncher.oobe.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/SaveAgentPersonParams;", "Ljava/io/Serializable;", "nickname", "", "tasks", "", "style", "overwrite", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)V", "getNickname", "()Ljava/lang/String;", "getTasks", "()Ljava/util/List;", "getStyle", "getOverwrite", "()Z", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "other", "", "hashCode", "", "toString", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SaveAgentPersonParams implements Serializable {
    private final String nickname;
    private final boolean overwrite;
    private final List<String> style;
    private final List<String> tasks;

    public SaveAgentPersonParams(String nickname, List<String> tasks, List<String> style, boolean z10) {
        p.i(nickname, "nickname");
        p.i(tasks, "tasks");
        p.i(style, "style");
        this.nickname = nickname;
        this.tasks = tasks;
        this.style = style;
        this.overwrite = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SaveAgentPersonParams copy$default(SaveAgentPersonParams saveAgentPersonParams, String str, List list, List list2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = saveAgentPersonParams.nickname;
        }
        if ((i10 & 2) != 0) {
            list = saveAgentPersonParams.tasks;
        }
        if ((i10 & 4) != 0) {
            list2 = saveAgentPersonParams.style;
        }
        if ((i10 & 8) != 0) {
            z10 = saveAgentPersonParams.overwrite;
        }
        return saveAgentPersonParams.copy(str, list, list2, z10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    public final List<String> component2() {
        return this.tasks;
    }

    public final List<String> component3() {
        return this.style;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getOverwrite() {
        return this.overwrite;
    }

    public final SaveAgentPersonParams copy(String nickname, List<String> tasks, List<String> style, boolean overwrite) {
        p.i(nickname, "nickname");
        p.i(tasks, "tasks");
        p.i(style, "style");
        return new SaveAgentPersonParams(nickname, tasks, style, overwrite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaveAgentPersonParams)) {
            return false;
        }
        SaveAgentPersonParams saveAgentPersonParams = (SaveAgentPersonParams) other;
        return p.d(this.nickname, saveAgentPersonParams.nickname) && p.d(this.tasks, saveAgentPersonParams.tasks) && p.d(this.style, saveAgentPersonParams.style) && this.overwrite == saveAgentPersonParams.overwrite;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final boolean getOverwrite() {
        return this.overwrite;
    }

    public final List<String> getStyle() {
        return this.style;
    }

    public final List<String> getTasks() {
        return this.tasks;
    }

    public int hashCode() {
        return (((((this.nickname.hashCode() * 31) + this.tasks.hashCode()) * 31) + this.style.hashCode()) * 31) + Boolean.hashCode(this.overwrite);
    }

    public String toString() {
        return "SaveAgentPersonParams(nickname=" + this.nickname + ", tasks=" + this.tasks + ", style=" + this.style + ", overwrite=" + this.overwrite + ")";
    }

    public /* synthetic */ SaveAgentPersonParams(String str, List list, List list2, boolean z10, int i10, i iVar) {
        this(str, list, list2, (i10 & 8) != 0 ? true : z10);
    }
}
