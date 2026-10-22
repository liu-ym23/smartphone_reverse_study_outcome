package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes17.dex */
interface ProxyInterface {
    int designAccess(int r100, String r101, Object r102, float[] r103, int r104, float[] r105, int r106);

    float getKeyFramePosition(Object r100, int r101, float r102, float r103);

    Object getKeyframeAtLocation(Object r100, float r101, float r102);

    Boolean getPositionKeyframe(Object r100, Object r101, float r102, float r103, String[] r104, float[] r105);

    long getTransitionTimeMs();

    void setAttributes(int r100, String r101, Object r102, Object r103);

    void setKeyFrame(Object r100, int r101, String r102, Object r103);

    boolean setKeyFramePosition(Object r100, int r101, int r102, float r103, float r104);

    void setToolPosition(float r100);
}
