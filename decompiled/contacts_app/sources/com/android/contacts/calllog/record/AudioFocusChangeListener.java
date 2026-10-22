package com.android.contacts.calllog.record;

import kotlin.Metadata;

/* JADX INFO: compiled from: AudioFocusManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/calllog/record/AudioFocusChangeListener;", "", "onAudioFocusGained", "", "onAudioFocusLossCanDuck", "onAudioFocusLost", "onAudioFocusTransientLost", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AudioFocusChangeListener {
    void onAudioFocusGained();

    void onAudioFocusLossCanDuck();

    void onAudioFocusLost();

    void onAudioFocusTransientLost();
}
