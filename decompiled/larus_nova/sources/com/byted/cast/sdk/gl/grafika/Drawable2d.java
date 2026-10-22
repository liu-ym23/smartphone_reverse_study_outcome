package com.byted.cast.sdk.gl.grafika;

import java.nio.FloatBuffer;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public class Drawable2d {
    private static final FloatBuffer FULL_RECTANGLE_BUF = null;
    private static final float[] FULL_RECTANGLE_COORDS = null;
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = null;
    private static final float[] FULL_RECTANGLE_TEX_COORDS = null;
    private static final FloatBuffer RECTANGLE_BUF = null;
    private static final float[] RECTANGLE_COORDS = null;
    private static final FloatBuffer RECTANGLE_TEX_BUF = null;
    private static final float[] RECTANGLE_TEX_COORDS = null;
    private static final int SIZEOF_FLOAT = 4;
    private static final FloatBuffer TRIANGLE_BUF = null;
    private static final float[] TRIANGLE_COORDS = null;
    private static final FloatBuffer TRIANGLE_TEX_BUF = null;
    private static final float[] TRIANGLE_TEX_COORDS = null;
    private int mCoordsPerVertex;
    private Prefab mPrefab;
    private FloatBuffer mTexCoordArray;
    private int mTexCoordStride;
    private FloatBuffer mVertexArray;
    private int mVertexCount;
    private int mVertexStride;

    /* JADX INFO: renamed from: com.byted.cast.sdk.gl.grafika.Drawable2d$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$sdk$gl$grafika$Drawable2d$Prefab = null;

        static {
            int[] r100 = new int[Prefab.values().length];
            $SwitchMap$com$byted$cast$sdk$gl$grafika$Drawable2d$Prefab = r100;
            r100[Prefab.TRIANGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$byted$cast$sdk$gl$grafika$Drawable2d$Prefab[Prefab.RECTANGLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$byted$cast$sdk$gl$grafika$Drawable2d$Prefab[Prefab.FULL_RECTANGLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum Prefab extends Enum<Prefab> {
        private static final /* synthetic */ Prefab[] $VALUES = null;
        public static final Prefab FULL_RECTANGLE = null;
        public static final Prefab RECTANGLE = null;
        public static final Prefab TRIANGLE = null;

        static {
            Prefab r100 = new Prefab("TRIANGLE", 0);
            TRIANGLE = r100;
            Prefab r101 = new Prefab("RECTANGLE", 1);
            RECTANGLE = r101;
            Prefab r102 = new Prefab("FULL_RECTANGLE", 2);
            FULL_RECTANGLE = r102;
            $VALUES = new Prefab[]{r100, r101, r102};
        }

        public static Prefab[] values() {
            return (Prefab[]) $VALUES.clone();
        }

        public static Prefab valueOf(String r100) {
            return (Prefab) a.a(Prefab.class, r100);
        }

        private Prefab(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        float[] r100 = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = r100;
        float[] r101 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TRIANGLE_TEX_COORDS = r101;
        TRIANGLE_BUF = GlUtil.createFloatBuffer(r100);
        TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(r101);
        float[] r102 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = r102;
        float[] r103 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        RECTANGLE_TEX_COORDS = r103;
        RECTANGLE_BUF = GlUtil.createFloatBuffer(r102);
        RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(r103);
        float[] r104 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = r104;
        float[] r105 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_TEX_COORDS = r105;
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(r104);
        FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(r105);
    }

    public String toString() {
        if (this.mPrefab != null) goto L5;
        return "[Drawable2d: ...]";
    L5:
        return "[Drawable2d: " + this.mPrefab + "]";
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public Drawable2d(Prefab r100) {
        int r101 = AnonymousClass1.$SwitchMap$com$byted$cast$sdk$gl$grafika$Drawable2d$Prefab[r100.ordinal()];
        if (r101 == 1) goto L11;
        if (r101 != 2) goto L6;
        this.mVertexArray = RECTANGLE_BUF;
        this.mTexCoordArray = RECTANGLE_TEX_BUF;
        this.mCoordsPerVertex = 2;
        this.mVertexStride = 2 * 4;
        this.mVertexCount = RECTANGLE_COORDS.length / 2;
    L12:
        this.mTexCoordStride = 8;
        this.mPrefab = r100;
        return;
    L6:
        if (r101 != 3) goto L9;
        this.mVertexArray = FULL_RECTANGLE_BUF;
        this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
        this.mCoordsPerVertex = 2;
        this.mVertexStride = 2 * 4;
        this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
        goto L12
    L9:
        throw new RuntimeException("Unknown shape " + r100);
    L11:
        this.mVertexArray = TRIANGLE_BUF;
        this.mTexCoordArray = TRIANGLE_TEX_BUF;
        this.mCoordsPerVertex = 2;
        this.mVertexStride = 2 * 4;
        this.mVertexCount = TRIANGLE_COORDS.length / 2;
        goto L12
    }
}
