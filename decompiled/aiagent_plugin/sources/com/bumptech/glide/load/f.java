package com.bumptech.glide.load;

import com.bumptech.glide.load.resource.bitmap.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    private interface a {
        int a(ImageHeaderParser r1);
    }

    /* JADX INFO: compiled from: ImageHeaderParserUtils.java */
    private interface b {
        ImageHeaderParser.ImageType getType(ImageHeaderParser r1);
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r2, final InputStream r3, com.bumptech.glide.load.engine.a.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L7:
        if (r3.markSupported() == true) goto L9;
        r3 = new w(r3, r6);
    L9:
        r3.mark(5242880);
        return a(r5, new AnonymousClass1(r3));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r2, final ByteBuffer r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return ImageHeaderParser.ImageType.UNKNOWN;
    L7:
        return a(r4, new AnonymousClass2(r3));
    }

    public static ImageHeaderParser.ImageType getType(List<ImageHeaderParser> r2, final com.bumptech.glide.load.a.m r3, com.bumptech.glide.load.engine.a.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        final com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        return a(r5, new AnonymousClass3(r3, r6));
    }

    private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> r5, b r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        int r0 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        ImageHeaderParser.ImageType r3 = r8.getType((ImageHeaderParser) ZeusTransformUtils.preCheckCast(r7.get(r2), ImageHeaderParser.class, "com.obric.aiagent.plugin"));
        if (r3 != ImageHeaderParser.ImageType.UNKNOWN) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static int a(List<ImageHeaderParser> r2, final InputStream r3, com.bumptech.glide.load.engine.a.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        final com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return -1;
    L7:
        if (r3.markSupported() == true) goto L9;
        r3 = new w(r3, r6);
    L9:
        r3.mark(5242880);
        return a(r5, new AnonymousClass4(r3, r6));
    }

    public static int a(List<ImageHeaderParser> r2, final com.bumptech.glide.load.a.m r3, com.bumptech.glide.load.engine.a.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        final com.bumptech.glide.load.engine.a.b r6 = (com.bumptech.glide.load.engine.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.a.b.class, "com.obric.aiagent.plugin");
        return a(r5, new AnonymousClass5(r3, r6));
    }

    private static int a(List<ImageHeaderParser> r6, a r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
        int r0 = r8.size();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L9;
        int r4 = r9.a((ImageHeaderParser) ZeusTransformUtils.preCheckCast(r8.get(r2), ImageHeaderParser.class, "com.obric.aiagent.plugin"));
        if (r4 != (-1)) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return r4;
    L9:
        return -1;
    }
}
