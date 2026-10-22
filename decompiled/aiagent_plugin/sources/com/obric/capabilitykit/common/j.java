package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f32057a = null;

    static {
        f32057a = new j();
    }

    private j() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, NoteEntity.class) == false) goto L18;
        NoteEntity r1 = (NoteEntity) ZeusTransformUtils.preCheckCast(r2, NoteEntity.class, "com.obric.aiagent.plugin");
        int r3 = ((r1.getTitle().hashCode() + 0) * 31) + r1.getText().hashCode();
        FormatModeEnum r0 = r1.getFormatMode();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.name().hashCode();
    L7:
        String r4 = r1.getNoteFolder();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        int r5 = (r3 * 31) + Boolean.hashCode(r1.isFavorite());
        List<FileEntity> r6 = r1.getFiles();
        if (r6 == null) goto L13;
        r5 = (r5 * 31) + r6.hashCode();
    L13:
        List<RecordingEntity> r7 = r1.getRecordings();
        if (r7 != null) goto L16;
        return r5;
    L16:
        return (r5 * 31) + r7.hashCode();
    L18:
        throw new IllegalStateException("Check failed.".toString());
    }
}
