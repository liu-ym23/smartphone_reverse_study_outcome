package com.stepos.activeview.task;

import android.os.AsyncTask;
import com.stepos.activeview.elements.TextureVideoView;
import com.stepos.activeview.utils.LogUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ReleaseVideoTask extends AsyncTask<Void, Integer, Long> {
    private static final String LOG_TAG = "ReleaseVideoTask";
    private WeakReference<TextureVideoView> mTextureVideoView;

    public ReleaseVideoTask(TextureVideoView textureVideoView) {
        if (textureVideoView != null) {
            this.mTextureVideoView = new WeakReference<>(textureVideoView);
        }
    }

    @Override // android.os.AsyncTask
    public Long doInBackground(Void... voidArr) {
        WeakReference<TextureVideoView> weakReference = this.mTextureVideoView;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        this.mTextureVideoView.get().release(true);
        LogUtil.i("LOG_TAG", "release success in ReleaseVideoTask");
        return null;
    }
}
