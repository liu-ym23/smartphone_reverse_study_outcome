package androidx.constraintlayout.core.state;

/* JADX INFO: loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int r10, int r11);

    void onNewMotionScene(String r10);

    void onProgress(float r10);

    void setDrawDebug(int r10);

    void setLayoutInformationMode(int r10);
}
