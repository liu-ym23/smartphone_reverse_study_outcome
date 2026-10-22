package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f32061a = null;

    static {
        f32061a = new l();
    }

    private l() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r3) {
        d.h.b.o.e(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, PhotoEntity.class) == false) goto L36;
        PhotoEntity r2 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r3, PhotoEntity.class, "com.obric.aiagent.plugin");
        int r4 = ((((((((((((r2.getName().hashCode() + 0) * 31) + r2.getFile().hashCode()) * 31) + r2.getAssetType().name().hashCode()) * 31) + r2.getInAlbum().hashCode()) * 31) + r2.getResolution().hashCode()) * 31) + Long.hashCode(r2.getFileSize())) * 31) + Boolean.hashCode(r2.isFavorite());
        List<String> r0 = r2.getTags();
        if (r0 == null) goto L7;
        r4 = (r4 * 31) + r0.hashCode();
    L7:
        List<PhotoFaceEntity> r1 = r2.getFaces();
        if (r1 == null) goto L10;
        r4 = (r4 * 31) + r1.hashCode();
    L10:
        MetaLocation r5 = r2.getLocation();
        if (r5 == null) goto L13;
        r4 = (r4 * 31) + r5.hashCode();
    L13:
        String r6 = r2.getCaption();
        if (r6 == null) goto L16;
        r4 = (r4 * 31) + r6.hashCode();
    L16:
        String r7 = r2.getOcr();
        if (r7 == null) goto L19;
        r4 = (r4 * 31) + r7.hashCode();
    L19:
        String r8 = r2.getSourcePackageName();
        if (r8 == null) goto L22;
        r4 = (r4 * 31) + r8.hashCode();
    L22:
        String r9 = r2.getSourceAppName();
        if (r9 == null) goto L25;
        r4 = (r4 * 31) + r9.hashCode();
    L25:
        String r10 = r2.getSourceDevice();
        if (r10 == null) goto L28;
        r4 = (r4 * 31) + r10.hashCode();
    L28:
        List<VideoFrame> r11 = r2.getVideoFrames();
        if (r11 == null) goto L31;
        r4 = (r4 * 31) + r11.hashCode();
    L31:
        List<VideoFrame> r12 = r2.getSearchFrames();
        if (r12 != null) goto L34;
        return r4;
    L34:
        return (r4 * 31) + r12.hashCode();
    L36:
        throw new IllegalStateException("Check failed.".toString());
    }
}
