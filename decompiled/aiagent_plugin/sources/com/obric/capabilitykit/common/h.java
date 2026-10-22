package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.Artist;
import com.obric.capabilitykit.entity.app.Cover;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.Preview;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f32055a = null;

    static {
        f32055a = new h();
    }

    private h() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r3) {
        d.h.b.o.e(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, MusicEntity.class) == false) goto L16;
        MusicEntity r2 = (MusicEntity) ZeusTransformUtils.preCheckCast(r3, MusicEntity.class, "com.obric.aiagent.plugin");
        int r4 = r2.getName().hashCode() + 0;
        List<Artist> r0 = r2.getArtists();
        if (r0 == null) goto L7;
        r4 = (r4 * 31) + r0.hashCode();
    L7:
        Cover r1 = r2.getCover();
        if (r1 == null) goto L10;
        r4 = (r4 * 31) + r1.hashCode();
    L10:
        Preview r5 = r2.getPreview();
        if (r5 == null) goto L14;
        r4 = (r4 * 31) + r5.hashCode();
    L14:
        return (r4 * 31) + Long.hashCode(r2.getDuration());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    }
}
