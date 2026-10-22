package com.lynx.markdown;

import android.graphics.RectF;
import com.ttreader.tttext.lite.TTTextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class MarkdownParser {
    private byte[] mDrawBuffer;
    private final long mInstance;
    private b mLoader;
    private com.lynx.markdown.a.e mResourceManager;
    private f mShadowNode;

    public static native void initial();

    private native long nativeCreateInstance();

    private native void nativeDestroyInstance(long r1);

    private native byte[] nativeDraw(long r1);

    private native byte[] nativeDrawWithCursor(long r1, int r3, boolean r4);

    private native int nativeGetCharPosByPoint(long r1, float r3, float r4);

    private native String nativeGetContentByCharRange(long r1, int r3, int r4);

    private native float[] nativeGetCursorPosition(long r1, int r3, boolean r4);

    private native float[] nativeGetInlineViewOrigin(long r1, String r3);

    private native String[] nativeGetLinkByPosition(long r1, float r3, float r4);

    private native float[] nativeGetLinkRects(long r1);

    private native String[] nativeGetLinks(long r1);

    private native int nativeGetMaxTypewriterStep(long r1);

    private native int nativeGetPageCharCount(long r1);

    private native float[] nativeGetSelectionRectByCharPos(long r1, long r3, long r5);

    private native float[] nativeLayout(long r1, float r3, float r4, int r5);

    private native void nativeParse(long r1, String r3, int r4, int r5, float r6);

    private native void nativeSetStyle(long r1, byte[] r3);

    private native int nativeTypewriterStepToChar(long r1, int r3);

    public int loadFont(String r1) {
        return 0;
    }

    public MarkdownParser(b r3, f r4) {
        this.mLoader = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.mInstance = nativeCreateInstance();
        this.mResourceManager = new com.lynx.markdown.a.e();
        this.mShadowNode = r4;
    }

    public void finalize() {
        super.finalize();
        nativeDestroyInstance(this.mInstance);
    }

    public void draw(com.lynx.markdown.a.d r2) {
        monitor-enter(this);
        byte[] r0 = this.mDrawBuffer;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        r2.a(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void drawWithCursor(com.lynx.markdown.a.d r3, int r4, boolean r5) {
        r3.a(nativeDrawWithCursor(this.mInstance, r4, r5));
    }

    public float[] findCursorPosition(int r3, boolean r4) {
        float[] r2 = nativeGetCursorPosition(this.mInstance, r3, r4);
        r2[0] = TTTextUtils.Dp2Px(r2[0]);
        r2[1] = TTTextUtils.Dp2Px(r2[1]);
        r2[3] = TTTextUtils.Dp2Px(r2[3]);
        return r2;
    }

    public int getMaxTypewriterStep() {
        return nativeGetMaxTypewriterStep(this.mInstance);
    }

    public void parseMarkdown(String r8, int r9, int r10, float r11) {
        nativeParse(this.mInstance, r8, r9, r10, TTTextUtils.Px2Dp(r11));
    }

    public float[] layoutMarkdown(float r7, float r8, int r9) {
        float[] r10 = nativeLayout(this.mInstance, TTTextUtils.Px2Dp(r7), TTTextUtils.Px2Dp(r8), r9);
        monitor-enter(this);
        this.mDrawBuffer = nativeDraw(this.mInstance);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        r10[0] = TTTextUtils.Dp2Px(r10[0]);
        r10[1] = TTTextUtils.Dp2Px(r10[1]);
        return r10;
    L8:
        th = move-exception;
        throw th;
    }

    public int loadImage(String r7, float r8, float r9, float r10, float r11) {
        d r12 = this.mLoader.a(r7, TTTextUtils.Dp2Px(r8), TTTextUtils.Dp2Px(r9), TTTextUtils.Dp2Px(r10), TTTextUtils.Dp2Px(r11));
        return this.mResourceManager.a(r12);
    }

    public int measureInlineView(String r2, float r3, float r4) {
        e r5 = this.mLoader.a(r2, TTTextUtils.Dp2Px(r3), TTTextUtils.Dp2Px(r4));
        return this.mResourceManager.a(r5);
    }

    public int generateBackground(String r2, float r3, float r4, float r5) {
        c r6 = this.mLoader.a(r2, TTTextUtils.Dp2Px(r3), TTTextUtils.Dp2Px(r4), TTTextUtils.Dp2Px(r5));
        return this.mResourceManager.a(r6);
    }

    public void onTextOverflow(String r1) {
        f r0 = this.mShadowNode;
        r0.a(r0, r1);
    }

    public String[] getLinkByTouchPosition(float r3, float r4) {
        return nativeGetLinkByPosition(this.mInstance, TTTextUtils.Px2Dp(r3), TTTextUtils.Px2Dp(r4));
    }

    public String getContentByCharRange(int r3, int r4) {
        return nativeGetContentByCharRange(this.mInstance, r3, r4);
    }

    public float[] getRunDelegateSize(int r3) {
        com.lynx.markdown.a.c r2 = this.mResourceManager.a(r3);
        float[] r4 = {0.0f, 0.0f, 0.0f};
        if (r2 != null) goto L5;
        return r4;
    L5:
        r4[0] = TTTextUtils.Px2Dp(r2.a());
        r4[1] = TTTextUtils.Px2Dp(r2.c());
        r4[2] = TTTextUtils.Px2Dp(r2.b());
        return r4;
    }

    public com.lynx.markdown.a.e getResourceManager() {
        return this.mResourceManager;
    }

    public void setStyle(HashMap r4) {
        j r0 = new j(this.mResourceManager, this.mLoader);
        nativeSetStyle(this.mInstance, r0.a(r4));
    }

    public float[] getInlineViewOrigin(String r4) {
        float[] r3 = nativeGetInlineViewOrigin(this.mInstance, r4);
        if (Float.compare(r3[0], -1.0f) == 0) goto L5;
    L8:
        r3[0] = TTTextUtils.Dp2Px(r3[0]);
        r3[1] = TTTextUtils.Dp2Px(r3[1]);
        return r3;
    L5:
        if (Float.compare(r3[1], -1.0f) != 0) goto L8;
        return null;
    }

    public ArrayList<RectF> getSelectionRectByCharPos(long r8, long r10) {
        float[] r7 = nativeGetSelectionRectByCharPos(this.mInstance, r8, r10);
        int r9 = 0;
        if (r7 != null) goto L5;
        int r11 = 0;
    L6:
        ArrayList<RectF> r12 = new ArrayList(r11);
    L7:
        if (r9 >= r11) goto L9;
        int r13 = r9 * 4;
        r12.add(new RectF(TTTextUtils.Dp2Px(r7[r13]), TTTextUtils.Dp2Px(r7[r13 + 1]), TTTextUtils.Dp2Px(r7[r13 + 2]), TTTextUtils.Dp2Px(r7[r13 + 3])));
        r9 = r9 + 1;
        goto L7
    L9:
        return r12;
    L5:
        r11 = r7.length / 4;
        goto L6
    }

    public int getCharPosByPoint(float r3, float r4) {
        return nativeGetCharPosByPoint(this.mInstance, TTTextUtils.Px2Dp(r3), TTTextUtils.Px2Dp(r4));
    }

    public int getPageCharCount() {
        return nativeGetPageCharCount(this.mInstance);
    }

    public int typewriterStepToChar(int r3) {
        return nativeTypewriterStepToChar(this.mInstance, r3);
    }

    public ArrayList<g> getLinks() {
        ArrayList<g> r0 = new ArrayList();
        String[] r1 = nativeGetLinks(this.mInstance);
        float[] r10 = nativeGetLinkRects(this.mInstance);
        if (r1 == null) goto L12;
        if (r10 == null) goto L12;
        int r2 = r10.length / 4;
        if (r1.length == (r2 * 2)) goto L9;
        return r0;
    L9:
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L12;
        int r4 = r3 * 4;
        int r5 = r3 * 2;
        g r6 = new g();
        r6.f13898c = r3;
        r6.f13896a = r1[r5];
        r6.f13897b = r1[r5 + 1];
        r6.f13899d = new RectF(TTTextUtils.Dp2Px(r10[r4]), TTTextUtils.Dp2Px(r10[r4 + 1]), TTTextUtils.Dp2Px(r10[r4 + 2]), TTTextUtils.Dp2Px(r10[r4 + 3]));
        r0.add(r6);
        r3 = r3 + 1;
    L12:
        return r0;
    }
}
