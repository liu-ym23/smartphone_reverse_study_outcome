package com.byted.mgl.merge.service.api.privacy.media;

import android.media.MediaRecorder;

/* JADX INFO: loaded from: classes43.dex */
public interface IPrivacyMedia {
    void release(MediaRecorder r100, String r101) throws IllegalAccessException;

    void start(MediaRecorder r100, String r101) throws IllegalAccessException;

    void stop(MediaRecorder r100, String r101) throws IllegalAccessException;
}
