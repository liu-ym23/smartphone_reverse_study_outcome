package com.android.contacts.calllog.record;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioFocusManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/calllog/record/AudioFocusManager;", "", "context", "Landroid/content/Context;", "listener", "Lcom/android/contacts/calllog/record/AudioFocusChangeListener;", "(Landroid/content/Context;Lcom/android/contacts/calllog/record/AudioFocusChangeListener;)V", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "Lkotlin/Lazy;", "hasAudioFocus", "", "getAudioFocusRequest", "handleAudioFocusChange", "", "focusChange", "", "releaseAudioFocus", "requestAudioFocus", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AudioFocusManager {
    private AudioFocusRequest audioFocusRequest;
    private final Lazy audioManager$delegate;
    private final Context context;
    private boolean hasAudioFocus;
    private final AudioFocusChangeListener listener;

    public static /* synthetic */ void $r8$lambda$iPS_pguTQeyHdMgeyiewyRIyKck(AudioFocusManager r0, int r1) {
        getAudioFocusRequest$lambda$2$lambda$1(r0, r1);
    }

    public AudioFocusManager(Context r2, AudioFocusChangeListener r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.context = r2;
        this.listener = r3;
        this.audioManager$delegate = LazyKt.lazy(new AudioFocusManager$audioManager$2(this));
    }

    public static final /* synthetic */ Context access$getContext$p(AudioFocusManager r0) {
        return r0.context;
    }

    private final AudioManager getAudioManager() {
        return (AudioManager) this.audioManager$delegate.getValue();
    }

    public final boolean hasAudioFocus() {
        return this.hasAudioFocus;
    }

    public final boolean requestAudioFocus() {
        AudioManager r0 = getAudioManager();
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.requestAudioFocus(getAudioFocusRequest());
    L7:
        if (r2 != 1) goto L9;
        r1 = true;
    L9:
        this.hasAudioFocus = r1;
        return r1;
    L5:
        r2 = 0;
        goto L7
    }

    public final boolean releaseAudioFocus() {
        AudioManager r0 = getAudioManager();
        if (r0 == null) goto L5;
        int r1 = r0.abandonAudioFocusRequest(getAudioFocusRequest());
    L6:
        boolean r2 = true;
        if (r1 == 1) goto L10;
        r2 = false;
    L10:
        if (r2 == false) goto L12;
        this.hasAudioFocus = false;
    L12:
        return r2;
    L5:
        r1 = 0;
        goto L6
    }

    private final AudioFocusRequest getAudioFocusRequest() {
        AudioFocusRequest r0 = this.audioFocusRequest;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0;
    L6:
        AudioFocusRequest.Builder r1 = new AudioFocusRequest.Builder(2);
        AudioAttributes.Builder r2 = new AudioAttributes.Builder();
        r2.setUsage(2);
        r2.setContentType(1);
        AudioFocusRequest r3 = r1.setAudioAttributes(r2.build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(new AudioFocusManager$$ExternalSyntheticLambda0(this)).build();
        this.audioFocusRequest = r3;
        Intrinsics.checkNotNullExpressionValue(r3, "focusRequest");
        return r3;
    }

    private static final void getAudioFocusRequest$lambda$2$lambda$1(AudioFocusManager r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.handleAudioFocusChange(r2);
    }

    private final void handleAudioFocusChange(int r3) {
        if (r3 != (-3)) goto L5;
        this.hasAudioFocus = true;
        this.listener.onAudioFocusLossCanDuck();
        return;
    L5:
        if (r3 != (-2)) goto L7;
        this.hasAudioFocus = true;
        this.listener.onAudioFocusTransientLost();
        return;
    L7:
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L10;
    L14:
        this.hasAudioFocus = true;
        this.listener.onAudioFocusGained();
        return;
    L10:
        if (r3 == 2) goto L14;
        if (r3 == 4) goto L14;
        return;
    L15:
        this.hasAudioFocus = false;
        this.listener.onAudioFocusLost();
    }
}
