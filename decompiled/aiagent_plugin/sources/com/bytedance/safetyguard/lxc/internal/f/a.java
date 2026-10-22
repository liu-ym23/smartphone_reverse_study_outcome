package com.bytedance.safetyguard.lxc.internal.f;

import android.os.ParcelFileDescriptor;
import d.h.b.o;

/* JADX INFO: compiled from: ParcelFileDescriptorStreams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final ParcelFileDescriptor.AutoCloseInputStream a(ParcelFileDescriptor r1) {
        o.e(r1, "<this>");
        return new ParcelFileDescriptor.AutoCloseInputStream(r1);
    }

    public static final ParcelFileDescriptor.AutoCloseOutputStream b(ParcelFileDescriptor r1) {
        o.e(r1, "<this>");
        return new ParcelFileDescriptor.AutoCloseOutputStream(r1);
    }
}
