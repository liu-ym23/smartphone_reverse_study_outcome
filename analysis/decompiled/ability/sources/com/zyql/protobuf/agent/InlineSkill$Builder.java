package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import o7.k;
import o7.r;

/* loaded from: classes2.dex */
public final class InlineSkill$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ InlineSkill$Builder(int i) {
        this();
    }

    public InlineSkill$Builder addAllFiles(Iterable<? extends k> iterable) {
        copyOnWrite();
        r.D((r) this.instance, iterable);
        return this;
    }

    public InlineSkill$Builder addFiles(k kVar) {
        copyOnWrite();
        r.F((r) this.instance, kVar);
        return this;
    }

    public InlineSkill$Builder clearDescription() {
        copyOnWrite();
        r.G((r) this.instance);
        return this;
    }

    public InlineSkill$Builder clearFiles() {
        copyOnWrite();
        r.H((r) this.instance);
        return this;
    }

    public InlineSkill$Builder clearName() {
        copyOnWrite();
        r.I((r) this.instance);
        return this;
    }

    public String getDescription() {
        return ((r) this.instance).S();
    }

    public ByteString getDescriptionBytes() {
        return ((r) this.instance).T();
    }

    public k getFiles(int i) {
        return ((r) this.instance).U(i);
    }

    public int getFilesCount() {
        return ((r) this.instance).V();
    }

    public List<k> getFilesList() {
        return Collections.unmodifiableList(((r) this.instance).W());
    }

    public String getName() {
        return ((r) this.instance).X();
    }

    public ByteString getNameBytes() {
        return ((r) this.instance).Y();
    }

    public InlineSkill$Builder removeFiles(int i) {
        copyOnWrite();
        r.J((r) this.instance, i);
        return this;
    }

    public InlineSkill$Builder setDescription(String str) {
        copyOnWrite();
        r.K((r) this.instance, str);
        return this;
    }

    public InlineSkill$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        r.L((r) this.instance, byteString);
        return this;
    }

    public InlineSkill$Builder setFiles(int i, k kVar) {
        copyOnWrite();
        r.M((r) this.instance, i, kVar);
        return this;
    }

    public InlineSkill$Builder setName(String str) {
        copyOnWrite();
        r.N((r) this.instance, str);
        return this;
    }

    public InlineSkill$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        r.O((r) this.instance, byteString);
        return this;
    }

    private InlineSkill$Builder() {
        super(r.DEFAULT_INSTANCE);
    }

    public InlineSkill$Builder addFiles(int i, k kVar) {
        copyOnWrite();
        r.E((r) this.instance, i, kVar);
        return this;
    }

    public InlineSkill$Builder setFiles(int i, FileContent$Builder fileContent$Builder) {
        copyOnWrite();
        r.M((r) this.instance, i, (k) fileContent$Builder.k());
        return this;
    }

    public InlineSkill$Builder addFiles(FileContent$Builder fileContent$Builder) {
        copyOnWrite();
        r.F((r) this.instance, (k) fileContent$Builder.k());
        return this;
    }

    public InlineSkill$Builder addFiles(int i, FileContent$Builder fileContent$Builder) {
        copyOnWrite();
        r.E((r) this.instance, i, (k) fileContent$Builder.k());
        return this;
    }
}
