package com.stepos.ailauncher.oobe.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/oobe/api/RestoreWorkspaceMdParams;", "Ljava/io/Serializable;", "files", "", "", "<init>", "(Ljava/util/List;)V", "getFiles", "()Ljava/util/List;", "component1", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RestoreWorkspaceMdParams implements Serializable {
    private final List<String> files;

    public RestoreWorkspaceMdParams(List<String> files) {
        p.i(files, "files");
        this.files = files;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestoreWorkspaceMdParams copy$default(RestoreWorkspaceMdParams restoreWorkspaceMdParams, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = restoreWorkspaceMdParams.files;
        }
        return restoreWorkspaceMdParams.copy(list);
    }

    public final List<String> component1() {
        return this.files;
    }

    public final RestoreWorkspaceMdParams copy(List<String> files) {
        p.i(files, "files");
        return new RestoreWorkspaceMdParams(files);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RestoreWorkspaceMdParams) && p.d(this.files, ((RestoreWorkspaceMdParams) other).files);
    }

    public final List<String> getFiles() {
        return this.files;
    }

    public int hashCode() {
        return this.files.hashCode();
    }

    public String toString() {
        return "RestoreWorkspaceMdParams(files=" + this.files + ")";
    }
}
