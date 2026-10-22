package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f0 f11275a = null;

    static {
        f11275a = new f0();
    }

    private f0() {
    }

    @Override // com.obric.capabilitykit.common.b0
    public int a(@NotNull AppEntity r10) {
        kotlin.jvm.internal.q.g(r10, "instance");
        if ((r10 instanceof PhotoEntity) == false) goto L33;
        PhotoEntity r11 = (PhotoEntity) r10;
        int r12 = (((((((((((r11.getName().hashCode() * 31) + r11.getFile().hashCode()) * 31) + r11.getAssetType().name().hashCode()) * 31) + r11.getInAlbum().hashCode()) * 31) + r11.getResolution().hashCode()) * 31) + Long.hashCode(r11.getFileSize())) * 31) + Boolean.hashCode(r11.isFavorite());
        List<String> r13 = r11.getTags();
        if (r13 == null) goto L7;
        r12 = (r12 * 31) + r13.hashCode();
    L7:
        List<PhotoFaceEntity> r14 = r11.getFaces();
        if (r14 == null) goto L10;
        r12 = (r12 * 31) + r14.hashCode();
    L10:
        MetaLocation r15 = r11.getLocation();
        if (r15 == null) goto L13;
        r12 = (r12 * 31) + r15.hashCode();
    L13:
        String r16 = r11.getCaption();
        if (r16 == null) goto L16;
        r12 = (r12 * 31) + r16.hashCode();
    L16:
        String r17 = r11.getOcr();
        if (r17 == null) goto L19;
        r12 = (r12 * 31) + r17.hashCode();
    L19:
        String r18 = r11.getSourcePackageName();
        if (r18 == null) goto L22;
        r12 = (r12 * 31) + r18.hashCode();
    L22:
        String r19 = r11.getSourceAppName();
        if (r19 == null) goto L25;
        r12 = (r12 * 31) + r19.hashCode();
    L25:
        List<VideoFrame> r20 = r11.getVideoFrames();
        if (r20 == null) goto L28;
        r12 = (r12 * 31) + r20.hashCode();
    L28:
        List<VideoFrame> r21 = r11.getSearchFrames();
        if (r21 != null) goto L31;
        return r12;
    L31:
        return (r12 * 31) + r21.hashCode();
    L33:
        throw new IllegalStateException("Check failed.");
    }
}
