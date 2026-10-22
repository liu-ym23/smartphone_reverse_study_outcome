package com.zyql.protobuf.skull;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import v7.e;
import v7.h;

/* loaded from: classes2.dex */
public final class Execution$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Execution$Builder(int i) {
        this();
    }

    public Execution$Builder addAllItems(Iterable<? extends h> iterable) {
        copyOnWrite();
        e.D((e) this.instance, iterable);
        return this;
    }

    public Execution$Builder addItems(h hVar) {
        copyOnWrite();
        e.F((e) this.instance, hVar);
        return this;
    }

    public Execution$Builder clearItems() {
        copyOnWrite();
        e.G((e) this.instance);
        return this;
    }

    public h getItems(int i) {
        return ((e) this.instance).L(i);
    }

    public int getItemsCount() {
        return ((e) this.instance).M();
    }

    public List<h> getItemsList() {
        return Collections.unmodifiableList(((e) this.instance).N());
    }

    public Execution$Builder removeItems(int i) {
        copyOnWrite();
        e.H((e) this.instance, i);
        return this;
    }

    public Execution$Builder setItems(int i, h hVar) {
        copyOnWrite();
        e.I((e) this.instance, i, hVar);
        return this;
    }

    private Execution$Builder() {
        super(e.DEFAULT_INSTANCE);
    }

    public Execution$Builder addItems(int i, h hVar) {
        copyOnWrite();
        e.E((e) this.instance, i, hVar);
        return this;
    }

    public Execution$Builder setItems(int i, Item$Builder item$Builder) {
        copyOnWrite();
        e.I((e) this.instance, i, (h) item$Builder.k());
        return this;
    }

    public Execution$Builder addItems(Item$Builder item$Builder) {
        copyOnWrite();
        e.F((e) this.instance, (h) item$Builder.k());
        return this;
    }

    public Execution$Builder addItems(int i, Item$Builder item$Builder) {
        copyOnWrite();
        e.E((e) this.instance, i, (h) item$Builder.k());
        return this;
    }
}
