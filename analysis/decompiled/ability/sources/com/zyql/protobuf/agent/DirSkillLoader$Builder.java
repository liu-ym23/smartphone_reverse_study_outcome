package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1771g;

/* loaded from: classes2.dex */
public final class DirSkillLoader$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ DirSkillLoader$Builder(int i) {
        this();
    }

    public DirSkillLoader$Builder clearIsSeparate() {
        copyOnWrite();
        C1771g.D((C1771g) this.instance);
        return this;
    }

    public DirSkillLoader$Builder clearPath() {
        copyOnWrite();
        C1771g.E((C1771g) this.instance);
        return this;
    }

    public boolean getIsSeparate() {
        return ((C1771g) this.instance).K();
    }

    public String getPath() {
        return ((C1771g) this.instance).L();
    }

    public ByteString getPathBytes() {
        return ((C1771g) this.instance).M();
    }

    public boolean hasIsSeparate() {
        return ((C1771g) this.instance).N();
    }

    public DirSkillLoader$Builder setIsSeparate(boolean z10) {
        copyOnWrite();
        C1771g.F((C1771g) this.instance, z10);
        return this;
    }

    public DirSkillLoader$Builder setPath(String str) {
        copyOnWrite();
        C1771g.G((C1771g) this.instance, str);
        return this;
    }

    public DirSkillLoader$Builder setPathBytes(ByteString byteString) {
        copyOnWrite();
        C1771g.H((C1771g) this.instance, byteString);
        return this;
    }

    private DirSkillLoader$Builder() {
        super(C1771g.DEFAULT_INSTANCE);
    }
}
