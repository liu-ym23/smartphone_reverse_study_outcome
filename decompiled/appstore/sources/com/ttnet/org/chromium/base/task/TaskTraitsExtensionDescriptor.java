package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes4.dex */
public interface TaskTraitsExtensionDescriptor<Extension> {
    Extension fromSerializedData(byte[] r10);

    int getId();

    byte[] toSerializedData(Extension r10);
}
