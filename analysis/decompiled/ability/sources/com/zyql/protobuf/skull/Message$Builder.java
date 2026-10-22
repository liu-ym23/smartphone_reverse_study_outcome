package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import v7.i;
import v7.l;

/* loaded from: classes2.dex */
public final class Message$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Message$Builder(int i) {
        this();
    }

    public Message$Builder addAllResources(Iterable<? extends l> iterable) {
        copyOnWrite();
        i.D((i) this.instance, iterable);
        return this;
    }

    public Message$Builder addResources(l lVar) {
        copyOnWrite();
        i.F((i) this.instance, lVar);
        return this;
    }

    public Message$Builder clearContent() {
        copyOnWrite();
        i.G((i) this.instance);
        return this;
    }

    public Message$Builder clearResources() {
        copyOnWrite();
        i.H((i) this.instance);
        return this;
    }

    public Message$Builder clearRole() {
        copyOnWrite();
        i.I((i) this.instance);
        return this;
    }

    public String getContent() {
        return ((i) this.instance).R();
    }

    public ByteString getContentBytes() {
        return ((i) this.instance).S();
    }

    public l getResources(int i) {
        return ((i) this.instance).U(i);
    }

    public int getResourcesCount() {
        return ((i) this.instance).V();
    }

    public List<l> getResourcesList() {
        return Collections.unmodifiableList(((i) this.instance).W());
    }

    public String getRole() {
        return ((i) this.instance).X();
    }

    public ByteString getRoleBytes() {
        return ((i) this.instance).Y();
    }

    public Message$Builder removeResources(int i) {
        copyOnWrite();
        i.J((i) this.instance, i);
        return this;
    }

    public Message$Builder setContent(String str) {
        copyOnWrite();
        i.K((i) this.instance, str);
        return this;
    }

    public Message$Builder setContentBytes(ByteString byteString) {
        copyOnWrite();
        i.L((i) this.instance, byteString);
        return this;
    }

    public Message$Builder setResources(int i, l lVar) {
        copyOnWrite();
        i.M((i) this.instance, i, lVar);
        return this;
    }

    public Message$Builder setRole(String str) {
        copyOnWrite();
        i.N((i) this.instance, str);
        return this;
    }

    public Message$Builder setRoleBytes(ByteString byteString) {
        copyOnWrite();
        i.O((i) this.instance, byteString);
        return this;
    }

    private Message$Builder() {
        super(i.DEFAULT_INSTANCE);
    }

    public Message$Builder addResources(int i, l lVar) {
        copyOnWrite();
        i.E((i) this.instance, i, lVar);
        return this;
    }

    public Message$Builder setResources(int i, Resource$Builder resource$Builder) {
        copyOnWrite();
        i.M((i) this.instance, i, (l) resource$Builder.k());
        return this;
    }

    public Message$Builder addResources(Resource$Builder resource$Builder) {
        copyOnWrite();
        i.F((i) this.instance, (l) resource$Builder.k());
        return this;
    }

    public Message$Builder addResources(int i, Resource$Builder resource$Builder) {
        copyOnWrite();
        i.E((i) this.instance, i, (l) resource$Builder.k());
        return this;
    }
}
