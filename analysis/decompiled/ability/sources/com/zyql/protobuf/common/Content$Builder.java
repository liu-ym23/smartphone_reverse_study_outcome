package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import q7.C1808f;
import q7.G;

/* loaded from: classes2.dex */
public final class Content$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Content$Builder(int i) {
        this();
    }

    public Content$Builder addAllParts(Iterable<? extends G> iterable) {
        copyOnWrite();
        C1808f.D((C1808f) this.instance, iterable);
        return this;
    }

    public Content$Builder addParts(G g) {
        copyOnWrite();
        C1808f.F((C1808f) this.instance, g);
        return this;
    }

    public Content$Builder clearParts() {
        copyOnWrite();
        C1808f.G((C1808f) this.instance);
        return this;
    }

    public Content$Builder clearRole() {
        copyOnWrite();
        C1808f.H((C1808f) this.instance);
        return this;
    }

    public G getParts(int i) {
        return ((C1808f) this.instance).P(i);
    }

    public int getPartsCount() {
        return ((C1808f) this.instance).Q();
    }

    public List<G> getPartsList() {
        return Collections.unmodifiableList(((C1808f) this.instance).R());
    }

    public String getRole() {
        return ((C1808f) this.instance).S();
    }

    public ByteString getRoleBytes() {
        return ((C1808f) this.instance).T();
    }

    public Content$Builder removeParts(int i) {
        copyOnWrite();
        C1808f.I(i, (C1808f) this.instance);
        return this;
    }

    public Content$Builder setParts(int i, G g) {
        copyOnWrite();
        C1808f.J((C1808f) this.instance, i, g);
        return this;
    }

    public Content$Builder setRole(String str) {
        copyOnWrite();
        C1808f.K((C1808f) this.instance, str);
        return this;
    }

    public Content$Builder setRoleBytes(ByteString byteString) {
        copyOnWrite();
        C1808f.L((C1808f) this.instance, byteString);
        return this;
    }

    private Content$Builder() {
        super(C1808f.DEFAULT_INSTANCE);
    }

    public Content$Builder addParts(int i, G g) {
        copyOnWrite();
        C1808f.E((C1808f) this.instance, i, g);
        return this;
    }

    public Content$Builder setParts(int i, Part$Builder part$Builder) {
        copyOnWrite();
        C1808f.J((C1808f) this.instance, i, (G) part$Builder.k());
        return this;
    }

    public Content$Builder addParts(Part$Builder part$Builder) {
        copyOnWrite();
        C1808f.F((C1808f) this.instance, (G) part$Builder.k());
        return this;
    }

    public Content$Builder addParts(int i, Part$Builder part$Builder) {
        copyOnWrite();
        C1808f.E((C1808f) this.instance, i, (G) part$Builder.k());
        return this;
    }
}
