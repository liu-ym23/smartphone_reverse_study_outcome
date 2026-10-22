package android.support.v4.media.session;

import B0.g;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback extends MediaControllerCompat$Callback$StubCompat {
    public MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(final a aVar) {
        new IMediaControllerCallback.Stub(aVar) { // from class: android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat
            private final WeakReference<a> mCallback;

            {
                this.mCallback = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z4) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat$QueueItem> list) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i4) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i4) throws RemoteException {
                g.y(this.mCallback.get());
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z4) throws RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                g.y(this.mCallback.get());
            }
        };
    }

    @Override // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat, android.support.v4.media.session.IMediaControllerCallback
    public void onExtrasChanged(Bundle bundle) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat, android.support.v4.media.session.IMediaControllerCallback
    public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat, android.support.v4.media.session.IMediaControllerCallback
    public void onQueueChanged(List<MediaSessionCompat$QueueItem> list) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat, android.support.v4.media.session.IMediaControllerCallback
    public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat, android.support.v4.media.session.IMediaControllerCallback
    public void onSessionDestroyed() throws RemoteException {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat, android.support.v4.media.session.IMediaControllerCallback
    public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
        throw new AssertionError();
    }
}
