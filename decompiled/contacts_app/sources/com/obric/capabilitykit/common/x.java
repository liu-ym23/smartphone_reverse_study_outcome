package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/FileEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class x implements a0 {
    public static final x a = null;

    static {
        a = new x();
    }

    private x() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof FileEntity) == false) goto L9;
        FileEntity r4 = (FileEntity) r3;
        int r2 = ((((((r4.getFileName().hashCode() + 0) * 31) + Long.hashCode(r4.getFileSize())) * 31) + r4.getContentUrl().hashCode()) * 31) + r4.getFileType().name().hashCode();
        String r5 = r4.getMimeType();
        if (r5 != null) goto L7;
        return r2;
    L7:
        return (r2 * 31) + r5.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
