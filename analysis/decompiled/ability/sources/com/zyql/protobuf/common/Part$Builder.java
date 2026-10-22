package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1807e;
import q7.C1809g;
import q7.C1810h;
import q7.C1811i;
import q7.G;

/* loaded from: classes2.dex */
public final class Part$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Part$Builder(int i) {
        this();
    }

    public Part$Builder clearContent() {
        copyOnWrite();
        G.D((G) this.instance);
        return this;
    }

    public Part$Builder clearFileData() {
        copyOnWrite();
        G.E((G) this.instance);
        return this;
    }

    public Part$Builder clearFunctionCall() {
        copyOnWrite();
        G.F((G) this.instance);
        return this;
    }

    public Part$Builder clearFunctionResponse() {
        copyOnWrite();
        G.G((G) this.instance);
        return this;
    }

    public Part$Builder clearInlineData() {
        copyOnWrite();
        G.H((G) this.instance);
        return this;
    }

    public Part$Builder clearText() {
        copyOnWrite();
        G.I((G) this.instance);
        return this;
    }

    public Part$Builder clearThought() {
        copyOnWrite();
        G.J((G) this.instance);
        return this;
    }

    public Part$ContentCase getContentCase() {
        return ((G) this.instance).W();
    }

    public C1809g getFileData() {
        return ((G) this.instance).X();
    }

    public C1810h getFunctionCall() {
        return ((G) this.instance).Y();
    }

    public C1811i getFunctionResponse() {
        return ((G) this.instance).Z();
    }

    public C1807e getInlineData() {
        return ((G) this.instance).a0();
    }

    public String getText() {
        return ((G) this.instance).b0();
    }

    public ByteString getTextBytes() {
        return ((G) this.instance).c0();
    }

    public boolean getThought() {
        return ((G) this.instance).d0();
    }

    public boolean hasFileData() {
        return ((G) this.instance).e0();
    }

    public boolean hasFunctionCall() {
        return ((G) this.instance).f0();
    }

    public boolean hasFunctionResponse() {
        return ((G) this.instance).g0();
    }

    public boolean hasInlineData() {
        return ((G) this.instance).h0();
    }

    public boolean hasText() {
        return ((G) this.instance).i0();
    }

    public Part$Builder mergeFileData(C1809g c1809g) {
        copyOnWrite();
        G.K((G) this.instance, c1809g);
        return this;
    }

    public Part$Builder mergeFunctionCall(C1810h c1810h) {
        copyOnWrite();
        G.L((G) this.instance, c1810h);
        return this;
    }

    public Part$Builder mergeFunctionResponse(C1811i c1811i) {
        copyOnWrite();
        G.M((G) this.instance, c1811i);
        return this;
    }

    public Part$Builder mergeInlineData(C1807e c1807e) {
        copyOnWrite();
        G.N((G) this.instance, c1807e);
        return this;
    }

    public Part$Builder setFileData(C1809g c1809g) {
        copyOnWrite();
        G.O((G) this.instance, c1809g);
        return this;
    }

    public Part$Builder setFunctionCall(C1810h c1810h) {
        copyOnWrite();
        G.P((G) this.instance, c1810h);
        return this;
    }

    public Part$Builder setFunctionResponse(C1811i c1811i) {
        copyOnWrite();
        G.Q((G) this.instance, c1811i);
        return this;
    }

    public Part$Builder setInlineData(C1807e c1807e) {
        copyOnWrite();
        G.R((G) this.instance, c1807e);
        return this;
    }

    public Part$Builder setText(String str) {
        copyOnWrite();
        G.S((G) this.instance, str);
        return this;
    }

    public Part$Builder setTextBytes(ByteString byteString) {
        copyOnWrite();
        G.T((G) this.instance, byteString);
        return this;
    }

    public Part$Builder setThought(boolean z10) {
        copyOnWrite();
        G.U((G) this.instance, z10);
        return this;
    }

    private Part$Builder() {
        super(G.DEFAULT_INSTANCE);
    }

    public Part$Builder setFileData(FileData$Builder fileData$Builder) {
        copyOnWrite();
        G.O((G) this.instance, (C1809g) fileData$Builder.k());
        return this;
    }

    public Part$Builder setFunctionCall(FunctionCall$Builder functionCall$Builder) {
        copyOnWrite();
        G.P((G) this.instance, (C1810h) functionCall$Builder.k());
        return this;
    }

    public Part$Builder setFunctionResponse(FunctionResponse$Builder functionResponse$Builder) {
        copyOnWrite();
        G.Q((G) this.instance, (C1811i) functionResponse$Builder.k());
        return this;
    }

    public Part$Builder setInlineData(Blob$Builder blob$Builder) {
        copyOnWrite();
        G.R((G) this.instance, (C1807e) blob$Builder.k());
        return this;
    }
}
