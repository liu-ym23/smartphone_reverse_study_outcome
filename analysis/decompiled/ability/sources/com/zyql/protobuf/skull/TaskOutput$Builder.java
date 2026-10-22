package com.zyql.protobuf.skull;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import v7.i;
import v7.l;
import v7.s;

/* loaded from: classes2.dex */
public final class TaskOutput$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskOutput$Builder(int i) {
        this();
    }

    public TaskOutput$Builder addAllArtifacts(Iterable<? extends l> iterable) {
        copyOnWrite();
        s.D((s) this.instance, iterable);
        return this;
    }

    public TaskOutput$Builder addArtifacts(l lVar) {
        copyOnWrite();
        s.F((s) this.instance, lVar);
        return this;
    }

    public TaskOutput$Builder clearArtifacts() {
        copyOnWrite();
        s.G((s) this.instance);
        return this;
    }

    public TaskOutput$Builder clearMessage() {
        copyOnWrite();
        s.H((s) this.instance);
        return this;
    }

    public l getArtifacts(int i) {
        return ((s) this.instance).O(i);
    }

    public int getArtifactsCount() {
        return ((s) this.instance).P();
    }

    public List<l> getArtifactsList() {
        return Collections.unmodifiableList(((s) this.instance).Q());
    }

    public i getMessage() {
        return ((s) this.instance).S();
    }

    public boolean hasMessage() {
        return ((s) this.instance).T();
    }

    public TaskOutput$Builder mergeMessage(i iVar) {
        copyOnWrite();
        s.I((s) this.instance, iVar);
        return this;
    }

    public TaskOutput$Builder removeArtifacts(int i) {
        copyOnWrite();
        s.J((s) this.instance, i);
        return this;
    }

    public TaskOutput$Builder setArtifacts(int i, l lVar) {
        copyOnWrite();
        s.K((s) this.instance, i, lVar);
        return this;
    }

    public TaskOutput$Builder setMessage(i iVar) {
        copyOnWrite();
        s.L((s) this.instance, iVar);
        return this;
    }

    private TaskOutput$Builder() {
        super(s.DEFAULT_INSTANCE);
    }

    public TaskOutput$Builder addArtifacts(int i, l lVar) {
        copyOnWrite();
        s.E((s) this.instance, i, lVar);
        return this;
    }

    public TaskOutput$Builder setArtifacts(int i, Resource$Builder resource$Builder) {
        copyOnWrite();
        s.K((s) this.instance, i, (l) resource$Builder.k());
        return this;
    }

    public TaskOutput$Builder setMessage(Message$Builder message$Builder) {
        copyOnWrite();
        s.L((s) this.instance, (i) message$Builder.k());
        return this;
    }

    public TaskOutput$Builder addArtifacts(Resource$Builder resource$Builder) {
        copyOnWrite();
        s.F((s) this.instance, (l) resource$Builder.k());
        return this;
    }

    public TaskOutput$Builder addArtifacts(int i, Resource$Builder resource$Builder) {
        copyOnWrite();
        s.E((s) this.instance, i, (l) resource$Builder.k());
        return this;
    }
}
