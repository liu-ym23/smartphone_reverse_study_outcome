package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private AbstractMessage.BuilderParent parent;

    public SingleFieldBuilderV3(MType r10, AbstractMessage.BuilderParent r11, boolean r12) {
        if (r10 == null) goto L7;
        this.message = r10;
        this.parent = r11;
        this.isClean = r12;
        return;
    L7:
        throw null;
    }

    private void onChanged() {
        if (this.builder == null) goto L6;
        this.message = null;
    L6:
        if (this.isClean == false) goto L11;
        AbstractMessage.BuilderParent r10 = this.parent;
        if (r10 == null) goto L12;
        r10.markDirty();
        this.isClean = false;
        return;
    L12:
        return;
    }

    public MType build() {
        this.isClean = true;
        return (MType) getMessage();
    }

    public SingleFieldBuilderV3<MType, BType, IType> clear() {
        MType r10 = this.message;
        if (r10 == null) goto L5;
        Message r11 = r10.getDefaultInstanceForType();
    L6:
        this.message = (MType) r11;
        BType r12 = this.builder;
        if (r12 == null) goto L9;
        r12.dispose();
        this.builder = null;
    L9:
        onChanged();
        return this;
    L5:
        r11 = this.builder.getDefaultInstanceForType();
        goto L6
    }

    public void dispose() {
        this.parent = null;
    }

    public BType getBuilder() {
        if (this.builder != null) goto L6;
        BType r10 = (BType) this.message.newBuilderForType(this);
        this.builder = r10;
        r10.mergeFrom(this.message);
        this.builder.markClean();
    L6:
        return this.builder;
    }

    public MType getMessage() {
        if (this.message != null) goto L6;
        this.message = (MType) this.builder.buildPartial();
    L6:
        return this.message;
    }

    public IType getMessageOrBuilder() {
        BType r10 = this.builder;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.message;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    public SingleFieldBuilderV3<MType, BType, IType> mergeFrom(MType r10) {
        if (this.builder != null) goto L7;
        Message r11 = this.message;
        if (r11 != r11.getDefaultInstanceForType()) goto L7;
        this.message = r10;
    L8:
        onChanged();
        return this;
    L7:
        getBuilder().mergeFrom(r10);
        goto L8
    }

    public SingleFieldBuilderV3<MType, BType, IType> setMessage(MType r10) {
        if (r10 == null) goto L9;
        this.message = r10;
        BType r11 = this.builder;
        if (r11 == null) goto L7;
        r11.dispose();
        this.builder = null;
    L7:
        onChanged();
        return this;
    L9:
        throw null;
    }
}
