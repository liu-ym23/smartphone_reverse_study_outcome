package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e0 f11273a = null;

    static {
        f11273a = new e0();
    }

    private e0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof NoteEntity) == false) goto L18;
        NoteEntity r11 = (NoteEntity) r10;
        int r12 = (r11.getTitle().hashCode() * 31) + r11.getText().hashCode();
        FormatModeEnum r13 = r11.getFormatMode();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.name().hashCode();
    L7:
        String r14 = r11.getNoteFolder();
        if (r14 == null) goto L10;
        r12 = (r12 * 31) + r14.hashCode();
    L10:
        int r15 = (r12 * 31) + Boolean.hashCode(r11.isFavorite());
        List<FileEntity> r16 = r11.getFiles();
        if (r16 == null) goto L13;
        r15 = (r15 * 31) + r16.hashCode();
    L13:
        List<RecordingEntity> r17 = r11.getRecordings();
        if (r17 != null) goto L16;
        return r15;
    L16:
        return (r15 * 31) + r17.hashCode();
    L18:
        throw new IllegalStateException("Check failed.");
    }
}
