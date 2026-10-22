package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d0 implements a0 {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    private d0() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof NoteEntity) == false) goto L18;
        NoteEntity r3 = (NoteEntity) r2;
        int r1 = ((r3.getTitle().hashCode() + 0) * 31) + r3.getText().hashCode();
        FormatModeEnum r0 = r3.getFormatMode();
        if (r0 == null) goto L7;
        r1 = (r1 * 31) + r0.name().hashCode();
    L7:
        String r4 = r3.getNoteFolder();
        if (r4 == null) goto L10;
        r1 = (r1 * 31) + r4.hashCode();
    L10:
        int r5 = (r1 * 31) + Boolean.hashCode(r3.isFavorite());
        List<FileEntity> r6 = r3.getFiles();
        if (r6 == null) goto L13;
        r5 = (r5 * 31) + r6.hashCode();
    L13:
        List<RecordingEntity> r7 = r3.getRecordings();
        if (r7 != null) goto L16;
        return r5;
    L16:
        return (r5 * 31) + r7.hashCode();
    L18:
        throw new IllegalStateException("Check failed.".toString());
    }
}
